package com.baidu.navisdk.ui.routeguide.model;

import android.text.TextUtils;
import com.baidu.navisdk.embed.R;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class r {
    private static final int[] b = {R.drawable.nsdk_ic_lane_turn_around_left_gray, R.drawable.nsdk_ic_lane_turn_around_left, R.drawable.nsdk_ic_lane_around_and_straight_gray, R.drawable.nsdk_ic_lane_around_and_straight, R.drawable.nsdk_ic_lane_straight_and_around, R.drawable.nsdk_ic_lane_around_and_left_gray, R.drawable.nsdk_ic_lane_around_and_left, R.drawable.nsdk_ic_lane_around_left_straight_gray, R.drawable.nsdk_ic_lane_around_left_straight, R.drawable.nsdk_ic_lane_straight_left_around, R.drawable.nsdk_ic_lane_left_and_around, R.drawable.nsdk_ic_lane_left_around_straight, R.drawable.nsdk_ic_lane_around_and_right_gray, R.drawable.nsdk_ic_lane_around_and_right, R.drawable.nsdk_ic_lane_around_right_straight_gray, R.drawable.nsdk_ic_lane_around_right_straight, R.drawable.nsdk_ic_lane_straight_right_around, R.drawable.nsdk_ic_lane_around_left_right_gray, R.drawable.nsdk_ic_lane_around_left_right, R.drawable.nsdk_ic_lane_around_left_right_straight_gray, R.drawable.nsdk_ic_lane_around_left_right_straight, R.drawable.nsdk_ic_lane_straight_around_left_right, R.drawable.nsdk_ic_lane_left_around_right, R.drawable.nsdk_ic_lane_left_around_right_straight, R.drawable.nsdk_ic_lane_right_and_around, R.drawable.nsdk_ic_lane_right_around_straight, R.drawable.nsdk_ic_lane_right_around_left, R.drawable.nsdk_ic_lane_right_around_left_straight};

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f8968a = new HashMap();

    private void a() {
        if (this.f8968a.size() > 0) {
            return;
        }
        this.f8968a.put("00000010", "00000010");
        this.f8968a.put("00000011", "00000011");
        this.f8968a.put("00001010", "00001010");
        this.f8968a.put("00001011", "00001011");
        this.f8968a.put("00001110", "00001110");
        this.f8968a.put("00100010", "10000010");
        this.f8968a.put("00100011", "10000011");
        this.f8968a.put("00101010", "10001010");
        this.f8968a.put("00101011", "10001011");
        this.f8968a.put("00101110", "10001110");
        this.f8968a.put("00110010", "11000010");
        this.f8968a.put("00111010", "11001010");
        this.f8968a.put("10000010", "00100010");
        this.f8968a.put("10000011", "00100011");
        this.f8968a.put("10001010", "00101010");
        this.f8968a.put("10001011", "00101011");
        this.f8968a.put("10001110", "00101110");
        this.f8968a.put("10100010", "10100010");
        this.f8968a.put("10100011", "10100011");
        this.f8968a.put("10101010", "10101010");
        this.f8968a.put("10101011", "10101011");
        this.f8968a.put("10101110", "10101110");
        this.f8968a.put("10110010", "11100010");
        this.f8968a.put("10111010", "11101010");
        this.f8968a.put("11000010", "00110010");
        this.f8968a.put("11001010", "00111010");
        this.f8968a.put("11100010", "10110010");
        this.f8968a.put("11101010", "10111010");
    }

    public static boolean a(int i) {
        for (int i2 : b) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public String a(String str) {
        a();
        return (TextUtils.isEmpty(str) || !this.f8968a.containsKey(str)) ? str : this.f8968a.get(str);
    }
}
