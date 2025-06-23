package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;

@Beta
/* loaded from: classes10.dex */
public interface PredecessorsFunction<N> {
    Iterable<? extends N> predecessors(N n);
}
