package com.jieli.jl_rcsp.model.command.watch;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes10.dex */
public class HealthSettingCmd extends CommandBase<Param, Response> {
    public static final byte OP_READ = 0;
    public static final byte OP_UPDATE = 2;
    public static final byte OP_WRITE = 1;

    /* loaded from: classes10.dex */
    public static class GetParam extends Param {
        public GetParam(int i) {
            super((byte) 0, CHexConver.intToBigBytes(i));
        }
    }

    /* loaded from: classes10.dex */
    public static class GetResponse extends Response {
        private final List<AttrBean> list;

        public GetResponse(List<AttrBean> list) {
            this.list = list;
        }

        public List<AttrBean> getList() {
            return this.list;
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private final byte[] data;
        private final byte op;

        public Param(byte b, byte[] bArr) {
            this.op = b;
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        public byte getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return ByteBuffer.allocate(this.data.length + 1).put(this.op).put(this.data).array();
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
    }

    /* loaded from: classes10.dex */
    public static class SetParam extends Param {
        private final List<AttrBean> list;

        public SetParam(List<AttrBean> list) {
            super((byte) 1, RcspUtil.attrs2Bytes(list));
            this.list = list;
        }

        public List<AttrBean> getList() {
            return this.list;
        }
    }

    /* loaded from: classes10.dex */
    public static class UpdateParam extends Param {
        private final List<AttrBean> list;

        public UpdateParam(List<AttrBean> list) {
            super((byte) 2, RcspUtil.attrs2Bytes(list));
            this.list = list;
        }

        public List<AttrBean> getList() {
            return this.list;
        }
    }

    public HealthSettingCmd(Param param) {
        this(2, param);
    }

    public HealthSettingCmd(int i, Param param) {
        super(165, HealthSettingCmd.class.getSimpleName(), i);
        setParam(param);
    }
}
