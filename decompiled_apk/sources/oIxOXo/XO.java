package oIxOXo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import oX0O.xoIox;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final String f31779OOXIXo = "color";

    /* renamed from: oO, reason: collision with root package name */
    public static XO f31780oO = new XO();

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final String f31781oOoXoXO = "drawable";

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f31782ooOOo0oXI = "drawableName";

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final String f31783x0XOIxOo = "drawablePathAndAngle";

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f31784xoIox = "type";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final String f31785xxIXOIIO = "SkinCompatUserThemeManager";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f31787II0XooXoX;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f31793oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final HashMap<String, oIX0oI> f31792oIX0oI = new HashMap<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Object f31788II0xO0 = new Object();

    /* renamed from: I0Io, reason: collision with root package name */
    public final WeakHashMap<Integer, WeakReference<ColorStateList>> f31786I0Io = new WeakHashMap<>();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final HashMap<String, String> f31790X0o0xo = new HashMap<>();

    /* renamed from: XO, reason: collision with root package name */
    public final Object f31791XO = new Object();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final WeakHashMap<Integer, WeakReference<Drawable>> f31789Oxx0IOOO = new WeakHashMap<>();

    public XO() {
        if (!oxoX.f31821II0XooXoX) {
            try {
                XxX0x0xxx();
            } catch (JSONException e) {
                this.f31792oIX0oI.clear();
                this.f31790X0o0xo.clear();
                if (xoIox.f32102oIX0oI) {
                    xoIox.II0xO0(f31785xxIXOIIO, "startLoadFromSharedPreferences error: " + e);
                }
            }
        }
    }

    public static boolean II0XooXoX(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            z = true;
        } else {
            z = false;
        }
        if (xoIox.f32102oIX0oI && !z) {
            xoIox.II0xO0(f31785xxIXOIIO, "Invalid drawable path : " + str);
        }
        return z;
    }

    public static XO x0XOIxOo() {
        return f31780oO;
    }

    public final void I0Io(@IXo.oxoX int i, ColorStateList colorStateList) {
        if (colorStateList != null) {
            synchronized (this.f31788II0xO0) {
                this.f31786I0Io.put(Integer.valueOf(i), new WeakReference<>(colorStateList));
            }
        }
    }

    public void II0xO0(@IXo.oxoX int i, oIX0oI oix0oi) {
        String xoXoI2 = xoXoI(i, "color");
        if (!TextUtils.isEmpty(xoXoI2) && oix0oi != null) {
            oix0oi.f31797II0xO0 = xoXoI2;
            this.f31792oIX0oI.put(xoXoI2, oix0oi);
            O0xOxO(i);
            this.f31793oxoX = false;
        }
    }

    public String IIXOooo(String str) {
        String str2 = this.f31790X0o0xo.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2.split(":")[0];
        }
        return "";
    }

    public oIX0oI IXxxXO(String str) {
        return this.f31792oIX0oI.get(str);
    }

    public final void O0xOxO(@IXo.oxoX int i) {
        synchronized (this.f31788II0xO0) {
            this.f31786I0Io.remove(Integer.valueOf(i));
        }
    }

    public void OOXIXo() {
        this.f31792oIX0oI.clear();
        xoIox();
        this.f31793oxoX = true;
        Oxx0IOOO();
    }

    public oIX0oI Oo(@IXo.oxoX int i) {
        String xoXoI2 = xoXoI(i, "color");
        if (!TextUtils.isEmpty(xoXoI2)) {
            return this.f31792oIX0oI.get(xoXoI2);
        }
        return null;
    }

    public boolean OxI() {
        return this.f31787II0XooXoX;
    }

    public void Oxx0IOOO() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f31792oIX0oI.keySet().iterator();
        while (it.hasNext()) {
            oIX0oI oix0oi = this.f31792oIX0oI.get(it.next());
            if (oix0oi != null) {
                try {
                    jSONArray.put(oIX0oI.oI0IIXIo(oix0oi).putOpt("type", "color"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        for (String str : this.f31790X0o0xo.keySet()) {
            try {
                jSONArray.put(new JSONObject().putOpt("type", "drawable").putOpt(f31782ooOOo0oXI, str).putOpt(f31783x0XOIxOo, this.f31790X0o0xo.get(str)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (xoIox.f32102oIX0oI) {
            xoIox.II0xO0(f31785xxIXOIIO, "Apply user theme: " + jSONArray.toString());
        }
        oX0O.xxIXOIIO.II0xO0().xxIXOIIO(jSONArray.toString()).oIX0oI();
        IIXOxIxOo.I0Io.IXxxXO().X0o0xo();
    }

    public ColorStateList Oxx0xo(@IXo.oxoX int i) {
        oIX0oI oix0oi;
        ColorStateList oO2 = oO(i);
        if (oO2 == null) {
            String xoXoI2 = xoXoI(i, "color");
            if (!TextUtils.isEmpty(xoXoI2) && (oix0oi = this.f31792oIX0oI.get(xoXoI2)) != null && (oO2 = oix0oi.IXxxXO()) != null) {
                I0Io(i, oO2);
            }
        }
        return oO2;
    }

    public int OxxIIOOXO(String str) {
        String str2 = this.f31790X0o0xo.get(str);
        if (!TextUtils.isEmpty(str2)) {
            String[] split = str2.split(":");
            if (split.length == 2) {
                return Integer.valueOf(split[1]).intValue();
            }
            return 0;
        }
        return 0;
    }

    public void X0IIOO(@IXo.oxoX int i) {
        String xoXoI2 = xoXoI(i, "color");
        if (!TextUtils.isEmpty(xoXoI2)) {
            this.f31792oIX0oI.remove(xoXoI2);
            O0xOxO(i);
            this.f31793oxoX = this.f31792oIX0oI.isEmpty();
        }
    }

    public void X0o0xo(@IXo.X0o0xo int i, String str, int i2) {
        if (!II0XooXoX(str)) {
            return;
        }
        String xoXoI2 = xoXoI(i, "drawable");
        if (!TextUtils.isEmpty(xoXoI2)) {
            this.f31790X0o0xo.put(xoXoI2, str + ":" + String.valueOf(i2));
            XIxXXX0x0(i);
            this.f31787II0XooXoX = false;
        }
    }

    public void XI0IXoo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f31792oIX0oI.remove(str);
            this.f31793oxoX = this.f31792oIX0oI.isEmpty();
        }
    }

    public final void XIxXXX0x0(@IXo.X0o0xo int i) {
        synchronized (this.f31791XO) {
            this.f31789Oxx0IOOO.remove(Integer.valueOf(i));
        }
    }

    public final void XO(@IXo.X0o0xo int i, Drawable drawable) {
        if (drawable != null) {
            synchronized (this.f31791XO) {
                this.f31789Oxx0IOOO.put(Integer.valueOf(i), new WeakReference<>(drawable));
            }
        }
    }

    public final void XxX0x0xxx() throws JSONException {
        String X0o0xo2 = oX0O.xxIXOIIO.II0xO0().X0o0xo();
        if (!TextUtils.isEmpty(X0o0xo2)) {
            JSONArray jSONArray = new JSONArray(X0o0xo2);
            if (xoIox.f32102oIX0oI) {
                xoIox.II0xO0(f31785xxIXOIIO, "startLoadFromSharedPreferences: " + jSONArray.toString());
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("type")) {
                    String string = jSONObject.getString("type");
                    if ("color".equals(string)) {
                        oIX0oI II0xO02 = oIX0oI.II0xO0(jSONObject);
                        if (II0xO02 != null) {
                            this.f31792oIX0oI.put(II0xO02.f31797II0xO0, II0xO02);
                        }
                    } else if ("drawable".equals(string)) {
                        String string2 = jSONObject.getString(f31782ooOOo0oXI);
                        String string3 = jSONObject.getString(f31783x0XOIxOo);
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                            this.f31790X0o0xo.put(string2, string3);
                        }
                    }
                }
            }
        }
        this.f31793oxoX = this.f31792oIX0oI.isEmpty();
        this.f31787II0XooXoX = this.f31790X0o0xo.isEmpty();
    }

    public boolean o00() {
        return this.f31793oxoX;
    }

    public Drawable oI0IIXIo(@IXo.X0o0xo int i) {
        Drawable x0xO0oo2 = x0xO0oo(i);
        if (x0xO0oo2 == null) {
            String xoXoI2 = xoXoI(i, "drawable");
            if (!TextUtils.isEmpty(xoXoI2)) {
                String str = this.f31790X0o0xo.get(xoXoI2);
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(":");
                    int i2 = 0;
                    String str2 = split[0];
                    if (split.length == 2) {
                        i2 = Integer.valueOf(split[1]).intValue();
                    }
                    if (II0XooXoX(str2)) {
                        if (i2 == 0) {
                            x0xO0oo2 = Drawable.createFromPath(str2);
                        } else {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(i2);
                            Bitmap decodeFile = BitmapFactory.decodeFile(str2);
                            x0xO0oo2 = new BitmapDrawable((Resources) null, Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true));
                        }
                        if (x0xO0oo2 != null) {
                            XO(i, x0xO0oo2);
                        }
                    }
                }
            }
        }
        return x0xO0oo2;
    }

    public void oIX0oI(@IXo.oxoX int i, String str) {
        if (!oIX0oI.oIX0oI("colorDefault", str)) {
            return;
        }
        String xoXoI2 = xoXoI(i, "color");
        if (!TextUtils.isEmpty(xoXoI2)) {
            this.f31792oIX0oI.put(xoXoI2, new oIX0oI(xoXoI2, str));
            O0xOxO(i);
            this.f31793oxoX = false;
        }
    }

    public final ColorStateList oO(@IXo.oxoX int i) {
        synchronized (this.f31788II0xO0) {
            try {
                WeakReference<ColorStateList> weakReference = this.f31786I0Io.get(Integer.valueOf(i));
                if (weakReference != null) {
                    ColorStateList colorStateList = weakReference.get();
                    if (colorStateList != null) {
                        return colorStateList;
                    }
                    this.f31786I0Io.remove(Integer.valueOf(i));
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void oOoXoXO() {
        synchronized (this.f31791XO) {
            this.f31789Oxx0IOOO.clear();
        }
    }

    public void ooOOo0oXI() {
        this.f31790X0o0xo.clear();
        oOoXoXO();
        this.f31787II0XooXoX = true;
        Oxx0IOOO();
    }

    public void oxoX(@IXo.X0o0xo int i, String str) {
        if (!II0XooXoX(str)) {
            return;
        }
        String xoXoI2 = xoXoI(i, "drawable");
        if (!TextUtils.isEmpty(xoXoI2)) {
            this.f31790X0o0xo.put(xoXoI2, str + ":" + String.valueOf(oX0O.X0o0xo.oIX0oI(str)));
            XIxXXX0x0(i);
            this.f31787II0XooXoX = false;
        }
    }

    public final Drawable x0xO0oo(@IXo.X0o0xo int i) {
        synchronized (this.f31791XO) {
            try {
                WeakReference<Drawable> weakReference = this.f31789Oxx0IOOO.get(Integer.valueOf(i));
                if (weakReference != null) {
                    Drawable drawable = weakReference.get();
                    if (drawable != null) {
                        return drawable;
                    }
                    this.f31789Oxx0IOOO.remove(Integer.valueOf(i));
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void xoIox() {
        synchronized (this.f31788II0xO0) {
            this.f31786I0Io.clear();
        }
    }

    public final String xoXoI(int i, String str) {
        Context x0XOIxOo2 = IIXOxIxOo.I0Io.IXxxXO().x0XOIxOo();
        if (str.equalsIgnoreCase(x0XOIxOo2.getResources().getResourceTypeName(i))) {
            return x0XOIxOo2.getResources().getResourceEntryName(i);
        }
        return null;
    }

    public void xxIXOIIO() {
        xoIox();
        oOoXoXO();
    }

    public void xxX(@IXo.X0o0xo int i) {
        String xoXoI2 = xoXoI(i, "drawable");
        if (!TextUtils.isEmpty(xoXoI2)) {
            this.f31790X0o0xo.remove(xoXoI2);
            XIxXXX0x0(i);
            this.f31787II0XooXoX = this.f31790X0o0xo.isEmpty();
        }
    }
}
