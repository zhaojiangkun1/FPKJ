package com.shuzutech.model;

import com.shuzutech.bean.EnvNum;
import com.shuzutech.config.GetAppInfo;
import com.shuzutech.config.GetSaveAddr;
import com.shuzutech.config.Md5;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostRequest {

    public static String zhenPiaoYunRequest(String body, EnvNum num) throws IOException, NoSuchAlgorithmException {
        String result = "";
        System.out.println("本次请求的报文:" + body);
        String url = GetSaveAddr.getSaveAddr(num);
        System.out.println("本次请求的url:" + url);
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
        String date = simpleDateFormat.format(new Date());

        String appId = GetAppInfo.getAppInfo(num).getAppid();
        String accessToken = GetAccessToken.getAccessToken(num);
        System.out.println("本次请求的accessToken:" + accessToken);
        String contentMd5 = Md5.EncoderByMd5(body + date.toString() + accessToken);

        StringEntity entity = new StringEntity(body, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/x-www-form-urlencoded");
        post.setEntity(entity);

        post.setHeader("APPID", appId);
        System.out.println("APPID:"+appId);
        post.setHeader("Date", date);
        String env = String.valueOf(num);
        if (env.contains("bwt")){
            System.out.println("version:2.0.0");
            post.setHeader("version","2.0.0");
        }
        System.out.println("Date:"+date);
        post.setHeader("Content-MD5", contentMd5);
        System.out.println("Content-MD5:"+contentMd5);

        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() == 200){
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        }
        System.out.println("臻票云返回的报文:"+result);
        return result;
    }


}
