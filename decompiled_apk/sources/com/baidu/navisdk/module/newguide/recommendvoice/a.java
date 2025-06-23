package com.baidu.navisdk.module.newguide.recommendvoice;

import OXOo.OOXIXo;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.module.newguide.recommendvoice.b;
import com.baidu.navisdk.module.newguide.settings.i;
import com.baidu.navisdk.module.newguide.settings.viewholder.e;
import com.baidu.navisdk.ui.flip.BNSectorFlipView;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class a {
    private static final int e = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_40dp);

    /* renamed from: a, reason: collision with root package name */
    private BNSectorFlipView f7219a;
    private c b;
    private com.baidu.navisdk.module.newguide.recommendvoice.b c;
    private b.InterfaceC0249b d;

    /* loaded from: classes7.dex */
    public class b implements b.InterfaceC0249b {
        public b(a aVar) {
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends BNSectorFlipView.a<d> {
        @Override // com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        public void b(@OOXIXo BNSectorFlipView.c cVar) {
        }

        @Override // com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        public void c(@OOXIXo BNSectorFlipView.c cVar) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        @OOXIXo
        public d a(@OOXIXo ViewGroup viewGroup) {
            return new d(com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_voice_flip_item, viewGroup, false));
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends BNSectorFlipView.c {
        private final TextView b;
        private final ImageView c;

        public d(@OOXIXo View view) {
            super(view);
            this.c = (ImageView) view.findViewById(R.id.bn_voice_flip_icon);
            this.b = (TextView) view.findViewById(R.id.bn_voice_flip_title);
        }

        public void a(b.c cVar) {
            TextView textView;
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGPlaySuperVoice", "update: " + cVar);
            }
            if (cVar != null && (textView = this.b) != null && this.c != null) {
                textView.setText(cVar.c());
                if (TextUtils.isEmpty(cVar.b())) {
                    this.c.setImageResource(cVar.a());
                } else {
                    ImageLoader.with(this.c.getContext()).load(cVar.b()).override(a.e, a.e).centerCrop().rectRoundCorner(ScreenUtil.getInstance().dip2px(14)).into(this.c);
                }
                this.c.setPadding(cVar.d(), cVar.d(), cVar.d(), cVar.d());
                return;
            }
            if (gVar.c()) {
                gVar.c("RGPlaySuperVoice", "update: param == null");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends e.f {
        private BNSectorFlipView b;
        private ImageView c;

        public e(View view) {
            super(view);
            if (view instanceof BNSectorFlipView) {
                this.b = (BNSectorFlipView) view;
                this.c = (ImageView) view.findViewById(R.id.bnav_v_img_text_bubble);
            }
        }

        @Override // com.baidu.navisdk.module.newguide.settings.viewholder.e.f
        public void a(com.baidu.navisdk.module.newguide.settings.shortcut.beans.a aVar) {
            super.a(aVar);
            i.a(aVar.b, this.c);
            BNSectorFlipView bNSectorFlipView = this.b;
            if (bNSectorFlipView != null) {
                bNSectorFlipView.a();
            }
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGPlaySuperVoice", "update: " + aVar);
            }
        }
    }

    private void b() {
        if (this.d == null) {
            this.d = new b(this);
        }
    }

    private void c() {
        com.baidu.navisdk.ui.routeguide.navicenter.c j;
        if (this.c == null && (j = com.baidu.navisdk.ui.routeguide.b.V().j()) != null) {
            this.c = j.j();
        }
    }

    private void d() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGPlaySuperVoice", "showDefault: ");
        }
        BNSectorFlipView bNSectorFlipView = this.f7219a;
        if (bNSectorFlipView != null) {
            bNSectorFlipView.a();
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.recommendvoice.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0248a extends c {
        public C0248a() {
        }

        @Override // com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        public boolean a(@OOXIXo BNSectorFlipView.c cVar) {
            ImageView imageView;
            return (!(cVar instanceof d) || (imageView = ((d) cVar).c) == null || imageView.getDrawable() == null) ? false : true;
        }

        @Override // com.baidu.navisdk.module.newguide.recommendvoice.a.c, com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        public void b(@OOXIXo BNSectorFlipView.c cVar) {
            super.b(cVar);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGPlaySuperVoice", "onBindDefault: ");
            }
            if (cVar instanceof d) {
                ((d) cVar).a(com.baidu.navisdk.module.newguide.recommendvoice.b.f.a());
            }
        }

        @Override // com.baidu.navisdk.module.newguide.recommendvoice.a.c, com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        public void c(@OOXIXo BNSectorFlipView.c cVar) {
            super.c(cVar);
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGPlaySuperVoice", "onBindViewHolder: ");
            }
            if (a.this.c != null && (cVar instanceof d) && a.this.c.d()) {
                ((d) cVar).a(a.this.c.b());
            }
        }

        @Override // com.baidu.navisdk.ui.flip.BNSectorFlipView.a
        public int a() {
            if (a.this.c == null) {
                return 0;
            }
            return a.this.c.c();
        }
    }

    public e a(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGPlaySuperVoice", "createViewHolder: ");
        }
        View a2 = com.baidu.navisdk.ui.util.b.a(viewGroup.getContext(), R.layout.nsdk_layout_rg_setting_shortcut_voice_item, viewGroup, false);
        a2.setOnClickListener(onClickListener);
        if (this.b == null) {
            this.b = new C0248a();
        }
        BNSectorFlipView bNSectorFlipView = (BNSectorFlipView) a2;
        this.f7219a = bNSectorFlipView;
        bNSectorFlipView.a(3000L, 500L);
        this.f7219a.setAdapter(this.b);
        return new e(a2);
    }

    public void a(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGPlaySuperVoice", "handleSettingPageStatusChange: " + z);
        }
        if (z && !z.b(com.baidu.navisdk.framework.a.c().a())) {
            if (gVar.c()) {
                gVar.c("RGPlaySuperVoice", "onAnimStatue: network not available");
            }
            d();
            return;
        }
        c();
        if (this.c == null) {
            if (gVar.c()) {
                gVar.c("RGPlaySuperVoice", "handleSettingPageStatusChange: mVoicePlayController == null");
            }
            d();
            return;
        }
        if (gVar.d()) {
            gVar.e("RGPlaySuperVoice", "handleSettingPageStatusChange mFlipView: " + this.f7219a);
        }
        if (z) {
            if (!this.c.a()) {
                b();
                this.c.a(this.d);
                d();
                return;
            } else {
                BNSectorFlipView bNSectorFlipView = this.f7219a;
                if (bNSectorFlipView != null) {
                    bNSectorFlipView.b();
                    return;
                }
                return;
            }
        }
        BNSectorFlipView bNSectorFlipView2 = this.f7219a;
        if (bNSectorFlipView2 != null) {
            bNSectorFlipView2.c();
        }
    }
}
