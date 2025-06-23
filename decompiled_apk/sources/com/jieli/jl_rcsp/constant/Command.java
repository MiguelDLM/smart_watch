package com.jieli.jl_rcsp.constant;

import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.AiOperateCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.AlarmExpandCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.BatchHandler;
import com.jieli.jl_rcsp.model.cmdHandler.CustomCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.DataCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.DataTransferCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.DeviceExtendParamCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.DisconnectClassicBluetoothCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.ExternalFlashCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.FileBrowseCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.FileTransferCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.FunctionCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.GetDevConfigureCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.GetDevMD5CmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.GetLowLatencySettingsCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.GetTargetFeatureMapCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.GetTargetInfoCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.HealthDataCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.HealthSettingCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.LargeFileTransferCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.LrcCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.NFCOperationCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.NotifyAppInfoCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.NotifyCommunicationWayCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.NotifyPhoneNumberPlayModeCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.OtaCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.PhoneCallRequestCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.PublicSettingsCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.QueryPhoneBtInfoCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.RcspCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.ReadErrorMsgCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.ReadFileFromDeviceCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SearchDevCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SetDevStorageCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SettingsMtuCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SmallFileTransferCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SpeechCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SportsInfoStatusCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.SysInfoCmdHandler;
import com.jieli.jl_rcsp.model.cmdHandler.TwsCmdHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Command {
    public static final int CMD_ADV_DEVICE_NOTIFY = 194;
    public static final int CMD_ADV_DEV_REQUEST_OPERATION = 196;
    public static final int CMD_ADV_GET_INFO = 193;
    public static final int CMD_ADV_NOTIFY_SETTINGS = 195;
    public static final int CMD_ADV_SETTINGS = 192;
    public static final int CMD_AI_OPERATE = 50;
    public static final int CMD_APP_PUSH_INFO_DATA_TO_DEVICE = 161;
    public static final int CMD_BATCH = 38;
    public static final int CMD_CANCEL_LARGE_FILE_TRANSFER = 30;
    public static final int CMD_CUSTOM = 240;
    public static final int CMD_DATA = 1;
    public static final int CMD_DATA_TRANSFER = 48;
    public static final int CMD_DELETE_FILE_BY_NAME = 35;
    public static final int CMD_DEVICE_PUSH_INFO_DATA_TO_APP = 162;
    public static final int CMD_DEVICE_PUSH_SENSOR_LOG_TO_APP = 163;
    public static final int CMD_DEV_PARAM_EXTEND = 39;
    public static final int CMD_DISCONNECT_CLASSIC_BLUETOOTH = 6;
    public static final int CMD_EXTERNAL_FLASH_IO_CTRL = 26;
    public static final int CMD_EXTRA_CUSTOM = 255;
    public static final int CMD_FILE_BROWSE_DELETE = 31;
    public static final int CMD_FORMAT_DEVICE = 34;
    public static final int CMD_FUNCTION = 14;
    public static final int CMD_GET_DEVICE_CONFIG_INFO = 217;
    public static final int CMD_GET_DEV_MD5 = 212;
    public static final int CMD_GET_EXTERNAL_FLASH_MSG = 214;
    public static final int CMD_GET_HEALTH_DATA = 160;
    public static final int CMD_GET_LOW_LATENCY_SETTINGS = 213;
    public static final int CMD_GET_SYS_INFO = 7;
    public static final int CMD_GET_TARGET_FEATURE_MAP = 2;
    public static final int CMD_GET_TARGET_INFO = 3;
    public static final int CMD_HEALTH_SETTING = 165;
    public static final int CMD_LARGE_FILE_TRANSFER_GET_NAME = 32;
    public static final int CMD_LARGE_FILE_TRANSFER_OP = 29;
    public static final int CMD_LRC_GET_START = 15;
    public static final int CMD_LRC_GET_STOP = 16;
    public static final int CMD_LRC_PUSH_START_TTS = 17;
    public static final int CMD_NFC_OPERATION = 164;
    public static final int CMD_NOTIFY_DEVICE_APP_INFO = 208;
    public static final int CMD_NOTIFY_FILE_STRUCTURE_CHANGE = 242;

    @Deprecated
    public static final int CMD_NOTIFY_FILE_TRANSFER_OP = 24;
    public static final int CMD_NOTIFY_PREPARE_ENV = 33;
    public static final int CMD_OTA_ENTER_UPDATE_MODE = 227;
    public static final int CMD_OTA_EXIT_UPDATE_MODE = 228;
    public static final int CMD_OTA_GET_DEVICE_REFRESH_FIRMWARE_STATUS = 230;
    public static final int CMD_OTA_GET_DEVICE_UPDATE_FILE_INFO_OFFSET = 225;
    public static final int CMD_OTA_INQUIRE_DEVICE_IF_CAN_UPDATE = 226;
    public static final int CMD_OTA_NOTIFY_UPDATE_CONTENT_SIZE = 232;
    public static final int CMD_OTA_SEND_FIRMWARE_UPDATE_BLOCK = 229;
    public static final int CMD_PHONE_CALL_REQUEST = 10;
    public static final int CMD_PHONE_NUMBER_PLAY_MODE = 241;
    public static final int CMD_PUBLIC_SETTINGS = 51;
    public static final int CMD_QUERY_CONNECTED_PHONE_BT_INFO = 49;
    public static final int CMD_READ_ERROR_MSG = 41;
    public static final int CMD_READ_FILE_FROM_DEVICE = 36;
    public static final int CMD_REBOOT_DEVICE = 231;
    public static final int CMD_RECEIVE_SPEECH_CANCEL = 210;
    public static final int CMD_RECEIVE_SPEECH_START = 4;
    public static final int CMD_RECEIVE_SPEECH_STOP = 5;
    public static final int CMD_RTC_EXPAND = 37;
    public static final int CMD_SEARCH_DEVICE = 25;
    public static final int CMD_SETTINGS_COMMUNICATION_MTU = 209;
    public static final int CMD_SET_DEVICE_STORAGE = 216;
    public static final int CMD_SET_SYS_INFO = 8;
    public static final int CMD_SMALL_FILE_TRANSFER = 40;
    public static final int CMD_SPORTS_INFO_STATUS_SYNC = 166;
    public static final int CMD_START_FILE_BROWSE = 12;

    @Deprecated
    public static final int CMD_START_FILE_TRANSFER = 22;
    public static final int CMD_START_LARGE_FILE_TRANSFER = 27;
    public static final int CMD_STOP_FILE_BROWSE = 13;

    @Deprecated
    public static final int CMD_STOP_FILE_TRANSFER = 23;
    public static final int CMD_STOP_LARGE_FILE_TRANSFER = 28;
    public static final int CMD_SWITCH_DEVICE_REQUEST = 11;
    public static final int CMD_SYS_INFO_AUTO_UPDATE = 9;

    /* renamed from: a, reason: collision with root package name */
    public static Map<Integer, ICmdHandler> f17835a;

    public static Map<Integer, ICmdHandler> getValidCommandList() {
        Map<Integer, ICmdHandler> map = f17835a;
        if (map == null || map.size() == 0) {
            HashMap hashMap = new HashMap();
            f17835a = hashMap;
            hashMap.put(1, new DataCmdHandler());
            f17835a.put(2, new GetTargetFeatureMapCmdHandler());
            f17835a.put(3, new GetTargetInfoCmdHandler());
            f17835a.put(6, new DisconnectClassicBluetoothCmdHandler());
            f17835a.put(7, new SysInfoCmdHandler());
            f17835a.put(8, new SysInfoCmdHandler());
            f17835a.put(9, new SysInfoCmdHandler());
            f17835a.put(10, new PhoneCallRequestCmdHandler());
            f17835a.put(11, new NotifyCommunicationWayCmdHandler());
            f17835a.put(14, new FunctionCmdHandler());
            f17835a.put(225, new OtaCmdHandler());
            f17835a.put(226, new OtaCmdHandler());
            f17835a.put(227, new OtaCmdHandler());
            f17835a.put(228, new OtaCmdHandler());
            f17835a.put(229, new OtaCmdHandler());
            f17835a.put(230, new OtaCmdHandler());
            f17835a.put(231, new OtaCmdHandler());
            f17835a.put(232, new OtaCmdHandler());
            f17835a.put(212, new GetDevMD5CmdHandler());
            f17835a.put(208, new NotifyAppInfoCmdHandler());
            f17835a.put(209, new SettingsMtuCmdHandler());
            f17835a.put(Integer.valueOf(CMD_PHONE_NUMBER_PLAY_MODE), new NotifyPhoneNumberPlayModeCmdHandler());
            f17835a.put(216, new SetDevStorageCmdHandler());
            f17835a.put(Integer.valueOf(CMD_GET_DEVICE_CONFIG_INFO), new GetDevConfigureCmdHandler());
            f17835a.put(240, new RcspCmdHandler());
            f17835a.put(255, new CustomCmdHandler());
            f17835a.put(Integer.valueOf(CMD_GET_EXTERNAL_FLASH_MSG), new ExternalFlashCmdHandler());
            f17835a.put(26, new ExternalFlashCmdHandler());
            f17835a.put(27, new LargeFileTransferCmdHandler());
            f17835a.put(28, new LargeFileTransferCmdHandler());
            f17835a.put(29, new LargeFileTransferCmdHandler());
            f17835a.put(32, new LargeFileTransferCmdHandler());
            f17835a.put(30, new LargeFileTransferCmdHandler());
            f17835a.put(33, new LargeFileTransferCmdHandler());
            f17835a.put(22, new FileTransferCmdHandler());
            f17835a.put(23, new FileTransferCmdHandler());
            f17835a.put(24, new FileTransferCmdHandler());
            f17835a.put(12, new FileBrowseCmdHandler());
            f17835a.put(13, new FileBrowseCmdHandler());
            f17835a.put(31, new FileBrowseCmdHandler());
            f17835a.put(35, new FileBrowseCmdHandler());
            f17835a.put(15, new LrcCmdHandler());
            f17835a.put(16, new LrcCmdHandler());
            f17835a.put(17, new LrcCmdHandler());
            f17835a.put(34, new FileBrowseCmdHandler());
            f17835a.put(Integer.valueOf(CMD_NOTIFY_FILE_STRUCTURE_CHANGE), new FileBrowseCmdHandler());
            f17835a.put(36, new ReadFileFromDeviceCmdHandler());
            f17835a.put(161, new HealthDataCmdHandler());
            f17835a.put(162, new HealthDataCmdHandler());
            f17835a.put(163, new HealthDataCmdHandler());
            f17835a.put(37, new AlarmExpandCmdHandler());
            f17835a.put(38, new BatchHandler());
            f17835a.put(39, new DeviceExtendParamCmdHandler());
            f17835a.put(4, new SpeechCmdHandler());
            f17835a.put(5, new SpeechCmdHandler());
            f17835a.put(210, new SpeechCmdHandler());
            f17835a.put(213, new GetLowLatencySettingsCmdHandler());
            f17835a.put(192, new TwsCmdHandler());
            f17835a.put(193, new TwsCmdHandler());
            f17835a.put(194, new TwsCmdHandler());
            f17835a.put(195, new TwsCmdHandler());
            f17835a.put(196, new TwsCmdHandler());
            f17835a.put(25, new SearchDevCmdHandler());
            f17835a.put(160, new HealthDataCmdHandler());
            f17835a.put(164, new NFCOperationCmdHandler());
            f17835a.put(165, new HealthSettingCmdHandler());
            f17835a.put(166, new SportsInfoStatusCmdHandler());
            f17835a.put(40, new SmallFileTransferCmdHandler());
            f17835a.put(41, new ReadErrorMsgCmdHandler());
            f17835a.put(48, new DataTransferCmdHandler());
            f17835a.put(49, new QueryPhoneBtInfoCmdHandler());
            f17835a.put(50, new AiOperateCmdHandler());
            f17835a.put(51, new PublicSettingsCmdHandler());
        }
        return f17835a;
    }

    public static boolean isValidCmd(int i) {
        return getValidCommandList().containsKey(Integer.valueOf(i));
    }
}
