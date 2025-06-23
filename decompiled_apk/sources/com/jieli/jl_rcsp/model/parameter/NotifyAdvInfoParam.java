package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class NotifyAdvInfoParam extends BaseParameter {
    private int action;
    private int chargingBinQuantity;
    private int deviceType;
    private String edrAddr;
    private boolean isDeviceCharging;
    private boolean isLeftCharging;
    private boolean isRightCharging;
    private int leftDeviceQuantity;
    private int pid;
    private int rightDeviceQuantity;
    private int seq;
    private boolean showDialog;
    private int uid;
    private int version;
    private int vid;

    public int getAction() {
        return this.action;
    }

    public int getChargingBinQuantity() {
        return this.chargingBinQuantity;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getEdrAddr() {
        return this.edrAddr;
    }

    public int getLeftDeviceQuantity() {
        return this.leftDeviceQuantity;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte b;
        byte b2;
        byte[] bArr = new byte[18];
        byte[] int2byte2 = CHexConver.int2byte2(this.vid);
        byte b3 = 0;
        System.arraycopy(int2byte2, 0, bArr, 0, int2byte2.length);
        int length = int2byte2.length;
        byte[] int2byte22 = CHexConver.int2byte2(this.uid);
        System.arraycopy(int2byte22, 0, bArr, length, int2byte22.length);
        int length2 = length + int2byte22.length;
        byte[] int2byte23 = CHexConver.int2byte2(this.pid);
        System.arraycopy(int2byte23, 0, bArr, length2, int2byte23.length);
        int length3 = length2 + int2byte23.length;
        bArr[length3] = (byte) ((this.deviceType << 4) | (this.version & 15));
        int i = length3 + 1;
        byte[] addressCovertToByteArray = RcspUtil.addressCovertToByteArray(this.edrAddr);
        if (addressCovertToByteArray != null && addressCovertToByteArray.length == 6) {
            System.arraycopy(addressCovertToByteArray, 0, bArr, i, addressCovertToByteArray.length);
            i = length3 + 7;
        }
        bArr[i] = CHexConver.intToByte(this.action);
        int i2 = i + 1;
        if (this.isLeftCharging) {
            b = Byte.MIN_VALUE;
        } else {
            b = 0;
        }
        bArr[i2] = b;
        int i3 = i + 2;
        if (this.isRightCharging) {
            b2 = Byte.MIN_VALUE;
        } else {
            b2 = 0;
        }
        bArr[i3] = b2;
        int i4 = i + 3;
        if (this.isDeviceCharging) {
            b3 = Byte.MIN_VALUE;
        }
        bArr[i4] = b3;
        bArr[i + 4] = CHexConver.intToByte(this.seq);
        return bArr;
    }

    public int getPid() {
        return this.pid;
    }

    public int getRightDeviceQuantity() {
        return this.rightDeviceQuantity;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVid() {
        return this.vid;
    }

    public boolean isDeviceCharging() {
        return this.isDeviceCharging;
    }

    public boolean isLeftCharging() {
        return this.isLeftCharging;
    }

    public boolean isRightCharging() {
        return this.isRightCharging;
    }

    public boolean isShowDialog() {
        return this.showDialog;
    }

    public NotifyAdvInfoParam setAction(int i) {
        this.action = i;
        return this;
    }

    public NotifyAdvInfoParam setChargingBinQuantity(int i) {
        this.chargingBinQuantity = i;
        return this;
    }

    public NotifyAdvInfoParam setDeviceCharging(boolean z) {
        this.isDeviceCharging = z;
        return this;
    }

    public NotifyAdvInfoParam setDeviceType(int i) {
        this.deviceType = i;
        return this;
    }

    public NotifyAdvInfoParam setEdrAddr(String str) {
        this.edrAddr = str;
        return this;
    }

    public NotifyAdvInfoParam setLeftCharging(boolean z) {
        this.isLeftCharging = z;
        return this;
    }

    public NotifyAdvInfoParam setLeftDeviceQuantity(int i) {
        this.leftDeviceQuantity = i;
        return this;
    }

    public NotifyAdvInfoParam setPid(int i) {
        this.pid = i;
        return this;
    }

    public NotifyAdvInfoParam setRightCharging(boolean z) {
        this.isRightCharging = z;
        return this;
    }

    public NotifyAdvInfoParam setRightDeviceQuantity(int i) {
        this.rightDeviceQuantity = i;
        return this;
    }

    public NotifyAdvInfoParam setSeq(int i) {
        this.seq = i;
        return this;
    }

    public NotifyAdvInfoParam setShowDialog(boolean z) {
        this.showDialog = z;
        return this;
    }

    public NotifyAdvInfoParam setUid(int i) {
        this.uid = i;
        return this;
    }

    public NotifyAdvInfoParam setVersion(int i) {
        this.version = i;
        return this;
    }

    public NotifyAdvInfoParam setVid(int i) {
        this.vid = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "NotifyAdvInfoParam{pid=" + this.pid + ", vid=" + this.vid + ", uid=" + this.uid + ", chipType=" + this.deviceType + ", version=" + this.version + ", showDialog=" + this.showDialog + ", edrAddr='" + this.edrAddr + "', seq=" + this.seq + ", action=" + this.action + ", leftDeviceQuantity=" + this.leftDeviceQuantity + ", isLeftCharging=" + this.isLeftCharging + ", rightDeviceQuantity=" + this.rightDeviceQuantity + ", isRightCharging=" + this.isRightCharging + ", chargingBinQuantity=" + this.chargingBinQuantity + ", isDeviceCharging=" + this.isDeviceCharging + "} " + super.toString();
    }
}
