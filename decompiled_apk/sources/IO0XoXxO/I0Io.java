package IO0XoXxO;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.huawei.hms.ads.dynamicloader.b;
import com.octopus.ad.AdActivity;
import com.octopus.ad.DownloadService;
import com.octopus.ad.R;
import com.octopus.ad.model.II0xO0;
import java.lang.ref.WeakReference;
import java.util.List;
import x0.oOXoIIIo;
import x0.oxXx0IX;

/* loaded from: classes11.dex */
public class I0Io {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static volatile I0Io f366OOXIXo;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f367I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public IO0XoXxO.II0xO0 f368II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public IXO.oIX0oI f369II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f370Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f371X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f372XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public WeakReference<Context> f373oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public String f374oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public X0xII0I.oIX0oI f375xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public II0xO0.C0895II0xO0 f376xxIXOIIO;

    /* renamed from: IO0XoXxO.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class ViewOnClickListenerC0012I0Io implements View.OnClickListener {
        public ViewOnClickListenerC0012I0Io() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            I0Io i0Io = I0Io.this;
            i0Io.oO(i0Io.f375xoIox.X0o0xo());
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements View.OnClickListener {
        public II0xO0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            I0Io i0Io = I0Io.this;
            i0Io.oO(i0Io.f375xoIox.Oxx0IOOO());
        }
    }

    /* loaded from: classes11.dex */
    public class X0o0xo implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f380XO;

