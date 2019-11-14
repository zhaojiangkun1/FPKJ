package Case;

import Bean.TestEnv;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class PuPiao {
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"开具普票"},description = "所有参数均正常，开具一张增值税普通发票")
    public void puPiao() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("sprsjh","");
        map.put("readonly","1");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(runResult,expectedResult);
    }

    @Test(groups = {"普票冲红"},description = "所有参数均正常，冲红一张增值税普通发票")
    public void puPiaoChongHong() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("sprsjh","");
        map.put("kplx","1");
        map.put("spsl","-1");
        map.put("dj","7.55");
        map.put("je","-7.55");
        map.put("sl","0.06");
        map.put("se","-0.45");
        map.put("yfpdm","050000000102");
        map.put("yfphm","13315608");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"多行普票开具"},description = "所有参数均正常，开具一张6行商品的普票")
    public void multiLineGroupPuPiao() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007",6);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(runResult,expectedResult);
    }

    @Test(groups = {"多行普票开具"},description = "所有参数均正常,开具一张8行商品的普票")
    public void multiLineGroupPuPiao1() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007", 8);
        System.out.println("本次请求的报文:" + file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(runResult, expectedResult);
    }

    @Test(groups = {"多行普票开具"},description = "所有参数均正常，开具一张9行商品的普票")
    public void multiLineGroupPuPiao2() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("007",9);
        System.out.println("本次请求的报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(runResult, expectedResult);
    }
}
