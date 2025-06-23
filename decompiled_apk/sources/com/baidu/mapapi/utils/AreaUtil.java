package com.baidu.mapapi.utils;

import XIXIX.OOXIXo;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes7.dex */
public class AreaUtil {
    public static double calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            LatLng latLng3 = new LatLng(latLng.latitude, latLng2.longitude);
            double distance = DistanceUtil.getDistance(latLng3, latLng2);
            double distance2 = DistanceUtil.getDistance(latLng, latLng3);
            if (distance != OOXIXo.f3760XO && distance2 != OOXIXo.f3760XO) {
                return distance * distance2;
            }
        }
        return OOXIXo.f3760XO;
    }

    public static double calculateArea(List<LatLng> list) {
        double d = OOXIXo.f3760XO;
        if (list == null || list.size() < 3) {
            return OOXIXo.f3760XO;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i % size);
            d += (((latLng.longitude * 111319.49079327358d) * Math.cos(latLng.latitude * 0.017453292519943295d)) * (latLng2.latitude * 111319.49079327358d)) - ((latLng.latitude * 111319.49079327358d) * ((latLng2.longitude * 111319.49079327358d) * Math.cos(latLng2.latitude * 0.017453292519943295d)));
        }
        return (float) Math.abs(d / 2.0d);
    }
}
