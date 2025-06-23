package com.sma.androidthirdpartylogin.model;

import OXOo.OOXIXo;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes11.dex */
public final class LoginResponse implements Parcelable {

    @OOXIXo
    public static final oIX0oI CREATOR = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OOXIXo
    public String f19714IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OOXIXo
    public String f19715Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OOXIXo
    public String f19716Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OOXIXo
    public String f19717OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public String f19718XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OOXIXo
    public String f19719oI0IIXIo;

    /* loaded from: classes11.dex */
    public static final class oIX0oI implements Parcelable.Creator<LoginResponse> {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @OOXIXo
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public LoginResponse[] newArray(int i) {
            return new LoginResponse[i];
        }

        @Override // android.os.Parcelable.Creator
        @OOXIXo
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public LoginResponse createFromParcel(@OOXIXo Parcel parcel) {
            IIX0o.x0xO0oo(parcel, "parcel");
            return new LoginResponse(parcel);
        }

        public oIX0oI() {
        }
    }

    public LoginResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    @OOXIXo
    public final String I0Io() {
        return this.f19715Oo;
    }

    public final void II0XooXoX(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f19719oI0IIXIo = str;
    }

    @OOXIXo
    public final String II0xO0() {
        return this.f19719oI0IIXIo;
    }

    public final void OOXIXo(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f19716Oxx0xo = str;
    }

    public final void Oxx0IOOO(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f19714IXxxXO = str;
    }

    @OOXIXo
    public final String X0o0xo() {
        return this.f19716Oxx0xo;
    }

    @OOXIXo
    public final String XO() {
        return this.f19717OxxIIOOXO;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f19714IXxxXO;
    }

    public final void oOoXoXO(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f19717OxxIIOOXO = str;
    }

    @OOXIXo
    public final String oxoX() {
        return this.f19718XO;
    }

    @OOXIXo
    public String toString() {
        return "LoginResponse(platform='" + this.f19718XO + "', openID='" + this.f19715Oo + "', accessToken='" + this.f19714IXxxXO + "'), unionId='" + this.f19717OxxIIOOXO + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@OOXIXo Parcel parcel, int i) {
        IIX0o.x0xO0oo(parcel, "parcel");
        parcel.writeString(this.f19718XO);
        parcel.writeString(this.f19715Oo);
        parcel.writeString(this.f19714IXxxXO);
        parcel.writeString(this.f19719oI0IIXIo);
        parcel.writeString(this.f19717OxxIIOOXO);
    }

    public final void xoIox(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f19718XO = str;
    }

    public final void xxIXOIIO(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f19715Oo = str;
    }

    public LoginResponse(@OOXIXo String platform, @OOXIXo String openID, @OOXIXo String accessToken, @OOXIXo String refreshToken, @OOXIXo String extInfo, @OOXIXo String unionId) {
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(openID, "openID");
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(refreshToken, "refreshToken");
        IIX0o.x0xO0oo(extInfo, "extInfo");
        IIX0o.x0xO0oo(unionId, "unionId");
        this.f19718XO = platform;
        this.f19715Oo = openID;
        this.f19714IXxxXO = accessToken;
        this.f19716Oxx0xo = refreshToken;
        this.f19719oI0IIXIo = extInfo;
        this.f19717OxxIIOOXO = unionId;
    }

    public /* synthetic */ LoginResponse(String str, String str2, String str3, String str4, String str5, String str6, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LoginResponse(@OXOo.OOXIXo android.os.Parcel r11) {
        /*
            r10 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r11, r0)
            java.lang.String r2 = r11.readString()
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r2, r0)
            java.lang.String r3 = r11.readString()
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, r0)
            java.lang.String r4 = r11.readString()
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r4, r0)
            java.lang.String r6 = r11.readString()
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r6, r0)
            java.lang.String r7 = r11.readString()
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r7, r0)
            r8 = 8
            r9 = 0
            r5 = 0
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.androidthirdpartylogin.model.LoginResponse.<init>(android.os.Parcel):void");
    }
}
