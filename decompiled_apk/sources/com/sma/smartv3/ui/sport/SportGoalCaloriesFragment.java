package com.sma.smartv3.ui.sport;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.DINCondBold;
import java.io.Serializable;
import kotlin.Pair;

@kotlin.jvm.internal.XX({"SMAP\nSportGoalCaloriesFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportGoalCaloriesFragment.kt\ncom/sma/smartv3/ui/sport/SportGoalCaloriesFragment\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n151#2,5:76\n156#2,5:82\n99#2,7:87\n106#2,3:95\n79#2,7:98\n109#2:105\n1#3:81\n1#3:94\n*S KotlinDebug\n*F\n+ 1 SportGoalCaloriesFragment.kt\ncom/sma/smartv3/ui/sport/SportGoalCaloriesFragment\n*L\n51#1:76,5\n51#1:82,5\n55#1:87,7\n55#1:95,3\n55#1:98,7\n55#1:105\n51#1:81\n55#1:94\n*E\n"})
/* loaded from: classes12.dex */
public final class SportGoalCaloriesFragment extends BaseSportGoalSetFragment {
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
            getGoals()[1] = 0;
            getGoals()[2] = ((Number) pair.getSecond()).intValue();
            LogUtils.d("pair -> " + pair);
        }
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void setGoalValueItem() {
        getDistanceItemData().put(0, "100 " + getString(R.string.kcal));
        getDistanceItemData().put(1, "300 " + getString(R.string.kcal));
        getDistanceItemData().put(2, "500 " + getString(R.string.kcal));
        getDistanceItemData().put(3, "700 " + getString(R.string.kcal));
        getDistanceItemData().put(4, "1000 " + getString(R.string.kcal));
        getDistanceItemData().put(5, "1500 " + getString(R.string.kcal));
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void setInfo() {
        getNowGoalUnit().setText(R.string.kcal);
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
        startActivityForResult(new Intent(activity, (Class<?>) CustomSportCaloriesGoalActivity.class), 123);
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void updateGoalValue(int i) {
        String str;
        boolean z;
        DINCondBold nowGoalValue = getNowGoalValue();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                str = "0";
                            } else {
                                str = "1500";
                            }
                        } else {
                            str = com.tencent.connect.common.II0xO0.f26842oIX0oI;
                        }
                    } else {
                        str = "700";
                    }
                } else {
                    str = "500";
                }
            } else {
                str = "300";
            }
        } else {
            str = "100";
        }
        nowGoalValue.setText(str);
        Button startExerciseBt = getStartExerciseBt();
        int i2 = 0;
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            z = false;
        } else {
            z = true;
        }
        startExerciseBt.setEnabled(z);
        int[] goals = getGoals();
        SportManager sportManager = SportManager.f23843oIX0oI;
        goals[sportManager.IXxxXO()] = 0;
        getGoals()[sportManager.Oxx0xo()] = 0;
        int[] goals2 = getGoals();
        int Oo2 = sportManager.Oo();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                i2 = 1500;
                            }
                        } else {
                            i2 = 1000;
                        }
                    } else {
                        i2 = 700;
                    }
                } else {
                    i2 = 500;
                }
            } else {
                i2 = 300;
            }
        } else {
            i2 = 100;
        }
        goals2[Oo2] = i2;
    }
}
