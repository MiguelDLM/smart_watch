package x0;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.xoIox;
import x0OxxIOxX.oIX0oI;

/* loaded from: classes11.dex */
public class I0oOoX {

    /* loaded from: classes11.dex */
    public class X0o0xo extends ClickableSpan {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ X0xII0I.oIX0oI f33677XO;

        public X0o0xo(X0xII0I.oIX0oI oix0oi) {
            this.f33677XO = oix0oi;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            I0oOoX.xoXoI(this.f33677XO.Oxx0IOOO());
        }
    }

    /* loaded from: classes11.dex */
    public class XO extends ClickableSpan {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ X0xII0I.oIX0oI f33678XO;

        public XO(X0xII0I.oIX0oI oix0oi) {
            this.f33678XO = oix0oi;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            I0oOoX.xoXoI(this.f33678XO.X0o0xo());
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX extends ClickableSpan {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ X0xII0I.oIX0oI f33679XO;

        public oxoX(X0xII0I.oIX0oI oix0oi) {
            this.f33679XO = oix0oi;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            I0oOoX.xoXoI(this.f33679XO.XO());
        }
    }

    public static FrameLayout I0Io(Context context, oIX0oI.oxoX oxox, int i) {
        float f;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(4);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        if (oxox != null) {
            xoIox oIX0oI2 = xoIox.oIX0oI();
            if (i > 0) {
                f = i / 640.0f;
            } else {
                f = 1.0f;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (oxox.oxoX() == oIX0oI.oxoX.f33946I0Io) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int applyDimension = (int) TypedValue.applyDimension(1, f * 14.0f, oIX0oI2.xoXoI());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension * 2, applyDimension, 8388691);
                layoutParams.setMargins(0, 0, 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
                oOXoIIIo.II0XooXoX(context).Oxx0IOOO(oxox.I0Io()).I0Io(imageView);
                frameLayout.addView(imageView);
            } else if (oxox.oxoX() == oIX0oI.oxoX.f33947oxoX) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                appCompatTextView.setTextSize(2, f * 10.0f);
                appCompatTextView.setTextColor(-1);
                appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
                appCompatTextView.setText(oxox.I0Io());
                new FrameLayout.LayoutParams(-2, -2, 8388691).setMargins(0, 0, 0, 0);
                frameLayout.addView(appCompatTextView);
            }
        }
        return frameLayout;
    }

