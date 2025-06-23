package com.baidu.ar.auth;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class FeatureCodes {
    public static final int ADVANCE_BEAUTY = 1600;
    public static final int BASIC_BEAUTY = 1000;
    public static final int BASIC_FILTER = 1100;
    public static final int BEAUTY_MAKEUP = 1610;
    public static final int BODY_SEG = 1700;
    public static final int DIGITAL = 2700;
    public static final int FACE = 1200;
    public static final int FACE_CHANGING = 1220;
    public static final int FACE_DUMOJI = 1230;
    public static final int FACE_MULTI = 1210;
    public static final int GESTURE = 1500;
    public static final int HAIR_SEG = 1800;
    public static final int HAND = 2200;
    public static final int HEAD_SEG = 2300;
    public static final int OBJECT_DETECT = 2000;
    public static final int POSE = 1400;
    public static final int SKY_SEG = 1900;
    public static final int SPLIT_FILTER = 1110;
    public static final int TRACK_2D = 2100;
    public static final int TRACK_3D = 3100;
    public static final int VO = 1300;

    public static List<Integer> getAll() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1000);
        arrayList.add(1100);
        arrayList.add(1200);
        arrayList.add(Integer.valueOf(VO));
        arrayList.add(Integer.valueOf(POSE));
        arrayList.add(1500);
        arrayList.add(1600);
        arrayList.add(Integer.valueOf(BODY_SEG));
        arrayList.add(Integer.valueOf(HAIR_SEG));
        arrayList.add(Integer.valueOf(SKY_SEG));
        arrayList.add(Integer.valueOf(FACE_MULTI));
        arrayList.add(Integer.valueOf(FACE_CHANGING));
        arrayList.add(Integer.valueOf(BEAUTY_MAKEUP));
        arrayList.add(Integer.valueOf(SPLIT_FILTER));
        arrayList.add(2000);
        arrayList.add(Integer.valueOf(FACE_DUMOJI));
        arrayList.add(2100);
        arrayList.add(3100);
        arrayList.add(2200);
        arrayList.add(2300);
        arrayList.add(2700);
        return arrayList;
    }
}
