package com.tenmeter.smlibrary.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class SMGameListParent implements Parcelable {
    public static final Parcelable.Creator<SMGameListParent> CREATOR = new Parcelable.Creator<SMGameListParent>() { // from class: com.tenmeter.smlibrary.entity.SMGameListParent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @RequiresApi(api = 29)
        public SMGameListParent createFromParcel(Parcel parcel) {
            return new SMGameListParent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SMGameListParent[] newArray(int i) {
            return new SMGameListParent[i];
        }
    };
    private List<SMGameInfo> gameList;
    private int tagId;
    private String tagName;

    public SMGameListParent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<SMGameInfo> getGameList() {
        return this.gameList;
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
    }

    @RequiresApi(api = 29)
    public SMGameListParent(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.gameList = arrayList;
        parcel.readTypedList(arrayList, SMGameInfo.CREATOR);
        this.tagId = parcel.readInt();
        this.tagName = parcel.readString();
    }
}
