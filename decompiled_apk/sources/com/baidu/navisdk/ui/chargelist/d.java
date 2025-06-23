package com.baidu.navisdk.ui.chargelist;

import OXOo.OOXIXo;
import com.baidu.navisdk.embed.R;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final d f8373a = new d();

    private d() {
    }

    public static /* synthetic */ int a(d dVar, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        return dVar.a(i, i2, z);
    }

    public final int b(int i) {
        int i2 = R.drawable.bnav_energy_list_selected_green_bg;
        if (i == 0) {
            return i2;
        }
        if (i != 1) {
            return i != 2 ? i2 : R.drawable.bnav_energy_list_selected_red_bg;
        }
        return R.drawable.bnav_energy_list_selected_orange_bg;
    }

    public final int c(int i) {
        int i2 = R.color.bnav_charge_list_small_text_des_orange;
        if (i != 1 && i == 2) {
            return R.color.bnav_charge_list_small_text_des_red;
        }
        return i2;
    }

    public final int a(int i, int i2, boolean z) {
        int i3 = R.drawable.nsdk_energy_charge_bg_green_top;
        if (i == 0) {
            if (i2 == 0) {
                return R.drawable.nsdk_energy_charge_bg_green_middle;
            }
            if (i2 == 1) {
                return R.drawable.nsdk_energy_charge_bg_orange_middle;
            }
            if (i2 != 2) {
                return i2 != 3 ? i3 : R.drawable.nsdk_energy_charge_bg_green_middle;
            }
            return R.drawable.nsdk_energy_charge_bg_red_middle;
        }
        if (i == 1) {
            if (i2 == 0) {
                return i3;
            }
            if (i2 != 1) {
                return i2 != 2 ? i3 : R.drawable.nsdk_energy_charge_bg_red_top;
            }
            return R.drawable.nsdk_energy_charge_bg_orange_top;
        }
        if (i == 2) {
            if (i2 == 0) {
                return R.drawable.nsdk_energy_charge_bg_green_middle;
            }
            if (i2 == 1) {
                return R.drawable.nsdk_energy_charge_bg_orange_middle;
            }
            if (i2 != 2) {
                return i2 != 3 ? i3 : R.drawable.nsdk_energy_charge_bg_green_middle;
            }
            return R.drawable.nsdk_energy_charge_bg_red_middle;
        }
        if (i != 3) {
            return i3;
        }
        if (i2 == 0) {
            return R.drawable.nsdk_energy_charge_bg_green_down;
        }
        if (i2 == 1) {
            return R.drawable.nsdk_energy_charge_bg_orange_down;
        }
        if (i2 != 2) {
            return i2 != 3 ? i3 : R.drawable.nsdk_energy_charge_bg_green_down;
        }
        return R.drawable.nsdk_energy_charge_bg_red_down;
    }

    public final int b(int i, int i2, boolean z) {
        int i3 = R.drawable.bnav_charge_single_green_bg;
        if (i == 0) {
            return (!z && i2 == 1) ? R.drawable.bnav_charge_single_route_green_bg : i3;
        }
        if (i == 1) {
            return R.drawable.bnav_charge_single_orange_bg;
        }
        if (i != 2) {
            return i != 3 ? i3 : R.drawable.bnav_charge_single_route_green_bg;
        }
        return R.drawable.bnav_charge_single_red_bg;
    }

    public final int a(int i) {
        int i2 = R.drawable.nsdk_energy_charge_location_green;
        if (i == 0) {
            return i2;
        }
        if (i != 1) {
            return i != 2 ? i2 : R.drawable.nsdk_energy_charge_location_red;
        }
        return R.drawable.nsdk_energy_charge_location_orange;
    }
}
