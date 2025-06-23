package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ads.ed;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.utils.ax;
import com.huawei.openalliance.ad.utils.bh;
import com.huawei.openalliance.ad.utils.w;
import java.io.Closeable;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class b {
    private static final String B = ".pps.apiprovider";
    private static final String C = ".pps.innerapiprovider";
    private static final String Code = "ApiCallManager";
    private static b V = null;
    private static final String Z = "content";
    private volatile Uri L;

    /* renamed from: a, reason: collision with root package name */
    private Context f17402a;
    private static final byte[] I = new byte[0];
    private static final String S = "com.huawei.hwid.pps.apiprovider";
    private static final String F = "/pps/api/call";
    private static final Uri D = new Uri.Builder().scheme("content").authority(S).path(F).build();

    private b(Context context) {
        this.f17402a = context.getApplicationContext();
    }

    private Uri Code(boolean z) {
        if (z) {
            return D;
        }
        int t = ed.Code(this.f17402a).t();
        fb.V(Code, "ads selection:" + t);
        if (w.V(this.f17402a) && (t == 0 || t == 2)) {
            return D;
        }
        if (!w.I()) {
            return D;
        }
        if (this.L == null) {
            this.L = new Uri.Builder().scheme("content").authority(this.f17402a.getPackageName() + C).path(F).build();
        }
        return this.L;
    }

    public <T> CallResult<T> Code(String str, String str2, Class<T> cls) {
        return Code(str, str2, cls, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> CallResult<T> Code(String str, String str2, Class<T> cls, boolean z) {
        String message;
        Uri Code2;
        CallResult<T> callResult = (CallResult<T>) new CallResult();
        Cursor cursor = null;
        try {
            try {
                try {
                    Code2 = Code(z);
                } catch (IllegalArgumentException e) {
                    fb.I(Code, "callRemote IllegalArgumentException");
                    callResult.setCode(-1);
                    message = e.getMessage();
                    callResult.setMsg(message);
                    ax.Code(cursor);
                    fb.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                    return callResult;
                }
            } catch (Throwable th) {
                fb.I(Code, "callRemote " + th.getClass().getSimpleName());
                callResult.setCode(-1);
                message = th.getMessage();
                callResult.setMsg(message);
                ax.Code(cursor);
                fb.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                return callResult;
            }
            if (!w.Code(this.f17402a, Code2)) {
                fb.I(Code, "uri invalid");
                callResult.setCode(-1);
                ax.Code((Closeable) null);
                return callResult;
            }
            fb.V(Code, "call remote method: %s", str);
            if (fb.Code()) {
                fb.Code(Code, "paramContent: %s", bh.Code(str2));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdk_version", "13.4.72.300");
            jSONObject.put("content", str2);
            cursor = this.f17402a.getContentResolver().query(Code2, null, null, new String[]{str, jSONObject.toString()}, null);
            if (cursor != null && cursor.moveToFirst()) {
                int i = cursor.getInt(cursor.getColumnIndexOrThrow("code"));
                callResult.setCode(i);
                String string = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                fb.Code(Code, "call: %s code: %s result: %s", str, Integer.valueOf(i), string);
                if (i == 200) {
                    callResult.setData(i.Code(string, cls));
                } else {
                    callResult.setMsg(string);
                }
            }
            ax.Code(cursor);
            fb.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
            return callResult;
        } catch (Throwable th2) {
            ax.Code((Closeable) null);
            throw th2;
        }
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new b(context);
                }
                bVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
