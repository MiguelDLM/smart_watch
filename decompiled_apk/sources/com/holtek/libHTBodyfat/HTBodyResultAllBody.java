package com.holtek.libHTBodyfat;

import Ox0O.II0xO0;
import Ox0O.oIX0oI;
import XIXIX.OOXIXo;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Hashtable;

/* loaded from: classes10.dex */
public class HTBodyResultAllBody extends II0xO0 {

    /* renamed from: I0oOoX, reason: collision with root package name */
    public double f17108I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public double f17109IIX0o;

    /* renamed from: IO, reason: collision with root package name */
    public double f17110IO;

    /* renamed from: Io, reason: collision with root package name */
    public double f17111Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public double f17112IoOoX;

    /* renamed from: OI0, reason: collision with root package name */
    public double f17113OI0;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public double f17114X00IoxXI;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public double f17115XIxXXX0x0;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public double f17116XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public double f17117XX;

    /* renamed from: XoX, reason: collision with root package name */
    public double f17118XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public double f17119Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public double f17120XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public double f17121o0;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public double f17122oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public double f17123oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public double f17124oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public double f17125ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public double f17126oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public double f17127oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public double f17128x0o;

    /* renamed from: xI, reason: collision with root package name */
    public double f17129xI;

    /* renamed from: xII, reason: collision with root package name */
    public double f17130xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public double f17131xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public double f17132xxX;

    static {
        System.loadLibrary("Bodyfat_SDK");
    }

    private native double native_bmi();

    private native double[] native_bmi_ratinglist();

    private native int native_body_age();

    private native int native_body_score();

    private native int native_body_type();

    private native double native_bodyfat_freemass();

    private native double native_bodyfat_kg();

    private native double native_bodyfat_leftArm();

    private native double native_bodyfat_leftLeg();

    private native double native_bodyfat_percentage();

    private native double[] native_bodyfat_ratinglist();

    private native double native_bodyfat_rightArm();

    private native double native_bodyfat_rightLeg();

    private native double native_bodyfat_subcut();

    private native double[] native_bodyfat_subcut_ratinglist();

    private native double native_bodyfat_subcutkg();

    private native double native_bodyfat_trunk();

    private native double native_bodyfatkg_leftArm();

    private native double native_bodyfatkg_leftLeg();

    private native double native_bodyfatkg_rightArm();

    private native double native_bodyfatkg_rightLeg();

    private native double native_bodyfatkg_trunk();

    private native double native_bone_kg();

    private native double[] native_bone_ratinglist();

    private native void native_calcu_bodys();

    private native int native_checkbody(double d, double d2, int i, int i2);

    private native int[] native_exercise_plannerlist();

    private native int native_getbodyfat(int i, int i2, int i3, int i4, int i5, boolean z);

    private native double native_ideal_weight();

    private native double native_muscle_kg();

    private native double native_muscle_kg_leftarm();

    private native double native_muscle_kg_leftleg();

    private native double native_muscle_kg_rightarm();

    private native double native_muscle_kg_rightleg();

    private native double native_muscle_kg_trunk();

    private native double native_muscle_percentage();

    private native double native_muscle_percentage_leftarm();

    private native double native_muscle_percentage_leftleg();

    private native double native_muscle_percentage_rightarm();

    private native double native_muscle_percentage_rightleg();

    private native double native_muscle_percentage_trunk();

    private native double[] native_muscle_ratinglist();

    private native double native_protein_percentage();

    private native double[] native_protein_ratinglist();

    private native int native_vfal();

    private native int[] native_vfal_ratinglist();

    private native double native_water_percentage();

    private native double[] native_water_ratinglist();

    private native double native_z_allBody();

    private native double native_z_leftArm();

    private native double native_z_leftLeg();

    private native double native_z_rightArm();

    private native double native_z_rightLeg();

    public native int native_bmr();

    public native int[] native_bmr_ratinglist();

