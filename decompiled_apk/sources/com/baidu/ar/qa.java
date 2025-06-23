package com.baidu.ar;

import java.io.Serializable;

/* loaded from: classes7.dex */
abstract class qa implements pq, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    @Override // com.baidu.ar.pq
    public String getName() {
        return this.name;
    }

    public Object readResolve() {
        return pr.cO(getName());
    }
}
