/**
 * Project Name:DragonBallWorldServerHappy
 * File Name:ServerGameConfig.java
 * Package Name:com.sj.engine.config
 * Date:2014-2-19上午10:56:06
 * Copyright (c) 2014, chenzhou1025@126.com All Rights Reserved.
 */

package com.lyh.apk.properties;


import com.lyh.apk.res.UserDir;

import java.util.Properties;


/**
 * ClassName:ServerGameConfig <br/>
 * Function: TODO (游戏的配置文件). <br/>
 * Reason: TODO (). <br/>
 * Date: 2014-2-19 上午10:56:06 <br/>
 *
 * @author lyh
 * @version
 * @see
 */

public class ServerGameConfig extends ServerProperties {
    private static final String BUNDLE_NAME = UserDir.USER_DIR + "/game.properties";

    /**签名文件名**/
    public static String ANDROID_KEYSTORE_NAME = "android_keystore_name";

    /**签名别名***/
    public static String ANDROID_KEY_ALIAS = "key_alias";

    public static int GM_CMD = 0;

    /** 防沉迷 */
    public static int INDUL = 1;

    /** 关闭屏蔽字1 **/
    public static int SHIELD = 0;
    // 语言包路径
    public static String LANGUAGE_PACK_PATH = "language_pack_path";

    /** 包路径 **/
    public static String PACKAGE = "Package";

    /** 版本号 **/
    public static String VERSION = "version";

    /** txt包路径 **/
    public static String TXT_PACKAGE = "txt_package";

    /** txt包路径 **/
    public static String DB_PACKAGE = "db_package";

    /** 后端与后台协议包路径 **/
    public static String PROTOCOL_PACKAGE = "protocol_package";
    /**是否使用redis**/
    public static boolean REDIS = false;

    /**ANdroid密码**/
    public static String ANDROID_PASSWORD = "android_password";

    /**
     * loadGameConfig:(). <br/>
     * TODO().<br/>
     * 加载配置
     *
     * @author lyh
     */
    public static void loadGameConfig(String path) {
        Properties GAME_BUNDLE = loadGameProperties(path + "/game.properties");

        ANDROID_KEYSTORE_NAME = GAME_BUNDLE.getProperty("android_keystore_name");

        ANDROID_KEY_ALIAS = GAME_BUNDLE.getProperty("key_alias");

        GM_CMD = Integer.parseInt(GAME_BUNDLE.getProperty("GmCmd"));
        SHIELD = Integer.parseInt(GAME_BUNDLE.getProperty("shield"));
        LANGUAGE_PACK_PATH = GAME_BUNDLE.getProperty("language_pack_path");

        PACKAGE = GAME_BUNDLE.getProperty("Package");
        VERSION = GAME_BUNDLE.getProperty("version");
        TXT_PACKAGE = GAME_BUNDLE.getProperty("txt_package");
        DB_PACKAGE = GAME_BUNDLE.getProperty("db_package");
        PROTOCOL_PACKAGE = GAME_BUNDLE.getProperty("protocol_package");
        ANDROID_PASSWORD = GAME_BUNDLE.getProperty("android_password");
        int redis = Integer.parseInt(GAME_BUNDLE.getProperty("redis"));
        REDIS = redis == 1;
    }

}
