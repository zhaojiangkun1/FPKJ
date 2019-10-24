package Case;
import Bean.EnvNum;
import Bean.TestEnv;
import Config.UpdateFpqqlsh;
import Model.AcquireSubstr;
import Model.ActualResult;
import Model.Java2XML;
import Model.PostRequest;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import javafx.geometry.Pos;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
public class Ghdwsbh {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "购货单位识别号为空")
    public void  ghdwsbh() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "购货单位识别号为15位数字")
    public void  ghdwsbh1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","123456789012345");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "购货单位识别号为20位数字")
    public void  ghdwsbh2() throws IOException,NoSuchAlgorithmException{
    map.put("ghdwsbh","12345678901234567890");
    map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
    String file = Java2XML.BuildXMLDoc(map);
    System.out.println("本次请求的报文为:"+file);
    jsonObject = ActualResult.resultCorrect();
    String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
    System.out.println(result);
    JSONObject arrayObject = AcquireSubstr.analyzeString(result);
    Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "购货单位识别号为15位字母")
    public void  ghdwsbh3() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","asdfghjklzxcvbn");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "购货单位识别号20wei字母")
    public void  ghdwsbh4() throws IOException,NoSuchAlgorithmException{
    map.put("ghdwsbh","gouhudanweishibiehao");
    map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
    String file = Java2XML.BuildXMLDoc(map);
    System.out.println("本次请求的报文为:"+file);
    jsonObject = ActualResult.resultCorrect();
    String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
    System.out.println(result);
    JSONObject arrayObject = AcquireSubstr.analyzeString(result);
    Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位识别号小于15位")
    public void  ghdwsbh5() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","123345");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位识别号大于20位")
    public void  ghdwsbh6() throws IOException,NoSuchAlgorithmException{
          map.put("ghdwsbh","12345678910238487327198912379121");
          map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
          String file = Java2XML.BuildXMLDoc(map);
          System.out.println("本次请求的报文为:"+file);
          jsonObject = ActualResult.resultCorrect();
          String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
          System.out.println(result);
          JSONObject arrayObject = AcquireSubstr.analyzeString(result);
          Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位识别号为null")
    public void  ghdwsbh7() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh",null);
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
