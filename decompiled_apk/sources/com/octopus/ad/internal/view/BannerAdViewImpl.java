package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.octopus.ad.R;
import com.octopus.ad.internal.animation.Animator;
import com.octopus.ad.internal.animation.TransitionDirection;
import com.octopus.ad.internal.animation.TransitionType;
import com.octopus.ad.internal.c;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.xoIox;
import oOoIIO0.o00;
import x0.oxXx0IX;
import x0OxxIOxX.II0xO0;

/* loaded from: classes11.dex */
public class BannerAdViewImpl extends AdViewImpl {

    /* renamed from: IXO, reason: collision with root package name */
    public boolean f18963IXO;

    /* renamed from: IoXIXo, reason: collision with root package name */
    public Animator f18964IoXIXo;

    /* renamed from: Ix00oIoI, reason: collision with root package name */
    public boolean f18965Ix00oIoI;

    /* renamed from: IxIX0I, reason: collision with root package name */
    public boolean f18966IxIX0I;

    /* renamed from: O0IxXx, reason: collision with root package name */
    public boolean f18967O0IxXx;

    /* renamed from: X0xII0I, reason: collision with root package name */
    public int f18968X0xII0I;

    /* renamed from: X0xxXX0, reason: collision with root package name */
    public int f18969X0xxXX0;

    /* renamed from: XXoOx0, reason: collision with root package name */
    public boolean f18970XXoOx0;

    /* renamed from: oI, reason: collision with root package name */
    public boolean f18971oI;

    /* renamed from: oOoIIO0, reason: collision with root package name */
    public BroadcastReceiver f18972oOoIIO0;

    /* renamed from: x0, reason: collision with root package name */
    public a f18973x0;

    /* renamed from: x0OIX00oO, reason: collision with root package name */
    public int f18974x0OIX00oO;

    /* renamed from: x0OxxIOxX, reason: collision with root package name */
    public com.octopus.ad.internal.view.I0Io f18975x0OxxIOxX;

    /* renamed from: xXoOI00O, reason: collision with root package name */
    public boolean f18976xXoOI00O;

    /* renamed from: xxOXOOoIX, reason: collision with root package name */
    public boolean f18977xxOXOOoIX;

    /* loaded from: classes11.dex */
    public class I0Io implements Animation.AnimationListener {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Animator f18979II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final com.octopus.ad.internal.view.I0Io f18980oIX0oI;

