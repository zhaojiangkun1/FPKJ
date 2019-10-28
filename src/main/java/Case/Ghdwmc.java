package Case;
import Bean.EnvNum;
import Bean.TestEnv;
import Config.UpdateFpqqlsh;
import Model.AcquireSubstr;
import Model.ActualResult;
import Model.Java2XML;
import Model.PostRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import javafx.geometry.Pos;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
public class Ghdwmc {
    JSONObject jsonObject = new JSONObject();
    HashMap<String,String> map = new HashMap();
    @Test(groups = {"正常开票"},description = "购货单位名称正常")
    public void  ghdwmc() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc","南京数族信息科技有限公司");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位名称为空")
    public void  ghdwmc1() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc","");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect4();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位名称为null")
    public void  ghdwmc2() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc",null);
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }
    @Test(groups = {"异常开票"},description = "购货单位名称输入特殊字符")
    public void  ghdwmc3() throws IOException,NoSuchAlgorithmException{
        map.put("ghdwmc","@#￥%&&");
        map.put("fpqqlsh",UpdateFpqqlsh.numbersLetters());
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        jsonObject = ActualResult.resultCorrect();
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject arrayObject = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(jsonObject,arrayObject);
    }

}
