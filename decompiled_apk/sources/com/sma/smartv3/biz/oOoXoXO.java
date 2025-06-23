package com.sma.smartv3.biz;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.component.BleConnector;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nMultiDeviceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiDeviceManager.kt\ncom/sma/smartv3/biz/MultiDeviceManager\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n74#2,4:93\n78#2:100\n80#2,2:102\n67#2,2:107\n67#2,2:111\n67#2,2:113\n1549#3:97\n1620#3,2:98\n1622#3:101\n1855#3,2:105\n1855#3,2:109\n1#4:104\n*S KotlinDebug\n*F\n+ 1 MultiDeviceManager.kt\ncom/sma/smartv3/biz/MultiDeviceManager\n*L\n28#1:93,4\n28#1:100\n28#1:102,2\n36#1:107,2\n47#1:111,2\n56#1:113,2\n28#1:97\n28#1:98,2\n28#1:101\n31#1:105,2\n42#1:109,2\n*E\n"})
/* loaded from: classes12.dex */
public final class oOoXoXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oOoXoXO f20294oIX0oI = new oOoXoXO();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f20293II0xO0 = "MultiDeviceManager";

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f20292I0Io = 10;

    public final void I0Io(@OXOo.OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(f20293II0xO0 + " connectDevice -> " + deviceInfo.getMBleAddress());
        BleConnector bleConnector = BleConnector.INSTANCE;
        bleConnector.closeConnection(true);
        BleCache bleCache = BleCache.INSTANCE;
        bleCache.setMDeviceInfo(deviceInfo);
        BleCache.putObject$default(bleCache, BleKey.IDENTITY, deviceInfo, null, 4, null);
        bleConnector.setMConnectDirectly(true);
        bleConnector.launch();
        DeviceInfoChecker.OOXIXo(DeviceInfoChecker.f19983oIX0oI, null, null, 3, null);
        x0xO0oo.oIX0oI(x0xO0oo.f24572IO, Boolean.FALSE);
        bleConnector.connectClassic();
        com.sma.smartv3.ble.II0xO0.f20317oIX0oI.XxX0x0xxx(true);
    }

    public final boolean II0XooXoX(@OXOo.OOXIXo String address) {
        IIX0o.x0xO0oo(address, "address");
        return IIX0o.Oxx0IOOO(address, BleCache.INSTANCE.getMBleAddress());
    }

    public final boolean II0xO0() {
        if (!ProjectManager.f19822oIX0oI.oXX0IoI() || X0o0xo().size() < f20292I0Io) {
            return true;
        }
        return false;
    }

    public final boolean Oxx0IOOO(@OXOo.oOoXoXO BleDeviceInfo bleDeviceInfo) {
        Object obj;
        Iterator<T> it = X0o0xo().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String mBleAddress = ((BleDeviceInfo) next).getMBleAddress();
            if (bleDeviceInfo != null) {
                obj = bleDeviceInfo.getMBleAddress();
            }
            if (IIX0o.Oxx0IOOO(mBleAddress, obj)) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final List<BleDeviceInfo> X0o0xo() {
        Collection ooXIXxIX2;
        Object obj;
        ArrayList arrayList = new ArrayList();
        try {
            byte[] base64Decode = EncodeUtils.base64Decode(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24357II0XooXoX));
            IIX0o.oO(base64Decode, "base64Decode(...)");
            JsonArray asJsonArray = JsonParser.parseString(new String(base64Decode, kotlin.text.oxoX.f29581II0xO0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                ooXIXxIX2.add(new Gson().fromJson(it.next(), BleDeviceInfo.class));
            }
        } catch (Exception unused) {
            ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Collection<BleDeviceInfo> collection = ooXIXxIX2;
        Iterator it2 = collection.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (f20294oIX0oI.II0XooXoX(((BleDeviceInfo) obj).getMBleAddress())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        BleDeviceInfo bleDeviceInfo = (BleDeviceInfo) obj;
        if (bleDeviceInfo != null) {
            arrayList.add(bleDeviceInfo);
        }
        for (BleDeviceInfo bleDeviceInfo2 : collection) {
            if (!f20294oIX0oI.II0XooXoX(bleDeviceInfo2.getMBleAddress())) {
                arrayList.add(bleDeviceInfo2);
            }
        }
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String json = new Gson().toJson(arrayList);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        XO2.put(XoI0Ixx0.f24357II0XooXoX, EncodeUtils.base64Encode2String(bytes));
        return arrayList;
    }

    public final int XO() {
        return f20292I0Io;
    }

    public final void oIX0oI(@OXOo.oOoXoXO BleDeviceInfo bleDeviceInfo) {
        if (bleDeviceInfo == null || Oxx0IOOO(BleCache.INSTANCE.getMDeviceInfo())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(X0o0xo());
        arrayList.add(bleDeviceInfo);
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String json = new Gson().toJson(arrayList);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        XO2.put(XoI0Ixx0.f24357II0XooXoX, EncodeUtils.base64Encode2String(bytes));
    }

    public final void oxoX(@OXOo.OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        ArrayList arrayList = new ArrayList();
        for (BleDeviceInfo bleDeviceInfo : X0o0xo()) {
            if (!IIX0o.Oxx0IOOO(bleDeviceInfo.getMBleAddress(), deviceInfo.getMBleAddress())) {
                arrayList.add(bleDeviceInfo);
            }
        }
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String json = new Gson().toJson(arrayList);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        XO2.put(XoI0Ixx0.f24357II0XooXoX, EncodeUtils.base64Encode2String(bytes));
    }
}
