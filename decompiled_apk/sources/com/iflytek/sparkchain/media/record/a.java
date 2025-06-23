package com.iflytek.sparkchain.media.record;

import android.content.Context;
import android.media.AudioTrack;
import android.os.MemoryFile;
import android.util.Log;
import com.iflytek.sparkchain.utils.FileUtil;
import com.iflytek.sparkchain.utils.log.LogUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes10.dex */
public class a {
    public static final int DEF_PROC_SCALE = 100;
    private ArrayList<C0674a> mAudioInfo;
    private Context mContext;
    private String mLocal_save_path;
    private int mMaxFileSize;
    private volatile long mPercent;
    private int mProcScale;
    private int mRate;
    public volatile long mTotalSize;
    private final int DEF_BYTE = 2;
    private final int DEF_CHANNEL = 1;
    private final int DEF_RATE = 16000;
    private final int DEF_MIN_BUF_SEC = 60;
    private final int BLANK_BLOCK_MS = 500;
    private final int DEF_MIN_BUF_SIZE = 1920000;
    private MemoryFile memFile = null;
    private volatile int mReadOffset = 0;
    private C0674a mTempAudio = null;
    private String mFilepath = "";
    private byte[] mAudioBuf = null;
    private int mBufOffset = 0;
    private int mBufLen = 0;
    private final float MAX_PLAYABLE_PERCANT = 0.95f;
    private boolean mEndWithNull = true;
    private int audioTrackBuffSize = 0;

    /* renamed from: com.iflytek.sparkchain.media.record.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0674a {

        /* renamed from: a, reason: collision with root package name */
        public int f17476a;
        public long b;
        public long c;
        public int d;

