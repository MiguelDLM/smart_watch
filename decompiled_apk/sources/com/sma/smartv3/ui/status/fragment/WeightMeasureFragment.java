package com.sma.smartv3.ui.status.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.WeightDao;
import com.sma.smartv3.db.entity.Weight;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.LevelType;
import com.sma.smartv3.model.WeightMeasureDataKt;
import com.sma.smartv3.model.WeightMeasureItemAdapter;
import com.sma.smartv3.model.WeightMeasureItemData;
import com.sma.smartv3.pop.WeightPickerPopup;
import com.sma.smartv3.ui.status.BodyFatScaleActivity;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.view.segmentedbar.CircleThumbSegmentedBarView;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFMedium;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeightMeasureFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightMeasureFragment.kt\ncom/sma/smartv3/ui/status/fragment/WeightMeasureFragment\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,619:1\n19#2:620\n15#2:621\n766#3:622\n857#3,2:623\n78#4,3:625\n81#4,5:629\n1#5:628\n*S KotlinDebug\n*F\n+ 1 WeightMeasureFragment.kt\ncom/sma/smartv3/ui/status/fragment/WeightMeasureFragment\n*L\n64#1:620\n64#1:621\n572#1:622\n572#1:623,2\n133#1:625,3\n133#1:629,5\n133#1:628\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightMeasureFragment extends BaseFragment {
    private List<WeightMeasureItemData> items;

    @OXOo.OOXIXo
    private final AppUser mAppUser;

    @OXOo.OOXIXo
    private final X0IIOO mSetWeightPopup$delegate;

    @OXOo.oOoXoXO
    private Weight mWeight;
    private WeightDao mWeightDao;

    @OXOo.OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (TabLayout) mView.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO scrollView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<NestedScrollView>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$scrollView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final NestedScrollView invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (NestedScrollView) mView.findViewById(R.id.scrollView);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llNoDatePanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$llNoDatePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return mView.findViewById(R.id.ll_weight_measure_no_date_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llReportPanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$llReportPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return mView.findViewById(R.id.ll_weight_measure_report_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llTitlePanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$llTitlePanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return mView.findViewById(R.id.ll_weight_measure_title_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO llItemPanel$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$llItemPanel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return mView.findViewById(R.id.ll_weight_measure_item_panel);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTopBmiValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvTopBmiValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.tv_topBmiValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTopWeightValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvTopWeightValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.tv_topWeightValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTopWeightUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvTopWeightUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_topWeightUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvTopBfrValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvTopBfrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.tv_topBfrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvMeasureDate$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvMeasureDate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_measure_date);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnMeasureWeight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$btnMeasureWeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return mView.findViewById(R.id.btn_measure_weight);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO btnInputWeight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$btnInputWeight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return mView.findViewById(R.id.btn_input_weight);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeightValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvWeightValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.tv_weightValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvWeightUnit$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvWeightUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (PFMedium) mView.findViewById(R.id.tv_weightUnit);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO tvBfrValue$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<DINCondBold>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$tvBfrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final DINCondBold invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (DINCondBold) mView.findViewById(R.id.tv_bfrValue);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mSbvBmi$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CircleThumbSegmentedBarView>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$mSbvBmi$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CircleThumbSegmentedBarView invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (CircleThumbSegmentedBarView) mView.findViewById(R.id.sbv_bmi);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO mItemView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$mItemView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = WeightMeasureFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.recyclerView);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TabLayout.OnTabSelectedListener {
        public oIX0oI() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@OXOo.oOoXoXO TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@OXOo.oOoXoXO TabLayout.Tab tab) {
            Integer num;
            LevelType levelType;
            if (tab != null) {
                num = Integer.valueOf(tab.getPosition());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                levelType = LevelType.STANDARD;
            } else if (num != null && num.intValue() == 2) {
                levelType = LevelType.LOW;
            } else if (num != null && num.intValue() == 3) {
                levelType = LevelType.HIGH;
            } else {
                levelType = LevelType.ALL;
            }
            WeightMeasureFragment.this.showItems(levelType);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@OXOo.oOoXoXO TabLayout.Tab tab) {
        }
    }

    public WeightMeasureFragment() {
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mSetWeightPopup$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WeightPickerPopup>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$mSetWeightPopup$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final WeightPickerPopup invoke() {
                Activity mActivity;
                AppUser appUser2;
                mActivity = WeightMeasureFragment.this.getMActivity();
                WeightPickerPopup weightPickerPopup = new WeightPickerPopup(mActivity);
                final WeightMeasureFragment weightMeasureFragment = WeightMeasureFragment.this;
                weightPickerPopup.ooXIXxIX(R.string.remember_weight);
                appUser2 = weightMeasureFragment.mAppUser;
                weightPickerPopup.xI(appUser2.getUnit());
                weightPickerPopup.oo0xXOI0I(20.0f);
                weightPickerPopup.IIX0o(new Oox.oOoXoXO<Float, Boolean>() { // from class: com.sma.smartv3.ui.status.fragment.WeightMeasureFragment$mSetWeightPopup$2$1$1
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Float f) {
                        return invoke(f.floatValue());
                    }

                    @OXOo.OOXIXo
                    public final Boolean invoke(float f) {
                        AppUser appUser3;
                        AppUser appUser4;
                        AppUser appUser5;
                        WeightDao weightDao;
                        if (f >= 20.0f) {
                            appUser3 = WeightMeasureFragment.this.mAppUser;
                            appUser3.setWeight(f);
                            SPUtils XO3 = Xo0.f24349oIX0oI.XO();
                            appUser4 = WeightMeasureFragment.this.mAppUser;
                            XO3.put(AppUser.class.getName(), new Gson().toJson(appUser4));
                            Weight weight = new Weight(0, 0L, null, 0.0f, 0, 0, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, null, null, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, XIXIX.OOXIXo.f3760XO, null, null, XIXIX.OOXIXo.f3760XO, null, 0, 0, 0, -1, 2097151, null);
                            weight.setMTime(System.currentTimeMillis());
                            String millis2String = TimeUtils.millis2String(weight.getMTime(), com.sma.smartv3.util.xoIox.I0Io());
                            IIX0o.oO(millis2String, "millis2String(...)");
                            weight.setMLocalTime(millis2String);
                            weight.setMWeight(f);
                            weight.setMIsMeasure(0);
                            float mWeight = weight.getMWeight();
                            appUser5 = WeightMeasureFragment.this.mAppUser;
                            weight.setMBmi(Double.parseDouble(TextConvertKt.Oxx0IOOO(mWeight, appUser5.getHeight())));
                            weightDao = WeightMeasureFragment.this.mWeightDao;
                            if (weightDao == null) {
                                IIX0o.XOxIOxOx("mWeightDao");
                                weightDao = null;
                            }
                            weightDao.insert(CollectionsKt__CollectionsKt.XOxIOxOx(weight));
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24612XO, null, 2, null);
                            com.sma.smartv3.util.x0xO0oo.oIX0oI(com.sma.smartv3.util.x0xO0oo.f24634oOoXoXO, weight);
                        } else {
                            ToastUtils.showLong(R.string.weight_set_error);
                        }
                        return Boolean.TRUE;
                    }
                });
                return weightPickerPopup;
            }
        });
    }

    private final View getBtnInputWeight() {
        return (View) this.btnInputWeight$delegate.getValue();
    }

    private final View getBtnMeasureWeight() {
        return (View) this.btnMeasureWeight$delegate.getValue();
    }

    private final void getItems(Weight weight) {
        List<WeightMeasureItemData> list;
        ArrayList arrayList = new ArrayList();
        this.items = arrayList;
        String string = getString(R.string.weight);
        IIX0o.oO(string, "getString(...)");
        double centigradeFilter = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeight(), this.mAppUser.getUnit()));
        String string2 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string2, "getString(...)");
        List<Double> mWeightRange = weight.getMWeightRange();
        String[] stringArray = getResources().getStringArray(R.array.level_range_5_3);
        IIX0o.oO(stringArray, "getStringArray(...)");
        int[] intArray = getResources().getIntArray(R.array.level_color_5_3);
        IIX0o.oO(intArray, "getIntArray(...)");
        String string3 = getString(R.string.item_weight_tips);
        IIX0o.oO(string3, "getString(...)");
        arrayList.add(new WeightMeasureItemData(R.drawable.icon_report_item_weight, string, true, centigradeFilter, string2, true, 3, 0, mWeightRange, stringArray, intArray, null, false, true, false, null, true, string3, 55424, null));
        List<WeightMeasureItemData> list2 = this.items;
        if (list2 == null) {
            IIX0o.XOxIOxOx("items");
            list2 = null;
        }
        String string4 = getString(R.string.bmi);
        IIX0o.oO(string4, "getString(...)");
        double mBmi = weight.getMBmi();
        List<Double> mBmiRange = weight.getMBmiRange();
        String[] stringArray2 = getResources().getStringArray(R.array.level_range_4_2);
        IIX0o.oO(stringArray2, "getStringArray(...)");
        int[] intArray2 = getResources().getIntArray(R.array.level_color_4_2);
        IIX0o.oO(intArray2, "getIntArray(...)");
        String string5 = getString(R.string.item_bmi_tips);
        IIX0o.oO(string5, "getString(...)");
        list2.add(new WeightMeasureItemData(R.drawable.icon_report_item_bmi, string4, true, mBmi, null, true, 2, 0, mBmiRange, stringArray2, intArray2, null, false, true, false, null, true, string5, 55440, null));
        List<WeightMeasureItemData> list3 = this.items;
        if (list3 == null) {
            IIX0o.XOxIOxOx("items");
            list3 = null;
        }
        String string6 = getString(R.string.bfr);
        IIX0o.oO(string6, "getString(...)");
        double mRatioOfFat = weight.getMRatioOfFat();
        String string7 = getString(R.string.percent);
        IIX0o.oO(string7, "getString(...)");
        List<Double> mRatioOfFatRange = weight.getMRatioOfFatRange();
        String[] stringArray3 = getResources().getStringArray(R.array.level_range_5_3);
        IIX0o.oO(stringArray3, "getStringArray(...)");
        int[] intArray3 = getResources().getIntArray(R.array.level_color_5_3);
        IIX0o.oO(intArray3, "getIntArray(...)");
        String string8 = getString(R.string.item_bfr_tips);
        IIX0o.oO(string8, "getString(...)");
        list3.add(new WeightMeasureItemData(R.drawable.icon_report_item_bfr, string6, true, mRatioOfFat, string7, true, 3, 0, mRatioOfFatRange, stringArray3, intArray3, null, false, true, false, null, true, string8, 55424, null));
        List<WeightMeasureItemData> list4 = this.items;
        if (list4 == null) {
            IIX0o.XOxIOxOx("items");
            list4 = null;
        }
        String string9 = getString(R.string.muscle_weight);
        IIX0o.oO(string9, "getString(...)");
        double centigradeFilter2 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightOfMuscle(), this.mAppUser.getUnit()));
        String string10 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string10, "getString(...)");
        List<Double> mWeightOfMuscleRange = weight.getMWeightOfMuscleRange();
        String[] stringArray4 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray4, "getStringArray(...)");
        int[] intArray4 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray4, "getIntArray(...)");
        String string11 = getString(R.string.item_muscle_weight_tips);
        IIX0o.oO(string11, "getString(...)");
        list4.add(new WeightMeasureItemData(R.drawable.icon_report_item_muscle_weight, string9, true, centigradeFilter2, string10, true, 2, 0, mWeightOfMuscleRange, stringArray4, intArray4, null, false, true, false, null, true, string11, 55424, null));
        List<WeightMeasureItemData> list5 = this.items;
        if (list5 == null) {
            IIX0o.XOxIOxOx("items");
            list5 = null;
        }
        String string12 = getString(R.string.levelofvisceralfat);
        IIX0o.oO(string12, "getString(...)");
        double mLevelOfVisceralFat = weight.getMLevelOfVisceralFat();
        List<Double> mLevelOfVisceralFatRange = weight.getMLevelOfVisceralFatRange();
        String[] stringArray5 = getResources().getStringArray(R.array.level_range_4_1);
        IIX0o.oO(stringArray5, "getStringArray(...)");
        int[] intArray5 = getResources().getIntArray(R.array.level_color_4_1);
        IIX0o.oO(intArray5, "getIntArray(...)");
        String string13 = getString(R.string.item_levelofvisceralfat_tips);
        IIX0o.oO(string13, "getString(...)");
        list5.add(new WeightMeasureItemData(R.drawable.icon_report_item_levelofvisceralfat, string12, true, mLevelOfVisceralFat, null, true, 1, 0, mLevelOfVisceralFatRange, stringArray5, intArray5, null, false, true, false, null, true, string13, 55440, null));
        List<WeightMeasureItemData> list6 = this.items;
        if (list6 == null) {
            IIX0o.XOxIOxOx("items");
            list6 = null;
        }
        String string14 = getString(R.string.water_ratio);
        IIX0o.oO(string14, "getString(...)");
        double mRatioOfWater = weight.getMRatioOfWater();
        String string15 = getString(R.string.percent);
        IIX0o.oO(string15, "getString(...)");
        List<Double> mRatioOfWaterRange = weight.getMRatioOfWaterRange();
        String[] stringArray6 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray6, "getStringArray(...)");
        int[] intArray6 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray6, "getIntArray(...)");
        String string16 = getString(R.string.item_water_ratio_tips);
        IIX0o.oO(string16, "getString(...)");
        list6.add(new WeightMeasureItemData(R.drawable.icon_report_item_water_ratio, string14, true, mRatioOfWater, string15, true, 2, 0, mRatioOfWaterRange, stringArray6, intArray6, null, false, true, false, null, true, string16, 55424, null));
        List<WeightMeasureItemData> list7 = this.items;
        if (list7 == null) {
            IIX0o.XOxIOxOx("items");
            list7 = null;
        }
        String string17 = getString(R.string.weightofbone);
        IIX0o.oO(string17, "getString(...)");
        double centigradeFilter3 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightOfBone(), this.mAppUser.getUnit()));
        String string18 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string18, "getString(...)");
        List<Double> mWeightOfBoneRange = weight.getMWeightOfBoneRange();
        String[] stringArray7 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray7, "getStringArray(...)");
        int[] intArray7 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray7, "getIntArray(...)");
        String string19 = getString(R.string.item_weightofbone_tips);
        IIX0o.oO(string19, "getString(...)");
        list7.add(new WeightMeasureItemData(R.drawable.icon_report_item_weightofbone, string17, true, centigradeFilter3, string18, true, 2, 0, mWeightOfBoneRange, stringArray7, intArray7, null, false, true, false, null, true, string19, 55424, null));
        List<WeightMeasureItemData> list8 = this.items;
        if (list8 == null) {
            IIX0o.XOxIOxOx("items");
            list8 = null;
        }
        String string20 = getString(R.string.bmr);
        IIX0o.oO(string20, "getString(...)");
        double mBmr = weight.getMBmr();
        String string21 = getString(R.string.kcal);
        IIX0o.oO(string21, "getString(...)");
        List<Double> mBmrRange = weight.getMBmrRange();
        String[] stringArray8 = getResources().getStringArray(R.array.level_range_2_2);
        IIX0o.oO(stringArray8, "getStringArray(...)");
        int[] intArray8 = getResources().getIntArray(R.array.level_color_2_2);
        IIX0o.oO(intArray8, "getIntArray(...)");
        String string22 = getString(R.string.item_bmr_tips);
        IIX0o.oO(string22, "getString(...)");
        list8.add(new WeightMeasureItemData(R.drawable.icon_report_item_bmr, string20, true, mBmr, string21, true, 2, 0, mBmrRange, stringArray8, intArray8, null, false, true, false, null, true, string22, 55424, null));
        List<WeightMeasureItemData> list9 = this.items;
        if (list9 == null) {
            IIX0o.XOxIOxOx("items");
            list9 = null;
        }
        String string23 = getString(R.string.fat_weight);
        IIX0o.oO(string23, "getString(...)");
        double centigradeFilter4 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightOfFat(), this.mAppUser.getUnit()));
        String string24 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string24, "getString(...)");
        List<Double> mWeightOfFatRange = weight.getMWeightOfFatRange();
        String[] stringArray9 = getResources().getStringArray(R.array.level_range_5_2);
        IIX0o.oO(stringArray9, "getStringArray(...)");
        int[] intArray9 = getResources().getIntArray(R.array.level_color_5_2);
        IIX0o.oO(intArray9, "getIntArray(...)");
        String string25 = getString(R.string.item_fat_weight_tips);
        IIX0o.oO(string25, "getString(...)");
        list9.add(new WeightMeasureItemData(R.drawable.icon_report_item_fat_weight, string23, true, centigradeFilter4, string24, true, 2, 0, mWeightOfFatRange, stringArray9, intArray9, null, false, true, false, null, true, string25, 55424, null));
        List<WeightMeasureItemData> list10 = this.items;
        if (list10 == null) {
            IIX0o.XOxIOxOx("items");
            list10 = null;
        }
        String string26 = getString(R.string.weightofskeletalmuscle);
        IIX0o.oO(string26, "getString(...)");
        double centigradeFilter5 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightOfSkeletalMuscle(), this.mAppUser.getUnit()));
        String string27 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string27, "getString(...)");
        List<Double> mWeightOfSkeletalMuscleRange = weight.getMWeightOfSkeletalMuscleRange();
        String[] stringArray10 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray10, "getStringArray(...)");
        int[] intArray10 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray10, "getIntArray(...)");
        String string28 = getString(R.string.item_weightofskeletalmuscle_tips);
        IIX0o.oO(string28, "getString(...)");
        list10.add(new WeightMeasureItemData(R.drawable.icon_report_item_weightofskeletalmuscle, string26, true, centigradeFilter5, string27, true, 2, 0, mWeightOfSkeletalMuscleRange, stringArray10, intArray10, null, false, true, false, null, true, string28, 55424, null));
        List<WeightMeasureItemData> list11 = this.items;
        if (list11 == null) {
            IIX0o.XOxIOxOx("items");
            list11 = null;
        }
        String string29 = getString(R.string.ratioofskeletalmuscle);
        IIX0o.oO(string29, "getString(...)");
        double mRatioOfSkeletalMuscle = weight.getMRatioOfSkeletalMuscle();
        String string30 = getString(R.string.percent);
        IIX0o.oO(string30, "getString(...)");
        List<Double> mRatioOfSkeletalMuscleRange = weight.getMRatioOfSkeletalMuscleRange();
        String[] stringArray11 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray11, "getStringArray(...)");
        int[] intArray11 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray11, "getIntArray(...)");
        String string31 = getString(R.string.item_ratioofskeletalmuscle_tips);
        IIX0o.oO(string31, "getString(...)");
        list11.add(new WeightMeasureItemData(R.drawable.icon_report_item_ratioofskeletalmuscle, string29, true, mRatioOfSkeletalMuscle, string30, true, 2, 0, mRatioOfSkeletalMuscleRange, stringArray11, intArray11, null, false, true, false, null, true, string31, 55424, null));
        List<WeightMeasureItemData> list12 = this.items;
        if (list12 == null) {
            IIX0o.XOxIOxOx("items");
            list12 = null;
        }
        String string32 = getString(R.string.weightofwater);
        IIX0o.oO(string32, "getString(...)");
        double centigradeFilter6 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightOfWater(), this.mAppUser.getUnit()));
        String string33 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string33, "getString(...)");
        List<Double> mWeightOfWaterRange = weight.getMWeightOfWaterRange();
        String[] stringArray12 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray12, "getStringArray(...)");
        int[] intArray12 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray12, "getIntArray(...)");
        String string34 = getString(R.string.item_weightofwater_tips);
        IIX0o.oO(string34, "getString(...)");
        list12.add(new WeightMeasureItemData(R.drawable.icon_report_item_weightofwater, string32, true, centigradeFilter6, string33, true, 2, 0, mWeightOfWaterRange, stringArray12, intArray12, null, false, true, false, null, true, string34, 55424, null));
        List<WeightMeasureItemData> list13 = this.items;
        if (list13 == null) {
            IIX0o.XOxIOxOx("items");
            list13 = null;
        }
        String string35 = getString(R.string.weightofprotein);
        IIX0o.oO(string35, "getString(...)");
        double centigradeFilter7 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightOfProtein(), this.mAppUser.getUnit()));
        String string36 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string36, "getString(...)");
        List<Double> mWeightOfProteinRange = weight.getMWeightOfProteinRange();
        String[] stringArray13 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray13, "getStringArray(...)");
        int[] intArray13 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray13, "getIntArray(...)");
        String string37 = getString(R.string.item_weightofprotein_tips);
        IIX0o.oO(string37, "getString(...)");
        list13.add(new WeightMeasureItemData(R.drawable.icon_report_item_weightofprotein, string35, true, centigradeFilter7, string36, true, 2, 0, mWeightOfProteinRange, stringArray13, intArray13, null, false, true, false, null, true, string37, 55424, null));
        List<WeightMeasureItemData> list14 = this.items;
        if (list14 == null) {
            IIX0o.XOxIOxOx("items");
            list14 = null;
        }
        String string38 = getString(R.string.ideal_weight);
        IIX0o.oO(string38, "getString(...)");
        double centigradeFilter8 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMIdealWeight(), this.mAppUser.getUnit()));
        String string39 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string39, "getString(...)");
        list14.add(new WeightMeasureItemData(R.drawable.icon_report_item_ideal_weight, string38, true, centigradeFilter8, string39, false, 0, 0, null, null, null, null, false, false, false, null, false, null, 258016, null));
        List<WeightMeasureItemData> list15 = this.items;
        if (list15 == null) {
            IIX0o.XOxIOxOx("items");
            list15 = null;
        }
        String string40 = getString(R.string.weighttocontrol);
        IIX0o.oO(string40, "getString(...)");
        double centigradeFilter9 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMWeightToControl(), this.mAppUser.getUnit()));
        String string41 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string41, "getString(...)");
        List OOXIXo2 = oI0IIXIo.OOXIXo(Double.valueOf(XIXIX.OOXIXo.f3760XO));
        String[] stringArray14 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray14, "getStringArray(...)");
        int[] intArray14 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray14, "getIntArray(...)");
        String string42 = getString(R.string.item_weighttocontrol_tips);
        IIX0o.oO(string42, "getString(...)");
        list15.add(new WeightMeasureItemData(R.drawable.icon_report_item_weighttocontrol, string40, true, centigradeFilter9, string41, true, 2, 0, OOXIXo2, stringArray14, intArray14, null, false, false, false, null, true, string42, 63616, null));
        List<WeightMeasureItemData> list16 = this.items;
        if (list16 == null) {
            IIX0o.XOxIOxOx("items");
            list16 = null;
        }
        String string43 = getString(R.string.fattocontrol);
        IIX0o.oO(string43, "getString(...)");
        double centigradeFilter10 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMFatToControl(), this.mAppUser.getUnit()));
        String string44 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string44, "getString(...)");
        List OOXIXo3 = oI0IIXIo.OOXIXo(Double.valueOf(XIXIX.OOXIXo.f3760XO));
        String[] stringArray15 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray15, "getStringArray(...)");
        int[] intArray15 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray15, "getIntArray(...)");
        String string45 = getString(R.string.item_fattocontrol_tips);
        IIX0o.oO(string45, "getString(...)");
        list16.add(new WeightMeasureItemData(R.drawable.icon_report_item_fattocontrol, string43, true, centigradeFilter10, string44, true, 2, 0, OOXIXo3, stringArray15, intArray15, null, false, false, false, null, true, string45, 63616, null));
        List<WeightMeasureItemData> list17 = this.items;
        if (list17 == null) {
            IIX0o.XOxIOxOx("items");
            list17 = null;
        }
        String string46 = getString(R.string.muscletocontrol);
        IIX0o.oO(string46, "getString(...)");
        double centigradeFilter11 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMMuscleToControl(), this.mAppUser.getUnit()));
        String string47 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string47, "getString(...)");
        List OOXIXo4 = oI0IIXIo.OOXIXo(Double.valueOf(XIXIX.OOXIXo.f3760XO));
        String[] stringArray16 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray16, "getStringArray(...)");
        int[] intArray16 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray16, "getIntArray(...)");
        String string48 = getString(R.string.item_muscletocontrol_tips);
        IIX0o.oO(string48, "getString(...)");
        list17.add(new WeightMeasureItemData(R.drawable.icon_report_item_muscletocontrol, string46, true, centigradeFilter11, string47, true, 2, 0, OOXIXo4, stringArray16, intArray16, null, false, false, false, null, true, string48, 63616, null));
        List<WeightMeasureItemData> list18 = this.items;
        if (list18 == null) {
            IIX0o.XOxIOxOx("items");
            list18 = null;
        }
        String string49 = getString(R.string.bodyshape);
        double mBodyShape = weight.getMBodyShape();
        String[] stringArray17 = getResources().getStringArray(R.array.body_shape_text);
        int[] intArray17 = getResources().getIntArray(R.array.body_shape_img);
        IIX0o.ooOOo0oXI(string49);
        IIX0o.ooOOo0oXI(stringArray17);
        IIX0o.ooOOo0oXI(intArray17);
        list18.add(new WeightMeasureItemData(R.drawable.icon_report_item_bodyshape, string49, false, mBodyShape, null, true, 5, 0, null, stringArray17, null, null, false, false, true, intArray17, false, null, 212372, null));
        List<WeightMeasureItemData> list19 = this.items;
        if (list19 == null) {
            IIX0o.XOxIOxOx("items");
            list19 = null;
        }
        String string50 = getString(R.string.nutrition_state);
        IIX0o.oO(string50, "getString(...)");
        double mStateOfNutrition = weight.getMStateOfNutrition();
        List OOXIXo5 = oI0IIXIo.OOXIXo(Double.valueOf(4.0d));
        String[] stringArray18 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray18, "getStringArray(...)");
        int[] intArray18 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray18, "getIntArray(...)");
        String string51 = getString(R.string.item_nutrition_state_tips);
        IIX0o.oO(string51, "getString(...)");
        list19.add(new WeightMeasureItemData(R.drawable.icon_report_item_nutrition_state, string50, true, mStateOfNutrition, null, true, 2, 0, OOXIXo5, stringArray18, intArray18, null, false, false, false, null, true, string51, 63632, null));
        List<WeightMeasureItemData> list20 = this.items;
        if (list20 == null) {
            IIX0o.XOxIOxOx("items");
            list20 = null;
        }
        String string52 = getString(R.string.body_age);
        IIX0o.oO(string52, "getString(...)");
        double mAgeOfBody = weight.getMAgeOfBody();
        List<Double> mAgeOfBodyRange = weight.getMAgeOfBodyRange();
        String[] stringArray19 = getResources().getStringArray(R.array.level_range_body_age);
        IIX0o.oO(stringArray19, "getStringArray(...)");
        int[] intArray19 = getResources().getIntArray(R.array.level_color_body_age);
        IIX0o.oO(intArray19, "getIntArray(...)");
        String string53 = getString(R.string.item_body_age_tips);
        IIX0o.oO(string53, "getString(...)");
        list20.add(new WeightMeasureItemData(R.drawable.icon_report_item_body_age, string52, true, mAgeOfBody, null, true, 1, 0, mAgeOfBodyRange, stringArray19, intArray19, null, false, true, false, null, true, string53, 55440, null));
        List<WeightMeasureItemData> list21 = this.items;
        if (list21 == null) {
            IIX0o.XOxIOxOx("items");
            list21 = null;
        }
        String string54 = getString(R.string.protein_ratio);
        IIX0o.oO(string54, "getString(...)");
        double mRatioOfProtein = weight.getMRatioOfProtein();
        String string55 = getString(R.string.percent);
        IIX0o.oO(string55, "getString(...)");
        List<Double> mRatioOfProteinRange = weight.getMRatioOfProteinRange();
        String[] stringArray20 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray20, "getStringArray(...)");
        int[] intArray20 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray20, "getIntArray(...)");
        String string56 = getString(R.string.item_protein_ratio_tips);
        IIX0o.oO(string56, "getString(...)");
        list21.add(new WeightMeasureItemData(R.drawable.icon_report_item_protein_ratio, string54, true, mRatioOfProtein, string55, true, 2, 0, mRatioOfProteinRange, stringArray20, intArray20, null, false, true, false, null, true, string56, 55424, null));
        List<WeightMeasureItemData> list22 = this.items;
        if (list22 == null) {
            IIX0o.XOxIOxOx("items");
            list22 = null;
        }
        String string57 = getString(R.string.ratioofsubcutaneousfat);
        IIX0o.oO(string57, "getString(...)");
        double mRatioOfSubcutaneousFat = weight.getMRatioOfSubcutaneousFat();
        String string58 = getString(R.string.percent);
        IIX0o.oO(string58, "getString(...)");
        List<Double> mRatioOfSubcutaneousFatRange = weight.getMRatioOfSubcutaneousFatRange();
        String[] stringArray21 = getResources().getStringArray(R.array.level_range_3_2);
        IIX0o.oO(stringArray21, "getStringArray(...)");
        int[] intArray21 = getResources().getIntArray(R.array.level_color_3_2);
        IIX0o.oO(intArray21, "getIntArray(...)");
        String string59 = getString(R.string.item_ratioofsubcutaneousfat_tips);
        IIX0o.oO(string59, "getString(...)");
        list22.add(new WeightMeasureItemData(R.drawable.icon_report_item_ratioofsubcutaneousfat, string57, true, mRatioOfSubcutaneousFat, string58, true, 2, 0, mRatioOfSubcutaneousFatRange, stringArray21, intArray21, null, false, true, false, null, true, string59, 55424, null));
        List<WeightMeasureItemData> list23 = this.items;
        if (list23 == null) {
            IIX0o.XOxIOxOx("items");
            list = null;
        } else {
            list = list23;
        }
        String string60 = getString(R.string.fatfreebodyweight);
        IIX0o.oO(string60, "getString(...)");
        double centigradeFilter12 = WeightMeasureDataKt.centigradeFilter(WeightMeasureDataKt.getWeightValue(weight.getMFatFreeBodyWeight(), this.mAppUser.getUnit()));
        String string61 = getString(TextConvertKt.xxX(this.mAppUser.getUnit()));
        IIX0o.oO(string61, "getString(...)");
        String string62 = getString(R.string.item_fatfreebodyweight_tips);
        IIX0o.oO(string62, "getString(...)");
        list.add(new WeightMeasureItemData(R.drawable.icon_report_item_fatfreebodyweight, string60, true, centigradeFilter12, string61, false, 0, 0, null, null, null, null, false, false, false, null, true, string62, 65504, null));
    }

    private final View getLlItemPanel() {
        return (View) this.llItemPanel$delegate.getValue();
    }

    private final View getLlNoDatePanel() {
        return (View) this.llNoDatePanel$delegate.getValue();
    }

    private final View getLlReportPanel() {
        return (View) this.llReportPanel$delegate.getValue();
    }

    private final View getLlTitlePanel() {
        return (View) this.llTitlePanel$delegate.getValue();
    }

    private final RecyclerView getMItemView() {
        return (RecyclerView) this.mItemView$delegate.getValue();
    }

    private final CircleThumbSegmentedBarView getMSbvBmi() {
        return (CircleThumbSegmentedBarView) this.mSbvBmi$delegate.getValue();
    }

    private final WeightPickerPopup getMSetWeightPopup() {
        return (WeightPickerPopup) this.mSetWeightPopup$delegate.getValue();
    }

    private final NestedScrollView getScrollView() {
        return (NestedScrollView) this.scrollView$delegate.getValue();
    }

    private final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    private final DINCondBold getTvBfrValue() {
        return (DINCondBold) this.tvBfrValue$delegate.getValue();
    }

    private final PFMedium getTvMeasureDate() {
        return (PFMedium) this.tvMeasureDate$delegate.getValue();
    }

    private final DINCondBold getTvTopBfrValue() {
        return (DINCondBold) this.tvTopBfrValue$delegate.getValue();
    }

    private final DINCondBold getTvTopBmiValue() {
        return (DINCondBold) this.tvTopBmiValue$delegate.getValue();
    }

    private final PFMedium getTvTopWeightUnit() {
        return (PFMedium) this.tvTopWeightUnit$delegate.getValue();
    }

    private final DINCondBold getTvTopWeightValue() {
        return (DINCondBold) this.tvTopWeightValue$delegate.getValue();
    }

    private final PFMedium getTvWeightUnit() {
        return (PFMedium) this.tvWeightUnit$delegate.getValue();
    }

    private final DINCondBold getTvWeightValue() {
        return (DINCondBold) this.tvWeightValue$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(WeightMeasureFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.startActivity(new Intent(this$0.getActivity(), (Class<?>) BodyFatScaleActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(WeightMeasureFragment this$0, View view) {
        float weight;
        IIX0o.x0xO0oo(this$0, "this$0");
        WeightPickerPopup mSetWeightPopup = this$0.getMSetWeightPopup();
        View btnInputWeight = this$0.getBtnInputWeight();
        IIX0o.oO(btnInputWeight, "<get-btnInputWeight>(...)");
        mSetWeightPopup.OxxIIOOXO(btnInputWeight);
        WeightPickerPopup mSetWeightPopup2 = this$0.getMSetWeightPopup();
        if (this$0.mAppUser.getWeight() == 0.0f) {
            weight = 65.0f;
        } else {
            weight = this$0.mAppUser.getWeight();
        }
        mSetWeightPopup2.oo0xXOI0I(weight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showItems(LevelType levelType) {
        RecyclerView mItemView = getMItemView();
        List<WeightMeasureItemData> list = this.items;
        if (list == null) {
            IIX0o.XOxIOxOx("items");
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            WeightMeasureItemData weightMeasureItemData = (WeightMeasureItemData) obj;
            if (levelType == LevelType.ALL || weightMeasureItemData.getLevelType() == levelType) {
                arrayList.add(obj);
            }
        }
        FragmentActivity requireActivity = requireActivity();
        IIX0o.oO(requireActivity, "requireActivity(...)");
        mItemView.setAdapter(new WeightMeasureItemAdapter(arrayList, requireActivity));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        if (getMArg3() != null) {
            Serializable mArg3 = getMArg3();
            IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.db.entity.Weight");
            this.mWeight = (Weight) mArg3;
        }
    }

    @Override // com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        Double d;
        Double d2;
        Double d3;
        String str;
        LogUtils.d(this.mWeight);
        getMItemView().setLayoutManager(new LinearLayoutManager(getActivity()));
        getMItemView().setHasFixedSize(true);
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getContext(), R.color.view_page_tablayout_bg));
        View childAt = getTable().getChildAt(0);
        IIX0o.x0XOIxOo(childAt, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) childAt;
        linearLayout.setShowDividers(2);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.layout_tab_divider_vertical);
        IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;
        gradientDrawable.setColor(oIxOXo.oxoX.I0Io(getContext(), R.color.view_page_main_bg));
        linearLayout.setDividerDrawable(gradientDrawable);
        getTable().addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new oIX0oI());
        this.mWeightDao = MyDb.INSTANCE.getMDatabase().weightDao();
        getTvTopWeightUnit().setText(TextConvertKt.xxX(this.mAppUser.getUnit()));
        if (getMArg1() == 1) {
            getMView().findViewById(R.id.ll_weight_measure_top_panel).setVisibility(8);
        }
        getBtnMeasureWeight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.ooOOo0oXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightMeasureFragment.initView$lambda$1(WeightMeasureFragment.this, view);
            }
        });
        getBtnInputWeight().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.status.fragment.x0XOIxOo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeightMeasureFragment.initView$lambda$2(WeightMeasureFragment.this, view);
            }
        });
        if (this.mWeight == null) {
            getLlNoDatePanel().setVisibility(0);
            getLlReportPanel().setVisibility(8);
            getLlTitlePanel().setVisibility(8);
            return;
        }
        getLlNoDatePanel().setVisibility(8);
        getLlReportPanel().setVisibility(0);
        if (getMArg1() == 1) {
            getLlTitlePanel().setVisibility(8);
        } else {
            getLlTitlePanel().setVisibility(0);
        }
        Weight weight = this.mWeight;
        Double d4 = null;
        if (weight != null) {
            d = Double.valueOf(weight.getMBmi());
        } else {
            d = null;
        }
        if (IIX0o.I0Io(d, XIXIX.OOXIXo.f3760XO)) {
            Weight weight2 = this.mWeight;
            IIX0o.ooOOo0oXI(weight2);
            d2 = Double.valueOf(Double.parseDouble(TextConvertKt.Oxx0IOOO(weight2.getMWeight(), this.mAppUser.getHeight())));
        } else {
            Weight weight3 = this.mWeight;
            if (weight3 != null) {
                d2 = Double.valueOf(weight3.getMBmi());
            } else {
                d2 = null;
            }
        }
        DINCondBold tvTopBmiValue = getTvTopBmiValue();
        IIX0o.ooOOo0oXI(d2);
        tvTopBmiValue.setText(TextConvertKt.oo((float) d2.doubleValue(), false, 2, null));
        DINCondBold tvTopWeightValue = getTvTopWeightValue();
        Weight weight4 = this.mWeight;
        IIX0o.ooOOo0oXI(weight4);
        tvTopWeightValue.setText(String.valueOf(TextConvertKt.xoIox(TextConvertKt.XxX0x0xxx(weight4.getMWeight(), this.mAppUser.getUnit()))));
        DINCondBold tvTopBfrValue = getTvTopBfrValue();
        Weight weight5 = this.mWeight;
        if (weight5 != null) {
            d3 = Double.valueOf(weight5.getMRatioOfFat());
        } else {
            d3 = null;
        }
        tvTopBfrValue.setText(String.valueOf(d3));
        PFMedium tvMeasureDate = getTvMeasureDate();
        Weight weight6 = this.mWeight;
        if (weight6 != null) {
            str = weight6.getMLocalTime();
        } else {
            str = null;
        }
        tvMeasureDate.setText(str);
        DINCondBold tvWeightValue = getTvWeightValue();
        Weight weight7 = this.mWeight;
        IIX0o.ooOOo0oXI(weight7);
        tvWeightValue.setText(String.valueOf(TextConvertKt.xoIox(TextConvertKt.XxX0x0xxx(weight7.getMWeight(), this.mAppUser.getUnit()))));
        getTvWeightUnit().setText(TextConvertKt.xxX(this.mAppUser.getUnit()));
        DINCondBold tvBfrValue = getTvBfrValue();
        Weight weight8 = this.mWeight;
        if (weight8 != null) {
            d4 = Double.valueOf(weight8.getMRatioOfFat());
        }
        tvBfrValue.setText(String.valueOf(d4));
        Weight weight9 = this.mWeight;
        if (weight9 != null && weight9.getMIsMeasure() == 1) {
            getLlItemPanel().setVisibility(0);
            CircleThumbSegmentedBarView mSbvBmi = getMSbvBmi();
            IIX0o.oO(mSbvBmi, "<get-mSbvBmi>(...)");
            double doubleValue = d2.doubleValue();
            Weight weight10 = this.mWeight;
            IIX0o.ooOOo0oXI(weight10);
            List<Double> mBmiRange = weight10.getMBmiRange();
            String[] stringArray = getResources().getStringArray(R.array.level_range_4_2);
            IIX0o.oO(stringArray, "getStringArray(...)");
            int[] intArray = getResources().getIntArray(R.array.level_color_4_2);
            IIX0o.oO(intArray, "getIntArray(...)");
            WeightMeasureDataKt.setBarView$default(mSbvBmi, doubleValue, mBmiRange, stringArray, intArray, false, 32, null);
            Weight weight11 = this.mWeight;
            IIX0o.ooOOo0oXI(weight11);
            getItems(weight11);
            showItems(LevelType.ALL);
            return;
        }
        getLlItemPanel().setVisibility(8);
        getTvTopBfrValue().setText(R.string.data_none);
        getTvBfrValue().setText(R.string.data_none);
        CircleThumbSegmentedBarView mSbvBmi2 = getMSbvBmi();
        IIX0o.oO(mSbvBmi2, "<get-mSbvBmi>(...)");
        double doubleValue2 = d2.doubleValue();
        List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(Double.valueOf(XIXIX.OOXIXo.f3760XO), Double.valueOf(18.4d), Double.valueOf(24.9d), Double.valueOf(29.9d), Double.valueOf(34.9d));
        String[] stringArray2 = getResources().getStringArray(R.array.level_range_4_2_bmi);
        IIX0o.oO(stringArray2, "getStringArray(...)");
        int[] intArray2 = getResources().getIntArray(R.array.level_color_4_2);
        IIX0o.oO(intArray2, "getIntArray(...)");
        WeightMeasureDataKt.setBarView$default(mSbvBmi2, doubleValue2, X00IoxXI2, stringArray2, intArray2, false, 32, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_weight_measure;
    }

    @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24634oOoXoXO)
    public final void onMeasureWeightChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onMeasureWeightChanged");
        this.mWeight = (Weight) data;
        initView();
    }

    public final void share() {
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        NestedScrollView scrollView = getScrollView();
        IIX0o.oO(scrollView, "<get-scrollView>(...)");
        oxx0IOOO.oxoX(getMActivity(), oxx0IOOO.I0Io(scrollView));
    }
}
