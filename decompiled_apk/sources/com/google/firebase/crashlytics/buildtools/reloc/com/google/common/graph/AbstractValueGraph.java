package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Beta
/* loaded from: classes10.dex */
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {
    private static <N, V> Map<EndpointPair<N>, V> edgeValueMap(final ValueGraph<N, V> valueGraph) {
        return Maps.asMap(valueGraph.edges(), new Function<EndpointPair<N>, V>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractValueGraph.2
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function, java.util.function.Function
            public V apply(EndpointPair<N> endpointPair) {
                return (V) ValueGraph.this.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.ValueGraph
    public Graph<N> asGraph() {
        return new AbstractGraph<N>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractValueGraph.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Graph
            public Set<N> adjacentNodes(N n) {
                return AbstractValueGraph.this.adjacentNodes(n);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Graph
            public boolean allowsSelfLoops() {
                return AbstractValueGraph.this.allowsSelfLoops();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
            public int degree(N n) {
                return AbstractValueGraph.this.degree(n);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
            public Set<EndpointPair<N>> edges() {
                return AbstractValueGraph.this.edges();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
            public int inDegree(N n) {
                return AbstractValueGraph.this.inDegree(n);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Graph
            public boolean isDirected() {
                return AbstractValueGraph.this.isDirected();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Graph
            public ElementOrder<N> nodeOrder() {
                return AbstractValueGraph.this.nodeOrder();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.Graph
            public Set<N> nodes() {
                return AbstractValueGraph.this.nodes();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
            public int outDegree(N n) {
                return AbstractValueGraph.this.outDegree(n);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.PredecessorsFunction
            public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
                return predecessors((AnonymousClass1) obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
            public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
                return successors((AnonymousClass1) obj);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.PredecessorsFunction
            public Set<N> predecessors(N n) {
                return AbstractValueGraph.this.predecessors((AbstractValueGraph) n);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
            public Set<N> successors(N n) {
                return AbstractValueGraph.this.successors((AbstractValueGraph) n);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int degree(Object obj) {
        return super.degree(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.ValueGraph
    public Optional<V> edgeValue(N n, N n2) {
        Optional<V> ofNullable;
        ofNullable = Optional.ofNullable(edgeValueOrDefault(n, n2, null));
        return ofNullable;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.ValueGraph
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        if (isDirected() == valueGraph.isDirected() && nodes().equals(valueGraph.nodes()) && edgeValueMap(this).equals(edgeValueMap(valueGraph))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.ValueGraph
    public final int hashCode() {
        return edgeValueMap(this).hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int inDegree(Object obj) {
        return super.inDegree(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int outDegree(Object obj) {
        return super.outDegree(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        Iterable predecessors;
        predecessors = predecessors((AbstractValueGraph<N, V>) ((ValueGraph) obj));
        return predecessors;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.AbstractBaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.BaseGraph, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        Iterable successors;
        successors = successors((AbstractValueGraph<N, V>) ((ValueGraph) obj));
        return successors;
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + edgeValueMap(this);
    }
}
