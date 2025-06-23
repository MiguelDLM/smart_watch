package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public class h extends s implements View.OnClickListener {

    @Nullable
    protected KsLogoView mLogoView;
    protected KsConvertButton yA;
    protected TextView yB;

    @Nullable
    protected TextView yC;

    @Nullable
    protected TextView yD;
    protected a yE;

    @LayoutRes
    protected int yF = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean yG = true;
    protected ImageView yf;

    @Nullable
    protected KsAppTagsView yj;

    /* loaded from: classes11.dex */
    public interface a {
        void ia();

        void ib();

        void ic();

        void id();

        void ie();

        /* renamed from: if, reason: not valid java name */
        void mo273if();
    }

    private void S(int i) {
        KsConvertButton ksConvertButton = this.yA;
        if (ksConvertButton == null) {
            return;
        }
        if (i == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i == 2) {
            ksConvertButton.getCornerConf().cf(false).ci(false).ch(true).cg(true);
        }
        this.yA.postInvalidate();
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.yf = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.yB = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.yj = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.yC = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.yD = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.yA = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    private static int jV() {
        return R.id.ksad_common_app_card_root;
    }

    public final void a(a aVar) {
        this.yE = aVar;
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, hZ(), jV());
        g(this.sA);
        ViewGroup viewGroup2 = this.sA;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.yA.setOnClickListener(this);
            this.yf.setOnClickListener(this);
            this.yB.setOnClickListener(this);
            TextView textView = this.yC;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.yD;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.yj;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    public int hZ() {
        return R.id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.yA)) {
            a aVar2 = this.yE;
            if (aVar2 != null) {
                aVar2.ia();
                return;
            }
            return;
        }
        if (view.equals(this.yf)) {
            a aVar3 = this.yE;
            if (aVar3 != null) {
                aVar3.ib();
                return;
            }
            return;
        }
        if (view.equals(this.yB)) {
            a aVar4 = this.yE;
            if (aVar4 != null) {
                aVar4.ic();
                return;
            }
            return;
        }
        if (!view.equals(this.yC) && !view.equals(this.yD)) {
            if (view.equals(this.yj)) {
                a aVar5 = this.yE;
                if (aVar5 != null) {
                    aVar5.ie();
                    return;
                }
                return;
            }
            if (view.equals(this.sA) && (aVar = this.yE) != null) {
                aVar.mo273if();
                return;
            }
            return;
        }
        a aVar6 = this.yE;
        if (aVar6 != null) {
            aVar6.id();
        }
    }

    public final void show() {
        ViewGroup viewGroup = this.sA;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.yG));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kwad.components.ad.reward.model.a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.hd()
            r5.S(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.gZ()
            r0.aE(r1)
        L15:
            android.widget.TextView r0 = r5.yB
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.yC
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.gh()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.yD
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L5c
            java.lang.String r3 = r6.gh()
            r0.setText(r3)
            java.lang.String r0 = r6.gh()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L46
            r0 = 8
        L43:
            r3 = 8
            goto L52
        L46:
            boolean r0 = r6.hc()
            if (r0 == 0) goto L50
            r0 = 8
            r3 = 0
            goto L52
        L50:
            r0 = 0
            goto L43
        L52:
            android.widget.TextView r4 = r5.yC
            if (r4 == 0) goto L59
            r4.setVisibility(r0)
        L59:
            android.widget.TextView r0 = r5.yD
            goto L6e
        L5c:
            android.widget.TextView r0 = r5.yC
            if (r0 == 0) goto L71
            java.lang.String r3 = r6.gh()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L6d
            r3 = 8
            goto L6e
        L6d:
            r3 = 0
        L6e:
            r0.setVisibility(r3)
        L71:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.yj
            if (r0 == 0) goto L8b
            java.util.List r3 = r6.hb()
            int r4 = r5.yF
            r0.a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.yj
            boolean r3 = r6.hc()
            if (r3 == 0) goto L88
            r1 = 8
        L88:
            r0.setVisibility(r1)
        L8b:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.yA
            if (r0 == 0) goto L9a
            com.kwad.components.core.e.d.c r1 = r6.ha()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.gZ()
            r0.a(r1, r2)
        L9a:
            android.widget.ImageView r0 = r5.yf
            java.lang.String r1 = r6.gg()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.gZ()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.n.h.a(com.kwad.components.ad.reward.model.a):void");
    }
}
