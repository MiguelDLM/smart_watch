package com.baidu.navisdk.ugc.dialog;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.SoftKeyboardStateHelper;
import java.util.Locale;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private View f8024a;
    private View b;
    private TextView c;
    private View d;
    private EditText e;
    private SoftKeyboardStateHelper.SoftKeyboardStateListener f;
    private int g = 0;
    public com.baidu.navisdk.ugc.quickinput.a h = new com.baidu.navisdk.ugc.quickinput.a();

    @DrawableRes
    public int i = R.color.ugc_rg_transparent;

    public void a(TextView textView) {
        this.c = textView;
    }

    public void b(View view) {
        this.b = view;
    }

    public void c(View view) {
        this.f8024a = view;
    }

    public View d() {
        return this.b;
    }

    public View e() {
        return this.f8024a;
    }

    public SoftKeyboardStateHelper.SoftKeyboardStateListener f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public void a(View view) {
        this.d = view;
    }

    public View b() {
        return this.d;
    }

    public TextView c() {
        return this.c;
    }

    public EditText a() {
        return this.e;
    }

    public void b(int i) {
        this.g = i;
        this.h.f = i;
    }

    public void a(EditText editText) {
        this.e = editText;
        this.h.h = editText;
    }

    public void a(SoftKeyboardStateHelper.SoftKeyboardStateListener softKeyboardStateListener) {
        this.f = softKeyboardStateListener;
    }

    public void a(int i) {
        if (i != 1 && i != 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c()) {
                gVar.e("UgcModule_Others", String.format(Locale.getDefault(), "BNInputDialogParams orientation value is %d, the value must %d or %d", Integer.valueOf(i), 1, 2));
                return;
            }
            return;
        }
        this.h.f8220a = i;
    }
}
