package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multiset;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* loaded from: classes10.dex */
public final /* synthetic */ class xooxxX {
    public static Spliterator I0Io(Multiset multiset) {
        return Multisets.spliteratorImpl(multiset);
    }

    @Beta
    public static void II0xO0(Multiset multiset, final ObjIntConsumer objIntConsumer) {
        Preconditions.checkNotNull(objIntConsumer);
        multiset.entrySet().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xoIXOxX
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                objIntConsumer.accept(r2.getElement(), ((Multiset.Entry) obj).getCount());
            }
        });
    }

    public static void oIX0oI(Multiset multiset, final Consumer consumer) {
        Preconditions.checkNotNull(consumer);
        multiset.entrySet().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xX0ox
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                xooxxX.oxoX(consumer, (Multiset.Entry) obj);
            }
        });
    }

    public static /* synthetic */ void oxoX(Consumer consumer, Multiset.Entry entry) {
        Object element = entry.getElement();
        int count = entry.getCount();
        for (int i = 0; i < count; i++) {
            consumer.accept(element);
        }
    }
}
