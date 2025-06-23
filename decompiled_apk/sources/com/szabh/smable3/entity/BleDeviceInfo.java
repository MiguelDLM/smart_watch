package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.text.TextUtils;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleReadable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.BleKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.StringsKt__StringsKt;
import oI00o.XO;

@XX({"SMAP\nBleDeviceInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleDeviceInfo.kt\ncom/szabh/smable3/entity/BleDeviceInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1240:1\n1549#2:1241\n1620#2,3:1242\n1549#2:1245\n1620#2,3:1246\n*S KotlinDebug\n*F\n+ 1 BleDeviceInfo.kt\ncom/szabh/smable3/entity/BleDeviceInfo\n*L\n619#1:1241\n619#1:1242,3\n751#1:1245\n751#1:1246,3\n*E\n"})
/* loaded from: classes13.dex */
public final class BleDeviceInfo extends BleReadable {
    public static final int AGPS_6228 = 9;
    public static final int AGPS_AGNSS = 6;
    public static final int AGPS_EPO = 1;
    public static final int AGPS_EPO2 = 7;
    public static final int AGPS_LTO = 8;
    public static final int AGPS_NONE = 0;
    public static final int AGPS_UBLOX = 2;
    public static final int ANTI_LOST_HIDE = 0;
    public static final int ANTI_LOST_VISIBLE = 1;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int DIGITAL_POWER_HIDE = 1;
    public static final int DIGITAL_POWER_VISIBLE = 0;

    @OOXIXo
    public static final String PLATFORM_GOODIX = "Goodix";

    @OOXIXo
    public static final String PLATFORM_JL = "JL";

    @OOXIXo
    public static final String PLATFORM_JL707 = "JL707";

    @OOXIXo
    public static final String PLATFORM_JL707LITE = "JL707Lite";

    @OOXIXo
    public static final String PLATFORM_MTK = "MTK";

    @OOXIXo
    public static final String PLATFORM_NORDIC = "Nordic";

    @OOXIXo
    public static final String PLATFORM_REALTEK = "Realtek";

    @OOXIXo
    public static final String PLATFORM_SIFLI = "SIFLI";

    @OOXIXo
    public static final String PLATFORM_ZKLX = "ZKLX";

    @OOXIXo
    public static final String PROTOTYPE_10G = "SMA-10G";

    @OOXIXo
    public static final String PROTOTYPE_A7 = "A7";

    @OOXIXo
    public static final String PROTOTYPE_A8 = "A8";

    @OOXIXo
    public static final String PROTOTYPE_A8_ULTRA_PRO = "A8_Ultra_Pro";

    @OOXIXo
    public static final String PROTOTYPE_A9MINI = "A9mini";

    @OOXIXo
    public static final String PROTOTYPE_AM01 = "AM01";

    @OOXIXo
    public static final String PROTOTYPE_AM01J = "AM01J";

    @OOXIXo
    public static final String PROTOTYPE_AM02J = "AM02J";

    @OOXIXo
    public static final String PROTOTYPE_AM05 = "AM05";

    @OOXIXo
    public static final String PROTOTYPE_AM08 = "AM08";

    @OOXIXo
    public static final String PROTOTYPE_AM11 = "AM11";

    @OOXIXo
    public static final String PROTOTYPE_AM22 = "AM22";

    @OOXIXo
    public static final String PROTOTYPE_AM25 = "AM25";

    @OOXIXo
    public static final String PROTOTYPE_AW37 = "AW37";

    @OOXIXo
    public static final String PROTOTYPE_B5CRT = "SMA-B5CRT";

    @OOXIXo
    public static final String PROTOTYPE_B9 = "B9";

    @OOXIXo
    public static final String PROTOTYPE_B9C_JL = "B9C_JL";

    @OOXIXo
    public static final String PROTOTYPE_BC01 = "BC01";

    @OOXIXo
    public static final String PROTOTYPE_EXPLORER = "Explorer";

    @OOXIXo
    public static final String PROTOTYPE_F1 = "SMA-F1";

    @OOXIXo
    public static final String PROTOTYPE_F11 = "F11";

    @OOXIXo
    public static final String PROTOTYPE_F12 = "F12";

    @OOXIXo
    public static final String PROTOTYPE_F12PRO = "F12Pro";

    @OOXIXo
    public static final String PROTOTYPE_F13 = "SMA-F13";

    @OOXIXo
    public static final String PROTOTYPE_F13A = "F13A";

    @OOXIXo
    public static final String PROTOTYPE_F13B = "F13B";

    @OOXIXo
    public static final String PROTOTYPE_F13J = "F13J";

    @OOXIXo
    public static final String PROTOTYPE_F17 = "F17";

    @OOXIXo
    public static final String PROTOTYPE_F1N = "SMA-F1N";

    @OOXIXo
    public static final String PROTOTYPE_F1RT = "SMA-F1RT";

    @OOXIXo
    public static final String PROTOTYPE_F1_DK = "F1";

    @OOXIXo
    public static final String PROTOTYPE_F2 = "SMA-F2";

    @OOXIXo
    public static final String PROTOTYPE_F2D = "SMA-F2D";

    @OOXIXo
    public static final String PROTOTYPE_F2K = "F2K";

    @OOXIXo
    public static final String PROTOTYPE_F2PRO = "F2Pro";

    @OOXIXo
    public static final String PROTOTYPE_F2R = "SMA-F2R";

    @OOXIXo
    public static final String PROTOTYPE_F2R_DK = "F2R";

    @OOXIXo
    public static final String PROTOTYPE_F3 = "F3";

    @OOXIXo
    public static final String PROTOTYPE_F3C = "SMA-F3C";

    @OOXIXo
    public static final String PROTOTYPE_F3R = "SMA-F3R";

    @OOXIXo
    public static final String PROTOTYPE_F3_LH = "F3-LH";

    @OOXIXo
    public static final String PROTOTYPE_F5 = "F5";

    @OOXIXo
    public static final String PROTOTYPE_F6 = "F6";

    @OOXIXo
    public static final String PROTOTYPE_F7 = "F7";

    @OOXIXo
    public static final String PROTOTYPE_FA86 = "SMA_FA_86";

    @OOXIXo
    public static final String PROTOTYPE_FC1 = "FC1";

    @OOXIXo
    public static final String PROTOTYPE_FC2 = "FC2";

    @OOXIXo
    public static final String PROTOTYPE_FT5 = "FT5";

    @OOXIXo
    public static final String PROTOTYPE_GB1 = "GB1";

    @OOXIXo
    public static final String PROTOTYPE_GTM5 = "SMA-GTM5";

    @OOXIXo
    public static final String PROTOTYPE_HW01 = "HW01";

    @OOXIXo
    public static final String PROTOTYPE_JX621D = "JX621D";

    @OOXIXo
    public static final String PROTOTYPE_K10 = "K10";

    @OOXIXo
    public static final String PROTOTYPE_K18 = "K18";

    @OOXIXo
    public static final String PROTOTYPE_K30 = "K30";

    @OOXIXo
    public static final String PROTOTYPE_LG19T = "SMA-LG19T";

    @OOXIXo
    public static final String PROTOTYPE_M3 = "M3";

    @OOXIXo
    public static final String PROTOTYPE_M4 = "M4";

    @OOXIXo
    public static final String PROTOTYPE_M4C = "M4C";

    @OOXIXo
    public static final String PROTOTYPE_M4S = "M4S";

    @OOXIXo
    public static final String PROTOTYPE_M5C = "M5C";

    @OOXIXo
    public static final String PROTOTYPE_M6 = "M6";

    @OOXIXo
    public static final String PROTOTYPE_M6C = "M6C";

    @OOXIXo
    public static final String PROTOTYPE_M7 = "M7";

    @OOXIXo
    public static final String PROTOTYPE_M7C = "M7C";

    @OOXIXo
    public static final String PROTOTYPE_M7S = "M7S";

    @OOXIXo
    public static final String PROTOTYPE_MATCH_S1 = "Match_S1";

    @OOXIXo
    public static final String PROTOTYPE_MC11 = "SMA_MC_11";

    @OOXIXo
    public static final String PROTOTYPE_ND08 = "SMA-ND08";

    @OOXIXo
    public static final String PROTOTYPE_ND09 = "SMA-ND09";

    @OOXIXo
    public static final String PROTOTYPE_NY58 = "NY58";

    @OOXIXo
    public static final String PROTOTYPE_R10 = "R10";

    @OOXIXo
    public static final String PROTOTYPE_R10PRO = "R10Pro";

    @OOXIXo
    public static final String PROTOTYPE_R11 = "R11";

    @OOXIXo
    public static final String PROTOTYPE_R11S = "R11S";

    @OOXIXo
    public static final String PROTOTYPE_R16 = "R16";

    @OOXIXo
    public static final String PROTOTYPE_R2 = "R2";

    @OOXIXo
    public static final String PROTOTYPE_R3H = "R3H";

    @OOXIXo
    public static final String PROTOTYPE_R3PRO = "R3Pro";

    @OOXIXo
    public static final String PROTOTYPE_R3Q = "R3Q";

    @OOXIXo
    public static final String PROTOTYPE_R4 = "SMA-R4";

    @OOXIXo
    public static final String PROTOTYPE_R5 = "SMA-R5";

    @OOXIXo
    public static final String PROTOTYPE_R6_PRO_DK = "R6_PRO_DK";

    @OOXIXo
    public static final String PROTOTYPE_R7 = "SMA-R7";

    @OOXIXo
    public static final String PROTOTYPE_R9 = "R9";

    @OOXIXo
    public static final String PROTOTYPE_R9J = "R9J";

    @OOXIXo
    public static final String PROTOTYPE_REALTEK_GTM5 = "REALTEK_GTM5";

    @OOXIXo
    public static final String PROTOTYPE_RN01 = "RN01";

    @OOXIXo
    public static final String PROTOTYPE_S03 = "SMA_S03";

    @OOXIXo
    public static final String PROTOTYPE_S2 = "S2";

    @OOXIXo
    public static final String PROTOTYPE_S4 = "S4";

    @OOXIXo
    public static final String PROTOTYPE_SF15GUC = "SF15GUC";

    @OOXIXo
    public static final String PROTOTYPE_SG02G = "SG02G";

    @OOXIXo
    public static final String PROTOTYPE_SG02J = "SG02J";

    @OOXIXo
    public static final String PROTOTYPE_SG02W = "SG02W";

    @OOXIXo
    public static final String PROTOTYPE_SG03J = "SG03J";

    @OOXIXo
    public static final String PROTOTYPE_SPORT4 = "Sport4";

    @OOXIXo
    public static final String PROTOTYPE_SW01 = "SMA-SW01";

    @OOXIXo
    public static final String PROTOTYPE_T78 = "T78";

    @OOXIXo
    public static final String PROTOTYPE_V1 = "SMA-V1";

    @OOXIXo
    public static final String PROTOTYPE_V2 = "V2";

    @OOXIXo
    public static final String PROTOTYPE_V3 = "V3";

    @OOXIXo
    public static final String PROTOTYPE_V5 = "V5";

    @OOXIXo
    public static final String PROTOTYPE_V61 = "V61";

    @OOXIXo
    public static final String PROTOTYPE_W9 = "W9";

    @OOXIXo
    public static final String PROTOTYPE_WS001 = "WS001";

    @OOXIXo
    public static final String PROTOTYPE_X2 = "X2";

    @OOXIXo
    public static final String PROTOTYPE_X3 = "X3";

    @OOXIXo
    public static final String PROTOTYPE_X5L = "X5L";

    @OOXIXo
    public static final String PROTOTYPE_X6 = "X6";

    @OOXIXo
    public static final String PROTOTYPE_Y1 = "Y1";

    @OOXIXo
    public static final String PROTOTYPE_Y2 = "Y2";

    @OOXIXo
    public static final String PROTOTYPE_Y3 = "Y3";

