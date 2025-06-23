package com.sma.smartv3.ble;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.initializer.BleInitializer;
import com.sma.smartv3.initializer.WeatherInitializer;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.BleDevice;
import com.sma.smartv3.model.DeviceExtra;
import com.sma.smartv3.model.DeviceSettings;
import com.sma.smartv3.ui.device.QiblaSettingsActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.xoIox;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleAlarm;
import com.szabh.smable3.entity.BleBloodOxyGenSettings;
import com.szabh.smable3.entity.BleCoaching;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleDrinkWaterSettings;
import com.szabh.smable3.entity.BleGameSettings;
import com.szabh.smable3.entity.BleGestureWake;
import com.szabh.smable3.entity.BleGirlCareSettings;
import com.szabh.smable3.entity.BleHrMonitoringSettings;
import com.szabh.smable3.entity.BleHrWarningSettings;
import com.szabh.smable3.entity.BleLanguagePackVersion;
import com.szabh.smable3.entity.BleMedicationAlarm;
import com.szabh.smable3.entity.BleNoDisturbSettings;
import com.szabh.smable3.entity.BlePressureTimingMeasurement;
import com.szabh.smable3.entity.BleQiblaSettings;
import com.szabh.smable3.entity.BleSchedule;
import com.szabh.smable3.entity.BleSedentarinessSettings;
import com.szabh.smable3.entity.BleStandbyWatchFaceSet;
import com.szabh.smable3.entity.BleTemperatureDetecting;
import com.szabh.smable3.entity.BleTime;
import com.szabh.smable3.entity.BleTimeRange;
import com.szabh.smable3.entity.BleTimeZone;
import com.szabh.smable3.entity.BleTouchSettings;
import com.szabh.smable3.entity.BleUserProfile;
import com.szabh.smable3.entity.BleWashSettings;
import com.szabh.smable3.entity.Languages;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nBleDeviceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleDeviceManager.kt\ncom/sma/smartv3/ble/BleDeviceManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 Json.kt\ncom/sma/smartv3/model/JsonFieldContainer\n*L\n1#1,606:1\n18#2,2:607\n15#2:609\n19#2:610\n15#2:611\n11#2,2:612\n13#3,6:614\n*S KotlinDebug\n*F\n+ 1 BleDeviceManager.kt\ncom/sma/smartv3/ble/BleDeviceManager\n*L\n39#1:607,2\n39#1:609\n222#1:610\n222#1:611\n226#1:612,2\n228#1:614,6\n*E\n"})
/* loaded from: classes12.dex */
public final class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static boolean f20316II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f20317oIX0oI = new II0xO0();

    public final int I0Io() {
        return BleCache.getInt$default(BleCache.INSTANCE, BleKey.BACK_LIGHT, 5, null, 4, null);
    }

    public final BleGirlCareSettings II0XooXoX() {
        BleGirlCareSettings bleGirlCareSettings = (BleGirlCareSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.GIRL_CARE, BleGirlCareSettings.class, null, 4, null);
        if (bleGirlCareSettings == null) {
            return new BleGirlCareSettings(0, 0, 10, 0, 2, 3, 0, 0, 0, 5, 28, 451, null);
        }
        return bleGirlCareSettings;
    }

    public final List<BleAlarm> II0xO0() {
        return BleCache.getList$default(BleCache.INSTANCE, BleKey.ALARM, BleAlarm.class, null, 4, null);
    }

    public final BleTouchSettings IIXOooo() {
        BleTouchSettings bleTouchSettings = (BleTouchSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.TOUCH_SET, BleTouchSettings.class, null, 4, null);
        if (bleTouchSettings == null) {
            return new BleTouchSettings(0, 0, 0, 0, 0, 31, null);
        }
        return bleTouchSettings;
    }

    public final BleSedentarinessSettings IXxxXO() {
        BleSedentarinessSettings bleSedentarinessSettings = (BleSedentarinessSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.SEDENTARINESS, BleSedentarinessSettings.class, null, 4, null);
        if (bleSedentarinessSettings == null) {
            return new BleSedentarinessSettings(0, 127, 8, 0, 18, 0, 120);
        }
        return bleSedentarinessSettings;
    }

    public final boolean O0xOxO() {
        return f20316II0xO0;
    }

    public final List<BleMedicationAlarm> OOXIXo() {
        return BleCache.getList$default(BleCache.INSTANCE, BleKey.MEDICATION_ALARM, BleMedicationAlarm.class, null, 4, null);
    }

    public final List<BleSchedule> Oo() {
        return BleCache.getList$default(BleCache.INSTANCE, BleKey.SCHEDULE, BleSchedule.class, null, 4, null);
    }

    public final BleWashSettings OxI() {
        BleWashSettings bleWashSettings = (BleWashSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.WASH_SET, BleWashSettings.class, null, 4, null);
        if (bleWashSettings == null) {
            return new BleWashSettings(0, 127, 8, 0, 18, 0, 120);
        }
        return bleWashSettings;
    }

    public final BleGestureWake Oxx0IOOO() {
        BleGestureWake bleGestureWake = (BleGestureWake) BleCache.getObject$default(BleCache.INSTANCE, BleKey.GESTURE_WAKE, BleGestureWake.class, null, 4, null);
        if (bleGestureWake == null) {
            return new BleGestureWake(new BleTimeRange(ProductManager.f20544oIX0oI.xo0x(), 0, 0, 0, 0));
        }
        return bleGestureWake;
    }

    public final BleStandbyWatchFaceSet Oxx0xo() {
        BleStandbyWatchFaceSet bleStandbyWatchFaceSet = (BleStandbyWatchFaceSet) BleCache.getObject$default(BleCache.INSTANCE, BleKey.STANDBY_WATCH_FACE_SET, BleStandbyWatchFaceSet.class, null, 4, null);
        if (bleStandbyWatchFaceSet == null) {
            return new BleStandbyWatchFaceSet(0, 1, new BleTimeRange(0, 8, 0, 18, 0), 0, 8, null);
        }
        return bleStandbyWatchFaceSet;
    }

    public final BleTemperatureDetecting OxxIIOOXO() {
        BleTemperatureDetecting bleTemperatureDetecting = (BleTemperatureDetecting) BleCache.getObject$default(BleCache.INSTANCE, BleKey.TEMPERATURE_DETECTING, BleTemperatureDetecting.class, null, 4, null);
        if (bleTemperatureDetecting == null) {
            return new BleTemperatureDetecting(new BleTimeRange(1, 8, 0, 18, 0), 60);
        }
        return bleTemperatureDetecting;
    }

    public final void X0IIOO() {
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("onDeviceConfigInfoChange");
        if (ProjectManager.f19822oIX0oI.I0oOIX()) {
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.GIRL_CARE, BleKeyFlag.UPDATE, II0XooXoX(), false, false, 24, null);
        } else {
            BleConnector.sendObject$default(BleConnector.INSTANCE, BleKey.GIRL_CARE, BleKeyFlag.UPDATE, new BleGirlCareSettings(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null), false, false, 24, null);
        }
    }

    public final BleDrinkWaterSettings X0o0xo() {
        BleDrinkWaterSettings bleDrinkWaterSettings = (BleDrinkWaterSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.DRINK_WATER, BleDrinkWaterSettings.class, null, 4, null);
        if (bleDrinkWaterSettings == null) {
            return new BleDrinkWaterSettings(0, 127, 8, 0, 18, 0, 120);
        }
        return bleDrinkWaterSettings;
    }

    public final void XI0IXoo(@oOoXoXO BleDevice bleDevice) {
        String settings;
        Object obj;
        if (bleDevice == null) {
            return;
        }
        if (ProjectManager.f19822oIX0oI.OOxOI()) {
            SPUtils XO2 = Xo0.f24349oIX0oI.XO();
            Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
            Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
            if (fromJson != null) {
                appUser = fromJson;
            }
            settings = ((AppUser) appUser).getSettings();
        } else {
            settings = bleDevice.getSettings();
        }
        Xo0.f24349oIX0oI.I0Io().put(BleDevice.class.getName(), new Gson().toJson(bleDevice));
        BleCache.putObject$default(BleCache.INSTANCE, BleKey.USER_PROFILE, xoXoI(), null, 4, null);
        try {
            obj = new Gson().fromJson(settings, (Class<Object>) DeviceSettings.class);
        } catch (Exception e) {
            e.printStackTrace();
            obj = null;
        }
        DeviceSettings deviceSettings = (DeviceSettings) obj;
        if (deviceSettings != null) {
            Integer stepGoal = deviceSettings.getStepGoal();
            if (stepGoal != null) {
                BleCache.putInt$default(BleCache.INSTANCE, BleKey.STEP_GOAL, stepGoal.intValue(), null, 4, null);
            }
            Integer backLight = deviceSettings.getBackLight();
            if (backLight != null) {
                BleCache.putInt$default(BleCache.INSTANCE, BleKey.BACK_LIGHT, backLight.intValue(), null, 4, null);
            }
            BleSedentarinessSettings sedentarinessSettings = deviceSettings.getSedentarinessSettings();
            if (sedentarinessSettings != null) {
                BleCache.putObject$default(BleCache.INSTANCE, BleKey.SEDENTARINESS, sedentarinessSettings, null, 4, null);
            }
            BleNoDisturbSettings noDisturbSettings = deviceSettings.getNoDisturbSettings();
            if (noDisturbSettings != null) {
                BleCache.putObject$default(BleCache.INSTANCE, BleKey.NO_DISTURB_RANGE, noDisturbSettings, null, 4, null);
            }
            Integer vibration = deviceSettings.getVibration();
            if (vibration != null) {
                BleCache.putInt$default(BleCache.INSTANCE, BleKey.VIBRATION, vibration.intValue(), null, 4, null);
            }
            List<BleAlarm> alarms = deviceSettings.getAlarms();
            if (alarms != null) {
                BleCache.putList$default(BleCache.INSTANCE, BleKey.ALARM, alarms, null, 4, null);
            }
            BleHrMonitoringSettings hrMonitoringSettings = deviceSettings.getHrMonitoringSettings();
            if (hrMonitoringSettings != null) {
                BleCache.putObject$default(BleCache.INSTANCE, BleKey.HR_MONITORING, hrMonitoringSettings, null, 4, null);
            }
            BleGestureWake gestureWake = deviceSettings.getGestureWake();
            if (gestureWake != null) {
                BleCache.putObject$default(BleCache.INSTANCE, BleKey.GESTURE_WAKE, gestureWake, null, 4, null);
            }
            BleGirlCareSettings girlCare = deviceSettings.getGirlCare();
            if (girlCare != null) {
                BleCache.putObject$default(BleCache.INSTANCE, BleKey.GIRL_CARE, girlCare, null, 4, null);
            }
            List<BleSchedule> schedules = deviceSettings.getSchedules();
            if (schedules != null) {
                BleCache.putList$default(BleCache.INSTANCE, BleKey.SCHEDULE, schedules, null, 4, null);
            }
            List<BleCoaching> coachings = deviceSettings.getCoachings();
            if (coachings != null) {
                BleCache.putList$default(BleCache.INSTANCE, BleKey.COACHING, coachings, null, 4, null);
            }
        }
    }

    public final void XIxXXX0x0() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        BleKey bleKey = BleKey.TIME_ZONE;
        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
        BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, new BleTimeZone(), false, false, 24, null);
        BleConnector.sendObject$default(bleConnector, BleKey.TIME, bleKeyFlag, BleTime.Companion.local(), false, false, 24, null);
        BleConnector.sendInt8$default(bleConnector, BleKey.HOUR_SYSTEM, bleKeyFlag, !xoIox.ooXIXxIX() ? 1 : 0, false, false, 24, null);
        BleKey bleKey2 = BleKey.USER_PROFILE;
        II0xO0 iI0xO0 = f20317oIX0oI;
        BleConnector.sendObject$default(bleConnector, bleKey2, bleKeyFlag, iI0xO0.xoXoI(), false, false, 24, null);
        BleConnector.sendInt32$default(bleConnector, BleKey.STEP_GOAL, bleKeyFlag, iI0xO0.oI0IIXIo(), null, false, false, 56, null);
        BleKey bleKey3 = BleKey.BACK_LIGHT;
        ProductManager productManager = ProductManager.f20544oIX0oI;
        BleConnector.sendInt8$default(bleConnector, bleKey3, bleKeyFlag, productManager.OxxIIOOXO(), false, false, 24, null);
        if (productManager.oxIIX0o()) {
            BleConnector.sendObject$default(bleConnector, BleKey.SEDENTARINESS, bleKeyFlag, iI0xO0.IXxxXO(), false, false, 24, null);
        }
        BleConnector.sendObject$default(bleConnector, BleKey.NO_DISTURB_RANGE, bleKeyFlag, iI0xO0.oOoXoXO(), false, false, 24, null);
        BleConnector.sendInt8$default(bleConnector, BleKey.VIBRATION, bleKeyFlag, iI0xO0.o00(), false, false, 24, null);
        if (iI0xO0.II0xO0().size() <= productManager.X00IoxXI()) {
            BleConnector.sendList$default(bleConnector, BleKey.ALARM, BleKeyFlag.RESET, iI0xO0.II0xO0(), false, false, 24, null);
        } else {
            BleConnector.sendList$default(bleConnector, BleKey.ALARM, BleKeyFlag.RESET, iI0xO0.II0xO0().subList(0, productManager.X00IoxXI()), false, false, 24, null);
        }
        if (productManager.oXIoIo()) {
            if (iI0xO0.OOXIXo().size() <= productManager.xXOx()) {
                BleConnector.sendList$default(bleConnector, BleKey.MEDICATION_ALARM, BleKeyFlag.RESET, iI0xO0.OOXIXo(), false, false, 24, null);
            } else {
                BleConnector.sendList$default(bleConnector, BleKey.MEDICATION_ALARM, BleKeyFlag.RESET, iI0xO0.OOXIXo().subList(0, productManager.xXOx()), false, false, 24, null);
            }
        }
        if (productManager.Ox0O()) {
            BleConnector.sendObject$default(bleConnector, BleKey.HR_MONITORING, bleKeyFlag, iI0xO0.xxIXOIIO(), false, false, 24, null);
        }
        if (productManager.I00O()) {
            BleConnector.sendObject$default(bleConnector, BleKey.BLOOD_OXYGEN_SET, bleKeyFlag, iI0xO0.oO(), false, false, 24, null);
        }
        if (productManager.xIXoO0Xx()) {
            BleConnector.sendObject$default(bleConnector, BleKey.PRESSURE_TIMING_MEASUREMENT, bleKeyFlag, iI0xO0.x0XOIxOo(), false, false, 24, null);
        }
        if (productManager.XIxO()) {
            BleConnector.sendObject$default(bleConnector, BleKey.HR_WARNING_SET, bleKeyFlag, iI0xO0.xoIox(), false, false, 24, null);
        }
        BleConnector.sendObject$default(bleConnector, BleKey.GESTURE_WAKE, bleKeyFlag, iI0xO0.Oxx0IOOO(), false, false, 24, null);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.I0oOIX()) {
            BleConnector.sendObject$default(bleConnector, BleKey.GIRL_CARE, bleKeyFlag, iI0xO0.II0XooXoX(), false, false, 24, null);
        } else {
            BleConnector.sendObject$default(bleConnector, BleKey.GIRL_CARE, bleKeyFlag, new BleGirlCareSettings(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2047, null), false, false, 24, null);
        }
        if (productManager.O0()) {
            BleConnector.sendObject$default(bleConnector, BleKey.TEMPERATURE_DETECTING, bleKeyFlag, iI0xO0.OxxIIOOXO(), false, false, 24, null);
        }
        if (productManager.XOo0()) {
            BleConnector.sendObject$default(bleConnector, BleKey.DRINK_WATER, bleKeyFlag, iI0xO0.X0o0xo(), false, false, 24, null);
        }
        if (productManager.OoOoXO0()) {
            BleConnector.sendObject$default(bleConnector, BleKey.WASH_SET, bleKeyFlag, iI0xO0.OxI(), false, false, 24, null);
        }
        projectManager.xxIXOIIO();
        if (productManager.O0O0Io00X()) {
            BleConnector.sendObject$default(bleConnector, BleKey.GAME_SET, bleKeyFlag, iI0xO0.XO(), false, false, 24, null);
        }
        if (productManager.IOXOxOII()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.NOTIFICATION_LIGHT_SCREEN_SET, bleKeyFlag, iI0xO0.ooOOo0oXI(), false, false, 24, null);
        }
        if (productManager.OIxOX()) {
            BleConnector.sendData$default(bleConnector, BleKey.APP_OP, BleKeyFlag.READ, null, false, false, 28, null);
        }
        BleInitializer.f20700XO.oo();
    }

    public final BleGameSettings XO() {
        BleGameSettings bleGameSettings = (BleGameSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.GAME_SET, BleGameSettings.class, null, 4, null);
        if (bleGameSettings == null) {
            return new BleGameSettings(0, 7, 0, 18, 0, 22, 0, 6, 0);
        }
        return bleGameSettings;
    }

    public final void XxX0x0xxx(boolean z) {
        f20316II0xO0 = z;
    }

    public final int o00() {
        return BleCache.getInt$default(BleCache.INSTANCE, BleKey.VIBRATION, 1, null, 4, null);
    }

    public final int oI0IIXIo() {
        return BleCache.getInt$default(BleCache.INSTANCE, BleKey.STEP_GOAL, 10000, null, 4, null);
    }

    @OOXIXo
    public final BleDevice oIX0oI() {
        BleDevice bleDevice = new BleDevice(null, null, null, null, null, 0, null, null, null, 511, null);
        BleCache bleCache = BleCache.INSTANCE;
        BleDeviceInfo bleDeviceInfo = (BleDeviceInfo) BleCache.getObjectNotNull$default(bleCache, BleKey.IDENTITY, BleDeviceInfo.class, null, null, 12, null);
        String string$default = BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, null, null, 6, null);
        BleLanguagePackVersion bleLanguagePackVersion = (BleLanguagePackVersion) BleCache.getObject$default(bleCache, BleKey.LANGUAGE_PACK_VERSION, BleLanguagePackVersion.class, null, 4, null);
        DeviceExtra deviceExtra = new DeviceExtra(string$default, null, 2, null);
        if (bleLanguagePackVersion != null) {
            deviceExtra.setLanguagePackVersion(bleLanguagePackVersion.getMVersion() + '.' + bleLanguagePackVersion.getMLanguageCode());
        }
        DeviceSettings deviceSettings = new DeviceSettings(Integer.valueOf(oI0IIXIo()), Integer.valueOf(I0Io()), IXxxXO(), oOoXoXO(), Integer.valueOf(o00()), II0xO0(), xxIXOIIO(), Oxx0IOOO(), II0XooXoX(), Oo(), oxoX(), X0o0xo(), XO());
        bleDevice.setName(bleDeviceInfo.getMBleName());
        bleDevice.setAddress(bleDeviceInfo.getMBleAddress());
        bleDevice.setPlatform(bleDeviceInfo.getMPlatform());
        bleDevice.setPrototype(bleDeviceInfo.getMPrototype());
        bleDevice.setFirmwareFlag(bleDeviceInfo.getMFirmwareFlag());
        bleDevice.setAgpsType(bleDeviceInfo.getMAGpsType());
        bleDevice.setVersion(BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        bleDevice.setExtraInfo(deviceExtra.toJson());
        bleDevice.setSettings(deviceSettings.toJson());
        return bleDevice;
    }

    public final BleBloodOxyGenSettings oO() {
        BleBloodOxyGenSettings bleBloodOxyGenSettings = (BleBloodOxyGenSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.BLOOD_OXYGEN_SET, BleBloodOxyGenSettings.class, null, 4, null);
        if (bleBloodOxyGenSettings == null) {
            ProductManager productManager = ProductManager.f20544oIX0oI;
            return new BleBloodOxyGenSettings(new BleTimeRange(productManager.II0XooXoX(), 0, 0, 23, 59), productManager.Oxx0IOOO());
        }
        return bleBloodOxyGenSettings;
    }

    public final BleNoDisturbSettings oOoXoXO() {
        BleNoDisturbSettings bleNoDisturbSettings = (BleNoDisturbSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.NO_DISTURB_RANGE, BleNoDisturbSettings.class, null, 4, null);
        if (bleNoDisturbSettings == null) {
            return new BleNoDisturbSettings(0, new BleTimeRange(0, 23, 0, 7, 0), null, null, 12, null);
        }
        return bleNoDisturbSettings;
    }

    public final int ooOOo0oXI() {
        return BleCache.getInt$default(BleCache.INSTANCE, BleKey.NOTIFICATION_LIGHT_SCREEN_SET, 0, null, 4, null);
    }

    public final List<BleCoaching> oxoX() {
        return BleCache.getList$default(BleCache.INSTANCE, BleKey.COACHING, BleCoaching.class, null, 4, null);
    }

    public final BlePressureTimingMeasurement x0XOIxOo() {
        BlePressureTimingMeasurement blePressureTimingMeasurement = (BlePressureTimingMeasurement) BleCache.getObject$default(BleCache.INSTANCE, BleKey.PRESSURE_TIMING_MEASUREMENT, BlePressureTimingMeasurement.class, null, 4, null);
        if (blePressureTimingMeasurement == null) {
            return new BlePressureTimingMeasurement(new BleTimeRange(1, 0, 0, 23, 59), ProductManager.f20544oIX0oI.OOXIXo());
        }
        return blePressureTimingMeasurement;
    }

    public final BleQiblaSettings x0xO0oo() {
        BleQiblaSettings bleQiblaSettings = (BleQiblaSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.QIBLA_SET, BleQiblaSettings.class, null, 4, null);
        if (bleQiblaSettings == null) {
            return new BleQiblaSettings(ProductManager.f20544oIX0oI.oX(), 0, QiblaSettingsActivity.Companion.oIX0oI(), 0, 0, 0, (int) (System.currentTimeMillis() / 1000), null, 184, null);
        }
        return bleQiblaSettings;
    }

    public final void xXxxox0I() {
        if (ProductManager.f20544oIX0oI.OIoxIx() && f20316II0xO0) {
            BleConnector.sendInt8$default(BleConnector.INSTANCE, BleKey.CONNECT_REMINDER, BleKeyFlag.UPDATE, 1, false, false, 24, null);
        }
        f20316II0xO0 = false;
    }

    public final BleHrWarningSettings xoIox() {
        BleHrWarningSettings bleHrWarningSettings = (BleHrWarningSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.HR_WARNING_SET, BleHrWarningSettings.class, null, 4, null);
        if (bleHrWarningSettings == null) {
            return new BleHrWarningSettings(0, 150, 0, 60);
        }
        return bleHrWarningSettings;
    }

    public final BleUserProfile xoXoI() {
        Object fromJson = new Gson().fromJson(Xo0.f24349oIX0oI.XO().getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson == null) {
            fromJson = AppUser.class.newInstance();
        }
        return ((AppUser) fromJson).getBleUserProfile();
    }

    public final BleHrMonitoringSettings xxIXOIIO() {
        int i;
        BleHrMonitoringSettings bleHrMonitoringSettings = (BleHrMonitoringSettings) BleCache.getObject$default(BleCache.INSTANCE, BleKey.HR_MONITORING, BleHrMonitoringSettings.class, null, 4, null);
        if (bleHrMonitoringSettings == null) {
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (productManager.xxIXOIIO()) {
                i = 255;
            } else {
                i = 0;
            }
            bleHrMonitoringSettings = new BleHrMonitoringSettings(new BleTimeRange(i, 0, 0, 23, 59), productManager.xoIox());
        }
        return bleHrMonitoringSettings;
    }

    public final void xxX() {
        BleConnector bleConnector = BleConnector.INSTANCE;
        BleKey bleKey = BleKey.TIME_ZONE;
        BleKeyFlag bleKeyFlag = BleKeyFlag.UPDATE;
        BleConnector.sendObject$default(bleConnector, bleKey, bleKeyFlag, new BleTimeZone(), false, false, 24, null);
        BleConnector.sendObject$default(bleConnector, BleKey.TIME, bleKeyFlag, BleTime.Companion.local(), false, false, 24, null);
        BleConnector.sendInt8$default(bleConnector, BleKey.HOUR_SYSTEM, bleKeyFlag, !xoIox.ooXIXxIX() ? 1 : 0, false, false, 24, null);
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.OO()) {
            BleConnector.sendData$default(bleConnector, BleKey.NO_DISTURB_RANGE, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager.xoxXI()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.ALARM, BleKeyFlag.READ, 255, false, false, 24, null);
        }
        if (productManager.oXIoIo()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.MEDICATION_ALARM, BleKeyFlag.READ, 255, false, false, 24, null);
        }
        if (productManager.xx0X0()) {
            BleKey bleKey2 = BleKey.UI_PACK_VERSION;
            BleKeyFlag bleKeyFlag2 = BleKeyFlag.READ;
            BleConnector.sendData$default(bleConnector, bleKey2, bleKeyFlag2, null, false, false, 28, null);
            BleConnector.sendData$default(bleConnector, BleKey.LANGUAGE_PACK_VERSION, bleKeyFlag2, null, false, false, 28, null);
        }
        if (productManager.IoX()) {
            BleCache bleCache = BleCache.INSTANCE;
            BleKey bleKey3 = BleKey.EARPHONE_INFO;
            BleCache.remove$default(bleCache, bleKey3, null, 2, null);
            BleKey bleKey4 = BleKey.EARPHONE_STATE;
            BleCache.remove$default(bleCache, bleKey4, null, 2, null);
            BleKeyFlag bleKeyFlag3 = BleKeyFlag.READ;
            BleConnector.sendData$default(bleConnector, bleKey3, bleKeyFlag3, null, false, false, 28, null);
            BleConnector.sendData$default(bleConnector, BleKey.EARPHONE_POWER, bleKeyFlag3, null, false, false, 28, null);
            BleConnector.sendData$default(bleConnector, bleKey4, bleKeyFlag3, null, false, false, 28, null);
        }
        if (productManager.X0xOO()) {
            BleConnector.sendData$default(bleConnector, BleKey.GPS_FIRMWARE_VERSION, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager.X0()) {
            BleConnector.sendData$default(bleConnector, BleKey.NETWORK_FIRMWARE_VERSION, BleKeyFlag.READ, null, false, false, 28, null);
        }
        BleKey bleKey5 = BleKey.FIRMWARE_VERSION;
        BleKeyFlag bleKeyFlag4 = BleKeyFlag.READ;
        BleConnector.sendData$default(bleConnector, bleKey5, bleKeyFlag4, null, false, false, 28, null);
        if (IIX0o.Oxx0IOOO(BleCache.INSTANCE.getMPlatform(), BleDeviceInfo.PLATFORM_MTK) && productManager.xOoOIoI()) {
            bleConnector.read(BleConnector.SERVICE_MTK, BleConnector.CH_MTK_OTA_META);
        }
        if (productManager.O0X()) {
            BleConnector.sendData$default(bleConnector, BleKey.MUSIC_CONTROL, bleKeyFlag4, null, false, false, 28, null);
        }
        if (productManager.oI()) {
            LogUtils.d("sendSessionCommands() -> Start syncWeather");
            WeatherInitializer.f20909XO.IXxxXO();
        }
        BleConnector.sendData$default(bleConnector, BleKey.POWER, bleKeyFlag4, null, false, false, 28, null);
        BleConnector.sendInt8$default(bleConnector, BleKey.LANGUAGE, bleKeyFlag, Xo0.f24349oIX0oI.II0xO0().getInt(XoI0Ixx0.f24413XI0IXoo, Languages.languageToCode$default(Languages.INSTANCE, null, 0, 3, null)), false, false, 24, null);
        if (productManager.xoIxX() > 0) {
            List<BleSchedule> Oo2 = f20317oIX0oI.Oo();
            BleConnector.sendInt8$default(bleConnector, BleKey.SCHEDULE, BleKeyFlag.DELETE, 255, false, false, 24, null);
            Iterator<BleSchedule> it = Oo2.iterator();
            while (it.hasNext()) {
                BleConnector.sendObject$default(bleConnector, BleKey.SCHEDULE, BleKeyFlag.CREATE, it.next(), false, false, 24, null);
            }
        }
        ProductManager productManager2 = ProductManager.f20544oIX0oI;
        if (productManager2.XOxoX()) {
            BleKey bleKey6 = BleKey.ANTI_LOST;
            BleConnector.sendInt8$default(bleConnector, bleKey6, BleKeyFlag.UPDATE, BleCache.getInt$default(BleCache.INSTANCE, bleKey6, productManager2.xII(), null, 4, null), false, false, 24, null);
        }
        if (productManager2.oox000IX()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.DATE_FORMAT, BleKeyFlag.UPDATE, ProjectManager.f19822oIX0oI.x0XOIxOo().getType(), false, false, 24, null);
        }
        if (productManager2.xxxoo0XI()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.IBEACON_SET, BleKeyFlag.UPDATE, 0, false, false, 24, null);
        }
        if (productManager2.xoIXOxX()) {
            BleConnector.sendData$default(bleConnector, BleKey.HID, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.xXIX0Xo()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.TEMPERATURE_UNIT, BleKeyFlag.UPDATE, productManager2.OO0(), false, false, 24, null);
        }
        if (productManager2.IXI()) {
            BleConnector.sendInt8$default(bleConnector, BleKey.WORLD_CLOCK, BleKeyFlag.READ, 255, false, false, 24, null);
        }
        if (productManager2.IoXO0XoX()) {
            BleConnector.sendData$default(bleConnector, BleKey.POWER_SAVE_MODE, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.xI0OXooO()) {
            BleKey bleKey7 = BleKey.STANDBY_SET;
            BleConnector.sendInt8$default(bleConnector, bleKey7, BleKeyFlag.UPDATE, BleCache.getInt$default(BleCache.INSTANCE, bleKey7, 0, null, 4, null), false, false, 24, null);
        }
        BleInitializer.f20700XO.Ox0O();
        if (productManager2.IIoX0OoI()) {
            BleConnector.sendData$default(bleConnector, BleKey.PACKAGE_STATUS, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.IOo0()) {
            BleConnector.sendData$default(bleConnector, BleKey.SET_WATCH_PASSWORD, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.Oxxo()) {
            BleConnector.sendData$default(bleConnector, BleKey.STANDBY_WATCH_FACE_SET, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.IIIxO()) {
            BleConnector.sendData$default(bleConnector, BleKey.INCOMING_CALL_RING, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.oIXoXx0()) {
            BleConnector.sendData$default(bleConnector, BleKey.GOMORE_SET, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.xoxo()) {
            BleConnector.sendData$default(bleConnector, BleKey.RING_VIBRATION_SET, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.IO0xX()) {
            BleConnector.sendData$default(bleConnector, BleKey.SOS_SET, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.IoxX()) {
            BleKey bleKey8 = BleKey.WEAR_WAY;
            BleConnector.sendInt8$default(bleConnector, bleKey8, BleKeyFlag.UPDATE, BleCache.getInt$default(BleCache.INSTANCE, bleKey8, 0, null, 4, null), false, false, 24, null);
        }
        if (productManager2.oI0X0()) {
            BleConnector.sendData$default(bleConnector, BleKey.GESTURE_WAKE2, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.x00X0xoXO()) {
            BleConnector.sendData$default(bleConnector, BleKey.DOUBLE_SCREEN, BleKeyFlag.READ, null, false, false, 28, null);
        }
        if (productManager2.OxIxx0()) {
            BleQiblaSettings x0xO0oo2 = f20317oIX0oI.x0xO0oo();
            if (x0xO0oo2.getMStartTime() == 0) {
                x0xO0oo2.setMStartTime((int) (System.currentTimeMillis() / 1000));
            }
            BleConnector.sendObject$default(bleConnector, BleKey.QIBLA_SET, BleKeyFlag.UPDATE, x0xO0oo2, false, false, 24, null);
        }
        if (productManager2.o0OO0()) {
            BleKey bleKey9 = BleKey.CALORIES_GOAL;
            BleKeyFlag bleKeyFlag5 = BleKeyFlag.READ;
            BleConnector.sendData$default(bleConnector, bleKey9, bleKeyFlag5, null, false, false, 28, null);
            BleConnector.sendData$default(bleConnector, BleKey.DISTANCE_GOAL, bleKeyFlag5, null, false, false, 28, null);
        }
        if (productManager2.XXooOOI()) {
            BleConnector.sendObject$default(bleConnector, BleKey.TOUCH_SET, BleKeyFlag.UPDATE, f20317oIX0oI.IIXOooo(), false, false, 24, null);
        }
        if (ProductManager.xOOxIO(productManager2, null, 1, null)) {
            BleConnector.sendData$default(bleConnector, BleKey.EARPHONE_KEY, BleKeyFlag.READ, null, false, false, 28, null);
        }
        f20317oIX0oI.xXxxox0I();
    }
}
