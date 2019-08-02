package com.dousnl.aiways;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*******************************************************************************
 * AES加解密算法 2016.07.22
 *
 * @author aes 128位 cbc 算法 HTML的&lt;
 *         &gt;&amp;&quot;&copy;&nbsp;分别是<，>，&，"，©;空格的转义字符
 */
public class AESUtils {

    private final static Logger logger = LoggerFactory.getLogger(AESUtils.class);

    // 加密
    public static String Encrypt(String sSrc, String keyStr, String ivStr) throws Exception {

        if (StringUtils.isEmpty(keyStr)) {
            logger.error("没有传入AES加密的加密秘钥");
            return null;
        }

        if (StringUtils.isEmpty(ivStr)) {
            logger.error("没有传入AES CBC加密的加密向量");
            return null;
        }

        if (ivStr.length() != 16) {
            logger.error("AES加密的加密向量长度不是16位");
            return null;
        }

        SecretKeySpec skeySpec = new SecretKeySpec(keyStr.getBytes("UTF-8"), "AES");

        // "算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes("UTF-8"));

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));
        String str = new BASE64Encoder().encode(encrypted);
        // return str.replaceAll("\r", "").replaceAll("\n", "");
        return str.replaceAll(System.lineSeparator(), "");
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey, String ivStr) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                logger.error("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                logger.error("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(ivStr.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);// 先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original, "UTF-8");
                // originalString= unEscapeChar(originalString);
                return originalString;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return null;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */
        String cKey = "a2164ada0026ccf7";

        String cIv = "82c91325e74bef0f";

        // 需要加密的字串
        String cSrc = "{\"LastQueryTime\":\"2015-01-01 00:00:00\",\"PageNo\":1,\"PageSize\":10,\"a\":\"哈\"}";

        System.out.println(cSrc);
        // 加密
        long lStart = System.currentTimeMillis();
        String enString = AESUtils.Encrypt(cSrc, cKey, cIv);
        System.out.println(String.format("加密后的字符串是：%s", enString));
        //System.out.println("加密后的字串是：" + enString);

        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("加密耗时：" + lUseTime + "毫秒");
        // 解密
        lStart = System.currentTimeMillis();
        // AESUtil.Decrypt("DHVWF+8xRIfU7nUCNQdLaGF15VaMZWtNcwaqeumUPe/ok9zgSkR0pbOJUmYYQs7ZFMN7GhLB1ywEN3kb1gH4z+Mc2Z4rQe8Xa42LrmkDRvwwosmVMuR+mbLFCG+Xf5unkRO6JJx1PiTAxAB6oyWqUmbOKskK81LqpWBU5fKnBZwXo3jv2hnKItwCODYw+B+Pg+0IzZ5ye5cKcwz99NO5//H2gU0scZhn+rl8Jcktbm42TVklnxdzG/aw200H2z9ugpB1q2X0sGAi55SQH3DbLpWb5oQE5vy0As7lje4e+4dE8vbLIR0dMw8/lA9cBPYRO2WOkH6SFwFUyi+IishP8j+mzEcfoyAOIUSh5G/5VYqlYu1zlVUsYCHWu7MTE1Gr55SicHZQxl5KHgmgFBw8OQl8DerA++D8vswR8eiRNcXR2MQmNXYarCmZ7Kuc6mRSbrSk2cImOZAywVIo6MpBSu/u0BINysS3S7Ni1LB6zqAu3Ly0yNbbxzz+ZpHjmAM+MMsx4/K6LtG1rhiW8iE3bbGOLJqu9njLFVLQtKXrVsUnF4b1FWuIADG3FBCXqcdyTTTj5vNwI2xxFm/zq5lvJUKUlcFPvYSwBQFsjKHZnl8=",
        // cKey);
        String DeString = AESUtils.Decrypt(enString, cKey, cIv);
        System.out.println("解密后的字串是：" + DeString);
        lUseTime = System.currentTimeMillis() - lStart;
        System.out.println("解密耗时：" + lUseTime + "毫秒");
    }
}
