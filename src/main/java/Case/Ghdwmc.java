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


public class Ghdwmc {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();
    @Test(groups = {"正常开票"},description = "购货单位名称正常")
    public void  ghdwmc() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc","南京数族信息科技有限公司");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "购货单位名称为空")
    public void  ghdwmc1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect4();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"异常开票"},description = "购货单位名称为null")
    public void  ghdwmc2() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","缺少节点或内容ghdwmc");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     * 购货单位名称的特殊字符未做校验
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(description = "购货单位名称输入特殊字符")
    public void  ghdwmc3() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc","@#￥%&&");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

}
