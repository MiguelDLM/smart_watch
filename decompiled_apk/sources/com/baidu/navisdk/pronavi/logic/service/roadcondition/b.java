package com.baidu.navisdk.pronavi.logic.service.roadcondition;

import OXOo.OOXIXo;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final b f7794a = new b();

    private b() {
    }

    private final String c(com.baidu.navisdk.module.pronavi.model.c cVar) {
        int i = cVar.e - cVar.d;
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        l0.a(i, l0.a.EN, sb);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "builder.toString()");
        return sb2;
    }

    public final int a(@OOXIXo com.baidu.navisdk.module.pronavi.model.c jamModel) {
        IIX0o.x0xO0oo(jamModel, "jamModel");
        int i = jamModel.c;
        if (i == 3) {
            int i2 = jamModel.b;
            if (i2 != 107) {
                if (i2 != 110) {
                    if (i2 != 401) {
                        if (i2 != 504 && i2 != 501 && i2 != 502) {
                            switch (i2) {
                                case 101:
                                    return R.drawable.nsdk_ugc_interaction_small_yongdu;
                                case 102:
                                    return R.drawable.nsdk_ugc_interaction_small_shigu;
                                case 103:
                                    return R.drawable.nsdk_ugc_interaction_small_guanzhi;
                                case 104:
                                    return R.drawable.nsdk_ugc_interaction_small_fenglu;
                                default:
                                    switch (i2) {
                                        case 403:
                                            return R.drawable.nsdk_ugc_jiebing;
                                        case 404:
                                            return R.drawable.nsdk_ugc_jiebing;
                                        case 405:
                                            return R.drawable.nsdk_ugc_interaction_small_jishui;
                                        default:
                                            return R.drawable.nsdk_ugc_interaction_small_yongdu;
                                    }
                            }
                        }
                        return R.drawable.nsdk_ugc_nishiliu;
                    }
                    return R.drawable.nsdk_ugc_interaction_small_dawu;
                }
                return R.drawable.nsdk_ugc_interaction_small_shigong;
            }
            return R.drawable.nsdk_ugc_interaction_small_weixian;
        }
        if (i == 1) {
            return R.drawable.nsdk_ugc_man;
        }
        return R.drawable.nsdk_ugc_interaction_small_yongdu;
    }

    @OOXIXo
    public final String b(@OOXIXo com.baidu.navisdk.module.pronavi.model.c jamModel) {
        IIX0o.x0xO0oo(jamModel, "jamModel");
        if (jamModel.n) {
            return "避开";
        }
        if (jamModel.c == 3) {
            int i = jamModel.b;
            if (i != 107) {
                if (i != 110) {
                    if (i != 401) {
                        if (i != 504) {
                            if (i != 501) {
                                if (i != 502) {
                                    switch (i) {
                                        case 101:
                                            return c(jamModel);
                                        case 102:
                                            return "事故";
                                        case 103:
                                            return "管制";
                                        case 104:
                                            return "封路";
                                        default:
                                            switch (i) {
                                                case 403:
                                                    return "结冰";
                                                case 404:
                                                    return "积雪";
                                                case 405:
                                                    return "积水";
                                                default:
                                                    if (g.COMMON_UI.b()) {
                                                        return "未知";
                                                    }
                                                    return "";
                                            }
                                    }
                                }
                                return "山体滑坡";
                            }
                            return "山体崩塌";
                        }
                        return "泥石流";
                    }
                    return "团雾";
                }
                return "施工";
            }
            return "危险";
        }
        return c(jamModel);
    }
}
