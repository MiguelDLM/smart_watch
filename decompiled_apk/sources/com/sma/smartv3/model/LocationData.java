package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.util.xoIox;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class LocationData {

    @OOXIXo
    public static final LocationData INSTANCE = new LocationData();

    private LocationData() {
    }

    public static /* synthetic */ ArrayList getSmoothLocationListAlgorithm$default(LocationData locationData, ArrayList arrayList, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 7;
        }
        return locationData.getSmoothLocationListAlgorithm(arrayList, i);
    }

    @OOXIXo
    public final ArrayList<CustomLatLng> getFinalLocationList(@OOXIXo List<Location> locationList, boolean z) {
        boolean z2;
        IIX0o.x0xO0oo(locationList, "locationList");
        ArrayList<CustomLatLng> arrayList = new ArrayList<>();
        if (!locationList.isEmpty() && locationList.size() >= 2) {
            Iterator<Location> it = locationList.iterator();
            while (true) {
                z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getMSource() == 1) {
                    z2 = false;
                    break;
                }
            }
            if (z && z2) {
                CoordinateConverter from = new CoordinateConverter().from(CoordinateConverter.CoordType.GPS);
                for (Location location : locationList) {
                    LatLng convert = from.coord(new LatLng(location.getMLatitude(), location.getMLongitude())).convert();
                    arrayList.add(new CustomLatLng(convert.latitude, convert.longitude, location.getMTime(), location.getMAltitude(), 0, 16, null));
                }
            } else {
                for (Location location2 : locationList) {
                    arrayList.add(new CustomLatLng(location2.getMLatitude(), location2.getMLongitude(), location2.getMTime(), location2.getMAltitude(), 0, 16, null));
                }
            }
        }
        return arrayList;
    }

    @OOXIXo
    public final String getGpxFileString(@OOXIXo ArrayList<CustomLatLng> locationList, long j, @OOXIXo String creator, @OOXIXo String title) {
        IIX0o.x0xO0oo(locationList, "locationList");
        IIX0o.x0xO0oo(creator, "creator");
        IIX0o.x0xO0oo(title, "title");
        SimpleDateFormat xoIox2 = xoIox.xoIox();
        int rawOffset = TimeZone.getDefault().getRawOffset();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><gpx creator='");
        sb.append(creator);
        sb.append("' version=\"1.1\" xmlns='http://www.topografix.com/GPX/1/1'><metadata><time>");
        long j2 = rawOffset;
        sb.append(xoIox2.format(Long.valueOf(j - j2)));
        sb.append("</time></metadata>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<trk><name>");
        sb2.append(title);
        sb2.append("</name><desc>");
        sb2.append(Utils.getApp().getString(R.string.app_name));
        sb2.append("</desc><trkseg>");
        int size = locationList.size();
        int i = 0;
        while (i < size) {
            CustomLatLng customLatLng = locationList.get(i);
            IIX0o.oO(customLatLng, "get(...)");
            CustomLatLng customLatLng2 = customLatLng;
            sb.append("<wpt lat='");
            sb.append(customLatLng2.getLatitude());
            sb.append("' lon='");
            sb.append(customLatLng2.getLongitude());
            sb.append("'><name>\"");
            i++;
            sb.append(i);
            sb.append("\"</name><ele>");
            sb.append(customLatLng2.getAltitude());
            sb.append("</ele><time>");
            sb.append(xoIox2.format(Long.valueOf(customLatLng2.getTime() - j2)));
            sb.append("</time></wpt>");
            sb2.append("<trkpt lat='");
            sb2.append(customLatLng2.getLatitude());
            sb2.append("' lon='");
            sb2.append(customLatLng2.getLongitude());
            sb2.append("'><ele>");
            sb2.append(customLatLng2.getAltitude());
            sb2.append("</ele><time>");
            sb2.append(xoIox2.format(Long.valueOf(customLatLng2.getTime() - j2)));
            sb2.append("</time></trkpt>");
        }
        sb2.append("</trkseg></trk>");
        sb.append(sb2.toString());
        sb.append("</gpx>");
        String sb3 = sb.toString();
        IIX0o.oO(sb3, "toString(...)");
        return sb3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<com.sma.smartv3.model.CustomLatLng> getSmoothLocationListAlgorithm(@OXOo.OOXIXo java.util.ArrayList<com.sma.smartv3.model.CustomLatLng> r31, int r32) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.model.LocationData.getSmoothLocationListAlgorithm(java.util.ArrayList, int):java.util.ArrayList");
    }
}
