package com.shuzutech.bean;

import java.util.HashMap;

public class InvoiceParamters {
    /**
     * 91320191MA1ML4CL25~~661921253676
     *110101201707010041~~499000152131
     *110101201701010023~~499000150987
     *110101201707010043~~499000152157
     */
//    private static String shnsrsbh = "110101201701010023";
    private static String jsbh = "110101201707010041~~499000152131";


    public static String kpzdbs = "499000152131";
    public static String nsrsbh = "110101201707010041";
    public static String bwt_dzfplxdm = "026";
    public static String bwt_zpfplxdm = "007";
    public static String bwt_jpfplxdm = "025";
    public static String bwt_zzfplxdm = "004";

    public static String spbm = "1010101080000000000";
    public static String spmc = "黑麦";

    public static HashMap<String,String> hashMap(String fplxdm){
        HashMap<String, String> map = new HashMap<>();
        map.put("fplxdm", fplxdm);
        map.put("shnsrsbh", "");
        map.put("jsbh", InvoiceParamters.jsbh);
        return map;
    }
}
