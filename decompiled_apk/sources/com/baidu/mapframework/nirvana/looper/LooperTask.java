package com.baidu.mapframework.nirvana.looper;

/* loaded from: classes7.dex */
public abstract class LooperTask extends BaseLooperTask {
    private long e;

    public LooperTask() {
        this.e = 0L;
    }

    public long getDelay() {
        return this.e;
    }

    public void setDelay(long j) {
        this.e = j;
    }

    @Override // com.baidu.mapframework.nirvana.NirvanaTask
    public String toString() {
        return "LooperTask{description=" + getDescription() + ", delay=" + this.e + ", isCancel=" + isCancel() + '}';
    }

    public LooperTask(long j) {
        this.e = j;
    }

    public LooperTask(String str) {
        this.e = 0L;
        appendDescription(str);
    }
}
