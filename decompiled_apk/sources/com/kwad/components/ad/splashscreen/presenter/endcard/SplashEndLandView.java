package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;

/* loaded from: classes11.dex */
public class SplashEndLandView extends FrameLayout {
    private CloseCountDownView EE;
    private ViewGroup EF;
    private ViewGroup EG;
    private ImageView EH;
    private TextView EI;
    private TextView EJ;
    private ImageView EU;
    private TextView EV;
    private KsLogoView EW;
    private TextView EX;
    private TextView EY;
    private int EZ;

    public SplashEndLandView(@NonNull Context context) {
        super(context);
        this.EZ = 24;
    }

    private void b(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (cVar == null) {
            return;
        }
        String a2 = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfo, cVar.ov(), 0);
        if (!TextUtils.isEmpty(a2)) {
            this.EX.setText(a2);
        } else {
            this.EX.setText(com.kwad.sdk.core.response.b.a.aD(adInfo));
        }
    }

    public final void W(String str) {
        TextView textView = this.EX;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, float f) {
        a(new g(getContext(), f));
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        this.EH.setImageResource(R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.e.c.d("SplashEndLandView", "bindView, appIconRadius: " + this.EZ);
        KSImageLoader.loadAppIcon(this.EH, com.kwad.sdk.core.response.b.a.cg(dS), adTemplate, this.EZ);
        this.EI.setText(com.kwad.sdk.core.response.b.a.cd(dS));
        this.EJ.setText(com.kwad.sdk.core.response.b.a.at(dS));
        this.EW.aE(adTemplate);
        if (!com.kwad.sdk.core.response.b.a.aE(dS)) {
            this.EX.setText("点击查看");
            this.EY.setVisibility(0);
            this.EY.setText("跳转详情页/第三方应用");
        } else {
            b(adTemplate, dS, cVar);
        }
        this.EE.a(dS, f);
    }

    public final void aM() {
        CloseCountDownView closeCountDownView = this.EE;
        if (closeCountDownView != null) {
            closeCountDownView.aM();
        }
    }

    public final void aN() {
        CloseCountDownView closeCountDownView = this.EE;
        if (closeCountDownView != null) {
            closeCountDownView.aN();
        }
    }

    public ViewGroup getActionBarView() {
        return this.EG;
    }

    public TextView getAppDesc() {
        return this.EJ;
    }

    public ImageView getAppIcon() {
        return this.EH;
    }

    public TextView getAppName() {
        return this.EI;
    }

    public CloseCountDownView getCloseView() {
        return this.EE;
    }

    public ViewGroup getGiftBoxView() {
        return this.EF;
    }

    public final void lF() {
        CloseCountDownView closeCountDownView = this.EE;
        if (closeCountDownView != null) {
            closeCountDownView.bf();
        }
    }

    public final void s(boolean z) {
        int i;
        if (z) {
            i = R.layout.ksad_splash_end_card_area_land;
        } else {
            i = R.layout.ksad_splash_end_card_area;
        }
        View.inflate(getContext(), i, this);
        this.EU = (ImageView) findViewById(R.id.ksad_ad_endcard_title_view);
        this.EF = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.EH = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.EI = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.EV = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.EJ = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.EW = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.EX = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.EY = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.EE = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.EG = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.EZ = 24;
    }

    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.EZ = 24;
    }

    @RequiresApi(api = 21)
    public SplashEndLandView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.EZ = 24;
    }

    private void a(g gVar) {
        ad.a(this.EU, gVar.lG());
        ad.a(this.EF, gVar.lH());
        ad.a(this.EH, gVar.lI());
        ad.a(this.EG, gVar.lK());
        ad.a(this.EI, gVar.lL());
        ad.a(this.EV, gVar.lM());
        ad.a(this.EJ, gVar.lN());
        ad.a(this.EE, gVar.lO());
        TextView textView = this.EI;
        if (textView != null) {
            textView.setTextSize(0, gVar.lP());
        }
        TextView textView2 = this.EV;
        if (textView2 != null) {
            textView2.setTextSize(0, gVar.lQ());
        }
        TextView textView3 = this.EJ;
        if (textView3 != null) {
            textView3.setTextSize(0, gVar.lR());
        }
        TextView textView4 = this.EX;
        if (textView4 != null) {
            textView4.setTextSize(0, gVar.lS());
        }
        TextView textView5 = this.EY;
        if (textView5 != null) {
            textView5.setTextSize(0, gVar.lT());
        }
        this.EZ = gVar.lJ();
    }
}
