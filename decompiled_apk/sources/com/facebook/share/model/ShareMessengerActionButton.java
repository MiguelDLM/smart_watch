package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Parcel;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class ShareMessengerActionButton implements ShareModel {

    @oOoXoXO
    private final String title;

    /* loaded from: classes8.dex */
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {

        @oOoXoXO
        private String title;

        @oOoXoXO
        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        @OOXIXo
        public final B setTitle(@oOoXoXO String str) {
            this.title = str;
            return this;
        }

        public final void setTitle$facebook_common_release(@oOoXoXO String str) {
            this.title = str;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public B readFrom(@oOoXoXO M m) {
            return m == null ? this : setTitle(m.getTitle());
        }
    }

    public ShareMessengerActionButton(@OOXIXo Builder<?, ?> builder) {
        IIX0o.x0xO0oo(builder, "builder");
        this.title = builder.getTitle$facebook_common_release();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeString(this.title);
    }

    public ShareMessengerActionButton(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        this.title = parcel.readString();
    }
}
