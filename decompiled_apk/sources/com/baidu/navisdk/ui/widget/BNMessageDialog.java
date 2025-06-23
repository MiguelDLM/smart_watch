package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.a;
import com.baidu.navisdk.ui.util.b;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class BNMessageDialog extends BNBaseDialog {
    private EditText mEditText;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private TextView mTextView;

    public BNMessageDialog(Activity activity) {
        super(activity);
        this.mOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.navisdk.ui.widget.BNMessageDialog.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    ((InputMethodManager) a.c().a().getSystemService("input_method")).hideSoftInputFromWindow(((EditText) view).getWindowToken(), 0);
                }
            }
        };
        View inflate = JarUtils.inflate(activity, R.layout.nsdk_layout_message_dialog, null);
        if (inflate != null) {
            this.mTextView = (TextView) inflate.findViewById(R.id.text_view);
            EditText editText = (EditText) inflate.findViewById(R.id.edit_text);
            this.mEditText = editText;
            editText.setOnFocusChangeListener(this.mOnFocusChangeListener);
            setContent(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String strFilter(String str, String str2) {
        return Pattern.compile(str2).matcher(str).replaceAll("").trim();
    }

    public String getEditTextMessage() {
        return this.mEditText.getText().toString();
    }

    public TextView getMessageView() {
        return this.mTextView;
    }

    public void setEditTextFocus(boolean z) {
        this.mEditText.setFocusable(z);
    }

    public BNMessageDialog setEditTextMessage(String str) {
        this.mTextView.setVisibility(8);
        this.mEditText.setVisibility(0);
        this.mEditText.setText(str, TextView.BufferType.SPANNABLE);
        return this;
    }

    public BNMessageDialog setEditTextMessageHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mEditText.getLayoutParams();
        layoutParams.height = i;
        this.mEditText.setLayoutParams(layoutParams);
        return this;
    }

    public BNMessageDialog setEditTextMessageWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.mEditText.getLayoutParams();
        layoutParams.width = i;
        this.mEditText.setLayoutParams(layoutParams);
        return this;
    }

    public BNMessageDialog setFilter(InputFilter[] inputFilterArr) {
        this.mEditText.setFilters(inputFilterArr);
        return this;
    }

    public BNMessageDialog setLastSelection() {
        this.mEditText.setSelection(getEditTextMessage().length());
        return this;
    }

    public BNMessageDialog setMessage(String str) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setVisibility(0);
            this.mTextView.setText(str, TextView.BufferType.SPANNABLE);
        }
        EditText editText = this.mEditText;
        if (editText != null) {
            editText.setVisibility(8);
        }
        return this;
    }

    public BNMessageDialog setMessageGravity(int i) {
        this.mTextView.setGravity(i);
        return this;
    }

    public BNMessageDialog setMessageHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
        layoutParams.height = i;
        this.mTextView.setLayoutParams(layoutParams);
        return this;
    }

    public BNMessageDialog setMessageWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
        layoutParams.width = i;
        this.mTextView.setLayoutParams(layoutParams);
        return this;
    }

    public BNMessageDialog setStringFilter(final String str) {
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.navisdk.ui.widget.BNMessageDialog.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String obj = BNMessageDialog.this.mEditText.getText().toString();
                String strFilter = BNMessageDialog.this.strFilter(obj, str);
                if (!obj.equals(strFilter)) {
                    BNMessageDialog.this.mEditText.setText(strFilter);
                    BNMessageDialog.this.mEditText.setSelection(strFilter.length());
                }
            }
        });
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog, android.app.Dialog
    public void show() {
        if (this.isSupportDayNight) {
            TextView textView = this.mTextView;
            int i = R.color.nsdk_common_color_dialog_content_text;
            textView.setTextColor(b.b(i));
            this.mEditText.setTextColor(b.b(i));
        }
        super.show();
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog enableBackKey(boolean z) {
        super.enableBackKey(z);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setContent(View view) {
        super.setContent(view);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setContentHeight(int i) {
        super.setContentHeight(i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setContentWidth(int i) {
        super.setContentWidth(i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setFirstBtnEnabled(boolean z) {
        super.setFirstBtnEnabled(z);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setFirstBtnText(String str) {
        super.setFirstBtnText(str);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setOnFirstBtnClickListener(BNBaseDialog.OnNaviClickListener onNaviClickListener) {
        super.setOnFirstBtnClickListener(onNaviClickListener);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setOnSecondBtnClickListener(BNBaseDialog.OnNaviClickListener onNaviClickListener) {
        super.setOnSecondBtnClickListener(onNaviClickListener);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setSecondBtnEnabled(boolean z) {
        super.setSecondBtnEnabled(z);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setSecondBtnText(String str) {
        super.setSecondBtnText(str);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setSecondBtnTextColor(int i) {
        super.setSecondBtnTextColor(i);
        return this;
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseDialog
    public BNMessageDialog setTitleText(String str) {
        super.setTitleText(str);
        return this;
    }
}
