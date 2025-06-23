package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.navisdk.embed.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8769a = new a();
    public static final b b = new b();

    /* loaded from: classes8.dex */
    public static final class c implements Comparator<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList<Integer> f8770a;

        public c(@NonNull ArrayList<Integer> arrayList) {
            this.f8770a = arrayList;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            int indexOf = this.f8770a.indexOf(num);
            int indexOf2 = this.f8770a.indexOf(num2);
            if (indexOf < 0) {
                indexOf = Integer.MIN_VALUE;
            }
            if (indexOf2 < 0) {
                indexOf2 = Integer.MIN_VALUE;
            }
            return indexOf - indexOf2;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class d {
        public abstract int a(int i);

        public abstract ArrayList<Integer> a();
    }

    public static void a(List<Integer> list, List<ImageView> list2, d dVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.a("BNServiceAreaUtils", "refreshServiceIcon", "subTypes", list);
        }
        if (dVar == null) {
            dVar = f8769a;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new c(dVar.a()));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int a2 = dVar.a(((Integer) it.next()).intValue());
            if (a2 != -1) {
                arrayList2.add(Integer.valueOf(a2));
            }
        }
        int size = arrayList2.size();
        if (size == 0) {
            for (int i = 0; i < list2.size(); i++) {
                ImageView imageView = list2.get(i);
                if (imageView != null) {
                    if (i == 0) {
                        imageView.setImageResource(R.drawable.nsdk_drawable_rg_hw_service_park);
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                    }
                }
            }
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            ImageView imageView2 = list2.get(i2);
            if (imageView2 != null) {
                if (i2 < size) {
                    int intValue = ((Integer) arrayList2.get(i2)).intValue();
                    imageView2.setVisibility(0);
                    imageView2.setImageDrawable(com.baidu.navisdk.ui.util.b.f(intValue));
                } else {
                    imageView2.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class a extends d {
        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.d
        public int a(int i) {
            if (i == 1) {
                return R.drawable.nsdk_drawable_rg_hw_service_petrol_station;
            }
            if (i == 2) {
                return R.drawable.nsdk_drawable_rg_hw_service_charging_station;
            }
            if (i == 4) {
                return R.drawable.nsdk_drawable_rg_hw_service_gas;
            }
            if (i == 8) {
                return R.drawable.nsdk_drawable_rg_hw_service_park;
            }
            if (i == 16) {
                return R.drawable.nsdk_drawable_rg_hw_service_garage;
            }
            if (i == 32) {
                return R.drawable.nsdk_drawable_rg_hw_service_diningroom;
            }
            if (i == 64) {
                return R.drawable.nsdk_drawable_rg_hw_service_toilet;
            }
            if (i == 128) {
                return R.drawable.nsdk_drawable_rg_hw_service_shop;
            }
            if (i != 256) {
                return -1;
            }
            return R.drawable.nsdk_drawable_rg_hw_service_recreation;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.d
        public ArrayList<Integer> a() {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(8);
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(32);
            arrayList.add(64);
            arrayList.add(128);
            arrayList.add(16);
            arrayList.add(256);
            arrayList.add(4);
            return arrayList;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends d {
        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.d
        public int a(int i) {
            if (i == 1) {
                return R.drawable.nsdk_drawable_rg_hw_service_petrol_station;
            }
            if (i == 2) {
                return R.drawable.nsdk_drawable_rg_hw_service_charging_station_white;
            }
            if (i == 4) {
                return R.drawable.nsdk_drawable_rg_hw_service_gas;
            }
            if (i == 8) {
                return R.drawable.nsdk_drawable_rg_hw_service_park;
            }
            if (i == 16) {
                return R.drawable.nsdk_drawable_rg_hw_service_garage;
            }
            if (i == 32) {
                return R.drawable.nsdk_drawable_rg_hw_service_diningroom;
            }
            if (i == 64) {
                return R.drawable.nsdk_drawable_rg_hw_service_toilet;
            }
            if (i == 128) {
                return R.drawable.nsdk_drawable_rg_hw_service_shop;
            }
            if (i != 256) {
                return -1;
            }
            return R.drawable.nsdk_drawable_rg_hw_service_recreation;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.i.d
        public ArrayList<Integer> a() {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(2);
            arrayList.add(8);
            arrayList.add(1);
            arrayList.add(32);
            arrayList.add(64);
            arrayList.add(128);
            arrayList.add(16);
            arrayList.add(256);
            arrayList.add(4);
            return arrayList;
        }
    }

    public static int a(int i, d dVar) {
        if (dVar == null) {
            dVar = f8769a;
        }
        return dVar.a(i);
    }
}
