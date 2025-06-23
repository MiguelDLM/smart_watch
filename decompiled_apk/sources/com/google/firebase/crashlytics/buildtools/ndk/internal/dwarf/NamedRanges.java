package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes10.dex */
public class NamedRanges {
    public TreeMap<Long, NamedRange> _byStartAddress = Maps.newTreeMap();

    public NamedRanges(List<NamedRange> list) {
        for (NamedRange namedRange : list) {
            this._byStartAddress.put(namedRange.start, namedRange);
        }
    }

    private static NamedRange findClosest(TreeMap<Long, NamedRange> treeMap, long j) {
        Long lowerKey = treeMap.lowerKey(Long.valueOf(j));
        if (lowerKey != null) {
            return treeMap.get(lowerKey);
        }
        return null;
    }

    public Optional<NamedRange> rangeFor(long j) {
        NamedRange findClosest;
        if (this._byStartAddress.containsKey(Long.valueOf(j))) {
            findClosest = this._byStartAddress.get(Long.valueOf(j));
        } else {
            findClosest = findClosest(this._byStartAddress, j);
        }
        if (findClosest == null) {
            return Optional.absent();
        }
        if (findClosest.contains(j)) {
            return Optional.of(findClosest);
        }
        return Optional.absent();
    }
}
