package Case;

import Bean.TestEnv;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class JuanPiao {

    HashMap<String,String> map = new HashMap<>();
    @Test(groups = {"开具卷票"},description = "所有参数均正常，开具一张卷票")
    public void juanPiao() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","500102010001459");
        map.put("jsbh","500102010001459~~499000115698");
        map.put("fplxdm","025");
        map.put("sprsjh","");
        map.put("readonly","0");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"冲红卷票"},description = "所有参数均正常，开具一张负数卷票")
    public void juanPiaoChongHong() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","025");
        map.put("kplx","1");
        map.put("sprsjh","");
        map.put("spsl","-1");
        map.put("hsje","-34.56");
        map.put("se","-1.96");
        map.put("yfpdm","150001201509");
        map.put("yfphm","20191054");
        String file = Java2XML.BuildXMLDoc(map);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"多行卷票开具"},description = "所有参数均正常，开具一张6行商品的卷票")
    public void multiGroupJuanPiao() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("025",6);
        System.out.println("请求报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"多行卷票开具"},description = "所有参数均正常，开具一张8行商品的卷票")
    public void multiGroupJuanPiao1() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("025",8);
        System.out.println("请求报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"多行卷票开具"},description = "所有参数均正常，开具一张超过8行商品的卷票")
    public void multiGroupJuanPiao2() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("025",9);
        System.out.println("请求报文:"+file);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }


}
