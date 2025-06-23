package com.tenmeter.smlibrary.entity;

import java.io.Serializable;

/* loaded from: classes13.dex */
public class SMGameUser implements Serializable {
    private static final long serialVersionUID = -5629015502728439990L;
    private String headImage;
    private String otpToken;
    private String serverUrl;
    private String thirdPartHeadImage;
    private String thirdPartNickname;
    private String thirdPartUid;
    private long uid;
    private String userNickname;
    private String userToken;

    public String getHeadImage() {
        return this.headImage;
    }

    public String getOtpToken() {
        return this.otpToken;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public String getThirdPartHeadImage() {
        return this.thirdPartHeadImage;
    }

    public String getThirdPartNickname() {
        return this.thirdPartNickname;
    }

    public String getThirdPartUid() {
        return this.thirdPartUid;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUserNickname() {
        return this.userNickname;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public void setHeadImage(String str) {
        this.headImage = str;
    }

    public void setOtpToken(String str) {
        this.otpToken = str;
    }

    public void setServerUrl(String str) {
        this.serverUrl = str;
    }

    public void setThirdPartHeadImage(String str) {
        if (str == null) {
            str = "";
        }
        this.thirdPartHeadImage = str;
    }

    public void setThirdPartNickname(String str) {
        if (str == null) {
            str = "";
        }
        this.thirdPartNickname = str;
    }

    public void setThirdPartUid(String str) {
        if (str == null) {
            str = "";
        }
        this.thirdPartUid = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setUserNickname(String str) {
        this.userNickname = str;
    }

    public void setUserToken(String str) {
        this.userToken = str;
    }
}
