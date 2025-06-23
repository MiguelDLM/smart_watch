package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import android.graphics.Color;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.ChannelInfo;
import com.jieli.jl_rcsp.model.device.DevStorageInfo;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.device.DynamicLimiterParam;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.jieli.jl_rcsp.model.device.EqPresetInfo;
import com.jieli.jl_rcsp.model.device.ExpandFunction;
import com.jieli.jl_rcsp.model.device.FmStatusInfo;
import com.jieli.jl_rcsp.model.device.ID3MusicInfo;
import com.jieli.jl_rcsp.model.device.LightControlInfo;
import com.jieli.jl_rcsp.model.device.MusicNameInfo;
import com.jieli.jl_rcsp.model.device.MusicStatusInfo;
import com.jieli.jl_rcsp.model.device.PlayModeInfo;
import com.jieli.jl_rcsp.model.device.ReverberationParam;
import com.jieli.jl_rcsp.model.device.VoiceMode;
import com.jieli.jl_rcsp.model.device.VolumeInfo;
import com.jieli.jl_rcsp.model.device.health.AutomaticPressureDetection;
import com.jieli.jl_rcsp.model.device.health.BloodOxygenMeasurementAlert;
import com.jieli.jl_rcsp.model.device.health.DisconnectReminder;
import com.jieli.jl_rcsp.model.device.health.EmergencyContact;
import com.jieli.jl_rcsp.model.device.health.ExerciseHeartRateReminder;
import com.jieli.jl_rcsp.model.device.health.FallDetection;
import com.jieli.jl_rcsp.model.device.health.HealthSettingInfo;
import com.jieli.jl_rcsp.model.device.health.HeartRateMeasure;
import com.jieli.jl_rcsp.model.device.health.LiftWristDetection;
import com.jieli.jl_rcsp.model.device.health.SedentaryReminder;
import com.jieli.jl_rcsp.model.device.health.SensorInfo;
import com.jieli.jl_rcsp.model.device.health.SleepDetection;
import com.jieli.jl_rcsp.model.device.health.UserInfo;
import com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class RcspDataHandler {
    public static final String c = "rcsp_handler";
    public static final int d = 64;

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f18028a;
    public final RcspEventListenerManager b;

    public RcspDataHandler(RcspOpImpl rcspOpImpl, RcspEventListenerManager rcspEventListenerManager) {
        this.f18028a = rcspOpImpl;
        this.b = rcspEventListenerManager;
    }

    public final void a(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        if (list == null || (deviceInfo = this.f18028a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0 && attrBean.getType() == 0) {
                boolean z = CHexConver.byteToInt(attrData[0]) == 1;
                JL_Log.i(c, "parseAUXData", "onAuxStatusChange >> " + z);
                deviceInfo.setAuxPlay(z);
                this.b.onAuxStatusChange(bluetoothDevice, z);
            }
        }
    }

    public final void b(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        String str;
        String str2;
        String str3;
        String str4;
        if (list == null || (deviceInfo = this.f18028a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        ID3MusicInfo iD3MusicInfo = deviceInfo.getiD3MusicInfo();
        if (iD3MusicInfo == null) {
            iD3MusicInfo = new ID3MusicInfo();
        }
        ID3MusicInfo iD3MusicInfo2 = iD3MusicInfo;
        boolean z = false;
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0) {
                switch (attrBean.getType()) {
                    case 0:
                        String byte2HexStr = CHexConver.byte2HexStr(attrData);
                        try {
                            str = new String(attrData, StandardCharsets.UTF_8);
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = null;
                        }
                        if (str != null && attrData.length == 64) {
                            str = str.substring(0, str.length() - 1) + "...";
                        }
                        iD3MusicInfo2.setTitle("00".equals(byte2HexStr) ? "" : str);
                        break;
                    case 1:
                        String byte2HexStr2 = CHexConver.byte2HexStr(attrData);
                        try {
                            str2 = new String(attrData, 0, attrData.length, StandardCharsets.UTF_8);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            str2 = null;
                        }
                        if (str2 != null && attrData.length == 64) {
                            str2 = str2.substring(0, str2.length() - 1) + "...";
                        }
                        iD3MusicInfo2.setArtist("00".equals(byte2HexStr2) ? "" : str2);
                        break;
                    case 2:
                        String byte2HexStr3 = CHexConver.byte2HexStr(attrData);
                        try {
                            str3 = new String(attrData, StandardCharsets.UTF_8);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            str3 = null;
                        }
                        if (str3 != null && attrData.length == 64) {
                            str3 = str3.substring(0, str3.length() - 1) + "...";
                        }
                        iD3MusicInfo2.setAlbum("00".equals(byte2HexStr3) ? "" : str3);
                        break;
                    case 3:
                        int byteToInt = CHexConver.byteToInt(attrData[0]);
                        JL_Log.d(c, "parseBtData", "id3 number: " + byteToInt);
                        iD3MusicInfo2.setNumber(byteToInt);
                        break;
                    case 4:
                        int bytesToInt = attrData.length >= 2 ? CHexConver.bytesToInt(attrData, 0, 2) : 0;
                        JL_Log.d(c, "parseBtData", "id3 allNum: " + bytesToInt);
                        iD3MusicInfo2.setTotal(bytesToInt);
                        break;
                    case 5:
                        try {
                            str4 = new String(attrData, 0, attrData.length, StandardCharsets.UTF_8);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            str4 = null;
                        }
                        JL_Log.d(c, "parseBtData", "id3 genre: " + str4);
                        iD3MusicInfo2.setGenre(str4);
                        break;
                    case 6:
                        int bytesToInt2 = attrData.length >= 2 ? CHexConver.bytesToInt(attrData, 0, 2) : 0;
                        JL_Log.i(c, "parseBtData", "id3 allTime: " + bytesToInt2);
                        iD3MusicInfo2.setTotalTime(bytesToInt2);
                        break;
                    case 7:
                        boolean z2 = (attrData[0] & 1) == 1;
                        JL_Log.d(c, "parseBtData", "id3 isPlay: " + z2);
                        iD3MusicInfo2.setPlayStatus(z2);
                        break;
                    case 8:
                        int bytesToInt3 = attrData.length >= 4 ? CHexConver.bytesToInt(attrData, 0, 4) / 1000 : 0;
                        JL_Log.d(c, "parseBtData", "id3 currentTime: " + bytesToInt3);
                        iD3MusicInfo2.setCurrentTime(bytesToInt3);
                        break;
                }
                z = true;
            }
        }
        if (z) {
            deviceInfo.setiD3MusicInfo(iD3MusicInfo2);
            this.b.onID3MusicInfo(bluetoothDevice, iD3MusicInfo2);
        }
    }

    public final void c(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        boolean z;
        int i;
        float f;
        if (list == null || (deviceInfo = this.f18028a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0) {
                byte type = attrBean.getType();
                int i2 = 1;
                if (type != 0) {
                    if (type == 1) {
                        ArrayList arrayList = new ArrayList();
                        int length = attrData.length;
                        while (length - i2 >= 3) {
                            int byteToInt = CHexConver.byteToInt(attrData[i2]);
                            float bytesToInt = CHexConver.bytesToInt(attrData[i2 + 1], attrData[i2 + 2]) / 10.0f;
                            i2 += 3;
                            arrayList.add(new ChannelInfo(byteToInt, bytesToInt));
                        }
                        deviceInfo.setChannelInfos(arrayList);
                        this.b.onFmChannelsChange(bluetoothDevice, arrayList);
                    }
                } else {
                    int i3 = 0;
                    if (CHexConver.byteToInt(attrData[0]) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (attrData.length > 1) {
                        i = CHexConver.byteToInt(attrData[1]);
                    } else {
                        i = 0;
                    }
                    if (attrData.length > 3) {
                        f = CHexConver.bytesToInt(attrData[2], attrData[3]) / 10.0f;
                    } else {
                        f = 0.0f;
                    }
                    if (attrData.length > 4) {
                        i3 = CHexConver.byteToInt(attrData[4]);
                    }
                    FmStatusInfo fmStatusInfo = new FmStatusInfo(z, i, f, i3);
                    deviceInfo.setFmStatusInfo(fmStatusInfo);
                    this.b.onFmStatusChange(bluetoothDevice, fmStatusInfo);
                }
            }
        }
    }

    public final void d(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        String str;
        String str2;
        boolean z;
        int i;
        int i2;
        if (list == null || (deviceInfo = this.f18028a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0) {
                byte type = attrBean.getType();
                boolean z2 = true;
                int i3 = 0;
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            int byteToInt = CHexConver.byteToInt(attrData[0]);
                            JL_Log.d(c, "parseMusicData", "music play mode : " + byteToInt);
                            PlayModeInfo playModeInfo = new PlayModeInfo(byteToInt);
                            deviceInfo.setPlayModeInfo(playModeInfo);
                            this.b.onPlayModeChange(bluetoothDevice, playModeInfo);
                        }
                    } else if (attrData.length > 3) {
                        byte[] bArr = new byte[4];
                        System.arraycopy(attrData, 0, bArr, 0, 4);
                        int bytesToInt = CHexConver.bytesToInt(bArr);
                        if (attrData.length > 4) {
                            if ((attrData[4] & 255) != 1) {
                                z2 = false;
                            }
                            if (attrData.length > 5) {
                                try {
                                    int length = attrData.length - 5;
                                    if (z2) {
                                        str2 = "gbk";
                                    } else {
                                        str2 = "utf-16le";
                                    }
                                    str = new String(attrData, 5, length, str2);
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                MusicNameInfo musicNameInfo = new MusicNameInfo(bytesToInt, str);
                                deviceInfo.setMusicNameInfo(musicNameInfo);
                                deviceInfo.setCluster(musicNameInfo.getCluster());
                                this.b.onMusicNameChange(bluetoothDevice, musicNameInfo);
                            }
                        }
                        str = null;
                        MusicNameInfo musicNameInfo2 = new MusicNameInfo(bytesToInt, str);
                        deviceInfo.setMusicNameInfo(musicNameInfo2);
                        deviceInfo.setCluster(musicNameInfo2.getCluster());
                        this.b.onMusicNameChange(bluetoothDevice, musicNameInfo2);
                    }
                } else {
                    if ((attrData[0] & 1) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (attrData.length > 4) {
                        byte[] bArr2 = new byte[4];
                        System.arraycopy(attrData, 1, bArr2, 0, 4);
                        int bytesToInt2 = CHexConver.bytesToInt(bArr2) * 1000;
                        if (attrData.length > 8) {
                            System.arraycopy(attrData, 5, bArr2, 0, 4);
                            i2 = CHexConver.bytesToInt(bArr2) * 1000;
                            if (attrData.length > 9) {
                                i = CHexConver.byteToInt(attrData[9]);
                                i3 = bytesToInt2;
                            }
                        } else {
                            i2 = 0;
                        }
                        i3 = bytesToInt2;
                        i = 0;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    MusicStatusInfo musicStatusInfo = new MusicStatusInfo(z, i3, i2, i);
                    deviceInfo.setMusicStatusInfo(musicStatusInfo);
                    deviceInfo.setCurrentDevIndex(CHexConver.intToByte(musicStatusInfo.getCurrentDev()));
                    this.b.onMusicStatusChange(bluetoothDevice, musicStatusInfo);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        boolean z;
        boolean z2;
        String str;
        DeviceInfo deviceInfo = this.f18028a.getDeviceInfo(bluetoothDevice);
        if (deviceInfo == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != 0 && attrData.length != 0) {
                int i = 1;
                int i2 = 0;
                switch (attrBean.getType()) {
                    case 0:
                        this.b.onBatteryChange(bluetoothDevice, new BatteryInfo(CHexConver.byteToInt(attrData[0])));
                        break;
                    case 1:
                        int maxVol = deviceInfo.getMaxVol();
                        boolean isSupportVolumeSync = deviceInfo.isSupportVolumeSync();
                        int byteToInt = CHexConver.byteToInt(attrData[0]);
                        deviceInfo.setVolume(byteToInt);
                        this.b.onVolumeChange(bluetoothDevice, new VolumeInfo(maxVol, byteToInt, isSupportVolumeSync));
                        break;
                    case 2:
                        DevStorageInfo devStorageInfo = new DevStorageInfo();
                        devStorageInfo.parseData(attrData);
                        deviceInfo.setDevStorageInfo(devStorageInfo);
                        this.b.onDevStorageInfoChange(bluetoothDevice, devStorageInfo);
                        break;
                    case 4:
                        byte b = attrData[0];
                        if ((b & 128) == 128) {
                            z = true;
                        } else {
                            z = false;
                        }
                        int byteToInt2 = CHexConver.byteToInt(b) & 127;
                        EqInfo eqInfo = new EqInfo();
                        eqInfo.setMode(byteToInt2);
                        eqInfo.setDynamic(z);
                        if (z) {
                            int i3 = attrData[1];
                            byte[] bArr = new byte[i3];
                            System.arraycopy(attrData, 2, bArr, 0, i3);
                            eqInfo.setValue(bArr);
                            EqPresetInfo a2 = a(list);
                            if (a2 == null) {
                                a2 = deviceInfo.getEqPresetInfo();
                            }
                            if (a2 != null) {
                                eqInfo.setFreqs(a2.getFreqs());
                            }
                            JL_Log.d(c, "parsePublicData", "eq data freq-->" + a2);
                        } else {
                            byte[] bArr2 = new byte[0];
                            if (attrData.length > 10) {
                                bArr2 = new byte[10];
                                System.arraycopy(attrData, 1, bArr2, 0, 10);
                            }
                            eqInfo.setValue(bArr2);
                        }
                        deviceInfo.setEqInfo(eqInfo);
                        this.b.onEqChange(bluetoothDevice, eqInfo);
                        break;
                    case 5:
                        try {
                            str = new String(attrData);
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = null;
                        }
                        deviceInfo.setPlayFileFormat(str);
                        this.b.onFileFormatChange(bluetoothDevice, str);
                        break;
                    case 6:
                        int byteToInt3 = CHexConver.byteToInt(attrData[0]);
                        deviceInfo.setCurFunction(attrData[0]);
                        JL_Log.i(c, "parsePublicData", "onDeviceModeChange >> " + byteToInt3);
                        this.b.onDeviceModeChange(bluetoothDevice, byteToInt3);
                        break;
                    case 7:
                        JL_Log.i(c, "parsePublicData", "SYS_INFO_ATTR_LIGHT");
                        int byteToInt4 = CHexConver.byteToInt(attrData[0]);
                        int byteToInt5 = CHexConver.byteToInt(attrData[1]);
                        int byteToInt6 = CHexConver.byteToInt(attrData[2]);
                        int byteToInt7 = CHexConver.byteToInt(attrData[3]);
                        int byteToInt8 = CHexConver.byteToInt(attrData[4]);
                        int byteToInt9 = CHexConver.byteToInt(attrData[5]);
                        int byteToInt10 = CHexConver.byteToInt(attrData[6]);
                        int bytesToInt = CHexConver.bytesToInt(attrData[7], attrData[8]);
                        LightControlInfo luminance = new LightControlInfo().setSwitchState(byteToInt4 & 3).setLightMode((byteToInt4 & 12) >>> 2).setColor(Color.rgb(byteToInt5, byteToInt6, byteToInt7)).setTwinkleMode(byteToInt8).setTwinkleFreq(byteToInt9).setSceneMode(byteToInt10).setHue(bytesToInt).setSaturation(CHexConver.byteToInt(attrData[9])).setLuminance(CHexConver.byteToInt(attrData[10]));
                        deviceInfo.setLightControlInfo(luminance);
                        this.b.onLightControlInfo(bluetoothDevice, luminance);
                        break;
                    case 8:
                        if (attrData.length >= 2 && attrData.length < 4) {
                            byte[] bArr3 = new byte[2];
                            System.arraycopy(attrData, 0, bArr3, 0, 2);
                            i2 = CHexConver.bytesToInt(bArr3[0], bArr3[1]);
                        } else if (attrData.length >= 4) {
                            byte[] bArr4 = new byte[4];
                            System.arraycopy(attrData, 0, bArr4, 0, 4);
                            i2 = CHexConver.bytesToInt(bArr4);
                        }
                        float f = i2 / 10.0f;
                        deviceInfo.setFrequency(f);
                        this.b.onFrequencyTx(bluetoothDevice, f);
                        break;
                    case 9:
                        this.b.onPeripheralsModeChange(bluetoothDevice, CHexConver.byteToInt(attrData[0]));
                        break;
                    case 10:
                        byte[] bArr5 = new byte[0];
                        if (attrData[0] == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 && attrData.length > 6) {
                            bArr5 = new byte[6];
                            System.arraycopy(attrData, 1, bArr5, 0, 6);
                        }
                        this.b.onPeripheralsConnectStatusChange(bluetoothDevice, z2, CHexConver.hexDataCovetToAddress(bArr5));
                        break;
                    case 11:
                        if (attrData.length >= 8) {
                            this.b.onHighAndBassChange(bluetoothDevice, CHexConver.bytesToInt(attrData, 0, 4), CHexConver.bytesToInt(attrData, 4, 4));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        JL_Log.d(c, "parsePublicData", "eq preset data-->" + CHexConver.byte2HexStr(attrData, attrData.length));
                        EqPresetInfo a3 = a(attrBean);
                        deviceInfo.setEqPresetInfo(a3);
                        this.b.onEqPresetChange(bluetoothDevice, a3);
                        break;
                    case 13:
                        if (attrData.length >= 9) {
                            byte[] bArr6 = new byte[9];
                            System.arraycopy(attrData, 0, bArr6, 0, 9);
                            VoiceMode parse = VoiceMode.parse(bArr6);
                            deviceInfo.setCurrentVoiceMode(parse);
                            this.b.onCurrentVoiceMode(bluetoothDevice, parse);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int i4 = attrData[0];
                        if (i4 > 0 && attrData.length >= (i4 * 9) + 1) {
                            byte[] bArr7 = new byte[9];
                            ArrayList arrayList = new ArrayList();
                            for (int i5 = 0; i5 < i4; i5++) {
                                System.arraycopy(attrData, i, bArr7, 0, 9);
                                i += 9;
                                arrayList.add(VoiceMode.parse(bArr7));
                            }
                            deviceInfo.setVoiceModeList(arrayList);
                            this.b.onVoiceModeList(bluetoothDevice, arrayList);
                            break;
                        }
                        break;
                    case 15:
                        JL_Log.e(c, "parsePublicData", "phone status change ：" + CHexConver.byte2HexStr(attrData));
                        int byteToInt11 = CHexConver.byteToInt(attrData[0]);
                        deviceInfo.setPhoneStatus(byteToInt11);
                        this.b.onPhoneCallStatusChange(bluetoothDevice, byteToInt11);
                        break;
                    case 16:
                        int length = attrData.length;
                        byte[] bArr8 = new byte[length];
                        System.arraycopy(attrData, 0, bArr8, 0, length);
                        a(bluetoothDevice, bArr8);
                        break;
                    case 17:
                        EqInfo eqInfo2 = new EqInfo();
                        eqInfo2.setDynamic(true);
                        eqInfo2.setMode(0);
                        int i6 = attrData[0];
                        int[] iArr = new int[i6];
                        while (i2 < i6) {
                            iArr[i2] = CHexConver.bytesToInt(attrData, i, 2);
                            i2++;
                            i += 2;
                        }
                        eqInfo2.setFreqs(iArr);
                        deviceInfo.setSoundCardEqInfo(eqInfo2);
                        break;
                    case 18:
                        EqInfo soundCardEqInfo = deviceInfo.getSoundCardEqInfo();
                        if (soundCardEqInfo == null) {
                            break;
                        } else {
                            int i7 = attrData[0];
                            byte[] bArr9 = new byte[i7];
                            System.arraycopy(attrData, 1, bArr9, 0, i7);
                            soundCardEqInfo.setValue(bArr9);
                            deviceInfo.setSoundCardEqInfo(soundCardEqInfo);
                            this.b.onSoundCardEqChange(bluetoothDevice, soundCardEqInfo);
                            break;
                        }
                    case 19:
                        JL_Log.d(c, "parsePublicData", "SYS_INFO_ATTR_SOUND_CARD : " + CHexConver.byte2HexStr(attrData));
                        if (attrData.length >= 8) {
                            long bytesToLong = CHexConver.bytesToLong(attrData, 0, 8);
                            JL_Log.d(c, "parsePublicData", "mask  ->  " + CHexConver.byte2HexStr(attrData, 8));
                            byte[] bArr10 = new byte[0];
                            if (attrData.length > 8) {
                                int length2 = attrData.length - 8;
                                byte[] bArr11 = new byte[length2];
                                System.arraycopy(attrData, 8, bArr11, 0, length2);
                                JL_Log.d(c, "parsePublicData", "values  ->  " + CHexConver.byte2HexStr(bArr11));
                                bArr10 = bArr11;
                            }
                            this.b.onSoundCardStatusChange(bluetoothDevice, bytesToLong, bArr10);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.bluetooth.BluetoothDevice r24, java.util.List<com.jieli.jl_rcsp.model.device.AttrBean> r25) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jieli.jl_rcsp.tool.RcspDataHandler.f(android.bluetooth.BluetoothDevice, java.util.List):void");
    }

    public void parseAttrMessage(BluetoothDevice bluetoothDevice, byte b, List<AttrBean> list) {
        if (bluetoothDevice != null && list != null) {
            if (b != -1) {
                if (b != 0) {
                    if (b != 1) {
                        if (b != 2) {
                            if (b != 3) {
                                if (b == 4) {
                                    c(bluetoothDevice, list);
                                    return;
                                }
                                return;
                            }
                            a(bluetoothDevice, list);
                            return;
                        }
                        f(bluetoothDevice, list);
                        return;
                    }
                    d(bluetoothDevice, list);
                    return;
                }
                b(bluetoothDevice, list);
                return;
            }
            e(bluetoothDevice, list);
        }
    }

    public void parseHealthSetting(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo = this.f18028a.getDeviceInfo();
        if (deviceInfo == null) {
            return;
        }
        HealthSettingInfo healthSettingInfo = deviceInfo.getHealthSettingInfo();
        if (healthSettingInfo == null) {
            healthSettingInfo = new HealthSettingInfo();
            deviceInfo.setHealthSettingInfo(healthSettingInfo);
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            healthSettingInfo.setFuncFlag(attrBean.getType());
            switch (attrBean.getType()) {
                case 1:
                    healthSettingInfo.setSensorInfo(new SensorInfo(CHexConver.bytesToInt(attrData, 0, 2)));
                    break;
                case 2:
                    healthSettingInfo.setSedentaryReminder(new SedentaryReminder(attrData));
                    break;
                case 3:
                    healthSettingInfo.setHeartRateMeasure(new HeartRateMeasure(attrData));
                    break;
                case 4:
                    healthSettingInfo.setExerciseHeartRateReminder(new ExerciseHeartRateReminder(attrData));
                    break;
                case 5:
                    healthSettingInfo.setAutomaticPressureDetection(new AutomaticPressureDetection(attrData));
                    break;
                case 6:
                    healthSettingInfo.setSleepDetection(new SleepDetection(attrData));
                    break;
                case 7:
                    healthSettingInfo.setFallDetection(new FallDetection(attrData));
                    break;
                case 8:
                    healthSettingInfo.setLiftWristDetection(new LiftWristDetection(attrData));
                    break;
                case 9:
                    healthSettingInfo.setUserInfo(new UserInfo(attrData));
                    break;
                case 10:
                    healthSettingInfo.setDisconnectReminder(new DisconnectReminder(attrData));
                    break;
                case 11:
                    healthSettingInfo.setBloodOxygenMeasurementAlert(new BloodOxygenMeasurementAlert(attrData));
                    break;
                case 12:
                    healthSettingInfo.setEmergencyContact(new EmergencyContact(attrData));
                    break;
            }
            this.b.onHealthSettingChange(bluetoothDevice, healthSettingInfo.cloneObject());
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        JL_Log.d(c, "parseFixedLenData", "data ---> " + CHexConver.byte2HexStr(bArr));
        DeviceInfo deviceInfo = this.f18028a.getDeviceInfo(bluetoothDevice);
        if (deviceInfo == null) {
            return;
        }
        ExpandFunction expandFunction = deviceInfo.getExpandFunction();
        int i = 4;
        if (bArr.length >= 4) {
            int bytesToInt = CHexConver.bytesToInt(bArr, 0, 4);
            if (expandFunction == null) {
                expandFunction = new ExpandFunction();
                expandFunction.setMask(bytesToInt);
            } else {
                expandFunction.setMask(expandFunction.getMask() | bytesToInt);
            }
            if ((bytesToInt & 1) == 1 && bArr.length >= 9) {
                byte[] bArr2 = new byte[5];
                System.arraycopy(bArr, 4, bArr2, 0, 5);
                expandFunction.putData(0, bArr2);
                this.b.onExpandFunction(bluetoothDevice, 0, bArr2);
                ReverberationParam parseData = ReverberationParam.parseData(bArr2);
                if (parseData != null) {
                    this.b.onReverberation(bluetoothDevice, parseData);
                }
                i = 9;
            }
            if ((bytesToInt & 2) == 2 && bArr.length >= i + 2) {
                byte[] bArr3 = new byte[2];
                System.arraycopy(bArr, i, bArr3, 0, 2);
                expandFunction.putData(1, bArr3);
                this.b.onExpandFunction(bluetoothDevice, 1, bArr3);
                DynamicLimiterParam parseData2 = DynamicLimiterParam.parseData(bArr3);
                if (parseData2 != null) {
                    this.b.onDynamicLimiter(bluetoothDevice, parseData2);
                }
            }
            deviceInfo.setExpandFunction(expandFunction);
        }
    }

    public final EqPresetInfo a(List<AttrBean> list) {
        AttrBean attrBean;
        Iterator<AttrBean> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                attrBean = null;
                break;
            }
            attrBean = it.next();
            if (attrBean.getType() == 12) {
                break;
            }
        }
        if (attrBean == null) {
            return null;
        }
        return a(attrBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final EqPresetInfo a(AttrBean attrBean) {
        EqPresetInfo eqPresetInfo = new EqPresetInfo();
        byte[] attrData = attrBean.getAttrData();
        ArrayList arrayList = new ArrayList();
        int i = attrData[0];
        int[] iArr = new int[i];
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = ((attrData[i2] & 255) << 8) | (attrData[i2 + 1] & 255);
            i2 += 2;
        }
        for (int i4 = 0; i4 < 7; i4++) {
            byte[] bArr = new byte[i];
            byte b = (byte) (attrData[i2] & 127);
            System.arraycopy(attrData, i2 + 1, bArr, 0, i);
            EqInfo eqInfo = new EqInfo(b, bArr, iArr);
            eqInfo.setDynamic((attrData[i2] & 128) == 128);
            arrayList.add(eqInfo);
            i2 += i + 1;
        }
        eqPresetInfo.setNumber(i);
        eqPresetInfo.setFreqs(iArr);
        eqPresetInfo.setEqInfos(arrayList);
        JL_Log.d(c, "parseEqPresetInfo", "eq--->" + eqPresetInfo);
        return eqPresetInfo;
    }

    public final int b(List<AttrBean> list) {
        for (AttrBean attrBean : list) {
            if (attrBean.getType() == 4) {
                return attrBean.getAttrData()[0] & 7;
            }
        }
        return 0;
    }
}
