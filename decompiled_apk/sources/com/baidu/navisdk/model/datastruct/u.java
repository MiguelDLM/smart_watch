package com.baidu.navisdk.model.datastruct;

/* loaded from: classes7.dex */
public class u implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public double f6943a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;

    public String toString() {
        return String.format("SensorData {accx:%1$f accy:%2$f accz:%3$f heading:%4$f pitch:%5$f roll:%6$f}", Double.valueOf(this.f6943a), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public u m92clone() {
        u uVar = new u();
        synchronized (this) {
            uVar.f6943a = this.f6943a;
            uVar.b = this.b;
            uVar.c = this.c;
            uVar.d = this.d;
            uVar.e = this.e;
            uVar.f = this.f;
        }
        return uVar;
    }
}
