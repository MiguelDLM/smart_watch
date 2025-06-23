package com.sifli.siflidfu;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* loaded from: classes11.dex */
public class DFUImagePath implements Parcelable {
    public static final Parcelable.Creator<DFUImagePath> CREATOR = new Parcelable.Creator<DFUImagePath>() { // from class: com.sifli.siflidfu.DFUImagePath.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DFUImagePath createFromParcel(Parcel parcel) {
            return new DFUImagePath(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DFUImagePath[] newArray(int i) {
            return new DFUImagePath[i];
        }
    };
    private String imagePath;
    private int imageType;
    private Uri imageUri;

    public DFUImagePath(String str, Uri uri, int i) {
        this.imagePath = str;
        this.imageUri = uri;
        this.imageType = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public int getImageType() {
        return this.imageType;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.imagePath);
        parcel.writeParcelable(this.imageUri, i);
        parcel.writeInt(this.imageType);
    }

    public DFUImagePath(Parcel parcel) {
        this.imagePath = parcel.readString();
        this.imageUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.imageType = parcel.readInt();
    }
}
