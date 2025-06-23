package com.baidu.navisdk.model.datastruct.chargestation;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import kotlin.collections.o00;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XoX;

/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private int f6911a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;

    @oOoXoXO
    private b f;

    @oOoXoXO
    private b g;

    @OOXIXo
    private final HashMap<String, b> h = new HashMap<>();

    @OOXIXo
    private ArrayList<b> i = new ArrayList<>();

    @oOoXoXO
    public final b a() {
        return this.g;
    }

    public final int b() {
        return this.e;
    }

    @OOXIXo
    public final ArrayList<b> c() {
        return this.i;
    }

    @OOXIXo
    public final HashMap<String, b> d() {
        return this.h;
    }

    public final int e() {
        return this.f6911a;
    }

    @oOoXoXO
    public final b f() {
        return this.f;
    }

    @OOXIXo
    public String toString() {
        return "CsInfoGroup(groupId=" + this.f6911a + ", isHasApproach=" + this.b + ", isEndGroup=" + this.c + ", isRecGroup=" + this.d + ", backupCsCount=" + this.e + ", optimalCsInfo=" + this.f + ", approachNeCsInfo=" + this.g + ", csInfoList=" + this.i + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void a(@oOoXoXO String str, @OOXIXo b info) {
        IIX0o.x0xO0oo(info, "info");
        if (str != null) {
            if (info.q()) {
                this.b = true;
                this.g = info;
            }
            this.c = info.h() == -1;
            this.f6911a = info.h();
            this.d = info.t();
            this.h.put(str, info);
            this.i.add(info);
            if (info.q()) {
                return;
            }
            if (info.n() == 1) {
                this.f = info;
            } else {
                this.e++;
            }
        }
    }

    public final void a(@OOXIXo Comparator<Object> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        ArrayList<b> arrayList = new ArrayList<>(this.i);
        XoX.oIX0oI(arrayList).remove(this.f);
        XoX.oIX0oI(arrayList).remove(this.g);
        o00.OO0x0xX(arrayList, comparator);
        b bVar = this.f;
        if (bVar != null) {
            arrayList.add(0, bVar);
        }
        b bVar2 = this.g;
        if (bVar2 != null) {
            arrayList.add(0, bVar2);
        }
        this.i = arrayList;
    }
}
