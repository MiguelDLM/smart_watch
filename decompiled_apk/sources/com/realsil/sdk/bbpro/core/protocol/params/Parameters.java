package com.realsil.sdk.bbpro.core.protocol.params;

/* loaded from: classes11.dex */
public class Parameters {
    public static final byte AUDIO_PASS_THROUGH_DISABLE = 0;
    public static final byte AUDIO_PASS_THROUGH_ENABLE = 1;
    public static final byte GET_CFG_LEGACY_NAME = 1;
    public static final byte GET_CFG_LE_NAME = 0;
    public static final byte RWS_STATE_DISCONNECTED = 0;
    public static final byte RWS_STATE_PRIMARY_SPEAKER = 1;
    public static final byte STATUS_INDEX_APP_STATE = 4;
    public static final byte STATUS_INDEX_AUDIO_PASS_THROUGH_STATUS = 3;
    public static final byte STATUS_INDEX_BATTERY_STATUS = 2;
    public static final byte STATUS_INDEX_RWS_CHANNEL = 1;
    public static final byte STATUS_INDEX_RWS_DEFAULT_ROLE = 5;
    public static final byte STATUS_INDEX_RWS_STATE = 0;

    /* loaded from: classes11.dex */
    public interface SCENARIO {
        public static final int SCENARIO_A2DP = 0;
        public static final int SCENARIO_LINEIN = 2;
        public static final int SCENARIO_SCO = 1;
    }
}
