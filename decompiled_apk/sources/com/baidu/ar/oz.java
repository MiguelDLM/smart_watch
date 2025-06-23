package com.baidu.ar;

/* loaded from: classes7.dex */
public class oz extends ou {
    public oz() {
        super(oc.TEXT);
    }

    @Override // com.baidu.ar.ou, com.baidu.ar.ow
    public void jC() {
        super.jC();
        if (!pn.p(jE())) {
            throw new oh(1007, "Received text is no valid utf8 string!");
        }
    }
}
