package com.sma.smartv3.ui.sport;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.base.MsgField;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.DINCondBold;
import java.io.Serializable;
import kotlin.Pair;

@kotlin.jvm.internal.XX({"SMAP\nSportGoalTimeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportGoalTimeFragment.kt\ncom/sma/smartv3/ui/sport/SportGoalTimeFragment\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n151#2,5:75\n156#2,5:81\n99#2,7:86\n106#2,3:94\n79#2,7:97\n109#2:104\n1#3:80\n1#3:93\n*S KotlinDebug\n*F\n+ 1 SportGoalTimeFragment.kt\ncom/sma/smartv3/ui/sport/SportGoalTimeFragment\n*L\n49#1:75,5\n49#1:81,5\n53#1:86,7\n53#1:94,3\n53#1:97,7\n53#1:104\n49#1:80\n53#1:93\n*E\n"})
/* loaded from: classes12.dex */
public final class SportGoalTimeFragment extends BaseSportGoalSetFragment {
    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        Serializable serializable;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (intent != null) {
                serializable = intent.getSerializableExtra(com.sma.smartv3.initializer.IXxxXO.f20858XOxIOxOx);
            } else {
                serializable = null;
            }
            kotlin.jvm.internal.IIX0o.x0XOIxOo(serializable, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.Int>");
            Pair pair = (Pair) serializable;
            getNowGoalValue().setText((CharSequence) pair.getFirst());
            getStartExerciseBt().setEnabled(true);
            getGoals()[0] = 0;
            getGoals()[1] = ((Number) pair.getSecond()).intValue();
            getGoals()[2] = 0;
            LogUtils.d("pair -> " + pair);
        }
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void setGoalValueItem() {
        getDistanceItemData().put(0, "15 " + getString(R.string.min));
        getDistanceItemData().put(1, "30 " + getString(R.string.min));
        getDistanceItemData().put(2, "40 " + getString(R.string.min));
        getDistanceItemData().put(3, "50 " + getString(R.string.min));
        getDistanceItemData().put(4, "60 " + getString(R.string.min));
        getDistanceItemData().put(5, "120 " + getString(R.string.min));
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void setInfo() {
        getNowGoalUnit().setText(R.string.h_min);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int[], java.io.Serializable] */
    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void startExercise() {
        int mArg1 = getMArg1();
        ?? goals = getGoals();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", goals);
        Intent intent = new Intent(getActivity(), (Class<?>) SportOnGoingGpsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void toCustomerGoal() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(activity);
        startActivityForResult(new Intent(activity, (Class<?>) CustomSportTimeGoalActivity.class), 123);
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void updateGoalValue(int i) {
        String str;
        boolean z;
        int i2;
        DINCondBold nowGoalValue = getNowGoalValue();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                str = "00:00";
                            } else {
                                str = "02:00";
                            }
                        } else {
                            str = "01:00";
                        }
                    } else {
                        str = "00:50";
                    }
                } else {
                    str = "00:40";
                }
            } else {
                str = "00:30";
            }
        } else {
            str = "00:15";
        }
        nowGoalValue.setText(str);
        Button startExerciseBt = getStartExerciseBt();
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            z = false;
        } else {
            z = true;
        }
        startExerciseBt.setEnabled(z);
        int[] goals = getGoals();
        SportManager sportManager = SportManager.f23843oIX0oI;
        goals[sportManager.IXxxXO()] = 0;
        int[] goals2 = getGoals();
        int Oxx0xo2 = sportManager.Oxx0xo();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                i2 = 0;
                            } else {
                                i2 = 7200;
                            }
                        } else {
                            i2 = 3600;
                        }
                    } else {
                        i2 = 3000;
                    }
                } else {
                    i2 = MsgField.MSG_PADDLE_INIT;
                }
            } else {
                i2 = FeatureCodes.HAIR_SEG;
            }
        } else {
            i2 = 900;
        }
        goals2[Oxx0xo2] = i2;
        getGoals()[sportManager.Oo()] = 0;
    }
}
