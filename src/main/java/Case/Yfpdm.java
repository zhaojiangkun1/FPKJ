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
public class Yfpdm {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "原发票代码为空")
    public void  yfpdm() throws IOException,NoSuchAlgorithmException{
        map.put("yfpdm","");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "原发票代码为null")
    public void  yfpdm1() throws IOException,NoSuchAlgorithmException{
        map.put("yfpdm",null);
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "所有参数均正常，开具一张负数电子发票")
    public void  yfpdm2() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","1");
        map.put("yfpdm","150000456123");
        map.put("yfphm","20201332");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "当开票类型为1时,只有原发票代码")
    public void  yfpdm3() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","1");
        map.put("yfpdm","150000456123");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect2();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "当开票类型为1时,只有原发票号码")
    public void  yfpdm4() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","1");
        map.put("yfpdm3","");
        map.put("yfphm","20201329");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect3();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);

    }
}
