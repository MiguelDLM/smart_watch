package com.sma.smartv3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.sma.smartv3.co_fit.R;
import java.util.Arrays;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class CompletionValueView extends FrameLayout {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f24864IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f24865Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f24866Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f24867OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0IIOO f24868XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f24869oI0IIXIo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CompletionValueView(@OXOo.OOXIXo Context context) {
        this(context, null, 0, 6, null);
        IIX0o.x0xO0oo(context, "context");
    }

    private final TextView getTv1() {
        return (TextView) this.f24868XO.getValue();
    }

    private final TextView getTv2() {
        return (TextView) this.f24865Oo.getValue();
    }

    private final TextView getTv3() {
        return (TextView) this.f24864IXxxXO.getValue();
    }

    private final TextView getTv4() {
        return (TextView) this.f24866Oxx0xo.getValue();
    }

    public final int getMBpm() {
        return this.f24867OxxIIOOXO;
    }

    public final int getMDuration() {
        return this.f24869oI0IIXIo;
    }

    public final void setMBpm(int i) {
        this.f24867OxxIIOOXO = i;
        getTv1().setVisibility(0);
        getTv2().setVisibility(0);
        getTv3().setVisibility(8);
        getTv4().setVisibility(8);
        getTv1().setText(String.valueOf(this.f24867OxxIIOOXO));
        getTv2().setText(getContext().getString(R.string.bpm));
    }

    public final void setMDuration(int i) {
        this.f24869oI0IIXIo = i;
        getTv1().setVisibility(0);
        getTv2().setVisibility(0);
        getTv3().setVisibility(0);
        getTv4().setVisibility(0);
        TextView tv1 = getTv1();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i / 60)}, 1));
        IIX0o.oO(format, "format(...)");
        tv1.setText(format);
        getTv2().setText(getContext().getString(R.string.minute_abrv));
        TextView tv3 = getTv3();
        String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i % 60)}, 1));
        IIX0o.oO(format2, "format(...)");
        tv3.setText(format2);
        getTv4().setText(getContext().getString(R.string.second_abrv));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CompletionValueView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IIX0o.x0xO0oo(context, "context");
    }

    public /* synthetic */ CompletionValueView(Context context, AttributeSet attributeSet, int i, int i2, IIXOooo iIXOooo) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @XO0OX.xoIox
    public CompletionValueView(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        IIX0o.x0xO0oo(context, "context");
        this.f24868XO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.view.CompletionValueView$tv1$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) CompletionValueView.this.findViewById(R.id.tv1);
            }
        });
        this.f24865Oo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.view.CompletionValueView$tv2$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) CompletionValueView.this.findViewById(R.id.tv2);
            }
        });
        this.f24864IXxxXO = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.view.CompletionValueView$tv3$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) CompletionValueView.this.findViewById(R.id.tv3);
            }
        });
        this.f24866Oxx0xo = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.view.CompletionValueView$tv4$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) CompletionValueView.this.findViewById(R.id.tv4);
            }
        });
        LayoutInflater.from(context).inflate(R.layout.completion_value_view, (ViewGroup) this, true);
    }
}
