package com.goodix.ble.libcomx.ptmodel;

/* loaded from: classes9.dex */
public final class PtCriterion {
    public boolean logicalNot;
    public String name;
    public String settingDesc;
    public String settingHint;
    public String settingValidate;
    public String valueExact;
    public Long valueMax;
    public Long valueMin;
    public Long valuePrecision;
    public String valueUnit;

    public PtCriterion copy(PtCriterion ptCriterion) {
        if (ptCriterion != null) {
            this.name = ptCriterion.name;
            this.valueMin = ptCriterion.valueMin;
            this.valueMax = ptCriterion.valueMax;
            this.valuePrecision = ptCriterion.valuePrecision;
            this.valueExact = ptCriterion.valueExact;
            this.logicalNot = ptCriterion.logicalNot;
            this.valueUnit = ptCriterion.valueUnit;
            this.settingDesc = ptCriterion.settingDesc;
            this.settingHint = ptCriterion.settingHint;
            this.settingValidate = ptCriterion.settingValidate;
        }
        return this;
    }
}
