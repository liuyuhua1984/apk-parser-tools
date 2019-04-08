package com.lyh.apk.manager;

import com.lyh.apk.ApkFile;
import com.lyh.apk.model.AgentUser;
import com.lyh.apk.properties.ServerGameConfig;
import com.lyh.apk.res.ResPath;
import com.lyh.apk.res.UserDir;
import com.lyh.apk.service.AgentUserService;
import com.lyh.apk.shutdown.ShutDownThread;
import com.lyh.apk.stop.Stopable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 代理管理者
 *
 * @author: root
 * @create: 2018-12-15 10:42
 **/
@Component
public class AgentUserManager implements Stopable {



    public static ScheduledExecutorService threadPool = new ScheduledThreadPoolExecutor(1);

    public static ExecutorService executorPool =  new ThreadPoolExecutor(0, 20,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());
    private static Logger logger = LoggerFactory.getLogger(AgentUserManager.class);


    @Autowired
    private AgentUserService agentUserService;
    public AgentUserManager(){
        ShutDownThread.registerCloseableToShutDown(this);
    }

    public void task(final String inputPath,final String outputPath,final  Integer allPackage,final int keyStoreFlag){

        if (allPackage == 1) {
            List<AgentUser> list = agentUserService.findAllAgentByLevel(2);
            doCmd(inputPath,outputPath,keyStoreFlag,list);
        }

        threadPool.scheduleAtFixedRate(new Runnable() {


            @Override
            public void run() {

                List<AgentUser> list = agentUserService.findByLevelAndCreatePackage(2, 0);
                doCmd(inputPath,outputPath,keyStoreFlag,list);

            }

        },2,1, TimeUnit.MINUTES);
    }

    @Override
    public void stop() {
        threadPool.shutdown();
        executorPool.shutdown();
    }

    public void doCmd(final String inputPath,final String outputPath,final int keyStoreFlag,List<AgentUser> list){

        if (list != null && list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                final AgentUser user = list.get(i);

                executorPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String outPutApk = outputPath + File.separator + user.getId() +".apk";
                            ApkFile.addStrToApk(inputPath,
                                    outPutApk,
                                    "0," + user.getId() + ",0",
                                    "assets/res/raw-assets/resources/mainUI/var/config.txt",keyStoreFlag);
                            logger.error("代理打包已完成::{}",user.getId());
                            //android重签名
                            if (keyStoreFlag == 1) {
                                ApkFile.signApk(ResPath.RES + ServerGameConfig.ANDROID_KEYSTORE_NAME, ServerGameConfig.ANDROID_KEY_ALIAS, ServerGameConfig.ANDROID_PASSWORD,
                                        outPutApk, outPutApk, false);
                                logger.error("签名已完成:" + outputPath + File.separator + user.getId() + ".apk" + "::{}", user.getId());
                            }
                            user.setCreatePackageFlag(1);
                            agentUserService.updateByCreatePackageFlag(user);
                            logger.error("代理打包更新数据库已完成::{}",user.getId());
                        }catch (Exception e){
                            e.printStackTrace();
                            logger.error("代理打包出错了::",e);
                        }
                    }
                });


            }
        }
    }
}
