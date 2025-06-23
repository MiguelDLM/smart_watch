package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.io;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.nio.file.FileSystemException;

@Beta
@GwtIncompatible
/* loaded from: classes10.dex */
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(@NullableDecl String str) {
        super(str, null, "unable to guarantee security of recursive delete");
    }
}
