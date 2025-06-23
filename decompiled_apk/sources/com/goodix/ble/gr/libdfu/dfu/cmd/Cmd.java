package com.goodix.ble.gr.libdfu.dfu.cmd;

import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XConfigExtFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XDumpFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XEfuse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XEmpty;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XEmptyResponse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XEraseFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XGetFlashInfo;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XGetFlashInfoResponse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XGetInfo;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XNvds;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XProgramEnd;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XProgramFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XProgramStart;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XReadRam;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XReadRamResponse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XReset;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XRwReg;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XRwRegResponse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfig;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XSystemConfigResponse;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XUpdateFlash;
import com.goodix.ble.gr.libdfu.dfu.cmd.sdu.XWriteRam;

/* loaded from: classes9.dex */
public class Cmd {

    /* loaded from: classes9.dex */
    public static class ConfigExtFlash {
        public static int CODE = 42;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XConfigExtFlash getTxSdu() {
            return new XConfigExtFlash();
        }
    }

    /* loaded from: classes9.dex */
    public static class DumpFlash {
        public static int CODE = 33;

        public static XReadRamResponse getRxSdu() {
            return new XReadRamResponse();
        }

        public static XDumpFlash getTxSdu() {
            return new XDumpFlash();
        }
    }

    /* loaded from: classes9.dex */
    public static class EraseFlash {
        public static int CODE = 34;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XEraseFlash getTxSdu() {
            return new XEraseFlash();
        }
    }

    /* loaded from: classes9.dex */
    public static class GetExtFlashId {
        public static int CODE = 43;

        public static XGetFlashInfoResponse getRxSdu() {
            return new XGetFlashInfoResponse();
        }

        public static XGetFlashInfo getTxSdu() {
            return new XGetFlashInfo();
        }
    }

    /* loaded from: classes9.dex */
    public static class GetInfo {
        public static int CODE = 1;

        public static XGetInfo getRxSdu() {
            return new XGetInfo();
        }

        public static XEmpty getTxSdu() {
            return new XEmpty();
        }
    }

    /* loaded from: classes9.dex */
    public static class ProgramEnd {
        public static int CODE = 37;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XProgramEnd getTxSdu() {
            return new XProgramEnd();
        }
    }

    /* loaded from: classes9.dex */
    public static class ProgramFlash {
        public static int CODE = 36;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XProgramFlash getTxSdu() {
            return new XProgramFlash();
        }
    }

    /* loaded from: classes9.dex */
    public static class ProgramStart {
        public static int CODE = 35;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XProgramStart getTxSdu() {
            return new XProgramStart();
        }
    }

    /* loaded from: classes9.dex */
    public static class ReadRam {
        public static int CODE = 18;

        public static XReadRamResponse getRxSdu() {
            return new XReadRamResponse();
        }

        public static XReadRam getTxSdu() {
            return new XReadRam();
        }
    }

    /* loaded from: classes9.dex */
    public static class Reset {
        public static int CODE = 2;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XReset getTxSdu() {
            return new XReset();
        }
    }

    /* loaded from: classes9.dex */
    public static class RwReg {
        public static int CODE = 44;

        public static XRwRegResponse getRxSdu() {
            return new XRwRegResponse();
        }

        public static XRwReg getTxSdu() {
            return new XRwReg();
        }
    }

    /* loaded from: classes9.dex */
    public static class SetEfuse {
        public static int CODE = 41;

        public static XEfuse getRxSdu() {
            return new XEfuse();
        }

        public static XEfuse getTxSdu() {
            return new XEfuse();
        }
    }

    /* loaded from: classes9.dex */
    public static class SetNvds {
        public static int CODE = 40;

        public static XNvds getRxSdu() {
            return new XNvds();
        }

        public static XNvds getTxSdu() {
            return new XNvds();
        }
    }

    /* loaded from: classes9.dex */
    public static class SystemConfig {
        public static int CODE = 39;

        public static XSystemConfigResponse getRxSdu() {
            return new XSystemConfigResponse();
        }

        public static XSystemConfig getTxSdu() {
            return new XSystemConfig();
        }
    }

    /* loaded from: classes9.dex */
    public static class UpdateFlash {
        public static int CODE = 38;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XUpdateFlash getTxSdu() {
            return new XUpdateFlash();
        }
    }

    /* loaded from: classes9.dex */
    public static class WriteRam {
        public static int CODE = 17;

        public static XEmptyResponse getRxSdu() {
            return new XEmptyResponse();
        }

        public static XWriteRam getTxSdu() {
            return new XWriteRam();
        }
    }
}