    @OOXIXo
    public static final String RAW_NAME_SEPARATOR = "<>";
    public static final int SUPPORT_2D_ACCELERATION_0 = 0;
    public static final int SUPPORT_2D_ACCELERATION_1 = 1;
    public static final int SUPPORT_AI_COACH_0 = 0;
    public static final int SUPPORT_AI_COACH_1 = 1;
    public static final int SUPPORT_AI_TRANSLATION_0 = 0;
    public static final int SUPPORT_AI_TRANSLATION_1 = 1;
    public static final int SUPPORT_ALIPAY_0 = 0;
    public static final int SUPPORT_ALIPAY_1 = 1;
    public static final int SUPPORT_APP_SPORT_0 = 0;
    public static final int SUPPORT_APP_SPORT_1 = 1;
    public static final int SUPPORT_APP_STORE_0 = 0;
    public static final int SUPPORT_APP_STORE_1 = 1;
    public static final int SUPPORT_AUDIO_BOOKS_0 = 0;
    public static final int SUPPORT_AUDIO_BOOKS_1 = 1;
    public static final int SUPPORT_BATTERY_USAGE_0 = 0;
    public static final int SUPPORT_BATTERY_USAGE_1 = 1;
    public static final int SUPPORT_BLOOD_OXYGEN_0 = 0;
    public static final int SUPPORT_BLOOD_OXYGEN_1 = 1;
    public static final int SUPPORT_BLOOD_PRESSURE_CALIBRATION_0 = 0;
    public static final int SUPPORT_BLOOD_PRESSURE_CALIBRATION_1 = 1;
    public static final int SUPPORT_CHANGE_CLASSIC_BLUETOOTH_STATE_0 = 0;
    public static final int SUPPORT_CHANGE_CLASSIC_BLUETOOTH_STATE_1 = 1;
    public static final int SUPPORT_CONNECT_REMINDER_0 = 0;
    public static final int SUPPORT_CONNECT_REMINDER_1 = 1;
    public static final int SUPPORT_CONTACT_SORT_0 = 0;
    public static final int SUPPORT_CONTACT_SORT_1 = 1;
    public static final int SUPPORT_CROSS_APP_TRANSLATION_0 = 0;
    public static final int SUPPORT_CROSS_APP_TRANSLATION_1 = 1;
    public static final int SUPPORT_CUSTOM_LOGO_0 = 0;
    public static final int SUPPORT_CUSTOM_LOGO_1 = 1;
    public static final int SUPPORT_DATE_FORMAT_0 = 0;
    public static final int SUPPORT_DATE_FORMAT_1 = 1;
    public static final int SUPPORT_DEVICE_SPORT_DATA_0 = 0;
    public static final int SUPPORT_DEVICE_SPORT_DATA_1 = 1;
    public static final int SUPPORT_DOUBLE_SCREEN_0 = 0;
    public static final int SUPPORT_DOUBLE_SCREEN_1 = 1;
    public static final int SUPPORT_DRINK_WATER_0 = 0;
    public static final int SUPPORT_DRINK_WATER_1 = 1;
    public static final int SUPPORT_EBOOK_TRANSFER_0 = 0;
    public static final int SUPPORT_EBOOK_TRANSFER_1 = 1;
    public static final int SUPPORT_FALL_SET_0 = 0;
    public static final int SUPPORT_FALL_SET_1 = 1;
    public static final int SUPPORT_FIND_WATCH_0 = 0;
    public static final int SUPPORT_FIND_WATCH_1 = 1;
    public static final int SUPPORT_GAME_CONTROL_0 = 0;
    public static final int SUPPORT_GAME_CONTROL_1 = 1;
    public static final int SUPPORT_GAME_TIME_REMINDER_0 = 0;
    public static final int SUPPORT_GAME_TIME_REMINDER_1 = 1;
    public static final int SUPPORT_GESTUREWAKE2_0 = 0;
    public static final int SUPPORT_GESTUREWAKE2_1 = 1;
    public static final int SUPPORT_GIRLCARE_REMINDER_0 = 0;
    public static final int SUPPORT_GIRLCARE_REMINDER_1 = 1;
    public static final int SUPPORT_GIRL_CARE_MONTHLY_0 = 0;
    public static final int SUPPORT_GIRL_CARE_MONTHLY_1 = 1;
    public static final int SUPPORT_GOMORE_SET_0 = 0;
    public static final int SUPPORT_GOMORE_SET_1 = 1;
    public static final int SUPPORT_GPS_FIRMWARE_FILE_0 = 0;
    public static final int SUPPORT_GPS_FIRMWARE_FILE_1 = 1;
    public static final int SUPPORT_HID_0 = 0;
    public static final int SUPPORT_HID_1 = 1;
    public static final int SUPPORT_HR_WARN_SET_0 = 0;
    public static final int SUPPORT_HR_WARN_SET_1 = 1;
    public static final int SUPPORT_IBEACON_SET_0 = 0;
    public static final int SUPPORT_IBEACON_SET_1 = 1;
    public static final int SUPPORT_IMEI_SET_0 = 0;
    public static final int SUPPORT_IMEI_SET_1 = 1;
    public static final int SUPPORT_INCOMING_CALL_RING_0 = 0;
    public static final int SUPPORT_INCOMING_CALL_RING_1 = 1;
    public static final int SUPPORT_JL_TRANSPORT_0 = 0;
    public static final int SUPPORT_JL_TRANSPORT_1 = 1;
    public static final int SUPPORT_LOVE_TAP_0 = 0;
    public static final int SUPPORT_LOVE_TAP_1 = 1;
    public static final int SUPPORT_MEASUREMENT_BLOOD_GLUCOSE_0 = 0;
    public static final int SUPPORT_MEASUREMENT_BLOOD_GLUCOSE_1 = 1;
    public static final int SUPPORT_MEDICATION_ALARM_0 = 0;
    public static final int SUPPORT_MEDICATION_ALARM_1 = 1;
    public static final int SUPPORT_MEDICATION_REMINDER_0 = 0;
    public static final int SUPPORT_MEDICATION_REMINDER_1 = 1;
    public static final int SUPPORT_MUSIC_TRANSFER_0 = 0;
    public static final int SUPPORT_MUSIC_TRANSFER_1 = 1;
    public static final int SUPPORT_NAVIGATION_0 = 0;
    public static final int SUPPORT_NAVIGATION_1 = 1;
    public static final int SUPPORT_NAV_IMAGE_0 = 0;
    public static final int SUPPORT_NAV_IMAGE_1 = 1;
    public static final int SUPPORT_NETWORK_0 = 0;
    public static final int SUPPORT_NETWORK_1 = 1;
    public static final int SUPPORT_NEWS_FEED_0 = 0;
    public static final int SUPPORT_NEWS_FEED_1 = 1;
    public static final int SUPPORT_NEW_SLEEP_ALGORITHM_0 = 0;
    public static final int SUPPORT_NEW_SLEEP_ALGORITHM_1 = 1;
    public static final int SUPPORT_NOTIFICATION_LIGHT_SCREEN_SET_0 = 0;
    public static final int SUPPORT_NOTIFICATION_LIGHT_SCREEN_SET_1 = 1;
    public static final int SUPPORT_NO_DISTURB2_0 = 0;
    public static final int SUPPORT_NO_DISTURB2_1 = 1;
    public static final int SUPPORT_NO_DISTURB_0 = 0;
    public static final int SUPPORT_NO_DISTURB_1 = 1;
    public static final int SUPPORT_OTA_FILE_0 = 0;
    public static final int SUPPORT_OTA_FILE_1 = 1;
    public static final int SUPPORT_POWER2_0 = 0;
    public static final int SUPPORT_POWER2_1 = 1;
    public static final int SUPPORT_POWER_SAVE_MODE_0 = 0;
    public static final int SUPPORT_POWER_SAVE_MODE_1 = 1;
    public static final int SUPPORT_PRESSURE_TIMING_MEASUREMENT_0 = 0;
    public static final int SUPPORT_PRESSURE_TIMING_MEASUREMENT_1 = 1;
    public static final int SUPPORT_QIBLA_SET_0 = 0;
    public static final int SUPPORT_QIBLA_SET_1 = 1;
    public static final int SUPPORT_QRCODE_0 = 0;
    public static final int SUPPORT_QRCODE_1 = 1;
    public static final int SUPPORT_QURAN_0 = 0;
    public static final int SUPPORT_QURAN_1 = 1;
    public static final int SUPPORT_READ_DEVICE_INFO_0 = 0;
    public static final int SUPPORT_READ_DEVICE_INFO_1 = 1;
    public static final int SUPPORT_READ_LANGUAGES_0 = 0;
    public static final int SUPPORT_READ_LANGUAGES_1 = 1;
    public static final int SUPPORT_READ_PACKAGE_STATUS_0 = 0;
    public static final int SUPPORT_READ_PACKAGE_STATUS_1 = 1;
    public static final int SUPPORT_REALTIME_MEASUREMENT_0 = 0;
    public static final int SUPPORT_REALTIME_MEASUREMENT_1 = 1;
    public static final int SUPPORT_RECORD_NOTE_0 = 0;
    public static final int SUPPORT_RECORD_NOTE_1 = 1;
    public static final int SUPPORT_RELAX_REMINDER_0 = 0;
    public static final int SUPPORT_RELAX_REMINDER_1 = 1;
    public static final int SUPPORT_REQUEST_REALTIME_WEATHER_0 = 0;
    public static final int SUPPORT_REQUEST_REALTIME_WEATHER_1 = 1;
    public static final int SUPPORT_RESTORE_FACTORY_0 = 0;
    public static final int SUPPORT_RESTORE_FACTORY_1 = 1;
    public static final int SUPPORT_RING_VIBRATION_SET_0 = 0;
    public static final int SUPPORT_RING_VIBRATION_SET_1 = 1;
    public static final int SUPPORT_SDCARD_INFO_0 = 0;
    public static final int SUPPORT_SDCARD_INFO_1 = 1;
    public static final int SUPPORT_SET_WATCH_PASSWORD_0 = 0;
    public static final int SUPPORT_SET_WATCH_PASSWORD_1 = 1;
    public static final int SUPPORT_SHSY_ALGORITHM_0 = 0;
    public static final int SUPPORT_SHSY_ALGORITHM_1 = 1;
    public static final int SUPPORT_SIMULTANEOUS_TRANSLATION_0 = 0;
    public static final int SUPPORT_SIMULTANEOUS_TRANSLATION_1 = 1;
    public static final int SUPPORT_SLEEP_SCORE_0 = 0;
    public static final int SUPPORT_SLEEP_SCORE_1 = 1;
    public static final int SUPPORT_SMS_QUICK_REPLY_0 = 0;
    public static final int SUPPORT_SMS_QUICK_REPLY_1 = 1;
    public static final int SUPPORT_SOS_CONTACT_0 = 0;
    public static final int SUPPORT_SOS_CONTACT_1 = 1;
    public static final int SUPPORT_SOS_SET_0 = 0;
    public static final int SUPPORT_SOS_SET_1 = 1;
    public static final int SUPPORT_STANDBY_SET_0 = 0;
    public static final int SUPPORT_STANDBY_SET_1 = 1;
    public static final int SUPPORT_STOCK_0 = 0;
    public static final int SUPPORT_STOCK_1 = 1;
    public static final int SUPPORT_STRING_QRCODE_0 = 0;
    public static final int SUPPORT_STRING_QRCODE_1 = 1;
    public static final int SUPPORT_STUDY_CARDS_0 = 0;
    public static final int SUPPORT_STUDY_CARDS_1 = 1;
    public static final int SUPPORT_SYNC_AGPS_IN_BACKGROUND_0 = 0;
    public static final int SUPPORT_SYNC_AGPS_IN_BACKGROUND_1 = 1;
    public static final int SUPPORT_TEMPERATURE_UNIT_0 = 0;
    public static final int SUPPORT_TEMPERATURE_UNIT_1 = 1;
    public static final int SUPPORT_TIMER_STANDBYSET_0 = 0;
    public static final int SUPPORT_TIMER_STANDBYSET_1 = 1;
    public static final int SUPPORT_TOUCH_SET_0 = 0;
    public static final int SUPPORT_TOUCH_SET_1 = 1;
    public static final int SUPPORT_TUYA_KEY_0 = 0;
    public static final int SUPPORT_TUYA_KEY_1 = 1;
    public static final int SUPPORT_VOICE_0 = 0;
    public static final int SUPPORT_VOICE_1 = 1;
    public static final int SUPPORT_VOICE_MAX_LENGTH_0 = 0;
    public static final int SUPPORT_VOICE_MAX_LENGTH_1 = 1;
    public static final int SUPPORT_WALK_BIKE_0 = 0;
    public static final int SUPPORT_WALK_BIKE_1 = 1;
    public static final int SUPPORT_WASH_0 = 0;
    public static final int SUPPORT_WASH_1 = 1;
    public static final int SUPPORT_WATCHFACE2_0 = 0;
    public static final int SUPPORT_WATCHFACE2_1 = 1;
    public static final int SUPPORT_WATCHFACE_ID_0 = 0;
    public static final int SUPPORT_WATCHFACE_ID_1 = 1;
    public static final int SUPPORT_WATCHFACE_INDEX_0 = 0;
    public static final int SUPPORT_WATCHFACE_INDEX_1 = 1;
    public static final int SUPPORT_WEAR_WAY_0 = 0;
    public static final int SUPPORT_WEAR_WAY_1 = 1;
    public static final int SUPPORT_WEATHER2_0 = 0;
    public static final int SUPPORT_WEATHER2_1 = 1;
    public static final int SUPPORT_WORLD_CLOCK_0 = 0;
    public static final int SUPPORT_WORLD_CLOCK_1 = 1;
    public static final int WATCH_0 = 0;
    public static final int WATCH_1 = 1;
    public static final int WATCH_10 = 10;
    public static final int WATCH_11 = 11;
    public static final int WATCH_12 = 12;
    public static final int WATCH_13 = 13;
    public static final int WATCH_14 = 14;
    public static final int WATCH_15 = 15;
    public static final int WATCH_16 = 16;
    public static final int WATCH_17 = 17;
    public static final int WATCH_18 = 18;
    public static final int WATCH_19 = 19;
    public static final int WATCH_2 = 2;
    public static final int WATCH_20 = 20;
    public static final int WATCH_21 = 21;
    public static final int WATCH_3 = 3;
    public static final int WATCH_4 = 4;
    public static final int WATCH_5 = 5;
    public static final int WATCH_6 = 6;
    public static final int WATCH_7 = 7;
    public static final int WATCH_8 = 8;
    public static final int WATCH_9 = 9;
    public static final int WATCH_99 = 99;
    private int mAGpsType;

