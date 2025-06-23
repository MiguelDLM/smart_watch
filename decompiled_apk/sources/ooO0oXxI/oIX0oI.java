package ooO0oXxI;

import xXo.Oxx0IOOO;

/* loaded from: classes13.dex */
public class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f32303oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Class<?> f32302II0xO0 = String.class;

    /* renamed from: I0Io, reason: collision with root package name */
    public Object f32301I0Io = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public Oxx0IOOO[] f32304oxoX = null;

    public oIX0oI(int i) {
        this.f32303oIX0oI = i;
    }

    public void I0Io(Oxx0IOOO[] oxx0IOOOArr) {
        this.f32304oxoX = oxx0IOOOArr;
    }

    public Oxx0IOOO[] II0xO0() {
        return this.f32304oxoX;
    }

    public Object oIX0oI(Object obj) {
        if (this.f32304oxoX == null) {
            return obj;
        }
        int i = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr = this.f32304oxoX;
            if (i < oxx0IOOOArr.length) {
                obj = oxx0IOOOArr[i].II0xO0(obj);
                i++;
            } else {
                return obj;
            }
        }
    }
}
