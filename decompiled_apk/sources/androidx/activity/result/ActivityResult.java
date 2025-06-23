package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {

    @oOoXoXO
    private final Intent data;
    private final int resultCode;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    @XO
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: androidx.activity.result.ActivityResult$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult createFromParcel(Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new ActivityResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult[] newArray(int i) {
            return new ActivityResult[i];
        }
    };

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }

        @x0XOIxOo
        @OOXIXo
        public final String resultCodeToString(int i) {
            if (i != -1) {
                if (i != 0) {
                    return String.valueOf(i);
                }
                return "RESULT_CANCELED";
            }
            return "RESULT_OK";
        }

        private Companion() {
        }
    }

    public ActivityResult(int i, @oOoXoXO Intent intent) {
        this.resultCode = i;
        this.data = intent;
    }

    @x0XOIxOo
    @OOXIXo
    public static final String resultCodeToString(int i) {
        return Companion.resultCodeToString(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Intent getData() {
        return this.data;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    @OOXIXo
    public String toString() {
        return "ActivityResult{resultCode=" + Companion.resultCodeToString(this.resultCode) + ", data=" + this.data + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel dest, int i) {
        int i2;
        IIX0o.x0xO0oo(dest, "dest");
        dest.writeInt(this.resultCode);
        if (this.data == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        dest.writeInt(i2);
        Intent intent = this.data;
        if (intent != null) {
            intent.writeToParcel(dest, i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityResult(@OOXIXo Parcel parcel) {
        this(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
        IIX0o.x0xO0oo(parcel, "parcel");
    }
}
