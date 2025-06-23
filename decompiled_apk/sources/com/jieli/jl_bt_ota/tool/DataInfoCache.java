package com.jieli.jl_bt_ota.tool;

import com.jieli.jl_bt_ota.model.DataInfo;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class DataInfoCache extends ArrayList<DataInfo> {
    public DataInfo getDataInfo(BasePacket basePacket) {
        Iterator<DataInfo> it = iterator();
        while (it.hasNext()) {
            DataInfo next = it.next();
            if (next.getBasePacket().getOpCode() == basePacket.getOpCode() && next.getBasePacket().getOpCodeSn() == basePacket.getOpCodeSn()) {
                return next;
            }
        }
        return null;
    }
}
