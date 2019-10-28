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

public class De {
    //dw-spsl-dj-je-sl-se
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();
    @Test(groups = {"正常开票"},description = "单位商品数量单价税率税额均合理")
    public void  de() throws IOException,NoSuchAlgorithmException{
        map.put("dw","元");
        map.put("spsl","10");
        map.put("dj","32.1");
        map.put("je","321");
        map.put("sl","0.03");
        map.put("se","9.63");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "不含税金额*税率与税额误差大于 0.06")
    public void  de1() throws IOException,NoSuchAlgorithmException{
        map.put("dw","元");
        map.put("spsl","10");
        map.put("dj","32.1");
        map.put("je","321");
        map.put("sl","0.03");
        map.put("se","10");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "数量*单价与金额误差大于 0.01")
    public void  de2() throws IOException,NoSuchAlgorithmException{
        map.put("dw","元");
        map.put("spsl","11");
        map.put("dj","32.1");
        map.put("je","321");
        map.put("sl","0.03");
        map.put("se","9.63");
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
