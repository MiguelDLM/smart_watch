package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static int f9837a;
    private static int b;

    public static ArrayList<c> a(Bundle bundle, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "GuideUtility.getGuideText from--->" + str);
        ArrayList<c> a2 = a(bundle, false);
        a2.addAll(a(bundle));
        ArrayList<c> arrayList = new ArrayList<>();
        if (a2.size() > 0) {
            arrayList.add(a2.get(0));
            if (a2.size() >= 2) {
                c cVar = a2.get(1);
                for (int i = 2; i < a2.size(); i++) {
                    cVar = c.a(cVar, a2.get(i));
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static void a(int i) {
        f9837a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<c> a(Bundle bundle, boolean z) {
        int i;
        int i2;
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "GuideUtility.getGuideLineText--->" + bundle.toString());
        ArrayList<c> arrayList = new ArrayList<>();
        String string = bundle.getString("usGuideText");
        int[] intArray = bundle.getIntArray("unIdx");
        int[] intArray2 = bundle.getIntArray("unWordCnt");
        int[] intArray3 = bundle.getIntArray("unLineNo");
        bundle.getBooleanArray("bHighLight");
        int[] intArray4 = bundle.getIntArray("enWordType");
        if (string.contains("@")) {
            string = string.replace("@", "...");
        }
        if (intArray.length == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 1;
            if (i3 >= intArray3.length) {
                break;
            }
            int i6 = intArray2[i3];
            i4 += i6;
            if (i5 != intArray3[i3]) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4 - i6));
                i5++;
                i4 = intArray2[i3];
            }
            if (i3 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4));
            }
            i3++;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i7 = 0;
        while (i7 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i7))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int i8 = 0;
            while (i8 < intValue) {
                if (i7 > 0) {
                    int i9 = i7 - 1;
                    if (i7 > i) {
                        i2 = ((Integer) hashMap.get(Integer.valueOf(i9))).intValue() + i8 + ((Integer) hashMap.get(Integer.valueOf(i7 - 2))).intValue();
                    } else {
                        i2 = ((Integer) hashMap.get(Integer.valueOf(i9))).intValue() + i8;
                    }
                } else {
                    i2 = i8;
                }
                if (i2 < string.length()) {
                    cArr[i8] = string.charAt(i2);
                }
                int i10 = 0;
                while (true) {
                    if (i10 >= intArray.length) {
                        break;
                    }
                    if (i10 != intArray.length - i) {
                        int i11 = i10 + 1;
                        if (i2 >= intArray[i11]) {
                            i10 = i11;
                            i = 1;
                        } else if (intArray4 != null) {
                            iArr[i8] = intArray4[i10];
                        }
                    } else if (intArray4 != null) {
                        iArr[i8] = intArray4[i10];
                    }
                }
                i8++;
                i = 1;
            }
            arrayList2.add(new c(cArr, iArr));
            i7++;
            i = 1;
        }
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            arrayList.add(arrayList2.get(i12));
        }
        if (arrayList.size() >= 1 && ((c) arrayList.get(0)).c != null && ((c) arrayList.get(0)).c.length == 0) {
            arrayList.remove(0);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ArrayList<c> a(Bundle bundle) {
        int i;
        int i2;
        String str;
        com.baidu.platform.comapi.wnplatform.d.a.a("GuideUtility.getGuideLineText", "" + bundle.toString());
        ArrayList<c> arrayList = new ArrayList<>();
        try {
            bundle.getInt("updatetype");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bundle.getInt("POIIsPassingPOI") == 0) {
            return arrayList;
        }
        String string = bundle.getString("usPOIGuideText");
        int[] intArray = bundle.getIntArray("unPOIIdx");
        int[] intArray2 = bundle.getIntArray("unPOIWordCnt");
        int[] intArray3 = bundle.getIntArray("unPOILineNo");
        boolean[] booleanArray = bundle.getBooleanArray("bPOIHighLight");
        a(intArray, intArray2, intArray3, booleanArray);
        if (string.contains("@")) {
            string = string.replace("@", "...");
        }
        if (intArray.length == 0) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i = 1;
            if (i3 >= intArray3.length) {
                break;
            }
            int i6 = intArray2[i3];
            i4 += i6;
            if (i5 != intArray3[i3]) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4 - i6));
                i5++;
                i4 = intArray2[i3];
            }
            if (i3 == intArray3.length - 1) {
                hashMap.put(Integer.valueOf(i5), Integer.valueOf(i4));
            }
            i3++;
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi segNumMap size:" + hashMap.size());
        for (int i7 = 0; i7 < hashMap.size(); i7++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", i7 + "==" + hashMap.get(Integer.valueOf(i7)));
        }
        ArrayList arrayList2 = new ArrayList();
        int size = hashMap.size();
        int i8 = 0;
        while (i8 < size) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i8))).intValue();
            char[] cArr = new char[intValue];
            int[] iArr = new int[intValue];
            int[] iArr2 = new int[intValue];
            int i9 = 0;
            while (i9 < intValue) {
                if (i8 <= 0) {
                    i2 = i9;
                } else if (i8 > i) {
                    i2 = ((Integer) hashMap.get(Integer.valueOf(i8 - 1))).intValue() + i9 + ((Integer) hashMap.get(Integer.valueOf(i8 - 2))).intValue();
                } else {
                    i2 = ((Integer) hashMap.get(Integer.valueOf(i8 - 1))).intValue() + i9;
                }
                if (i2 < string.length()) {
                    cArr[i9] = string.charAt(i2);
                }
                iArr2[i9] = 1;
                HashMap hashMap2 = hashMap;
                int i10 = 0;
                while (true) {
                    if (i10 >= intArray.length) {
                        break;
                    }
                    if (i10 == intArray.length - 1) {
                        if (booleanArray[i10]) {
                            iArr[i9] = 1;
                        } else {
                            iArr[i9] = 0;
                        }
                    } else {
                        int i11 = i10 + 1;
                        str = string;
                        if (i2 >= intArray[i11]) {
                            i10 = i11;
                            string = str;
                        } else if (booleanArray[i10]) {
                            iArr[i9] = 1;
                        } else {
                            iArr[i9] = 0;
                        }
                    }
                }
                str = string;
                i9++;
                hashMap = hashMap2;
                string = str;
                i = 1;
            }
            arrayList2.add(new c(cArr, iArr, iArr2));
            i8++;
            hashMap = hashMap;
            string = string;
            i = 1;
        }
        a((ArrayList<c>) arrayList2);
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            arrayList.add(arrayList2.get(i12));
        }
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi line:" + i13 + String.valueOf(((c) arrayList.get(i13)).c));
        }
        return arrayList;
    }

    private static void a(ArrayList<c> arrayList) {
        if (arrayList.size() >= 1) {
            c a2 = c.a(arrayList.get(0), arrayList.get(1));
            arrayList.remove(0);
            arrayList.remove(0);
            arrayList.add(0, a2);
            if (arrayList.get(0).c.length > f9837a) {
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "poi enter new branch2!!!");
                c cVar = arrayList.get(0);
                c cVar2 = arrayList.size() >= 2 ? arrayList.get(1) : null;
                c a3 = c.a(arrayList.get(0), f9837a);
                c b2 = c.b(arrayList.get(0), f9837a);
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "headSecondText:" + String.valueOf(a3.c));
                com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "tailSecondText:" + String.valueOf(b2.c));
                if (arrayList.size() >= 2) {
                    b2 = c.a(b2, arrayList.get(1));
                }
                arrayList.remove(cVar);
                if (cVar2 != null) {
                    arrayList.remove(cVar2);
                }
                arrayList.add(a3);
                arrayList.add(b2);
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int[] iArr3, boolean[] zArr) {
        String str = "";
        String str2 = "";
        for (int i : iArr) {
            str2 = str2 + i + ",";
        }
        String str3 = "";
        for (int i2 : iArr2) {
            str3 = str3 + i2 + ",";
        }
        String str4 = "";
        for (int i3 : iArr3) {
            str4 = str4 + i3 + ",";
        }
        for (boolean z : zArr) {
            str = str + z + ",";
        }
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unIdxString:" + str2);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unWordCntString:" + str3);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "unLineNoString:" + str4);
        com.baidu.platform.comapi.wnplatform.d.a.c("yang11", "highLightString:" + str);
    }
}
