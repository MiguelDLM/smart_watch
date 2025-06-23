package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class LteCellValue extends MessageMicro {
    public static final int BANDWIDTH_FIELD_NUMBER = 5;
    public static final int CI_FIELD_NUMBER = 1;
    public static final int CQI_FIELD_NUMBER = 10;
    public static final int EARFCN_FIELD_NUMBER = 4;
    public static final int PCI_FIELD_NUMBER = 2;
    public static final int RSRP_FIELD_NUMBER = 7;
    public static final int RSRQ_FIELD_NUMBER = 8;
    public static final int RSSI_FIELD_NUMBER = 6;
    public static final int RSSNR_FIELD_NUMBER = 9;
    public static final int TAC_FIELD_NUMBER = 3;
    public static final int TIMINGADVANCE_FIELD_NUMBER = 11;
    private boolean hasBandwidth;
    private boolean hasCi;
    private boolean hasCqi;
    private boolean hasEarfcn;
    private boolean hasPci;
    private boolean hasRsrp;
    private boolean hasRsrq;
    private boolean hasRssi;
    private boolean hasRssnr;
    private boolean hasTac;
    private boolean hasTimingadvance;
    private int ci_ = 0;
    private int pci_ = 0;
    private int tac_ = 0;
    private int earfcn_ = 0;
    private int bandwidth_ = 0;
    private int rssi_ = 0;
    private int rsrp_ = 0;
    private int rsrq_ = 0;
    private int rssnr_ = 0;
    private int cqi_ = 0;
    private int timingadvance_ = 0;
    private int cachedSize = -1;

    public static LteCellValue parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (LteCellValue) new LteCellValue().mergeFrom(bArr);
    }

    public final LteCellValue clear() {
        clearCi();
        clearPci();
        clearTac();
        clearEarfcn();
        clearBandwidth();
        clearRssi();
        clearRsrp();
        clearRsrq();
        clearRssnr();
        clearCqi();
        clearTimingadvance();
        this.cachedSize = -1;
        return this;
    }

    public LteCellValue clearBandwidth() {
        this.hasBandwidth = false;
        this.bandwidth_ = 0;
        return this;
    }

    public LteCellValue clearCi() {
        this.hasCi = false;
        this.ci_ = 0;
        return this;
    }

    public LteCellValue clearCqi() {
        this.hasCqi = false;
        this.cqi_ = 0;
        return this;
    }

    public LteCellValue clearEarfcn() {
        this.hasEarfcn = false;
        this.earfcn_ = 0;
        return this;
    }

    public LteCellValue clearPci() {
        this.hasPci = false;
        this.pci_ = 0;
        return this;
    }

    public LteCellValue clearRsrp() {
        this.hasRsrp = false;
        this.rsrp_ = 0;
        return this;
    }

    public LteCellValue clearRsrq() {
        this.hasRsrq = false;
        this.rsrq_ = 0;
        return this;
    }

    public LteCellValue clearRssi() {
        this.hasRssi = false;
        this.rssi_ = 0;
        return this;
    }

    public LteCellValue clearRssnr() {
        this.hasRssnr = false;
        this.rssnr_ = 0;
        return this;
    }

    public LteCellValue clearTac() {
        this.hasTac = false;
        this.tac_ = 0;
        return this;
    }

    public LteCellValue clearTimingadvance() {
        this.hasTimingadvance = false;
        this.timingadvance_ = 0;
        return this;
    }

    public int getBandwidth() {
        return this.bandwidth_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCi() {
        return this.ci_;
    }

    public int getCqi() {
        return this.cqi_;
    }

    public int getEarfcn() {
        return this.earfcn_;
    }

    public int getPci() {
        return this.pci_;
    }

    public int getRsrp() {
        return this.rsrp_;
    }

    public int getRsrq() {
        return this.rsrq_;
    }

    public int getRssi() {
        return this.rssi_;
    }

    public int getRssnr() {
        return this.rssnr_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        if (hasCi()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getCi());
        } else {
            i = 0;
        }
        if (hasPci()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getPci());
        }
        if (hasTac()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getTac());
        }
        if (hasEarfcn()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getEarfcn());
        }
        if (hasBandwidth()) {
            i += CodedOutputStreamMicro.computeInt32Size(5, getBandwidth());
        }
        if (hasRssi()) {
            i += CodedOutputStreamMicro.computeInt32Size(6, getRssi());
        }
        if (hasRsrp()) {
            i += CodedOutputStreamMicro.computeInt32Size(7, getRsrp());
        }
        if (hasRsrq()) {
            i += CodedOutputStreamMicro.computeInt32Size(8, getRsrq());
        }
        if (hasRssnr()) {
            i += CodedOutputStreamMicro.computeInt32Size(9, getRssnr());
        }
        if (hasCqi()) {
            i += CodedOutputStreamMicro.computeInt32Size(10, getCqi());
        }
        if (hasTimingadvance()) {
            i += CodedOutputStreamMicro.computeInt32Size(11, getTimingadvance());
        }
        this.cachedSize = i;
        return i;
    }

    public int getTac() {
        return this.tac_;
    }

    public int getTimingadvance() {
        return this.timingadvance_;
    }

    public boolean hasBandwidth() {
        return this.hasBandwidth;
    }

    public boolean hasCi() {
        return this.hasCi;
    }

    public boolean hasCqi() {
        return this.hasCqi;
    }

    public boolean hasEarfcn() {
        return this.hasEarfcn;
    }

    public boolean hasPci() {
        return this.hasPci;
    }

    public boolean hasRsrp() {
        return this.hasRsrp;
    }

    public boolean hasRsrq() {
        return this.hasRsrq;
    }

    public boolean hasRssi() {
        return this.hasRssi;
    }

    public boolean hasRssnr() {
        return this.hasRssnr;
    }

    public boolean hasTac() {
        return this.hasTac;
    }

    public boolean hasTimingadvance() {
        return this.hasTimingadvance;
    }

    public final boolean isInitialized() {
        return true;
    }

    public LteCellValue setBandwidth(int i) {
        this.hasBandwidth = true;
        this.bandwidth_ = i;
        return this;
    }

    public LteCellValue setCi(int i) {
        this.hasCi = true;
        this.ci_ = i;
        return this;
    }

    public LteCellValue setCqi(int i) {
        this.hasCqi = true;
        this.cqi_ = i;
        return this;
    }

    public LteCellValue setEarfcn(int i) {
        this.hasEarfcn = true;
        this.earfcn_ = i;
        return this;
    }

    public LteCellValue setPci(int i) {
        this.hasPci = true;
        this.pci_ = i;
        return this;
    }

    public LteCellValue setRsrp(int i) {
        this.hasRsrp = true;
        this.rsrp_ = i;
        return this;
    }

    public LteCellValue setRsrq(int i) {
        this.hasRsrq = true;
        this.rsrq_ = i;
        return this;
    }

    public LteCellValue setRssi(int i) {
        this.hasRssi = true;
        this.rssi_ = i;
        return this;
    }

    public LteCellValue setRssnr(int i) {
        this.hasRssnr = true;
        this.rssnr_ = i;
        return this;
    }

    public LteCellValue setTac(int i) {
        this.hasTac = true;
        this.tac_ = i;
        return this;
    }

    public LteCellValue setTimingadvance(int i) {
        this.hasTimingadvance = true;
        this.timingadvance_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasCi()) {
            codedOutputStreamMicro.writeInt32(1, getCi());
        }
        if (hasPci()) {
            codedOutputStreamMicro.writeInt32(2, getPci());
        }
        if (hasTac()) {
            codedOutputStreamMicro.writeInt32(3, getTac());
        }
        if (hasEarfcn()) {
            codedOutputStreamMicro.writeInt32(4, getEarfcn());
        }
        if (hasBandwidth()) {
            codedOutputStreamMicro.writeInt32(5, getBandwidth());
        }
        if (hasRssi()) {
            codedOutputStreamMicro.writeInt32(6, getRssi());
        }
        if (hasRsrp()) {
            codedOutputStreamMicro.writeInt32(7, getRsrp());
        }
        if (hasRsrq()) {
            codedOutputStreamMicro.writeInt32(8, getRsrq());
        }
        if (hasRssnr()) {
            codedOutputStreamMicro.writeInt32(9, getRssnr());
        }
        if (hasCqi()) {
            codedOutputStreamMicro.writeInt32(10, getCqi());
        }
        if (hasTimingadvance()) {
            codedOutputStreamMicro.writeInt32(11, getTimingadvance());
        }
    }

    public static LteCellValue parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new LteCellValue().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public LteCellValue mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    setCi(codedInputStreamMicro.readInt32());
                    break;
                case 16:
                    setPci(codedInputStreamMicro.readInt32());
                    break;
                case 24:
                    setTac(codedInputStreamMicro.readInt32());
                    break;
                case 32:
                    setEarfcn(codedInputStreamMicro.readInt32());
                    break;
                case 40:
                    setBandwidth(codedInputStreamMicro.readInt32());
                    break;
                case 48:
                    setRssi(codedInputStreamMicro.readInt32());
                    break;
                case 56:
                    setRsrp(codedInputStreamMicro.readInt32());
                    break;
                case 64:
                    setRsrq(codedInputStreamMicro.readInt32());
                    break;
                case 72:
                    setRssnr(codedInputStreamMicro.readInt32());
                    break;
                case 80:
                    setCqi(codedInputStreamMicro.readInt32());
                    break;
                case 88:
                    setTimingadvance(codedInputStreamMicro.readInt32());
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
