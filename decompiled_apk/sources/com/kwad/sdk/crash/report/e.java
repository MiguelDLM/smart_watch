package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes11.dex */
public interface e {
    File Ia();

    void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch);
}
