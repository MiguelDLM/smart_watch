package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class AIOperateParam extends BaseParameter {
    private Integer aiDialFunUIState;
    private String aiDialStyle;
    private int flag;
    private int op;
    private Integer scaleZoomHeight;
    private Integer scaleZoomWidth;
    private String thumbPath;

    /* loaded from: classes10.dex */
    public static class AIOperateResultParam extends AIOperateParam {
        private final int result;

        public AIOperateResultParam(int i) {
            this.result = i;
        }

        @Override // com.jieli.jl_rcsp.model.parameter.AIOperateParam, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{CHexConver.intToByte(this.result)};
        }

        public int getResult() {
            return this.result;
        }
    }

    private int getParamSize() {
        String str;
        int length;
        if (this.op != 0) {
            return 2;
        }
        int i = this.flag;
        if (i == 0) {
            String str2 = this.aiDialStyle;
            if (str2 == null) {
                return 2;
            }
            length = str2.getBytes().length;
        } else {
            if (i == 1) {
                if (this.aiDialFunUIState == null) {
                    return 2;
                }
                return 3;
            }
            if (i != 4 || (str = this.thumbPath) == null) {
                return 2;
            }
            length = str.getBytes().length;
        }
        return 2 + length;
    }

    public Integer getAiDialFunUIState() {
        return this.aiDialFunUIState;
    }

    public String getAiDialStyle() {
        return this.aiDialStyle;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        String str;
        byte[] bArr = new byte[getParamSize()];
        bArr[0] = CHexConver.intToByte(this.op);
        bArr[1] = CHexConver.intToByte(this.flag);
        if (this.op == 0) {
            int i = this.flag;
            if (i == 0) {
                String str2 = this.aiDialStyle;
                if (str2 != null) {
                    byte[] bytes = str2.getBytes();
                    System.arraycopy(bytes, 0, bArr, 2, bytes.length);
                }
            } else if (i == 1) {
                Integer num = this.aiDialFunUIState;
                if (num != null) {
                    bArr[2] = CHexConver.intToByte(num.intValue());
                }
            } else if (i == 4 && (str = this.thumbPath) != null) {
                byte[] bytes2 = str.getBytes();
                System.arraycopy(bytes2, 0, bArr, 2, bytes2.length);
            }
        }
        return bArr;
    }

    public Integer getScaleZoomHeight() {
        return this.scaleZoomHeight;
    }

    public Integer getScaleZoomWidth() {
        return this.scaleZoomWidth;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public AIOperateParam setAiDialFunUIState(Integer num) {
        this.aiDialFunUIState = num;
        return this;
    }

    public AIOperateParam setAiDialStyle(String str) {
        this.aiDialStyle = str;
        return this;
    }

    public AIOperateParam setFlag(int i) {
        this.flag = i;
        return this;
    }

    public AIOperateParam setOp(int i) {
        this.op = i;
        return this;
    }

    public AIOperateParam setScaleZoomHeight(Integer num) {
        this.scaleZoomHeight = num;
        return this;
    }

    public AIOperateParam setScaleZoomWidth(Integer num) {
        this.scaleZoomWidth = num;
        return this;
    }

    public AIOperateParam setThumbPath(String str) {
        this.thumbPath = str;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "AIOperateParam{op=" + this.op + ", flag=" + this.flag + ", aiDialStyle='" + this.aiDialStyle + "', aiDialFunUIState=" + this.aiDialFunUIState + ", thumbPath='" + this.thumbPath + "'}";
    }
}
