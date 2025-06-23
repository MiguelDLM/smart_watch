package com.jieli.jl_rcsp.constant;

/* loaded from: classes.dex */
public class WatchError extends RcspErrorCode {
    public static final int ERR_CRC_CHECK = 12544;
    public static final int ERR_DATA_OVER_LIMIT = 16899;
    public static final int ERR_DEVICE_IN_CALLING = 12545;
    public static final int ERR_FAT_BEGIN = 16667;
    public static final int ERR_FAT_DENIED = 16647;
    public static final int ERR_FAT_DISK = 16641;
    public static final int ERR_FAT_END = 16668;
    public static final int ERR_FAT_EXIST = 16648;
    public static final int ERR_FAT_INIT = 16642;
    public static final int ERR_FAT_INVALID_DRIVE = 16651;
    public static final int ERR_FAT_INVALID_NAME = 16646;
    public static final int ERR_FAT_INVALID_OBJECT = 16649;
    public static final int ERR_FAT_INVALID_PARAMETER = 16659;
    public static final int ERR_FAT_JNI_INIT = 16662;
    public static final int ERR_FAT_LOCKED = 16656;
    public static final int ERR_FAT_MKFS_ABORTED = 16654;
    public static final int ERR_FAT_NOT_ENABLED = 16652;
    public static final int ERR_FAT_NOT_ENOUGH_CORE = 16657;
    public static final int ERR_FAT_NOT_READY = 16643;
    public static final int ERR_FAT_NO_FILE = 16644;
    public static final int ERR_FAT_NO_FILESYSTEM = 16653;
    public static final int ERR_FAT_NO_PATH = 16645;
    public static final int ERR_FAT_READ = 16664;
    public static final int ERR_FAT_SYNC = 16665;
    public static final int ERR_FAT_TIMEOUT = 16655;
    public static final int ERR_FAT_TOO_BIG = 16660;
    public static final int ERR_FAT_TOO_MANY_OPEN_FILES = 16658;
    public static final int ERR_FAT_WRITE = 16663;
    public static final int ERR_FAT_WRITE_PROTECTED = 16650;
    public static final int ERR_FUNC_NOT_SUPPORT = 4353;
    public static final int ERR_IN_PROGRESS = 4352;
    public static final int ERR_NETWORK_OTA_FAILED = 20481;
    public static final int ERR_NETWORK_OTA_TIMEOUT = 20482;
    public static final int ERR_NETWORK_OTA_UNKNOWN = 20480;
    public static final int ERR_NETWORK_OTA_WAITING_COMMAND_TIMEOUT = 20483;
    public static final int ERR_OP_NOT_ALLOW = 12546;
    public static final int ERR_RENAME_FILE = 16898;
    public static final int ERR_SPACE_TO_UPDATE = 16897;
    public static final int ERR_VERSION_NOT_MATCH = 16896;

