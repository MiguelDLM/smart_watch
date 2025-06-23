package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance;

import XIXIX.OOXIXo;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.navimageloader.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7534a = false;
    private static ConcurrentHashMap<String, Integer> b = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, h.c> d = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, HashSet<String>> e = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Integer> f = new ConcurrentHashMap<>();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f7535a = 99;
        int b;
        int c;
    }

    static {
        b.put("晴", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_sunny));
        b.put("阴", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_overcast));
        b.put("多云", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_cloudy));
        b.put("小雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_light_rain));
        b.put("中雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_moderate_rain));
        b.put("大雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_heavy_rain));
        b.put("暴雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_storm_rain));
        b.put("阵雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_shower));
        b.put("雷阵雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_thunder_shower));
        b.put("雾", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_foggy));
        b.put("霾", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_haze));
        b.put("雨夹雪", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_sleet));
        b.put("小雪", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_light_snow));
        b.put("中雪", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_moderate_snow));
        b.put("大雪", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_heavy_snow));
        b.put("冰雹", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_hail));
        b.put("浮尘", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_float_dust));
        b.put("扬沙", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_sand_storm));
        c.put("晴", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_sunny_dark));
        c.put("多云", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_cloudy_dark));
        c.put("阵雨", Integer.valueOf(R.drawable.nsdk_drawable_route_result_weather_shower_dark));
        f.put(123, Integer.valueOf(R.drawable.nsdk_drawable_route_result_pavement_wet));
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = f;
        int i = R.drawable.nsdk_drawable_route_result_pavement_snow;
        concurrentHashMap.put(124, Integer.valueOf(i));
        f.put(125, Integer.valueOf(R.drawable.nsdk_drawable_route_result_pavement_freeze));
        f.put(126, Integer.valueOf(i));
        d.put("晴", new h.c(3, "路面干燥", "能见度高"));
        d.put("阴", new h.c(3, "路面干燥", "能见度较低"));
        d.put("多云", new h.c(3, "路面干燥", "能见度较低"));
        d.put("小雨", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("中雨", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("大雨", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("暴雨", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("阵雨", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("雷阵雨", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("冰雹", new h.c(3, "路面潮湿", "能见度较低"));
        d.put("雾", new h.c(3, "路面干燥", "能见度较低"));
        d.put("霾", new h.c(3, "路面干燥", "能见度较低"));
        d.put("浮尘", new h.c(3, "路面干燥", "能见度较低"));
        d.put("扬沙", new h.c(3, "路面干燥", "能见度较低"));
        d.put("雨夹雪", new h.c(3, "路面有雪水", "能见度较低"));
        d.put("小雪", new h.c(3, "路面有雪水", "能见度较低"));
        d.put("中雪", new h.c(3, "路面有雪水", "能见度较低"));
        d.put("大雪", new h.c(3, "路面有雪水", "能见度较低"));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("能见度极低");
        e.put("晴", hashSet);
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("能见度极低");
        e.put("阴", hashSet2);
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("能见度极低");
        e.put("多云", hashSet3);
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("路面干燥");
        e.put("中雨", hashSet4);
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("能见度高");
        hashSet5.add("路面干燥");
        e.put("大雨", hashSet5);
        HashSet<String> hashSet6 = new HashSet<>();
        hashSet6.add("能见度高");
        hashSet6.add("路面干燥");
        e.put("暴雨", hashSet6);
        HashSet<String> hashSet7 = new HashSet<>();
        hashSet7.add("能见度高");
        e.put("雾", hashSet7);
        HashSet<String> hashSet8 = new HashSet<>();
        hashSet8.add("能见度高");
        e.put("霾", hashSet8);
        HashSet<String> hashSet9 = new HashSet<>();
        hashSet9.add("能见度高");
        e.put("冰雹", hashSet9);
        HashSet<String> hashSet10 = new HashSet<>();
        hashSet10.add("能见度高");
        e.put("浮尘", hashSet10);
        HashSet<String> hashSet11 = new HashSet<>();
        hashSet11.add("能见度高");
        e.put("扬沙", hashSet11);
        HashSet<String> hashSet12 = new HashSet<>();
        hashSet12.add("路面干燥");
        e.put("中雪", hashSet12);
        HashSet<String> hashSet13 = new HashSet<>();
        hashSet13.add("能见度高");
        hashSet13.add("路面干燥");
        e.put("大雪", hashSet13);
    }

    public static int a(String str, boolean z) {
        Integer num;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "getWeatherDrawableId --> climate = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (z) {
            num = b.get(str);
        } else {
            Integer num2 = c.get(str);
            num = num2 == null ? b.get(str) : num2;
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static boolean b(h hVar) {
        h.d dVar;
        if (hVar == null || (dVar = hVar.f) == null) {
            return false;
        }
        return a(dVar.f6931a);
    }

    public static boolean c() {
        if (!b() && a()) {
            return true;
        }
        return false;
    }

    public static ArrayList<h> b(ArrayList<h> arrayList, int i, double d2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("MeteorUtils", "updatePavementDataByLevel", "meteorInfoList", arrayList);
            LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> level = " + i);
        }
        double d3 = com.baidu.baidunavis.maplayer.e.k().d();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> units = " + d3);
        }
        if (d3 != OOXIXo.f3760XO && arrayList != null && !arrayList.isEmpty()) {
            int rint = (int) Math.rint(d2 / 1.3d);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> showSize = " + rint);
            }
            ArrayList<h> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList(arrayList);
            int size = arrayList3.size();
            a aVar = new a();
            int i2 = 0;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                h hVar = (h) arrayList3.get(i4);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> i = " + i4 + ", meteorInfo = " + hVar);
                }
                if (hVar != null) {
                    int a2 = a(hVar.d.d, 1.3d);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> segment = " + a2);
                    }
                    if (i3 == a2 || i4 == 0) {
                        LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> meteorInfo.locationInfo.priority = " + hVar.c.f + "," + aVar.f7535a);
                        if (hVar.c.f < aVar.f7535a) {
                            a(hVar, i4, aVar, a2);
                        }
                    } else if (i3 != -1) {
                        arrayList2.add(((h) arrayList3.get(aVar.b)).m85clone());
                        a(hVar, i4, aVar, a2);
                        i2++;
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("MeteorUtils", "updatePavementDataByLevel --> tempSegment is " + a2);
                    }
                    if (i2 >= rint) {
                        break;
                    }
                    i3 = a2;
                }
            }
            arrayList2.add(((h) arrayList3.get(aVar.b)).m85clone());
            return arrayList2;
        }
        return new ArrayList<>();
    }

    public static int a(int i) {
        Integer num;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "getPavementDrawableId --> pavementType = " + i);
        }
        if (f.containsKey(Integer.valueOf(i)) && (num = f.get(Integer.valueOf(i))) != null) {
            return num.intValue();
        }
        return -1;
    }

    public static boolean a(String str, String str2, String str3) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "isMismatchPavement --> climate = " + str + ", describe = " + str2 + ", visDescribe = " + str3);
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) || !e.containsKey(str)) {
            return false;
        }
        HashSet<String> hashSet = e.get(str);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "isMismatchPavement --> climateSet = " + hashSet);
        }
        if (hashSet == null) {
            return false;
        }
        return hashSet.contains(str2) || hashSet.contains(str3);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && b.containsKey(str);
    }

    public static ArrayList<h> a(ArrayList<h> arrayList, int i, double d2) {
        int i2;
        String str;
        int i3;
        String str2 = "updateDataByLevel";
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("MeteorUtils", "updateDataByLevel", "meteorInfoList", arrayList);
            LogUtil.e("MeteorUtils", "updateDataByLevel --> level = " + i);
        }
        double d3 = com.baidu.baidunavis.maplayer.e.k().d();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "updateDataByLevel --> units = " + d3);
        }
        if (d3 != OOXIXo.f3760XO && arrayList != null && !arrayList.isEmpty()) {
            int rint = (int) Math.rint(d2 / 1.3d);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("MeteorUtils", "updateDataByLevel --> showSize = " + rint);
            }
            ArrayList<h> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList(arrayList);
            int size = arrayList3.size();
            a aVar = new a();
            int i4 = 0;
            int i5 = 0;
            int i6 = -1;
            while (true) {
                i2 = size - 1;
                if (i4 >= i2 || size < 1) {
                    break;
                }
                h hVar = (h) arrayList3.get(i4);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("MeteorUtils", "updateDataByLevel --> i = " + i4 + ", meteorInfo = " + hVar);
                }
                if (hVar == null) {
                    i3 = rint;
                    str = str2;
                } else {
                    int i7 = rint;
                    str = str2;
                    int a2 = a(hVar.d.d, 1.3d);
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("MeteorUtils", "updateDataByLevel --> segment = " + a2);
                    }
                    if (i6 == a2 || i4 == 0) {
                        LogUtil.e("MeteorUtils", "updateDataByLevel --> meteorInfo.locationInfo.priority = " + hVar.c.f + "," + aVar.f7535a);
                        if (hVar.c.f < aVar.f7535a) {
                            a(hVar, i4, aVar, a2);
                        }
                    } else if (i6 != -1 || i4 == size - 2) {
                        arrayList2.add(((h) arrayList3.get(aVar.b)).m85clone());
                        a(hVar, i4, aVar, a2);
                        i5++;
                    }
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("MeteorUtils", "updateDataByLevel --> tempSegment is " + a2);
                    }
                    i3 = i7;
                    if (i5 >= i3) {
                        break;
                    }
                    i6 = a2;
                }
                i4++;
                rint = i3;
                str2 = str;
            }
            str = str2;
            h hVar2 = (arrayList3.size() <= i2 || i2 < 0) ? null : (h) arrayList3.get(i2);
            int i8 = aVar.b;
            if (i8 == size - 2 && hVar2 != null) {
                h m85clone = ((h) arrayList3.get(i8)).m85clone();
                int a3 = a(m85clone.d.d, 1.3d);
                int a4 = a(hVar2.d.d, 1.3d);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("MeteorUtils", "updateDataByLevel --> latestSegment = " + a3 + ", lastSegment = " + a4);
                }
                if (!arrayList2.contains(m85clone) && a3 != a4) {
                    arrayList2.add(m85clone);
                }
            }
            if (hVar2 != null && !arrayList2.contains(hVar2)) {
                arrayList2.add(hVar2);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.printList("MeteorUtils", str, "levelMeteorList", arrayList2);
            }
            return arrayList2;
        }
        return new ArrayList<>();
    }

    public static boolean b() {
        return f7534a;
    }

    public static boolean a(h hVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "isShouldDeleteStartCityData --> meteorInfo = " + hVar);
        }
        if (hVar == null) {
            return true;
        }
        h.b bVar = hVar.c;
        boolean z = a(bVar.b, bVar.f6929a) || hVar.d.f6928a == 0;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "isShouldDeleteStartCityData --> isInStartCity = " + z);
        }
        return hVar.f6927a == 0 && z;
    }

    private static boolean a(int i, String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "isInStartCity --> cityId = " + i + " cityName = " + str);
        }
        f fVar = (f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar == null || fVar.o() == null) {
            return false;
        }
        RoutePlanNode o = fVar.o();
        int districtID = o.getDistrictID();
        String cityName = o.getCityName();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("MeteorUtils", "isInStartCity --> cityId = " + i + " cityName = " + str + " startNode = " + o + " startCityId = " + districtID);
        }
        return districtID == i || TextUtils.equals(str, cityName);
    }

    private static int a(long j, double d2) {
        double d3 = d2 * com.baidu.baidunavis.maplayer.e.k().d();
        if (d3 != OOXIXo.f3760XO) {
            return (int) (j / d3);
        }
        return 0;
    }

    public static boolean a() {
        if (j.d()) {
            return f.q.b();
        }
        return true;
    }

    private static void a(@NonNull h hVar, int i, a aVar, int i2) {
        aVar.f7535a = hVar.c.f;
        aVar.b = i;
        aVar.c = i2;
    }

    public static void a(ImageView imageView, h hVar, boolean z) {
        if (hVar == null || imageView == null) {
            return;
        }
        h.c cVar = hVar.e;
        if (cVar.g && a(cVar.f) != -1) {
            imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(a(hVar.e.f)));
        } else {
            com.baidu.navisdk.util.navimageloader.c.d().a(z ? hVar.f.c : hVar.f.d, imageView, new b.C0502b().a(a(hVar.f.f6931a, z)).b(a(hVar.f.f6931a, z)).a());
        }
    }
}
