package Case;

import Bean.TestEnv;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class DianPiao {
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"开具电票"},description = "所有参数都正常，开具一张电票")
    public void dianPiao() throws IOException, NoSuchAlgorithmException {
        map.put("readonly","1");
        map.put("shnsrsbh","110101201601010075");
        map.put("jsbh","110101201601010075~~499000153838");
        map.put("sprsjh","zhaokun@shuzutech.com");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult= ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(runResult,expectedResult);
    }

    @Test(groups = {"自助开票"},description = "所有参数都正常，自助开票")
    public void ziZhuKaiPiao() throws IOException, NoSuchAlgorithmException {
        map.put("yhlx","1");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult= ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(runResult,expectedResult);
    }

    @Test(groups = {"电票冲红"},description = "所有参数均正常，开具一张负数发票")
    public void dianPiaoChongHong() throws IOException, NoSuchAlgorithmException {
        map.put("kplx","1");
        map.put("spsl","-1");
        map.put("dj","32.6");
        map.put("je","-32.6");
        map.put("sl","0.06");
        map.put("se","-1.96");
        map.put("readonly","0");
        map.put("yfpdm","150000456123");
        map.put("yfphm","36873823");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult= ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(runResult,expectedResult);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常,开具一张6行商品的电票")
    public void multiGroupDianPiao() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",6);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult= ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常，开具一张8行商品的电票")
    public void multiGroupDianPiao1() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",8);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult= ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常,开具一张9行商品的电票")
    public void multiGroupDianPiao2() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",9);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult= ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(expectedResult,runResult);
    }

}
