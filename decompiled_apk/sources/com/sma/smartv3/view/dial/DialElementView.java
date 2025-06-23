package com.sma.smartv3.view.dial;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xoIox;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.R;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class DialElementView extends RelativeLayout {

    /* renamed from: IIX0o, reason: collision with root package name */
    @oOoXoXO
    public ImageView f25451IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f25452IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    @oOoXoXO
    public String f25453IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public int f25454O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f25455Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public int f25456OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f25457Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f25458OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f25459X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f25460XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f25461XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f25462XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public float f25463XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public int f25464o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f25465oI0IIXIo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public float f25466oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    @oOoXoXO
    public NestedScrollView f25467ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f25468xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @oOoXoXO
    public TextView f25469xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f25470xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public float f25471xxX;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DialElementView(@OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public final void I0Io() {
        int i;
        if (getParent() instanceof ViewGroup) {
            ViewParent parent = getParent();
            IIX0o.x0XOIxOo(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            this.f25464o00 = viewGroup.getMeasuredHeight();
            int measuredWidth = viewGroup.getMeasuredWidth();
            this.f25470xoXoI = measuredWidth;
            if (this.f25468xI && (i = this.f25464o00) != measuredWidth) {
                if (i < measuredWidth) {
                    this.f25470xoXoI = i;
                } else {
                    this.f25464o00 = measuredWidth;
                }
            }
            int i2 = iArr[0];
            this.f25454O0xOxO = i2;
            int i3 = iArr[1];
            this.f25456OxI = i3;
            int i4 = this.f25470xoXoI / 2;
            this.f25461XIxXXX0x0 = i4;
            this.f25459X0IIOO = i2 + i4;
            this.f25460XI0IXoo = i3 + i4;
        }
    }

    public final void II0xO0(Context context, AttributeSet attributeSet) {
        int i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialElementView);
        IIX0o.oO(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f25462XO = obtainStyledAttributes.getBoolean(0, this.f25462XO);
        this.f25455Oo = obtainStyledAttributes.getBoolean(1, this.f25455Oo);
        int integer = obtainStyledAttributes.getInteger(2, this.f25452IIXOooo);
        this.f25452IIXOooo = integer;
        if (integer == 1) {
            i = com.sma.smartv3.co_fit.R.layout.dial_time_digital_content;
        } else {
            i = com.sma.smartv3.co_fit.R.layout.dial_control_content;
        }
        this.f25465oI0IIXIo = obtainStyledAttributes.getResourceId(4, i);
        this.f25457Oxx0xo = obtainStyledAttributes.getResourceId(3, com.sma.smartv3.co_fit.R.drawable.dial_control_pop_0);
        this.f25453IXxxXO = obtainStyledAttributes.getString(5);
        obtainStyledAttributes.recycle();
    }

    public final void Oxx0IOOO() {
        if (!oxoX(getY())) {
            setY((this.f25464o00 * this.f25466oo0xXOI0I) - getHeight());
        }
    }

    public final boolean X0o0xo(float f, float f2) {
        if (Math.sqrt((f * f) + (f2 * f2)) <= this.f25461XIxXXX0x0) {
            return true;
        }
        return false;
    }

    public final boolean XO(float f, float f2) {
        if (!oxoX(f2)) {
            return false;
        }
        boolean X0o0xo2 = X0o0xo(this.f25459X0IIOO - (this.f25454O0xOxO + f), this.f25460XI0IXoo - (this.f25456OxI + f2));
        boolean X0o0xo3 = X0o0xo(this.f25459X0IIOO - (this.f25454O0xOxO + f), this.f25460XI0IXoo - ((this.f25456OxI + f2) + getHeight()));
        boolean X0o0xo4 = X0o0xo(this.f25459X0IIOO - ((this.f25454O0xOxO + f) + getWidth()), this.f25460XI0IXoo - (this.f25456OxI + f2));
        boolean X0o0xo5 = X0o0xo(this.f25459X0IIOO - ((f + this.f25454O0xOxO) + getWidth()), this.f25460XI0IXoo - ((f2 + this.f25456OxI) + getHeight()));
        if (!X0o0xo2 || !X0o0xo3 || !X0o0xo4 || !X0o0xo5) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        super.dispatchTouchEvent(event);
        if (event.getAction() == 1) {
            NestedScrollView nestedScrollView = this.f25467ooXIXxIX;
            if (nestedScrollView != null) {
                nestedScrollView.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            NestedScrollView nestedScrollView2 = this.f25467ooXIXxIX;
            if (nestedScrollView2 != null) {
                nestedScrollView2.requestDisallowInterceptTouchEvent(true);
            }
        }
        return true;
    }

    public final void oIX0oI(Context context) {
        if (this.f25452IIXOooo == 1) {
            View inflate = LayoutInflater.from(context).inflate(this.f25465oI0IIXIo, (ViewGroup) null);
            this.f25451IIX0o = (ImageView) inflate.findViewById(com.sma.smartv3.co_fit.R.id.iv);
            addView(inflate);
            return;
        }
        View inflate2 = LayoutInflater.from(context).inflate(this.f25465oI0IIXIo, (ViewGroup) null);
        ((ImageView) inflate2.findViewById(com.sma.smartv3.co_fit.R.id.controlIv)).setImageResource(this.f25457Oxx0xo);
        TextView textView = (TextView) inflate2.findViewById(com.sma.smartv3.co_fit.R.id.tv);
        this.f25469xXxxox0I = textView;
        if (textView != null) {
            textView.setText(this.f25453IXxxXO);
        }
        addView(inflate2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        I0Io();
        Oxx0IOOO();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@oOoXoXO MotionEvent motionEvent) {
        if (motionEvent != null && this.f25455Oo) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action != 0) {
                boolean z = true;
                float f = 0.0f;
                if (action != 1) {
                    if (action == 2) {
                        if (rawX >= this.f25454O0xOxO && rawX <= this.f25470xoXoI + r2) {
                            if (rawY >= this.f25456OxI && rawY <= this.f25464o00 + r2) {
                                float f2 = rawX - this.f25471xxX;
                                float f3 = rawY - this.f25463XxX0x0xxx;
                                if (!this.f25458OxxIIOOXO && this.f25462XO) {
                                    if (Math.sqrt((f2 * f2) + (f3 * f3)) < 2.0d) {
                                        z = false;
                                    }
                                    this.f25458OxxIIOOXO = z;
                                }
                                float x = getX() + f2;
                                float y = getY() + f3;
                                float width = this.f25470xoXoI - getWidth();
                                float height = this.f25464o00 - getHeight();
                                if (x < 0.0f) {
                                    x = 0.0f;
                                } else if (x > width) {
                                    x = width;
                                }
                                if (y >= 0.0f) {
                                    if (y > height) {
                                        f = height;
                                    } else {
                                        f = y;
                                    }
                                }
                                if (this.f25468xI) {
                                    if (XO(x, f)) {
                                        setX(x);
                                        setY(f);
                                        this.f25471xxX = rawX;
                                        this.f25463XxX0x0xxx = rawY;
                                        ToastUtils.cancel();
                                    } else {
                                        ToastUtils.showLong(getContext().getString(com.sma.smartv3.co_fit.R.string.unable_move), new Object[0]);
                                    }
                                } else {
                                    setX(x);
                                    setY(f);
                                    this.f25471xxX = rawX;
                                    this.f25463XxX0x0xxx = rawY;
                                }
                            }
                        }
                    }
                } else if (this.f25462XO && this.f25458OxxIIOOXO) {
                    if (this.f25471xxX <= this.f25470xoXoI / 2) {
                        animate().setInterpolator(new BounceInterpolator()).setDuration(500L).x(0.0f).start();
                    } else {
                        animate().setInterpolator(new BounceInterpolator()).setDuration(500L).x(this.f25470xoXoI - getWidth()).start();
                    }
                }
            } else {
                this.f25458OxxIIOOXO = false;
                this.f25471xxX = rawX;
                this.f25463XxX0x0xxx = rawY;
            }
        }
        boolean z2 = this.f25458OxxIIOOXO;
        if (!z2) {
            return super.onTouchEvent(motionEvent);
        }
        return z2;
    }

    public final boolean oxoX(float f) {
        if ((this.f25464o00 * this.f25466oo0xXOI0I) - (f + getHeight()) >= 0.0f) {
            return true;
        }
        return false;
    }

    public final void setBottomRangeScale(float f) {
        this.f25466oo0xXOI0I = f;
    }

    public final void setImageRes(int i) {
        ImageView imageView = this.f25451IIX0o;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public final void setIsRangeCircle(boolean z) {
        this.f25468xI = z;
    }

    public final void setScrollView(@OOXIXo NestedScrollView view) {
        IIX0o.x0xO0oo(view, "view");
        this.f25467ooXIXxIX = view;
    }

    public final void setTextColor(int i) {
        TextView textView = this.f25469xXxxox0I;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DialElementView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ DialElementView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @xoIox
    public DialElementView(@OOXIXo Context context, @oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25462XO = true;
        this.f25455Oo = true;
        this.f25453IXxxXO = "80";
        this.f25468xI = true;
        this.f25466oo0xXOI0I = 1.0f;
        II0xO0(context, attributeSet);
        oIX0oI(context);
    }
}
