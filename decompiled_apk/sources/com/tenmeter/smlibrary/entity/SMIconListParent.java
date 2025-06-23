package com.tenmeter.smlibrary.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class SMIconListParent implements Parcelable {
    public static final Parcelable.Creator<SMIconListParent> CREATOR = new Parcelable.Creator<SMIconListParent>() { // from class: com.tenmeter.smlibrary.entity.SMIconListParent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @RequiresApi(api = 29)
        public SMIconListParent createFromParcel(Parcel parcel) {
            return new SMIconListParent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMIconListParent[] newArray(int i) {
            return new SMIconListParent[i];
        }
    };
    private List<SMGameInfo> gameList;
    private int iconId;
    private String iconName;
    private int iconPage;
    private String iconPageTitle;
    private String iconUrl;
    private String tagDisplayName;
    private int tagId;
    private String tagName;

    public SMIconListParent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<SMGameInfo> getGameList() {
        return this.gameList;
    }

    public int getIconId() {
        return this.iconId;
    }

    public String getIconName() {
        return this.iconName;
    }

    public int getIconPage() {
        return this.iconPage;
    }

    public String getIconPageTitle() {
        return this.iconPageTitle;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTagDisplayName() {
        return this.tagDisplayName;
    }

    public int getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setGameList(List<SMGameInfo> list) {
        this.gameList = list;
    }

    public void setIconId(int i) {
        this.iconId = i;
    }

    public void setIconName(String str) {
        this.iconName = str;
    }

    public void setIconPage(int i) {
        this.iconPage = i;
    }

    public void setIconPageTitle(String str) {
        this.iconPageTitle = str;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setTagDisplayName(String str) {
        this.tagDisplayName = str;
    }

    public void setTagId(int i) {
        this.tagId = i;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    @Override // android.os.Parcelable
    @RequiresApi(api = 29)
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.gameList);
        parcel.writeInt(this.tagId);
        parcel.writeString(this.tagName);
        parcel.writeInt(this.iconId);
        parcel.writeString(this.iconName);
        parcel.writeInt(this.iconPage);
        parcel.writeString(this.tagDisplayName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.iconPageTitle);
    }

    @RequiresApi(api = 29)
    public SMIconListParent(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.gameList = arrayList;
        parcel.readTypedList(arrayList, SMGameInfo.CREATOR);
        this.tagId = parcel.readInt();
        this.tagName = parcel.readString();
        this.iconId = parcel.readInt();
        this.iconName = parcel.readString();
        this.iconPage = parcel.readInt();
        this.tagDisplayName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.iconPageTitle = parcel.readString();
    }
}
