package Case;

import Bean.*;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Fplxdm {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    /**
     * 为null和为空是一致的
     * 发票类型代码为空，分两种情况
     * 1）如果在老板通——扫码台配置的界面，配置了默认开票的发票类型，则取这个默认值
     * 2）如果未配置默认的开票类型，则发票类型代码必须为空
     *
     * 商户扫码台开票企业信息未正确配置
     * 1000025
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"异常开票"},description = "开票其它参数正常，发票类型代码为空")
    public void fplxdm() throws IOException,NoSuchAlgorithmException{
        map.put("fplxdm","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     * 发票类型代码不存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "开票其它参数正常，发票类型代码为027")
    public void  fplxdm2() throws IOException,NoSuchAlgorithmException{
        map.put("fplxdm","027");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","发票类型代码有误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


}
