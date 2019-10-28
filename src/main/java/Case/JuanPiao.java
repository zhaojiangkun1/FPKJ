package Case;

import Bean.TestEnv;
import Model.AcquireSubstr;
import Model.ActualResult;
import Model.Java2XML;
import Model.PostRequest;
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
        map.put("fplxdm","025");
        map.put("sprsjh","");
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
        map.put("yfpdm","050000000102");
        map.put("yfphm","20191065");
        String file = Java2XML.BuildXMLDoc(map);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }


}
