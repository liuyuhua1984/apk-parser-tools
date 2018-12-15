package com.lyh.apk.shutdown;


import com.lyh.apk.stop.Stopable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName:ShutThread <br/>
 * Function: TODO (退出线程). <br/>
 * Reason: TODO (). <br/>
 * Date: 2015-7-17 下午4:46:09 <br/>
 *
 * @author lyh
 * @see
 */

public class ShutDownThread extends Thread {
    private static CopyOnWriteArrayList<Stopable> shutDownLists = new CopyOnWriteArrayList<Stopable>();
    private static Logger logger = LoggerFactory.getLogger(ShutDownThread.class);

    public ShutDownThread() {
        super("ExitThread");


    }

    @Override
    public void run() {


        for (Stopable ca : shutDownLists) {
            // 关闭
            try {
                ca.stop();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("正常关闭有错误::",e);
            }
        }

      //  threadPool

    }

    /**
     * registerCloseable:(). <br/>
     * TODO().<br/>
     *
     * @param ca
     * @author lyh
     */
    public static void registerCloseableToShutDown(Stopable ca) {
        if (!shutDownLists.contains(ca)) {
            shutDownLists.add(ca);
        }

    }
}
