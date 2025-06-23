package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;

/* loaded from: classes9.dex */
public interface Allocator {

    /* loaded from: classes9.dex */
    public interface AllocationNode {
        Allocation getAllocation();

        @Nullable
        AllocationNode next();
    }

    Allocation allocate();

    int getIndividualAllocationLength();

    int getTotalBytesAllocated();

    void release(Allocation allocation);

    void release(AllocationNode allocationNode);

    void trim();
}
