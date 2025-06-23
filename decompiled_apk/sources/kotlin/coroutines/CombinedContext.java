package kotlin.coroutines;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;

@XX({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public final class CombinedContext implements CoroutineContext, Serializable {

    @OOXIXo
    private final CoroutineContext.oIX0oI element;

    @OOXIXo
    private final CoroutineContext left;

    @XX({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12720#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Serialized implements Serializable {

        @OOXIXo
        public static final oIX0oI Companion = new oIX0oI(null);
        private static final long serialVersionUID = 0;

        @OOXIXo
        private final CoroutineContext[] elements;

        /* loaded from: classes6.dex */
        public static final class oIX0oI {
            public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
                this();
            }

            public oIX0oI() {
            }
        }

        public Serialized(@OOXIXo CoroutineContext[] elements) {
            IIX0o.x0xO0oo(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(coroutineContext2);
            }
            return coroutineContext;
        }

        @OOXIXo
        public final CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(@OOXIXo CoroutineContext left, @OOXIXo CoroutineContext.oIX0oI element) {
        IIX0o.x0xO0oo(left, "left");
        IIX0o.x0xO0oo(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean contains(CoroutineContext.oIX0oI oix0oi) {
        return IIX0o.Oxx0IOOO(get(oix0oi.getKey()), oix0oi);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                IIX0o.x0XOIxOo(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((CoroutineContext.oIX0oI) coroutineContext);
            }
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                combinedContext = null;
            }
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        final Ref.IntRef intRef = new Ref.IntRef();
        fold(oXIO0o0XI.f29392oIX0oI, new x0xO0oo<oXIO0o0XI, CoroutineContext.oIX0oI, oXIO0o0XI>() { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(oXIO0o0XI oxio0o0xi, CoroutineContext.oIX0oI oix0oi) {
                invoke2(oxio0o0xi, oix0oi);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo oXIO0o0XI oxio0o0xi, @OOXIXo CoroutineContext.oIX0oI element) {
                IIX0o.x0xO0oo(oxio0o0xi, "<anonymous parameter 0>");
                IIX0o.x0xO0oo(element, "element");
                CoroutineContext[] coroutineContextArr2 = coroutineContextArr;
                Ref.IntRef intRef2 = intRef;
                int i = intRef2.element;
                intRef2.element = i + 1;
                coroutineContextArr2[i] = element;
            }
        });
        if (intRef.element == size) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super CoroutineContext.oIX0oI, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        return operation.invoke((Object) this.left.fold(r, operation), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @oOoXoXO
    public <E extends CoroutineContext.oIX0oI> E get(@OOXIXo CoroutineContext.II0xO0<E> key) {
        IIX0o.x0xO0oo(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.get(key);
            }
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OOXIXo
    public CoroutineContext minusKey(@OOXIXo CoroutineContext.II0xO0<?> key) {
        IIX0o.x0xO0oo(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(key);
        if (minusKey == this.left) {
            return this;
        }
        if (minusKey == EmptyCoroutineContext.INSTANCE) {
            return this.element;
        }
        return new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @OOXIXo
    public CoroutineContext plus(@OOXIXo CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.oIX0oI(this, coroutineContext);
    }

    @OOXIXo
    public String toString() {
        return '[' + ((String) fold("", new x0xO0oo<String, CoroutineContext.oIX0oI, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // Oox.x0xO0oo
            @OOXIXo
            public final String invoke(@OOXIXo String acc, @OOXIXo CoroutineContext.oIX0oI element) {
                IIX0o.x0xO0oo(acc, "acc");
                IIX0o.x0xO0oo(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            }
        })) + ']';
    }
}
