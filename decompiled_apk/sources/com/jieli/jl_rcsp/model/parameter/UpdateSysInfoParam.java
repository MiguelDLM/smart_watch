package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.device.AttrBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class UpdateSysInfoParam extends BaseParameter {
    private List<AttrBean> attrBeanList;
    private byte function;

    public UpdateSysInfoParam(byte b, List<AttrBean> list) {
        setAttrBeanList(list);
        setFunction(b);
    }

    public List<AttrBean> getAttrBeanList() {
        return this.attrBeanList;
    }

    public byte getFunction() {
        return this.function;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        ArrayList<byte[]> arrayList = new ArrayList();
        Iterator<AttrBean> it = this.attrBeanList.iterator();
        int i = 0;
        while (it.hasNext()) {
            byte[] data = it.next().getData();
            arrayList.add(data);
            i += data.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : arrayList) {
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    public UpdateSysInfoParam setAttrBeanList(List<AttrBean> list) {
        this.attrBeanList = list;
        return this;
    }

    public UpdateSysInfoParam setFunction(byte b) {
        this.function = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "UpdateSysInfoParam{attrBeanList=" + this.attrBeanList + ", function=" + ((int) this.function) + "} " + super.toString();
    }
}
