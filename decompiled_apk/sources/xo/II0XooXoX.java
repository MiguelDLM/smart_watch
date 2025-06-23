package xo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes13.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static II0XooXoX f34902I0Io = null;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f34903II0XooXoX = "KEY_WIDEVINE_ID";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f34904II0xO0 = "II0XooXoX";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f34905Oxx0IOOO = "KEY_ANDROID_ID";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f34906X0o0xo = "KEY_IMEI";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f34907XO = "KEY_CLIENT_ID";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f34908oxoX = "KEY_OAID";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f34909xxIXOIIO = "KEY_PSEUDO_ID";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public SharedPreferences f34910oIX0oI;

    /* loaded from: classes13.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f34912Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f34913XO;

        public oIX0oI(String str, String str2) {
            this.f34913XO = str;
            this.f34912Oo = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences.Editor edit = II0XooXoX.this.f34910oIX0oI.edit();
                edit.putString(this.f34913XO, this.f34912Oo);
                edit.apply();
            } catch (Exception unused) {
                Log.e(II0XooXoX.f34904II0xO0, "putString异常 key" + this.f34913XO + " value:" + this.f34912Oo);
            }
        }
    }

    public II0XooXoX(Context context) {
        this.f34910oIX0oI = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static II0XooXoX I0Io(Context context) {
        if (f34902I0Io == null) {
            synchronized (II0XooXoX.class) {
                try {
                    if (f34902I0Io == null) {
                        f34902I0Io = new II0XooXoX(context);
                    }
                } finally {
                }
            }
        }
        return f34902I0Io;
    }

    public void X0o0xo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            XO(str, str2);
            return;
        }
        Log.e("putId", "key:" + str + " v" + str2 + " 过程有key或value为空，终止");
    }

    public void XO(String str, String str2) {
        oOoXoXO.II0xO0(new oIX0oI(str, str2));
    }

    public String oxoX(String str) {
        try {
            return this.f34910oIX0oI.getString(str, "");
        } catch (Exception unused) {
            Log.e(f34904II0xO0, "getString异常 key:" + str);
            return "";
        }
    }
}
