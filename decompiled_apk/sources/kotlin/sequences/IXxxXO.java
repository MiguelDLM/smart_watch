package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f29428I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f29429II0xO0 = 1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f29430X0o0xo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f29431XO = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f29432oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f29433oxoX = 3;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SequenceBuilder.kt\nkotlin/sequences/SequencesKt__SequenceBuilderKt\n*L\n1#1,680:1\n26#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements ooOOo0oXI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Oox.x0xO0oo f29434oIX0oI;

        public oIX0oI(Oox.x0xO0oo x0xo0oo) {
            this.f29434oIX0oI = x0xo0oo;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return IXxxXO.oIX0oI(this.f29434oIX0oI);
        }
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static <T> ooOOo0oXI<T> II0xO0(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super oO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> block) {
        IIX0o.x0xO0oo(block, "block");
        return new oIX0oI(block);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static <T> Iterator<T> oIX0oI(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super oO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> block) {
        IIX0o.x0xO0oo(block, "block");
        x0XOIxOo x0xoixoo = new x0XOIxOo();
        x0xoixoo.OOXIXo(IntrinsicsKt__IntrinsicsJvmKt.I0Io(block, x0xoixoo, x0xoixoo));
        return x0xoixoo;
    }
}
