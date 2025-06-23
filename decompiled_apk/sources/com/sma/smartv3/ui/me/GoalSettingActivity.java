package com.sma.smartv3.ui.me;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.WheelView.WheelView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;

@kotlin.jvm.internal.XX({"SMAP\nGoalSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoalSettingActivity.kt\ncom/sma/smartv3/ui/me/GoalSettingActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,81:1\n19#2:82\n15#2:83\n*S KotlinDebug\n*F\n+ 1 GoalSettingActivity.kt\ncom/sma/smartv3/ui/me/GoalSettingActivity\n*L\n31#1:82\n31#1:83\n*E\n"})
/* loaded from: classes11.dex */
public final class GoalSettingActivity extends BaseActivity {

    @OXOo.OOXIXo
    private AppUser mAppUser;
    private int stepGoalValue;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO wv$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WheelView>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$wv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WheelView invoke() {
            return (WheelView) GoalSettingActivity.this.findViewById(R.id.wv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distanceGoal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$distanceGoal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) GoalSettingActivity.this.findViewById(R.id.distanceGoal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO caloriesGoal$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$caloriesGoal$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            return (DINCondBold) GoalSettingActivity.this.findViewById(R.id.caloriesGoal);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO distanceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$distanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) GoalSettingActivity.this.findViewById(R.id.nowGoalUnit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btGoalDone$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$btGoalDone$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) GoalSettingActivity.this.findViewById(R.id.btGoalDone);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO approximatelyEqualTo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$approximatelyEqualTo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) GoalSettingActivity.this.findViewById(R.id.approximatelyEqualTo);
        }
    });

    public GoalSettingActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final void countGoal(String str) {
        this.stepGoalValue = Integer.parseInt(str);
        getDistanceGoal().setText(TextConvertKt.O0Xx(this.mAppUser.getHeight(), this.stepGoalValue, this.mAppUser.getUnit()));
        getCaloriesGoal().setText(TextConvertKt.XoI0Ixx0(this.mAppUser.getGender(), this.mAppUser.getWeight(), this.stepGoalValue));
    }

    private final PFMedium getApproximatelyEqualTo() {
        return (PFMedium) this.approximatelyEqualTo$delegate.getValue();
    }

    private final Button getBtGoalDone() {
        return (Button) this.btGoalDone$delegate.getValue();
    }

    private final DINCondBold getCaloriesGoal() {
        return (DINCondBold) this.caloriesGoal$delegate.getValue();
    }

    private final DINCondBold getDistanceGoal() {
        return (DINCondBold) this.distanceGoal$delegate.getValue();
    }

    private final PFMedium getDistanceUnit() {
        return (PFMedium) this.distanceUnit$delegate.getValue();
    }

    private final WheelView getWv() {
        return (WheelView) this.wv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(GoalSettingActivity this$0, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.countGoal(com.sma.smartv3.util.OxxIIOOXO.oIX0oI().get(i));
    }

    public final void doneClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.GoalSettingActivity$doneClick$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(BleConnector bleConnector) {
                invoke2(bleConnector);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo BleConnector it) {
                int i;
                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                BleConnector bleConnector = BleConnector.INSTANCE;
                BleKey bleKey = BleKey.STEP_GOAL;
                BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                i = GoalSettingActivity.this.stepGoalValue;
                BleConnector.sendInt32$default(bleConnector, bleKey, bleKeyFlag, i, null, false, false, 56, null);
                com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24663xoIxX, null, 2, null);
            }
        }, 1, null);
        finish();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.goal_set);
        PFMedium approximatelyEqualTo = getApproximatelyEqualTo();
        if (ProjectManager.f19822oIX0oI.oxXx0IX()) {
            i = 0;
        } else {
            i = 4;
        }
        approximatelyEqualTo.setVisibility(i);
        int int$default = (BleCache.getInt$default(BleCache.INSTANCE, BleKey.STEP_GOAL, 6000, null, 4, null) / 1000) - 1;
        if (int$default < 0) {
            int$default = 9;
        }
        WheelView wv = getWv();
        kotlin.jvm.internal.IIX0o.oO(wv, "<get-wv>(...)");
        com.sma.smartv3.util.OxxIIOOXO.II0xO0(wv, int$default);
        countGoal(com.sma.smartv3.util.OxxIIOOXO.oIX0oI().get(int$default));
        getBtGoalDone().setText(R.string.confirm);
        getWv().xxIXOIIO();
        getWv().setListener(new X0O0I0.I0Io() { // from class: com.sma.smartv3.ui.me.oxIO0IIo
            @Override // X0O0I0.I0Io
            public final void onItemSelected(int i2) {
                GoalSettingActivity.initView$lambda$1$lambda$0(GoalSettingActivity.this, i2);
            }
        });
        getDistanceUnit().setText(TextConvertKt.oI0IIXIo(this.mAppUser.getUnit()));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_goal_set;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
