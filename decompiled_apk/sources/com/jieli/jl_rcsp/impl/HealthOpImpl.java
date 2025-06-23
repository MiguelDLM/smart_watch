package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.health.IHealthOp;
import com.jieli.jl_rcsp.model.HealthDataQuery;
import com.jieli.jl_rcsp.model.RealTimeSportsData;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.watch.RequestHealthDataCmd;
import com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr;
import com.jieli.jl_rcsp.model.device.health.SportsInfo;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class HealthOpImpl implements IHealthOp {

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f17844a;

    public HealthOpImpl(RcspOpImpl rcspOpImpl) {
        if (rcspOpImpl != null) {
            this.f17844a = rcspOpImpl;
            return;
        }
        throw new NullPointerException("RcspOpImpl can not be null.");
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void configHealthSettings(BluetoothDevice bluetoothDevice, List<AttrBean> list, OnOperationCallback<Boolean> onOperationCallback) {
        if (list != null && !list.isEmpty()) {
            this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSetHealthSettingCmd(list), new BooleanRcspActionCallback("configHealthSettings", onOperationCallback));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "List of AttrBean can not be empty."));
        }
    }

    public BluetoothDevice getConnectedDevice() {
        return this.f17844a.getConnectedDevice();
    }

    public RcspOpImpl getRcspOp() {
        return this.f17844a;
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void pauseSports(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncSportsStatusCmd(new SportsInfoStatusSyncCmd.PauseSportsParam()), new BooleanRcspActionCallback("pauseSports", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void readHealthData(BluetoothDevice bluetoothDevice, HealthDataQuery healthDataQuery, OnOperationCallback<Boolean> onOperationCallback) {
        if (healthDataQuery == null) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(4097, "HealthDataQuery is null."));
                return;
            }
            return;
        }
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetHealthDataInfoCmd(healthDataQuery.getMask(), healthDataQuery.getVersion(), healthDataQuery.getParam()), new CustomRcspActionCallback("readHealthData", onOperationCallback, new IHandleResult<Boolean, RequestHealthDataCmd>() { // from class: com.jieli.jl_rcsp.impl.HealthOpImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice2, RequestHealthDataCmd requestHealthDataCmd) {
                return Boolean.TRUE;
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, RequestHealthDataCmd requestHealthDataCmd) {
                if (requestHealthDataCmd == null) {
                    return 1;
                }
                if (requestHealthDataCmd.getStatus() != 0) {
                    return requestHealthDataCmd.getStatus();
                }
                if (requestHealthDataCmd.getResponse() == null) {
                    return 1;
                }
                return CHexConver.byteToInt(requestHealthDataCmd.getResponse().getRet());
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void readHealthSettings(BluetoothDevice bluetoothDevice, int i, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetHealthSettingCmd(i), new BooleanRcspActionCallback("readHealthSettings", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void readRealTimeSportsData(BluetoothDevice bluetoothDevice, OnOperationCallback<RealTimeSportsData> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncSportsStatusCmd(new SportsInfoStatusSyncCmd.ReadRealDataParam()), new CustomRcspActionCallback("readRealTimeSportsData", onOperationCallback, new IHandleResult<RealTimeSportsData, SportsInfoStatusSyncCmd>() { // from class: com.jieli.jl_rcsp.impl.HealthOpImpl.3
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd) {
                return 0;
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public RealTimeSportsData handleResult(BluetoothDevice bluetoothDevice2, SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd) {
                SportsInfoStatusSyncCmd.ReadRealDataResponse readRealDataResponse;
                SportsInfoStatusSyncCmd.Param param = sportsInfoStatusSyncCmd.getParam();
                if (param == null || param.getOp() != 6 || (readRealDataResponse = (SportsInfoStatusSyncCmd.ReadRealDataResponse) sportsInfoStatusSyncCmd.getResponse()) == null) {
                    return null;
                }
                return new RealTimeSportsData().setVersion(readRealDataResponse.version).setStep(readRealDataResponse.step).setDistance(readRealDataResponse.distance).setDuration(readRealDataResponse.duration).setSpeed(readRealDataResponse.speed).setPace(readRealDataResponse.pace).setCalorie(readRealDataResponse.kcal).setStepFreq(readRealDataResponse.stepFreq).setStride(readRealDataResponse.stride).setExerciseStatus(readRealDataResponse.exerciseStatus).setHeartRate(readRealDataResponse.heartRate);
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void readSportsInfo(BluetoothDevice bluetoothDevice, OnOperationCallback<SportsInfo> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncSportsStatusCmd(new SportsInfoStatusSyncCmd.ReadSportsInfoParam()), new CustomRcspActionCallback("readSportsInfo", onOperationCallback, new IHandleResult<SportsInfo, SportsInfoStatusSyncCmd>() { // from class: com.jieli.jl_rcsp.impl.HealthOpImpl.2
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd) {
                return 0;
            }

            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public SportsInfo handleResult(BluetoothDevice bluetoothDevice2, SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd) {
                SportsInfoStatusSyncCmd.ReadSportsInfoResponse readSportsInfoResponse;
                SportsInfoStatusSyncCmd.Param param = sportsInfoStatusSyncCmd.getParam();
                if (param == null || param.getOp() != 0 || (readSportsInfoResponse = (SportsInfoStatusSyncCmd.ReadSportsInfoResponse) sportsInfoStatusSyncCmd.getResponse()) == null) {
                    return null;
                }
                return new SportsInfo().setMode(readSportsInfoResponse.type).setState(readSportsInfoResponse.status).setId(readSportsInfoResponse.id).setNeedAppGPS(readSportsInfoResponse.hasGps).setHeartRateMode(readSportsInfoResponse.heartRateMode).setReadRealTimeDataInterval(readSportsInfoResponse.readReadDataInterval);
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void resumeSports(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncSportsStatusCmd(new SportsInfoStatusSyncCmd.ResumeSportsParam()), new BooleanRcspActionCallback("resumeSports", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void startSports(BluetoothDevice bluetoothDevice, int i, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncSportsStatusCmd(new SportsInfoStatusSyncCmd.StartSportsParam((byte) i)), new BooleanRcspActionCallback("startSports", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void stopSports(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.f17844a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncSportsStatusCmd(new SportsInfoStatusSyncCmd.AppStopSportsParam()), new BooleanRcspActionCallback("stopSports", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.health.IHealthOp
    public void configHealthSettings(BluetoothDevice bluetoothDevice, IHealthSettingToAttr iHealthSettingToAttr, OnOperationCallback<Boolean> onOperationCallback) {
        if (iHealthSettingToAttr == null) {
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(new BaseError(4097, "IHealthSettingToAttr is null."));
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(iHealthSettingToAttr.toAttr());
            configHealthSettings(bluetoothDevice, arrayList, onOperationCallback);
        }
    }
}
