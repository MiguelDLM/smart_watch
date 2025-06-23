package com.facebook.gamingservices;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.gson.annotations.SerializedName;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class Tournament implements ShareModel {

    @OOXIXo
    public static final CREATOR CREATOR = new CREATOR(null);

    @SerializedName("tournament_end_time")
    @XO0OX.XO
    @oOoXoXO
    public String endTime;

    @SerializedName("id")
    @OOXIXo
    @XO0OX.XO
    public final String identifier;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_PAYLOAD)
    @XO0OX.XO
    @oOoXoXO
    public final String payload;

    @SerializedName(SDKConstants.PARAM_TOURNAMENTS_TITLE)
    @XO0OX.XO
    @oOoXoXO
    public final String title;

    /* loaded from: classes8.dex */
    public static final class Builder implements ShareModelBuilder<Tournament, Builder> {

        @oOoXoXO
        private String endTime;

        @oOoXoXO
        private ZonedDateTime expiration;

        @OOXIXo
        private String identifier;

        @oOoXoXO
        private String payload;

        @oOoXoXO
        private String title;

        public Builder(@OOXIXo String identifier, @oOoXoXO ZonedDateTime zonedDateTime, @oOoXoXO String str, @oOoXoXO String str2) {
            IIX0o.x0xO0oo(identifier, "identifier");
            this.identifier = identifier;
            this.expiration = zonedDateTime;
            this.title = str;
            this.payload = str2;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, ZonedDateTime zonedDateTime, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.identifier;
            }
            if ((i & 2) != 0) {
                zonedDateTime = builder.expiration;
            }
            if ((i & 4) != 0) {
                str2 = builder.title;
            }
            if ((i & 8) != 0) {
                str3 = builder.payload;
            }
            return builder.copy(str, zonedDateTime, str2, str3);
        }

        @OOXIXo
        public final String component1() {
            return this.identifier;
        }

        @oOoXoXO
        public final ZonedDateTime component2() {
            return this.expiration;
        }

        @oOoXoXO
        public final String component3() {
            return this.title;
        }

        @oOoXoXO
        public final String component4() {
            return this.payload;
        }

        @OOXIXo
        public final Builder copy(@OOXIXo String identifier, @oOoXoXO ZonedDateTime zonedDateTime, @oOoXoXO String str, @oOoXoXO String str2) {
            IIX0o.x0xO0oo(identifier, "identifier");
            return new Builder(identifier, zonedDateTime, str, str2);
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return IIX0o.Oxx0IOOO(this.identifier, builder.identifier) && IIX0o.Oxx0IOOO(this.expiration, builder.expiration) && IIX0o.Oxx0IOOO(this.title, builder.title) && IIX0o.Oxx0IOOO(this.payload, builder.payload);
        }

        @OOXIXo
        public final Builder expiration(@oOoXoXO ZonedDateTime zonedDateTime) {
            DateTimeFormatter dateTimeFormatter;
            String format;
            setExpiration(zonedDateTime);
            if (Build.VERSION.SDK_INT >= 26 && zonedDateTime != null) {
                dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
                format = zonedDateTime.format(dateTimeFormatter);
                setEndTime(format);
            }
            return this;
        }

        @oOoXoXO
        public final String getEndTime() {
            return this.endTime;
        }

        @oOoXoXO
        public final ZonedDateTime getExpiration() {
            return this.expiration;
        }

        @OOXIXo
        public final String getIdentifier() {
            return this.identifier;
        }

        @oOoXoXO
        public final String getPayload() {
            return this.payload;
        }

        @oOoXoXO
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode = this.identifier.hashCode() * 31;
            ZonedDateTime zonedDateTime = this.expiration;
            int hashCode2 = (hashCode + (zonedDateTime == null ? 0 : zonedDateTime.hashCode())) * 31;
            String str = this.title;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.payload;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        @OOXIXo
        public final Builder identifier(@OOXIXo String identifier) {
            IIX0o.x0xO0oo(identifier, "identifier");
            setIdentifier(identifier);
            return this;
        }

        @OOXIXo
        public final Builder payload(@oOoXoXO String str) {
            setPayload(str);
            return this;
        }

        public final void setEndTime(@oOoXoXO String str) {
            this.endTime = str;
        }

        public final void setExpiration(@oOoXoXO ZonedDateTime zonedDateTime) {
            this.expiration = zonedDateTime;
        }

        public final void setIdentifier(@OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.identifier = str;
        }

        public final void setPayload(@oOoXoXO String str) {
            this.payload = str;
        }

        public final void setTitle(@oOoXoXO String str) {
            this.title = str;
        }

        @OOXIXo
        public final Builder title(@oOoXoXO String str) {
            setTitle(str);
            return this;
        }

        @OOXIXo
        public String toString() {
            return "Builder(identifier=" + this.identifier + ", expiration=" + this.expiration + ", title=" + ((Object) this.title) + ", payload=" + ((Object) this.payload) + HexStringBuilder.COMMENT_END_CHAR;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public Tournament build() {
            return new Tournament(this.identifier, this.endTime, this.title, this.payload);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO Tournament tournament) {
            Builder payload = tournament == null ? null : identifier(tournament.identifier).expiration(tournament.getExpiration()).title(tournament.title).payload(tournament.payload);
            return payload == null ? this : payload;
        }

        public /* synthetic */ Builder(String str, ZonedDateTime zonedDateTime, String str2, String str3, int i, IIXOooo iIXOooo) {
            this(str, (i & 2) != 0 ? null : zonedDateTime, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }
    }

    /* loaded from: classes8.dex */
    public static final class CREATOR implements Parcelable.Creator<Tournament> {
        public /* synthetic */ CREATOR(IIXOooo iIXOooo) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public Tournament createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new Tournament(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public Tournament[] newArray(int i) {
            return new Tournament[i];
        }
    }

    public Tournament(@OOXIXo String identifier, @oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO String str3) {
        IIX0o.x0xO0oo(identifier, "identifier");
        this.identifier = identifier;
        this.endTime = str;
        this.title = str2;
        this.payload = str3;
        setExpiration(DateFormatter.INSTANCE.format$facebook_gamingservices_release(str));
    }

    private final void setExpiration(ZonedDateTime zonedDateTime) {
        DateTimeFormatter dateTimeFormatter;
        String format;
        if (Build.VERSION.SDK_INT >= 26 && zonedDateTime != null) {
            dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
            format = zonedDateTime.format(dateTimeFormatter);
            this.endTime = format;
            setExpiration(zonedDateTime);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final ZonedDateTime getExpiration() {
        return DateFormatter.INSTANCE.format$facebook_gamingservices_release(this.endTime);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeString(this.identifier);
        out.writeString(this.endTime);
        out.writeString(this.title);
        out.writeString(this.payload);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Tournament(@OOXIXo Parcel parcel) {
        this(parcel.toString(), parcel.toString(), parcel.toString(), parcel.toString());
        IIX0o.x0xO0oo(parcel, "parcel");
    }
}
