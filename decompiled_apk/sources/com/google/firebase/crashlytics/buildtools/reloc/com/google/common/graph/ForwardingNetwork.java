package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import java.util.Optional;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<E> adjacentEdges(E e) {
        return delegate().adjacentEdges(e);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<N> adjacentNodes(N n) {
        return delegate().adjacentNodes(n);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public int degree(N n) {
        return delegate().degree(n);
    }

    public abstract Network<N, E> delegate();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Optional<E> edgeConnecting(N n, N n2) {
        return delegate().edgeConnecting(n, n2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public E edgeConnectingOrNull(N n, N n2) {
        return delegate().edgeConnectingOrNull(n, n2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return delegate().edgeOrder();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<E> edges() {
        return delegate().edges();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<E> edgesConnecting(N n, N n2) {
        return delegate().edgesConnecting(n, n2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n, N n2) {
        return delegate().hasEdgeConnecting(n, n2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public int inDegree(N n) {
        return delegate().inDegree(n);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<E> inEdges(N n) {
        return delegate().inEdges(n);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<E> incidentEdges(N n) {
        return delegate().incidentEdges(n);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e) {
        return delegate().incidentNodes(e);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public int outDegree(N n) {
        return delegate().outDegree(n);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network
    public Set<E> outEdges(N n) {
        return delegate().outEdges(n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ForwardingNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n) {
        return delegate().predecessors((Network<N, E>) n);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractNetwork, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Network, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n) {
        return delegate().successors((Network<N, E>) n);
    }
}
