package com.sma.smartv3.ui.sport;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity;
import com.baidu.mobads.sdk.internal.cn;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.text.DINCondBold;
import java.io.Serializable;
import kotlin.Pair;

@kotlin.jvm.internal.XX({"SMAP\nSportGoalDistanceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportGoalDistanceFragment.kt\ncom/sma/smartv3/ui/sport/SportGoalDistanceFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n19#2:225\n15#2:226\n151#3,5:227\n156#3,5:233\n99#3,7:238\n106#3,3:246\n79#3,7:249\n109#3:256\n1#4:232\n1#4:245\n*S KotlinDebug\n*F\n+ 1 SportGoalDistanceFragment.kt\ncom/sma/smartv3/ui/sport/SportGoalDistanceFragment\n*L\n26#1:225\n26#1:226\n199#1:227,5\n199#1:233,5\n203#1:238,7\n203#1:246,3\n203#1:249,7\n203#1:256\n199#1:232\n203#1:245\n*E\n"})
/* loaded from: classes12.dex */
public final class SportGoalDistanceFragment extends BaseSportGoalSetFragment {

    @OXOo.OOXIXo
    private final AppUser userProfile;

    public SportGoalDistanceFragment() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final int getHalfGoals() {
        return 21097;
    }

    private final float getHalfHorse() {
        return 21.0f;
    }

    private final int getWholeGoals() {
        return 42195;
    }

    private final float getWholeHorse() {
        return 42.1f;
    }

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
            getGoals()[0] = ((Number) pair.getSecond()).intValue();
            getGoals()[1] = 0;
            getGoals()[2] = 0;
            LogUtils.d("pair -> " + pair);
        }
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void setGoalValueItem() {
        getDistanceItemData().put(0, "3 " + getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
        getDistanceItemData().put(1, "5 " + getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
        getDistanceItemData().put(2, "8 " + getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
        getDistanceItemData().put(3, "10 " + getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
        getDistanceItemData().put(4, getString(R.string.half_horse) + TokenParser.SP + transformHalfWhole(getHalfHorse()) + TokenParser.SP + getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
        getDistanceItemData().put(5, getString(R.string.whole_horse) + TokenParser.SP + transformHalfWhole(getWholeHorse()) + TokenParser.SP + getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
    }

    @Override // com.sma.smartv3.ui.sport.BaseSportGoalSetFragment
    public void setInfo() {
        getNowGoalUnit().setText(getString(TextConvertKt.oI0IIXIo(this.userProfile.getUnit())));
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
        startActivityForResult(new Intent(activity, (Class<?>) CustomSportDistanceGoalActivity.class), 123);
    }

    @OXOo.OOXIXo
    public final String transformHalfWhole(float f) {
        if (this.userProfile.getUnit() == 1) {
            return TextConvertKt.oIX0oI(Xx000oIo.XO.oxoX(f), false);
        }
        return TextConvertKt.oIX0oI(f, false);
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
                                str = cn.d;
                            } else {
                                str = transformHalfWhole(getWholeHorse());
                            }
                        } else {
                            str = transformHalfWhole(getHalfHorse());
                        }
                    } else {
                        str = "10.0";
                    }
                } else {
                    str = "8.0";
                }
            } else {
                str = "5.0";
            }
        } else {
            str = "3.0";
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
        int IXxxXO2 = sportManager.IXxxXO();
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                i2 = 0;
                            } else {
                                i2 = getWholeGoals();
                            }
                        } else {
                            i2 = getHalfGoals();
                        }
                    } else {
                        i2 = 10000;
                    }
                } else {
                    i2 = 8000;
                }
            } else {
                i2 = 5000;
            }
        } else {
            i2 = 3000;
        }
        goals[IXxxXO2] = i2;
        if (this.userProfile.getUnit() == 1) {
            getGoals()[sportManager.IXxxXO()] = (int) Xx000oIo.XO.XO(getGoals()[sportManager.IXxxXO()]);
        }
        getGoals()[sportManager.Oxx0xo()] = 0;
        getGoals()[sportManager.Oo()] = 0;
    }
}
