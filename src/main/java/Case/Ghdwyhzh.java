package Case;
import Bean.*;
import Config.UpdateFpqqlsh;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Ghdwyhzh {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "购货单位银行账号为空")
    public void  ghdwyhzh() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwyhzh","");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "购货单位银行账号为正常账号")
    public void  ghdwyhzh1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwyhzh","10107501040008319");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位银行账号为null")
    public void  ghdwyhzh2() throws IOException,NoSuchAlgorithmException{
            map.put("ghdwyhzh",null);
            map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
            String file = Java2XML.BuildXMLDoc(map);
            System.out.println("本次请求的报文为:"+file);
            jsonObject = ActualResult.resultCorrect();
            String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
            System.out.println(result);
            JSONObject arrayObject = AcquireSubstr.analyzeString(result);
            Assert.assertEquals(jsonObject,arrayObject);
    }
}
