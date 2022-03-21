package Brilley.Chapter06;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

public class Hutools {
        static AES aes = SecureUtil.aes();
        public static void test1() {
            System.out.println("This Class is created by Hutools");
            String encry = aes.encryptHex("Brilley and Yanyan baobao!");
            System.out.println("The encrypted data is:");
            System.out.println(encry);
            String oo = aes.decryptStr(encry);
            System.out.println(oo);
        }
    }