package Case;
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
public class Yhlx {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    @Test(groups = {"正常开票"},description = "yhlx用户类型为空")
    public void  yhlx() throws IOException,NoSuchAlgorithmException{
        map.put("yhlx","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","yhlx:参数错误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     * 用户类型为3，也默认开票成功（电子发票）,也就是当用户类型不存在，则怀疑是取了扫码台的发票配置
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "用户类型3")
    public void  yhlx3() throws IOException,NoSuchAlgorithmException{
        map.put("yhlx","3");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","yhlx:参数错误");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
}


