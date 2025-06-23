package com.goodix.ble.libcomx.task;

import java.util.concurrent.Executor;

/* loaded from: classes9.dex */
public interface ITaskContext {
    Executor getExecutor();

    <T> T getParameter(String str);

    <T> void setParameter(String str, T t);
}
