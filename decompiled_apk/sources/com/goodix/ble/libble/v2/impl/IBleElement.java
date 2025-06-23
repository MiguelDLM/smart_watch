package com.goodix.ble.libble.v2.impl;

import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public interface IBleElement<T> {
    boolean checkRequiredUuid();

    void clearFoundFlag();

    void getMissingRequiredUuid(List<UUID> list);

    boolean onDiscovered(T t);
}
