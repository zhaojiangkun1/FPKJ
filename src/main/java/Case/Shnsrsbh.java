package Case;

import Bean.TestEnv;
import Model.AcquireSubstr;;
import Model.ExpectedResult;
import Model.Java2XML;
import Model.PostRequest;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Shnsrsbh {
    HashMap map = new HashMap();

    /**
     * 销方纳税人识别号和机身编号有关系
     * 如果机身编号且存在填了，则允许销方纳税人识别号为空，否则必须存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "销方纳税人识别号与机身编号同时为空")
    public void shnsrsbh1() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","");
        map.put("jsbh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        JSONObject expectedResult = new JSONObject();
        expectedResult.put("returncode","1000009");
        expectedResult.put("returnmsg","纳税人识别号对应商户不存在");
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    /**
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "销方纳税人识别号与机身编号中税号不一致")
    public void shnsrsbh2() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","000012312312312");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        JSONObject expectedResult = new JSONObject();
        expectedResult.put("returncode","1000052");
        expectedResult.put("returnmsg","机身编号中的税号与传入的纳税人识别号不一致");
        String result = PostRequest.zhenPiaoYunRequest(file, TestEnv.testEnv);
        System.out.println(result);
        JSONObject actaulResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actaulResult,expectedResult);
    }

    @Test(groups = {"正常开票"},description = "机身编号存在，但是销方纳税人识别号为空")
    public void shnsrsbh3() throws IOException, NoSuchAlgorithmException {
        map.put("shnsrsbh","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文:"+file);
        JSONObject expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


}
