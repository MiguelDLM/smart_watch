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
public final class CustomSportTimeGoalActivity extends BaseCustomSportGoalActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO time1Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportTimeGoalActivity$time1Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportTimeGoalActivity.this.findViewById(R.id.time1Et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO time2Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportTimeGoalActivity$time2Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportTimeGoalActivity.this.findViewById(R.id.time2Et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO time3Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportTimeGoalActivity$time3Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportTimeGoalActivity.this.findViewById(R.id.time3Et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO time4Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportTimeGoalActivity$time4Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportTimeGoalActivity.this.findViewById(R.id.time4Et);
        }
    });

    public final EditText getTime1Et() {
        return (EditText) this.time1Et$delegate.getValue();
    }

    public final EditText getTime2Et() {
        return (EditText) this.time2Et$delegate.getValue();
    }

    public final EditText getTime3Et() {
        return (EditText) this.time3Et$delegate.getValue();
    }

    public final EditText getTime4Et() {
        return (EditText) this.time4Et$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.custom_duration);
        EditText time1Et = getTime1Et();
        EditText time1Et2 = getTime1Et();
        kotlin.jvm.internal.IIX0o.oO(time1Et2, "<get-time1Et>(...)");
        EditText time1Et3 = getTime1Et();
        kotlin.jvm.internal.IIX0o.oO(time1Et3, "<get-time1Et>(...)");
        EditText time2Et = getTime2Et();
        kotlin.jvm.internal.IIX0o.oO(time2Et, "<get-time2Et>(...)");
        time1Et.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, time1Et2, time1Et3, time2Et, false, 8, null));
        EditText time2Et2 = getTime2Et();
        EditText time1Et4 = getTime1Et();
        kotlin.jvm.internal.IIX0o.oO(time1Et4, "<get-time1Et>(...)");
        EditText time2Et3 = getTime2Et();
        kotlin.jvm.internal.IIX0o.oO(time2Et3, "<get-time2Et>(...)");
        EditText time3Et = getTime3Et();
        kotlin.jvm.internal.IIX0o.oO(time3Et, "<get-time3Et>(...)");
        time2Et2.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, time1Et4, time2Et3, time3Et, false, 8, null));
        EditText time3Et2 = getTime3Et();
        EditText time2Et4 = getTime2Et();
        kotlin.jvm.internal.IIX0o.oO(time2Et4, "<get-time2Et>(...)");
        EditText time3Et3 = getTime3Et();
        kotlin.jvm.internal.IIX0o.oO(time3Et3, "<get-time3Et>(...)");
        EditText time4Et = getTime4Et();
        kotlin.jvm.internal.IIX0o.oO(time4Et, "<get-time4Et>(...)");
        time3Et2.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, time2Et4, time3Et3, time4Et, false, 8, null));
        EditText time4Et2 = getTime4Et();
        EditText time3Et4 = getTime3Et();
        kotlin.jvm.internal.IIX0o.oO(time3Et4, "<get-time3Et>(...)");
        EditText time4Et3 = getTime4Et();
        kotlin.jvm.internal.IIX0o.oO(time4Et3, "<get-time4Et>(...)");
        EditText time4Et4 = getTime4Et();
        kotlin.jvm.internal.IIX0o.oO(time4Et4, "<get-time4Et>(...)");
        time4Et2.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, time3Et4, time4Et3, time4Et4, false, 8, null));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_custom_sport_time_goal;
    }

    @Override // com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity
    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        String obj = getTime1Et().getText().toString();
        String obj2 = getTime2Et().getText().toString();
        String obj3 = getTime3Et().getText().toString();
        String obj4 = getTime4Et().getText().toString();
        if (obj.length() == 0) {
            obj = "0";
        }
        if (obj2.length() == 0) {
            obj2 = "0";
        }
        if (obj3.length() == 0) {
            obj3 = "0";
        }
        if (obj4.length() == 0) {
            obj4 = "0";
        }
        String str = obj + obj2 + ':' + obj3 + obj4;
        int parseInt = (Integer.parseInt(obj) * 36000) + (Integer.parseInt(obj2) * 3600) + (Integer.parseInt(obj3) * 600) + (Integer.parseInt(obj4) * 60);
        if (parseInt == 0) {
            ToastUtils.showLong(getString(R.string.no_content_set_key), new Object[0]);
        } else {
            setResult(-1, new Intent().putExtra(com.sma.smartv3.initializer.IXxxXO.f20858XOxIOxOx, new Pair(str, Integer.valueOf(parseInt))));
            finish();
        }
    }
}
