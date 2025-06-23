package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public enum DWForm {
    ADDR(1, "addr"),
    BLOCK2(3, "block2"),
    BLOCK4(4, "block4"),
    DATA2(5, "data2"),
    DATA4(6, "data4"),
    DATA8(7, "data8"),
    STRING(8, TypedValues.Custom.S_STRING),
    BLOCK(9, "block"),
    BLOCK1(10, "block1"),
    DATA1(11, "data1"),
    FLAG(12, "flag"),
    SDATA(13, "sdata"),
    STRP(14, "strp"),
    UDATA(15, "udata"),
    REF_ADDR(16, "ref_addr"),
    REF1(17, "ref1"),
    REF2(18, "ref2"),
    REF4(19, "ref4"),
    REF8(20, "ref8"),
    REF_UDATA(21, "ref_udata"),
    INDIRECT(22, DevicePublicKeyStringDef.INDIRECT),
    SEC_OFFSET(23, "sec_offset"),
    EXPRLOC(24, "exprloc"),
    FLAG_PRESENT(25, "flag_present"),
    STRX(26, "strx"),
    ADDRX(27, "addrx"),
    REF_SUP4(28, "ref_sup4"),
    STRP_SUP(29, "strp_sup"),
    DATA16(30, "data16"),
    LINE_STRP(31, "line_strp"),
    REF_SIG8(32, "ref_sig8"),
    IMPLICIT_CONST(33, "implicit_const"),
    LOCLISTX(34, "loclistx"),
    RNGLISTX(35, "rnglistx"),
    REF_SUP8(36, "ref_sup8"),
    STRX1(37, "strx1"),
    STRX2(38, "strx2"),
    STRX3(39, "strx3"),
    STRX4(40, "strx4"),
    ADDRX1(41, "addrx1"),
    ADDRX2(42, "addrx2"),
    ADDRX3(43, "addrx3"),
    ADDRX4(44, "addrx4");

    private static final Map<Integer, DWForm> LOOKUP = new HashMap();
    private static final String PREFIX = "DW_FORM_";
    private final String _fullName;
    private final String _name;
    private final int _value;

    static {
        for (DWForm dWForm : values()) {
            LOOKUP.put(Integer.valueOf(dWForm._value), dWForm);
        }
    }

    DWForm(int i, String str) {
        this._value = i;
        this._name = str;
        this._fullName = PREFIX + str;
    }

    public static DWForm fromValue(int i) {
        return LOOKUP.get(Integer.valueOf(i));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this._fullName;
    }
}
