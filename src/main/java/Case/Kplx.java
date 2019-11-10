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
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();


    @Test(groups = {"异常开票"},description = "开票其它参数均正常，开票类型为空")
    public void  kplx() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","缺少节点或内容kplx");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"异常开票"},description = "开票其它参数均正常，开票类型为null")
    public void  kplx2() throws IOException,NoSuchAlgorithmException{
        map.put("kplx",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","缺少节点或内容kplx");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "开票其它参数均正常，开票类型为2")
    public void  kplx3() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","2");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","300000");
        expectedResult.put("returnmsg","开票类型有误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);

    }

}
