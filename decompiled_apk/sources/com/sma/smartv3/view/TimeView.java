package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sma.smartv3.co_fit.R;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class TimeView extends FrameLayout {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f25387Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f25388XO;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TimeView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final TextView getTv1() {
        return (TextView) this.f25388XO.getValue();
    }

    private final TextView getTv2() {
        return (TextView) this.f25387Oo.getValue();
    }

    public final void oIX0oI(int i, int i2, int i3, int i4, int i5) {
        Context context;
        int i6;
        Calendar calendar = Calendar.getInstance();
        IIX0o.ooOOo0oXI(calendar);
        oOXoIIIo.II0xO0.XI0IXoo(calendar, i);
        oOXoIIIo.II0xO0.o00(calendar, i2);
        oOXoIIIo.II0xO0.IXxxXO(calendar, i3);
        oOXoIIIo.II0xO0.oI0IIXIo(calendar, i4);
        oOXoIIIo.II0xO0.IIXOooo(calendar, i5);
        if (com.sma.smartv3.util.xoIox.ooXIXxIX()) {
            TextView tv1 = getTv1();
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            IIX0o.ooOOo0oXI(calendar);
            String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(oOXoIIIo.II0xO0.Oxx0IOOO(calendar)), Integer.valueOf(oOXoIIIo.II0xO0.xxIXOIIO(calendar))}, 2));
            IIX0o.oO(format, "format(...)");
            tv1.setText(format);
            getTv2().setText("");
            return;
        }
        TextView tv12 = getTv1();
        oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
        IIX0o.ooOOo0oXI(calendar);
        String format2 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(oOXoIIIo.II0xO0.XO(calendar)), Integer.valueOf(oOXoIIIo.II0xO0.xxIXOIIO(calendar))}, 2));
        IIX0o.oO(format2, "format(...)");
        tv12.setText(format2);
        TextView tv2 = getTv2();
        if (oOXoIIIo.II0xO0.x0xO0oo(calendar)) {
            context = getContext();
            i6 = R.string.am;
        } else {
            context = getContext();
            i6 = R.string.pm;
        }
        tv2.setText(context.getString(i6));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getTv1().setEnabled(z);
        getTv2().setEnabled(z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TimeView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ TimeView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public TimeView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f25388XO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.view.TimeView$tv1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) TimeView.this.findViewById(R.id.tv1);
            }
        });
        this.f25387Oo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.view.TimeView$tv2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) TimeView.this.findViewById(R.id.tv2);
            }
        });
        LayoutInflater.from(context).inflate(R.layout.clock_view, (ViewGroup) this, true);
    }
}
