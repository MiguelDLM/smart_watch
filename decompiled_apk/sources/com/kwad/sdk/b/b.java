package com.kwad.sdk.b;

import com.kuaishou.weapon.p0.IWeaponInitParams;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bj;

/* loaded from: classes11.dex */
public final class b implements IWeaponInitParams {
    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final boolean getAPPLISTSwitch() {
        if (!av.Ne()) {
            return true;
        }
        return false;
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getAppKey() {
        return "400000";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getChannel() {
        return "";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getDeviceId() {
        return bj.getDeviceId();
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final boolean getPrivacySwitch() {
        return true;
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getProductName() {
        return "ksadsdk";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getSecKey() {
        return "f12536c198aee4d8198aad2300827430";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final String getUserId() {
        return "";
    }

    @Override // com.kuaishou.weapon.p0.IWeaponInitParams
    public final boolean isLoadSo() {
        return com.kwad.framework.a.a.aeu.booleanValue();
    }
}
