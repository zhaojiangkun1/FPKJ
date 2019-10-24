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

public class Spmc {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "当fphxz为0时,商品名称为水稻")
    public void  spmc() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","0");
        map.put("spmc","水稻");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "当fphxz为1时，商品名称为水稻")
    public void  spmc1() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","1");
        map.put("spmc","水稻");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "当fphxz为2时，商品名称为水稻")
    public void  spmc2() throws IOException,NoSuchAlgorithmException{
    map.put("fphxz","2");
    map.put("spmc","水稻");
    map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
    String file = Java2XML.BuildXMLDoc(map);
    System.out.println("本次请求的报文为:"+file);
    jsonObject = ActualResult.resultCorrect();
    String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
    System.out.println(result);
    JSONObject arrayObject = AcquireSubstr.analyzeString(result);
    Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "当fphxz为空或null,商品名称为水稻")
    public void  spmc3() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","");
        map.put("spmc","水稻");
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
