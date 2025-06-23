package androidx.navigation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@SuppressLint({"BanParcelableUsage"})
@XX({"SMAP\nNavBackStackEntryState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavBackStackEntryState.kt\nandroidx/navigation/NavBackStackEntryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class NavBackStackEntryState implements Parcelable {
    @XO
    @OOXIXo
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new NavBackStackEntryState$Companion$CREATOR$1();
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @oOoXoXO
    private final Bundle args;
    private final int destinationId;
    @OOXIXo
    private final String id;
    @OOXIXo
    private final Bundle savedState;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public NavBackStackEntryState(@OOXIXo NavBackStackEntry navBackStackEntry) {
        IIX0o.x0xO0oo(navBackStackEntry, "entry");
        this.id = navBackStackEntry.getId();
        this.destinationId = navBackStackEntry.getDestination().getId();
        this.args = navBackStackEntry.getArguments();
        Bundle bundle = new Bundle();
        this.savedState = bundle;
        navBackStackEntry.saveState(bundle);
    }

    public int describeContents() {
        return 0;
    }

    @oOoXoXO
    public final Bundle getArgs() {
        return this.args;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    @OOXIXo
    public final String getId() {
        return this.id;
    }

    @OOXIXo
    public final Bundle getSavedState() {
        return this.savedState;
    }

    @OOXIXo
    public final NavBackStackEntry instantiate(@OOXIXo Context context, @OOXIXo NavDestination navDestination, @OOXIXo Lifecycle.State state, @oOoXoXO NavControllerViewModel navControllerViewModel) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(navDestination, "destination");
        IIX0o.x0xO0oo(state, "hostLifecycleState");
        Bundle bundle = this.args;
        if (bundle != null) {
            bundle.setClassLoader(context.getClassLoader());
        } else {
            bundle = null;
        }
        return NavBackStackEntry.Companion.create(context, navDestination, bundle, state, navControllerViewModel, this.id, this.savedState);
    }

    public void writeToParcel(@OOXIXo Parcel parcel, int i) {
        IIX0o.x0xO0oo(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.destinationId);
        parcel.writeBundle(this.args);
        parcel.writeBundle(this.savedState);
    }

    public NavBackStackEntryState(@OOXIXo Parcel parcel) {
        IIX0o.x0xO0oo(parcel, "inParcel");
        String readString = parcel.readString();
        IIX0o.ooOOo0oXI(readString);
        this.id = readString;
        this.destinationId = parcel.readInt();
        Class<NavBackStackEntryState> cls = NavBackStackEntryState.class;
        this.args = parcel.readBundle(cls.getClassLoader());
        Bundle readBundle = parcel.readBundle(cls.getClassLoader());
        IIX0o.ooOOo0oXI(readBundle);
        this.savedState = readBundle;
    }
}
