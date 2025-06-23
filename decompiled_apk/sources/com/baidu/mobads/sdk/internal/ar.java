package com.baidu.mobads.sdk.internal;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ar implements Comparator<Map.Entry<String, Long>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aq f6232a;

    public ar(aq aqVar) {
        this.f6232a = aqVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
