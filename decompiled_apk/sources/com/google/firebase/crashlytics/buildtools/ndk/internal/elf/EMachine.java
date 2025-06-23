package com.google.firebase.crashlytics.buildtools.ndk.internal.elf;

/* loaded from: classes10.dex */
public class EMachine {
    public static final int EM_386 = 3;
    public static final int EM_486 = 6;
    public static final int EM_56800EX = 200;
    public static final int EM_68HC05 = 72;
    public static final int EM_68HC08 = 71;
    public static final int EM_68HC11 = 70;
    public static final int EM_68HC12 = 53;
    public static final int EM_68HC16 = 69;
    public static final int EM_68K = 4;
    public static final int EM_78KOR = 199;
    public static final int EM_8051 = 165;
    public static final int EM_860 = 7;
    public static final int EM_88K = 5;
    public static final int EM_960 = 19;
    public static final int EM_AARCH64 = 183;
    public static final int EM_ALPHA = 41;
    public static final int EM_ALTERA_NIOS2 = 113;
    public static final int EM_ARC = 45;
    public static final int EM_ARCA = 109;
    public static final int EM_ARC_COMPACT = 93;
    public static final int EM_ARC_COMPACT2 = 195;
    public static final int EM_ARM = 40;
    public static final int EM_AVR = 83;
    public static final int EM_AVR32 = 185;
    public static final int EM_BLACKFIN = 106;
    public static final int EM_C166 = 116;
    public static final int EM_CE = 119;
    public static final int EM_CLOUDSHIELD = 192;
    public static final int EM_COLDFIRE = 52;
    public static final int EM_COREA_1ST = 193;
    public static final int EM_COREA_2ND = 194;
    public static final int EM_CR = 103;
    public static final int EM_CR16 = 177;
    public static final int EM_CRAYNV2 = 172;
    public static final int EM_CRIS = 76;
    public static final int EM_CRX = 114;
    public static final int EM_CUDA = 190;
    public static final int EM_CYPRESS_M8C = 161;
    public static final int EM_D10V = 85;
    public static final int EM_D30V = 86;
    public static final int EM_DSP24 = 136;
    public static final int EM_DSPIC30F = 118;
    public static final int EM_DXP = 112;
    public static final int EM_ECOG1 = 168;
    public static final int EM_ECOG16 = 176;
    public static final int EM_ECOG1X = 168;
    public static final int EM_ECOG2 = 134;
    public static final int EM_ETPU = 178;
    public static final int EM_EXCESS = 111;
    public static final int EM_F2MC16 = 104;
    public static final int EM_FIREPATH = 78;
    public static final int EM_FR20 = 37;
    public static final int EM_FR30 = 84;
    public static final int EM_FX66 = 66;
    public static final int EM_H8S = 48;
    public static final int EM_H8_300 = 46;
    public static final int EM_H8_300H = 47;
    public static final int EM_H8_500 = 49;
    public static final int EM_HEXAGON = 164;
    public static final int EM_HUANY = 81;
    public static final int EM_IA_64 = 50;
    public static final int EM_IP2K = 101;
    public static final int EM_JAVELIN = 77;
    public static final int EM_K10M = 181;
    public static final int EM_L10M = 180;
    public static final int EM_LATTICEMICO32 = 138;
    public static final int EM_M16C = 117;
    public static final int EM_M32 = 1;
    public static final int EM_M32C = 120;
    public static final int EM_M32R = 88;
    public static final int EM_MANIK = 171;
    public static final int EM_MAX = 102;
    public static final int EM_MAXQ30 = 169;
    public static final int EM_MCST_ELBRUS = 175;
    public static final int EM_ME16 = 59;
    public static final int EM_METAG = 174;
    public static final int EM_MIPS = 8;
    public static final int EM_MIPS_RS3_LE = 10;
    public static final int EM_MIPS_X = 51;
    public static final int EM_MMA = 54;
    public static final int EM_MMDSP_PLUS = 160;
    public static final int EM_MMIX = 80;
    public static final int EM_MN10200 = 90;
    public static final int EM_MN10300 = 89;
    public static final int EM_MSP430 = 105;
    public static final int EM_NCPU = 56;
    public static final int EM_NDR1 = 57;
    public static final int EM_NDS32 = 167;
    public static final int EM_NONE = 0;
    public static final int EM_NS32K = 97;
    public static final int EM_OPEN8 = 196;
    public static final int EM_OPENRISC = 92;
    public static final int EM_PARISC = 15;
    public static final int EM_PCP = 55;
    public static final int EM_PDP10 = 64;
    public static final int EM_PDP11 = 65;
    public static final int EM_PDSP = 63;
    public static final int EM_PJ = 91;
    public static final int EM_PPC = 20;
    public static final int EM_PPC64 = 21;
    public static final int EM_PRISM = 82;
    public static final int EM_R32C = 162;
    public static final int EM_RCE = 39;
    public static final int EM_RH32 = 38;
    public static final int EM_RL78 = 197;
    public static final int EM_RS08 = 132;
    public static final int EM_RX = 173;
    public static final int EM_S370 = 9;
    public static final int EM_S390 = 22;
    public static final int EM_SCORE7 = 135;
    public static final int EM_SEP = 108;
    public static final int EM_SE_C17 = 139;
    public static final int EM_SE_C33 = 107;
    public static final int EM_SH = 42;
    public static final int EM_SHARC = 133;
    public static final int EM_SLE9X = 179;
    public static final int EM_SNP1K = 99;
    public static final int EM_SPARC = 2;
    public static final int EM_SPARC32PLUS = 18;
    public static final int EM_SPARCV9 = 43;
    public static final int EM_SPU = 23;
    public static final int EM_ST100 = 60;
    public static final int EM_ST19 = 74;
    public static final int EM_ST200 = 100;
    public static final int EM_ST7 = 68;
    public static final int EM_ST9PLUS = 67;
    public static final int EM_STARCORE = 58;
    public static final int EM_STM8 = 186;
    public static final int EM_STXP7X = 166;
    public static final int EM_SVX = 73;
    public static final int EM_TILE64 = 187;
    public static final int EM_TILEGX = 191;
    public static final int EM_TILEPRO = 188;
    public static final int EM_TINYJ = 61;
    public static final int EM_TI_C2000 = 141;
    public static final int EM_TI_C5500 = 142;
    public static final int EM_TI_C6000 = 140;
    public static final int EM_TMM_GPP = 96;
    public static final int EM_TPC = 98;
    public static final int EM_TRICORE = 44;
    public static final int EM_TRIMEDIA = 163;
    public static final int EM_TSK3000 = 131;
    public static final int EM_UNICORE = 110;
    public static final int EM_V800 = 36;
    public static final int EM_V850 = 87;
    public static final int EM_VAX = 75;
    public static final int EM_VIDEOCORE = 95;
    public static final int EM_VIDEOCORE3 = 137;
    public static final int EM_VIDEOCORE5 = 198;
    public static final int EM_VPP500 = 17;
    public static final int EM_X86_64 = 62;
    public static final int EM_XGATE = 115;
    public static final int EM_XIMO16 = 170;
    public static final int EM_XTENSA = 94;
    public static final int EM_ZSP = 79;

    public static String getMachineName(int i) {
        if (i != 3) {
            if (i != 8) {
                if (i != 40) {
                    if (i != 62) {
                        if (i != 183) {
                            return "unknown";
                        }
                        return "aarch64";
                    }
                    return "x86_64";
                }
                return "arm";
            }
            return "mips";
        }
        return "x86";
    }
}
