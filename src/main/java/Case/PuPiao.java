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

public class PuPiao {
    HashMap<String,String> map = new HashMap<>();

    @Test(groups = {"开具普票"},description = "所有参数均正常，开具一张增值税普通发票")
    public void puPiao() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("sprsjh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        JSONObject expectedResult = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,runResult);
    }

    @Test(groups = {"普票冲红"},description = "所有参数均正常，冲红一张增值税普通发票")
    public void puPiaoChongHong() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","007");
        map.put("sprsjh","");
        map.put("kplx","1");
        map.put("spsl","-1");
        map.put("je","-32.6");
        map.put("se","-1.96");
        map.put("yfpdm","050000000102");
        map.put("yfphm","13315602");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject expectedResult = ActualResult.resultCorrect();
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(expectedResult,actualResult);
    }

}
