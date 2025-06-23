package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* loaded from: classes10.dex */
public final /* synthetic */ class OoIXo {
    public static void oIX0oI(Multimap multimap, final BiConsumer biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        multimap.entries().forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xIoXXXIXo
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                biConsumer.accept(r2.getKey(), ((Map.Entry) obj).getValue());
            }
        });
    }
}
