package com.huawei.openalliance.ad.feedback;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ck;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bi;
import com.huawei.openalliance.ad.utils.q;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: classes10.dex */
public class FeedbackView extends PPSBaseDialogContentView implements d {
    private LinearLayout h;
    private LinearLayout i;
    private FlowLayoutView j;
    private FlowLayoutView k;
    private ViewStub l;
    private com.huawei.openalliance.ad.compliance.a m;
    private boolean n;
    private boolean o;
    private com.huawei.openalliance.ad.feedback.b p;
    private a q;
    private c r;

    /* loaded from: classes10.dex */
    public static class a extends b {
        private com.huawei.openalliance.ad.compliance.a I;

        public a(Context context) {
            super(context);
        }

        public void Code(com.huawei.openalliance.ad.compliance.a aVar) {
            this.I = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.feedback.b bVar = this.Code;
            if (bVar == null) {
                return;
            }
            boolean Z = bVar.Z();
            fb.Code("FeedbackView", "click to complain:%s", Boolean.valueOf(Z));
            if (!Z || this.I == null || w.b(view.getContext()).intValue() >= 30468100) {
                return;
            }
            this.I.Code(3, this.Code.I());
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b implements View.OnClickListener {
        protected com.huawei.openalliance.ad.feedback.b Code;
        protected final Context V;

        public b(Context context) {
            this.V = context;
        }

        public void Code(com.huawei.openalliance.ad.feedback.b bVar) {
            this.Code = bVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends b {
        public c(Context context) {
            super(context);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.feedback.b bVar = this.Code;
            if (bVar == null) {
                return;
            }
            boolean Code = bVar.Code(this.V);
            fb.Code("FeedbackView", "click to why this ad:%s", Boolean.valueOf(Code));
            if (Code) {
                Context context = this.V;
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
            }
        }
    }

    public FeedbackView(Context context) {
        super(context);
        this.n = true;
        this.o = true;
    }

    private boolean I() {
        com.huawei.openalliance.ad.feedback.b bVar = this.p;
        return (bVar == null || !bVar.B() || ay.Code(this.p.C())) ? false : true;
    }

    private void setArrowBitMap(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (bc.I()) {
                imageView.setImageBitmap(z.V(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        View view;
        try {
            this.o = ck.Code(getContext()).V();
            fb.V("FeedbackView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.b), Integer.valueOf(this.c));
            if (V() && (view = this.I) != null) {
                view.setPadding(this.b, 0, this.c, 0);
                com.huawei.openalliance.ad.feedback.b bVar = this.p;
                if (bVar != null) {
                    List<FeedbackInfo> Code = bVar.Code();
                    List<FeedbackInfo> V = this.p.V();
                    FeedbackInfo I = this.p.I();
                    if (q.Code(Code)) {
                        bi.Code((View) this.h, true);
                        Code(this.j, Code, 2);
                    } else {
                        bi.Code((View) this.h, false);
                    }
                    if (q.Code(V)) {
                        bi.Code((View) this.i, true);
                        Code(this.k, V, 1);
                    } else {
                        bi.Code((View) this.i, false);
                    }
                    Code(I);
                }
                this.I.requestLayout();
                this.I.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
            }
        } catch (Throwable th) {
            fb.I("FeedbackView", "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        boolean V = ck.Code(context).V();
        this.o = V;
        fb.Code("FeedbackView", "isChinaRom = %s", Boolean.valueOf(V));
        ViewStub viewStub = this.l;
        if (viewStub == null) {
            return;
        }
        viewStub.setLayoutResource(R.layout.hiad_feedback_viewstub);
        this.l.inflate();
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        ImageView imageView2 = (ImageView) this.V.findViewById(R.id.dsa_right_arrow);
        setArrowBitMap(imageView);
        setArrowBitMap(imageView2);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        com.huawei.openalliance.ad.feedback.b bVar = this.p;
        if (bVar != null) {
            bVar.Code(getContext(), adContentData);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
        this.m = aVar;
        a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.Code(aVar);
        }
    }

    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = true;
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i, FeedbackInfo feedbackInfo) {
        com.huawei.openalliance.ad.compliance.a aVar = this.m;
        if (aVar != null) {
            aVar.Code(i, feedbackInfo);
        }
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = true;
        this.o = true;
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_feedback_view, this);
            this.V = inflate;
            this.h = (LinearLayout) inflate.findViewById(R.id.feedback_positive_ll);
            this.i = (LinearLayout) this.V.findViewById(R.id.feedback_negative_ll);
            this.I = this.V.findViewById(R.id.feedback_view_root);
            this.B = this.V.findViewById(R.id.feedback_scrollview);
            this.j = (FlowLayoutView) this.V.findViewById(R.id.feedback_positive_flv);
            this.k = (FlowLayoutView) this.V.findViewById(R.id.feedback_negative_flv);
            this.l = (ViewStub) this.V.findViewById(R.id.feedback_viewstub);
            this.p = new com.huawei.openalliance.ad.feedback.b(this);
            this.q = new a(getContext());
            this.r = new c(getContext());
            this.q.Code(this.p);
            this.r.Code(this.p);
        } catch (Throwable th) {
            fb.I("FeedbackView", "initView error, %s", th.getClass().getSimpleName());
        }
    }

    @SuppressLint({"NewApi"})
    public FeedbackView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.n = true;
        this.o = true;
    }

    private void Code(FlowLayoutView flowLayoutView, List<FeedbackInfo> list, final int i) {
        flowLayoutView.removeAllViews();
        if (ad.Code(list)) {
            fb.V("FeedbackView", "feedbackInfoList is null");
            return;
        }
        fb.V("FeedbackView", "initFlowLayout, feedType: %s, feedbackList.size: %s", Integer.valueOf(i), Integer.valueOf(list.size()));
        for (final FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && !TextUtils.isEmpty(feedbackInfo.Code())) {
                String Code = feedbackInfo.Code();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_feedback_unlike_label_item, (ViewGroup) flowLayoutView, false);
                if (inflate instanceof TextView) {
                    TextView textView = (TextView) inflate;
                    textView.setText(Code);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (FeedbackView.this.n) {
                                    FeedbackView.this.n = false;
                                    view.setSelected(!view.isSelected());
                                    view.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FeedbackView.this.n = true;
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            FeedbackView.this.Code(i, feedbackInfo);
                                        }
                                    }, 200L);
                                }
                            } catch (Throwable th) {
                                fb.I("FeedbackView", "onClick error, %s", th.getClass().getSimpleName());
                            }
                        }
                    });
                    flowLayoutView.addView(textView);
                }
            }
        }
        flowLayoutView.setDefaultDisplayMode(bc.I() ? -1 : 1);
    }

    private void Code(FeedbackInfo feedbackInfo) {
        View findViewById = this.V.findViewById(R.id.complain_extra_area);
        View findViewById2 = this.V.findViewById(R.id.dsa_extra_area);
        if (this.o) {
            if (findViewById != null) {
                if (feedbackInfo == null || !feedbackInfo.Z()) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                    ((TextView) this.V.findViewById(R.id.complain_tv)).setText(feedbackInfo.Code());
                    findViewById.setOnClickListener(this.q);
                }
            }
            if (findViewById2 == null) {
                return;
            }
            if (!I()) {
                findViewById2.setVisibility(8);
                return;
            }
        } else {
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (findViewById2 == null) {
                return;
            }
        }
        findViewById2.setVisibility(0);
        findViewById2.setOnClickListener(this.r);
    }
}
