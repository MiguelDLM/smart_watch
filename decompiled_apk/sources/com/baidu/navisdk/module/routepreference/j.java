package com.baidu.navisdk.module.routepreference;

import com.baidu.navisdk.embed.R;

/* loaded from: classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public String f7486a;
    public int b;
    public int c;
    public int d;

    public j(String str, int i) {
        this.f7486a = str;
        this.b = i;
    }

    public int a(boolean z) {
        int i = this.b;
        if (i == 1) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_default_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_default_normal;
        }
        if (i == 4) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_nohighway_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_nohighway_normal;
        }
        if (i == 8) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_notoll_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_notoll_normal;
        }
        if (i == 16) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_normal;
        }
        if (i == 128) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_distance_first_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_distance_first_normal;
        }
        if (i == 256) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_time_first_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_time_first_normal;
        }
        if (i == 512) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_road_first_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_road_first_normal;
        }
        if (i != 1024) {
            if (z) {
                return R.drawable.nsdk_drawable_route_sort_default_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_default_normal;
        }
        if (z) {
            return R.drawable.nsdk_drawable_route_sort_notoll_selected;
        }
        return R.drawable.nsdk_drawable_route_sort_notoll_normal;
    }

    public int b() {
        int i = this.b;
        if (i != 1) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 128) {
                            if (i != 256) {
                                if (i != 512) {
                                    if (i != 1024) {
                                        return R.drawable.nsdk_drawable_route_sort_default_selected;
                                    }
                                    return R.drawable.nsdk_drawable_route_sort_notoll_selected;
                                }
                                return R.drawable.nsdk_drawable_route_sort_road_first_selected;
                            }
                            return R.drawable.nsdk_drawable_route_sort_time_first_selected;
                        }
                        return R.drawable.nsdk_drawable_route_sort_distance_first_selected;
                    }
                    return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_selected;
                }
                return R.drawable.nsdk_drawable_route_sort_notoll_selected;
            }
            return R.drawable.nsdk_drawable_route_sort_nohighway_selected;
        }
        return R.drawable.nsdk_drawable_route_sort_default_selected;
    }

    public int c() {
        int i = this.b;
        if (i != 1) {
            if (i != 4) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 256) {
                            if (i != 512) {
                                if (i != 1024) {
                                    return R.drawable.nsdk_drawable_route_sort_default_white;
                                }
                                return R.drawable.nsdk_drawable_route_sort_notoll_white;
                            }
                            return R.drawable.nsdk_drawable_route_sort_road_first_white;
                        }
                        return R.drawable.nsdk_drawable_route_sort_time_first_white;
                    }
                    return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_white;
                }
                return R.drawable.nsdk_drawable_route_sort_notoll_white;
            }
            return R.drawable.nsdk_drawable_route_sort_nohighway_white;
        }
        return R.drawable.nsdk_drawable_route_sort_default_white;
    }

    public int a() {
        int i = this.b;
        if (i == 1) {
            return R.drawable.nsdk_drawable_route_sort_default_normal;
        }
        if (i == 4) {
            return R.drawable.nsdk_drawable_route_sort_nohighway_normal;
        }
        if (i == 8) {
            return R.drawable.nsdk_drawable_route_sort_notoll_normal;
        }
        if (i == 16) {
            return R.drawable.nsdk_drawable_route_sort_avoid_traffic_jam_normal;
        }
        if (i == 128) {
            return R.drawable.nsdk_drawable_route_sort_distance_first_normal;
        }
        if (i == 256) {
            return R.drawable.nsdk_drawable_route_sort_time_first_normal;
        }
        if (i == 512) {
            return R.drawable.nsdk_drawable_route_sort_road_first_normal;
        }
        if (i != 1024) {
            return R.drawable.nsdk_drawable_route_sort_default_normal;
        }
        return R.drawable.nsdk_drawable_route_sort_notoll_normal;
    }
}