    @OOXIXo
    private String mBleAddress;

    @OOXIXo
    private String mBleCustomName;

    @OOXIXo
    private String mBleDefaultName;

    @OOXIXo
    private String mBleName;

    @OOXIXo
    private String mClassicAddress;

    @OOXIXo
    private List<Integer> mDataKeys;

    @OOXIXo
    private String mFirmwareFlag;
    private int mHideDigitalPower;
    private long mIOBufferSize;
    private int mId;

    @OOXIXo
    private String mPlatform;

    @OOXIXo
    private String mPrototype;
    private int mQrcodeContentSize;
    private int mQrcodeSize;
    private int mShowAntiLostSwitch;
    private int mSleepAlgorithmType;
    private int mSupport2DAcceleration;
    private int mSupportAICoach;
    private int mSupportAITranslation;
    private int mSupportAlipay;
    private int mSupportAppPushSwitch;
    private int mSupportAppSport;
    private int mSupportAppStore;
    private int mSupportAudioBooks;
    private int mSupportBatteryUsage;
    private int mSupportBloodOxyGenSet;
    private int mSupportBloodPressureCalibration;
    private int mSupportChangeClassicBluetoothState;
    private int mSupportConnectReminder;
    private int mSupportContactSize;
    private int mSupportContactSort;
    private int mSupportCrossAppTranslation;
    private int mSupportCustomLogo;
    private int mSupportDateFormatSet;
    private int mSupportDeviceSportData;
    private int mSupportDoubleScreen;
    private int mSupportDrinkWaterSet;
    private int mSupportEbookTransfer;
    private int mSupportFallSet;
    private int mSupportFindWatch;
    private int mSupportGPSFirmwareFile;
    private int mSupportGameControls;
    private int mSupportGameTimeReminder;
    private int mSupportGestureWake2;
    private int mSupportGirlCareMonthly;
    private int mSupportGirlCareReminder;
    private int mSupportGoMoreSet;
    private int mSupportHID;
    private int mSupportHrWarnSet;
    private int mSupportIBeaconSet;
    private int mSupportIMEISet;
    private int mSupportIncomingCallRing;
    private int mSupportJLTransport;
    private int mSupportLoveTap;
    private int mSupportMeasurementBloodGlucose;
    private int mSupportMedicationAlarm;
    private int mSupportMedicationReminder;
    private int mSupportMusicTransfer;
    private int mSupportMyCardCodeSize;
    private int mSupportNavImage;
    private int mSupportNavigation;
    private int mSupportNetwork;
    private int mSupportNewTransportMode;
    private int mSupportNewsfeed;
    private int mSupportNoDisturbSet;
    private int mSupportNoDisturbSet2;
    private int mSupportNotificationLightScreenSet;
    private int mSupportOTAFile;
    private int mSupportPower2;
    private int mSupportPowerSaveMode;
    private int mSupportPressureTimingMeasurement;
    private int mSupportQiblaSet;
    private int mSupportQrcode;
    private int mSupportQuran;
    private int mSupportReadDeviceInfo;
    private int mSupportReadLanguages;
    private int mSupportReadPackageStatus;
    private int mSupportRealTimeMeasurement;
    private int mSupportReceiptCodeSize;
    private int mSupportRecordNote;
    private int mSupportRelaxReminder;
    private int mSupportRequestRealtimeWeather;
    private int mSupportRestoreFactory;
    private int mSupportRingVibrationSet;
    private int mSupportSDCardInfo;
    private int mSupportSHSYAlgorithm;
    private int mSupportSMSQuickReply;
    private int mSupportSOSSet;
    private int mSupportSOSSet2;
    private int mSupportSetWatchPassword;
    private int mSupportSimultaneousTranslation;
    private int mSupportSleepScore;
    private int mSupportSosContact;
    private int mSupportStandbySet;
    private int mSupportStock;
    private int mSupportStringQrcode;
    private int mSupportStudyCards;
    private int mSupportSyncAGPSInBackground;
    private int mSupportTemperatureUnitSet;
    private int mSupportTimerStandbySet;
    private int mSupportTouchSet;
    private int mSupportTuyaKey;
    private int mSupportVoice;
    private int mSupportVoiceMaxLength;
    private int mSupportWalkAndBike;
    private int mSupportWashSet;
    private int mSupportWatchFaceId;
    private int mSupportWatchFaceIndex;
    private int mSupportWatchface2;
    private int mSupportWearWay;
    private int mSupportWeather2;
    private int mSupportWorldClock;
    private int mWatchFaceType;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleDeviceInfo() {
        this(0, null, null, null, null, null, null, null, 0, 0L, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, XO.f31358oIX0oI, null);
    }

    private final String component53() {
        return this.mBleDefaultName;
    }

    @kotlin.OOXIXo(message = "已废弃")
    public static /* synthetic */ void getMSupportSOSSet$annotations() {
    }

    public final int component1() {
        return this.mId;
    }

    public final long component10() {
        return this.mIOBufferSize;
    }

    public final int component100() {
        return this.mSupportBatteryUsage;
    }

    public final int component101() {
        return this.mSupportAITranslation;
    }

    public final int component102() {
        return this.mSupportSimultaneousTranslation;
    }

    public final int component103() {
        return this.mSupportTouchSet;
    }

    public final int component104() {
        return this.mSupportIMEISet;
    }

    public final int component105() {
        return this.mSupportQuran;
    }

    public final int component106() {
        return this.mSupportSyncAGPSInBackground;
    }

    public final int component107() {
        return this.mSupportRestoreFactory;
    }

    public final int component108() {
        return this.mSupportRecordNote;
    }

    public final int component109() {
        return this.mSupportSleepScore;
    }

    public final int component11() {
        return this.mWatchFaceType;
    }

    public final int component110() {
        return this.mSupportWatchface2;
    }

    public final int component111() {
        return this.mSupportAICoach;
    }

    public final int component112() {
        return this.mSupportCrossAppTranslation;
    }

    public final int component113() {
        return this.mSupportRelaxReminder;
    }

    public final int component114() {
        return this.mSupportPower2;
    }

    @OOXIXo
    public final String component12() {
        return this.mClassicAddress;
    }

    public final int component13() {
        return this.mHideDigitalPower;
    }

    public final int component14() {
        return this.mShowAntiLostSwitch;
    }

    public final int component15() {
        return this.mSleepAlgorithmType;
    }

    public final int component16() {
        return this.mSupportDateFormatSet;
    }

    public final int component17() {
        return this.mSupportReadDeviceInfo;
    }

    public final int component18() {
        return this.mSupportTemperatureUnitSet;
    }

    public final int component19() {
        return this.mSupportDrinkWaterSet;
    }

    @OOXIXo
    public final List<Integer> component2() {
        return this.mDataKeys;
    }

    public final int component20() {
        return this.mSupportChangeClassicBluetoothState;
    }

    public final int component21() {
        return this.mSupportAppSport;
    }

    public final int component22() {
        return this.mSupportBloodOxyGenSet;
    }

    public final int component23() {
        return this.mSupportWashSet;
    }

    public final int component24() {
        return this.mSupportRequestRealtimeWeather;
    }

    public final int component25() {
        return this.mSupportHID;
    }

    public final int component26() {
        return this.mSupportIBeaconSet;
    }

    public final int component27() {
        return this.mSupportWatchFaceId;
    }

    public final int component28() {
        return this.mSupportNewTransportMode;
    }

    public final int component29() {
        return this.mSupportJLTransport;
    }

    @OOXIXo
    public final String component3() {
        return this.mBleName;
    }

    public final int component30() {
        return this.mSupportFindWatch;
    }

    public final int component31() {
        return this.mSupportWorldClock;
    }

    public final int component32() {
        return this.mSupportStock;
    }

    public final int component33() {
        return this.mSupportSMSQuickReply;
    }

    public final int component34() {
        return this.mSupportNoDisturbSet;
    }

    public final int component35() {
        return this.mSupportSetWatchPassword;
    }

    public final int component36() {
        return this.mSupportRealTimeMeasurement;
    }

    public final int component37() {
        return this.mSupportPowerSaveMode;
    }

    public final int component38() {
        return this.mSupportLoveTap;
    }

    public final int component39() {
        return this.mSupportNewsfeed;
    }

    @OOXIXo
    public final String component4() {
        return this.mBleCustomName;
    }

    public final int component40() {
        return this.mSupportMedicationReminder;
    }

    public final int component41() {
        return this.mSupportQrcode;
    }

    public final int component42() {
        return this.mSupportWeather2;
    }

    public final int component43() {
        return this.mSupportAlipay;
    }

    public final int component44() {
        return this.mSupportStandbySet;
    }

    public final int component45() {
        return this.mSupport2DAcceleration;
    }

    public final int component46() {
        return this.mSupportTuyaKey;
    }

    public final int component47() {
        return this.mSupportMedicationAlarm;
    }

    public final int component48() {
        return this.mSupportReadPackageStatus;
    }

    public final int component49() {
        return this.mSupportContactSize;
    }

    @OOXIXo
    public final String component5() {
        return this.mBleAddress;
    }

    public final int component50() {
        return this.mSupportVoice;
    }

    public final int component51() {
        return this.mSupportNavigation;
    }

    public final int component52() {
        return this.mSupportHrWarnSet;
    }

    public final int component54() {
        return this.mSupportMusicTransfer;
    }

    public final int component55() {
        return this.mSupportNoDisturbSet2;
    }

    public final int component56() {
        return this.mSupportSOSSet;
    }

    public final int component57() {
        return this.mSupportReadLanguages;
    }

    public final int component58() {
        return this.mSupportGirlCareReminder;
    }

    public final int component59() {
        return this.mSupportAppPushSwitch;
    }

    @OOXIXo
    public final String component6() {
        return this.mPlatform;
    }

    public final int component60() {
        return this.mSupportReceiptCodeSize;
    }

    public final int component61() {
        return this.mSupportGameTimeReminder;
    }

    public final int component62() {
        return this.mSupportMyCardCodeSize;
    }

    public final int component63() {
        return this.mSupportDeviceSportData;
    }

    public final int component64() {
        return this.mSupportEbookTransfer;
    }

    public final int component65() {
        return this.mSupportDoubleScreen;
    }

    public final int component66() {
        return this.mSupportCustomLogo;
    }

    public final int component67() {
        return this.mSupportPressureTimingMeasurement;
    }

    public final int component68() {
        return this.mSupportTimerStandbySet;
    }

    public final int component69() {
        return this.mSupportSOSSet2;
    }

    @OOXIXo
    public final String component7() {
        return this.mPrototype;
    }

    public final int component70() {
        return this.mSupportFallSet;
    }

    public final int component71() {
        return this.mSupportWalkAndBike;
    }

    public final int component72() {
        return this.mSupportConnectReminder;
    }

    public final int component73() {
        return this.mSupportSDCardInfo;
    }

    public final int component74() {
        return this.mSupportIncomingCallRing;
    }

    public final int component75() {
        return this.mSupportNotificationLightScreenSet;
    }

    public final int component76() {
        return this.mSupportBloodPressureCalibration;
    }

    public final int component77() {
        return this.mSupportOTAFile;
    }

    public final int component78() {
        return this.mSupportGPSFirmwareFile;
    }

    public final int component79() {
        return this.mSupportGoMoreSet;
    }

    @OOXIXo
    public final String component8() {
        return this.mFirmwareFlag;
    }

    public final int component80() {
        return this.mSupportRingVibrationSet;
    }

    public final int component81() {
        return this.mSupportNetwork;
    }

    public final int component82() {
        return this.mSupportContactSort;
    }

    public final int component83() {
        return this.mQrcodeSize;
    }

    public final int component84() {
        return this.mQrcodeContentSize;
    }

    public final int component85() {
        return this.mSupportStringQrcode;
    }

    public final int component86() {
        return this.mSupportWatchFaceIndex;
    }

    public final int component87() {
        return this.mSupportSosContact;
    }

    public final int component88() {
        return this.mSupportGirlCareMonthly;
    }

    public final int component89() {
        return this.mSupportWearWay;
    }

    public final int component9() {
        return this.mAGpsType;
    }

    public final int component90() {
        return this.mSupportGestureWake2;
    }

    public final int component91() {
        return this.mSupportNavImage;
    }

    public final int component92() {
        return this.mSupportVoiceMaxLength;
    }

    public final int component93() {
        return this.mSupportAudioBooks;
    }

    public final int component94() {
        return this.mSupportStudyCards;
    }

    public final int component95() {
        return this.mSupportAppStore;
    }

    public final int component96() {
        return this.mSupportSHSYAlgorithm;
    }

    public final int component97() {
        return this.mSupportQiblaSet;
    }

    public final int component98() {
        return this.mSupportMeasurementBloodGlucose;
    }

    public final int component99() {
        return this.mSupportGameControls;
    }

