package com.baidu.navisdk.module.newguide.settings;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.widgets.RGOutScrollView;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.android.exoplayer2.PlaybackException;

/* loaded from: classes7.dex */
public class b extends a {
    public b(Context context, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, bVar, viewGroup, aVar);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.a
    public RGOutScrollView F0() {
        ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.bnav_rg_setting_scrollview_stub);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Exception e) {
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    com.baidu.navisdk.util.common.g.PRO_NAV.e("BottomBar", "obtainScrollView Exception: " + e);
                }
                if (com.baidu.navisdk.util.common.g.PRO_NAV.b()) {
                    LogUtil.printException("loadTopView", e);
                }
            }
        }
        return (RGOutScrollView) this.b.findViewById(R.id.bnav_rg_setting_scrollview);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.a
    public FrameLayout G0() {
        return (FrameLayout) com.baidu.navisdk.ui.util.b.a(this.f9165a, R.layout.nsdk_layout_rg_bottom_bar_setting_page, null, false);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.a
    public com.baidu.navisdk.module.newguide.subviews.b H0() {
        return new com.baidu.navisdk.module.newguide.subviews.b(this.f9165a, this.b, this.c);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.a
    public com.baidu.navisdk.module.newguide.subviews.c a(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        com.baidu.navisdk.apicenter.h a2 = bVar.j().e("RGNewEtaComponent").a(PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR).b("root_view_group", this.b).b("setting_root_view", this.o).b("rg_subview_listener", this.c).a();
        if (a2 == null) {
            return null;
        }
        return (com.baidu.navisdk.pronavi.ui.newnavi.bottom.a) a2.a("resultA", (String) null);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.a
    public com.baidu.navisdk.module.newguide.subviews.e b(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        com.baidu.navisdk.apicenter.h a2 = bVar.j().e("RGNewSimpleEtaComponent").a(3).b("root_view_group", this.b).a();
        if (a2 == null) {
            return null;
        }
        return (com.baidu.navisdk.module.newguide.subviews.e) a2.a("resultA", (String) null);
    }

    @Override // com.baidu.navisdk.module.newguide.settings.a
    public com.baidu.navisdk.module.newguide.subviews.a a(Context context, com.baidu.navisdk.pronavi.ui.base.b bVar, ViewGroup viewGroup, ViewGroup viewGroup2) {
        com.baidu.navisdk.apicenter.h a2 = bVar.j().e("RGNewQuitNaviComponent").a(7003).b("root_view_group", viewGroup).b("setting_root_view", viewGroup2).a();
        if (a2 == null) {
            return null;
        }
        return (com.baidu.navisdk.pronavi.ui.newnavi.bottom.b) a2.a("resultA", (String) null);
    }
}
