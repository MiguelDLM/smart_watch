package com.tenmeter.smlibrary.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

/* loaded from: classes13.dex */
public class SMADBean implements Parcelable {
    public static final Parcelable.Creator<SMADBean> CREATOR = new Parcelable.Creator<SMADBean>() { // from class: com.tenmeter.smlibrary.entity.SMADBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @RequiresApi(api = 29)
        public SMADBean createFromParcel(Parcel parcel) {
            return new SMADBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMADBean[] newArray(int i) {
            return new SMADBean[i];
        }
    };
    private String adEnUrl;
    private String adName;
    private String adUrl;
    private String comp;
    private String createdTime;
    private SMGameInfo game;
    private SMIconListParent icon;
    private int id;
    private String lastUpdatedTime;
    private int redirectId;
    private int redirectType;
    private String redirectUrl;
    private SMGameListParent tag;

    public SMADBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdEnUrl() {
        return this.adEnUrl;
    }

    public String getAdName() {
        return this.adName;
    }

    public String getAdUrl() {
        return this.adUrl;
    }

    public String getComp() {
        return this.comp;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public SMGameInfo getGame() {
        return this.game;
    }

    public SMIconListParent getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public String getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    public int getRedirectId() {
        return this.redirectId;
    }

    public int getRedirectType() {
        return this.redirectType;
    }

    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    public SMGameListParent getTag() {
        return this.tag;
    }

    public void setAdEnUrl(String str) {
        this.adEnUrl = str;
    }

    public void setAdName(String str) {
        this.adName = str;
    }

    public void setAdUrl(String str) {
        this.adUrl = str;
    }

    public void setComp(String str) {
        this.comp = str;
    }

    public void setCreatedTime(String str) {
        this.createdTime = str;
    }

    public void setGame(SMGameInfo sMGameInfo) {
        this.game = sMGameInfo;
    }

    public void setIcon(SMIconListParent sMIconListParent) {
        this.icon = sMIconListParent;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLastUpdatedTime(String str) {
        this.lastUpdatedTime = str;
    }

    public void setRedirectId(int i) {
        this.redirectId = i;
    }

    public void setRedirectType(int i) {
        this.redirectType = i;
    }

    public void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    public void setTag(SMGameListParent sMGameListParent) {
        this.tag = sMGameListParent;
    }

    @Override // android.os.Parcelable
    @RequiresApi(api = 29)
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.adEnUrl);
        parcel.writeString(this.adName);
        parcel.writeString(this.adUrl);
        parcel.writeString(this.comp);
        parcel.writeString(this.createdTime);
        parcel.writeParcelable(this.game, i);
        parcel.writeParcelable(this.icon, i);
        parcel.writeInt(this.id);
        parcel.writeString(this.lastUpdatedTime);
        parcel.writeInt(this.redirectId);
        parcel.writeInt(this.redirectType);
        parcel.writeParcelable(this.tag, i);
        parcel.writeString(this.redirectUrl);
    }

    @RequiresApi(api = 29)
    public SMADBean(Parcel parcel) {
        this.adEnUrl = parcel.readString();
        this.adName = parcel.readString();
        this.adUrl = parcel.readString();
        this.comp = parcel.readString();
        this.createdTime = parcel.readString();
        this.game = (SMGameInfo) parcel.readParcelable(SMGameInfo.class.getClassLoader());
        this.icon = (SMIconListParent) parcel.readParcelable(SMIconListParent.class.getClassLoader());
        this.id = parcel.readInt();
        this.lastUpdatedTime = parcel.readString();
        this.redirectId = parcel.readInt();
        this.redirectType = parcel.readInt();
        this.tag = (SMGameListParent) parcel.readParcelable(SMGameListParent.class.getClassLoader());
        this.redirectUrl = parcel.readString();
    }
}
