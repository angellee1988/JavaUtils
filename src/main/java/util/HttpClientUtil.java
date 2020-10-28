package util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.BaseException;
import exception.CommonBusinessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @Description: TODO
 * @author: simon.JY
 * @date: 2015年8月12日
 * 久兴信息技术(上海)有限公司
 */
public class HttpClientUtil {
    private final static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private final static Integer CONNECTION_OUT_TIME = 2000;
    private final static Integer READ_OUT_TIME = 2000;
    private final static String URL_CHARSET = "UTF-8";
    private final static String GET="GET";
    private final static String POST="POST";
     
    
    /**
     * GET请求
     * @param url
     * @return
     * @throws BaseException
     */
    public static String get(String url) throws BaseException{
        return executeMethod(GET,url,null,URL_CHARSET);
    }
    
    /**
     * GET请求
     * @param url
     * @return
     * @throws BaseException
     */
    public static String get(String url,Map<String, String> param) throws BaseException{
        if(null==url) return null;
        Iterator<Entry<String, String>> iterator=param.entrySet().iterator();
        String str="";
        while(iterator.hasNext()){
            Map.Entry<String, String> kv=iterator.next();
            str+=kv.getKey()+"="+kv.getValue()+"&";
        }
        url=url+"?"+str;
        return executeMethod(GET,url,null,URL_CHARSET);
    }
   
    /**
     * POST提交
     * @param url
     * @return
     * @throws BaseException 
     */
    public static String post(String url) throws BaseException{
        return post(url,null);
    }
    /**
     * POST提交
     * @param url
     * @param params
     * @return
     * @throws BaseException 
     */
    public static String post(String url,Map params) throws BaseException{
        return executeMethod(POST,url,params,URL_CHARSET);
    }

    /**
     * 
     * @Description: 发送一个post请求，获取返回的json格式字符串
     * @author: simon.JY
     * @param targetUrl
     * @param params
     * @return
     * @throws BaseException
     * @date: 2015年8月12日 下午9:31:19
     *
     */
    public static String executeMethod(String methodType,String targetUrl,Map<String, Object> params,String encoding) throws BaseException{
        if(null==targetUrl) return null;
        SimpleHttpConnectionManager connectionManager =  new SimpleHttpConnectionManager(true);
        //连接超时,单位毫秒
        connectionManager.getParams().setConnectionTimeout(CONNECTION_OUT_TIME);
        //读取超时,单位毫秒
        connectionManager.getParams().setSoTimeout(READ_OUT_TIME);
        connectionManager.getParams().setTcpNoDelay(false);
        //设置获取内容编码
        connectionManager.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,encoding);
        HttpClient httpClient = new HttpClient(connectionManager);
        HttpMethod method=null;
        
        if(POST.equals(methodType)){
            PostMethod pmethod = new PostMethod(targetUrl);
          //判断参数是否为空
            if(params != null){
                NameValuePair[] nameValuePairArr = new NameValuePair[params.size()];
                Set key = params.keySet();
                Iterator keyIte = key.iterator();
                int index = 0;
                while(keyIte.hasNext()){
                    Object paramName = keyIte.next();
                    Object paramValue = params.get(paramName);
                    if(paramName instanceof String && paramValue instanceof String){
                        NameValuePair pair = new NameValuePair((String)paramName,(String)paramValue);
                        nameValuePairArr[index] = pair;
                        index++;
                    }
                }
                pmethod.addParameters(nameValuePairArr);
                
            }
            method=pmethod;
        }else{
            method = new GetMethod(targetUrl);
        }
        
        
        //设置请求参数的编码
        method.getParams().setContentCharset(encoding);
        String resmethod = "";
        try {
            int sendStatus = httpClient.executeMethod(method);
            if(sendStatus == HttpStatus.SC_OK){
                logger.info("http请求返回成功![url:{}],[param:{}]",targetUrl,params);
            }else{
                logger.error("http请求返回失败![url:{}],[param:{}]",targetUrl,params);
            }
            //获取返回的信息
            resmethod = method.getResponseBodyAsString();
        } catch (HttpException e) {
            logger.error(e.toString());
            throw new BaseException(CommonBusinessException.HTTP_EXCEPTION.getCode(),CommonBusinessException.HTTP_EXCEPTION.getMessage(),e);
        } catch (IOException e) {
            logger.error("http请求数据异常!请求[url:{}],[param:{}]。异常错误信息"+e.getMessage(),targetUrl,params);
            throw new BaseException(CommonBusinessException.IO_EXCEPTION.getCode(),CommonBusinessException.IO_EXCEPTION.getMessage(),e);
        } finally{
            //释放连接
            if(method != null){
                method.releaseConnection();
            }
            //关闭连接
            if(connectionManager != null){
                connectionManager.shutdown(); 
            }
        }
        return resmethod;
    }
    
    public static void main(String[] args) throws BaseException{
    }



    public static String sendPost(String url, String param) throws BaseException{
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            throw new BaseException("201","拨打电话发送 POST 请求出现异常！",e);
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
