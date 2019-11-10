package Case;

import Bean.TestEnv;
import Model.AcquireSubstr;
import Model.ExpectedResult;
import Model.Java2XML;
import Model.PostRequest;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Ghdwsbh {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "专票开具，购货单位识别号为空")
    public void  ghdwsbh() throws IOException,NoSuchAlgorithmException{
        map.put("fplxdm","004");
        map.put("ghdwsbh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","缺少节点或内容ghdwsbh");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(description = "购货单位识别号为15位数字")
    public void  ghdwsbh1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","123456789012345");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(description = "购货单位识别号为20位数字")
    public void  ghdwsbh2() throws IOException,NoSuchAlgorithmException{
    map.put("ghdwsbh","12345678901234567890");
    String file = Java2XML.BuildXMLDoc(map);
    System.out.println("本次请求的报文为:"+file);
    expectedResult = ExpectedResult.resultCorrect();
    String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
    System.out.println(result);
    JSONObject actualResult = AcquireSubstr.analyzeString(result);
    Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(description = "购货单位识别号为15位字母")
    public void  ghdwsbh3() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","asdfghjklzxcvbn");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(description = "购货单位识别号20位字母")
    public void  ghdwsbh4() throws IOException,NoSuchAlgorithmException{
    map.put("ghdwsbh","gouhudanweishibiehao");
    String file = Java2XML.BuildXMLDoc(map);
    System.out.println("本次请求的报文为:"+file);
    expectedResult = ExpectedResult.resultCorrect();
    String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
    System.out.println(result);
    JSONObject actualResult = AcquireSubstr.analyzeString(result);
    Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(description = "购货单位识别号小于15位")
    public void  ghdwsbh5() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh","123345");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(groups = {"异常开票"},description = "购货单位识别号大于20位")
    public void  ghdwsbh6() throws IOException,NoSuchAlgorithmException{
          map.put("ghdwsbh","12345678910238487327198912379121");
          String file = Java2XML.BuildXMLDoc(map);
          System.out.println("本次请求的报文为:"+file);
          expectedResult = ExpectedResult.resultCorrect();
          String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
          System.out.println(result);
          JSONObject actualResult = AcquireSubstr.analyzeString(result);
          Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(description = "购货单位识别号为null")
    public void  ghdwsbh7() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwsbh",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
