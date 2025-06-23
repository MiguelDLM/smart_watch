package com.baidu.navisdk.module.ar.tracker;

import OXOo.OOXIXo;
import android.location.Location;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final SimpleDateFormat f6998a;
    private long b;
    private HashMap<String, Location> c;

    @OOXIXo
    private final e d;

    @OOXIXo
    private final String e;

    public c(@OOXIXo e proxy, @OOXIXo String gpsTrackPath) {
        IIX0o.x0xO0oo(proxy, "proxy");
        IIX0o.x0xO0oo(gpsTrackPath, "gpsTrackPath");
        this.d = proxy;
        this.e = gpsTrackPath;
        this.f6998a = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
    }

    public final void a() {
        this.c = a(this.e);
    }

    public final void a(long j) {
        if (j - this.b > 1000) {
            HashMap<String, Location> hashMap = this.c;
            if (hashMap == null) {
                IIX0o.XOxIOxOx("mLocationMap");
            }
            a(hashMap, j);
            this.b = j;
        }
    }

    private final void a(HashMap<String, Location> hashMap, long j) {
        String format = this.f6998a.format(new Date(j));
        com.baidu.navisdk.module.ar.util.a.b("BNAr", "mocktime:" + format);
        Location location = hashMap.get(format);
        if (location != null) {
            a(location);
        }
    }

    private final void a(Location location) {
        this.d.a(location);
    }

    private final HashMap<String, Location> a(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        long time;
        String IIOIX2;
        HashMap<String, Location> hashMap = new HashMap<>();
        if (str == null) {
            return hashMap;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return hashMap;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                Object[] array = StringsKt__StringsKt.XXoO0oX(readLine, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    Location location = new Location("txt");
                    location.setLongitude(Double.parseDouble(strArr[1]));
                    location.setLatitude(Double.parseDouble(strArr[2]));
                    location.setSpeed(Float.parseFloat(strArr[3]));
                    location.setBearing(Float.parseFloat(strArr[4]));
                    location.setAccuracy(Float.parseFloat(strArr[5]));
                    if (strArr.length > 10) {
                        Date parse = this.f6998a.parse(OxI.IIOIX(strArr[strArr.length - 5], ":", "", false, 4, null));
                        IIX0o.oO(parse, "mSDF.parse(params[params…ze - 5].replace(\":\", \"\"))");
                        time = parse.getTime();
                    } else {
                        Date parse2 = this.f6998a.parse(OxI.IIOIX(strArr[strArr.length - 3], ":", "", false, 4, null));
                        IIX0o.oO(parse2, "mSDF.parse(params[params…ze - 3].replace(\":\", \"\"))");
                        time = parse2.getTime();
                    }
                    location.setTime(time);
                    if (strArr.length > 10) {
                        IIOIX2 = OxI.IIOIX(strArr[strArr.length - 5], ":", "", false, 4, null);
                    } else {
                        IIOIX2 = OxI.IIOIX(strArr[strArr.length - 3], ":", "", false, 4, null);
                    }
                    hashMap.put(IIOIX2, location);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    throw th;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }
}
