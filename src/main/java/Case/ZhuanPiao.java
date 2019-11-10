package Case;

import Bean.TestEnv;
import Model.AcquireSubstr;
import Model.ExpectedResult;
import Model.Java2XML;
import Model.PostRequest;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ZhuanPiao {
    HashMap<String,String> map = new HashMap<>();
    @Test(groups = {"开具专票"},description = "所有参数均正常，开具一张专票")
    public void zhuanPiao() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("sprsjh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(runResult,expectedResult);
    }

    /**
     * 专票冲红，必须带上通知单编号，需要提前上传红字信息表，返回一个通知单编号之后，才能冲红专票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"专票冲红"},description = "所有参数均正常，冲红一张增值税专票")
    public void zhuanPiaoHongChong() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","004");
        map.put("sprsjh","");
        map.put("spsl","");
        map.put("dj","");
        map.put("je","");
        map.put("sl","");
        map.put("se","");
        map.put("tzdbh","");

        String file = Java2XML.BuildXMLDoc(map);
        System.out.println(file);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        JSONObject runResult = AcquireSubstr.analyzeString(result);
        System.out.println(result);
        Assert.assertEquals(runResult,expectedResult);
    }

}