    public static AppCompatTextView II0XooXoX(Context context, int i, int i2, int i3, int i4, int i5) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.oct_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.oct_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        appCompatTextView.setMinimumWidth((int) TypedValue.applyDimension(1, 30.0f, oIX0oI2.xoXoI()));
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i2 + 5, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, i3 + 15, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, i4 + 15, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, i5 + 10, oIX0oI2.xoXoI()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new II0xO0());
        return appCompatTextView;
    }

    public static void II0xO0(Activity activity, int[] iArr) {
        float f = activity.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] / f) + 0.5f);
        }
    }

    public static int IIXOooo(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int[] IXxxXO(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return new int[]{point.x, point.y};
    }

    public static void O0xOxO(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public static ProgressBar OOXIXo(Context context) {
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.getIndeterminateDrawable().setColorFilter(-3355444, PorterDuff.Mode.SRC_IN);
        int applyDimension = (int) TypedValue.applyDimension(1, 40.0f, xoIox.oIX0oI().xoXoI());
        progressBar.setLayoutParams(new FrameLayout.LayoutParams(applyDimension, applyDimension, 17));
        return progressBar;
    }

    public static int[] Oo(Activity activity) {
        int[] IXxxXO2 = IXxxXO(activity);
        II0xO0(activity, IXxxXO2);
        return IXxxXO2;
    }

    public static int OxI(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AppCompatTextView Oxx0IOOO(Context context, int i) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.oct_count_down_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.oct_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(Integer.toString(i));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, oIX0oI2.xoXoI()), -2, 53);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 10.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 5.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 10.0f, oIX0oI2.xoXoI()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new oIX0oI());
        return appCompatTextView;
    }

    public static int Oxx0xo(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Context OxxIIOOXO(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        boolean z = parent instanceof View;
        ViewParent viewParent = parent;
        if (!z) {
            if (view.getContext() instanceof MutableContextWrapper) {
                return ((MutableContextWrapper) view.getContext()).getBaseContext();
            }
            return view.getContext();
        }
        while (viewParent.getParent() != null && (viewParent.getParent() instanceof View)) {
            viewParent = viewParent.getParent();
        }
        return ((View) viewParent).getContext();
    }

    public static AppCompatTextView X0o0xo(Context context, int i, int i2, int i3, int i4) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.oct_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.oct_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(R.string.skip_ad);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, i + 5, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, i2 + 15, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, i3 + 52, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, i4 + 10, oIX0oI2.xoXoI()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static AppCompatTextView XO(Context context, X0xII0I.oIX0oI oix0oi, float f, boolean z) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        if (oix0oi == null) {
            return appCompatTextView;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        appCompatTextView.setTextSize(8.0f * f);
        int i = (int) (f * 10.0f);
        if (z) {
            appCompatTextView.setPadding(i, i, i, i);
        } else {
            appCompatTextView.setPadding(i * 2, i, i * 7, i);
        }
        String format = String.format("应用名称：%1$s | 开发者：%2$s | 应用版本：%3$s | 权限详情 | 隐私协议 | 功能介绍", oix0oi.II0xO0(), oix0oi.oxoX(), oix0oi.I0Io());
        SpannableString spannableString = new SpannableString(format);
        oxoX oxox = new oxoX(oix0oi);
        int indexOf = format.indexOf("权限详情");
        spannableString.setSpan(oxox, indexOf, indexOf + 4, 17);
        X0o0xo x0o0xo = new X0o0xo(oix0oi);
        int indexOf2 = format.indexOf("隐私协议");
        spannableString.setSpan(x0o0xo, indexOf2, indexOf2 + 4, 17);
        XO xo2 = new XO(oix0oi);
        int indexOf3 = format.indexOf("功能介绍");
        spannableString.setSpan(xo2, indexOf3, indexOf3 + 4, 17);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, spannableString.length(), 33);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
        appCompatTextView.setText(spannableString);
        return appCompatTextView;
    }

    public static void o00(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float oI0IIXIo(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static void oIX0oI(Activity activity, int[] iArr) {
        float f = activity.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] * f) + 0.5f);
        }
    }

    public static int oO(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static FrameLayout oOoXoXO(Context context, oIX0oI.oxoX oxox, int i) {
        float f;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setVisibility(4);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        if (oxox != null) {
            xoIox oIX0oI2 = xoIox.oIX0oI();
            if (i > 0) {
                f = i / 640.0f;
            } else {
                f = 1.0f;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (oxox.oxoX() == oIX0oI.oxoX.f33946I0Io) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                int applyDimension = (int) TypedValue.applyDimension(1, f * 14.0f, oIX0oI2.xoXoI());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 8388693);
                layoutParams.setMargins(0, 0, 0, 0);
                imageView.setLayoutParams(layoutParams);
                imageView.setVisibility(0);
                oOXoIIIo.II0XooXoX(context).Oxx0IOOO(oxox.I0Io()).I0Io(imageView);
                frameLayout.addView(imageView);
            } else if (oxox.oxoX() == oIX0oI.oxoX.f33947oxoX) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                appCompatTextView.setTextSize(2, f * 10.0f);
                appCompatTextView.setTextColor(-1);
                appCompatTextView.setShadowLayer(5.0f, 1.0f, 1.0f, Color.parseColor("#80000000"));
                appCompatTextView.setText(oxox.I0Io());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 8388693);
                layoutParams2.setMargins(0, 0, 0, 0);
                frameLayout.addView(appCompatTextView, layoutParams2);
            }
        }
        return frameLayout;
    }

    public static AppCompatImageView ooOOo0oXI(Context context, boolean z) {
        int i;
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        if (z) {
            i = R.drawable.oct_voice_off;
        } else {
            i = R.drawable.oct_voice_on;
        }
        appCompatImageView.setImageResource(i);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        int applyDimension = (int) TypedValue.applyDimension(1, 25.0f, oIX0oI2.xoXoI());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 8388659);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 15.0f, oIX0oI2.xoXoI());
        layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        appCompatImageView.setLayoutParams(layoutParams);
        return appCompatImageView;
    }

    public static AppCompatTextView oxoX(Context context) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.oct_close_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.oct_text_selector));
        appCompatTextView.setTextSize(2, 12.0f);
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(R.string.skip_ad);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 5.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 10.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 42.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 10.0f, oIX0oI2.xoXoI()));
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    public static int x0XOIxOo(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float x0xO0oo(Context context) {
        return OxI(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static AppCompatTextView xoIox(Context context, int i, float f) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.oct_count_down_interstitial_background));
        appCompatTextView.setTextColor(ContextCompat.getColorStateList(context, R.color.oct_text_selector));
        appCompatTextView.setTextSize(2, 12.0f * f);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        appCompatTextView.setGravity(17);
        appCompatTextView.setText(String.valueOf(i));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, f * 30.0f, oIX0oI2.xoXoI()), -2, 8388661);
        layoutParams.setMargins((int) TypedValue.applyDimension(1, 0.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 0.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 0.0f, oIX0oI2.xoXoI()), (int) TypedValue.applyDimension(1, 0.0f, oIX0oI2.xoXoI()));
        appCompatTextView.setLayoutParams(layoutParams);
        appCompatTextView.setOnClickListener(new I0Io());
        return appCompatTextView;
    }

    public static void xoXoI(String str) {
        Class<AdActivity> oIX0oI2 = AdActivity.oIX0oI();
        try {
            Context x0xO0oo2 = xoIox.oIX0oI().x0xO0oo();
            if (x0xO0oo2 != null && !TextUtils.isEmpty(str)) {
                WebView webView = new WebView(new MutableContextWrapper(x0xO0oo2));
                oxXx0IX.XO(webView);
                webView.loadUrl(str);
                Intent intent = new Intent(x0xO0oo2, oIX0oI2);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "BROWSER");
                oI.oIX0oI.f31320I0Io.add(webView);
                x0xO0oo2.startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.adactivity_missing, oIX0oI2.getName()));
            oI.oIX0oI.f31320I0Io.remove();
        } catch (Exception e) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Exception initializing the redirect webview: " + e.getMessage());
        }
    }

    public static ImageView xxIXOIIO(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.oct_close);
        xoIox oIX0oI2 = xoIox.oIX0oI();
        int applyDimension = (int) TypedValue.applyDimension(1, 18.0f, oIX0oI2.xoXoI());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 8388661);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 3.0f, oIX0oI2.xoXoI());
        layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    /* loaded from: classes11.dex */
    public class I0Io implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
