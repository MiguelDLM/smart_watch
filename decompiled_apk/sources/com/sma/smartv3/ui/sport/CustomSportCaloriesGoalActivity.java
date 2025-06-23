package com.sma.smartv3.ui.sport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import kotlin.Pair;

/* loaded from: classes12.dex */
public final class CustomSportCaloriesGoalActivity extends BaseCustomSportGoalActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO calEt$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportCaloriesGoalActivity$calEt$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportCaloriesGoalActivity.this.findViewById(R.id.calEt);
        }
    });

    public final EditText getCalEt() {
        return (EditText) this.calEt$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.custom_calories);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_custom_sport_calories_goal;
    }

    @Override // com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity
    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        String obj = getCalEt().getText().toString();
        if (obj.length() > 0) {
            int parseInt = Integer.parseInt(obj);
            if (parseInt == 0) {
                return;
            }
            setResult(-1, new Intent().putExtra(com.sma.smartv3.initializer.IXxxXO.f20858XOxIOxOx, new Pair(obj, Integer.valueOf(parseInt))));
            finish();
            return;
        }
        ToastUtils.showLong(getString(R.string.no_content_set_key), new Object[0]);
    }
}
