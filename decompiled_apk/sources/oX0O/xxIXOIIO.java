package oX0O;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static xxIXOIIO f32103II0XooXoX = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f32104Oxx0IOOO = "skin-user-theme-json";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f32105X0o0xo = "skin-name";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f32106XO = "skin-strategy";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f32107oxoX = "meta-data";

    /* renamed from: I0Io, reason: collision with root package name */
    public final SharedPreferences.Editor f32108I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final SharedPreferences f32109II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Context f32110oIX0oI;

    public xxIXOIIO(Context context) {
        this.f32110oIX0oI = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f32107oxoX, 0);
        this.f32109II0xO0 = sharedPreferences;
        this.f32108I0Io = sharedPreferences.edit();
    }

    public static xxIXOIIO II0xO0() {
        return f32103II0XooXoX;
    }

    public static void XO(Context context) {
        if (f32103II0XooXoX == null) {
            synchronized (xxIXOIIO.class) {
                try {
                    if (f32103II0XooXoX == null) {
                        f32103II0XooXoX = new xxIXOIIO(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
    }

    public String I0Io() {
        return this.f32109II0xO0.getString(f32105X0o0xo, "");
    }

    public xxIXOIIO II0XooXoX(int i) {
        this.f32108I0Io.putInt(f32106XO, i);
        return this;
    }

    public xxIXOIIO Oxx0IOOO(String str) {
        this.f32108I0Io.putString(f32105X0o0xo, str);
        return this;
    }

    public String X0o0xo() {
        return this.f32109II0xO0.getString(f32104Oxx0IOOO, "");
    }

    public void oIX0oI() {
        this.f32108I0Io.apply();
    }

    public int oxoX() {
        return this.f32109II0xO0.getInt(f32106XO, -1);
    }

    public xxIXOIIO xxIXOIIO(String str) {
        this.f32108I0Io.putString(f32104Oxx0IOOO, str);
        return this;
    }
}
