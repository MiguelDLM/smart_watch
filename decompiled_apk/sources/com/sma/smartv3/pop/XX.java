package com.sma.smartv3.pop;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourSelectByType;

/* loaded from: classes12.dex */
public final class XX extends PopupWindow {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final RecyclerView f21383I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final FrameLayout f21384II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public CommonAdapter<CourSelectByType> f21385X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f21386XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public Activity f21387oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public final FrameLayout f21388oxoX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XX(@OXOo.OOXIXo Activity mActivity) {
        super(mActivity);
        kotlin.jvm.internal.IIX0o.x0xO0oo(mActivity, "mActivity");
        this.f21387oIX0oI = mActivity;
        FrameLayout frameLayout = new FrameLayout(this.f21387oIX0oI);
        this.f21384II0xO0 = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(this.f21387oIX0oI);
        this.f21388oxoX = frameLayout2;
        this.f21386XO = true;
        LayoutInflater.from(this.f21387oIX0oI).inflate(R.layout.pop_list, frameLayout2);
        View findViewById = frameLayout2.findViewById(R.id.pop_list_recycler);
        kotlin.jvm.internal.IIX0o.oO(findViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f21383I0Io = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f21387oIX0oI, 1, false));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-2, -2));
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.pop.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XX.Oxx0IOOO(XX.this, view);
            }
        });
        frameLayout2.setClickable(true);
        setContentView(frameLayout);
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
    }

    public static final void Oxx0IOOO(XX this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.f21386XO) {
            this$0.dismiss();
        }
    }

    @OXOo.oOoXoXO
    public final CommonAdapter<CourSelectByType> I0Io() {
        return this.f21385X0o0xo;
    }

    public final void II0XooXoX(@OXOo.OOXIXo Activity activity) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(activity, "<set-?>");
        this.f21387oIX0oI = activity;
    }

    @OXOo.OOXIXo
    public final Activity II0xO0() {
        return this.f21387oIX0oI;
    }

    @OXOo.OOXIXo
    public final FrameLayout X0o0xo() {
        return this.f21388oxoX;
    }

    @OXOo.OOXIXo
    public final FrameLayout XO() {
        return this.f21384II0xO0;
    }

    public final boolean oxoX() {
        return this.f21386XO;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@OXOo.oOoXoXO View view) {
        super.showAsDropDown(view);
    }

    public final void xoIox(boolean z) {
        this.f21386XO = z;
        setFocusable(z);
        setOutsideTouchable(z);
    }

    public final void xxIXOIIO(@OXOo.oOoXoXO CommonAdapter<CourSelectByType> commonAdapter) {
        this.f21385X0o0xo = commonAdapter;
        this.f21383I0Io.setAdapter(commonAdapter);
    }
}
