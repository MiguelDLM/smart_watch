package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.model.base.CommandWithResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.device.DeviceConfiguration;

/* loaded from: classes10.dex */
public class GetDevConfigureCmd extends CommandWithResponse<Response> {

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
        private final DeviceConfiguration deviceConfiguration = new DeviceConfiguration();

        public byte[] getData() {
            return this.deviceConfiguration.getData();
        }

        public DeviceConfiguration getDeviceConfiguration() {
            return this.deviceConfiguration;
        }

        public int getProductFlag() {
            return this.deviceConfiguration.getType();
        }

        public int getVersion() {
            return this.deviceConfiguration.getVersion();
        }

        public void parseData(byte[] bArr) {
            this.deviceConfiguration.parse(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "Response{deviceConfiguration=" + this.deviceConfiguration + '}';
        }
    }

    public GetDevConfigureCmd() {
        super(Command.CMD_GET_DEVICE_CONFIG_INFO, GetDevConfigureCmd.class.getSimpleName());
    }
}
