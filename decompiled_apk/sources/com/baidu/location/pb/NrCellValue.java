package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class NrCellValue extends MessageMicro {
    public static final int CI_FIELD_NUMBER = 1;
    public static final int CSIRSRP_FIELD_NUMBER = 8;
    public static final int CSIRSRQ_FIELD_NUMBER = 9;
    public static final int CSISINR_FIELD_NUMBER = 10;
    public static final int NRARFCN_FIELD_NUMBER = 4;
    public static final int PCI_FIELD_NUMBER = 2;
    public static final int SSRSRP_FIELD_NUMBER = 5;
    public static final int SSRSRQ_FIELD_NUMBER = 6;
    public static final int SSSINR_FIELD_NUMBER = 7;
    public static final int TAC_FIELD_NUMBER = 3;
    private boolean hasCi;
    private boolean hasCsirsrp;
    private boolean hasCsirsrq;
    private boolean hasCsisinr;
    private boolean hasNrarfcn;
    private boolean hasPci;
    private boolean hasSsrsrp;
    private boolean hasSsrsrq;
    private boolean hasSssinr;
    private boolean hasTac;
    private long ci_ = 0;
    private int pci_ = 0;
    private int tac_ = 0;
    private int nrarfcn_ = 0;
    private int ssrsrp_ = 0;
    private int ssrsrq_ = 0;
    private int sssinr_ = 0;
    private int csirsrp_ = 0;
    private int csirsrq_ = 0;
    private int csisinr_ = 0;
    private int cachedSize = -1;

    public static NrCellValue parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (NrCellValue) new NrCellValue().mergeFrom(bArr);
    }

    public final NrCellValue clear() {
        clearCi();
        clearPci();
        clearTac();
        clearNrarfcn();
        clearSsrsrp();
        clearSsrsrq();
        clearSssinr();
        clearCsirsrp();
        clearCsirsrq();
        clearCsisinr();
        this.cachedSize = -1;
        return this;
    }

    public NrCellValue clearCi() {
        this.hasCi = false;
        this.ci_ = 0L;
        return this;
    }

    public NrCellValue clearCsirsrp() {
        this.hasCsirsrp = false;
        this.csirsrp_ = 0;
        return this;
    }

    public NrCellValue clearCsirsrq() {
        this.hasCsirsrq = false;
        this.csirsrq_ = 0;
        return this;
    }

    public NrCellValue clearCsisinr() {
        this.hasCsisinr = false;
        this.csisinr_ = 0;
        return this;
    }

    public NrCellValue clearNrarfcn() {
        this.hasNrarfcn = false;
        this.nrarfcn_ = 0;
        return this;
    }

    public NrCellValue clearPci() {
        this.hasPci = false;
        this.pci_ = 0;
        return this;
    }

    public NrCellValue clearSsrsrp() {
        this.hasSsrsrp = false;
        this.ssrsrp_ = 0;
        return this;
    }

    public NrCellValue clearSsrsrq() {
        this.hasSsrsrq = false;
        this.ssrsrq_ = 0;
        return this;
    }

    public NrCellValue clearSssinr() {
        this.hasSssinr = false;
        this.sssinr_ = 0;
        return this;
    }

    public NrCellValue clearTac() {
        this.hasTac = false;
        this.tac_ = 0;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public long getCi() {
        return this.ci_;
    }

    public int getCsirsrp() {
        return this.csirsrp_;
    }

    public int getCsirsrq() {
        return this.csirsrq_;
    }

    public int getCsisinr() {
        return this.csisinr_;
    }

    public int getNrarfcn() {
        return this.nrarfcn_;
    }

    public int getPci() {
        return this.pci_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasCi()) {
            i = CodedOutputStreamMicro.computeUInt64Size(1, getCi());
        } else {
            i = 0;
        }
        if (hasPci()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getPci());
        }
        if (hasTac()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getTac());
        }
        if (hasNrarfcn()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getNrarfcn());
        }
        if (hasSsrsrp()) {
            i += CodedOutputStreamMicro.computeInt32Size(5, getSsrsrp());
        }
        if (hasSsrsrq()) {
            i += CodedOutputStreamMicro.computeInt32Size(6, getSsrsrq());
        }
        if (hasSssinr()) {
            i += CodedOutputStreamMicro.computeInt32Size(7, getSssinr());
        }
        if (hasCsirsrp()) {
            i += CodedOutputStreamMicro.computeInt32Size(8, getCsirsrp());
        }
        if (hasCsirsrq()) {
            i += CodedOutputStreamMicro.computeInt32Size(9, getCsirsrq());
        }
        if (hasCsisinr()) {
            i += CodedOutputStreamMicro.computeInt32Size(10, getCsisinr());
        }
        this.cachedSize = i;
        return i;
    }

    public int getSsrsrp() {
        return this.ssrsrp_;
    }

    public int getSsrsrq() {
        return this.ssrsrq_;
    }

    public int getSssinr() {
        return this.sssinr_;
    }

    public int getTac() {
        return this.tac_;
    }

    public boolean hasCi() {
        return this.hasCi;
    }

    public boolean hasCsirsrp() {
        return this.hasCsirsrp;
    }

    public boolean hasCsirsrq() {
        return this.hasCsirsrq;
    }

    public boolean hasCsisinr() {
        return this.hasCsisinr;
    }

    public boolean hasNrarfcn() {
        return this.hasNrarfcn;
    }

    public boolean hasPci() {
        return this.hasPci;
    }

    public boolean hasSsrsrp() {
        return this.hasSsrsrp;
    }

    public boolean hasSsrsrq() {
        return this.hasSsrsrq;
    }

    public boolean hasSssinr() {
        return this.hasSssinr;
    }

    public boolean hasTac() {
        return this.hasTac;
    }

    public final boolean isInitialized() {
        return true;
    }

    public NrCellValue setCi(long j) {
        this.hasCi = true;
        this.ci_ = j;
        return this;
    }

    public NrCellValue setCsirsrp(int i) {
        this.hasCsirsrp = true;
        this.csirsrp_ = i;
        return this;
    }

    public NrCellValue setCsirsrq(int i) {
        this.hasCsirsrq = true;
        this.csirsrq_ = i;
        return this;
    }

    public NrCellValue setCsisinr(int i) {
        this.hasCsisinr = true;
        this.csisinr_ = i;
        return this;
    }

    public NrCellValue setNrarfcn(int i) {
        this.hasNrarfcn = true;
        this.nrarfcn_ = i;
        return this;
    }

    public NrCellValue setPci(int i) {
        this.hasPci = true;
        this.pci_ = i;
        return this;
    }

    public NrCellValue setSsrsrp(int i) {
        this.hasSsrsrp = true;
        this.ssrsrp_ = i;
        return this;
    }

    public NrCellValue setSsrsrq(int i) {
        this.hasSsrsrq = true;
        this.ssrsrq_ = i;
        return this;
    }

    public NrCellValue setSssinr(int i) {
        this.hasSssinr = true;
        this.sssinr_ = i;
        return this;
    }

    public NrCellValue setTac(int i) {
        this.hasTac = true;
        this.tac_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCi()) {
            codedOutputStreamMicro.writeUInt64(1, getCi());
        }
        if (hasPci()) {
            codedOutputStreamMicro.writeInt32(2, getPci());
        }
        if (hasTac()) {
            codedOutputStreamMicro.writeInt32(3, getTac());
        }
        if (hasNrarfcn()) {
            codedOutputStreamMicro.writeInt32(4, getNrarfcn());
        }
        if (hasSsrsrp()) {
            codedOutputStreamMicro.writeInt32(5, getSsrsrp());
        }
        if (hasSsrsrq()) {
            codedOutputStreamMicro.writeInt32(6, getSsrsrq());
        }
        if (hasSssinr()) {
            codedOutputStreamMicro.writeInt32(7, getSssinr());
        }
        if (hasCsirsrp()) {
            codedOutputStreamMicro.writeInt32(8, getCsirsrp());
        }
        if (hasCsirsrq()) {
            codedOutputStreamMicro.writeInt32(9, getCsirsrq());
        }
        if (hasCsisinr()) {
            codedOutputStreamMicro.writeInt32(10, getCsisinr());
        }
    }

    public static NrCellValue parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new NrCellValue().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public NrCellValue mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    setCi(codedInputStreamMicro.readUInt64());
                    break;
                case 16:
                    setPci(codedInputStreamMicro.readInt32());
                    break;
                case 24:
                    setTac(codedInputStreamMicro.readInt32());
                    break;
                case 32:
                    setNrarfcn(codedInputStreamMicro.readInt32());
                    break;
                case 40:
                    setSsrsrp(codedInputStreamMicro.readInt32());
                    break;
                case 48:
                    setSsrsrq(codedInputStreamMicro.readInt32());
                    break;
                case 56:
                    setSssinr(codedInputStreamMicro.readInt32());
                    break;
                case 64:
                    setCsirsrp(codedInputStreamMicro.readInt32());
                    break;
                case 72:
                    setCsirsrq(codedInputStreamMicro.readInt32());
                    break;
                case 80:
                    setCsisinr(codedInputStreamMicro.readInt32());
                    break;
                default:
                    if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
