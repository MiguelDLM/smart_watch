package com.baidu.navisdk.ugc.report.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.pictures.previews.b;
import com.baidu.navisdk.ugc.pictures.show.UgcInputShowPicLayout;
import com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView;
import com.baidu.navisdk.ugc.report.ui.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.c0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ugc.report.ui.widget.c implements View.OnClickListener, b.e, UgcInputShowPicLayout.a {
    private Context d;
    private com.baidu.navisdk.ugc.report.ui.a e;
    private int f;
    private d.c g;
    private int h;
    private View i;
    private View j;
    private UgcInputShowPicLayout o;
    private com.baidu.navisdk.ugc.module.a p;
    private com.baidu.navisdk.ugc.pictures.previews.b q;
    private TextView k = null;
    private EditText l = null;
    private View m = null;
    private com.baidu.navisdk.ugc.dialog.b n = null;
    private int r = -1;
    TextWatcher s = new a();
    private View.OnFocusChangeListener t = new ViewOnFocusChangeListenerC0399b();

    /* loaded from: classes8.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z;
            if (editable.length() > 40) {
                z = true;
            } else {
                z = false;
            }
            if (b.this.m != null) {
                if (editable.length() > 0) {
                    b.this.m.setVisibility(0);
                } else {
                    b.this.m.setVisibility(8);
                }
            }
            if (z) {
                try {
                    b.this.l.setText(b.this.l.getText().toString().substring(0, 40));
                    b.this.l.setSelection(40);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TipTool.onCreateToastDialog(b.this.d, JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_content_max_length));
                return;
            }
            if (b.this.g != null) {
                b.this.g.b(b.this.l.getText().toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.report.ui.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnFocusChangeListenerC0399b implements View.OnFocusChangeListener {
        public ViewOnFocusChangeListenerC0399b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                b.this.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            b.this.i();
        }

        @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int i) {
        }
    }

    /* loaded from: classes8.dex */
    public class d implements QuickInputPromptView.b {
        public d() {
        }

        @Override // com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView.b
        public void a(String str, String str2) {
            if (b.this.g != null) {
                b.this.g.a(str, str2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements com.baidu.navisdk.ugc.listener.b {
        public e() {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(String str) {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(c0.a aVar) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReportTruck", "onClickPhotograph(), mPicProcessResInfo = " + aVar);
            }
            if (b.this.o != null) {
                b.this.o.a(aVar.f9222a);
            }
            if (b.this.g != null) {
                b.this.g.c(aVar.f9222a, com.baidu.navisdk.ugc.https.d.a(b.this.m()));
            }
        }
    }

    public b(Activity activity, com.baidu.navisdk.ugc.report.ui.a aVar, boolean z, int i, d.c cVar, int i2) {
        this.d = activity;
        this.e = aVar;
        this.f = i;
        this.g = cVar;
        this.h = i2;
    }

    private void h() {
        this.k.setText("");
        this.l.setText("");
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        g();
        com.baidu.navisdk.ugc.dialog.g.e().a();
    }

    private void j() {
        com.baidu.navisdk.ugc.dialog.g.e().c();
    }

    private Activity k() {
        Context context = this.d;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    private void l() {
        TextView textView = this.k;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        EditText editText = this.l;
        if (editText != null) {
            editText.setOnFocusChangeListener(this.t);
            this.l.addTextChangedListener(this.s);
        }
        View view = this.m;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        com.baidu.navisdk.ugc.report.ui.a aVar = this.e;
        if (aVar == null) {
            return false;
        }
        int e2 = aVar.e();
        if (e2 != 3 && e2 != 2) {
            return false;
        }
        return true;
    }

    private boolean n() {
        com.baidu.navisdk.ugc.report.ui.a aVar = this.e;
        if (aVar == null || aVar.e() != 2) {
            return false;
        }
        return true;
    }

    private void o() {
        EditText editText = this.l;
        if (editText != null) {
            editText.setHint("点击输入详情");
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setHint("点击输入详情");
        }
    }

    private void p() {
        com.baidu.navisdk.ugc.report.ui.a aVar;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
        if (aVar2 == null && (aVar = this.e) != null) {
            aVar2 = aVar.c();
        }
        if (aVar2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar2.h)) {
            c(aVar2.h);
        }
        ArrayList<String> c2 = aVar2.c();
        if (c2 != null && !c2.isEmpty()) {
            UgcInputShowPicLayout ugcInputShowPicLayout = this.o;
            if (ugcInputShowPicLayout != null) {
                ugcInputShowPicLayout.a(c2);
            }
            if (this.g != null) {
                Iterator<String> it = c2.iterator();
                while (it.hasNext()) {
                    this.g.c(it.next(), aVar2.j);
                }
            }
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportTruck", "showExistentData statusPackage.content = " + aVar2.h);
        }
    }

    private void q() {
        com.baidu.navisdk.ugc.dialog.g.e().a();
        if (this.j != null && this.k != null && this.l != null && this.d != null) {
            if (this.n == null) {
                com.baidu.navisdk.ugc.dialog.b bVar = new com.baidu.navisdk.ugc.dialog.b();
                this.n = bVar;
                bVar.c(this.j);
                this.n.b(this.k);
                this.n.a(this.k);
                this.n.a((View) this.l);
                this.n.a(this.l);
                this.n.a(this.h);
                this.n.b(1);
                com.baidu.navisdk.ugc.dialog.b bVar2 = this.n;
                bVar2.i = R.color.ugc_white_color;
                bVar2.a(new c());
                this.n.h.e = new d();
                com.baidu.navisdk.ugc.quickinput.a aVar = this.n.h;
                aVar.b = this.f;
                aVar.g = this.e.n();
            }
            com.baidu.navisdk.ugc.quickinput.a aVar2 = this.n.h;
            aVar2.c = false;
            aVar2.d = false;
            if (this.d != null) {
                com.baidu.navisdk.ugc.dialog.g.e().a(k(), this.n);
            } else {
                g.UGC.e("UgcModule_UgcReportTruck", "UgcReportDetailInputAndPhotoView show input dialog context == null");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ugc_sub_info_fill_content_tv) {
            q();
        } else if (id == R.id.truck_ugc_delete_btn) {
            h();
        }
    }

    private void b(View view) {
        EditText editText;
        this.o = (UgcInputShowPicLayout) view.findViewById(R.id.truck_input_show_pic_layout);
        this.j = view.findViewById(R.id.truck_ugc_input_layout);
        this.k = (TextView) view.findViewById(R.id.ugc_sub_info_fill_content_tv);
        this.l = (EditText) view.findViewById(R.id.ugc_sub_info_fill_content_et);
        this.m = view.findViewById(R.id.truck_ugc_delete_btn);
        this.l.setHintTextColor(Color.parseColor("#999999"));
        this.k.setHintTextColor(Color.parseColor("#999999"));
        if (this.k != null && (editText = this.l) != null) {
            editText.setVisibility(8);
            this.k.setVisibility(0);
        }
        o();
        int measuredWidth = this.i.getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = ScreenUtil.getInstance().getWidthPixels();
        }
        this.o.b(measuredWidth);
        this.o.setListener(this);
        this.o.b();
    }

    private void c(String str) {
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(str);
        }
        EditText editText = this.l;
        if (editText != null) {
            editText.setText(str);
        }
        d.c cVar = this.g;
        if (cVar != null) {
            cVar.b(str);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.c
    public void a(View view) {
        this.i = view;
        Activity k = k();
        Window window = k != null ? k.getWindow() : null;
        if (window != null) {
            this.r = window.getAttributes().softInputMode;
            window.setSoftInputMode(48);
        } else {
            g.UGC.e("UgcModule", "UgcReportDetailInputAndPhotoView get window context is not activity");
        }
        b(view);
        l();
        a((Configuration) null);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void e() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportTruck", "ugc report details input onDestroy");
        }
        j();
        i();
        if (n()) {
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReportTruck", "UgcReportDetailInputAndPhotoView naving onDestroy focus resumeVoiceTTSOutput");
            }
            TTSPlayerControl.resumeVoiceTTSOutput();
            com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
        }
        Activity k = k();
        if (this.r != -1 && k != null && k.getWindow() != null) {
            k.getWindow().setSoftInputMode(this.r);
            this.r = -1;
        }
        EditText editText = this.l;
        if (editText != null) {
            editText.removeTextChangedListener(this.s);
        }
        com.baidu.navisdk.ugc.module.a aVar = this.p;
        if (aVar != null) {
            aVar.a();
            this.p = null;
        }
        UgcInputShowPicLayout ugcInputShowPicLayout = this.o;
        if (ugcInputShowPicLayout != null) {
            ugcInputShowPicLayout.a();
            this.o = null;
        }
        com.baidu.navisdk.ugc.pictures.previews.b bVar = this.q;
        if (bVar != null) {
            bVar.b();
            this.q = null;
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.c
    public int f() {
        if (this.h == 1) {
            return R.layout.nsdk_layout_truck_ugc_report_input_and_photo_view;
        }
        return R.layout.nsdk_layout_truck_ugc_report_input_and_photo_view_land;
    }

    public void g() {
        InputMethodManager inputMethodManager;
        if (this.l == null || (inputMethodManager = (InputMethodManager) com.baidu.navisdk.framework.a.c().a().getSystemService("input_method")) == null || !inputMethodManager.isActive(this.l)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.l.getWindowToken(), 0);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void a(Configuration configuration) {
        i();
        p();
        com.baidu.navisdk.ugc.pictures.previews.b d2 = com.baidu.navisdk.ugc.pictures.previews.b.d();
        this.q = d2;
        if (d2 == null || !d2.a()) {
            return;
        }
        this.q.a(this, (com.baidu.navisdk.ugc.listener.c) null);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ugc.module.a aVar = this.p;
        if (aVar == null || !aVar.a(i)) {
            return;
        }
        this.p.a(i, i2, intent, k());
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public boolean a(int i) {
        com.baidu.navisdk.ugc.module.a aVar = this.p;
        return aVar != null && aVar.a(i);
    }

    private void b(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportTruck", "deletePhoto: " + str);
        }
        d.c cVar = this.g;
        if (cVar != null) {
            cVar.a(str);
        }
        try {
            s.a(str);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.navisdk.ugc.pictures.show.UgcInputShowPicLayout.a
    public void a() {
        if (this.p == null) {
            this.p = new com.baidu.navisdk.ugc.module.a(new e());
        }
        this.p.a(k());
    }

    @Override // com.baidu.navisdk.ugc.pictures.show.UgcInputShowPicLayout.a
    public void a(int i, ArrayList<String> arrayList) {
        g gVar = g.UGC;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onClickPic(), index = ");
            sb.append(i);
            sb.append(" picPathList = ");
            sb.append(arrayList == null ? "null" : Arrays.toString(arrayList.toArray()));
            gVar.e("UgcModule_UgcReportTruck", sb.toString());
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        b(i, arrayList);
    }

    private void b(int i, ArrayList<String> arrayList) {
        if (this.q == null) {
            this.q = new com.baidu.navisdk.ugc.pictures.previews.b();
        }
        this.q.a(this, (com.baidu.navisdk.ugc.listener.c) null);
        this.q.a(k(), arrayList, 1, i, true);
    }

    @Override // com.baidu.navisdk.ugc.pictures.previews.b.e
    public void a(String str, int i) {
        UgcInputShowPicLayout ugcInputShowPicLayout = this.o;
        if (ugcInputShowPicLayout != null) {
            ugcInputShowPicLayout.a(str, i);
            b(str);
        }
    }
}
