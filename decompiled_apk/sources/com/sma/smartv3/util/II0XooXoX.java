package com.sma.smartv3.util;

import androidx.core.text.util.LocalePreferences;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.kuaishou.weapon.p0.bi;
import com.kwad.sdk.m.e;
import com.szabh.smable3.entity.Languages;
import java.nio.charset.Charset;

/* loaded from: classes12.dex */
public final class II0XooXoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.oOoXoXO
    public String f24236II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.oOoXoXO
    public StringBuilder f24237oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f24231I0Io = new oIX0oI(null);

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final int[] f24235oxoX = {-20319, -20317, -20304, -20295, -20292, -20283, -20265, -20257, -20242, -20230, -20051, -20036, -20032, -20026, -20002, -19990, -19986, -19982, -19976, -19805, -19784, -19775, -19774, -19763, -19756, -19751, -19746, -19741, -19739, -19728, -19725, -19715, -19540, -19531, -19525, -19515, -19500, -19484, -19479, -19467, -19289, -19288, -19281, -19275, -19270, -19263, -19261, -19249, -19243, -19242, -19238, -19235, -19227, -19224, -19218, -19212, -19038, -19023, -19018, -19006, -19003, -18996, -18977, -18961, -18952, -18783, -18774, -18773, -18763, -18756, -18741, -18735, -18731, -18722, -18710, -18697, -18696, -18526, -18518, -18501, -18490, -18478, -18463, -18448, -18447, -18446, -18239, -18237, -18231, -18220, -18211, -18201, -18184, -18183, -18181, -18012, -17997, -17988, -17970, -17964, -17961, -17950, -17947, -17931, -17928, -17922, -17759, -17752, -17733, -17730, -17721, -17703, -17701, -17697, -17692, -17683, -17676, -17496, -17487, -17482, -17468, -17454, -17433, -17427, -17417, -17202, -17185, -16983, -16970, -16942, -16915, -16733, -16708, -16706, -16689, -16664, -16657, -16647, -16474, -16470, -16465, -16459, -16452, -16448, -16433, -16429, -16427, -16423, -16419, -16412, -16407, -16403, -16401, -16393, -16220, -16216, -16212, -16205, -16202, -16187, -16180, -16171, -16169, -16158, -16155, -15959, -15958, -15944, -15933, -15920, -15915, -15903, -15889, -15878, -15707, -15701, -15681, -15667, -15661, -15659, -15652, -15640, -15631, -15625, -15454, -15448, -15436, -15435, -15419, -15416, -15408, -15394, -15385, -15377, -15375, -15369, -15363, -15362, -15183, -15180, -15165, -15158, -15153, -15150, -15149, -15144, -15143, -15141, -15140, -15139, -15128, -15121, -15119, -15117, -15110, -15109, -14941, -14937, -14933, -14930, -14929, -14928, -14926, -14922, -14921, -14914, -14908, -14902, -14894, -14889, -14882, -14873, -14871, -14857, -14678, -14674, -14670, -14668, -14663, -14654, -14645, -14630, -14594, -14429, -14407, -14399, -14384, -14379, -14368, -14355, -14353, -14345, -14170, -14159, -14151, -14149, -14145, -14140, -14137, -14135, -14125, -14123, -14122, -14112, -14109, -14099, -14097, -14094, -14092, -14090, -14087, -14083, -13917, -13914, -13910, -13907, -13906, -13905, -13896, -13894, -13878, -13870, -13859, -13847, -13831, -13658, -13611, -13601, -13406, -13404, -13400, -13398, -13395, -13391, -13387, -13383, -13367, -13359, -13356, -13343, -13340, -13329, -13326, -13318, -13147, -13138, -13120, -13107, -13096, -13095, -13091, -13076, -13068, -13063, -13060, -12888, -12875, -12871, -12860, -12858, -12852, -12849, -12838, -12831, -12829, -12812, -12802, -12607, -12597, -12594, -12585, -12556, -12359, -12346, -12320, -12300, -12120, -12099, -12089, -12074, -12067, -12058, -12039, -11867, -11861, -11847, -11831, -11798, -11781, -11604, -11589, -11536, -11358, -11340, -11339, -11324, -11303, -11097, -11077, -11067, -11055, -11052, -11045, -11041, -11038, -11024, -11020, -11019, -11018, -11014, -10838, -10832, -10815, -10800, -10790, -10780, -10764, -10587, -10544, -10533, -10519, -10331, -10329, -10328, -10322, -10315, -10309, -10307, -10296, -10281, -10274, -10270, -10262, -10260, -10256, -10254};

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static String[] f24233X0o0xo = {"a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", e.TAG, Languages.DEFAULT_LANGUAGE, "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", UserDataStore.GENDER, "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "lv", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", TournamentShareDialogURIBuilder.f10996me, "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nv", "nuan", "nue", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", bi.y, "suan", "sui", LocalePreferences.FirstDayOfWeek.SUNDAY, "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"};

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0XooXoX f24234XO = new II0XooXoX();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static StringBuffer f24232Oxx0IOOO = new StringBuffer();

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final String I0Io(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
            XO().setLength(0);
            char charAt = str.charAt(0);
            String[] II0XooXoX2 = XXO0.X0o0xo.II0XooXoX(charAt);
            if (II0XooXoX2 != null) {
                XO().append(II0XooXoX2[0].charAt(0));
            } else {
                XO().append(charAt);
            }
            String stringBuffer = XO().toString();
            kotlin.jvm.internal.IIX0o.oO(stringBuffer, "toString(...)");
            return stringBuffer;
        }

        public final void II0XooXoX(@OXOo.OOXIXo StringBuffer stringBuffer) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(stringBuffer, "<set-?>");
            II0XooXoX.f24232Oxx0IOOO = stringBuffer;
        }

        @OXOo.OOXIXo
        public final String II0xO0(@OXOo.OOXIXo String chines) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(chines, "chines");
            XO().setLength(0);
            char[] charArray = chines.toCharArray();
            kotlin.jvm.internal.IIX0o.oO(charArray, "toCharArray(...)");
            x0xOIoO.II0xO0 iI0xO0 = new x0xOIoO.II0xO0();
            iI0xO0.X0o0xo(x0xOIoO.oIX0oI.f34103I0Io);
            iI0xO0.XO(x0xOIoO.I0Io.f34096I0Io);
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                if (charArray[i] > 128) {
                    try {
                        XO().append(XXO0.X0o0xo.xxIXOIIO(charArray[i], iI0xO0)[0]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    XO().append(charArray[i]);
                }
            }
            String stringBuffer = XO().toString();
            kotlin.jvm.internal.IIX0o.oO(stringBuffer, "toString(...)");
            return stringBuffer;
        }

        public final void Oxx0IOOO(@OXOo.OOXIXo String[] strArr) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(strArr, "<set-?>");
            II0XooXoX.f24233X0o0xo = strArr;
        }

        @OXOo.OOXIXo
        public final String[] X0o0xo() {
            return II0XooXoX.f24233X0o0xo;
        }

        @OXOo.OOXIXo
        public final StringBuffer XO() {
            return II0XooXoX.f24232Oxx0IOOO;
        }

        @OXOo.OOXIXo
        public final II0XooXoX oIX0oI() {
            return II0XooXoX.f24234XO;
        }

        @OXOo.OOXIXo
        public final String oxoX(@OXOo.OOXIXo String chines) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(chines, "chines");
            XO().setLength(0);
            char[] charArray = chines.toCharArray();
            kotlin.jvm.internal.IIX0o.oO(charArray, "toCharArray(...)");
            x0xOIoO.II0xO0 iI0xO0 = new x0xOIoO.II0xO0();
            iI0xO0.X0o0xo(x0xOIoO.oIX0oI.f34103I0Io);
            iI0xO0.XO(x0xOIoO.I0Io.f34096I0Io);
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                if (charArray[i] > 128) {
                    try {
                        XO().append(XXO0.X0o0xo.xxIXOIIO(charArray[i], iI0xO0)[0].charAt(0));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    XO().append(charArray[i]);
                }
            }
            String stringBuffer = XO().toString();
            kotlin.jvm.internal.IIX0o.oO(stringBuffer, "toString(...)");
            return stringBuffer;
        }

        public oIX0oI() {
        }
    }

    @OXOo.oOoXoXO
    public final String II0XooXoX() {
        return this.f24236II0xO0;
    }

    public final void OOXIXo(@OXOo.oOoXoXO String str) {
        this.f24236II0xO0 = str;
    }

    public final int Oxx0IOOO(String str) {
        byte b;
        byte b2 = 0;
        try {
            Charset forName = Charset.forName("gb2312");
            kotlin.jvm.internal.IIX0o.oO(forName, "forName(...)");
            byte[] bytes = str.getBytes(forName);
            kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
            if (bytes != null && bytes.length <= 2 && bytes.length > 0) {
                if (bytes.length == 1) {
                    b = bytes[0];
                } else {
                    b = 0;
                }
                try {
                    if (bytes.length == 2) {
                        return (((bytes[0] + 256) * 256) + (bytes[1] + 256)) - 65536;
                    }
                    return b;
                } catch (Exception unused) {
                    b2 = b;
                    return b2;
                }
            }
            throw new RuntimeException("illegal resource string");
        } catch (Exception unused2) {
        }
    }

    @OXOo.oOoXoXO
    public final String XO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "str");
        int Oxx0IOOO2 = Oxx0IOOO(str);
        if (Oxx0IOOO2 > 0 && Oxx0IOOO2 < 160) {
            return String.valueOf((char) Oxx0IOOO2);
        }
        int length = f24235oxoX.length;
        do {
            length--;
            if (-1 >= length) {
                return null;
            }
        } while (f24235oxoX[length] > Oxx0IOOO2);
        return f24233X0o0xo[length];
    }

    @OXOo.OOXIXo
    public final String xoIox() {
        return xxIXOIIO(this.f24236II0xO0);
    }

    @OXOo.OOXIXo
    public final String xxIXOIIO(@OXOo.oOoXoXO String str) {
        this.f24237oIX0oI = new StringBuilder();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            kotlin.jvm.internal.IIX0o.oO(substring, "substring(...)");
            byte[] bytes = substring.getBytes(kotlin.text.oxoX.f29581II0xO0);
            kotlin.jvm.internal.IIX0o.oO(bytes, "getBytes(...)");
            if (bytes.length >= 2 && (substring = XO(substring)) == null) {
                substring = "unknown";
            }
            StringBuilder sb = this.f24237oIX0oI;
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(sb);
            sb.append(substring);
            i = i2;
        }
        return String.valueOf(this.f24237oIX0oI);
    }
}
