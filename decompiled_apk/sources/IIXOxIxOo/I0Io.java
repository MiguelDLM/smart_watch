package IIXOxIxOo;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import oIxOXo.oxoX;
import oX0O.xxIXOIIO;
import xx0O.Oxx0IOOO;
import xx0O.XO;
import xxx.X0o0xo;

/* loaded from: classes6.dex */
public class I0Io extends OoxxX.oIX0oI {

    /* renamed from: oO, reason: collision with root package name */
    public static final int f321oO = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f322oOoXoXO = -1;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f323ooOOo0oXI = 0;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f324x0XOIxOo = 1;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static volatile I0Io f325x0xO0oo;

    /* renamed from: I0Io, reason: collision with root package name */
    public final Context f326I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Object f328II0xO0 = new Object();

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f333oxoX = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public List<Oxx0IOOO> f331X0o0xo = new ArrayList();

    /* renamed from: XO, reason: collision with root package name */
    public List<XO> f332XO = new ArrayList();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public List<XO> f330Oxx0IOOO = new ArrayList();

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public SparseArray<InterfaceC0010I0Io> f327II0XooXoX = new SparseArray<>();

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f335xxIXOIIO = true;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f334xoIox = false;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f329OOXIXo = true;

    /* renamed from: IIXOxIxOo.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0010I0Io {
        Drawable I0Io(Context context, String str, int i);

        ColorStateList II0xO0(Context context, String str, int i);

        ColorStateList X0o0xo(Context context, String str, int i);

        int getType();

        String oIX0oI(Context context, String str, int i);

        String oxoX(Context context, String str);
    }

    /* loaded from: classes6.dex */
    public interface II0xO0 {
        void onFailed(String str);

        void onStart();

        void onSuccess();
    }

    /* loaded from: classes6.dex */
    public class oIX0oI extends AsyncTask<String, Void, String> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final InterfaceC0010I0Io f337II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final II0xO0 f338oIX0oI;

        public oIX0oI(@IXo.Oxx0IOOO II0xO0 iI0xO0, @IXo.XO InterfaceC0010I0Io interfaceC0010I0Io) {
            this.f338oIX0oI = iI0xO0;
            this.f337II0xO0 = interfaceC0010I0Io;
        }

