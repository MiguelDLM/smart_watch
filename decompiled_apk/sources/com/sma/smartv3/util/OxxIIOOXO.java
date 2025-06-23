package com.sma.smartv3.util;

import com.sma.smartv3.view.WheelView.WheelView;
import java.util.ArrayList;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nGoalSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoalSet.kt\ncom/sma/smartv3/util/GoalSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,12:1\n1#2:13\n*E\n"})
/* loaded from: classes12.dex */
public final class OxxIIOOXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final List<String> f24319oIX0oI;

    static {
        ArrayList arrayList = new ArrayList(30);
        int i = 0;
        while (i < 30) {
            i++;
            arrayList.add(String.valueOf(i * 1000));
        }
        f24319oIX0oI = arrayList;
    }

    public static final void II0xO0(@OXOo.OOXIXo WheelView wv, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(wv, "wv");
        wv.setItems(f24319oIX0oI);
        wv.setVisibleCount(3);
        wv.setInitPosition(i);
    }

    @OXOo.OOXIXo
    public static final List<String> oIX0oI() {
        return f24319oIX0oI;
    }
}
