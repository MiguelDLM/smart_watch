package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import java.util.List;

/* loaded from: classes10.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter iOFileFilter);

    List<IOFileFilter> getFileFilters();

    boolean removeFileFilter(IOFileFilter iOFileFilter);

    void setFileFilters(List<IOFileFilter> list);
}
