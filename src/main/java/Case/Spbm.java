package Case;
import Bean.*;
import Model.*;
import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
public class Spbm {
    JSONObject expectedResult = new JSONObject();
    HashMap<String,String> map = new HashMap();

    /**
     * 商品：如果该商户在老板通上配置了默认商品，则不传商品，取老板通上默认商品，否则报错
     * 商品编码相关节点应该全部存在或不存在
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Test(groups = {"异常开票"},description = "存在商品信息，但是商品编码为空")
    public void  spbm1() throws IOException,NoSuchAlgorithmException{
        map.put("spbm","");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","300089");
        expectedResult.put("returnmsg","商品编码相关节点应该全部存在或不存在");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test(groups = {"异常开票"},description = "传入商品编码在局端不存在")
    public void  spbm2() throws IOException,NoSuchAlgorithmException{
        map.put("spbm","84796000");
        String file = Java2XML.BuildXMLDoc(map);
        System.out.println("本次请求的报文为:"+file);
        expectedResult.put("returncode","300091");
        expectedResult.put("returnmsg","传入商品编码在局端不存在");
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        System.out.println(result);
        JSONObject actualResult = AcquireSubstr.analyzeString(result);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test(groups = {"正常开票"},description = "该商户在老板通上存在默认商品，只传商品金额等信息，不传商品名称及商品编码")
    public void spbm3() throws IOException, NoSuchAlgorithmException {
      map.put("spmc","");
      map.put("spsl","1");
      map.put("dj","6.3");
      map.put("je","6.3");
      map.put("sl","0");
      map.put("se","0");
      map.put("spbm","");
      String file = Java2XML.BuildXMLDoc(map);
      System.out.println("本次请求的报文:"+file);
      expectedResult = ExpectedResult.resultCorrect();
      String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
      System.out.println(result);
      JSONObject actualResult = AcquireSubstr.analyzeString(result);
      Assert.assertEquals(actualResult,expectedResult);
    }

}
