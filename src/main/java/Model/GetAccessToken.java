package Model;

import Bean.AppInfo;
import Bean.EnvNum;
import Config.GetAppInfo;
import Config.UpdateToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

public class GetAccessToken {

    public static String getAccessToken(EnvNum num) throws IOException {
        AppInfo appInfo = GetAppInfo.getAppInfo(num);
        String appId = appInfo.getAppid();
        String appSecret = appInfo.getAppSecret();
        String addr = appInfo.getAddress();
        Date old_time = appInfo.getUpdateTime();
        Date current_time = new Date();
        String accessToken;
        String url = addr + "?appId=" + appId + "&appSecret=" + appSecret;
        System.out.println("获取token的url："+url);
        long diffsec = (current_time.getTime()-old_time.getTime())/1000;

        System.out.println("两次请求的时间差："+diffsec);
        if (diffsec <= 7200){
            accessToken = appInfo.getAccessToken();
        }else {


            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            String leftTag = "<access_token>";
            String rightTag = "</access_token>";
            accessToken = result.substring(result.indexOf(leftTag) + leftTag.length(), result.indexOf(rightTag));

            appInfo.setAccessToken(accessToken);
            appInfo.setUpdateTime(current_time);
            UpdateToken.updateToken(appInfo,num);

        }
        return accessToken;

    }

}
