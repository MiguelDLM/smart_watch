package com.iflytek.sparkchain.core;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class AiBuilder {
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private InputData inputData;
    protected int paramCount = 0;
    protected AiStatus status = AiStatus.BEGIN;
    protected int handle = getAtomicHandle();

    /* loaded from: classes10.dex */
    public static class InputData {
        private ByteBuffer buffer;
        private InputData lastData;

        private InputData() {
        }

        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        public InputData getLastData() {
            return this.lastData;
        }

        public void setBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
        }

        public void setLastData(InputData inputData) {
            this.lastData = inputData;
        }
    }

    private void clearInputData() {
        while (true) {
            InputData inputData = this.inputData;
            if (inputData == null) {
                return;
            }
            inputData.getBuffer().clear();
            this.inputData.setBuffer(null);
            this.inputData = this.inputData.getLastData();
        }
    }

    public static int getAtomicHandle() {
        return atomicInteger.incrementAndGet();
    }

    public void add(String str, ByteBuffer byteBuffer, b bVar, c cVar) {
        if (byteBuffer == null) {
            return;
        }
        if (cVar.equals(c.OTHER)) {
            AiHelper.getInst().newBuffer(this.handle, str, byteBuffer.array(), bVar.getValue(), cVar.getValue(), this.status.getValue());
        } else {
            addDirectBuffer(str, byteBuffer, bVar, cVar.getValue());
        }
    }

    public void addDirectBuffer(String str, ByteBuffer byteBuffer, b bVar, int i) {
        AiHelper.getInst().newDirectBuffer(this.handle, str, byteBuffer, bVar.getValue(), i, this.status.getValue(), byteBuffer.capacity());
    }

    public void clean() {
        AiHelper.getInst().paramClear(this.handle);
        AiHelper.getInst().inputClear(this.handle);
        clearInputData();
        this.paramCount = 0;
    }

    public void custom(String str, byte[] bArr, b bVar, int i, int i2) {
        if (bArr != null) {
            AiHelper.getInst().newCustom(this.handle, str, bArr, bVar.getValue(), i, i2);
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        clearInputData();
    }

    public void add(String str, ByteBuffer byteBuffer, c cVar) {
        if (byteBuffer == null) {
            return;
        }
        add(str, byteBuffer, b.MEM, cVar);
    }

    public void add(String str, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        add(str, bArr, c.OTHER);
    }

    public void add(String str, byte[] bArr, b bVar, c cVar) {
        if (bArr == null) {
            return;
        }
        if (cVar.equals(c.OTHER)) {
            AiHelper.getInst().newBuffer(this.handle, str, bArr, bVar.getValue(), cVar.getValue(), this.status.getValue());
            return;
        }
        int length = bArr.length;
        c cVar2 = c.TEXT;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + (cVar == cVar2 ? 2 : 0));
        allocateDirect.put(bArr);
        if (cVar == cVar2) {
            allocateDirect.put((byte) 0);
        }
        if (this.inputData == null) {
            InputData inputData = new InputData();
            this.inputData = inputData;
            inputData.buffer = allocateDirect;
        } else {
            InputData inputData2 = new InputData();
            inputData2.setBuffer(allocateDirect);
            inputData2.setLastData(this.inputData);
            this.inputData = inputData2;
        }
        addDirectBuffer(str, allocateDirect, bVar, cVar.getValue());
    }

    public void add(String str, byte[] bArr, c cVar) {
        if (bArr == null) {
            return;
        }
        add(str, bArr, b.MEM, cVar);
    }
}
