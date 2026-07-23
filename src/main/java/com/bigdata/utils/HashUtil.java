package com.bigdata.utils;

import java.security.MessageDigest;

/**
 * hash工具
 */
public class HashUtil {
    /**
     * md5消息摘要算法，参数为byte[]
     */
    public static String md5(byte[] data) throws Exception {
        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 执行摘要方法
        byte[] digest = md.digest(data);
        return bytes2HexStr(digest);
    }

    /**
     * md5消息摘要算法，参数为String
     */
    public static String md5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes());
        byte[] digest = md.digest();
        return bytes2HexStr(digest);
    }

    /**
     * SHA-1消息摘要算法
     */
    public static String sha1Bytes(byte[] data) throws Exception {
        // 初始化MessageDigest,SHA即SHA-1的简称
        MessageDigest md = MessageDigest.getInstance("SHA");
        // 执行摘要方法
        byte[] digest = md.digest(data);
        return bytes2HexStr(digest);
        // return new HexBinaryAdapter().marshal(digest);
    }

    /**
     * SHA-256消息摘要算法
     */
    public static String sha256Bytes(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(data);
        return bytes2HexStr(digest);
        // return new HexBinaryAdapter().marshal(digest);
    }

    /**
     * SHA-256消息摘要算法
     */
    public static String sha256String(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytes2HexStr(md.digest());
        // return new HexBinaryAdapter().marshal(md.digest());
    }

    /**
     * SHA-384消息摘要算法
     */
    public static String sha384Bytes(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-384");
        byte[] digest = md.digest(data);
        return bytes2HexStr(digest);
        // return new HexBinaryAdapter().marshal(digest);
    }

    /**
     * SHA-512消息摘要算法
     */
    public static String sha512Bytes(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] digest = md.digest(data);
        return bytes2HexStr(digest);
        // return new HexBinaryAdapter().marshal(digest);
    }

    /**
     * 将字节数组转成16进制数字
     **/
    public static String bytes2HexStr(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) {
            result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    /**
     * SHA-512消息摘要算法. 参数是16进制字节码：1a44b9f2 。
     */
    public static String sha256HexString(String data) throws Exception {
        byte[] hex_arr = hexStr2HexBytes(data);
        String result = sha256Bytes(hex_arr);
        return result;
    }

    /**
     * 将16进制数字的字符串，按照每两位一个字节转成字节数组。例如：123456 → byte[] ={0x12,0x34,0x56}
     **/
    public static byte[] hexStr2HexBytes(String strHex) {
        if (null == strHex || 0 == strHex.length()) {
            return null;
        }
        strHex = (strHex.length() == 1) ? "0" + strHex : strHex;
        byte[] arr = new byte[strHex.length() / 2];
        byte[] tmp = strHex.getBytes();
        for (int i = 0; i < (tmp.length / 2); i++) {
            arr[i] = unitBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return arr;
    }

    public static byte unitBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

    /**
     * 将16进制字符串大小端颠倒排序，例如： 字符串 123456 → 563412
     **/
    public static String hexStrReverse(String str) {
        int length = str.length();
        String[] arr = new String[str.length() / 2];
        int j = 0;
        for (int i = length; i > 1; i = i - 2) {
            arr[j] = str.substring(i - 2, i);
            j++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

}
