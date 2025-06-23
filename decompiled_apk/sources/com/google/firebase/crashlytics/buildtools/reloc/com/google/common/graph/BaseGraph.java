package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n);

    boolean allowsSelfLoops();

    int degree(N n);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(N n, N n2);

    int inDegree(N n);

    Set<EndpointPair<N>> incidentEdges(N n);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    /* bridge */ /* synthetic */ Iterable predecessors(Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.PredecessorsFunction
    Set<N> predecessors(N n);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
    /* bridge */ /* synthetic */ Iterable successors(Object obj);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n);
}
