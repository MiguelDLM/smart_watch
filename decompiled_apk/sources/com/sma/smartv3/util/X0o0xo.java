package com.sma.smartv3.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.text.Regex;

@kotlin.jvm.internal.XX({"SMAP\nBytesLimitTextWatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BytesLimitTextWatcher.kt\ncom/sma/smartv3/util/BytesLimitInputTextWatcher\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,52:1\n107#2:53\n79#2,22:54\n*S KotlinDebug\n*F\n+ 1 BytesLimitTextWatcher.kt\ncom/sma/smartv3/util/BytesLimitInputTextWatcher\n*L\n39#1:53\n39#1:54,22\n*E\n"})
/* loaded from: classes12.dex */
public class X0o0xo implements TextWatcher {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f24324IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f24325Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final EditText f24326XO;

    public X0o0xo(@OXOo.OOXIXo EditText et, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(et, "et");
        this.f24326XO = et;
        this.f24325Oo = i;
        this.f24324IXxxXO = "[^a-zA-Z0-9一-龥]";
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
        int i;
        boolean z;
        if (editable != null) {
            String oIX0oI2 = oIX0oI(this.f24324IXxxXO, editable.toString());
            this.f24326XO.removeTextChangedListener(this);
            int length = editable.toString().length();
            int length2 = oIX0oI2.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length2) {
                if (!z2) {
                    i = i2;
                } else {
                    i = length2;
                }
                if (kotlin.jvm.internal.IIX0o.oI0IIXIo(oIX0oI2.charAt(i), 32) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z2) {
                    if (!z) {
                        z2 = true;
                    } else {
                        i2++;
                    }
                } else if (!z) {
                    break;
                } else {
                    length2--;
                }
            }
            editable.replace(0, length, oIX0oI2.subSequence(i2, length2 + 1).toString());
            this.f24326XO.addTextChangedListener(this);
        }
        while (true) {
            String valueOf = String.valueOf(editable);
            Charset UTF_8 = StandardCharsets.UTF_8;
            kotlin.jvm.internal.IIX0o.oO(UTF_8, "UTF_8");
            byte[] bytes = valueOf.getBytes(UTF_8);
            kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
            if (bytes.length > this.f24325Oo) {
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

    public final String oIX0oI(String str, String str2) {
        return new Regex(str).replace(str2, "");
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
    }
}
