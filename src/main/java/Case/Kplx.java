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

public class Kplx {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "开票类型为空")
    public void  kplx() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "开票类型为0，正数发票")
    public void  kplx2() throws IOException,NoSuchAlgorithmException{
        //正数发票开具
        map.put("kplx","0");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "开票类型为1，开负数电子发票")
    public void  kplx3() throws IOException,NoSuchAlgorithmException{
        //负数开票：需要原发票代码,发票号码
        map.put("kplx","1");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "开票类型为null")
    public void  kplx4() throws IOException,NoSuchAlgorithmException{
        map.put("kplx",null);
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"正常开票"},description = "开票类型为1，开增值税普通发票")
    public void  kplx5() throws IOException,NoSuchAlgorithmException{
    
    }
    @Test(groups = {"正常开票"},description = "开票类型为1，开增值税卷式发票")
    public void  kplx6() throws IOException,NoSuchAlgorithmException{

    }
    @Test(groups = {"正常开票"},description = "开票类型为1，冲红增值专票")
    public void  kplx7() throws IOException,NoSuchAlgorithmException{

    }
}
