package Case;

import Bean.InvoiceCase;
import Config.GetInvoiceCase;
import Model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class DianPiao {
    HashMap<String,String> map = new HashMap<>();

    /**
     * 不传商品编码 商品名称，只传金额等值，优先读取注册商户时传的默认商品，
     * 如果注册时未设置，则读取接口设置的默认商品，
     * 若接口也未设置默认商品、
     * ，则报错：<returncode>1000023</returncode><returnmsg>设备:未配置默认商品</returnmsg>
     *
     * 1.旋极平台：优先读取扫码台默认商品，若无，调接口查询，查默认商品，若无，报错
     * 2.广东、许继等平台，优先读取扫码台默认商品，若无，则读取数据库中默认商品，若无，报错
     *
     *
     * 默认商品，只传金额即可，税率 商品名称，单价，(根据商品名称去判断，所以商品名称保留为空即可)
     *商品名称为空 税率、税额等值取得也是默认商品，只传金额
     * 总结：广东、许继  直接开票，把手机号、邮箱传给广东、许继，短信和邮箱是他们发，自助开票，如果同时填了手机号和邮箱，则把手机号传过去，此时邮箱我们来发
     *宁波短信自己发
     *
     * 合力中税："税率为0%，零税率标识不能为空_FyxmN1"   零税率标识必须要填，如果税率为0的时候
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    /**
     * 110101201707010064
     * 如果只传商品名称，该商品在商品列表中已经添加了商品，则开票成功
     * invocationCount = 10
     * threadPoolSize = 3
     * 三个线程同时执行，共执行10次
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    @Test(groups = {"开具电票"},description = "所有参数都正常，开具一张电票")
    public void dianPiao_0001() throws IOException, NoSuchAlgorithmException {
        map.put("fplxdm","026");
        map.put("jsbh","");
        map.put("shnsrsbh","110101201707010043");
        map.put("fpqqlsh","mB16220200426111010");
//        map.put("spbm","");
        map.put("sprsjh","13701476279");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0001");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
//        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test(groups = {"自助开票"},description = "所有参数都正常，自助开票")
    public void ziZhuKaiPiao_0002() throws IOException, NoSuchAlgorithmException {
//        map.put("jsbh","");
//        map.put("shnsrsbh","110101201707010043");
        map.put("fplxdm","026");
        map.put("yhlx","1");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0002");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"电票冲红"},description = "所有参数均正常，开具一张负数发票")
    public void dianPiaoChongHong_0003() throws IOException, NoSuchAlgorithmException {
//        map.put("jsbh","");
//        map.put("shnsrsbh","110101201707010064");
        map.put("fplxdm","026");
        map.put("kplx","1");
        map.put("spsl","-1.0");
        map.put("dj","282.075472");
        map.put("je","-282.08");
        map.put("sl","0.06");
        map.put("se","-16.92");
        map.put("yfpdm","050003521107");
        map.put("yfphm","95766950");
//        map.put("sprsjh","13701476279");
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0003");
        GongYouFangFa.gongYouFangFa(Java2XML.BuildXMLDoc(map),invoiceCase);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常,开具一张6行商品的电票")
    public void multiGroupDianPiao_0004() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",6);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0004");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常，开具一张8行商品的电票")
    public void multiGroupDianPiao_0005() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",8);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0005");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

    @Test(groups = {"多行电票开具"},description = "所有参数均正常,开具一张9行商品的电票")
    public void multiGroupDianPiao_0006() throws IOException, NoSuchAlgorithmException {
        String file = MultiLineGroup.multiLineGroup("026",9);
        InvoiceCase invoiceCase = GetInvoiceCase.getInvoiceCase("dianPiao_0006");
        GongYouFangFa.gongYouFangFa(file,invoiceCase);
    }

}
