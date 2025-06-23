package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.coroutines.internal.X00IoxXI;

@XX({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
/* loaded from: classes6.dex */
public final class OOXIXo<E> extends X00IoxXI<OOXIXo<E>> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final AtomicReferenceArray f29863OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final BufferedChannel<E> f29864oI0IIXIo;

    public OOXIXo(long j, @OXOo.oOoXoXO OOXIXo<E> oOXIXo, @OXOo.oOoXoXO BufferedChannel<E> bufferedChannel, int i) {
        super(j, oOXIXo, i);
        this.f29864oI0IIXIo = bufferedChannel;
        this.f29863OxxIIOOXO = new AtomicReferenceArray(BufferedChannelKt.f29828II0xO0 * 2);
    }

    @OXOo.oOoXoXO
    public final Object IIXOooo(int i, @OXOo.oOoXoXO Object obj) {
        return this.f29863OxxIIOOXO.getAndSet((i * 2) + 1, obj);
    }

    public final void O0xOxO(int i, boolean z) {
        if (z) {
            xoXoI().O0xxXxI((this.f30276IXxxXO * BufferedChannelKt.f29828II0xO0) + i);
        }
        IXxxXO();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0063, code lost:
    
        OxxIIOOXO(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r4 = xoXoI().f29819Oo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.II0xO0(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.X00IoxXI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Oo(int r4, @OXOo.oOoXoXO java.lang.Throwable r5, @OXOo.OOXIXo kotlin.coroutines.CoroutineContext r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.o00(r4)
        Le:
            java.lang.Object r1 = r3.OxI(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.o0IXXIx
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.OxxIIOOXO
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.xoIox()
            if (r1 == r2) goto L63
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.xxIXOIIO()
            if (r1 != r2) goto L28
            goto L63
        L28:
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.x0xO0oo()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.Oo()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.x0o r4 = kotlinx.coroutines.channels.BufferedChannelKt.XO()
            if (r1 == r4) goto L62
            kotlinx.coroutines.internal.x0o r4 = kotlinx.coroutines.channels.BufferedChannelKt.f29843XO
            if (r1 != r4) goto L40
            goto L62
        L40:
            kotlinx.coroutines.internal.x0o r4 = kotlinx.coroutines.channels.BufferedChannelKt.O0xOxO()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.OxxIIOOXO(r4)
            if (r0 == 0) goto L73
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.xoXoI()
            Oox.oOoXoXO<E, kotlin.oXIO0o0XI> r4 = r4.f29819Oo
            if (r4 == 0) goto L73
            kotlinx.coroutines.internal.OnUndeliveredElementKt.II0xO0(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.xoIox()
            goto L7f
        L7b:
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.xxIXOIIO()
        L7f:
            boolean r1 = r3.oI0IIXIo(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.OxxIIOOXO(r4)
            r1 = r0 ^ 1
            r3.O0xOxO(r4, r1)
            if (r0 == 0) goto L9a
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.xoXoI()
            Oox.oOoXoXO<E, kotlin.oXIO0o0XI> r4 = r4.f29819Oo
            if (r4 == 0) goto L9a
            kotlinx.coroutines.internal.OnUndeliveredElementKt.II0xO0(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.OOXIXo.Oo(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    @OXOo.oOoXoXO
    public final Object OxI(int i) {
        return this.f29863OxxIIOOXO.get((i * 2) + 1);
    }

    public final void OxxIIOOXO(int i) {
        XI0IXoo(i, null);
    }

    public final E X0IIOO(int i) {
        E o002 = o00(i);
        OxxIIOOXO(i);
        return o002;
    }

    public final void XI0IXoo(int i, Object obj) {
        this.f29863OxxIIOOXO.lazySet(i * 2, obj);
    }

    public final void XIxXXX0x0(int i, @OXOo.oOoXoXO Object obj) {
        this.f29863OxxIIOOXO.set((i * 2) + 1, obj);
    }

    public final E o00(int i) {
        return (E) this.f29863OxxIIOOXO.get(i * 2);
    }

    public final boolean oI0IIXIo(int i, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Object obj2) {
        return com.google.common.util.concurrent.oxoX.oIX0oI(this.f29863OxxIIOOXO, (i * 2) + 1, obj, obj2);
    }

    @Override // kotlinx.coroutines.internal.X00IoxXI
    public int x0xO0oo() {
        return BufferedChannelKt.f29828II0xO0;
    }

    @OXOo.OOXIXo
    public final BufferedChannel<E> xoXoI() {
        BufferedChannel<E> bufferedChannel = this.f29864oI0IIXIo;
        IIX0o.ooOOo0oXI(bufferedChannel);
        return bufferedChannel;
    }

    public final void xxX(int i, E e) {
        XI0IXoo(i, e);
    }
}
