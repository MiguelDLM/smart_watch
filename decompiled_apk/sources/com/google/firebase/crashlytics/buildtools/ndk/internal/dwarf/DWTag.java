package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.jieli.jl_rcsp.constant.WatchError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public enum DWTag {
    ARRAY_TYPE(1, "array_type"),
    CLASS_TYPE(2, "class_type"),
    ENTRY_POINT(3, "entry_point"),
    ENUMERATION_TYPE(4, "enumeration_type"),
    FORMAL_PARAMETER(5, "formal_parameter"),
    IMPORTED_DECLARATION(8, "imported_declaration"),
    LABEL(10, TTDownloadField.TT_LABEL),
    LEXICAL_BLOCK(11, "lexical_block"),
    MEMBER(13, "member"),
    POINTER_TYPE(15, "pointer_type"),
    REFERENCE_TYPE(16, "reference_type"),
    COMPILE_UNIT(17, "compile_unit"),
    STRING_TYPE(18, "string_type"),
    STRUCTURE_TYPE(19, "structure_type"),
    SUBROUTINE_TYPE(21, "subroutine_type"),
    TYPEDEF(22, "typedef"),
    UNION_TYPE(23, "union_type"),
    UNSPECIFIED_PARAMETERS(24, "unspecified_parameters"),
    VARIANT(25, "variant"),
    COMMON_BLOCK(26, "common_block"),
    COMMON_INCLUSION(27, "common_inclusion"),
    INHERITANCE(28, "inheritance"),
    INLINED_SUBROUTINE(29, "inlined_subroutine"),
    MODULE(30, "module"),
    PTR_TO_MEMBER_TYPE(31, "ptr_to_member_type"),
    SET_TYPE(32, "set_type"),
    SUBRANGE_TYPE(33, "subrange_type"),
    WITH_STMT(34, "with_stmt"),
    ACCESS_DECLARATION(35, "access_declaration"),
    BASE_TYPE(36, "base_type"),
    CATCH_BLOCK(37, "catch_block"),
    CONST_TYPE(38, "const_type"),
    CONSTANT(39, "constant"),
    ENUMERATOR(40, "enumerator"),
    FILE_TYPE(41, "file_type"),
    FRIEND(42, "friend"),
    NAMELIST(43, "namelist"),
    NAMELIST_ITEM(44, "namelist_item"),
    PACKED_TYPE(45, "packed_type"),
    SUBPROGRAM(46, "subprogram"),
    TEMPLATE_TYPE_PARAMETER(47, "template_type_parameter"),
    TEMPLATE_VALUE_PARAMETER(48, "template_value_parameter"),
    THROWN_TYPE(49, "thrown_type"),
    TRY_BLOCK(50, "try_block"),
    VARIANT_PART(51, "variant_part"),
    VARIABLE(52, "variable"),
    VOLATILE_TYPE(53, "volatile_type"),
    DWARF_PROCEDURE(54, "dwarf_procedure"),
    RESTRICT_TYPE(55, "restrict_type"),
    INTERFACE_TYPE(56, "interface_type"),
    NAMESPACE(57, "namespace"),
    IMPORTED_MODULE(58, "imported_module"),
    UNSPECIFIED_TYPE(59, "unspecified_type"),
    PARTIAL_UNIT(60, "partial_unit"),
    IMPORTED_UNIT(61, "imported_unit"),
    CONDITION(63, "condition"),
    SHARED_TYPE(64, "shared_type"),
    TYPE_UNIT(65, "type_unit"),
    RVALUE_REFERENCE_TYPE(66, "rvalue_reference_type"),
    TEMPLATE_ALIAS(67, "template_alias"),
    COARRAY_TYPE(68, "coarray_type"),
    GENERIC_SUBRANGE(69, "generic_subrange"),
    DYNAMIC_TYPE(70, "dynamic_type"),
    ATOMIC_TYPE(71, "atomic_type"),
    CALL_SITE(72, "call_site"),
    CALL_SITE_PARAMETER(73, "call_site_parameter"),
    SKELETON_UNIT(74, "skeleton_unit"),
    IMMUTABLE_TYPE(75, "immutable_type"),
    LO_USER(16512, "lo_user"),
    MIPS_LOOP(16513, "MIPS_loop"),
    FORMAT_LABEL(WatchError.ERR_FAT_DISK, "format_label"),
    FUNCTION_TEMPLATE(WatchError.ERR_FAT_INIT, "function_template"),
    CLASS_TEMPLATE(WatchError.ERR_FAT_NOT_READY, "class_template"),
    GNU_TEMPLATE_TEMPLATE_PARAM(WatchError.ERR_FAT_INVALID_NAME, "GNU_template_template_param"),
    GNU_TEMPLATE_PARAMETER_PACK(WatchError.ERR_FAT_DENIED, "GNU_template_parameter_pack"),
    GNU_FORMAL_PARAMETER_PACK(WatchError.ERR_FAT_EXIST, "GNU_formal_parameter_pack"),
    GNU_CALL_SITE(WatchError.ERR_FAT_INVALID_OBJECT, "GNU_call_site"),
    GNU_CALL_SITE_PARAMETER(WatchError.ERR_FAT_WRITE_PROTECTED, "GNU_call_site_parameter"),
    APPLE_PROPERTY(16896, "APPLE_property"),
    BORLAND_PROPERTY(45056, "BORLAND_property"),
    BORLAND_DELPHI_STRING(45057, "BORLAND_Delphi_string"),
    BORLAND_DELPHI_DYNAMIC_ARRAY(45058, "BORLAND_Delphi_dynamic_array"),
    BORLAND_DELPHI_SET(45059, "BORLAND_Delphi_set"),
    BORLAND_DELPHI_VARIANT(45060, "BORLAND_Delphi_variant"),
    HI_USER(65535, "hi_user");

    private static final Map<Integer, DWTag> LOOKUP = new HashMap();
    private static final String PREFIX = "DW_TAG_";
    private final String _fullName;
    private final String _name;
    private final int _value;

    static {
        for (DWTag dWTag : values()) {
            LOOKUP.put(Integer.valueOf(dWTag._value), dWTag);
        }
    }

    DWTag(int i, String str) {
        this._value = i;
        this._name = str;
        this._fullName = PREFIX + str;
    }

    public static DWTag fromValue(int i) {
        return LOOKUP.get(Integer.valueOf(i));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this._fullName;
    }
}