    @OOXIXo
    public final BleDeviceInfo copy(int i, @OOXIXo List<Integer> mDataKeys, @OOXIXo String mBleName, @OOXIXo String mBleCustomName, @OOXIXo String mBleAddress, @OOXIXo String mPlatform, @OOXIXo String mPrototype, @OOXIXo String mFirmwareFlag, int i2, long j, int i3, @OOXIXo String mClassicAddress, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, @OOXIXo String mBleDefaultName, int i44, int i45, int i46, int i47, int i48, int i49, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, int i62, int i63, int i64, int i65, int i66, int i67, int i68, int i69, int i70, int i71, int i72, int i73, int i74, int i75, int i76, int i77, int i78, int i79, int i80, int i81, int i82, int i83, int i84, int i85, int i86, int i87, int i88, int i89, int i90, int i91, int i92, int i93, int i94, int i95, int i96, int i97, int i98, int i99, int i100, int i101, int i102, int i103, int i104) {
        IIX0o.x0xO0oo(mDataKeys, "mDataKeys");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mBleCustomName, "mBleCustomName");
        IIX0o.x0xO0oo(mBleAddress, "mBleAddress");
        IIX0o.x0xO0oo(mPlatform, "mPlatform");
        IIX0o.x0xO0oo(mPrototype, "mPrototype");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mClassicAddress, "mClassicAddress");
        IIX0o.x0xO0oo(mBleDefaultName, "mBleDefaultName");
        return new BleDeviceInfo(i, mDataKeys, mBleName, mBleCustomName, mBleAddress, mPlatform, mPrototype, mFirmwareFlag, i2, j, i3, mClassicAddress, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, mBleDefaultName, i44, i45, i46, i47, i48, i49, i50, i51, i52, i53, i54, i55, i56, i57, i58, i59, i60, i61, i62, i63, i64, i65, i66, i67, i68, i69, i70, i71, i72, i73, i74, i75, i76, i77, i78, i79, i80, i81, i82, i83, i84, i85, i86, i87, i88, i89, i90, i91, i92, i93, i94, i95, i96, i97, i98, i99, i100, i101, i102, i103, i104);
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mId = BleReadable.readInt32$default(this, null, 1, null);
        List<List> OxXXx0X2 = CollectionsKt___CollectionsKt.OxXXx0X(ArraysKt___ArraysKt.oIIxOxXOo(readBytesUtil((byte) 0)), 2);
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(OxXXx0X2, 10));
        for (List list : OxXXx0X2) {
            arrayList.add(Integer.valueOf((((Number) list.get(1)).byteValue() & 255) | ((((Number) list.get(0)).byteValue() & 255) << 8)));
        }
        this.mDataKeys = arrayList;
        this.mBleName = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        String readStringUtil$default = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        Locale locale = Locale.getDefault();
        IIX0o.oO(locale, "getDefault(...)");
        String upperCase = readStringUtil$default.toUpperCase(locale);
        IIX0o.oO(upperCase, "toUpperCase(...)");
        this.mBleAddress = upperCase;
        this.mPlatform = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mPrototype = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mFirmwareFlag = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mAGpsType = readInt8();
        this.mIOBufferSize = BleReadable.readUInt16$default(this, null, 1, null);
        this.mWatchFaceType = readInt8();
        String readStringUtil$default2 = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        Locale locale2 = Locale.getDefault();
        IIX0o.oO(locale2, "getDefault(...)");
        String upperCase2 = readStringUtil$default2.toUpperCase(locale2);
        IIX0o.oO(upperCase2, "toUpperCase(...)");
        this.mClassicAddress = upperCase2;
        this.mHideDigitalPower = readInt8();
        this.mShowAntiLostSwitch = readInt8();
        this.mSleepAlgorithmType = readInt8();
        this.mSupportDateFormatSet = readInt8();
        this.mSupportReadDeviceInfo = readInt8();
        this.mSupportTemperatureUnitSet = readInt8();
        this.mSupportDrinkWaterSet = readInt8();
        this.mSupportChangeClassicBluetoothState = readInt8();
        this.mSupportAppSport = readInt8();
        this.mSupportBloodOxyGenSet = readInt8();
        this.mSupportWashSet = readInt8();
        this.mSupportRequestRealtimeWeather = readInt8();
        this.mSupportHID = readInt8();
        this.mSupportIBeaconSet = readInt8();
        this.mSupportWatchFaceId = readInt8();
        this.mSupportNewTransportMode = readInt8();
        this.mSupportJLTransport = readInt8();
        this.mSupportFindWatch = readInt8();
        this.mSupportWorldClock = readInt8();
        this.mSupportStock = readInt8();
        this.mSupportSMSQuickReply = readInt8();
        this.mSupportNoDisturbSet = readInt8();
        this.mSupportSetWatchPassword = readInt8();
        this.mSupportRealTimeMeasurement = readInt8();
        this.mSupportPowerSaveMode = readInt8();
        this.mSupportLoveTap = readInt8();
        this.mSupportNewsfeed = readInt8();
        this.mSupportMedicationReminder = readInt8();
        this.mSupportQrcode = readInt8();
        this.mSupportWeather2 = readInt8();
        this.mSupportAlipay = readInt8();
        this.mSupportStandbySet = readInt8();
        this.mSupport2DAcceleration = readInt8();
        this.mSupportTuyaKey = readInt8();
        this.mSupportMedicationAlarm = readInt8();
        this.mSupportReadPackageStatus = readInt8();
        this.mSupportContactSize = readInt8() * 10;
        this.mSupportVoice = readInt8();
        this.mSupportNavigation = readInt8();
        this.mSupportHrWarnSet = readInt8();
        if (StringsKt__StringsKt.o00xOoIO(this.mFirmwareFlag, RAW_NAME_SEPARATOR, false, 2, null)) {
            String str = (String) StringsKt__StringsKt.XXoO0oX(this.mFirmwareFlag, new String[]{RAW_NAME_SEPARATOR}, false, 0, 6, null).get(1);
            if (!TextUtils.isEmpty(str) && !IIX0o.Oxx0IOOO(str, this.mBleName)) {
                this.mBleCustomName = this.mBleName;
                this.mBleName = str;
            }
        }
        String readStringUtil$default3 = BleReadable.readStringUtil$default(this, (byte) 0, null, 2, null);
        this.mBleDefaultName = readStringUtil$default3;
        if (!TextUtils.isEmpty(readStringUtil$default3)) {
            this.mBleCustomName = this.mBleName;
            this.mBleName = this.mBleDefaultName;
        }
        this.mSupportMusicTransfer = readInt8();
        this.mSupportNoDisturbSet2 = readInt8();
        this.mSupportSOSSet = readInt8();
        this.mSupportReadLanguages = readInt8();
        this.mSupportGirlCareReminder = readInt8();
        this.mSupportAppPushSwitch = readInt8();
        this.mSupportReceiptCodeSize = readInt8();
        this.mSupportGameTimeReminder = readInt8();
        this.mSupportMyCardCodeSize = readInt8();
        this.mSupportDeviceSportData = readInt8();
        this.mSupportEbookTransfer = readInt8();
        this.mSupportDoubleScreen = readInt8();
        this.mSupportCustomLogo = readInt8();
        this.mSupportPressureTimingMeasurement = readInt8();
        this.mSupportTimerStandbySet = readInt8();
        this.mSupportSOSSet2 = readInt8();
        this.mSupportFallSet = readInt8();
        this.mSupportWalkAndBike = readInt8();
        this.mSupportConnectReminder = readInt8();
        this.mSupportSDCardInfo = readInt8();
        this.mSupportIncomingCallRing = readInt8();
        this.mSupportNotificationLightScreenSet = readInt8();
        this.mSupportBloodPressureCalibration = readInt8();
        this.mSupportOTAFile = readInt8();
        this.mSupportGPSFirmwareFile = readInt8();
        this.mSupportGoMoreSet = readInt8();
        this.mSupportRingVibrationSet = readInt8();
        this.mSupportNetwork = readInt8();
        this.mSupportContactSort = readInt8();
        this.mQrcodeSize = readInt8();
        this.mQrcodeContentSize = readUInt8();
        this.mSupportStringQrcode = readInt8();
        this.mSupportWatchFaceIndex = readInt8();
        this.mSupportSosContact = readInt8();
        this.mSupportGirlCareMonthly = readInt8();
        this.mSupportWearWay = readInt8();
        this.mSupportGestureWake2 = readInt8();
        this.mSupportNavImage = readInt8();
        this.mSupportVoiceMaxLength = readInt8();
        this.mSupportAudioBooks = readInt8();
        this.mSupportStudyCards = readInt8();
        this.mSupportAppStore = readInt8();
        this.mSupportSHSYAlgorithm = readInt8();
        this.mSupportQiblaSet = readInt8();
        this.mSupportMeasurementBloodGlucose = readInt8();
        this.mSupportGameControls = readInt8();
        this.mSupportBatteryUsage = readInt8();
        this.mSupportAITranslation = readInt8();
        this.mSupportSimultaneousTranslation = readInt8();
        this.mSupportTouchSet = readInt8();
        this.mSupportIMEISet = readInt8();
        this.mSupportQuran = readInt8();
        this.mSupportSyncAGPSInBackground = readInt8();
        this.mSupportRestoreFactory = readInt8();
        this.mSupportRecordNote = readInt8();
        this.mSupportSleepScore = readInt8();
        this.mSupportWatchface2 = readInt8();
        this.mSupportAICoach = readInt8();
        this.mSupportCrossAppTranslation = readInt8();
        this.mSupportRelaxReminder = readInt8();
        this.mSupportPower2 = readInt8();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleDeviceInfo)) {
            return false;
        }
        BleDeviceInfo bleDeviceInfo = (BleDeviceInfo) obj;
        return this.mId == bleDeviceInfo.mId && IIX0o.Oxx0IOOO(this.mDataKeys, bleDeviceInfo.mDataKeys) && IIX0o.Oxx0IOOO(this.mBleName, bleDeviceInfo.mBleName) && IIX0o.Oxx0IOOO(this.mBleCustomName, bleDeviceInfo.mBleCustomName) && IIX0o.Oxx0IOOO(this.mBleAddress, bleDeviceInfo.mBleAddress) && IIX0o.Oxx0IOOO(this.mPlatform, bleDeviceInfo.mPlatform) && IIX0o.Oxx0IOOO(this.mPrototype, bleDeviceInfo.mPrototype) && IIX0o.Oxx0IOOO(this.mFirmwareFlag, bleDeviceInfo.mFirmwareFlag) && this.mAGpsType == bleDeviceInfo.mAGpsType && this.mIOBufferSize == bleDeviceInfo.mIOBufferSize && this.mWatchFaceType == bleDeviceInfo.mWatchFaceType && IIX0o.Oxx0IOOO(this.mClassicAddress, bleDeviceInfo.mClassicAddress) && this.mHideDigitalPower == bleDeviceInfo.mHideDigitalPower && this.mShowAntiLostSwitch == bleDeviceInfo.mShowAntiLostSwitch && this.mSleepAlgorithmType == bleDeviceInfo.mSleepAlgorithmType && this.mSupportDateFormatSet == bleDeviceInfo.mSupportDateFormatSet && this.mSupportReadDeviceInfo == bleDeviceInfo.mSupportReadDeviceInfo && this.mSupportTemperatureUnitSet == bleDeviceInfo.mSupportTemperatureUnitSet && this.mSupportDrinkWaterSet == bleDeviceInfo.mSupportDrinkWaterSet && this.mSupportChangeClassicBluetoothState == bleDeviceInfo.mSupportChangeClassicBluetoothState && this.mSupportAppSport == bleDeviceInfo.mSupportAppSport && this.mSupportBloodOxyGenSet == bleDeviceInfo.mSupportBloodOxyGenSet && this.mSupportWashSet == bleDeviceInfo.mSupportWashSet && this.mSupportRequestRealtimeWeather == bleDeviceInfo.mSupportRequestRealtimeWeather && this.mSupportHID == bleDeviceInfo.mSupportHID && this.mSupportIBeaconSet == bleDeviceInfo.mSupportIBeaconSet && this.mSupportWatchFaceId == bleDeviceInfo.mSupportWatchFaceId && this.mSupportNewTransportMode == bleDeviceInfo.mSupportNewTransportMode && this.mSupportJLTransport == bleDeviceInfo.mSupportJLTransport && this.mSupportFindWatch == bleDeviceInfo.mSupportFindWatch && this.mSupportWorldClock == bleDeviceInfo.mSupportWorldClock && this.mSupportStock == bleDeviceInfo.mSupportStock && this.mSupportSMSQuickReply == bleDeviceInfo.mSupportSMSQuickReply && this.mSupportNoDisturbSet == bleDeviceInfo.mSupportNoDisturbSet && this.mSupportSetWatchPassword == bleDeviceInfo.mSupportSetWatchPassword && this.mSupportRealTimeMeasurement == bleDeviceInfo.mSupportRealTimeMeasurement && this.mSupportPowerSaveMode == bleDeviceInfo.mSupportPowerSaveMode && this.mSupportLoveTap == bleDeviceInfo.mSupportLoveTap && this.mSupportNewsfeed == bleDeviceInfo.mSupportNewsfeed && this.mSupportMedicationReminder == bleDeviceInfo.mSupportMedicationReminder && this.mSupportQrcode == bleDeviceInfo.mSupportQrcode && this.mSupportWeather2 == bleDeviceInfo.mSupportWeather2 && this.mSupportAlipay == bleDeviceInfo.mSupportAlipay && this.mSupportStandbySet == bleDeviceInfo.mSupportStandbySet && this.mSupport2DAcceleration == bleDeviceInfo.mSupport2DAcceleration && this.mSupportTuyaKey == bleDeviceInfo.mSupportTuyaKey && this.mSupportMedicationAlarm == bleDeviceInfo.mSupportMedicationAlarm && this.mSupportReadPackageStatus == bleDeviceInfo.mSupportReadPackageStatus && this.mSupportContactSize == bleDeviceInfo.mSupportContactSize && this.mSupportVoice == bleDeviceInfo.mSupportVoice && this.mSupportNavigation == bleDeviceInfo.mSupportNavigation && this.mSupportHrWarnSet == bleDeviceInfo.mSupportHrWarnSet && IIX0o.Oxx0IOOO(this.mBleDefaultName, bleDeviceInfo.mBleDefaultName) && this.mSupportMusicTransfer == bleDeviceInfo.mSupportMusicTransfer && this.mSupportNoDisturbSet2 == bleDeviceInfo.mSupportNoDisturbSet2 && this.mSupportSOSSet == bleDeviceInfo.mSupportSOSSet && this.mSupportReadLanguages == bleDeviceInfo.mSupportReadLanguages && this.mSupportGirlCareReminder == bleDeviceInfo.mSupportGirlCareReminder && this.mSupportAppPushSwitch == bleDeviceInfo.mSupportAppPushSwitch && this.mSupportReceiptCodeSize == bleDeviceInfo.mSupportReceiptCodeSize && this.mSupportGameTimeReminder == bleDeviceInfo.mSupportGameTimeReminder && this.mSupportMyCardCodeSize == bleDeviceInfo.mSupportMyCardCodeSize && this.mSupportDeviceSportData == bleDeviceInfo.mSupportDeviceSportData && this.mSupportEbookTransfer == bleDeviceInfo.mSupportEbookTransfer && this.mSupportDoubleScreen == bleDeviceInfo.mSupportDoubleScreen && this.mSupportCustomLogo == bleDeviceInfo.mSupportCustomLogo && this.mSupportPressureTimingMeasurement == bleDeviceInfo.mSupportPressureTimingMeasurement && this.mSupportTimerStandbySet == bleDeviceInfo.mSupportTimerStandbySet && this.mSupportSOSSet2 == bleDeviceInfo.mSupportSOSSet2 && this.mSupportFallSet == bleDeviceInfo.mSupportFallSet && this.mSupportWalkAndBike == bleDeviceInfo.mSupportWalkAndBike && this.mSupportConnectReminder == bleDeviceInfo.mSupportConnectReminder && this.mSupportSDCardInfo == bleDeviceInfo.mSupportSDCardInfo && this.mSupportIncomingCallRing == bleDeviceInfo.mSupportIncomingCallRing && this.mSupportNotificationLightScreenSet == bleDeviceInfo.mSupportNotificationLightScreenSet && this.mSupportBloodPressureCalibration == bleDeviceInfo.mSupportBloodPressureCalibration && this.mSupportOTAFile == bleDeviceInfo.mSupportOTAFile && this.mSupportGPSFirmwareFile == bleDeviceInfo.mSupportGPSFirmwareFile && this.mSupportGoMoreSet == bleDeviceInfo.mSupportGoMoreSet && this.mSupportRingVibrationSet == bleDeviceInfo.mSupportRingVibrationSet && this.mSupportNetwork == bleDeviceInfo.mSupportNetwork && this.mSupportContactSort == bleDeviceInfo.mSupportContactSort && this.mQrcodeSize == bleDeviceInfo.mQrcodeSize && this.mQrcodeContentSize == bleDeviceInfo.mQrcodeContentSize && this.mSupportStringQrcode == bleDeviceInfo.mSupportStringQrcode && this.mSupportWatchFaceIndex == bleDeviceInfo.mSupportWatchFaceIndex && this.mSupportSosContact == bleDeviceInfo.mSupportSosContact && this.mSupportGirlCareMonthly == bleDeviceInfo.mSupportGirlCareMonthly && this.mSupportWearWay == bleDeviceInfo.mSupportWearWay && this.mSupportGestureWake2 == bleDeviceInfo.mSupportGestureWake2 && this.mSupportNavImage == bleDeviceInfo.mSupportNavImage && this.mSupportVoiceMaxLength == bleDeviceInfo.mSupportVoiceMaxLength && this.mSupportAudioBooks == bleDeviceInfo.mSupportAudioBooks && this.mSupportStudyCards == bleDeviceInfo.mSupportStudyCards && this.mSupportAppStore == bleDeviceInfo.mSupportAppStore && this.mSupportSHSYAlgorithm == bleDeviceInfo.mSupportSHSYAlgorithm && this.mSupportQiblaSet == bleDeviceInfo.mSupportQiblaSet && this.mSupportMeasurementBloodGlucose == bleDeviceInfo.mSupportMeasurementBloodGlucose && this.mSupportGameControls == bleDeviceInfo.mSupportGameControls && this.mSupportBatteryUsage == bleDeviceInfo.mSupportBatteryUsage && this.mSupportAITranslation == bleDeviceInfo.mSupportAITranslation && this.mSupportSimultaneousTranslation == bleDeviceInfo.mSupportSimultaneousTranslation && this.mSupportTouchSet == bleDeviceInfo.mSupportTouchSet && this.mSupportIMEISet == bleDeviceInfo.mSupportIMEISet && this.mSupportQuran == bleDeviceInfo.mSupportQuran && this.mSupportSyncAGPSInBackground == bleDeviceInfo.mSupportSyncAGPSInBackground && this.mSupportRestoreFactory == bleDeviceInfo.mSupportRestoreFactory && this.mSupportRecordNote == bleDeviceInfo.mSupportRecordNote && this.mSupportSleepScore == bleDeviceInfo.mSupportSleepScore && this.mSupportWatchface2 == bleDeviceInfo.mSupportWatchface2 && this.mSupportAICoach == bleDeviceInfo.mSupportAICoach && this.mSupportCrossAppTranslation == bleDeviceInfo.mSupportCrossAppTranslation && this.mSupportRelaxReminder == bleDeviceInfo.mSupportRelaxReminder && this.mSupportPower2 == bleDeviceInfo.mSupportPower2;
    }

    public final int getMAGpsType() {
        return this.mAGpsType;
    }

    @OOXIXo
    public final String getMBleAddress() {
        return this.mBleAddress;
    }

    @OOXIXo
    public final String getMBleCustomName() {
        return this.mBleCustomName;
    }

    @OOXIXo
    public final String getMBleName() {
        return this.mBleName;
    }

    @OOXIXo
    public final String getMClassicAddress() {
        return this.mClassicAddress;
    }

    @OOXIXo
    public final List<Integer> getMDataKeys() {
        return this.mDataKeys;
    }

    @OOXIXo
    public final String getMFirmwareFlag() {
        return this.mFirmwareFlag;
    }

    public final int getMHideDigitalPower() {
        return this.mHideDigitalPower;
    }

    public final long getMIOBufferSize() {
        return this.mIOBufferSize;
    }

    public final int getMId() {
        return this.mId;
    }

    @OOXIXo
    public final String getMPlatform() {
        return this.mPlatform;
    }

    @OOXIXo
    public final String getMPrototype() {
        return this.mPrototype;
    }

    public final int getMQrcodeContentSize() {
        return this.mQrcodeContentSize;
    }

    public final int getMQrcodeSize() {
        return this.mQrcodeSize;
    }

    public final int getMShowAntiLostSwitch() {
        return this.mShowAntiLostSwitch;
    }

    public final int getMSleepAlgorithmType() {
        return this.mSleepAlgorithmType;
    }

    public final int getMSupport2DAcceleration() {
        return this.mSupport2DAcceleration;
    }

    public final int getMSupportAICoach() {
        return this.mSupportAICoach;
    }

    public final int getMSupportAITranslation() {
        return this.mSupportAITranslation;
    }

    public final int getMSupportAlipay() {
        return this.mSupportAlipay;
    }

    public final int getMSupportAppPushSwitch() {
        return this.mSupportAppPushSwitch;
    }

    public final int getMSupportAppSport() {
        return this.mSupportAppSport;
    }

    public final int getMSupportAppStore() {
        return this.mSupportAppStore;
    }

    public final int getMSupportAudioBooks() {
        return this.mSupportAudioBooks;
    }

    public final int getMSupportBatteryUsage() {
        return this.mSupportBatteryUsage;
    }

    public final int getMSupportBloodOxyGenSet() {
        return this.mSupportBloodOxyGenSet;
    }

    public final int getMSupportBloodPressureCalibration() {
        return this.mSupportBloodPressureCalibration;
    }

    public final int getMSupportChangeClassicBluetoothState() {
        return this.mSupportChangeClassicBluetoothState;
    }

    public final int getMSupportConnectReminder() {
        return this.mSupportConnectReminder;
    }

    public final int getMSupportContactSize() {
        return this.mSupportContactSize;
    }

    public final int getMSupportContactSort() {
        return this.mSupportContactSort;
    }

    public final int getMSupportCrossAppTranslation() {
        return this.mSupportCrossAppTranslation;
    }

    public final int getMSupportCustomLogo() {
        return this.mSupportCustomLogo;
    }

    public final int getMSupportDateFormatSet() {
        return this.mSupportDateFormatSet;
    }

    public final int getMSupportDeviceSportData() {
        return this.mSupportDeviceSportData;
    }

    public final int getMSupportDoubleScreen() {
        return this.mSupportDoubleScreen;
    }

    public final int getMSupportDrinkWaterSet() {
        return this.mSupportDrinkWaterSet;
    }

    public final int getMSupportEbookTransfer() {
        return this.mSupportEbookTransfer;
    }

    public final int getMSupportFallSet() {
        return this.mSupportFallSet;
    }

    public final int getMSupportFindWatch() {
        return this.mSupportFindWatch;
    }

    public final int getMSupportGPSFirmwareFile() {
        return this.mSupportGPSFirmwareFile;
    }

    public final int getMSupportGameControls() {
        return this.mSupportGameControls;
    }

    public final int getMSupportGameTimeReminder() {
        return this.mSupportGameTimeReminder;
    }

    public final int getMSupportGestureWake2() {
        return this.mSupportGestureWake2;
    }

    public final int getMSupportGirlCareMonthly() {
        return this.mSupportGirlCareMonthly;
    }

    public final int getMSupportGirlCareReminder() {
        return this.mSupportGirlCareReminder;
    }

    public final int getMSupportGoMoreSet() {
        return this.mSupportGoMoreSet;
    }

    public final int getMSupportHID() {
        return this.mSupportHID;
    }

    public final int getMSupportHrWarnSet() {
        return this.mSupportHrWarnSet;
    }

    public final int getMSupportIBeaconSet() {
        return this.mSupportIBeaconSet;
    }

    public final int getMSupportIMEISet() {
        return this.mSupportIMEISet;
    }

    public final int getMSupportIncomingCallRing() {
        return this.mSupportIncomingCallRing;
    }

    public final int getMSupportJLTransport() {
        return this.mSupportJLTransport;
    }

    public final int getMSupportLoveTap() {
        return this.mSupportLoveTap;
    }

    public final int getMSupportMeasurementBloodGlucose() {
        return this.mSupportMeasurementBloodGlucose;
    }

    public final int getMSupportMedicationAlarm() {
        return this.mSupportMedicationAlarm;
    }

    public final int getMSupportMedicationReminder() {
        return this.mSupportMedicationReminder;
    }

    public final int getMSupportMusicTransfer() {
        return this.mSupportMusicTransfer;
    }

    public final int getMSupportMyCardCodeSize() {
        return this.mSupportMyCardCodeSize;
    }

    public final int getMSupportNavImage() {
        return this.mSupportNavImage;
    }

    public final int getMSupportNavigation() {
        return this.mSupportNavigation;
    }

    public final int getMSupportNetwork() {
        return this.mSupportNetwork;
    }

    public final int getMSupportNewTransportMode() {
        return this.mSupportNewTransportMode;
    }

    public final int getMSupportNewsfeed() {
        return this.mSupportNewsfeed;
    }

    public final int getMSupportNoDisturbSet() {
        return this.mSupportNoDisturbSet;
    }

    public final int getMSupportNoDisturbSet2() {
        return this.mSupportNoDisturbSet2;
    }

    public final int getMSupportNotificationLightScreenSet() {
        return this.mSupportNotificationLightScreenSet;
    }

    public final int getMSupportOTAFile() {
        return this.mSupportOTAFile;
    }

    public final int getMSupportPower2() {
        return this.mSupportPower2;
    }

    public final int getMSupportPowerSaveMode() {
        return this.mSupportPowerSaveMode;
    }

    public final int getMSupportPressureTimingMeasurement() {
        return this.mSupportPressureTimingMeasurement;
    }

    public final int getMSupportQiblaSet() {
        return this.mSupportQiblaSet;
    }

    public final int getMSupportQrcode() {
        return this.mSupportQrcode;
    }

    public final int getMSupportQuran() {
        return this.mSupportQuran;
    }

    public final int getMSupportReadDeviceInfo() {
        return this.mSupportReadDeviceInfo;
    }

    public final int getMSupportReadLanguages() {
        return this.mSupportReadLanguages;
    }

    public final int getMSupportReadPackageStatus() {
        return this.mSupportReadPackageStatus;
    }

    public final int getMSupportRealTimeMeasurement() {
        return this.mSupportRealTimeMeasurement;
    }

    public final int getMSupportReceiptCodeSize() {
        return this.mSupportReceiptCodeSize;
    }

    public final int getMSupportRecordNote() {
        return this.mSupportRecordNote;
    }

    public final int getMSupportRelaxReminder() {
        return this.mSupportRelaxReminder;
    }

    public final int getMSupportRequestRealtimeWeather() {
        return this.mSupportRequestRealtimeWeather;
    }

    public final int getMSupportRestoreFactory() {
        return this.mSupportRestoreFactory;
    }

    public final int getMSupportRingVibrationSet() {
        return this.mSupportRingVibrationSet;
    }

    public final int getMSupportSDCardInfo() {
        return this.mSupportSDCardInfo;
    }

    public final int getMSupportSHSYAlgorithm() {
        return this.mSupportSHSYAlgorithm;
    }

    public final int getMSupportSMSQuickReply() {
        return this.mSupportSMSQuickReply;
    }

    public final int getMSupportSOSSet() {
        return this.mSupportSOSSet;
    }

    public final int getMSupportSOSSet2() {
        return this.mSupportSOSSet2;
    }

    public final int getMSupportSetWatchPassword() {
        return this.mSupportSetWatchPassword;
    }

    public final int getMSupportSimultaneousTranslation() {
        return this.mSupportSimultaneousTranslation;
    }

    public final int getMSupportSleepScore() {
        return this.mSupportSleepScore;
    }

    public final int getMSupportSosContact() {
        return this.mSupportSosContact;
    }

    public final int getMSupportStandbySet() {
        return this.mSupportStandbySet;
    }

    public final int getMSupportStock() {
        return this.mSupportStock;
    }

    public final int getMSupportStringQrcode() {
        return this.mSupportStringQrcode;
    }

    public final int getMSupportStudyCards() {
        return this.mSupportStudyCards;
    }

    public final int getMSupportSyncAGPSInBackground() {
        return this.mSupportSyncAGPSInBackground;
    }

    public final int getMSupportTemperatureUnitSet() {
        return this.mSupportTemperatureUnitSet;
    }

    public final int getMSupportTimerStandbySet() {
        return this.mSupportTimerStandbySet;
    }

    public final int getMSupportTouchSet() {
        return this.mSupportTouchSet;
    }

    public final int getMSupportTuyaKey() {
        return this.mSupportTuyaKey;
    }

    public final int getMSupportVoice() {
        return this.mSupportVoice;
    }

    public final int getMSupportVoiceMaxLength() {
        return this.mSupportVoiceMaxLength;
    }

    public final int getMSupportWalkAndBike() {
        return this.mSupportWalkAndBike;
    }

    public final int getMSupportWashSet() {
        return this.mSupportWashSet;
    }

    public final int getMSupportWatchFaceId() {
        return this.mSupportWatchFaceId;
    }

    public final int getMSupportWatchFaceIndex() {
        return this.mSupportWatchFaceIndex;
    }

    public final int getMSupportWatchface2() {
        return this.mSupportWatchface2;
    }

    public final int getMSupportWearWay() {
        return this.mSupportWearWay;
    }

    public final int getMSupportWeather2() {
        return this.mSupportWeather2;
    }

    public final int getMSupportWorldClock() {
        return this.mSupportWorldClock;
    }

    public final int getMWatchFaceType() {
        return this.mWatchFaceType;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.mId * 31) + this.mDataKeys.hashCode()) * 31) + this.mBleName.hashCode()) * 31) + this.mBleCustomName.hashCode()) * 31) + this.mBleAddress.hashCode()) * 31) + this.mPlatform.hashCode()) * 31) + this.mPrototype.hashCode()) * 31) + this.mFirmwareFlag.hashCode()) * 31) + this.mAGpsType) * 31) + oIX0oI.oIX0oI(this.mIOBufferSize)) * 31) + this.mWatchFaceType) * 31) + this.mClassicAddress.hashCode()) * 31) + this.mHideDigitalPower) * 31) + this.mShowAntiLostSwitch) * 31) + this.mSleepAlgorithmType) * 31) + this.mSupportDateFormatSet) * 31) + this.mSupportReadDeviceInfo) * 31) + this.mSupportTemperatureUnitSet) * 31) + this.mSupportDrinkWaterSet) * 31) + this.mSupportChangeClassicBluetoothState) * 31) + this.mSupportAppSport) * 31) + this.mSupportBloodOxyGenSet) * 31) + this.mSupportWashSet) * 31) + this.mSupportRequestRealtimeWeather) * 31) + this.mSupportHID) * 31) + this.mSupportIBeaconSet) * 31) + this.mSupportWatchFaceId) * 31) + this.mSupportNewTransportMode) * 31) + this.mSupportJLTransport) * 31) + this.mSupportFindWatch) * 31) + this.mSupportWorldClock) * 31) + this.mSupportStock) * 31) + this.mSupportSMSQuickReply) * 31) + this.mSupportNoDisturbSet) * 31) + this.mSupportSetWatchPassword) * 31) + this.mSupportRealTimeMeasurement) * 31) + this.mSupportPowerSaveMode) * 31) + this.mSupportLoveTap) * 31) + this.mSupportNewsfeed) * 31) + this.mSupportMedicationReminder) * 31) + this.mSupportQrcode) * 31) + this.mSupportWeather2) * 31) + this.mSupportAlipay) * 31) + this.mSupportStandbySet) * 31) + this.mSupport2DAcceleration) * 31) + this.mSupportTuyaKey) * 31) + this.mSupportMedicationAlarm) * 31) + this.mSupportReadPackageStatus) * 31) + this.mSupportContactSize) * 31) + this.mSupportVoice) * 31) + this.mSupportNavigation) * 31) + this.mSupportHrWarnSet) * 31) + this.mBleDefaultName.hashCode()) * 31) + this.mSupportMusicTransfer) * 31) + this.mSupportNoDisturbSet2) * 31) + this.mSupportSOSSet) * 31) + this.mSupportReadLanguages) * 31) + this.mSupportGirlCareReminder) * 31) + this.mSupportAppPushSwitch) * 31) + this.mSupportReceiptCodeSize) * 31) + this.mSupportGameTimeReminder) * 31) + this.mSupportMyCardCodeSize) * 31) + this.mSupportDeviceSportData) * 31) + this.mSupportEbookTransfer) * 31) + this.mSupportDoubleScreen) * 31) + this.mSupportCustomLogo) * 31) + this.mSupportPressureTimingMeasurement) * 31) + this.mSupportTimerStandbySet) * 31) + this.mSupportSOSSet2) * 31) + this.mSupportFallSet) * 31) + this.mSupportWalkAndBike) * 31) + this.mSupportConnectReminder) * 31) + this.mSupportSDCardInfo) * 31) + this.mSupportIncomingCallRing) * 31) + this.mSupportNotificationLightScreenSet) * 31) + this.mSupportBloodPressureCalibration) * 31) + this.mSupportOTAFile) * 31) + this.mSupportGPSFirmwareFile) * 31) + this.mSupportGoMoreSet) * 31) + this.mSupportRingVibrationSet) * 31) + this.mSupportNetwork) * 31) + this.mSupportContactSort) * 31) + this.mQrcodeSize) * 31) + this.mQrcodeContentSize) * 31) + this.mSupportStringQrcode) * 31) + this.mSupportWatchFaceIndex) * 31) + this.mSupportSosContact) * 31) + this.mSupportGirlCareMonthly) * 31) + this.mSupportWearWay) * 31) + this.mSupportGestureWake2) * 31) + this.mSupportNavImage) * 31) + this.mSupportVoiceMaxLength) * 31) + this.mSupportAudioBooks) * 31) + this.mSupportStudyCards) * 31) + this.mSupportAppStore) * 31) + this.mSupportSHSYAlgorithm) * 31) + this.mSupportQiblaSet) * 31) + this.mSupportMeasurementBloodGlucose) * 31) + this.mSupportGameControls) * 31) + this.mSupportBatteryUsage) * 31) + this.mSupportAITranslation) * 31) + this.mSupportSimultaneousTranslation) * 31) + this.mSupportTouchSet) * 31) + this.mSupportIMEISet) * 31) + this.mSupportQuran) * 31) + this.mSupportSyncAGPSInBackground) * 31) + this.mSupportRestoreFactory) * 31) + this.mSupportRecordNote) * 31) + this.mSupportSleepScore) * 31) + this.mSupportWatchface2) * 31) + this.mSupportAICoach) * 31) + this.mSupportCrossAppTranslation) * 31) + this.mSupportRelaxReminder) * 31) + this.mSupportPower2;
    }

    public final void setMAGpsType(int i) {
        this.mAGpsType = i;
    }

    public final void setMBleAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleAddress = str;
    }

    public final void setMBleCustomName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleCustomName = str;
    }

    public final void setMBleName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mBleName = str;
    }

    public final void setMClassicAddress(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mClassicAddress = str;
    }

    public final void setMDataKeys(@OOXIXo List<Integer> list) {
        IIX0o.x0xO0oo(list, "<set-?>");
        this.mDataKeys = list;
    }

    public final void setMFirmwareFlag(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mFirmwareFlag = str;
    }

    public final void setMHideDigitalPower(int i) {
        this.mHideDigitalPower = i;
    }

    public final void setMIOBufferSize(long j) {
        this.mIOBufferSize = j;
    }

    public final void setMId(int i) {
        this.mId = i;
    }

    public final void setMPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPlatform = str;
    }

    public final void setMPrototype(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPrototype = str;
    }

    public final void setMQrcodeContentSize(int i) {
        this.mQrcodeContentSize = i;
    }

    public final void setMQrcodeSize(int i) {
        this.mQrcodeSize = i;
    }

    public final void setMShowAntiLostSwitch(int i) {
        this.mShowAntiLostSwitch = i;
    }

    public final void setMSleepAlgorithmType(int i) {
        this.mSleepAlgorithmType = i;
    }

    public final void setMSupport2DAcceleration(int i) {
        this.mSupport2DAcceleration = i;
    }

    public final void setMSupportAICoach(int i) {
        this.mSupportAICoach = i;
    }

    public final void setMSupportAITranslation(int i) {
        this.mSupportAITranslation = i;
    }

    public final void setMSupportAlipay(int i) {
        this.mSupportAlipay = i;
    }

    public final void setMSupportAppPushSwitch(int i) {
        this.mSupportAppPushSwitch = i;
    }

    public final void setMSupportAppSport(int i) {
        this.mSupportAppSport = i;
    }

    public final void setMSupportAppStore(int i) {
        this.mSupportAppStore = i;
    }

    public final void setMSupportAudioBooks(int i) {
        this.mSupportAudioBooks = i;
    }

    public final void setMSupportBatteryUsage(int i) {
        this.mSupportBatteryUsage = i;
    }

    public final void setMSupportBloodOxyGenSet(int i) {
        this.mSupportBloodOxyGenSet = i;
    }

    public final void setMSupportBloodPressureCalibration(int i) {
        this.mSupportBloodPressureCalibration = i;
    }

    public final void setMSupportChangeClassicBluetoothState(int i) {
        this.mSupportChangeClassicBluetoothState = i;
    }

    public final void setMSupportConnectReminder(int i) {
        this.mSupportConnectReminder = i;
    }

    public final void setMSupportContactSize(int i) {
        this.mSupportContactSize = i;
    }

    public final void setMSupportContactSort(int i) {
        this.mSupportContactSort = i;
    }

    public final void setMSupportCrossAppTranslation(int i) {
        this.mSupportCrossAppTranslation = i;
    }

    public final void setMSupportCustomLogo(int i) {
        this.mSupportCustomLogo = i;
    }

    public final void setMSupportDateFormatSet(int i) {
        this.mSupportDateFormatSet = i;
    }

    public final void setMSupportDeviceSportData(int i) {
        this.mSupportDeviceSportData = i;
    }

    public final void setMSupportDoubleScreen(int i) {
        this.mSupportDoubleScreen = i;
    }

    public final void setMSupportDrinkWaterSet(int i) {
        this.mSupportDrinkWaterSet = i;
    }

    public final void setMSupportEbookTransfer(int i) {
        this.mSupportEbookTransfer = i;
    }

    public final void setMSupportFallSet(int i) {
        this.mSupportFallSet = i;
    }

    public final void setMSupportFindWatch(int i) {
        this.mSupportFindWatch = i;
    }

    public final void setMSupportGPSFirmwareFile(int i) {
        this.mSupportGPSFirmwareFile = i;
    }

    public final void setMSupportGameControls(int i) {
        this.mSupportGameControls = i;
    }

    public final void setMSupportGameTimeReminder(int i) {
        this.mSupportGameTimeReminder = i;
    }

    public final void setMSupportGestureWake2(int i) {
        this.mSupportGestureWake2 = i;
    }

    public final void setMSupportGirlCareMonthly(int i) {
        this.mSupportGirlCareMonthly = i;
    }

    public final void setMSupportGirlCareReminder(int i) {
        this.mSupportGirlCareReminder = i;
    }

    public final void setMSupportGoMoreSet(int i) {
        this.mSupportGoMoreSet = i;
    }

    public final void setMSupportHID(int i) {
        this.mSupportHID = i;
    }

    public final void setMSupportHrWarnSet(int i) {
        this.mSupportHrWarnSet = i;
    }

    public final void setMSupportIBeaconSet(int i) {
        this.mSupportIBeaconSet = i;
    }

    public final void setMSupportIMEISet(int i) {
        this.mSupportIMEISet = i;
    }

    public final void setMSupportIncomingCallRing(int i) {
        this.mSupportIncomingCallRing = i;
    }

    public final void setMSupportJLTransport(int i) {
        this.mSupportJLTransport = i;
    }

    public final void setMSupportLoveTap(int i) {
        this.mSupportLoveTap = i;
    }

    public final void setMSupportMeasurementBloodGlucose(int i) {
        this.mSupportMeasurementBloodGlucose = i;
    }

    public final void setMSupportMedicationAlarm(int i) {
        this.mSupportMedicationAlarm = i;
    }

    public final void setMSupportMedicationReminder(int i) {
        this.mSupportMedicationReminder = i;
    }

    public final void setMSupportMusicTransfer(int i) {
        this.mSupportMusicTransfer = i;
    }

    public final void setMSupportMyCardCodeSize(int i) {
        this.mSupportMyCardCodeSize = i;
    }

    public final void setMSupportNavImage(int i) {
        this.mSupportNavImage = i;
    }

    public final void setMSupportNavigation(int i) {
        this.mSupportNavigation = i;
    }

    public final void setMSupportNetwork(int i) {
        this.mSupportNetwork = i;
    }

    public final void setMSupportNewTransportMode(int i) {
        this.mSupportNewTransportMode = i;
    }

    public final void setMSupportNewsfeed(int i) {
        this.mSupportNewsfeed = i;
    }

    public final void setMSupportNoDisturbSet(int i) {
        this.mSupportNoDisturbSet = i;
    }

    public final void setMSupportNoDisturbSet2(int i) {
        this.mSupportNoDisturbSet2 = i;
    }

    public final void setMSupportNotificationLightScreenSet(int i) {
        this.mSupportNotificationLightScreenSet = i;
    }

    public final void setMSupportOTAFile(int i) {
        this.mSupportOTAFile = i;
    }

    public final void setMSupportPower2(int i) {
        this.mSupportPower2 = i;
    }

    public final void setMSupportPowerSaveMode(int i) {
        this.mSupportPowerSaveMode = i;
    }

    public final void setMSupportPressureTimingMeasurement(int i) {
        this.mSupportPressureTimingMeasurement = i;
    }

    public final void setMSupportQiblaSet(int i) {
        this.mSupportQiblaSet = i;
    }

    public final void setMSupportQrcode(int i) {
        this.mSupportQrcode = i;
    }

    public final void setMSupportQuran(int i) {
        this.mSupportQuran = i;
    }

    public final void setMSupportReadDeviceInfo(int i) {
        this.mSupportReadDeviceInfo = i;
    }

    public final void setMSupportReadLanguages(int i) {
        this.mSupportReadLanguages = i;
    }

    public final void setMSupportReadPackageStatus(int i) {
        this.mSupportReadPackageStatus = i;
    }

    public final void setMSupportRealTimeMeasurement(int i) {
        this.mSupportRealTimeMeasurement = i;
    }

    public final void setMSupportReceiptCodeSize(int i) {
        this.mSupportReceiptCodeSize = i;
    }

    public final void setMSupportRecordNote(int i) {
        this.mSupportRecordNote = i;
    }

    public final void setMSupportRelaxReminder(int i) {
        this.mSupportRelaxReminder = i;
    }

    public final void setMSupportRequestRealtimeWeather(int i) {
        this.mSupportRequestRealtimeWeather = i;
    }

    public final void setMSupportRestoreFactory(int i) {
        this.mSupportRestoreFactory = i;
    }

    public final void setMSupportRingVibrationSet(int i) {
        this.mSupportRingVibrationSet = i;
    }

    public final void setMSupportSDCardInfo(int i) {
        this.mSupportSDCardInfo = i;
    }

    public final void setMSupportSHSYAlgorithm(int i) {
        this.mSupportSHSYAlgorithm = i;
    }

    public final void setMSupportSMSQuickReply(int i) {
        this.mSupportSMSQuickReply = i;
    }

    public final void setMSupportSOSSet(int i) {
        this.mSupportSOSSet = i;
    }

    public final void setMSupportSOSSet2(int i) {
        this.mSupportSOSSet2 = i;
    }

    public final void setMSupportSetWatchPassword(int i) {
        this.mSupportSetWatchPassword = i;
    }

    public final void setMSupportSimultaneousTranslation(int i) {
        this.mSupportSimultaneousTranslation = i;
    }

    public final void setMSupportSleepScore(int i) {
        this.mSupportSleepScore = i;
    }

    public final void setMSupportSosContact(int i) {
        this.mSupportSosContact = i;
    }

    public final void setMSupportStandbySet(int i) {
        this.mSupportStandbySet = i;
    }

    public final void setMSupportStock(int i) {
        this.mSupportStock = i;
    }

    public final void setMSupportStringQrcode(int i) {
        this.mSupportStringQrcode = i;
    }

    public final void setMSupportStudyCards(int i) {
        this.mSupportStudyCards = i;
    }

    public final void setMSupportSyncAGPSInBackground(int i) {
        this.mSupportSyncAGPSInBackground = i;
    }

    public final void setMSupportTemperatureUnitSet(int i) {
        this.mSupportTemperatureUnitSet = i;
    }

    public final void setMSupportTimerStandbySet(int i) {
        this.mSupportTimerStandbySet = i;
    }

    public final void setMSupportTouchSet(int i) {
        this.mSupportTouchSet = i;
    }

    public final void setMSupportTuyaKey(int i) {
        this.mSupportTuyaKey = i;
    }

    public final void setMSupportVoice(int i) {
        this.mSupportVoice = i;
    }

    public final void setMSupportVoiceMaxLength(int i) {
        this.mSupportVoiceMaxLength = i;
    }

    public final void setMSupportWalkAndBike(int i) {
        this.mSupportWalkAndBike = i;
    }

    public final void setMSupportWashSet(int i) {
        this.mSupportWashSet = i;
    }

    public final void setMSupportWatchFaceId(int i) {
        this.mSupportWatchFaceId = i;
    }

    public final void setMSupportWatchFaceIndex(int i) {
        this.mSupportWatchFaceIndex = i;
    }

    public final void setMSupportWatchface2(int i) {
        this.mSupportWatchface2 = i;
    }

    public final void setMSupportWearWay(int i) {
        this.mSupportWearWay = i;
    }

    public final void setMSupportWeather2(int i) {
        this.mSupportWeather2 = i;
    }

    public final void setMSupportWorldClock(int i) {
        this.mSupportWorldClock = i;
    }

    public final void setMWatchFaceType(int i) {
        this.mWatchFaceType = i;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleDeviceInfo(mId=");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%08X", Arrays.copyOf(new Object[]{Integer.valueOf(this.mId)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(", mDataKeys=");
        List<Integer> list = this.mDataKeys;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BleKey.Companion.oIX0oI(((Number) it.next()).intValue()));
        }
        sb.append(arrayList);
        sb.append(", mBleName='");
        sb.append(this.mBleName);
        sb.append("', mBleCustomName='");
        sb.append(this.mBleCustomName);
        sb.append("', mBleAddress='");
        sb.append(this.mBleAddress);
        sb.append("', mPlatform='");
        sb.append(this.mPlatform);
        sb.append("', mPrototype='");
        sb.append(this.mPrototype);
        sb.append("', mFirmwareFlag='");
        sb.append(this.mFirmwareFlag);
        sb.append("', mAGpsType=");
        sb.append(this.mAGpsType);
        sb.append(", mIOBufferSize=");
        sb.append(this.mIOBufferSize);
        sb.append(", mWatchFaceType=");
        sb.append(this.mWatchFaceType);
        sb.append(", mClassicAddress='");
        sb.append(this.mClassicAddress);
        sb.append("', mHideDigitalPower=");
        sb.append(this.mHideDigitalPower);
        sb.append(", mShowAntiLostSwitch=");
        sb.append(this.mShowAntiLostSwitch);
        sb.append(", mSleepAlgorithmType=");
        sb.append(this.mSleepAlgorithmType);
        sb.append(", mSupportDateFormatSet=");
        sb.append(this.mSupportDateFormatSet);
        sb.append(", mSupportReadDeviceInfo=");
        sb.append(this.mSupportReadDeviceInfo);
        sb.append(", mSupportTemperatureUnitSet=");
        sb.append(this.mSupportTemperatureUnitSet);
        sb.append(", mSupportDrinkWaterSet=");
        sb.append(this.mSupportDrinkWaterSet);
        sb.append(", mSupportChangeClassicBluetoothState=");
        sb.append(this.mSupportChangeClassicBluetoothState);
        sb.append(", mSupportAppSport=");
        sb.append(this.mSupportAppSport);
        sb.append(", mSupportBloodOxyGenSet=");
        sb.append(this.mSupportBloodOxyGenSet);
        sb.append(", mSupportWashSet=");
        sb.append(this.mSupportWashSet);
        sb.append(", mSupportRequestRealtimeWeather=");
        sb.append(this.mSupportRequestRealtimeWeather);
        sb.append(", mSupportHID=");
        sb.append(this.mSupportHID);
        sb.append(", mSupportIBeaconSet=");
        sb.append(this.mSupportIBeaconSet);
        sb.append(", mSupportWatchFaceId=");
        sb.append(this.mSupportWatchFaceId);
        sb.append(", mSupportNewTransportMode=");
        sb.append(this.mSupportNewTransportMode);
        sb.append(", mSupportJLTransport=");
        sb.append(this.mSupportJLTransport);
        sb.append(", mSupportFindWatch=");
        sb.append(this.mSupportFindWatch);
        sb.append(", mSupportWorldClock=");
        sb.append(this.mSupportWorldClock);
        sb.append(", mSupportStock=");
        sb.append(this.mSupportStock);
        sb.append(", mSupportSMSQuickReply=");
        sb.append(this.mSupportSMSQuickReply);
        sb.append(", mSupportNoDisturbSet=");
        sb.append(this.mSupportNoDisturbSet);
        sb.append(", mSupportSetWatchPassword=");
        sb.append(this.mSupportSetWatchPassword);
        sb.append(", mSupportRealTimeMeasurement=");
        sb.append(this.mSupportRealTimeMeasurement);
        sb.append(", mSupportPowerSaveMode=");
        sb.append(this.mSupportPowerSaveMode);
        sb.append(", mSupportLoveTap=");
        sb.append(this.mSupportLoveTap);
        sb.append(", mSupportNewsfeed=");
        sb.append(this.mSupportNewsfeed);
        sb.append(", mSupportMedicationReminder=");
        sb.append(this.mSupportMedicationReminder);
        sb.append(", mSupportQrcode=");
        sb.append(this.mSupportQrcode);
        sb.append(", mSupportWeather2=");
        sb.append(this.mSupportWeather2);
        sb.append(", mSupportAlipay=");
        sb.append(this.mSupportAlipay);
        sb.append(", mSupportStandbySet=");
        sb.append(this.mSupportStandbySet);
        sb.append(", mSupport2DAcceleration=");
        sb.append(this.mSupport2DAcceleration);
        sb.append(", mSupportTuyaKey=");
        sb.append(this.mSupportTuyaKey);
        sb.append(", mSupportMedicationAlarm=");
        sb.append(this.mSupportMedicationAlarm);
        sb.append(", mSupportReadPackageStatus=");
        sb.append(this.mSupportReadPackageStatus);
        sb.append(", mSupportContactSize=");
        sb.append(this.mSupportContactSize);
        sb.append(", mSupportVoice=");
        sb.append(this.mSupportVoice);
        sb.append(", mSupportNavigation=");
        sb.append(this.mSupportNavigation);
        sb.append(", mSupportHrWarnSet=");
        sb.append(this.mSupportHrWarnSet);
        sb.append(", mBleDefaultName='");
        sb.append(this.mBleDefaultName);
        sb.append("', mSupportMusicTransfer=");
        sb.append(this.mSupportMusicTransfer);
        sb.append(", mSupportNoDisturbSet2=");
        sb.append(this.mSupportNoDisturbSet2);
        sb.append(", mSupportSOSSet=");
        sb.append(this.mSupportSOSSet);
        sb.append(", mSupportReadLanguages=");
        sb.append(this.mSupportReadLanguages);
        sb.append(", mSupportGirlCareReminder=");
        sb.append(this.mSupportGirlCareReminder);
        sb.append(", mSupportAppPushSwitch=");
        sb.append(this.mSupportAppPushSwitch);
        sb.append(", mSupportReceiptCodeSize=");
        sb.append(this.mSupportReceiptCodeSize);
        sb.append(", mSupportGameTimeReminder=");
        sb.append(this.mSupportGameTimeReminder);
        sb.append(", mSupportMyCardCodeSize=");
        sb.append(this.mSupportMyCardCodeSize);
        sb.append(", mSupportDeviceSportData=");
        sb.append(this.mSupportDeviceSportData);
        sb.append(", mSupportEbookTransfer=");
        sb.append(this.mSupportEbookTransfer);
        sb.append(", mSupportDoubleScreen=");
        sb.append(this.mSupportDoubleScreen);
        sb.append(", mSupportCustomLogo=");
        sb.append(this.mSupportCustomLogo);
        sb.append(", mSupportPressureTimingMeasurement=");
        sb.append(this.mSupportPressureTimingMeasurement);
        sb.append(", mSupportTimerStandbySet=");
        sb.append(this.mSupportTimerStandbySet);
        sb.append(", mSupportSOSSet2=");
        sb.append(this.mSupportSOSSet2);
        sb.append(", mSupportFallSet=");
        sb.append(this.mSupportFallSet);
        sb.append(", mSupportWalkAndBike=");
        sb.append(this.mSupportWalkAndBike);
        sb.append(", mSupportConnectReminder=");
        sb.append(this.mSupportConnectReminder);
        sb.append(", mSupportSDCardInfo=");
        sb.append(this.mSupportSDCardInfo);
        sb.append(", mSupportIncomingCallRing=");
        sb.append(this.mSupportIncomingCallRing);
        sb.append(", mSupportNotificationLightScreenSet=");
        sb.append(this.mSupportNotificationLightScreenSet);
        sb.append(", mSupportBloodPressureCalibration=");
        sb.append(this.mSupportBloodPressureCalibration);
        sb.append(", mSupportOTAFile=");
        sb.append(this.mSupportOTAFile);
        sb.append(", mSupportGPSFirmwareFile=");
        sb.append(this.mSupportGPSFirmwareFile);
        sb.append(", mSupportGoMoreSet=");
        sb.append(this.mSupportGoMoreSet);
        sb.append(", mSupportRingVibrationSet=");
        sb.append(this.mSupportRingVibrationSet);
        sb.append(", mSupportNetwork=");
        sb.append(this.mSupportNetwork);
        sb.append(", mSupportContactSort=");
        sb.append(this.mSupportContactSort);
        sb.append(", mQrcodeSize=");
        sb.append(this.mQrcodeSize);
        sb.append(", mQrcodeContentSize=");
        sb.append(this.mQrcodeContentSize);
        sb.append(", mSupportStringQrcode=");
        sb.append(this.mSupportStringQrcode);
        sb.append(", mSupportWatchFaceIndex=");
        sb.append(this.mSupportWatchFaceIndex);
        sb.append(", mSupportSosContact=");
        sb.append(this.mSupportSosContact);
        sb.append(", mSupportGirlCareMonthly=");
        sb.append(this.mSupportGirlCareMonthly);
        sb.append(", mSupportWearWay=");
        sb.append(this.mSupportWearWay);
        sb.append(", mSupportGestureWake2=");
        sb.append(this.mSupportGestureWake2);
        sb.append(", mSupportNavImage=");
        sb.append(this.mSupportNavImage);
        sb.append(", mSupportVoiceMaxLength=");
        sb.append(this.mSupportVoiceMaxLength);
        sb.append(", mSupportAudioBooks=");
        sb.append(this.mSupportAudioBooks);
        sb.append(", mSupportStudyCards=");
        sb.append(this.mSupportStudyCards);
        sb.append(", mSupportAppStore=");
        sb.append(this.mSupportAppStore);
        sb.append(", mSupportSHSYAlgorithm=");
        sb.append(this.mSupportSHSYAlgorithm);
        sb.append(", mSupportQiblaSet=");
        sb.append(this.mSupportQiblaSet);
        sb.append(", mSupportMeasurementBloodGlucose=");
        sb.append(this.mSupportMeasurementBloodGlucose);
        sb.append(", mSupportGameControls=");
        sb.append(this.mSupportGameControls);
        sb.append(", mSupportBatteryUsage=");
        sb.append(this.mSupportBatteryUsage);
        sb.append(", mSupportAITranslation=");
        sb.append(this.mSupportAITranslation);
        sb.append(", mSupportSimultaneousTranslation=");
        sb.append(this.mSupportSimultaneousTranslation);
        sb.append(", mSupportTouchSet=");
        sb.append(this.mSupportTouchSet);
        sb.append(", mSupportIMEISet=");
        sb.append(this.mSupportIMEISet);
        sb.append(", mSupportQuran=");
        sb.append(this.mSupportQuran);
        sb.append(", mSupportSyncAGPSInBackground=");
        sb.append(this.mSupportSyncAGPSInBackground);
        sb.append(", mSupportRestoreFactory=");
        sb.append(this.mSupportRestoreFactory);
        sb.append(",mSupportRecordNote = ");
        sb.append(this.mSupportRecordNote);
        sb.append(", mSupportSleepScore=");
        sb.append(this.mSupportSleepScore);
        sb.append(", mSupportWatchface2=");
        sb.append(this.mSupportWatchface2);
        sb.append(",mSupportAICoach=");
        sb.append(this.mSupportAICoach);
        sb.append(",mSupportCrossAppTranslation=");
        sb.append(this.mSupportCrossAppTranslation);
        sb.append(", mSupportRelaxReminder=");
        sb.append(this.mSupportRelaxReminder);
        sb.append(", mSupportPower2=");
        sb.append(this.mSupportPower2);
        sb.append(HexStringBuilder.COMMENT_END_CHAR);
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ BleDeviceInfo(int r114, java.util.List r115, java.lang.String r116, java.lang.String r117, java.lang.String r118, java.lang.String r119, java.lang.String r120, java.lang.String r121, int r122, long r123, int r125, java.lang.String r126, int r127, int r128, int r129, int r130, int r131, int r132, int r133, int r134, int r135, int r136, int r137, int r138, int r139, int r140, int r141, int r142, int r143, int r144, int r145, int r146, int r147, int r148, int r149, int r150, int r151, int r152, int r153, int r154, int r155, int r156, int r157, int r158, int r159, int r160, int r161, int r162, int r163, int r164, int r165, int r166, java.lang.String r167, int r168, int r169, int r170, int r171, int r172, int r173, int r174, int r175, int r176, int r177, int r178, int r179, int r180, int r181, int r182, int r183, int r184, int r185, int r186, int r187, int r188, int r189, int r190, int r191, int r192, int r193, int r194, int r195, int r196, int r197, int r198, int r199, int r200, int r201, int r202, int r203, int r204, int r205, int r206, int r207, int r208, int r209, int r210, int r211, int r212, int r213, int r214, int r215, int r216, int r217, int r218, int r219, int r220, int r221, int r222, int r223, int r224, int r225, int r226, int r227, int r228, int r229, int r230, int r231, int r232, kotlin.jvm.internal.IIXOooo r233) {
        /*
            Method dump skipped, instructions count: 1371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.szabh.smable3.entity.BleDeviceInfo.<init>(int, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, long, int, java.lang.String, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, java.lang.String, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.IIXOooo):void");
    }

    public BleDeviceInfo(int i, @OOXIXo List<Integer> mDataKeys, @OOXIXo String mBleName, @OOXIXo String mBleCustomName, @OOXIXo String mBleAddress, @OOXIXo String mPlatform, @OOXIXo String mPrototype, @OOXIXo String mFirmwareFlag, int i2, long j, int i3, @OOXIXo String mClassicAddress, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, @OOXIXo String mBleDefaultName, int i44, int i45, int i46, int i47, int i48, int i49, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, int i62, int i63, int i64, int i65, int i66, int i67, int i68, int i69, int i70, int i71, int i72, int i73, int i74, int i75, int i76, int i77, int i78, int i79, int i80, int i81, int i82, int i83, int i84, int i85, int i86, int i87, int i88, int i89, int i90, int i91, int i92, int i93, int i94, int i95, int i96, int i97, int i98, int i99, int i100, int i101, int i102, int i103, int i104) {
        IIX0o.x0xO0oo(mDataKeys, "mDataKeys");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mBleCustomName, "mBleCustomName");
        IIX0o.x0xO0oo(mBleAddress, "mBleAddress");
        IIX0o.x0xO0oo(mPlatform, "mPlatform");
        IIX0o.x0xO0oo(mPrototype, "mPrototype");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        IIX0o.x0xO0oo(mClassicAddress, "mClassicAddress");
        IIX0o.x0xO0oo(mBleDefaultName, "mBleDefaultName");
        this.mId = i;
        this.mDataKeys = mDataKeys;
        this.mBleName = mBleName;
        this.mBleCustomName = mBleCustomName;
        this.mBleAddress = mBleAddress;
        this.mPlatform = mPlatform;
        this.mPrototype = mPrototype;
        this.mFirmwareFlag = mFirmwareFlag;
        this.mAGpsType = i2;
        this.mIOBufferSize = j;
        this.mWatchFaceType = i3;
        this.mClassicAddress = mClassicAddress;
        this.mHideDigitalPower = i4;
        this.mShowAntiLostSwitch = i5;
        this.mSleepAlgorithmType = i6;
        this.mSupportDateFormatSet = i7;
        this.mSupportReadDeviceInfo = i8;
        this.mSupportTemperatureUnitSet = i9;
        this.mSupportDrinkWaterSet = i10;
        this.mSupportChangeClassicBluetoothState = i11;
        this.mSupportAppSport = i12;
        this.mSupportBloodOxyGenSet = i13;
        this.mSupportWashSet = i14;
        this.mSupportRequestRealtimeWeather = i15;
        this.mSupportHID = i16;
        this.mSupportIBeaconSet = i17;
        this.mSupportWatchFaceId = i18;
        this.mSupportNewTransportMode = i19;
        this.mSupportJLTransport = i20;
        this.mSupportFindWatch = i21;
        this.mSupportWorldClock = i22;
        this.mSupportStock = i23;
        this.mSupportSMSQuickReply = i24;
        this.mSupportNoDisturbSet = i25;
        this.mSupportSetWatchPassword = i26;
        this.mSupportRealTimeMeasurement = i27;
        this.mSupportPowerSaveMode = i28;
        this.mSupportLoveTap = i29;
        this.mSupportNewsfeed = i30;
        this.mSupportMedicationReminder = i31;
        this.mSupportQrcode = i32;
        this.mSupportWeather2 = i33;
        this.mSupportAlipay = i34;
        this.mSupportStandbySet = i35;
        this.mSupport2DAcceleration = i36;
        this.mSupportTuyaKey = i37;
        this.mSupportMedicationAlarm = i38;
        this.mSupportReadPackageStatus = i39;
        this.mSupportContactSize = i40;
        this.mSupportVoice = i41;
        this.mSupportNavigation = i42;
        this.mSupportHrWarnSet = i43;
        this.mBleDefaultName = mBleDefaultName;
        this.mSupportMusicTransfer = i44;
        this.mSupportNoDisturbSet2 = i45;
        this.mSupportSOSSet = i46;
        this.mSupportReadLanguages = i47;
        this.mSupportGirlCareReminder = i48;
        this.mSupportAppPushSwitch = i49;
        this.mSupportReceiptCodeSize = i50;
        this.mSupportGameTimeReminder = i51;
        this.mSupportMyCardCodeSize = i52;
        this.mSupportDeviceSportData = i53;
        this.mSupportEbookTransfer = i54;
        this.mSupportDoubleScreen = i55;
        this.mSupportCustomLogo = i56;
        this.mSupportPressureTimingMeasurement = i57;
        this.mSupportTimerStandbySet = i58;
        this.mSupportSOSSet2 = i59;
        this.mSupportFallSet = i60;
        this.mSupportWalkAndBike = i61;
        this.mSupportConnectReminder = i62;
        this.mSupportSDCardInfo = i63;
        this.mSupportIncomingCallRing = i64;
        this.mSupportNotificationLightScreenSet = i65;
        this.mSupportBloodPressureCalibration = i66;
        this.mSupportOTAFile = i67;
        this.mSupportGPSFirmwareFile = i68;
        this.mSupportGoMoreSet = i69;
        this.mSupportRingVibrationSet = i70;
        this.mSupportNetwork = i71;
        this.mSupportContactSort = i72;
        this.mQrcodeSize = i73;
        this.mQrcodeContentSize = i74;
        this.mSupportStringQrcode = i75;
        this.mSupportWatchFaceIndex = i76;
        this.mSupportSosContact = i77;
        this.mSupportGirlCareMonthly = i78;
        this.mSupportWearWay = i79;
        this.mSupportGestureWake2 = i80;
        this.mSupportNavImage = i81;
        this.mSupportVoiceMaxLength = i82;
        this.mSupportAudioBooks = i83;
        this.mSupportStudyCards = i84;
        this.mSupportAppStore = i85;
        this.mSupportSHSYAlgorithm = i86;
        this.mSupportQiblaSet = i87;
        this.mSupportMeasurementBloodGlucose = i88;
        this.mSupportGameControls = i89;
        this.mSupportBatteryUsage = i90;
        this.mSupportAITranslation = i91;
        this.mSupportSimultaneousTranslation = i92;
        this.mSupportTouchSet = i93;
        this.mSupportIMEISet = i94;
        this.mSupportQuran = i95;
        this.mSupportSyncAGPSInBackground = i96;
        this.mSupportRestoreFactory = i97;
        this.mSupportRecordNote = i98;
        this.mSupportSleepScore = i99;
        this.mSupportWatchface2 = i100;
        this.mSupportAICoach = i101;
        this.mSupportCrossAppTranslation = i102;
        this.mSupportRelaxReminder = i103;
        this.mSupportPower2 = i104;
    }
}
