package com.octopus.ad.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.octopus.ad.R;
import o0IXXIx.II0XooXoX;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class ScrollClickView extends LinearLayout {

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final String f19358IIX0o = "down";

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final String f19359XxX0x0xxx = "left";

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final String f19360xXxxox0I = "up";

    /* renamed from: xxX, reason: collision with root package name */
    public static final String f19361xxX = "right";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public String f19362IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ImageView f19363IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public Context f19364O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public ImageView f19365Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public ValueAnimator f19366OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public TextView f19367Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f19368OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public FrameLayout f19369X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public FrameLayout f19370XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public LinearLayout f19371XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f19372XO;

    /* renamed from: o00, reason: collision with root package name */
    public int f19373o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f19374oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f19375xoXoI;

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {

        /* loaded from: classes11.dex */
        public class oIX0oI implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f19378XO;

            public oIX0oI(int i) {
                this.f19378XO = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f19369X0IIOO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = intValue;
                }
                ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f19370XI0IXoo.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = intValue - (this.f19378XO / 3);
                }
                ScrollClickView.this.f19369X0IIOO.requestLayout();
            }
        }

        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScrollClickView.this.f19369X0IIOO != null && ScrollClickView.this.f19370XI0IXoo != null) {
                if (ScrollClickView.this.f19365Oo.getLayoutParams() == null) {
                    return;
                }
                int i = ScrollClickView.this.f19365Oo.getLayoutParams().height;
                ScrollClickView scrollClickView = ScrollClickView.this;
                scrollClickView.f19366OxI = ValueAnimator.ofInt(i, scrollClickView.f19373o00);
                ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f19363IXxxXO.getLayoutParams();
                II0XooXoX.II0xO0("ScrollClickUtil", "handHeight = " + i);
                if (layoutParams != null) {
                    layoutParams.height = ScrollClickView.this.f19373o00;
                }
                ScrollClickView.this.f19366OxI.setDuration(1000L);
                ScrollClickView.this.f19366OxI.setRepeatCount(-1);
                ScrollClickView.this.f19366OxI.setRepeatMode(1);
                ScrollClickView.this.f19366OxI.addUpdateListener(new oIX0oI(i));
                return;
            }
            II0XooXoX.II0xO0("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: com.octopus.ad.widget.ScrollClickView$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class C0901oIX0oI implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f19381XO;

            public C0901oIX0oI(int i) {
                this.f19381XO = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f19365Oo.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).topMargin = ScrollClickView.this.f19373o00 - intValue;
                }
                ViewGroup.LayoutParams layoutParams2 = ScrollClickView.this.f19370XI0IXoo.getLayoutParams();
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    layoutParams2.height = intValue - (this.f19381XO / 3);
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
                    layoutParams3.topMargin = ScrollClickView.this.f19373o00 - layoutParams3.height;
                }
                ScrollClickView.this.f19369X0IIOO.requestLayout();
            }
        }

        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScrollClickView.this.f19369X0IIOO != null && ScrollClickView.this.f19370XI0IXoo != null) {
                if (ScrollClickView.this.f19365Oo.getLayoutParams() == null) {
                    return;
                }
                int i = ScrollClickView.this.f19365Oo.getLayoutParams().height;
                ScrollClickView scrollClickView = ScrollClickView.this;
                scrollClickView.f19366OxI = ValueAnimator.ofInt(i, scrollClickView.f19373o00);
                II0XooXoX.II0xO0("ScrollClickUtil", "handHeight = " + i + ",scrollbarHeight = " + ScrollClickView.this.f19373o00);
                ViewGroup.LayoutParams layoutParams = ScrollClickView.this.f19363IXxxXO.getLayoutParams();
                StringBuilder sb = new StringBuilder();
                sb.append("handHeight = ");
                sb.append(i);
                II0XooXoX.II0xO0("ScrollClickUtil", sb.toString());
                if (layoutParams != null) {
                    layoutParams.height = ScrollClickView.this.f19373o00;
                }
                ScrollClickView.this.f19366OxI.setDuration(1000L);
                ScrollClickView.this.f19366OxI.setRepeatCount(-1);
                ScrollClickView.this.f19366OxI.setRepeatMode(1);
                ScrollClickView.this.f19366OxI.addUpdateListener(new C0901oIX0oI(i));
                return;
            }
            II0XooXoX.II0xO0("ScrollClickUtil", "scrollContainer or scrollBarContainer is null , please check !");
        }
    }

    public ScrollClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19372XO = false;
        this.f19368OxxIIOOXO = 12;
        this.f19362IIXOooo = "up";
        this.f19375xoXoI = 45;
        this.f19373o00 = 180;
        this.f19371XIxXXX0x0 = null;
        xxIXOIIO(context);
    }

    public final void I0Io() {
        this.f19365Oo.post(new oIX0oI());
    }

    public void OOXIXo() {
        ValueAnimator valueAnimator = this.f19366OxI;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f19366OxI.cancel();
        }
    }

    public final void X0o0xo() {
        this.f19365Oo.post(new II0xO0());
    }

    public void XO() {
        try {
            if ("up".equalsIgnoreCase(this.f19362IIXOooo)) {
                this.f19371XIxXXX0x0 = (LinearLayout) LayoutInflater.from(this.f19364O0xOxO).inflate(R.layout.oct_layout_scrollview_up, this);
            } else if (f19358IIX0o.equalsIgnoreCase(this.f19362IIXOooo)) {
                this.f19371XIxXXX0x0 = (LinearLayout) LayoutInflater.from(this.f19364O0xOxO).inflate(R.layout.oct_layout_scrollview_down, this);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if ("up".equalsIgnoreCase(this.f19362IIXOooo)) {
                this.f19371XIxXXX0x0 = (LinearLayout) LayoutInflater.from(this.f19364O0xOxO.getApplicationContext()).inflate(R.layout.oct_layout_scrollview_up, this);
            } else if (f19358IIX0o.equalsIgnoreCase(this.f19362IIXOooo)) {
                this.f19371XIxXXX0x0 = (LinearLayout) LayoutInflater.from(this.f19364O0xOxO.getApplicationContext()).inflate(R.layout.oct_layout_scrollview_down, this);
            }
        }
        LinearLayout linearLayout = this.f19371XIxXXX0x0;
        if (linearLayout == null) {
            return;
        }
        this.f19365Oo = (ImageView) linearLayout.findViewById(R.id.hand);
        this.f19363IXxxXO = (ImageView) this.f19371XIxXXX0x0.findViewById(R.id.scrollbar);
        this.f19367Oxx0xo = (TextView) this.f19371XIxXXX0x0.findViewById(R.id.title);
        this.f19369X0IIOO = (FrameLayout) this.f19371XIxXXX0x0.findViewById(R.id.scroll_container);
        this.f19370XI0IXoo = (FrameLayout) this.f19371XIxXXX0x0.findViewById(R.id.scrollbar_container);
        this.f19375xoXoI = I0oOoX.x0XOIxOo(this.f19364O0xOxO, this.f19375xoXoI);
        this.f19373o00 = I0oOoX.x0XOIxOo(this.f19364O0xOxO, this.f19373o00) + this.f19375xoXoI;
        TextView textView = this.f19367Oxx0xo;
        if (textView != null) {
            textView.setText(this.f19374oI0IIXIo);
            this.f19367Oxx0xo.setTextSize(2, this.f19368OxxIIOOXO);
        }
        ImageView imageView = this.f19365Oo;
        if (imageView != null && this.f19363IXxxXO != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f19363IXxxXO.getLayoutParams();
            if (layoutParams != null) {
                int i = this.f19375xoXoI;
                layoutParams.width = i;
                layoutParams.height = i;
                if (layoutParams2 != null) {
                    layoutParams2.height = this.f19373o00;
                    layoutParams2.width = (int) (i * 0.55f);
                }
            }
            if (f19358IIX0o.equalsIgnoreCase(this.f19362IIXOooo)) {
                X0o0xo();
            } else if ("up".equalsIgnoreCase(this.f19362IIXOooo)) {
                I0Io();
            } else if (!"left".equalsIgnoreCase(this.f19362IIXOooo)) {
                "right".equalsIgnoreCase(this.f19362IIXOooo);
            }
        }
    }

    public void setHandWidth(int i) {
        this.f19375xoXoI = i;
    }

    public void setScrollDirection(String str) {
        this.f19362IIXOooo = str;
    }

    public void setScrollbarHeight(int i) {
        this.f19373o00 = i;
    }

    public void setTitleFont(int i) {
        this.f19368OxxIIOOXO = i;
    }

    public void setTitleText(String str) {
        this.f19374oI0IIXIo = str;
    }

    public void xoIox() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("startAnim animator != null ? ");
        if (this.f19366OxI != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        II0XooXoX.II0xO0("ScrollClickUtil", sb.toString());
        ValueAnimator valueAnimator = this.f19366OxI;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void xxIXOIIO(Context context) {
        if (this.f19372XO) {
            return;
        }
        this.f19364O0xOxO = context;
        this.f19372XO = true;
    }

    public ScrollClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19372XO = false;
        this.f19368OxxIIOOXO = 12;
        this.f19362IIXOooo = "up";
        this.f19375xoXoI = 45;
        this.f19373o00 = 180;
        this.f19371XIxXXX0x0 = null;
        xxIXOIIO(context);
    }

    public ScrollClickView(Context context) {
        super(context);
        this.f19372XO = false;
        this.f19368OxxIIOOXO = 12;
        this.f19362IIXOooo = "up";
        this.f19375xoXoI = 45;
        this.f19373o00 = 180;
        this.f19371XIxXXX0x0 = null;
        xxIXOIIO(context);
    }
}
