package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class ExternalFlashMsgResponse extends CommonResponse {
    private int blockSize;
    private int cluster;
    private int fatSize;
    private int flashSize;
    private String[] matchVersions;
    private int receiveMtu;
    private int screenHeight;
    private int screenWidth;
    private int sysStatus;
    private int system;
    private int watchVersionCode;

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getCluster() {
        return this.cluster;
    }

    public int getFatSize() {
        return this.fatSize;
    }

    public int getFlashSize() {
        return this.flashSize;
    }

    public String[] getMatchVersions() {
        return this.matchVersions;
    }

    public int getReceiveMtu() {
        return this.receiveMtu;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getSysStatus() {
        return this.sysStatus;
    }

    public int getSystem() {
        return this.system;
    }

    public int getWatchVersionCode() {
        return this.watchVersionCode;
    }

    public ExternalFlashMsgResponse setBlockSize(int i) {
        this.blockSize = i;
        return this;
    }

    public ExternalFlashMsgResponse setCluster(int i) {
        this.cluster = i;
        return this;
    }

    public ExternalFlashMsgResponse setFatSize(int i) {
        this.fatSize = i;
        return this;
    }

    public ExternalFlashMsgResponse setFlashSize(int i) {
        this.flashSize = i;
        return this;
    }

    public ExternalFlashMsgResponse setMatchVersions(String[] strArr) {
        this.matchVersions = strArr;
        return this;
    }

    public ExternalFlashMsgResponse setReceiveMtu(int i) {
        this.receiveMtu = i;
        return this;
    }

    public ExternalFlashMsgResponse setScreenHeight(int i) {
        this.screenHeight = i;
        return this;
    }

    public ExternalFlashMsgResponse setScreenWidth(int i) {
        this.screenWidth = i;
        return this;
    }

    public ExternalFlashMsgResponse setSysStatus(int i) {
        this.sysStatus = i;
        return this;
    }

    public ExternalFlashMsgResponse setSystem(int i) {
        this.system = i;
        return this;
    }

    public ExternalFlashMsgResponse setWatchVersionCode(int i) {
        this.watchVersionCode = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "ExternalFlashMsgResponse{flashSize=" + this.flashSize + ", system=" + this.system + ", blockSize=" + this.blockSize + ", sysStatus=" + this.sysStatus + ", cluster=" + this.cluster + ", fatSize=" + this.fatSize + ", matchVersions=" + Arrays.toString(this.matchVersions) + ", watchVersionCode=" + this.watchVersionCode + ", blockSize=" + this.blockSize + ", receiveMtu=" + this.receiveMtu + ", screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + "} " + super.toString();
    }
}
