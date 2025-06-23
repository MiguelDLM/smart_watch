package xIxooxXX;

import XxXX.II0XooXoX;
import XxXX.Oxx0IOOO;
import XxXX.XO;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.baidu.ar.constants.HttpConstants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jieli.jl_rcsp.constant.Command;
import com.sma.smartv3.initializer.IXxxXO;
import com.tencent.connect.common.oIX0oI;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.security.JniInterface;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import xoX.OOXIXo;
import xox.oO;
import xx0.xxIXOIIO;

/* loaded from: classes13.dex */
public class oIX0oI extends com.tencent.connect.common.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f34409II0XooXoX = "KEY_FORCE_QR_LOGIN";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f34410Oxx0IOOO = "libwbsafeedit_64";

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f34411X0o0xo = "libwbsafeedit_x86_64";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f34412XO = "libwbsafeedit";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f34413oxoX = "libwbsafeedit_x86";

    /* renamed from: xoIox, reason: collision with root package name */
    public static String f34414xoIox = null;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static String f34415xxIXOIIO = "libwbsafeedit";

    /* renamed from: I0Io, reason: collision with root package name */
    public WeakReference<Activity> f34416I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f34417II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public o0Oo.II0xO0 f34418oIX0oI;

    /* loaded from: classes13.dex */
    public class I0Io implements o0Oo.II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public WeakReference<o0Oo.II0xO0> f34422oIX0oI;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final String f34420II0xO0 = "sendinstall";

        /* renamed from: I0Io, reason: collision with root package name */
        public final String f34419I0Io = "installwording";

        /* renamed from: oxoX, reason: collision with root package name */
        public final String f34423oxoX = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* renamed from: xIxooxXX.oIX0oI$I0Io$I0Io, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class DialogInterfaceOnCancelListenerC1154I0Io implements DialogInterface.OnCancelListener {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ Object f34425Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ o0Oo.II0xO0 f34426XO;

            public DialogInterfaceOnCancelListenerC1154I0Io(o0Oo.II0xO0 iI0xO0, Object obj) {
                this.f34426XO = iI0xO0;
                this.f34425Oo = obj;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                o0Oo.II0xO0 iI0xO0 = this.f34426XO;
                if (iI0xO0 != null) {
                    iI0xO0.onComplete(this.f34425Oo);
                }
            }
        }

        /* loaded from: classes13.dex */
        public class II0xO0 extends oxoX {

            /* renamed from: IXxxXO, reason: collision with root package name */
            public final /* synthetic */ o0Oo.II0xO0 f34427IXxxXO;

            /* renamed from: Oxx0xo, reason: collision with root package name */
            public final /* synthetic */ Object f34428Oxx0xo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public II0xO0(Dialog dialog, o0Oo.II0xO0 iI0xO0, Object obj) {
                super(dialog);
                this.f34427IXxxXO = iI0xO0;
                this.f34428Oxx0xo = obj;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialog = this.f34434XO;
                if (dialog != null && dialog.isShowing()) {
                    this.f34434XO.dismiss();
                }
                o0Oo.II0xO0 iI0xO0 = this.f34427IXxxXO;
                if (iI0xO0 != null) {
                    iI0xO0.onComplete(this.f34428Oxx0xo);
                }
            }
        }

        /* renamed from: xIxooxXX.oIX0oI$I0Io$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class C1155oIX0oI extends oxoX {

            /* renamed from: IXxxXO, reason: collision with root package name */
            public final /* synthetic */ o0Oo.II0xO0 f34430IXxxXO;

            /* renamed from: Oxx0xo, reason: collision with root package name */
            public final /* synthetic */ Object f34431Oxx0xo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1155oIX0oI(Dialog dialog, o0Oo.II0xO0 iI0xO0, Object obj) {
                super(dialog);
                this.f34430IXxxXO = iI0xO0;
                this.f34431Oxx0xo = obj;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                I0Io.this.oxoX();
                Dialog dialog = this.f34434XO;
                if (dialog != null && dialog.isShowing()) {
                    this.f34434XO.dismiss();
                }
                o0Oo.II0xO0 iI0xO0 = this.f34430IXxxXO;
                if (iI0xO0 != null) {
                    iI0xO0.onComplete(this.f34431Oxx0xo);
                }
            }
        }

        /* loaded from: classes13.dex */
        public abstract class oxoX implements View.OnClickListener {

            /* renamed from: XO, reason: collision with root package name */
            public Dialog f34434XO;

            public oxoX(Dialog dialog) {
                this.f34434XO = dialog;
            }
        }

        public I0Io(o0Oo.II0xO0 iI0xO0) {
            this.f34422oIX0oI = new WeakReference<>(iI0xO0);
        }

        public final View I0Io(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (f * 14.0f);
            int i3 = (int) (18.0f * f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, (int) (6.0f * f), i3);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams2.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(Command.CMD_GET_EXTERNAL_FLASH_MSG, Command.CMD_GET_EXTERNAL_FLASH_MSG, Command.CMD_GET_EXTERNAL_FLASH_MSG));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i4 = (int) (12.0f * f);
            layoutParams3.setMargins(0, 0, 0, i4);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("跳过");
            button.setBackgroundDrawable(II0xO0("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i5 = (int) (45.0f * f);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i5);
            layoutParams5.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams5.leftMargin = i6;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(II0xO0("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i5);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i6;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (f * 163.0f));
            relativeLayout.setPadding(i2, 0, i4, i4);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        public final Drawable II0xO0(String str, Context context) {
            InputStream open;
            Bitmap bitmap;
            Drawable drawable = null;
            try {
                open = context.getApplicationContext().getAssets().open(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (open == null) {
                return null;
            }
            if (str.endsWith(".9.png")) {
                try {
                    bitmap = BitmapFactory.decodeStream(open);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                    bitmap = null;
                }
                if (bitmap == null) {
                    return null;
                }
                byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                NinePatch.isNinePatchChunk(ninePatchChunk);
                return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
            }
            drawable = Drawable.createFromStream(open, str);
            open.close();
            return drawable;
        }

        public final void X0o0xo(String str, o0Oo.II0xO0 iI0xO0, Object obj) {
            PackageInfo packageInfo;
            if (oIX0oI.this.f34416I0Io == null) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            Activity activity = (Activity) oIX0oI.this.f34416I0Io.get();
            if (activity == null) {
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            Drawable drawable = null;
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e.getStackTrace().toString());
                packageInfo = null;
            }
            if (packageInfo != null) {
                drawable = packageInfo.applicationInfo.loadIcon(packageManager);
            }
            View.OnClickListener c1155oIX0oI = new C1155oIX0oI(dialog, iI0xO0, obj);
            View.OnClickListener iI0xO02 = new II0xO0(dialog, iI0xO0, obj);
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog.getWindow().setBackgroundDrawable(colorDrawable);
            dialog.setContentView(I0Io(activity, drawable, str, c1155oIX0oI, iI0xO02));
            dialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC1154I0Io(iI0xO0, obj));
            if (!activity.isFinishing()) {
                dialog.show();
            }
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            if (this.f34422oIX0oI.get() != null) {
                this.f34422oIX0oI.get().oIX0oI(i0Io);
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            if (this.f34422oIX0oI.get() != null) {
                this.f34422oIX0oI.get().onCancel();
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            String str;
            if (obj != null) {
                JSONObject jSONObject = (JSONObject) obj;
                boolean z = false;
                try {
                    if (jSONObject.getInt("sendinstall") == 1) {
                        z = true;
                    }
                    str = jSONObject.getString("installwording");
                } catch (JSONException unused) {
                    xxIXOIIO.oI0IIXIo("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    str = "";
                }
                String decode = URLDecoder.decode(str);
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", " WORDING = " + decode + "xx,showConfirmDialog=" + z);
                if (z && !TextUtils.isEmpty(decode)) {
                    X0o0xo(decode, this.f34422oIX0oI.get(), obj);
                    xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", " WORDING is not empty and return");
                } else {
                    if (this.f34422oIX0oI.get() != null) {
                        if (((com.tencent.connect.common.oIX0oI) oIX0oI.this).c != null) {
                            ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c.ooOOo0oXI(jSONObject);
                        }
                        this.f34422oIX0oI.get().onComplete(obj);
                        return;
                    }
                    xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", " userListener is null");
                }
            }
        }

        public void oxoX() {
            Activity activity;
            Bundle xoIox2 = oIX0oI.this.xoIox();
            if (oIX0oI.this.f34416I0Io != null && (activity = (Activity) oIX0oI.this.f34416I0Io.get()) != null) {
                HttpUtils.oOoXoXO(((com.tencent.connect.common.oIX0oI) oIX0oI.this).c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", xoIox2, "POST", null);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class II0xO0 implements o0Oo.II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public o0Oo.II0xO0 f34436oIX0oI;

        public II0xO0(o0Oo.II0xO0 iI0xO0) {
            this.f34436oIX0oI = iI0xO0;
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            o0Oo.II0xO0 iI0xO0 = this.f34436oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.oIX0oI(i0Io);
            }
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            o0Oo.II0xO0 iI0xO0 = this.f34436oIX0oI;
            if (iI0xO0 != null) {
                iI0xO0.onCancel();
            }
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            String string;
            if (obj == null) {
                xxIXOIIO.II0XooXoX("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i = jSONObject.getInt("ret");
                if (i == 0) {
                    string = "success";
                } else {
                    string = jSONObject.getString("msg");
                }
                o0Oo.II0xO0 iI0xO0 = this.f34436oIX0oI;
                if (iI0xO0 != null) {
                    iI0xO0.onComplete(new JSONObject().put("ret", i).put("msg", string));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                xxIXOIIO.II0XooXoX("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }
    }

    /* renamed from: xIxooxXX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public class RunnableC1156oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ o0Oo.II0xO0 f34438Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ String f34439XO;

        /* renamed from: xIxooxXX.oIX0oI$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC1157oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Activity f34441XO;

            public RunnableC1157oIX0oI(Activity activity) {
                this.f34441XO = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (JniInterface.f26980oIX0oI) {
                    Activity activity = this.f34441XO;
                    RunnableC1156oIX0oI runnableC1156oIX0oI = RunnableC1156oIX0oI.this;
                    xIxooxXX.I0Io i0Io = new xIxooxXX.I0Io(activity, "action_login", runnableC1156oIX0oI.f34439XO, runnableC1156oIX0oI.f34438Oo, ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c);
                    if (!this.f34441XO.isFinishing()) {
                        i0Io.show();
                        return;
                    }
                    return;
                }
                xxIXOIIO.oI0IIXIo("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                O0OOX0IIx.X0o0xo x0o0xo = new O0OOX0IIx.X0o0xo(this.f34441XO, "", oIX0oI.this.I0Io(""), null, ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c);
                if (!this.f34441XO.isFinishing()) {
                    x0o0xo.show();
                }
            }
        }

        public RunnableC1156oIX0oI(String str, o0Oo.II0xO0 iI0xO0) {
            this.f34439XO = str;
            this.f34438Oo = iI0xO0;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            Oxx0IOOO.OOXIXo(oIX0oI.f34415xxIXOIIO, oIX0oI.f34414xoIox, 3);
            JniInterface.oIX0oI();
            if (oIX0oI.this.f34416I0Io != null && (activity = (Activity) oIX0oI.this.f34416I0Io.get()) != null) {
                activity.runOnUiThread(new RunnableC1157oIX0oI(activity));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class oxoX implements o0Oo.II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Context f34442I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final boolean f34443II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final o0Oo.II0xO0 f34444oIX0oI;

        public oxoX(Context context, o0Oo.II0xO0 iI0xO0, boolean z, boolean z2) {
            this.f34442I0Io = context;
            this.f34444oIX0oI = iI0xO0;
            this.f34443II0xO0 = z;
            xxIXOIIO.XO("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // o0Oo.II0xO0
        public void oIX0oI(o0Oo.I0Io i0Io) {
            xxIXOIIO.XO("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f34444oIX0oI.oIX0oI(i0Io);
            xxIXOIIO.x0XOIxOo();
        }

        @Override // o0Oo.II0xO0
        public void onCancel() {
            xxIXOIIO.XO("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f34444oIX0oI.onCancel();
            xxIXOIIO.x0XOIxOo();
        }

        @Override // o0Oo.II0xO0
        public void onComplete(Object obj) {
            xxIXOIIO.XO("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (string != null && ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c != null && string3 != null) {
                    ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c.x0XOIxOo(string, string2);
                    ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c.Oo(string3);
                    oO.X0o0xo(this.f34442I0Io, ((com.tencent.connect.common.oIX0oI) oIX0oI.this).c);
                }
                String string4 = jSONObject.getString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0);
                if (string4 != null) {
                    try {
                        this.f34442I0Io.getSharedPreferences(com.tencent.connect.common.II0xO0.f26831XxX0x0xxx, 0).edit().putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, string4).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                        xxIXOIIO.xxIXOIIO("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.f34443II0xO0) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                xxIXOIIO.xxIXOIIO("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.f34444oIX0oI.onComplete(jSONObject);
            oIX0oI.this.oOoXoXO();
            xxIXOIIO.x0XOIxOo();
        }
    }

    static {
        f34414xoIox = f34415xxIXOIIO + ".so";
        String str = Build.CPU_ABI;
        if (str != null && !str.equals("")) {
            if (str.equalsIgnoreCase("arm64-v8a")) {
                f34415xxIXOIIO = f34410Oxx0IOOO;
                f34414xoIox = f34415xxIXOIIO + ".so";
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
                return;
            }
            if (str.equalsIgnoreCase("x86")) {
                f34415xxIXOIIO = f34413oxoX;
                f34414xoIox = f34415xxIXOIIO + ".so";
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "is x86 architecture");
                return;
            }
            if (str.equalsIgnoreCase("x86_64")) {
                f34415xxIXOIIO = f34411X0o0xo;
                f34414xoIox = f34415xxIXOIIO + ".so";
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "is x86_64 architecture");
                return;
            }
            f34415xxIXOIIO = f34412XO;
            f34414xoIox = f34415xxIXOIIO + ".so";
            xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "is arm(default) architecture");
            return;
        }
        f34415xxIXOIIO = f34412XO;
        f34414xoIox = f34415xxIXOIIO + ".so";
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public oIX0oI(xIxooxXX.II0xO0 iI0xO0) {
        super(iI0xO0);
    }

    public final boolean IXxxXO(Activity activity, Fragment fragment, boolean z) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent xxIXOIIO2 = xxIXOIIO("com.tencent.open.agent.AgentActivity");
        if (xxIXOIIO2 != null) {
            Bundle II0xO02 = II0xO0();
            if (z) {
                II0xO02.putString("isadd", "1");
            }
            II0xO02.putString("scope", this.f34417II0xO0);
            II0xO02.putString("client_id", this.c.X0o0xo());
            if (com.tencent.connect.common.oIX0oI.isOEM) {
                II0xO02.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, "desktop_m_qq-" + com.tencent.connect.common.oIX0oI.installChannel + HelpFormatter.DEFAULT_OPT_PREFIX + "android" + HelpFormatter.DEFAULT_OPT_PREFIX + com.tencent.connect.common.oIX0oI.registerChannel + HelpFormatter.DEFAULT_OPT_PREFIX + com.tencent.connect.common.oIX0oI.businessId);
            } else {
                II0xO02.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, com.tencent.connect.common.II0xO0.f26794OxxIIOOXO);
            }
            II0xO02.putString("need_pay", "1");
            II0xO02.putString(com.tencent.connect.common.II0xO0.f26760O0, Oxx0IOOO.XO(XxXX.X0o0xo.oIX0oI()));
            xxIXOIIO2.putExtra(com.tencent.connect.common.II0xO0.f26845oOo, "action_login");
            xxIXOIIO2.putExtra(com.tencent.connect.common.II0xO0.f26852oXIO0o0XI, II0xO02);
            xxIXOIIO2.putExtra("appid", this.c.X0o0xo());
            II0xO02.putString(com.tencent.connect.common.II0xO0.f26867oxIO0IIo, Oxx0IOOO.X0o0xo(activity, x0XOIxOo(II0xO02)));
            if (II0XooXoX(xxIXOIIO2)) {
                this.f34418oIX0oI = new I0Io(this.f34418oIX0oI);
                com.tencent.connect.common.I0Io.II0xO0().Oxx0IOOO(11101, this.f34418oIX0oI);
                if (fragment != null) {
                    xxIXOIIO.XO("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    Oxx0IOOO(fragment, xxIXOIIO2, 11101);
                } else {
                    xxIXOIIO.XO("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    X0o0xo(activity, xxIXOIIO2, 11101);
                }
                xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                OOXIXo.oIX0oI().II0xO0(0, "LOGIN_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        OOXIXo.oIX0oI().II0xO0(1, "LOGIN_CHECK_SDK", com.tencent.connect.common.II0xO0.f26842oIX0oI, this.c.X0o0xo(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    public void Oo(o0Oo.II0xO0 iI0xO0) {
        String str;
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String oxoX2 = this.c.oxoX();
        String II0XooXoX2 = this.c.II0XooXoX();
        String X0o0xo2 = this.c.X0o0xo();
        if (!TextUtils.isEmpty(oxoX2) && !TextUtils.isEmpty(II0XooXoX2) && !TextUtils.isEmpty(X0o0xo2)) {
            str = com.tencent.open.utils.II0xO0.IoOoX("tencent&sdk&qazxc***14969%%" + oxoX2 + X0o0xo2 + II0XooXoX2 + "qzone3.4");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            xxIXOIIO.II0XooXoX("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle II0xO02 = II0xO0();
        II0xO02.putString("encrytoken", str);
        HttpUtils.oOoXoXO(this.c, XxXX.X0o0xo.oIX0oI(), "https://openmobile.qq.com/user/user_login_statis", II0xO02, "POST", null);
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }

    public int OxI(Activity activity, String str, o0Oo.II0xO0 iI0xO0, boolean z, Fragment fragment, boolean z2) {
        this.f34417II0xO0 = str;
        this.f34416I0Io = new WeakReference<>(activity);
        this.f34418oIX0oI = iI0xO0;
        if (!activity.getIntent().getBooleanExtra(f34409II0XooXoX, false) && !com.tencent.open.utils.oIX0oI.oxoX(activity, this.c.X0o0xo()).xoIox("C_LoginWeb") && IXxxXO(activity, fragment, z)) {
            xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            OOXIXo.oIX0oI().oxoX(this.c.II0XooXoX(), this.c.X0o0xo(), "2", "1", "5", "0", "0", "0");
            return 1;
        }
        OOXIXo.oIX0oI().oxoX(this.c.II0XooXoX(), this.c.X0o0xo(), "2", "1", "5", "1", "0", "0");
        xxIXOIIO.oI0IIXIo("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        I0Io i0Io = new I0Io(this.f34418oIX0oI);
        this.f34418oIX0oI = i0Io;
        return ooOOo0oXI(z, i0Io, z2);
    }

    public int o00(Activity activity, String str, o0Oo.II0xO0 iI0xO0, boolean z, Fragment fragment) {
        return OxI(activity, str, iI0xO0, z, fragment, false);
    }

    public void oI0IIXIo(o0Oo.II0xO0 iI0xO0) {
        Bundle II0xO02 = II0xO0();
        II0xO02.putString("reqType", "checkLogin");
        HttpUtils.oOoXoXO(this.c, XxXX.X0o0xo.oIX0oI(), "https://openmobile.qq.com/v3/user/get_info", II0xO02, "GET", new oIX0oI.C1086oIX0oI(new II0xO0(iI0xO0)));
    }

    @Override // com.tencent.connect.common.oIX0oI
    public void oOoXoXO() {
        this.f34418oIX0oI = null;
    }

    public final int ooOOo0oXI(boolean z, o0Oo.II0xO0 iI0xO0, boolean z2) {
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(XxXX.X0o0xo.oIX0oI());
        Bundle II0xO02 = II0xO0();
        if (z) {
            II0xO02.putString("isadd", "1");
        }
        II0xO02.putString("scope", this.f34417II0xO0);
        II0xO02.putString("client_id", this.c.X0o0xo());
        if (com.tencent.connect.common.oIX0oI.isOEM) {
            II0xO02.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, "desktop_m_qq-" + com.tencent.connect.common.oIX0oI.installChannel + HelpFormatter.DEFAULT_OPT_PREFIX + "android" + HelpFormatter.DEFAULT_OPT_PREFIX + com.tencent.connect.common.oIX0oI.registerChannel + HelpFormatter.DEFAULT_OPT_PREFIX + com.tencent.connect.common.oIX0oI.businessId);
        } else {
            II0xO02.putString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0, com.tencent.connect.common.II0xO0.f26794OxxIIOOXO);
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        II0xO02.putString(HttpConstants.SIGN, Oxx0IOOO.oOoXoXO(XxXX.X0o0xo.oIX0oI(), str));
        II0xO02.putString("time", str);
        II0xO02.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "mobile");
        II0xO02.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "token");
        II0xO02.putString("redirect_uri", "auth://tauth.qq.com/");
        II0xO02.putString("cancel_display", "1");
        II0xO02.putString("switch", "1");
        II0xO02.putString("status_userip", com.tencent.open.utils.II0xO0.Oxx0IOOO());
        if (z2) {
            II0xO02.putString("style", IXxxXO.f20845OI0);
        }
        String str2 = XO.oIX0oI().II0xO0(XxXX.X0o0xo.oIX0oI(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.XO(II0xO02);
        oxoX oxox = new oxoX(XxXX.X0o0xo.oIX0oI(), iI0xO0, true, false);
        xxIXOIIO.XO("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        II0XooXoX.II0xO0(new RunnableC1156oIX0oI(str2, oxox));
        xxIXOIIO.oOoXoXO("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    public final String x0XOIxOo(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString("sdkv");
        String string5 = bundle.getString("client_id");
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString(com.tencent.connect.common.II0xO0.f26810XIxXXX0x0);
        xxIXOIIO.XO("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
        StringBuilder sb = new StringBuilder();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb.append(string7);
        return sb.toString();
    }

    public int xoXoI(Activity activity, String str, o0Oo.II0xO0 iI0xO0) {
        return o00(activity, str, iI0xO0, false, null);
    }
}
