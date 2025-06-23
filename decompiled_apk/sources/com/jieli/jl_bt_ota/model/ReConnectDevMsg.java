package com.jieli.jl_bt_ota.model;

import android.bluetooth.BluetoothAdapter;
import java.util.Objects;

/* loaded from: classes10.dex */
public class ReConnectDevMsg {
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SCANNING = 1;
    private String address;
    private boolean isUseADV;
    private int state;
    private int way;

    public ReConnectDevMsg(int i, String str) {
        this(i, str, false);
    }

    public boolean checkIsValid() {
        return BluetoothAdapter.checkBluetoothAddress(this.address);
    }

    public ReConnectDevMsg cloneObject() {
        return new ReConnectDevMsg(this.way, this.address, this.isUseADV).setState(this.state);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReConnectDevMsg reConnectDevMsg = (ReConnectDevMsg) obj;
        if (this.way == reConnectDevMsg.way && Objects.equals(this.address, reConnectDevMsg.address)) {
            return true;
        }
        return false;
    }

    public String getAddress() {
        return this.address;
    }

    public int getState() {
        return this.state;
    }

    public int getWay() {
        return this.way;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.way), this.address);
    }

    public boolean isUseADV() {
        return this.isUseADV;
    }

    public ReConnectDevMsg setAddress(String str) {
        this.address = str;
        return this;
    }

    public ReConnectDevMsg setState(int i) {
        this.state = i;
        return this;
    }

    public ReConnectDevMsg setUseADV(boolean z) {
        this.isUseADV = z;
        return this;
    }

    public ReConnectDevMsg setWay(int i) {
        this.way = i;
        return this;
    }

    public String toString() {
        return "ReConnectDevMsg{way=" + this.way + ", address='" + this.address + "', isUseADV=" + this.isUseADV + ", state=" + this.state + '}';
    }

    public ReConnectDevMsg(int i, String str, boolean z) {
        setWay(i).setAddress(str).setUseADV(z);
    }
}
