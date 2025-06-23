package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.entity.BleDeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.oxoX;

@XX({"SMAP\nUpgradeFailedDeviceData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpgradeFailedDeviceData.kt\ncom/sma/smartv3/model/UpgradeFailedDeviceData\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,32:1\n74#2,4:33\n78#2:40\n80#2,2:42\n67#2,2:46\n67#2,2:48\n1549#3:37\n1620#3,2:38\n1622#3:41\n1855#3,2:44\n*S KotlinDebug\n*F\n+ 1 UpgradeFailedDeviceData.kt\ncom/sma/smartv3/model/UpgradeFailedDeviceData\n*L\n11#1:33,4\n11#1:40\n11#1:42,2\n21#1:46,2\n28#1:48,2\n11#1:37\n11#1:38,2\n11#1:41\n16#1:44,2\n*E\n"})
/* loaded from: classes12.dex */
public final class UpgradeFailedDeviceData {

    @OOXIXo
    public static final UpgradeFailedDeviceData INSTANCE = new UpgradeFailedDeviceData();

    private UpgradeFailedDeviceData() {
    }

    public final void add(@OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getList());
        arrayList.add(deviceInfo);
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String json = new Gson().toJson(arrayList);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        XO2.put(XoI0Ixx0.f24403Oxx0IOOO, EncodeUtils.base64Encode2String(bytes));
    }

    public final void delete(@OOXIXo BleDeviceInfo deviceInfo) {
        IIX0o.x0xO0oo(deviceInfo, "deviceInfo");
        ArrayList arrayList = new ArrayList();
        for (BleDeviceInfo bleDeviceInfo : getList()) {
            if (!IIX0o.Oxx0IOOO(bleDeviceInfo.getMBleAddress(), deviceInfo.getMBleAddress())) {
                arrayList.add(bleDeviceInfo);
            }
        }
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        String json = new Gson().toJson(arrayList);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        XO2.put(XoI0Ixx0.f24403Oxx0IOOO, EncodeUtils.base64Encode2String(bytes));
    }

    @OOXIXo
    public final List<BleDeviceInfo> getList() {
        try {
            byte[] base64Decode = EncodeUtils.base64Decode(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24403Oxx0IOOO));
            IIX0o.oO(base64Decode, "base64Decode(...)");
            JsonArray asJsonArray = JsonParser.parseString(new String(base64Decode, oxoX.f29581II0xO0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                arrayList.add(new Gson().fromJson(it.next(), BleDeviceInfo.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }
}
