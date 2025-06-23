package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.asr.view.BNVoiceAidView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g1;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class v extends com.baidu.navisdk.pronavi.ui.bucket.item.a {
    private g1 f;
    private boolean g;

    /* loaded from: classes7.dex */
    public class a implements BNVoiceAidView.j {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.asr.view.BNVoiceAidView.j
        public void a(int i) {
            View view = v.this.getView();
            if (view != null) {
                view.setVisibility(i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public b(v vVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public v(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar);
        this.g = false;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public View a(@NonNull ViewGroup viewGroup, int i, @NonNull Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        g1 g1Var = new g1(context, relativeLayout);
        this.f = g1Var;
        g1Var.a(new a());
        return relativeLayout;
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VoiceAidView", "setVisibility: " + z + ",this.isShow: " + this.g);
        }
        this.g = z;
        if (z) {
            com.baidu.navisdk.framework.c.b().a(15, 16);
        }
        refreshVisible();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (com.baidu.navisdk.ui.routeguide.asr.c.n().e() || !this.g) {
            return 8;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public View.OnClickListener getOnClickListener() {
        return new b(this);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public boolean isInterceptSetVisible(int i) {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        g1 g1Var = this.f;
        if (g1Var != null) {
            g1Var.i();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onInterceptSetVisible(@Nullable View view, int i) {
        super.onInterceptSetVisible(view, i);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VoiceAidView", "onInterceptSetVisible: " + i);
        }
        if (i == 0) {
            g1 g1Var = this.f;
            if (g1Var != null) {
                g1Var.y();
                return;
            }
            return;
        }
        g1 g1Var2 = this.f;
        if (g1Var2 != null && g1Var2.n0()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("VoiceAidView", "onInterceptSetVisible() xdAidView is Visible");
            }
            this.f.c();
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int a(int i, boolean z) {
        if (i != 2) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_4dp);
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public void a(boolean z) {
        super.a(z);
        g1 g1Var = this.f;
        if (g1Var != null) {
            g1Var.a(z);
        }
    }
}
