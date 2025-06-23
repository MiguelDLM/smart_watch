package com.szabh.smable3.component;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.bluetooth.BluetoothAdapter;
import android.util.SparseArray;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.szabh.smable3.BleCommand;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.BleKeyFlag;
import com.szabh.smable3.entity.BleAlarm;
import com.szabh.smable3.entity.BleCoaching;
import com.szabh.smable3.entity.BleDeviceInfo;
import com.szabh.smable3.entity.BleIdObject;
import com.szabh.smable3.entity.BleLoveTapUser;
import com.szabh.smable3.entity.BleMedicationAlarm;
import com.szabh.smable3.entity.BleMedicationReminder;
import com.szabh.smable3.entity.BleSMSQuickReplyContent;
import com.szabh.smable3.entity.BleSchedule;
import com.szabh.smable3.entity.BleStock;
import com.szabh.smable3.entity.BleStreamPacket;
import com.szabh.smable3.entity.BleWorldClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.text.OxI;
import kotlin.text.StringsKt___StringsKt;

@XX({"SMAP\nBleCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCache.kt\ncom/szabh/smable3/component/BleCache\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,632:1\n1855#2,2:633\n*S KotlinDebug\n*F\n+ 1 BleCache.kt\ncom/szabh/smable3/component/BleCache\n*L\n528#1:633,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleCache {

    @OOXIXo
    private static final String MTK_OTA_META = "mtk_ota_meta";

    @OOXIXo
    private static final String TAG = "BleCache";

    @OOXIXo
    private static final SparseArray<String> mAGpsFileUrls;

    @oOoXoXO
    private static BleDeviceInfo mDeviceInfo;

    @OOXIXo
    public static final BleCache INSTANCE = new BleCache();

    @OOXIXo
    private static final X0IIOO mSpUtils$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<SPUtils>() { // from class: com.szabh.smable3.component.BleCache$mSpUtils$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final SPUtils invoke() {
            return SPUtils.getInstance("sma_ble_sdk3");
        }
    });

    /* loaded from: classes13.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BleCommand.values().length];
            try {
                iArr[BleCommand.SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleCommand.PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleCommand.CONTROL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BleKey.values().length];
            try {
                iArr2[BleKey.ALARM.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BleKey.SCHEDULE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BleKey.COACHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BleKey.WORLD_CLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BleKey.STOCK.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BleKey.SMS_QUICK_REPLY_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[BleKey.LOVE_TAP_USER.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[BleKey.MEDICATION_REMINDER.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[BleKey.MEDICATION_ALARM.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.append(1, "http://wepodownload.mediatek.com/EPO_GR_3_1.DAT");
        sparseArray.append(2, "https://alp.u-blox.com/current_1d.alp");
        sparseArray.append(6, "https://api.smawatch.cn/epo/ble_epo_offline.bin");
        sparseArray.append(7, "https://sma-product.oss-accelerate.aliyuncs.com/a-gps/file_info_3335_epo.DAT");
        sparseArray.append(8, "https://sma-product.oss-accelerate.aliyuncs.com/a-gps/file_info_7dv5_lto.brm");
        sparseArray.append(9, "https://api-oss.iot-solution.net/a-gps/f1e1G7C7J7.pgl");
        mAGpsFileUrls = sparseArray;
    }

    private BleCache() {
    }

    public static /* synthetic */ boolean getBoolean$default(BleCache bleCache, BleKey bleKey, boolean z, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getBoolean(bleKey, z, bleKeyFlag);
    }

    public static /* synthetic */ int getInt$default(BleCache bleCache, BleKey bleKey, int i, BleKeyFlag bleKeyFlag, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getInt(bleKey, i, bleKeyFlag);
    }

    private final String getKey(BleKey bleKey, BleKeyFlag bleKeyFlag) {
        if (bleKeyFlag == null) {
            return String.valueOf(bleKey);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bleKey);
        sb.append('_');
        sb.append(bleKeyFlag);
        return sb.toString();
    }

    public static /* synthetic */ List getList$default(BleCache bleCache, BleKey bleKey, Class cls, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getList(bleKey, cls, bleKeyFlag);
    }

    public static /* synthetic */ long getLong$default(BleCache bleCache, BleKey bleKey, long j, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getLong(bleKey, j, bleKeyFlag);
    }

    private final SPUtils getMSpUtils() {
        Object value = mSpUtils$delegate.getValue();
        IIX0o.oO(value, "getValue(...)");
        return (SPUtils) value;
    }

    public static /* synthetic */ Object getObject$default(BleCache bleCache, BleKey bleKey, Class cls, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getObject(bleKey, cls, bleKeyFlag);
    }

    public static /* synthetic */ Object getObjectNotNull$default(BleCache bleCache, BleKey bleKey, Class cls, Object obj, BleKeyFlag bleKeyFlag, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        if ((i & 8) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getObjectNotNull(bleKey, cls, obj, bleKeyFlag);
    }

    public static /* synthetic */ String getString$default(BleCache bleCache, BleKey bleKey, String str, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        return bleCache.getString(bleKey, str, bleKeyFlag);
    }

    public static /* synthetic */ void putBoolean$default(BleCache bleCache, BleKey bleKey, boolean z, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        bleCache.putBoolean(bleKey, z, bleKeyFlag);
    }

    public static /* synthetic */ void putInt$default(BleCache bleCache, BleKey bleKey, int i, BleKeyFlag bleKeyFlag, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bleKeyFlag = null;
        }
        bleCache.putInt(bleKey, i, bleKeyFlag);
    }

    public static /* synthetic */ void putList$default(BleCache bleCache, BleKey bleKey, List list, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        bleCache.putList(bleKey, list, bleKeyFlag);
    }

    public static /* synthetic */ void putLong$default(BleCache bleCache, BleKey bleKey, long j, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        bleCache.putLong(bleKey, j, bleKeyFlag);
    }

    public static /* synthetic */ void putObject$default(BleCache bleCache, BleKey bleKey, Object obj, BleKeyFlag bleKeyFlag, int i, Object obj2) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        bleCache.putObject(bleKey, obj, bleKeyFlag);
    }

    public static /* synthetic */ void putString$default(BleCache bleCache, BleKey bleKey, String str, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 4) != 0) {
            bleKeyFlag = null;
        }
        bleCache.putString(bleKey, str, bleKeyFlag);
    }

    public static /* synthetic */ void remove$default(BleCache bleCache, BleKey bleKey, BleKeyFlag bleKeyFlag, int i, Object obj) {
        if ((i & 2) != 0) {
            bleKeyFlag = null;
        }
        bleCache.remove(bleKey, bleKeyFlag);
    }

    public final void clear() {
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache clear");
        getMSpUtils().clear();
    }

    public final boolean getBoolean(@OOXIXo BleKey bleKey, boolean z, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        boolean z2 = getMSpUtils().getBoolean(getKey(bleKey, bleKeyFlag), z);
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getBoolean " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + z2);
        return z2;
    }

    @OOXIXo
    public final List<BleIdObject> getIdObjects(@OOXIXo BleKey bleKey) {
        List list$default;
        IIX0o.x0xO0oo(bleKey, "bleKey");
        switch (WhenMappings.$EnumSwitchMapping$1[bleKey.ordinal()]) {
            case 1:
                list$default = getList$default(this, bleKey, BleAlarm.class, null, 4, null);
                break;
            case 2:
                list$default = getList$default(this, bleKey, BleSchedule.class, null, 4, null);
                break;
            case 3:
                list$default = getList$default(this, bleKey, BleCoaching.class, null, 4, null);
                break;
            case 4:
                list$default = getList$default(this, bleKey, BleWorldClock.class, null, 4, null);
                break;
            case 5:
                list$default = getList$default(this, bleKey, BleStock.class, null, 4, null);
                break;
            case 6:
                list$default = getList$default(this, bleKey, BleSMSQuickReplyContent.class, null, 4, null);
                break;
            case 7:
                list$default = getList$default(this, bleKey, BleLoveTapUser.class, null, 4, null);
                break;
            case 8:
                list$default = getList$default(this, bleKey, BleMedicationReminder.class, null, 4, null);
                break;
            case 9:
                list$default = getList$default(this, bleKey, BleMedicationAlarm.class, null, 4, null);
                break;
            default:
                list$default = CollectionsKt__CollectionsKt.ooXIXxIX();
                break;
        }
        return CollectionsKt___CollectionsKt.o0Xo0XII(list$default);
    }

    public final int getInt(@OOXIXo BleKey bleKey, int i, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        int i2 = getMSpUtils().getInt(getKey(bleKey, bleKeyFlag), i);
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getInt " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + i2);
        return i2;
    }

    @OOXIXo
    public final <T> List<T> getList(@OOXIXo BleKey bleKey, @OOXIXo Class<T> clazz, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(clazz, "clazz");
        ArrayList arrayList = new ArrayList();
        BleCache bleCache = INSTANCE;
        String string = bleCache.getMSpUtils().getString(bleCache.getKey(bleKey, bleKeyFlag));
        IIX0o.oO(string, "getString(...)");
        if (!OxI.X0O0I0(string)) {
            try {
                JsonArray asJsonArray = JsonParser.parseString(bleCache.getMSpUtils().getString(bleCache.getKey(bleKey, bleKeyFlag))).getAsJsonArray();
                if (asJsonArray != null) {
                    IIX0o.ooOOo0oXI(asJsonArray);
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Gson().fromJson(it.next(), (Class) clazz));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getList " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + arrayList);
        return arrayList;
    }

    public final long getLong(@OOXIXo BleKey bleKey, long j, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        long j2 = getMSpUtils().getLong(getKey(bleKey, bleKeyFlag), j);
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getLong " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + j2);
        return j2;
    }

    @OOXIXo
    public final String getMAGpsFileUrl() {
        String str = mAGpsFileUrls.get(getMAGpsType());
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int getMAGpsType() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMAGpsType();
        }
        return 0;
    }

    @OOXIXo
    public final String getMBleAddress() {
        String mBleAddress;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mBleAddress = bleDeviceInfo.getMBleAddress()) == null) {
            return "";
        }
        return mBleAddress;
    }

    @OOXIXo
    public final String getMBleCustomName() {
        String mBleCustomName;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mBleCustomName = bleDeviceInfo.getMBleCustomName()) == null) {
            return "";
        }
        return mBleCustomName;
    }

    @OOXIXo
    public final String getMBleName() {
        String mBleName;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mBleName = bleDeviceInfo.getMBleName()) == null) {
            return "";
        }
        return mBleName;
    }

    @OOXIXo
    public final String getMClassicAddress() {
        String mClassicAddress;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mClassicAddress = bleDeviceInfo.getMClassicAddress()) == null) {
            return "";
        }
        return mClassicAddress;
    }

    @OOXIXo
    public final List<Integer> getMDataKeys() {
        List<Integer> mDataKeys;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mDataKeys = bleDeviceInfo.getMDataKeys()) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return mDataKeys;
    }

    @oOoXoXO
    public final BleDeviceInfo getMDeviceInfo() {
        return mDeviceInfo;
    }

    @OOXIXo
    public final String getMDfuAddress() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null && BluetoothAdapter.checkBluetoothAddress(bleDeviceInfo.getMBleAddress())) {
            if (!IIX0o.Oxx0IOOO(bleDeviceInfo.getMPlatform(), BleDeviceInfo.PLATFORM_JL) && !IIX0o.Oxx0IOOO(bleDeviceInfo.getMPlatform(), BleDeviceInfo.PLATFORM_JL707) && !IIX0o.Oxx0IOOO(bleDeviceInfo.getMPlatform(), BleDeviceInfo.PLATFORM_JL707LITE) && !IIX0o.Oxx0IOOO(bleDeviceInfo.getMPlatform(), BleDeviceInfo.PLATFORM_NORDIC) && (!IIX0o.Oxx0IOOO(bleDeviceInfo.getMPlatform(), BleDeviceInfo.PLATFORM_GOODIX) || !IIX0o.Oxx0IOOO(bleDeviceInfo.getMPrototype(), BleDeviceInfo.PROTOTYPE_R3Q))) {
                return bleDeviceInfo.getMBleAddress();
            }
            long parseLong = Long.parseLong(OxI.IIOIX(bleDeviceInfo.getMBleAddress(), ":", "", false, 4, null), kotlin.text.II0xO0.oIX0oI(16)) + 1;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%012X", Arrays.copyOf(new Object[]{Long.valueOf(parseLong)}, 1));
            IIX0o.oO(format, "format(...)");
            return CollectionsKt___CollectionsKt.OoIXo(StringsKt___StringsKt.X0OXI(format, 2), ":", null, null, 0, null, null, 62, null);
        }
        return "";
    }

    @OOXIXo
    public final String getMFirmwareFlag() {
        String mFirmwareFlag;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mFirmwareFlag = bleDeviceInfo.getMFirmwareFlag()) == null) {
            return "";
        }
        return mFirmwareFlag;
    }

    public final int getMHideDigitalPower() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMHideDigitalPower();
        }
        return 0;
    }

    public final long getMIOBufferSize() {
        Long l;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            l = Long.valueOf(bleDeviceInfo.getMIOBufferSize());
        } else {
            l = null;
        }
        if (l == null || l.longValue() == 0) {
            l = Long.valueOf(BleStreamPacket.Companion.getBUFFER_MAX_SIZE());
        }
        return l.longValue();
    }

    @OOXIXo
    public final String getMPlatform() {
        String mPlatform;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mPlatform = bleDeviceInfo.getMPlatform()) == null) {
            return "";
        }
        return mPlatform;
    }

    @OOXIXo
    public final String getMPrototype() {
        String mPrototype;
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo == null || (mPrototype = bleDeviceInfo.getMPrototype()) == null) {
            return "";
        }
        return mPrototype;
    }

    public final int getMQrcodeContentSize() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMQrcodeContentSize();
        }
        return 0;
    }

    public final int getMQrcodeSize() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMQrcodeSize();
        }
        return 0;
    }

    public final int getMShowAntiLostSwitch() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMShowAntiLostSwitch();
        }
        return 0;
    }

    public final int getMSleepAlgorithmType() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSleepAlgorithmType();
        }
        return 0;
    }

    public final int getMSupport2DAcceleration() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupport2DAcceleration();
        }
        return 0;
    }

    public final int getMSupportAICoach() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportAICoach();
        }
        return 0;
    }

    public final int getMSupportAITranslation() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportAITranslation();
        }
        return 0;
    }

    public final int getMSupportAlipay() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportAlipay();
        }
        return 0;
    }

    public final int getMSupportAppSport() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportAppSport();
        }
        return 0;
    }

    public final int getMSupportAppStore() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportAppStore();
        }
        return 0;
    }

    public final int getMSupportAudioBooks() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportAudioBooks();
        }
        return 0;
    }

    public final int getMSupportBloodOxyGenSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportBloodOxyGenSet();
        }
        return 0;
    }

    public final int getMSupportBloodPressureCalibration() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportBloodPressureCalibration();
        }
        return 0;
    }

    public final int getMSupportChangeClassicBluetoothState() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportChangeClassicBluetoothState();
        }
        return 0;
    }

    public final int getMSupportConnectReminder() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportConnectReminder();
        }
        return 0;
    }

    public final int getMSupportContactSize() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportContactSize();
        }
        return 0;
    }

    public final int getMSupportContactSort() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportContactSort();
        }
        return 0;
    }

    public final int getMSupportCrossAppTranslation() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportCrossAppTranslation();
        }
        return 0;
    }

    public final int getMSupportCustomLogo() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportCustomLogo();
        }
        return 0;
    }

    public final int getMSupportDateFormatSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportDateFormatSet();
        }
        return 0;
    }

    public final int getMSupportDeviceSportData() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportDeviceSportData();
        }
        return 0;
    }

    public final int getMSupportDoubleScreen() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportDoubleScreen();
        }
        return 0;
    }

    public final int getMSupportDrinkWaterSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportDrinkWaterSet();
        }
        return 0;
    }

    public final int getMSupportEbookTransfer() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportEbookTransfer();
        }
        return 0;
    }

    public final int getMSupportFallSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportFallSet();
        }
        return 0;
    }

    public final int getMSupportFindWatch() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportFindWatch();
        }
        return 0;
    }

    public final int getMSupportGPSFirmwareFile() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGPSFirmwareFile();
        }
        return 0;
    }

    public final int getMSupportGameControl() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGameControls();
        }
        return 0;
    }

    public final int getMSupportGameTimeReminder() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGameTimeReminder();
        }
        return 0;
    }

    public final int getMSupportGestureWake2() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGestureWake2();
        }
        return 0;
    }

    public final int getMSupportGirlCareMonthly() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGirlCareMonthly();
        }
        return 0;
    }

    public final int getMSupportGirlCareReminder() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGirlCareReminder();
        }
        return 0;
    }

    public final int getMSupportGoMoreSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportGoMoreSet();
        }
        return 0;
    }

    public final int getMSupportHID() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportHID();
        }
        return 0;
    }

    public final int getMSupportHrWarnSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportHrWarnSet();
        }
        return 0;
    }

    public final int getMSupportIBeaconSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportIBeaconSet();
        }
        return 0;
    }

    public final int getMSupportIncomingCallRing() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportIncomingCallRing();
        }
        return 0;
    }

    public final int getMSupportJLTransport() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportJLTransport();
        }
        return 0;
    }

    public final int getMSupportLoveTap() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportLoveTap();
        }
        return 0;
    }

    public final int getMSupportMeasurementBloodGlucose() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportMeasurementBloodGlucose();
        }
        return 0;
    }

    public final int getMSupportMedicationAlarm() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportMedicationAlarm();
        }
        return 0;
    }

    public final int getMSupportMedicationReminder() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportMedicationReminder();
        }
        return 0;
    }

    public final int getMSupportMusicTransfer() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportMusicTransfer();
        }
        return 0;
    }

    public final int getMSupportMyCardCodeSize() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportMyCardCodeSize();
        }
        return 0;
    }

    public final int getMSupportNavImage() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNavImage();
        }
        return 0;
    }

    public final int getMSupportNavigation() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNavigation();
        }
        return 0;
    }

    public final int getMSupportNetwork() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNetwork();
        }
        return 0;
    }

    public final int getMSupportNewsfeed() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNewsfeed();
        }
        return 0;
    }

    public final int getMSupportNoDisturbSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNoDisturbSet();
        }
        return 0;
    }

    public final int getMSupportNoDisturbSet2() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNoDisturbSet2();
        }
        return 0;
    }

    public final int getMSupportNotificationLightScreenSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportNotificationLightScreenSet();
        }
        return 0;
    }

    public final int getMSupportOTAFile() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportOTAFile();
        }
        return 0;
    }

    public final int getMSupportPower2() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportPower2();
        }
        return 0;
    }

    public final int getMSupportPowerSaveMode() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportPowerSaveMode();
        }
        return 0;
    }

    public final int getMSupportPressureTimingMeasurement() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportPressureTimingMeasurement();
        }
        return 0;
    }

    public final int getMSupportQiblaSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportQiblaSet();
        }
        return 0;
    }

    public final int getMSupportQrcode() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportQrcode();
        }
        return 0;
    }

    public final int getMSupportQuran() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportQuran();
        }
        return 0;
    }

    public final int getMSupportReadDeviceInfo() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportReadDeviceInfo();
        }
        return 0;
    }

    public final int getMSupportReadLanguages() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportReadLanguages();
        }
        return 0;
    }

    public final int getMSupportReadPackageStatus() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportReadPackageStatus();
        }
        return 0;
    }

    public final int getMSupportRealTimeMeasurement() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportRealTimeMeasurement();
        }
        return 0;
    }

    public final int getMSupportReceiptCodeSize() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportReceiptCodeSize();
        }
        return 0;
    }

    public final int getMSupportRecordNote() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportRecordNote();
        }
        return 0;
    }

    public final int getMSupportRelaxReminder() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportRelaxReminder();
        }
        return 0;
    }

    public final int getMSupportRequestRealtimeWeather() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportRequestRealtimeWeather();
        }
        return 0;
    }

    public final int getMSupportRestoreFactory() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportRestoreFactory();
        }
        return 0;
    }

    public final int getMSupportRingVibrationSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportRingVibrationSet();
        }
        return 0;
    }

    public final int getMSupportSDCardInfo() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSDCardInfo();
        }
        return 0;
    }

    public final int getMSupportSHSYAlgorithm() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSHSYAlgorithm();
        }
        return 0;
    }

    public final int getMSupportSMSQuickReply() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSMSQuickReply();
        }
        return 0;
    }

    public final int getMSupportSOSSet2() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSOSSet2();
        }
        return 0;
    }

    public final int getMSupportSetWatchPassword() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSetWatchPassword();
        }
        return 0;
    }

    public final int getMSupportSimultaneousTranslation() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSimultaneousTranslation();
        }
        return 0;
    }

    public final int getMSupportSleepScore() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSleepScore();
        }
        return 0;
    }

    public final int getMSupportSosContact() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSosContact();
        }
        return 0;
    }

    public final int getMSupportStandbySet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportStandbySet();
        }
        return 0;
    }

    public final int getMSupportStock() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportStock();
        }
        return 0;
    }

    public final int getMSupportStringQrcode() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportStringQrcode();
        }
        return 0;
    }

    public final int getMSupportStudyCards() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportStudyCards();
        }
        return 0;
    }

    public final int getMSupportSyncAGPSInBackground() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportSyncAGPSInBackground();
        }
        return 0;
    }

    public final int getMSupportTemperatureUnitSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportTemperatureUnitSet();
        }
        return 0;
    }

    public final int getMSupportTimerStandbySet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportTimerStandbySet();
        }
        return 0;
    }

    public final int getMSupportTouchSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportTouchSet();
        }
        return 0;
    }

    public final int getMSupportTuyaKey() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportTuyaKey();
        }
        return 0;
    }

    public final int getMSupportVoice() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportVoice();
        }
        return 0;
    }

    public final int getMSupportVoiceMaxLength() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportVoiceMaxLength();
        }
        return 0;
    }

    public final int getMSupportWalkAndBike() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWalkAndBike();
        }
        return 0;
    }

    public final int getMSupportWashSet() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWashSet();
        }
        return 0;
    }

    public final int getMSupportWatchFaceId() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWatchFaceId();
        }
        return 0;
    }

    public final int getMSupportWatchFaceIndex() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWatchFaceIndex();
        }
        return 0;
    }

    public final int getMSupportWatchface2() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWatchface2();
        }
        return 0;
    }

    public final int getMSupportWearWay() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWearWay();
        }
        return 0;
    }

    public final int getMSupportWeather2() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWeather2();
        }
        return 0;
    }

    public final int getMSupportWorldClock() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMSupportWorldClock();
        }
        return 0;
    }

    public final int getMWatchFaceType() {
        BleDeviceInfo bleDeviceInfo = mDeviceInfo;
        if (bleDeviceInfo != null) {
            return bleDeviceInfo.getMWatchFaceType();
        }
        return 0;
    }

    @OOXIXo
    public final String getMtkOtaMeta() {
        String string = getMSpUtils().getString(MTK_OTA_META);
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getMtkOtaMeta -> " + string);
        IIX0o.oO(string, "also(...)");
        return string;
    }

    @oOoXoXO
    public final <T> T getObject(@OOXIXo BleKey bleKey, @OOXIXo Class<T> clazz, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(clazz, "clazz");
        T t = (T) new Gson().fromJson(getMSpUtils().getString(getKey(bleKey, bleKeyFlag)), (Class) clazz);
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getObject " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + t);
        return t;
    }

    public final <T> T getObjectNotNull(@OOXIXo BleKey bleKey, @OOXIXo Class<T> clazz, @oOoXoXO T t, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(clazz, "clazz");
        T t2 = (T) getObject$default(this, bleKey, clazz, null, 4, null);
        if (t2 == null) {
            if (t == null) {
                t = clazz.newInstance();
            }
            OI0.oIX0oI.f1507oIX0oI.XO("BleCache getObjectNotNull " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + t);
            return t;
        }
        return t2;
    }

    @OOXIXo
    public final String getString(@OOXIXo BleKey bleKey, @OOXIXo String def, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(def, "def");
        String string = getMSpUtils().getString(getKey(bleKey, bleKeyFlag), def);
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache getString " + INSTANCE.getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + string);
        IIX0o.oO(string, "also(...)");
        return string;
    }

    public final void putBoolean(@OOXIXo BleKey bleKey, boolean z, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putBoolean " + getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + z);
        getMSpUtils().put(getKey(bleKey, bleKeyFlag), z);
    }

    public final void putInt(@OOXIXo BleKey bleKey, int i, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putInt " + getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        getMSpUtils().put(getKey(bleKey, bleKeyFlag), i);
    }

    public final <T> void putList(@OOXIXo BleKey bleKey, @oOoXoXO List<? extends T> list, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putList " + getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + list);
        if (list != null && !list.isEmpty()) {
            getMSpUtils().put(getKey(bleKey, bleKeyFlag), new Gson().toJson(list));
        } else {
            remove$default(this, bleKey, null, 2, null);
        }
    }

    public final void putLong(@OOXIXo BleKey bleKey, long j, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putLong " + getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + j);
        getMSpUtils().put(getKey(bleKey, bleKeyFlag), j);
    }

    public final void putMtkOtaMeta(@OOXIXo String meta) {
        IIX0o.x0xO0oo(meta, "meta");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putMtkOtaMeta  -> " + meta);
        getMSpUtils().put(MTK_OTA_META, meta);
    }

    public final <T> void putObject(@OOXIXo BleKey bleKey, @oOoXoXO T t, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putObject " + getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + t);
        if (t == null) {
            remove$default(this, bleKey, null, 2, null);
        } else {
            getMSpUtils().put(getKey(bleKey, bleKeyFlag), new Gson().toJson(t));
        }
    }

    public final void putString(@OOXIXo BleKey bleKey, @OOXIXo String value, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(value, "value");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache putString " + getKey(bleKey, bleKeyFlag) + org.apache.commons.text.oIX0oI.f33048oxoX + value);
        getMSpUtils().put(getKey(bleKey, bleKeyFlag), value);
    }

    public final void remove(@OOXIXo BleKey bleKey, @oOoXoXO BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        OI0.oIX0oI.f1507oIX0oI.XO("BleCache remove " + getKey(bleKey, bleKeyFlag));
        getMSpUtils().remove(getKey(bleKey, bleKeyFlag));
    }

    public final boolean requireCache(@OOXIXo BleKey bleKey, @OOXIXo BleKeyFlag bleKeyFlag) {
        IIX0o.x0xO0oo(bleKey, "bleKey");
        IIX0o.x0xO0oo(bleKeyFlag, "bleKeyFlag");
        int i = WhenMappings.$EnumSwitchMapping$0[bleKey.getMBleCommand().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return false;
                }
                if (bleKeyFlag != BleKeyFlag.CREATE && bleKeyFlag != BleKeyFlag.DELETE && bleKeyFlag != BleKeyFlag.UPDATE && bleKeyFlag != BleKeyFlag.RESET) {
                    return false;
                }
            } else if ((bleKey != BleKey.SCHEDULE || (bleKeyFlag != BleKeyFlag.CREATE && bleKeyFlag != BleKeyFlag.DELETE && bleKeyFlag != BleKeyFlag.UPDATE)) && ((bleKey != BleKey.SMS_QUICK_REPLY_CONTENT || (bleKeyFlag != BleKeyFlag.CREATE && bleKeyFlag != BleKeyFlag.DELETE && bleKeyFlag != BleKeyFlag.UPDATE && bleKeyFlag != BleKeyFlag.RESET)) && ((bleKey != BleKey.WEATHER_REALTIME || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.WEATHER_FORECAST || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.STOCK || (bleKeyFlag != BleKeyFlag.CREATE && bleKeyFlag != BleKeyFlag.DELETE && bleKeyFlag != BleKeyFlag.UPDATE && bleKeyFlag != BleKeyFlag.RESET)) && ((bleKey != BleKey.WORLD_CLOCK || (bleKeyFlag != BleKeyFlag.CREATE && bleKeyFlag != BleKeyFlag.DELETE && bleKeyFlag != BleKeyFlag.UPDATE && bleKeyFlag != BleKeyFlag.RESET)) && ((bleKey != BleKey.WEATHER_REALTIME2 || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.WEATHER_FORECAST2 || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.LOGIN_DAYS || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.TARGET_COMPLETION || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.AUDIO_TEXT || bleKeyFlag != BleKeyFlag.UPDATE) && ((bleKey != BleKey.WEATHER_REALTIME3 || bleKeyFlag != BleKeyFlag.UPDATE) && (bleKey != BleKey.WEATHER_FORECAST3 || bleKeyFlag != BleKeyFlag.UPDATE))))))))))))) {
                return false;
            }
        } else if (bleKeyFlag != BleKeyFlag.CREATE && bleKeyFlag != BleKeyFlag.DELETE && bleKeyFlag != BleKeyFlag.UPDATE && bleKeyFlag != BleKeyFlag.RESET) {
            return false;
        }
        return true;
    }

    public final void setMDeviceInfo(@oOoXoXO BleDeviceInfo bleDeviceInfo) {
        mDeviceInfo = bleDeviceInfo;
    }
}
