package com.baidu.navisdk.ugc.report.ui.innavi.main;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class b {
    private c f;

    /* renamed from: a, reason: collision with root package name */
    private Button f8281a = null;
    private Button b = null;
    private ImageView c = null;
    private TextView d = null;
    private boolean e = false;
    private View.OnClickListener g = new a();
    private View.OnTouchListener h = new ViewOnTouchListenerC0395b();

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.ugc_navi_upload_immediately_upload_btn) {
                if (b.this.f != null) {
                    b.this.f.s();
                }
            } else if (id == R.id.ugc_navi_upload_content_fill_btn && b.this.f != null) {
                b.this.f.b(false);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.main.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnTouchListenerC0395b implements View.OnTouchListener {
        public ViewOnTouchListenerC0395b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (view.getId() == R.id.ugc_navi_upload_content_fill_btn) {
                b.this.a("6A6A6A", view, motionEvent);
                return false;
            }
            return false;
        }
    }

    public b(c cVar) {
        this.f = null;
        this.f = cVar;
    }

    public void a() {
    }

    public View a(Context context, int i) {
        View inflate = JarUtils.inflate(context, R.layout.nsdk_layout_ugc_report_sub_tips_view, null);
        this.f8281a = (Button) inflate.findViewById(R.id.ugc_navi_upload_immediately_upload_btn);
        this.b = (Button) inflate.findViewById(R.id.ugc_navi_upload_content_fill_btn);
        this.c = (ImageView) inflate.findViewById(R.id.ugc_sub_title_iv);
        this.d = (TextView) inflate.findViewById(R.id.ugc_sub_title_type_tv);
        c cVar = this.f;
        if (cVar != null) {
            a(cVar.h());
        }
        Button button = this.f8281a;
        if (button != null && this.b != null) {
            button.setOnClickListener(this.g);
            this.b.setOnClickListener(this.g);
            this.b.setOnTouchListener(this.h);
        }
        TextView textView = this.d;
        if (textView != null && this.c != null) {
            textView.setText(this.f.o());
            this.f.a(i, this.c);
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, View view, MotionEvent motionEvent) {
        if (view instanceof TextView) {
            RectF a2 = a(view);
            if (motionEvent.getAction() == 0) {
                this.e = false;
                ((TextView) view).setTextColor(Color.parseColor("#66" + str));
                return;
            }
            if (motionEvent.getAction() == 2) {
                if (a(a2, motionEvent) && !this.e) {
                    ((TextView) view).setTextColor(Color.parseColor("#66" + str));
                    return;
                }
                this.e = true;
                ((TextView) view).setTextColor(Color.parseColor(xoXoI.f2670oxoX + str));
                return;
            }
            ((TextView) view).setTextColor(Color.parseColor(xoXoI.f2670oxoX + str));
        }
    }

    private boolean a(RectF rectF, MotionEvent motionEvent) {
        return motionEvent != null && rectF.contains(motionEvent.getRawX(), motionEvent.getRawY());
    }

    private RectF a(View view) {
        int[] iArr = new int[2];
        if (view == null) {
            return new RectF();
        }
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    public void a(int i) {
        Button button = this.f8281a;
        if (button != null) {
            button.setText(String.format("%s(%ds)", "立即上报", Integer.valueOf(i)));
        }
    }
}
