package com.airbnb.lottie;

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

/* loaded from: classes.dex */
public class II0XooXoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final Map<String, IXxxXO<com.airbnb.lottie.Oxx0IOOO>> f4743oIX0oI = new HashMap();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final byte[] f4742II0xO0 = {80, 75, 3, 4};

    /* loaded from: classes.dex */
    public class I0Io implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f4744IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4745Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f4746XO;

        public I0Io(Context context, String str, String str2) {
            this.f4746XO = context;
            this.f4745Oo = str;
            this.f4744IXxxXO = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            x0xO0oo<com.airbnb.lottie.Oxx0IOOO> I0Io2 = com.airbnb.lottie.X0o0xo.oxoX(this.f4746XO).I0Io(this.f4745Oo, this.f4744IXxxXO);
            if (this.f4744IXxxXO != null && I0Io2.II0xO0() != null) {
                x0xO0oo.XO.I0Io().oxoX(this.f4744IXxxXO, I0Io2.II0xO0());
            }
            return I0Io2;
        }
    }

    /* renamed from: com.airbnb.lottie.II0XooXoX$II0XooXoX, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0096II0XooXoX implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4747Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f4748XO;

        public CallableC0096II0XooXoX(String str, String str2) {
            this.f4748XO = str;
            this.f4747Oo = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return II0XooXoX.Oo(this.f4748XO, this.f4747Oo);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements oOoXoXO<Throwable> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f4749oIX0oI;

        public II0xO0(String str) {
            this.f4749oIX0oI = str;
        }

        @Override // com.airbnb.lottie.oOoXoXO
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            II0XooXoX.f4743oIX0oI.remove(this.f4749oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class OOXIXo implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ com.airbnb.lottie.Oxx0IOOO f4750XO;

        public OOXIXo(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            this.f4750XO = oxx0IOOO;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return new x0xO0oo<>(this.f4750XO);
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4751Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ JSONObject f4752XO;

        public Oxx0IOOO(JSONObject jSONObject, String str) {
            this.f4752XO = jSONObject;
            this.f4751Oo = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return II0XooXoX.IXxxXO(this.f4752XO, this.f4751Oo);
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ int f4753IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f4754Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ String f4755Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ WeakReference f4756XO;

        public X0o0xo(WeakReference weakReference, Context context, int i, String str) {
            this.f4756XO = weakReference;
            this.f4754Oo = context;
            this.f4753IXxxXO = i;
            this.f4755Oxx0xo = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            Context context = (Context) this.f4756XO.get();
            if (context == null) {
                context = this.f4754Oo;
            }
            return II0XooXoX.IIXOooo(context, this.f4753IXxxXO, this.f4755Oxx0xo);
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4757Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ InputStream f4758XO;

        public XO(InputStream inputStream, String str) {
            this.f4758XO = inputStream;
            this.f4757Oo = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return II0XooXoX.OOXIXo(this.f4758XO, this.f4757Oo);
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements oOoXoXO<com.airbnb.lottie.Oxx0IOOO> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ String f4759oIX0oI;

        public oIX0oI(String str) {
            this.f4759oIX0oI = str;
        }

        @Override // com.airbnb.lottie.oOoXoXO
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.Oxx0IOOO oxx0IOOO) {
            II0XooXoX.f4743oIX0oI.remove(this.f4759oIX0oI);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ String f4760IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4761Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f4762XO;

        public oxoX(Context context, String str, String str2) {
            this.f4762XO = context;
            this.f4761Oo = str;
            this.f4760IXxxXO = str2;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return II0XooXoX.II0XooXoX(this.f4762XO, this.f4761Oo, this.f4760IXxxXO);
        }
    }

    /* loaded from: classes.dex */
    public class xoIox implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4763Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ZipInputStream f4764XO;

        public xoIox(ZipInputStream zipInputStream, String str) {
            this.f4764XO = zipInputStream;
            this.f4763Oo = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return II0XooXoX.XI0IXoo(this.f4764XO, this.f4763Oo);
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ String f4765Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ JsonReader f4766XO;

        public xxIXOIIO(JsonReader jsonReader, String str) {
            this.f4766XO = jsonReader;
            this.f4765Oo = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public x0xO0oo<com.airbnb.lottie.Oxx0IOOO> call() {
            return II0XooXoX.x0XOIxOo(this.f4766XO, this.f4765Oo);
        }
    }

    public static void I0Io(Context context) {
        f4743oIX0oI.clear();
        x0xO0oo.XO.I0Io().oIX0oI();
        com.airbnb.lottie.X0o0xo.I0Io(context).oIX0oI();
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> II0XooXoX(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(OTAManager.OTA_ZIP_SUFFIX) && !str.endsWith(".lottie")) {
                return OOXIXo(context.getAssets().open(str), str2);
            }
            return XI0IXoo(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new x0xO0oo<>((Throwable) e);
        }
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> II0xO0(@Nullable String str, Callable<x0xO0oo<com.airbnb.lottie.Oxx0IOOO>> callable) {
        com.airbnb.lottie.Oxx0IOOO II0xO02;
        if (str == null) {
            II0xO02 = null;
        } else {
            II0xO02 = x0xO0oo.XO.I0Io().II0xO0(str);
        }
        if (II0xO02 != null) {
            return new IXxxXO<>(new OOXIXo(II0xO02));
        }
        if (str != null) {
            Map<String, IXxxXO<com.airbnb.lottie.Oxx0IOOO>> map = f4743oIX0oI;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        IXxxXO<com.airbnb.lottie.Oxx0IOOO> iXxxXO = new IXxxXO<>(callable);
        if (str != null) {
            iXxxXO.XO(new oIX0oI(str));
            iXxxXO.X0o0xo(new II0xO0(str));
            f4743oIX0oI.put(str, iXxxXO);
        }
        return iXxxXO;
    }

    public static void IIX0o(int i) {
        x0xO0oo.XO.I0Io().X0o0xo(i);
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> IIXOooo(Context context, @RawRes int i, @Nullable String str) {
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
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> IXxxXO(JSONObject jSONObject, @Nullable String str) {
        return Oo(jSONObject.toString(), str);
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> O0xOxO(Context context, String str, @Nullable String str2) {
        x0xO0oo<com.airbnb.lottie.Oxx0IOOO> I0Io2 = com.airbnb.lottie.X0o0xo.oxoX(context).I0Io(str, str2);
        if (str2 != null && I0Io2.II0xO0() != null) {
            x0xO0oo.XO.I0Io().oxoX(str2, I0Io2.II0xO0());
        }
        return I0Io2;
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> OOXIXo(InputStream inputStream, @Nullable String str) {
        return oOoXoXO(inputStream, str, true);
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> Oo(String str, @Nullable String str2) {
        return x0XOIxOo(JsonReader.oOoXoXO(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> OxI(Context context, String str) {
        return O0xOxO(context, str, str);
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> Oxx0IOOO(Context context, String str) {
        return II0XooXoX(context, str, "asset_" + str);
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> Oxx0xo(Context context, @RawRes int i) {
        return oI0IIXIo(context, i, xXxxox0I(context, i));
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> OxxIIOOXO(Context context, @RawRes int i) {
        return IIXOooo(context, i, xXxxox0I(context, i));
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> X0IIOO(ZipInputStream zipInputStream, @Nullable String str) {
        return II0xO0(str, new xoIox(zipInputStream, str));
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> X0o0xo(Context context, String str) {
        return XO(context, str, "asset_" + str);
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> XI0IXoo(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return XIxXXX0x0(zipInputStream, str);
        } finally {
            IIXOooo.xoIox.I0Io(zipInputStream);
        }
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> XIxXXX0x0(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.Oxx0IOOO oxx0IOOO = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    oxx0IOOO = oO(JsonReader.oOoXoXO(Okio.buffer(Okio.source(zipInputStream))), null, false).II0xO0();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp")) {
                        zipInputStream.closeEntry();
                    }
                    hashMap.put(name.split("/")[r1.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (oxx0IOOO == null) {
                return new x0xO0oo<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                com.airbnb.lottie.OOXIXo oxoX2 = oxoX(oxx0IOOO, (String) entry.getKey());
                if (oxoX2 != null) {
                    oxoX2.II0XooXoX(IIXOooo.xoIox.ooOOo0oXI((Bitmap) entry.getValue(), oxoX2.XO(), oxoX2.oxoX()));
                }
            }
            for (Map.Entry<String, com.airbnb.lottie.OOXIXo> entry2 : oxx0IOOO.xxIXOIIO().entrySet()) {
                if (entry2.getValue().oIX0oI() == null) {
                    return new x0xO0oo<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().I0Io()));
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

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> XO(Context context, String str, @Nullable String str2) {
        return II0xO0(str2, new oxoX(context.getApplicationContext(), str, str2));
    }

    public static Boolean XxX0x0xxx(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b : f4742II0xO0) {
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

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> o00(Context context, String str, @Nullable String str2) {
        return II0xO0(str2, new I0Io(context, str, str2));
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> oI0IIXIo(Context context, @RawRes int i, @Nullable String str) {
        return II0xO0(str, new X0o0xo(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> oO(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            try {
                com.airbnb.lottie.Oxx0IOOO oIX0oI2 = OxxIIOOXO.OxxIIOOXO.oIX0oI(jsonReader);
                if (str != null) {
                    x0xO0oo.XO.I0Io().oxoX(str, oIX0oI2);
                }
                x0xO0oo<com.airbnb.lottie.Oxx0IOOO> x0xo0oo = new x0xO0oo<>(oIX0oI2);
                if (z) {
                    IIXOooo.xoIox.I0Io(jsonReader);
                }
                return x0xo0oo;
            } catch (Exception e) {
                x0xO0oo<com.airbnb.lottie.Oxx0IOOO> x0xo0oo2 = new x0xO0oo<>(e);
                if (z) {
                    IIXOooo.xoIox.I0Io(jsonReader);
                }
                return x0xo0oo2;
            }
        } catch (Throwable th) {
            if (z) {
                IIXOooo.xoIox.I0Io(jsonReader);
            }
            throw th;
        }
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> oOoXoXO(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return x0XOIxOo(JsonReader.oOoXoXO(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                IIXOooo.xoIox.I0Io(inputStream);
            }
        }
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> ooOOo0oXI(JsonReader jsonReader, @Nullable String str) {
        return II0xO0(str, new xxIXOIIO(jsonReader, str));
    }

    @Nullable
    public static com.airbnb.lottie.OOXIXo oxoX(com.airbnb.lottie.Oxx0IOOO oxx0IOOO, String str) {
        for (com.airbnb.lottie.OOXIXo oOXIXo : oxx0IOOO.xxIXOIIO().values()) {
            if (oOXIXo.I0Io().equals(str)) {
                return oOXIXo;
            }
        }
        return null;
    }

    @WorkerThread
    public static x0xO0oo<com.airbnb.lottie.Oxx0IOOO> x0XOIxOo(JsonReader jsonReader, @Nullable String str) {
        return oO(jsonReader, str, true);
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> x0xO0oo(String str, @Nullable String str2) {
        return II0xO0(str2, new CallableC0096II0XooXoX(str, str2));
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

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> xoIox(InputStream inputStream, @Nullable String str) {
        return II0xO0(str, new XO(inputStream, str));
    }

    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> xoXoI(Context context, String str) {
        return o00(context, str, "url_" + str);
    }

    @Deprecated
    public static IXxxXO<com.airbnb.lottie.Oxx0IOOO> xxIXOIIO(JSONObject jSONObject, @Nullable String str) {
        return II0xO0(str, new Oxx0IOOO(jSONObject, str));
    }

    public static boolean xxX(Context context) {
        if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }
}
