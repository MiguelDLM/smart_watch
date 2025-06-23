package com.jieli.jl_rcsp.model;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class RecordState {
    public static final int REASON_NORMAL = 0;
    public static final int REASON_STOP = 1;
    public static final int RECORD_STATE_IDLE = 0;
    public static final int RECORD_STATE_START = 1;
    public static final int RECORD_STATE_WORKING = 2;
    private String message;
    private RecordParam recordParam;
    private byte[] voiceData;
    private byte[] voiceDataBlock;
    private int state = 0;
    private int reason = 0;
    private boolean isSyncIatText = false;
    private boolean isSyncNlpText = false;
    private boolean isPlayTTS = false;

    public String getMessage() {
        return this.message;
    }

    public int getReason() {
        return this.reason;
    }

    public RecordParam getRecordParam() {
        return this.recordParam;
    }

    public int getState() {
        return this.state;
    }

    public byte[] getVoiceData() {
        return this.voiceData;
    }

    public byte[] getVoiceDataBlock() {
        return this.voiceDataBlock;
    }

    public boolean isPlayTTS() {
        return this.isPlayTTS;
    }

    public boolean isSyncIatText() {
        return this.isSyncIatText;
    }

    public boolean isSyncNlpText() {
        return this.isSyncNlpText;
    }

    public RecordState setMessage(String str) {
        this.message = str;
        return this;
    }

    public RecordState setPlayTTS(boolean z) {
        this.isPlayTTS = z;
        return this;
    }

    public RecordState setReason(int i) {
        this.reason = i;
        return this;
    }

    public RecordState setRecordParam(RecordParam recordParam) {
        this.recordParam = recordParam;
        return this;
    }

    public RecordState setState(int i) {
        this.state = i;
        return this;
    }

    public RecordState setSyncIatText(boolean z) {
        this.isSyncIatText = z;
        return this;
    }

    public RecordState setSyncNlpText(boolean z) {
        this.isSyncNlpText = z;
        return this;
    }

    public RecordState setVoiceData(byte[] bArr) {
        this.voiceData = bArr;
        return this;
    }

    public RecordState setVoiceDataBlock(byte[] bArr) {
        this.voiceDataBlock = bArr;
        return this;
    }

    public String toString() {
        return "RecordState{state=" + this.state + ", recordParam=" + this.recordParam + ", voiceDataBlock=" + CHexConver.byte2HexStr(this.voiceDataBlock) + ", reason=" + this.reason + ", voiceData=" + CHexConver.byte2HexStr(this.voiceData) + ", message='" + this.message + "'}";
    }
}
