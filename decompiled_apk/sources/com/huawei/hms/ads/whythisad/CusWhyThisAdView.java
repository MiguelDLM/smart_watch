package com.huawei.hms.ads.whythisad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class CusWhyThisAdView extends RelativeLayout {
    private HorizontalScrollView B;
    private ScrollView C;
    private c D;
    private LinearLayout F;
    private RelativeLayout I;
    private RelativeLayout L;
    private LinearLayout S;
    private RelativeLayout V;

    /* renamed from: a, reason: collision with root package name */
    private HorizontalScrollView f17367a;
    private ScrollView b;
    private LinearLayout c;
    private LinearLayout d;
    private c e;
    private TextView f;
    private b g;

    /* loaded from: classes10.dex */
    public enum a {
        NONE,
        INIT,
        SHOWN,
        DISLIKED
    }

    public CusWhyThisAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context, attributeSet);
    }

    public void B() {
        Z();
    }

    public void Code() {
        this.I.setVisibility(8);
        this.f17367a.setVisibility(8);
        this.b.setVisibility(8);
        this.B.setVisibility(8);
        this.C.setVisibility(8);
        this.L.setVisibility(8);
        this.f.setVisibility(8);
    }

    public void I() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.V();
        }
    }

    public void V() {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        boolean z = false;
        this.I.setVisibility(0);
        d dVar = new d(getContext().getString(R.string.hiad_choices_hide), com.huawei.hms.ads.whythisad.a.HIDE_AD);
        d dVar2 = new d(getContext().getString(R.string.hiad_choices_whythisad), com.huawei.hms.ads.whythisad.a.WHY_THIS_AD);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        arrayList.add(dVar2);
        if (this.V.getWidth() > this.V.getHeight()) {
            this.e = new c(getContext(), this, this.c);
            this.f17367a.setVisibility(0);
            this.b.setVisibility(8);
            z = true;
        } else {
            this.e = new c(getContext(), this, this.d);
            this.f17367a.setVisibility(8);
            this.b.setVisibility(0);
        }
        this.e.Code(arrayList, z);
        fb.Code("CusWhyView", "SDK showWhyThisAd end");
    }

    public void Z() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.Code();
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.I;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.L;
        boolean z = false;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        HorizontalScrollView horizontalScrollView = this.B;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(0);
        }
        List<String> arrayList = new ArrayList<>();
        b bVar2 = this.g;
        if (bVar2 != null) {
            arrayList = bVar2.I();
        }
        ArrayList arrayList2 = new ArrayList();
        if (ad.Code(arrayList)) {
            Code(null);
            return;
        }
        arrayList2.add(new d(getContext().getString(R.string.hiad_choices_ad_no_interest), com.huawei.hms.ads.whythisad.a.NOT_INTEREST));
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new d(it.next(), com.huawei.hms.ads.whythisad.a.CLOSE_AD));
        }
        if (this.V.getWidth() > this.V.getHeight()) {
            this.D = new c(getContext(), this, this.S);
            this.B.setVisibility(0);
            this.C.setVisibility(8);
            z = true;
        } else {
            this.D = new c(getContext(), this, this.F);
            this.B.setVisibility(8);
            this.C.setVisibility(0);
        }
        this.D.Code(arrayList2, z);
        fb.Code("CusWhyView", "SDK showFeedBackList end");
    }

    public void setOnCloseCallBack(b bVar) {
        this.g = bVar;
    }

    public CusWhyThisAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context, attributeSet);
    }

    private void Code(Context context, AttributeSet attributeSet) {
        View.inflate(context, R.layout.hiad_choices_whythisad_root, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.hiad_whythisad_wrapper);
        this.I = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f17367a = (HorizontalScrollView) findViewById(R.id.hiad_whythisad_horizontal_List);
        this.c = (LinearLayout) findViewById(R.id.hiad_whythisad_horizional_ll_wrapper);
        this.f17367a.setVisibility(8);
        this.b = (ScrollView) findViewById(R.id.hiad_whythisad_vertical_feedback_List);
        this.d = (LinearLayout) findViewById(R.id.hiad_whythisad_vertical_ll_wrapper);
        this.b.setVisibility(8);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.hiad_feedback_wrapper);
        this.L = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.B = (HorizontalScrollView) findViewById(R.id.hiad_feedback_horizontal_List);
        this.S = (LinearLayout) findViewById(R.id.hiad_feedback_horizional_ll_wrapper);
        this.B.setVisibility(8);
        this.C = (ScrollView) findViewById(R.id.hiad_feedback_vertical_feedback_List);
        this.F = (LinearLayout) findViewById(R.id.hiad_feedback_vertical_ll_wrapper);
        this.C.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_closed_hint);
        this.f = textView;
        textView.setVisibility(8);
    }

    public CusWhyThisAdView(Context context, RelativeLayout relativeLayout) {
        super(context);
        this.V = relativeLayout;
        Code(context, null);
    }

    public void Code(String str) {
        HorizontalScrollView horizontalScrollView = this.B;
        if (horizontalScrollView != null) {
            horizontalScrollView.setVisibility(8);
        }
        ScrollView scrollView = this.C;
        if (scrollView != null) {
            scrollView.setVisibility(8);
        }
        HorizontalScrollView horizontalScrollView2 = this.f17367a;
        if (horizontalScrollView2 != null) {
            horizontalScrollView2.setVisibility(8);
        }
        ScrollView scrollView2 = this.b;
        if (scrollView2 != null) {
            scrollView2.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setVisibility(0);
        }
        this.g.Code(str);
        fb.Code("CusWhyView", "SDK processCloseEvent");
    }
}
