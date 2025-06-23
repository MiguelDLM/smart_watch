package com.octopus.ad.internal.view;

import IO0XoXxO.II0XooXoX;
import IO0XoXxO.xoIox;
import IO0XoXxO.xxIXOIIO;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.octopus.ad.AdActivity;
import com.octopus.ad.BannerAdView;
import com.octopus.ad.R;
import com.octopus.ad.internal.c;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.view.AdWebView;
import com.octopus.ad.internal.view.f;
import com.octopus.ad.model.II0xO0;
import com.octopus.ad.widget.ScrollClickView;
import com.octopus.ad.widget.SkipView;
import java.io.File;
import java.util.ArrayList;
import x0.I0oOoX;
import x0.x0o;
import x0OxxIOxX.II0xO0;
import x0OxxIOxX.oIX0oI;

/* loaded from: classes11.dex */
public abstract class AdViewImpl extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, oOoIIO0.II0xO0, oOoIIO0.Oxx0IOOO, com.octopus.ad.internal.oIX0oI {

    /* renamed from: OIOoIIOIx, reason: collision with root package name */
    public static AdWebView.II0XooXoX f18751OIOoIIOIx;

    /* renamed from: OoO, reason: collision with root package name */
    public static f f18752OoO;

    /* renamed from: XIXIxO, reason: collision with root package name */
    public static FrameLayout f18753XIXIxO;

    /* renamed from: I0, reason: collision with root package name */
    public boolean f18754I0;

    /* renamed from: I0X0x0oIo, reason: collision with root package name */
    public GestureDetector f18755I0X0x0oIo;

    /* renamed from: I0oOIX, reason: collision with root package name */
    public int f18756I0oOIX;

    /* renamed from: I0oOoX, reason: collision with root package name */
    public AppCompatTextView f18757I0oOoX;

    /* renamed from: IIX0, reason: collision with root package name */
    public boolean f18758IIX0;

    /* renamed from: IIX0o, reason: collision with root package name */
    public O0IxXx.II0xO0 f18759IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f18760IIXOooo;

    /* renamed from: IIxOXoOo0, reason: collision with root package name */
    public long f18761IIxOXoOo0;

    /* renamed from: IO, reason: collision with root package name */
    public II0xO0.C1145II0xO0 f18762IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public View f18763IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public boolean f18764Io;

    /* renamed from: IoIOOxIIo, reason: collision with root package name */
    public IO0XoXxO.II0XooXoX f18765IoIOOxIIo;

    /* renamed from: IoOoX, reason: collision with root package name */
    public boolean f18766IoOoX;

    /* renamed from: IoOoo, reason: collision with root package name */
    public FrameLayout f18767IoOoo;

    /* renamed from: Ioxxx, reason: collision with root package name */
    public int f18768Ioxxx;

    /* renamed from: O0, reason: collision with root package name */
    public String f18769O0;

    /* renamed from: O00XxXI, reason: collision with root package name */
    public String f18770O00XxXI;

    /* renamed from: O0X, reason: collision with root package name */
    public AdWebView f18771O0X;

    /* renamed from: O0Xx, reason: collision with root package name */
    public float f18772O0Xx;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public a f18773O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public c f18774OI0;

    /* renamed from: OO, reason: collision with root package name */
    public FrameLayout f18775OO;

    /* renamed from: OO0x0xX, reason: collision with root package name */
    public int f18776OO0x0xX;

    /* renamed from: OOXIxO0, reason: collision with root package name */
    public long f18777OOXIxO0;

    /* renamed from: OX00O0xII, reason: collision with root package name */
    public boolean f18778OX00O0xII;

    /* renamed from: Oo, reason: collision with root package name */
    public ViewGroup f18779Oo;

    /* renamed from: Ox0O, reason: collision with root package name */
    public boolean f18780Ox0O;

    /* renamed from: OxI, reason: collision with root package name */
    public oOoIIO0.XO f18781OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public x0OxxIOxX.oIX0oI f18782Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f18783OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public com.octopus.ad.internal.I0Io f18784X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public oOoIIO0.Oxx0xo f18785X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public oOoIIO0.oxoX f18786XI0IXoo;

    /* renamed from: XI0oooXX, reason: collision with root package name */
    public int f18787XI0oooXX;

    /* renamed from: XIXIX, reason: collision with root package name */
    public boolean f18788XIXIX;

    /* renamed from: XIo0oOXIx, reason: collision with root package name */
    public int f18789XIo0oOXIx;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public oo0xXOI0I f18790XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f18791XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public boolean f18792XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public AppCompatTextView f18793XX;

    /* renamed from: XX0, reason: collision with root package name */
    public long f18794XX0;

    /* renamed from: XX0xXo, reason: collision with root package name */
    public String f18795XX0xXo;

    /* renamed from: Xo0, reason: collision with root package name */
    public float f18796Xo0;

    /* renamed from: XoI0Ixx0, reason: collision with root package name */
    public float f18797XoI0Ixx0;

    /* renamed from: XoX, reason: collision with root package name */
    public IXO.oIX0oI f18798XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public boolean f18799Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public com.octopus.ad.internal.view.I0Io f18800XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f18801o0;

    /* renamed from: o00, reason: collision with root package name */
    public oOoIIO0.xoIox f18802o00;

    /* renamed from: o0oIxOo, reason: collision with root package name */
    public int f18803o0oIxOo;

    /* renamed from: o0xxxXXxX, reason: collision with root package name */
    public String f18804o0xxxXXxX;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f18805oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f18806oOXoIIIo;

    /* renamed from: oOo, reason: collision with root package name */
    public AdVideoView f18807oOo;

    /* renamed from: oX, reason: collision with root package name */
    public float f18808oX;

    /* renamed from: oXIO0o0XI, reason: collision with root package name */
    public int f18809oXIO0o0XI;

    /* renamed from: oo, reason: collision with root package name */
    public boolean f18810oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f18811oo0xXOI0I;

    /* renamed from: ooOx, reason: collision with root package name */
    public boolean f18812ooOx;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public O0IxXx.II0XooXoX f18813ooXIXxIX;

    /* renamed from: ox, reason: collision with root package name */
    public String f18814ox;

    /* renamed from: oxIIX0o, reason: collision with root package name */
    public final IoOoX f18815oxIIX0o;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public AppCompatImageView f18816oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public ImageView f18817oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public boolean f18818x0o;

    /* renamed from: x0xO, reason: collision with root package name */
    public int f18819x0xO;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f18820xI;

    /* renamed from: xI0oxI00, reason: collision with root package name */
    public IO0XoXxO.xxIXOIIO f18821xI0oxI00;

    /* renamed from: xII, reason: collision with root package name */
    public boolean f18822xII;

    /* renamed from: xOOOX, reason: collision with root package name */
    public boolean f18823xOOOX;

    /* renamed from: xOoOIoI, reason: collision with root package name */
    public boolean f18824xOoOIoI;

    /* renamed from: xX0IIXIx0, reason: collision with root package name */
    public boolean f18825xX0IIXIx0;

    /* renamed from: xXOx, reason: collision with root package name */
    public ProgressBar f18826xXOx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public xI f18827xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public AppCompatTextView f18828xo0x;

    /* renamed from: xoIxX, reason: collision with root package name */
    public int f18829xoIxX;

    /* renamed from: xoO0xx0, reason: collision with root package name */
    public boolean f18830xoO0xx0;

    /* renamed from: xoXoI, reason: collision with root package name */
    public oOoIIO0.OxxIIOOXO f18831xoXoI;

    /* renamed from: xoxXI, reason: collision with root package name */
    public int f18832xoxXI;

    /* renamed from: xx0X0, reason: collision with root package name */
    public IO0XoXxO.xoIox f18833xx0X0;

    /* renamed from: xxIO, reason: collision with root package name */
    public String f18834xxIO;

    /* renamed from: xxX, reason: collision with root package name */
    public final Handler f18835xxX;

    /* loaded from: classes11.dex */
    public class I0Io implements Runnable {

