package com.sma.smartv3.ui.sport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import kotlin.Pair;

@kotlin.jvm.internal.XX({"SMAP\nCustomSportDistanceGoalActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomSportDistanceGoalActivity.kt\ncom/sma/smartv3/ui/sport/CustomSportDistanceGoalActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,80:1\n19#2:81\n15#2:82\n*S KotlinDebug\n*F\n+ 1 CustomSportDistanceGoalActivity.kt\ncom/sma/smartv3/ui/sport/CustomSportDistanceGoalActivity\n*L\n27#1:81\n27#1:82\n*E\n"})
/* loaded from: classes12.dex */
public final class CustomSportDistanceGoalActivity extends BaseCustomSportGoalActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distance1Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportDistanceGoalActivity$distance1Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportDistanceGoalActivity.this.findViewById(R.id.distance1Et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distance2Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportDistanceGoalActivity$distance2Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportDistanceGoalActivity.this.findViewById(R.id.distance2Et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distance3Et$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<EditText>() { // from class: com.sma.smartv3.ui.sport.CustomSportDistanceGoalActivity$distance3Et$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final EditText invoke() {
            return (EditText) CustomSportDistanceGoalActivity.this.findViewById(R.id.distance3Et);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceUtil$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.CustomSportDistanceGoalActivity$tvDistanceUtil$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) CustomSportDistanceGoalActivity.this.findViewById(R.id.distanceUnit);
        }
    });

    @OXOo.OOXIXo
    private final AppUser userProfile;

    public CustomSportDistanceGoalActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final TextView getTvDistanceUtil() {
        return (TextView) this.tvDistanceUtil$delegate.getValue();
    }

    public final EditText getDistance1Et() {
        return (EditText) this.distance1Et$delegate.getValue();
    }

    public final EditText getDistance2Et() {
        return (EditText) this.distance2Et$delegate.getValue();
    }

    public final EditText getDistance3Et() {
        return (EditText) this.distance3Et$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.custom_distance);
        EditText distance1Et = getDistance1Et();
        EditText distance1Et2 = getDistance1Et();
        kotlin.jvm.internal.IIX0o.oO(distance1Et2, "<get-distance1Et>(...)");
        EditText distance1Et3 = getDistance1Et();
        kotlin.jvm.internal.IIX0o.oO(distance1Et3, "<get-distance1Et>(...)");
        EditText distance2Et = getDistance2Et();
        kotlin.jvm.internal.IIX0o.oO(distance2Et, "<get-distance2Et>(...)");
        distance1Et.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, distance1Et2, distance1Et3, distance2Et, false, 8, null));
        EditText distance2Et2 = getDistance2Et();
        EditText distance1Et4 = getDistance1Et();
        kotlin.jvm.internal.IIX0o.oO(distance1Et4, "<get-distance1Et>(...)");
        EditText distance2Et3 = getDistance2Et();
        kotlin.jvm.internal.IIX0o.oO(distance2Et3, "<get-distance2Et>(...)");
        EditText distance3Et = getDistance3Et();
        kotlin.jvm.internal.IIX0o.oO(distance3Et, "<get-distance3Et>(...)");
        distance2Et2.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, distance1Et4, distance2Et3, distance3Et, false, 8, null));
        EditText distance3Et2 = getDistance3Et();
        EditText distance2Et4 = getDistance2Et();
        kotlin.jvm.internal.IIX0o.oO(distance2Et4, "<get-distance2Et>(...)");
        EditText distance3Et3 = getDistance3Et();
        kotlin.jvm.internal.IIX0o.oO(distance3Et3, "<get-distance3Et>(...)");
        EditText distance3Et4 = getDistance3Et();
        kotlin.jvm.internal.IIX0o.oO(distance3Et4, "<get-distance3Et>(...)");
        distance3Et2.setOnKeyListener(BaseCustomSportGoalActivity.setKeyListener$default(this, distance2Et4, distance3Et3, distance3Et4, false, 8, null));
        getTvDistanceUtil().setText(getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_custom_sport_distance_goal;
    }

    @Override // com.sma.smartv3.ui.sport.BaseCustomSportGoalActivity
    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        String obj = getDistance1Et().getText().toString();
        String obj2 = getDistance2Et().getText().toString();
        String obj3 = getDistance3Et().getText().toString();
        if (obj.length() == 0) {
            obj = "0";
        }
        if (obj2.length() == 0) {
            obj2 = "0";
        }
        if (obj3.length() == 0) {
            obj3 = "0";
        }
        int parseInt = (Integer.parseInt(obj) * 10000) + (Integer.parseInt(obj2) * 1000) + (Integer.parseInt(obj3) * 100);
        float f = parseInt;
        String oo0xXOI0I2 = TextConvertKt.oo0xXOI0I(f / 1000.0f, true);
        if (this.userProfile.getUnit() == 1) {
            parseInt = (int) Xx000oIo.XO.XO(f);
        }
        if (parseInt == 0) {
            ToastUtils.showLong(getString(R.string.no_content_set_key), new Object[0]);
        } else {
            setResult(-1, new Intent().putExtra(com.sma.smartv3.initializer.IXxxXO.f20858XOxIOxOx, new Pair(oo0xXOI0I2, Integer.valueOf(parseInt))));
            finish();
        }
    }
}
