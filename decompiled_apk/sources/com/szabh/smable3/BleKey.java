package com.szabh.smable3;

import OXOo.OOXIXo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.ar.base.MsgField;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.UIMsg;
import com.blankj.utilcode.constant.PermissionConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.garmin.fit.OxXXx0X;
import com.goodix.ble.libble.center.BleCenter;
import com.goodix.ble.libcomx.task.TaskPipe;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.jieli.jl_rcsp.constant.Command;
import com.realsil.sdk.dfu.DfuConstants;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import com.realsil.sdk.dfu.utils.DfuAdapter;
import com.sifli.siflidfu.constants.General;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.ui.me.CoachingSegmentEditActivity;
import com.sma.smartv3.view.picker.HeightPicker;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oI0IIXIo;
import kotlin.enums.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@XX({"SMAP\nBleCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCommand.kt\ncom/szabh/smable3/BleKey\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
/* loaded from: classes13.dex */
public final class BleKey {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ BleKey[] $VALUES;

    @OOXIXo
    public static final oIX0oI Companion;
    private final int mKey;
    public static final BleKey OTA = new BleKey("OTA", 0, 257);
    public static final BleKey XMODEM = new BleKey("XMODEM", 1, 258);
    public static final BleKey TIME = new BleKey("TIME", 2, 513);
    public static final BleKey TIME_ZONE = new BleKey("TIME_ZONE", 3, 514);
    public static final BleKey POWER = new BleKey(ProductManager.oxIIOOX, 4, 515);
    public static final BleKey FIRMWARE_VERSION = new BleKey("FIRMWARE_VERSION", 5, 516);
    public static final BleKey BLE_ADDRESS = new BleKey("BLE_ADDRESS", 6, 517);
    public static final BleKey USER_PROFILE = new BleKey("USER_PROFILE", 7, 518);
    public static final BleKey STEP_GOAL = new BleKey("STEP_GOAL", 8, 519);
    public static final BleKey BACK_LIGHT = new BleKey("BACK_LIGHT", 9, 520);
    public static final BleKey SEDENTARINESS = new BleKey("SEDENTARINESS", 10, 521);
    public static final BleKey NO_DISTURB_RANGE = new BleKey("NO_DISTURB_RANGE", 11, DfuConstants.PROGRESS_HAND_OVER_PROCESSING);
    public static final BleKey VIBRATION = new BleKey("VIBRATION", 12, 523);
    public static final BleKey GESTURE_WAKE = new BleKey("GESTURE_WAKE", 13, DfuConstants.PROGRESS_ACTIVE_IMAGE_AND_RESET);
    public static final BleKey HR_ASSIST_SLEEP = new BleKey("HR_ASSIST_SLEEP", 14, 525);
    public static final BleKey HOUR_SYSTEM = new BleKey("HOUR_SYSTEM", 15, 526);
    public static final BleKey LANGUAGE = new BleKey("LANGUAGE", 16, 527);
    public static final BleKey ALARM = new BleKey("ALARM", 17, BNMapObserver.EventMapView.EVENT_CLICKED_ROUTE_PAN_ITEM);
    public static final BleKey UNIT_SET = new BleKey("UNIT_SET", 18, BNMapObserver.EventMapView.EVENT_CLICKED_DEST_NODE_BUBBLE);
    public static final BleKey COACHING = new BleKey("COACHING", 19, 530);
    public static final BleKey FIND_PHONE = new BleKey("FIND_PHONE", 20, BNMapObserver.EventMapView.EVENT_CLICKED_DYNAMIC_LAYER_ITEM);
    public static final BleKey NOTIFICATION_REMINDER = new BleKey("NOTIFICATION_REMINDER", 21, 532);
    public static final BleKey ANTI_LOST = new BleKey("ANTI_LOST", 22, 533);
    public static final BleKey HR_MONITORING = new BleKey("HR_MONITORING", 23, DfuAdapter.STATE_PREPARE_PAIRING_REQUEST);
    public static final BleKey UI_PACK_VERSION = new BleKey("UI_PACK_VERSION", 24, DfuAdapter.STATE_PREPARE_CONNECTING);
    public static final BleKey LANGUAGE_PACK_VERSION = new BleKey("LANGUAGE_PACK_VERSION", 25, DfuAdapter.STATE_PENDDING_DISCOVERY_SERVICE);
    public static final BleKey SLEEP_QUALITY = new BleKey("SLEEP_QUALITY", 26, DfuAdapter.STATE_DISCOVERY_SERVICE);
    public static final BleKey GIRL_CARE = new BleKey("GIRL_CARE", 27, 538);
    public static final BleKey TEMPERATURE_DETECTING = new BleKey("TEMPERATURE_DETECTING", 28, 539);
    public static final BleKey AEROBIC_EXERCISE = new BleKey("AEROBIC_EXERCISE", 29, 540);
    public static final BleKey TEMPERATURE_UNIT = new BleKey("TEMPERATURE_UNIT", 30, DfuAdapter.STATE_SYNC_SUB_INFO);
    public static final BleKey DATE_FORMAT = new BleKey("DATE_FORMAT", 31, DfuAdapter.STATE_READ_BATTERY_INFO);
    public static final BleKey WATCH_FACE_SWITCH = new BleKey("WATCH_FACE_SWITCH", 32, DfuAdapter.STATE_READ_IMAGE_INFO);
    public static final BleKey AGPS_PREREQUISITE = new BleKey("AGPS_PREREQUISITE", 33, 544);
    public static final BleKey DRINK_WATER = new BleKey("DRINK_WATER", 34, 545);
    public static final BleKey SHUTDOWN = new BleKey("SHUTDOWN", 35, 546);
    public static final BleKey APP_SPORT_DATA = new BleKey("APP_SPORT_DATA", 36, 547);
    public static final BleKey REAL_TIME_HEART_RATE = new BleKey("REAL_TIME_HEART_RATE", 37, General.SIFLI_DFU_PACKET_BODY_LEN_NOR);
    public static final BleKey BLOOD_OXYGEN_SET = new BleKey("BLOOD_OXYGEN_SET", 38, 549);
    public static final BleKey WASH_SET = new BleKey("WASH_SET", 39, 550);
    public static final BleKey WATCHFACE_ID = new BleKey("WATCHFACE_ID", 40, UIMsg.MsgDefine.MSG_LOG_GESTURE);
    public static final BleKey IBEACON_SET = new BleKey("IBEACON_SET", 41, 552);
    public static final BleKey MAC_QRCODE = new BleKey("MAC_QRCODE", 42, 553);
    public static final BleKey REAL_TIME_TEMPERATURE = new BleKey("REAL_TIME_TEMPERATURE", 43, 560);
    public static final BleKey REAL_TIME_BLOOD_PRESSURE = new BleKey("REAL_TIME_BLOOD_PRESSURE", 44, 561);
    public static final BleKey TEMPERATURE_VALUE = new BleKey("TEMPERATURE_VALUE", 45, TTAdConstant.STYLE_SIZE_RADIO_9_16);
    public static final BleKey GAME_SET = new BleKey("GAME_SET", 46, 563);
    public static final BleKey FIND_WATCH = new BleKey("FIND_WATCH", 47, 564);
    public static final BleKey SET_WATCH_PASSWORD = new BleKey("SET_WATCH_PASSWORD", 48, 565);
    public static final BleKey REALTIME_MEASUREMENT = new BleKey("REALTIME_MEASUREMENT", 49, 566);
    public static final BleKey POWER_SAVE_MODE = new BleKey("POWER_SAVE_MODE", 50, 567);
    public static final BleKey BAC_SET = new BleKey("BAC_SET", 51, 568);
    public static final BleKey CALORIES_GOAL = new BleKey("CALORIES_GOAL", 52, 569);
    public static final BleKey DISTANCE_GOAL = new BleKey("DISTANCE_GOAL", 53, 570);
    public static final BleKey SLEEP_GOAL = new BleKey("SLEEP_GOAL", 54, 571);
    public static final BleKey LOVE_TAP_USER = new BleKey("LOVE_TAP_USER", 55, 572);
    public static final BleKey MEDICATION_REMINDER = new BleKey("MEDICATION_REMINDER", 56, 573);
    public static final BleKey DEVICE_INFO = new BleKey("DEVICE_INFO", 57, 574);
    public static final BleKey HR_WARNING_SET = new BleKey("HR_WARNING_SET", 58, 575);
    public static final BleKey SLEEP_MONITORING = new BleKey("SLEEP_MONITORING", 59, 576);
    public static final BleKey STANDBY_SET = new BleKey("STANDBY_SET", 60, 577);
    public static final BleKey BT_NAME = new BleKey("BT_NAME", 61, 578);
    public static final BleKey TUYA_KEY_SET = new BleKey("TUYA_KEY_SET", 62, 579);
    public static final BleKey BAC_RESULT = new BleKey("BAC_RESULT", 63, 580);
    public static final BleKey BAC_RESULT_SET = new BleKey("BAC_RESULT_SET", 64, 581);
    public static final BleKey MEDICATION_ALARM = new BleKey("MEDICATION_ALARM", 65, 582);
    public static final BleKey MATCH_SET = new BleKey("MATCH_SET", 66, 583);
    public static final BleKey PACKAGE_STATUS = new BleKey("PACKAGE_STATUS", 67, 585);
    public static final BleKey NOTIFICATION_REMINDER2 = new BleKey("NOTIFICATION_REMINDER2", 68, 592);
    public static final BleKey ALIPAY_SET = new BleKey("ALIPAY_SET", 69, 586);
    public static final BleKey RECORD_PACKET = new BleKey("RECORD_PACKET", 70, 587);
    public static final BleKey BLE_ADDRESS_SET = new BleKey("BLE_ADDRESS_SET", 71, 588);
    public static final BleKey NAVI_INFO = new BleKey("NAVI_INFO", 72, 589);
    public static final BleKey SOS_SET = new BleKey("SOS_SET", 73, 590);
    public static final BleKey DEVICE_LANGUAGES = new BleKey("DEVICE_LANGUAGES", 74, 591);
    public static final BleKey GAME_TIME_REMINDER = new BleKey("GAME_TIME_REMINDER", 75, 593);
    public static final BleKey DEVICE_SPORT_DATA = new BleKey("DEVICE_SPORT_DATA", 76, 594);
    public static final BleKey PRESSURE_TIMING_MEASUREMENT = new BleKey("PRESSURE_TIMING_MEASUREMENT", 77, 595);
    public static final BleKey STANDBY_WATCH_FACE_SET = new BleKey("STANDBY_WATCH_FACE_SET", 78, 596);
    public static final BleKey FALL_SET = new BleKey("FALL_SET", 79, 597);
    public static final BleKey BW_NAVI_INFO = new BleKey("BW_NAVI_INFO", 80, BleCenter.EVT_REMOVED);
    public static final BleKey CONNECT_REMINDER = new BleKey("CONNECT_REMINDER", 81, 599);
    public static final BleKey SDCARD_INFO = new BleKey("SDCARD_INFO", 82, 600);
    public static final BleKey ACTIVITY_DETAIL = new BleKey("ACTIVITY_DETAIL", 83, 601);
    public static final BleKey NOTIFICATION_LIGHT_SCREEN_SET = new BleKey("NOTIFICATION_LIGHT_SCREEN_SET", 84, 602);
    public static final BleKey BLOOD_PRESSURE_CALIBRATION = new BleKey("BLOOD_PRESSURE_CALIBRATION", 85, 603);
    public static final BleKey AIR_PRESSURE_CALIBRATION = new BleKey("AIR_PRESSURE_CALIBRATION", 86, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR);
    public static final BleKey EARPHONE_POWER = new BleKey("EARPHONE_POWER", 87, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO);
    public static final BleKey EARPHONE_ANC_SET = new BleKey("EARPHONE_ANC_SET", 88, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO);
    public static final BleKey EARPHONE_SOUND_EFFECTS_SET = new BleKey("EARPHONE_SOUND_EFFECTS_SET", 89, TypedValues.MotionType.TYPE_PATHMOTION_ARC);
    public static final BleKey SCREEN_BRIGHTNESS_SET = new BleKey("SCREEN_BRIGHTNESS_SET", 90, TypedValues.MotionType.TYPE_DRAW_PATH);
    public static final BleKey EARPHONE_INFO = new BleKey("EARPHONE_INFO", 91, TypedValues.MotionType.TYPE_POLAR_RELATIVETO);
    public static final BleKey EARPHONE_STATE = new BleKey("EARPHONE_STATE", 92, 610);
    public static final BleKey EARPHONE_CALL = new BleKey("EARPHONE_CALL", 93, 611);
    public static final BleKey GPS_FIRMWARE_VERSION = new BleKey("GPS_FIRMWARE_VERSION", 94, 612);
    public static final BleKey GOMORE_SET = new BleKey("GOMORE_SET", 95, 613);
    public static final BleKey RING_VIBRATION_SET = new BleKey("RING_VIBRATION_SET", 96, 614);
    public static final BleKey NETWORK_FIRMWARE_VERSION = new BleKey("NETWORK_FIRMWARE_VERSION", 97, 615);
    public static final BleKey ECG_SET = new BleKey("ECG_SET", 98, 616);
    public static final BleKey SPORT_DURATION_GOAL = new BleKey("SPORT_DURATION_GOAL", 99, 617);
    public static final BleKey WATCHFACE_INDEX = new BleKey("WATCHFACE_INDEX", 100, 618);
    public static final BleKey SOS_CONTACT = new BleKey("SOS_CONTACT", 101, 619);
    public static final BleKey GIRL_CARE_MONTHLY = new BleKey("GIRL_CARE_MONTHLY", 102, 620);
    public static final BleKey GIRL_CARE_MENSTRUATION_UPDATE = new BleKey("GIRL_CARE_MENSTRUATION_UPDATE", 103, 621);
    public static final BleKey HEALTH_INDEX = new BleKey("HEALTH_INDEX", 104, 622);
    public static final BleKey CHECK_IN_EVERY_DAY = new BleKey("CHECK_IN_EVERY_DAY", 105, 623);
    public static final BleKey WEAR_WAY = new BleKey("WEAR_WAY", 106, 624);
    public static final BleKey GESTURE_WAKE2 = new BleKey("GESTURE_WAKE2", 107, 625);
    public static final BleKey EARPHONE_KEY = new BleKey("EARPHONE_KEY", 108, 626);
    public static final BleKey FIND_EARPHONE = new BleKey("FIND_EARPHONE", 109, 627);
    public static final BleKey HANBAO_SET = new BleKey("HANBAO_SET", 110, 628);
    public static final BleKey QIBLA_SET = new BleKey("QIBLA_SET", 111, 629);
    public static final BleKey CALIBRATION_DATA = new BleKey("CALIBRATION_DATA", 112, 630);
    public static final BleKey BATTERY_USAGE = new BleKey("BATTERY_USAGE", 113, 631);
    public static final BleKey TOUCH_SET = new BleKey("TOUCH_SET", 114, 632);
    public static final BleKey DEVICE_UNIQUE_DATA_SET = new BleKey("DEVICE_UNIQUE_DATA_SET", 115, 633);
    public static final BleKey IPC_VERSION = new BleKey("IPC_VERSION", 116, 636);
    public static final BleKey IPC_STORES_INFO = new BleKey("IPC_STORES_INFO", 117, 637);
    public static final BleKey SLEEP_QUALITY_SCORE = new BleKey("SLEEP_QUALITY_SCORE", 118, 639);
    public static final BleKey RELAX_REMINDER = new BleKey("RELAX_REMINDER", 119, ScreenUtil.SCREEN_SIZE_Y_LARGE);
    public static final BleKey CP_USER_INFO = new BleKey("CP_USER_INFO", 120, 641);
    public static final BleKey TEST_INFO_SET = new BleKey("TEST_INFO_SET", 121, 642);
    public static final BleKey POWER2 = new BleKey("POWER2", 122, 643);
    public static final BleKey PPG_SHSY = new BleKey("PPG_SHSY", 123, 757);
    public static final BleKey GSENSOR_SHSY = new BleKey("GSENSOR_SHSY", 124, 758);
    public static final BleKey LOCATION_GSV = new BleKey("LOCATION_GSV", 125, 759);
    public static final BleKey HR_RAW = new BleKey("HR_RAW", 126, 760);
    public static final BleKey REALTIME_LOG = new BleKey("REALTIME_LOG", 127, TaskPipe.EVT_BUSY);
    public static final BleKey GSENSOR_OUTPUT = new BleKey("GSENSOR_OUTPUT", 128, 762);
    public static final BleKey GSENSOR_RAW = new BleKey("GSENSOR_RAW", 129, 763);
    public static final BleKey MOTION_DETECT = new BleKey("MOTION_DETECT", 130, 764);
    public static final BleKey LOCATION_GGA = new BleKey("LOCATION_GGA", 131, 765);
    public static final BleKey RAW_SLEEP = new BleKey("RAW_SLEEP", 132, DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    public static final BleKey NO_DISTURB_GLOBAL = new BleKey("NO_DISTURB_GLOBAL", 133, DfuException.ERROR_NOTIFICATION_NO_RESPONSE);
    public static final BleKey IDENTITY = new BleKey("IDENTITY", 134, 769);
    public static final BleKey SESSION = new BleKey("SESSION", 135, 770);
    public static final BleKey NOTIFICATION = new BleKey("NOTIFICATION", 136, 1025);
    public static final BleKey MUSIC_CONTROL = new BleKey("MUSIC_CONTROL", 137, 1026);
    public static final BleKey SCHEDULE = new BleKey("SCHEDULE", 138, 1027);
    public static final BleKey WEATHER_REALTIME = new BleKey("WEATHER_REALTIME", 139, 1028);
    public static final BleKey WEATHER_FORECAST = new BleKey("WEATHER_FORECAST", 140, 1029);
    public static final BleKey HID = new BleKey("HID", 141, 1030);
    public static final BleKey WORLD_CLOCK = new BleKey("WORLD_CLOCK", 142, ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE);
    public static final BleKey STOCK = new BleKey("STOCK", 143, 1032);
    public static final BleKey SMS_QUICK_REPLY_CONTENT = new BleKey("SMS_QUICK_REPLY_CONTENT", 144, 1033);
    public static final BleKey NOTIFICATION2 = new BleKey("NOTIFICATION2", 145, 1034);
    public static final BleKey NEWS_FEED = new BleKey("NEWS_FEED", 146, 1035);
    public static final BleKey WEATHER_REALTIME2 = new BleKey("WEATHER_REALTIME2", 147, OxXXx0X.f13101XIxXXX0x0);
    public static final BleKey WEATHER_FORECAST2 = new BleKey("WEATHER_FORECAST2", 148, 1037);
    public static final BleKey LOGIN_DAYS = new BleKey("LOGIN_DAYS", 149, 1038);
    public static final BleKey TARGET_COMPLETION = new BleKey("TARGET_COMPLETION", 150, 1039);
    public static final BleKey AUDIO_TEXT = new BleKey("AUDIO_TEXT", 151, SubBinId.Bbpro.DSP_UI_PARAMETER_FILE);
    public static final BleKey WEATHER_REALTIME3 = new BleKey("WEATHER_REALTIME3", 152, 1042);
    public static final BleKey WEATHER_FORECAST3 = new BleKey("WEATHER_FORECAST3", 153, 1043);
    public static final BleKey DATA_ALL = new BleKey("DATA_ALL", 154, 1535);
    public static final BleKey ACTIVITY_REALTIME = new BleKey("ACTIVITY_REALTIME", 155, 1281);
    public static final BleKey ACTIVITY = new BleKey("ACTIVITY", 156, 1282);
    public static final BleKey HEART_RATE = new BleKey("HEART_RATE", 157, 1283);
    public static final BleKey BLOOD_PRESSURE = new BleKey("BLOOD_PRESSURE", 158, 1284);
    public static final BleKey SLEEP = new BleKey("SLEEP", 159, 1285);
    public static final BleKey WORKOUT = new BleKey("WORKOUT", 160, 1286);
    public static final BleKey LOCATION = new BleKey(PermissionConstants.LOCATION, 161, 1287);
    public static final BleKey TEMPERATURE = new BleKey("TEMPERATURE", 162, 1288);
    public static final BleKey BLOOD_OXYGEN = new BleKey("BLOOD_OXYGEN", 163, 1289);
    public static final BleKey HRV = new BleKey("HRV", 164, 1290);
    public static final BleKey LOG = new BleKey("LOG", 165, 1291);
    public static final BleKey SLEEP_RAW_DATA = new BleKey("SLEEP_RAW_DATA", 166, 1292);
    public static final BleKey PRESSURE = new BleKey("PRESSURE", 167, 1293);
    public static final BleKey WORKOUT2 = new BleKey("WORKOUT2", 168, 1294);
    public static final BleKey MATCH_RECORD = new BleKey("MATCH_RECORD", 169, 1295);
    public static final BleKey BLOOD_GLUCOSE = new BleKey("BLOOD_GLUCOSE", 170, 1296);
    public static final BleKey BODY_STATUS = new BleKey("BODY_STATUS", EMachine.EM_MANIK, 1297);
    public static final BleKey MIND_STATUS = new BleKey("MIND_STATUS", 172, 1298);
    public static final BleKey CALORIE_INTAKE = new BleKey("CALORIE_INTAKE", 173, 1299);
    public static final BleKey FOOD_BALANCE = new BleKey("FOOD_BALANCE", 174, FeatureCodes.VO);
    public static final BleKey BAC = new BleKey("BAC", EMachine.EM_MCST_ELBRUS, 1301);
    public static final BleKey MATCH_RECORD2 = new BleKey("MATCH_RECORD2", 176, 1302);
    public static final BleKey AVG_HEART_RATE = new BleKey("AVG_HEART_RATE", 177, 1303);
    public static final BleKey ALIPAY_BIND_INFO = new BleKey("ALIPAY_BIND_INFO", 178, 1304);
    public static final BleKey RRI = new BleKey("RRI", EMachine.EM_SLE9X, 1305);
    public static final BleKey ECG = new BleKey("ECG", 180, 1312);
    public static final BleKey HANBAO_VIBRATION = new BleKey("HANBAO_VIBRATION", 181, 1313);
    public static final BleKey SOS_CALL_LOG = new BleKey("SOS_CALL_LOG", 182, 1314);
    public static final BleKey WORKOUT3 = new BleKey("WORKOUT3", 183, 1315);
    public static final BleKey DAILY_POWER = new BleKey("DAILY_POWER", 184, 1317);
    public static final BleKey TRAINING_STATUS = new BleKey("TRAINING_STATUS", 185, 1318);
    public static final BleKey VITALITY = new BleKey("VITALITY", 186, 1319);
    public static final BleKey HRV2 = new BleKey("HRV2", 187, 1320);
    public static final BleKey RESPIRATORY_RATE = new BleKey("RESPIRATORY_RATE", 188, 1321);
    public static final BleKey CAMERA = new BleKey(PermissionConstants.CAMERA, PsExtractor.PRIVATE_STREAM_1, 1537);
    public static final BleKey REQUEST_LOCATION = new BleKey("REQUEST_LOCATION", 190, SubBinId.Bbpro.DSP_APP_IMAGE);
    public static final BleKey INCOMING_CALL = new BleKey("INCOMING_CALL", EMachine.EM_TILEGX, SubBinId.Bbpro.DSP_SCENARIO2);
    public static final BleKey APP_SPORT_STATE = new BleKey("APP_SPORT_STATE", 192, 1540);
    public static final BleKey CLASSIC_BLUETOOTH_STATE = new BleKey("CLASSIC_BLUETOOTH_STATE", 193, 1541);
    public static final BleKey DEVICE_SMS_QUICK_REPLY = new BleKey("DEVICE_SMS_QUICK_REPLY", 194, 1543);
    public static final BleKey LOVE_TAP = new BleKey("LOVE_TAP", 195, 1544);
    public static final BleKey FACTORY_TEST = new BleKey("FACTORY_TEST", 196, 1545);
    public static final BleKey DOUBLE_SCREEN = new BleKey("DOUBLE_SCREEN", 197, 1546);
    public static final BleKey BAC_CALIBRATION = new BleKey("BAC_CALIBRATION", 198, 1547);
    public static final BleKey INCOMING_CALL_RING = new BleKey("INCOMING_CALL_RING", 199, 1548);
    public static final BleKey SPORT_END_NOTIFY = new BleKey("SPORT_END_NOTIFY", 200, 1549);
    public static final BleKey FILE_PATH = new BleKey("FILE_PATH", 201, 1550);
    public static final BleKey APP_OP = new BleKey("APP_OP", 202, OxXXx0X.f12952I0X0x0oIo);
    public static final BleKey HANBAO_VIBRATION_STATE = new BleKey("HANBAO_VIBRATION_STATE", 203, 1552);
    public static final BleKey MEASUREMENT = new BleKey("MEASUREMENT", 204, 1553);
    public static final BleKey GAME_CONTROL = new BleKey("GAME_CONTROL", 205, 1554);
    public static final BleKey APP_API_VERSION = new BleKey("APP_API_VERSION", 206, OxXXx0X.f13178oX);
    public static final BleKey DEVICE_OP = new BleKey("DEVICE_OP", 207, 1556);
    public static final BleKey RECEIVE_DEVICE_FILE = new BleKey("RECEIVE_DEVICE_FILE", 208, 1557);
    public static final BleKey AI_COMMAND = new BleKey("AI_COMMAND", 209, 1558);
    public static final BleKey SG_RGB_SET = new BleKey("SG_RGB_SET", 210, 1559);
    public static final BleKey SG_SLEEP_SET = new BleKey("SG_SLEEP_SET", 211, 1560);
    public static final BleKey SG_EQ_SET = new BleKey("SG_EQ_SET", 212, OxXXx0X.f13124Xo0);
    public static final BleKey SG_KEY_SET = new BleKey("SG_KEY_SET", 213, 1562);
    public static final BleKey SG_CAMERA_SET = new BleKey("SG_CAMERA_SET", Command.CMD_GET_EXTERNAL_FLASH_MSG, 1563);
    public static final BleKey IPC_WIFI_STATE = new BleKey("IPC_WIFI_STATE", 215, 1564);
    public static final BleKey SG_KEYWORD_AWAKE = new BleKey("SG_KEYWORD_AWAKE", 216, 1565);
    public static final BleKey IPC_WIFI_INFO = new BleKey("IPC_WIFI_INFO", Command.CMD_GET_DEVICE_CONFIG_INFO, 1566);
    public static final BleKey AI_COACH_PLAN = new BleKey("AI_COACH_PLAN", HeightPicker.f25534xoXoI, OxXXx0X.f13125XoI0Ixx0);
    public static final BleKey WEAR_STATE = new BleKey("WEAR_STATE", 219, 1568);
    public static final BleKey SG_TEST = new BleKey("SG_TEST", CoachingSegmentEditActivity.HR_MAX, 1569);
    public static final BleKey LACTATE_THRESHOLD = new BleKey("LACTATE_THRESHOLD", 221, OxXXx0X.f13016O0Xx);
    public static final BleKey WATCH_FACE = new BleKey("WATCH_FACE", 222, 1793);
    public static final BleKey AGPS_FILE = new BleKey("AGPS_FILE", 223, 1794);
    public static final BleKey FONT_FILE = new BleKey("FONT_FILE", 224, 1795);
    public static final BleKey CONTACT = new BleKey("CONTACT", 225, 1796);
    public static final BleKey UI_FILE = new BleKey("UI_FILE", 226, 1797);
    public static final BleKey DEVICE_FILE = new BleKey("DEVICE_FILE", 227, 1798);
    public static final BleKey LANGUAGE_FILE = new BleKey("LANGUAGE_FILE", 228, 1799);
    public static final BleKey BRAND_INFO_FILE = new BleKey("BRAND_INFO_FILE", 229, FeatureCodes.HAIR_SEG);
    public static final BleKey QRCODE = new BleKey("QRCODE", 230, 1801);
    public static final BleKey THIRD_PARTY_DATA = new BleKey("THIRD_PARTY_DATA", 231, MsgField.MSG_ON_QUERY_RESOURCE_ERROR_SERVER);
    public static final BleKey QRCODE2 = new BleKey("QRCODE2", 232, MsgField.IMSG_SO_DOWNLOAD_ERROR);
    public static final BleKey LOGO_FILE = new BleKey("LOGO_FILE", 233, MsgField.IMSG_QUERY_RES_ERROR);
    public static final BleKey OTA_FILE = new BleKey("OTA_FILE", 234, MsgField.IMSG_DOWNLOAD_RES_ERROR);
    public static final BleKey GPS_FIRMWARE_FILE = new BleKey("GPS_FIRMWARE_FILE", 235, MsgField.IMSG_ON_DEVICE_IR_START);
    public static final BleKey CONTACT_SORT = new BleKey("CONTACT_SORT", 236, MsgField.IMSG_CLORD_ID_START);
    public static final BleKey NAVI_IMAGE = new BleKey("NAVI_IMAGE", 237, MsgField.IMSG_TRACK_MODEL_NOT_SHOWING);
    public static final BleKey APP_FILE = new BleKey("APP_FILE", 238, MsgField.IMSG_TRACK_MODEL_APPEAR);
    public static final BleKey FAT_BIN_FILE = new BleKey("FAT_BIN_FILE", 239, MsgField.IMSG_SLAM_MODEL_DISAPPEAR);
    public static final BleKey AGPS_FILE2 = new BleKey("AGPS_FILE2", 240, MsgField.IMSG_IMU_MODEL_DISAPPEAR);
    public static final BleKey NONE = new BleKey("NONE", Command.CMD_PHONE_NUMBER_PLAY_MODE, 65535);

    /* loaded from: classes13.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f26446oIX0oI;

        static {
            int[] iArr = new int[BleKey.values().length];
            try {
                iArr[BleKey.OTA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleKey.XMODEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleKey.POWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleKey.FIRMWARE_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleKey.BLE_ADDRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BleKey.UI_PACK_VERSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BleKey.LANGUAGE_PACK_VERSION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BleKey.DEVICE_FILE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BleKey.RAW_SLEEP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BleKey.DEVICE_INFO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BleKey.PACKAGE_STATUS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BleKey.DEVICE_LANGUAGES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[BleKey.SDCARD_INFO.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[BleKey.ACTIVITY_DETAIL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[BleKey.EARPHONE_POWER.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[BleKey.EARPHONE_STATE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[BleKey.EARPHONE_INFO.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[BleKey.GPS_FIRMWARE_VERSION.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[BleKey.NETWORK_FIRMWARE_VERSION.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[BleKey.GIRL_CARE_MONTHLY.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[BleKey.IPC_VERSION.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[BleKey.IPC_STORES_INFO.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[BleKey.SLEEP_QUALITY_SCORE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[BleKey.RELAX_REMINDER.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[BleKey.POWER2.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[BleKey.TIME.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[BleKey.NOTIFICATION_REMINDER.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[BleKey.SLEEP_QUALITY.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[BleKey.TEMPERATURE_DETECTING.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[BleKey.SHUTDOWN.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[BleKey.APP_SPORT_DATA.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[BleKey.REAL_TIME_HEART_RATE.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[BleKey.IBEACON_SET.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[BleKey.MAC_QRCODE.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[BleKey.REAL_TIME_TEMPERATURE.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[BleKey.REAL_TIME_BLOOD_PRESSURE.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[BleKey.REALTIME_MEASUREMENT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[BleKey.BAC_SET.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[BleKey.HR_WARNING_SET.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[BleKey.SLEEP_MONITORING.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[BleKey.BT_NAME.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[BleKey.BAC_RESULT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[BleKey.BAC_RESULT_SET.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[BleKey.MATCH_SET.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[BleKey.BLE_ADDRESS_SET.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[BleKey.NAVI_INFO.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[BleKey.DEVICE_SPORT_DATA.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[BleKey.FIND_PHONE.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[BleKey.BW_NAVI_INFO.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[BleKey.CONNECT_REMINDER.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr[BleKey.AIR_PRESSURE_CALIBRATION.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr[BleKey.ECG_SET.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr[BleKey.GIRL_CARE_MENSTRUATION_UPDATE.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr[BleKey.HEALTH_INDEX.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr[BleKey.WEAR_WAY.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr[BleKey.FIND_EARPHONE.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr[BleKey.TOUCH_SET.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr[BleKey.RECORD_PACKET.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr[BleKey.TEST_INFO_SET.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr[BleKey.TIME_ZONE.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr[BleKey.USER_PROFILE.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr[BleKey.STEP_GOAL.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr[BleKey.BACK_LIGHT.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr[BleKey.SEDENTARINESS.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr[BleKey.NO_DISTURB_RANGE.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr[BleKey.NO_DISTURB_GLOBAL.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr[BleKey.VIBRATION.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr[BleKey.GESTURE_WAKE.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr[BleKey.HR_ASSIST_SLEEP.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr[BleKey.HOUR_SYSTEM.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr[BleKey.LANGUAGE.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr[BleKey.ANTI_LOST.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr[BleKey.HR_MONITORING.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr[BleKey.AEROBIC_EXERCISE.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr[BleKey.TEMPERATURE_UNIT.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr[BleKey.DATE_FORMAT.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr[BleKey.WATCH_FACE_SWITCH.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr[BleKey.DRINK_WATER.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr[BleKey.WATCHFACE_ID.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr[BleKey.POWER_SAVE_MODE.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr[BleKey.CALORIES_GOAL.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr[BleKey.DISTANCE_GOAL.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr[BleKey.SLEEP_GOAL.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr[BleKey.UNIT_SET.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr[BleKey.STANDBY_SET.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                iArr[BleKey.ALIPAY_SET.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                iArr[BleKey.SET_WATCH_PASSWORD.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                iArr[BleKey.SOS_SET.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                iArr[BleKey.GIRL_CARE.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                iArr[BleKey.GAME_TIME_REMINDER.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                iArr[BleKey.PRESSURE_TIMING_MEASUREMENT.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                iArr[BleKey.STANDBY_WATCH_FACE_SET.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                iArr[BleKey.DOUBLE_SCREEN.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                iArr[BleKey.BLOOD_OXYGEN_SET.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                iArr[BleKey.NOTIFICATION_REMINDER2.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                iArr[BleKey.FALL_SET.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                iArr[BleKey.INCOMING_CALL_RING.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                iArr[BleKey.NOTIFICATION_LIGHT_SCREEN_SET.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                iArr[BleKey.BLOOD_PRESSURE_CALIBRATION.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                iArr[BleKey.EARPHONE_ANC_SET.ordinal()] = 100;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                iArr[BleKey.EARPHONE_SOUND_EFFECTS_SET.ordinal()] = 101;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                iArr[BleKey.SCREEN_BRIGHTNESS_SET.ordinal()] = 102;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                iArr[BleKey.EARPHONE_CALL.ordinal()] = 103;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                iArr[BleKey.GOMORE_SET.ordinal()] = 104;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                iArr[BleKey.RING_VIBRATION_SET.ordinal()] = 105;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                iArr[BleKey.SPORT_DURATION_GOAL.ordinal()] = 106;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                iArr[BleKey.SOS_CONTACT.ordinal()] = 107;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                iArr[BleKey.CHECK_IN_EVERY_DAY.ordinal()] = 108;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                iArr[BleKey.GESTURE_WAKE2.ordinal()] = 109;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                iArr[BleKey.EARPHONE_KEY.ordinal()] = 110;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                iArr[BleKey.HANBAO_SET.ordinal()] = 111;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                iArr[BleKey.QIBLA_SET.ordinal()] = 112;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                iArr[BleKey.CALIBRATION_DATA.ordinal()] = 113;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                iArr[BleKey.DEVICE_UNIQUE_DATA_SET.ordinal()] = 114;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                iArr[BleKey.CP_USER_INFO.ordinal()] = 115;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                iArr[BleKey.WATCHFACE_INDEX.ordinal()] = 116;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                iArr[BleKey.ALARM.ordinal()] = 117;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                iArr[BleKey.LOVE_TAP_USER.ordinal()] = 118;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                iArr[BleKey.MEDICATION_REMINDER.ordinal()] = 119;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                iArr[BleKey.MEDICATION_ALARM.ordinal()] = 120;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                iArr[BleKey.COACHING.ordinal()] = 121;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                iArr[BleKey.TUYA_KEY_SET.ordinal()] = 122;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                iArr[BleKey.BATTERY_USAGE.ordinal()] = 123;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                iArr[BleKey.IDENTITY.ordinal()] = 124;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                iArr[BleKey.NOTIFICATION.ordinal()] = 125;
            } catch (NoSuchFieldError unused125) {
            }
            try {
                iArr[BleKey.WEATHER_REALTIME.ordinal()] = 126;
            } catch (NoSuchFieldError unused126) {
            }
            try {
                iArr[BleKey.WEATHER_FORECAST.ordinal()] = 127;
            } catch (NoSuchFieldError unused127) {
            }
            try {
                iArr[BleKey.NOTIFICATION2.ordinal()] = 128;
            } catch (NoSuchFieldError unused128) {
            }
            try {
                iArr[BleKey.NEWS_FEED.ordinal()] = 129;
            } catch (NoSuchFieldError unused129) {
            }
            try {
                iArr[BleKey.WEATHER_REALTIME2.ordinal()] = 130;
            } catch (NoSuchFieldError unused130) {
            }
            try {
                iArr[BleKey.WEATHER_FORECAST2.ordinal()] = 131;
            } catch (NoSuchFieldError unused131) {
            }
            try {
                iArr[BleKey.LOGIN_DAYS.ordinal()] = 132;
            } catch (NoSuchFieldError unused132) {
            }
            try {
                iArr[BleKey.TARGET_COMPLETION.ordinal()] = 133;
            } catch (NoSuchFieldError unused133) {
            }
            try {
                iArr[BleKey.AUDIO_TEXT.ordinal()] = 134;
            } catch (NoSuchFieldError unused134) {
            }
            try {
                iArr[BleKey.WEATHER_REALTIME3.ordinal()] = 135;
            } catch (NoSuchFieldError unused135) {
            }
            try {
                iArr[BleKey.WEATHER_FORECAST3.ordinal()] = 136;
            } catch (NoSuchFieldError unused136) {
            }
            try {
                iArr[BleKey.SCHEDULE.ordinal()] = 137;
            } catch (NoSuchFieldError unused137) {
            }
            try {
                iArr[BleKey.SMS_QUICK_REPLY_CONTENT.ordinal()] = 138;
            } catch (NoSuchFieldError unused138) {
            }
            try {
                iArr[BleKey.HID.ordinal()] = 139;
            } catch (NoSuchFieldError unused139) {
            }
            try {
                iArr[BleKey.WORLD_CLOCK.ordinal()] = 140;
            } catch (NoSuchFieldError unused140) {
            }
            try {
                iArr[BleKey.STOCK.ordinal()] = 141;
            } catch (NoSuchFieldError unused141) {
            }
            try {
                iArr[BleKey.DATA_ALL.ordinal()] = 142;
            } catch (NoSuchFieldError unused142) {
            }
            try {
                iArr[BleKey.ACTIVITY_REALTIME.ordinal()] = 143;
            } catch (NoSuchFieldError unused143) {
            }
            try {
                iArr[BleKey.ACTIVITY.ordinal()] = 144;
            } catch (NoSuchFieldError unused144) {
            }
            try {
                iArr[BleKey.HEART_RATE.ordinal()] = 145;
            } catch (NoSuchFieldError unused145) {
            }
            try {
                iArr[BleKey.BLOOD_PRESSURE.ordinal()] = 146;
            } catch (NoSuchFieldError unused146) {
            }
            try {
                iArr[BleKey.SLEEP.ordinal()] = 147;
            } catch (NoSuchFieldError unused147) {
            }
            try {
                iArr[BleKey.WORKOUT.ordinal()] = 148;
            } catch (NoSuchFieldError unused148) {
            }
            try {
                iArr[BleKey.LOCATION.ordinal()] = 149;
            } catch (NoSuchFieldError unused149) {
            }
            try {
                iArr[BleKey.TEMPERATURE.ordinal()] = 150;
            } catch (NoSuchFieldError unused150) {
            }
            try {
                iArr[BleKey.BLOOD_OXYGEN.ordinal()] = 151;
            } catch (NoSuchFieldError unused151) {
            }
            try {
                iArr[BleKey.HRV.ordinal()] = 152;
            } catch (NoSuchFieldError unused152) {
            }
            try {
                iArr[BleKey.LOG.ordinal()] = 153;
            } catch (NoSuchFieldError unused153) {
            }
            try {
                iArr[BleKey.SLEEP_RAW_DATA.ordinal()] = 154;
            } catch (NoSuchFieldError unused154) {
            }
            try {
                iArr[BleKey.PRESSURE.ordinal()] = 155;
            } catch (NoSuchFieldError unused155) {
            }
            try {
                iArr[BleKey.WORKOUT2.ordinal()] = 156;
            } catch (NoSuchFieldError unused156) {
            }
            try {
                iArr[BleKey.BLOOD_GLUCOSE.ordinal()] = 157;
            } catch (NoSuchFieldError unused157) {
            }
            try {
                iArr[BleKey.BODY_STATUS.ordinal()] = 158;
            } catch (NoSuchFieldError unused158) {
            }
            try {
                iArr[BleKey.MIND_STATUS.ordinal()] = 159;
            } catch (NoSuchFieldError unused159) {
            }
            try {
                iArr[BleKey.CALORIE_INTAKE.ordinal()] = 160;
            } catch (NoSuchFieldError unused160) {
            }
            try {
                iArr[BleKey.FOOD_BALANCE.ordinal()] = 161;
            } catch (NoSuchFieldError unused161) {
            }
            try {
                iArr[BleKey.BAC.ordinal()] = 162;
            } catch (NoSuchFieldError unused162) {
            }
            try {
                iArr[BleKey.MATCH_RECORD2.ordinal()] = 163;
            } catch (NoSuchFieldError unused163) {
            }
            try {
                iArr[BleKey.AVG_HEART_RATE.ordinal()] = 164;
            } catch (NoSuchFieldError unused164) {
            }
            try {
                iArr[BleKey.ALIPAY_BIND_INFO.ordinal()] = 165;
            } catch (NoSuchFieldError unused165) {
            }
            try {
                iArr[BleKey.RRI.ordinal()] = 166;
            } catch (NoSuchFieldError unused166) {
            }
            try {
                iArr[BleKey.ECG.ordinal()] = 167;
            } catch (NoSuchFieldError unused167) {
            }
            try {
                iArr[BleKey.HANBAO_VIBRATION.ordinal()] = 168;
            } catch (NoSuchFieldError unused168) {
            }
            try {
                iArr[BleKey.SOS_CALL_LOG.ordinal()] = 169;
            } catch (NoSuchFieldError unused169) {
            }
            try {
                iArr[BleKey.WORKOUT3.ordinal()] = 170;
            } catch (NoSuchFieldError unused170) {
            }
            try {
                iArr[BleKey.DAILY_POWER.ordinal()] = 171;
            } catch (NoSuchFieldError unused171) {
            }
            try {
                iArr[BleKey.TRAINING_STATUS.ordinal()] = 172;
            } catch (NoSuchFieldError unused172) {
            }
            try {
                iArr[BleKey.VITALITY.ordinal()] = 173;
            } catch (NoSuchFieldError unused173) {
            }
            try {
                iArr[BleKey.HRV2.ordinal()] = 174;
            } catch (NoSuchFieldError unused174) {
            }
            try {
                iArr[BleKey.RESPIRATORY_RATE.ordinal()] = 175;
            } catch (NoSuchFieldError unused175) {
            }
            try {
                iArr[BleKey.CAMERA.ordinal()] = 176;
            } catch (NoSuchFieldError unused176) {
            }
            try {
                iArr[BleKey.REQUEST_LOCATION.ordinal()] = 177;
            } catch (NoSuchFieldError unused177) {
            }
            try {
                iArr[BleKey.DEVICE_SMS_QUICK_REPLY.ordinal()] = 178;
            } catch (NoSuchFieldError unused178) {
            }
            try {
                iArr[BleKey.INCOMING_CALL.ordinal()] = 179;
            } catch (NoSuchFieldError unused179) {
            }
            try {
                iArr[BleKey.APP_SPORT_STATE.ordinal()] = 180;
            } catch (NoSuchFieldError unused180) {
            }
            try {
                iArr[BleKey.LOVE_TAP.ordinal()] = 181;
            } catch (NoSuchFieldError unused181) {
            }
            try {
                iArr[BleKey.FACTORY_TEST.ordinal()] = 182;
            } catch (NoSuchFieldError unused182) {
            }
            try {
                iArr[BleKey.SPORT_END_NOTIFY.ordinal()] = 183;
            } catch (NoSuchFieldError unused183) {
            }
            try {
                iArr[BleKey.HANBAO_VIBRATION_STATE.ordinal()] = 184;
            } catch (NoSuchFieldError unused184) {
            }
            try {
                iArr[BleKey.MEASUREMENT.ordinal()] = 185;
            } catch (NoSuchFieldError unused185) {
            }
            try {
                iArr[BleKey.GAME_CONTROL.ordinal()] = 186;
            } catch (NoSuchFieldError unused186) {
            }
            try {
                iArr[BleKey.DEVICE_OP.ordinal()] = 187;
            } catch (NoSuchFieldError unused187) {
            }
            try {
                iArr[BleKey.RECEIVE_DEVICE_FILE.ordinal()] = 188;
            } catch (NoSuchFieldError unused188) {
            }
            try {
                iArr[BleKey.AI_COMMAND.ordinal()] = 189;
            } catch (NoSuchFieldError unused189) {
            }
            try {
                iArr[BleKey.SG_RGB_SET.ordinal()] = 190;
            } catch (NoSuchFieldError unused190) {
            }
            try {
                iArr[BleKey.SG_SLEEP_SET.ordinal()] = 191;
            } catch (NoSuchFieldError unused191) {
            }
            try {
                iArr[BleKey.SG_EQ_SET.ordinal()] = 192;
            } catch (NoSuchFieldError unused192) {
            }
            try {
                iArr[BleKey.SG_KEY_SET.ordinal()] = 193;
            } catch (NoSuchFieldError unused193) {
            }
            try {
                iArr[BleKey.SG_KEYWORD_AWAKE.ordinal()] = 194;
            } catch (NoSuchFieldError unused194) {
            }
            try {
                iArr[BleKey.CLASSIC_BLUETOOTH_STATE.ordinal()] = 195;
            } catch (NoSuchFieldError unused195) {
            }
            try {
                iArr[BleKey.APP_OP.ordinal()] = 196;
            } catch (NoSuchFieldError unused196) {
            }
            try {
                iArr[BleKey.IPC_WIFI_STATE.ordinal()] = 197;
            } catch (NoSuchFieldError unused197) {
            }
            try {
                iArr[BleKey.AI_COACH_PLAN.ordinal()] = 198;
            } catch (NoSuchFieldError unused198) {
            }
            try {
                iArr[BleKey.FILE_PATH.ordinal()] = 199;
            } catch (NoSuchFieldError unused199) {
            }
            try {
                iArr[BleKey.APP_API_VERSION.ordinal()] = 200;
            } catch (NoSuchFieldError unused200) {
            }
            try {
                iArr[BleKey.IPC_WIFI_INFO.ordinal()] = 201;
            } catch (NoSuchFieldError unused201) {
            }
            try {
                iArr[BleKey.WATCH_FACE.ordinal()] = 202;
            } catch (NoSuchFieldError unused202) {
            }
            try {
                iArr[BleKey.AGPS_FILE.ordinal()] = 203;
            } catch (NoSuchFieldError unused203) {
            }
            try {
                iArr[BleKey.FONT_FILE.ordinal()] = 204;
            } catch (NoSuchFieldError unused204) {
            }
            try {
                iArr[BleKey.CONTACT.ordinal()] = 205;
            } catch (NoSuchFieldError unused205) {
            }
            try {
                iArr[BleKey.UI_FILE.ordinal()] = 206;
            } catch (NoSuchFieldError unused206) {
            }
            try {
                iArr[BleKey.LANGUAGE_FILE.ordinal()] = 207;
            } catch (NoSuchFieldError unused207) {
            }
            try {
                iArr[BleKey.BRAND_INFO_FILE.ordinal()] = 208;
            } catch (NoSuchFieldError unused208) {
            }
            try {
                iArr[BleKey.QRCODE.ordinal()] = 209;
            } catch (NoSuchFieldError unused209) {
            }
            try {
                iArr[BleKey.THIRD_PARTY_DATA.ordinal()] = 210;
            } catch (NoSuchFieldError unused210) {
            }
            try {
                iArr[BleKey.QRCODE2.ordinal()] = 211;
            } catch (NoSuchFieldError unused211) {
            }
            try {
                iArr[BleKey.LOGO_FILE.ordinal()] = 212;
            } catch (NoSuchFieldError unused212) {
            }
            try {
                iArr[BleKey.OTA_FILE.ordinal()] = 213;
            } catch (NoSuchFieldError unused213) {
            }
            try {
                iArr[BleKey.GPS_FIRMWARE_FILE.ordinal()] = 214;
            } catch (NoSuchFieldError unused214) {
            }
            try {
                iArr[BleKey.CONTACT_SORT.ordinal()] = 215;
            } catch (NoSuchFieldError unused215) {
            }
            try {
                iArr[BleKey.NAVI_IMAGE.ordinal()] = 216;
            } catch (NoSuchFieldError unused216) {
            }
            try {
                iArr[BleKey.APP_FILE.ordinal()] = 217;
            } catch (NoSuchFieldError unused217) {
            }
            try {
                iArr[BleKey.FAT_BIN_FILE.ordinal()] = 218;
            } catch (NoSuchFieldError unused218) {
            }
            try {
                iArr[BleKey.AGPS_FILE2.ordinal()] = 219;
            } catch (NoSuchFieldError unused219) {
            }
            f26446oIX0oI = iArr;
        }
    }

    @XX({"SMAP\nBleCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCommand.kt\ncom/szabh/smable3/BleKey$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleKey oIX0oI(int i) {
            BleKey bleKey;
            BleKey[] values = BleKey.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleKey = values[i2];
                    if (bleKey.getMKey() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleKey = null;
                    break;
                }
            }
            if (bleKey == null) {
                return BleKey.NONE;
            }
            return bleKey;
        }

        public oIX0oI() {
        }
    }

    private static final /* synthetic */ BleKey[] $values() {
        return new BleKey[]{OTA, XMODEM, TIME, TIME_ZONE, POWER, FIRMWARE_VERSION, BLE_ADDRESS, USER_PROFILE, STEP_GOAL, BACK_LIGHT, SEDENTARINESS, NO_DISTURB_RANGE, VIBRATION, GESTURE_WAKE, HR_ASSIST_SLEEP, HOUR_SYSTEM, LANGUAGE, ALARM, UNIT_SET, COACHING, FIND_PHONE, NOTIFICATION_REMINDER, ANTI_LOST, HR_MONITORING, UI_PACK_VERSION, LANGUAGE_PACK_VERSION, SLEEP_QUALITY, GIRL_CARE, TEMPERATURE_DETECTING, AEROBIC_EXERCISE, TEMPERATURE_UNIT, DATE_FORMAT, WATCH_FACE_SWITCH, AGPS_PREREQUISITE, DRINK_WATER, SHUTDOWN, APP_SPORT_DATA, REAL_TIME_HEART_RATE, BLOOD_OXYGEN_SET, WASH_SET, WATCHFACE_ID, IBEACON_SET, MAC_QRCODE, REAL_TIME_TEMPERATURE, REAL_TIME_BLOOD_PRESSURE, TEMPERATURE_VALUE, GAME_SET, FIND_WATCH, SET_WATCH_PASSWORD, REALTIME_MEASUREMENT, POWER_SAVE_MODE, BAC_SET, CALORIES_GOAL, DISTANCE_GOAL, SLEEP_GOAL, LOVE_TAP_USER, MEDICATION_REMINDER, DEVICE_INFO, HR_WARNING_SET, SLEEP_MONITORING, STANDBY_SET, BT_NAME, TUYA_KEY_SET, BAC_RESULT, BAC_RESULT_SET, MEDICATION_ALARM, MATCH_SET, PACKAGE_STATUS, NOTIFICATION_REMINDER2, ALIPAY_SET, RECORD_PACKET, BLE_ADDRESS_SET, NAVI_INFO, SOS_SET, DEVICE_LANGUAGES, GAME_TIME_REMINDER, DEVICE_SPORT_DATA, PRESSURE_TIMING_MEASUREMENT, STANDBY_WATCH_FACE_SET, FALL_SET, BW_NAVI_INFO, CONNECT_REMINDER, SDCARD_INFO, ACTIVITY_DETAIL, NOTIFICATION_LIGHT_SCREEN_SET, BLOOD_PRESSURE_CALIBRATION, AIR_PRESSURE_CALIBRATION, EARPHONE_POWER, EARPHONE_ANC_SET, EARPHONE_SOUND_EFFECTS_SET, SCREEN_BRIGHTNESS_SET, EARPHONE_INFO, EARPHONE_STATE, EARPHONE_CALL, GPS_FIRMWARE_VERSION, GOMORE_SET, RING_VIBRATION_SET, NETWORK_FIRMWARE_VERSION, ECG_SET, SPORT_DURATION_GOAL, WATCHFACE_INDEX, SOS_CONTACT, GIRL_CARE_MONTHLY, GIRL_CARE_MENSTRUATION_UPDATE, HEALTH_INDEX, CHECK_IN_EVERY_DAY, WEAR_WAY, GESTURE_WAKE2, EARPHONE_KEY, FIND_EARPHONE, HANBAO_SET, QIBLA_SET, CALIBRATION_DATA, BATTERY_USAGE, TOUCH_SET, DEVICE_UNIQUE_DATA_SET, IPC_VERSION, IPC_STORES_INFO, SLEEP_QUALITY_SCORE, RELAX_REMINDER, CP_USER_INFO, TEST_INFO_SET, POWER2, PPG_SHSY, GSENSOR_SHSY, LOCATION_GSV, HR_RAW, REALTIME_LOG, GSENSOR_OUTPUT, GSENSOR_RAW, MOTION_DETECT, LOCATION_GGA, RAW_SLEEP, NO_DISTURB_GLOBAL, IDENTITY, SESSION, NOTIFICATION, MUSIC_CONTROL, SCHEDULE, WEATHER_REALTIME, WEATHER_FORECAST, HID, WORLD_CLOCK, STOCK, SMS_QUICK_REPLY_CONTENT, NOTIFICATION2, NEWS_FEED, WEATHER_REALTIME2, WEATHER_FORECAST2, LOGIN_DAYS, TARGET_COMPLETION, AUDIO_TEXT, WEATHER_REALTIME3, WEATHER_FORECAST3, DATA_ALL, ACTIVITY_REALTIME, ACTIVITY, HEART_RATE, BLOOD_PRESSURE, SLEEP, WORKOUT, LOCATION, TEMPERATURE, BLOOD_OXYGEN, HRV, LOG, SLEEP_RAW_DATA, PRESSURE, WORKOUT2, MATCH_RECORD, BLOOD_GLUCOSE, BODY_STATUS, MIND_STATUS, CALORIE_INTAKE, FOOD_BALANCE, BAC, MATCH_RECORD2, AVG_HEART_RATE, ALIPAY_BIND_INFO, RRI, ECG, HANBAO_VIBRATION, SOS_CALL_LOG, WORKOUT3, DAILY_POWER, TRAINING_STATUS, VITALITY, HRV2, RESPIRATORY_RATE, CAMERA, REQUEST_LOCATION, INCOMING_CALL, APP_SPORT_STATE, CLASSIC_BLUETOOTH_STATE, DEVICE_SMS_QUICK_REPLY, LOVE_TAP, FACTORY_TEST, DOUBLE_SCREEN, BAC_CALIBRATION, INCOMING_CALL_RING, SPORT_END_NOTIFY, FILE_PATH, APP_OP, HANBAO_VIBRATION_STATE, MEASUREMENT, GAME_CONTROL, APP_API_VERSION, DEVICE_OP, RECEIVE_DEVICE_FILE, AI_COMMAND, SG_RGB_SET, SG_SLEEP_SET, SG_EQ_SET, SG_KEY_SET, SG_CAMERA_SET, IPC_WIFI_STATE, SG_KEYWORD_AWAKE, IPC_WIFI_INFO, AI_COACH_PLAN, WEAR_STATE, SG_TEST, LACTATE_THRESHOLD, WATCH_FACE, AGPS_FILE, FONT_FILE, CONTACT, UI_FILE, DEVICE_FILE, LANGUAGE_FILE, BRAND_INFO_FILE, QRCODE, THIRD_PARTY_DATA, QRCODE2, LOGO_FILE, OTA_FILE, GPS_FIRMWARE_FILE, CONTACT_SORT, NAVI_IMAGE, APP_FILE, FAT_BIN_FILE, AGPS_FILE2, NONE};
    }

    static {
        BleKey[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new oIX0oI(null);
    }

    private BleKey(String str, int i, int i2) {
        this.mKey = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<BleKey> getEntries() {
        return $ENTRIES;
    }

    public static BleKey valueOf(String str) {
        return (BleKey) Enum.valueOf(BleKey.class, str);
    }

    public static BleKey[] values() {
        return (BleKey[]) $VALUES.clone();
    }

    @OOXIXo
    public final List<BleKeyFlag> getBleKeyFlags() {
        switch (II0xO0.f26446oIX0oI[ordinal()]) {
            case 1:
            case 2:
                return oI0IIXIo.OOXIXo(BleKeyFlag.UPDATE);
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                return oI0IIXIo.OOXIXo(BleKeyFlag.READ);
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                return oI0IIXIo.OOXIXo(BleKeyFlag.UPDATE);
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.UPDATE, BleKeyFlag.READ);
            case 116:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.UPDATE, BleKeyFlag.READ);
            case 117:
            case 118:
            case 119:
            case 120:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.DELETE, BleKeyFlag.UPDATE, BleKeyFlag.READ, BleKeyFlag.RESET);
            case 121:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.UPDATE, BleKeyFlag.READ);
            case 122:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.UPDATE, BleKeyFlag.READ, BleKeyFlag.DELETE);
            case 123:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.READ, BleKeyFlag.DELETE);
            case 124:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.READ, BleKeyFlag.DELETE, BleKeyFlag.UPDATE);
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
                return oI0IIXIo.OOXIXo(BleKeyFlag.UPDATE);
            case 137:
            case 138:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.DELETE, BleKeyFlag.UPDATE);
            case 139:
                return oI0IIXIo.OOXIXo(BleKeyFlag.READ);
            case 140:
            case 141:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.DELETE, BleKeyFlag.UPDATE, BleKeyFlag.READ, BleKeyFlag.RESET);
            case 142:
            case 143:
                return oI0IIXIo.OOXIXo(BleKeyFlag.READ);
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case EMachine.EM_MANIK /* 171 */:
            case 172:
            case 173:
            case 174:
            case EMachine.EM_MCST_ELBRUS /* 175 */:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.READ, BleKeyFlag.DELETE);
            case 176:
                return oI0IIXIo.OOXIXo(BleKeyFlag.UPDATE);
            case 177:
            case 178:
                return oI0IIXIo.OOXIXo(BleKeyFlag.CREATE);
            case EMachine.EM_SLE9X /* 179 */:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
            case 190:
            case EMachine.EM_TILEGX /* 191 */:
            case 192:
            case 193:
            case 194:
                return oI0IIXIo.OOXIXo(BleKeyFlag.UPDATE);
            case 195:
            case 196:
            case 197:
            case 198:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.UPDATE, BleKeyFlag.READ);
            case 199:
                return CollectionsKt__CollectionsKt.X00IoxXI(BleKeyFlag.CREATE, BleKeyFlag.DELETE, BleKeyFlag.UPDATE, BleKeyFlag.READ);
            case 200:
            case 201:
                return oI0IIXIo.OOXIXo(BleKeyFlag.READ);
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case Command.CMD_GET_EXTERNAL_FLASH_MSG /* 214 */:
            case 215:
            case 216:
            case Command.CMD_GET_DEVICE_CONFIG_INFO /* 217 */:
            case HeightPicker.f25534xoXoI /* 218 */:
            case 219:
                return oI0IIXIo.OOXIXo(BleKeyFlag.UPDATE);
            default:
                return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    @OOXIXo
    public final BleCommand getMBleCommand() {
        BleCommand bleCommand;
        BleCommand[] values = BleCommand.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i < length) {
                bleCommand = values[i];
                if (bleCommand.getMBleCommand() == (this.mKey >>> 8)) {
                    break;
                }
                i++;
            } else {
                bleCommand = null;
                break;
            }
        }
        if (bleCommand == null) {
            return BleCommand.NONE;
        }
        return bleCommand;
    }

    public final byte getMCommandRawValue() {
        return (byte) (this.mKey >> 8);
    }

    public final int getMKey() {
        return this.mKey;
    }

    public final byte getMKeyRawValue() {
        return (byte) this.mKey;
    }

    public final boolean isIdObjectKey() {
        if (this != ALARM && this != SCHEDULE && this != COACHING && this != WORLD_CLOCK && this != STOCK && this != SMS_QUICK_REPLY_CONTENT && this != LOVE_TAP_USER && this != MEDICATION_REMINDER && this != MEDICATION_ALARM) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Enum
    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%04X_", Arrays.copyOf(new Object[]{Integer.valueOf(this.mKey)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(name());
        return sb.toString();
    }
}
