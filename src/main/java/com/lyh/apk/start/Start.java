package com.lyh.apk.start;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

import com.lyh.apk.beanfactory.SpringBeanFactory;
import com.lyh.apk.res.ResPath;
import com.lyh.apk.res.UserDir;
import com.lyh.apk.shutdown.ShutDownThread;
import com.lyh.apk.utils.XmlUtils;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

/**
 * ClassName:Start <br/>
 * Function: TODO (游戏入口类). <br/>
 * Reason: TODO (). <br/>
 * Date: 2015-6-30 上午9:19:06 <br/>
 *
 * @author lyh
 * @see
 */
public abstract class Start {

    /**
     * start:(). <br/>
     * TODO().<br/>
     * 游戏开始
     *
     * @param ars
     * @author lyh
     */
    public void start(String ars[]) {
        if (ars.length < 1) {
            return;
        }
        if (ars.length > 1) {
            UserDir.USER_DIR = ars[0];
        }

        // setLog4jPath(ars[2], UserDir.USER_DIR + "/" + "log4j.properties");
        // PropertyConfigurator.configure(UserDir.USER_DIR + "/" + "log4j.properties");
        configLogBack(ars[1]);

        SpringBeanFactory.springStart();
        // ars[0]自己服务的标志
        //ServerInfoManage.curServerInfo = ServerInfoManage.getSConfig(Integer.parseInt(ars[0]));

        initialize();

        // 加挂退出线程
        Runtime.getRuntime().addShutdownHook(new ShutDownThread());
    }


    /**
     * initialize:(). <br/>
     * TODO().<br/>
     * 初始化一些数据
     *
     * @author lyh
     */
    public abstract void initialize();

    /**
     * configLogBack:(). <br/>
     * TODO().<br/>
     * logback
     *
     * @author lyh
     */
    @SuppressWarnings("unchecked")
    private static void configLogBack(String extFolderName) {
        String path = ResPath.RES + "/logback.xml";
        try {
            Document doc = null;
            try {
                doc = XmlUtils.readAsDocument(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Element root = doc.getRootElement();
            List<Element> eles = root.elements("appender");
            for (Element el : eles) {
                Attribute nAttribute = el.attribute("name");
                if (nAttribute != null && nAttribute.getValue() != null) {
                    String name = nAttribute.getValue().trim();
                    if (name.startsWith("FILE")) {
                        Element logPathElement = el.element("rollingPolicy").element("FileNamePattern");
                        if (logPathElement != null) {
                            String logPathName = logPathElement.getTextTrim();
                            // 替换成现有的
                            String logPath = UserDir.USER_DIR + File.separator + extFolderName + File.separator + logPathName;
                            logPathElement.setText(logPath);
                        }
                    }
                }
            }

            InputStream is = new ByteArrayInputStream(doc.asXML().getBytes("utf-8"));
            LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(lc);
            lc.reset();
            configurator.doConfigure(is);

        } catch (JoranException e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * setLog4jPath:(). <br/>
     * TODO().<br/>
     * log4j
     *
     * @param path
     * @param logFile
     * @return
     * @author lyh
     */
    private Properties setLog4jPath(String path, String logFile) {
        Properties p = new Properties();
        try {
            FileInputStream fis = new FileInputStream(logFile);
            try {
                p.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String logPath = p.getProperty("log4j.appender.TRACE.File");
            p.setProperty("log4j.appender.TRACE.File", UserDir.USER_DIR + File.separator + path + File.separator + logPath);
            PropertyConfigurator.configure(p);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }
}
