package com.baidu.navisdk.adapter.struct;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public class BNChargingPreferInfo {
    private int mileage = 300;
    private int remainMileage = 300;
    private int chargeStart = 20;
    private int chargeEnd = 90;
    private ArrayList<ChargePreferType> pileList = new ArrayList<>();

    /* loaded from: classes7.dex */
    public enum ChargePreferType {
        FAST(0),
        SLOW(1),
        FREE(2),
        IDLE(3),
        ALL_DAY(4),
        STATE_GRID(5);

        private final int value;

        ChargePreferType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int getChargeEnd() {
        return this.chargeEnd;
    }

    public int getChargeStart() {
        return this.chargeStart;
    }

    public int getMileage() {
        return this.mileage;
    }

    public ArrayList<ChargePreferType> getPileList() {
        return this.pileList;
    }

    public int getRemainMileage() {
        return this.remainMileage;
    }

    public void setChargeEnd(int i) {
        this.chargeEnd = i;
    }

    public void setChargeStart(int i) {
        this.chargeStart = i;
    }

    public void setMileage(int i) {
        this.mileage = i;
    }

    public void setPileList(ArrayList<ChargePreferType> arrayList) {
        this.pileList = arrayList;
    }

    public void setRemainMileage(int i) {
        this.remainMileage = Math.min(i, this.mileage);
    }
}
