package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor;

import com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.NamedRange;
import java.util.Collections;
import java.util.List;

/* loaded from: classes10.dex */
public class MissingSectionNamedRangesResolver implements NamedRangesResolver {
    @Override // com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf.processor.NamedRangesResolver
    public List<NamedRange> resolveNamedRanges(long j, String str, long j2) {
        return Collections.emptyList();
    }
}
