package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    protected final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public void addInEdge(E e, N n, boolean z) {
        if (!z) {
            addOutEdge(e, n);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public void addOutEdge(E e, N n) {
        boolean z;
        if (this.incidentEdgeMap.put(e, n) == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public N adjacentNode(E e) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.get(e));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return incidentEdges();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return incidentEdges();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public N removeInEdge(E e, boolean z) {
        if (!z) {
            return removeOutEdge(e);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.remove(e));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return adjacentNodes();
    }
}
