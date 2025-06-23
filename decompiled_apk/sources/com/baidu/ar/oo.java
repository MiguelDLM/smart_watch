package com.baidu.ar;

/* loaded from: classes7.dex */
public class oo implements op {
    @Override // com.baidu.ar.op
    public boolean cE(String str) {
        return true;
    }

    @Override // com.baidu.ar.op
    public boolean cF(String str) {
        return true;
    }

    @Override // com.baidu.ar.op
    public void e(ov ovVar) {
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass());
    }

    @Override // com.baidu.ar.op
    public void f(ov ovVar) {
    }

    @Override // com.baidu.ar.op
    public void g(ov ovVar) {
        if (ovVar.jG() || ovVar.jH() || ovVar.jI()) {
            throw new oj("bad rsv RSV1: " + ovVar.jG() + " RSV2: " + ovVar.jH() + " RSV3: " + ovVar.jI());
        }
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // com.baidu.ar.op
    public String jA() {
        return "";
    }

    @Override // com.baidu.ar.op
    public op jB() {
        return new oo();
    }

    @Override // com.baidu.ar.op
    public String jz() {
        return "";
    }

    @Override // com.baidu.ar.op
    public void reset() {
    }

    @Override // com.baidu.ar.op
    public String toString() {
        return getClass().getSimpleName();
    }
}
