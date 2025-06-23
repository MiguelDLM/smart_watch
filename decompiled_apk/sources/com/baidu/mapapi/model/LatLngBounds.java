package com.baidu.mapapi.model;

import XIXIX.OOXIXo;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    private LatLng f5921a;
    public final LatLng northeast;
    public final LatLng southwest;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        LatLng latLng2 = this.southwest;
        double d = latLng2.latitude;
        LatLng latLng3 = this.northeast;
        double d2 = latLng3.latitude;
        double d3 = latLng2.longitude;
        double d4 = latLng3.longitude;
        double d5 = latLng.latitude;
        double d6 = latLng.longitude;
        if (d5 >= d && d5 <= d2 && d6 >= d3 && d6 <= d4) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        LatLng latLng = this.f5921a;
        if (latLng != null) {
            return latLng;
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(this.northeast);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(this.southwest);
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(((ll2mc.getLatitudeE6() - ll2mc2.getLatitudeE6()) / 2.0d) + ll2mc2.getLatitudeE6(), ((ll2mc.getLongitudeE6() - ll2mc2.getLongitudeE6()) / 2.0d) + ll2mc2.getLongitudeE6()));
        this.f5921a = mc2ll;
        return mc2ll;
    }

    public void setCenter(LatLng latLng) {
        this.f5921a = latLng;
    }

    public String toString() {
        return "southwest: " + this.southwest.latitude + ", " + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + ", " + this.northeast.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.northeast, i);
        parcel.writeParcelable(this.southwest, i);
    }

    public LatLngBounds(Parcel parcel) {
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private double f5922a;
        private double b;
        private double c;
        private double d;
        private double e;
        private double f;
        private boolean g = true;

        private void a(LatLng latLng) {
            if (latLng == null) {
                return;
            }
            double d = latLng.latitude;
            double d2 = latLng.longitude;
            if (d < this.f5922a) {
                this.f5922a = d;
            }
            if (d > this.b) {
                this.b = d;
            }
            if (d2 >= OOXIXo.f3760XO) {
                if (d2 < this.c) {
                    this.c = d2;
                }
                if (d2 > this.d) {
                    this.d = d2;
                    if (this.c == OOXIXo.f3760XO) {
                        this.c = d2;
                    }
                }
                if (d2 == OOXIXo.f3760XO) {
                    this.e = d2;
                    return;
                }
                return;
            }
            if (d2 < this.f) {
                this.f = d2;
            }
            if (d2 > this.e) {
                this.e = d2;
            }
        }

        public LatLngBounds build() {
            double d = this.e;
            if (d != OOXIXo.f3760XO || this.f != OOXIXo.f3760XO) {
                double d2 = this.d;
                if (d2 == OOXIXo.f3760XO && this.c == OOXIXo.f3760XO) {
                    this.d = d;
                    this.c = this.f;
                } else {
                    double d3 = this.f + 360.0d;
                    this.c = d3;
                    if (d3 > d2) {
                        this.d = d3;
                        this.c = d2;
                    }
                }
            }
            double d4 = this.d;
            if (d4 > 180.0d) {
                double d5 = d4 - 360.0d;
                this.d = d5;
                double d6 = this.c;
                if (d5 < d6) {
                    this.d = d6;
                    this.c = d5;
                }
            }
            return new LatLngBounds(new LatLng(this.b, this.d), new LatLng(this.f5922a, this.c));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            if (this.g) {
                this.g = false;
                double d = latLng.longitude;
                if (d >= OOXIXo.f3760XO) {
                    this.c = d;
                    this.d = d;
                } else {
                    this.f = d;
                    this.e = d;
                }
                double d2 = latLng.latitude;
                this.f5922a = d2;
                this.b = d2;
            }
            a(latLng);
            return this;
        }

        public Builder include(List<LatLng> list) {
            if (list != null && list.size() != 0) {
                if (list.get(0) != null && this.g) {
                    this.g = false;
                    if (list.get(0).longitude >= OOXIXo.f3760XO) {
                        double d = list.get(0).longitude;
                        this.c = d;
                        this.d = d;
                    } else {
                        double d2 = list.get(0).longitude;
                        this.f = d2;
                        this.e = d2;
                    }
                    double d3 = list.get(0).latitude;
                    this.f5922a = d3;
                    this.b = d3;
                }
                Iterator<LatLng> it = list.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            return this;
        }
    }
}
