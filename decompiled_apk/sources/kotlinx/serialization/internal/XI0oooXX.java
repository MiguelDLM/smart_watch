package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlinx.serialization.MissingFieldException;

/* loaded from: classes6.dex */
public final class XI0oooXX {
    @kotlinx.serialization.XO
    public static final void II0xO0(int i, int i2, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & i2;
        for (int i4 = 0; i4 < 32; i4++) {
            if ((i3 & 1) != 0) {
                arrayList.add(descriptor.Oxx0IOOO(i4));
            }
            i3 >>>= 1;
        }
        throw new MissingFieldException(arrayList, descriptor.xxIXOIIO());
    }

    @kotlinx.serialization.XO
    public static final void oIX0oI(@OXOo.OOXIXo int[] seenArray, @OXOo.OOXIXo int[] goldenMaskArray, @OXOo.OOXIXo kotlinx.serialization.descriptors.XO descriptor) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(seenArray, "seenArray");
        kotlin.jvm.internal.IIX0o.x0xO0oo(goldenMaskArray, "goldenMaskArray");
        kotlin.jvm.internal.IIX0o.x0xO0oo(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int length = goldenMaskArray.length;
        for (int i = 0; i < length; i++) {
            int i2 = goldenMaskArray[i] & (~seenArray[i]);
            if (i2 != 0) {
                for (int i3 = 0; i3 < 32; i3++) {
                    if ((i2 & 1) != 0) {
                        arrayList.add(descriptor.Oxx0IOOO((i * 32) + i3));
                    }
                    i2 >>>= 1;
                }
            }
        }
        throw new MissingFieldException(arrayList, descriptor.xxIXOIIO());
    }
}
