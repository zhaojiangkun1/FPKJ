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


public class Fplxdm {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();


    @Test(groups = {"异常开票"},description = "发票类型为空")
    public void fplxdm() throws IOException,NoSuchAlgorithmException{
        map.put("fplxdm","");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "")
    public void  fplxdm1() throws IOException,NoSuchAlgorithmException{

    }
}
