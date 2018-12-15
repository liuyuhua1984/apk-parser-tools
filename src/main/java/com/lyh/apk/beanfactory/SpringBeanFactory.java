package com.lyh.apk.beanfactory;


import com.lyh.apk.res.ResPath;
import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * 框架属性文件配置工厂,ResourceBundle 读取.properties的类
 *
 * @author lyh
 */
public class SpringBeanFactory {

  //  public static FileSystemXmlApplicationContext factory;
    public static  ApplicationContext factory;
    public static ApplicationContext springStart() {
        // game.properties的键值映射
        String xmlPath = ResPath.RES + "beans.xml";
        // ClassPathResource res= new ClassPathResource(xmlPath);
        //factory = new ClassPathXmlApplicationContext(xmlPath);
        factory = new FileSystemXmlApplicationContext(xmlPath);

        return factory;
    }

    // /**
    // * 注册.properties配置文件
    // *
    // * @param bundleName 不含后缀名的文件名
    // */
    // public static void regeditRorpery(String bundleName) {
    // if (null != listBundle.get(bundleName))
    // return;
    // initialize();
    // }

    /**
     * 获取.properties配置文件是的配置信息
     *
     * @param bundleName 不含后缀名的文件名
     * @param key 对应健值
     * @return 如果返回"" 没有找到对应的健值
     */
    // public static String getBundleString(String bundleName, String key) {
    // Properties bundle = listBundle.get(bundleName);
    // if (null == bundle)
    // return "";
    // return bundle.getProperty(key);
    // }

    // /**
    // * 获取.properties配置文件是的配置信息
    // *
    // * @param bundleName 不含后缀名的文件名
    // * @param key 对应健值
    // * @param param 参数
    // * @return 如果返回"" 没有找到对应的健值
    // */
    // public static String getBundleString(String bundleName, String key,
    // String[] param) {
    // String bundle = getBundleString(bundleName, key);
    // for (int i = 0; i < param.length; i++) {
    // bundle = bundle.replaceAll("{" + i + "}", param[i]);
    // }
    // return bundle;
    // }

    /**
     * 获得SpingBean
     *
     * @param beanName
     * @return
     * @createDate 2008-9-27 04:36:46
     */
    public static Object getSpringBean(String beanName) {
        return factory.getBean(beanName);
    }

    /**
     * 获得springBean
     *
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T getSpringBean(Class<T> beanClass) {
        return factory.getBean(beanClass);
    }
}
