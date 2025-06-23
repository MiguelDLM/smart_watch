package com.sma.smartv3.util;

import android.text.Editable;
import android.text.TextWatcher;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes12.dex */
public class XO implements TextWatcher {

    /* renamed from: XO, reason: collision with root package name */
    public final int f24340XO;

    public XO(int i) {
        this.f24340XO = i;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
        while (true) {
            String valueOf = String.valueOf(editable);
            Charset UTF_8 = StandardCharsets.UTF_8;
            kotlin.jvm.internal.IIX0o.oO(UTF_8, "UTF_8");
            byte[] bytes = valueOf.getBytes(UTF_8);
            kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
            if (bytes.length > this.f24340XO) {
                if (editable != null) {
                    editable.delete(editable.length() - 1, editable.length());
                }
            } else {
                return;
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
    }
}
