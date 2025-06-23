package com.baidu.ar;

/* loaded from: classes7.dex */
public abstract class ot extends ow {
    public ot(oc ocVar) {
        super(ocVar);
    }

    @Override // com.baidu.ar.ow
    public void jC() {
        if (!jF()) {
            throw new oj("Control frame cant have fin==false set");
        }
        if (jG()) {
            throw new oj("Control frame cant have rsv1==true set");
        }
        if (jH()) {
            throw new oj("Control frame cant have rsv2==true set");
        }
        if (jI()) {
            throw new oj("Control frame cant have rsv3==true set");
        }
    }
}
