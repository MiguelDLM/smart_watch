package com.jieli.jl_bt_ota.model.command.tws;

import com.jieli.jl_bt_ota.model.base.CommandWithParamAndResponse;
import com.jieli.jl_bt_ota.model.parameter.tws.SetDeviceNotifyAdvInfoParam;
import com.jieli.jl_bt_ota.model.response.SetDeviceNotifyAdvInfoResponse;

/* loaded from: classes10.dex */
public class SetDeviceNotifyAdvInfoCmd extends CommandWithParamAndResponse<SetDeviceNotifyAdvInfoParam, SetDeviceNotifyAdvInfoResponse> {
    public SetDeviceNotifyAdvInfoCmd(SetDeviceNotifyAdvInfoParam setDeviceNotifyAdvInfoParam) {
        super(195, SetDeviceNotifyAdvInfoCmd.class.getSimpleName(), setDeviceNotifyAdvInfoParam);
    }
}