        /* loaded from: classes11.dex */
        public class oIX0oI implements GestureDetector.OnGestureListener {
            public oIX0oI() {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                AdViewImpl.this.f18808oX = motionEvent.getX();
                AdViewImpl.this.f18796Xo0 = motionEvent.getY();
                AdViewImpl.this.f18797XoI0Ixx0 = motionEvent.getRawX();
                AdViewImpl.this.f18772O0Xx = motionEvent.getRawY();
                return true;
            }
        }

        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdViewImpl.this.f18755I0X0x0oIo = new GestureDetector(new oIX0oI());
        }
    }

    /* loaded from: classes11.dex */
    public class II0XooXoX implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ f f18839XO;

        public II0XooXoX(f fVar) {
            this.f18839XO = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18839XO.I0Io();
        }
    }

    /* loaded from: classes11.dex */
    public class IIX0o implements View.OnClickListener {
        public IIX0o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AdViewImpl.this.f18812ooOx) {
                AdViewImpl.this.ooOx();
                return;
            }
            AdViewImpl.this.getAdDispatcher().a();
            if (AdViewImpl.this.f18798XoX != null) {
                AdViewImpl.this.f18798XoX.x0XOIxOo();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class IIXOooo implements IoOoX {
        public IIXOooo() {
        }

        @Override // com.octopus.ad.internal.view.AdViewImpl.IoOoX
        public void a() {
            if (!AdViewImpl.this.f18830xoO0xx0 && !AdViewImpl.this.f18778OX00O0xII && !AdViewImpl.this.f18825xX0IIXIx0) {
                AdViewImpl adViewImpl = AdViewImpl.this;
                if (adViewImpl.f18782Oxx0xo != null) {
                    adViewImpl.ooOx();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class IXxxXO implements II0XooXoX.I0Io {
        public IXxxXO() {
        }

        @Override // IO0XoXxO.II0XooXoX.I0Io
        public void oIX0oI(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            AdViewImpl.this.IO();
        }
    }

    /* loaded from: classes11.dex */
    public interface IoOoX {
        void a();
    }

    /* loaded from: classes11.dex */
    public class O0xOxO implements Runnable {
        public O0xOxO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdViewImpl.this.xX0IIXIx0();
        }
    }

    /* loaded from: classes11.dex */
    public class OOXIXo extends Handler {
        public OOXIXo(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* loaded from: classes11.dex */
    public class OxI implements Runnable {
        public OxI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdViewImpl.this.ooOx();
        }
    }

    /* loaded from: classes11.dex */
    public class Oxx0IOOO extends AppCompatTextView {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ f f18849XO;

        /* loaded from: classes11.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ ViewGroup.MarginLayoutParams f18851XO;

            public oIX0oI(ViewGroup.MarginLayoutParams marginLayoutParams) {
                this.f18851XO = marginLayoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                Oxx0IOOO.this.setLayoutParams(this.f18851XO);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Oxx0IOOO(Context context, f fVar) {
            super(context);
            this.f18849XO = fVar;
        }

        @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
        @SuppressLint({"NewApi", "DrawAllocation"})
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            Activity activity;
            boolean z2;
            Point point;
            int i5;
            int i6;
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Point point2 = new Point(0, 0);
            try {
                activity = (Activity) this.f18849XO.f19022oIX0oI.getContext();
                z2 = true;
            } catch (ClassCastException unused) {
                activity = null;
                z2 = false;
            }
            if (z2) {
                activity.getWindowManager().getDefaultDisplay().getSize(point2);
            }
            int[] iArr2 = new int[2];
            if (AdViewImpl.this.getMediaType().equals(l.INTERSTITIAL)) {
                InterstitialAdViewImpl.f19001O0IxXx.measure(0, 0);
                InterstitialAdViewImpl.f19001O0IxXx.getLocationOnScreen(iArr2);
                point = new Point(InterstitialAdViewImpl.f19001O0IxXx.getMeasuredWidth(), InterstitialAdViewImpl.f19001O0IxXx.getMeasuredHeight());
            } else {
                AdViewImpl.this.measure(0, 0);
                AdViewImpl.this.getLocationOnScreen(iArr2);
                point = new Point(AdViewImpl.this.getMeasuredWidth(), AdViewImpl.this.getMeasuredHeight());
            }
            int i7 = point.x;
            int i8 = AdViewImpl.this.f18803o0oIxOo;
            int i9 = i7 - i8;
            int i10 = point.y - i8;
            if (z2) {
                i9 = (iArr2[0] + Math.min(point2.x, i7)) - AdViewImpl.this.f18803o0oIxOo;
                i10 = (iArr2[1] + Math.min(point2.y, point.y)) - AdViewImpl.this.f18803o0oIxOo;
                i5 = iArr2[0];
                i6 = iArr2[1];
            } else {
                i5 = 0;
                i6 = 0;
            }
            int i11 = iArr[0];
            if (i11 + 1 >= i5 && i11 - 1 <= i9) {
                int i12 = iArr[1];
                if (i12 + 1 >= i6 && i12 - 1 <= i10) {
                    return;
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
            layoutParams.setMargins(40, 40, 40, 40);
            post(new oIX0oI(layoutParams));
            AdViewImpl.this.f18757I0oOoX.setBackgroundDrawable(getResources().getDrawable(R.drawable.oct_close_background));
            AdViewImpl.this.f18757I0oOoX.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.oct_text_selector));
            AdViewImpl.this.f18757I0oOoX.setTextSize(2, 16.0f);
            AdViewImpl.this.f18757I0oOoX.setText(R.string.skip_ad);
        }
    }

    /* loaded from: classes11.dex */
    public class Oxx0xo implements View.OnTouchListener {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public final /* synthetic */ int f18852IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public float f18853IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public float f18854Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public float f18856Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public float f18857OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public float f18858XO;

        /* renamed from: o00, reason: collision with root package name */
        public final /* synthetic */ xxIXOIIO.oxoX f18859o00;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public float f18860oI0IIXIo;

        /* renamed from: xoXoI, reason: collision with root package name */
        public final /* synthetic */ String f18861xoXoI;

        public Oxx0xo(int i, String str, xxIXOIIO.oxoX oxox) {
            this.f18852IIXOooo = i;
            this.f18861xoXoI = str;
            this.f18859o00 = oxox;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            xxIXOIIO.oxoX oxox;
            xxIXOIIO.oxoX oxox2;
            xxIXOIIO.oxoX oxox3;
            xxIXOIIO.oxoX oxox4;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f18858XO = motionEvent.getX();
                this.f18854Oo = motionEvent.getY();
                this.f18853IXxxXO = motionEvent.getX();
                this.f18856Oxx0xo = motionEvent.getY();
                this.f18860oI0IIXIo = motionEvent.getRawX();
                this.f18857OxxIIOOXO = motionEvent.getRawY();
            } else if (action == 1) {
                o0IXXIx.II0XooXoX.II0xO0("ScrollClickUtil", "mCurPosX = " + this.f18853IXxxXO + ",mCurPosY = " + this.f18856Oxx0xo + ",mPosX = " + this.f18858XO + ",mPosY = " + this.f18854Oo);
                float f = this.f18856Oxx0xo;
                float f2 = this.f18854Oo;
                if (f - f2 > 0.0f && Math.abs(f - f2) > this.f18852IIXOooo) {
                    if (ScrollClickView.f19358IIX0o.equalsIgnoreCase(this.f18861xoXoI) && (oxox4 = this.f18859o00) != null) {
                        oxox4.oIX0oI(this.f18858XO + "", this.f18854Oo + "", this.f18860oI0IIXIo + "", this.f18857OxxIIOOXO + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else {
                    float f3 = this.f18856Oxx0xo;
                    float f4 = this.f18854Oo;
                    if (f3 - f4 < 0.0f && Math.abs(f3 - f4) > this.f18852IIXOooo) {
                        if ("up".equalsIgnoreCase(this.f18861xoXoI) && (oxox3 = this.f18859o00) != null) {
                            oxox3.oIX0oI(this.f18858XO + "", this.f18854Oo + "", this.f18860oI0IIXIo + "", this.f18857OxxIIOOXO + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else {
                        float f5 = this.f18853IXxxXO;
                        float f6 = this.f18858XO;
                        if (f5 - f6 < 0.0f && Math.abs(f5 - f6) > this.f18852IIXOooo) {
                            if ("left".equalsIgnoreCase(this.f18861xoXoI) && (oxox2 = this.f18859o00) != null) {
                                oxox2.oIX0oI(this.f18858XO + "", this.f18854Oo + "", this.f18860oI0IIXIo + "", this.f18857OxxIIOOXO + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else {
                            float f7 = this.f18853IXxxXO;
                            float f8 = this.f18858XO;
                            if (f7 - f8 < 0.0f && Math.abs(f7 - f8) > this.f18852IIXOooo && "right".equalsIgnoreCase(this.f18861xoXoI) && (oxox = this.f18859o00) != null) {
                                oxox.oIX0oI(this.f18858XO + "", this.f18854Oo + "", this.f18860oI0IIXIo + "", this.f18857OxxIIOOXO + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        }
                    }
                }
            } else if (action == 2) {
                this.f18853IXxxXO = motionEvent.getX();
                this.f18856Oxx0xo = motionEvent.getY();
            }
            return true;
        }
    }

    /* loaded from: classes11.dex */
    public class OxxIIOOXO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ IoOoX f18862XO;

        public OxxIIOOXO(IoOoX ioOoX) {
            this.f18862XO = ioOoX;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f18862XO.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class X0IIOO implements Runnable {
        public X0IIOO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdViewImpl.this.ooOx();
        }
    }

    /* loaded from: classes11.dex */
    public class X0o0xo implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ f f18865XO;

        public X0o0xo(f fVar) {
            this.f18865XO = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18865XO.I0Io();
        }
    }

    /* loaded from: classes11.dex */
    public class XO implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ f f18869XO;

        public XO(f fVar) {
            this.f18869XO = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18869XO.I0Io();
        }
    }

    /* loaded from: classes11.dex */
    public class XxX0x0xxx implements View.OnClickListener {
        public XxX0x0xxx() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdViewImpl.this.getAdDispatcher().a();
        }
    }

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public EnumC0892a f18872oIX0oI = EnumC0892a.UNCHANGE;

        /* renamed from: II0xO0, reason: collision with root package name */
        public boolean f18871II0xO0 = false;

        /* renamed from: com.octopus.ad.internal.view.AdViewImpl$a$a, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public enum EnumC0892a {
            UNCHANGE,
            STATE_PREPARE_CHANGE,
            STATE_BACKGROUND,
            FINISHCLOSE
        }

        public boolean I0Io() {
            return this.f18871II0xO0;
        }

        public void II0xO0(boolean z) {
            this.f18871II0xO0 = z;
        }

        public EnumC0892a X0o0xo() {
            return this.f18872oIX0oI;
        }

        public synchronized void oIX0oI(EnumC0892a enumC0892a) {
            try {
                EnumC0892a enumC0892a2 = EnumC0892a.STATE_PREPARE_CHANGE;
                if (enumC0892a == enumC0892a2 && this.f18872oIX0oI == EnumC0892a.UNCHANGE) {
                    this.f18872oIX0oI = enumC0892a2;
                }
                EnumC0892a enumC0892a3 = EnumC0892a.STATE_BACKGROUND;
                if (enumC0892a == enumC0892a3 && this.f18872oIX0oI == enumC0892a2) {
                    this.f18872oIX0oI = enumC0892a3;
                }
                EnumC0892a enumC0892a4 = EnumC0892a.FINISHCLOSE;
                if (enumC0892a == enumC0892a4 && this.f18872oIX0oI == enumC0892a3 && this.f18871II0xO0) {
                    this.f18872oIX0oI = enumC0892a4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public void oxoX() {
            this.f18872oIX0oI = EnumC0892a.UNCHANGE;
        }
    }

    /* loaded from: classes11.dex */
    public class o00 implements Runnable {
        public o00() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdViewImpl.this.xX0IIXIx0();
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oI0IIXIo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f18875oIX0oI;

        static {
            int[] iArr = new int[f.a.values().length];
            f18875oIX0oI = iArr;
            try {
                iArr[f.a.bottom_center.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18875oIX0oI[f.a.bottom_left.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18875oIX0oI[f.a.bottom_right.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18875oIX0oI[f.a.center.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18875oIX0oI[f.a.top_center.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18875oIX0oI[f.a.top_left.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18875oIX0oI[f.a.top_right.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class oO implements oOoIIO0.xoXoI {
        public oO() {
        }

        @Override // oOoIIO0.xoXoI
        public void a(boolean z) {
            AdViewImpl.this.Xo0(z);
        }
    }

    /* loaded from: classes11.dex */
    public class oOoXoXO implements xoIox.oxoX {
        public oOoXoXO() {
        }

        @Override // IO0XoXxO.xoIox.oxoX
        public void a() {
            AdViewImpl.this.IO();
        }
    }

    /* loaded from: classes11.dex */
    public static class oo0xXOI0I {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final ArrayList<Pair<String, oo0xXOI0I>> f18881oIX0oI = new ArrayList<>();
    }

    /* loaded from: classes11.dex */
    public class ooOOo0oXI implements View.OnClickListener {
        public ooOOo0oXI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdViewImpl.this.IO();
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements View.OnClickListener {
        public oxoX() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AdViewImpl.this.xoxXI()) {
                if (AdViewImpl.this.f18812ooOx) {
                    AdViewImpl.this.ooOx();
                    return;
                } else {
                    AdViewImpl.this.xOOOX();
                    return;
                }
            }
            AdViewImpl.this.getAdDispatcher().a();
            if (AdViewImpl.this.f18798XoX != null) {
                AdViewImpl.this.f18798XoX.x0XOIxOo();
            }
            if (AdViewImpl.this.f18791XO) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, "Should not close banner!");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class x0XOIxOo implements View.OnTouchListener {
        public x0XOIxOo() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes11.dex */
    public class x0xO0oo implements xxIXOIIO.oxoX {
        public x0xO0oo() {
        }

        @Override // IO0XoXxO.xxIXOIIO.oxoX
        public void oIX0oI(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            AdViewImpl.this.IO();
        }
    }

    /* loaded from: classes11.dex */
    public class xoIox implements com.octopus.ad.internal.view.II0xO0 {
        public xoIox() {
        }

        @Override // com.octopus.ad.internal.view.II0xO0
        public void a() {
            AdViewImpl.this.xI0oxI00(oOoIIO0.I0Io.f32019ooOOo0oXI);
            AdViewImpl.this.f18758IIX0 = false;
        }
    }

    /* loaded from: classes11.dex */
    public class xoXoI implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ AdVideoView f18904XO;

        public xoXoI(AdVideoView adVideoView) {
            this.f18904XO = adVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean xII2 = this.f18904XO.xII();
            AppCompatImageView appCompatImageView = AdViewImpl.this.f18816oxXx0IX;
            if (xII2) {
                i = R.drawable.oct_voice_off;
            } else {
                i = R.drawable.oct_voice_on;
            }
            appCompatImageView.setImageResource(i);
        }
    }

    /* loaded from: classes11.dex */
    public class xxIXOIIO implements O0IxXx.II0xO0 {
        public xxIXOIIO() {
        }

        @Override // O0IxXx.II0xO0
        public void oIX0oI(File file, String str, int i) {
            if (i == 100) {
                AdViewImpl.this.xx0X0();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class xxX implements View.OnClickListener {
        public xxX() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AdViewImpl.this.xoxXI()) {
                if (AdViewImpl.this.f18812ooOx) {
                    AdViewImpl.this.ooOx();
                } else {
                    AdViewImpl.this.xOOOX();
                }
            }
        }
    }

    public AdViewImpl(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public static boolean IIxOXoOo0(x0OxxIOxX.oIX0oI oix0oi) {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.xoXoI oOoXoXO2;
        if (oix0oi == null || (XOxIOxOx2 = oix0oi.XOxIOxOx()) == null || (oOoXoXO2 = XOxIOxOx2.oOoXoXO()) == null || oOoXoXO2.oIX0oI() != 1) {
            return false;
        }
        return true;
    }

    private void O0X() {
        AdVideoView adVideoView = this.f18807oOo;
        if (adVideoView == null) {
            return;
        }
        String videoUrl = adVideoView.getVideoUrl();
        if (TextUtils.isEmpty(videoUrl)) {
            return;
        }
        O0IxXx.II0XooXoX II0XooXoX2 = com.octopus.ad.internal.xoIox.oIX0oI().II0XooXoX();
        this.f18813ooXIXxIX = II0XooXoX2;
        if (II0XooXoX2.ooOOo0oXI(videoUrl)) {
            xx0X0();
        } else {
            xxIXOIIO xxixoiio = new xxIXOIIO();
            this.f18759IIX0o = xxixoiio;
            this.f18813ooXIXxIX.oxoX(xxixoiio, videoUrl);
        }
        x0OxxIOxX.oIX0oI oix0oi = this.f18782Oxx0xo;
        if (oix0oi != null) {
            oix0oi.xxIO(new xoIox());
        }
    }

    private void O0xOxO(String str) {
        ViewParent parent;
        IO0XoXxO.xxIXOIIO xxixoiio = this.f18821xI0oxI00;
        if (xxixoiio != null) {
            xxixoiio.I0Io();
            View view = this.f18807oOo;
            if (view == null) {
                view = this.f18771O0X;
            }
            View oIX0oI2 = this.f18821xI0oxI00.oIX0oI(I0oOoX.OxI(getContext(), view.getWidth()), I0oOoX.OxI(getContext(), view.getHeight()), str);
            if (oIX0oI2 != null) {
                X0IIOO("up", 100, new x0xO0oo());
                if (xoxXI()) {
                    parent = view.getParent();
                } else {
                    parent = getParent();
                }
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(oIX0oI2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OO0x0xX() {
        x0OxxIOxX.oIX0oI oix0oi;
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.x0XOIxOo x0XOIxOo2;
        x0OxxIOxX.oIX0oI oix0oi2;
        if (!this.f18823xOOOX && (oix0oi = this.f18782Oxx0xo) != null && (XOxIOxOx2 = oix0oi.XOxIOxOx()) != null && (x0XOIxOo2 = XOxIOxOx2.x0XOIxOo()) != null && x0XOIxOo2.oIX0oI() == 1) {
            this.f18823xOOOX = true;
            AdWebView adWebView = this.f18771O0X;
            if (adWebView != null && (oix0oi2 = adWebView.f18911IXxxXO) != null) {
                oix0oi2.ox(true);
            }
            new Handler().postDelayed(new o00(), x0XOIxOo2.X0o0xo());
            if (x0XOIxOo2.I0Io() == 1) {
                new Handler().postDelayed(new OxI(), x0XOIxOo2.Oxx0IOOO());
            }
        }
    }

    private void XI0IXoo(boolean z) {
        o0IXXIx.II0XooXoX.oIX0oI("OctopusAd", "octopus clickable = " + z);
        if (!z) {
            I0X0x0oIo(new x0XOIxOo());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XIo0oOXIx() {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.x0XOIxOo x0XOIxOo2;
        x0OxxIOxX.oIX0oI oix0oi;
        x0OxxIOxX.oIX0oI oix0oi2 = this.f18782Oxx0xo;
        if (oix0oi2 != null && (XOxIOxOx2 = oix0oi2.XOxIOxOx()) != null && (x0XOIxOo2 = XOxIOxOx2.x0XOIxOo()) != null && x0XOIxOo2.oIX0oI() == 1) {
            AdWebView adWebView = this.f18771O0X;
            if (adWebView != null && (oix0oi = adWebView.f18911IXxxXO) != null) {
                oix0oi.O00XxXI(true);
            }
            new Handler().postDelayed(new O0xOxO(), x0XOIxOo2.X0o0xo());
            if (x0XOIxOo2.I0Io() == 1) {
                new Handler().postDelayed(new X0IIOO(), x0XOIxOo2.Oxx0IOOO());
            }
        }
    }

    public static boolean XX0xXo(x0OxxIOxX.oIX0oI oix0oi) {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.II0XooXoX OOXIXo2;
        if (oix0oi == null || (XOxIOxOx2 = oix0oi.XOxIOxOx()) == null || (OOXIXo2 = XOxIOxOx2.OOXIXo()) == null || OOXIXo2.oIX0oI() == 1) {
            return true;
        }
        return false;
    }

    public static FrameLayout getMRAIDFullscreenContainer() {
        return f18753XIXIxO;
    }

    public static f getMRAIDFullscreenImplementation() {
        return f18752OoO;
    }

    public static AdWebView.II0XooXoX getMRAIDFullscreenListener() {
        return f18751OIOoIIOIx;
    }

    public static void oI(x0OxxIOxX.oIX0oI oix0oi, IoOoX ioOoX) {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.Oxx0IOOO xxIXOIIO2;
        if (oix0oi != null && (XOxIOxOx2 = oix0oi.XOxIOxOx()) != null && (xxIXOIIO2 = XOxIOxOx2.xxIXOIIO()) != null && xxIXOIIO2.oIX0oI() == 1) {
            IO0XoXxO.oxoX.oIX0oI(new OxxIIOOXO(ioOoX), xxIXOIIO2.I0Io());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ooOx() {
        if (this.f18771O0X != null) {
            this.f18812ooOx = false;
            if (xxIO(this.f18782Oxx0xo)) {
                this.f18825xX0IIXIx0 = false;
                this.f18788XIXIX = true;
                this.f18809oXIO0o0XI = 0;
            } else {
                this.f18825xX0IIXIx0 = true;
                this.f18809oXIO0o0XI = 9;
            }
            this.f18771O0X.IO(this.f18809oXIO0o0XI);
        }
    }

    @SuppressLint({"DefaultLocale"})
    private void setDefaultSkip(Context context) {
        View view = this.f18763IXxxXO;
        if (view != null) {
            I0oOoX.O0xOxO(view);
            int Oxx0xo2 = (int) (I0oOoX.Oxx0xo(context) * 0.15d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Oxx0xo2, (int) (Oxx0xo2 * 0.45d));
            layoutParams.gravity = 53;
            layoutParams.topMargin = I0oOoX.x0XOIxOo(context, this.f18819x0xO + 15);
            layoutParams.rightMargin = I0oOoX.x0XOIxOo(context, 15.0f);
            addView(this.f18763IXxxXO, layoutParams);
            ((SkipView) this.f18763IXxxXO).xxIXOIIO(1, 0);
        }
    }

    public static void setMRAIDFullscreenContainer(FrameLayout frameLayout) {
        f18753XIXIxO = frameLayout;
    }

    public static void setMRAIDFullscreenImplementation(f fVar) {
        f18752OoO = fVar;
    }

    public static void setMRAIDFullscreenListener(AdWebView.II0XooXoX iI0XooXoX) {
        f18751OIOoIIOIx = iI0XooXoX;
    }

    private void x0o(String str) {
        ViewParent parent;
        IO0XoXxO.II0XooXoX iI0XooXoX = this.f18765IoIOOxIIo;
        if (iI0XooXoX != null) {
            View view = this.f18807oOo;
            if (view == null) {
                view = this.f18771O0X;
            }
            View II0xO02 = iI0XooXoX.II0xO0(I0oOoX.OxI(getContext(), view.getWidth()), I0oOoX.OxI(getContext(), view.getHeight()), str, true);
            if (II0xO02 != null) {
                this.f18765IoIOOxIIo.XO(new IXxxXO());
                if (xoxXI()) {
                    parent = view.getParent();
                } else {
                    parent = getParent();
                }
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(II0xO02);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xOOOX() {
        getAdDispatcher().a();
        IXO.oIX0oI oix0oi = this.f18798XoX;
        if (oix0oi != null) {
            oix0oi.x0XOIxOo();
        }
        Activity xoIxX2 = xoIxX(this.f18771O0X);
        if (xoIxX2 != null && !xoIxX2.isFinishing() && (xoIxX2 instanceof AdActivity)) {
            xoIxX2.finish();
        }
    }

    private void xOoOIoI() {
        O0IxXx.II0xO0 iI0xO0;
        O0IxXx.II0XooXoX iI0XooXoX = this.f18813ooXIXxIX;
        if (iI0XooXoX != null && (iI0xO0 = this.f18759IIX0o) != null) {
            iI0XooXoX.I0Io(iI0xO0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xX0IIXIx0() {
        AdWebView adWebView = this.f18771O0X;
        adWebView.f18911IXxxXO.XX0(adWebView, null);
    }

    public static boolean xxIO(x0OxxIOxX.oIX0oI oix0oi) {
        II0xO0.IIXOooo XOxIOxOx2;
        II0xO0.Oxx0IOOO xxIXOIIO2;
        if (oix0oi == null || (XOxIOxOx2 = oix0oi.XOxIOxOx()) == null || (xxIXOIIO2 = XOxIOxOx2.xxIXOIIO()) == null || xxIXOIIO2.X0o0xo() != 1) {
            return false;
        }
        return true;
    }

    public boolean I0() {
        if (System.currentTimeMillis() - this.f18777OOXIxO0 < this.f18761IIxOXoOo0) {
            return true;
        }
        return false;
    }

    @Override // oOoIIO0.II0xO0
    public void I0Io() {
    }

    public void I0X0x0oIo(View.OnTouchListener onTouchListener) {
        View view = this.f18807oOo;
        if (view == null) {
            view = this.f18771O0X;
        }
        view.setOnTouchListener(onTouchListener);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        try {
            this.f18782Oxx0xo.OO0x0xX(i, str, str2);
            OO0x0xX();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        try {
            this.f18782Oxx0xo.XIo0oOXIx(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void IIX0o();

    public void IIXOooo(int i, int i2, boolean z, f fVar, AdWebView.II0XooXoX iI0XooXoX) {
        Oxx0xo(i, i2);
        AppCompatTextView oxoX2 = I0oOoX.oxoX(getContext());
        this.f18757I0oOoX = oxoX2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) oxoX2.getLayoutParams();
        if (!fVar.f19022oIX0oI.f18917OxI && getChildAt(0) != null) {
            layoutParams.rightMargin = (getMeasuredWidth() - getChildAt(0).getMeasuredWidth()) / 2;
        }
        this.f18757I0oOoX.setLayoutParams(layoutParams);
        this.f18757I0oOoX.setOnClickListener(new XO(fVar));
        if (fVar.f19022oIX0oI.f18917OxI) {
            OxI(fVar, z, iI0XooXoX);
        } else {
            addView(this.f18757I0oOoX);
        }
        this.f18811oo0xXOI0I = true;
    }

    public void IO() {
        this.f18778OX00O0xII = true;
        AdWebView adWebView = this.f18771O0X;
        if (adWebView != null) {
            adWebView.IO(this.f18809oXIO0o0XI);
        }
    }

    public final void IXxxXO(double d, double d2, String str, boolean z, boolean z2) {
        ViewParent parent;
        IO0XoXxO.xoIox xoiox = this.f18833xx0X0;
        if (xoiox != null) {
            View view = this.f18807oOo;
            if (view == null) {
                view = this.f18771O0X;
            }
            xoiox.Oxx0IOOO(d, d2);
            this.f18833xx0X0.OOXIXo(view);
            View oxoX2 = this.f18833xx0X0.oxoX(I0oOoX.OxI(getContext(), view.getWidth()), I0oOoX.OxI(getContext(), view.getHeight()), 12.0f, str, false, xoxXI());
            if (oxoX2 != null) {
                if (z2) {
                    this.f18809oXIO0o0XI = 7;
                }
                this.f18833xx0X0.xoIox(new oOoXoXO());
                oxoX2.setOnClickListener(new ooOOo0oXI());
                if (xoxXI()) {
                    parent = view.getParent();
                } else {
                    parent = getParent();
                }
                if ((parent instanceof FrameLayout) && z) {
                    ((FrameLayout) parent).addView(oxoX2);
                }
            }
        }
    }

    public void IoIOOxIIo() {
        if (!this.f18758IIX0) {
            this.f18758IIX0 = true;
            this.f18777OOXIxO0 = System.currentTimeMillis();
            oOoIIO0.OxxIIOOXO oxxIIOOXO = this.f18831xoXoI;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.onAdLoaded();
            }
            oOoIIO0.XO xo2 = this.f18781OxI;
            if (xo2 != null) {
                xo2.onAdLoaded();
            }
            oOoIIO0.xoIox xoiox = this.f18802o00;
            if (xoiox != null) {
                xoiox.onAdLoaded();
            }
            oOoIIO0.Oxx0xo oxx0xo = this.f18785X0IIOO;
            if (oxx0xo != null) {
                oxx0xo.Oxx0IOOO();
            }
            O0X();
        }
    }

    public void IoOoX(int i, int i2, View view) {
        float f;
        ViewParent parent;
        I0oOoX.O0xOxO(this.f18793XX);
        int i3 = this.f18805oI0IIXIo;
        float f2 = 1.0f;
        if (i3 > 0) {
            f = i3 / 640.0f;
        } else {
            f = 1.0f;
        }
        if (f <= 1.0f) {
            f2 = f;
        }
        if (i2 != -1) {
            this.f18793XX = I0oOoX.xoIox(getContext(), i2, f2);
            if (i > 0) {
                this.f18787XI0oooXX = i2 - i;
            }
            IXO.oIX0oI oix0oi = new IXO.oIX0oI(i2 * 1000, 50L);
            this.f18798XoX = oix0oi;
            oix0oi.XO(new XI0IXoo());
            this.f18798XoX.I0Io();
        } else if (i != -1) {
            this.f18793XX = I0oOoX.xoIox(getContext(), i, f2);
            IXO.oIX0oI oix0oi2 = new IXO.oIX0oI(i * 1000, 50L);
            this.f18798XoX = oix0oi2;
            oix0oi2.XO(new XIxXXX0x0());
            this.f18798XoX.I0Io();
        } else {
            return;
        }
        if (xoxXI()) {
            parent = view.getParent();
        } else {
            parent = getParent();
        }
        if (parent instanceof FrameLayout) {
            com.octopus.ad.internal.xoIox oIX0oI2 = com.octopus.ad.internal.xoIox.oIX0oI();
            int applyDimension = (int) TypedValue.applyDimension(1, 18.0f * f2, oIX0oI2.xoXoI());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, GravityCompat.END);
            int applyDimension2 = (int) TypedValue.applyDimension(1, f2 * 15.0f, oIX0oI2.xoXoI());
            layoutParams.setMargins(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
            ((FrameLayout) parent).addView(this.f18793XX, layoutParams);
        }
    }

    public abstract void IoOoo();

    public void IoXIXo(ViewGroup viewGroup) {
        if (this.f18780Ox0O) {
            return;
        }
        this.f18780Ox0O = true;
        AdVideoView adVideoView = this.f18807oOo;
        if (adVideoView != null) {
            adVideoView.X00IoxXI();
        }
        I0oOoX.O0xOxO(this);
        if (viewGroup != null) {
            this.f18779Oo = viewGroup;
        }
        ViewGroup viewGroup2 = this.f18779Oo;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.f18779Oo.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            this.f18779Oo.addView(this, layoutParams);
        }
        Ix00oIoI(0, 25, 0, 0);
        x0OxxIOxX.oIX0oI oix0oi = this.f18782Oxx0xo;
        if (oix0oi != null && oix0oi.f33935xo0x == l.SPLASH && this.f18763IXxxXO != null) {
            if (this.f18754I0) {
                setDefaultSkip(getContext());
            }
            Xx000oIo(this.f18771O0X.getAutoCloseTime(), this.f18763IXxxXO);
        } else {
            oo0xXOI0I(-1, this.f18771O0X.getShowSkipBtnTime(), this.f18771O0X.getAutoCloseTime());
        }
        oI(this.f18782Oxx0xo, this.f18815oxIIX0o);
        boolean XX0xXo2 = XX0xXo(this.f18782Oxx0xo);
        this.f18788XIXIX = XX0xXo2;
        if (!XX0xXo2) {
            this.f18809oXIO0o0XI = 8;
        }
        this.f18771O0X.setOpt(this.f18809oXIO0o0XI);
        if (this.f18831xoXoI != null) {
            Log.e("OctopusAd", "enter Octopus ad show");
            AdWebView adWebView = this.f18771O0X;
            adWebView.f18911IXxxXO.XX0(adWebView, new oO());
        }
    }

    public void Ix00oIoI(int i, int i2, int i3, int i4) {
        this.f18829xoIxX = i;
        this.f18819x0xO = i2;
        this.f18776OO0x0xX = i3;
        this.f18789XIo0oOXIx = i4;
    }

    public final void O0() {
        IO0XoXxO.xoIox xoiox = this.f18833xx0X0;
        if (xoiox != null) {
            xoiox.Oo();
            this.f18833xx0X0 = null;
        }
        IO0XoXxO.II0XooXoX iI0XooXoX = this.f18765IoIOOxIIo;
        if (iI0XooXoX != null) {
            iI0XooXoX.X0o0xo();
        }
        IO0XoXxO.xxIXOIIO xxixoiio = this.f18821xI0oxI00;
        if (xxixoiio != null) {
            xxixoiio.xoIox();
        }
    }

    public void O00XxXI(AdWebView adWebView) {
        this.f18771O0X = adWebView;
        if (this.f18807oOo == null) {
            xx0X0();
        }
    }

    public void O0IxXx() {
        II0xO0.oO oIX0oI2;
        x0OxxIOxX.oIX0oI oix0oi = this.f18782Oxx0xo;
        if (oix0oi != null) {
            II0xO0.IIXOooo XOxIOxOx2 = oix0oi.XOxIOxOx();
            if (XOxIOxOx2 != null && (oIX0oI2 = XOxIOxOx2.oIX0oI()) != null) {
                boolean z = true;
                if (oIX0oI2.oIX0oI() != 1) {
                    z = false;
                }
                this.f18812ooOx = z;
            }
            this.f18782Oxx0xo.XX0xXo(this.f18798XoX);
        }
    }

    public abstract boolean O0Xx();

    public boolean OOXIxO0() {
        return this.f18764Io;
    }

    public void OoO(boolean z) {
        setOpensNativeBrowser(z);
    }

    public void OxI(f fVar, boolean z, AdWebView.II0XooXoX iI0XooXoX) {
        fVar.Oxx0IOOO((ViewGroup) fVar.f19022oIX0oI.getParent());
        FrameLayout frameLayout = new FrameLayout(getContext());
        I0oOoX.O0xOxO(fVar.f19022oIX0oI);
        frameLayout.addView(fVar.f19022oIX0oI);
        if (this.f18757I0oOoX == null) {
            AppCompatTextView oxoX2 = I0oOoX.oxoX(getContext());
            this.f18757I0oOoX = oxoX2;
            oxoX2.setOnClickListener(new X0o0xo(fVar));
        }
        frameLayout.addView(this.f18757I0oOoX);
        f18753XIXIxO = frameLayout;
        f18752OoO = fVar;
        f18751OIOoIIOIx = iI0XooXoX;
        Class<AdActivity> oIX0oI2 = AdActivity.oIX0oI();
        try {
            Intent intent = new Intent(getContext(), oIX0oI2);
            intent.putExtra("ACTIVITY_TYPE", x0OxxIOxX.oIX0oI.f33875x0xO);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.adactivity_missing, oIX0oI2.getName()));
            f18753XIXIxO = null;
            f18752OoO = null;
            f18751OIOoIIOIx = null;
        }
    }

    @Override // oOoIIO0.II0xO0
    public void Oxx0IOOO() {
    }

    public final void Oxx0xo(int i, int i2) {
        this.f18820xI = true;
        if (getLayoutParams() != null) {
            if (getLayoutParams().width > 0) {
                getLayoutParams().width = i;
            }
            if (getLayoutParams().height > 0) {
                getLayoutParams().height = i2;
            }
        }
        if (this.f18806oOXoIIIo && (getParent() instanceof View)) {
            View view = (View) getParent();
            if (view.getLayoutParams() != null) {
                if (view.getLayoutParams().width > 0) {
                    view.getLayoutParams().width = i;
                }
                if (view.getLayoutParams().height > 0) {
                    view.getLayoutParams().height = i2;
                }
            }
        }
    }

    public void OxxIIOOXO(int i, int i2, f fVar) {
        I0oOoX.O0xOxO(this.f18757I0oOoX);
        this.f18757I0oOoX = null;
        AdWebView adWebView = fVar.f19022oIX0oI;
        if (adWebView.f18917OxI) {
            I0oOoX.O0xOxO(adWebView);
            if (fVar.Oxx0xo() != null) {
                fVar.Oxx0xo().addView(fVar.f19022oIX0oI, 0);
            }
            if (fVar.Oo() != null) {
                fVar.Oo().finish();
            }
            if (getMediaType().equals(l.BANNER) && (fVar.f19022oIX0oI.getContext() instanceof MutableContextWrapper)) {
                ((MutableContextWrapper) fVar.f19022oIX0oI.getContext()).setBaseContext(getContext());
            }
        }
        f18753XIXIxO = null;
        f18752OoO = null;
        f18751OIOoIIOIx = null;
        Oxx0xo(i, i2);
        this.f18810oo = true;
        this.f18811oo0xXOI0I = false;
    }

    public final void X0IIOO(String str, int i, xxIXOIIO.oxoX oxox) {
        if (oxox != null) {
            this.f18821xI0oxI00.X0o0xo(oxox);
        }
        setScrollClick(new Oxx0xo(I0oOoX.x0XOIxOo(getContext(), i), str, oxox));
    }

    @Override // oOoIIO0.II0xO0
    public void X0o0xo() {
    }

    public boolean XI0oooXX() {
        return this.f18822xII;
    }

    public void XIXIxO() {
        oOoIIO0.Oxx0xo oxx0xo;
        if (this.f18792XOxIOxOx && (oxx0xo = this.f18785X0IIOO) != null) {
            oxx0xo.I0Io();
        }
    }

    public boolean XIxXXX0x0() {
        return this.f18811oo0xXOI0I;
    }

    @Override // oOoIIO0.II0xO0
    public void XO() {
        a aVar = this.f18773O0xOxO;
        a.EnumC0892a enumC0892a = a.EnumC0892a.FINISHCLOSE;
        aVar.oIX0oI(enumC0892a);
        if (this.f18773O0xOxO.X0o0xo() == enumC0892a) {
            getAdDispatcher().a();
        }
    }

    public void XXoOx0(String str) {
        if (!x0o.II0XooXoX(str)) {
            new com.octopus.ad.internal.Oxx0IOOO(str).XO();
        }
    }

    public void Xo0(boolean z) {
        x0OxxIOxX.oIX0oI oix0oi;
        if (!this.f18818x0o) {
            this.f18818x0o = true;
            this.f18792XOxIOxOx = z;
            if (z && (oix0oi = this.f18782Oxx0xo) != null) {
                this.f18792XOxIOxOx = oix0oi.O0Xx();
            }
            if (this.f18792XOxIOxOx) {
                oOoIIO0.OxxIIOOXO oxxIIOOXO = this.f18831xoXoI;
                if (oxxIIOOXO != null) {
                    oxxIIOOXO.onAdShown();
                    return;
                }
                oOoIIO0.XO xo2 = this.f18781OxI;
                if (xo2 != null) {
                    xo2.onAdShown();
                    return;
                }
                oOoIIO0.xoIox xoiox = this.f18802o00;
                if (xoiox != null) {
                    xoiox.onAdShown();
                    return;
                }
                oOoIIO0.Oxx0xo oxx0xo = this.f18785X0IIOO;
                if (oxx0xo != null) {
                    oxx0xo.XO();
                }
            }
        }
    }

    public void XoX(boolean z, oIX0oI.oxoX oxox, oIX0oI.oxoX oxox2, int i) {
        I0oOoX.O0xOxO(this.f18775OO);
        I0oOoX.O0xOxO(this.f18767IoOoo);
        if (!z && !TextUtils.isEmpty(oxox.I0Io())) {
            this.f18775OO = I0oOoX.I0Io(new MutableContextWrapper(getContext()), oxox, i);
        }
        if (!TextUtils.isEmpty(oxox2.I0Io())) {
            this.f18767IoOoo = I0oOoX.oOoXoXO(new MutableContextWrapper(getContext()), oxox2, i);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void Xx000oIo(int i, View view) {
        long j;
        I0oOoX.O0xOxO(this.f18757I0oOoX);
        I0oOoX.O0xOxO(this.f18793XX);
        IXO.oIX0oI oix0oi = this.f18798XoX;
        if (oix0oi != null) {
            oix0oi.x0XOIxOo();
        }
        if (i <= 0) {
            j = 5;
        } else {
            j = i;
        }
        IXO.oIX0oI oix0oi2 = new IXO.oIX0oI(j * 1000, 50L);
        this.f18798XoX = oix0oi2;
        oix0oi2.XO(new xXxxox0I());
        this.f18798XoX.I0Io();
        view.setVisibility(0);
        O0IxXx();
        view.setOnClickListener(new IIX0o());
    }

    @Override // oOoIIO0.II0xO0
    public void destroy() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "called destroy() on AdView");
        com.octopus.ad.internal.view.I0Io i0Io = this.f18800XxX0x0xxx;
        if (i0Io != null) {
            i0Io.destroy();
            this.f18800XxX0x0xxx = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f18755I0X0x0oIo.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
        c cVar = this.f18774OI0;
        if (cVar != null) {
            cVar.oxoX();
        }
    }

    public com.octopus.ad.internal.II0xO0 getAdDispatcher() {
        return this.f18827xXxxox0I;
    }

    public String getAdId() {
        return this.f18804o0xxxXXxX;
    }

    public com.octopus.ad.internal.I0Io getAdParameters() {
        return this.f18784X00IoxXI;
    }

    public II0xO0.C1145II0xO0 getAdRequest() {
        return this.f18762IO;
    }

    public oOoIIO0.o00 getAdSize() {
        return new oOoIIO0.o00(this.f18805oI0IIXIo, this.f18783OxxIIOOXO);
    }

    public String getAdSlotId() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.get_placement_id, this.f18784X00IoxXI.xoIox()));
        return this.f18784X00IoxXI.xoIox();
    }

    public oOoIIO0.oxoX getAppEventListener() {
        return this.f18786XI0IXoo;
    }

    public oo0xXOI0I getBrowserStyle() {
        return this.f18790XIxXXX0x0;
    }

    public int getContainerHeight() {
        return this.f18784X00IoxXI.IIXOooo();
    }

    public int getContainerWidth() {
        return this.f18784X00IoxXI.OxxIIOOXO();
    }

    public int getCreativeHeight() {
        return this.f18783OxxIIOOXO;
    }

    public int getCreativeWidth() {
        return this.f18805oI0IIXIo;
    }

    public String getExtraData() {
        return this.f18770O00XxXI;
    }

    public String getLandingPageUrl() {
        return this.f18795XX0xXo;
    }

    public boolean getLoadsInBackground() {
        return this.f18766IoOoX;
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public Handler getMyHandler() {
        return this.f18835xxX;
    }

    public boolean getOpensNativeBrowser() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.get_opens_native_browser, this.f18784X00IoxXI.xoXoI()));
        return this.f18784X00IoxXI.xoXoI();
    }

    public int getPrice() {
        return this.f18768Ioxxx;
    }

    public String getRequestId() {
        return this.f18769O0;
    }

    public oOoIIO0.Oxx0xo getRewaredVideoAdListener() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.get_reward_video_ad_listener));
        return this.f18785X0IIOO;
    }

    public boolean getShowLoadingIndicator() {
        return this.f18799Xx000oIo;
    }

    public ViewGroup getSplashParent() {
        return this.f18779Oo;
    }

    public String getTagId() {
        return this.f18834xxIO;
    }

    public String getUserId() {
        return this.f18814ox;
    }

    public void o0() {
        getVisibility();
    }

    public abstract void o00(com.octopus.ad.internal.view.I0Io i0Io);

    public void o0oIxOo() {
        AdWebView adWebView = this.f18771O0X;
        if (adWebView != null) {
            adWebView.oX();
        }
    }

    public boolean o0xxxXXxX() {
        return this.f18792XOxIOxOx;
    }

    public void oI0IIXIo(int i, int i2, int i3, int i4, f.a aVar, boolean z, f fVar) {
        Oxx0xo(i, i2);
        I0oOoX.O0xOxO(this.f18757I0oOoX);
        if (this.f18803o0oIxOo <= 0) {
            this.f18803o0oIxOo = (int) (fVar.f19022oIX0oI.getContext().getResources().getDisplayMetrics().density * 50.0f);
        }
        this.f18757I0oOoX = new Oxx0IOOO(getContext(), fVar);
        int i5 = this.f18803o0oIxOo;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5, 17);
        int i6 = this.f18803o0oIxOo;
        int i7 = (i2 / 2) - (i6 / 2);
        int i8 = (i / 2) - (i6 / 2);
        int i9 = oI0IIXIo.f18875oIX0oI[aVar.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 5) {
                        if (i9 != 6) {
                            if (i9 == 7) {
                                layoutParams.leftMargin = i8;
                                layoutParams.bottomMargin = i7;
                            }
                        } else {
                            layoutParams.rightMargin = i8;
                            layoutParams.bottomMargin = i7;
                        }
                    } else {
                        layoutParams.bottomMargin = i7;
                    }
                } else {
                    layoutParams.leftMargin = i8;
                    layoutParams.topMargin = i7;
                }
            } else {
                layoutParams.rightMargin = i8;
                layoutParams.topMargin = i7;
            }
        } else {
            layoutParams.topMargin = i7;
        }
        this.f18757I0oOoX.setLayoutParams(layoutParams);
        this.f18757I0oOoX.setBackgroundColor(0);
        this.f18757I0oOoX.setOnClickListener(new II0XooXoX(fVar));
        if (fVar.f19022oIX0oI.getParent() != null) {
            ((ViewGroup) fVar.f19022oIX0oI.getParent()).addView(this.f18757I0oOoX);
        }
    }

    @Override // oOoIIO0.II0xO0
    public void oIX0oI() {
        c cVar = this.f18774OI0;
        if (cVar != null) {
            cVar.oxoX();
        }
        xOoOIoI();
        O0();
        xXxxox0I();
    }

    public void oOXoIIIo(AdVideoView adVideoView, boolean z) {
        float f;
        I0oOoX.O0xOxO(this.f18816oxXx0IX);
        AppCompatImageView ooOOo0oXI2 = I0oOoX.ooOOo0oXI(getContext(), z);
        this.f18816oxXx0IX = ooOOo0oXI2;
        ooOOo0oXI2.setOnClickListener(new xoXoI(adVideoView));
        ViewParent parent = adVideoView.getParent();
        if (parent instanceof FrameLayout) {
            com.octopus.ad.internal.xoIox oIX0oI2 = com.octopus.ad.internal.xoIox.oIX0oI();
            int i = this.f18805oI0IIXIo;
            float f2 = 1.0f;
            if (i > 0) {
                f = i / 640.0f;
            } else {
                f = 1.0f;
            }
            if (f <= 1.0f) {
                f2 = f;
            }
            int applyDimension = (int) TypedValue.applyDimension(1, 25.0f * f2, oIX0oI2.xoXoI());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, GravityCompat.START);
            int applyDimension2 = (int) TypedValue.applyDimension(1, (this.f18819x0xO + 15) * f2, oIX0oI2.xoXoI());
            int applyDimension3 = (int) TypedValue.applyDimension(1, f2 * 15.0f, oIX0oI2.xoXoI());
            layoutParams.setMargins(applyDimension3, applyDimension2, applyDimension3, applyDimension3);
            ((FrameLayout) parent).addView(this.f18816oxXx0IX, layoutParams);
        }
    }

    public void oX() {
        ProgressBar progressBar = this.f18826xXOx;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public boolean oXIO0o0XI(II0xO0.C1145II0xO0 c1145II0xO0) {
        c cVar;
        this.f18762IO = c1145II0xO0;
        if (!oxoX()) {
            oOoIIO0.OxxIIOOXO oxxIIOOXO = this.f18831xoXoI;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.onAdFailedToLoad(80000);
            }
            oOoIIO0.xoIox xoiox = this.f18802o00;
            if (xoiox != null) {
                xoiox.onAdFailedToLoad(80000);
            }
            oOoIIO0.XO xo2 = this.f18781OxI;
            if (xo2 != null) {
                xo2.onAdFailedToLoad(80000);
            }
            return false;
        }
        if (getWindowVisibility() == 0 && (cVar = this.f18774OI0) != null) {
            cVar.oxoX();
            this.f18774OI0.xxIXOIIO();
            this.f18774OI0.Oxx0IOOO();
            this.f18822xII = true;
            this.f18756I0oOIX = 1;
            this.f18832xoxXI = 0;
            return true;
        }
        c cVar2 = this.f18774OI0;
        if (cVar2 != null) {
            cVar2.oxoX();
            this.f18774OI0.xxIXOIIO();
            this.f18774OI0.Oxx0IOOO();
            this.f18822xII = true;
            this.f18756I0oOIX = 1;
            this.f18832xoxXI = 0;
        }
        return false;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        II0xO0.ooOOo0oXI oo0xXOI0I2;
        boolean z;
        boolean z2;
        boolean z3;
        View view = this.f18807oOo;
        if (view == null) {
            view = this.f18771O0X;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        x0OxxIOxX.oIX0oI oix0oi = this.f18782Oxx0xo;
        if (oix0oi != null && (oo0xXOI0I2 = oix0oi.oo0xXOI0I()) != null) {
            II0xO0.OOXIXo oIX0oI2 = oo0xXOI0I2.oIX0oI();
            if (oIX0oI2 != null) {
                if (oIX0oI2.oIX0oI() == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                XI0IXoo(z3);
            } else if (this.f18791XO || this.f18764Io) {
                XI0IXoo(false);
            }
            II0xO0.oI0IIXIo Oxx0IOOO2 = oo0xXOI0I2.Oxx0IOOO();
            if (Oxx0IOOO2 != null && Oxx0IOOO2.oIX0oI() == 1) {
                double II0XooXoX2 = Oxx0IOOO2.II0XooXoX();
                double OOXIXo2 = Oxx0IOOO2.OOXIXo();
                String xoIox2 = Oxx0IOOO2.xoIox();
                if (Oxx0IOOO2.oOoXoXO() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (Oxx0IOOO2.X0o0xo() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                IXxxXO(II0XooXoX2, OOXIXo2, xoIox2, z, z2);
            }
            II0xO0.IXxxXO II0XooXoX3 = oo0xXOI0I2.II0XooXoX();
            if (II0XooXoX3 != null && II0XooXoX3.oIX0oI() == 1) {
                O0xOxO(II0XooXoX3.oxoX());
            }
            II0xO0.x0xO0oo XO2 = oo0xXOI0I2.XO();
            if (XO2 != null && XO2.oIX0oI() == 1) {
                x0o(XO2.oxoX());
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void oo(View view) {
        ViewParent viewParent;
        int i;
        AppCompatTextView appCompatTextView = this.f18828xo0x;
        if (appCompatTextView != null) {
            I0oOoX.O0xOxO(appCompatTextView);
            if (xoxXI()) {
                viewParent = view.getParent();
            } else {
                viewParent = this;
            }
            if (viewParent instanceof FrameLayout) {
                x0OxxIOxX.oIX0oI oix0oi = this.f18782Oxx0xo;
                if (oix0oi != null) {
                    int oxxXoxO2 = oix0oi.oxxXoxO();
                    if (getMediaType().equals(l.INTERSTITIAL) && oxxXoxO2 > 0) {
                        i = (int) (oxxXoxO2 * com.octopus.ad.internal.xoIox.oIX0oI().f19070Oxx0xo);
                        int Oxx0xo2 = I0oOoX.Oxx0xo(getContext());
                        if (i > Oxx0xo2) {
                            i = Oxx0xo2;
                        }
                        ((FrameLayout) viewParent).addView(this.f18828xo0x, new FrameLayout.LayoutParams(i, -2, 80));
                    }
                }
                i = -1;
                ((FrameLayout) viewParent).addView(this.f18828xo0x, new FrameLayout.LayoutParams(i, -2, 80));
            }
        }
    }

    public void oo0xXOI0I(int i, int i2, int i3) {
        ViewParent parent;
        ViewParent parent2;
        x0OxxIOxX.oIX0oI oix0oi;
        I0oOoX.O0xOxO(this.f18757I0oOoX);
        I0oOoX.O0xOxO(this.f18793XX);
        IXO.oIX0oI oix0oi2 = this.f18798XoX;
        if (oix0oi2 != null) {
            oix0oi2.x0XOIxOo();
        }
        this.f18757I0oOoX = I0oOoX.X0o0xo(getContext(), this.f18829xoIxX, this.f18819x0xO, this.f18776OO0x0xX, this.f18789XIo0oOXIx);
        if (i3 > 0 && (oix0oi = this.f18782Oxx0xo) != null && oix0oi.I0X0x0oIo()) {
            this.f18793XX = I0oOoX.II0XooXoX(getContext(), i3, this.f18829xoIxX, this.f18819x0xO, this.f18776OO0x0xX, this.f18789XIo0oOXIx);
            if (i2 == -1) {
                this.f18757I0oOoX.setVisibility(8);
            } else if (i2 > 0) {
                if (i3 < 33) {
                    this.f18787XI0oooXX = i3 - ((int) ((i3 * 0.9f) + 0.5f));
                } else {
                    this.f18787XI0oooXX = i3 - 30;
                }
                this.f18757I0oOoX.setEnabled(false);
            }
            IXO.oIX0oI oix0oi3 = new IXO.oIX0oI(i3 * 1000, 50L);
            this.f18798XoX = oix0oi3;
            oix0oi3.XO(new ooXIXxIX());
            this.f18798XoX.I0Io();
            AdVideoView adVideoView = this.f18807oOo;
            if (adVideoView != null) {
                adVideoView.setCountDownTimer(this.f18798XoX);
            }
            x0OxxIOxX.oIX0oI oix0oi4 = this.f18782Oxx0xo;
            if (oix0oi4 != null && oix0oi4.f33935xo0x == l.SPLASH) {
                oix0oi4.XX0xXo(this.f18798XoX);
            }
        } else if (i2 != -1 && i != -1) {
            this.f18793XX = I0oOoX.II0XooXoX(getContext(), i, this.f18829xoIxX, this.f18819x0xO, this.f18776OO0x0xX, this.f18789XIo0oOXIx);
            if (i2 > 0) {
                this.f18757I0oOoX.setEnabled(false);
                if (i < 33) {
                    this.f18787XI0oooXX = i - ((int) ((i * 0.9f) + 0.5f));
                } else {
                    this.f18787XI0oooXX = i - 30;
                }
            }
            IXO.oIX0oI oix0oi5 = new IXO.oIX0oI(i * 1000, 50L);
            this.f18798XoX = oix0oi5;
            oix0oi5.XO(new oIX0oI());
            this.f18798XoX.I0Io();
            AdVideoView adVideoView2 = this.f18807oOo;
            if (adVideoView2 != null) {
                adVideoView2.setCountDownTimer(this.f18798XoX);
            }
        } else if (i != -1) {
            this.f18793XX = I0oOoX.II0XooXoX(getContext(), i, this.f18829xoIxX, this.f18819x0xO, this.f18776OO0x0xX, this.f18789XIo0oOXIx);
            IXO.oIX0oI oix0oi6 = new IXO.oIX0oI(i * 1000, 50L);
            this.f18798XoX = oix0oi6;
            oix0oi6.XO(new II0xO0());
            this.f18798XoX.I0Io();
            AdVideoView adVideoView3 = this.f18807oOo;
            if (adVideoView3 != null) {
                adVideoView3.setCountDownTimer(this.f18798XoX);
            }
            View view = this.f18807oOo;
            if (view == null) {
                view = this.f18771O0X;
            }
            if (xoxXI()) {
                parent = view.getParent();
            } else {
                parent = getParent();
            }
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(this.f18793XX);
                return;
            }
            return;
        }
        this.f18757I0oOoX.setOnClickListener(new oxoX());
        View view2 = this.f18807oOo;
        if (view2 == null) {
            view2 = this.f18771O0X;
        }
        if (xoxXI()) {
            parent2 = view2.getParent();
        } else {
            parent2 = getParent();
        }
        if (parent2 instanceof FrameLayout) {
            AppCompatTextView appCompatTextView = this.f18757I0oOoX;
            if (appCompatTextView != null) {
                I0oOoX.O0xOxO(appCompatTextView);
                ((FrameLayout) parent2).addView(this.f18757I0oOoX);
            }
            AppCompatTextView appCompatTextView2 = this.f18793XX;
            if (appCompatTextView2 != null) {
                I0oOoX.O0xOxO(appCompatTextView2);
                ((FrameLayout) parent2).addView(this.f18793XX);
            }
        }
    }

    public abstract void ooXIXxIX();

    public boolean ox() {
        return this.f18758IIX0;
    }

    public void oxIIX0o(String str, int i) {
        oOoIIO0.Oxx0xo oxx0xo;
        if (this.f18792XOxIOxOx && (oxx0xo = this.f18785X0IIOO) != null) {
            oxx0xo.X0o0xo(new com.octopus.ad.internal.ooOOo0oXI(str, i));
        }
    }

    public void oxXx0IX(X0xII0I.oIX0oI oix0oi, float f) {
        this.f18828xo0x = I0oOoX.XO(getContext(), oix0oi, f, false);
    }

    @Override // com.octopus.ad.internal.oIX0oI
    public boolean oxoX() {
        if (XIxXXX0x0()) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.already_expanded));
            return false;
        }
        com.octopus.ad.internal.I0Io i0Io = this.f18784X00IoxXI;
        if (i0Io == null || !i0Io.OxI() || this.f18762IO == null) {
            return false;
        }
        return true;
    }

    public void oxxXoxO() {
        this.f18762IO = null;
    }

    public void setAdExtInfo(String str) {
        this.f18760IIXOooo = str;
    }

    public void setAdId(String str) {
        this.f18804o0xxxXXxX = str;
    }

    public void setAdSlotId(String str) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.set_placement_id, str));
        this.f18784X00IoxXI.oxoX(str);
    }

    public void setAdVideoView(AdVideoView adVideoView) {
        this.f18807oOo = adVideoView;
    }

    public void setAdWebView(AdWebView adWebView) {
        this.f18771O0X = adWebView;
    }

    public void setAppEventListener(oOoIIO0.oxoX oxox) {
        this.f18786XI0IXoo = oxox;
    }

    public void setBannerAdListener(oOoIIO0.XO xo2) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.set_banner_ad_listener));
        this.f18781OxI = xo2;
    }

    public void setBrowserStyle(oo0xXOI0I oo0xxoi0i) {
        this.f18790XIxXXX0x0 = oo0xxoi0i;
    }

    public void setChannel(String str) {
        this.f18784X00IoxXI.II0XooXoX(str);
    }

    public void setCreativeHeight(int i) {
        this.f18783OxxIIOOXO = i;
    }

    public void setCreativeWidth(int i) {
        this.f18805oI0IIXIo = i;
    }

    public void setExtraData(String str) {
        this.f18770O00XxXI = str;
    }

    public void setInterstitialAdListener(oOoIIO0.xoIox xoiox) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.set_interstitial_ad_listener));
        this.f18802o00 = xoiox;
    }

    public void setIsBoost(boolean z) {
        this.f18784X00IoxXI.xxIXOIIO(z);
    }

    public void setLandingPageUrl(String str) {
        this.f18795XX0xXo = str;
    }

    public void setLoadsInBackground(boolean z) {
        this.f18766IoOoX = z;
    }

    public void setOpensNativeBrowser(boolean z) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.oI0IIXIo(R.string.set_opens_native_browser, z));
        this.f18784X00IoxXI.ooOOo0oXI(z);
    }

    public void setPrice(int i) {
        this.f18768Ioxxx = i;
    }

    public void setRequestId(String str) {
        this.f18784X00IoxXI.oOoXoXO(str);
    }

    public void setRewardVideoAdListener(oOoIIO0.Oxx0xo oxx0xo) {
        if (!this.f18764Io) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, "setRewardVideoAdListener() called on non-RewardVideoAd");
        } else {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.set_reward_video_ad_listener));
            this.f18785X0IIOO = oxx0xo;
        }
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        View view = this.f18807oOo;
        if (view == null) {
            view = this.f18771O0X;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public void setShouldResizeParent(boolean z) {
        this.f18806oOXoIIIo = z;
    }

    public void setShowLoadingIndicator(boolean z) {
        this.f18799Xx000oIo = z;
    }

    public void setSplashAdListener(oOoIIO0.OxxIIOOXO oxxIIOOXO) {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18704oxoX, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.set_splash_ad_listener));
        this.f18831xoXoI = oxxIIOOXO;
    }

    public void setTagId(String str) {
        this.f18834xxIO = str;
    }

    public void setUserId(String str) {
        this.f18814ox = str;
    }

    public void setValidTime(long j) {
        com.octopus.ad.internal.xoIox.f19058ooXIXxIX = j;
        this.f18761IIxOXoOo0 = j;
    }

    public void x0(AdVideoView adVideoView) {
        float f;
        ProgressBar progressBar = this.f18826xXOx;
        if (progressBar == null) {
            this.f18826xXOx = I0oOoX.OOXIXo(getContext());
            ViewParent parent = adVideoView.getParent();
            if (parent instanceof FrameLayout) {
                com.octopus.ad.internal.xoIox oIX0oI2 = com.octopus.ad.internal.xoIox.oIX0oI();
                int i = this.f18805oI0IIXIo;
                float f2 = 1.0f;
                if (i > 0) {
                    f = i / 640.0f;
                } else {
                    f = 1.0f;
                }
                if (f <= 1.0f) {
                    f2 = f;
                }
                int applyDimension = (int) TypedValue.applyDimension(1, f2 * 40.0f, oIX0oI2.xoXoI());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(applyDimension, applyDimension, 17);
                I0oOoX.O0xOxO(this.f18826xXOx);
                ((FrameLayout) parent).addView(this.f18826xXOx, layoutParams);
                return;
            }
            return;
        }
        progressBar.setVisibility(0);
    }

    public void x0OIX00oO(String str) {
        if (!x0o.II0XooXoX(str)) {
            new com.octopus.ad.internal.Oxx0IOOO(str).XO();
        }
    }

    public void x0OxxIOxX() {
        this.f18793XX.setText("");
        this.f18793XX.setBackgroundResource(R.drawable.oct_close);
        this.f18793XX.setVisibility(0);
        this.f18793XX.setOnClickListener(new xxX());
    }

    public Context x0xO0oo(View view) {
        Context context;
        if (view == null) {
            return null;
        }
        if (view.getContext() instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) view.getContext()).getBaseContext();
        } else {
            context = getContext();
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        return context;
    }

    public void xI() {
        I0oOoX.O0xOxO(this.f18817oxxXoxO);
        ImageView xxIXOIIO2 = I0oOoX.xxIXOIIO(getContext());
        this.f18817oxxXoxO = xxIXOIIO2;
        xxIXOIIO2.setVisibility(0);
        this.f18817oxxXoxO.setEnabled(true);
        this.f18817oxxXoxO.setOnClickListener(new XxX0x0xxx());
    }

    public void xI0oxI00(int i) {
        if (!this.f18764Io) {
            oOoIIO0.OxxIIOOXO oxxIIOOXO = this.f18831xoXoI;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.onAdFailedToLoad(i);
            }
            oOoIIO0.xoIox xoiox = this.f18802o00;
            if (xoiox != null) {
                xoiox.onAdFailedToLoad(i);
            }
            oOoIIO0.XO xo2 = this.f18781OxI;
            if (xo2 != null) {
                xo2.onAdFailedToLoad(i);
                return;
            }
            return;
        }
        oOoIIO0.Oxx0xo oxx0xo = this.f18785X0IIOO;
        if (oxx0xo != null) {
            oxx0xo.II0xO0(i);
        }
    }

    public abstract void xII(Context context, AttributeSet attributeSet);

    public void xXOx() {
        getVisibility();
    }

    public void xXoOI00O(View view) {
        ImageView imageView;
        if ((view instanceof FrameLayout) && (imageView = this.f18817oxxXoxO) != null) {
            ((FrameLayout) view).addView(imageView);
        }
    }

    public abstract void xXxxox0I();

    @Override // oOoIIO0.II0xO0
    public void xoIox() {
        this.f18773O0xOxO.oIX0oI(a.EnumC0892a.STATE_BACKGROUND);
    }

    public Activity xoIxX(View view) {
        return (Activity) x0xO0oo(view);
    }

    public void xoXoI(Context context, AttributeSet attributeSet) {
        setBackgroundColor(0);
        this.f18827xXxxox0I = new xI(this.f18835xxX);
        this.f18769O0 = x0o.X0o0xo();
        this.f18784X00IoxXI = new com.octopus.ad.internal.I0Io(context, this.f18769O0);
        IO0XoXxO.oIX0oI.I0Io(new I0Io());
        try {
            com.octopus.ad.internal.utilities.oIX0oI.XI0IXoo(getContext().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setPadding(0, 0, 0, 0);
        this.f18774OI0 = new c(this);
        if (attributeSet != null) {
            xII(context, attributeSet);
        }
        this.f18833xx0X0 = new IO0XoXxO.xoIox(getContext());
        this.f18821xI0oxI00 = new IO0XoXxO.xxIXOIIO(getContext());
        this.f18765IoIOOxIIo = new IO0XoXxO.II0XooXoX(getContext());
    }

    public abstract boolean xoxXI();

    public void xx0X0() {
        if (!this.f18824xOoOIoI) {
            this.f18824xOoOIoI = true;
            oOoIIO0.OxxIIOOXO oxxIIOOXO = this.f18831xoXoI;
            if (oxxIIOOXO != null) {
                oxxIIOOXO.onAdCacheLoaded();
            }
            oOoIIO0.xoIox xoiox = this.f18802o00;
            if (xoiox != null) {
                xoiox.onAdCacheLoaded();
            }
            oOoIIO0.Oxx0xo oxx0xo = this.f18785X0IIOO;
            if (oxx0xo != null) {
                oxx0xo.onRewardVideoCached();
            }
            if (this.f18781OxI != null) {
                BannerAdView bannerAdView = new BannerAdView(getContext(), this);
                bannerAdView.II0xO0();
                this.f18781OxI.onRenderSuccess(bannerAdView);
            }
        }
    }

    @Override // oOoIIO0.II0xO0
    public void xxIXOIIO() {
    }

    public void xxOXOOoIX(View view) {
        ViewParent viewParent;
        I0oOoX.O0xOxO(this.f18775OO);
        I0oOoX.O0xOxO(this.f18767IoOoo);
        if (xoxXI()) {
            viewParent = view.getParent();
        } else {
            viewParent = this;
        }
        if (viewParent instanceof FrameLayout) {
            if (this.f18775OO != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 42, 83);
                layoutParams.setMargins(16, 0, 0, 16);
                ((FrameLayout) viewParent).addView(this.f18775OO, layoutParams);
                this.f18775OO.setVisibility(0);
            }
            if (this.f18767IoOoo != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 42, 85);
                layoutParams2.setMargins(0, 0, 16, 16);
                ((FrameLayout) viewParent).addView(this.f18767IoOoo, layoutParams2);
                this.f18767IoOoo.setVisibility(0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements IXO.II0xO0 {

        /* loaded from: classes11.dex */
        public class oIX0oI implements View.OnClickListener {
            public oIX0oI() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdViewImpl.this.xoxXI()) {
                    if (AdViewImpl.this.f18812ooOx) {
                        AdViewImpl.this.ooOx();
                    } else {
                        AdViewImpl.this.xOOOX();
                    }
                }
            }
        }

        public II0xO0() {
        }

        @Override // IXO.II0xO0
        @SuppressLint({"SetTextI18n"})
        public void a(long j) {
            AdViewImpl.this.f18793XX.setText(Integer.toString((int) ((j / 1000) + 1)));
        }

        @Override // IXO.II0xO0
        public void b() {
        }

        @Override // IXO.II0xO0
        public void a() {
            AdViewImpl.this.f18793XX.setText("关闭");
            AdViewImpl.this.f18793XX.setOnClickListener(new oIX0oI());
            if (AdViewImpl.this.f18807oOo != null) {
                AdViewImpl.this.f18807oOo.O0xOxO();
                AdViewImpl.this.f18807oOo.o00();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class XIxXXX0x0 implements IXO.II0xO0 {
        public XIxXXX0x0() {
        }

        @Override // IXO.II0xO0
        @SuppressLint({"SetTextI18n"})
        public void a(long j) {
            AdViewImpl.this.f18793XX.setText(Integer.toString((int) ((j / 1000) + 1)));
        }

        @Override // IXO.II0xO0
        public void b() {
        }

        @Override // IXO.II0xO0
        public void a() {
            AdViewImpl.this.x0OxxIOxX();
        }
    }

    public AdViewImpl(Context context, ViewGroup viewGroup, View view) {
        super(context, null, 0);
        this.f18760IIXOooo = "";
        this.f18773O0xOxO = new a();
        this.f18835xxX = new OOXIXo(Looper.getMainLooper());
        this.f18820xI = false;
        this.f18811oo0xXOI0I = false;
        this.f18810oo = false;
        this.f18766IoOoX = true;
        this.f18806oOXoIIIo = false;
        this.f18799Xx000oIo = true;
        this.f18784X00IoxXI = null;
        this.f18762IO = null;
        this.f18822xII = false;
        this.f18764Io = false;
        this.f18801o0 = false;
        this.f18787XI0oooXX = 0;
        this.f18788XIXIX = true;
        this.f18809oXIO0o0XI = 0;
        this.f18758IIX0 = false;
        this.f18824xOoOIoI = false;
        this.f18815oxIIX0o = new IIXOooo();
        this.f18803o0oIxOo = 0;
        this.f18791XO = true;
        this.f18779Oo = viewGroup;
        if (view == null) {
            this.f18754I0 = true;
            try {
                this.f18763IXxxXO = new SkipView(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            this.f18754I0 = false;
            this.f18763IXxxXO = view;
        }
        xoXoI(context, null);
    }

    /* loaded from: classes11.dex */
    public class XI0IXoo implements IXO.II0xO0 {
        public XI0IXoo() {
        }

        @Override // IXO.II0xO0
        @SuppressLint({"SetTextI18n"})
        public void a(long j) {
            int i = (int) ((j / 1000) + 1);
            if (AdViewImpl.this.f18787XI0oooXX > 0) {
                int unused = AdViewImpl.this.f18787XI0oooXX;
            }
            AdViewImpl.this.f18793XX.setText(Integer.toString(i));
        }

        @Override // IXO.II0xO0
        public void b() {
        }

        @Override // IXO.II0xO0
        public void a() {
            x0OxxIOxX.oIX0oI oix0oi = AdViewImpl.this.f18782Oxx0xo;
            if (oix0oi != null && oix0oi.I0X0x0oIo()) {
                AdViewImpl.this.f18793XX.setText("0");
                AdViewImpl.this.xOOOX();
            } else {
                AdViewImpl.this.x0OxxIOxX();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class xXxxox0I implements IXO.II0xO0 {
        public xXxxox0I() {
        }

        @Override // IXO.II0xO0
        public void a(long j) {
            AdViewImpl.this.getAdDispatcher().a(j);
            int i = (int) ((j / 1000) + 1);
            if (AdViewImpl.this.f18763IXxxXO == null || !AdViewImpl.this.f18754I0) {
                return;
            }
            ((SkipView) AdViewImpl.this.f18763IXxxXO).setText(String.format("跳过 %d", Integer.valueOf(i)));
        }

        @Override // IXO.II0xO0
        public void b() {
        }

        @Override // IXO.II0xO0
        public void a() {
            AdViewImpl.this.f18773O0xOxO.II0xO0(true);
            if (AdViewImpl.this.f18773O0xOxO.I0Io() && (AdViewImpl.this.f18773O0xOxO.X0o0xo() == a.EnumC0892a.UNCHANGE || AdViewImpl.this.f18773O0xOxO.X0o0xo() == a.EnumC0892a.STATE_PREPARE_CHANGE)) {
                AdViewImpl.this.getAdDispatcher().a();
            }
            if (AdViewImpl.this.f18791XO) {
                return;
            }
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18707xoIox, "Should not close banner!");
        }
    }

    /* loaded from: classes11.dex */
    public class ooXIXxIX implements IXO.II0xO0 {
        public ooXIXxIX() {
        }

        @Override // IXO.II0xO0
        @SuppressLint({"SetTextI18n"})
        public void a(long j) {
            int i = (int) ((j / 1000) + 1);
            AdViewImpl.this.f18793XX.setText(Integer.toString(i));
            if (AdViewImpl.this.f18787XI0oooXX <= 0 || i > AdViewImpl.this.f18787XI0oooXX) {
                return;
            }
            if (AdViewImpl.this.f18807oOo != null) {
                AdViewImpl.this.f18807oOo.O0xOxO();
            }
            AdViewImpl.this.f18757I0oOoX.setEnabled(true);
        }

        @Override // IXO.II0xO0
        public void b() {
        }

        @Override // IXO.II0xO0
        public void a() {
            AdViewImpl.this.f18793XX.setText("0");
            if (AdViewImpl.this.f18807oOo != null) {
                AdViewImpl.this.f18807oOo.O0xOxO();
                AdViewImpl.this.f18807oOo.o00();
            }
            AdViewImpl.this.xOOOX();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements IXO.II0xO0 {

        /* loaded from: classes11.dex */
        public class II0xO0 implements View.OnClickListener {
            public II0xO0() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdViewImpl.this.xoxXI()) {
                    if (AdViewImpl.this.f18812ooOx) {
                        AdViewImpl.this.ooOx();
                    } else {
                        AdViewImpl.this.xOOOX();
                    }
                }
            }
        }

        /* renamed from: com.octopus.ad.internal.view.AdViewImpl$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class ViewOnClickListenerC0893oIX0oI implements View.OnClickListener {
            public ViewOnClickListenerC0893oIX0oI() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdViewImpl.this.xOOOX();
            }
        }

        public oIX0oI() {
        }

        @Override // IXO.II0xO0
        @SuppressLint({"SetTextI18n"})
        public void a(long j) {
            int i = (int) ((j / 1000) + 1);
            AdViewImpl.this.f18793XX.setText(Integer.toString(i));
            if (AdViewImpl.this.f18787XI0oooXX <= 0 || i > AdViewImpl.this.f18787XI0oooXX) {
                return;
            }
            if (AdViewImpl.this.f18807oOo != null) {
                AdViewImpl.this.f18807oOo.O0xOxO();
            }
            AdViewImpl.this.f18757I0oOoX.setEnabled(true);
            AdViewImpl.this.f18757I0oOoX.setOnClickListener(new ViewOnClickListenerC0893oIX0oI());
        }

        @Override // IXO.II0xO0
        public void b() {
        }

        @Override // IXO.II0xO0
        public void a() {
            AdViewImpl.this.f18793XX.setText("关闭");
            AdViewImpl.this.f18793XX.setOnClickListener(new II0xO0());
            AdViewImpl.this.f18757I0oOoX.setVisibility(8);
            if (AdViewImpl.this.f18807oOo != null) {
                AdViewImpl.this.f18807oOo.O0xOxO();
                AdViewImpl.this.f18807oOo.o00();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class xI implements com.octopus.ad.internal.II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public x0OxxIOxX.I0Io f18888II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Handler f18889oIX0oI;

        /* loaded from: classes11.dex */
        public class I0Io implements Runnable {
            public I0Io() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AdViewImpl adViewImpl = AdViewImpl.this;
                if (!adViewImpl.f18764Io) {
                    if (adViewImpl.f18831xoXoI != null) {
                        AdViewImpl.this.f18831xoXoI.onAdClosed();
                    }
                    if (AdViewImpl.this.f18802o00 != null) {
                        AdViewImpl.this.f18802o00.onAdClosed();
                    }
                    if (AdViewImpl.this.f18781OxI != null) {
                        AdViewImpl.this.f18781OxI.onAdClosed();
                    }
                } else if (adViewImpl.f18785X0IIOO != null) {
                    AdViewImpl.this.f18785X0IIOO.oxoX();
                }
                AdViewImpl.this.f18773O0xOxO.oxoX();
            }
        }

        /* loaded from: classes11.dex */
        public class II0xO0 implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f18892XO;

            public II0xO0(int i) {
                this.f18892XO = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                AdViewImpl.this.xI0oxI00(this.f18892XO);
            }
        }

        /* loaded from: classes11.dex */
        public class X0o0xo implements Runnable {

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ String f18894Oo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ String f18895XO;

            public X0o0xo(String str, String str2) {
                this.f18895XO = str;
                this.f18894Oo = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AdViewImpl.this.f18786XI0IXoo != null) {
                    AdViewImpl.this.f18786XI0IXoo.oIX0oI(this.f18895XO, this.f18894Oo);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class XO implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ long f18897XO;

            public XO(long j) {
                this.f18897XO = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AdViewImpl.this.f18831xoXoI != null && xI.this.f18888II0xO0 != null && xI.this.f18888II0xO0.a().equals(l.SPLASH)) {
                    AdViewImpl.this.f18831xoXoI.onAdTick(this.f18897XO);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ x0OxxIOxX.I0Io f18899XO;

            public oIX0oI(x0OxxIOxX.I0Io i0Io) {
                this.f18899XO = i0Io;
            }

            @Override // java.lang.Runnable
            public void run() {
                AdViewImpl.this.setCreativeWidth(this.f18899XO.b().getCreativeWidth());
                AdViewImpl.this.setCreativeHeight(this.f18899XO.b().getCreativeHeight());
                AdViewImpl.this.setAdExtInfo(this.f18899XO.d());
                AdViewImpl.this.setPrice(this.f18899XO.e());
                AdViewImpl.this.setTagId(this.f18899XO.f());
                AdViewImpl.this.setAdId(this.f18899XO.g());
                AdViewImpl.this.setValidTime(this.f18899XO.h());
                AdViewImpl.this.o00(this.f18899XO.b());
                AdViewImpl.this.IoIOOxIIo();
                (AdViewImpl.this.f18807oOo == null ? AdViewImpl.this.f18771O0X : AdViewImpl.this.f18807oOo).getViewTreeObserver().addOnGlobalLayoutListener(AdViewImpl.this);
            }
        }

        /* loaded from: classes11.dex */
        public class oxoX implements Runnable {
            public oxoX() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.i("OctopusAd", "enter Octopus ad click");
                AdViewImpl adViewImpl = AdViewImpl.this;
                if (!adViewImpl.f18764Io) {
                    adViewImpl.f18773O0xOxO.oIX0oI(a.EnumC0892a.STATE_PREPARE_CHANGE);
                    if (AdViewImpl.this.f18792XOxIOxOx && AdViewImpl.this.f18788XIXIX && !AdViewImpl.this.f18825xX0IIXIx0) {
                        if (AdViewImpl.this.f18831xoXoI != null) {
                            AdViewImpl.this.f18831xoXoI.onAdClicked();
                        }
                        if (AdViewImpl.this.f18802o00 != null) {
                            AdViewImpl.this.f18802o00.onAdClicked();
                        }
                        if (AdViewImpl.this.f18781OxI != null) {
                            AdViewImpl.this.f18781OxI.onAdClicked();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (adViewImpl.f18785X0IIOO != null) {
                    AdViewImpl.this.f18773O0xOxO.oIX0oI(a.EnumC0892a.STATE_PREPARE_CHANGE);
                    if (AdViewImpl.this.f18792XOxIOxOx && AdViewImpl.this.f18788XIXIX && !AdViewImpl.this.f18825xX0IIXIx0) {
                        AdViewImpl.this.f18785X0IIOO.oIX0oI();
                    }
                }
            }
        }

        public xI(Handler handler) {
            this.f18889oIX0oI = handler;
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(boolean z) {
            AdViewImpl.this.Xo0(z);
            AdViewImpl.this.f18794XX0 = System.currentTimeMillis();
            AdViewImpl adViewImpl = AdViewImpl.this;
            if (adViewImpl.f18782Oxx0xo != null) {
                adViewImpl.O0IxXx();
                AdViewImpl adViewImpl2 = AdViewImpl.this;
                AdViewImpl.oI(adViewImpl2.f18782Oxx0xo, adViewImpl2.f18815oxIIX0o);
                AdViewImpl adViewImpl3 = AdViewImpl.this;
                adViewImpl3.f18788XIXIX = AdViewImpl.XX0xXo(adViewImpl3.f18782Oxx0xo);
                if (!AdViewImpl.this.f18788XIXIX) {
                    AdViewImpl.this.f18809oXIO0o0XI = 8;
                }
            }
            AdViewImpl.this.f18771O0X.setOpt(AdViewImpl.this.f18809oXIO0o0XI);
            if (AdViewImpl.this.f18807oOo != null) {
                AdViewImpl.this.f18807oOo.setOpt(AdViewImpl.this.f18809oXIO0o0XI);
            }
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void b() {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void c() {
            this.f18889oIX0oI.post(new oxoX());
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void d() {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void e() {
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void oIX0oI(x0OxxIOxX.I0Io i0Io) {
            this.f18888II0xO0 = i0Io;
            if (!i0Io.a().equals(l.SPLASH) && !i0Io.a().equals(l.BANNER) && !i0Io.a().equals(l.INTERSTITIAL) && !i0Io.a().equals(l.REWARDVIDEO)) {
                a(oOoIIO0.I0Io.f32023xxIXOIIO);
                return;
            }
            if (AdViewImpl.this.f18784X00IoxXI.oI0IIXIo()) {
                AdViewImpl.this.XIo0oOXIx();
                return;
            }
            if (AdViewImpl.this.f18782Oxx0xo.IIX0o() == 1) {
                a(oOoIIO0.I0Io.f32017XO);
                AdViewImpl.this.OO0x0xX();
                if (!AdViewImpl.this.f18823xOOOX) {
                    x0OxxIOxX.II0xO0.XO(AdViewImpl.this.getContext(), AdViewImpl.this.f18782Oxx0xo.xxX(), AdViewImpl.this.getMediaType());
                    return;
                }
                return;
            }
            this.f18889oIX0oI.post(new oIX0oI(i0Io));
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(int i) {
            this.f18889oIX0oI.post(new II0xO0(i));
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a() {
            if (AdViewImpl.this.f18830xoO0xx0) {
                return;
            }
            AdViewImpl.this.f18830xoO0xx0 = true;
            x0OxxIOxX.oIX0oI oix0oi = AdViewImpl.this.f18782Oxx0xo;
            if (oix0oi != null) {
                oix0oi.x0xO();
            }
            this.f18889oIX0oI.post(new I0Io());
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(String str, String str2) {
            this.f18889oIX0oI.post(new X0o0xo(str, str2));
        }

        @Override // com.octopus.ad.internal.II0xO0
        public void a(long j) {
            this.f18889oIX0oI.post(new XO(j));
        }
    }

    public AdViewImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18760IIXOooo = "";
        this.f18773O0xOxO = new a();
        this.f18835xxX = new OOXIXo(Looper.getMainLooper());
        this.f18820xI = false;
        this.f18811oo0xXOI0I = false;
        this.f18810oo = false;
        this.f18766IoOoX = true;
        this.f18806oOXoIIIo = false;
        this.f18799Xx000oIo = true;
        this.f18784X00IoxXI = null;
        this.f18762IO = null;
        this.f18822xII = false;
        this.f18764Io = false;
        this.f18801o0 = false;
        this.f18787XI0oooXX = 0;
        this.f18788XIXIX = true;
        this.f18809oXIO0o0XI = 0;
        this.f18758IIX0 = false;
        this.f18824xOoOIoI = false;
        this.f18815oxIIX0o = new IIXOooo();
        this.f18803o0oIxOo = 0;
        xoXoI(context, attributeSet);
    }
}