        public C0674a(long j, long j2, int i, int i2) {
            this.b = j;
            this.c = j2;
            this.d = i;
            this.f17476a = i2;
        }
    }

    public a(Context context, int i, int i2, String str, int i3) {
        this.mMaxFileSize = 1920000;
        this.mAudioInfo = null;
        this.mContext = null;
        this.mRate = 16000;
        this.mPercent = 0L;
        this.mTotalSize = 0L;
        this.mLocal_save_path = null;
        this.mProcScale = 100;
        this.mContext = context;
        this.mPercent = 0L;
        this.mAudioInfo = new ArrayList<>();
        this.mTotalSize = 0L;
        this.mRate = i;
        this.mLocal_save_path = str;
        this.mProcScale = i3;
        this.mMaxFileSize = (i * 2 * i2) + 1920000;
        LogUtil.d("min audio seconds: " + i2 + ", max audio buf size: " + this.mMaxFileSize);
    }

    private String genFileName() {
        return FileUtil.getUserPath(this.mContext) + System.currentTimeMillis() + "tts.pcm";
    }

    private void readAudio(int i) throws IOException {
        if (this.mAudioBuf == null) {
            this.mAudioBuf = new byte[i * 10];
        }
        int length = this.mAudioBuf.length;
        int i2 = (int) (this.mTotalSize - this.mReadOffset);
        if (i2 < length) {
            length = i2;
        }
        this.memFile.readBytes(this.mAudioBuf, this.mReadOffset, 0, length);
        this.mReadOffset += length;
        this.mBufOffset = 0;
        this.mBufLen = length;
        LogUtil.d("readAudio leave, dataSize=" + length + ", bufLen=" + i2);
    }

    private void writeToFile(byte[] bArr) throws IOException {
        String str;
        String str2;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (this.memFile == null) {
            this.mFilepath = genFileName();
            try {
                MemoryFile memoryFile = new MemoryFile(this.mFilepath, this.mMaxFileSize);
                this.memFile = memoryFile;
                memoryFile.allowPurging(false);
            } catch (Exception e) {
                str = "PcmBuffer:writeToFile:" + e.toString();
                str2 = "AEE";
            }
        }
        this.memFile.writeBytes(bArr, 0, (int) this.mTotalSize, bArr.length);
        this.mTotalSize += bArr.length;
        str = "mTotalSize : " + this.mTotalSize;
        str2 = "TAG";
        Log.e(str2, str);
    }

    public void beginRead() throws IOException {
        this.mReadOffset = 0;
        this.mTempAudio = null;
        if (this.mAudioInfo.size() > 0) {
            this.mTempAudio = this.mAudioInfo.get(0);
        }
    }

    public void deleteFile() {
        LogUtil.d("deleteFile");
        try {
            MemoryFile memoryFile = this.memFile;
            if (memoryFile != null) {
                memoryFile.close();
                this.memFile = null;
            }
        } catch (Exception e) {
            LogUtil.e(e);
        }
    }

    public void finalize() throws Throwable {
        deleteFile();
        super.finalize();
    }

    public boolean getEndWithNull() {
        return this.mEndWithNull;
    }

    public int getMemFileLenth() {
        MemoryFile memoryFile = this.memFile;
        if (memoryFile != null) {
            return memoryFile.length();
        }
        return 0;
    }

    public C0674a getPalyAudioInfo() {
        if (this.mTempAudio == null) {
            return null;
        }
        long j = this.mReadOffset - (this.mBufLen - this.mBufOffset);
        C0674a c0674a = this.mTempAudio;
        if (j >= c0674a.b && j <= c0674a.c) {
            return c0674a;
        }
        synchronized (this.mAudioInfo) {
            try {
                Iterator<C0674a> it = this.mAudioInfo.iterator();
                while (it.hasNext()) {
                    C0674a next = it.next();
                    this.mTempAudio = next;
                    if (j >= next.b && j <= next.c) {
                        return next;
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public int getPlayPercent() {
        if (this.mTotalSize <= 0) {
            return 0;
        }
        return (int) (((this.mReadOffset - (this.mBufLen - this.mBufOffset)) * this.mPercent) / this.mTotalSize);
    }

    public int getRate() {
        return this.mRate;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    public boolean hasMoreBuffer(int i) {
        return ((long) i) <= ((this.mTotalSize - ((long) this.mReadOffset)) + ((long) this.mBufLen)) - ((long) this.mBufOffset);
    }

    public boolean isBufferingFinished() {
        return ((long) this.mProcScale) == this.mPercent;
    }

    public boolean isOver() {
        return ((long) this.mProcScale) == this.mPercent && ((long) this.mReadOffset) >= this.mTotalSize && this.mBufOffset >= this.mBufLen;
    }

    public boolean playAble() {
        return ((long) this.mReadOffset) < this.mTotalSize || this.mBufOffset < this.mBufLen;
    }

    public boolean readyToPlay(int i) {
        if (((float) this.mPercent) > this.mProcScale * 0.95f) {
            return true;
        }
        return this.mTotalSize / 32 >= ((long) i) && 0 < this.mTotalSize;
    }

    public boolean renameToLocal(String str) {
        LogUtil.d("save to local: format = " + str + " totalSize = " + this.mTotalSize + " maxSize=" + this.mMaxFileSize);
        if (FileUtil.saveFile(this.memFile, this.mTotalSize, this.mLocal_save_path)) {
            return FileUtil.formatPcm(str, this.mLocal_save_path, getRate());
        }
        return false;
    }

    public void reset(Context context, int i, int i2, String str, int i3) {
        this.mContext = context;
        this.mPercent = 0L;
        this.mAudioInfo = new ArrayList<>();
        this.mTotalSize = 0L;
        this.mRate = i;
        this.mLocal_save_path = str;
        this.mProcScale = i3;
        this.mReadOffset = 0;
        this.mBufOffset = 0;
        this.mBufLen = 0;
        this.mMaxFileSize = (this.mRate * 2 * i2) + 1920000;
        LogUtil.d("min audio seconds: " + i2 + ", max audio buf size: " + this.mMaxFileSize);
    }

    public void setAudioTrackBuffSize(int i) {
        this.audioTrackBuffSize = i;
    }

    public void setEndWithNull(boolean z) {
        this.mEndWithNull = z;
    }

    public void setMaxFileSize(int i) {
        this.mMaxFileSize = i;
    }

    public void setPercent(int i) {
        if (i < 0 || i > this.mProcScale) {
            return;
        }
        this.mPercent = i;
    }

    public void writeBuffer(ConcurrentLinkedQueue<byte[]> concurrentLinkedQueue) throws IOException {
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator<byte[]> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            writeToFile(it.next());
        }
    }

    public boolean writeStream(ArrayList<byte[]> arrayList, int i, int i2, int i3) {
        boolean z = false;
        try {
            LogUtil.i("buffer percent = " + i + ", beg=" + i2 + ", end=" + i3);
            C0674a c0674a = new C0674a(this.mTotalSize, this.mTotalSize, i2, i3);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                writeToFile(arrayList.get(i4));
            }
            c0674a.c = this.mTotalSize;
            this.mPercent = i;
            synchronized (this.mAudioInfo) {
                this.mAudioInfo.add(c0674a);
            }
            z = true;
        } catch (IOException e) {
            LogUtil.i(e.getMessage() + " ");
            e.printStackTrace();
        }
        LogUtil.i("allSize = " + this.mTotalSize + " maxSize=" + this.mMaxFileSize);
        return z;
    }

    public void writeTrack(AudioTrack audioTrack, int i) throws IOException {
        if (this.mBufOffset >= this.mBufLen) {
            readAudio(i);
        }
        int i2 = i * 2;
        int i3 = this.mBufLen;
        int i4 = this.mBufOffset;
        int i5 = i3 - i4;
        if (i2 <= i5) {
            i5 = i;
        }
        audioTrack.write(this.mAudioBuf, i4, i5);
        this.mBufOffset += i5;
        if (isOver() && getEndWithNull()) {
            writeTrackBlankBlock(audioTrack, i);
        }
    }

    public void writeTrackBlankBlock(AudioTrack audioTrack, int i) {
        long j = this.mTotalSize;
        long j2 = this.audioTrackBuffSize;
        if (j < j2) {
            int i2 = (int) (j2 - this.mTotalSize);
            LogUtil.i("mBuffer.writeTrack writeTrackBlankBlock size: " + i2);
            audioTrack.write(new byte[i2], 0, i2);
        }
    }
}
