package com.baidu.location.pb;

import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class StatData extends MessageMicro {
    public static final int ACCS_FIELD_NUMBER = 5;
    public static final int COSTS_FIELD_NUMBER = 6;
    public static final int LOAD_FAIL_CNT_FIELD_NUMBER = 2;
    public static final int LOAD_SUCC_CNT_FIELD_NUMBER = 1;
    public static final int LOC_FAIL_CNT_FIELD_NUMBER = 4;
    public static final int LOC_SUCC_CNT_FIELD_NUMBER = 3;
    private boolean hasLoadFailCnt;
    private boolean hasLoadSuccCnt;
    private boolean hasLocFailCnt;
    private boolean hasLocSuccCnt;
    private int loadSuccCnt_ = 0;
    private int loadFailCnt_ = 0;
    private int locSuccCnt_ = 0;
    private int locFailCnt_ = 0;
    private List<Integer> accs_ = Collections.emptyList();
    private List<Integer> costs_ = Collections.emptyList();
    private int cachedSize = -1;

    public static StatData parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (StatData) new StatData().mergeFrom(bArr);
    }

    public StatData addAccs(int i) {
        if (this.accs_.isEmpty()) {
            this.accs_ = new ArrayList();
        }
        this.accs_.add(Integer.valueOf(i));
        return this;
    }

    public StatData addCosts(int i) {
        if (this.costs_.isEmpty()) {
            this.costs_ = new ArrayList();
        }
        this.costs_.add(Integer.valueOf(i));
        return this;
    }

    public final StatData clear() {
        clearLoadSuccCnt();
        clearLoadFailCnt();
        clearLocSuccCnt();
        clearLocFailCnt();
        clearAccs();
        clearCosts();
        this.cachedSize = -1;
        return this;
    }

    public StatData clearAccs() {
        this.accs_ = Collections.emptyList();
        return this;
    }

    public StatData clearCosts() {
        this.costs_ = Collections.emptyList();
        return this;
    }

    public StatData clearLoadFailCnt() {
        this.hasLoadFailCnt = false;
        this.loadFailCnt_ = 0;
        return this;
    }

    public StatData clearLoadSuccCnt() {
        this.hasLoadSuccCnt = false;
        this.loadSuccCnt_ = 0;
        return this;
    }

    public StatData clearLocFailCnt() {
        this.hasLocFailCnt = false;
        this.locFailCnt_ = 0;
        return this;
    }

    public StatData clearLocSuccCnt() {
        this.hasLocSuccCnt = false;
        this.locSuccCnt_ = 0;
        return this;
    }

    public int getAccs(int i) {
        return this.accs_.get(i).intValue();
    }

    public int getAccsCount() {
        return this.accs_.size();
    }

    public List<Integer> getAccsList() {
        return this.accs_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCosts(int i) {
        return this.costs_.get(i).intValue();
    }

    public int getCostsCount() {
        return this.costs_.size();
    }

    public List<Integer> getCostsList() {
        return this.costs_;
    }

    public int getLoadFailCnt() {
        return this.loadFailCnt_;
    }

    public int getLoadSuccCnt() {
        return this.loadSuccCnt_;
    }

    public int getLocFailCnt() {
        return this.locFailCnt_;
    }

    public int getLocSuccCnt() {
        return this.locSuccCnt_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int i;
        int i2 = 0;
        if (hasLoadSuccCnt()) {
            i = CodedOutputStreamMicro.computeInt32Size(1, getLoadSuccCnt());
        } else {
            i = 0;
        }
        if (hasLoadFailCnt()) {
            i += CodedOutputStreamMicro.computeInt32Size(2, getLoadFailCnt());
        }
        if (hasLocSuccCnt()) {
            i += CodedOutputStreamMicro.computeInt32Size(3, getLocSuccCnt());
        }
        if (hasLocFailCnt()) {
            i += CodedOutputStreamMicro.computeInt32Size(4, getLocFailCnt());
        }
        Iterator<Integer> it = getAccsList().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += CodedOutputStreamMicro.computeInt32SizeNoTag(it.next().intValue());
        }
        int size = i + i3 + getAccsList().size();
        Iterator<Integer> it2 = getCostsList().iterator();
        while (it2.hasNext()) {
            i2 += CodedOutputStreamMicro.computeInt32SizeNoTag(it2.next().intValue());
        }
        int size2 = size + i2 + getCostsList().size();
        this.cachedSize = size2;
        return size2;
    }

    public boolean hasLoadFailCnt() {
        return this.hasLoadFailCnt;
    }

    public boolean hasLoadSuccCnt() {
        return this.hasLoadSuccCnt;
    }

    public boolean hasLocFailCnt() {
        return this.hasLocFailCnt;
    }

    public boolean hasLocSuccCnt() {
        return this.hasLocSuccCnt;
    }

    public final boolean isInitialized() {
        return true;
    }

    public StatData setAccs(int i, int i2) {
        this.accs_.set(i, Integer.valueOf(i2));
        return this;
    }

    public StatData setCosts(int i, int i2) {
        this.costs_.set(i, Integer.valueOf(i2));
        return this;
    }

    public StatData setLoadFailCnt(int i) {
        this.hasLoadFailCnt = true;
        this.loadFailCnt_ = i;
        return this;
    }

    public StatData setLoadSuccCnt(int i) {
        this.hasLoadSuccCnt = true;
        this.loadSuccCnt_ = i;
        return this;
    }

    public StatData setLocFailCnt(int i) {
        this.hasLocFailCnt = true;
        this.locFailCnt_ = i;
        return this;
    }

    public StatData setLocSuccCnt(int i) {
        this.hasLocSuccCnt = true;
        this.locSuccCnt_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasLoadSuccCnt()) {
            codedOutputStreamMicro.writeInt32(1, getLoadSuccCnt());
        }
        if (hasLoadFailCnt()) {
            codedOutputStreamMicro.writeInt32(2, getLoadFailCnt());
        }
        if (hasLocSuccCnt()) {
            codedOutputStreamMicro.writeInt32(3, getLocSuccCnt());
        }
        if (hasLocFailCnt()) {
            codedOutputStreamMicro.writeInt32(4, getLocFailCnt());
        }
        Iterator<Integer> it = getAccsList().iterator();
        while (it.hasNext()) {
            codedOutputStreamMicro.writeInt32(5, it.next().intValue());
        }
        Iterator<Integer> it2 = getCostsList().iterator();
        while (it2.hasNext()) {
            codedOutputStreamMicro.writeInt32(6, it2.next().intValue());
        }
    }

    public static StatData parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new StatData().mergeFrom(codedInputStreamMicro);
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public StatData mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int readTag = codedInputStreamMicro.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                setLoadSuccCnt(codedInputStreamMicro.readInt32());
            } else if (readTag == 16) {
                setLoadFailCnt(codedInputStreamMicro.readInt32());
            } else if (readTag == 24) {
                setLocSuccCnt(codedInputStreamMicro.readInt32());
            } else if (readTag == 32) {
                setLocFailCnt(codedInputStreamMicro.readInt32());
            } else if (readTag == 40) {
                addAccs(codedInputStreamMicro.readInt32());
            } else if (readTag != 48) {
                if (!parseUnknownField(codedInputStreamMicro, readTag)) {
                    return this;
                }
            } else {
                addCosts(codedInputStreamMicro.readInt32());
            }
        }
    }
}
