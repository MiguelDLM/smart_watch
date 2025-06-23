package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.di;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.fw;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.n;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.huawei.openalliance.ad.views.dialog.PPSTransparencyDialog;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: classes10.dex */
public class PPSSplashAdSourceView extends RelativeLayout {
    private fn B;
    private Integer C;
    private boolean D;
    private WeakReference<fw> F;
    private TextView I;
    private boolean L;
    private Integer S;
    private PPSSplashLabelView V;

    /* renamed from: a, reason: collision with root package name */
    private d f17427a;

    /* loaded from: classes10.dex */
    public static class a implements PPSLabelView.a {
        private fn B;
        private WeakReference<PPSSplashAdSourceView> Code;
        private boolean I;
        private AdContentData V;
        private Integer Z;

        public a(PPSSplashAdSourceView pPSSplashAdSourceView, AdContentData adContentData, boolean z, Integer num, fn fnVar) {
            this.Code = new WeakReference<>(pPSSplashAdSourceView);
            this.V = adContentData;
            this.I = z;
            this.Z = num;
            this.B = fnVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.openalliance.ad.views.PPSLabelView.a
        public void Code(fw fwVar, int[] iArr, int[] iArr2) {
            if (fwVar != 0) {
                boolean z = fwVar instanceof PPSSplashView;
                if (z || (fwVar instanceof PPSLinkedView)) {
                    if (!w.Code(iArr, 2) || !w.Code(iArr2, 2)) {
                        fb.I("PPSSplashAdSourceView", "anchor is invalid.");
                        return;
                    }
                    if (fb.Code()) {
                        fb.Code("PPSSplashAdSourceView", "addTransparencyDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                        fb.Code("PPSSplashAdSourceView", "addTransparencyDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                    }
                    RelativeLayout relativeLayout = (RelativeLayout) fwVar;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    PPSTransparencyDialog pPSTransparencyDialog = new PPSTransparencyDialog(relativeLayout.getContext(), iArr, iArr2, 1);
                    PPSSplashAdSourceView pPSSplashAdSourceView = this.Code.get();
                    if (pPSSplashAdSourceView != null) {
                        pPSSplashAdSourceView.setTransparencyDialogCallback(new d(pPSTransparencyDialog));
                    }
                    if (z) {
                        pPSTransparencyDialog.Code(this.I, new c(this.Z, this.B), new b(this.B));
                        relativeLayout.addView(pPSTransparencyDialog, layoutParams);
                        pPSTransparencyDialog.setScreenHeight(relativeLayout.getMeasuredHeight());
                        pPSTransparencyDialog.setScreenWidth(relativeLayout.getMeasuredWidth());
                    } else if ((fwVar instanceof PPSLinkedView) && !Code((PPSLinkedView) fwVar, this.I, this.Z, layoutParams, pPSTransparencyDialog)) {
                        return;
                    }
                    pPSTransparencyDialog.setAdContent(this.V);
                }
            }
        }

        private boolean Code(PPSLinkedView pPSLinkedView, boolean z, Integer num, RelativeLayout.LayoutParams layoutParams, PPSTransparencyDialog pPSTransparencyDialog) {
            SplashLinkedVideoView h = pPSLinkedView.h();
            if (h == null) {
                fb.I("PPSSplashAdSourceView", "linked splash container is null");
                return false;
            }
            pPSTransparencyDialog.Code(z, new c(num, this.B), new b(this.B));
            h.addView(pPSTransparencyDialog, layoutParams);
            pPSTransparencyDialog.setScreenHeight(h.getMeasuredHeight());
            pPSTransparencyDialog.setScreenWidth(h.getMeasuredWidth());
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements com.huawei.openalliance.ad.views.dsa.a {
        private fn Code;

        public b(fn fnVar) {
            this.Code = fnVar;
        }

        @Override // com.huawei.openalliance.ad.views.dsa.a
        public void Code() {
            fn fnVar = this.Code;
            if (fnVar != null) {
                fnVar.B();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements PPSLabelView.d {
        private Integer Code;
        private fn V;

        public c(Integer num, fn fnVar) {
            this.Code = num;
            this.V = fnVar;
        }

        private int Code(Context context, int i) {
            Integer b = w.b(context);
            if (w.I()) {
                return i;
            }
            if (b != null && b.intValue() >= 30454100) {
                return i;
            }
            fb.V("PPSSplashAdSourceView", "HMS version is low, interactMode is %s", Integer.valueOf(i));
            if (i == 4) {
                i = 1;
            }
            if (i == 3) {
                return 2;
            }
            return i;
        }

        @Override // com.huawei.openalliance.ad.views.PPSLabelView.d
        public void Code(View view) {
            di.Code(view.getContext()).Code();
            cy.Code(view.getContext());
            Intent intent = new Intent();
            intent.setAction(x.aj);
            intent.setPackage(w.Z(view.getContext()));
            intent.putExtra(bb.aj, Code(view.getContext(), this.Code.intValue()));
            if (!(view.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            bc.Code(view.getContext(), intent);
            fn fnVar = this.V;
            if (fnVar != null) {
                fnVar.C();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class d {
        PPSTransparencyDialog Code;

        public d(PPSTransparencyDialog pPSTransparencyDialog) {
            this.Code = pPSTransparencyDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code() {
            PPSTransparencyDialog pPSTransparencyDialog = this.Code;
            if (pPSTransparencyDialog != null) {
                pPSTransparencyDialog.S();
            }
        }
    }

    public PPSSplashAdSourceView(Context context) {
        super(context, null);
        this.D = false;
        this.L = false;
    }

    private void V(AdContentData adContentData) {
        TextView textView;
        int i;
        MetaData S = adContentData.S();
        if (S == null || this.I == null) {
            return;
        }
        String V = ay.V(S.L());
        if (TextUtils.isEmpty(V)) {
            textView = this.I;
            i = 8;
        } else {
            this.I.setText(V);
            textView = this.I;
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void Code() {
        d dVar = this.f17427a;
        if (dVar != null) {
            dVar.Code();
        }
    }

    public int getRootLayoutId() {
        this.L = Code(getContext(), this.C, this.S);
        return V() ? R.layout.hiad_splash_ad_source_with_click : R.layout.hiad_splash_ad_source;
    }

    public void setAdMediator(fn fnVar) {
        this.B = fnVar;
    }

    public void setTransparencyDialogCallback(d dVar) {
        this.f17427a = dVar;
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = false;
        this.L = false;
    }

    private void Code(int i, int i2, boolean z, int i3, int i4, RelativeLayout.LayoutParams layoutParams) {
        int I;
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.rightMargin = i3;
        layoutParams.setMarginEnd(i3);
        layoutParams.topMargin = i4;
        if (i2 != 0) {
            layoutParams.topMargin = i4 + i;
            return;
        }
        if (!z) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + i);
            layoutParams.rightMargin += i;
        }
        if (ck.V(getContext())) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + bc.I(getContext()));
            I = layoutParams.rightMargin + bc.I(getContext());
        } else {
            layoutParams.setMarginEnd(bc.I(getContext()));
            I = bc.I(getContext());
        }
        layoutParams.rightMargin = I;
        layoutParams.topMargin += w.V(getContext(), 12.0f);
    }

    private boolean V() {
        fb.V("PPSSplashAdSourceView", "isSplashClickable: %s, isShowTransparency: %s", Boolean.valueOf(this.L), Boolean.valueOf(this.D));
        return this.L || this.D;
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = false;
        this.L = false;
    }

    private void Code(Context context) {
        View.inflate(context, getRootLayoutId(), this);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label);
        this.V = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source);
        this.I = textView;
        textView.setVisibility(8);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.D = false;
        this.L = false;
    }

    public void Code(fw fwVar, Integer num, Integer num2, boolean z) {
        fb.V("PPSSplashAdSourceView", "setAdLabelConfig %s %s %s", num, num2, Boolean.valueOf(z));
        this.F = new WeakReference<>(fwVar);
        this.C = num;
        this.S = num2;
        this.D = z;
    }

    private void Code(AdContentData adContentData) {
        String r = adContentData.r();
        MetaData S = adContentData.S();
        AdSource Code = (S == null || S.l() == null) ? null : AdSource.Code(S.l());
        if (TextUtils.isEmpty(r)) {
            this.V.setVisibility(8);
            return;
        }
        PPSSplashLabelView pPSSplashLabelView = this.V;
        a aVar = new a(this, adContentData, this.L, this.C, this.B);
        WeakReference<fw> weakReference = this.F;
        pPSSplashLabelView.Code(aVar, weakReference != null ? weakReference.get() : null, adContentData, this.D);
        this.V.Code(Code, r, this.L);
        this.V.setVisibility(0);
        this.V.setDataAndRefreshUi(adContentData);
    }

    public void Code(AdContentData adContentData, boolean z, int i, int i2, boolean z2) {
        Code(getContext());
        String s = adContentData.s() == null ? "ll" : adContentData.s();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int i3 = R.dimen.hiad_splash_label_side_margin;
        int dimensionPixelSize = resources.getDimensionPixelSize(i3);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i3);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(s)) {
                Code(i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z, i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        Code(adContentData);
        V(adContentData);
    }

    private void Code(boolean z, int i, int i2, boolean z2, int i3, int i4, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        layoutParams.leftMargin = i3;
        layoutParams.setMarginStart(i3);
        layoutParams.bottomMargin = i4;
        if (i2 != 0) {
            if (z) {
                return;
            }
            layoutParams.bottomMargin = i4 + bc.I(getContext());
            return;
        }
        if (ck.V(getContext()) && z2) {
            layoutParams.setMarginStart(layoutParams.leftMargin + i);
            layoutParams.leftMargin += i;
        } else if (!ck.V(getContext()) || (ck.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1)) {
            layoutParams.setMarginStart(bc.I(getContext()));
            layoutParams.leftMargin = bc.I(getContext());
        }
        if (z) {
            return;
        }
        if (n.B(getContext()) || n.S(getContext())) {
            layoutParams.bottomMargin += bc.I(getContext());
        }
    }

    public static boolean Code(Context context, Integer num, Integer num2) {
        if (!ck.Code(context).V() || num == null || num2 == null) {
            return false;
        }
        return ((num.intValue() == 1 || num.intValue() == 4) && (num2.intValue() == 2 || num2.intValue() == 3)) || ((num.intValue() == 2 || num.intValue() == 3) && (num2.intValue() == 1 || num2.intValue() == 3));
    }
}
