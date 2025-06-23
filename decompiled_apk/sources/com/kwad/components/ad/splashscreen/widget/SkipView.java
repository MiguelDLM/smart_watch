package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.n.l;

/* loaded from: classes11.dex */
public class SkipView extends LinearLayout implements com.kwad.components.ad.splashscreen.widget.b {
    private a FY;
    private Runnable Gk;
    private TextView HA;
    private TextView HB;
    private int HC;
    private final b Hy;
    private View Hz;
    private boolean nE;
    private boolean sC;

    /* loaded from: classes11.dex */
    public interface a {
        void Y(int i);

        void lb();

        void lc();
    }

    /* loaded from: classes11.dex */
    public static class b {
        private int Gf;
        private String HE;
        private String HF;
        private int HG;
        private boolean HH;
        private boolean HI;

        private b() {
            this.HE = "跳过";
            this.HF = "";
            this.HG = 5;
            this.Gf = 5;
            this.HH = true;
            this.HI = true;
        }

        public static /* synthetic */ int d(b bVar) {
            int i = bVar.Gf;
            bVar.Gf = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean mA() {
            if (this.HH && this.HI) {
                return true;
            }
            return false;
        }

        public final void X(String str) {
            this.Gf = -1;
            this.HF = str;
        }

        public final void ad(int i) {
            this.HG = i;
            this.Gf = i;
        }

        public final String my() {
            int i = this.Gf;
            if (i < 0) {
                return this.HF;
            }
            if (i == 0) {
                return this.HF + 1;
            }
            return this.HF + this.Gf;
        }

        public final boolean mz() {
            if (this.Gf <= 0) {
                return true;
            }
            return false;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public SkipView(Context context) {
        this(context, null);
    }

    private void C(AdInfo adInfo) {
        setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cz(adInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i) {
        a aVar = this.FY;
        if (aVar != null) {
            aVar.Y(i);
        }
    }

    private void eG() {
        a(this.Hy);
        post(this.Gk);
    }

    private void eH() {
        this.nE = true;
    }

    private void eI() {
        this.nE = false;
    }

    private void init() {
        setOrientation(0);
        l.inflate(getContext(), R.layout.ksad_skip_view, this);
        this.HA = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.HB = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.Hz = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SkipView.this.FY != null) {
                    SkipView.this.FY.lb();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    private void mx() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        if (!com.kwad.sdk.core.response.b.a.bb(adInfo)) {
            eH();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        if (this.sC) {
            mx();
        }
        if (!com.kwad.sdk.core.response.b.a.bb(adInfo)) {
            eI();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int aa(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        int width = getWidth();
        setLayoutParams(layoutParams);
        return width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void bf() {
        if (getHandler() != null) {
            getHandler().removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.HC = layoutParams.width;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(a aVar) {
        this.FY = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.Hy.HH = z;
        a(this.Hy);
    }

    public void setSkipText(String str) {
        this.Hy.HE = str;
        a(this.Hy);
    }

    public void setTimerBtnVisible(boolean z) {
        this.Hy.HI = z;
        a(this.Hy);
    }

    public void setTimerPrefixText(String str) {
        this.Hy.HF = str;
        a(this.Hy);
    }

    public void setTimerSecond(int i) {
        this.Hy.ad(i);
        a(this.Hy);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(l.wrapContextIfNeed(context), attributeSet, i);
        this.Hy = new b((byte) 0);
        this.HC = -1;
        this.nE = false;
        this.sC = true;
        this.Gk = new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.SkipView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (SkipView.this.nE) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.Hy);
                SkipView skipView2 = SkipView.this;
                skipView2.X(skipView2.Hy.HG - SkipView.this.Hy.Gf);
                if (!SkipView.this.Hy.mz()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.d(SkipView.this.Hy);
                } else if (SkipView.this.FY != null) {
                    SkipView.this.FY.lc();
                }
            }
        };
        init();
    }

    public final void X(String str) {
        if (str == null) {
            return;
        }
        this.Hy.X(str);
        a(this.Hy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.HA != null) {
            if (bVar.HE != null) {
                this.HA.setText(bVar.HE);
            }
            this.HA.setVisibility(this.Hy.HH ? 0 : 8);
        }
        String my = bVar.my();
        TextView textView = this.HB;
        if (textView != null) {
            if (my != null) {
                textView.setText(my);
            }
            this.HB.setVisibility(this.Hy.HI ? 0 : 8);
        }
        if (this.Hz != null) {
            boolean mA = this.Hy.mA();
            this.Hz.setVisibility(mA ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (!mA) {
                    layoutParams.width = -2;
                    invalidate();
                    return;
                }
                int i = this.HC;
                if (i > 0) {
                    layoutParams.width = i;
                    invalidate();
                }
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sC = com.kwad.sdk.core.response.b.a.cy(adInfo);
        setTimerPrefixText(com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.CP));
        setTimerSecond(splashSkipViewModel.skipSecond);
        if (!com.kwad.sdk.core.response.b.a.bb(adInfo)) {
            eG();
        }
        setSkipText(com.kwad.sdk.core.response.b.a.ck(adInfo));
        setVisibility(8);
        C(adInfo);
    }
}
