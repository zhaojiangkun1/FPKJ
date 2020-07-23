package com.shuzutech.testCase.Invoice;


import com.shuzutech.bean.InvoiceParamters;
import com.shuzutech.bean.TestEnv;
import com.shuzutech.config.UpdateFpqqlsh;
import com.shuzutech.model.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;


public class DianPiao {
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
     * 合力中税：此错误信息：税控设备写发票明细时异常  DiskErr:092400，19999；冲红过的发票再次冲红
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */

    /**
     * threadPoolSize = 3,invocationCount = 3
     * 91320594346148467C
     * 91320594MA1MECA285
     * 110101201707010064
     * 110101201707010043
     * 110101201707010041
     * 500102010001408
     * 110101201707010037
     * 110101201707010064~~499000152528
     * 如果只传商品名称，该商品在商品列表中已经添加了商品，则开票成功
     * invocationCount = 10
     * threadPoolSize = 3
     * 三个线程同时执行，共执行10次
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */


    @Test(groups = {"开具电票"}, description = "所有参数都正常，开具一张电票")
    public void dianPiao_0001() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        map.put("ghdwmc", "上海盛付通电子支付服务有限公司");
        map.put("ghdwsbh", "9131011567624841X0");
        map.put("ghdwdzdh", "");
        map.put("ghdwyhzh", "");
        map.put("spmc", "智能空气品质控制器 KF-700RM(RPM+Malino)");
        map.put("spbm","1090416990000000000");
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXMLDoc(map), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }


    @Test(groups = {"开具电票"}, description = "所有参数均正常,开具一张6行商品的电票")
    public void multiGroupDianPiao_0004() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 6);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开具电票"}, description = "所有参数均正常，开具一张8行商品的电票")
    public void multiGroupDianPiao_0005() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 8);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开票电票"}, description = "所有参数均正常,开具一张9行商品的电票")
    public void multiGroupDianPiao_0006() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String file = Java2XML.BuildXMLDoc(map, 9);
        String result = PostRequest.zhenPiaoYunRequest(file,TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }

    @Test(groups = {"开具电票"},description = "开具一张带折扣行的电票")
    public void discountDianPiao() throws IOException, NoSuchAlgorithmException, InterruptedException {
        HashMap<String, String> map = InvoiceParamters.hashMap("026");
        ArrayList<GroupModel> groupModels = new ArrayList<>();
        GroupModel groupModel = new GroupModel("2", "1", "20", "20", "0.03", "0.6");
        GroupModel groupModel1 = new GroupModel("1", "", "", "-10", "0.03", "-0.3");
        groupModels.add(groupModel);
        groupModels.add(groupModel1);
        String fpqqlsh = UpdateFpqqlsh.generateFpqqlsh();
        map.put("fpqqlsh", fpqqlsh);
        String result = PostRequest.zhenPiaoYunRequest(Java2XML.BuildXmlDoc(map,groupModels), TestEnv.testEnv);
        GongYouFangFa.zpy(map,result);
    }


}
