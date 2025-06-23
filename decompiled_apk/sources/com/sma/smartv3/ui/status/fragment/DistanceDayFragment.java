package com.sma.smartv3.ui.status.fragment;

import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.SPUtils;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Activity;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.ui.status.base.ActivityBaseDayFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

@XX({"SMAP\nDistanceDayFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DistanceDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/DistanceDayFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,132:1\n19#2:133\n15#2:134\n*S KotlinDebug\n*F\n+ 1 DistanceDayFragment.kt\ncom/sma/smartv3/ui/status/fragment/DistanceDayFragment\n*L\n20#1:133\n20#1:134\n*E\n"})
/* loaded from: classes12.dex */
public final class DistanceDayFragment extends ActivityBaseDayFragment {

    @OXOo.OOXIXo
    private final String formatDecimal;

    @OXOo.OOXIXo
    private final AppUser userProfile;

    public DistanceDayFragment() {
        String str;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.userProfile = (AppUser) (fromJson != null ? fromJson : appUser);
        if (ProductManager.f20544oIX0oI.Ioxxx()) {
            str = "%.2f";
        } else {
            str = "%.1f";
        }
        this.formatDecimal = str;
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void filterData(@OXOo.OOXIXo List<Activity> data) {
        float f;
        int i;
        IIX0o.x0xO0oo(data, "data");
        super.filterData(data);
        if (data.isEmpty()) {
            DINCondBold twoValue = getTwoValue();
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(TextConvertKt.ooOOo0oXI(0, this.userProfile.getUnit(), false, 4, null))}, 1));
            IIX0o.oO(format, "format(...)");
            twoValue.setText(UtilsKt.IIXOooo(format));
        } else {
            Activity activity = data.get(data.size() - 1);
            DINCondBold twoValue2 = getTwoValue();
            oxxXoxO oxxxoxo2 = oxxXoxO.f29356oIX0oI;
            String format2 = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(TextConvertKt.ooOOo0oXI(activity.getMDistance() / 10000, this.userProfile.getUnit(), false, 4, null))}, 1));
            IIX0o.oO(format2, "format(...)");
            twoValue2.setText(format2);
        }
        for (Activity activity2 : data) {
            Iterator<Map.Entry<Long, ArrayList<Activity>>> it = getFilterData().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<Long, ArrayList<Activity>> next = it.next();
                    long longValue = next.getKey().longValue();
                    ArrayList<Activity> value = next.getValue();
                    if (activity2.getMTime() <= longValue) {
                        value.add(activity2);
                        break;
                    }
                }
            }
        }
        Iterator<Map.Entry<Long, ArrayList<Activity>>> it2 = getFilterData().entrySet().iterator();
        int i2 = 0;
        int i3 = 0;
        while (it2.hasNext()) {
            ArrayList<Activity> value2 = it2.next().getValue();
            if (value2.isEmpty()) {
                f = 0.0f;
            } else {
                Iterator<Activity> it3 = value2.iterator();
                int i4 = 0;
                int i5 = 0;
                while (it3.hasNext()) {
                    int mDistance = it3.next().getMDistance() / 10000;
                    if (i5 <= mDistance) {
                        if (i5 == 0 && i3 != 0 && mDistance >= i3) {
                            i = mDistance - i3;
                        } else {
                            i = mDistance - i5;
                        }
                        i4 += i;
                    }
                    i5 = mDistance;
                }
                float ooOOo0oXI2 = TextConvertKt.ooOOo0oXI(i4, this.userProfile.getUnit(), false, 4, null);
                int mDistance2 = ((Activity) CollectionsKt___CollectionsKt.O0O0Io00X(value2)).getMDistance() / 10000;
                f = ooOOo0oXI2;
                i3 = mDistance2;
            }
            getValues().add(new BarEntry(i2, f));
            i2++;
        }
        Iterator<Activity> it4 = data.iterator();
        int i6 = 0;
        int i7 = 0;
        while (it4.hasNext()) {
            int mDistance3 = it4.next().getMDistance() / 10000;
            if (i7 <= mDistance3) {
                i6 += mDistance3 - i7;
            }
            i7 = mDistance3;
        }
        DINCondBold oneValue = getOneValue();
        oxxXoxO oxxxoxo3 = oxxXoxO.f29356oIX0oI;
        String format3 = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(TextConvertKt.ooOOo0oXI(i6, this.userProfile.getUnit(), false, 4, null))}, 1));
        IIX0o.oO(format3, "format(...)");
        oneValue.setText(UtilsKt.IIXOooo(format3));
    }

    @OXOo.OOXIXo
    public final String getFormatDecimal() {
        return this.formatDecimal;
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment, com.sma.smartv3.ui.status.base.BaseDetailsFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getImage().setImageResource(R.drawable.icon_distance_info);
        getValueUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
        getOneTV().setText(R.string.total_distance);
        getTotalUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
        getTwoTV().setText(R.string.current_device_total_distance);
        getTwoUnit().setText(TextConvertKt.oI0IIXIo(this.userProfile.getUnit()));
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void setColor(@OXOo.OOXIXo o0xxxXXxX.II0xO0 value) {
        IIX0o.x0xO0oo(value, "value");
        value.xOOxIO(ContextCompat.getColor(getMActivity(), R.color.distance_show_1), ContextCompat.getColor(getMActivity(), R.color.distance_show_2));
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    @OXOo.OOXIXo
    public String setDataLabel() {
        return "Distance day Data";
    }

    @Override // com.sma.smartv3.ui.status.base.ActivityBaseDayFragment
    public void updateItemData(@OXOo.OOXIXo Entry e) {
        IIX0o.x0xO0oo(e, "e");
        DINCondBold nowValue = getNowValue();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(this.formatDecimal, Arrays.copyOf(new Object[]{Float.valueOf(e.I0Io())}, 1));
        IIX0o.oO(format, "format(...)");
        nowValue.setText(UtilsKt.IIXOooo(format));
    }
}
