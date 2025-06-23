package com.jd.ad.sdk.jad_tc;

import android.graphics.Color;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.jd.ad.sdk.jad_ud.jad_cp;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class jad_vi {
    public static final jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", MediationConstant.ADN_KS, TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", "sr", UserDataStore.STATE, IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "tm", "cl", "hd");
    public static final jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("d", "a");
    public static final jad_cp.jad_an jad_cp = jad_cp.jad_an.jad_an("ty", "nm");

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length];
            jad_an = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:302:0x03a8. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x005b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.jd.ad.sdk.jad_ra.jad_er jad_an(com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
        ArrayList arrayList;
        int i;
        String str;
        String str2;
        String str3;
        char c;
        char c2;
        String str4;
        String str5;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar3;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar4;
        char c3;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jad_cpVar.jad_cp();
        boolean z = false;
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        boolean z2 = true;
        long j = -1;
        float f = 0.0f;
        int i2 = 0;
        String str6 = null;
        com.jd.ad.sdk.jad_py.jad_ly jad_lyVar = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 1.0f;
        float f3 = 0.0f;
        int i6 = 0;
        int i7 = 0;
        com.jd.ad.sdk.jad_py.jad_jw jad_jwVar = null;
        com.jd.ad.sdk.jad_py.jad_kx jad_kxVar = null;
        int i8 = 1;
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar5 = null;
        boolean z3 = false;
        com.jd.ad.sdk.jad_qz.jad_an jad_anVar = null;
        jad_jw jad_jwVar2 = null;
        float f4 = 0.0f;
        long j2 = 0;
        String str7 = "UNSET";
        String str8 = null;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    str7 = jad_cpVar.jad_ly();
                    z2 = true;
                    z = false;
                    break;
                case 1:
                    j2 = jad_cpVar.jad_jw();
                    z2 = true;
                    z = false;
                    break;
                case 2:
                    str6 = jad_cpVar.jad_ly();
                    z2 = true;
                    z = false;
                    break;
                case 3:
                    str2 = str8;
                    int jad_jw = jad_cpVar.jad_jw();
                    i2 = 7;
                    if (jad_jw < 6) {
                        i2 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(7)[jad_jw];
                    }
                    str8 = str2;
                    z2 = true;
                    z = false;
                    break;
                case 4:
                    str2 = str8;
                    j = jad_cpVar.jad_jw();
                    str8 = str2;
                    z2 = true;
                    z = false;
                    break;
                case 5:
                    i3 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    z2 = true;
                    z = false;
                    break;
                case 6:
                    i4 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    z2 = true;
                    z = false;
                    break;
                case 7:
                    i5 = Color.parseColor(jad_cpVar.jad_ly());
                    z2 = true;
                    z = false;
                    break;
                case 8:
                    jad_lyVar = jad_cp.jad_an(jad_cpVar, jad_jtVar);
                    z2 = true;
                    z = false;
                    break;
                case 9:
                    str2 = str8;
                    int jad_jw2 = jad_cpVar.jad_jw();
                    if (jad_jw2 >= com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length) {
                        jad_jtVar.jad_an("Unsupported matte type: " + jad_jw2);
                    } else {
                        i8 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6)[jad_jw2];
                        int i9 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i8)];
                        if (i9 != 1) {
                            str3 = i9 == 2 ? "Unsupported matte type: Luma Inverted" : "Unsupported matte type: Luma";
                            jad_jtVar.jad_ob++;
                        }
                        jad_jtVar.jad_an(str3);
                        jad_jtVar.jad_ob++;
                    }
                    str8 = str2;
                    z2 = true;
                    z = false;
                    break;
                case 10:
                    str2 = str8;
                    com.jd.ad.sdk.jad_py.jad_hu jad_huVar = null;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        com.jd.ad.sdk.jad_py.jad_hu jad_huVar2 = jad_huVar;
                        com.jd.ad.sdk.jad_py.jad_dq jad_dqVar = jad_huVar2;
                        int i10 = 0;
                        boolean z4 = false;
                        while (jad_cpVar.jad_jt()) {
                            String jad_kx = jad_cpVar.jad_kx();
                            jad_kx.getClass();
                            switch (jad_kx.hashCode()) {
                                case 111:
                                    if (jad_kx.equals("o")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 3588:
                                    if (jad_kx.equals("pt")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 104433:
                                    if (jad_kx.equals("inv")) {
                                        c = 2;
                                        break;
                                    }
                                    break;
                                case 3357091:
                                    if (jad_kx.equals("mode")) {
                                        c = 3;
                                        break;
                                    }
                                    break;
                            }
                            c = 65535;
                            switch (c) {
                                case 0:
                                    jad_dqVar = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                                    break;
                                case 1:
                                    jad_huVar2 = new com.jd.ad.sdk.jad_py.jad_hu(jad_uh.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_ve.jad_hu.jad_an(), jad_gr.jad_an, false));
                                    jad_dqVar = jad_dqVar;
                                    break;
                                case 2:
                                    z4 = jad_cpVar.jad_hu();
                                    break;
                                case 3:
                                    String jad_ly = jad_cpVar.jad_ly();
                                    jad_ly.getClass();
                                    switch (jad_ly.hashCode()) {
                                        case 97:
                                            if (jad_ly.equals("a")) {
                                                c2 = 0;
                                                break;
                                            }
                                            break;
                                        case 105:
                                            if (jad_ly.equals("i")) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                        case 110:
                                            if (jad_ly.equals("n")) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 115:
                                            if (jad_ly.equals("s")) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                    }
                                    c2 = 65535;
                                    switch (c2) {
                                        case 0:
                                            break;
                                        case 1:
                                            jad_jtVar.jad_an("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            i10 = 3;
                                            break;
                                        case 2:
                                            i10 = 4;
                                            break;
                                        case 3:
                                            i10 = 2;
                                            break;
                                        default:
                                            com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Unknown mask mode " + jad_kx + ". Defaulting to Add.");
                                            break;
                                    }
                                    i10 = 1;
                                    break;
                                default:
                                    jad_cpVar.jad_ob();
                                    break;
                            }
                        }
                        jad_cpVar.jad_er();
                        arrayList2.add(new com.jd.ad.sdk.jad_qz.jad_jt(i10, jad_huVar2, jad_dqVar, z4));
                        jad_huVar = null;
                    }
                    jad_jtVar.jad_ob += arrayList2.size();
                    jad_cpVar.jad_dq();
                    str8 = str2;
                    z2 = true;
                    z = false;
                    break;
                case 11:
                    str2 = str8;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_qz.jad_cp jad_an2 = jad_hu.jad_an(jad_cpVar, jad_jtVar);
                        if (jad_an2 != null) {
                            arrayList3.add(jad_an2);
                        }
                    }
                    jad_cpVar.jad_dq();
                    str8 = str2;
                    z2 = true;
                    z = false;
                    break;
                case 12:
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        int jad_an3 = jad_cpVar.jad_an(jad_bo);
                        if (jad_an3 == 0) {
                            jad_jwVar = new com.jd.ad.sdk.jad_py.jad_jw(jad_dq.jad_an(jad_cpVar, jad_jtVar, jad_iv.jad_an));
                        } else if (jad_an3 != 1) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_cpVar.jad_bo();
                            if (jad_cpVar.jad_jt()) {
                                jad_cp.jad_an jad_anVar2 = jad_bo.jad_an;
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_py.jad_kx jad_kxVar2 = null;
                                while (jad_cpVar.jad_jt()) {
                                    if (jad_cpVar.jad_an(jad_bo.jad_an) != 0) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_cpVar.jad_cp();
                                        com.jd.ad.sdk.jad_py.jad_an jad_anVar3 = null;
                                        com.jd.ad.sdk.jad_py.jad_an jad_anVar4 = null;
                                        com.jd.ad.sdk.jad_py.jad_bo jad_boVar6 = null;
                                        com.jd.ad.sdk.jad_py.jad_bo jad_boVar7 = null;
                                        while (jad_cpVar.jad_jt()) {
                                            int jad_an4 = jad_cpVar.jad_an(jad_bo.jad_bo);
                                            if (jad_an4 == 0) {
                                                jad_anVar3 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                            } else if (jad_an4 != 1) {
                                                if (jad_an4 != 2) {
                                                    str5 = str8;
                                                    if (jad_an4 != 3) {
                                                        jad_cpVar.jad_na();
                                                        jad_cpVar.jad_ob();
                                                    } else {
                                                        jad_boVar7 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                                    }
                                                } else {
                                                    str5 = str8;
                                                    jad_boVar6 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                                }
                                                str8 = str5;
                                            } else {
                                                jad_anVar4 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                            }
                                        }
                                        jad_cpVar.jad_er();
                                        jad_kxVar2 = new com.jd.ad.sdk.jad_py.jad_kx(jad_anVar3, jad_anVar4, jad_boVar6, jad_boVar7);
                                        str8 = str8;
                                    }
                                }
                                str4 = str8;
                                jad_cpVar.jad_er();
                                if (jad_kxVar2 == null) {
                                    jad_kxVar2 = new com.jd.ad.sdk.jad_py.jad_kx(null, null, null, null);
                                }
                                jad_kxVar = jad_kxVar2;
                            } else {
                                str4 = str8;
                            }
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_ob();
                            }
                            jad_cpVar.jad_dq();
                            str8 = str4;
                        }
                    }
                    jad_cpVar.jad_er();
                    z2 = true;
                    z = false;
                    break;
                case 13:
                    jad_cpVar.jad_bo();
                    ArrayList arrayList4 = new ArrayList();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        while (jad_cpVar.jad_jt()) {
                            int jad_an5 = jad_cpVar.jad_an(jad_cp);
                            if (jad_an5 == 0) {
                                int jad_jw3 = jad_cpVar.jad_jw();
                                if (jad_jw3 == 29) {
                                    jad_cp.jad_an jad_anVar5 = jad_er.jad_an;
                                    jad_anVar = null;
                                    while (jad_cpVar.jad_jt()) {
                                        if (jad_cpVar.jad_an(jad_er.jad_an) != 0) {
                                            jad_cpVar.jad_na();
                                            jad_cpVar.jad_ob();
                                        } else {
                                            jad_cpVar.jad_bo();
                                            while (jad_cpVar.jad_jt()) {
                                                jad_cpVar.jad_cp();
                                                com.jd.ad.sdk.jad_qz.jad_an jad_anVar6 = null;
                                                while (true) {
                                                    boolean z5 = false;
                                                    while (jad_cpVar.jad_jt()) {
                                                        int jad_an6 = jad_cpVar.jad_an(jad_er.jad_bo);
                                                        if (jad_an6 != 0) {
                                                            if (jad_an6 != z2) {
                                                                jad_cpVar.jad_na();
                                                                jad_cpVar.jad_ob();
                                                            } else if (z5) {
                                                                jad_anVar6 = new com.jd.ad.sdk.jad_qz.jad_an(jad_dq.jad_an(jad_cpVar, jad_jtVar, z2));
                                                            } else {
                                                                jad_cpVar.jad_ob();
                                                            }
                                                        } else if (jad_cpVar.jad_jw() == 0) {
                                                            z5 = true;
                                                        }
                                                    }
                                                    jad_cpVar.jad_er();
                                                    if (jad_anVar6 != null) {
                                                        jad_anVar = jad_anVar6;
                                                    }
                                                }
                                            }
                                            jad_cpVar.jad_dq();
                                        }
                                    }
                                } else if (jad_jw3 == 25) {
                                    jad_kx jad_kxVar3 = new jad_kx();
                                    while (jad_cpVar.jad_jt()) {
                                        if (jad_cpVar.jad_an(jad_kx.jad_fs) != 0) {
                                            jad_cpVar.jad_na();
                                            jad_cpVar.jad_ob();
                                        } else {
                                            jad_cpVar.jad_bo();
                                            while (jad_cpVar.jad_jt()) {
                                                jad_cpVar.jad_cp();
                                                String str9 = "";
                                                while (jad_cpVar.jad_jt()) {
                                                    int jad_an7 = jad_cpVar.jad_an(jad_kx.jad_jt);
                                                    if (jad_an7 != 0) {
                                                        if (jad_an7 == z2) {
                                                            str9.getClass();
                                                            switch (str9.hashCode()) {
                                                                case 353103893:
                                                                    if (str9.equals(JNISearchConst.JNI_DISTANCE)) {
                                                                        c3 = 0;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 397447147:
                                                                    if (str9.equals("Opacity")) {
                                                                        c3 = 1;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 1041377119:
                                                                    if (str9.equals("Direction")) {
                                                                        c3 = 2;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 1379387491:
                                                                    if (str9.equals("Shadow Color")) {
                                                                        c3 = 3;
                                                                        break;
                                                                    }
                                                                    break;
                                                                case 1383710113:
                                                                    if (str9.equals("Softness")) {
                                                                        c3 = 4;
                                                                        break;
                                                                    }
                                                                    break;
                                                            }
                                                            c3 = 65535;
                                                            switch (c3) {
                                                                case 0:
                                                                    jad_kxVar3.jad_dq = jad_dq.jad_an(jad_cpVar, jad_jtVar, z2);
                                                                    break;
                                                                case 1:
                                                                    jad_kxVar3.jad_bo = jad_dq.jad_an(jad_cpVar, jad_jtVar, z);
                                                                    break;
                                                                case 2:
                                                                    jad_kxVar3.jad_cp = jad_dq.jad_an(jad_cpVar, jad_jtVar, z);
                                                                    break;
                                                                case 3:
                                                                    jad_kxVar3.jad_an = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                                                    break;
                                                                case 4:
                                                                    jad_kxVar3.jad_er = jad_dq.jad_an(jad_cpVar, jad_jtVar, z2);
                                                                    break;
                                                            }
                                                        } else {
                                                            jad_cpVar.jad_na();
                                                        }
                                                        jad_cpVar.jad_ob();
                                                    } else {
                                                        str9 = jad_cpVar.jad_ly();
                                                    }
                                                }
                                                jad_cpVar.jad_er();
                                            }
                                            jad_cpVar.jad_dq();
                                        }
                                    }
                                    com.jd.ad.sdk.jad_py.jad_an jad_anVar7 = jad_kxVar3.jad_an;
                                    if (jad_anVar7 == null || (jad_boVar = jad_kxVar3.jad_bo) == null || (jad_boVar2 = jad_kxVar3.jad_cp) == null || (jad_boVar3 = jad_kxVar3.jad_dq) == null || (jad_boVar4 = jad_kxVar3.jad_er) == null) {
                                        z2 = true;
                                        z = false;
                                        jad_jwVar2 = null;
                                    } else {
                                        jad_jwVar2 = new jad_jw(jad_anVar7, jad_boVar, jad_boVar2, jad_boVar3, jad_boVar4);
                                    }
                                }
                            } else if (jad_an5 != z2) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                arrayList4.add(jad_cpVar.jad_ly());
                            }
                            z2 = true;
                            z = false;
                        }
                        jad_cpVar.jad_er();
                        z2 = true;
                        z = false;
                    }
                    jad_cpVar.jad_dq();
                    jad_jtVar.jad_an("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    z2 = true;
                    z = false;
                    break;
                case 14:
                    f2 = (float) jad_cpVar.jad_iv();
                    break;
                case 15:
                    f3 = (float) jad_cpVar.jad_iv();
                    break;
                case 16:
                    i6 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    break;
                case 17:
                    i7 = (int) (com.jd.ad.sdk.jad_ve.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    break;
                case 18:
                    f = (float) jad_cpVar.jad_iv();
                    break;
                case 19:
                    f4 = (float) jad_cpVar.jad_iv();
                    break;
                case 20:
                    jad_boVar5 = jad_dq.jad_an(jad_cpVar, jad_jtVar, z);
                    break;
                case 21:
                    str8 = jad_cpVar.jad_ly();
                    break;
                case 22:
                    z3 = jad_cpVar.jad_hu();
                    break;
                default:
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    str2 = str8;
                    str8 = str2;
                    z2 = true;
                    z = false;
                    break;
            }
        }
        String str10 = str8;
        jad_cpVar.jad_er();
        ArrayList arrayList5 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList2;
            i = i2;
            str = str10;
            arrayList5.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_jtVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList2;
            i = i2;
            str = str10;
        }
        if (f4 <= 0.0f) {
            f4 = jad_jtVar.jad_ly;
        }
        arrayList5.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_jtVar, valueOf, valueOf, null, f, Float.valueOf(f4)));
        arrayList5.add(new com.jd.ad.sdk.jad_wf.jad_an(jad_jtVar, valueOf2, valueOf2, null, f4, Float.valueOf(Float.MAX_VALUE)));
        if (str7.endsWith(".ai") || "ai".equals(str)) {
            jad_jtVar.jad_an("Convert your Illustrator layers to shape layers.");
        }
        return new com.jd.ad.sdk.jad_ra.jad_er(arrayList3, jad_jtVar, str7, j2, i, j, str6, arrayList, jad_lyVar, i3, i4, i5, f2, f3, i6, i7, jad_jwVar, jad_kxVar, arrayList5, i8, jad_boVar5, z3, jad_anVar, jad_jwVar2);
    }
}
