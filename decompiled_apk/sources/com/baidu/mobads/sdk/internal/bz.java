package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.ar.constants.HttpConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class bz implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6264a = "MD5";
    public static final Parcelable.Creator<bz> b = new ca();
    private JSONObject c;
    private double d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;

    public /* synthetic */ bz(Parcel parcel, ca caVar) {
        this(parcel);
    }

    public Boolean a() {
        boolean z = true;
        if (this.i != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public double b() {
        return this.d;
    }

    public String c() {
        return cs.a().c(this.e);
    }

    public String d() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.g;
    }

    public Boolean f() {
        boolean z = true;
        if (this.h != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public String toString() {
        return this.c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeInt(this.i);
        parcel.writeString(this.e);
        parcel.writeDouble(this.d);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
    }

    public bz(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.c = jSONObject;
            this.d = jSONObject.getDouble("version");
            this.e = this.c.getString("url");
            this.f = this.c.getString(HttpConstants.SIGN);
            this.i = 1;
            this.g = "";
            this.h = 0;
        } catch (JSONException unused) {
            this.i = 0;
        }
        this.i = c() == null ? 0 : 1;
    }

    public bz(bz bzVar, String str, Boolean bool) {
        this.d = bzVar.b();
        this.e = bzVar.c();
        this.f = bzVar.d();
        this.i = bzVar.a().booleanValue() ? 1 : 0;
        this.g = str;
        this.h = bool.booleanValue() ? 1 : 0;
    }

    private bz(Parcel parcel) {
        this.f = parcel.readString();
        this.i = parcel.readInt();
        this.e = parcel.readString();
        this.d = parcel.readDouble();
        this.g = parcel.readString();
        this.h = parcel.readInt();
    }
}
