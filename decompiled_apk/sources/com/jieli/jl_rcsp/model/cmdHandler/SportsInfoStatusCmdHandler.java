package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.watch.SportsInfoStatusSyncCmd;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.JL_Log;

/* loaded from: classes10.dex */
public class SportsInfoStatusCmdHandler implements ICmdHandler {
    private final String tag = getClass().getSimpleName();

    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int i;
        if (basePacket == null || basePacket.getOpCode() != 166) {
            return null;
        }
        byte[] paramData = basePacket.getParamData();
        if (basePacket.getHasResponse() == 1) {
            i = 2;
        } else {
            i = 1;
        }
        if (basePacket.getType() == 1) {
            try {
                SportsInfoStatusSyncCmd.Param param = new SportsInfoStatusSyncCmd.Param(paramData);
                switch (param.getOp()) {
                    case 0:
                        param = new SportsInfoStatusSyncCmd.ReadSportsInfoParam(paramData);
                        break;
                    case 1:
                        param = new SportsInfoStatusSyncCmd.StartSportsParam(paramData);
                        break;
                    case 2:
                        param = new SportsInfoStatusSyncCmd.AppStopSportsParam(paramData);
                        break;
                    case 3:
                        param = new SportsInfoStatusSyncCmd.FirmwareStopSportsParam(paramData);
                        break;
                    case 4:
                        param = new SportsInfoStatusSyncCmd.PauseSportsParam(paramData);
                        break;
                    case 5:
                        param = new SportsInfoStatusSyncCmd.ResumeSportsParam(paramData);
                        break;
                    case 6:
                        param = new SportsInfoStatusSyncCmd.ReadRealDataParam(paramData);
                        break;
                    case 7:
                        param = new SportsInfoStatusSyncCmd.SetReadRealDataIntervalParam(paramData);
                        break;
                }
                SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd = new SportsInfoStatusSyncCmd(i, param);
                sportsInfoStatusSyncCmd.setOpCodeSn(basePacket.getOpCodeSn());
                return sportsInfoStatusSyncCmd;
            } catch (ParseDataException e) {
                JL_Log.w(this.tag, "parseDataToCmd", "command ParseDataException : " + e);
                return null;
            }
        }
        CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        if (command == null) {
            JL_Log.e(this.tag, "parseDataToCmd", "invalid sports info status sync cmd response");
            return null;
        }
        try {
            SportsInfoStatusSyncCmd.Response response = new SportsInfoStatusSyncCmd.Response(paramData);
            int op = response.getOp();
            if (op != 0) {
                if (op != 2) {
                    if (op == 6) {
                        response = new SportsInfoStatusSyncCmd.ReadRealDataResponse(paramData);
                    }
                } else {
                    response = new SportsInfoStatusSyncCmd.AppStopSportsResponse(paramData);
                }
            } else {
                response = new SportsInfoStatusSyncCmd.ReadSportsInfoResponse(paramData);
            }
            SportsInfoStatusSyncCmd sportsInfoStatusSyncCmd2 = (SportsInfoStatusSyncCmd) command;
            sportsInfoStatusSyncCmd2.setOpCodeSn(basePacket.getOpCodeSn());
            sportsInfoStatusSyncCmd2.setStatus(basePacket.getStatus());
            sportsInfoStatusSyncCmd2.setResponse(response);
            return sportsInfoStatusSyncCmd2;
        } catch (ParseDataException e2) {
            JL_Log.w(this.tag, "parseDataToCmd", "response ParseDataException : " + e2);
            return null;
        }
    }
}