        public X0o0xo(AlertDialog alertDialog) {
            this.f380XO = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f380XO.cancel();
        }
    }

    /* loaded from: classes11.dex */
    public class XO implements DialogInterface.OnDismissListener {
        public XO() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (I0Io.this.f369II0xO0 != null) {
                I0Io.this.f369II0xO0.oOoXoXO();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements View.OnClickListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            I0Io i0Io = I0Io.this;
            i0Io.oO(i0Io.f375xoIox.XO());
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ AlertDialog f384XO;

        public oxoX(AlertDialog alertDialog) {
            this.f384XO = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            I0Io.this.Oxx0xo();
            this.f384XO.cancel();
        }
    }

    public I0Io(Context context) {
        this.f373oIX0oI = new WeakReference<>(context);
    }

    public static I0Io XO(Context context) {
        if (f366OOXIXo == null) {
            synchronized (I0Io.class) {
                try {
                    if (f366OOXIXo == null) {
                        f366OOXIXo = new I0Io(context);
                    }
                } finally {
                }
            }
        }
        return f366OOXIXo;
    }

    public I0Io I0Io(IO0XoXxO.II0xO0 iI0xO0) {
        this.f368II0XooXoX = iI0xO0;
        return this;
    }

    public I0Io II0XooXoX(String str) {
        if (!str.equals(this.f374oxoX)) {
            this.f372XO = false;
            this.f370Oxx0IOOO = false;
        }
        this.f374oxoX = str;
        return this;
    }

    public I0Io II0xO0(int i) {
        this.f367I0Io = i;
        return this;
    }

    public void IXxxXO() {
        f366OOXIXo = null;
        this.f373oIX0oI = null;
    }

    public I0Io Oxx0IOOO(II0xO0.C0895II0xO0 c0895II0xO0) {
        this.f376xxIXOIIO = c0895II0xO0;
        return this;
    }

    public final void Oxx0xo() {
        if (!OxxIIOOXO()) {
            Log.d("octopus", "startDownloadService download:下载必要参数为null");
            return;
        }
        try {
            if (this.f373oIX0oI.get() != null) {
                this.f373oIX0oI.get().startService(new Intent(this.f373oIX0oI.get(), (Class<?>) DownloadService.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean OxxIIOOXO() {
        IO0XoXxO.II0xO0 iI0xO0 = this.f368II0XooXoX;
        if (iI0xO0 == null) {
            return false;
        }
        if (TextUtils.isEmpty(iI0xO0.oIX0oI())) {
            o0IXXIx.II0XooXoX.I0Io("ApkDownloadManager", "apkUrl can not be empty!");
            return false;
        }
        if (TextUtils.isEmpty(this.f368II0XooXoX.II0xO0())) {
            o0IXXIx.II0XooXoX.I0Io("ApkDownloadManager", "apkName can not be empty!");
            return false;
        }
        if (!this.f368II0XooXoX.II0xO0().endsWith(b.b)) {
            o0IXXIx.II0XooXoX.I0Io("ApkDownloadManager", "apkName must endsWith .apk!");
            return false;
        }
        return true;
    }

    public I0Io X0o0xo(X0xII0I.oIX0oI oix0oi) {
        this.f375xoIox = oix0oi;
        return this;
    }

    public final void oI0IIXIo() {
        try {
            if (this.f373oIX0oI.get() != null && (this.f373oIX0oI.get() instanceof Activity)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f373oIX0oI.get(), R.style.OctopusAlertDialogStyle);
                View inflate = LayoutInflater.from(this.f373oIX0oI.get()).inflate(R.layout.oct_dialog_download, (ViewGroup) null);
                builder.setView(inflate);
                AlertDialog create = builder.create();
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_app_icon);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_app_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_app_version);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tv_app_developer);
                TextView textView4 = (TextView) inflate.findViewById(R.id.tv_app_permission);
                TextView textView5 = (TextView) inflate.findViewById(R.id.tv_app_privacy);
                TextView textView6 = (TextView) inflate.findViewById(R.id.tv_app_function);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_download);
                TextView textView7 = (TextView) inflate.findViewById(R.id.tv_give_up);
                oOXoIIIo.II0XooXoX(null).Oxx0IOOO(this.f375xoIox.oIX0oI()).I0Io(imageView);
                textView.setText(this.f375xoIox.II0xO0());
                textView2.setText(String.format("版本号：%s", this.f375xoIox.I0Io()));
                textView3.setText(String.format("开发者：%s", this.f375xoIox.oxoX()));
                textView4.setOnClickListener(new oIX0oI());
                textView5.setOnClickListener(new II0xO0());
                textView6.setOnClickListener(new ViewOnClickListenerC0012I0Io());
                linearLayout.setOnClickListener(new oxoX(create));
                textView7.setOnClickListener(new X0o0xo(create));
                create.show();
                create.setOnDismissListener(new XO());
                IXO.oIX0oI oix0oi = this.f369II0xO0;
                if (oix0oi != null) {
                    oix0oi.xxIXOIIO();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IO0XoXxO.II0xO0 oIX0oI() {
        return this.f368II0XooXoX;
    }

    public final void oO(String str) {
        try {
            if (this.f373oIX0oI.get() != null && !TextUtils.isEmpty(str)) {
                WebView webView = new WebView(new MutableContextWrapper(this.f373oIX0oI.get()));
                oxXx0IX.XO(webView);
                webView.loadUrl(str);
                Intent intent = new Intent(this.f373oIX0oI.get(), AdActivity.oIX0oI());
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "BROWSER");
                oI.oIX0oI.f31320I0Io.add(webView);
                this.f373oIX0oI.get().startActivity(intent);
            }
        } catch (Exception unused) {
            oI.oIX0oI.f31320I0Io.remove();
        }
    }

    public I0Io oOoXoXO(Context context) {
        this.f373oIX0oI = new WeakReference<>(context);
        return this;
    }

    public void ooOOo0oXI() {
        if (!com.octopus.ad.internal.xoIox.oIX0oI().OxI() && !this.f371X0o0xo) {
            oI0IIXIo();
        } else {
            Oxx0xo();
        }
    }

    public I0Io oxoX(IXO.oIX0oI oix0oi) {
        this.f369II0xO0 = oix0oi;
        return this;
    }

    public void x0xO0oo(boolean z) {
        II0xO0.C0895II0xO0 c0895II0xO0 = this.f376xxIXOIIO;
        if (c0895II0xO0 != null) {
            if (z) {
                if (this.f370Oxx0IOOO) {
                    return;
                } else {
                    this.f370Oxx0IOOO = true;
                }
            } else if (this.f372XO) {
                return;
            } else {
                this.f372XO = true;
            }
            List<II0xO0.xxIXOIIO> XI0IXoo2 = c0895II0xO0.XI0IXoo();
            if (XI0IXoo2 != null) {
                for (int i = 0; i < XI0IXoo2.size(); i++) {
                    II0xO0.xxIXOIIO xxixoiio = XI0IXoo2.get(i);
                    if (xxixoiio != null && !TextUtils.isEmpty(xxixoiio.xxIXOIIO())) {
                        String xxIXOIIO2 = xxixoiio.xxIXOIIO();
                        if (xxIXOIIO2.startsWith("http://v.adintl.cn/downsucc")) {
                            if (z) {
                                xxIXOIIO2 = xxIXOIIO2 + "&opt=5";
                            } else if (this.f367I0Io != 0) {
                                xxIXOIIO2 = xxIXOIIO2 + "&opt=" + this.f367I0Io;
                            }
                        }
                        new com.octopus.ad.internal.Oxx0IOOO(xxIXOIIO2).XO();
                    }
                }
            }
        }
    }

    public I0Io xxIXOIIO(boolean z) {
        this.f371X0o0xo = z;
        return this;
    }
}
