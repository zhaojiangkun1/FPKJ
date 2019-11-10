package Case;
import Bean.*;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Fphxz {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"异常开票"},description = "非折扣行商品，单个商品的发票行性质为空")
    public void  fphxz() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","缺少节点或内容fphxz");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"正常开票"},description = "非折扣行商品，单个商品的发票行性质为0")
    public void  fphxz1() throws IOException,NoSuchAlgorithmException{
    map.put("fphxz","0");
    String file = Java2XML.BuildXMLDoc(map);
    System.out.println("本次请求的报文为:"+file);
    expectedResult = ExpectedResult.resultCorrect();
    String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
    System.out.println(result);
    JSONObject actualResult = AcquireSubstr.analyzeString(result);
    Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "非折扣行商品，单个商品发票行性质为1")
    public void  fphxz2() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","1");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","60034");
        expectedResult.put("returnmsg","发票行性质有误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "非折扣行商品，单个商品的发票行性质为2")
    public void  fphxz3() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz","2");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","60034");
        expectedResult.put("returnmsg","发票行性质有误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "单个商品的发票行性质为null")
    public void  fphxz4() throws IOException,NoSuchAlgorithmException{
        map.put("fphxz",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","缺少节点或内容fphxz");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"异常开票"},description = "单个商品的发票行性质为3")
    public void fphxz5() throws IOException, NoSuchAlgorithmException {
        map.put("fphxz","3");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","60034");
        expectedResult.put("returnmsg","发票行性质有误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);

    }
}
