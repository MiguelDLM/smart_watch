package kotlinx.coroutines.channels;

import XO0OX.o00;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.I0oOoX;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OI0;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.Oxx0IOOO;
import kotlinx.coroutines.internal.IO;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.X00IoxXI;
import kotlinx.coroutines.internal.x0o;
import kotlinx.coroutines.internal.xII;
import kotlinx.coroutines.o0IXXIx;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@XX({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
/* loaded from: classes6.dex */
public class BufferedChannel<E> implements Oxx0IOOO<E> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Oox.IXxxXO<kotlinx.coroutines.selects.xoIox<?>, Object, Object, Oox.oOoXoXO<Throwable, oXIO0o0XI>> f29818IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<E, oXIO0o0XI> f29819Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f29820XO;

    @OXOo.oOoXoXO
    @o00
    private volatile Object _closeCause;

    @o00
    private volatile long bufferEnd;

    @OXOo.oOoXoXO
    @o00
    private volatile Object bufferEndSegment;

    @OXOo.oOoXoXO
    @o00
    private volatile Object closeHandler;

    @o00
    private volatile long completedExpandBuffersAndPauseFlag;

    @OXOo.oOoXoXO
    @o00
    private volatile Object receiveSegment;

    @o00
    private volatile long receivers;

    @OXOo.oOoXoXO
    @o00
    private volatile Object sendSegment;

    @o00
    private volatile long sendersAndCloseStatus;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicLongFieldUpdater f29812Oxx0xo = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicLongFieldUpdater f29816oI0IIXIo = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicLongFieldUpdater f29813OxxIIOOXO = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicLongFieldUpdater f29809IIXOooo = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: xoXoI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29817xoXoI = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");

    /* renamed from: o00, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29815o00 = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");

    /* renamed from: OxI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29811OxI = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");

    /* renamed from: O0xOxO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29810O0xOxO = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");

    /* renamed from: X0IIOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f29814X0IIOO = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements o0IXXIx {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.x0xO0oo<Boolean> f29821Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final kotlinx.coroutines.oO<Boolean> f29822XO;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(@OXOo.OOXIXo kotlinx.coroutines.oO<? super Boolean> oOVar) {
            this.f29822XO = oOVar;
            IIX0o.x0XOIxOo(oOVar, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f29821Oo = (kotlinx.coroutines.x0xO0oo) oOVar;
        }

        @Override // kotlinx.coroutines.o0IXXIx
        public void II0xO0(@OXOo.OOXIXo X00IoxXI<?> x00IoxXI, int i) {
            this.f29821Oo.II0xO0(x00IoxXI, i);
        }

        @OXOo.OOXIXo
        public final kotlinx.coroutines.oO<Boolean> oIX0oI() {
            return this.f29822XO;
        }
    }

    @XX({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    /* loaded from: classes6.dex */
    public final class oIX0oI implements ChannelIterator<E>, o0IXXIx {

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.oOoXoXO
        public kotlinx.coroutines.x0xO0oo<? super Boolean> f29824Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public Object f29825XO;

        public oIX0oI() {
            x0o x0oVar;
            x0oVar = BufferedChannelKt.f29845o00;
            this.f29825XO = x0oVar;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @OXOo.oOoXoXO
        public Object I0Io(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super Boolean> i0Io) {
            OOXIXo<E> oOXIXo;
            x0o x0oVar;
            x0o x0oVar2;
            x0o x0oVar3;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            OOXIXo<E> oOXIXo2 = (OOXIXo) BufferedChannel.f29815o00.get(bufferedChannel);
            while (!bufferedChannel.XxX0x0xxx()) {
                long andIncrement = BufferedChannel.f29816oI0IIXIo.getAndIncrement(bufferedChannel);
                int i = BufferedChannelKt.f29828II0xO0;
                long j = andIncrement / i;
                int i2 = (int) (andIncrement % i);
                if (oOXIXo2.f30276IXxxXO != j) {
                    OOXIXo<E> xo0x2 = bufferedChannel.xo0x(j, oOXIXo2);
                    if (xo0x2 == null) {
                        continue;
                    } else {
                        oOXIXo = xo0x2;
                    }
                } else {
                    oOXIXo = oOXIXo2;
                }
                Object OooI2 = bufferedChannel.OooI(oOXIXo, i2, andIncrement, null);
                x0oVar = BufferedChannelKt.f29848oO;
                if (OooI2 != x0oVar) {
                    x0oVar2 = BufferedChannelKt.f29834Oo;
                    if (OooI2 != x0oVar2) {
                        x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                        if (OooI2 == x0oVar3) {
                            return II0XooXoX(oOXIXo, i2, andIncrement, i0Io);
                        }
                        oOXIXo.II0xO0();
                        this.f29825XO = OooI2;
                        return IXIxx0.oIX0oI.oIX0oI(true);
                    }
                    if (andIncrement < bufferedChannel.x0xO()) {
                        oOXIXo.II0xO0();
                    }
                    oOXIXo2 = oOXIXo;
                } else {
                    throw new IllegalStateException("unreachable");
                }
            }
            return IXIxx0.oIX0oI.oIX0oI(xxIXOIIO());
        }

        public final Object II0XooXoX(OOXIXo<E> oOXIXo, int i, long j, kotlin.coroutines.I0Io<? super Boolean> i0Io) {
            x0o x0oVar;
            x0o x0oVar2;
            Boolean oIX0oI2;
            x0o x0oVar3;
            x0o x0oVar4;
            x0o x0oVar5;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            kotlinx.coroutines.x0xO0oo II0xO02 = kotlinx.coroutines.Oxx0xo.II0xO0(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io));
            try {
                this.f29824Oo = II0xO02;
                Object OooI2 = bufferedChannel.OooI(oOXIXo, i, j, this);
                x0oVar = BufferedChannelKt.f29848oO;
                if (OooI2 == x0oVar) {
                    bufferedChannel.o0oIxOo(this, oOXIXo, i);
                } else {
                    x0oVar2 = BufferedChannelKt.f29834Oo;
                    Oox.oOoXoXO<Throwable, oXIO0o0XI> oooxoxo = null;
                    if (OooI2 == x0oVar2) {
                        if (j < bufferedChannel.x0xO()) {
                            oOXIXo.II0xO0();
                        }
                        OOXIXo oOXIXo2 = (OOXIXo) BufferedChannel.f29815o00.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.XxX0x0xxx()) {
                                xoIox();
                                break;
                            }
                            long andIncrement = BufferedChannel.f29816oI0IIXIo.getAndIncrement(bufferedChannel);
                            int i2 = BufferedChannelKt.f29828II0xO0;
                            long j2 = andIncrement / i2;
                            int i3 = (int) (andIncrement % i2);
                            if (oOXIXo2.f30276IXxxXO != j2) {
                                OOXIXo xo0x2 = bufferedChannel.xo0x(j2, oOXIXo2);
                                if (xo0x2 != null) {
                                    oOXIXo2 = xo0x2;
                                }
                            }
                            Object OooI3 = bufferedChannel.OooI(oOXIXo2, i3, andIncrement, this);
                            x0oVar3 = BufferedChannelKt.f29848oO;
                            if (OooI3 == x0oVar3) {
                                bufferedChannel.o0oIxOo(this, oOXIXo2, i3);
                                break;
                            }
                            x0oVar4 = BufferedChannelKt.f29834Oo;
                            if (OooI3 != x0oVar4) {
                                x0oVar5 = BufferedChannelKt.f29854x0xO0oo;
                                if (OooI3 != x0oVar5) {
                                    oOXIXo2.II0xO0();
                                    this.f29825XO = OooI3;
                                    this.f29824Oo = null;
                                    oIX0oI2 = IXIxx0.oIX0oI.oIX0oI(true);
                                    Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo2 = bufferedChannel.f29819Oo;
                                    if (oooxoxo2 != null) {
                                        oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo2, OooI3, II0xO02.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else if (andIncrement < bufferedChannel.x0xO()) {
                                oOXIXo2.II0xO0();
                            }
                        }
                    } else {
                        oOXIXo.II0xO0();
                        this.f29825XO = OooI2;
                        this.f29824Oo = null;
                        oIX0oI2 = IXIxx0.oIX0oI.oIX0oI(true);
                        Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo3 = bufferedChannel.f29819Oo;
                        if (oooxoxo3 != null) {
                            oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo3, OooI2, II0xO02.getContext());
                        }
                    }
                    II0xO02.OxxIIOOXO(oIX0oI2, oooxoxo);
                }
                Object o002 = II0xO02.o00();
                if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                    IXIxx0.XO.I0Io(i0Io);
                }
                return o002;
            } catch (Throwable th) {
                II0xO02.Xx000oIo();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.o0IXXIx
        public void II0xO0(@OXOo.OOXIXo X00IoxXI<?> x00IoxXI, int i) {
            kotlinx.coroutines.x0xO0oo<? super Boolean> x0xo0oo = this.f29824Oo;
            if (x0xo0oo != null) {
                x0xo0oo.II0xO0(x00IoxXI, i);
            }
        }

        public final boolean OOXIXo(E e) {
            boolean xXxxox0I2;
            kotlinx.coroutines.x0xO0oo<? super Boolean> x0xo0oo = this.f29824Oo;
            IIX0o.ooOOo0oXI(x0xo0oo);
            Oox.oOoXoXO<Throwable, oXIO0o0XI> oooxoxo = null;
            this.f29824Oo = null;
            this.f29825XO = e;
            Boolean bool = Boolean.TRUE;
            Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo2 = BufferedChannel.this.f29819Oo;
            if (oooxoxo2 != null) {
                oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo2, e, x0xo0oo.getContext());
            }
            xXxxox0I2 = BufferedChannelKt.xXxxox0I(x0xo0oo, bool, oooxoxo);
            return xXxxox0I2;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            x0o x0oVar;
            x0o x0oVar2;
            E e = (E) this.f29825XO;
            x0oVar = BufferedChannelKt.f29845o00;
            if (e != x0oVar) {
                x0oVar2 = BufferedChannelKt.f29845o00;
                this.f29825XO = x0oVar2;
                if (e != BufferedChannelKt.O0xOxO()) {
                    return e;
                }
                throw xII.oO(BufferedChannel.this.OO());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @XO0OX.xxIXOIIO(name = "next")
        public /* synthetic */ Object oIX0oI(kotlin.coroutines.I0Io i0Io) {
            return ChannelIterator.DefaultImpls.oIX0oI(this, i0Io);
        }

        public final void oOoXoXO() {
            kotlinx.coroutines.x0xO0oo<? super Boolean> x0xo0oo = this.f29824Oo;
            IIX0o.ooOOo0oXI(x0xo0oo);
            this.f29824Oo = null;
            this.f29825XO = BufferedChannelKt.O0xOxO();
            Throwable oX2 = BufferedChannel.this.oX();
            if (oX2 == null) {
                Result.oIX0oI oix0oi = Result.Companion;
                x0xo0oo.resumeWith(Result.m287constructorimpl(Boolean.FALSE));
            } else {
                Result.oIX0oI oix0oi2 = Result.Companion;
                x0xo0oo.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(oX2)));
            }
        }

        public final void xoIox() {
            kotlinx.coroutines.x0xO0oo<? super Boolean> x0xo0oo = this.f29824Oo;
            IIX0o.ooOOo0oXI(x0xo0oo);
            this.f29824Oo = null;
            this.f29825XO = BufferedChannelKt.O0xOxO();
            Throwable oX2 = BufferedChannel.this.oX();
            if (oX2 == null) {
                Result.oIX0oI oix0oi = Result.Companion;
                x0xo0oo.resumeWith(Result.m287constructorimpl(Boolean.FALSE));
            } else {
                Result.oIX0oI oix0oi2 = Result.Companion;
                x0xo0oo.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(oX2)));
            }
        }

        public final boolean xxIXOIIO() {
            this.f29825XO = BufferedChannelKt.O0xOxO();
            Throwable oX2 = BufferedChannel.this.oX();
            if (oX2 == null) {
                return false;
            }
            throw xII.oO(oX2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [Oox.oOoXoXO<? super E, kotlin.oXIO0o0XI>, Oox.oOoXoXO<E, kotlin.oXIO0o0XI>] */
    public BufferedChannel(int i, @OXOo.oOoXoXO Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        long XxX0x0xxx2;
        x0o x0oVar;
        this.f29820XO = i;
        this.f29819Oo = oooxoxo;
        if (i >= 0) {
            XxX0x0xxx2 = BufferedChannelKt.XxX0x0xxx(i);
            this.bufferEnd = XxX0x0xxx2;
            this.completedExpandBuffersAndPauseFlag = I0X0x0oIo();
            OOXIXo oOXIXo = new OOXIXo(0L, null, this, 3);
            this.sendSegment = oOXIXo;
            this.receiveSegment = oOXIXo;
            if (ooOx()) {
                oOXIXo = BufferedChannelKt.f29847oIX0oI;
                IIX0o.x0XOIxOo(oOXIXo, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = oOXIXo;
            this.f29818IXxxXO = oooxoxo != 0 ? new Oox.IXxxXO<kotlinx.coroutines.selects.xoIox<?>, Object, Object, Oox.oOoXoXO<? super Throwable, ? extends oXIO0o0XI>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                final /* synthetic */ BufferedChannel<E> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.this$0 = this;
                }

                @Override // Oox.IXxxXO
                @OXOo.OOXIXo
                public final Oox.oOoXoXO<Throwable, oXIO0o0XI> invoke(@OXOo.OOXIXo final kotlinx.coroutines.selects.xoIox<?> xoiox, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO final Object obj2) {
                    final BufferedChannel<E> bufferedChannel = this.this$0;
                    return new Oox.oOoXoXO<Throwable, oXIO0o0XI>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Throwable th) {
                            invoke2(th);
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo Throwable th) {
                            if (obj2 != BufferedChannelKt.O0xOxO()) {
                                OnUndeliveredElementKt.II0xO0(bufferedChannel.f29819Oo, obj2, xoiox.getContext());
                            }
                        }
                    };
                }
            } : null;
            x0oVar = BufferedChannelKt.f29839X0IIOO;
            this._closeCause = x0oVar;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
    }

    @XI0oooXX
    public static /* synthetic */ void I0() {
    }

    public static /* synthetic */ void I0oOIX() {
    }

    public static /* synthetic */ <E> Object IO0XoXxO(BufferedChannel<E> bufferedChannel, E e, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        OOXIXo<E> oOXIXo = (OOXIXo) f29817xoXoI.get(bufferedChannel);
        while (true) {
            long andIncrement = f29812Oxx0xo.getAndIncrement(bufferedChannel);
            long j = BufferedChannelKt.f29829IIX0o & andIncrement;
            boolean OOXIxO02 = bufferedChannel.OOXIxO0(andIncrement);
            int i = BufferedChannelKt.f29828II0xO0;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (oOXIXo.f30276IXxxXO != j2) {
                OOXIXo<E> xXOx2 = bufferedChannel.xXOx(j2, oOXIXo);
                if (xXOx2 == null) {
                    if (OOXIxO02) {
                        Object xx0X02 = bufferedChannel.xx0X0(e, i0Io);
                        if (xx0X02 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                            return xx0X02;
                        }
                    }
                } else {
                    oOXIXo = xXOx2;
                }
            }
            int xIXX2 = bufferedChannel.xIXX(oOXIXo, i2, e, j, null, OOXIxO02);
            if (xIXX2 != 0) {
                if (xIXX2 == 1) {
                    break;
                }
                if (xIXX2 != 2) {
                    if (xIXX2 != 3) {
                        if (xIXX2 != 4) {
                            if (xIXX2 == 5) {
                                oOXIXo.II0xO0();
                            }
                        } else {
                            if (j < bufferedChannel.IoOoo()) {
                                oOXIXo.II0xO0();
                            }
                            Object xx0X03 = bufferedChannel.xx0X0(e, i0Io);
                            if (xx0X03 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                                return xx0X03;
                            }
                        }
                    } else {
                        Object oXX0IoI2 = bufferedChannel.oXX0IoI(oOXIXo, i2, e, j, i0Io);
                        if (oXX0IoI2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                            return oXX0IoI2;
                        }
                    }
                } else if (OOXIxO02) {
                    oOXIXo.IXxxXO();
                    Object xx0X04 = bufferedChannel.xx0X0(e, i0Io);
                    if (xx0X04 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                        return xx0X04;
                    }
                }
            } else {
                oOXIXo.II0xO0();
                break;
            }
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public static /* synthetic */ Object IOoo(BufferedChannel bufferedChannel, Object obj, Object obj2, Oox.oIX0oI oix0oi, Oox.x0xO0oo x0xo0oo, Oox.oIX0oI oix0oi2, Oox.Oxx0xo oxx0xo, int i, Object obj3) {
        Oox.Oxx0xo oxx0xo2;
        OOXIXo oOXIXo;
        o0IXXIx o0ixxix;
        if (obj3 == null) {
            if ((i & 32) != 0) {
                oxx0xo2 = new Oox.Oxx0xo() { // from class: kotlinx.coroutines.channels.BufferedChannel$sendImpl$1
                    @Override // Oox.Oxx0xo
                    public /* bridge */ /* synthetic */ Object invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                        return invoke((OOXIXo<int>) obj4, ((Number) obj5).intValue(), (int) obj6, ((Number) obj7).longValue());
                    }

                    @OXOo.OOXIXo
                    public final Void invoke(@OXOo.OOXIXo OOXIXo<E> oOXIXo2, int i2, E e, long j) {
                        throw new IllegalStateException("unexpected");
                    }
                };
            } else {
                oxx0xo2 = oxx0xo;
            }
            OOXIXo oOXIXo2 = (OOXIXo) f29817xoXoI.get(bufferedChannel);
            while (true) {
                long andIncrement = f29812Oxx0xo.getAndIncrement(bufferedChannel);
                long j = andIncrement & BufferedChannelKt.f29829IIX0o;
                boolean OOXIxO02 = bufferedChannel.OOXIxO0(andIncrement);
                int i2 = BufferedChannelKt.f29828II0xO0;
                long j2 = j / i2;
                int i3 = (int) (j % i2);
                if (oOXIXo2.f30276IXxxXO != j2) {
                    OOXIXo xXOx2 = bufferedChannel.xXOx(j2, oOXIXo2);
                    if (xXOx2 == null) {
                        if (OOXIxO02) {
                            return oix0oi2.invoke();
                        }
                    } else {
                        oOXIXo = xXOx2;
                    }
                } else {
                    oOXIXo = oOXIXo2;
                }
                int xIXX2 = bufferedChannel.xIXX(oOXIXo, i3, obj, j, obj2, OOXIxO02);
                if (xIXX2 != 0) {
                    if (xIXX2 != 1) {
                        if (xIXX2 != 2) {
                            if (xIXX2 != 3) {
                                if (xIXX2 != 4) {
                                    if (xIXX2 == 5) {
                                        oOXIXo.II0xO0();
                                    }
                                    oOXIXo2 = oOXIXo;
                                } else {
                                    if (j < bufferedChannel.IoOoo()) {
                                        oOXIXo.II0xO0();
                                    }
                                    return oix0oi2.invoke();
                                }
                            } else {
                                return oxx0xo2.invoke(oOXIXo, Integer.valueOf(i3), obj, Long.valueOf(j));
                            }
                        } else {
                            if (OOXIxO02) {
                                oOXIXo.IXxxXO();
                                return oix0oi2.invoke();
                            }
                            if (obj2 instanceof o0IXXIx) {
                                o0ixxix = (o0IXXIx) obj2;
                            } else {
                                o0ixxix = null;
                            }
                            if (o0ixxix != null) {
                                bufferedChannel.XIXIxO(o0ixxix, oOXIXo, i3);
                            }
                            return x0xo0oo.invoke(oOXIXo, Integer.valueOf(i3));
                        }
                    } else {
                        return oix0oi.invoke();
                    }
                } else {
                    oOXIXo.II0xO0();
                    return oix0oi.invoke();
                }
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
    }

    public static /* synthetic */ void Ioxxx(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 1;
            }
            bufferedChannel.XIo0oOXIx(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    public static /* synthetic */ Object Ix00oIoI(BufferedChannel bufferedChannel, Object obj, Oox.oOoXoXO oooxoxo, Oox.IXxxXO iXxxXO, Oox.oIX0oI oix0oi, Oox.IXxxXO iXxxXO2, int i, Object obj2) {
        x0o x0oVar;
        o0IXXIx o0ixxix;
        x0o x0oVar2;
        x0o x0oVar3;
        if (obj2 == null) {
            if ((i & 16) != 0) {
                iXxxXO2 = new Oox.IXxxXO() { // from class: kotlinx.coroutines.channels.BufferedChannel$receiveImpl$1
                    @Override // Oox.IXxxXO
                    public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5) {
                        return invoke((OOXIXo) obj3, ((Number) obj4).intValue(), ((Number) obj5).longValue());
                    }

                    @OXOo.OOXIXo
                    public final Void invoke(@OXOo.OOXIXo OOXIXo<E> oOXIXo, int i2, long j) {
                        throw new IllegalStateException("unexpected");
                    }
                };
            }
            OOXIXo oOXIXo = (OOXIXo) f29815o00.get(bufferedChannel);
            while (!bufferedChannel.XxX0x0xxx()) {
                long andIncrement = f29816oI0IIXIo.getAndIncrement(bufferedChannel);
                int i2 = BufferedChannelKt.f29828II0xO0;
                long j = andIncrement / i2;
                int i3 = (int) (andIncrement % i2);
                if (oOXIXo.f30276IXxxXO != j) {
                    OOXIXo xo0x2 = bufferedChannel.xo0x(j, oOXIXo);
                    if (xo0x2 == null) {
                        continue;
                    } else {
                        oOXIXo = xo0x2;
                    }
                }
                Object OooI2 = bufferedChannel.OooI(oOXIXo, i3, andIncrement, obj);
                x0oVar = BufferedChannelKt.f29848oO;
                if (OooI2 != x0oVar) {
                    x0oVar2 = BufferedChannelKt.f29834Oo;
                    if (OooI2 != x0oVar2) {
                        x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                        if (OooI2 == x0oVar3) {
                            return iXxxXO2.invoke(oOXIXo, Integer.valueOf(i3), Long.valueOf(andIncrement));
                        }
                        oOXIXo.II0xO0();
                        return oooxoxo.invoke(OooI2);
                    }
                    if (andIncrement < bufferedChannel.x0xO()) {
                        oOXIXo.II0xO0();
                    }
                } else {
                    if (obj instanceof o0IXXIx) {
                        o0ixxix = (o0IXXIx) obj;
                    } else {
                        o0ixxix = null;
                    }
                    if (o0ixxix != null) {
                        bufferedChannel.o0oIxOo(o0ixxix, oOXIXo, i3);
                    }
                    return iXxxXO.invoke(oOXIXo, Integer.valueOf(i3), Long.valueOf(andIncrement));
                }
            }
            return oix0oi.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    public static /* synthetic */ <E> Object IxIX0I(BufferedChannel<E> bufferedChannel, kotlin.coroutines.I0Io<? super E> i0Io) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        OOXIXo<E> oOXIXo = (OOXIXo) f29815o00.get(bufferedChannel);
        while (!bufferedChannel.XxX0x0xxx()) {
            long andIncrement = f29816oI0IIXIo.getAndIncrement(bufferedChannel);
            int i = BufferedChannelKt.f29828II0xO0;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (oOXIXo.f30276IXxxXO != j) {
                OOXIXo<E> xo0x2 = bufferedChannel.xo0x(j, oOXIXo);
                if (xo0x2 == null) {
                    continue;
                } else {
                    oOXIXo = xo0x2;
                }
            }
            Object OooI2 = bufferedChannel.OooI(oOXIXo, i2, andIncrement, null);
            x0oVar = BufferedChannelKt.f29848oO;
            if (OooI2 != x0oVar) {
                x0oVar2 = BufferedChannelKt.f29834Oo;
                if (OooI2 != x0oVar2) {
                    x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                    if (OooI2 == x0oVar3) {
                        return bufferedChannel.IoXIXo(oOXIXo, i2, andIncrement, i0Io);
                    }
                    oOXIXo.II0xO0();
                    return OooI2;
                }
                if (andIncrement < bufferedChannel.x0xO()) {
                    oOXIXo.II0xO0();
                }
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        throw xII.oO(bufferedChannel.OO());
    }

    @XI0oooXX
    public static /* synthetic */ void O00XxXI() {
    }

    public static /* synthetic */ void O0Xx() {
    }

    private final void OX00O0xII(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @XI0oooXX
    public static /* synthetic */ void XI0oooXX() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a6, code lost:
    
        r0 = kotlin.Result.Companion;
        r9.resumeWith(kotlin.Result.m287constructorimpl(IXIxx0.oIX0oI.oIX0oI(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object XOxxooXI(kotlinx.coroutines.channels.BufferedChannel<E> r18, E r19, kotlin.coroutines.I0Io<? super java.lang.Boolean> r20) {
        /*
            r8 = r18
            kotlinx.coroutines.x0xO0oo r9 = new kotlinx.coroutines.x0xO0oo
            kotlin.coroutines.I0Io r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(r20)
            r10 = 1
            r9.<init>(r0, r10)
            r9.IO()
            Oox.oOoXoXO<E, kotlin.oXIO0o0XI> r0 = r8.f29819Oo
            if (r0 != 0) goto Lc8
            kotlinx.coroutines.channels.BufferedChannel$II0xO0 r11 = new kotlinx.coroutines.channels.BufferedChannel$II0xO0
            r11.<init>(r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = II0XooXoX()
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.OOXIXo r0 = (kotlinx.coroutines.channels.OOXIXo) r0
        L22:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = xoIox()
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r12 = r1 & r3
            boolean r14 = oOoXoXO(r8, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            long r2 = (long) r1
            long r2 = r12 / r2
            long r4 = (long) r1
            long r4 = r12 % r4
            int r15 = (int) r4
            long r4 = r0.f30276IXxxXO
            r16 = 0
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L5f
            kotlinx.coroutines.channels.OOXIXo r1 = oxoX(r8, r2, r0)
            if (r1 != 0) goto L5d
            if (r14 == 0) goto L22
        L4e:
            kotlin.Result$oIX0oI r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = IXIxx0.oIX0oI.oIX0oI(r16)
            java.lang.Object r0 = kotlin.Result.m287constructorimpl(r0)
            r9.resumeWith(r0)
            goto Lba
        L5d:
            r7 = r1
            goto L60
        L5f:
            r7 = r0
        L60:
            r0 = r18
            r1 = r7
            r2 = r15
            r3 = r19
            r4 = r12
            r6 = r11
            r17 = r7
            r7 = r14
            int r0 = oo(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb4
            if (r0 == r10) goto La6
            r1 = 2
            if (r0 == r1) goto L9a
            r1 = 3
            if (r0 == r1) goto L92
            r1 = 4
            if (r0 == r1) goto L86
            r1 = 5
            if (r0 == r1) goto L80
            goto L83
        L80:
            r17.II0xO0()
        L83:
            r0 = r17
            goto L22
        L86:
            long r0 = r18.IoOoo()
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 >= 0) goto L4e
            r17.II0xO0()
            goto L4e
        L92:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            r0.<init>(r1)
            throw r0
        L9a:
            if (r14 == 0) goto La0
            r17.IXxxXO()
            goto L4e
        La0:
            r0 = r17
            OxI(r8, r11, r0, r15)
            goto Lba
        La6:
            kotlin.Result$oIX0oI r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = IXIxx0.oIX0oI.oIX0oI(r10)
            java.lang.Object r0 = kotlin.Result.m287constructorimpl(r0)
            r9.resumeWith(r0)
            goto Lba
        Lb4:
            r0 = r17
            r0.II0xO0()
            goto La6
        Lba:
            java.lang.Object r0 = r9.o00()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            if (r0 != r1) goto Lc7
            IXIxx0.XO.I0Io(r20)
        Lc7:
            return r0
        Lc8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.XOxxooXI(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.I0Io):java.lang.Object");
    }

    public static /* synthetic */ void Xo0() {
    }

    public static /* synthetic */ void XoI0Ixx0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ <E> java.lang.Object oOoIIO0(kotlinx.coroutines.channels.BufferedChannel<E> r13, kotlin.coroutines.I0Io<? super kotlinx.coroutines.channels.xoIox<? extends E>> r14) {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            kotlin.I0oOoX.x0XOIxOo(r14)
            kotlinx.coroutines.channels.xoIox r14 = (kotlinx.coroutines.channels.xoIox) r14
            java.lang.Object r13 = r14.oO()
            goto Lb2
        L32:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3a:
            kotlin.I0oOoX.x0XOIxOo(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = XO()
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.OOXIXo r14 = (kotlinx.coroutines.channels.OOXIXo) r14
        L47:
            boolean r1 = r13.XxX0x0xxx()
            if (r1 == 0) goto L58
            kotlinx.coroutines.channels.xoIox$II0xO0 r14 = kotlinx.coroutines.channels.xoIox.f29891II0xO0
            java.lang.Throwable r13 = r13.oX()
            java.lang.Object r13 = r14.oIX0oI(r13)
            goto Lb2
        L58:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = Oxx0IOOO()
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f30276IXxxXO
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L77
            kotlinx.coroutines.channels.OOXIXo r1 = I0Io(r13, r7, r14)
            if (r1 != 0) goto L76
            goto L47
        L76:
            r14 = r1
        L77:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = oo0xXOI0I(r7, r8, r9, r10, r12)
            kotlinx.coroutines.internal.x0o r7 = kotlinx.coroutines.channels.BufferedChannelKt.IXxxXO()
            if (r1 == r7) goto Lb3
            kotlinx.coroutines.internal.x0o r7 = kotlinx.coroutines.channels.BufferedChannelKt.II0XooXoX()
            if (r1 != r7) goto L98
            long r7 = r13.x0xO()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L47
            r14.II0xO0()
            goto L47
        L98:
            kotlinx.coroutines.internal.x0o r7 = kotlinx.coroutines.channels.BufferedChannelKt.Oxx0xo()
            if (r1 != r7) goto La9
            r6.label = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.IXO(r2, r3, r4, r6)
            if (r13 != r0) goto Lb2
            return r0
        La9:
            r14.II0xO0()
            kotlinx.coroutines.channels.xoIox$II0xO0 r13 = kotlinx.coroutines.channels.xoIox.f29891II0xO0
            java.lang.Object r13 = r13.I0Io(r1)
        Lb2:
            return r13
        Lb3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.oOoIIO0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.I0Io):java.lang.Object");
    }

    public static /* synthetic */ void xoxXI() {
    }

    public final long I0X0x0oIo() {
        return f29813OxxIIOOXO.get(this);
    }

    public final void I0oOoX() {
        X0IIOO();
    }

    public boolean I0xX0() {
        return XXXI(f29812Oxx0xo.get(this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException) {
        oOXoIIIo(cancellationException);
    }

    public final void IIX0(kotlinx.coroutines.oO<? super xoIox<? extends E>> oOVar) {
        Result.oIX0oI oix0oi = Result.Companion;
        oOVar.resumeWith(Result.m287constructorimpl(xoIox.II0xO0(xoIox.f29891II0xO0.oIX0oI(oX()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.OOXIXo
    public Object IIXOooo() {
        Object obj;
        OOXIXo oOXIXo;
        x0o x0oVar;
        o0IXXIx o0ixxix;
        x0o x0oVar2;
        x0o x0oVar3;
        long j = f29816oI0IIXIo.get(this);
        long j2 = f29812Oxx0xo.get(this);
        if (ox(j2)) {
            return xoIox.f29891II0xO0.oIX0oI(oX());
        }
        if (j < (j2 & BufferedChannelKt.f29829IIX0o)) {
            obj = BufferedChannelKt.f29850ooOOo0oXI;
            OOXIXo oOXIXo2 = (OOXIXo) f29815o00.get(this);
            while (!XxX0x0xxx()) {
                long andIncrement = f29816oI0IIXIo.getAndIncrement(this);
                int i = BufferedChannelKt.f29828II0xO0;
                long j3 = andIncrement / i;
                int i2 = (int) (andIncrement % i);
                if (oOXIXo2.f30276IXxxXO != j3) {
                    OOXIXo xo0x2 = xo0x(j3, oOXIXo2);
                    if (xo0x2 == null) {
                        continue;
                    } else {
                        oOXIXo = xo0x2;
                    }
                } else {
                    oOXIXo = oOXIXo2;
                }
                Object OooI2 = OooI(oOXIXo, i2, andIncrement, obj);
                x0oVar = BufferedChannelKt.f29848oO;
                if (OooI2 != x0oVar) {
                    x0oVar2 = BufferedChannelKt.f29834Oo;
                    if (OooI2 != x0oVar2) {
                        x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                        if (OooI2 != x0oVar3) {
                            oOXIXo.II0xO0();
                            return xoIox.f29891II0xO0.I0Io(OooI2);
                        }
                        throw new IllegalStateException("unexpected");
                    }
                    if (andIncrement < x0xO()) {
                        oOXIXo.II0xO0();
                    }
                    oOXIXo2 = oOXIXo;
                } else {
                    if (obj instanceof o0IXXIx) {
                        o0ixxix = (o0IXXIx) obj;
                    } else {
                        o0ixxix = null;
                    }
                    if (o0ixxix != null) {
                        o0oIxOo(o0ixxix, oOXIXo, i2);
                    }
                    O0xxXxI(andIncrement);
                    oOXIXo.IXxxXO();
                    return xoIox.f29891II0xO0.II0xO0();
                }
            }
            return xoIox.f29891II0xO0.oIX0oI(oX());
        }
        return xoIox.f29891II0xO0.II0xO0();
    }

    public boolean IIxOXoOo0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void IO() {
        boolean z;
        x0o x0oVar;
        x0o x0oVar2;
        boolean Oxx0IOOO2;
        boolean Oxx0IOOO3;
        x0o x0oVar3;
        x0o x0oVar4;
        boolean Oxx0IOOO4;
        boolean z2;
        boolean z3;
        OOXIXo oOXIXo;
        OOXIXo oOXIXo2;
        if (ooOx()) {
            Object obj = f29811OxI.get(this);
            oOXIXo2 = BufferedChannelKt.f29847oIX0oI;
            if (obj != oOXIXo2) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((OOXIXo) f29815o00.get(this)).f30276IXxxXO > ((OOXIXo) f29811OxI.get(this)).f30276IXxxXO) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(f29815o00.get(this), f29817xoXoI.get(this), f29811OxI.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : X00IoxXI2) {
            OOXIXo oOXIXo3 = (OOXIXo) obj2;
            oOXIXo = BufferedChannelKt.f29847oIX0oI;
            if (oOXIXo3 != oOXIXo) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j = ((OOXIXo) next).f30276IXxxXO;
                do {
                    Object next2 = it.next();
                    long j2 = ((OOXIXo) next2).f30276IXxxXO;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
            OOXIXo oOXIXo4 = (OOXIXo) next;
            if (oOXIXo4.Oxx0IOOO() == 0) {
                while (oOXIXo4.X0o0xo() != 0) {
                    S X0o0xo2 = oOXIXo4.X0o0xo();
                    IIX0o.ooOOo0oXI(X0o0xo2);
                    if (((OOXIXo) X0o0xo2).Oxx0IOOO() != 0) {
                        S X0o0xo3 = oOXIXo4.X0o0xo();
                        IIX0o.ooOOo0oXI(X0o0xo3);
                        if (((OOXIXo) X0o0xo3).Oxx0IOOO() != oOXIXo4) {
                            throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                        }
                    }
                    int i = BufferedChannelKt.f29828II0xO0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        Object OxI2 = oOXIXo4.OxI(i3);
                        if (!IIX0o.Oxx0IOOO(OxI2, BufferedChannelKt.f29843XO) && !(OxI2 instanceof o0IXXIx)) {
                            x0oVar = BufferedChannelKt.f29850ooOOo0oXI;
                            if (!IIX0o.Oxx0IOOO(OxI2, x0oVar)) {
                                x0oVar2 = BufferedChannelKt.f29849oOoXoXO;
                                Oxx0IOOO2 = IIX0o.Oxx0IOOO(OxI2, x0oVar2);
                            } else {
                                Oxx0IOOO2 = true;
                            }
                            if (Oxx0IOOO2) {
                                Oxx0IOOO3 = true;
                            } else {
                                Oxx0IOOO3 = IIX0o.Oxx0IOOO(OxI2, BufferedChannelKt.O0xOxO());
                            }
                            if (!Oxx0IOOO3) {
                                x0oVar3 = BufferedChannelKt.f29857xoIox;
                                if (!IIX0o.Oxx0IOOO(OxI2, x0oVar3)) {
                                    x0oVar4 = BufferedChannelKt.f29833OOXIXo;
                                    Oxx0IOOO4 = IIX0o.Oxx0IOOO(OxI2, x0oVar4);
                                } else {
                                    Oxx0IOOO4 = true;
                                }
                                if (Oxx0IOOO4) {
                                    if (oOXIXo4.o00(i3) == null) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                } else {
                                    throw new IllegalStateException(("Unexpected segment cell state: " + OxI2 + ".\nChannel state: " + this).toString());
                                }
                            } else {
                                if (oOXIXo4.o00(i3) == null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    i2++;
                                } else {
                                    throw new IllegalStateException("Check failed.");
                                }
                            }
                        }
                    }
                    if (i2 == BufferedChannelKt.f29828II0xO0) {
                        if (oOXIXo4 != f29815o00.get(this) && oOXIXo4 != f29817xoXoI.get(this) && oOXIXo4 != f29811OxI.get(this)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
                        }
                    }
                    S X0o0xo4 = oOXIXo4.X0o0xo();
                    IIX0o.ooOOo0oXI(X0o0xo4);
                    oOXIXo4 = (OOXIXo) X0o0xo4;
                }
                return;
            }
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object IXO(kotlinx.coroutines.channels.OOXIXo<E> r11, int r12, long r13, kotlin.coroutines.I0Io<? super kotlinx.coroutines.channels.xoIox<? extends E>> r15) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.IXO(kotlinx.coroutines.channels.OOXIXo, int, long, kotlin.coroutines.I0Io):java.lang.Object");
    }

    public boolean Io(@OXOo.oOoXoXO Throwable th, boolean z) {
        x0o x0oVar;
        if (z) {
            xOOOX();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29810O0xOxO;
        x0oVar = BufferedChannelKt.f29839X0IIOO;
        boolean oIX0oI2 = androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x0oVar, th);
        if (z) {
            XIXIX();
        } else {
            oXIO0o0XI();
        }
        I0oOoX();
        O0X();
        if (oIX0oI2) {
            xxIO();
        }
        return oIX0oI2;
    }

    public void IoIOOxIIo() {
    }

    public final boolean IoOoX(long j) {
        if (j >= I0X0x0oIo() && j >= IoOoo() + this.f29820XO) {
            return false;
        }
        return true;
    }

    public final long IoOoo() {
        return f29816oI0IIXIo.get(this);
    }

    public final Object IoXIXo(OOXIXo<E> oOXIXo, int i, long j, kotlin.coroutines.I0Io<? super E> i0Io) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        kotlinx.coroutines.x0xO0oo II0xO02 = kotlinx.coroutines.Oxx0xo.II0xO0(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io));
        try {
            Object OooI2 = OooI(oOXIXo, i, j, II0xO02);
            x0oVar = BufferedChannelKt.f29848oO;
            if (OooI2 == x0oVar) {
                o0oIxOo(II0xO02, oOXIXo, i);
            } else {
                x0oVar2 = BufferedChannelKt.f29834Oo;
                Oox.oOoXoXO<Throwable, oXIO0o0XI> oooxoxo = null;
                oooxoxo = null;
                kotlinx.coroutines.x0xO0oo x0xo0oo = null;
                if (OooI2 == x0oVar2) {
                    if (j < x0xO()) {
                        oOXIXo.II0xO0();
                    }
                    OOXIXo oOXIXo2 = (OOXIXo) f29815o00.get(this);
                    while (true) {
                        if (XxX0x0xxx()) {
                            xOoOIoI(II0xO02);
                            break;
                        }
                        long andIncrement = f29816oI0IIXIo.getAndIncrement(this);
                        int i2 = BufferedChannelKt.f29828II0xO0;
                        long j2 = andIncrement / i2;
                        int i3 = (int) (andIncrement % i2);
                        if (oOXIXo2.f30276IXxxXO != j2) {
                            OOXIXo xo0x2 = xo0x(j2, oOXIXo2);
                            if (xo0x2 != null) {
                                oOXIXo2 = xo0x2;
                            }
                        }
                        OooI2 = OooI(oOXIXo2, i3, andIncrement, II0xO02);
                        x0oVar3 = BufferedChannelKt.f29848oO;
                        if (OooI2 != x0oVar3) {
                            x0oVar4 = BufferedChannelKt.f29834Oo;
                            if (OooI2 != x0oVar4) {
                                x0oVar5 = BufferedChannelKt.f29854x0xO0oo;
                                if (OooI2 != x0oVar5) {
                                    oOXIXo2.II0xO0();
                                    Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo2 = this.f29819Oo;
                                    if (oooxoxo2 != null) {
                                        oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo2, OooI2, II0xO02.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            } else if (andIncrement < x0xO()) {
                                oOXIXo2.II0xO0();
                            }
                        } else {
                            if (II0xO02 instanceof o0IXXIx) {
                                x0xo0oo = II0xO02;
                            }
                            if (x0xo0oo != null) {
                                o0oIxOo(x0xo0oo, oOXIXo2, i3);
                            }
                        }
                    }
                } else {
                    oOXIXo.II0xO0();
                    Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo3 = this.f29819Oo;
                    if (oooxoxo3 != null) {
                        oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo3, OooI2, II0xO02.getContext());
                    }
                }
                II0xO02.OxxIIOOXO(OooI2, oooxoxo);
            }
            Object o002 = II0xO02.o00();
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return o002;
        } catch (Throwable th) {
            II0xO02.Xx000oIo();
            throw th;
        }
    }

    public final void O0(E e, kotlinx.coroutines.selects.xoIox<?> xoiox) {
        Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo = this.f29819Oo;
        if (oooxoxo != null) {
            OnUndeliveredElementKt.II0xO0(oooxoxo, e, xoiox.getContext());
        }
        xoiox.XO(BufferedChannelKt.O0xOxO());
    }

    public final void O00(long j) {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f29816oI0IIXIo;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if (j2 >= j) {
                return;
            }
        } while (!f29816oI0IIXIo.compareAndSet(this, j2, j));
    }

    public final void O0IxXx(OOXIXo<E> oOXIXo, int i, long j, o0IXXIx o0ixxix, Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo, Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        x0o x0oVar6 = (Object) OooI(oOXIXo, i, j, o0ixxix);
        x0oVar = BufferedChannelKt.f29848oO;
        if (x0oVar6 == x0oVar) {
            o0oIxOo(o0ixxix, oOXIXo, i);
            return;
        }
        x0oVar2 = BufferedChannelKt.f29834Oo;
        if (x0oVar6 == x0oVar2) {
            if (j < x0xO()) {
                oOXIXo.II0xO0();
            }
            OOXIXo oOXIXo2 = (OOXIXo) f29815o00.get(this);
            while (!XxX0x0xxx()) {
                long andIncrement = f29816oI0IIXIo.getAndIncrement(this);
                int i2 = BufferedChannelKt.f29828II0xO0;
                long j2 = andIncrement / i2;
                int i3 = (int) (andIncrement % i2);
                if (oOXIXo2.f30276IXxxXO != j2) {
                    OOXIXo xo0x2 = xo0x(j2, oOXIXo2);
                    if (xo0x2 == null) {
                        continue;
                    } else {
                        oOXIXo2 = xo0x2;
                    }
                }
                x0o x0oVar7 = (Object) OooI(oOXIXo2, i3, andIncrement, o0ixxix);
                x0oVar3 = BufferedChannelKt.f29848oO;
                if (x0oVar7 != x0oVar3) {
                    x0oVar4 = BufferedChannelKt.f29834Oo;
                    if (x0oVar7 != x0oVar4) {
                        x0oVar5 = BufferedChannelKt.f29854x0xO0oo;
                        if (x0oVar7 != x0oVar5) {
                            oOXIXo2.II0xO0();
                            oooxoxo.invoke(x0oVar7);
                            return;
                        }
                        throw new IllegalStateException("unexpected");
                    }
                    if (andIncrement < x0xO()) {
                        oOXIXo2.II0xO0();
                    }
                } else {
                    if (!(o0ixxix instanceof o0IXXIx)) {
                        o0ixxix = null;
                    }
                    if (o0ixxix != null) {
                        o0oIxOo(o0ixxix, oOXIXo2, i3);
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    return;
                }
            }
            oix0oi.invoke();
            return;
        }
        oOXIXo.II0xO0();
        oooxoxo.invoke(x0oVar6);
    }

    public void O0X() {
    }

    public final void O0xxXxI(long j) {
        int i;
        long j2;
        long IIXOooo2;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z;
        long IIXOooo3;
        long j3;
        long IIXOooo4;
        if (ooOx()) {
            return;
        }
        do {
        } while (I0X0x0oIo() <= j);
        i = BufferedChannelKt.f29826I0Io;
        for (int i2 = 0; i2 < i; i2++) {
            long I0X0x0oIo2 = I0X0x0oIo();
            if (I0X0x0oIo2 == (f29809IIXOooo.get(this) & 4611686018427387903L) && I0X0x0oIo2 == I0X0x0oIo()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f29809IIXOooo;
        do {
            j2 = atomicLongFieldUpdater2.get(this);
            IIXOooo2 = BufferedChannelKt.IIXOooo(j2 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j2, IIXOooo2));
        while (true) {
            long I0X0x0oIo3 = I0X0x0oIo();
            atomicLongFieldUpdater = f29809IIXOooo;
            long j4 = atomicLongFieldUpdater.get(this);
            long j5 = j4 & 4611686018427387903L;
            if ((4611686018427387904L & j4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (I0X0x0oIo3 == j5 && I0X0x0oIo3 == I0X0x0oIo()) {
                break;
            } else if (!z) {
                IIXOooo3 = BufferedChannelKt.IIXOooo(j5, true);
                atomicLongFieldUpdater.compareAndSet(this, j4, IIXOooo3);
            }
        }
        do {
            j3 = atomicLongFieldUpdater.get(this);
            IIXOooo4 = BufferedChannelKt.IIXOooo(j3 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, IIXOooo4));
    }

    public final OOXIXo<E> OI0() {
        Object obj = f29811OxI.get(this);
        OOXIXo oOXIXo = (OOXIXo) f29817xoXoI.get(this);
        if (oOXIXo.f30276IXxxXO > ((OOXIXo) obj).f30276IXxxXO) {
            obj = oOXIXo;
        }
        OOXIXo oOXIXo2 = (OOXIXo) f29815o00.get(this);
        if (oOXIXo2.f30276IXxxXO > ((OOXIXo) obj).f30276IXxxXO) {
            obj = oOXIXo2;
        }
        return (OOXIXo) kotlinx.coroutines.internal.XO.oxoX((kotlinx.coroutines.internal.Oxx0IOOO) obj);
    }

    public final Object OIOoIIOIx(Object obj, Object obj2) {
        Object I0Io2;
        if (obj2 == BufferedChannelKt.O0xOxO()) {
            I0Io2 = xoIox.f29891II0xO0.oIX0oI(oX());
        } else {
            I0Io2 = xoIox.f29891II0xO0.I0Io(obj2);
        }
        return xoIox.II0xO0(I0Io2);
    }

    public final Object OIx00oxx(OOXIXo<E> oOXIXo, int i, long j, Object obj) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        x0o x0oVar6;
        x0o x0oVar7;
        x0o x0oVar8;
        x0o x0oVar9;
        x0o x0oVar10;
        x0o x0oVar11;
        x0o x0oVar12;
        x0o x0oVar13;
        x0o x0oVar14;
        x0o x0oVar15;
        x0o x0oVar16;
        while (true) {
            Object OxI2 = oOXIXo.OxI(i);
            if (OxI2 != null) {
                x0oVar5 = BufferedChannelKt.f29836Oxx0IOOO;
                if (OxI2 != x0oVar5) {
                    if (OxI2 == BufferedChannelKt.f29843XO) {
                        x0oVar6 = BufferedChannelKt.f29833OOXIXo;
                        if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar6)) {
                            XoX();
                            return oOXIXo.X0IIOO(i);
                        }
                    } else {
                        x0oVar7 = BufferedChannelKt.f29849oOoXoXO;
                        if (OxI2 == x0oVar7) {
                            x0oVar8 = BufferedChannelKt.f29834Oo;
                            return x0oVar8;
                        }
                        x0oVar9 = BufferedChannelKt.f29857xoIox;
                        if (OxI2 == x0oVar9) {
                            x0oVar10 = BufferedChannelKt.f29834Oo;
                            return x0oVar10;
                        }
                        if (OxI2 != BufferedChannelKt.O0xOxO()) {
                            x0oVar12 = BufferedChannelKt.f29859xxIXOIIO;
                            if (OxI2 != x0oVar12) {
                                x0oVar13 = BufferedChannelKt.f29827II0XooXoX;
                                if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar13)) {
                                    boolean z = OxI2 instanceof OxxIIOOXO;
                                    if (z) {
                                        OxI2 = ((OxxIIOOXO) OxI2).f29881oIX0oI;
                                    }
                                    if (oXIoO(OxI2, oOXIXo, i)) {
                                        x0oVar16 = BufferedChannelKt.f29833OOXIXo;
                                        oOXIXo.XIxXXX0x0(i, x0oVar16);
                                        XoX();
                                        return oOXIXo.X0IIOO(i);
                                    }
                                    x0oVar14 = BufferedChannelKt.f29849oOoXoXO;
                                    oOXIXo.XIxXXX0x0(i, x0oVar14);
                                    oOXIXo.O0xOxO(i, false);
                                    if (z) {
                                        XoX();
                                    }
                                    x0oVar15 = BufferedChannelKt.f29834Oo;
                                    return x0oVar15;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            XoX();
                            x0oVar11 = BufferedChannelKt.f29834Oo;
                            return x0oVar11;
                        }
                    }
                }
            }
            if (j < (f29812Oxx0xo.get(this) & BufferedChannelKt.f29829IIX0o)) {
                x0oVar = BufferedChannelKt.f29857xoIox;
                if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar)) {
                    XoX();
                    x0oVar2 = BufferedChannelKt.f29834Oo;
                    return x0oVar2;
                }
            } else {
                if (obj == null) {
                    x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                    return x0oVar3;
                }
                if (oOXIXo.oI0IIXIo(i, OxI2, obj)) {
                    XoX();
                    x0oVar4 = BufferedChannelKt.f29848oO;
                    return x0oVar4;
                }
            }
        }
    }

    public final Throwable OO() {
        Throwable oX2 = oX();
        if (oX2 == null) {
            return new ClosedReceiveChannelException(oOoXoXO.f29886oIX0oI);
        }
        return oX2;
    }

    public final boolean OO0(OOXIXo<E> oOXIXo, int i, long j) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        x0o x0oVar6;
        x0o x0oVar7;
        x0o x0oVar8;
        while (true) {
            Object OxI2 = oOXIXo.OxI(i);
            if (!(OxI2 instanceof o0IXXIx)) {
                x0oVar3 = BufferedChannelKt.f29849oOoXoXO;
                if (OxI2 == x0oVar3) {
                    return false;
                }
                if (OxI2 == null) {
                    x0oVar4 = BufferedChannelKt.f29836Oxx0IOOO;
                    if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar4)) {
                        return true;
                    }
                } else if (OxI2 != BufferedChannelKt.f29843XO) {
                    x0oVar5 = BufferedChannelKt.f29857xoIox;
                    if (OxI2 == x0oVar5) {
                        break;
                    }
                    x0oVar6 = BufferedChannelKt.f29833OOXIXo;
                    if (OxI2 == x0oVar6) {
                        break;
                    }
                    x0oVar7 = BufferedChannelKt.f29850ooOOo0oXI;
                    if (OxI2 != x0oVar7 && OxI2 != BufferedChannelKt.O0xOxO()) {
                        x0oVar8 = BufferedChannelKt.f29827II0XooXoX;
                        if (OxI2 != x0oVar8) {
                            throw new IllegalStateException(("Unexpected cell state: " + OxI2).toString());
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (j >= f29816oI0IIXIo.get(this)) {
                x0oVar = BufferedChannelKt.f29859xxIXOIIO;
                if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar)) {
                    if (!oXIoO(OxI2, oOXIXo, i)) {
                        x0oVar2 = BufferedChannelKt.f29849oOoXoXO;
                        oOXIXo.XIxXXX0x0(i, x0oVar2);
                        oOXIXo.O0xOxO(i, false);
                        return false;
                    }
                    oOXIXo.XIxXXX0x0(i, BufferedChannelKt.f29843XO);
                    return true;
                }
            } else if (oOXIXo.oI0IIXIo(i, OxI2, new OxxIIOOXO((o0IXXIx) OxI2))) {
                return true;
            }
        }
    }

    public final boolean OO0x0xX() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29815o00;
            OOXIXo<E> oOXIXo = (OOXIXo) atomicReferenceFieldUpdater.get(this);
            long IoOoo2 = IoOoo();
            if (x0xO() <= IoOoo2) {
                return false;
            }
            int i = BufferedChannelKt.f29828II0xO0;
            long j = IoOoo2 / i;
            if (oOXIXo.f30276IXxxXO != j && (oOXIXo = xo0x(j, oOXIXo)) == null) {
                if (((OOXIXo) atomicReferenceFieldUpdater.get(this)).f30276IXxxXO < j) {
                    return false;
                }
            } else {
                oOXIXo.II0xO0();
                if (XX0xXo(oOXIXo, (int) (IoOoo2 % i), IoOoo2)) {
                    return true;
                }
                f29816oI0IIXIo.compareAndSet(this, IoOoo2, IoOoo2 + 1);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public void OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        x0o x0oVar;
        x0o x0oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        x0o x0oVar3;
        x0o x0oVar4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f29814X0IIOO;
        if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater2, this, null, oooxoxo)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            x0oVar = BufferedChannelKt.f29835OxI;
            if (obj != x0oVar) {
                x0oVar2 = BufferedChannelKt.f29832O0xOxO;
                if (obj == x0oVar2) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = f29814X0IIOO;
            x0oVar3 = BufferedChannelKt.f29835OxI;
            x0oVar4 = BufferedChannelKt.f29832O0xOxO;
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x0oVar3, x0oVar4));
        oooxoxo.invoke(oX());
    }

    public final boolean OOXIxO0(long j) {
        return o0xxxXXxX(j, false);
    }

    public final boolean OX(Object obj, E e) {
        boolean xXxxox0I2;
        boolean xXxxox0I3;
        if (obj instanceof kotlinx.coroutines.selects.xoIox) {
            return ((kotlinx.coroutines.selects.xoIox) obj).xxIXOIIO(this, e);
        }
        Oox.oOoXoXO<Throwable, oXIO0o0XI> oooxoxo = null;
        if (obj instanceof Oxx0xo) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            Oxx0xo oxx0xo = (Oxx0xo) obj;
            kotlinx.coroutines.x0xO0oo<xoIox<? extends E>> x0xo0oo = oxx0xo.f29880XO;
            xoIox II0xO02 = xoIox.II0xO0(xoIox.f29891II0xO0.I0Io(e));
            Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo2 = this.f29819Oo;
            if (oooxoxo2 != null) {
                oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo2, e, oxx0xo.f29880XO.getContext());
            }
            xXxxox0I3 = BufferedChannelKt.xXxxox0I(x0xo0oo, II0xO02, oooxoxo);
            return xXxxox0I3;
        }
        if (obj instanceof oIX0oI) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((oIX0oI) obj).OOXIXo(e);
        }
        if (obj instanceof kotlinx.coroutines.oO) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.oO oOVar = (kotlinx.coroutines.oO) obj;
            Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo3 = this.f29819Oo;
            if (oooxoxo3 != null) {
                oooxoxo = OnUndeliveredElementKt.oIX0oI(oooxoxo3, e, oOVar.getContext());
            }
            xXxxox0I2 = BufferedChannelKt.xXxxox0I(oOVar, e, oooxoxo);
            return xXxxox0I2;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final Object OoO(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.O0xOxO()) {
            return obj2;
        }
        throw OO();
    }

    public final Object OooI(OOXIXo<E> oOXIXo, int i, long j, Object obj) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        Object OxI2 = oOXIXo.OxI(i);
        if (OxI2 == null) {
            if (j >= (f29812Oxx0xo.get(this) & BufferedChannelKt.f29829IIX0o)) {
                if (obj == null) {
                    x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                    return x0oVar3;
                }
                if (oOXIXo.oI0IIXIo(i, OxI2, obj)) {
                    XoX();
                    x0oVar2 = BufferedChannelKt.f29848oO;
                    return x0oVar2;
                }
            }
        } else if (OxI2 == BufferedChannelKt.f29843XO) {
            x0oVar = BufferedChannelKt.f29833OOXIXo;
            if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar)) {
                XoX();
                return oOXIXo.X0IIOO(i);
            }
        }
        return OIx00oxx(oOXIXo, i, j, obj);
    }

    public final void Ox0O(kotlinx.coroutines.selects.xoIox<?> xoiox) {
        xoiox.XO(BufferedChannelKt.O0xOxO());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final String Oxx() {
        String str;
        String str2;
        String valueOf;
        OOXIXo oOXIXo;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S=");
        sb2.append(x0xO());
        sb2.append(",R=");
        sb2.append(IoOoo());
        sb2.append(",B=");
        sb2.append(I0X0x0oIo());
        sb2.append(",B'=");
        sb2.append(f29809IIXOooo.get(this));
        sb2.append(",C=");
        AtomicLongFieldUpdater atomicLongFieldUpdater = f29812Oxx0xo;
        sb2.append((int) (atomicLongFieldUpdater.get(this) >> 60));
        sb2.append(',');
        sb.append(sb2.toString());
        int i = (int) (atomicLongFieldUpdater.get(this) >> 60);
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    sb.append("CANCELLED,");
                }
            } else {
                sb.append("CLOSED,");
            }
        } else {
            sb.append("CANCELLATION_STARTED,");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("SEND_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29817xoXoI;
        sb3.append(OI0.II0xO0(atomicReferenceFieldUpdater.get(this)));
        sb3.append(",RCV_SEGM=");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f29815o00;
        sb3.append(OI0.II0xO0(atomicReferenceFieldUpdater2.get(this)));
        sb.append(sb3.toString());
        if (!ooOx()) {
            sb.append(",EB_SEGM=" + OI0.II0xO0(f29811OxI.get(this)));
        }
        sb.append("  ");
        List X00IoxXI2 = CollectionsKt__CollectionsKt.X00IoxXI(atomicReferenceFieldUpdater2.get(this), atomicReferenceFieldUpdater.get(this), f29811OxI.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : X00IoxXI2) {
            OOXIXo oOXIXo2 = (OOXIXo) obj;
            oOXIXo = BufferedChannelKt.f29847oIX0oI;
            if (oOXIXo2 != oOXIXo) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long j = ((OOXIXo) next).f30276IXxxXO;
                do {
                    Object next2 = it.next();
                    long j2 = ((OOXIXo) next2).f30276IXxxXO;
                    if (j > j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
            OOXIXo oOXIXo3 = (OOXIXo) next;
            do {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(OI0.II0xO0(oOXIXo3));
                sb4.append("=[");
                if (oOXIXo3.II0XooXoX()) {
                    str = "*";
                } else {
                    str = "";
                }
                sb4.append(str);
                sb4.append(oOXIXo3.f30276IXxxXO);
                sb4.append(",prev=");
                OOXIXo oOXIXo4 = (OOXIXo) oOXIXo3.Oxx0IOOO();
                String str3 = null;
                if (oOXIXo4 != null) {
                    str2 = OI0.II0xO0(oOXIXo4);
                } else {
                    str2 = null;
                }
                sb4.append(str2);
                sb4.append(',');
                sb.append(sb4.toString());
                int i2 = BufferedChannelKt.f29828II0xO0;
                for (int i3 = 0; i3 < i2; i3++) {
                    Object OxI2 = oOXIXo3.OxI(i3);
                    Object o002 = oOXIXo3.o00(i3);
                    if (OxI2 instanceof kotlinx.coroutines.oO) {
                        valueOf = "cont";
                    } else if (OxI2 instanceof kotlinx.coroutines.selects.xoIox) {
                        valueOf = "select";
                    } else if (OxI2 instanceof Oxx0xo) {
                        valueOf = "receiveCatching";
                    } else if (OxI2 instanceof II0xO0) {
                        valueOf = "send(broadcast)";
                    } else if (OxI2 instanceof OxxIIOOXO) {
                        valueOf = "EB(" + OxI2 + HexStringBuilder.COMMENT_END_CHAR;
                    } else {
                        valueOf = String.valueOf(OxI2);
                    }
                    sb.append('[' + i3 + "]=(" + valueOf + ',' + o002 + "),");
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("next=");
                OOXIXo oOXIXo5 = (OOXIXo) oOXIXo3.X0o0xo();
                if (oOXIXo5 != null) {
                    str3 = OI0.II0xO0(oOXIXo5);
                }
                sb5.append(str3);
                sb5.append("]  ");
                sb.append(sb5.toString());
                oOXIXo3 = (OOXIXo) oOXIXo3.X0o0xo();
            } while (oOXIXo3 != null);
            return sb.toString();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.X0o0xo<xoIox<E>> Oxx0xo() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Oox.IXxxXO iXxxXO = (Oox.IXxxXO) XoX.Oo(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.XO(this, iXxxXO, (Oox.IXxxXO) XoX.Oo(bufferedChannel$onReceiveCatching$2, 3), this.f29818IXxxXO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X00IoxXI(OOXIXo<E> oOXIXo, long j) {
        x0o x0oVar;
        Object I0Io2 = kotlinx.coroutines.internal.x0xO0oo.I0Io(null, 1, null);
        loop0: while (oOXIXo != null) {
            for (int i = BufferedChannelKt.f29828II0xO0 - 1; -1 < i; i--) {
                if ((oOXIXo.f30276IXxxXO * BufferedChannelKt.f29828II0xO0) + i < j) {
                    break loop0;
                }
                while (true) {
                    Object OxI2 = oOXIXo.OxI(i);
                    if (OxI2 != null) {
                        x0oVar = BufferedChannelKt.f29836Oxx0IOOO;
                        if (OxI2 != x0oVar) {
                            if (OxI2 instanceof OxxIIOOXO) {
                                if (oOXIXo.oI0IIXIo(i, OxI2, BufferedChannelKt.O0xOxO())) {
                                    I0Io2 = kotlinx.coroutines.internal.x0xO0oo.II0XooXoX(I0Io2, ((OxxIIOOXO) OxI2).f29881oIX0oI);
                                    oOXIXo.O0xOxO(i, true);
                                    break;
                                }
                            } else {
                                if (!(OxI2 instanceof o0IXXIx)) {
                                    break;
                                }
                                if (oOXIXo.oI0IIXIo(i, OxI2, BufferedChannelKt.O0xOxO())) {
                                    I0Io2 = kotlinx.coroutines.internal.x0xO0oo.II0XooXoX(I0Io2, OxI2);
                                    oOXIXo.O0xOxO(i, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (oOXIXo.oI0IIXIo(i, OxI2, BufferedChannelKt.O0xOxO())) {
                        oOXIXo.IXxxXO();
                        break;
                    }
                }
            }
            oOXIXo = (OOXIXo) oOXIXo.Oxx0IOOO();
        }
        if (I0Io2 != null) {
            if (!(I0Io2 instanceof ArrayList)) {
                x0((o0IXXIx) I0Io2);
                return;
            }
            IIX0o.x0XOIxOo(I0Io2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) I0Io2;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                x0((o0IXXIx) arrayList.get(size));
            }
        }
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public boolean X0IIOO() {
        return OOXIxO0(f29812Oxx0xo.get(this));
    }

    public final void X0xII0I(o0IXXIx o0ixxix) {
        X0xxXX0(o0ixxix, false);
    }

    public final void X0xxXX0(o0IXXIx o0ixxix, boolean z) {
        Throwable xoIxX2;
        if (o0ixxix instanceof II0xO0) {
            kotlinx.coroutines.oO<Boolean> oIX0oI2 = ((II0xO0) o0ixxix).oIX0oI();
            Result.oIX0oI oix0oi = Result.Companion;
            oIX0oI2.resumeWith(Result.m287constructorimpl(Boolean.FALSE));
            return;
        }
        if (o0ixxix instanceof kotlinx.coroutines.oO) {
            kotlin.coroutines.I0Io i0Io = (kotlin.coroutines.I0Io) o0ixxix;
            Result.oIX0oI oix0oi2 = Result.Companion;
            if (z) {
                xoIxX2 = OO();
            } else {
                xoIxX2 = xoIxX();
            }
            i0Io.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(xoIxX2)));
            return;
        }
        if (o0ixxix instanceof Oxx0xo) {
            kotlinx.coroutines.x0xO0oo<xoIox<? extends E>> x0xo0oo = ((Oxx0xo) o0ixxix).f29880XO;
            Result.oIX0oI oix0oi3 = Result.Companion;
            x0xo0oo.resumeWith(Result.m287constructorimpl(xoIox.II0xO0(xoIox.f29891II0xO0.oIX0oI(oX()))));
        } else if (o0ixxix instanceof oIX0oI) {
            ((oIX0oI) o0ixxix).oOoXoXO();
        } else {
            if (o0ixxix instanceof kotlinx.coroutines.selects.xoIox) {
                ((kotlinx.coroutines.selects.xoIox) o0ixxix).xxIXOIIO(this, BufferedChannelKt.O0xOxO());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + o0ixxix).toString());
        }
    }

    public final <R> R XI(E e, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi, @OXOo.OOXIXo Oox.x0xO0oo<? super OOXIXo<E>, ? super Integer, ? extends R> x0xo0oo, @OXOo.OOXIXo Oox.oIX0oI<? extends R> oix0oi2, @OXOo.OOXIXo Oox.Oxx0xo<? super OOXIXo<E>, ? super Integer, ? super E, ? super Long, ? extends R> oxx0xo) {
        OOXIXo oOXIXo;
        o0IXXIx o0ixxix;
        OOXIXo oOXIXo2 = (OOXIXo) f29817xoXoI.get(this);
        while (true) {
            long andIncrement = f29812Oxx0xo.getAndIncrement(this);
            long j = andIncrement & BufferedChannelKt.f29829IIX0o;
            boolean OOXIxO02 = OOXIxO0(andIncrement);
            int i = BufferedChannelKt.f29828II0xO0;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (oOXIXo2.f30276IXxxXO != j2) {
                OOXIXo xXOx2 = xXOx(j2, oOXIXo2);
                if (xXOx2 == null) {
                    if (OOXIxO02) {
                        return oix0oi2.invoke();
                    }
                } else {
                    oOXIXo = xXOx2;
                }
            } else {
                oOXIXo = oOXIXo2;
            }
            int xIXX2 = xIXX(oOXIXo, i2, e, j, obj, OOXIxO02);
            if (xIXX2 != 0) {
                if (xIXX2 != 1) {
                    if (xIXX2 != 2) {
                        if (xIXX2 != 3) {
                            if (xIXX2 != 4) {
                                if (xIXX2 == 5) {
                                    oOXIXo.II0xO0();
                                }
                                oOXIXo2 = oOXIXo;
                            } else {
                                if (j < IoOoo()) {
                                    oOXIXo.II0xO0();
                                }
                                return oix0oi2.invoke();
                            }
                        } else {
                            return oxx0xo.invoke(oOXIXo, Integer.valueOf(i2), e, Long.valueOf(j));
                        }
                    } else {
                        if (OOXIxO02) {
                            oOXIXo.IXxxXO();
                            return oix0oi2.invoke();
                        }
                        if (obj instanceof o0IXXIx) {
                            o0ixxix = (o0IXXIx) obj;
                        } else {
                            o0ixxix = null;
                        }
                        if (o0ixxix != null) {
                            XIXIxO(o0ixxix, oOXIXo, i2);
                        }
                        return x0xo0oo.invoke(oOXIXo, Integer.valueOf(i2));
                    }
                } else {
                    return oix0oi.invoke();
                }
            } else {
                oOXIXo.II0xO0();
                return oix0oi.invoke();
            }
        }
    }

    public final void XIXIX() {
        long j;
        long xoXoI2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f29812Oxx0xo;
        do {
            j = atomicLongFieldUpdater.get(this);
            xoXoI2 = BufferedChannelKt.xoXoI(BufferedChannelKt.f29829IIX0o & j, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, xoXoI2));
    }

    public final void XIXIxO(o0IXXIx o0ixxix, OOXIXo<E> oOXIXo, int i) {
        o0ixxix.II0xO0(oOXIXo, i + BufferedChannelKt.f29828II0xO0);
    }

    public final void XIo0oOXIx(long j) {
        if ((f29809IIXOooo.addAndGet(this, j) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((f29809IIXOooo.get(this) & 4611686018427387904L) != 0);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.oOoXoXO
    public Object XOxIOxOx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return IO0XoXxO(this, e, i0Io);
    }

    public final OOXIXo<E> XX(long j) {
        OOXIXo<E> OI02 = OI0();
        if (IIxOXoOo0()) {
            long xX0IIXIx02 = xX0IIXIx0(OI02);
            if (xX0IIXIx02 != -1) {
                oxxXoxO(xX0IIXIx02);
            }
        }
        X00IoxXI(OI02, j);
        return OI02;
    }

    public final Object XX0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, ? extends Object> oooxoxo, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, obj, obj2, oooxoxo.invoke(obj2)));
        return obj2;
    }

    public final boolean XX0xXo(OOXIXo<E> oOXIXo, int i, long j) {
        Object OxI2;
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        x0o x0oVar6;
        x0o x0oVar7;
        do {
            OxI2 = oOXIXo.OxI(i);
            if (OxI2 != null) {
                x0oVar2 = BufferedChannelKt.f29836Oxx0IOOO;
                if (OxI2 != x0oVar2) {
                    if (OxI2 != BufferedChannelKt.f29843XO) {
                        x0oVar3 = BufferedChannelKt.f29849oOoXoXO;
                        if (OxI2 != x0oVar3 && OxI2 != BufferedChannelKt.O0xOxO()) {
                            x0oVar4 = BufferedChannelKt.f29833OOXIXo;
                            if (OxI2 != x0oVar4) {
                                x0oVar5 = BufferedChannelKt.f29857xoIox;
                                if (OxI2 != x0oVar5) {
                                    x0oVar6 = BufferedChannelKt.f29859xxIXOIIO;
                                    if (OxI2 != x0oVar6) {
                                        x0oVar7 = BufferedChannelKt.f29827II0XooXoX;
                                        if (OxI2 == x0oVar7 || j != IoOoo()) {
                                            return false;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return true;
                }
            }
            x0oVar = BufferedChannelKt.f29857xoIox;
        } while (!oOXIXo.oI0IIXIo(i, OxI2, x0oVar));
        XoX();
        return false;
    }

    public final boolean XXXI(long j) {
        if (OOXIxO0(j)) {
            return false;
        }
        return !IoOoX(j & BufferedChannelKt.f29829IIX0o);
    }

    public final Object XXoOx0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.O0xOxO()) {
            return this;
        }
        throw xoIxX();
    }

    public final boolean XoIxOXIXo(OOXIXo<E> oOXIXo, int i, long j) {
        x0o x0oVar;
        x0o x0oVar2;
        Object OxI2 = oOXIXo.OxI(i);
        if ((OxI2 instanceof o0IXXIx) && j >= f29816oI0IIXIo.get(this)) {
            x0oVar = BufferedChannelKt.f29859xxIXOIIO;
            if (oOXIXo.oI0IIXIo(i, OxI2, x0oVar)) {
                if (!oXIoO(OxI2, oOXIXo, i)) {
                    x0oVar2 = BufferedChannelKt.f29849oOoXoXO;
                    oOXIXo.XIxXXX0x0(i, x0oVar2);
                    oOXIXo.O0xOxO(i, false);
                    return false;
                }
                oOXIXo.XIxXXX0x0(i, BufferedChannelKt.f29843XO);
                return true;
            }
        }
        return OO0(oOXIXo, i, j);
    }

    public final void XoX() {
        if (ooOx()) {
            return;
        }
        OOXIXo<E> oOXIXo = (OOXIXo) f29811OxI.get(this);
        while (true) {
            long andIncrement = f29813OxxIIOOXO.getAndIncrement(this);
            int i = BufferedChannelKt.f29828II0xO0;
            long j = andIncrement / i;
            if (x0xO() <= andIncrement) {
                if (oOXIXo.f30276IXxxXO < j && oOXIXo.X0o0xo() != 0) {
                    oOo(j, oOXIXo);
                }
                Ioxxx(this, 0L, 1, null);
                return;
            }
            if (oOXIXo.f30276IXxxXO != j) {
                OOXIXo<E> oxXx0IX2 = oxXx0IX(j, oOXIXo, andIncrement);
                if (oxXx0IX2 == null) {
                    continue;
                } else {
                    oOXIXo = oxXx0IX2;
                }
            }
            if (XoIxOXIXo(oOXIXo, (int) (andIncrement % i), andIncrement)) {
                Ioxxx(this, 0L, 1, null);
                return;
            }
            Ioxxx(this, 0L, 1, null);
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.X0o0xo<E> Xx000oIo() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Oox.IXxxXO iXxxXO = (Oox.IXxxXO) XoX.Oo(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.XO(this, iXxxXO, (Oox.IXxxXO) XoX.Oo(bufferedChannel$onReceive$2, 3), this.f29818IXxxXO);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean XxX0x0xxx() {
        return ox(f29812Oxx0xo.get(this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        oOXoIIIo(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (XxX0x0xxx() || OO0x0xX()) {
            return false;
        }
        return !XxX0x0xxx();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.OOXIXo
    public ChannelIterator<E> iterator() {
        return new oIX0oI();
    }

    public final void o0(long j) {
        x0OxxIOxX(XX(j));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.oOoXoXO
    public Object o00(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super xoIox<? extends E>> i0Io) {
        return oOoIIO0(this, i0Io);
    }

    public final void o0IXXIx(AtomicLongFieldUpdater atomicLongFieldUpdater, Oox.oOoXoXO<? super Long, Long> oooxoxo, Object obj) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, oooxoxo.invoke(Long.valueOf(j)).longValue()));
    }

    public final void o0oIxOo(o0IXXIx o0ixxix, OOXIXo<E> oOXIXo, int i) {
        oxIIX0o();
        o0ixxix.II0xO0(oOXIXo, i);
    }

    public final boolean o0xxxXXxX(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i != 2) {
            if (i == 3) {
                o0(j & BufferedChannelKt.f29829IIX0o);
            } else {
                throw new IllegalStateException(("unexpected close status: " + i).toString());
            }
        } else {
            XX(j & BufferedChannelKt.f29829IIX0o);
            if (z && OO0x0xX()) {
                return false;
            }
        }
        return true;
    }

    public final <R> R oI(Object obj, Oox.oOoXoXO<? super E, ? extends R> oooxoxo, Oox.IXxxXO<? super OOXIXo<E>, ? super Integer, ? super Long, ? extends R> iXxxXO, Oox.oIX0oI<? extends R> oix0oi, Oox.IXxxXO<? super OOXIXo<E>, ? super Integer, ? super Long, ? extends R> iXxxXO2) {
        x0o x0oVar;
        o0IXXIx o0ixxix;
        x0o x0oVar2;
        x0o x0oVar3;
        OOXIXo oOXIXo = (OOXIXo) f29815o00.get(this);
        while (!XxX0x0xxx()) {
            long andIncrement = f29816oI0IIXIo.getAndIncrement(this);
            int i = BufferedChannelKt.f29828II0xO0;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (oOXIXo.f30276IXxxXO != j) {
                OOXIXo xo0x2 = xo0x(j, oOXIXo);
                if (xo0x2 == null) {
                    continue;
                } else {
                    oOXIXo = xo0x2;
                }
            }
            x0o x0oVar4 = (Object) OooI(oOXIXo, i2, andIncrement, obj);
            x0oVar = BufferedChannelKt.f29848oO;
            if (x0oVar4 != x0oVar) {
                x0oVar2 = BufferedChannelKt.f29834Oo;
                if (x0oVar4 != x0oVar2) {
                    x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                    if (x0oVar4 == x0oVar3) {
                        return iXxxXO2.invoke(oOXIXo, Integer.valueOf(i2), Long.valueOf(andIncrement));
                    }
                    oOXIXo.II0xO0();
                    return oooxoxo.invoke(x0oVar4);
                }
                if (andIncrement < x0xO()) {
                    oOXIXo.II0xO0();
                }
            } else {
                if (obj instanceof o0IXXIx) {
                    o0ixxix = (o0IXXIx) obj;
                } else {
                    o0ixxix = null;
                }
                if (o0ixxix != null) {
                    o0oIxOo(o0ixxix, oOXIXo, i2);
                }
                return iXxxXO.invoke(oOXIXo, Integer.valueOf(i2), Long.valueOf(andIncrement));
            }
        }
        return oix0oi.invoke();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.X0o0xo<E> oI0IIXIo() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Oox.IXxxXO iXxxXO = (Oox.IXxxXO) XoX.Oo(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.XO(this, iXxxXO, (Oox.IXxxXO) XoX.Oo(bufferedChannel$onReceiveOrNull$2, 3), this.f29818IXxxXO);
    }

    public final void oIIxXoo(OOXIXo<E> oOXIXo, int i, E e, long j, o0IXXIx o0ixxix, Oox.oIX0oI<oXIO0o0XI> oix0oi, Oox.oIX0oI<oXIO0o0XI> oix0oi2) {
        OOXIXo oOXIXo2;
        o0IXXIx o0ixxix2 = o0ixxix;
        int xIXX2 = xIXX(oOXIXo, i, e, j, o0ixxix, false);
        if (xIXX2 != 0) {
            if (xIXX2 != 1) {
                if (xIXX2 == 2) {
                    XIXIxO(o0ixxix2, oOXIXo, i);
                    return;
                }
                if (xIXX2 != 4) {
                    if (xIXX2 == 5) {
                        oOXIXo.II0xO0();
                        OOXIXo oOXIXo3 = (OOXIXo) f29817xoXoI.get(this);
                        while (true) {
                            long andIncrement = f29812Oxx0xo.getAndIncrement(this);
                            long j2 = andIncrement & BufferedChannelKt.f29829IIX0o;
                            boolean OOXIxO02 = OOXIxO0(andIncrement);
                            int i2 = BufferedChannelKt.f29828II0xO0;
                            long j3 = j2 / i2;
                            int i3 = (int) (j2 % i2);
                            if (oOXIXo3.f30276IXxxXO != j3) {
                                OOXIXo xXOx2 = xXOx(j3, oOXIXo3);
                                if (xXOx2 == null) {
                                    if (OOXIxO02) {
                                        oix0oi2.invoke();
                                        return;
                                    }
                                } else {
                                    oOXIXo2 = xXOx2;
                                }
                            } else {
                                oOXIXo2 = oOXIXo3;
                            }
                            OOXIXo oOXIXo4 = oOXIXo2;
                            int xIXX3 = xIXX(oOXIXo2, i3, e, j2, o0ixxix, OOXIxO02);
                            if (xIXX3 != 0) {
                                if (xIXX3 != 1) {
                                    if (xIXX3 != 2) {
                                        if (xIXX3 != 3) {
                                            if (xIXX3 != 4) {
                                                if (xIXX3 == 5) {
                                                    oOXIXo4.II0xO0();
                                                }
                                                oOXIXo3 = oOXIXo4;
                                            } else {
                                                if (j2 < IoOoo()) {
                                                    oOXIXo4.II0xO0();
                                                }
                                                oix0oi2.invoke();
                                                return;
                                            }
                                        } else {
                                            throw new IllegalStateException("unexpected");
                                        }
                                    } else {
                                        if (OOXIxO02) {
                                            oOXIXo4.IXxxXO();
                                            oix0oi2.invoke();
                                            return;
                                        }
                                        if (!(o0ixxix2 instanceof o0IXXIx)) {
                                            o0ixxix2 = null;
                                        }
                                        if (o0ixxix2 != null) {
                                            XIXIxO(o0ixxix2, oOXIXo4, i3);
                                        }
                                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                                        return;
                                    }
                                } else {
                                    oix0oi.invoke();
                                    return;
                                }
                            } else {
                                oOXIXo4.II0xO0();
                                oix0oi.invoke();
                                return;
                            }
                        }
                    } else {
                        throw new IllegalStateException("unexpected");
                    }
                } else {
                    if (j < IoOoo()) {
                        oOXIXo.II0xO0();
                    }
                    oix0oi2.invoke();
                }
            } else {
                oix0oi.invoke();
            }
        } else {
            oOXIXo.II0xO0();
            oix0oi.invoke();
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean oIX0oI(@OXOo.oOoXoXO Throwable th) {
        return oOXoIIIo(th);
    }

    public boolean oOXoIIIo(@OXOo.oOoXoXO Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return Io(th, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void oOo(long r6, kotlinx.coroutines.channels.OOXIXo<E> r8) {
        /*
            r5 = this;
        L0:
            long r0 = r8.f30276IXxxXO
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L11
            kotlinx.coroutines.internal.Oxx0IOOO r0 = r8.X0o0xo()
            kotlinx.coroutines.channels.OOXIXo r0 = (kotlinx.coroutines.channels.OOXIXo) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r8 = r0
            goto L0
        L11:
            boolean r6 = r8.II0XooXoX()
            if (r6 == 0) goto L22
            kotlinx.coroutines.internal.Oxx0IOOO r6 = r8.X0o0xo()
            kotlinx.coroutines.channels.OOXIXo r6 = (kotlinx.coroutines.channels.OOXIXo) r6
            if (r6 != 0) goto L20
            goto L22
        L20:
            r8 = r6
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.channels.BufferedChannel.f29811OxI
        L24:
            java.lang.Object r7 = r6.get(r5)
            kotlinx.coroutines.internal.X00IoxXI r7 = (kotlinx.coroutines.internal.X00IoxXI) r7
            long r0 = r7.f30276IXxxXO
            long r2 = r8.f30276IXxxXO
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r8.Oxx0xo()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = androidx.concurrent.futures.oIX0oI.oIX0oI(r6, r5, r7, r8)
            if (r0 == 0) goto L4a
            boolean r6 = r7.oO()
            if (r6 == 0) goto L49
            r7.oOoXoXO()
        L49:
            return
        L4a:
            boolean r7 = r8.oO()
            if (r7 == 0) goto L24
            r8.oOoXoXO()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.oOo(long, kotlinx.coroutines.channels.OOXIXo):void");
    }

    @OXOo.oOoXoXO
    public final Throwable oX() {
        return (Throwable) f29810O0xOxO.get(this);
    }

    public final void oXIO0o0XI() {
        long j;
        long xoXoI2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f29812Oxx0xo;
        do {
            j = atomicLongFieldUpdater.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                xoXoI2 = BufferedChannelKt.xoXoI(j & BufferedChannelKt.f29829IIX0o, 2);
            } else if (i == 1) {
                xoXoI2 = BufferedChannelKt.xoXoI(j & BufferedChannelKt.f29829IIX0o, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, xoXoI2));
    }

    public final boolean oXIoO(Object obj, OOXIXo<E> oOXIXo, int i) {
        if (obj instanceof kotlinx.coroutines.oO) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.IIX0o((kotlinx.coroutines.oO) obj, oXIO0o0XI.f29392oIX0oI, null, 2, null);
        }
        if (obj instanceof kotlinx.coroutines.selects.xoIox) {
            IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult oo0xXOI0I2 = ((SelectImplementation) obj).oo0xXOI0I(this, oXIO0o0XI.f29392oIX0oI);
            if (oo0xXOI0I2 == TrySelectDetailedResult.REREGISTER) {
                oOXIXo.OxxIIOOXO(i);
            }
            if (oo0xXOI0I2 == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        }
        if (obj instanceof II0xO0) {
            return BufferedChannelKt.IIX0o(((II0xO0) obj).oIX0oI(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object oXX0IoI(kotlinx.coroutines.channels.OOXIXo<E> r21, int r22, E r23, long r24, kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> r26) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.oXX0IoI(kotlinx.coroutines.channels.OOXIXo, int, java.lang.Object, long, kotlin.coroutines.I0Io):java.lang.Object");
    }

    @OXOo.oOoXoXO
    public Object oXxOI0oIx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Boolean> i0Io) {
        return XOxxooXI(this, e, i0Io);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.XX(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Oxx0IOOO.oIX0oI.I0Io(this, e);
    }

    public final boolean ooOx() {
        long I0X0x0oIo2 = I0X0x0oIo();
        if (I0X0x0oIo2 != 0 && I0X0x0oIo2 != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean ox(long j) {
        return o0xxxXXxX(j, true);
    }

    public void oxIIX0o() {
    }

    public final OOXIXo<E> oxXx0IX(long j, OOXIXo<E> oOXIXo, long j2) {
        Object Oxx0IOOO2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29811OxI;
        Oox.x0xO0oo x0xo0oo = (Oox.x0xO0oo) BufferedChannelKt.OxI();
        loop0: while (true) {
            Oxx0IOOO2 = kotlinx.coroutines.internal.XO.Oxx0IOOO(oOXIXo, j, x0xo0oo);
            if (!IO.II0XooXoX(Oxx0IOOO2)) {
                X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
                while (true) {
                    X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(this);
                    if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                        break loop0;
                    }
                    if (!XO2.Oxx0xo()) {
                        break;
                    }
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x00IoxXI, XO2)) {
                        if (x00IoxXI.oO()) {
                            x00IoxXI.oOoXoXO();
                        }
                    } else if (XO2.oO()) {
                        XO2.oOoXoXO();
                    }
                }
            } else {
                break;
            }
        }
        if (IO.II0XooXoX(Oxx0IOOO2)) {
            I0oOoX();
            oOo(j, oOXIXo);
            Ioxxx(this, 0L, 1, null);
            return null;
        }
        OOXIXo<E> oOXIXo2 = (OOXIXo) IO.XO(Oxx0IOOO2);
        long j3 = oOXIXo2.f30276IXxxXO;
        if (j3 > j) {
            int i = BufferedChannelKt.f29828II0xO0;
            if (f29813OxxIIOOXO.compareAndSet(this, j2 + 1, i * j3)) {
                XIo0oOXIx((oOXIXo2.f30276IXxxXO * i) - j2);
                return null;
            }
            Ioxxx(this, 0L, 1, null);
            return null;
        }
        return oOXIXo2;
    }

    public final void oxxXoxO(long j) {
        x0o x0oVar;
        UndeliveredElementException oxoX2;
        OOXIXo<E> oOXIXo = (OOXIXo) f29815o00.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f29816oI0IIXIo;
            long j2 = atomicLongFieldUpdater.get(this);
            if (j < Math.max(this.f29820XO + j2, I0X0x0oIo())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j2, j2 + 1)) {
                int i = BufferedChannelKt.f29828II0xO0;
                long j3 = j2 / i;
                int i2 = (int) (j2 % i);
                if (oOXIXo.f30276IXxxXO != j3) {
                    OOXIXo<E> xo0x2 = xo0x(j3, oOXIXo);
                    if (xo0x2 == null) {
                        continue;
                    } else {
                        oOXIXo = xo0x2;
                    }
                }
                Object OooI2 = OooI(oOXIXo, i2, j2, null);
                x0oVar = BufferedChannelKt.f29834Oo;
                if (OooI2 == x0oVar) {
                    if (j2 < x0xO()) {
                        oOXIXo.II0xO0();
                    }
                } else {
                    oOXIXo.II0xO0();
                    Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo = this.f29819Oo;
                    if (oooxoxo != null && (oxoX2 = OnUndeliveredElementKt.oxoX(oooxoxo, OooI2, null, 2, null)) != null) {
                        throw oxoX2;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @kotlin.XX(expression = "tryReceive().getOrNull()", imports = {}))
    @OXOo.oOoXoXO
    public E poll() {
        return (E) Oxx0IOOO.oIX0oI.oxoX(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01dd, code lost:
    
        r3 = (kotlinx.coroutines.channels.OOXIXo) r3.X0o0xo();
     */
    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public final void x0(o0IXXIx o0ixxix) {
        X0xxXX0(o0ixxix, true);
    }

    public final Object x0OIX00oO(Object obj, Object obj2) {
        if (obj2 == BufferedChannelKt.O0xOxO()) {
            if (oX() == null) {
                return null;
            }
            throw OO();
        }
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b4, code lost:
    
        r13 = (kotlinx.coroutines.channels.OOXIXo) r13.Oxx0IOOO();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0OxxIOxX(kotlinx.coroutines.channels.OOXIXo<E> r13) {
        /*
            r12 = this;
            Oox.oOoXoXO<E, kotlin.oXIO0o0XI> r0 = r12.f29819Oo
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.x0xO0oo.I0Io(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb4
            long r6 = r13.f30276IXxxXO
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L17:
            java.lang.Object r8 = r13.OxI(r4)
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.XO()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.f29843XO
            if (r8 != r9) goto L49
            long r9 = r12.IoOoo()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.O0xOxO()
            boolean r8 = r13.oI0IIXIo(r4, r8, r9)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L41
            java.lang.Object r5 = r13.o00(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.I0Io(r0, r5, r1)
        L41:
            r13.OxxIIOOXO(r4)
            r13.IXxxXO()
            goto Lb0
        L49:
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.OOXIXo()
            if (r8 == r9) goto La3
            if (r8 != 0) goto L52
            goto La3
        L52:
            boolean r9 = r8 instanceof kotlinx.coroutines.o0IXXIx
            if (r9 != 0) goto L6f
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.OxxIIOOXO
            if (r9 == 0) goto L5b
            goto L6f
        L5b:
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.x0xO0oo()
            if (r8 == r9) goto Lbc
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.Oo()
            if (r8 != r9) goto L68
            goto Lbc
        L68:
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.x0xO0oo()
            if (r8 == r9) goto L17
            goto Lb0
        L6f:
            long r9 = r12.IoOoo()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto Lbc
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.OxxIIOOXO
            if (r9 == 0) goto L81
            r9 = r8
            kotlinx.coroutines.channels.OxxIIOOXO r9 = (kotlinx.coroutines.channels.OxxIIOOXO) r9
            kotlinx.coroutines.o0IXXIx r9 = r9.f29881oIX0oI
            goto L84
        L81:
            r9 = r8
            kotlinx.coroutines.o0IXXIx r9 = (kotlinx.coroutines.o0IXXIx) r9
        L84:
            kotlinx.coroutines.internal.x0o r10 = kotlinx.coroutines.channels.BufferedChannelKt.O0xOxO()
            boolean r8 = r13.oI0IIXIo(r4, r8, r10)
            if (r8 == 0) goto L17
            if (r0 == 0) goto L98
            java.lang.Object r5 = r13.o00(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.I0Io(r0, r5, r1)
        L98:
            java.lang.Object r3 = kotlinx.coroutines.internal.x0xO0oo.II0XooXoX(r3, r9)
            r13.OxxIIOOXO(r4)
            r13.IXxxXO()
            goto Lb0
        La3:
            kotlinx.coroutines.internal.x0o r9 = kotlinx.coroutines.channels.BufferedChannelKt.O0xOxO()
            boolean r8 = r13.oI0IIXIo(r4, r8, r9)
            if (r8 == 0) goto L17
            r13.IXxxXO()
        Lb0:
            int r4 = r4 + (-1)
            goto Lb
        Lb4:
            kotlinx.coroutines.internal.Oxx0IOOO r13 = r13.Oxx0IOOO()
            kotlinx.coroutines.channels.OOXIXo r13 = (kotlinx.coroutines.channels.OOXIXo) r13
            if (r13 != 0) goto L8
        Lbc:
            if (r3 == 0) goto Le2
            boolean r13 = r3 instanceof java.util.ArrayList
            if (r13 != 0) goto Lc8
            kotlinx.coroutines.o0IXXIx r3 = (kotlinx.coroutines.o0IXXIx) r3
            r12.X0xII0I(r3)
            goto Le2
        Lc8:
            java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r3, r13)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r13 = r3.size()
            int r13 = r13 - r2
        Ld4:
            if (r5 >= r13) goto Le2
            java.lang.Object r0 = r3.get(r13)
            kotlinx.coroutines.o0IXXIx r0 = (kotlinx.coroutines.o0IXXIx) r0
            r12.X0xII0I(r0)
            int r13 = r13 + (-1)
            goto Ld4
        Le2:
            if (r1 != 0) goto Le5
            return
        Le5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.x0OxxIOxX(kotlinx.coroutines.channels.OOXIXo):void");
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public boolean x0o(@OXOo.oOoXoXO Throwable th) {
        return Io(th, false);
    }

    public final long x0xO() {
        return f29812Oxx0xo.get(this) & BufferedChannelKt.f29829IIX0o;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return kotlinx.coroutines.channels.xoIox.f29891II0xO0.I0Io(kotlin.oXIO0o0XI.f29392oIX0oI);
     */
    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x0xO0oo(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.f29812Oxx0xo
            long r0 = r0.get(r14)
            boolean r0 = r14.XXXI(r0)
            if (r0 == 0) goto L13
            kotlinx.coroutines.channels.xoIox$II0xO0 r15 = kotlinx.coroutines.channels.xoIox.f29891II0xO0
            java.lang.Object r15 = r15.II0xO0()
            return r15
        L13:
            kotlinx.coroutines.internal.x0o r8 = kotlinx.coroutines.channels.BufferedChannelKt.xoIox()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = II0XooXoX()
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.OOXIXo r0 = (kotlinx.coroutines.channels.OOXIXo) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = xoIox()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = oOoXoXO(r14, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f30276IXxxXO
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L59
            kotlinx.coroutines.channels.OOXIXo r1 = oxoX(r14, r2, r0)
            if (r1 != 0) goto L57
            if (r11 == 0) goto L21
        L4b:
            kotlinx.coroutines.channels.xoIox$II0xO0 r15 = kotlinx.coroutines.channels.xoIox.f29891II0xO0
            java.lang.Throwable r0 = r14.xoIxX()
            java.lang.Object r15 = r15.oIX0oI(r0)
            goto Lba
        L57:
            r13 = r1
            goto L5a
        L59:
            r13 = r0
        L5a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = oo(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb6
            r1 = 1
            if (r0 == r1) goto Lad
            r1 = 2
            if (r0 == r1) goto L90
            r1 = 3
            if (r0 == r1) goto L88
            r1 = 4
            if (r0 == r1) goto L7c
            r1 = 5
            if (r0 == r1) goto L77
            goto L7a
        L77:
            r13.II0xO0()
        L7a:
            r0 = r13
            goto L21
        L7c:
            long r0 = r14.IoOoo()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L4b
            r13.II0xO0()
            goto L4b
        L88:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            r15.<init>(r0)
            throw r15
        L90:
            if (r11 == 0) goto L96
            r13.IXxxXO()
            goto L4b
        L96:
            boolean r15 = r8 instanceof kotlinx.coroutines.o0IXXIx
            if (r15 == 0) goto L9d
            kotlinx.coroutines.o0IXXIx r8 = (kotlinx.coroutines.o0IXXIx) r8
            goto L9e
        L9d:
            r8 = 0
        L9e:
            if (r8 == 0) goto La3
            OxI(r14, r8, r13, r12)
        La3:
            r13.IXxxXO()
            kotlinx.coroutines.channels.xoIox$II0xO0 r15 = kotlinx.coroutines.channels.xoIox.f29891II0xO0
            java.lang.Object r15 = r15.II0xO0()
            goto Lba
        Lad:
            kotlinx.coroutines.channels.xoIox$II0xO0 r15 = kotlinx.coroutines.channels.xoIox.f29891II0xO0
            kotlin.oXIO0o0XI r0 = kotlin.oXIO0o0XI.f29392oIX0oI
            java.lang.Object r15 = r15.I0Io(r0)
            goto Lba
        Lb6:
            r13.II0xO0()
            goto Lad
        Lba:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.x0xO0oo(java.lang.Object):java.lang.Object");
    }

    public final void xI0oxI00(E e, kotlinx.coroutines.oO<? super oXIO0o0XI> oOVar) {
        Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo = this.f29819Oo;
        if (oooxoxo != null) {
            OnUndeliveredElementKt.II0xO0(oooxoxo, e, oOVar.getContext());
        }
        Throwable xoIxX2 = xoIxX();
        Result.oIX0oI oix0oi = Result.Companion;
        oOVar.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(xoIxX2)));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @OXOo.oOoXoXO
    public Object xII(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> i0Io) {
        return IxIX0I(this, i0Io);
    }

    public final int xIXX(OOXIXo<E> oOXIXo, int i, E e, long j, Object obj, boolean z) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        oOXIXo.xxX(i, e);
        if (z) {
            return xxxI(oOXIXo, i, e, j, obj, z);
        }
        Object OxI2 = oOXIXo.OxI(i);
        if (OxI2 == null) {
            if (IoOoX(j)) {
                if (oOXIXo.oI0IIXIo(i, null, BufferedChannelKt.f29843XO)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (oOXIXo.oI0IIXIo(i, null, obj)) {
                    return 2;
                }
            }
        } else if (OxI2 instanceof o0IXXIx) {
            oOXIXo.OxxIIOOXO(i);
            if (OX(OxI2, e)) {
                x0oVar3 = BufferedChannelKt.f29833OOXIXo;
                oOXIXo.XIxXXX0x0(i, x0oVar3);
                IoIOOxIIo();
                return 0;
            }
            x0oVar = BufferedChannelKt.f29850ooOOo0oXI;
            Object IIXOooo2 = oOXIXo.IIXOooo(i, x0oVar);
            x0oVar2 = BufferedChannelKt.f29850ooOOo0oXI;
            if (IIXOooo2 != x0oVar2) {
                oOXIXo.O0xOxO(i, true);
            }
            return 5;
        }
        return xxxI(oOXIXo, i, e, j, obj, z);
    }

    public final void xOOOX() {
        long j;
        long xoXoI2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f29812Oxx0xo;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (((int) (j >> 60)) == 0) {
                xoXoI2 = BufferedChannelKt.xoXoI(BufferedChannelKt.f29829IIX0o & j, 1);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, xoXoI2));
    }

    public final void xOOxIO(long j) {
        long j2;
        long xoXoI2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f29812Oxx0xo;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            long j3 = BufferedChannelKt.f29829IIX0o & j2;
            if (j3 < j) {
                xoXoI2 = BufferedChannelKt.xoXoI(j3, (int) (j2 >> 60));
            } else {
                return;
            }
        } while (!f29812Oxx0xo.compareAndSet(this, j2, xoXoI2));
    }

    public final void xOoOIoI(kotlinx.coroutines.oO<? super E> oOVar) {
        Result.oIX0oI oix0oi = Result.Companion;
        oOVar.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(OO())));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        r9 = (kotlinx.coroutines.channels.OOXIXo) r9.Oxx0IOOO();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long xX0IIXIx0(kotlinx.coroutines.channels.OOXIXo<E> r9) {
        /*
            r8 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3d
            long r3 = r9.f30276IXxxXO
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r8.IoOoo()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L1b
            return r1
        L1b:
            java.lang.Object r1 = r9.OxI(r0)
            if (r1 == 0) goto L2d
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.OOXIXo()
            if (r1 != r2) goto L28
            goto L2d
        L28:
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.f29843XO
            if (r1 != r2) goto L3a
            return r3
        L2d:
            kotlinx.coroutines.internal.x0o r2 = kotlinx.coroutines.channels.BufferedChannelKt.O0xOxO()
            boolean r1 = r9.oI0IIXIo(r0, r1, r2)
            if (r1 == 0) goto L1b
            r9.IXxxXO()
        L3a:
            int r0 = r0 + (-1)
            goto L4
        L3d:
            kotlinx.coroutines.internal.Oxx0IOOO r9 = r9.Oxx0IOOO()
            kotlinx.coroutines.channels.OOXIXo r9 = (kotlinx.coroutines.channels.OOXIXo) r9
            if (r9 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.xX0IIXIx0(kotlinx.coroutines.channels.OOXIXo):long");
    }

    public final OOXIXo<E> xXOx(long j, OOXIXo<E> oOXIXo) {
        Object Oxx0IOOO2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29817xoXoI;
        Oox.x0xO0oo x0xo0oo = (Oox.x0xO0oo) BufferedChannelKt.OxI();
        loop0: while (true) {
            Oxx0IOOO2 = kotlinx.coroutines.internal.XO.Oxx0IOOO(oOXIXo, j, x0xo0oo);
            if (!IO.II0XooXoX(Oxx0IOOO2)) {
                X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
                while (true) {
                    X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(this);
                    if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                        break loop0;
                    }
                    if (!XO2.Oxx0xo()) {
                        break;
                    }
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x00IoxXI, XO2)) {
                        if (x00IoxXI.oO()) {
                            x00IoxXI.oOoXoXO();
                        }
                    } else if (XO2.oO()) {
                        XO2.oOoXoXO();
                    }
                }
            } else {
                break;
            }
        }
        if (IO.II0XooXoX(Oxx0IOOO2)) {
            I0oOoX();
            if (oOXIXo.f30276IXxxXO * BufferedChannelKt.f29828II0xO0 >= IoOoo()) {
                return null;
            }
            oOXIXo.II0xO0();
            return null;
        }
        OOXIXo<E> oOXIXo2 = (OOXIXo) IO.XO(Oxx0IOOO2);
        long j2 = oOXIXo2.f30276IXxxXO;
        if (j2 > j) {
            int i = BufferedChannelKt.f29828II0xO0;
            xOOxIO(j2 * i);
            if (oOXIXo2.f30276IXxxXO * i >= IoOoo()) {
                return null;
            }
            oOXIXo2.II0xO0();
            return null;
        }
        return oOXIXo2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
    
        r14.XO(kotlin.oXIO0o0XI.f29392oIX0oI);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xXoOI00O(@OXOo.OOXIXo kotlinx.coroutines.selects.xoIox<?> r14, @OXOo.oOoXoXO java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = II0XooXoX()
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.OOXIXo r0 = (kotlinx.coroutines.channels.OOXIXo) r0
        La:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = xoIox()
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = oOoXoXO(r13, r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.f29828II0xO0
            long r5 = (long) r2
            long r5 = r3 / r5
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.f30276IXxxXO
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 == 0) goto L39
            kotlinx.coroutines.channels.OOXIXo r5 = oxoX(r13, r5, r0)
            if (r5 != 0) goto L38
            if (r1 == 0) goto La
        L33:
            r13.O0(r15, r14)
            goto L8c
        L38:
            r0 = r5
        L39:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = oo(r5, r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L88
            r6 = 1
            if (r5 == r6) goto L82
            r6 = 2
            if (r5 == r6) goto L6e
            r1 = 3
            if (r5 == r1) goto L66
            r1 = 4
            if (r5 == r1) goto L5a
            r1 = 5
            if (r5 == r1) goto L56
            goto La
        L56:
            r0.II0xO0()
            goto La
        L5a:
            long r1 = r13.IoOoo()
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L33
            r0.II0xO0()
            goto L33
        L66:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            r14.<init>(r15)
            throw r14
        L6e:
            if (r1 == 0) goto L74
            r0.IXxxXO()
            goto L33
        L74:
            boolean r15 = r14 instanceof kotlinx.coroutines.o0IXXIx
            if (r15 == 0) goto L7b
            kotlinx.coroutines.o0IXXIx r14 = (kotlinx.coroutines.o0IXXIx) r14
            goto L7c
        L7b:
            r14 = 0
        L7c:
            if (r14 == 0) goto L8c
            OxI(r13, r14, r0, r2)
            goto L8c
        L82:
            kotlin.oXIO0o0XI r15 = kotlin.oXIO0o0XI.f29392oIX0oI
            r14.XO(r15)
            goto L8c
        L88:
            r0.II0xO0()
            goto L82
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.xXoOI00O(kotlinx.coroutines.selects.xoIox, java.lang.Object):void");
    }

    public final OOXIXo<E> xo0x(long j, OOXIXo<E> oOXIXo) {
        Object Oxx0IOOO2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29815o00;
        Oox.x0xO0oo x0xo0oo = (Oox.x0xO0oo) BufferedChannelKt.OxI();
        loop0: while (true) {
            Oxx0IOOO2 = kotlinx.coroutines.internal.XO.Oxx0IOOO(oOXIXo, j, x0xo0oo);
            if (!IO.II0XooXoX(Oxx0IOOO2)) {
                X00IoxXI XO2 = IO.XO(Oxx0IOOO2);
                while (true) {
                    X00IoxXI x00IoxXI = (X00IoxXI) atomicReferenceFieldUpdater.get(this);
                    if (x00IoxXI.f30276IXxxXO >= XO2.f30276IXxxXO) {
                        break loop0;
                    }
                    if (!XO2.Oxx0xo()) {
                        break;
                    }
                    if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, x00IoxXI, XO2)) {
                        if (x00IoxXI.oO()) {
                            x00IoxXI.oOoXoXO();
                        }
                    } else if (XO2.oO()) {
                        XO2.oOoXoXO();
                    }
                }
            } else {
                break;
            }
        }
        if (IO.II0XooXoX(Oxx0IOOO2)) {
            I0oOoX();
            if (oOXIXo.f30276IXxxXO * BufferedChannelKt.f29828II0xO0 >= x0xO()) {
                return null;
            }
            oOXIXo.II0xO0();
            return null;
        }
        OOXIXo<E> oOXIXo2 = (OOXIXo) IO.XO(Oxx0IOOO2);
        if (!ooOx() && j <= I0X0x0oIo() / BufferedChannelKt.f29828II0xO0) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f29811OxI;
            while (true) {
                X00IoxXI x00IoxXI2 = (X00IoxXI) atomicReferenceFieldUpdater2.get(this);
                if (x00IoxXI2.f30276IXxxXO >= oOXIXo2.f30276IXxxXO || !oOXIXo2.Oxx0xo()) {
                    break;
                }
                if (androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater2, this, x00IoxXI2, oOXIXo2)) {
                    if (x00IoxXI2.oO()) {
                        x00IoxXI2.oOoXoXO();
                    }
                } else if (oOXIXo2.oO()) {
                    oOXIXo2.oOoXoXO();
                }
            }
        }
        long j2 = oOXIXo2.f30276IXxxXO;
        if (j2 > j) {
            int i = BufferedChannelKt.f29828II0xO0;
            O00(j2 * i);
            if (oOXIXo2.f30276IXxxXO * i >= x0xO()) {
                return null;
            }
            oOXIXo2.II0xO0();
            return null;
        }
        return oOXIXo2;
    }

    @OXOo.OOXIXo
    public final Throwable xoIxX() {
        Throwable oX2 = oX();
        if (oX2 == null) {
            return new ClosedSendChannelException(oOoXoXO.f29886oIX0oI);
        }
        return oX2;
    }

    public final void xoO0xx0(AtomicLongFieldUpdater atomicLongFieldUpdater, Oox.oOoXoXO<? super Long, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.XX(expression = "receiveCatching().getOrNull()", imports = {}))
    @xx0o0O.II0XooXoX
    @OXOo.oOoXoXO
    public Object xoXoI(@OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> i0Io) {
        return Oxx0IOOO.oIX0oI.X0o0xo(this, i0Io);
    }

    public final Object xx0X0(E e, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        UndeliveredElementException oxoX2;
        kotlinx.coroutines.x0xO0oo x0xo0oo = new kotlinx.coroutines.x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
        x0xo0oo.IO();
        Oox.oOoXoXO<E, oXIO0o0XI> oooxoxo = this.f29819Oo;
        if (oooxoxo != null && (oxoX2 = OnUndeliveredElementKt.oxoX(oooxoxo, e, null, 2, null)) != null) {
            kotlin.oO.oIX0oI(oxoX2, xoIxX());
            Result.oIX0oI oix0oi = Result.Companion;
            x0xo0oo.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(oxoX2)));
        } else {
            Throwable xoIxX2 = xoIxX();
            Result.oIX0oI oix0oi2 = Result.Companion;
            x0xo0oo.resumeWith(Result.m287constructorimpl(I0oOoX.oIX0oI(xoIxX2)));
        }
        Object o002 = x0xo0oo.o00();
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            IXIxx0.XO.I0Io(i0Io);
        }
        if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return o002;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    public final void xxIO() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29814X0IIOO;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.oIX0oI.oIX0oI(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.f29835OxI : BufferedChannelKt.f29832O0xOxO));
        if (obj == null) {
            return;
        }
        ((Oox.oOoXoXO) obj).invoke(oX());
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.Oxx0IOOO<E, BufferedChannel<E>> xxIXOIIO() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Oox.IXxxXO iXxxXO = (Oox.IXxxXO) XoX.Oo(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        IIX0o.x0XOIxOo(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.II0XooXoX(this, iXxxXO, (Oox.IXxxXO) XoX.Oo(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    public final void xxOXOOoIX(kotlinx.coroutines.selects.xoIox<?> xoiox, Object obj) {
        x0o x0oVar;
        o0IXXIx o0ixxix;
        x0o x0oVar2;
        x0o x0oVar3;
        OOXIXo oOXIXo = (OOXIXo) f29815o00.get(this);
        while (!XxX0x0xxx()) {
            long andIncrement = f29816oI0IIXIo.getAndIncrement(this);
            int i = BufferedChannelKt.f29828II0xO0;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (oOXIXo.f30276IXxxXO != j) {
                OOXIXo xo0x2 = xo0x(j, oOXIXo);
                if (xo0x2 == null) {
                    continue;
                } else {
                    oOXIXo = xo0x2;
                }
            }
            Object OooI2 = OooI(oOXIXo, i2, andIncrement, xoiox);
            x0oVar = BufferedChannelKt.f29848oO;
            if (OooI2 != x0oVar) {
                x0oVar2 = BufferedChannelKt.f29834Oo;
                if (OooI2 != x0oVar2) {
                    x0oVar3 = BufferedChannelKt.f29854x0xO0oo;
                    if (OooI2 != x0oVar3) {
                        oOXIXo.II0xO0();
                        xoiox.XO(OooI2);
                        return;
                    }
                    throw new IllegalStateException("unexpected");
                }
                if (andIncrement < x0xO()) {
                    oOXIXo.II0xO0();
                }
            } else {
                if (xoiox instanceof o0IXXIx) {
                    o0ixxix = (o0IXXIx) xoiox;
                } else {
                    o0ixxix = null;
                }
                if (o0ixxix != null) {
                    o0oIxOo(o0ixxix, oOXIXo, i2);
                    return;
                }
                return;
            }
        }
        Ox0O(xoiox);
    }

    public final int xxxI(OOXIXo<E> oOXIXo, int i, E e, long j, Object obj, boolean z) {
        x0o x0oVar;
        x0o x0oVar2;
        x0o x0oVar3;
        x0o x0oVar4;
        x0o x0oVar5;
        x0o x0oVar6;
        x0o x0oVar7;
        while (true) {
            Object OxI2 = oOXIXo.OxI(i);
            if (OxI2 != null) {
                x0oVar2 = BufferedChannelKt.f29836Oxx0IOOO;
                if (OxI2 != x0oVar2) {
                    x0oVar3 = BufferedChannelKt.f29850ooOOo0oXI;
                    if (OxI2 != x0oVar3) {
                        x0oVar4 = BufferedChannelKt.f29857xoIox;
                        if (OxI2 == x0oVar4) {
                            oOXIXo.OxxIIOOXO(i);
                            return 5;
                        }
                        if (OxI2 == BufferedChannelKt.O0xOxO()) {
                            oOXIXo.OxxIIOOXO(i);
                            I0oOoX();
                            return 4;
                        }
                        oOXIXo.OxxIIOOXO(i);
                        if (OxI2 instanceof OxxIIOOXO) {
                            OxI2 = ((OxxIIOOXO) OxI2).f29881oIX0oI;
                        }
                        if (OX(OxI2, e)) {
                            x0oVar7 = BufferedChannelKt.f29833OOXIXo;
                            oOXIXo.XIxXXX0x0(i, x0oVar7);
                            IoIOOxIIo();
                            return 0;
                        }
                        x0oVar5 = BufferedChannelKt.f29850ooOOo0oXI;
                        Object IIXOooo2 = oOXIXo.IIXOooo(i, x0oVar5);
                        x0oVar6 = BufferedChannelKt.f29850ooOOo0oXI;
                        if (IIXOooo2 != x0oVar6) {
                            oOXIXo.O0xOxO(i, true);
                        }
                        return 5;
                    }
                    oOXIXo.OxxIIOOXO(i);
                    return 5;
                }
                if (oOXIXo.oI0IIXIo(i, OxI2, BufferedChannelKt.f29843XO)) {
                    return 1;
                }
            } else if (IoOoX(j) && !z) {
                if (oOXIXo.oI0IIXIo(i, null, BufferedChannelKt.f29843XO)) {
                    return 1;
                }
            } else if (z) {
                x0oVar = BufferedChannelKt.f29849oOoXoXO;
                if (oOXIXo.oI0IIXIo(i, null, x0oVar)) {
                    oOXIXo.O0xOxO(i, false);
                    return 4;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (oOXIXo.oI0IIXIo(i, null, obj)) {
                    return 2;
                }
            }
        }
    }

    public /* synthetic */ BufferedChannel(int i, Oox.oOoXoXO oooxoxo, int i2, IIXOooo iIXOooo) {
        this(i, (i2 & 2) != 0 ? null : oooxoxo);
    }
}
