package IO0XoXxO;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.octopus.ad.widget.ScrollClickView;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class xxIXOIIO {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f452I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f453II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f454II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public ScrollClickView f455Oxx0IOOO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Context f458oIX0oI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f460xxIXOIIO;

    /* renamed from: oxoX, reason: collision with root package name */
    public oxoX f459oxoX = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f456X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public int f457XO = 200;

    /* loaded from: classes11.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xxIXOIIO.this.f455Oxx0IOOO != null) {
                xxIXOIIO.this.f455Oxx0IOOO.xoIox();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ FrameLayout.LayoutParams f462IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ int f463Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f465XO;

        public II0xO0(int i, int i2, FrameLayout.LayoutParams layoutParams) {
            this.f465XO = i;
            this.f463Oo = i2;
            this.f462IXxxXO = layoutParams;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (xxIXOIIO.this.f455Oxx0IOOO == null) {
                return;
            }
            xxIXOIIO.this.f455Oxx0IOOO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int measuredWidth = xxIXOIIO.this.f455Oxx0IOOO.getMeasuredWidth();
            xxIXOIIO xxixoiio = xxIXOIIO.this;
            if (xxixoiio.f460xxIXOIIO == 0) {
                xxixoiio.f460xxIXOIIO = I0oOoX.x0XOIxOo(xxixoiio.f458oIX0oI, this.f465XO) / 2;
            }
            xxIXOIIO xxixoiio2 = xxIXOIIO.this;
            if (xxixoiio2.f453II0XooXoX == 0) {
                xxixoiio2.f453II0XooXoX = I0oOoX.x0XOIxOo(xxixoiio2.f458oIX0oI, this.f463Oo) / 2;
            }
            FrameLayout.LayoutParams layoutParams = this.f462IXxxXO;
            xxIXOIIO xxixoiio3 = xxIXOIIO.this;
            layoutParams.topMargin = xxixoiio3.f460xxIXOIIO;
            layoutParams.leftMargin = xxixoiio3.f453II0XooXoX - (measuredWidth / 2);
            xxixoiio3.f455Oxx0IOOO.setLayoutParams(this.f462IXxxXO);
            o0IXXIx.II0XooXoX.oIX0oI("ScrollClickUtil", "topMargin = " + this.f462IXxxXO.topMargin + ",leftMargin = " + this.f462IXxxXO.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xxIXOIIO.this.Oxx0IOOO();
        }
    }

    /* loaded from: classes11.dex */
    public interface oxoX {
        void oIX0oI(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public xxIXOIIO(Context context) {
        this.f458oIX0oI = context;
    }

    public static Pair<Integer, Boolean> xxIXOIIO(int i) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    public void I0Io() {
        oxoX(1000);
        II0XooXoX(0);
    }

    public void II0XooXoX(int i) {
        this.f452I0Io = i;
        OOXIXo();
    }

    public final void OOXIXo() {
        if (((Boolean) xxIXOIIO(this.f452I0Io).second).booleanValue()) {
            IO0XoXxO.oxoX.oIX0oI(new oIX0oI(), this.f454II0xO0 + (((Integer) r0.first).intValue() * 10));
        }
    }

    public void Oxx0IOOO() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        if (this.f459oxoX != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(",!isCallBack = ");
        sb.append(!this.f456X0o0xo);
        o0IXXIx.II0XooXoX.oIX0oI("ScrollClickUtil", sb.toString());
        if (this.f459oxoX != null && !this.f456X0o0xo) {
            o0IXXIx.II0XooXoX.oIX0oI("ScrollClickUtil", "callback onShakeHappened()");
            this.f459oxoX.oIX0oI("100", "200", "105", "206", "100", "200", "105", "206");
            this.f456X0o0xo = true;
            ScrollClickView scrollClickView = this.f455Oxx0IOOO;
            if (scrollClickView != null) {
                scrollClickView.OOXIXo();
            }
        }
    }

    public void X0o0xo(oxoX oxox) {
        this.f459oxoX = oxox;
    }

    public View oIX0oI(int i, int i2, String str) {
        o0IXXIx.II0XooXoX.oIX0oI("ScrollClickUtil", "enter getScrollClick");
        if (this.f458oIX0oI == null) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = "向上滑动跳转至\n第三方应用或详情页";
            }
            ScrollClickView scrollClickView = new ScrollClickView(this.f458oIX0oI);
            this.f455Oxx0IOOO = scrollClickView;
            scrollClickView.setScrollDirection("up");
            this.f455Oxx0IOOO.setTitleText(str);
            int parseInt = Integer.parseInt("50");
            int parseInt2 = Integer.parseInt("80");
            float f = i / 360.0f;
            this.f455Oxx0IOOO.setTitleFont((int) (14.0f * f));
            this.f455Oxx0IOOO.setHandWidth((int) (parseInt * f));
            this.f455Oxx0IOOO.setScrollbarHeight((int) (parseInt2 * f));
            this.f455Oxx0IOOO.XO();
            String str2 = "52%";
            TextUtils.isEmpty("50%");
            if (TextUtils.isEmpty("52%")) {
                str2 = "50%";
            }
            if ("50%".endsWith("%")) {
                this.f453II0XooXoX = (Integer.parseInt("50%".substring(0, "50%".indexOf("%"))) * i) / 100;
            } else {
                this.f453II0XooXoX = Integer.parseInt("50%");
            }
            if (str2.endsWith("%")) {
                this.f460xxIXOIIO = (Integer.parseInt(str2.substring(0, str2.indexOf("%"))) * i2) / 100;
            } else {
                this.f460xxIXOIIO = Integer.parseInt(str2);
            }
            this.f453II0XooXoX = I0oOoX.x0XOIxOo(this.f458oIX0oI, this.f453II0XooXoX);
            this.f460xxIXOIIO = I0oOoX.x0XOIxOo(this.f458oIX0oI, this.f460xxIXOIIO);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            o0IXXIx.II0XooXoX.oIX0oI("ScrollClickUtil", "topInt = " + this.f460xxIXOIIO + ",centerXInt = " + this.f453II0XooXoX + ",adWidthDp = " + i + ",adHeightDp = " + i2);
            this.f455Oxx0IOOO.getViewTreeObserver().addOnGlobalLayoutListener(new II0xO0(i2, i, layoutParams));
            this.f455Oxx0IOOO.setLayoutParams(layoutParams);
            this.f455Oxx0IOOO.postDelayed(new I0Io(), 10L);
            return this.f455Oxx0IOOO;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void oxoX(int i) {
        this.f454II0xO0 = i;
    }

    public void xoIox() {
        this.f456X0o0xo = false;
        ScrollClickView scrollClickView = this.f455Oxx0IOOO;
        if (scrollClickView != null) {
            scrollClickView.OOXIXo();
        }
        this.f459oxoX = null;
        this.f458oIX0oI = null;
        this.f455Oxx0IOOO = null;
        this.f457XO = 200;
    }
}
