package com.lfm.wms.core.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author lfm
 * @date 2019/12/11 - 9:04
 */
public class test {
    public static void main(String []ages ){
        //加密方式
        String hashAlgorithmName = "md5";
        //原密码
        String credentials = "1234567";
        //加密次数
        int hashIterations = 1024;
        //加密盐值，大家可以用生成字符串的方法
        String hash = "wxKYXuTPST5SG0jMQzVPsg==";
        ByteSource credentialsSalt = ByteSource.Util.bytes(hash);
        String password = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations).toHex();
        System.out.println(password);
    }


}
