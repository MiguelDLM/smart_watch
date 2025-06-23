package com.sma.smartv3.ui.sport;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes12.dex */
public abstract class BaseCustomSportGoalActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO abh_title_right$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity$abh_title_right$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BaseCustomSportGoalActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    /* loaded from: classes12.dex */
    public static final class II0xO0 implements View.OnKeyListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ EditText f23753IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ EditText f23754Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ EditText f23755XO;

        public II0xO0(EditText editText, EditText editText2, EditText editText3) {
            this.f23755XO = editText;
            this.f23754Oo = editText2;
            this.f23753IXxxXO = editText3;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@OXOo.OOXIXo View v, int i, @OXOo.OOXIXo KeyEvent event) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
            kotlin.jvm.internal.IIX0o.x0xO0oo(event, "event");
            if (event.getAction() != 0) {
                return true;
            }
            LogUtils.d("setOnKeyListener   " + i + "  " + event.getAction());
            if (i == 67 && this.f23755XO.getText().toString().length() == 0) {
                this.f23754Oo.requestFocus();
                this.f23754Oo.getText().clear();
                return true;
            }
            if (i != 67 && this.f23755XO.getText().toString().length() > 0) {
                this.f23753IXxxXO.requestFocus();
                this.f23753IXxxXO.onKeyDown(i, event);
            }
            return false;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TextWatcher {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ EditText f23756Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ boolean f23757XO;

        public oIX0oI(boolean z, EditText editText) {
            this.f23757XO = z;
            this.f23756Oo = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
            if (this.f23757XO && !TextUtils.isEmpty(charSequence)) {
                this.f23756Oo.requestFocus();
            }
        }
    }

    public static /* synthetic */ View.OnKeyListener setKeyListener$default(BaseCustomSportGoalActivity baseCustomSportGoalActivity, EditText editText, EditText editText2, EditText editText3, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 8) != 0) {
                z = true;
            }
            return baseCustomSportGoalActivity.setKeyListener(editText, editText2, editText3, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setKeyListener");
    }

    public final ImageView getAbh_title_right() {
        return (ImageView) this.abh_title_right$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbh_title_right().setVisibility(0);
        getAbh_title_right().setImageResource(R.drawable.selector_save_image);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        ToastUtils.showLong("onTitleRightClick", new Object[0]);
    }

    @OXOo.OOXIXo
    public final View.OnKeyListener setKeyListener(@OXOo.OOXIXo EditText leftEdit, @OXOo.OOXIXo EditText middleEdit, @OXOo.OOXIXo EditText rightEdit, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(leftEdit, "leftEdit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(middleEdit, "middleEdit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(rightEdit, "rightEdit");
        middleEdit.addTextChangedListener(new oIX0oI(z, rightEdit));
        return new II0xO0(middleEdit, leftEdit, rightEdit);
    }
}
