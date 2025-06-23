package com.baidu.location.e;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public class d {
    public static int a(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ArrayList<Float> arrayList2 = arrayList.get(i2);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() > 0.0f) {
                i++;
            }
        }
        return i;
    }

    public static int b(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ArrayList<Float> arrayList2 = arrayList.get(i2);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() >= 15.0f) {
                i++;
            }
        }
        return i;
    }

    public static int c(ArrayList<ArrayList<Float>> arrayList) {
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ArrayList<Float> arrayList2 = arrayList.get(i2);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() >= 20.0f) {
                i++;
            }
        }
        return i;
    }

    public static int d(ArrayList<ArrayList<Float>> arrayList) {
        float f = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Float> arrayList2 = arrayList.get(i);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() > 0.0f) {
                f += arrayList2.get(2).floatValue();
            }
        }
        return Math.round(f);
    }

    public static int e(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(d(arrayList) / a(arrayList));
    }

    public static int f(ArrayList<ArrayList<Float>> arrayList) {
        float f = 0.0f;
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Float> arrayList2 = arrayList.get(i);
            if (arrayList2 != null && arrayList2.size() > 2 && arrayList2.get(2).floatValue() > 0.0f) {
                f += arrayList2.get(2).floatValue() * arrayList2.get(1).floatValue();
            }
        }
        return Math.round(f);
    }

    public static int g(ArrayList<ArrayList<Float>> arrayList) {
        return Math.round(f(arrayList) / a(arrayList));
    }

    public static int h(ArrayList<ArrayList<Float>> arrayList) {
        int i;
        int[] iArr = new int[37];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                if (i3 >= arrayList.size()) {
                    break;
                }
                ArrayList<Float> arrayList2 = arrayList.get(i3);
                if (arrayList2 != null && arrayList2.size() > 0 && arrayList2.get(0).floatValue() < 360.0d) {
                    int ceil = (int) Math.ceil(arrayList2.get(0).floatValue() / 10.0f);
                    iArr[ceil] = iArr[ceil] + 1;
                }
                i3++;
            } catch (Exception unused) {
                return 0;
            }
        }
        for (i = 1; i <= 36; i++) {
            if (iArr[i] > 0) {
                i2++;
            }
        }
        return Math.round((i2 / 36.0f) * 1000.0f);
    }
}
