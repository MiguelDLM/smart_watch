package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNImageView;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class a0 extends com.baidu.navisdk.pronavi.ui.bucket.item.a implements View.OnClickListener {
    private BNImageView f;
    private BNImageView g;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a0.this.w();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a0.this.x();
                return true;
            }
            return true;
        }
    }

    public a0(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
    }

    @NonNull
    private Size d(int i) {
        Resources resources = JarUtils.getResources();
        if (i == 2) {
            return new Size(resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width), resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_zoom_layout_height));
        }
        return new Size(resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_width_new), resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_zoom_layout_height_new));
    }

    @NonNull
    private Size e(int i) {
        Resources resources = JarUtils.getResources();
        if (i == 2) {
            int i2 = R.dimen.navi_dimens_24dp;
            return new Size(resources.getDimensionPixelSize(i2), resources.getDimensionPixelSize(i2));
        }
        return new Size(resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_zoomin_btn_img_width), resources.getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_zoomin_btn_img_height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.baidu.navisdk.ui.routeguide.subview.a c = c();
        if (c != null) {
            if (com.baidu.navisdk.ui.routeguide.control.b.k().f() >= 20 && com.baidu.navisdk.ui.routeguide.b.V().A()) {
                TipTool.onCreateToastDialog(this.f7853a.a(), "已放大至最高级别");
            }
            c.k();
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.baidu.navisdk.ui.routeguide.subview.a c = c();
        if (c != null) {
            c.a();
            if (com.baidu.navisdk.ui.routeguide.control.b.k().f() <= 5 && com.baidu.navisdk.ui.routeguide.b.V().A()) {
                TipTool.onCreateToastDialog(this.f7853a.a(), "已缩小到最小级别");
            }
            v();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (f()) {
            return 8;
        }
        if (!com.baidu.navisdk.module.newguide.a.e().a(com.baidu.navisdk.pronavi.util.a.h.a(), i == 1)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ZoomInOutBtn", "visibility: not isShowRGZoomInBtn");
            }
            return 8;
        }
        if (!this.f7853a.N()) {
            return b(RGFSMTable.FsmState.BrowseMap, RGFSMTable.FsmState.NearbySearch) ? 0 : 8;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("ZoomInOutBtn", "visibility: isRoused");
        }
        return 8;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean h() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean i() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ZoomInOutBtn", "onClick: " + view);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        BNImageView bNImageView = this.g;
        if (bNImageView != null) {
            bNImageView.changeSize(d(i), e(i));
        }
        BNImageView bNImageView2 = this.f;
        if (bNImageView2 != null) {
            bNImageView2.changeSize(d(i), e(i));
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public String[] r() {
        return new String[]{RGFSMTable.FsmState.Voice, RGFSMTable.FsmState.NaviReady, RGFSMTable.FsmState.ArriveDest};
    }

    public void v() {
        int f = com.baidu.navisdk.ui.routeguide.control.b.k().f();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ZoomInOutBtn", "updateZoomButton. level = " + f);
        }
        if (f <= 4) {
            b(true);
            c(false);
        } else if (f >= 21) {
            b(false);
            c(true);
        } else {
            b(true);
            c(true);
        }
    }

    private void b(boolean z) {
        BNImageView bNImageView = this.g;
        if (bNImageView != null) {
            bNImageView.setEnabled(z);
            this.g.setImageAlpha(z ? 255 : 51);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("ZoomInOutBtn", "loadBucketItem: " + i);
        }
        View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_rg_zoom_in_out, viewGroup, false);
        this.g = (BNImageView) a2.findViewById(R.id.bnav_rg_cp_zoomin);
        BNImageView bNImageView = (BNImageView) a2.findViewById(R.id.bnav_rg_cp_zoomout);
        this.f = bNImageView;
        bNImageView.setOnClickListener(this);
        this.g.setOnClickListener(this);
        if (!b(i)) {
            onRefreshViewStyle(i);
        }
        this.g.setOnTouchListener(new a());
        this.f.setOnTouchListener(new b());
        return a2;
    }

    private void c(boolean z) {
        BNImageView bNImageView = this.f;
        if (bNImageView != null) {
            bNImageView.setEnabled(z);
            this.f.setImageAlpha(z ? 255 : 51);
        }
    }
}
