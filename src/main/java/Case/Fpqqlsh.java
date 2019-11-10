package Case;

import Bean.EnvNum;
import Bean.TestEnv;
import Config.UpdateFpqqlsh;
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

public class Fpqqlsh {

    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"异常开票"},description = "发票请求流水号为空")
    public void fpqqlsh1() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh", "");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.parametersError("fpqqlsh");
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"开具电子票"},description = "发票请求流水号为1个数字",priority = 4)
    public void fpqqlsh2() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","0");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(groups = {"开具电子票"},description = "发票请求流水号为1个字母")
    public void fpqqlsh3() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh",String.valueOf(UpdateFpqqlsh.randGenerated()));
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);

    }

    @Test(groups = {"开具电子票"},description = "发票请求流水号为64位数字")
    public void fpqqlsh4() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh", UpdateFpqqlsh.numbers64());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"开具电子票"},description = "发票请求流水号为64位字母")
    public void fpqqlsh5() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh", UpdateFpqqlsh.letters64());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"开具电子票"},description = "发票请求流水号为字母和数字的组合")
    public void fpqqlsh6() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh", UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"异常开票"},description = "发票请求流水号为65位")
    public void fpqqlsh7() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh",UpdateFpqqlsh.numbers64()+"A");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.parametersError("fpqqlsh");
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(groups = {"异常开票"},description = "发票请求流水号含有特殊字符")
    public void fpqqlsh8() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","1111%%￥&jhhhd");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        expectedResult = ExpectedResult.parametersError("fpqqlsh");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"异常开票"},description = "发票请求流水号为null")
    public void fpqqlsh9() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh",null);
        System.out.println("本次请求的报文:"+Java2XML.BuildXMLDoc(map));
        expectedResult = ExpectedResult.parametersError("fpqqlsh");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map),TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"异常开票"},description = "同一应用开票，发票请求流水号相同")
    public void fpqqlsh10() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","0");
        System.out.println("本次请求的报文:"+Java2XML.BuildXMLDoc(map));
        expectedResult.put("returncode","1000012");
        expectedResult.put("returnmsg","当前发票处于:开具成功后打印成功状态,不支持重新开具");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map),TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"开具电子票"},description = "不同应用，发票请求流水号相同")
    public void fpqqlsh11() throws IOException, NoSuchAlgorithmException {
        map.put("fpqqlsh","0");
        System.out.println("本次请求的报文:"+Java2XML.BuildXMLDoc(map));
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), EnvNum.PRO1);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }







}
