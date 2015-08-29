/**
 * @Title: PropertiesLoader.java
 * @Package com.pb.common.util
 * @author maohaitao
 * @date 2015年4月14日 下午2:11:54
 * @version V1.0
 */
package com.sf.common.properties;

import com.sf.common.log.LogService;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author maohaitao
 * @ClassName: PropertiesLoader
 * @date 2015年4月14日 下午2:11:54
 */
public class PropertiesLoader {

    public PropertiesLoader() {
    }

    public static Properties loadProperties(String dirORfile) {
        Properties props = new Properties();

        try {
            URL e = PropertiesLoader.class.getClassLoader().getResource(dirORfile);
            File file = new File(e.getPath());
            if (file.isDirectory()) {
                File[] in = file.listFiles();

                for (int e1 = 0; e1 < in.length; ++e1) {
                    File f = in[e1];
                    FileInputStream in1 = null;

                    try {
                        in1 = new FileInputStream(f);
                        props.load(in1);
                    } catch (Exception var37) {
                        LogService.error(String.format("loadProperties：%sfaild!", new Object[]{file.getAbsolutePath()}),
                                var37);
                    } finally {
                        try {
                            in1.close();
                        } catch (Exception var34) {
                            LogService.error(String.format("close file:%s faild!", new Object[]{file.getAbsolutePath()}),
                                    var34);
                        }

                    }
                }
            } else if (file.isFile()) {
                FileInputStream var40 = null;

                try {
                    var40 = new FileInputStream(file);
                    props.load(var40);
                } catch (Exception var35) {
                    LogService.error(String.format("loadProperties：%sfaild!", new Object[]{file.getAbsolutePath()}), var35);
                } finally {
                    try {
                        var40.close();
                    } catch (Exception var33) {
                        LogService.error(String.format("关闭配置文件：%s输入流faild!", new Object[]{file.getAbsolutePath()}), var33);
                    }

                }
            }
        } catch (Exception var39) {
            LogService.error("PropertiesLoader.loadProperties() faild!dirORfile:" + dirORfile, var39);
        }

        return props;
    }
}
