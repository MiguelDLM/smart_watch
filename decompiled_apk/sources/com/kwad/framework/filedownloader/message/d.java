package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: classes11.dex */
public abstract class d extends MessageSnapshot {

    /* loaded from: classes11.dex */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i, boolean z, long j) {
            super(i, true, j);
        }
    }

    /* loaded from: classes11.dex */
    public static class e extends f {
        public e(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) -2;
        }
    }

    /* loaded from: classes11.dex */
    public static class f extends d {
        private final long aif;
        private final long totalBytes;

        public f(f fVar) {
            this(fVar.getId(), fVar.wG(), fVar.wE());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte uz() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wE() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long wG() {
            return this.aif;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aif);
            parcel.writeLong(this.totalBytes);
        }

        public f(int i, long j, long j2) {
            super(i);
            this.aif = j;
            this.totalBytes = j2;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.aif = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    /* loaded from: classes11.dex */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i, long j, long j2) {
            super(i, j, j2);
        }
    }

    /* loaded from: classes11.dex */
    public static class j extends f implements MessageSnapshot.a {
        public j(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
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

    public d(int i2) {
        super(i2);
        this.aih = true;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int wC() {
        if (wG() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) wG();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int wD() {
        if (wE() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) wE();
    }

    /* loaded from: classes11.dex */
    public static class g extends d {
        private final long aif;

        public g(int i, long j) {
            super(i);
            this.aif = j;
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
        public final long wG() {
            return this.aif;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aif);
        }

        public g(Parcel parcel) {
            super(parcel);
            this.aif = parcel.readLong();
        }
    }

    /* loaded from: classes11.dex */
    public static class h extends C0831d {
        private final int ahK;

        public h(int i, long j, Throwable th, int i2) {
            super(i, j, th);
            this.ahK = i2;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0831d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int uD() {
            return this.ahK;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0831d, com.kwad.framework.filedownloader.message.c
        public final byte uz() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0831d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ahK);
        }

        public h(Parcel parcel) {
            super(parcel);
            this.ahK = parcel.readInt();
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends d {
        private final boolean aic;
        private final long totalBytes;

        public b(int i, boolean z, long j) {
            super(i);
            this.aic = z;
            this.totalBytes = j;
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
        public final long wE() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wF() {
            return this.aic;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aic ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.aic = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$d, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0831d extends d {
        private final long aif;
        private final Throwable aig;

        public C0831d(int i, long j, Throwable th) {
            super(i);
            this.aif = j;
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
        public final long wG() {
            return this.aif;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable wH() {
            return this.aig;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.aif);
            parcel.writeSerializable(this.aig);
        }

        public C0831d(Parcel parcel) {
            super(parcel);
            this.aif = parcel.readLong();
            this.aig = (Throwable) parcel.readSerializable();
        }
    }

    public d(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: classes11.dex */
    public static class c extends d {
        private final String agz;
        private final boolean aid;
        private final String aie;
        private final long totalBytes;

        public c(int i, boolean z, long j, String str, String str2) {
            super(i);
            this.aid = z;
            this.totalBytes = j;
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
        public final long wE() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.aid ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
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
            this.totalBytes = parcel.readLong();
            this.agz = parcel.readString();
            this.aie = parcel.readString();
        }
    }
}
