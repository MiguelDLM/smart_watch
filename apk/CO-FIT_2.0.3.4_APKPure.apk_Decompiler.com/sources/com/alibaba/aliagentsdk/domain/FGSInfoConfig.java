package com.alibaba.aliagentsdk.domain;

import II0XooXoX.X0o0xo;
import II0XooXoX.XO;
import II0XooXoX.oIX0oI;
import II0XooXoX.oxoX;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.text.II0XooXoX;
import org.json.JSONStringer;

public class FGSInfoConfig {
    private static final String TAG = "FGSInfoConfig";
    public static String sDeviceName;
    public static String sDeviceSecret;
    public static String sProductKey;
    public static String sTimeStamp;
    public static String sonce;

    public static byte[] fgs2Byte(String str, String str2, String str3, String str4, String str5) {
        byte[] oIX0oI2;
        StringBuilder sb;
        Log.d(TAG, "sonce==> " + str5 + " timeStamp ==> " + str4 + " productKey==> " + str3 + " deviceSecret ==> " + str2);
        int i = X0o0xo.f12oIX0oI;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deviceName ==> ");
        sb2.append(str);
        XO.II0xO0("DataUtils", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("deviceSecret ==> ");
        sb3.append(str2);
        XO.II0xO0("DataUtils", sb3.toString());
        XO.II0xO0("DataUtils", "productKey ==> " + str3);
        XO.II0xO0("DataUtils", "timestamp ==> " + str4);
        XO.II0xO0("DataUtils", "sonce ==> " + str5);
        byte[] bArr = null;
        try {
            if (TextUtils.isEmpty(str5)) {
                XO.II0xO0("DataUtils", "r1(sonce)为空，启用固定值测试");
                Log.d("DataUtils", "secretKey: " + II0XooXoX.f19271oIX0oI);
                oIX0oI2 = II0XooXoX.f19271oIX0oI.getBytes("UTF-8");
                String encodeHexString = Hex.encodeHexString(oIX0oI2);
                Log.d("DataUtils", "secretKey hex: " + encodeHexString);
                str2 = "103e325c29ea5368ed421b75f07bdd49";
                sb = new StringBuilder();
                sb.append("ds明文 ：");
            } else {
                oIX0oI2 = oIX0oI.oIX0oI(str5, str4, str3);
                String encodeHexString2 = Hex.encodeHexString(oIX0oI2);
                Log.d("DataUtils", "secretKey hex: " + encodeHexString2);
                sb = new StringBuilder();
                sb.append("ds明文 ：");
            }
            sb.append(str2);
            Log.d("DataUtils", sb.toString());
            byte[] bytes = str2.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(oIX0oI2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
            bArr = instance.doFinal(bytes);
            String encodeHexString3 = Hex.encodeHexString(bArr);
            PrintStream printStream = System.out;
            printStream.println("ds密文 Hex: " + encodeHexString3);
        } catch (Exception e) {
            Log.d("DataUtils", "加密失败，明文：" + str2);
            e.printStackTrace();
        }
        String oIX0oI3 = oxoX.oIX0oI(bArr);
        Log.d(TAG, "DS密文并进行了base64编码：" + oIX0oI3);
        return X0o0xo.II0xO0(Sid.FGS, new JSONStringer().object().key("msg_type").value("FGS_MSG_TYPE_DS_DOWNLOAD_REQ").key("code").value(200).key("deviceSecret").value(oIX0oI3).key("message").value("success").key("sidver").value(1).endObject().toString());
    }
}
