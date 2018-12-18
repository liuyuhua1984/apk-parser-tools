package com.lyh.apk;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;


/**
 * apk文件类
 * todo:解压apk 并添加一个文件到apk
 *assets\res\raw-assets\resources\mainUI/var/config.txt
 * @author: root
 * @create: 2018-12-14 16:36
 **/

public class ApkFile {

    private final static Logger logger = LoggerFactory.getLogger(ApkFile.class);


    /**
     * 往Apk中添加文件
     * @param apkPath
     * @param outputPath
     * @param addFilePath 文件路径
     * @param entryName 希望在apk中显示的路径、名称
     */
    public static void addFileToApk(String apkPath,String outputPath,String addFilePath,String entryName,final int keyStoreFlag){
        try {
            File addFile = new File(addFilePath);
            FileInputStream fileInputStream = new FileInputStream(addFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len =0;
            byte[] buffer = new byte[2048];
            while((len = bufferedInputStream.read(buffer)) != -1){
                bos.write(buffer, 0 ,len);
            }
            bos.flush();

            bufferedInputStream.close();
            fileInputStream.close();

            addByteToApk(apkPath, outputPath, bos.toByteArray(), entryName,keyStoreFlag);
        } catch (IOException e) {
            // TODO: handle exception
        }


    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException{
        byte[] b = new byte[2048];
        int len = 0;
        while((len = inputStream.read(b)) != -1){
            outputStream.write(b, 0, len);
        }
    }
    /**
     * 往Apk中byte[]
     * @param apkPath
     * @param outputPath
     * @param addFileBytes 文件路径
     * @param entryName 希望在apk中显示的路径、名称
     */
    public static  void addByteToApk(String apkPath,String outputPath,byte[] addFileBytes,String entryName,final int keyStoreFlag){
        File file = new File(apkPath);

        File outputFile = new File(outputPath);
        if(!file.exists()){
            System.out.println("not found "+apkPath);
            return;
        }

        if(outputFile.exists()){
            outputFile.delete();
        }
        try {
            ZipArchiveOutputStream zipArchiveOutputStream = new ZipArchiveOutputStream(outputFile);

            ZipFile zipFile = new ZipFile(file);
            Enumeration<ZipArchiveEntry> enumeration = zipFile.getEntries();

            //原样拷贝
            while (enumeration.hasMoreElements()) {
                ZipArchiveEntry zipArchiveEntry =  enumeration.nextElement();
                if(zipArchiveEntry.getName().equals(entryName)){
                    System.out.println("Wranning! found "+entryName+" cover it !");
                    continue;
                }

                //为了要重新签名
                if (keyStoreFlag == 1 && zipArchiveEntry.getName().startsWith("META-INF")){
                    continue;
                }

                //logger.error("名字:"+zipArchiveEntry.getName());
                zipArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
                if(!zipArchiveEntry.isDirectory()){
                    copy(zipFile.getInputStream(zipArchiveEntry), zipArchiveOutputStream);
                }
                zipArchiveOutputStream.closeArchiveEntry();
            }

            //添加文件
            ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(entryName);

            zipArchiveOutputStream.putArchiveEntry(zipArchiveEntry);
            zipArchiveOutputStream.write(addFileBytes);
            zipArchiveOutputStream.closeArchiveEntry();

            zipFile.close();
            zipArchiveOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addStrToApk(String apkPath,String outputPath,String addStr,String entryName,final int keyStoreFlag){
        try {
            addByteToApk(apkPath, outputPath, addStr.getBytes("utf-8"), entryName,keyStoreFlag);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    /**
     * 解压apk
     * @param apkPath
     * @param outPath
     */
    public static void unZipApk(String apkPath,String outPath){
        File file = new File(apkPath);
        if(!file.exists()){
            System.out.println("not found "+apkPath);
            return;
        }
        try {

            File outputDir = new File(outPath);
            outputDir.mkdir();

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            ArchiveInputStream inputStream = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, bufferedInputStream);
            ZipArchiveEntry zipArchiveEntry = null;
            try {
                while((zipArchiveEntry = (ZipArchiveEntry) inputStream.getNextEntry()) != null){

                    if(zipArchiveEntry.isDirectory()){
                        new File(outputDir,zipArchiveEntry.getName()).mkdirs();
                    }else{
                        File tempFile = new File(outputDir,zipArchiveEntry.getName());
                        if(!tempFile.getParentFile().exists()){
                            tempFile.getParentFile().mkdirs();
                        }

                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(tempFile);
                            //IOUtils.copy(inputStream, fos);
                            byte[] b = new byte[2048];
                            int len = 0;
                            while((len = inputStream.read(b)) != -1){
                                fos.write(b, 0, len);
                            }
                            fos.flush();
                        } catch (IOException e) {
                            e.printStackTrace();

                        }finally{
                            if(fos != null){
                                fos.close();
                            }
                        }

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(inputStream != null){
                    inputStream.close();
                }
            }

            System.out.println("unZipApk done !");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    /**
     * 执行命令
     *
     * @param command
     */
    public static void runCommand(String command) {
        logger.error("执行：" + command);
        final Runtime runtime = Runtime.getRuntime();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            Process process = runtime.exec(command);
            inputStream = process.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
               // logger.error("line：" + line);
            }
            int exitValue = process.waitFor();
            System.out.println("Process Exit Value : " + exitValue);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 签名APK
     * @param keystoreFilePath 签名文件路径
     * @param keystoreTag 签名文件别名
     * @param keystorePassword 签名文件密码
     * @param sourceFilePath 源文件，对应未签名的文件
     * @param targetFilePath 目标文件，对应签名后最终的文件
     * @param deleteSourceFile 是否删除源文件
     *                         apksigner sign                 //执行签名操作
     * --ks 你的jks路径               //jks签名证书路径
     * --ks-key-alias 你的alias          //生成jks时指定的alias
     * --ks-pass pass:你的密码           //KeyStore密码
     * --key-pass pass:你的密码          //签署者的密码，即生成jks时指定alias对应的密码
     * --out output.apk               //输出路径
     * input.apk                   //需要签名的APK
     * apksigner sign –ks aoaoyi.jks –ks-key-alias aoaoyi –ks-pass pass:aoaoyi.com –key-pass pass:aoaoyi.com –out output.apk input.apk签名示例：
     *
     * jarsigner:jdk自带工具，用于生成带签名的apk
     *
     * -verbose 具体描述
     *
     * myKey.jks 我的签名证书，用于给unsign.apk签名
     *
     * -signedjar signed.apk 签名生成后的apk名称
     *
     * unsign.apk 未签名的apk
     *
     * myKeyAlias 我的证书myKey.jks的别名
     *  -digestalg SHA1 -sigalg MD5withRSA
     * ---------------------
     */
    public static void signApk(final String keystoreFilePath, String keystoreTag, String keystorePassword, String sourceFilePath, String targetFilePath, boolean deleteSourceFile) {
        System.out.println("正在准备签名APK：" + sourceFilePath + "," + targetFilePath);
        runCommand(String.format("jarsigner -verbose -keystore %s -signedjar %s %s %s -storepass %s", keystoreFilePath, targetFilePath, sourceFilePath, keystoreTag, keystorePassword));
        final File targetFile = new File(targetFilePath);
        if (deleteSourceFile && targetFile.exists()) {
            new File(sourceFilePath).delete();
        }
    }


    //ApkUtils apkUtils = new ApkUtils();
    ////apkUtils.unZipApk("d:\\Administrator\\Desktop\\ApkIDE_ApkIDE_Apk.apk", "d:\\Administrator\\Desktop\\ApkIDE_ApkIDE_Apk");
	//	apkUtils.addStrToApk("d:\\Administrator\\Desktop\\ApkIDE_ApkIDE_Apk.apk",
    //            "d:\\Administrator\\Desktop\\new.apk",
    //            "d:\\Administrator\\Desktop\\DEV信息APP版本-cyl(4).doc",
    //            "DEV信息APP版本-cyl(4).txt");



}
