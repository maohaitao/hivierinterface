/**
 * @Title: CommonUtil.java
 * @Package com.pb.common.util
 * @Des: 常用的工具类
 * @author maohaitao
 * @date 2015年4月14日 下午12:09:29
 * @version V1.0
 */
package com.sf.common.util;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

/**
 * @author maohaitao
 * @ClassName: CommonUtil
 * @date 2015年4月14日 下午12:09:29
 */
public class CommonUtil {
    public CommonUtil() {
    }

    public static boolean isNull(String value) {
        return value == null || value.trim().length() == 0 || value.equalsIgnoreCase("null");
    }

    public static boolean isEmpty(Object value) {
        return value == null;
    }

    public static String getLocalIP() {
        String ip = "";

        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();

            while (e.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) e.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();

                while (addresses.hasMoreElements()) {
                    InetAddress addres = (InetAddress) addresses.nextElement();
                    if (addres != null && addres instanceof Inet4Address && !addres.isLoopbackAddress()
                            && addres.isSiteLocalAddress()) {
                        ip = addres.getHostAddress();
                        break;
                    }
                }

                if (ip != null && ip.length() > 5) {
                    break;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return ip;
    }

    public static String getExceptionStackStr(Throwable e) {
        if (e == null) {
            return "";
        } else {
            StringBuilder logStrBuilder = new StringBuilder();
            logStrBuilder.append("stack:");
            StackTraceElement[] traces = e.getStackTrace();

            for (int i = 0; null != traces && i < traces.length; ++i) {
                logStrBuilder.append(traces[i].toString()).append(" ");
            }

            return logStrBuilder.toString();
        }
    }

    public static String splitJointValue(String separator, String... values) {
        StringBuffer resultValue = new StringBuffer();

        for (int i = 0; i < values.length; ++i) {
            if (values[i] != null) {
                resultValue.append(values[i]);
            }

            if (i < values.length - 1) {
                resultValue.append(separator);
            }
        }

        return resultValue.toString();
    }

    public static boolean isNumber(String value) {
        if (isNull(value)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("[0-9]{1,}");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
    }

    public static boolean isDouble(String value) {
        if (isNull(value)) {
            return false;
        } else {
//            Pattern pattern = Pattern.compile("[0-9]{1,}[.]{0,1}[0-9]{0,}]");
            Pattern pattern = Pattern.compile("\\-?\\d+\\.?\\d*");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
    }

    public static boolean isPhone(String value) {
        if (isNull(value)) {
            return false;
        } else {
//            Pattern pattern = Pattern.compile("[0-9]{1,}[.]{0,1}[0-9]{0,}]");
            Pattern pattern = Pattern.compile("((\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
    }

    public static byte[] toByteArray(InputStream in, boolean close) throws Exception {
        byte[] e;
        try {
            e = IOUtils.toByteArray(in);
        } catch (IOException var11) {
            throw var11;
        } finally {
            try {
                if (close) {
                    in.close();
                }
            } catch (IOException var10) {
                ;
            }

        }

        return e;
    }

    public static byte[] gzip(byte[] bs) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(4096);
        GZIPOutputStream gzout = null;

        try {
            gzout = new GZIPOutputStream(bout);
            gzout.write(bs);
            gzout.flush();
        } catch (Exception var7) {
            throw var7;
        } finally {
            gzout.close();
            bout.close();
        }

        return bout.toByteArray();
    }

    public static byte[] ungzip(byte[] bs) throws Exception {
        GZIPInputStream gzin = null;
        ByteArrayInputStream bin = null;

        byte[] e;
        try {
            bin = new ByteArrayInputStream(bs);
            gzin = new GZIPInputStream(bin);
            e = IOUtils.toByteArray(gzin);
        } catch (Exception var7) {
            throw var7;
        } finally {
            gzin.close();
            bin.close();
        }

        return e;
    }

    public static byte[] inflate(byte[] bs, boolean nowrap) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(4096);

        try {
            Inflater e = new Inflater(nowrap);
            e.setInput(bs);
            byte[] buf = new byte[1024];

            while (!e.finished()) {
                int count = e.inflate(buf);
                bout.write(buf, 0, count);
            }
        } catch (Exception var9) {
            throw var9;
        } finally {
            bout.close();
        }

        return bout.toByteArray();
    }

    public static byte[] deflate(byte[] bs, boolean nowrap) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(4096);

        try {
            Deflater e = new Deflater(5, nowrap);
            e.setInput(bs);
            e.finish();
            byte[] buff = new byte[1024];

            while (!e.finished()) {
                int count = e.deflate(buff);
                bout.write(buff, 0, count);
            }
        } catch (Exception var9) {
            throw var9;
        } finally {
            bout.close();
        }
        return bout.toByteArray();
    }

    public static void main(String[] args) {
        System.out.println(CommonUtil.isDouble("020123456728.0000"));
    }
}
