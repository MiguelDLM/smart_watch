package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes11.dex */
public interface a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0855a implements a {
        private final IBinder ayv;

        public C0855a(IBinder iBinder) {
            this.ayv = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.ayv;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.ayv.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception unused) {
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }
    }
}
