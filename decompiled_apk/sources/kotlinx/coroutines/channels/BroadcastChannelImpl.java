package kotlinx.coroutines.channels;

import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.x0o;

@XX({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
/* loaded from: classes6.dex */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements oxoX<E> {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public final int f29802XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ReentrantLock f29803XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    @OXOo.oOoXoXO
    public Object f29804XxX0x0xxx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    @OXOo.OOXIXo
    public final HashMap<kotlinx.coroutines.selects.xoIox<?>, Object> f29805xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    @OXOo.OOXIXo
    public List<? extends BufferedChannel<E>> f29806xxX;

    /* loaded from: classes6.dex */
    public final class II0xO0 extends x0XOIxOo<E> {
        public II0xO0() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: xX, reason: merged with bridge method [inline-methods] */
        public boolean oOXoIIIo(@OXOo.oOoXoXO Throwable th) {
            BroadcastChannelImpl.this.OxXXx0X(this);
            return super.oOXoIIIo(th);
        }
    }

    @XX({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    /* loaded from: classes6.dex */
    public final class oIX0oI extends BufferedChannel<E> {
        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI() {
            super(BroadcastChannelImpl.this.oX0I0O(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* renamed from: oxOXxoXII, reason: merged with bridge method [inline-methods] */
        public boolean oOXoIIIo(@OXOo.oOoXoXO Throwable th) {
            ReentrantLock reentrantLock = BroadcastChannelImpl.this.f29803XIxXXX0x0;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            reentrantLock.lock();
            try {
                broadcastChannelImpl.OxXXx0X(this);
                return super.oOXoIIIo(th);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public BroadcastChannelImpl(int i) {
        super(0, null);
        this.f29802XI0IXoo = i;
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i + " was specified").toString());
        }
        this.f29803XIxXXX0x0 = new ReentrantLock();
        this.f29806xxX = CollectionsKt__CollectionsKt.ooXIXxIX();
        this.f29804XxX0x0xxx = X0o0xo.II0xO0();
        this.f29805xXxxox0I = new HashMap<>();
    }

    public static /* synthetic */ void oo00() {
    }

    public static /* synthetic */ void xX() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void OxXXx0X(ReceiveChannel<? extends E> receiveChannel) {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            List<? extends BufferedChannel<E>> list = this.f29806xxX;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != receiveChannel) {
                    arrayList.add(obj);
                }
            }
            this.f29806xxX = arrayList;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.oI0IIXIo
    public boolean X0IIOO() {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            return super.X0IIOO();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:10:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object XOxIOxOx(E r7, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r4
            kotlin.I0oOoX.x0XOIxOo(r8)
            goto L80
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.I0oOoX.x0XOIxOo(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f29803XIxXXX0x0
            r8.lock()
            boolean r2 = r6.X0IIOO()     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L99
            int r2 = r6.f29802XI0IXoo     // Catch: java.lang.Throwable -> L51
            r4 = -1
            if (r2 != r4) goto L53
            r6.f29804XxX0x0xxx = r7     // Catch: java.lang.Throwable -> L51
            goto L53
        L51:
            r7 = move-exception
            goto L9e
        L53:
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r2 = r6.f29806xxX     // Catch: java.lang.Throwable -> L51
            r8.unlock()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L62:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L96
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.L$0 = r4
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r2 = r2.oXxOI0oIx(r8, r0)
            if (r2 != r1) goto L7d
            return r1
        L7d:
            r5 = r2
            r2 = r8
            r8 = r5
        L80:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L94
            boolean r8 = r4.X0IIOO()
            if (r8 != 0) goto L8f
            goto L94
        L8f:
            java.lang.Throwable r7 = r4.xoIxX()
            throw r7
        L94:
            r8 = r2
            goto L62
        L96:
            kotlin.oXIO0o0XI r7 = kotlin.oXIO0o0XI.f29392oIX0oI
            return r7
        L99:
            java.lang.Throwable r7 = r6.xoIxX()     // Catch: java.lang.Throwable -> L51
            throw r7     // Catch: java.lang.Throwable -> L51
        L9e:
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.XOxIOxOx(java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean oOXoIIIo(@OXOo.oOoXoXO Throwable th) {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f29806xxX.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).oOXoIIIo(th);
            }
            this.f29804XxX0x0xxx = X0o0xo.II0xO0();
            boolean oOXoIIIo2 = super.oOXoIIIo(th);
            reentrantLock.unlock();
            return oOXoIIIo2;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final int oX0I0O() {
        return this.f29802XI0IXoo;
    }

    @OXOo.oOoXoXO
    public final E oX0ooo0I0() {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            E e = null;
            if (!XxX0x0xxx() && this.f29804XxX0x0xxx != X0o0xo.II0xO0()) {
                e = (E) this.f29804XxX0x0xxx;
            }
            return e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.oxoX
    @OXOo.OOXIXo
    public ReceiveChannel<E> ooOOo0oXI() {
        oIX0oI oix0oi;
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            if (this.f29802XI0IXoo == -1) {
                oix0oi = new II0xO0();
            } else {
                oix0oi = new oIX0oI();
            }
            if (X0IIOO() && this.f29804XxX0x0xxx == X0o0xo.II0xO0()) {
                ((BufferedChannel) oix0oi).x0o(oX());
                reentrantLock.unlock();
                return oix0oi;
            }
            if (this.f29804XxX0x0xxx != X0o0xo.II0xO0()) {
                ((BufferedChannel) oix0oi).x0xO0oo(x00IOx());
            }
            this.f29806xxX = CollectionsKt___CollectionsKt.OIxOIX0II(this.f29806xxX, oix0oi);
            reentrantLock.unlock();
            return oix0oi;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @OXOo.OOXIXo
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f29804XxX0x0xxx != X0o0xo.II0xO0()) {
            str = "CONFLATED_ELEMENT=" + this.f29804XxX0x0xxx + "; ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt___CollectionsKt.OoIXo(this.f29806xxX, x.aL, "<", ">", 0, null, null, 56, null));
        return sb.toString();
    }

    public final E x00IOx() {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            if (X0IIOO()) {
                Throwable oX2 = oX();
                if (oX2 == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw oX2;
            }
            if (this.f29804XxX0x0xxx != X0o0xo.II0xO0()) {
                E e = (E) this.f29804XxX0x0xxx;
                reentrantLock.unlock();
                return e;
            }
            throw new IllegalStateException("No value");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.oI0IIXIo
    public boolean x0o(@OXOo.oOoXoXO Throwable th) {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.f29806xxX.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).x0o(th);
            }
            List<? extends BufferedChannel<E>> list = this.f29806xxX;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).OO0x0xX()) {
                    arrayList.add(obj);
                }
            }
            this.f29806xxX = arrayList;
            boolean x0o2 = super.x0o(th);
            reentrantLock.unlock();
            return x0o2;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public Object x0xO0oo(E e) {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            if (X0IIOO()) {
                return super.x0xO0oo(e);
            }
            List<? extends BufferedChannel<E>> list = this.f29806xxX;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((BufferedChannel) it.next()).I0xX0()) {
                        return xoIox.f29891II0xO0.II0xO0();
                    }
                }
            }
            if (this.f29802XI0IXoo == -1) {
                this.f29804XxX0x0xxx = e;
            }
            Iterator<T> it2 = this.f29806xxX.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).x0xO0oo(e);
            }
            return xoIox.f29891II0xO0.I0Io(oXIO0o0XI.f29392oIX0oI);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void xXoOI00O(@OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> xoiox, @OXOo.oOoXoXO Object obj) {
        ReentrantLock reentrantLock = this.f29803XIxXXX0x0;
        reentrantLock.lock();
        try {
            Object remove = this.f29805xXxxox0I.remove(xoiox);
            if (remove != null) {
                xoiox.XO(remove);
                return;
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
            kotlinx.coroutines.II0XooXoX.X0o0xo(x0o.oIX0oI(xoiox.getContext()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, xoiox, null), 1, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
