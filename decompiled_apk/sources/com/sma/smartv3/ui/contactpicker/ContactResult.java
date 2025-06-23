package com.sma.smartv3.ui.contactpicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class ContactResult implements Parcelable {
    public static final Parcelable.Creator<ContactResult> CREATOR = new Parcelable.Creator<ContactResult>() { // from class: com.sma.smartv3.ui.contactpicker.ContactResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactResult createFromParcel(Parcel in) {
            return new ContactResult(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactResult[] newArray(int size) {
            return new ContactResult[size];
        }
    };
    private String mContactID;
    private String mDisplayName;
    private List<String> mEmails;
    private String mItemGroups;
    private List<PhoneNumber> mPhoneNumbers;
    private String mPhoto;
    private boolean mStarred;
    private String mThumbnail;

    public ContactResult(Contact contact) {
        this.mEmails = new ArrayList();
        this.mPhoneNumbers = new ArrayList();
        this.mItemGroups = "";
        this.mContactID = String.valueOf(contact.getId());
        this.mDisplayName = contact.getDisplayName();
        this.mStarred = contact.isStarred();
        this.mPhoto = String.valueOf(contact.getPhoto());
        this.mThumbnail = String.valueOf(contact.getThumbnail());
        this.mEmails.clear();
        this.mEmails.addAll(contact.getEmails());
        this.mPhoneNumbers.clear();
        this.mPhoneNumbers.addAll(contact.getPhoneNumbers());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContactID() {
        return this.mContactID;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public List<String> getEmails() {
        return this.mEmails;
    }

    public String getItemGroups() {
        return this.mItemGroups;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.mPhoneNumbers;
    }

    public String getPhoto() {
        return this.mPhoto;
    }

    public String getThumbnail() {
        return this.mThumbnail;
    }

    public boolean isStarred() {
        return this.mStarred;
    }

    public void setContactID(String mContactID) {
        this.mContactID = mContactID;
    }

    public void setDisplayName(String mDisplayName) {
        this.mDisplayName = mDisplayName;
    }

    public void setItemGroups(String itemGroups) {
        this.mItemGroups = itemGroups;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumbers.get(0).setNumber(phoneNumber);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mContactID);
        parcel.writeString(this.mDisplayName);
        parcel.writeByte(this.mStarred ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mPhoto);
        parcel.writeString(this.mThumbnail);
        parcel.writeStringList(this.mEmails);
        parcel.writeTypedList(this.mPhoneNumbers);
    }

    public ContactResult(Parcel in) {
        this.mEmails = new ArrayList();
        this.mPhoneNumbers = new ArrayList();
        this.mItemGroups = "";
        this.mContactID = in.readString();
        this.mDisplayName = in.readString();
        this.mStarred = in.readByte() != 0;
        this.mPhoto = in.readString();
        this.mThumbnail = in.readString();
        this.mEmails = in.createStringArrayList();
        in.readTypedList(this.mPhoneNumbers, PhoneNumber.CREATOR);
    }
}
