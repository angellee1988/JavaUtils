package util;

import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Description Rose 返回
 * @author: kail
 * Copyright(c)2015/9/1 13:20 ttpai All Rights Reserved.
 */
public class RoseReturn {

    /**
     * 返回视图
     *
     * @param str 视图路径
     * @return
     */
    public static String view(String str) {
        return str;
    }

    /**
     * 【rose 内置】返回字符串
     *
     * @param str 需要返回的字符串
     * @return
     */
    public static String at(String str) {
        return "@" + str;
    }

    /**
     * 【rose 内置】返回Json
     *
     * @param str 需要返回的json字符串
     * @return
     */
    public static String json(String str) {
        return "@json:" + str;
    }

    public static String jsonAuto(Object obj) {
        return "@json:" + JsonUtil.toJSONString(obj);
    }

    public static String jsonAuto(Object obj, SerializerFeature... features) {
        return "@json:" + JsonUtil.toJSONString(obj, features);
    }

    /**
     * 【rose 内置】 重定向 redirect
     *
     * @param str 重定向的连接
     * @return
     */
    public static String redirect(String str) {
        return "r:" + str;
    }

    /**
     * 【rose 内置】 转发 forward
     *
     * @param str 转发的连接
     * @return
     */
    public static String forward(String str) {
        return "a:" + str;
    }


    /**
     * 返回空的json对象
     *
     * @return
     */
    public static String none() {
        return "@json:{}";
    }

    /**
     * 成功的信息
     */
    public static String ok() {
        return none();
    }

}
