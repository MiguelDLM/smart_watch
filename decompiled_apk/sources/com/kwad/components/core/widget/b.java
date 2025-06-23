package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.h.c {
    public a abY;
    private long abZ;
    private com.kwad.components.core.widget.a.b bQ;
    private com.kwad.sdk.core.h.b bT;
    public AdInfo mAdInfo;

    @NonNull
    protected T mAdResultData;

    @NonNull
    public R mAdTemplate;

    @NonNull
    public Context mContext;
    private bn mTimerHelper;
    protected boolean ms;

    /* loaded from: classes11.dex */
    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public b(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ long a(b bVar, long j) {
        long j2 = bVar.abZ + j;
        bVar.abZ = j2;
        return j2;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    private void initView() {
        l.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bc();
        this.bQ = new com.kwad.components.core.widget.a.b(this, 70);
    }

    public final void aL(int i) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, getTouchCoords());
        a aVar = this.abY;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public void aM() {
    }

    public void aN() {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        this.bQ.a(this);
        this.bQ.a(this.bT);
        this.bQ.ua();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        this.bQ.ub();
        this.bQ.b(this);
        bf();
    }

    public void b(@NonNull T t) {
        this.mAdResultData = t;
        R r = (R) com.kwad.sdk.core.response.b.c.n(t);
        this.mAdTemplate = r;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(r);
        a(this);
    }

    public abstract void bc();

    public void bf() {
    }

    public void bv() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.abY) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0845a c0845a = new a.C0845a();
        FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0845a.templateId = String.valueOf(fromInt.getType());
        bVar.b(c0845a);
        bVar.v(getHeight(), getWidth());
        com.kwad.components.core.s.b.rC().a(this.mAdTemplate, null, bVar);
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public long getStayTime() {
        return this.abZ + getTimerHelper().getTime();
    }

    public bn getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bn();
        }
        return this.mTimerHelper;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.abY;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.abY;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.abY = aVar;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.bT = bVar;
    }

    public final void tN() {
        a aVar = this.abY;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void tO() {
        com.kwad.sdk.core.adlog.c.bG(this.mAdTemplate);
        a aVar = this.abY;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.d.CX() && com.kwad.sdk.core.config.d.CW() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0818a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0818a
                public final void ac() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0818a
                public final void ad() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.ms) {
                            long Oc = bVar.getTimerHelper().Oc();
                            b.a(b.this, Oc);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Oc, (JSONObject) null);
                            b.this.ms = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0818a
                public final void eq() {
                    if (b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.ms) {
                            long Oc = bVar.getTimerHelper().Oc();
                            b.a(b.this, Oc);
                            com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, Oc, (JSONObject) null);
                            b.this.ms = false;
                        }
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0818a
                public final void k(View view) {
                    if (!b.this.mAdTemplate.mPvReported) {
                        b bVar = b.this;
                        if (bVar.abY != null) {
                            bVar.ms = true;
                            bVar.bv();
                            b.this.getTimerHelper().startTiming();
                        }
                    }
                    b bVar2 = b.this;
                    if (!bVar2.ms) {
                        bVar2.getTimerHelper().startTiming();
                    }
                    b.this.ms = true;
                }
            });
            aVar.tM();
            return;
        }
        c b = b(viewGroup);
        if (b == null) {
            b = new c(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new c.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.c.a
            public final void er() {
                b.this.bv();
            }
        });
        b.setNeedCheckingShow(true);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private static c b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof c) {
                return (c) childAt;
            }
        }
        return null;
    }

    public final void c(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.abY;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }
}
