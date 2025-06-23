package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes10.dex */
public class NotifyFileStructureChangeCmd extends CommandWithParam<Param> {
    public static final int OP_CREATE = 2;
    public static final int OP_DELETE = 1;
    public static final int OP_MODIFY = 0;

    public NotifyFileStructureChangeCmd(Param param) {
        super(Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, NotifyFileStructureChangeCmd.class.getSimpleName(), param);
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter implements IDataOp {
        private int cluster;
        private int devHandle;
        private String filePath;
        private int op;

        public Param(int i, int i2, int i3, String str) {
            this.devHandle = i;
            this.op = i2;
            this.cluster = i3;
            this.filePath = str;
        }

        public int getCluster() {
            return this.cluster;
        }

        public int getDevHandle() {
            return this.devHandle;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public int getOp() {
            return this.op;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return toData();
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.filePath = "";
            if (bArr == null || bArr.length == 0 || bArr.length < 11) {
                return 0;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.BIG_ENDIAN);
            this.devHandle = wrap.getInt();
            this.op = CHexConver.byteToInt(wrap.get());
            this.cluster = wrap.getInt();
            int min = Math.min((int) wrap.getShort(), wrap.remaining());
            if (min > 0) {
                try {
                    byte[] bArr2 = new byte[min];
                    wrap.get(bArr2);
                    this.filePath = new String(bArr2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            int position = wrap.position();
            wrap.reset();
            return position;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            int length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandle));
                byteArrayOutputStream.write(this.op);
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.cluster));
                String str = this.filePath;
                if (str == null) {
                    length = 0;
                } else {
                    length = str.length();
                }
                byteArrayOutputStream.write(CHexConver.int2byte2(length));
                if (length > 0) {
                    byteArrayOutputStream.write(this.filePath.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public Param(byte[] bArr) {
            parse(bArr);
        }
    }
}
