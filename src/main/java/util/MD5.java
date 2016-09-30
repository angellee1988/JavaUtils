package util;

import java.security.MessageDigest;

public class MD5 {
    /**
     * @param s       待加密字符串
     * @param charset 编码格式
     * @return
     * @Description: TODO
     * @author: simon.JY
     * @date: 2015年6月30日 下午5:36:08
     */
    public final static String MD5Encoder(String s, String charset) {
        try {
            if (null == s) {
                return null;
            }
            if (null == charset) {
                charset = "UTF-8";
            }
            byte[] btInput = s.getBytes(charset);
            return MD5Encoder(btInput);
        } catch (Exception e) {
            return null;
        }
    }

    public final static String MD5Encoder(String s) {
        return MD5Encoder(s, "UTF-8");
    }

    /**
     * @param bytes 需要编码的字节
     * @author: kail
     * @date: 2015年9月1日 下午16:36
     */
    public final static String MD5Encoder(byte[] bytes) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(bytes);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String test = MD5Encoder("123456", "UTF-8");
        System.out.println(test);
        //e10adc3949ba59abbe56e057f20f883e
    }
}
