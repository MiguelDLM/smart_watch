package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

/* loaded from: classes.dex */
public class Cache {
    Pools.Pool<ArrayRow> mOptimizedArrayRowPool = new Pools.SimplePool(256);
    Pools.Pool<ArrayRow> mArrayRowPool = new Pools.SimplePool(256);
    Pools.Pool<SolverVariable> mSolverVariablePool = new Pools.SimplePool(256);
    SolverVariable[] mIndexedVariables = new SolverVariable[32];
}
