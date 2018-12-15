package com.lyh.apk;


import com.lyh.apk.beanfactory.SpringBeanFactory;
import com.lyh.apk.manager.AgentUserManager;
import com.lyh.apk.start.Start;

/**
 * APK解析工具主类
 *
 */
public class App extends Start
{

    /**带后辍apk**/
    private static String inputPathName;

    /**输出目录**/
    private static String outputPathName;

    private static Integer allPackage = 0;
    public static void main( String[] args )
    {

        //ApkFile apkFile = new ApkFilecurPath+"/app.apk");

        if (args.length > 2){
            inputPathName = args[2];
        }

        if (args.length > 3){
            outputPathName = args[3];
        }

        if (args.length > 4){
            allPackage = Integer.parseInt(args[4]);
        }
        App app = new App();
        app.start(args);





        
    }

    @Override
    public void initialize() {
        AgentUserManager agentUserManager = SpringBeanFactory.getSpringBean(AgentUserManager.class);
        agentUserManager.task(inputPathName,outputPathName,allPackage);
    }
}
