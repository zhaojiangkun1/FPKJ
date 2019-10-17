package Config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Md5 {
     /**利用MD5进行加密*/
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
//        BASE64Encoder base64en = new BASE64Encoder();
//        String encodeStr=DigestUtils.md5Hex(str);
//        String newstr = base64en.encode();
            //加密后的字符串
//        String newstr= Base64.encode(md5.digest(str.getBytes("utf-8")));

            md5.update(str.getBytes("utf-8"));
            byte[] b = md5.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                int v = (int) b[i];
                v = v < 0 ? 0x100 + v : v;
                String cc = Integer.toHexString(v);
                if (cc.length() == 1)
                    sb.append('0');
                sb.append(cc);
            }
//            System.out.println("MD5:" + sb.toString());
            String encodeToString = Base64.getEncoder().encodeToString(sb.toString().getBytes("utf-8"));
            return encodeToString;

    }
    
    /**判断用户密码是否正确
     *newpasswd  用户输入的密码
     *oldpasswd  正确密码*/
    public static boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?><business id=\"FPKJ\"><body><input><fpqqlsh>12420190918165817</fpqqlsh><shnsrsbh>110101201707010057</shnsrsbh><jsbh>110101201707010057~~499000152456</jsbh><fplxdm>026</fplxdm><kplx>0</kplx><yhlx>0</yhlx><ghdwsbh>91310114MA1GU3NU72</ghdwsbh><ghdwmc>上海融族网络科技有限公司</ghdwmc><ghdwdzdh>上海市浦东新区康威路1500号3幢1层103室02158958286</ghdwdzdh><ghdwyhzh>中国建设银行股份有限公司上海张江支行31050161393600001918</ghdwyhzh><fyxm count=\"1\"><group xh=\"1\"><fphxz>0</fphxz><spmc>技术服务费</spmc><ggxh>W6900</ggxh><dw>套</dw><spsl>1</spsl><dj>86</dj><je>86</je><sl>0</sl><se>0</se><spbm>3040205000000000000</spbm><zxbm/><yhzcbs>0</yhzcbs><lslbs/><zzstsgl/></group></fyxm><extParam>storeId=1000001,operatorId=1007045</extParam><bz/><skr/><fhr/><kpr>管理员</kpr><yfpdm/><yfphm/><sprsjh>zhaokun@shuzutech.com</sprsjh></input></body></business>";
        try {
            System.out.println(Md5.EncoderByMd5(str+"2019-10-10 11:50:56"+"788c8f7c1cfec68065e007ea8301b56b"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
