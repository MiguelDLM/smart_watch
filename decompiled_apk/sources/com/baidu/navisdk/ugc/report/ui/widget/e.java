package com.baidu.navisdk.ugc.report.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ugc.dialog.h;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.pictures.previews.c;
import com.baidu.navisdk.ugc.quickinput.sugs.QuickInputPromptView;
import com.baidu.navisdk.ugc.report.ui.d;
import com.baidu.navisdk.ugc.video.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper;
import com.baidu.navisdk.util.common.c0;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.o0;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class e extends com.baidu.navisdk.ugc.report.ui.widget.c implements View.OnClickListener, c.a, c.e {
    private boolean A;
    private h.i B;
    private com.baidu.navisdk.ugc.listener.b C;
    private Context d;
    private com.baidu.navisdk.ugc.report.ui.a e;
    private boolean f;
    private int g;
    private d.c h;
    private int i;
    private View j;
    private View k;
    private com.baidu.navisdk.ugc.video.c w;
    private com.baidu.navisdk.ugc.pictures.previews.c x;
    private String y;
    private boolean z;
    private TextView l = null;
    private EditText m = null;
    private ImageView n = null;
    private TextView o = null;
    private View p = null;
    private ImageView q = null;
    private ImageView r = null;
    private ImageView s = null;
    private com.baidu.navisdk.ugc.dialog.b t = null;
    private com.baidu.navisdk.ugc.dialog.h u = null;
    private boolean v = false;
    private int D = -1;
    TextWatcher E = new a();
    private View.OnFocusChangeListener F = new b();

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
            if (e.this.n != null) {
                if (editable.length() > 0) {
                    e.this.n.setVisibility(0);
                    e.this.n.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_sub_info_fill_sounds_deleted_icon));
                } else {
                    if (e.this.z) {
                        e.this.n.setVisibility(8);
                    }
                    e.this.n.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_sub_info_fill_sounds_icon));
                }
            }
            if (z) {
                try {
                    e.this.m.setText(e.this.m.getText().toString().substring(0, 40));
                    e.this.m.setSelection(40);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                TipTool.onCreateToastDialog(e.this.d, JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_content_max_length));
                return;
            }
            if (e.this.h != null) {
                e.this.h.b(e.this.m.getText().toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                e.this.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public c() {
        }

        @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            e.this.j();
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
            if (e.this.h != null) {
                e.this.h.a(str, str2);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.report.ui.widget.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0400e implements o0.b {
        public C0400e() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public void a(int i, boolean z, ArrayList<String> arrayList) {
            if (i == 3003) {
                if (z) {
                    e.this.E();
                } else {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "没有麦克风权限，请打开后重试");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements h.i {
        public g() {
        }

        @Override // com.baidu.navisdk.ugc.dialog.h.i
        public void a(int i, String str, boolean z) {
            if (z) {
                if (i >= 1) {
                    e.this.c(i);
                    if (e.this.h != null) {
                        e.this.h.a(str, i);
                    }
                } else {
                    TipTool.onCreateToastDialog(e.this.d, "录音时间过短");
                }
            }
            e.this.l();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements h.InterfaceC0371h {
        public h() {
        }

        @Override // com.baidu.navisdk.ugc.dialog.h.InterfaceC0371h
        public boolean a() {
            return e.this.A;
        }
    }

    public e(Activity activity, com.baidu.navisdk.ugc.report.ui.a aVar, boolean z, int i, d.c cVar, int i2) {
        this.z = false;
        this.A = false;
        this.d = activity;
        this.e = aVar;
        this.f = z;
        this.g = i;
        this.h = cVar;
        this.i = i2;
        this.z = r();
        this.A = false;
    }

    private void A() {
        if (this.u != null && s()) {
            this.u.a(new h());
        }
    }

    private void B() {
        boolean z;
        com.baidu.navisdk.ugc.report.ui.a aVar;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
        if (aVar2 == null && (aVar = this.e) != null) {
            aVar2 = aVar.c();
        }
        if (aVar2 == null) {
            return;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(aVar2.h)) {
            c(aVar2.h);
            b(aVar2.h);
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.isEmpty(aVar2.i)) {
            String str = aVar2.i;
            this.y = str;
            try {
                b(BitmapFactory.decodeFile(str));
                this.h.b(aVar2.i, aVar2.j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (com.baidu.navisdk.ugc.dialog.g.e().d()) {
                o();
                com.baidu.navisdk.ugc.dialog.g.e().a(this.C);
            }
            z2 = false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "UgcReportDetailInputAndPhotoViewstatusPackage.voicePath = " + aVar2.n + ", statusPackage.recordTime = " + aVar2.W);
        }
        if (!TextUtils.isEmpty(aVar2.n)) {
            if (z) {
                this.h.a("", -1);
            } else {
                c(aVar2.W);
                this.h.a(aVar2.n, aVar2.W);
            }
        } else if (!z && t()) {
            p();
            com.baidu.navisdk.ugc.dialog.h hVar = this.u;
            if (hVar != null) {
                hVar.a(this.B);
            }
            A();
        }
        if (!z2 && aVar2.e()) {
            a(aVar2.U);
            c(BitmapFactory.decodeFile(aVar2.U.b));
            this.h.a(aVar2.U);
        }
    }

    private void C() {
        com.baidu.navisdk.ugc.dialog.g.e().a();
        if (this.k != null && this.l != null && this.m != null && this.d != null) {
            if (this.t == null) {
                com.baidu.navisdk.ugc.dialog.b bVar = new com.baidu.navisdk.ugc.dialog.b();
                this.t = bVar;
                bVar.c(this.k);
                this.t.b(this.l);
                this.t.a(this.l);
                this.t.a((View) this.m);
                this.t.a(this.m);
                this.t.a(this.i);
                this.t.b(1);
                this.t.a(new c());
                this.t.h.e = new d();
                com.baidu.navisdk.ugc.quickinput.a aVar = this.t.h;
                aVar.b = this.g;
                aVar.g = this.e.n();
            }
            this.t.h.c = true ^ this.f;
            if (this.d != null) {
                com.baidu.navisdk.ugc.dialog.g.e().a(m(), this.t);
                return;
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.c("UgcModule", "UgcReportDetailInputAndPhotoView show input dialog context == null");
            }
        }
    }

    private void D() {
        TextView textView;
        if (this.o != null && (textView = this.l) != null && this.n != null && this.m != null) {
            if (this.v) {
                textView.setVisibility(0);
                this.m.setVisibility(8);
            }
            this.v = false;
            this.l.setText("");
            this.m.setText("");
            z();
            y();
            this.o.setVisibility(8);
            if (this.z) {
                this.n.setVisibility(8);
            }
            this.n.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_sub_info_fill_sounds_icon));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        l();
        this.u = new com.baidu.navisdk.ugc.dialog.h(m(), 1);
        p();
        this.u.a(this.B);
        A();
        this.u.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.baidu.navisdk.ugc.dialog.h hVar = this.u;
        if (hVar != null && hVar.isShowing()) {
            this.u.dismiss();
            this.u = null;
        }
    }

    private Activity m() {
        Context context = this.d;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    private void n() {
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.n;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        TextView textView = this.l;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        EditText editText = this.m;
        if (editText != null) {
            editText.setOnFocusChangeListener(this.F);
            this.m.addTextChangedListener(this.E);
        }
        ImageView imageView3 = this.q;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
    }

    private void o() {
        if (this.C == null) {
            this.C = new f();
        }
    }

    private void p() {
        this.B = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        com.baidu.navisdk.ugc.report.ui.a aVar = this.e;
        if (aVar == null) {
            return false;
        }
        int e = aVar.e();
        if (e != 3 && e != 2) {
            return false;
        }
        return true;
    }

    private boolean r() {
        return true;
    }

    private boolean s() {
        com.baidu.navisdk.ugc.report.ui.a aVar = this.e;
        if (aVar == null || aVar.e() != 2) {
            return false;
        }
        return true;
    }

    private boolean t() {
        com.baidu.navisdk.ugc.dialog.h a2 = com.baidu.navisdk.ugc.dialog.h.a();
        this.u = a2;
        if (a2 != null && a2.isShowing()) {
            return true;
        }
        return false;
    }

    private void u() {
        if (this.e == null) {
            return;
        }
        o();
        if (this.e instanceof com.baidu.navisdk.ugc.report.ui.innavi.sub.c) {
            if (this.f) {
                com.baidu.navisdk.ugc.dialog.g.e().a(m(), 17, this.C, 1);
            } else {
                a((e.b) null);
                com.baidu.navisdk.ugc.dialog.g.e().a(m(), 257, this.C, this.w, 1);
            }
        }
    }

    private void v() {
        if (!n0.a(this.d, "android.permission.RECORD_AUDIO")) {
            o0.b().a(3003, new C0400e());
        } else {
            E();
        }
    }

    private void w() {
        if (this.x == null) {
            this.x = new com.baidu.navisdk.ugc.pictures.previews.c(this);
        }
        this.x.a(m(), this.y, 1);
    }

    private void x() {
        com.baidu.navisdk.ugc.video.c cVar = this.w;
        if (cVar != null) {
            cVar.a(m());
        }
    }

    private void y() {
        if (this.m != null) {
            if (com.baidu.navisdk.ugc.report.data.datarepository.d.i().a(this.g)) {
                if (this.g == 15) {
                    if (this.i == 1) {
                        this.m.setRawInputType(2);
                    }
                    this.m.setHint("请输入其他速度或描述...");
                    return;
                }
                this.m.setHint("以上选项说不清，可以在这里吐槽...");
                return;
            }
            this.m.setHint("以上选项说不清，可以在这里吐槽...");
        }
    }

    private void z() {
        if (this.l != null) {
            if (com.baidu.navisdk.ugc.report.data.datarepository.d.i().a(this.g)) {
                if (this.g == 15) {
                    this.l.setHint("请输入其他速度或描述...");
                    return;
                } else {
                    this.l.setHint("以上选项说不清，可以在这里吐槽...");
                    return;
                }
            }
            this.l.setHint("以上选项说不清，可以在这里吐槽...");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        EditText editText;
        int id = view.getId();
        if (id == R.id.ugc_sub_info_fill_photo_iv) {
            j();
            u();
            return;
        }
        if (id == R.id.ugc_sub_photo_show_iv) {
            ImageView imageView = this.s;
            if (imageView != null && imageView.getVisibility() == 0) {
                x();
                return;
            } else {
                w();
                return;
            }
        }
        if (id == R.id.ugc_sub_info_fill_sounds_iv) {
            TextView textView2 = this.o;
            if (textView2 != null && textView2.getVisibility() == 8 && (textView = this.l) != null && TextUtils.isEmpty(textView.getText()) && (editText = this.m) != null && TextUtils.isEmpty(editText.getText())) {
                j();
                v();
                return;
            } else {
                h();
                return;
            }
        }
        if (id == R.id.ugc_sub_info_fill_content_tv) {
            C();
        }
    }

    private void b(View view) {
        ImageView imageView;
        EditText editText;
        this.l = (TextView) view.findViewById(R.id.ugc_sub_info_fill_content_tv);
        this.m = (EditText) view.findViewById(R.id.ugc_sub_info_fill_content_et);
        this.n = (ImageView) view.findViewById(R.id.ugc_sub_info_fill_sounds_iv);
        this.o = (TextView) view.findViewById(R.id.ugc_sub_sounds_content_tv);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.ugc_sub_info_fill_photo_iv);
        this.r = imageView2;
        imageView2.setVisibility(j.d() ? 0 : 8);
        this.p = view.findViewById(R.id.ugc_sub_photo_show_layout);
        this.q = (ImageView) view.findViewById(R.id.ugc_sub_photo_show_iv);
        this.s = (ImageView) view.findViewById(R.id.ugc_sub_photo_show_play_video_iv);
        this.m.setHintTextColor(Color.parseColor("#999999"));
        this.l.setHintTextColor(Color.parseColor("#999999"));
        if (this.l != null && (editText = this.m) != null) {
            editText.setVisibility(8);
            this.l.setVisibility(0);
        }
        y();
        z();
        if (!this.z || (imageView = this.n) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        TextView textView;
        if (this.o == null || this.m == null || this.n == null || (textView = this.l) == null) {
            return;
        }
        this.v = true;
        textView.setVisibility(8);
        this.m.setVisibility(8);
        this.o.setVisibility(0);
        this.n.setImageDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_ugc_sub_info_fill_sounds_deleted_icon));
        this.o.setText(Html.fromHtml("语音描述  <font color=\"#3a86fd\"> " + i + " \""));
    }

    private void h() {
        D();
        this.h.a("", -1);
    }

    private void i() {
        ImageView imageView;
        if (this.p != null && this.r != null && (imageView = this.q) != null) {
            imageView.setImageDrawable(null);
            this.p.setVisibility(8);
            this.r.setVisibility(0);
            this.s.setVisibility(8);
        }
        d.c cVar = this.h;
        if (cVar != null) {
            cVar.a((e.b) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        g();
        com.baidu.navisdk.ugc.dialog.g.e().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.baidu.navisdk.ugc.dialog.g.e().c();
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void d() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_UgcReport", "onDeleteVideo");
        }
        i();
        d.c cVar = this.h;
        if (cVar != null) {
            cVar.a((e.b) null);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void e() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_UgcReport", "ugc report details input onDestroy");
        }
        this.A = true;
        k();
        l();
        j();
        Activity m = m();
        if (this.D != -1 && m != null && m.getWindow() != null) {
            m.getWindow().setSoftInputMode(this.D);
            this.D = -1;
        }
        ImageView imageView = this.q;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        com.baidu.navisdk.ugc.video.c cVar = this.w;
        if (cVar != null) {
            cVar.a();
            this.w = null;
        } else if (s()) {
            if (gVar.e()) {
                gVar.g("UgcModule_UgcReport", "UgcReportDetailInputAndPhotoView naving onDestroy focus resumeVoiceTTSOutput");
            }
            TTSPlayerControl.resumeVoiceTTSOutput();
            com.baidu.navisdk.ugc.utils.e.f8333a.a(com.baidu.navisdk.framework.a.c().a());
        }
        com.baidu.navisdk.ugc.pictures.previews.c cVar2 = this.x;
        if (cVar2 != null) {
            cVar2.c();
            this.x = null;
        }
        this.y = null;
        EditText editText = this.m;
        if (editText != null) {
            editText.removeTextChangedListener(this.E);
        }
        this.B = null;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.c
    public int f() {
        if (this.i == 1) {
            return R.layout.nsdk_layout_ugc_report_sub_detail_input_and_photo_view;
        }
        return R.layout.nsdk_layout_ugc_report_sub_detail_input_and_photo_view_land;
    }

    public void g() {
        InputMethodManager inputMethodManager;
        if (this.m == null || (inputMethodManager = (InputMethodManager) com.baidu.navisdk.framework.a.c().a().getSystemService("input_method")) == null || !inputMethodManager.isActive(this.m)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.m.getWindowToken(), 0);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.c
    public void a(View view) {
        this.j = view;
        this.k = view.findViewById(R.id.ugc_sub_input_and_photo);
        Activity m = m();
        Window window = m != null ? m.getWindow() : null;
        if (window != null) {
            this.D = window.getAttributes().softInputMode;
            window.setSoftInputMode(48);
        } else {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule", "UgcReportDetailInputAndPhotoView get window context is not activity");
        }
        b(view);
        n();
        a((Configuration) null);
    }

    /* loaded from: classes8.dex */
    public class f implements com.baidu.navisdk.ugc.listener.b {
        public f() {
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(c0.a aVar) {
            if (aVar == null) {
                return;
            }
            e.this.b(aVar.b);
            e.this.k();
            e.this.y = aVar.f9222a;
            e.this.h.b(aVar.f9222a, com.baidu.navisdk.ugc.https.d.a(e.this.q()));
        }

        @Override // com.baidu.navisdk.ugc.listener.b
        public void a(String str) {
            e.this.k();
            e.this.y = null;
        }
    }

    private void c(String str) {
        TextView textView;
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setText(str);
        }
        d.c cVar = this.h;
        if (cVar == null || (textView = this.l) == null) {
            return;
        }
        cVar.b(textView.getText().toString());
    }

    private void a(e.b bVar) {
        if (this.w == null) {
            com.baidu.navisdk.ugc.video.c cVar = new com.baidu.navisdk.ugc.video.c(s());
            this.w = cVar;
            cVar.a(this);
        }
        if (bVar != null) {
            com.baidu.navisdk.ugc.video.c cVar2 = this.w;
            cVar2.c = bVar.c;
            cVar2.f8345a = bVar.f8076a;
            cVar2.b = bVar.b;
        }
    }

    private void c(Bitmap bitmap) {
        if (bitmap != null) {
            this.p.setVisibility(0);
            this.r.setVisibility(8);
            this.q.setImageBitmap(bitmap);
            this.s.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void c() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Bitmap bitmap) {
        View view = this.p;
        if (view == null || this.q == null || this.r == null || bitmap == null) {
            return;
        }
        view.setVisibility(0);
        this.r.setVisibility(8);
        this.q.setImageBitmap(bitmap);
        this.s.setVisibility(8);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void a(Configuration configuration) {
        j();
        B();
        com.baidu.navisdk.ugc.pictures.previews.c e = com.baidu.navisdk.ugc.pictures.previews.c.e();
        this.x = e;
        if (e == null || !e.b()) {
            return;
        }
        this.x.a(this, (com.baidu.navisdk.ugc.listener.c) null);
    }

    private void b(String str) {
        EditText editText;
        EditText editText2 = this.m;
        if (editText2 != null) {
            editText2.setText(str);
        }
        d.c cVar = this.h;
        if (cVar == null || (editText = this.m) == null) {
            return;
        }
        cVar.b(editText.getText().toString());
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "onActivityResult: " + i + "," + i2);
        }
        com.baidu.navisdk.ugc.video.c cVar = this.w;
        if (cVar != null && cVar.a(i)) {
            this.w.b(i2, intent);
        } else if (com.baidu.navisdk.ugc.dialog.g.e().a(i)) {
            com.baidu.navisdk.ugc.dialog.g.e().a(i, i2, intent);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.widget.a
    public boolean a(int i) {
        com.baidu.navisdk.ugc.video.c cVar = this.w;
        return (cVar != null && cVar.a(i)) || com.baidu.navisdk.ugc.dialog.g.e().a(i);
    }

    @Override // com.baidu.navisdk.ugc.video.c.a
    public void a(Bitmap bitmap) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "onVideoRecordSuccess");
        }
        k();
        c(bitmap);
        if (this.h != null) {
            e.b bVar = new e.b();
            com.baidu.navisdk.ugc.video.c cVar = this.w;
            bVar.f8076a = cVar.f8345a;
            bVar.b = cVar.b;
            bVar.c = cVar.c;
            this.h.a(bVar);
        }
    }

    @Override // com.baidu.navisdk.ugc.pictures.previews.c.e
    public void a(String str) {
        View view = this.p;
        if (view != null && this.r != null) {
            view.setVisibility(8);
            this.r.setVisibility(0);
            this.q.setImageDrawable(null);
        }
        this.h.b("", "");
        this.y = null;
    }
}
