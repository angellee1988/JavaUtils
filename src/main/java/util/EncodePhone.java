package util;

import org.apache.commons.lang.StringUtils;

public class EncodePhone {
    /**
     * @param phone
     * @param accountId 当前登陆用户的id
     * @return
     * @Description: 手机号加密 （当前用户 id+3 * 不包括后6位的手机号,再连接 后6位号码至最前面）
     * @author: simon.JY
     * @date: 2015年10月30日 下午4:01:58
     */
    public static String getEncodePhone(String phone, Integer accountId) {
        if(phone==null || accountId==null){
            return "";
        }
        phone = phone.trim();
        if (StringUtils.isNumeric(phone) && StringUtils.isNotBlank(phone) && phone.length() > 5) {
            Long temp = accountId + 3L;
            String headphone = phone.substring(0, 5);
            Long ihead = Long.parseLong(headphone);
            temp = temp * ihead;
            String last5phone = phone.substring(5);
            return last5phone + temp;
        }
        return phone;
    }

    /**
     * @param encodePhone
     * @param accountId
     * @return
     * @Description: 手机号解码
     * @author: simon.JY
     * @date: 2015年10月30日 下午5:07:15
     */
    public static String getDecodePhone(String encodePhone, Integer accountId) {
        encodePhone = encodePhone.trim();
        if (StringUtils.isNumeric(encodePhone) && StringUtils.isNotBlank(encodePhone) && encodePhone.length() > 6) {
            Long temp = accountId + 3L;
            String last6phone = encodePhone.substring(0, 6);
            String headphone = encodePhone.substring(6);
            Long i = Long.parseLong(headphone);
            temp = i / temp;
            return temp + last6phone;
        }
        return encodePhone;
    }


    public static void main(String[] args) {
        EncodePhone phone = new EncodePhone();
        System.out.println(phone.getEncodePhone("18016348674", 144));
        System.out.println(phone.getEncodePhone("1", 9900));
    }

}
