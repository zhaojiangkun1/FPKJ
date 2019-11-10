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
public class Yfpdm {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    /**
     * 存在已开具的正数发票
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"异常开票"},description = "当开票类型为1时,只有原发票代码")
    public void  yfpdm() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","1");
        map.put("dj","6");
        map.put("spsl","-1");
        map.put("je","-6");
        map.put("sl","0.03");
        map.put("se","-0.18");
        map.put("yfpdm","150000456123");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","红冲必须传原发票号码和原发票代码");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "当开票类型为1时,只有原发票号码")
    public void  yfpdm1() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","1");
        map.put("dj","6");
        map.put("spsl","-1");
        map.put("je","-6");
        map.put("sl","0.03");
        map.put("se","-0.18");
        map.put("yfphm","20201329");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","红冲必须传原发票号码和原发票代码");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test(groups = {"异常开票"},description = "负数发票，原发票不存在")
    public void  yfpdm2() throws IOException,NoSuchAlgorithmException{
        map.put("kplx","1");
        map.put("dj","6");
        map.put("spsl","-1");
        map.put("je","-6");
        map.put("sl","0.03");
        map.put("se","-0.18");
        map.put("yfpdm","0300001002");
        map.put("yfphm","20201329");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","10001");
        expectedResult.put("returnmsg","原发票记录不存在");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

}