        /* loaded from: classes11.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ com.octopus.ad.internal.view.I0Io f18982Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Animator f18983XO;

            public oIX0oI(Animator animator, com.octopus.ad.internal.view.I0Io i0Io) {
                this.f18983XO = animator;
                this.f18982Oo = i0Io;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f18983XO.clearAnimation();
                this.f18982Oo.destroy();
                this.f18983XO.oIX0oI();
            }
        }

        public I0Io(com.octopus.ad.internal.view.I0Io i0Io, Animator animator) {
            this.f18980oIX0oI = i0Io;
            this.f18979II0xO0 = animator;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            animation.setAnimationListener(null);
            com.octopus.ad.internal.view.I0Io i0Io = this.f18980oIX0oI;
            Animator animator = this.f18979II0xO0;
            if (i0Io != null && animator != null) {
                i0Io.getView().getHandler().post(new oIX0oI(animator, i0Io));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f18984oIX0oI;

        static {
            int[] iArr = new int[a.values().length];
            f18984oIX0oI = iArr;
            try {
                iArr[a.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18984oIX0oI[a.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18984oIX0oI[a.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18984oIX0oI[a.CENTER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18984oIX0oI[a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18984oIX0oI[a.CENTER_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18984oIX0oI[a.BOTTOM_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18984oIX0oI[a.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18984oIX0oI[a.BOTTOM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public enum a {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        CENTER_LEFT,
        CENTER,
        CENTER_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT;

        public int a() {
            switch (II0xO0.f18984oIX0oI[ordinal()]) {
                case 1:
                    return 51;
                case 2:
                    return 49;
                case 3:
                    return 53;
                case 4:
                    return 19;
                case 5:
                default:
                    return 17;
                case 6:
                    return 21;
                case 7:
                    return 83;
                case 8:
                    return 81;
                case 9:
                    return 85;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI extends BroadcastReceiver {
        public oIX0oI() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                BannerAdViewImpl.this.XIo0oOXIx();
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.screen_off_stop));
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                if (BannerAdViewImpl.this.f18974x0OIX00oO > 0) {
                    BannerAdViewImpl.this.OO0x0xX();
                } else if (BannerAdViewImpl.this.f18966IxIX0I) {
                    BannerAdViewImpl.this.XIo0oOXIx();
                    BannerAdViewImpl.this.OO0x0xX();
                } else {
                    return;
                }
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.screen_on_start));
            }
        }
    }

    public BannerAdViewImpl(Context context) {
        super(context);
        this.f18976xXoOI00O = true;
    }

    public boolean I0xX0() {
        return this.f18976xXoOI00O;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void IIX0o() {
        com.octopus.ad.internal.view.I0Io i0Io = this.f18975x0OxxIOxX;
        if (i0Io != null) {
            i0Io.onPause();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void IoOoo() {
    }

    public final void O0X() {
        if (this.f18974x0OIX00oO > 0) {
            xOOOX();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean O0Xx() {
        return true;
    }

    public void OO0x0xX() {
        if (!this.f18970XXoOx0) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.start));
            this.f18774OI0.Oxx0IOOO();
            this.f18970XXoOx0 = true;
        }
    }

    @SuppressLint({"NewApi"})
    public void OX(int i, int i2, com.octopus.ad.internal.view.I0Io i0Io) {
        int width;
        int height;
        if (getWidth() <= 0) {
            width = getMeasuredWidth();
        } else {
            width = getWidth();
        }
        if (getHeight() <= 0) {
            height = getMeasuredHeight();
        } else {
            height = getHeight();
        }
        if (height > 0 && width > 0) {
            float f = i / width;
            float f2 = i2 / height;
            View view = i0Io.getView();
            if (f < f2) {
                width = (i * height) / i2;
                if (view instanceof WebView) {
                    ((WebView) view).setInitialScale((int) Math.ceil((height * 100) / i2));
                }
            } else {
                height = (i2 * width) / i;
                if (view instanceof WebView) {
                    ((WebView) view).setInitialScale((int) Math.ceil((width * 100) / i));
                }
            }
            if (view.getLayoutParams() == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                view.setLayoutParams(layoutParams);
            } else {
                view.getLayoutParams().width = width;
                view.getLayoutParams().height = height;
                ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 17;
            }
            view.invalidate();
            return;
        }
        com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Unable to resize ad to fit container because of failure to obtain the container size.");
    }

    public void Oxx() {
        if (this.f18963IXO) {
            ooOx();
        }
    }

    public void XIo0oOXIx() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.stop));
        this.f18774OI0.oxoX();
        this.f18970XXoOx0 = false;
    }

    @SuppressLint({"NewApi"})
    public void XXXI(int i, int i2, com.octopus.ad.internal.view.I0Io i0Io) {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i3 = point.x;
        int floor = (int) Math.floor(i2 * (i3 / i));
        this.f18968X0xII0I = getLayoutParams().height;
        this.f18969X0xxXX0 = getLayoutParams().width;
        if (getLayoutParams().width > 0 || getLayoutParams().width == -2) {
            getLayoutParams().width = i3;
        }
        getLayoutParams().height = floor;
        View view = i0Io.getView();
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } else {
            view.getLayoutParams().width = -1;
            view.getLayoutParams().height = -1;
        }
        view.invalidate();
        this.f18963IXO = true;
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        c cVar = this.f18774OI0;
        if (cVar != null) {
            cVar.oxoX();
        }
    }

    public a getAdAlignment() {
        if (this.f18973x0 == null) {
            this.f18973x0 = a.CENTER;
        }
        return this.f18973x0;
    }

    public int getAdHeight() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.get_height, this.f18784X00IoxXI.Oxx0xo()));
        return this.f18784X00IoxXI.Oxx0xo();
    }

    public int getAdWidth() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.get_width, this.f18784X00IoxXI.IXxxXO()));
        return this.f18784X00IoxXI.IXxxXO();
    }

    public int getAutoRefreshInterval() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.get_period, this.f18974x0OIX00oO));
        return this.f18974x0OIX00oO;
    }

    public boolean getExpandsToFitScreenWidth() {
        return this.f18971oI;
    }

    @Override // com.octopus.ad.internal.oIX0oI
    public l getMediaType() {
        if (this.f18791XO) {
            return l.SPLASH;
        }
        return l.BANNER;
    }

    public boolean getResizeAdToFitContainer() {
        return this.f18965Ix00oIoI;
    }

    public boolean getShouldReloadOnResume() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.get_should_resume, this.f18966IxIX0I));
        return this.f18966IxIX0I;
    }

    public TransitionDirection getTransitionDirection() {
        return this.f18964IoXIXo.getTransitionDirection();
    }

    public long getTransitionDuration() {
        return this.f18964IoXIXo.getTransitionDuration();
    }

    public TransitionType getTransitionType() {
        return this.f18964IoXIXo.getTransitionType();
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void o00(com.octopus.ad.internal.view.I0Io i0Io) {
        int refreshInterval;
        if (i0Io != null && !i0Io.oIX0oI() && i0Io.getView() != null) {
            if (this.f18800XxX0x0xxx == i0Io) {
                return;
            }
            this.f18975x0OxxIOxX = i0Io;
            if (getTransitionType() == TransitionType.NONE) {
                removeAllViews();
                com.octopus.ad.internal.view.I0Io i0Io2 = this.f18800XxX0x0xxx;
                if (i0Io2 != null) {
                    i0Io2.destroy();
                }
                View view = i0Io.getView();
                addView(view, new ViewGroup.LayoutParams(-1, -1));
                if (view.getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = getAdAlignment().a();
                }
                if (i0Io.getView() instanceof AdVideoView) {
                    i0Io.II0xO0();
                }
            } else {
                if (i0Io.getView().getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) i0Io.getView().getLayoutParams()).gravity = getAdAlignment().a();
                    this.f18964IoXIXo.setLayoutParams(i0Io.getView().getLayoutParams());
                }
                if (getChildCount() != 0 && indexOfChild(this.f18964IoXIXo) != -1) {
                    if (i0Io.getView() instanceof AdVideoView) {
                        i0Io.II0xO0();
                    }
                    this.f18964IoXIXo.addView(i0Io.getView());
                    this.f18964IoXIXo.showNext();
                } else {
                    removeAllViews();
                    if (i0Io.getView() instanceof AdVideoView) {
                        i0Io.II0xO0();
                    }
                    addView(this.f18964IoXIXo, 0);
                    this.f18964IoXIXo.addView(i0Io.getView());
                }
                com.octopus.ad.internal.view.I0Io i0Io3 = this.f18800XxX0x0xxx;
                if (i0Io3 != null) {
                    if (i0Io3.getView().getAnimation() != null) {
                        i0Io3.getView().getAnimation().setAnimationListener(new I0Io(i0Io3, this.f18964IoXIXo));
                    } else {
                        i0Io3.destroy();
                    }
                }
            }
            o0();
            if (!this.f18791XO && (refreshInterval = i0Io.getRefreshInterval()) > 0 && this.f18976xXoOI00O) {
                setAutoRefreshInterval(refreshInterval * 1000);
            }
            this.f18800XxX0x0xxx = i0Io;
            return;
        }
        xI0oxI00(oOoIIO0.I0Io.f32012II0XooXoX);
        com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Loaded an ad with an invalid displayable");
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean oXIO0o0XI(II0xO0.C1145II0xO0 c1145II0xO0) {
        if (super.oXIO0o0XI(c1145II0xO0)) {
            this.f18970XXoOx0 = true;
            return true;
        }
        return false;
    }

    public void oXIoO(int i, int i2) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xoIox(R.string.set_size, i, i2));
        this.f18784X00IoxXI.Oxx0IOOO(i);
        this.f18784X00IoxXI.OOXIXo(i2);
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f18820xI) {
            this.f18820xI = false;
            return;
        }
        if (!this.f18967O0IxXx || z) {
            xoIox oIX0oI2 = xoIox.oIX0oI();
            int oI0IIXIo2 = (int) (((i3 - i) / oIX0oI2.oI0IIXIo()) + 0.5f);
            int OxxIIOOXO2 = (int) (((i4 - i2) / oIX0oI2.OxxIIOOXO()) + 0.5f);
            if (oI0IIXIo2 >= this.f18784X00IoxXI.IXxxXO() && (OxxIIOOXO2 >= this.f18784X00IoxXI.Oxx0xo() || oI0IIXIo2 <= 0 || OxxIIOOXO2 <= 0)) {
                this.f18784X00IoxXI.oO(oI0IIXIo2);
                this.f18784X00IoxXI.Oo(OxxIIOOXO2);
                if (!this.f18967O0IxXx) {
                    xXOx();
                }
                this.f18967O0IxXx = true;
            } else {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.OOXIXo(R.string.adsize_too_big, oI0IIXIo2, OxxIIOOXO2, this.f18784X00IoxXI.IXxxXO(), this.f18784X00IoxXI.Oxx0xo()));
                xXOx();
                c cVar = this.f18774OI0;
                if (cVar != null) {
                    cVar.oxoX();
                    return;
                }
                return;
            }
        }
        if (this.f18970XXoOx0) {
            xOOOX();
            if (this.f18966IxIX0I) {
                OO0x0xX();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            xOOOX();
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.unhidden));
            if ((this.f18970XXoOx0 || this.f18966IxIX0I || this.f18974x0OIX00oO > 0) && !this.f18810oo && !this.f18820xI && !XIxXXX0x0() && this.f18774OI0 != null) {
                OO0x0xX();
            }
            this.f18810oo = false;
            if (getChildAt(0) instanceof WebView) {
                oxXx0IX.X0o0xo((WebView) getChildAt(0));
                return;
            }
            return;
        }
        o0IXXIx.II0XooXoX.I0Io("OctopusAd", "enter onWindowVisibilityChanged before dismantleBroadcast");
        xOoOIoI();
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.hidden));
        if (this.f18774OI0 != null && this.f18970XXoOx0) {
            XIo0oOXIx();
        }
        if (getChildAt(0) instanceof WebView) {
            oxXx0IX.oxoX((WebView) getChildAt(0));
        }
    }

    public void ooOx() {
        this.f18963IXO = false;
        if (getLayoutParams() != null) {
            getLayoutParams().height = this.f18968X0xII0I;
            getLayoutParams().width = this.f18969X0xxXX0;
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void ooXIXxIX() {
        com.octopus.ad.internal.view.I0Io i0Io = this.f18975x0OxxIOxX;
        if (i0Io != null) {
            i0Io.onResume();
        }
    }

    public void setAdAlignment(a aVar) {
        this.f18973x0 = aVar;
    }

    public void setAutoRefresh(boolean z) {
        this.f18976xXoOI00O = z;
    }

    public void setAutoRefreshInterval(int i) {
        if (i > 0) {
            this.f18974x0OIX00oO = Math.max(10000, i);
        } else {
            this.f18974x0OIX00oO = i;
        }
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.set_period, this.f18974x0OIX00oO));
        c cVar = this.f18774OI0;
        if (cVar != null) {
            cVar.X0o0xo(this.f18974x0OIX00oO);
        }
    }

    public void setExpandsToFitScreenWidth(boolean z) {
        this.f18971oI = z;
    }

    public void setResizeAdToFitContainer(boolean z) {
        this.f18965Ix00oIoI = z;
    }

    public void setShouldReloadOnResume(boolean z) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.set_should_resume, z));
        this.f18966IxIX0I = z;
    }

    public void setTransitionDirection(TransitionDirection transitionDirection) {
        this.f18964IoXIXo.setTransitionDirection(transitionDirection);
    }

    public void setTransitionDuration(long j) {
        this.f18964IoXIXo.setTransitionDuration(j);
    }

    public void setTransitionType(TransitionType transitionType) {
        this.f18964IoXIXo.setTransitionType(transitionType);
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void xII(Context context, AttributeSet attributeSet) {
        xX0IIXIx0();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.oct_ad_view);
        int indexCount = obtainStyledAttributes.getIndexCount();
        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.found_n_in_xml, indexCount));
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.oct_ad_view_oct_ad_slotId) {
                setAdSlotId(obtainStyledAttributes.getString(index));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.placement_id, obtainStyledAttributes.getString(index)));
            } else if (index == R.styleable.oct_ad_view_oct_auto_refresh_interval) {
                int i2 = obtainStyledAttributes.getInt(index, -1);
                setAutoRefreshInterval(i2);
                if (i2 <= 0) {
                    this.f18977xxOXOOoIX = true;
                }
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.xml_set_period, i2));
            } else if (index == R.styleable.oct_ad_view_oct_test) {
                xoIox.oIX0oI().f19080oxoX = obtainStyledAttributes.getBoolean(index, false);
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_set_test, xoIox.oIX0oI().f19080oxoX));
            } else if (index == R.styleable.oct_ad_view_oct_ad_size) {
                String string = obtainStyledAttributes.getString(index);
                o00 o00Var = null;
                if (string != null && !string.isEmpty()) {
                    try {
                        o00Var = (o00) o00.class.getDeclaredField(string).get(null);
                    } catch (Exception unused) {
                    }
                }
                if (o00Var == null) {
                    o00Var = o00.f32039xoIox;
                }
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.xml_ad_size, o00Var.toString()));
                oXIoO(o00Var.I0Io(), o00Var.oIX0oI());
            } else if (index == R.styleable.oct_ad_view_oct_should_reload_on_resume) {
                setShouldReloadOnResume(obtainStyledAttributes.getBoolean(index, false));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_set_should_reload, this.f18966IxIX0I));
            } else if (index == R.styleable.oct_ad_view_oct_opens_native_browser) {
                setOpensNativeBrowser(obtainStyledAttributes.getBoolean(index, false));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_set_opens_native_browser, getOpensNativeBrowser()));
            } else if (index == R.styleable.oct_ad_view_oct_expands_to_fit_screen_width) {
                setExpandsToFitScreenWidth(obtainStyledAttributes.getBoolean(index, false));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_set_expands_to_full_screen_width, this.f18971oI));
            } else if (index == R.styleable.oct_ad_view_oct_resize_ad_to_fit_container) {
                setResizeAdToFitContainer(obtainStyledAttributes.getBoolean(index, false));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_resize_ad_to_fit_container, this.f18965Ix00oIoI));
            } else if (index == R.styleable.oct_ad_view_oct_show_loading_indicator) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.show_loading_indicator_xml));
                setShowLoadingIndicator(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == R.styleable.oct_ad_view_oct_transition_type) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.transition_type));
                setTransitionType(TransitionType.getTypeForInt(obtainStyledAttributes.getInt(index, 0)));
            } else if (index == R.styleable.oct_ad_view_oct_transition_direction) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.transition_direction));
                setTransitionDirection(TransitionDirection.getDirectionForInt(obtainStyledAttributes.getInt(index, 0)));
            } else if (index == R.styleable.oct_ad_view_oct_transition_duration) {
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.transition_duration));
                setTransitionDuration(obtainStyledAttributes.getInt(index, 1000));
            } else if (index == R.styleable.oct_ad_view_oct_load_landing_page_in_background) {
                setLoadsInBackground(obtainStyledAttributes.getBoolean(index, true));
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18684II0XooXoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.xml_load_landing_page_in_background, this.f18766IoOoX));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void xOOOX() {
        if (this.f18972oOoIIO0 != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        this.f18972oOoIIO0 = new oIX0oI();
        try {
            o0IXXIx.II0XooXoX.I0Io("OctopusAd", "before registerReceiver");
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.f18972oOoIIO0, intentFilter);
        } catch (Throwable unused) {
            o0IXXIx.II0XooXoX.I0Io("OctopusAd", "ignore error");
        }
    }

    public final void xOoOIoI() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("enter dismantleBroadcast mReceiver == null ? ");
        if (this.f18972oOoIIO0 == null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        o0IXXIx.II0XooXoX.I0Io("OctopusAd", sb.toString());
        if (this.f18972oOoIIO0 == null) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f18972oOoIIO0);
            o0IXXIx.II0XooXoX.I0Io("OctopusAd", "after unregisterReceiver");
        } catch (IllegalArgumentException unused) {
            o0IXXIx.II0XooXoX.I0Io("OctopusAd", "got IllegalArgumentException");
        }
        this.f18972oOoIIO0 = null;
    }

    public final void xX0IIXIx0() {
        this.f18970XXoOx0 = false;
        this.f18974x0OIX00oO = -1;
        this.f18966IxIX0I = false;
        this.f18977xxOXOOoIX = true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void xXxxox0I() {
        com.octopus.ad.internal.view.I0Io i0Io = this.f18975x0OxxIOxX;
        if (i0Io != null) {
            i0Io.onDestroy();
            this.f18975x0OxxIOxX = null;
        }
        o0IXXIx.II0XooXoX.I0Io("OctopusAd", "enter activityOnDestroy before dismantleBroadcast");
        xOoOIoI();
        if (this.f18774OI0 != null) {
            XIo0oOXIx();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void xoXoI(Context context, AttributeSet attributeSet) {
        l lVar;
        this.f18974x0OIX00oO = -1;
        this.f18963IXO = false;
        this.f18971oI = false;
        this.f18965Ix00oIoI = false;
        this.f18967O0IxXx = false;
        this.f18964IoXIXo = new Animator(getContext(), TransitionType.NONE, TransitionDirection.UP, 500L);
        View view = (View) getParent();
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            xoIox oIX0oI2 = xoIox.oIX0oI();
            int OxxIIOOXO2 = (int) ((measuredHeight / oIX0oI2.OxxIIOOXO()) + 0.5f);
            this.f18784X00IoxXI.oO((int) ((measuredHeight2 / oIX0oI2.oI0IIXIo()) + 0.5f));
            this.f18784X00IoxXI.Oo(OxxIIOOXO2);
        }
        super.xoXoI(context, attributeSet);
        O0X();
        com.octopus.ad.internal.I0Io i0Io = this.f18784X00IoxXI;
        if (this.f18791XO) {
            lVar = l.SPLASH;
        } else {
            lVar = l.BANNER;
        }
        i0Io.I0Io(lVar);
        this.f18774OI0.X0o0xo(this.f18974x0OIX00oO);
        if (this.f18977xxOXOOoIX) {
            this.f18774OI0.Oxx0IOOO();
            this.f18970XXoOx0 = true;
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean xoxXI() {
        return false;
    }

    public BannerAdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
        this.f18976xXoOI00O = true;
    }

    public BannerAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18976xXoOI00O = true;
    }

    public BannerAdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18976xXoOI00O = true;
    }

    public BannerAdViewImpl(Context context, int i) {
        super(context);
        this.f18976xXoOI00O = true;
        setAutoRefreshInterval(i);
    }
}
