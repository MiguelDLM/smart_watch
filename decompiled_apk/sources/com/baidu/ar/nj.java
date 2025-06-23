package com.baidu.ar;

import XIXIX.OOXIXo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class nj {

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, String str, String str2, float[] fArr, String str3);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onUploadProtobufResult(byte[] bArr, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:49:0x001b */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.baidu.ar.ihttp.IHttpResponse] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public void a(IHttpResponse iHttpResponse, b bVar, boolean z) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    iHttpResponse = iHttpResponse.getStream();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                }
            } catch (IOException e) {
                e = e;
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                iHttpResponse = 0;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = iHttpResponse.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    iHttpResponse.close();
                    if (byteArray != null && byteArray.length > 0) {
                        bVar.onUploadProtobufResult(byteArray, z);
                        byteArrayOutputStream.close();
                        iHttpResponse.close();
                    }
                    bVar.onUploadProtobufResult(null, z);
                    byteArrayOutputStream.close();
                    iHttpResponse.close();
                } catch (IOException e2) {
                    e = e2;
                    inputStream = iHttpResponse;
                    e.printStackTrace();
                    bVar.onUploadProtobufResult(null, z);
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                inputStream = iHttpResponse;
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                if (iHttpResponse != 0) {
                    iHttpResponse.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private String e(Map<String, Object> map) {
        String format;
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : map.keySet()) {
            if ((map.get(str) instanceof Float) || (map.get(str) instanceof Double)) {
                NumberFormat numberInstance = NumberFormat.getNumberInstance();
                numberInstance.setMaximumFractionDigits(5);
                numberInstance.setRoundingMode(RoundingMode.HALF_DOWN);
                format = new DecimalFormat("0.00000").format(Double.parseDouble(numberInstance.format(map.get(str))));
            } else {
                boolean z = map.get(str) instanceof Boolean;
                Object obj = map.get(str);
                if (z) {
                    format = ((Boolean) obj).booleanValue() ? "true" : "false";
                } else {
                    stringBuffer.append(obj);
                }
            }
            stringBuffer.append(format);
        }
        stringBuffer.append("313d1d593314c7bff96422b0f29432d9c50a");
        return kp.cp(stringBuffer.toString());
    }

    private TreeMap<String, Object> ig() {
        return new TreeMap<>(new Comparator<String>() { // from class: com.baidu.ar.nj.4
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
    }

    public void b(byte[] bArr, final b bVar) {
        ni.a(kw.hv(), bArr, new fa() { // from class: com.baidu.ar.nj.3
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                bVar.onUploadProtobufResult(null, false);
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                nj.this.a(iHttpResponse, bVar, false);
            }
        });
    }

    public void iQ() {
        ni.release();
    }

    public void a(byte[] bArr, final b bVar) {
        if (bVar == null) {
            return;
        }
        ni.a(kw.hy(), bArr, new fa() { // from class: com.baidu.ar.nj.2
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                bVar.onUploadProtobufResult(null, true);
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                nj.this.a(iHttpResponse, bVar, true);
            }
        });
    }

    public void a(double[] dArr, String str, int i, int i2, final a aVar) {
        double d;
        double d2;
        if (aVar == null) {
            return;
        }
        String hx = kw.hx();
        long currentTimeMillis = System.currentTimeMillis();
        TreeMap<String, Object> ig = ig();
        if (dArr == null) {
            d = OOXIXo.f3760XO;
            d2 = 0.0d;
        } else {
            d = dArr[0];
            d2 = dArr[1];
        }
        ig.put("lat", Double.valueOf(d));
        ig.put("lng", Double.valueOf(d2));
        ig.put("frame_width", String.valueOf(i));
        ig.put("frame_height", String.valueOf(i2));
        ig.put("phonetype", "Android_" + Build.MODEL);
        ig.put("timestamp", Long.valueOf(currentTimeMillis));
        ig.put("version", String.valueOf(kg.getVersionCode()));
        if (!TextUtils.isEmpty(str)) {
            ig.put("building_id", str);
        }
        ig.put("userid", TextUtils.isEmpty(mv.iB()) ? "default" : mv.iB());
        ig.put(HttpConstants.SIGN, e(ig).toUpperCase());
        ni.a(hx, new JSONObject(ig), new fa() { // from class: com.baidu.ar.nj.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                aVar.a(false, null, null, null, null);
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    nj.this.a(iHttpResponse.getContent(), aVar);
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar.a(false, "ar inner exception", null, null, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, a aVar) {
        String str2;
        float[] fArr;
        String string;
        boolean z;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("err_code") || jSONObject.getInt("err_code") == 0) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                str2 = (String) jSONObject2.get("session_id");
                if (jSONObject2.has(PixelReadParams.DEFAULT_FILTER_ID)) {
                    String[] split = jSONObject2.getString(PixelReadParams.DEFAULT_FILTER_ID).split(",");
                    float[] fArr2 = new float[split.length];
                    for (int i = 0; i < split.length; i++) {
                        fArr2[i] = Float.parseFloat(split[i]);
                    }
                    fArr = fArr2;
                } else {
                    fArr = null;
                }
                string = jSONObject2.has("conf") ? jSONObject2.getString("conf") : null;
                if (TextUtils.isEmpty(str2)) {
                    aVar.a(false, null, null, null, null);
                } else {
                    z = true;
                    str3 = "success";
                }
            } else {
                str3 = jSONObject.getString("err_msg");
                fArr = null;
                string = null;
                z = false;
                str2 = null;
            }
            aVar.a(z, str3, str2, fArr, string);
            return true;
        }
        return false;
    }
}
