package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.MoreCollectors;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public final class MoreCollectors {
    private static final Object NULL_PLACEHOLDER;
    private static final Collector<Object, ?, Object> ONLY_ELEMENT;
    private static final Collector<Object, ?, Optional<Object>> TO_OPTIONAL;

    /* loaded from: classes10.dex */
    public static final class ToOptionalState {
        static final int MAX_EXTRAS = 4;

        @NullableDecl
        Object element = null;

        @NullableDecl
        List<Object> extras = null;

        public void add(Object obj) {
            Preconditions.checkNotNull(obj);
            if (this.element == null) {
                this.element = obj;
                return;
            }
            List<Object> list = this.extras;
            if (list == null) {
                ArrayList arrayList = new ArrayList(4);
                this.extras = arrayList;
                arrayList.add(obj);
            } else {
                if (list.size() < 4) {
                    this.extras.add(obj);
                    return;
                }
                throw multiples(true);
            }
        }

        public ToOptionalState combine(ToOptionalState toOptionalState) {
            if (this.element == null) {
                return toOptionalState;
            }
            if (toOptionalState.element == null) {
                return this;
            }
            if (this.extras == null) {
                this.extras = new ArrayList();
            }
            this.extras.add(toOptionalState.element);
            List<Object> list = toOptionalState.extras;
            if (list != null) {
                this.extras.addAll(list);
            }
            if (this.extras.size() <= 4) {
                return this;
            }
            List<Object> list2 = this.extras;
            list2.subList(4, list2.size()).clear();
            throw multiples(true);
        }

        public Object getElement() {
            Object obj = this.element;
            if (obj != null) {
                if (this.extras == null) {
                    return obj;
                }
                throw multiples(false);
            }
            throw new NoSuchElementException();
        }

        public Optional<Object> getOptional() {
            Optional<Object> ofNullable;
            if (this.extras == null) {
                ofNullable = Optional.ofNullable(this.element);
                return ofNullable;
            }
            throw multiples(false);
        }

        public IllegalArgumentException multiples(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <");
            sb.append(this.element);
            for (Object obj : this.extras) {
                sb.append(", ");
                sb.append(obj);
            }
            if (z) {
                sb.append(", ...");
            }
            sb.append(kotlin.text.XIxXXX0x0.f29545XO);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static {
        Collector.Characteristics characteristics;
        Collector<Object, ?, Optional<Object>> of;
        Collector.Characteristics characteristics2;
        Collector<Object, ?, Object> of2;
        Supplier supplier = new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.O0o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MoreCollectors.ToOptionalState();
            }
        };
        BiConsumer biConsumer = new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OIxI0O
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((MoreCollectors.ToOptionalState) obj).add(obj2);
            }
        };
        BinaryOperator binaryOperator = new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IXX
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((MoreCollectors.ToOptionalState) obj).combine((MoreCollectors.ToOptionalState) obj2);
            }
        };
        Function function = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x00X0xoXO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((MoreCollectors.ToOptionalState) obj).getOptional();
            }
        };
        characteristics = Collector.Characteristics.UNORDERED;
        of = Collector.of(supplier, biConsumer, binaryOperator, function, characteristics);
        TO_OPTIONAL = of;
        NULL_PLACEHOLDER = new Object();
        Supplier supplier2 = new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.O0o0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new MoreCollectors.ToOptionalState();
            }
        };
        BiConsumer biConsumer2 = new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XOo0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MoreCollectors.lambda$static$0((MoreCollectors.ToOptionalState) obj, obj2);
            }
        };
        BinaryOperator binaryOperator2 = new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IXX
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((MoreCollectors.ToOptionalState) obj).combine((MoreCollectors.ToOptionalState) obj2);
            }
        };
        Function function2 = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IoX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object lambda$static$1;
                lambda$static$1 = MoreCollectors.lambda$static$1((MoreCollectors.ToOptionalState) obj);
                return lambda$static$1;
            }
        };
        characteristics2 = Collector.Characteristics.UNORDERED;
        of2 = Collector.of(supplier2, biConsumer2, binaryOperator2, function2, characteristics2);
        ONLY_ELEMENT = of2;
    }

    private MoreCollectors() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(ToOptionalState toOptionalState, Object obj) {
        if (obj == null) {
            obj = NULL_PLACEHOLDER;
        }
        toOptionalState.add(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$static$1(ToOptionalState toOptionalState) {
        Object element = toOptionalState.getElement();
        if (element == NULL_PLACEHOLDER) {
            return null;
        }
        return element;
    }

    public static <T> Collector<T, ?, T> onlyElement() {
        return (Collector<T, ?, T>) ONLY_ELEMENT;
    }

    public static <T> Collector<T, ?, Optional<T>> toOptional() {
        return (Collector<T, ?, Optional<T>>) TO_OPTIONAL;
    }
}
