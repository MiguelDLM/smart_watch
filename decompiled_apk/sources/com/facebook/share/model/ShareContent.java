package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;
import com.facebook.share.model.ShareHashtag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class ShareContent<M extends ShareContent<M, B>, B extends Builder<M, B>> implements ShareModel {

    @oOoXoXO
    private final Uri contentUrl;

    @oOoXoXO
    private final String pageId;

    @oOoXoXO
    private final List<String> peopleIds;

    @oOoXoXO
    private final String placeId;

    @oOoXoXO
    private final String ref;

    @oOoXoXO
    private final ShareHashtag shareHashtag;

    /* loaded from: classes8.dex */
    public static abstract class Builder<M extends ShareContent<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {

        @oOoXoXO
        private Uri contentUrl;

        @oOoXoXO
        private ShareHashtag hashtag;

        @oOoXoXO
        private String pageId;

        @oOoXoXO
        private List<String> peopleIds;

        @oOoXoXO
        private String placeId;

        @oOoXoXO
        private String ref;

        @oOoXoXO
        public final Uri getContentUrl$facebook_common_release() {
            return this.contentUrl;
        }

        @oOoXoXO
        public final ShareHashtag getHashtag$facebook_common_release() {
            return this.hashtag;
        }

        @oOoXoXO
        public final String getPageId$facebook_common_release() {
            return this.pageId;
        }

        @oOoXoXO
        public final List<String> getPeopleIds$facebook_common_release() {
            return this.peopleIds;
        }

        @oOoXoXO
        public final String getPlaceId$facebook_common_release() {
            return this.placeId;
        }

        @oOoXoXO
        public final String getRef$facebook_common_release() {
            return this.ref;
        }

        @OOXIXo
        public final B setContentUrl(@oOoXoXO Uri uri) {
            this.contentUrl = uri;
            return this;
        }

        public final void setContentUrl$facebook_common_release(@oOoXoXO Uri uri) {
            this.contentUrl = uri;
        }

        public final void setHashtag$facebook_common_release(@oOoXoXO ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
        }

        @OOXIXo
        public final B setPageId(@oOoXoXO String str) {
            this.pageId = str;
            return this;
        }

        public final void setPageId$facebook_common_release(@oOoXoXO String str) {
            this.pageId = str;
        }

        @OOXIXo
        public final B setPeopleIds(@oOoXoXO List<String> list) {
            List<String> unmodifiableList;
            if (list == null) {
                unmodifiableList = null;
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.peopleIds = unmodifiableList;
            return this;
        }

        public final void setPeopleIds$facebook_common_release(@oOoXoXO List<String> list) {
            this.peopleIds = list;
        }

        @OOXIXo
        public final B setPlaceId(@oOoXoXO String str) {
            this.placeId = str;
            return this;
        }

        public final void setPlaceId$facebook_common_release(@oOoXoXO String str) {
            this.placeId = str;
        }

        @OOXIXo
        public final B setRef(@oOoXoXO String str) {
            this.ref = str;
            return this;
        }

        public final void setRef$facebook_common_release(@oOoXoXO String str) {
            this.ref = str;
        }

        @OOXIXo
        public final B setShareHashtag(@oOoXoXO ShareHashtag shareHashtag) {
            this.hashtag = shareHashtag;
            return this;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public B readFrom(@oOoXoXO M m) {
            return m == null ? this : (B) setContentUrl(m.getContentUrl()).setPeopleIds(m.getPeopleIds()).setPlaceId(m.getPlaceId()).setPageId(m.getPageId()).setRef(m.getRef()).setShareHashtag(m.getShareHashtag());
        }
    }

    public ShareContent(@OOXIXo Builder<M, B> builder) {
        IIX0o.x0xO0oo(builder, "builder");
        this.contentUrl = builder.getContentUrl$facebook_common_release();
        this.peopleIds = builder.getPeopleIds$facebook_common_release();
        this.placeId = builder.getPlaceId$facebook_common_release();
        this.pageId = builder.getPageId$facebook_common_release();
        this.ref = builder.getRef$facebook_common_release();
        this.shareHashtag = builder.getHashtag$facebook_common_release();
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    @oOoXoXO
    public final String getPageId() {
        return this.pageId;
    }

    @oOoXoXO
    public final List<String> getPeopleIds() {
        return this.peopleIds;
    }

    @oOoXoXO
    public final String getPlaceId() {
        return this.placeId;
    }

    @oOoXoXO
    public final String getRef() {
        return this.ref;
    }

    @oOoXoXO
    public final ShareHashtag getShareHashtag() {
        return this.shareHashtag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeParcelable(this.contentUrl, 0);
        out.writeStringList(this.peopleIds);
        out.writeString(this.placeId);
        out.writeString(this.pageId);
        out.writeString(this.ref);
        out.writeParcelable(this.shareHashtag, 0);
    }

    public ShareContent(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        this.contentUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.peopleIds = readUnmodifiableStringList(parcel);
        this.placeId = parcel.readString();
        this.pageId = parcel.readString();
        this.ref = parcel.readString();
        this.shareHashtag = new ShareHashtag.Builder().readFrom$facebook_common_release(parcel).build();
    }
}
