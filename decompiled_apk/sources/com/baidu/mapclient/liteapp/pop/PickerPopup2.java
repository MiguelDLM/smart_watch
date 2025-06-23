package com.baidu.mapclient.liteapp.pop;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.mapclient.liteapp.pop.base.BottomPopup;
import com.baidu.mapclient.liteapp.view.WheelView.OnItemSelectedListener;
import com.baidu.mapclient.liteapp.view.WheelView.WheelView;
import com.szabh.navi.R;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class PickerPopup2 extends BottomPopup {
    private boolean isNoLoop;

    @oOoXoXO
    private OnPickedListener mListener;
    private int mPick;
    private int mTitle;

    @OOXIXo
    private final TextView tvTitle;

    @OOXIXo
    private final WheelView wv;

    /* loaded from: classes7.dex */
    public interface OnPickedListener {
        boolean invoke(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerPopup2(@OOXIXo Activity activity, @OOXIXo List<String> items) {
        super(activity);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(items, "items");
        this.mPick = -1;
        LayoutInflater.from(getMActivity()).inflate(R.layout.nav_pop_picker2, getMLayout());
        View findViewById = getMLayout().findViewById(R.id.tv_title);
        IIX0o.oO(findViewById, "findViewById(...)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = getMLayout().findViewById(R.id.wv);
        WheelView wheelView = (WheelView) findViewById2;
        wheelView.setListener(new OnItemSelectedListener() { // from class: com.baidu.mapclient.liteapp.pop.oIX0oI
            @Override // com.baidu.mapclient.liteapp.view.WheelView.OnItemSelectedListener
            public final void onItemSelected(int i) {
                PickerPopup2.lambda$1$lambda$0(PickerPopup2.this, i);
            }
        });
        IIX0o.oO(findViewById2, "apply(...)");
        this.wv = wheelView;
        getMLayout().findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.pop.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickerPopup2._init_$lambda$2(PickerPopup2.this, view);
            }
        });
        getMLayout().findViewById(R.id.action2).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapclient.liteapp.pop.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickerPopup2._init_$lambda$3(PickerPopup2.this, view);
            }
        });
        wheelView.setVisibleCount(3);
        wheelView.setItems(items);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(PickerPopup2 this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(PickerPopup2 this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        OnPickedListener onPickedListener = this$0.mListener;
        if (onPickedListener != null) {
            IIX0o.ooOOo0oXI(onPickedListener);
            if (!onPickedListener.invoke(this$0.mPick)) {
                return;
            }
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(PickerPopup2 this$0, int i) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.mPick = i;
    }

    @oOoXoXO
    public final OnPickedListener getMListener() {
        return this.mListener;
    }

    public final int getMTitle() {
        return this.mTitle;
    }

    @OOXIXo
    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    @OOXIXo
    public final WheelView getWv() {
        return this.wv;
    }

    public final boolean isNoLoop() {
        return this.isNoLoop;
    }

    public final void setMListener(@oOoXoXO OnPickedListener onPickedListener) {
        this.mListener = onPickedListener;
    }

    public final void setMTitle(int i) {
        this.mTitle = i;
        this.tvTitle.setText(i);
    }

    public final void setNoLoop(boolean z) {
        this.isNoLoop = z;
        if (z) {
            this.wv.setNotLoop();
        }
    }

    public final void setPicked(int i) {
        this.mPick = i;
        this.wv.setInitPosition(i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PickerPopup2(@OXOo.OOXIXo android.app.Activity r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            android.content.res.Resources r0 = r2.getResources()
            java.lang.String[] r3 = r0.getStringArray(r3)
            java.lang.String r0 = "getStringArray(...)"
            kotlin.jvm.internal.IIX0o.oO(r3, r0)
            java.util.List r3 = kotlin.collections.ArraysKt___ArraysKt.IoXOX(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapclient.liteapp.pop.PickerPopup2.<init>(android.app.Activity, int):void");
    }
}
