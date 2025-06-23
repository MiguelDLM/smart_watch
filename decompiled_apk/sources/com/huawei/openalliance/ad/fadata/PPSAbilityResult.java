package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.ArrayList;

@DataKeep
/* loaded from: classes10.dex */
public class PPSAbilityResult {
    private ArrayList<PPSAbilityData> abilityDatas;
    private String intentSn;

    public String Code() {
        return this.intentSn;
    }

    public ArrayList<PPSAbilityData> V() {
        return this.abilityDatas;
    }

    public void Code(String str) {
        this.intentSn = str;
    }

    public void Code(ArrayList<PPSAbilityData> arrayList) {
        this.abilityDatas = arrayList;
    }
}
