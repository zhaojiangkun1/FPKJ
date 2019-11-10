package Case;
import Bean.*;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Ghdwyhzh {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "购货单位银行账号为空")
    public void  ghdwyhzh() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwyhzh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"正常开票"},description = "购货单位银行账号为正常账号")
    public void  ghdwyhzh1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwyhzh","10107501040008319");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "购货单位银行账号为null")
    public void  ghdwyhzh2() throws IOException,NoSuchAlgorithmException{
            map.put("ghdwyhzh",null);
            String file = Java2XML.BuildXMLDoc(map);
            System.out.println("本次请求的报文为:"+file);
            expectedResult = ExpectedResult.resultCorrect();
            String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
            System.out.println(result);
            JSONObject actualResult = AcquireSubstr.analyzeString(result);
            Assert.assertEquals(actualResult,expectedResult);
    }
}
