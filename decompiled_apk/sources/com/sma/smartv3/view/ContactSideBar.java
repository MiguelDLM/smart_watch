package com.sma.smartv3.view;

import OoOoXO0.xoXoI;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.huawei.hms.ads.ContentClassification;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.network.Api;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class ContactSideBar extends View {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Paint f24872IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f24873Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public TextView f24874Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public II0xO0 f24875XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f24871oI0IIXIo = new oIX0oI(null);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String[] f24870OxxIIOOXO = {"A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", com.sma.smartv3.util.xoIox.f24717xXxxox0I, com.vtrump.vtble.Oxx0IOOO.f27277xI, ContentClassification.AD_CONTENT_CLASSIFICATION_J, "K", "L", "M", "N", DeviceId.CUIDInfo.I_FIXED, "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "W", "X", Api.Y, "Z", xoXoI.f2670oxoX};

    /* loaded from: classes12.dex */
    public interface II0xO0 {
        void oIX0oI(@OXOo.oOoXoXO String str);
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final void II0xO0(@OXOo.OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(strArr, "<set-?>");
            ContactSideBar.f24870OxxIIOOXO = strArr;
        }

        @OXOo.OOXIXo
        public final String[] oIX0oI() {
            return ContactSideBar.f24870OxxIIOOXO;
        }

        public oIX0oI() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ContactSideBar(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public boolean dispatchTouchEvent(@OXOo.OOXIXo MotionEvent event) {
        IIX0o.x0xO0oo(event, "event");
        int action = event.getAction();
        float y = event.getY();
        int i = this.f24873Oo;
        II0xO0 iI0xO0 = this.f24875XO;
        int height = (int) ((y / getHeight()) * f24870OxxIIOOXO.length);
        if (action == 1) {
            invalidate();
            TextView textView = this.f24874Oxx0xo;
            if (textView != null) {
                IIX0o.ooOOo0oXI(textView);
                textView.setVisibility(4);
            }
        } else {
            setAlpha(0.7f);
            if (i != height && height >= 0) {
                String[] strArr = f24870OxxIIOOXO;
                if (height < strArr.length) {
                    if (iI0xO0 != null) {
                        iI0xO0.oIX0oI(strArr[height]);
                    }
                    TextView textView2 = this.f24874Oxx0xo;
                    if (textView2 != null) {
                        IIX0o.ooOOo0oXI(textView2);
                        textView2.setText(f24870OxxIIOOXO[height]);
                        TextView textView3 = this.f24874Oxx0xo;
                        IIX0o.ooOOo0oXI(textView3);
                        textView3.setVisibility(0);
                    }
                    this.f24873Oo = height;
                    invalidate();
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onDraw(@OXOo.OOXIXo Canvas canvas) {
        IIX0o.x0xO0oo(canvas, "canvas");
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        String[] strArr = f24870OxxIIOOXO;
        int length = height / strArr.length;
        int length2 = strArr.length;
        for (int i = 0; i < length2; i++) {
            this.f24872IXxxXO.setColor(getResources().getColor(R.color.colorAccent));
            this.f24872IXxxXO.setTypeface(Typeface.DEFAULT);
            this.f24872IXxxXO.setAntiAlias(true);
            this.f24872IXxxXO.setTextSize(28.0f);
            this.f24872IXxxXO.setFakeBoldText(true);
            float f = 2;
            float measureText = (width / 2) - (this.f24872IXxxXO.measureText(f24870OxxIIOOXO[i]) / f);
            float f2 = (length * i) + length;
            float max = Math.max(this.f24872IXxxXO.measureText(f24870OxxIIOOXO[i]), 20.0f);
            if (i == this.f24873Oo) {
                this.f24872IXxxXO.setAlpha(70);
                canvas.drawCircle((this.f24872IXxxXO.measureText(f24870OxxIIOOXO[i]) / f) + measureText, f2 - (this.f24872IXxxXO.measureText(f24870OxxIIOOXO[i]) / f), max, this.f24872IXxxXO);
            } else {
                this.f24872IXxxXO.setAlpha(255);
            }
            canvas.drawText(f24870OxxIIOOXO[i], measureText, f2, this.f24872IXxxXO);
            this.f24872IXxxXO.reset();
        }
    }

    public final void setBar(@OXOo.OOXIXo String[] list) {
        IIX0o.x0xO0oo(list, "list");
    }

    public final void setOnTouchingLetterChangedListener(@OXOo.oOoXoXO II0xO0 iI0xO0) {
        this.f24875XO = iI0xO0;
    }

    public final void setTextView(@OXOo.oOoXoXO TextView textView) {
        this.f24874Oxx0xo = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ContactSideBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ ContactSideBar(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public ContactSideBar(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24873Oo = -1;
        this.f24872IXxxXO = new Paint();
    }
}
