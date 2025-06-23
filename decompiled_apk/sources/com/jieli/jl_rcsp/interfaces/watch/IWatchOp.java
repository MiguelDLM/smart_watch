package com.jieli.jl_rcsp.interfaces.watch;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_rcsp.model.NotificationMsg;
import com.jieli.jl_rcsp.model.WatchConfigure;
import com.jieli.jl_rcsp.model.WatchFileContent;
import com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public interface IWatchOp {
    boolean cancelTransfer();

    void createWatchFile(String str, boolean z, OnFatFileProgressListener onFatFileProgressListener);

    void deleteWatchFile(String str, OnFatFileProgressListener onFatFileProgressListener);

    void enableCustomWatchBg(String str, OnWatchOpCallback<FatFile> onWatchOpCallback);

    String getCurrentBrowsePath();

    void getCurrentWatchInfo(OnWatchOpCallback<FatFile> onWatchOpCallback);

    void getCustomWatchBgInfo(String str, OnWatchOpCallback<String> onWatchOpCallback);

    WatchConfigure getWatchConfigure(BluetoothDevice bluetoothDevice);

    void getWatchFileSize(String str, OnWatchOpCallback<WatchFileContent> onWatchOpCallback);

    void getWatchMessage(String str, OnWatchOpCallback<String> onWatchOpCallback);

    void getWatchSysLeftSize(OnWatchOpCallback<Long> onWatchOpCallback);

    boolean isOTAResource();

    void jumpToUpdateResource(boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback);

    void listWatchList(OnWatchOpCallback<ArrayList<FatFile>> onWatchOpCallback);

    void openWatchFile(String str, OnWatchOpCallback<byte[]> onWatchOpCallback);

    void pushMessageInfo(NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback);

    void registerOnWatchCallback(OnWatchCallback onWatchCallback);

    void removeMessageInfo(NotificationMsg notificationMsg, OnWatchOpCallback<Boolean> onWatchOpCallback);

    void replaceWatchFile(String str, OnFatFileProgressListener onFatFileProgressListener);

    void requestDeviceConfigure(OnWatchOpCallback<WatchConfigure> onWatchOpCallback);

    void requestDevicePower(OnWatchOpCallback<Boolean> onWatchOpCallback);

    void restoreWatchSystem(OnFatFileProgressListener onFatFileProgressListener);

    void setCurrentWatchInfo(String str, OnWatchOpCallback<FatFile> onWatchOpCallback);

    void syncWeatherInfo(PushInfoDataToDeviceCmd.Weather weather, OnWatchOpCallback<Boolean> onWatchOpCallback);

    void unregisterOnWatchCallback(OnWatchCallback onWatchCallback);

    void updateWatchResource(String str, OnUpdateResourceCallback onUpdateResourceCallback);

    void writeResourceOTAFlag(boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback);
}
