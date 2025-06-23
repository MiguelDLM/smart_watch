package kotlin.enums;

import OXOo.OOXIXo;
import androidx.exifinterface.media.ExifInterface;
import kotlin.IXxxXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oxxXoxO;

@XX({"SMAP\nEnumEntries.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnumEntries.kt\nkotlin/enums/EnumEntriesKt\n+ 2 EnumEntriesJVM.kt\nkotlin/enums/EnumEntriesJVMKt\n*L\n1#1,91:1\n16#2:92\n*S KotlinDebug\n*F\n+ 1 EnumEntries.kt\nkotlin/enums/EnumEntriesKt\n*L\n31#1:92\n*E\n"})
/* loaded from: classes6.dex */
public final class I0Io {
    @OOXIXo
    @o0
    @oxxXoxO(version = "1.8")
    public static final <E extends Enum<E>> oIX0oI<E> I0Io(@OOXIXo E[] entries) {
        IIX0o.x0xO0oo(entries, "entries");
        return new EnumEntriesList(entries);
    }

    @OOXIXo
    @o0
    @oxxXoxO(version = "1.8")
    public static final <E extends Enum<E>> oIX0oI<E> II0xO0(@OOXIXo Oox.oIX0oI<E[]> entriesProvider) {
        IIX0o.x0xO0oo(entriesProvider, "entriesProvider");
        return new EnumEntriesList(entriesProvider.invoke());
    }

    @IXxxXO
    @oxxXoxO(version = "1.9")
    public static final /* synthetic */ <T extends Enum<T>> oIX0oI<T> oIX0oI() {
        IIX0o.OxI(5, ExifInterface.GPS_DIRECTION_TRUE);
        return I0Io(new Enum[0]);
    }
}
