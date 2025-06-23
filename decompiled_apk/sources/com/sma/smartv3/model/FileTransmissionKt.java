package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.x0xO0oo;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleAppInfo;
import com.szabh.smable3.entity.BleAppInfoList;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFileTransmission.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTransmission.kt\ncom/sma/smartv3/model/FileTransmissionKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n766#2:244\n857#2,2:245\n1855#2,2:247\n*S KotlinDebug\n*F\n+ 1 FileTransmission.kt\ncom/sma/smartv3/model/FileTransmissionKt\n*L\n44#1:244\n44#1:245,2\n61#1:247,2\n*E\n"})
/* loaded from: classes12.dex */
public final class FileTransmissionKt {
    public static final boolean appStoreIsShowCurrentCategory(@OOXIXo String appPackName) {
        IIX0o.x0xO0oo(appPackName, "appPackName");
        if (!ProductManager.f20544oIX0oI.OIxOX()) {
            return false;
        }
        try {
            BleAppInfoList bleAppInfoList = (BleAppInfoList) BleCache.getObject$default(BleCache.INSTANCE, BleKey.APP_OP, BleAppInfoList.class, null, 4, null);
            if (bleAppInfoList == null || bleAppInfoList.getMList().isEmpty()) {
                return false;
            }
            List<BleAppInfo> mList = bleAppInfoList.getMList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : mList) {
                if (IIX0o.Oxx0IOOO(((BleAppInfo) obj).getMPackage(), appPackName)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            if (((BleAppInfo) CollectionsKt___CollectionsKt.O0OOX0IIx(arrayList)).getMHide() != 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean appStoreIsShowCurrentCategory$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = BleAppInfo.PACKAGE_WORLD_CLOCK;
        }
        return appStoreIsShowCurrentCategory(str);
    }

    public static final void changAppStoreCurrentCategory(@OOXIXo String appPackName) {
        IIX0o.x0xO0oo(appPackName, "appPackName");
        if (ProductManager.f20544oIX0oI.OIxOX()) {
            try {
                BleAppInfoList bleAppInfoList = (BleAppInfoList) BleCache.getObject$default(BleCache.INSTANCE, BleKey.APP_OP, BleAppInfoList.class, null, 4, null);
                if (bleAppInfoList != null && !bleAppInfoList.getMList().isEmpty()) {
                    for (BleAppInfo bleAppInfo : bleAppInfoList.getMList()) {
                        if (IIX0o.Oxx0IOOO(bleAppInfo.getMPackage(), appPackName)) {
                            if (bleAppInfo.getMHide() == 0) {
                                bleAppInfo.setMHide(1);
                            } else {
                                bleAppInfo.setMHide(0);
                            }
                        }
                    }
                }
                BleCache.putObject$default(BleCache.INSTANCE, BleKey.APP_OP, bleAppInfoList, null, 4, null);
                x0xO0oo.oIX0oI(x0xO0oo.f24572IO, Boolean.FALSE);
            } catch (Exception unused) {
            }
        }
    }

    public static final int getAppStoreIcon(@OOXIXo String mPackage) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        switch (mPackage.hashCode()) {
            case -1900747410:
                if (!mPackage.equals(BleAppInfo.PACKAGE_NAVIGATION)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_tool02;
            case -1150287196:
                if (!mPackage.equals(BleAppInfo.PACKAGE_ALIPAY)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_tool01;
            case -820781567:
                if (!mPackage.equals(BleAppInfo.PACKAGE_GAME_TTT)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_game04;
            case -574428292:
                if (!mPackage.equals(BleAppInfo.PACKAGE_STOCK)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_game01;
            case 323541717:
                if (!mPackage.equals(BleAppInfo.PACKAGE_GAME_2048)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_game03;
            case 325447868:
                if (!mPackage.equals(BleAppInfo.PACKAGE_GAME_PLAN)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_game05;
            case 595424519:
                mPackage.equals(BleAppInfo.PACKAGE_WORLD_CLOCK);
                return R.drawable.app_store_game02;
            case 867788782:
                if (!mPackage.equals(BleAppInfo.PACKAGE_CARD_WALLET)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_tool04;
            case 1386488444:
                if (!mPackage.equals(BleAppInfo.PACKAGE_CALCULATOR)) {
                    return R.drawable.app_store_game02;
                }
                return R.drawable.app_store_tool03;
            default:
                return R.drawable.app_store_game02;
        }
    }
}
