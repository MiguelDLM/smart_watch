package com.baidu.navisdk.ugc.quickinput.sugs;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.report.data.datarepository.j;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import java.util.Locale;

/* loaded from: classes8.dex */
public class QuickInputPromptView extends LinearLayout implements com.baidu.navisdk.ugc.quickinput.sugs.a, View.OnClickListener, com.baidu.navisdk.ugc.quickinput.sugs.b {

    /* renamed from: a, reason: collision with root package name */
    private int f8223a;
    private int b;
    private a[] c;
    private View d;
    private b e;
    private j f;
    private d g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, String str2);
    }

    public QuickInputPromptView(Context context) {
        this(context, null);
    }

    private void b() {
        a[] aVarArr = new a[4];
        this.c = aVarArr;
        aVarArr[3] = new a((TextView) findViewById(R.id.ugc_quick_input_prompt_tv1), findViewById(R.id.ugc_quick_input_prompt_line1));
        this.c[2] = new a((TextView) findViewById(R.id.ugc_quick_input_prompt_tv2), findViewById(R.id.ugc_quick_input_prompt_line2));
        this.c[1] = new a((TextView) findViewById(R.id.ugc_quick_input_prompt_tv3), findViewById(R.id.ugc_quick_input_prompt_line3));
        this.c[0] = new a((TextView) findViewById(R.id.ugc_quick_input_prompt_tv4), null);
        this.d = findViewById(R.id.ugc_quick_input_prompt_line4);
        for (a aVar : this.c) {
            aVar.a(this);
        }
        setVisibility(8);
        if (this.g == null) {
            this.g = new d(this);
        }
    }

    private void c() {
        int min;
        j jVar = this.f;
        if (jVar != null && !jVar.d()) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            int c = this.f.c();
            if (this.b == 2) {
                min = Math.min(c, 2);
            } else {
                min = Math.min(c, this.f8223a);
            }
            int i = 0;
            while (i < min) {
                String a2 = this.f.a(i);
                if (TextUtils.isEmpty(a2)) {
                    break;
                }
                this.c[i].a(0);
                this.c[i].a(a2);
                i++;
            }
            for (int length = this.c.length - 1; length >= i; length--) {
                this.c[length].a(8);
            }
            return;
        }
        setVisibility(8);
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void a(String str) {
        if (this.i) {
            this.i = false;
            return;
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(null, null);
        }
        if (!TextUtils.isEmpty(str) && str.length() <= 6) {
            d dVar = this.g;
            if (dVar != null) {
                dVar.a(str, this.h);
                return;
            }
            return;
        }
        d dVar2 = this.g;
        if (dVar2 != null) {
            dVar2.a();
        }
        a((j) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (this.e != null && this.f != null) {
            int id = view.getId();
            int i = 2;
            if (id == R.id.ugc_quick_input_prompt_tv1) {
                str = this.f.a(3);
            } else if (id == R.id.ugc_quick_input_prompt_tv2) {
                str = this.f.a(2);
            } else if (id == R.id.ugc_quick_input_prompt_tv3) {
                str = this.f.a(1);
            } else if (id == R.id.ugc_quick_input_prompt_tv4) {
                str = this.f.a(0);
            } else {
                str = null;
            }
            if (this.e != null && !TextUtils.isEmpty(str) && this.f != null) {
                this.i = true;
                this.e.a(str.replaceAll("<\\/{0,1}font.*?>", ""), this.f.a());
                if (TextUtils.isEmpty(this.f.a())) {
                    i = 1;
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.7", this.l + "", this.k + "", "" + i);
                a((j) null);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void onDestroy() {
        setVisibility(8);
        this.c = null;
        this.f = null;
        d dVar = this.g;
        if (dVar != null) {
            dVar.b();
            this.g = null;
        }
        this.e = null;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setClickPromptListener(b bVar) {
        this.e = bVar;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setEventType(int i) {
        this.h = i;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setHasInitTextInEdit(boolean z) {
        this.j = z;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setIsShowTags(boolean z) {
        if (z) {
            this.f8223a = Math.min(this.f8223a, 3);
            return;
        }
        View view = this.d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setPageFrom(int i) {
        this.l = i;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setScreenOrientation(int i) {
        int dip2px;
        if (i != 1 && i != 2) {
            g gVar = g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule_Sug", String.format(Locale.getDefault(), "QuickInputPromptView orientation value is %d, the value must %d or %d", Integer.valueOf(i), 1, 2));
                return;
            }
            return;
        }
        this.b = i;
        if (i == 2) {
            dip2px = ScreenUtil.getInstance().dip2px(34);
        } else {
            dip2px = ScreenUtil.getInstance().dip2px(45);
        }
        LinearLayout.LayoutParams layoutParams = null;
        for (a aVar : this.c) {
            if (layoutParams == null) {
                layoutParams = aVar.a();
            }
            layoutParams.height = dip2px;
            aVar.a(layoutParams);
        }
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void setSourceFrom(int i) {
        this.k = i;
    }

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private TextView f8224a;
        private View b;

        public a(TextView textView, View view) {
            this.f8224a = textView;
            this.b = view;
        }

        public void a(String str) {
            TextView textView = this.f8224a;
            if (textView != null) {
                textView.setText(Html.fromHtml(str));
            }
        }

        public void a(int i) {
            TextView textView = this.f8224a;
            if (textView != null && textView.getVisibility() != i) {
                this.f8224a.setVisibility(i);
            }
            View view = this.b;
            if (view == null || view.getVisibility() == i) {
                return;
            }
            this.b.setVisibility(i);
        }

        public void a(View.OnClickListener onClickListener) {
            TextView textView = this.f8224a;
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
            }
        }

        public void a(LinearLayout.LayoutParams layoutParams) {
            TextView textView = this.f8224a;
            if (textView != null) {
                textView.setLayoutParams(layoutParams);
            }
        }

        public LinearLayout.LayoutParams a() {
            TextView textView = this.f8224a;
            if (textView != null) {
                return (LinearLayout.LayoutParams) textView.getLayoutParams();
            }
            return new LinearLayout.LayoutParams(-1, -2);
        }
    }

    public QuickInputPromptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8223a = 4;
        this.b = 1;
        this.h = -1;
        this.i = false;
        this.j = false;
    }

    @TargetApi(11)
    public QuickInputPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8223a = 4;
        this.b = 1;
        this.h = -1;
        this.i = false;
        this.j = false;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.a
    public void a() {
        d dVar = this.g;
        if (dVar == null || this.j) {
            return;
        }
        dVar.a(this.h);
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.b
    public void a(j jVar) {
        this.f = jVar;
        c();
    }

    @TargetApi(21)
    public QuickInputPromptView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8223a = 4;
        this.b = 1;
        this.h = -1;
        this.i = false;
        this.j = false;
    }

    @Override // com.baidu.navisdk.ugc.quickinput.sugs.b
    public void a(j jVar, boolean z) {
        if (z) {
            this.f = jVar;
            c();
        }
    }
}
