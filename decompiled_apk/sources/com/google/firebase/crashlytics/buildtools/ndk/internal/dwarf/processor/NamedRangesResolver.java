package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.NamedRange;
import java.util.List;

/* loaded from: classes10.dex */
public interface NamedRangesResolver {
    List<NamedRange> resolveNamedRanges(long j, String str, long j2);
}
