package com.jieli.jl_rcsp.model.command.setting;

import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.device.settings.SettingData;
import com.jieli.jl_rcsp.model.device.settings.v0.BoundDeviceState;
import com.jieli.jl_rcsp.model.device.settings.v0.BrightnessSetting;
import com.jieli.jl_rcsp.model.device.settings.v0.DialExpandInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.FlashlightSetting;
import com.jieli.jl_rcsp.model.device.settings.v0.FunctionResource;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkFunction;
import com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class PublicSettingsCmd extends CommandBase<Param, Response> {
    public PublicSettingsCmd(Param param) {
        this(2, param);
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        private SettingData settingData;

        public Param() {
            this.settingData = new SettingData(new byte[0]);
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return toData();
        }

        public SettingData getSettingData() {
            return this.settingData;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            return this.settingData.parse(bArr);
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            return this.settingData.toData();
        }

        public Param(SettingData settingData) {
            new SettingData(new byte[0]);
            this.settingData = settingData;
        }
    }

    /* loaded from: classes10.dex */
    public static class ResultParam extends Param {
        private int result;

        public ResultParam() {
            this.result = -1;
        }

        public int getResult() {
            return this.result;
        }

        @Override // com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            this.result = CHexConver.byteToInt(bArr[0]);
            return super.parse(bArr);
        }

        @Override // com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd.Param, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            return new byte[]{(byte) this.result};
        }

        public ResultParam(int i) {
            super(new SettingData(new byte[0]));
            this.result = i;
        }
    }

    public PublicSettingsCmd(int i, Param param) {
        super(51, PublicSettingsCmd.class.getSimpleName(), i);
        setParam(param);
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse implements IDataOp {
        private int result;
        private SettingData settingData;

        public Response(byte[] bArr) {
            this.result = -1;
            setRawData(bArr);
            parse(bArr);
        }

        public int getResult() {
            return this.result;
        }

        public SettingData getSettingData() {
            return this.settingData;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            this.result = CHexConver.byteToInt(bArr[0]);
            if (bArr.length <= 1) {
                return 1;
            }
            int length = bArr.length - 1;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 1, bArr2, 0, length);
            if (this.settingData == null) {
                this.settingData = new SettingData(new byte[0]);
            }
            int parse = this.settingData.parse(bArr2);
            if (parse > 0 && this.settingData.getVersion() == 0) {
                SettingFunction settingFunction = new SettingFunction(bArr2);
                int function = settingFunction.getFunction();
                if (function != 1) {
                    if (function != 2) {
                        if (function != 3) {
                            if (function != 4) {
                                if (function != 5) {
                                    if (function != 7) {
                                        this.settingData = settingFunction;
                                    } else {
                                        this.settingData = new DialExpandInfo(bArr2);
                                    }
                                } else {
                                    this.settingData = new NetworkFunction(bArr2);
                                }
                            } else {
                                this.settingData = new FunctionResource(bArr2);
                            }
                        } else {
                            this.settingData = new BoundDeviceState(bArr2);
                        }
                    } else {
                        this.settingData = new FlashlightSetting(bArr2);
                    }
                } else {
                    this.settingData = new BrightnessSetting(bArr2);
                }
            }
            return 1 + parse;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.result);
                SettingData settingData = this.settingData;
                if (settingData != null) {
                    byteArrayOutputStream.write(settingData.toData());
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.jieli.jl_rcsp.model.base.CommonResponse
        public String toString() {
            return "Response{result=" + this.result + ", settingData=" + this.settingData + '}';
        }

        public Response(int i, SettingData settingData) {
            this.result = i;
            this.settingData = settingData;
        }
    }
}
