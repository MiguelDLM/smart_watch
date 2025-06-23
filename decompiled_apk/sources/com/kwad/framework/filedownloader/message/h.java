package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: classes11.dex */
public abstract class h extends MessageSnapshot {

    /* loaded from: classes11.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i, boolean z, int i2) {
            super(i, true, i2);
        }
    }

    /* loaded from: classes11.dex */
    public static class e extends f {
        public e(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) -2;
        }
    }

    /* loaded from: classes11.dex */
    public static class f extends h {
        private final int air;
        private final int ais;

        public f(f fVar) {
            this(fVar.getId(), fVar.wC(), fVar.wD());
        }

        public byte uz() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wC() {
            return this.ais;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wD() {
            return this.air;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ais);
            parcel.writeInt(this.air);
        }

        public f(int i, int i2, int i3) {
            super(i);
            this.ais = i2;
            this.air = i3;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.ais = parcel.readInt();
            this.air = parcel.readInt();
        }
    }

    /* loaded from: classes11.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i, int i2, int i3) {
            super(i, i2, i3);
        }
    }

    /* loaded from: classes11.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot wI() {
            return new f(this);
        }

        public j(Parcel parcel) {
            super(parcel);
        }
    }

    public h(int i2) {
        super(i2);
        this.aih = false;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long wE() {
        return wD();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long wG() {
        return wC();
    }

    /* loaded from: classes11.dex */
    public static class g extends h {
        private final int ais;

        public g(int i, int i2) {
            super(i);
            this.ais = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wC() {
            return this.ais;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ais);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.ais = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0832h extends d {
        private final int ahK;

        public C0832h(int i, int i2, Throwable th, int i3) {
            super(i, i2, th);
            this.ahK = i3;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int uD() {
            return this.ahK;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahK);
        }

        public C0832h(Parcel parcel) {
            super(parcel);
            this.ahK = parcel.readInt();
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends h {
        private final boolean aic;
        private final int air;

        public b(int i, boolean z, int i2) {
            super(i);
            this.aic = z;
            this.air = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wD() {
            return this.air;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wF() {
            return this.aic;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aic ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.air);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.aic = parcel.readByte() != 0;
            this.air = parcel.readInt();
        }
    }

    /* loaded from: classes11.dex */
    public static class d extends h {
        private final Throwable aig;
        private final int ais;

        public d(int i, int i2, Throwable th) {
            super(i);
            this.ais = i2;
            this.aig = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte uz() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wC() {
            return this.ais;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable wH() {
            return this.aig;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ais);
            parcel.writeSerializable(this.aig);
        }

        public d(Parcel parcel) {
            super(parcel);
            this.ais = parcel.readInt();
            this.aig = (Throwable) parcel.readSerializable();
        }
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: classes11.dex */
    public static class c extends h {
        private final String agz;
        private final boolean aid;
        private final String aie;
        private final int air;

        public c(int i, boolean z, int i2, String str, String str2) {
            super(i);
            this.aid = z;
            this.air = i2;
            this.agz = str;
            this.aie = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.agz;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.aie;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wD() {
            return this.air;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aid ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.air);
            parcel.writeString(this.agz);
            parcel.writeString(this.aie);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wu() {
            return this.aid;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.aid = parcel.readByte() != 0;
            this.air = parcel.readInt();
            this.agz = parcel.readString();
            this.aie = parcel.readString();
        }
    }
}
