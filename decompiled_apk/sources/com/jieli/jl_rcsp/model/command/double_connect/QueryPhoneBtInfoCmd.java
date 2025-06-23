package com.jieli.jl_rcsp.model.command.double_connect;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.device.double_connect.ConnectedBtInfo;
import com.jieli.jl_rcsp.model.device.double_connect.DeviceBtInfo;

/* loaded from: classes10.dex */
public class QueryPhoneBtInfoCmd extends CommandBase<Param, Response> {

    /* loaded from: classes10.dex */
    public static class NotifyParam extends Param {
        private final ConnectedBtInfo connectedBtInfo = new ConnectedBtInfo();

        public ConnectedBtInfo getConnectedBtInfo() {
            return this.connectedBtInfo;
        }

        @Override // com.jieli.jl_rcsp.model.command.double_connect.QueryPhoneBtInfoCmd.Param, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return this.connectedBtInfo.toData();
        }

        @Override // com.jieli.jl_rcsp.model.command.double_connect.QueryPhoneBtInfoCmd.Param
        public int parseData(byte[] bArr) {
            return this.connectedBtInfo.parseConnectedDeviceBtData(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter
        public String toString() {
            return "NotifyParam{connectedBtInfo=" + this.connectedBtInfo + "} ";
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private DeviceBtInfo deviceBtInfo;

        public DeviceBtInfo getDeviceBtInfo() {
            return this.deviceBtInfo;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            DeviceBtInfo deviceBtInfo = this.deviceBtInfo;
            if (deviceBtInfo != null) {
                return deviceBtInfo.toData();
            }
            return new byte[0];
        }

        public int parseData(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                DeviceBtInfo deviceBtInfo = new DeviceBtInfo();
                int parseData = deviceBtInfo.parseData(bArr);
                if (parseData > 0) {
                    setDeviceBtInfo(deviceBtInfo);
                }
                return parseData;
            }
            return 0;
        }

        public Param setDeviceBtInfo(DeviceBtInfo deviceBtInfo) {
            this.deviceBtInfo = deviceBtInfo;
            return this;
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
        private final ConnectedBtInfo connectedBtInfo = new ConnectedBtInfo();

        public ConnectedBtInfo getConnectedBtInfo() {
            return this.connectedBtInfo;
        }

        public int parseData(byte[] bArr) {
            return this.connectedBtInfo.parseConnectedDeviceBtData(bArr);
        }
    }

    public QueryPhoneBtInfoCmd(Param param) {
        this(2, param);
    }

    public QueryPhoneBtInfoCmd(int i, Param param) {
        super(49, "QueryPhoneBtInfoCmd", i);
        setParam(param);
    }
}
