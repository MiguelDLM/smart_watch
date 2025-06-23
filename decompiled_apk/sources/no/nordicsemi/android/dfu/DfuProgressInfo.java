package no.nordicsemi.android.dfu;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
class DfuProgressInfo {
    private int bytesReceived;
    private int bytesSent;
    private int currentPart;
    private int imageSizeInBytes;
    private int initialBytesSent;
    private int lastBytesSent;
    private long lastProgressTime;
    private final ProgressListener mListener;
    private int maxObjectSizeInBytes;
    private int progress;
    private long timeStart;
    private int totalParts;

    /* loaded from: classes6.dex */
    public interface ProgressListener {
        void updateProgressNotification();
    }

    public DfuProgressInfo(@NonNull ProgressListener progressListener) {
        this.mListener = progressListener;
    }

    public void addBytesSent(int i) {
        setBytesSent(this.bytesSent + i);
    }

    public int getAvailableObjectSizeIsBytes() {
        int i = this.imageSizeInBytes;
        int i2 = this.bytesSent;
        int i3 = this.maxObjectSizeInBytes;
        return Math.min(i - i2, i3 - (i2 % i3));
    }

    public float getAverageSpeed() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.timeStart;
        if (elapsedRealtime - j != 0) {
            return (this.bytesSent - this.initialBytesSent) / ((float) (elapsedRealtime - j));
        }
        return 0.0f;
    }

    public int getBytesReceived() {
        return this.bytesReceived;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }

    public int getCurrentPart() {
        return this.currentPart;
    }

    public int getImageSizeInBytes() {
        return this.imageSizeInBytes;
    }

    public int getProgress() {
        return this.progress;
    }

    public float getSpeed() {
        float f;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.timeStart != 0) {
            f = (this.bytesSent - this.lastBytesSent) / ((float) (elapsedRealtime - this.lastProgressTime));
        } else {
            f = 0.0f;
        }
        this.lastProgressTime = elapsedRealtime;
        this.lastBytesSent = this.bytesSent;
        return f;
    }

    public int getTotalParts() {
        return this.totalParts;
    }

    public void init(int i, int i2, int i3) {
        this.imageSizeInBytes = i;
        this.maxObjectSizeInBytes = Integer.MAX_VALUE;
        this.currentPart = i2;
        this.totalParts = i3;
    }

    public boolean isComplete() {
        if (this.bytesSent == this.imageSizeInBytes) {
            return true;
        }
        return false;
    }

    public boolean isLastPart() {
        if (this.currentPart == this.totalParts) {
            return true;
        }
        return false;
    }

    public boolean isObjectComplete() {
        if (this.bytesSent % this.maxObjectSizeInBytes == 0) {
            return true;
        }
        return false;
    }

    public void setBytesReceived(int i) {
        this.bytesReceived = i;
    }

    public void setBytesSent(int i) {
        if (this.timeStart == 0) {
            this.timeStart = SystemClock.elapsedRealtime();
            this.initialBytesSent = i;
        }
        this.bytesSent = i;
        this.progress = (int) ((i * 100.0f) / this.imageSizeInBytes);
        this.mListener.updateProgressNotification();
    }

    public void setMaxObjectSizeInBytes(int i) {
        this.maxObjectSizeInBytes = i;
    }

    public void setProgress(int i) {
        this.progress = i;
        this.mListener.updateProgressNotification();
    }

    public DfuProgressInfo setTotalPart(int i) {
        this.totalParts = i;
        return this;
    }
}
