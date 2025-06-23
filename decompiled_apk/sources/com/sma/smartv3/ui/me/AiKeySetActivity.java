package com.sma.smartv3.ui.me;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.biz.voice.VoiceManager;
import com.sma.smartv3.co_fit.R;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes11.dex */
public final class AiKeySetActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.AiKeySetActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return AiKeySetActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO etContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.AiKeySetActivity$etContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) AiKeySetActivity.this.findViewById(R.id.et_content);
        }
    });

    private final EditText getEtContent() {
        return (EditText) this.etContent$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.ai_key_set);
        String string = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getString(com.sma.smartv3.util.XoI0Ixx0.f24480xOOOX);
        if (string != null) {
            getEtContent().setText(string);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_key_set;
    }

    public final void onSave(@OXOo.OOXIXo View view) {
        final String str;
        String obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Editable text = getEtContent().getText();
        if (text != null && (obj = text.toString()) != null) {
            str = StringsKt__StringsKt.oIoIXxIO(obj).toString();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24480xOOOX, str);
            finish();
        } else {
            VoiceManager voiceManager = VoiceManager.INSTANCE;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
            voiceManager.openAiCheck(str, new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.AiKeySetActivity$onSave$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str2) {
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24480xOOOX, str);
                    this.finish();
                }
            }, this, getRootView());
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
