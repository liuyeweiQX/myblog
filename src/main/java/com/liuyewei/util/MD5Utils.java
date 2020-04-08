package com.liuyewei.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: liuyewei
 * Date: 2020/1/11
 * Time: 7:12 下午
 * Description:
 */
public class MD5Utils {

    /**
     * MD5加密
     * @param str 要加密的字符串
     * @return    加密后的字符串
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for(int offset = 0; offset < byteDigest.length; offset++){
                i = byteDigest[offset];
                if(i < 0)
                    i += 256;
                if(i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            //16位加密
            //return buf.toString().sustring(8,24);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
}


