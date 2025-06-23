package com.baidu.navisdk.comapi.routeplan;

import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpStatus;
import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes7.dex */
public class c {
    public static String a(int i) {
        int i2;
        if (i != 406) {
            if (i != 423) {
                if (i != 450) {
                    if (i != 9000) {
                        switch (i) {
                            case 400:
                                i2 = R.string.nsdk_string_rp_toast_fail_low_version;
                                break;
                            case 401:
                                i2 = R.string.nsdk_string_rp_toast_fail_wrong_version;
                                break;
                            case 402:
                                i2 = R.string.nsdk_string_rp_toast_fail_no_start;
                                break;
                            case 403:
                                i2 = R.string.nsdk_string_rp_toast_fail_no_stop;
                                break;
                            case 404:
                                i2 = R.string.nsdk_string_rp_toast_fail_wrong_coord;
                                break;
                            default:
                                switch (i) {
                                    case 413:
                                        i2 = R.string.nsdk_string_rp_toast_fail_start_deviate;
                                        break;
                                    case 414:
                                        i2 = R.string.nsdk_string_rp_toast_fail_dest1_deviate;
                                        break;
                                    case 415:
                                        i2 = R.string.nsdk_string_rp_toast_fail_dest2_deviate;
                                        break;
                                    case 416:
                                        i2 = R.string.nsdk_string_rp_toast_fail_dest3_deviate;
                                        break;
                                    case 417:
                                        i2 = R.string.nsdk_string_rp_toast_fail_dest4_deviate;
                                        break;
                                    case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                        i2 = R.string.nsdk_string_rp_toast_fail_dest5_deviate;
                                        break;
                                    case HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE /* 419 */:
                                        i2 = R.string.nsdk_string_rp_toast_fail_too_close;
                                        break;
                                    case 420:
                                        i2 = R.string.nsdk_string_rp_toast_data_lack_failed;
                                        break;
                                    default:
                                        i2 = -1;
                                        break;
                                }
                        }
                    } else {
                        i2 = R.string.nsdk_string_rp_toast_fail_district_error;
                    }
                } else {
                    i2 = R.string.nsdk_string_rp_toast_network_unconnected;
                }
            } else {
                i2 = R.string.nsdk_string_rp_toast_fail_calc_fail;
            }
        } else {
            i2 = R.string.nsdk_string_rp_toast_fail_calc_cancel;
        }
        try {
            if (i2 != -1) {
                return JarUtils.getResources().getString(i2);
            }
            return JarUtils.getResources().getString(R.string.nsdk_string_rp_toast_calc_route_failed);
        } catch (Exception unused) {
            return "晕，小度不知怎么走了，请重试一次吧~";
        }
    }

    public static String b(int i) {
        int i2;
        if (i != 5030) {
            if (i != 5031) {
                if (i != 5200) {
                    switch (i) {
                        case 5000:
                            i2 = R.string.nsdk_string_rp_toast_route_node_not_complete;
                            break;
                        case 5001:
                            i2 = R.string.nsdk_string_rp_start_or_dest_invalid;
                            break;
                        case 5002:
                            i2 = R.string.nsdk_string_rp_toast_fail_too_close;
                            break;
                        default:
                            switch (i) {
                                case 5050:
                                    i2 = R.string.nsdk_string_rp_toast_calc_route_failed;
                                    break;
                                case ErrorCode.BIDDING_C2S_TIMEOUT /* 5051 */:
                                    i2 = R.string.nsdk_string_rp_toast_set_start_failed;
                                    break;
                                case ErrorCode.BIDDING_C2S_NO_AD /* 5052 */:
                                    i2 = R.string.nsdk_string_rp_toast_set_end_failed;
                                    break;
                                case 5053:
                                    i2 = R.string.nsdk_string_rp_toast_offline_avoid_tafficjam_error;
                                    break;
                                default:
                                    i2 = -1;
                                    break;
                            }
                    }
                } else {
                    i2 = R.string.nsdk_string_rp_toast_loc_invalid;
                }
            } else {
                i2 = R.string.nsdk_string_rp_on2off_network_error;
            }
        } else {
            i2 = R.string.nsdk_string_rp_toast_network_unconnected;
        }
        try {
            if (i2 != -1) {
                return JarUtils.getResources().getString(i2);
            }
            return JarUtils.getResources().getString(R.string.nsdk_string_rp_toast_calc_route_failed);
        } catch (Exception unused) {
            return "";
        }
    }
}
