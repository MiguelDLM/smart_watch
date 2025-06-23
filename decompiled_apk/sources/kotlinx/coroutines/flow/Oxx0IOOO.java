package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.X00IoxXI;
import kotlin.XX;
import kotlin.collections.xI;
import kotlin.coroutines.CoroutineContext;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.OOXIxO0;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public final class Oxx0IOOO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f30127oIX0oI = "kotlinx.coroutines.flow.defaultConcurrency";

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @XX(expression = "flatMapConcat(mapper)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> I0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return FlowKt__MigrationKt.oOoXoXO(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Integer> I0Io(@OXOo.OOXIXo X0.oOoXoXO oooxoxo) {
        return FlowKt__BuildersKt.I0Io(oooxoxo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @XX(expression = "onEach { delay(timeMillis) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> I0X0x0oIo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__MigrationKt.xoIox(x0o0xo, j);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> I0oOIX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        return FlowKt__LimitKt.oxoX(x0o0xo, i);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> I0oOoX(@OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.I0Io(receiveChannel);
    }

    @OXOo.oOoXoXO
    public static final <S, T extends S> Object I0xX0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super S, ? super T, ? super kotlin.coroutines.I0Io<? super S>, ? extends Object> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super S> i0Io) {
        return FlowKt__ReduceKt.xxIXOIIO(x0o0xo, iXxxXO, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo kotlinx.coroutines.channels.oxoX<T> oxox) {
        return FlowKt__ChannelsKt.II0xO0(oxox);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0xO0(@OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.coroutines.I0Io<? super T>, ? extends Object> oooxoxo) {
        return FlowKt__BuildersKt.II0xO0(oooxoxo);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "flowCombine")
    public static final <T1, T2, R> X0o0xo<R> IIX0(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__ZipKt.x0xO0oo(x0o0xo, x0o0xo2, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, T5, R> X0o0xo<R> IIX0o(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo X0o0xo<? extends T5> x0o0xo5, @OXOo.OOXIXo Oox.OxxIIOOXO<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxxIIOOXO) {
        return FlowKt__ZipKt.XO(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5, oxxIIOOXO);
    }

    @OXOo.oOoXoXO
    public static final <T> Object IIXOooo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Throwable> i0Io) {
        return FlowKt__ErrorsKt.II0xO0(x0o0xo, xo2, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, R> X0o0xo<R> IO(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @kotlin.II0xO0 @OXOo.OOXIXo Oox.OxxIIOOXO<? super XO<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oxxIIOOXO) {
        return FlowKt__ZipKt.OOXIXo(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, oxxIIOOXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @XX(expression = "this.shareIn(scope, 0)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> IOoo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return FlowKt__MigrationKt.xoXoI(x0o0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @XX(expression = "flattenConcat()", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> IXO(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo) {
        return FlowKt__MigrationKt.oO(x0o0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @XX(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> IXxxXO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return FlowKt__MigrationKt.oIX0oI(x0o0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @XX(expression = "onCompletion { emit(value) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Io(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t) {
        return FlowKt__MigrationKt.II0XooXoX(x0o0xo, t);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @XX(expression = "collect(action)", imports = {}))
    public static final <T> void IoIOOxIIo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        FlowKt__MigrationKt.x0XOIxOo(x0o0xo, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @XX(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, T5, R> X0o0xo<R> IoOoX(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo X0o0xo<? extends T5> x0o0xo5, @OXOo.OOXIXo Oox.OxxIIOOXO<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxxIIOOXO) {
        return FlowKt__MigrationKt.X0o0xo(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5, oxxIIOOXO);
    }

    @OXOo.oOoXoXO
    public static final <T> Object IoOoo(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return FlowKt__CollectKt.Oxx0IOOO(xo2, x0o0xo, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> IoXIXo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super T>, ? super Throwable, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return FlowKt__EmittersKt.oxoX(x0o0xo, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <R> X0o0xo<R> Ioxxx(@OXOo.OOXIXo X0o0xo<?> x0o0xo, @OXOo.OOXIXo kotlin.reflect.oxoX<R> oxox) {
        return FlowKt__TransformKt.I0Io(x0o0xo, oxox);
    }

    @OXOo.OOXIXo
    public static final Void Ix00oIoI() {
        return FlowKt__MigrationKt.x0xO0oo();
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> IxIX0I(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return FlowKt__TransformKt.Oxx0IOOO(x0o0xo, x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object IxX00(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.xoIox(x0o0xo, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> O0(@OXOo.OOXIXo T... tArr) {
        return FlowKt__BuildersKt.x0xO0oo(tArr);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @XX(expression = "scan(initial, operation)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> O00(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__MigrationKt.XI0IXoo(x0o0xo, r, iXxxXO);
    }

    @OXOo.oOoXoXO
    public static final <T> Object O00XxXI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.II0xO0(x0o0xo, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> O0IxXx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.Oo(x0o0xo, coroutineContext);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> O0X(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__BuildersKt.x0XOIxOo(x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T, K> X0o0xo<T> O0Xx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
        return FlowKt__DistinctKt.I0Io(x0o0xo, oooxoxo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object O0xOxO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return FlowKt__CollectKt.oxoX(x0o0xo, iXxxXO, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T> x0XOIxOo<T> O0xxXxI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii, @OXOo.OOXIXo Oxx0xo oxx0xo, int i) {
        return FlowKt__ShareKt.Oxx0IOOO(x0o0xo, xii, oxx0xo, i);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @XX(expression = "flatMapConcat(mapper)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> OI0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends X0o0xo<? extends R>> oooxoxo) {
        return FlowKt__MigrationKt.Oxx0IOOO(x0o0xo, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> kotlinx.coroutines.oXIO0o0XI OIOoIIOIx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii) {
        return FlowKt__CollectKt.II0XooXoX(x0o0xo, xii);
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> OIx00oxx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__DelayKt.II0XooXoX(x0o0xo, j);
    }

    @OXOo.oOoXoXO
    public static final <T> Object OO(@OXOo.OOXIXo XO<? super T> xo2, @OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return FlowKt__ChannelsKt.oxoX(xo2, receiveChannel, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> OO0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__TransformKt.xxIXOIIO(x0o0xo, r, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OO0x0xX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return FlowKt__TransformKt.oIX0oI(x0o0xo, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void OOOI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        FlowKt__MigrationKt.ooXIXxIX(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OOXIXo(@OXOo.OOXIXo T[] tArr) {
        return FlowKt__BuildersKt.xoIox(tArr);
    }

    @OXOo.OOXIXo
    public static final ReceiveChannel<oXIO0o0XI> OOXIxO0(@OXOo.OOXIXo xII xii, long j, long j2) {
        return FlowKt__DelayKt.XO(xii, j, j2);
    }

    @OXOo.oOoXoXO
    public static final <T, C extends Collection<? super T>> Object OOxOI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo C c, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super C> i0Io) {
        return FlowKt__CollectionKt.oIX0oI(x0o0xo, c, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @XX(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        return FlowKt__MigrationKt.X0IIOO(x0o0xo, i);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> OX00O0xII(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return FlowKt__MergeKt.I0Io(x0o0xo, i, x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object OoO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.II0XooXoX(x0o0xo, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OooI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super T, ? super T, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> iXxxXO) {
        return FlowKt__TransformKt.xoIox(x0o0xo, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Ox0O(T t) {
        return FlowKt__BuildersKt.oO(t);
    }

    @OXOo.oOoXoXO
    public static final Object OxI(@OXOo.OOXIXo X0o0xo<?> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return FlowKt__CollectKt.II0xO0(x0o0xo, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @XX(expression = "this.flatMapLatest(transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> OxO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return FlowKt__MigrationKt.oo(x0o0xo, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void OxXXx0X(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        FlowKt__MigrationKt.IIX0o(x0o0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @XX(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return FlowKt__MigrationKt.O0xOxO(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0IOOO(@OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> ooooo0oxi) {
        return FlowKt__BuildersKt.Oxx0IOOO(ooooo0oxi);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0xo(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.coroutines.channels.IXxxXO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__BuildersKt.OOXIXo(x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OxxIIOOXO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super T>, ? super Throwable, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return FlowKt__ErrorsKt.oIX0oI(x0o0xo, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, R> X0o0xo<R> X00IoxXI(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @kotlin.II0xO0 @OXOo.OOXIXo Oox.oI0IIXIo<? super XO<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oi0iixio) {
        return FlowKt__ZipKt.xoIox(x0o0xo, x0o0xo2, x0o0xo3, oi0iixio);
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> X00xOoXI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__DelayKt.xoIox(x0o0xo, j);
    }

    @OXOo.oOoXoXO
    public static final <T> Object X0IIOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return FlowKt__CollectKt.XO(x0o0xo, x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0O0I0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.oo0xXOI0I(x0o0xo, coroutineContext);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0o0xo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.X0o0xo(iterable);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @XX(expression = "catch { emit(fallback) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0xII0I(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t) {
        return FlowKt__MigrationKt.oI0IIXIo(x0o0xo, t);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @XX(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0xxXX0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, Boolean> oooxoxo) {
        return FlowKt__MigrationKt.OxxIIOOXO(x0o0xo, t, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> ReceiveChannel<T> XI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii) {
        return FlowKt__ChannelsKt.XO(x0o0xo, xii);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XI0IXoo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return FlowKt__LimitKt.II0xO0(x0o0xo, x0xo0oo, i0Io);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XI0oooXX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.oxoX(x0o0xo, i0Io);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T> X0o0xo<T> XIXIX(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo) {
        return FlowKt__MergeKt.X0o0xo(x0o0xo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XIXIxO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.Oxx0IOOO(x0o0xo, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XO(@OXOo.OOXIXo Iterator<? extends T> it) {
        return FlowKt__BuildersKt.XO(it);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XO00XOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo List<T> list, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super List<? extends T>> i0Io) {
        return FlowKt__CollectionKt.II0xO0(x0o0xo, list, i0Io);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XO0o(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.OOXIXo(x0o0xo, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @XX(expression = "let(transformer)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> XOxIOxOx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super X0o0xo<? extends T>, ? extends X0o0xo<? extends R>> oooxoxo) {
        return FlowKt__MigrationKt.XO(x0o0xo, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> x0XOIxOo<T> XOxxooXI(@OXOo.OOXIXo x0XOIxOo<? extends T> x0xoixoo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__ShareKt.XO(x0xoixoo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return II0XooXoX.Oxx0IOOO(x0o0xo);
    }

    @OXOo.OOXIXo
    @OOXIxO0
    @XO0OX.xxIXOIIO(name = "debounceDuration")
    @X00IoxXI
    public static final <T> X0o0xo<T> XX0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, kotlin.time.oxoX> oooxoxo) {
        return FlowKt__DelayKt.oxoX(x0o0xo, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XX0xXo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return FlowKt__TransformKt.X0o0xo(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XXXI(@OXOo.OOXIXo ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.Oxx0IOOO(receiveChannel);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> XXoOx0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return FlowKt__MergeKt.OOXIXo(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<xI<T>> Xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return FlowKt__TransformKt.oOoXoXO(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Xo0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return FlowKt__DistinctKt.oIX0oI(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XoI0Ixx0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super T, Boolean> x0xo0oo) {
        return FlowKt__DistinctKt.II0xO0(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XoIxOXIXo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.Oxx0xo<? super XO<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> oxx0xo) {
        return FlowKt__ErrorsKt.Oxx0IOOO(x0o0xo, oxx0xo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Integer> i0Io) {
        return FlowKt__CountKt.II0xO0(x0o0xo, i0Io);
    }

    @OXOo.oOoXoXO
    public static final <T> Object XooIO0oo0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Set<T> set, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Set<? extends T>> i0Io) {
        return FlowKt__CollectionKt.oxoX(x0o0xo, set, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> Xx000oIo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @kotlin.II0xO0 @OXOo.OOXIXo Oox.Oxx0xo<? super XO<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oxx0xo) {
        return FlowKt__ZipKt.xxIXOIIO(x0o0xo, x0o0xo2, oxx0xo);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, R> X0o0xo<R> XxX0x0xxx(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @kotlin.II0xO0 @OXOo.OOXIXo Oox.Oxx0xo<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxx0xo) {
        return FlowKt__ZipKt.oxoX(x0o0xo, x0o0xo2, x0o0xo3, oxx0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @XX(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> o0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        return FlowKt__MigrationKt.xxIXOIIO(x0o0xo, x0o0xo2);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> o0Xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return FlowKt__LimitKt.II0XooXoX(x0o0xo, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void o0oxo0oI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo Oox.x0xO0oo<? super Throwable, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo2) {
        FlowKt__MigrationKt.xI(x0o0xo, x0xo0oo, x0xo0oo2);
    }

    @OXOo.oOoXoXO
    public static final <T> Object o0xxxXXxX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.oIX0oI(x0o0xo, x0xo0oo, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oI(@OXOo.OOXIXo X0o0xo<? extends T>... x0o0xoArr) {
        return FlowKt__MergeKt.ooOOo0oXI(x0o0xoArr);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oI0IIXIo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        return II0XooXoX.X0o0xo(x0o0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @XX(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIIxXoo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        return FlowKt__MigrationKt.o00(x0o0xo, i);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        return FlowKt__BuildersKt.oIX0oI(oix0oi);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return II0XooXoX.II0xO0(x0o0xo, i, bufferOverflow);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oOoIIO0(@OXOo.OOXIXo Iterable<? extends X0o0xo<? extends T>> iterable) {
        return FlowKt__MergeKt.oOoXoXO(iterable);
    }

    @OXOo.OOXIXo
    public static final <T> x0XOIxOo<T> oOoXoXO(@OXOo.OOXIXo xxIXOIIO<T> xxixoiio) {
        return FlowKt__ShareKt.oIX0oI(xxixoiio);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @XX(expression = "onStart { delay(timeMillis) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__MigrationKt.OOXIXo(x0o0xo, j);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @XX(expression = "drop(count)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oX0I0O(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        return FlowKt__MigrationKt.xxX(x0o0xo, i);
    }

    @OXOo.oOoXoXO
    public static final <T> Object oX0ooo0I0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super IIXOooo<? extends T>> i0Io) {
        return FlowKt__ShareKt.xxIXOIIO(x0o0xo, xii, i0Io);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T> X0o0xo<T> oXIO0o0XI(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo, int i) {
        return FlowKt__MergeKt.XO(x0o0xo, i);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oXIoO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j, @OXOo.OOXIXo Oox.x0xO0oo<? super Throwable, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return FlowKt__ErrorsKt.X0o0xo(x0o0xo, j, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> oXO0oOx0(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__ZipKt.Oxx0xo(x0o0xo, x0o0xo2, iXxxXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oXX0IoI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.OxI(x0o0xo, coroutineContext);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oXxOI0oIx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__EmittersKt.XO(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> oXxx000(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return FlowKt__MergeKt.x0XOIxOo(x0o0xo, iXxxXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @XX(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, R> X0o0xo<R> oo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo Oox.oI0IIXIo<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oi0iixio) {
        return FlowKt__MigrationKt.oxoX(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, oi0iixio);
    }

    @OXOo.OOXIXo
    public static final <T> IIXOooo<T> oo00(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo xII xii, @OXOo.OOXIXo Oxx0xo oxx0xo, T t) {
        return FlowKt__ShareKt.xoIox(x0o0xo, xii, oxx0xo, t);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @XX(expression = "combine(this, other, other2, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, T3, R> X0o0xo<R> oo0xXOI0I(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo Oox.Oxx0xo<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxx0xo) {
        return FlowKt__MigrationKt.I0Io(x0o0xo, x0o0xo2, x0o0xo3, oxx0xo);
    }

    @OXOo.OOXIXo
    public static final <T> IIXOooo<T> ooOOo0oXI(@OXOo.OOXIXo xoIox<T> xoiox) {
        return FlowKt__ShareKt.II0xO0(xoiox);
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> ooOx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return FlowKt__MergeKt.oIX0oI(x0o0xo, x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final <T> Object ox(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return FlowKt__ReduceKt.I0Io(x0o0xo, x0xo0oo, i0Io);
    }

    public static final int oxIIX0o() {
        return FlowKt__MergeKt.II0XooXoX();
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> oxXx0IX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__DelayKt.oIX0oI(x0o0xo, j);
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Long> oxoX(@OXOo.OOXIXo X0.oO oOVar) {
        return FlowKt__BuildersKt.oxoX(oOVar);
    }

    @OXOo.oOoXoXO
    public static final <T> Object oxxXoxO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Integer> i0Io) {
        return FlowKt__CountKt.oIX0oI(x0o0xo, x0xo0oo, i0Io);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @XX(expression = "catch { emitAll(fallback) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> x0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        return FlowKt__MigrationKt.Oxx0xo(x0o0xo, x0o0xo2);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @XX(expression = "onStart { emit(value) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> x00IOx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t) {
        return FlowKt__MigrationKt.XxX0x0xxx(x0o0xo, t);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> x0OIX00oO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return FlowKt__TransformKt.XO(x0o0xo, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @XX(expression = "catch { emitAll(fallback) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> x0OxxIOxX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        return FlowKt__MigrationKt.IXxxXO(x0o0xo, x0o0xo2);
    }

    public static final void x0xO(@OXOo.OOXIXo XO<?> xo2) {
        FlowKt__EmittersKt.II0xO0(xo2);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @XX(expression = "this.combine(other, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> xI(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__MigrationKt.II0xO0(x0o0xo, x0o0xo2, iXxxXO);
    }

    @OXOo.oOoXoXO
    public static final <T, R> Object xI0oxI00(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super R> i0Io) {
        return FlowKt__ReduceKt.X0o0xo(x0o0xo, r, iXxxXO, i0Io);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, T5, R> X0o0xo<R> xII(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo X0o0xo<? extends T5> x0o0xo5, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IIXOooo<? super XO<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iIXOooo) {
        return FlowKt__ZipKt.oOoXoXO(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5, iIXOooo);
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> xIXX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__DelayKt.xxIXOIIO(x0o0xo, j);
    }

    @OXOo.OOXIXo
    @o0
    public static final <T, R> X0o0xo<R> xIx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return FlowKt__EmittersKt.II0XooXoX(x0o0xo, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> xIx0XO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> iXxxXO) {
        return FlowKt__EmittersKt.Oxx0IOOO(x0o0xo, iXxxXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @XX(expression = "flattenConcat()", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xOOOX(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo) {
        return FlowKt__MigrationKt.ooOOo0oXI(x0o0xo);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> xOOxI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super XO<? super R>, ? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> iXxxXO) {
        return FlowKt__LimitKt.xxIXOIIO(x0o0xo, iXxxXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @XX(expression = "runningReduce(operation)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xOOxIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super T, ? super T, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> iXxxXO) {
        return FlowKt__MigrationKt.XIxXXX0x0(x0o0xo, iXxxXO);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "flowCombineTransform")
    public static final <T1, T2, R> X0o0xo<R> xOoOIoI(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @kotlin.II0xO0 @OXOo.OOXIXo Oox.Oxx0xo<? super XO<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> oxx0xo) {
        return FlowKt__ZipKt.Oo(x0o0xo, x0o0xo2, oxx0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @XX(expression = "onStart { emitAll(other) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        return FlowKt__MigrationKt.xXxxox0I(x0o0xo, x0o0xo2);
    }

    @OXOo.OOXIXo
    @OOXIxO0
    public static final <T> X0o0xo<T> xXOx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return FlowKt__DelayKt.I0Io(x0o0xo, j);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xXoOI00O(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super XO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__EmittersKt.X0o0xo(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, R> X0o0xo<R> xXxxox0I(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo Oox.oI0IIXIo<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oi0iixio) {
        return FlowKt__ZipKt.X0o0xo(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, oi0iixio);
    }

    @OXOo.OOXIXo
    @X00IoxXI
    @OOXIxO0
    public static final <T> X0o0xo<T> xo0x(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Long> oooxoxo) {
        return FlowKt__DelayKt.II0xO0(x0o0xo, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Long> xoIox(@OXOo.OOXIXo long[] jArr) {
        return FlowKt__BuildersKt.xxIXOIIO(jArr);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoIxX() {
        return FlowKt__BuildersKt.ooOOo0oXI();
    }

    @OXOo.OOXIXo
    @XI0oooXX
    public static final <T, R> X0o0xo<R> xoO0xx0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return FlowKt__MergeKt.II0xO0(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoXoI(@kotlin.II0xO0 @OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.coroutines.channels.IXxxXO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__BuildersKt.oOoXoXO(x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoxXI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return FlowKt__LimitKt.X0o0xo(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xx0X0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        return II0XooXoX.II0XooXoX(x0o0xo, coroutineContext);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xxIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return FlowKt__TransformKt.oxoX(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final X0o0xo<Integer> xxIXOIIO(@OXOo.OOXIXo int[] iArr) {
        return FlowKt__BuildersKt.II0XooXoX(iArr);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xxOXOOoIX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        return FlowKt__TransformKt.II0XooXoX(x0o0xo, x0xo0oo);
    }

    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> xxX(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__ZipKt.I0Io(x0o0xo, x0o0xo2, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xxx00(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        return FlowKt__LimitKt.Oxx0IOOO(x0o0xo, i);
    }

    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> xxxI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return FlowKt__TransformKt.OOXIXo(x0o0xo, r, iXxxXO);
    }
}
