package com.lyh.apk;

import java.io.File;

/**
 * 主app
 *
 * @author: root
 * @create: 2018-12-15 11:26
 **/

public class MainApp {
    public static void main(String[] args) {

        File f = new File(System.getProperty("user.dir"));
        App.main(new String[]{f.getPath() + File.separator + "", "logs/apkLog", f.getPath() + File.separator + "app.apk", f.getPath() + File.separator});
    }
}
