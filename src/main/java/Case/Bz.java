package Case;
import Bean.*;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
public class Bz {

    HashMap<String,String> map = new HashMap();
    JSONObject expectedResult = new JSONObject();

    @Test(groups = {"正常开票"},description = "备注长度为空")
    public void  bz() throws IOException,NoSuchAlgorithmException{
        map.put("bz","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"正常开票"},description = "备注长度为null")
    public void  bz1() throws IOException,NoSuchAlgorithmException{
        map.put("bz",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "备注长度超过142")
    public void  bz2() throws IOException,NoSuchAlgorithmException{
        map.put("bz","1------------------------------------------------------------" +
                "-----------------------------------------------------------------" +
                "----------------------------------------------------------------" +
                "----------------1-----------------------------------------------" +
                "-------------------------------------------------");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","100002");
        expectedResult.put("returnmsg","入库失败(业务单据表)");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
