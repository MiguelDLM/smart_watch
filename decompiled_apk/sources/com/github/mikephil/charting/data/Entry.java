package com.github.mikephil.charting.data;

import XIXIX.OOXIXo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import o0xxxXXxX.XO;

/* loaded from: classes9.dex */
public class Entry extends XO implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new oIX0oI();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f16014Oxx0xo;

    /* loaded from: classes9.dex */
    public static class oIX0oI implements Parcelable.Creator<Entry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
        public Entry[] newArray(int i) {
            return new Entry[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }
    }

    public Entry() {
        this.f16014Oxx0xo = 0.0f;
    }

    public boolean II0XooXoX(Entry entry) {
        if (entry == null || entry.oIX0oI() != oIX0oI()) {
            return false;
        }
        float abs = Math.abs(entry.f16014Oxx0xo - this.f16014Oxx0xo);
        float f = OOXIXo.f3758Oxx0IOOO;
        if (abs > f || Math.abs(entry.I0Io() - I0Io()) > f) {
            return false;
        }
        return true;
    }

    public Entry Oxx0IOOO() {
        return new Entry(this.f16014Oxx0xo, I0Io(), oIX0oI());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Entry, x: " + this.f16014Oxx0xo + " y: " + I0Io();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f16014Oxx0xo);
        parcel.writeFloat(I0Io());
        if (oIX0oI() != null) {
            if (oIX0oI() instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) oIX0oI(), i);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }

    public void xoIox(float f) {
        this.f16014Oxx0xo = f;
    }

    public float xxIXOIIO() {
        return this.f16014Oxx0xo;
    }

    public Entry(float f, float f2) {
        super(f2);
        this.f16014Oxx0xo = f;
    }

    public Entry(float f, float f2, Object obj) {
        super(f2, obj);
        this.f16014Oxx0xo = f;
    }

    public Entry(float f, float f2, Drawable drawable) {
        super(f2, drawable);
        this.f16014Oxx0xo = f;
    }

    public Entry(float f, float f2, Drawable drawable, Object obj) {
        super(f2, drawable, obj);
        this.f16014Oxx0xo = f;
    }

    public Entry(Parcel parcel) {
        this.f16014Oxx0xo = 0.0f;
        this.f16014Oxx0xo = parcel.readFloat();
        XO(parcel.readFloat());
        if (parcel.readInt() == 1) {
            oxoX(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
