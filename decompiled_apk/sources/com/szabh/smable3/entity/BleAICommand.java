package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleAICommand extends BleWritable {
    public static final int COMMAND_ANSWER_CALL = 1;
    public static final int COMMAND_DECREASE_VOLUME = 12;
    public static final int COMMAND_DISABLE_DO_NOT_DISTURB = 16;
    public static final int COMMAND_ENABLE_DO_NOT_DISTURB = 15;
    public static final int COMMAND_HANG_UP_CALL = 2;
    public static final int COMMAND_INCREASE_VOLUME = 13;
    public static final int COMMAND_NEXT_TRACK = 11;
    public static final int COMMAND_PAUSE_PLAYBACK = 9;
    public static final int COMMAND_PLAY_MUSIC = 7;
    public static final int COMMAND_PREVIOUS_TRACK = 10;
    public static final int COMMAND_QUERY_BATTERY = 3;
    public static final int COMMAND_REBOOT_SYSTEM = 14;
    public static final int COMMAND_RESUME_PLAYBACK = 8;
    public static final int COMMAND_START_RECORDING = 5;
    public static final int COMMAND_STOP_RECORDING = 6;
    public static final int COMMAND_TAKE_PHOTO = 4;
    public static final int COMMAND_VISUAL_RECOGNITION = 17;

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_LENGTH = 1;
    private int mCommand;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleAICommand() {
        this(0, 1, null);
    }

    public static /* synthetic */ BleAICommand copy$default(BleAICommand bleAICommand, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleAICommand.mCommand;
        }
        return bleAICommand.copy(i);
    }

    public final int component1() {
        return this.mCommand;
    }

    @OOXIXo
    public final BleAICommand copy(int i) {
        return new BleAICommand(i);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCommand);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BleAICommand) && this.mCommand == ((BleAICommand) obj).mCommand;
    }

    public final int getMCommand() {
        return this.mCommand;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 1;
    }

    public int hashCode() {
        return this.mCommand;
    }

    public final void setMCommand(int i) {
        this.mCommand = i;
    }

    @OOXIXo
    public String toString() {
        return "BleAICommand(mCommand=" + this.mCommand + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ BleAICommand(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public BleAICommand(int i) {
        this.mCommand = i;
    }
}
