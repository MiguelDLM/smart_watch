package com.angcyo.dsladapter;

import java.util.List;

/* loaded from: classes7.dex */
public interface Xx000oIo {

    /* loaded from: classes7.dex */
    public static final class oIX0oI {
        public static void II0xO0(@OXOo.OOXIXo Xx000oIo xx000oIo, int i, int i2) {
            String oIX0oI2;
            String oIX0oI3;
            L l = L.f5267oIX0oI;
            StringBuilder sb = new StringBuilder();
            sb.append("选择模式改变:[");
            oIX0oI2 = ItemSelectorHelperKt.oIX0oI(i);
            sb.append(oIX0oI2);
            sb.append("]->[");
            oIX0oI3 = ItemSelectorHelperKt.oIX0oI(i2);
            sb.append(oIX0oI3);
            sb.append(']');
            l.Oxx0xo(sb.toString());
        }

        public static void oIX0oI(@OXOo.OOXIXo Xx000oIo xx000oIo, @OXOo.OOXIXo List<DslAdapterItem> selectorItems, @OXOo.OOXIXo List<Integer> selectorIndexList, boolean z, @OXOo.OOXIXo IO selectorParams) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorItems, "selectorItems");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorIndexList, "selectorIndexList");
            kotlin.jvm.internal.IIX0o.x0xO0oo(selectorParams, "selectorParams");
            L.f5267oIX0oI.Oxx0xo("选择改变->" + selectorIndexList);
        }
    }

    void II0xO0(@OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo List<Integer> list2, boolean z, @OXOo.OOXIXo IO io2);

    void oIX0oI(int i, int i2);
}
