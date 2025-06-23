package com.tenmeter.smlibrary.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes13.dex */
public class StringTextWatcher implements TextWatcher {
    private EditText editText;
    private int length;

    public StringTextWatcher(int i, EditText editText) {
        this.length = i;
        this.editText = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int selectionEnd = this.editText.getSelectionEnd();
        this.editText.removeTextChangedListener(this);
        while (StringUtil.counterChars(editable.toString()) > this.length && selectionEnd > 0) {
            editable.delete(selectionEnd - 1, selectionEnd);
            selectionEnd--;
        }
        this.editText.setSelection(selectionEnd);
        this.editText.addTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
