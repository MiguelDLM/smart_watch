package com.baidu.ar;

import XIXIX.OOXIXo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class lt implements lq {
    private lv EW;
    private z EX;
    private HandlerThread nN;
    private Handler nO;

    /* loaded from: classes7.dex */
    public static class a extends Handler {
        private lq EZ;

        public a(Looper looper, lq lqVar) {
            super(looper);
            this.EZ = lqVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.EZ.handleMessage(message);
        }
    }

    public lt() {
        HandlerThread handlerThread = new HandlerThread("VpasController");
        this.nN = handlerThread;
        handlerThread.start();
        this.nO = new a(this.nN.getLooper(), this);
    }

    private void cw(String str) {
        lu.a(kw.hu(), cx(str), new fa() { // from class: com.baidu.ar.lt.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    String content = iHttpResponse.getContent();
                    if (TextUtils.isEmpty(content)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(content);
                    if (jSONObject.getInt("err_code") != 0) {
                        jSONObject.getString("err_msg");
                        if (lt.this.EW != null) {
                            lt.this.EW.a(false, null);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    String str2 = (String) jSONObject2.get("session_id");
                    if (jSONObject2.has("srt")) {
                        JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("srt"));
                        if (jSONObject3.has("scale")) {
                            double d = jSONObject3.getDouble("scale");
                            if (lt.this.EW != null) {
                                lt.this.EW.f((float) d);
                            }
                        }
                        if (jSONObject3.has("rotation")) {
                            JSONArray jSONArray = jSONObject3.getJSONArray("rotation");
                            float[] fArr = new float[jSONArray.length()];
                            for (int i = 0; i < jSONArray.length(); i++) {
                                fArr[i] = (float) jSONArray.getDouble(i);
                                Log.e("rotation", fArr[i] + "");
                            }
                            if (lt.this.EW != null) {
                                lt.this.EW.m(fArr);
                            }
                        }
                        if (jSONObject3.has("translation")) {
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("translation");
                            float[] fArr2 = new float[jSONArray2.length()];
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                fArr2[i2] = (float) jSONArray2.getDouble(i2);
                                Log.e("translation", fArr2[i2] + "");
                            }
                            if (lt.this.EW != null) {
                                lt.this.EW.n(fArr2);
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str2) && lt.this.EW != null) {
                        lt.this.EW.a(false, null);
                    }
                    if (lt.this.EW != null) {
                        lt.this.EW.a(true, str2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (lt.this.EW != null) {
                        lt.this.EW.a(false, null);
                    }
                }
            }
        });
    }

    private JSONObject cx(String str) {
        double d;
        double d2;
        long currentTimeMillis = System.currentTimeMillis();
        TreeMap ig = ig();
        z zVar = this.EX;
        if (zVar == null || zVar.az() == null) {
            d = OOXIXo.f3760XO;
            d2 = 0.0d;
        } else {
            d = this.EX.az()[0];
            d2 = this.EX.az()[1];
        }
        ig.put("lat", Double.valueOf(d));
        ig.put("lng", Double.valueOf(d2));
        ig.put("timestamp", Long.valueOf(currentTimeMillis));
        ig.put("ar_key", Long.valueOf(Long.parseLong(str)));
        ig.put("app_id", Integer.valueOf(Integer.parseInt(DuMixARConfig.getAipAppId())));
        String d3 = lw.d(ig);
        ig.put(HttpConstants.SIGN, d3.toUpperCase());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", d);
            jSONObject.put("lng", d2);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("ar_key", Long.parseLong(str));
            jSONObject.put("app_id", Integer.parseInt(DuMixARConfig.getAipAppId()));
            jSONObject.put(HttpConstants.SIGN, d3.toUpperCase());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static TreeMap ig() {
        return new TreeMap(new Comparator<String>() { // from class: com.baidu.ar.lt.2
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
    }

    public void cv(String str) {
        Handler handler = this.nO;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1001, str));
        }
    }

    @Override // com.baidu.ar.lq
    public void handleMessage(Message message) {
        Object obj;
        int i = message.what;
        if (i != 1001) {
            if (i == 1002 && (obj = message.obj) != null) {
                q((byte[]) obj);
                return;
            }
            return;
        }
        Object obj2 = message.obj;
        if (obj2 != null) {
            cw((String) obj2);
        }
    }

    public void q(byte[] bArr) {
        lu.b(new fa() { // from class: com.baidu.ar.lt.3
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                Log.e("response trackFrame err", "" + httpException.getMessage());
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                try {
                    if (lt.this.EW == null) {
                        return;
                    }
                    InputStream stream = iHttpResponse.getStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = stream.read(bArr2);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            stream.close();
                            lt.this.EW.o(byteArray);
                            return;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, bArr);
    }

    public void a(lv lvVar, z zVar) {
        this.EW = lvVar;
        this.EX = zVar;
    }
}
