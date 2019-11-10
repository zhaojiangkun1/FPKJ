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

public class Jsbh {

    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    /**
     * 机身编号为空的话。如果纳税人识别号是正常，会从识别号找设备。
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"正常开票"},description = "机身编号为空")
    public void jsbh() throws IOException,NoSuchAlgorithmException{
        map.put("jsbh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     * 同上
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"异常开票"},description = "机身编号为null")
    public void jsbh2() throws IOException,NoSuchAlgorithmException{
        map.put("jsbh",null);
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     * 机身编号格式不正确
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "开票终端标识~~纳税人标号")
    public void jsbh3() throws IOException,NoSuchAlgorithmException{
        map.put("jsbh","A10016420000196~~110101201707010037");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","1000052");
        expectedResult.put("returnmsg","机身编号中的税号与传入的纳税人识别号不一致");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
