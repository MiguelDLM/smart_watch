package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class ExpandFunc {
    private boolean banEq;
    private boolean isGameMode;
    private boolean isSupportMD5;
    private boolean isSupportSearchDevice;
    private byte[] rawData;
    private boolean supportAdaptiveANC;
    private boolean supportAnc;
    private boolean supportDevConfigure;
    private boolean supportExternalFlashTransfer;
    private boolean supportHearingAssist;
    private boolean supportReadErrorMSg;
    private boolean supportSoundCard;

    public byte[] getRawData() {
        return this.rawData;
    }

    public boolean isBanEq() {
        return this.banEq;
    }

    public boolean isGameMode() {
        return this.isGameMode;
    }

    public boolean isSupportAdaptiveANC() {
        return this.supportAdaptiveANC;
    }

    public boolean isSupportAnc() {
        return this.supportAnc;
    }

    public boolean isSupportDevConfigure() {
        return this.supportDevConfigure;
    }

    public boolean isSupportExternalFlashTransfer() {
        return this.supportExternalFlashTransfer;
    }

    public boolean isSupportHearingAssist() {
        return this.supportHearingAssist;
    }

    public boolean isSupportMD5() {
        return this.isSupportMD5;
    }

    public boolean isSupportReadErrorMSg() {
        return this.supportReadErrorMSg;
    }

    public boolean isSupportSearchDevice() {
        return this.isSupportSearchDevice;
    }

    public boolean isSupportSoundCard() {
        return this.supportSoundCard;
    }

    public void parseData(byte[] bArr) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (bArr != null) {
            boolean z11 = true;
            if (bArr.length >= 1) {
                setRawData(bArr);
                byte b = bArr[0];
                if ((b & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                setSupportMD5(z);
                if (((b >> 1) & 1) == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                setGameMode(z2);
                if (((b >> 2) & 1) == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                setSupportSearchDevice(z3);
                if (((b >> 3) & 1) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                setSupportSoundCard(z4);
                if (((b >> 4) & 1) == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                setBanEq(z5);
                if (((b >> 5) & 1) == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                setSupportExternalFlashTransfer(z6);
                if (((b >> 6) & 1) == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                setSupportAnc(z7);
                if (((b >> 7) & 1) == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                setSupportReadErrorMSg(z8);
                if (bArr.length >= 2) {
                    byte b2 = bArr[1];
                    if ((b2 & 1) == 1) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    setSupportHearingAssist(z9);
                    if (((b2 >> 1) & 1) == 1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    setSupportAdaptiveANC(z10);
                    if (((b2 >> 2) & 1) != 1) {
                        z11 = false;
                    }
                    setSupportDevConfigure(z11);
                }
            }
        }
    }

    public void setBanEq(boolean z) {
        this.banEq = z;
    }

    public void setGameMode(boolean z) {
        this.isGameMode = z;
    }

    public void setRawData(byte[] bArr) {
        this.rawData = bArr;
    }

    public void setSupportAdaptiveANC(boolean z) {
        this.supportAdaptiveANC = z;
    }

    public void setSupportAnc(boolean z) {
        this.supportAnc = z;
    }

    public void setSupportDevConfigure(boolean z) {
        this.supportDevConfigure = z;
    }

    public void setSupportExternalFlashTransfer(boolean z) {
        this.supportExternalFlashTransfer = z;
    }

    public void setSupportHearingAssist(boolean z) {
        this.supportHearingAssist = z;
    }

    public void setSupportMD5(boolean z) {
        this.isSupportMD5 = z;
    }

    public void setSupportReadErrorMSg(boolean z) {
        this.supportReadErrorMSg = z;
    }

    public void setSupportSearchDevice(boolean z) {
        this.isSupportSearchDevice = z;
    }

    public void setSupportSoundCard(boolean z) {
        this.supportSoundCard = z;
    }

    public String toString() {
        return "ExpandFunc{rawData=" + CHexConver.byte2HexStr(this.rawData) + ", isSupportMD5=" + this.isSupportMD5 + ", isGameMode=" + this.isGameMode + ", isSupportSearchDevice=" + this.isSupportSearchDevice + ", supportSoundCard=" + this.supportSoundCard + ", banEq=" + this.banEq + ", supportExternalFlashTransfer=" + this.supportExternalFlashTransfer + ", supportAnc=" + this.supportAnc + ", supportReadErrorMSg=" + this.supportReadErrorMSg + ", supportHearingAssist=" + this.supportHearingAssist + ", supportAdaptiveANC=" + this.supportAdaptiveANC + ", supportDevConfigure=" + this.supportDevConfigure + '}';
    }
}
