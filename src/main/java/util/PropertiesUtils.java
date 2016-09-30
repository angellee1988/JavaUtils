package util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 属性文件公共类
 *
 * @Description:TODO
 * @author: 金砖
 * @date: 2014年12月19日 下午4:22:52
 * 久兴信息技术(上海)有限公司
 */
public class PropertiesUtils  extends PropertyPlaceholderConfigurer {
    //所有属性文件的键值对
    private static Map<String, Object> ctxPropertiesMap;

    /**
     * 添加所有属性到map中
     * Description: TODO
     *
     * @param beanFactoryToProcess
     * @param props
     * @throws BeansException
     * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.Properties)
     */
    @Override
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        // TODO Auto-generated method stub
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    /**
     * 获取属性值
     *
     * @param name
     * @return
     * @throws
     * @Description: TODO
     * @return: Object
     */
    public static String getContextProperty(String name) {
        return ctxPropertiesMap.get(name) == null ? "" : ctxPropertiesMap.get(name).toString();
    }

    /**
     * @param name         属性名
     * @param defaultValue 如果获取不到属性值，使用默认值
     * @Description: 角色/id 查询角色列表(分页)
     * @author: kail
     * @date: 2015年9月29日
     */
    public static String getContextProperty(String name, String defaultValue) {
        return ctxPropertiesMap.get(name) == null ? defaultValue : ctxPropertiesMap.get(name).toString();
    }

    /**
     * @param name 属性名
     * @Description: 角色/id 查询角色列表(分页)
     * @author: kail
     * @date: 2015年9月29日
     */
    public static Integer getInt(String name) {
        String value = getContextProperty(name);
        if ((value + "").matches("-?\\d+")) {
            return Integer.parseInt(value);
        } else {
            return null;
        }
    }

    /**
     * @param name         属性名
     * @param defaultValue 如果获取不到属性值，使用默认值
     * @Description: 角色/id 查询角色列表(分页)
     * @author: kail
     * @date: 2015年9月29日
     */
    public static Integer getInt(String name, Integer defaultValue) {
        String value = getContextProperty(name);
        if ((value + "").matches("-?\\d+")) {
            return Integer.parseInt(value);
        } else {
            return defaultValue;
        }
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isNumeric("-1"));
        System.out.println(StringUtils.isNumeric(""));
        System.out.println(StringUtils.isNumeric(null));

        System.out.println((null + "").matches("\\d*"));
        System.out.println(("-1").matches("-?\\d+"));
        System.out.println(("1").matches("-?\\d+"));
        System.out.println(("").matches("\\d+"));
    }

}
