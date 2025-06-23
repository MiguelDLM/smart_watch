package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nMigration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,496:1\n193#2:497\n*S KotlinDebug\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n*L\n435#1:497\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class FlowKt__MigrationKt {
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.XX(expression = "combine(this, other, other2, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, T3, R> X0o0xo<R> I0Io(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo Oox.Oxx0xo<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxx0xo) {
        return Oxx0IOOO.XxX0x0xxx(x0o0xo, x0o0xo2, x0o0xo3, oxx0xo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @kotlin.XX(expression = "onCompletion { emit(value) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> II0XooXoX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.XX(expression = "this.combine(other, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, R> X0o0xo<R> II0xO0(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo Oox.IXxxXO<? super T1, ? super T2, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return Oxx0IOOO.xxX(x0o0xo, x0o0xo2, iXxxXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void IIX0o(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ X0o0xo IIXOooo(X0o0xo x0o0xo, Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<Throwable, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$1
                @Override // Oox.oOoXoXO
                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo Throwable th) {
                    return Boolean.TRUE;
                }
            };
        }
        return Oxx0IOOO.X0xxXX0(x0o0xo, obj, oooxoxo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @kotlin.XX(expression = "catch { emitAll(fallback) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> IXxxXO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.XX(expression = "this.shareIn(scope, Int.MAX_VALUE)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> O0xOxO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @kotlin.XX(expression = "onStart { delay(timeMillis) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OOXIXo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return Oxx0IOOO.oXxOI0oIx(x0o0xo, new FlowKt__MigrationKt$delayFlow$1(j, null));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OxI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @kotlin.XX(expression = "flatMapConcat(mapper)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> Oxx0IOOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends X0o0xo<? extends R>> oooxoxo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @kotlin.XX(expression = "catch { emitAll(fallback) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> Oxx0xo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @kotlin.XX(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> OxxIIOOXO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t, @OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, Boolean> oooxoxo) {
        return Oxx0IOOO.OxxIIOOXO(x0o0xo, new FlowKt__MigrationKt$onErrorReturn$2(oooxoxo, t, null));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.XX(expression = "this.shareIn(scope, bufferSize)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> X0IIOO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.XX(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, T5, R> X0o0xo<R> X0o0xo(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo X0o0xo<? extends T5> x0o0xo5, @OXOo.OOXIXo Oox.OxxIIOOXO<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oxxIIOOXO) {
        return Oxx0IOOO.IIX0o(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, x0o0xo5, oxxIIOOXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @kotlin.XX(expression = "scan(initial, operation)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> XI0IXoo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, R r, @kotlin.II0xO0 @OXOo.OOXIXo Oox.IXxxXO<? super R, ? super T, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @kotlin.XX(expression = "runningReduce(operation)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XIxXXX0x0(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.IXxxXO<? super T, ? super T, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> iXxxXO) {
        return Oxx0IOOO.OooI(x0o0xo, iXxxXO);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @kotlin.XX(expression = "let(transformer)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> XO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.oOoXoXO<? super X0o0xo<? extends T>, ? extends X0o0xo<? extends R>> oooxoxo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @kotlin.XX(expression = "onStart { emit(value) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> XxX0x0xxx(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.XX(expression = "this.buffer(bufferSize).shareIn(scope, 0)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> o00(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @kotlin.XX(expression = "catch { emit(fallback) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oI0IIXIo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, T t) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @kotlin.XX(expression = "this.shareIn(scope, Int.MAX_VALUE, started = SharingStared.Lazily)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oIX0oI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @kotlin.XX(expression = "flattenConcat()", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oO(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @kotlin.XX(expression = "flatMapConcat(mapper)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> oOoXoXO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @kotlin.XX(expression = "this.flatMapLatest(transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T, R> X0o0xo<R> oo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super X0o0xo<? extends R>>, ? extends Object> x0xo0oo) {
        return Oxx0IOOO.oXxx000(x0o0xo, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(x0xo0oo, null));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> oo0xXOI0I(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @kotlin.XX(expression = "flattenConcat()", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> ooOOo0oXI(@OXOo.OOXIXo X0o0xo<? extends X0o0xo<? extends T>> x0o0xo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void ooXIXxIX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @kotlin.XX(expression = "combine(this, other, other2, other3, transform)", imports = {}))
    @OXOo.OOXIXo
    public static final <T1, T2, T3, T4, R> X0o0xo<R> oxoX(@OXOo.OOXIXo X0o0xo<? extends T1> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T2> x0o0xo2, @OXOo.OOXIXo X0o0xo<? extends T3> x0o0xo3, @OXOo.OOXIXo X0o0xo<? extends T4> x0o0xo4, @OXOo.OOXIXo Oox.oI0IIXIo<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> oi0iixio) {
        return Oxx0IOOO.xXxxox0I(x0o0xo, x0o0xo2, x0o0xo3, x0o0xo4, oi0iixio);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @kotlin.XX(expression = "collect(action)", imports = {}))
    public static final <T> void x0XOIxOo(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @OXOo.OOXIXo
    public static final Void x0xO0oo() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void xI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo Oox.x0xO0oo<? super Throwable, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @kotlin.XX(expression = "onStart { emitAll(other) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xXxxox0I(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @kotlin.XX(expression = "onEach { delay(timeMillis) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoIox(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, long j) {
        return Oxx0IOOO.xxOXOOoIX(x0o0xo, new FlowKt__MigrationKt$delayEach$1(j, null));
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @kotlin.XX(expression = "this.shareIn(scope, 0)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xoXoI(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @kotlin.XX(expression = "onCompletion { if (it == null) emitAll(other) }", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xxIXOIIO(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, @OXOo.OOXIXo X0o0xo<? extends T> x0o0xo2) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @kotlin.XX(expression = "drop(count)", imports = {}))
    @OXOo.OOXIXo
    public static final <T> X0o0xo<T> xxX(@OXOo.OOXIXo X0o0xo<? extends T> x0o0xo, int i) {
        Oxx0IOOO.Ix00oIoI();
        throw new KotlinNothingValueException();
    }
}
