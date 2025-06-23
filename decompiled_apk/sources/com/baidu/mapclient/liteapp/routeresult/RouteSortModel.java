package com.baidu.mapclient.liteapp.routeresult;

import com.szabh.navi.R;

/* loaded from: classes7.dex */
public class RouteSortModel {
    public String mItemName;
    public int mPreferValue;

    public RouteSortModel(String str, int i) {
        this.mItemName = str;
        this.mPreferValue = i;
    }

    public int getPreferIconId(boolean z) {
        int i = this.mPreferValue;
        if (i != 4) {
            if (i != 8) {
                if (i != 16) {
                    if (i != 128) {
                        if (i != 256) {
                            if (i != 512) {
                                if (i != 1024) {
                                    if (z) {
                                        return R.drawable.nsdk_drawable_route_sort_default_selected;
                                    }
                                    return R.drawable.nsdk_drawable_route_sort_default_normal;
                                }
                            } else {
                                if (z) {
                                    return R.drawable.nsdk_drawable_route_sort_road_first_selected;
                                }
                                return R.drawable.nsdk_drawable_route_sort_road_first_normal;
                            }
                        } else {
                            if (z) {
                                return R.drawable.nsdk_drawable_route_sort_time_first_selected;
                            }
                            return R.drawable.nsdk_drawable_route_sort_time_first_normal;
                        }
                    } else {
                        if (z) {
                            return R.drawable.nsdk_drawable_route_sort_distance_first_selected;
                        }
                        return R.drawable.nsdk_drawable_route_sort_distance_first_normal;
                    }
                } else {
                    if (z) {
                        return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_selected;
                    }
                    return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_normal;
                }
            }
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_notoll_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_notoll_normal;
        }
        if (z) {
            return R.drawable.nsdk_drawable_route_sort_nohighway_selected;
        }
        return R.drawable.nsdk_drawable_route_sort_nohighway_normal;
    }
}
