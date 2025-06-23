package com.facebook.gamingservices;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.media.Image;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.parser.deserializer.xoIox;
import com.facebook.gamingservices.internal.DateFormatter;
import com.facebook.gamingservices.internal.TournamentScoreType;
import com.facebook.gamingservices.internal.TournamentSortOrder;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.time.Instant;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class TournamentConfig implements ShareModel {

    @OOXIXo
    public static final CREATOR CREATOR = new CREATOR(null);

    @oOoXoXO
    private final Instant endTime;

    @oOoXoXO
    private final Image image;

    @oOoXoXO
    private final String payload;

    @oOoXoXO
    private final TournamentScoreType scoreType;

    @oOoXoXO
    private final TournamentSortOrder sortOrder;

    @oOoXoXO
    private final String title;

    /* loaded from: classes8.dex */
    public static final class Builder implements ShareModelBuilder<TournamentConfig, Builder> {

        @oOoXoXO
        private Instant endTime;

        @oOoXoXO
        private Image image;

        @oOoXoXO
        private String payload;

        @oOoXoXO
        private TournamentScoreType scoreType;

        @oOoXoXO
        private TournamentSortOrder sortOrder;

        @oOoXoXO
        private String title;

        @oOoXoXO
        public final Instant getEndTime() {
            return this.endTime;
        }

        @oOoXoXO
        public final Image getImage() {
            return this.image;
        }

        @oOoXoXO
        public final String getPayload() {
            return this.payload;
        }

        @oOoXoXO
        public final TournamentScoreType getScoreType() {
            return this.scoreType;
        }

        @oOoXoXO
        public final TournamentSortOrder getSortOrder() {
            return this.sortOrder;
        }

        @oOoXoXO
        public final String getTitle() {
            return this.title;
        }

        @OOXIXo
        public final Builder readFrom$facebook_gamingservices_release(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return readFrom((TournamentConfig) parcel.readParcelable(TournamentConfig.class.getClassLoader()));
        }

        public final void setEndTime(@oOoXoXO Instant instant) {
            this.endTime = instant;
        }

        public final void setImage(@oOoXoXO Image image) {
            this.image = image;
        }

        public final void setPayload(@oOoXoXO String str) {
            this.payload = str;
        }

        public final void setScoreType(@oOoXoXO TournamentScoreType tournamentScoreType) {
            this.scoreType = tournamentScoreType;
        }

        public final void setSortOrder(@oOoXoXO TournamentSortOrder tournamentSortOrder) {
            this.sortOrder = tournamentSortOrder;
        }

        public final void setTitle(@oOoXoXO String str) {
            this.title = str;
        }

        @OOXIXo
        public final Builder setTournamentEndTime(@OOXIXo Instant endTime) {
            IIX0o.x0xO0oo(endTime, "endTime");
            this.endTime = endTime;
            return this;
        }

        @OOXIXo
        public final Builder setTournamentImage(@oOoXoXO Image image) {
            this.image = image;
            return this;
        }

        @OOXIXo
        public final Builder setTournamentPayload(@oOoXoXO String str) {
            this.payload = str;
            return this;
        }

        @OOXIXo
        public final Builder setTournamentScoreType(@OOXIXo TournamentScoreType scoreType) {
            IIX0o.x0xO0oo(scoreType, "scoreType");
            this.scoreType = scoreType;
            return this;
        }

        @OOXIXo
        public final Builder setTournamentSortOrder(@OOXIXo TournamentSortOrder sortOrder) {
            IIX0o.x0xO0oo(sortOrder, "sortOrder");
            this.sortOrder = sortOrder;
            return this;
        }

        @OOXIXo
        public final Builder setTournamentTitle(@oOoXoXO String str) {
            this.title = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @OOXIXo
        public TournamentConfig build() {
            return new TournamentConfig(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        @OOXIXo
        public Builder readFrom(@oOoXoXO TournamentConfig tournamentConfig) {
            if (tournamentConfig == null) {
                return this;
            }
            TournamentSortOrder sortOrder = tournamentConfig.getSortOrder();
            if (sortOrder != null) {
                setTournamentSortOrder(sortOrder);
            }
            TournamentScoreType scoreType = tournamentConfig.getScoreType();
            if (scoreType != null) {
                setTournamentScoreType(scoreType);
            }
            Instant endTime = tournamentConfig.getEndTime();
            if (endTime != null) {
                setTournamentEndTime(endTime);
            }
            String title = tournamentConfig.getTitle();
            if (title != null) {
                setTournamentTitle(title);
            }
            setTournamentPayload(tournamentConfig.getPayload());
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static final class CREATOR implements Parcelable.Creator<TournamentConfig> {
        public /* synthetic */ CREATOR(IIXOooo iIXOooo) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public TournamentConfig createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new TournamentConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public TournamentConfig[] newArray(int i) {
            return new TournamentConfig[i];
        }
    }

    public /* synthetic */ TournamentConfig(Builder builder, IIXOooo iIXOooo) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Instant getEndTime() {
        return this.endTime;
    }

    @oOoXoXO
    public final Image getImage() {
        return this.image;
    }

    @oOoXoXO
    public final String getPayload() {
        return this.payload;
    }

    @oOoXoXO
    public final TournamentScoreType getScoreType() {
        return this.scoreType;
    }

    @oOoXoXO
    public final TournamentSortOrder getSortOrder() {
        return this.sortOrder;
    }

    @oOoXoXO
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel out, int i) {
        IIX0o.x0xO0oo(out, "out");
        out.writeString(String.valueOf(this.sortOrder));
        out.writeString(String.valueOf(this.scoreType));
        out.writeString(String.valueOf(this.endTime));
        out.writeString(this.title);
        out.writeString(this.payload);
    }

    private TournamentConfig(Builder builder) {
        this.title = builder.getTitle();
        this.sortOrder = builder.getSortOrder();
        this.scoreType = builder.getScoreType();
        this.endTime = builder.getEndTime();
        this.image = builder.getImage();
        this.payload = builder.getPayload();
    }

    public TournamentConfig(@OOXIXo Parcel parcel) {
        TournamentSortOrder tournamentSortOrder;
        TournamentScoreType tournamentScoreType;
        Instant oIX0oI2;
        IIX0o.x0xO0oo(parcel, "parcel");
        this.title = parcel.readString();
        TournamentSortOrder[] valuesCustom = TournamentSortOrder.valuesCustom();
        int length = valuesCustom.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                tournamentSortOrder = null;
                break;
            }
            tournamentSortOrder = valuesCustom[i2];
            if (IIX0o.Oxx0IOOO(tournamentSortOrder.name(), parcel.readString())) {
                break;
            } else {
                i2++;
            }
        }
        this.sortOrder = tournamentSortOrder;
        TournamentScoreType[] valuesCustom2 = TournamentScoreType.valuesCustom();
        int length2 = valuesCustom2.length;
        while (true) {
            if (i >= length2) {
                tournamentScoreType = null;
                break;
            }
            tournamentScoreType = valuesCustom2[i];
            if (IIX0o.Oxx0IOOO(tournamentScoreType.name(), parcel.readString())) {
                break;
            } else {
                i++;
            }
        }
        this.scoreType = tournamentScoreType;
        if (Build.VERSION.SDK_INT >= 26) {
            oIX0oI2 = Instant.from(xoIox.oIX0oI(DateFormatter.INSTANCE.format$facebook_gamingservices_release(parcel.readString())));
        } else {
            oIX0oI2 = X0o0xo.oIX0oI(null);
        }
        this.endTime = oIX0oI2;
        this.payload = parcel.readString();
        this.image = null;
    }
}
