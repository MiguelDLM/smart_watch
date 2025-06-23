package com.jd.ad.sdk.dl.baseinfo;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_bo.jad_bo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADLocation {
    private double lat;
    private double lon;
    private double radius;

    public JADLocation() {
        this.lat = -1.0d;
        this.lon = -1.0d;
        this.radius = -1.0d;
    }

    public static JADLocation parseJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JADLocation();
        }
        JADLocation jADLocation = new JADLocation();
        jADLocation.setLatitude(jSONObject.optDouble("lat"));
        jADLocation.setLongitude(jSONObject.optDouble("lon"));
        jADLocation.setRadius(jSONObject.optDouble("radius"));
        return jADLocation;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean isValid() {
        if (Double.compare(this.lat, -1.0d) == 0 && Double.compare(this.lon, -1.0d) == 0 && Double.compare(this.radius, -1.0d) == 0) {
            return false;
        }
        return true;
    }

    public void setLatitude(double d) {
        this.lat = d;
    }

    public void setLongitude(double d) {
        this.lon = d;
    }

    public void setRadius(double d) {
        this.radius = d;
    }

    @NonNull
    public double[] toDoubleArray() {
        return new double[]{this.lat, this.lon, this.radius};
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lat", Double.valueOf(this.lat));
            jSONObject.putOpt("lon", Double.valueOf(this.lon));
            jSONObject.putOpt("radius", Double.valueOf(this.radius));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder jad_an = jad_bo.jad_an("JADLocation{lat=");
        jad_an.append(this.lat);
        jad_an.append(", lon=");
        jad_an.append(this.lon);
        jad_an.append(", radius=");
        jad_an.append(this.radius);
        jad_an.append('}');
        return jad_an.toString();
    }

    public JADLocation(double d, double d2, double d3) {
        this.lat = d;
        this.lon = d2;
        this.radius = d3;
    }
}
