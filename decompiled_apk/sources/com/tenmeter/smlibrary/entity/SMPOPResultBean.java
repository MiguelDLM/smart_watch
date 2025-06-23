package com.tenmeter.smlibrary.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

/* loaded from: classes13.dex */
public class SMPOPResultBean implements Parcelable {
    public static final Parcelable.Creator<SMPOPResultBean> CREATOR = new Parcelable.Creator<SMPOPResultBean>() { // from class: com.tenmeter.smlibrary.entity.SMPOPResultBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @RequiresApi(api = 29)
        public SMPOPResultBean createFromParcel(Parcel parcel) {
            return new SMPOPResultBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMPOPResultBean[] newArray(int i) {
            return new SMPOPResultBean[i];
        }
    };
    private SMGameListBannerParent banner;
    private String comp;
    private String createdTime;
    private String des;
    private String enDes;
    private String enResource;
    private String enTitle;
    private SMGameInfo gameDto;
    private SMIconListParent icon;
    private int id;
    private String lastUpdatedTime;
    private String linkResource;
    private int linkType;
    private boolean playOnce;
    private String resource;
    private String title;

    public SMPOPResultBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SMGameListBannerParent getBanner() {
        return this.banner;
    }

    public String getComp() {
        return this.comp;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public String getDes() {
        return this.des;
    }

    public String getEnDes() {
        return this.enDes;
    }

    public String getEnResource() {
        return this.enResource;
    }

    public String getEnTitle() {
        return this.enTitle;
    }

    public SMGameInfo getGameDto() {
        return this.gameDto;
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

    public String getLinkResource() {
        return this.linkResource;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public String getResource() {
        return this.resource;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isPlayOnce() {
        return this.playOnce;
    }

    public void setBanner(SMGameListBannerParent sMGameListBannerParent) {
        this.banner = sMGameListBannerParent;
    }

    public void setComp(String str) {
        this.comp = str;
    }

    public void setCreatedTime(String str) {
        this.createdTime = str;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setEnDes(String str) {
        this.enDes = str;
    }

    public void setEnResource(String str) {
        this.enResource = str;
    }

    public void setEnTitle(String str) {
        this.enTitle = str;
    }

    public void setGameDto(SMGameInfo sMGameInfo) {
        this.gameDto = sMGameInfo;
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

    public void setLinkResource(String str) {
        this.linkResource = str;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public void setPlayOnce(boolean z) {
        this.playOnce = z;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    @RequiresApi(api = 29)
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.comp);
        parcel.writeString(this.des);
        parcel.writeString(this.enDes);
        parcel.writeString(this.enResource);
        parcel.writeString(this.enTitle);
        parcel.writeString(this.title);
        parcel.writeString(this.createdTime);
        parcel.writeParcelable(this.gameDto, i);
        parcel.writeInt(this.id);
        parcel.writeString(this.lastUpdatedTime);
        parcel.writeString(this.linkResource);
        parcel.writeString(this.resource);
        parcel.writeInt(this.linkType);
        parcel.writeBoolean(this.playOnce);
        parcel.writeParcelable(this.banner, i);
        parcel.writeParcelable(this.icon, i);
    }

    @RequiresApi(api = 29)
    public SMPOPResultBean(Parcel parcel) {
        boolean readBoolean;
        this.comp = parcel.readString();
        this.des = parcel.readString();
        this.enDes = parcel.readString();
        this.enResource = parcel.readString();
        this.enTitle = parcel.readString();
        this.title = parcel.readString();
        this.createdTime = parcel.readString();
        this.gameDto = (SMGameInfo) parcel.readParcelable(SMGameInfo.class.getClassLoader());
        this.id = parcel.readInt();
        this.lastUpdatedTime = parcel.readString();
        this.linkResource = parcel.readString();
        this.resource = parcel.readString();
        this.linkType = parcel.readInt();
        readBoolean = parcel.readBoolean();
        this.playOnce = readBoolean;
        this.banner = (SMGameListBannerParent) parcel.readParcelable(SMGameListBannerParent.class.getClassLoader());
        this.icon = (SMIconListParent) parcel.readParcelable(SMIconListParent.class.getClassLoader());
    }
}
