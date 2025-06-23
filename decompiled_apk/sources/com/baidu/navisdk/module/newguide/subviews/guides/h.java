package com.baidu.navisdk.module.newguide.subviews.guides;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.t;

/* loaded from: classes7.dex */
public class h extends t {
    private ImageView w;

    public h(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t
    public void a(com.baidu.navisdk.pronavi.data.vm.devicestate.a aVar) {
        super.a(aVar);
        if (this.w != null && com.baidu.navisdk.j.d()) {
            if (aVar != null && aVar.c()) {
                this.w.setVisibility(0);
                this.w.setImageResource(aVar.a());
            } else {
                this.w.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t, com.baidu.navisdk.ui.routeguide.widget.c
    public ViewGroup.LayoutParams o0() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t, com.baidu.navisdk.ui.routeguide.widget.c
    public int p0() {
        return R.id.bnav_rg_device_status_container;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t, com.baidu.navisdk.ui.routeguide.widget.c
    public int q0() {
        return R.layout.nsdk_layout_rg_device_state_new;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t, com.baidu.navisdk.ui.routeguide.widget.c
    public int r0() {
        return R.layout.nsdk_layout_rg_device_state_new;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t, com.baidu.navisdk.ui.routeguide.widget.c
    public String s0() {
        return "RGMMDeviceStateViewNew";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.t, com.baidu.navisdk.ui.routeguide.widget.c
    public void w0() {
        super.w0();
        this.w = (ImageView) this.k.findViewById(R.id.bnav_rg_smart_traffic_label);
    }
}
