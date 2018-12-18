package com.lyh.apk.properties;


/**
 * ClassName:ConfigFactory <br/>
 * Function: TODO (文件配置管理 类). <br/>
 * Reason: TODO (). <br/>
 * Date: 2015-7-6 下午2:24:39 <br/>
 *
 * @author lyh
 * @see
 */
public class ConfigFactory {
    public static void init(String curPath) {
        // TODO Auto-generated method stub
        ServerGameConfig.loadGameConfig(curPath);// 加载游戏.propterties配置
    }

}
