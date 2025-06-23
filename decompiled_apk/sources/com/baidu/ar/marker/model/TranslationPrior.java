package com.baidu.ar.marker.model;

import java.util.Arrays;

/* loaded from: classes7.dex */
public class TranslationPrior {
    private String buildingId;
    private float confidence;
    private long time;
    private int type;
    private String uq;
    private float[] ur;
    private float us;

    public TranslationPrior() {
        this.us = 1.0f;
        this.confidence = 1.0f;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public float[] getCoordinate() {
        return this.ur;
    }

    public String getFloorID() {
        return this.uq;
    }

    public float getPrecision() {
        return this.us;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setConfidence(float f) {
        this.confidence = f;
    }

    public void setCoordinate(float[] fArr) {
        this.ur = fArr;
    }

    public void setFloorID(String str) {
        this.uq = str;
    }

    public void setPrecision(float f) {
        this.us = f;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        return "TranslationPrior{type=" + this.type + ", floor_id='" + this.uq + "', building_id='" + this.buildingId + "', prior=" + Arrays.toString(this.ur) + ", prior_accuracy=" + this.us + ", prior_confidence=" + this.confidence + '}';
    }

    public TranslationPrior(TranslationPrior translationPrior) {
        this.us = 1.0f;
        this.confidence = 1.0f;
        if (translationPrior == null) {
            return;
        }
        this.uq = translationPrior.getFloorID();
        this.type = translationPrior.getType();
        this.buildingId = translationPrior.getBuildingId();
        this.ur = Arrays.copyOf(translationPrior.getCoordinate(), translationPrior.getCoordinate().length);
        this.us = translationPrior.getPrecision();
        this.confidence = translationPrior.getConfidence();
        this.time = translationPrior.getTime();
    }
}
