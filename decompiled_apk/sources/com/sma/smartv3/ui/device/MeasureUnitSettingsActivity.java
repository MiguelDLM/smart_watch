package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.view.text.PFMedium;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;

@kotlin.jvm.internal.XX({"SMAP\nMeasureUnitSettingsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeasureUnitSettingsActivity.kt\ncom/sma/smartv3/ui/device/MeasureUnitSettingsActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,112:1\n19#2:113\n15#2:114\n*S KotlinDebug\n*F\n+ 1 MeasureUnitSettingsActivity.kt\ncom/sma/smartv3/ui/device/MeasureUnitSettingsActivity\n*L\n34#1:113\n34#1:114\n*E\n"})
/* loaded from: classes12.dex */
public final class MeasureUnitSettingsActivity extends BaseActivity {

    @OXOo.OOXIXo
    private AppUser mAppUser;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mDistanceUnitPopup;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mTemperaturePopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return MeasureUnitSettingsActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$tvDistanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) MeasureUnitSettingsActivity.this.findViewById(R.id.tv_distance_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvTemperatureUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$tvTemperatureUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) MeasureUnitSettingsActivity.this.findViewById(R.id.tv_temperature_unit);
        }
    });

    public MeasureUnitSettingsActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.mAppUser = (AppUser) (fromJson != null ? fromJson : appUser);
    }

    private final PFMedium getTvDistanceUnit() {
        return (PFMedium) this.tvDistanceUnit$delegate.getValue();
    }

    private final PFMedium getTvTemperatureUnit() {
        return (PFMedium) this.tvTemperatureUnit$delegate.getValue();
    }

    public final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        int i2;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.unit_settings_item);
        PFMedium tvDistanceUnit = getTvDistanceUnit();
        if (this.mAppUser.getUnit() == 0) {
            i = R.string.metric;
        } else {
            i = R.string.imperial;
        }
        tvDistanceUnit.setText(i);
        getTvTemperatureUnit().setText(getResources().getStringArray(R.array.temperature_unit_sk_result)[BleCache.getInt$default(BleCache.INSTANCE, BleKey.TEMPERATURE_UNIT, 0, null, 6, null)]);
        View findViewById = findViewById(R.id.ll_temperature_unit);
        if (ProductManager.f20544oIX0oI.xXIX0Xo()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_measure_unit_settings;
    }

    public final void onItemClick(@OXOo.OOXIXo View view) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        int id = view.getId();
        if (id != R.id.ll_distance_unit) {
            if (id == R.id.ll_temperature_unit) {
                if (this.mTemperaturePopup == null) {
                    com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.temperature_unit_sk_list, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
                    xxoxoooix.xI(R.string.temperature_unit);
                    xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$onItemClick$3$1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        @OXOo.OOXIXo
                        public final Boolean invoke(final int i2) {
                            final MeasureUnitSettingsActivity measureUnitSettingsActivity = MeasureUnitSettingsActivity.this;
                            return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$onItemClick$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                    BleConnector.sendInt8$default(it, BleKey.TEMPERATURE_UNIT, BleKeyFlag.UPDATE, i2, false, false, 24, null);
                                    com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24662xoIox, null, 2, null);
                                    measureUnitSettingsActivity.initView();
                                }
                            }, 1, null));
                        }
                    });
                    this.mTemperaturePopup = xxoxoooix;
                }
                com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mTemperaturePopup;
                if (xxoxoooix2 != null) {
                    xxoxoooix2.IIX0o(BleCache.getInt$default(BleCache.INSTANCE, BleKey.TEMPERATURE_UNIT, 0, null, 6, null));
                    View rootView = getRootView();
                    kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
                    xxoxoooix2.OxxIIOOXO(rootView);
                    return;
                }
                return;
            }
            return;
        }
        if (this.mDistanceUnitPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix3 = new com.sma.smartv3.pop.xxOXOOoIX(this, R.array.temperature_unit_sk, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix3.xI(R.string.metric_and_imperial_item);
            xxoxoooix3.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$onItemClick$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(final int i2) {
                    final MeasureUnitSettingsActivity measureUnitSettingsActivity = MeasureUnitSettingsActivity.this;
                    return Boolean.valueOf(com.sma.smartv3.ble.I0Io.II0xO0(false, new Oox.oOoXoXO<BleConnector, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.MeasureUnitSettingsActivity$onItemClick$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            AppUser appUser;
                            kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
                            SPUtils XO2 = xo0.XO();
                            Object appUser2 = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
                            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
                            if (fromJson != null) {
                                appUser2 = fromJson;
                            }
                            int i3 = i2;
                            MeasureUnitSettingsActivity measureUnitSettingsActivity2 = MeasureUnitSettingsActivity.this;
                            AppUser appUser3 = (AppUser) appUser2;
                            appUser3.setUnit(i3 == 0 ? 0 : 1);
                            measureUnitSettingsActivity2.mAppUser = appUser3;
                            measureUnitSettingsActivity2.initView();
                            xo0.XO().put(AppUser.class.getName(), new Gson().toJson(appUser3));
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24578IoOoo, null, 2, null);
                            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24605X0o0xo, null, 2, null);
                            BleConnector bleConnector = BleConnector.INSTANCE;
                            BleKey bleKey = BleKey.USER_PROFILE;
                            BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
                            appUser = MeasureUnitSettingsActivity.this.mAppUser;
                            BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, appUser.getBleUserProfile(), false, false, 24, null);
                        }
                    }, 1, null));
                }
            });
            this.mDistanceUnitPopup = xxoxoooix3;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix4 = this.mDistanceUnitPopup;
        if (xxoxoooix4 != null) {
            if (this.mAppUser.getUnit() == 0) {
                i = 0;
            } else {
                i = 1;
            }
            xxoxoooix4.IIX0o(i);
            View rootView2 = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView2, "<get-rootView>(...)");
            xxoxoooix4.OxxIIOOXO(rootView2);
        }
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
