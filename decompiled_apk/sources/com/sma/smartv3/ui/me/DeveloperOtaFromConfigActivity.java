package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.BatchOtaConfig;
import java.io.Serializable;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperOtaFromConfigActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperOtaFromConfigActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaFromConfigActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n69#2,3:48\n72#2,5:52\n1#3:51\n*S KotlinDebug\n*F\n+ 1 DeveloperOtaFromConfigActivity.kt\ncom/sma/smartv3/ui/me/DeveloperOtaFromConfigActivity\n*L\n40#1:48,3\n40#1:52,5\n40#1:51\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperOtaFromConfigActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEtContent$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.me.DeveloperOtaFromConfigActivity$mEtContent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) DeveloperOtaFromConfigActivity.this.findViewById(R.id.et_content);
        }
    });

    private final EditText getMEtContent() {
        return (EditText) this.mEtContent$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_ota_from_config;
    }

    public final void onStart(@OXOo.OOXIXo View v) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(v, "v");
        String obj2 = getMEtContent().getText().toString();
        if (obj2.length() == 0) {
            return;
        }
        try {
            byte[] base64Decode = EncodeUtils.base64Decode(obj2);
            kotlin.jvm.internal.IIX0o.oO(base64Decode, "base64Decode(...)");
            obj = new Gson().fromJson(new String(base64Decode, kotlin.text.oxoX.f29581II0xO0), (Class<Object>) BatchOtaConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showLong("Format error！", new Object[0]);
            obj = null;
        }
        if (obj != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("otaConfig", (Serializable) obj);
            Intent intent = new Intent(this, (Class<?>) DeveloperOtaStartActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
