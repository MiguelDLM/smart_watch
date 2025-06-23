package com.baidu.navisdk.ui.chargelist.data.beans;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class a extends b {

    @OOXIXo
    private final ArrayList<String> h;

    @OOXIXo
    private final String i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;

    @OOXIXo
    private final com.baidu.navisdk.model.datastruct.chargestation.a n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i, int i2, int i3, int i4, @OOXIXo com.baidu.navisdk.model.datastruct.chargestation.a csBubble) {
        super(csBubble.g(), i, i2, 0, i3, i4);
        String str;
        IIX0o.x0xO0oo(csBubble, "csBubble");
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
        this.n = csBubble;
        this.h = csBubble.a();
        int d = d();
        if (d != 2) {
            if (d != 3) {
                str = "";
            } else {
                str = "绕路规划";
            }
        } else {
            str = "不可达";
        }
        this.i = str;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int a() {
        return this.l;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int b() {
        return this.m;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int c() {
        return this.j;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    public int d() {
        return this.k;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (c() == aVar.c() && d() == aVar.d() && IIX0o.Oxx0IOOO(this.n, aVar.n) && IIX0o.Oxx0IOOO(this.h, aVar.h) && g() == aVar.g()) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final ArrayList<String> h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((c() * 31) + d()) * 31) + this.n.hashCode()) * 31) + this.h.hashCode()) * 31) + Boolean.valueOf(g()).hashCode();
    }

    @OOXIXo
    public final String i() {
        return this.i;
    }

    @Override // com.baidu.navisdk.ui.chargelist.data.beans.b
    @OOXIXo
    public String toString() {
        return "BubbleWrapper(" + super.toString() + ", groupIndex=" + c() + ", itemType=" + d() + ", backgroundType=" + a() + ", distance=" + b() + ", csBubble=" + this.n + ", content=" + this.h + ", groupName='" + this.i + '\'' + oIX0oI.I0Io.f4095I0Io;
    }
}
