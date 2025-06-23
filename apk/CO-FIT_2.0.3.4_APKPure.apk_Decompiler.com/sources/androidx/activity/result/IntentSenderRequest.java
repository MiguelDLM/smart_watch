package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XxI.I0Io;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    @XO
    @OOXIXo
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest$Companion$CREATOR$1();
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @oOoXoXO
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    @OOXIXo
    private final IntentSender intentSender;

    public static final class Builder {
        @oOoXoXO
        private Intent fillInIntent;
        private int flagsMask;
        private int flagsValues;
        @OOXIXo
        private final IntentSender intentSender;

        @I0Io(AnnotationRetention.SOURCE)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Flag {
        }

        public Builder(@OOXIXo IntentSender intentSender2) {
            IIX0o.x0xO0oo(intentSender2, "intentSender");
            this.intentSender = intentSender2;
        }

        @OOXIXo
        public final IntentSenderRequest build() {
            return new IntentSenderRequest(this.intentSender, this.fillInIntent, this.flagsMask, this.flagsValues);
        }

        @OOXIXo
        public final Builder setFillInIntent(@oOoXoXO Intent intent) {
            this.fillInIntent = intent;
            return this;
        }

        @OOXIXo
        public final Builder setFlags(int i, int i2) {
            this.flagsValues = i;
            this.flagsMask = i2;
            return this;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Builder(@OXOo.OOXIXo android.app.PendingIntent r2) {
            /*
                r1 = this;
                java.lang.String r0 = "pendingIntent"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                android.content.IntentSender r2 = r2.getIntentSender()
                java.lang.String r0 = "pendingIntent.intentSender"
                kotlin.jvm.internal.IIX0o.oO(r2, r0)
                r1.<init>((android.content.IntentSender) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.Builder.<init>(android.app.PendingIntent):void");
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        private Companion() {
        }
    }

    public IntentSenderRequest(@OOXIXo IntentSender intentSender2, @oOoXoXO Intent intent, int i, int i2) {
        IIX0o.x0xO0oo(intentSender2, "intentSender");
        this.intentSender = intentSender2;
        this.fillInIntent = intent;
        this.flagsMask = i;
        this.flagsValues = i2;
    }

    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    @OOXIXo
    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    public void writeToParcel(@OOXIXo Parcel parcel, int i) {
        IIX0o.x0xO0oo(parcel, "dest");
        parcel.writeParcelable(this.intentSender, i);
        parcel.writeParcelable(this.fillInIntent, i);
        parcel.writeInt(this.flagsMask);
        parcel.writeInt(this.flagsValues);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntentSenderRequest(IntentSender intentSender2, Intent intent, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(intentSender2, (i3 & 2) != 0 ? null : intent, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntentSenderRequest(@OXOo.OOXIXo android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.<init>(android.os.Parcel):void");
    }
}
