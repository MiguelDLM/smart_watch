package com.jieli.bluetooth_connect.interfaces;

import com.jieli.bluetooth_connect.bean.BluetoothOption;

/* loaded from: classes10.dex */
public interface IBluetoothBase<T> {
    void addListener(T listener);

    void destroy();

    void removeListener(T listener);

    void setBluetoothOption(BluetoothOption option);
}
