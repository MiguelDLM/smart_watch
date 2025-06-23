package com.huawei.openalliance.ad.fadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes10.dex */
public class PPSAbilityData {
    private List<PPSAbilityDataContent> abilityDataContent;
    private String displayForm;

    public String Code() {
        return this.displayForm;
    }

    public List<PPSAbilityDataContent> V() {
        return this.abilityDataContent;
    }

    public void Code(String str) {
        this.displayForm = str;
    }

    public void Code(List<PPSAbilityDataContent> list) {
        this.abilityDataContent = list;
    }
}
