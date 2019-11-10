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
public class Yhzcbs {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();


    @Test(groups = {"正常开票"},description = "优惠政策标识为0,不使用优惠政策")
    public void  yhzcbs1() throws IOException,NoSuchAlgorithmException{
        map.put("yhzcbs","0");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"正常开票"},description = "优惠政策标识为1,增值税特殊管理为免税")
    public void  yhzcbs2() throws IOException,NoSuchAlgorithmException{
        map.put("yhzcbs","1");
        map.put("zzstsgl","免税");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult = ExpectedResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "优惠政策标识含特殊字符")
    public void  yhzcbs3() throws IOException,NoSuchAlgorithmException{
        //入库失败(业务单据明细表)
        map.put("yhzcbs","$%$%$$%%$$%");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","100002");
        expectedResult.put("returnmsg","入库失败(业务单据明细表)");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
}