        @Override // android.os.AsyncTask
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            synchronized (I0Io.this.f328II0xO0) {
                try {
                    if (str != null) {
                        xxIXOIIO.II0xO0().Oxx0IOOO(str).II0XooXoX(this.f337II0xO0.getType()).oIX0oI();
                        I0Io.this.X0o0xo();
                        II0xO0 iI0xO0 = this.f338oIX0oI;
                        if (iI0xO0 != null) {
                            iI0xO0.onSuccess();
                        }
                    } else {
                        xxIXOIIO.II0xO0().Oxx0IOOO("").II0XooXoX(-1).oIX0oI();
                        II0xO0 iI0xO02 = this.f338oIX0oI;
                        if (iI0xO02 != null) {
                            iI0xO02.onFailed("皮肤资源获取失败");
                        }
                    }
                    I0Io.this.f333oxoX = false;
                    I0Io.this.f328II0xO0.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            synchronized (I0Io.this.f328II0xO0) {
                while (I0Io.this.f333oxoX) {
                    try {
                        I0Io.this.f328II0xO0.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                I0Io.this.f333oxoX = true;
            }
            try {
                if (strArr.length == 1) {
                    if (TextUtils.isEmpty(this.f337II0xO0.oxoX(I0Io.this.f326I0Io, strArr[0]))) {
                        oxoX.II0XooXoX().xoXoI(this.f337II0xO0);
                        return "";
                    }
                    return strArr[0];
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            oxoX.II0XooXoX().IIXOooo();
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            II0xO0 iI0xO0 = this.f338oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.onStart();
            }
        }
    }

    public I0Io(Context context) {
        this.f326I0Io = context.getApplicationContext();
        o00();
    }

    public static I0Io IXxxXO() {
        return f325x0xO0oo;
    }

    public static I0Io IoOoX(Application application) {
        xoXoI(application);
        xx0O.oIX0oI.Oxx0IOOO(application);
        return f325x0xO0oo;
    }

    public static I0Io xoXoI(Context context) {
        if (f325x0xO0oo == null) {
            synchronized (I0Io.class) {
                try {
                    if (f325x0xO0oo == null) {
                        f325x0xO0oo = new I0Io(context);
                    }
                } finally {
                }
            }
        }
        xxIXOIIO.XO(context);
        return f325x0xO0oo;
    }

    public AsyncTask IIX0o(String str, II0xO0 iI0xO0, int i) {
        InterfaceC0010I0Io interfaceC0010I0Io = this.f327II0XooXoX.get(i);
        if (interfaceC0010I0Io == null) {
            return null;
        }
        return new oIX0oI(iI0xO0, interfaceC0010I0Io).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }

    public List<Oxx0IOOO> IIXOooo() {
        return this.f331X0o0xo;
    }

    @Deprecated
    public boolean O0xOxO() {
        return this.f334xoIox;
    }

    @Deprecated
    public I0Io OOXIXo(XO xo2) {
        this.f330Oxx0IOOO.add(xo2);
        return this;
    }

    public List<XO> Oo() {
        return this.f332XO;
    }

    public boolean OxI() {
        return this.f335xxIXOIIO;
    }

    public String Oxx0xo(String str) {
        return this.f326I0Io.getPackageManager().getPackageArchiveInfo(str, 1).packageName;
    }

    public SparseArray<InterfaceC0010I0Io> OxxIIOOXO() {
        return this.f327II0XooXoX;
    }

    public boolean X0IIOO() {
        return this.f329OOXIXo;
    }

    public AsyncTask XI0IXoo() {
        String I0Io2 = xxIXOIIO.II0xO0().I0Io();
        int oxoX2 = xxIXOIIO.II0xO0().oxoX();
        if (TextUtils.isEmpty(I0Io2) || oxoX2 == -1) {
            return null;
        }
        return IIX0o(I0Io2, null, oxoX2);
    }

    public AsyncTask XIxXXX0x0(II0xO0 iI0xO0) {
        String I0Io2 = xxIXOIIO.II0xO0().I0Io();
        int oxoX2 = xxIXOIIO.II0xO0().oxoX();
        if (!TextUtils.isEmpty(I0Io2) && oxoX2 != -1) {
            return IIX0o(I0Io2, iI0xO0, oxoX2);
        }
        return null;
    }

    public AsyncTask XxX0x0xxx(String str, int i) {
        return IIX0o(str, null, i);
    }

    public final void o00() {
        this.f327II0XooXoX.put(-1, new xxx.oxoX());
        this.f327II0XooXoX.put(0, new xxx.II0xO0());
        this.f327II0XooXoX.put(1, new xxx.I0Io());
        this.f327II0XooXoX.put(2, new X0o0xo());
    }

    @IXo.Oxx0IOOO
    public Resources oI0IIXIo(String str) {
        try {
            PackageInfo packageArchiveInfo = this.f326I0Io.getPackageManager().getPackageArchiveInfo(str, 0);
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            Resources resourcesForApplication = this.f326I0Io.getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo);
            Resources resources = this.f326I0Io.getResources();
            return new Resources(resourcesForApplication.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public String oO() {
        return xxIXOIIO.II0xO0().I0Io();
    }

    public I0Io oOoXoXO(XO xo2) {
        if (xo2 instanceof Oxx0IOOO) {
            this.f331X0o0xo.add((Oxx0IOOO) xo2);
        }
        this.f332XO.add(xo2);
        return this;
    }

    public I0Io oo(boolean z) {
        this.f329OOXIXo = z;
        return this;
    }

    @Deprecated
    public I0Io oo0xXOI0I(boolean z) {
        this.f334xoIox = z;
        return this;
    }

    public I0Io ooOOo0oXI(InterfaceC0010I0Io interfaceC0010I0Io) {
        this.f327II0XooXoX.put(interfaceC0010I0Io.getType(), interfaceC0010I0Io);
        return this;
    }

    public void ooXIXxIX() {
        XxX0x0xxx("", -1);
    }

    public Context x0XOIxOo() {
        return this.f326I0Io;
    }

    @Deprecated
    public List<XO> x0xO0oo() {
        return this.f330Oxx0IOOO;
    }

    public I0Io xI(boolean z) {
        this.f335xxIXOIIO = z;
        return this;
    }

    @Deprecated
    public AsyncTask xXxxox0I(String str, II0xO0 iI0xO0) {
        return IIX0o(str, iI0xO0, 0);
    }

    @Deprecated
    public AsyncTask xxX(String str) {
        return xXxxox0I(str, null);
    }
}