    public int oIX0oI(oIX0oI oix0oi) {
        native_checkbody(oix0oi.f2802oIX0oI, oix0oi.f2798II0xO0, oix0oi.f2796I0Io, oix0oi.f2803oxoX);
        int native_getbodyfat = native_getbodyfat(oix0oi.f2801XO, oix0oi.f2799Oxx0IOOO, oix0oi.f2797II0XooXoX, oix0oi.f2805xxIXOIIO, oix0oi.f2804xoIox, true);
        if (native_getbodyfat == 0) {
            this.f2777Oxx0IOOO = native_bodyfat_percentage();
            this.f2783XO = native_bodyfat_kg();
            this.f2769II0XooXoX = native_water_percentage();
            this.f2781X0o0xo = native_bone_kg();
            this.f2793xoIox = native_muscle_kg();
            this.f2774OOXIXo = native_muscle_percentage();
            this.f2790oxoX = native_vfal();
            this.f2768I0Io = native_bmr();
            this.f2770II0xO0 = native_bmi();
            this.f2792x0xO0oo = native_ideal_weight();
            this.f2787oO = native_body_age();
            this.f2795xxIXOIIO = native_protein_percentage();
            this.f2788oOoXoXO = native_bodyfat_subcut();
            this.f2789ooOOo0oXI = native_bodyfat_subcutkg();
            int[] native_exercise_plannerlist = native_exercise_plannerlist();
            this.f2782XI0IXoo.put("walking", String.valueOf(native_exercise_plannerlist[0]));
            this.f2782XI0IXoo.put("jogging", String.valueOf(native_exercise_plannerlist[1]));
            this.f2782XI0IXoo.put("bicycle", String.valueOf(native_exercise_plannerlist[2]));
            this.f2782XI0IXoo.put("swim", String.valueOf(native_exercise_plannerlist[3]));
            this.f2782XI0IXoo.put("mountain_climbing", String.valueOf(native_exercise_plannerlist[4]));
            this.f2782XI0IXoo.put("aerobic", String.valueOf(native_exercise_plannerlist[5]));
            this.f2782XI0IXoo.put("tabletennis", String.valueOf(native_exercise_plannerlist[6]));
            this.f2782XI0IXoo.put(FitnessActivities.TENNIS, String.valueOf(native_exercise_plannerlist[7]));
            this.f2782XI0IXoo.put("football", String.valueOf(native_exercise_plannerlist[8]));
            this.f2782XI0IXoo.put("oriental_fencing", String.valueOf(native_exercise_plannerlist[9]));
            this.f2782XI0IXoo.put("gateball", String.valueOf(native_exercise_plannerlist[10]));
            this.f2782XI0IXoo.put(FitnessActivities.BADMINTON, String.valueOf(native_exercise_plannerlist[11]));
            this.f2782XI0IXoo.put("racketball", String.valueOf(native_exercise_plannerlist[12]));
            this.f2782XI0IXoo.put("tae_kwon_do", String.valueOf(native_exercise_plannerlist[13]));
            this.f2782XI0IXoo.put(FitnessActivities.SQUASH, String.valueOf(native_exercise_plannerlist[14]));
            this.f2782XI0IXoo.put(FitnessActivities.BASKETBALL, String.valueOf(native_exercise_plannerlist[15]));
            this.f2782XI0IXoo.put("ropejumping", String.valueOf(native_exercise_plannerlist[16]));
            this.f2782XI0IXoo.put(FitnessActivities.GOLF, String.valueOf(native_exercise_plannerlist[17]));
            double[] native_bmi_ratinglist = native_bmi_ratinglist();
            this.f2778Oxx0xo.put("瘦-普通", String.valueOf(native_bmi_ratinglist[0]));
            this.f2778Oxx0xo.put("普通-偏胖", String.valueOf(native_bmi_ratinglist[1]));
            this.f2778Oxx0xo.put("偏胖-肥胖", String.valueOf(native_bmi_ratinglist[2]));
            int[] native_bmr_ratinglist = native_bmr_ratinglist();
            Hashtable<String, String> hashtable = new Hashtable<>();
            this.f2785oI0IIXIo = hashtable;
            hashtable.put("偏低-达标", String.valueOf(native_bmr_ratinglist[0]));
            double[] native_bodyfat_ratinglist = native_bodyfat_ratinglist();
            this.f2794xoXoI.put("偏瘦-标准", String.valueOf(native_bodyfat_ratinglist[0]));
            this.f2794xoXoI.put("标准-警惕", String.valueOf(native_bodyfat_ratinglist[1]));
            this.f2794xoXoI.put("警惕-偏胖", String.valueOf(native_bodyfat_ratinglist[2]));
            this.f2794xoXoI.put("偏胖-肥胖", String.valueOf(native_bodyfat_ratinglist[3]));
            double[] native_bone_ratinglist = native_bone_ratinglist();
            this.f2771IIXOooo.put("不足-标准", String.valueOf(native_bone_ratinglist[0]));
            this.f2771IIXOooo.put("标准-优秀", String.valueOf(native_bone_ratinglist[1]));
            double[] native_muscle_ratinglist = native_muscle_ratinglist();
            this.f2776OxI.put("不足-标准", String.valueOf(native_muscle_ratinglist[0]));
            this.f2776OxI.put("标准-优秀", String.valueOf(native_muscle_ratinglist[1]));
            int[] native_vfal_ratinglist = native_vfal_ratinglist();
            this.f2779OxxIIOOXO.put("标准-警惕", String.valueOf(native_vfal_ratinglist[0]));
            this.f2779OxxIIOOXO.put("警惕-危险", String.valueOf(native_vfal_ratinglist[1]));
            double[] native_water_ratinglist = native_water_ratinglist();
            this.f2784o00.put("不足-标准", String.valueOf(native_water_ratinglist[0]));
            this.f2784o00.put("标准-优秀", String.valueOf(native_water_ratinglist[1]));
            double[] native_bodyfat_subcut_ratinglist = native_bodyfat_subcut_ratinglist();
            this.f2780X0IIOO.put("低-标准", String.valueOf(native_bodyfat_subcut_ratinglist[0]));
            this.f2780X0IIOO.put("标准-高", String.valueOf(native_bodyfat_subcut_ratinglist[1]));
            double[] native_protein_ratinglist = native_protein_ratinglist();
            this.f2773O0xOxO.put("不足-标准", String.valueOf(native_protein_ratinglist[0]));
            this.f2773O0xOxO.put("标准-优秀", String.valueOf(native_protein_ratinglist[1]));
            this.f2772IXxxXO = native_body_score();
            this.f2775Oo = native_body_type();
            this.f2791x0XOIxOo = native_bodyfat_freemass();
            native_calcu_bodys();
            this.f17122oOXoIIIo = native_bodyfat_trunk();
            this.f17119Xx000oIo = native_bodyfat_leftLeg();
            this.f17114X00IoxXI = native_bodyfat_rightLeg();
            this.f17110IO = native_bodyfat_leftArm();
            this.f17130xII = native_bodyfat_rightArm();
            this.f17117XX = native_bodyfatkg_trunk();
            this.f17108I0oOoX = native_bodyfatkg_leftLeg();
            this.f17127oxxXoxO = native_bodyfatkg_rightLeg();
            this.f17118XoX = native_bodyfatkg_leftArm();
            this.f17126oxXx0IX = native_bodyfatkg_rightArm();
            this.f17125ooXIXxIX = native_muscle_percentage_trunk();
            this.f17129xI = native_muscle_percentage_leftleg();
            this.f17124oo0xXOI0I = native_muscle_percentage_rightleg();
            this.f17123oo = native_muscle_percentage_leftarm();
            this.f17112IoOoX = native_muscle_percentage_rightarm();
            this.f17128x0o = native_muscle_kg_trunk();
            this.f17116XOxIOxOx = native_muscle_kg_leftleg();
            this.f17113OI0 = native_muscle_kg_rightleg();
            this.f17111Io = native_muscle_kg_leftarm();
            this.f17121o0 = native_muscle_kg_rightarm();
        } else {
            if ((native_getbodyfat & 4) != 4 && (native_getbodyfat & 2) != 2) {
                this.f2770II0xO0 = native_bmi();
                this.f2792x0xO0oo = native_ideal_weight();
            } else {
                this.f2770II0xO0 = OOXIXo.f3760XO;
                this.f2792x0xO0oo = OOXIXo.f3760XO;
            }
            this.f2790oxoX = 0;
            this.f2777Oxx0IOOO = OOXIXo.f3760XO;
            this.f2769II0XooXoX = OOXIXo.f3760XO;
            this.f2793xoIox = OOXIXo.f3760XO;
            this.f2781X0o0xo = OOXIXo.f3760XO;
            this.f2768I0Io = 0;
            this.f2787oO = 0;
            this.f2795xxIXOIIO = OOXIXo.f3760XO;
            this.f2791x0XOIxOo = OOXIXo.f3760XO;
            this.f2775Oo = 0;
            this.f2772IXxxXO = 0;
            this.f2774OOXIXo = OOXIXo.f3760XO;
            this.f2783XO = OOXIXo.f3760XO;
            this.f2788oOoXoXO = OOXIXo.f3760XO;
            this.f2789ooOOo0oXI = OOXIXo.f3760XO;
            this.f17122oOXoIIIo = OOXIXo.f3760XO;
            this.f17119Xx000oIo = OOXIXo.f3760XO;
            this.f17114X00IoxXI = OOXIXo.f3760XO;
            this.f17110IO = OOXIXo.f3760XO;
            this.f17130xII = OOXIXo.f3760XO;
            this.f17117XX = OOXIXo.f3760XO;
            this.f17108I0oOoX = OOXIXo.f3760XO;
            this.f17127oxxXoxO = OOXIXo.f3760XO;
            this.f17118XoX = OOXIXo.f3760XO;
            this.f17126oxXx0IX = OOXIXo.f3760XO;
            this.f17125ooXIXxIX = OOXIXo.f3760XO;
            this.f17129xI = OOXIXo.f3760XO;
            this.f17124oo0xXOI0I = OOXIXo.f3760XO;
            this.f17123oo = OOXIXo.f3760XO;
            this.f17112IoOoX = OOXIXo.f3760XO;
            this.f17128x0o = OOXIXo.f3760XO;
            this.f17116XOxIOxOx = OOXIXo.f3760XO;
            this.f17113OI0 = OOXIXo.f3760XO;
            this.f17111Io = OOXIXo.f3760XO;
            this.f17121o0 = OOXIXo.f3760XO;
        }
        this.f17115XIxXXX0x0 = native_z_allBody();
        this.f17132xxX = native_z_leftLeg();
        this.f17120XxX0x0xxx = native_z_rightLeg();
        this.f17131xXxxox0I = native_z_leftArm();
        this.f17109IIX0o = native_z_rightArm();
        this.f2786oIX0oI = native_getbodyfat;
        return native_getbodyfat;
    }
}
