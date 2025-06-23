package com.airbnb.lottie;

import OxxIIOOXO.OxxIIOOXO;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

public class II0XooXoX {

    /* renamed from: II0xO0  reason: collision with root package name */
    public static final byte[] f748II0xO0 = {80, 75, 3, 4};

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static final Map<String, IXxxXO<Oxx0IOOO>> f749oIX0oI = new HashMap();

    public class I0Io implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: IXxxXO  reason: collision with root package name */
        public final /* synthetic */ String f750IXxxXO;

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f751Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ Context f752XO;

        public I0Io(Context context, String str, String str2) {
            this.f752XO = context;
            this.f751Oo = str;
            this.f750IXxxXO = str2;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            x0xO0oo<Oxx0IOOO> I0Io2 = X0o0xo.oxoX(this.f752XO).I0Io(this.f751Oo, this.f750IXxxXO);
            if (!(this.f750IXxxXO == null || I0Io2.II0xO0() == null)) {
                x0xO0oo.XO.I0Io().oxoX(this.f750IXxxXO, I0Io2.II0xO0());
            }
            return I0Io2;
        }
    }

    /* renamed from: com.airbnb.lottie.II0XooXoX$II0XooXoX  reason: collision with other inner class name */
    public class C0016II0XooXoX implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f753Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ String f754XO;

        public C0016II0XooXoX(String str, String str2) {
            this.f754XO = str;
            this.f753Oo = str2;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return II0XooXoX.Oo(this.f754XO, this.f753Oo);
        }
    }

    public class II0xO0 implements oOoXoXO<Throwable> {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f755oIX0oI;

        public II0xO0(String str) {
            this.f755oIX0oI = str;
        }

        /* renamed from: oIX0oI */
        public void onResult(Throwable th) {
            II0XooXoX.f749oIX0oI.remove(this.f755oIX0oI);
        }
    }

    public class OOXIXo implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ Oxx0IOOO f756XO;

        public OOXIXo(Oxx0IOOO oxx0IOOO) {
            this.f756XO = oxx0IOOO;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return new x0xO0oo<>(this.f756XO);
        }
    }

    public class Oxx0IOOO implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f757Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ JSONObject f758XO;

        public Oxx0IOOO(JSONObject jSONObject, String str) {
            this.f758XO = jSONObject;
            this.f757Oo = str;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return II0XooXoX.IXxxXO(this.f758XO, this.f757Oo);
        }
    }

    public class X0o0xo implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: IXxxXO  reason: collision with root package name */
        public final /* synthetic */ int f759IXxxXO;

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ Context f760Oo;

        /* renamed from: Oxx0xo  reason: collision with root package name */
        public final /* synthetic */ String f761Oxx0xo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ WeakReference f762XO;

        public X0o0xo(WeakReference weakReference, Context context, int i, String str) {
            this.f762XO = weakReference;
            this.f760Oo = context;
            this.f759IXxxXO = i;
            this.f761Oxx0xo = str;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            Context context = (Context) this.f762XO.get();
            if (context == null) {
                context = this.f760Oo;
            }
            return II0XooXoX.IIXOooo(context, this.f759IXxxXO, this.f761Oxx0xo);
        }
    }

    public class XO implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f763Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ InputStream f764XO;

        public XO(InputStream inputStream, String str) {
            this.f764XO = inputStream;
            this.f763Oo = str;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return II0XooXoX.OOXIXo(this.f764XO, this.f763Oo);
        }
    }

    public class oIX0oI implements oOoXoXO<Oxx0IOOO> {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public final /* synthetic */ String f765oIX0oI;

        public oIX0oI(String str) {
            this.f765oIX0oI = str;
        }

        /* renamed from: oIX0oI */
        public void onResult(Oxx0IOOO oxx0IOOO) {
            II0XooXoX.f749oIX0oI.remove(this.f765oIX0oI);
        }
    }

    public class oxoX implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: IXxxXO  reason: collision with root package name */
        public final /* synthetic */ String f766IXxxXO;

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f767Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ Context f768XO;

        public oxoX(Context context, String str, String str2) {
            this.f768XO = context;
            this.f767Oo = str;
            this.f766IXxxXO = str2;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return II0XooXoX.II0XooXoX(this.f768XO, this.f767Oo, this.f766IXxxXO);
        }
    }

    public class xoIox implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f769Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ ZipInputStream f770XO;

        public xoIox(ZipInputStream zipInputStream, String str) {
            this.f770XO = zipInputStream;
            this.f769Oo = str;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return II0XooXoX.XI0IXoo(this.f770XO, this.f769Oo);
        }
    }

    public class xxIXOIIO implements Callable<x0xO0oo<Oxx0IOOO>> {

        /* renamed from: Oo  reason: collision with root package name */
        public final /* synthetic */ String f771Oo;

        /* renamed from: XO  reason: collision with root package name */
        public final /* synthetic */ JsonReader f772XO;

        public xxIXOIIO(JsonReader jsonReader, String str) {
            this.f772XO = jsonReader;
            this.f771Oo = str;
        }

        /* renamed from: oIX0oI */
        public x0xO0oo<Oxx0IOOO> call() {
            return II0XooXoX.x0XOIxOo(this.f772XO, this.f771Oo);
        }
    }

    public static void I0Io(Context context) {
        f749oIX0oI.clear();
        x0xO0oo.XO.I0Io().oIX0oI();
        X0o0xo.I0Io(context).oIX0oI();
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> II0XooXoX(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(OTAManager.OTA_ZIP_SUFFIX)) {
                if (!str.endsWith(".lottie")) {
                    return OOXIXo(context.getAssets().open(str), str2);
                }
            }
            return XI0IXoo(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new x0xO0oo<>((Throwable) e);
        }
    }

    public static IXxxXO<Oxx0IOOO> II0xO0(@Nullable String str, Callable<x0xO0oo<Oxx0IOOO>> callable) {
        Oxx0IOOO oxx0IOOO;
        if (str == null) {
            oxx0IOOO = null;
        } else {
            oxx0IOOO = x0xO0oo.XO.I0Io().II0xO0(str);
        }
        if (oxx0IOOO != null) {
            return new IXxxXO<>(new OOXIXo(oxx0IOOO));
        }
        if (str != null) {
            Map<String, IXxxXO<Oxx0IOOO>> map = f749oIX0oI;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        IXxxXO<Oxx0IOOO> iXxxXO = new IXxxXO<>(callable);
        if (str != null) {
            iXxxXO.XO(new oIX0oI(str));
            iXxxXO.X0o0xo(new II0xO0(str));
            f749oIX0oI.put(str, iXxxXO);
        }
        return iXxxXO;
    }

    public static void IIX0o(int i) {
        x0xO0oo.XO.I0Io().X0o0xo(i);
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> IIXOooo(Context context, @RawRes int i, @Nullable String str) {
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (XxX0x0xxx(buffer).booleanValue()) {
                return XI0IXoo(new ZipInputStream(buffer.inputStream()), str);
            }
            return OOXIXo(buffer.inputStream(), str);
        } catch (Resources.NotFoundException e) {
            return new x0xO0oo<>((Throwable) e);
        }
    }

    @WorkerThread
    @Deprecated
    public static x0xO0oo<Oxx0IOOO> IXxxXO(JSONObject jSONObject, @Nullable String str) {
        return Oo(jSONObject.toString(), str);
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> O0xOxO(Context context, String str, @Nullable String str2) {
        x0xO0oo<Oxx0IOOO> I0Io2 = X0o0xo.oxoX(context).I0Io(str, str2);
        if (!(str2 == null || I0Io2.II0xO0() == null)) {
            x0xO0oo.XO.I0Io().oxoX(str2, I0Io2.II0xO0());
        }
        return I0Io2;
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> OOXIXo(InputStream inputStream, @Nullable String str) {
        return oOoXoXO(inputStream, str, true);
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> Oo(String str, @Nullable String str2) {
        return x0XOIxOo(JsonReader.oOoXoXO(Okio.buffer(Okio.source((InputStream) new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> OxI(Context context, String str) {
        return O0xOxO(context, str, str);
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> Oxx0IOOO(Context context, String str) {
        return II0XooXoX(context, str, "asset_" + str);
    }

    public static IXxxXO<Oxx0IOOO> Oxx0xo(Context context, @RawRes int i) {
        return oI0IIXIo(context, i, xXxxox0I(context, i));
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> OxxIIOOXO(Context context, @RawRes int i) {
        return IIXOooo(context, i, xXxxox0I(context, i));
    }

    public static IXxxXO<Oxx0IOOO> X0IIOO(ZipInputStream zipInputStream, @Nullable String str) {
        return II0xO0(str, new xoIox(zipInputStream, str));
    }

    public static IXxxXO<Oxx0IOOO> X0o0xo(Context context, String str) {
        return XO(context, str, "asset_" + str);
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> XI0IXoo(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return XIxXXX0x0(zipInputStream, str);
        } finally {
            IIXOooo.xoIox.I0Io(zipInputStream);
        }
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> XIxXXX0x0(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            Oxx0IOOO oxx0IOOO = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    oxx0IOOO = oO(JsonReader.oOoXoXO(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).II0xO0();
                } else {
                    if (!name.contains(".png")) {
                        if (!name.contains(".webp")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (oxx0IOOO == null) {
                return new x0xO0oo<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                OOXIXo oxoX2 = oxoX(oxx0IOOO, (String) entry.getKey());
                if (oxoX2 != null) {
                    oxoX2.II0XooXoX(IIXOooo.xoIox.ooOOo0oXI((Bitmap) entry.getValue(), oxoX2.XO(), oxoX2.oxoX()));
                }
            }
            for (Map.Entry next : oxx0IOOO.xxIXOIIO().entrySet()) {
                if (((OOXIXo) next.getValue()).oIX0oI() == null) {
                    return new x0xO0oo<>((Throwable) new IllegalStateException("There is no image for " + ((OOXIXo) next.getValue()).I0Io()));
                }
            }
            if (str != null) {
                x0xO0oo.XO.I0Io().oxoX(str, oxx0IOOO);
            }
            return new x0xO0oo<>(oxx0IOOO);
        } catch (IOException e) {
            return new x0xO0oo<>((Throwable) e);
        }
    }

    public static IXxxXO<Oxx0IOOO> XO(Context context, String str, @Nullable String str2) {
        return II0xO0(str2, new oxoX(context.getApplicationContext(), str, str2));
    }

    public static Boolean XxX0x0xxx(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b : f748II0xO0) {
                if (peek.readByte() != b) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            IIXOooo.XO.I0Io("Failed to check zip file header", e);
            return Boolean.FALSE;
        }
    }

    public static IXxxXO<Oxx0IOOO> o00(Context context, String str, @Nullable String str2) {
        return II0xO0(str2, new I0Io(context, str, str2));
    }

    public static IXxxXO<Oxx0IOOO> oI0IIXIo(Context context, @RawRes int i, @Nullable String str) {
        return II0xO0(str, new X0o0xo(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    public static x0xO0oo<Oxx0IOOO> oO(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            Oxx0IOOO oIX0oI2 = OxxIIOOXO.oIX0oI(jsonReader);
            if (str != null) {
                x0xO0oo.XO.I0Io().oxoX(str, oIX0oI2);
            }
            x0xO0oo<Oxx0IOOO> x0xo0oo = new x0xO0oo<>(oIX0oI2);
            if (z) {
                IIXOooo.xoIox.I0Io(jsonReader);
            }
            return x0xo0oo;
        } catch (Exception e) {
            x0xO0oo<Oxx0IOOO> x0xo0oo2 = new x0xO0oo<>((Throwable) e);
            if (z) {
                IIXOooo.xoIox.I0Io(jsonReader);
            }
            return x0xo0oo2;
        } catch (Throwable th) {
            if (z) {
                IIXOooo.xoIox.I0Io(jsonReader);
            }
            throw th;
        }
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> oOoXoXO(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return x0XOIxOo(JsonReader.oOoXoXO(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                IIXOooo.xoIox.I0Io(inputStream);
            }
        }
    }

    public static IXxxXO<Oxx0IOOO> ooOOo0oXI(JsonReader jsonReader, @Nullable String str) {
        return II0xO0(str, new xxIXOIIO(jsonReader, str));
    }

    @Nullable
    public static OOXIXo oxoX(Oxx0IOOO oxx0IOOO, String str) {
        for (OOXIXo next : oxx0IOOO.xxIXOIIO().values()) {
            if (next.I0Io().equals(str)) {
                return next;
            }
        }
        return null;
    }

    @WorkerThread
    public static x0xO0oo<Oxx0IOOO> x0XOIxOo(JsonReader jsonReader, @Nullable String str) {
        return oO(jsonReader, str, true);
    }

    public static IXxxXO<Oxx0IOOO> x0xO0oo(String str, @Nullable String str2) {
        return II0xO0(str2, new C0016II0XooXoX(str, str2));
    }

    public static String xXxxox0I(Context context, @RawRes int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        if (xxX(context)) {
            str = "_night_";
        } else {
            str = "_day_";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static IXxxXO<Oxx0IOOO> xoIox(InputStream inputStream, @Nullable String str) {
        return II0xO0(str, new XO(inputStream, str));
    }

    public static IXxxXO<Oxx0IOOO> xoXoI(Context context, String str) {
        return o00(context, str, "url_" + str);
    }

    @Deprecated
    public static IXxxXO<Oxx0IOOO> xxIXOIIO(JSONObject jSONObject, @Nullable String str) {
        return II0xO0(str, new Oxx0IOOO(jSONObject, str));
    }

    public static boolean xxX(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }
}
