package com.midoujia.pay.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.midoujia.pay.exception.BusinessMsg;
import com.midoujia.pay.exception.PayException;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Http请求工具类
 *
 * @author zfldiv@163.com
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * http post调用http接口
     * @param url
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     * @throws PayException
     */
    public static<T> T httpPost(String url, String jsonStr, Class<T> t) throws PayException {
        //创建httpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        T instance = null;
        try {
            instance = t.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成Token http请求
//        String token = null;
//        try {
//            token = httpToken("POST",url,jsonStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json;charset=UTF-8");
        httppost.addHeader("Accept", "application/json");
//        httppost.addHeader("Authorization", token);
        //设置连接超时时间和数据获取超时时间--单位：ms
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000000).setConnectionRequestTimeout(5000000)
                .setSocketTimeout(5000000).build();
        httppost.setConfig(requestConfig);
        //设置http request body请求体
        if (null != jsonStr) {
            //解决中文乱码问题
            StringEntity myEntity = new StringEntity(jsonStr, "UTF-8");
            httppost.setEntity(myEntity);
        }
        HttpResponse response = null;
        try {
            response = httpClient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
            //throw new PayException(BusinessMsg.UNKNOW_ERROR);
        }
        String result= null;
        try {
            result = EntityUtils.toString(response.getEntity(),"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到返回的字符串
        JSONObject jsonObject = JSON.parseObject(result);
        if(instance instanceof JSONObject) {
            return (T) jsonObject;
        }

        T resultBean = (T) JSONObject.parseObject(jsonObject.toString(), t);
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultBean;
    }


    /**
     * http get调用http接口
     * @param url
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static<T> T httpGet(String url, String jsonStr,Class<T> t) throws PayException {
        String result = "";
        T instance = null;
        try {
            instance = t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //生成Token http请求
//        String token = null;
//        try {
//            token = httpToken("GET",url,jsonStr);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //创建httpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建实例方法
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpget.addHeader("Accept", "application/json");
//        httpget.addHeader("Authorization", token);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpget);
        } catch (IOException e) {
            //throw new PayException(BusinessMsg.UNKNOW_ERROR);
        }

        //如果状态码为200,就是正常返回
        if(response.getStatusLine().getStatusCode()==200){
            try {
                result= EntityUtils.toString(response.getEntity(),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JSONObject jsonObject =JSON.parseObject(result);
        if(instance instanceof JSONObject) {
            return (T) jsonObject;
        }

        T resultBean = (T) JSONObject.parseObject(jsonObject.toString(), t);
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultBean;
    }
}
