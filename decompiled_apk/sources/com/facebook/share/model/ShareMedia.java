package com.facebook.share.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Builder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public abstract class ShareMedia<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModel {

    @OOXIXo
    private final Bundle params;

    /* loaded from: classes8.dex */
    public static abstract class Builder<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        private Bundle params = new Bundle();

        /* loaded from: classes8.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OOXIXo
            public final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(@OOXIXo Parcel parcel) {
                IIX0o.x0xO0oo(parcel, "parcel");
                Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
                if (readParcelableArray == null) {
                    return CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : readParcelableArray) {
                    if (parcelable instanceof ShareMedia) {
                        arrayList.add(parcelable);
                    }
                }
                return arrayList;
            }

            @x0XOIxOo
            public final void writeListTo$facebook_common_release(@OOXIXo Parcel out, int i, @OOXIXo List<? extends ShareMedia<?, ?>> media) {
                IIX0o.x0xO0oo(out, "out");
                IIX0o.x0xO0oo(media, "media");
                Object[] array = media.toArray(new ShareMedia[0]);
                if (array != null) {
                    out.writeParcelableArray((Parcelable[]) array, i);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }

            private Companion() {
            }
        }

        @OOXIXo
        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        @kotlin.OOXIXo(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        @OOXIXo
        public final B setParameter(@OOXIXo String key, @OOXIXo String value) {
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            this.params.putString(key, value);
            return this;
        }

        @kotlin.OOXIXo(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
        @OOXIXo
        public final B setParameters(@OOXIXo Bundle parameters) {
            IIX0o.x0xO0oo(parameters, "parameters");
            this.params.putAll(parameters);
            return this;
        }

        public final void setParams$facebook_common_release(@OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(bundle, "<set-?>");
            this.params = bundle;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public B readFrom(@oOoXoXO M m) {
            return m == null ? this : setParameters(((ShareMedia) m).params);
        }
    }

    /* loaded from: classes8.dex */
    public enum Type {
        PHOTO,
        VIDEO;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] valuesCustom = values();
            return (Type[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public ShareMedia(@OOXIXo Builder<M, B> builder) {
        IIX0o.x0xO0oo(builder, "builder");
        this.params = new Bundle(builder.getParams$facebook_common_release());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @OOXIXo
    public abstract Type getMediaType();

    @kotlin.OOXIXo(message = "This method is deprecated. Use GraphRequest directly to set parameters.")
    @OOXIXo
    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeBundle(this.params);
    }

    public ShareMedia(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "parcel");
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        this.params = readBundle == null ? new Bundle() : readBundle;
    }
}
