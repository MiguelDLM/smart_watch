package com.sma.smartv3.ui.contactpicker;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class Contact implements Comparable<Contact> {
    private int backgroundColor;
    private boolean isSelected;
    private String mDisplayName;
    private final long mId;
    private int mInVisibleGroup;
    private Uri mPhoto;
    private boolean mStarred;
    private Uri mThumbnail;
    private List<String> mEmails = new ArrayList();
    private List<PhoneNumber> mPhoneNumbers = new ArrayList();

    public Contact(long id) {
        this.backgroundColor = -16776961;
        this.mId = id;
        this.backgroundColor = ColorUtils.getRandomMaterialColor();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass() && this.mId == ((Contact) o).mId) {
            return true;
        }
        return false;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public List<String> getEmails() {
        return this.mEmails;
    }

    public long getId() {
        return this.mId;
    }

    public int getInVisibleGroup() {
        return this.mInVisibleGroup;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.mPhoneNumbers;
    }

    public Uri getPhoto() {
        return this.mPhoto;
    }

    public Uri getThumbnail() {
        return this.mThumbnail;
    }

    public int hashCode() {
        long j = this.mId;
        return (int) (j ^ (j >>> 32));
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isStarred() {
        return this.mStarred;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setDisplayName(String displayName) {
        this.mDisplayName = displayName;
    }

    public void setEmails(List<String> emails) {
        this.mEmails = emails;
    }

    public void setInVisibleGroup(int inVisibleGroup) {
        this.mInVisibleGroup = inVisibleGroup;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.mPhoneNumbers = phoneNumbers;
    }

    public void setPhoto(Uri photo) {
        this.mPhoto = photo;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }

    public void setStarred(boolean starred) {
        this.mStarred = starred;
    }

    public void setThumbnail(Uri thumbnail) {
        this.mThumbnail = thumbnail;
    }

    @Override // java.lang.Comparable
    public int compareTo(Contact other) {
        String str;
        String str2 = this.mDisplayName;
        if (str2 == null || (str = other.mDisplayName) == null) {
            return -1;
        }
        return str2.compareTo(str);
    }
}
