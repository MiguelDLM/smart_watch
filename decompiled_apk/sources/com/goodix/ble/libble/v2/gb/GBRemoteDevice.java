package com.goodix.ble.libble.v2.gb;

import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libble.v2.gb.pojo.GBCI;
import com.goodix.ble.libble.v2.gb.pojo.GBError;
import com.goodix.ble.libble.v2.gb.pojo.GBPhy;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedure;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedureConnect;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedureRssiRead;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import com.goodix.ble.libcomx.task.TaskQueue;
import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public interface GBRemoteDevice {
    public static final int EVT_CI_UPDATED = 101;
    public static final int EVT_ERROR = 102;
    public static final int EVT_MTU_UPDATED = 103;
    public static final int EVT_PHY_UPDATED = 104;
    public static final int EVT_READY = 108;
    public static final int EVT_STATE_CHANGED = 106;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 3;

    void clearEventListener(Object obj);

    void clearPendingProcedure();

    GBProcedureConnect connect(int i);

    GBProcedure createBond();

    GBGattService defineService(UUID uuid, boolean z);

    GBProcedure disconnect(boolean z);

    GBProcedure discoverServices();

    Event<GBCI> evtCIUpdated();

    Event<GBError> evtError();

    Event<Integer> evtMtuUpdated();

    Event<GBPhy> evtPhyUpdated();

    Event<Boolean> evtReady();

    Event<Integer> evtStateChanged();

    String getAddress();

    GBCI getConnectionParameter();

    ILogger getLogger();

    int getMtu();

    String getName();

    GBPhy getPhy();

    List<GBGattService> getService(UUID uuid);

    List<GBGattService> getServices();

    TaskQueue getSetupSteps();

    int getState();

    boolean isBond();

    boolean isConnected();

    boolean isDisconnected();

    boolean isDiscovered();

    boolean isInService();

    boolean isReady();

    GBProcedure readCurrentPhy();

    GBProcedureRssiRead readRemoteRssi();

    GBProcedure removeBond();

    GBGattService requireService(UUID uuid, boolean z);

    GBProcedure setConnectionPriority(int i);

    void setLogger(ILogger iLogger);

    GBProcedure setMtu(int i);

    GBProcedure setPreferredPhy(int i, int i2, int i3);
}
