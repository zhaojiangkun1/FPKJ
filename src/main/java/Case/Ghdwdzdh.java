package Case;
import Bean.*;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class Ghdwdzdh {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"异常开票"},description = "专票开具，其购货单位地址电话为空")
    public void  ghdwdzdh() throws IOException,NoSuchAlgorithmException{
        map.put("fplxdm","004");
        map.put("ghdwdzdh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returnmsg","缺少节点或内容ghdwdzdh");
        expectedResult.put("returncode","10001");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     * 购货单位地址电话未做特殊字符校验
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(description = "输入特殊字符")
    public void  ghdwdzdh1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwdzdh","#￥%%#￥#%%#￥%#￥￥#");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(description = "购货单位地址电话为null")
    public void  ghdwdzdh2() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwdzdh",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

}
