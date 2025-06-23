package com.huawei.openalliance.ad.msgnotify;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ar;
import com.huawei.openalliance.ad.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class b {
    private static final String Code = "MessageNotifyManager";

    private static Object Code() {
        try {
            return ar.Code(null, Class.forName("com.huawei.openalliance.ad.ppskit.msgnotify.PersistentMessageCenter"), "getInstance", null, null);
        } catch (Throwable unused) {
            fb.V(Code, "get inner msg notify");
            return a.Code();
        }
    }

    private static void I(Context context, String str) {
        fb.V(Code, "unregisterAllNotify via aidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(bb.v, str);
            jSONObject.putOpt(bb.x, x.aK);
            g.V(context).Code(s.g, jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fb.I(Code, "unregisterAllNotify " + e.getClass().getSimpleName());
        }
    }

    public static void V(Context context, String str) {
        fb.V(Code, "unregisterAllNotify via hard link");
        Object Code2 = Code();
        if (Code2 != null) {
            if (Code2 instanceof a) {
                ((a) Code2).Code(str);
            } else {
                ar.Code(Code2, Code2.getClass(), "unregisterAll", new Class[]{String.class, String.class}, new Object[]{context.getPackageName(), str});
            }
        }
    }

    public static void Code(Context context, String str) {
        I(context, str);
        if (w.B(context)) {
            return;
        }
        V(context, str);
    }

    private static void I(Context context, String str, final NotifyCallback notifyCallback) {
        fb.V(Code, "registerNotifyViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(bb.v, str);
            jSONObject.putOpt(bb.x, x.aJ);
            g.V(context).Code(s.g, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.msgnotify.b.1
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str2, CallResult<String> callResult) {
                    Intent Code2;
                    if (NotifyCallback.this == null || callResult == null || callResult.getCode() != 200 || (Code2 = c.Code(callResult.getData())) == null) {
                        return;
                    }
                    SafeIntent safeIntent = new SafeIntent(Code2);
                    String stringExtra = safeIntent.getStringExtra(bb.v);
                    fb.V(b.Code, "receive msg: " + stringExtra);
                    NotifyCallback.this.onMessageNotify(stringExtra, safeIntent);
                }
            }, String.class);
        } catch (JSONException e) {
            fb.Code(5, Code, "registerNotify ", e);
        }
    }

    public static void V(Context context, String str, NotifyCallback notifyCallback) {
        if (context == null || TextUtils.isEmpty(str) || notifyCallback == null) {
            fb.V(Code, "registerNotifyViaHardLink some param is empty");
            return;
        }
        fb.V(Code, "registerNotifyViaHardLink");
        Object Code2 = Code();
        if (Code2 != null) {
            if (Code2 instanceof a) {
                ((a) Code2).Code(str, notifyCallback);
            } else {
                ar.Code(Code2, Code2.getClass(), "registerNotifyCallbackFromSdk", new Class[]{String.class, String.class, Object.class}, new Object[]{context.getPackageName(), str, notifyCallback});
            }
        }
    }

    public static void Code(Context context, String str, Intent intent) {
        fb.V(Code, "notifyMessage via hard link");
        Object Code2 = Code();
        if (Code2 != null) {
            if (Code2 instanceof a) {
                ((a) Code2).Code(str, intent);
            } else {
                ar.Code(Code2, Code2.getClass(), "notifyMessage", new Class[]{String.class, String.class, Intent.class}, new Object[]{context.getPackageName(), str, intent});
            }
        }
    }

    public static void Code(Context context, String str, NotifyCallback notifyCallback) {
        I(context, str, notifyCallback);
    }

    public static void Code(Context context, String str, String str2, Intent intent) {
        if (!w.B(context)) {
            Code(context, str2, intent);
            return;
        }
        fb.V(Code, "notifyMessage via aidl");
        String Code2 = c.Code(str, str2, intent);
        if (TextUtils.isEmpty(Code2)) {
            return;
        }
        g.V(context).Code(s.h, Code2, null, null);
    }
}
