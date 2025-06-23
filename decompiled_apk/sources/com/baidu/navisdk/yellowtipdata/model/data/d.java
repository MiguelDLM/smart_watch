package com.baidu.navisdk.yellowtipdata.model.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class d implements Parcelable {

    @OOXIXo
    public static final a CREATOR = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f9464a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;

    @oOoXoXO
    private String l;

    @oOoXoXO
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;

    @oOoXoXO
    private g r;

    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator<d> {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public d createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new d(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OOXIXo
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public d() {
        this.n = -1;
    }

    public final int a() {
        return this.f9464a;
    }

    public final int b() {
        return this.b;
    }

    public final void c(int i) {
        this.f9464a = i;
    }

    public final void d(boolean z) {
        this.f = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.c;
    }

    public final void f(int i) {
        this.b = i;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    @OOXIXo
    public String toString() {
        String str = "RouteCarYBannerModel{tipType=" + this.f9464a + ", priority=" + this.b + ", isGlobal=" + this.c + ", isClickable=" + this.d + ", isHasCloseView=" + this.e + ", isHasAnimation=" + this.f + ", isShowInToolBoxAfterDismiss=" + this.g + ", isTriggerHalfway=" + this.h + ", isCalComplete=" + this.i + ", clickAction=" + this.j + ", isSpeedy=" + this.k + ", conformText='" + this.l + "', cancelText='" + this.m + "', groupId=" + this.n + ", previewClickAction=" + this.o + ", routeCarYBannerInfo=" + this.r + '}';
        IIX0o.oO(str, "sb.toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel parcel, int i) {
        IIX0o.x0xO0oo(parcel, "parcel");
        parcel.writeInt(this.f9464a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.j);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final void b(@oOoXoXO String str) {
        this.l = str;
    }

    public final void c(boolean z) {
        this.c = z;
    }

    public final boolean d() {
        return this.i;
    }

    public final void e(boolean z) {
        this.e = z;
    }

    public final boolean f() {
        return this.f;
    }

    public final void g(boolean z) {
        this.k = z;
    }

    public final void h(boolean z) {
        this.h = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(@OOXIXo Parcel parcel) {
        this();
        IIX0o.x0xO0oo(parcel, "parcel");
        this.f9464a = parcel.readInt();
        this.b = parcel.readInt();
        byte b = (byte) 0;
        this.c = parcel.readByte() != b;
        this.d = parcel.readByte() != b;
        this.e = parcel.readByte() != b;
        this.f = parcel.readByte() != b;
        this.g = parcel.readByte() != b;
        this.h = parcel.readByte() != b;
        this.i = parcel.readByte() != b;
        this.j = parcel.readInt();
        this.k = parcel.readByte() != b;
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
    }

    public final void a(int i) {
        this.j = i;
    }

    public final void b(int i) {
        this.n = i;
    }

    @oOoXoXO
    public final g c() {
        return this.r;
    }

    public final void d(int i) {
        this.q = i;
    }

    public final void e(int i) {
        this.o = i;
    }

    public final void f(boolean z) {
        this.g = z;
    }

    public final void a(@oOoXoXO String str) {
        this.m = str;
    }

    public final void b(boolean z) {
        this.d = z;
    }

    public final void a(@oOoXoXO g gVar) {
        this.r = gVar;
    }
}
