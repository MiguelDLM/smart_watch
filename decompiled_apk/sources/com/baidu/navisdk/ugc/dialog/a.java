package com.baidu.navisdk.ugc.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends f implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
    private RelativeLayout c;
    private ViewGroup d;
    private SoftKeyboardStateHelper e;
    private SoftKeyboardStateHelper.SoftKeyboardStateListener f;
    private ViewGroup g;
    private ViewGroup.MarginLayoutParams h;
    private View i;
    private View j;
    private TextView k;
    private View l;
    private EditText m;
    private int n;
    private View o;
    private int p;
    private com.baidu.navisdk.ugc.quickinput.b q;
    private int r;

    /* renamed from: com.baidu.navisdk.ugc.dialog.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0369a implements View.OnClickListener {
        public ViewOnClickListenerC0369a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnShowListener {

        /* renamed from: com.baidu.navisdk.ugc.dialog.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0370a implements Runnable {
            public RunnableC0370a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c();
            }
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (a.this.m != null) {
                a.this.m.post(new RunnableC0370a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.a();
        }
    }

    public a(Activity activity, com.baidu.navisdk.ugc.dialog.b bVar) {
        super(activity, R.style.BNDialog);
        boolean z;
        View view;
        this.n = -1;
        this.f = bVar.f();
        this.i = bVar.e();
        this.j = bVar.d();
        this.k = bVar.c();
        this.l = bVar.b();
        this.m = bVar.a();
        int g = bVar.g();
        this.p = g;
        if (g == 2) {
            z = true;
        } else {
            z = false;
        }
        this.f8029a = z;
        RelativeLayout relativeLayout = (RelativeLayout) JarUtils.inflate(activity, R.layout.nsdk_layout_input_dialog, null);
        this.c = relativeLayout;
        if (relativeLayout != null) {
            int i = R.id.input_container;
            ViewGroup viewGroup = (ViewGroup) relativeLayout.findViewById(i);
            this.d = viewGroup;
            viewGroup.setBackgroundResource(bVar.i);
            SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(activity, this.c);
            this.e = softKeyboardStateHelper;
            softKeyboardStateHelper.addSoftKeyboardStateListener(this);
            View view2 = this.i;
            if (view2 != null && this.d != null) {
                int height = view2.getHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                this.h = marginLayoutParams;
                if (marginLayoutParams == null) {
                    this.h = new ViewGroup.MarginLayoutParams(-1, height);
                }
                if (this.i.getParent() != null && (this.i.getParent() instanceof ViewGroup)) {
                    ViewGroup viewGroup2 = (ViewGroup) this.i.getParent();
                    this.g = viewGroup2;
                    this.n = viewGroup2.indexOfChild(this.i);
                    View view3 = new View(this.i.getContext());
                    this.o = view3;
                    view3.setLayoutParams(this.h);
                    this.g.removeView(this.i);
                    this.g.addView(this.o, this.n);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-1, height);
                ViewGroup.MarginLayoutParams marginLayoutParams3 = this.h;
                marginLayoutParams2.leftMargin = marginLayoutParams3.leftMargin;
                marginLayoutParams2.rightMargin = marginLayoutParams3.rightMargin;
                marginLayoutParams2.bottomMargin = marginLayoutParams3.bottomMargin;
                marginLayoutParams2.topMargin = marginLayoutParams3.topMargin;
                this.d.addView(this.i, marginLayoutParams2);
            }
            if (this.j != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("BNInputDialog", "BNInputDialog(), activity = " + activity + " inputDialogParams = " + bVar);
                }
                this.j.setVisibility(8);
            }
            if (this.q == null) {
                this.q = new com.baidu.navisdk.ugc.quickinput.b();
            }
            this.q.a(activity, this.c, i, bVar.h);
            if (this.m != null && (view = this.l) != null) {
                view.setVisibility(0);
                String obj = this.m.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.m.setSelection(obj.length());
                }
            }
            this.c.setOnClickListener(new ViewOnClickListenerC0369a());
            try {
                setContentView(this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.r = activity.getWindow().getAttributes().softInputMode;
            b();
            setCanceledOnTouchOutside(true);
            setOnShowListener(new b());
            setOnDismissListener(new c());
        }
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        String str;
        View view;
        EditText editText;
        super.dismiss();
        if (this.p == 2) {
            com.baidu.navisdk.ugc.d.a(false);
        }
        SoftKeyboardStateHelper softKeyboardStateHelper = this.e;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.onDestroy();
            this.e = null;
        }
        EditText editText2 = this.m;
        if (editText2 != null && this.l != null) {
            if (editText2.getText() != null && !TextUtils.isEmpty(this.m.getText().toString())) {
                str = this.m.getText().toString().trim();
            } else {
                str = null;
            }
            this.l.setVisibility(8);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("BNInputDialog", "dismiss: inputEtContainer gone");
            }
        } else {
            str = null;
        }
        TextView textView = this.k;
        if (textView != null && this.j != null && (editText = this.m) != null) {
            if (str != null) {
                textView.setText(str);
                this.k.setTextColor(this.m.getCurrentTextColor());
            } else if (editText.getHint() != null) {
                this.k.setText((CharSequence) null);
                this.k.setHint(this.m.getHint());
                this.k.setHintTextColor(this.m.getCurrentHintTextColor());
            }
            this.j.setVisibility(0);
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("BNInputDialog", "dismiss: inputTvContainer visible");
            }
        }
        if (this.g != null && (view = this.i) != null && this.o != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i);
            }
            if (this.h == null) {
                this.h = new ViewGroup.MarginLayoutParams(-1, this.i.getHeight());
            }
            this.g.removeView(this.o);
            this.g.addView(this.i, this.n, this.h);
            this.g = null;
            this.o = null;
            this.h = null;
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar3.d()) {
                gVar3.e("BNInputDialog", "dismiss: remove placeholderView and add  inputView done");
            }
        }
        com.baidu.navisdk.ugc.quickinput.b bVar = this.q;
        if (bVar != null) {
            bVar.a();
            this.q = null;
        }
    }

    @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener = this.f;
        if (softKeyboardStateListener != null) {
            softKeyboardStateListener.onSoftKeyboardClosed();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardOpened(int i) {
        SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener = this.f;
        if (softKeyboardStateListener != null) {
            softKeyboardStateListener.onSoftKeyboardOpened(i);
        }
        com.baidu.navisdk.ugc.quickinput.b bVar = this.q;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.baidu.navisdk.ugc.dialog.f, android.app.Dialog
    public void show() {
        super.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("BNInputDialog", "hideSoftInput: ");
        }
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(this.r);
        }
        if (this.m != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) com.baidu.navisdk.framework.a.c().a().getSystemService("input_method");
            if (inputMethodManager != null && inputMethodManager.isActive(this.m)) {
                inputMethodManager.hideSoftInputFromWindow(this.m.getWindowToken(), 0);
            }
            this.m.clearFocus();
        }
    }

    private void b() {
        Window window = getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        EditText editText;
        if (!isShowing()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("BNInputDialog", "showSoftInput dialog not showing: ");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar2.e()) {
            gVar2.g("BNInputDialog", "showSoftInput: ");
        }
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        InputMethodManager inputMethodManager = (InputMethodManager) com.baidu.navisdk.framework.a.c().a().getSystemService("input_method");
        if (inputMethodManager == null || (editText = this.m) == null) {
            return;
        }
        editText.requestFocus();
        inputMethodManager.toggleSoftInput(0, 2);
    }
}