    public static int fatfsToWatchErr(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return ERR_FAT_DISK;
            case 2:
                return ERR_FAT_INIT;
            case 3:
                return ERR_FAT_NOT_READY;
            case 4:
                return ERR_FAT_NO_FILE;
            case 5:
                return ERR_FAT_NO_PATH;
            case 6:
                return ERR_FAT_INVALID_NAME;
            case 7:
                return ERR_FAT_DENIED;
            case 8:
                return ERR_FAT_EXIST;
            case 9:
                return ERR_FAT_INVALID_OBJECT;
            case 10:
                return ERR_FAT_WRITE_PROTECTED;
            case 11:
                return ERR_FAT_INVALID_DRIVE;
            case 12:
                return ERR_FAT_NOT_ENABLED;
            case 13:
                return ERR_FAT_NO_FILESYSTEM;
            case 14:
                return ERR_FAT_MKFS_ABORTED;
            case 15:
                return ERR_FAT_TIMEOUT;
            case 16:
                return ERR_FAT_LOCKED;
            case 17:
                return ERR_FAT_NOT_ENOUGH_CORE;
            case 18:
                return ERR_FAT_TOO_MANY_OPEN_FILES;
            case 19:
                return ERR_FAT_INVALID_PARAMETER;
            case 20:
                return ERR_FAT_TOO_BIG;
            case 21:
            case 26:
            default:
                return i;
            case 22:
                return ERR_FAT_JNI_INIT;
            case 23:
                return ERR_FAT_WRITE;
            case 24:
                return ERR_FAT_READ;
            case 25:
                return ERR_FAT_SYNC;
            case 27:
                return ERR_FAT_BEGIN;
            case 28:
                return ERR_FAT_END;
        }
    }

    public static String getErrorDesc(int i) {
        if (i != 0) {
            if (i != 4097) {
                if (i != 4098) {
                    if (i != 4352) {
                        if (i != 4353) {
                            if (i != 16667) {
                                if (i == 16668) {
                                    return "Process end error.";
                                }
                                switch (i) {
                                    case 0:
                                        return "Success";
                                    case ERR_FAT_DISK /* 16641 */:
                                        return "A hard error occurred in the low level disk I/O layer.";
                                    case ERR_FAT_INIT /* 16642 */:
                                        return "Assertion failed.";
                                    case ERR_FAT_NOT_READY /* 16643 */:
                                        return "The physical drive cannot work.";
                                    case ERR_FAT_NO_FILE /* 16644 */:
                                        return "Could not find the file.";
                                    case ERR_FAT_NO_PATH /* 16645 */:
                                        return "Could not find the path.";
                                    case ERR_FAT_INVALID_NAME /* 16646 */:
                                        return "The path name format is invalid.";
                                    case ERR_FAT_DENIED /* 16647 */:
                                        return "Access denied due to prohibited access or directory full.";
                                    case ERR_FAT_EXIST /* 16648 */:
                                        return "Access denied due to prohibited access.";
                                    case ERR_FAT_INVALID_OBJECT /* 16649 */:
                                        return "The file/directory object is invalid.";
                                    case ERR_FAT_WRITE_PROTECTED /* 16650 */:
                                        return "The physical drive is write protected.";
                                    case ERR_FAT_INVALID_DRIVE /* 16651 */:
                                        return "The logical drive number is invalid.";
                                    case ERR_FAT_NOT_ENABLED /* 16652 */:
                                        return "The volume has no work area.";
                                    case ERR_FAT_NO_FILESYSTEM /* 16653 */:
                                        return "There is no valid FAT volume.";
                                    case ERR_FAT_MKFS_ABORTED /* 16654 */:
                                        return "The f_mkfs() aborted due to any problem.";
                                    case ERR_FAT_TIMEOUT /* 16655 */:
                                        return "Could not get a grant to access the volume within defined period.";
                                    case ERR_FAT_LOCKED /* 16656 */:
                                        return "The operation is rejected according to the file sharing policy.";
                                    case ERR_FAT_NOT_ENOUGH_CORE /* 16657 */:
                                        return "LFN working buffer could not be allocated.";
                                    case ERR_FAT_TOO_MANY_OPEN_FILES /* 16658 */:
                                        return "Number of open files > FF_FS_LOCK.";
                                    case ERR_FAT_INVALID_PARAMETER /* 16659 */:
                                        return "Given parameter is invalid";
                                    case ERR_FAT_TOO_BIG /* 16660 */:
                                        return "Image size to big, do not to support big size image.";
                                    case 20480:
                                        return "Undefined upgrade error code.";
                                    case 20481:
                                        return "Network module upgrade failed.";
                                    case ERR_NETWORK_OTA_TIMEOUT /* 20482 */:
                                        return "Network module upgrade timeout.";
                                    case ERR_NETWORK_OTA_WAITING_COMMAND_TIMEOUT /* 20483 */:
                                        return "Network module timeout waiting for upgrade command.";
                                    default:
                                        switch (i) {
                                            case 8192:
                                                return "The remote device is not connected.";
                                            case 8193:
                                                return "The device is not the same as the device in use.";
                                            case 8194:
                                                return "Failed to use system reflection function.";
                                            case 8195:
                                                return "Failed to auth device.";
                                            default:
                                                switch (i) {
                                                    case 12288:
                                                        return "Command sending failed.";
                                                    case 12289:
                                                        return "Failed to parse RCSP data.";
                                                    case 12290:
                                                        return "Waiting for a reply packet timed out.";
                                                    case 12291:
                                                        return "System is busy.";
                                                    case 12292:
                                                        return "Device returns a failed state.";
                                                    case 12293:
                                                        return "Device returns a failure result.";
                                                    default:
                                                        switch (i) {
                                                            case 12544:
                                                                return "CRC is error.";
                                                            case 12545:
                                                                return "The device is in calling.";
                                                            case 12546:
                                                                return "The operation is not allowed.";
                                                            default:
                                                                switch (i) {
                                                                    case 16384:
                                                                        return "Storage offline.";
                                                                    case 16385:
                                                                        return "File browsing.";
                                                                    case 16386:
                                                                        return "File data is loaded.";
                                                                    case 16387:
                                                                        return "Missing file data.";
                                                                    case 16388:
                                                                        return "Directory hierarchy is too deep.";
                                                                    case 16389:
                                                                        return "IO Exception.";
                                                                    default:
                                                                        switch (i) {
                                                                            case ERR_FAT_JNI_INIT /* 16662 */:
                                                                                return "Watch system has not been initialized.";
                                                                            case ERR_FAT_WRITE /* 16663 */:
                                                                                return "Write data failed.";
                                                                            case ERR_FAT_READ /* 16664 */:
                                                                                return "Read data failed.";
                                                                            case ERR_FAT_SYNC /* 16665 */:
                                                                                return "Sync data error.";
                                                                            default:
                                                                                switch (i) {
                                                                                    case 16896:
                                                                                        return "File information does not match.";
                                                                                    case 16897:
                                                                                        return "Insufficient space to update multiple files.";
                                                                                    case 16898:
                                                                                        return "Failed to rename the file.";
                                                                                    case ERR_DATA_OVER_LIMIT /* 16899 */:
                                                                                        return "The data sent exceeds the limit.";
                                                                                    default:
                                                                                        return "Unknown Code : " + i;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            return "Process start error.";
                        }
                        return "Feature not supported.";
                    }
                    return "Task is in progress.";
                }
                return "Cancel Operation.";
            }
            return "Invalid Parameter.";
        }
        return "Success";
    }
}
