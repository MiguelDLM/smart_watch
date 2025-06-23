package com.jieli.jl_rcsp.util;

import android.text.TextUtils;
import com.garmin.fit.xxXXXxIxo;
import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.AlarmExpandCmd;
import com.jieli.jl_rcsp.model.command.DisconnectClassicBluetoothCmd;
import com.jieli.jl_rcsp.model.command.FunctionCmd;
import com.jieli.jl_rcsp.model.command.GetDevConfigureCmd;
import com.jieli.jl_rcsp.model.command.NotifyCommunicationWayCmd;
import com.jieli.jl_rcsp.model.command.NotifyPrepareEnvCmd;
import com.jieli.jl_rcsp.model.command.ReadErrorMsgCmd;
import com.jieli.jl_rcsp.model.command.SearchDevCmd;
import com.jieli.jl_rcsp.model.command.SetDevStorageCmd;
import com.jieli.jl_rcsp.model.command.ai.AIOperateCmd;
import com.jieli.jl_rcsp.model.command.custom.CustomCmd;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.data.DataHasResponseCmd;
import com.jieli.jl_rcsp.model.command.external_flash.ExtFlashIOCtrlNoResponseCmd;
import com.jieli.jl_rcsp.model.command.external_flash.ExternalFlashIOCtrlCmd;
import com.jieli.jl_rcsp.model.command.external_flash.GetExternalFlashMsgCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartFileBrowseCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopFileTransferCmd;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;
import com.jieli.jl_rcsp.model.command.phone.PhoneCallRequestCmd;
import com.jieli.jl_rcsp.model.command.status.GetTargetInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.GetSysInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.SetSysInfoCmd;
import com.jieli.jl_rcsp.model.command.tws.GetADVInfoCmd;
import com.jieli.jl_rcsp.model.command.tws.SetADVInfoCmd;
import com.jieli.jl_rcsp.model.command.tws.SetDeviceNotifyAdvInfoCmd;
import com.jieli.jl_rcsp.model.command.upgrade.RebootDeviceCmd;
import com.jieli.jl_rcsp.model.command.watch.HealthSettingCmd;
import com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd;
import com.jieli.jl_rcsp.model.command.watch.RequestHealthDataCmd;
import com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.device.VoiceMode;
import com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr;
import com.jieli.jl_rcsp.model.parameter.AIOperateParam;
import com.jieli.jl_rcsp.model.parameter.CustomParam;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam;
import com.jieli.jl_rcsp.model.parameter.FunctionParam;
import com.jieli.jl_rcsp.model.parameter.GetADVInfoParam;
import com.jieli.jl_rcsp.model.parameter.GetSysInfoParam;
import com.jieli.jl_rcsp.model.parameter.GetTargetInfoParam;
import com.jieli.jl_rcsp.model.parameter.NotifyCommunicationWayParam;
import com.jieli.jl_rcsp.model.parameter.PhoneCallRequestParam;
import com.jieli.jl_rcsp.model.parameter.RebootDeviceParam;
import com.jieli.jl_rcsp.model.parameter.SearchDevParam;
import com.jieli.jl_rcsp.model.parameter.SetADVInfoParam;
import com.jieli.jl_rcsp.model.parameter.SetDeviceNotifyAdvInfoParam;
import com.jieli.jl_rcsp.model.parameter.SetSysInfoParam;
import com.jieli.jl_rcsp.model.parameter.StartFileBrowseParam;
import com.jieli.jl_rcsp.model.parameter.StartFileTransferParam;
import com.jieli.jl_rcsp.model.parameter.StopFileTransferParam;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes10.dex */
public class CommandBuilder {
    public static CommandBase buildAuditionAlarmBellCmd(byte b, byte b2, int i) {
        byte[] bArr = {1, b, b2};
        System.arraycopy(CHexConver.intToBigBytes(i), 0, bArr, 3, 4);
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 6);
        attrBean.setAttrData(bArr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) 2, arrayList);
    }

    public static CommandBase buildAuxPlayOrPauseCmd() {
        return buildFunctionCmd((byte) 3, (byte) 1, null);
    }

    public static CommandBase buildCustomCmd(byte[] bArr) {
        return new CustomCmd(new CustomParam(bArr));
    }

    public static CommandBase buildCustomCmdWithoutResponse(byte[] bArr) {
        return new CustomCmd(1, new CustomParam(bArr));
    }

    public static DataCmd buildDataCmd(CommandBase commandBase, byte[] bArr) {
        if (commandBase != null && bArr != null) {
            DataParam dataParam = new DataParam(bArr);
            dataParam.setXmOpCode(commandBase.getId());
            return new DataCmd(dataParam);
        }
        return null;
    }

    public static DataHasResponseCmd buildDataCmdWithResponse(CommandBase commandBase, byte[] bArr) {
        if (commandBase != null && bArr != null && bArr.length > 0) {
            DataParam dataParam = new DataParam(bArr);
            dataParam.setXmOpCode(commandBase.getId());
            return new DataHasResponseCmd(dataParam);
        }
        return null;
    }

    public static CommandBase buildDelAlarmCmd(AttrBean attrBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) 2, arrayList);
    }

    public static CommandBase buildDeleteNFCInfoSyncCmd(int i, short s) {
        return new NFCOperationCmd(new NFCOperationCmd.DeleteMsgParam(i, s));
    }

    public static CommandBase buildDisconnectClassicBluetoothCmd() {
        return new DisconnectClassicBluetoothCmd();
    }

    public static CommandBase buildExternalFlashDeleteFileEndCmd() {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(5).setFlag(0));
    }

    public static CommandBase buildExternalFlashDeleteFileStartCmd(String str) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(5).setFlag(1).setFilePath(str));
    }

    public static CommandBase buildExternalFlashEnableCustomWatchCmd(String str) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(3).setFlag(4).setFilePath(str));
    }

    public static CommandBase buildExternalFlashErasureDataCmd(int i, int i2) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(4).setOffset(i).setSize(i2));
    }

    public static CommandBase buildExternalFlashGetCurrentWatchMsgCmd() {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(3).setFlag(0));
    }

    public static CommandBase buildExternalFlashGetCustomBgInfoCmd(String str) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(3).setFlag(5).setFilePath(str));
    }

    public static CommandBase buildExternalFlashGetFileMsgCmd(String str) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(11).setFilePath(str));
    }

    public static CommandBase buildExternalFlashGetLeftSpaceCmd() {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(12));
    }

    public static CommandBase buildExternalFlashGetWatchVersionCmd(String str) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(3).setFlag(3).setFilePath(str));
    }

    public static CommandBase buildExternalFlashInsertNewFileEndCmd() {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(2).setFlag(0));
    }

    public static CommandBase buildExternalFlashInsertNewFileStartCmd(String str, int i) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(2).setFlag(1).setFilePath(str).setSize(i));
    }

    public static CommandBase buildExternalFlashOTAResourceCmd(boolean z) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(9).setFlag(!z ? 1 : 0));
    }

    public static CommandBase buildExternalFlashQueryWriteResultCmd(int i, short s) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(8).setFlag(i).setCrc16(s));
    }

    public static CommandBase buildExternalFlashReadDataCmd(int i, int i2, int i3) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(1).setFlag(i).setOffset(i2).setSize(i3));
    }

    public static CommandBase buildExternalFlashRestoreSystemCmd() {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(10));
    }

    public static CommandBase buildExternalFlashSetWatchCmd(String str) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(3).setFlag(1).setFilePath(str));
    }

    public static CommandBase buildExternalFlashUpdateResourceCmd(boolean z) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(7).setFlag(!z ? 1 : 0));
    }

    public static CommandBase buildExternalFlashWriteDataCmd(int i, int i2, byte[] bArr) {
        return new ExtFlashIOCtrlNoResponseCmd(new ExternalFlashIOCtrlParam().setOp(0).setFlag(i).setOffset(i2).setData(bArr));
    }

    public static CommandBase buildExternalFlashWriteProtectCmd(boolean z) {
        return new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam().setOp(6).setFlag(!z ? 1 : 0));
    }

    public static CommandBase buildFastForwardCmd(short s) {
        return buildFunctionCmd((byte) 1, (byte) 7, CHexConver.shortToBigBytes(s));
    }

    public static CommandBase buildFmDelChannelCmd(byte b) {
        return buildFunctionCmd((byte) 4, (byte) 8, new byte[]{b});
    }

    public static CommandBase buildFmFunctionCmd(byte b, byte[] bArr) {
        return buildFunctionCmd((byte) 4, b, bArr);
    }

    public static CommandBase buildFmNextChannelCmd() {
        return buildFunctionCmd((byte) 4, (byte) 5, null);
    }

    public static CommandBase buildFmNextFreqCmd() {
        return buildFunctionCmd((byte) 4, (byte) 3, null);
    }

    public static CommandBase buildFmPlayOrPauseCmd() {
        return buildFunctionCmd((byte) 4, (byte) 1, null);
    }

    public static CommandBase buildFmPrevChannelCmd() {
        return buildFunctionCmd((byte) 4, (byte) 4, null);
    }

    public static CommandBase buildFmPrevFreqCmd() {
        return buildFunctionCmd((byte) 4, (byte) 2, null);
    }

    public static CommandBase buildFmScanCmd(byte b) {
        return buildFunctionCmd((byte) 4, (byte) 6, new byte[]{b});
    }

    public static CommandBase buildFmSelChannelCmd(byte b) {
        return buildFunctionCmd((byte) 4, (byte) 7, new byte[]{b});
    }

    public static CommandBase buildFmSelectFreqCmd(float f) {
        int i = (int) (f * 10.0f);
        return buildFunctionCmd((byte) 4, (byte) 9, new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)});
    }

    public static CommandBase buildFunctionCmd(byte b, byte b2, byte[] bArr) {
        FunctionParam functionParam = new FunctionParam(b, b2);
        functionParam.setExtend(bArr);
        return new FunctionCmd(functionParam);
    }

    public static CommandBase buildGetADVInfoCmd(int i) {
        return new GetADVInfoCmd(new GetADVInfoParam(i));
    }

    public static CommandBase buildGetADVInfoCmdWithAll() {
        return buildGetADVInfoCmd(-1);
    }

    public static CommandBase buildGetAlarmCmd() {
        return buildGetSysInfoCmd((byte) 2, 18);
    }

    public static CommandBase buildGetAllVoiceModes() {
        return buildGetSysInfoCmd((byte) -1, 16384);
    }

    public static CommandBase buildGetAuxPlayStatueCmd() {
        return buildGetSysInfoCmd((byte) 3, 1);
    }

    public static CommandBase buildGetBrowseFileTypeCmd() {
        return buildGetPublicSysInfoCmd(32);
    }

    public static CommandBase buildGetBtSysInfoCmd() {
        return buildGetBtSysInfoCmd(xxXXXxIxo.f15726I0Io);
    }

    public static CommandBase buildGetCurrentVoiceMode() {
        return buildGetSysInfoCmd((byte) -1, 8192);
    }

    public static CommandBase buildGetDefaultAlarmBellsCmd() {
        return buildGetSysInfoCmd((byte) 2, 32);
    }

    public static CommandBase buildGetDefaultNfcOpCmd(int i) {
        return new NFCOperationCmd(new NFCOperationCmd.GetDefaultNfcParam(i));
    }

    public static CommandBase buildGetDevConfigureCmd() {
        return new GetDevConfigureCmd();
    }

    public static CommandBase buildGetDeviceInfoCmd(int i) {
        return new GetTargetInfoCmd(new GetTargetInfoParam(i));
    }

    public static CommandBase buildGetDeviceInfoCmdForAll() {
        return buildGetDeviceInfoCmd(-1);
    }

    public static CommandBase buildGetEqPresetAndEqValueCmd() {
        return buildGetPublicSysInfoCmd(4112);
    }

    public static CommandBase buildGetEqPresetValueCmd() {
        return buildGetPublicSysInfoCmd(4096);
    }

    public static CommandBase buildGetEqValueCmd() {
        return buildGetPublicSysInfoCmd(16);
    }

    public static CommandBase buildGetExternalFlashMsgCmd() {
        return new GetExternalFlashMsgCmd();
    }

    public static CommandBase buildGetFixedLenDataCmd() {
        return buildGetSysInfoCmd((byte) -1, 65536);
    }

    public static CommandBase buildGetFmChannelCmd() {
        return buildGetFmSysInfoCmd(2);
    }

    public static CommandBase buildGetFmStatueCmd() {
        return buildGetFmSysInfoCmd(1);
    }

    public static CommandBase buildGetFmSysInfoCmd(int i) {
        return buildGetSysInfoCmd((byte) 4, i);
    }

    public static CommandBase buildGetFrequencyTxInfoCmd() {
        return buildGetSysInfoCmd((byte) -1, 256);
    }

    public static CommandBase buildGetHealthDataInfoCmd(int i, int i2, byte... bArr) {
        return new RequestHealthDataCmd(new RequestHealthDataCmd.Param(i, (byte) i2, bArr));
    }

    public static CommandBase buildGetHealthSettingCmd(int i) {
        return new HealthSettingCmd(new HealthSettingCmd.GetParam(i));
    }

    public static CommandBase buildGetHighAndBassCmd() {
        return buildGetSysInfoCmd((byte) -1, 2048);
    }

    public static CommandBase buildGetLightControlInfoCmd() {
        return buildGetSysInfoCmd((byte) -1, 128);
    }

    public static CommandBase buildGetMusicFileInfoCmd() {
        return buildGetMusicSysInfoCmd(2);
    }

    public static CommandBase buildGetMusicPlayModeCmd() {
        return buildGetMusicSysInfoCmd(4);
    }

    public static CommandBase buildGetMusicStatusInfoCmd() {
        return buildGetMusicSysInfoCmd(1);
    }

    public static CommandBase buildGetMusicSysInfoCmd() {
        return buildGetMusicSysInfoCmd(xxXXXxIxo.f15726I0Io);
    }

    public static CommandBase buildGetPublicSysInfoCmd() {
        return buildGetPublicSysInfoCmd(65527);
    }

    public static CommandBase buildGetSoundCardEqInfo() {
        return buildGetPublicSysInfoCmd(393216);
    }

    public static CommandBase buildGetSoundCardStatusInfo() {
        return buildGetPublicSysInfoCmd(524288);
    }

    public static CommandBase buildGetSysInfoCmd(byte b, int i) {
        return new GetSysInfoCmd(new GetSysInfoParam(b, i));
    }

    public static CommandBase buildGetVolumeCmd() {
        return buildGetPublicSysInfoCmd(2);
    }

    public static CommandBase buildID3DataPushSwitch(byte b) {
        return buildFunctionCmd((byte) 0, (byte) 4, new byte[]{b});
    }

    public static CommandBase buildID3PlayNextCmd() {
        return buildFunctionCmd((byte) 0, (byte) 3, null);
    }

    public static CommandBase buildID3PlayOrPauseCmd() {
        return buildFunctionCmd((byte) 0, (byte) 1, null);
    }

    public static CommandBase buildID3PlayPrevCmd() {
        return buildFunctionCmd((byte) 0, (byte) 2, null);
    }

    public static CommandBase buildInsertNfcFileCmd(int i, int i2, String str) {
        return new NFCOperationCmd(new NFCOperationCmd.InsertFileParam(i, i2, str));
    }

    public static CommandBase buildInsertNfcFileEndCmd(int i, String str) {
        return new NFCOperationCmd(new NFCOperationCmd.InsertFileEndParam(i, str));
    }

    public static CommandBase buildModifyNFCInfoCmd(NFCOperationCmd.ModifyMsgParam modifyMsgParam) {
        return new NFCOperationCmd(modifyMsgParam);
    }

    public static CommandBase buildNextEqModeCmd() {
        return buildFunctionCmd((byte) 1, (byte) 5, null);
    }

    public static CommandBase buildNextPlaymodeCmd() {
        return buildFunctionCmd((byte) 1, (byte) 4, null);
    }

    public static CommandBase buildNotifyAIDialThumbSuccess(String str) {
        return new AIOperateCmd(new AIOperateParam().setOp(0).setFlag(4).setThumbPath(str));
    }

    public static CommandBase buildNotifyAIPaintStyle(String str) {
        return new AIOperateCmd(new AIOperateParam().setOp(0).setFlag(0).setAiDialStyle(str));
    }

    public static NotifyCommunicationWayCmd buildNotifyCommunicationWayCmd(int i, int i2) {
        return new NotifyCommunicationWayCmd(new NotifyCommunicationWayParam(i, i2));
    }

    public static CommandBase buildNotifyPrepareEnvCmd(byte b) {
        return new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.Param(b));
    }

    public static CommandBase buildPhoneCallCmd(String str) {
        PhoneCallRequestParam phoneCallRequestParam = new PhoneCallRequestParam(str);
        phoneCallRequestParam.setType(1);
        return new PhoneCallRequestCmd(phoneCallRequestParam);
    }

    public static CommandBase buildPlayNextCmd() {
        return buildFunctionCmd((byte) 1, (byte) 3, null);
    }

    public static CommandBase buildPlayOrPauseCmd() {
        return buildFunctionCmd((byte) 1, (byte) 1, null);
    }

    public static CommandBase buildPlayPrevCmd() {
        return buildFunctionCmd((byte) 1, (byte) 2, null);
    }

    public static CommandBase buildPushMessageInfoCmd(PushInfoDataToDeviceCmd.MessageData messageData) {
        return new PushInfoDataToDeviceCmd(new PushInfoDataToDeviceCmd.Param(messageData));
    }

    public static CommandBase buildReadBellArgsCmd(byte b) {
        return new AlarmExpandCmd(new AlarmExpandCmd.ReadRtcBellArgsParams(b));
    }

    public static CommandBase buildRebootCmd() {
        return new RebootDeviceCmd(new RebootDeviceParam(0));
    }

    public static CommandBase buildRemoveMessageCmd(PushInfoDataToDeviceCmd.RemoveMsg removeMsg) {
        return new PushInfoDataToDeviceCmd(new PushInfoDataToDeviceCmd.Param(removeMsg));
    }

    public static CommandBase buildRetreatQuicklyCmd(short s) {
        return buildFunctionCmd((byte) 1, (byte) 6, CHexConver.shortToBigBytes(s));
    }

    public static CommandBase buildSearchDevCmd(int i, int i2) {
        return buildSearchDevCmd(i, i2, 0, 0);
    }

    public static CommandBase buildSendPathDataCmd(PathData pathData) {
        return new StartFileBrowseCmd(new StartFileBrowseParam(pathData));
    }

    public static CommandBase buildSetADVInfoCmd(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new SetADVInfoCmd(new SetADVInfoParam(bArr));
    }

    public static CommandBase buildSetAlarmCmd(AttrBean attrBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) 2, arrayList);
    }

    public static CommandBase buildSetBellArgsCmd(AlarmExpandCmd.BellArg bellArg) {
        return new AlarmExpandCmd(new AlarmExpandCmd.SetRtcBellArgsParams(bellArg));
    }

    public static CommandBase buildSetBrowseFileTypeCmd(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[bytes.length + 1];
            bArr[0] = (byte) bytes.length;
            System.arraycopy(bytes, 0, bArr, 1, bytes.length);
            AttrBean attrBean = new AttrBean();
            attrBean.setType((byte) 5);
            attrBean.setAttrData(bArr);
            ArrayList arrayList = new ArrayList();
            arrayList.add(attrBean);
            return buildSetPublicSysInfoCmd(arrayList);
        }
        throw new IllegalArgumentException("文件类型参数不能为null");
    }

    public static CommandBase buildSetBtSysInfoCmd(List<AttrBean> list) {
        return buildSetSysInfoCmd((byte) 0, list);
    }

    public static CommandBase buildSetCurrentVoiceMode(VoiceMode voiceMode) {
        if (voiceMode == null) {
            return null;
        }
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 13);
        attrBean.setAttrData(voiceMode.getBytes());
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) -1, arrayList);
    }

    public static CommandBase buildSetDefaultNfcOpCmd(int i, short s) {
        return new NFCOperationCmd(new NFCOperationCmd.SetDefaultNfcParam(i, s));
    }

    public static CommandBase buildSetDeviceNotifyADVInfoCmd(int i) {
        return new SetDeviceNotifyAdvInfoCmd(new SetDeviceNotifyAdvInfoParam(i));
    }

    public static CommandBase buildSetDeviceStorageCmd(int i) {
        return new SetDevStorageCmd(i);
    }

    @Deprecated
    public static CommandBase buildSetEqValueCmd(byte b, byte[] bArr) {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 4);
        byte[] bArr2 = new byte[11];
        bArr2[0] = b;
        if (bArr != null && bArr.length == 10) {
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        }
        attrBean.setAttrData(bArr2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetPublicSysInfoCmd(arrayList);
    }

    public static CommandBase buildSetFixedLenDataCmd(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[bArr.length + 4];
        byte[] intToBigBytes = CHexConver.intToBigBytes(i);
        System.arraycopy(intToBigBytes, 0, bArr2, 0, intToBigBytes.length);
        System.arraycopy(bArr, 0, bArr2, intToBigBytes.length, bArr.length);
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 16);
        attrBean.setAttrData(bArr2);
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) -1, arrayList);
    }

    public static CommandBase buildSetFrequencyTxInfoCmd(byte[] bArr) {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 8);
        attrBean.setAttrData(bArr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) -1, arrayList);
    }

    public static CommandBase buildSetHealthSettingCmd(List<AttrBean> list) {
        return new HealthSettingCmd(new HealthSettingCmd.SetParam(list));
    }

    public static CommandBase buildSetHighAndBassCmd(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 11);
        byte[] bArr = new byte[8];
        byte[] intToBigBytes = CHexConver.intToBigBytes(i);
        System.arraycopy(CHexConver.intToBigBytes(i2), 0, bArr, 0, 4);
        System.arraycopy(intToBigBytes, 0, bArr, 4, 4);
        attrBean.setAttrData(bArr);
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) -1, arrayList);
    }

    public static CommandBase buildSetLightControlInfoCmd(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 7);
        attrBean.setAttrData(bArr);
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) -1, arrayList);
    }

    public static CommandBase buildSetMusicPlayModeCmd(byte b) {
        byte[] bArr = {b};
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 2);
        attrBean.setAttrData(bArr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetMusicSysInfoCmd(arrayList);
    }

    public static CommandBase buildSetMusicSysInfoCmd(List<AttrBean> list) {
        return buildSetSysInfoCmd((byte) 1, list);
    }

    public static CommandBase buildSetPublicSysInfoCmd(List<AttrBean> list) {
        return buildSetSysInfoCmd((byte) -1, list);
    }

    public static CommandBase buildSetSoundCardEqValue(byte[] bArr) {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 18);
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[0] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
        attrBean.setAttrData(bArr2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetPublicSysInfoCmd(arrayList);
    }

    public static CommandBase buildSetSoundCardInfo(byte b, int i) {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 19);
        attrBean.setAttrData(new byte[]{b, (byte) ((i >> 8) & 255), (byte) (i & 255)});
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetPublicSysInfoCmd(arrayList);
    }

    public static CommandBase buildSetSysInfoCmd(byte b, List<AttrBean> list) {
        return new SetSysInfoCmd(new SetSysInfoParam(b, list));
    }

    public static CommandBase buildSetVolumeCmd(int i) {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 1);
        attrBean.setAttrData(new byte[]{(byte) i});
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetPublicSysInfoCmd(arrayList);
    }

    public static CommandBase buildShutdownCmd() {
        return new RebootDeviceCmd(new RebootDeviceParam(1));
    }

    @Deprecated
    public static CommandBase buildStartFileTransferCmd(String str, int i, boolean z) {
        StartFileTransferParam startFileTransferParam = new StartFileTransferParam(str, i);
        startFileTransferParam.enableDataNeedResponse(z);
        return new StartFileTransferCmd(startFileTransferParam);
    }

    public static CommandBase buildStartNFCInfoSyncCmd(int i) {
        return new NFCOperationCmd(new NFCOperationCmd.StartSyncParam(i));
    }

    public static CommandBase buildStartReadErrorMsgCmd() {
        ReadErrorMsgCmd.ReadErrorMsgParam readErrorMsgParam = new ReadErrorMsgCmd.ReadErrorMsgParam();
        readErrorMsgParam.setOp(0);
        return new ReadErrorMsgCmd(readErrorMsgParam);
    }

    public static CommandBase buildStopAlarmCmd() {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 1);
        attrBean.setAttrData(new byte[]{2});
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) 2, arrayList);
    }

    public static CommandBase buildStopAuditionAlarmBellCmd() {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 6);
        attrBean.setAttrData(new byte[1]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) 2, arrayList);
    }

    public static CommandBase buildStopDeviceNotifyADVInfoCmd() {
        return buildSetDeviceNotifyADVInfoCmd(0);
    }

    @Deprecated
    public static CommandBase buildStopFileTransferCmd(int i) {
        return new StopFileTransferCmd(new StopFileTransferParam(i));
    }

    public static CommandBase buildStopReadErrorMsgCmd() {
        ReadErrorMsgCmd.ReadErrorMsgParam readErrorMsgParam = new ReadErrorMsgCmd.ReadErrorMsgParam();
        readErrorMsgParam.setOp(1);
        return new ReadErrorMsgCmd(readErrorMsgParam);
    }

    public static CommandBase buildSwitchBtModeCmd() {
        return buildSwitchModeCmd((byte) 0);
    }

    public static CommandBase buildSwitchFMModeCmd() {
        return buildSwitchModeCmd((byte) 4);
    }

    public static CommandBase buildSwitchLineInModeCmd() {
        return buildSwitchModeCmd((byte) 3);
    }

    public static CommandBase buildSwitchModeCmd(byte b) {
        return buildFunctionCmd((byte) -1, b, null);
    }

    public static CommandBase buildSwitchMusicModeCmd() {
        return buildSwitchModeCmd((byte) 1);
    }

    public static CommandBase buildSwitchRtcModeCmd() {
        return buildSwitchModeCmd((byte) 2);
    }

    public static CommandBase buildSyncSportsStatusCmd(SportsInfoStatusSyncCmd.Param param) {
        return new SportsInfoStatusSyncCmd(param);
    }

    public static CommandBase buildSyncTimeCmd(Calendar calendar) {
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 0);
        int i = calendar.get(1);
        attrBean.setAttrData(new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255), (byte) (calendar.get(2) + 1), (byte) calendar.get(5), (byte) calendar.get(11), (byte) calendar.get(12), (byte) calendar.get(13)});
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetSysInfoCmd((byte) 2, arrayList);
    }

    public static CommandBase buildGetBtSysInfoCmd(int i) {
        return buildGetSysInfoCmd((byte) 0, i);
    }

    public static CommandBase buildGetDeviceInfoCmd(int i, byte b) {
        return new GetTargetInfoCmd(new GetTargetInfoParam(i).setPlatform(b));
    }

    public static CommandBase buildGetMusicSysInfoCmd(int i) {
        return buildGetSysInfoCmd((byte) 1, i);
    }

    public static CommandBase buildGetPublicSysInfoCmd(int i) {
        return buildGetSysInfoCmd((byte) -1, i);
    }

    public static CommandBase buildSearchDevCmd(int i, int i2, int i3, int i4) {
        SearchDevParam searchDevParam = new SearchDevParam(1, i, i2);
        searchDevParam.setWay(i3);
        searchDevParam.setPlayer(i4);
        return new SearchDevCmd(searchDevParam);
    }

    public static CommandBase buildSetHealthSettingCmd(IHealthSettingToAttr iHealthSettingToAttr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(iHealthSettingToAttr.toAttr());
        return buildSetHealthSettingCmd(arrayList);
    }

    public static CommandBase buildSetFrequencyTxInfoCmd(float f) {
        return buildSetFrequencyTxInfoCmd(CHexConver.int2byte2((int) Math.floor(f * 10.0f)));
    }

    public static CommandBase buildSetEqValueCmd(boolean z, byte b, byte[] bArr) {
        if (!z) {
            return buildSetEqValueCmd(b, bArr);
        }
        AttrBean attrBean = new AttrBean();
        attrBean.setType((byte) 4);
        byte[] bArr2 = new byte[bArr.length + 2];
        bArr2[0] = (byte) (b | 128);
        bArr2[1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        attrBean.setAttrData(bArr2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(attrBean);
        return buildSetPublicSysInfoCmd(arrayList);
    }
}
