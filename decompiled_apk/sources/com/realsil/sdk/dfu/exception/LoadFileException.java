package com.realsil.sdk.dfu.exception;

import com.realsil.sdk.dfu.DfuException;

/* loaded from: classes11.dex */
public class LoadFileException extends DfuException {
    public static final int ERROR_CODE_IMAGE_VERSION_LOW = 4114;
    public static final int ERROR_COMBINE_PACK_MISSING_BUD = 4105;
    public static final int ERROR_COMBINE_PACK_NOT_SUPPORTED = 4103;
    public static final int ERROR_COMBINE_PACK_NS = 4103;
    public static final int ERROR_COMBINE_PACK_SUB_FILE_INVALID = 4106;
    public static final int ERROR_DATA_IMAGE_VERSION_LOW = 4113;
    public static final int ERROR_IMAGE_FILE_LOAD_FAILED = 4097;
    public static final int ERROR_IMAGE_FILE_NOT_EXIST = 4100;
    public static final int ERROR_IMAGE_FILE_PATH_INVALID = 4098;
    public static final int ERROR_IMAGE_FILE_TYPE_CONFLICT = 4102;
    public static final int ERROR_IMAGE_IC_TYPE_CONFLICT = 4101;
    public static final int ERROR_IMAGE_INVALID_PATH = 4098;
    public static final int ERROR_IMAGE_NT_MULTI_PACK = 4103;
    public static final int ERROR_IMAGE_SUFFIX_INVALID = 4099;
    public static final int ERROR_INCOMPLETE_MISS_OTA_HEADER = 4115;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_NON_DUALBANK_NS_OTAHEADER = 4112;
    public static final int ERROR_PACK_EMPTY = 4110;
    public static final int ERROR_PACK_INCORRECT_FORMAT = 4117;
    public static final int ERROR_PACK_MP_NOT_SUPPORTED = 4116;
    public static final int ERROR_PACK_NOT_SUPPORT = 4107;
    public static final int ERROR_PACK_NOT_SUPPORTED = 4107;
    public static final int ERROR_PACK_NS_DUALBANK = 4111;
    public static final int ERROR_SECTION_SIZE_CHECK_FAILED = 4109;
    public static final int ERROR_SINGLE_NOT_SUPPORT = 4108;
    public static final int ERROR_VERSION_CHECK_LOW = 4104;
    public static final int SUCCESS = 4096;

    public LoadFileException(String str, int i) {
        super(str, i);
    }

    public LoadFileException(int i) {
        super(i);
    }
}
