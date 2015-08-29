package com.sf.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sf.common.log.RsyncLog;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class T {
    private T() {

    }

    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    public static String stringValue(String v, String def) {
        if (v == null || v.length() == 0) {
            return def;
        }

        return v.trim();
    }

    public static String[] stringArrayValue(String[] v, String[] def) {
        if (v == null || v.length == 0) {
            return def;
        }
        return v;
    }

    public static byte byteValue(String v, byte def) {
        if (isBlank(v)) {
            return def;
        }

        try {
            return Byte.parseByte(v);
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static char charValue(String v, char def) {
        if (isBlank(v)) {
            return def;
        }

        try {
            return (char) Integer.parseInt(v);
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static int intValue(String v, int def) {
        if (isBlank(v) || "null".equalsIgnoreCase(v)) {
            return def;
        }

        try {
            return Integer.parseInt(v.trim());
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static Integer integerValue(String v) {
        return integerValue(v, null);
    }

    public static Integer integerValue(String v, int def) {
        if (isBlank(v)) {
            return Integer.valueOf(def);// ref:http://tech.puredanger.com/2007/02/01/valueof/
        }

        try {
            return Integer.valueOf(v);
        } catch (Exception e) {
            RsyncLog.error(e);
            return Integer.valueOf(def);
        }
    }

    public static Integer integerValue(String v, Integer def) {
        if (isBlank(v)) {
            return def;
        }

        try {
            return Integer.valueOf(v);
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static long longValue(String v, long def) {
        if (isBlank(v)) {
            return def;
        }
        try {
            return Long.parseLong(v.trim());
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static float floatValue(String v, float def) {
        if (isBlank(v)) {
            return def;
        }

        try {
            return Float.parseFloat(v.trim());
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static float floatValue(String v, int remain, float def) {
        try {
            BigDecimal bd = new BigDecimal(v);
            bd = bd.setScale(remain, BigDecimal.ROUND_HALF_UP);
            return bd.floatValue();
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static double doubleValue(String v, double def) {
        if (isBlank(v)) {
            return def;
        }

        try {
            return Double.parseDouble(v.trim());
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static Date dateValue(String v, String fm, Date def) {
        if (isBlank(v)) {
            return def;
        }

        try {
            return new SimpleDateFormat(fm).parse(v.trim());
        } catch (Exception e) {
            RsyncLog.error(e);
            return def;
        }
    }

    public static Date dateValue(String v, Date def) {
        return dateValue(v, FORMAT_DATE, def);
    }

    public static Date datetimeValue(String v, Date def) {
        return dateValue(v, FORMAT_DATETIME, def);
    }

    public static Date getNow() {
        return new Date(System.currentTimeMillis());
    }

    public static Date getToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 生成token
    public static String getUUID() {
        String s = UUID.randomUUID().toString();

        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    public static String getRandomStr(int bit) {
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"};

        Random rdm = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bit; j++) {
            sb.append(str[rdm.nextInt(36)]);
        }
        return sb.toString();
    }

    public static String getNumberRandomStr(int bit) {
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random rdm = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bit; j++) {
            sb.append(str[rdm.nextInt(10)]);
        }
        return sb.toString();
    }

    public static Date getAfterNow(int seconds) {
        return new Date(System.currentTimeMillis() + seconds * 1000);
    }

    public final static String md5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");

            mdInst.update(s.getBytes());

            byte[] md = mdInst.digest();

            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);

        } catch (Exception e) {
            RsyncLog.error(e);
        }

        return null;
    }

    /**
     * @param s
     * @return String
     * @throws
     * @Title: md5to32bits
     * @Description: md5加密成32位 小写
     */
    public static String md5to32bits(String s) {
        StringBuffer buf = new StringBuffer("");

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

        } catch (NoSuchAlgorithmException e) {
            RsyncLog.error(e);
        }

        return buf.toString();
    }

    public static String getParamOrJsonValue(HttpServletRequest request, JsonObject jsonData, String name) {
        if (!T.isBlank(request.getParameter(name))) {
            return request.getParameter(name);
        }

        return jsonData != null && jsonData.has(name) ? jsonData.get(name).getAsString() : "";
    }

    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().setDateFormat(FORMAT_DATETIME).create();

        return gson.toJson(object);
    }

    public static Object toObject(String json, Type type) {
        Gson gson = new GsonBuilder().setDateFormat(FORMAT_DATETIME).create();

        return gson.fromJson(json, type);
    }

    private static final Pattern MOBILE_PATTERN = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");

    public static boolean isMobileNO(String value) {
        if (isBlank(value)) {
            return false;
        }

        try {
            Matcher m = MOBILE_PATTERN.matcher(value);

            return m.matches();

        } catch (Exception e) {
            RsyncLog.error(e);
            return false;
        }
    }

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]*");

    public static boolean isNO(String value) {
        if (isBlank(value)) {
            return false;
        }

        try {
            Matcher numberMatcher = NUMBER_PATTERN.matcher(value);

            return numberMatcher.matches();

        } catch (Exception e) {
            RsyncLog.error(e);
            return false;
        }
    }

    public static boolean isEmail(String email) {
        if (email != null) {
            boolean tag = true;
            final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            final Pattern pattern = Pattern.compile(pattern1);
            final Matcher mat = pattern.matcher(email);
            if (!mat.find()) {
                tag = false;
            }
            return tag;
        } else {
            return false;
        }
    }

    public static boolean isPassword(String password) {
        int passwordLength = password.length();

        return (passwordLength >= 6 && passwordLength <= 20);
    }

    // 找替身(依次找不为空的字符)
    public static String stuntman(String... texts) {
        if (texts == null || texts.length == 0) {
            return "";
        }

        for (String text : texts) {
            if (!isBlank(text)) {
                return text;
            }
        }

        return "";
    }

    /**
     * 检测是否有emoji字符
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        if (T.isBlank(source)) {
            return false;
        }

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (!isUnicode(codePoint)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isUnicode(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    public static String getCookieValueByName(HttpServletRequest request, String name) {
        if (T.isBlank(name)) {
            return null;
        }
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return "";
    }

    /**
     * @Fields emoji : Emoji表情正则
     */
    private static final Pattern EMOJI_PATTERN = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE
            | Pattern.CASE_INSENSITIVE);

    /**
     * @param source
     * @return
     * @Title filterEmoji
     * @Description 过滤Emoji表情
     * @author limingfeng
     * @dateTime 2014-12-9 下午3:39:39
     */
    public static String filterEmoji(String source) {
        if (T.isBlank(source)) {
            return source;
        }

        Matcher emojiMatcher = EMOJI_PATTERN.matcher(source);
        if (emojiMatcher.find()) {
            String text = emojiMatcher.replaceAll("*");
            RsyncLog.info("emoji filter - before:" + source + ", after:" + text);

            return text;
        }

        return source;
    }

    public static void setCookie(HttpServletResponse response, String name, String value, int expiry) {
        Cookie cookie = new Cookie(name, value);

        cookie.setMaxAge(expiry);

        response.addCookie(cookie);
    }

    public static byte[] toByteArray(String fileName) throws IOException {

        File f = new File(fileName);
        if (!f.exists()) {
            throw new FileNotFoundException(fileName);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            final int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, bufferSize))) {
                bos.write(buffer, 0, len);
            }

            return bos.toByteArray();

        } catch (IOException e) {
            RsyncLog.error(e);
            throw e;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                bos.close();
            } catch (IOException e) {
                RsyncLog.error(e);
            }
        }
    }

    /**
     * @param d 日期
     * @return
     * @Title 根据日期获取星座
     * @Description <p>
     * 按星座对应的开始月份：1-12 如水瓶座是1，双鱼座是2，以此类推。 星座参考—— 水瓶座：每年1月21日～2月18日
     * 双鱼座：每年2月19日～3月20日 白羊座：每年3月21日～4月20日 金牛座：每年4月21日～5月21日
     * 双子座：每年5月21日～6月21日 巨蟹座：每年6月22日～7月22日 狮子座：每年7月23日～8月22日
     * 处女座：每年8月23日～9月22日 天秤座：每年9月23日～10月23日 天蝎座：每年10月24日～11月22日
     * 射手座：每年11月23日～12月21日 摩羯座：当年12月22日～次年1月20日
     * </p>
     * @author limingfeng
     * @dateTime 2014-7-14 下午3:37:29
     */
    public static int getConstellationByDate(final Date d) {
        if (d == null) {
            return 0;// 找不到相应的星座
        }

        int[] constellations = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] days = {22, 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22}; // 两个星座分割日

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(d);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int index = month;

        // 所查询日期在分割日之前，索引-1，否则不变
        if (day < days[month - 1]) {
            index = index - 1;
        }

        return constellations[index];
    }

    /**
     * @return
     * @Title getShortLocalIpAddress
     * @Description 获取本机短ip地址（如ip是192.168.10.11 则返回 10.11）
     * @author limingfeng
     * @dateTime 2014-12-12 上午11:16:18
     */
    public static String getShortLocalIpAddress() {
        try {
            String ip = getLocalIpAddress();
            if (T.isBlank(ip)) {
                return ip;
            }

            String[] ips = ip.split("\\.");
            if (ips.length >= 4) {
                return ips[2] + "." + ips[3];
            }

        } catch (Exception e) {
            RsyncLog.error(e);
        }

        return "";
    }

    /**
     * @return
     * @Title getLocalIpAddress
     * @Description 获取本机ip地址
     * @author limingfeng
     * @dateTime 2014-12-12 上午11:14:32
     */
    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();

            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    InetAddress ip = address.nextElement();
                    if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                        return ip.getHostAddress();
                    }
                }
            }

        } catch (Exception e) {
            RsyncLog.error(e);
        }

        return "";
    }

    /**
     * 获取客户端的ip
     */
    public static String getClientIpAddr(HttpServletRequest request) {
        try {
            // 针对　nginx获取ip
            String ip = request.getHeader("X-Real-IP");
            // 针对　一般tomcat获取ip
            if (isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            if (isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteHost();
            }
            return ip;

        } catch (Exception e) {
            RsyncLog.error(e);
        }

        return "";
    }

    /**
     * @param phone
     * @return
     * @Title makeupMobileNumber
     * @Description 手机号容错处理，兼容空格，+86
     * @author limingfeng
     * @dateTime 2014-12-23 上午11:56:09
     */
    public static String makeupMobileNumber(String phone) {
        if (T.isBlank(phone)) {
            return "";
        }

        return phone.replaceAll(" ", "").replaceFirst("(\\+86)", "");
    }

}