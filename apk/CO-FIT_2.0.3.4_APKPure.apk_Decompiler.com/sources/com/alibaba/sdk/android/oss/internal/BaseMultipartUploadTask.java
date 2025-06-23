package com.alibaba.sdk.android.oss.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected final int PART_SIZE_ALIGN_NUM;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected Uri mUploadUri;
    protected long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        int i = availableProcessors < 5 ? availableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = availableProcessors;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0;
        boolean z = false;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES ? true : z;
        if (request.getThreadNum() != null && request.getThreadNum().intValue() > 0) {
            i = request.getThreadNum().intValue();
            availableProcessors = request.getThreadNum().intValue();
        }
        this.mPoolExecutor = new ThreadPoolExecutor(i, availableProcessors, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
    }

    public abstract void abortThisUpload();

    public long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, Boolean.TRUE);
        }
    }

    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            } else if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            } else if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            } else {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
        }
    }

    public void checkInitData() throws ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0;
            File file = new File(this.mUploadFilePath);
            this.mUploadFile = file;
            this.mFileLength = file.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                parcelFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                this.mFileLength = parcelFileDescriptor.getStatSize();
                try {
                    parcelFileDescriptor.close();
                } catch (IOException e) {
                    OSSLog.logThrowable2Local(e);
                }
            } catch (IOException e2) {
                throw new ClientException(e2.getMessage(), e2, Boolean.TRUE);
            } catch (Throwable th) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (IOException e3) {
                        OSSLog.logThrowable2Local(e3);
                    }
                }
                throw th;
            }
        }
        if (this.mFileLength != 0) {
            checkPartSize(this.mPartAttr);
            long partSize = this.mRequest.getPartSize();
            int i = this.mPartAttr[1];
            OSSLog.logDebug("[checkInitData] - partNumber : " + i);
            OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
            if (i > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
                throw new ClientException("Part size must be greater than or equal to 100KB!");
            }
            return;
        }
        throw new ClientException("file length must not be 0");
    }

    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        long j2 = j / partSize;
        long j3 = 1;
        if (j % partSize != 0) {
            j2++;
        }
        if (j2 == 1) {
            partSize = j;
        } else if (j2 > ((long) 5000)) {
            partSize = ceilPartSize(j / ((long) 4999));
            long j4 = this.mFileLength;
            long j5 = j4 / partSize;
            if (j4 % partSize == 0) {
                j3 = 0;
            }
            j2 = j5 + j3;
        }
        int i = (int) partSize;
        iArr[0] = i;
        iArr[1] = (int) j2;
        this.mRequest.setPartSize((long) i);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i);
        long j6 = this.mFileLength % partSize;
        if (j6 != 0) {
            partSize = j6;
        }
        this.mLastPartSize = partSize;
    }

    public boolean checkWaitCondition(int i) {
        if (this.mPartETags.size() == i) {
            return false;
        }
        return true;
    }

    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() {
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            if (this.mRequest.getMetadata() != null) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                for (String next : this.mRequest.getMetadata().getRawMetadata().keySet()) {
                    if (!next.equals(OSSHeaders.STORAGE_CLASS)) {
                        objectMetadata.setHeader(next, this.mRequest.getMetadata().getRawMetadata().get(next));
                    }
                }
                completeMultipartUploadRequest.setMetadata(objectMetadata);
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0;
        return completeMultipartUploadResult;
    }

    public abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    public abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }

    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    public abstract void processException(Exception exc);

    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0178 A[Catch:{ IOException -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017d A[Catch:{ IOException -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x015e A[SYNTHETIC, Splitter:B:90:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0163 A[Catch:{ IOException -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0168 A[Catch:{ IOException -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0170 A[SYNTHETIC, Splitter:B:99:0x0170] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r12, int r13, int r14) {
        /*
            r11 = this;
            r2 = 0
            com.alibaba.sdk.android.oss.network.ExecutionContext r3 = r11.mContext     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r3 = r3.getCancellationHandler()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            boolean r3 = r3.isCancelled()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            if (r3 == 0) goto L_0x0022
            java.util.concurrent.ThreadPoolExecutor r0 = r11.mPoolExecutor     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            java.util.concurrent.BlockingQueue r0 = r0.getQueue()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            r0.clear()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            return
        L_0x0017:
            r0 = move-exception
            r1 = r0
            r8 = r2
            r9 = r8
            goto L_0x016e
        L_0x001d:
            r0 = move-exception
            r8 = r2
            r9 = r8
            goto L_0x0159
        L_0x0022:
            java.lang.Object r3 = r11.mLock     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            monitor-enter(r3)     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            int r4 = r11.mRunPartTaskCount     // Catch:{ all -> 0x0156 }
            int r4 = r4 + 1
            r11.mRunPartTaskCount = r4     // Catch:{ all -> 0x0156 }
            monitor-exit(r3)     // Catch:{ all -> 0x0156 }
            r11.preUploadPart(r12, r13, r14)     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            byte[] r3 = new byte[r13]     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            long r4 = (long) r12     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            Request r6 = r11.mRequest     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            long r7 = r6.getPartSize()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            long r4 = r4 * r7
            android.net.Uri r6 = r11.mUploadUri     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            r7 = 0
            if (r6 == 0) goto L_0x0070
            com.alibaba.sdk.android.oss.network.ExecutionContext r6 = r11.mContext     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            android.net.Uri r8 = r11.mUploadUri     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            java.io.InputStream r6 = r6.openInputStream(r8)     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x006d, all -> 0x0069 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x006d, all -> 0x0069 }
            r8.skip(r4)     // Catch:{ Exception -> 0x0064, all -> 0x005e }
            r8.read(r3, r7, r13)     // Catch:{ Exception -> 0x0064, all -> 0x005e }
            r7 = r2
            r9 = r8
            r8 = r6
            goto L_0x0082
        L_0x005e:
            r0 = move-exception
            r1 = r0
            r9 = r8
        L_0x0061:
            r8 = r6
            goto L_0x016e
        L_0x0064:
            r0 = move-exception
            r9 = r8
        L_0x0066:
            r8 = r6
            goto L_0x0159
        L_0x0069:
            r0 = move-exception
            r1 = r0
            r9 = r2
            goto L_0x0061
        L_0x006d:
            r0 = move-exception
            r9 = r2
            goto L_0x0066
        L_0x0070:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            java.io.File r8 = r11.mUploadFile     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            java.lang.String r9 = "r"
            r6.<init>(r8, r9)     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
            r6.seek(r4)     // Catch:{ Exception -> 0x0151, all -> 0x014b }
            r6.readFully(r3, r7, r13)     // Catch:{ Exception -> 0x0151, all -> 0x014b }
            r8 = r2
            r9 = r8
            r7 = r6
        L_0x0082:
            com.alibaba.sdk.android.oss.model.UploadPartRequest r2 = new com.alibaba.sdk.android.oss.model.UploadPartRequest     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            Request r4 = r11.mRequest     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r4 = r4.getBucketName()     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            Request r5 = r11.mRequest     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r5 = r5.getObjectKey()     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r6 = r11.mUploadId     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            int r0 = r12 + 1
            r2.<init>(r4, r5, r6, r0)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            r2.setPartContent(r3)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5((byte[]) r3)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            r2.setMd5Digest(r0)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            Request r0 = r11.mRequest     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            java.lang.Enum r0 = r0.getCRC64()     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            r2.setCRC64(r0)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r0 = r11.mApiOperation     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            com.alibaba.sdk.android.oss.model.UploadPartResult r0 = r0.syncUploadPart(r2)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            java.lang.Object r10 = r11.mLock     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            monitor-enter(r10)     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
            com.alibaba.sdk.android.oss.model.PartETag r3 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x00d4 }
            int r2 = r2.getPartNumber()     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r0.getETag()     // Catch:{ all -> 0x00d4 }
            r3.<init>(r2, r4)     // Catch:{ all -> 0x00d4 }
            long r1 = (long) r13     // Catch:{ all -> 0x00d4 }
            r3.setPartSize(r1)     // Catch:{ all -> 0x00d4 }
            boolean r4 = r11.mCheckCRC64     // Catch:{ all -> 0x00d4 }
            if (r4 == 0) goto L_0x00d7
            java.lang.Long r0 = r0.getClientCRC()     // Catch:{ all -> 0x00d4 }
            long r4 = r0.longValue()     // Catch:{ all -> 0x00d4 }
            r3.setCRC64(r4)     // Catch:{ all -> 0x00d4 }
            goto L_0x00d7
        L_0x00d4:
            r0 = move-exception
            goto L_0x0142
        L_0x00d7:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r11.mPartETags     // Catch:{ all -> 0x00d4 }
            r0.add(r3)     // Catch:{ all -> 0x00d4 }
            long r4 = r11.mUploadedLength     // Catch:{ all -> 0x00d4 }
            long r4 = r4 + r1
            r11.mUploadedLength = r4     // Catch:{ all -> 0x00d4 }
            r11.uploadPartFinish(r3)     // Catch:{ all -> 0x00d4 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r11.mContext     // Catch:{ all -> 0x00d4 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()     // Catch:{ all -> 0x00d4 }
            boolean r0 = r0.isCancelled()     // Catch:{ all -> 0x00d4 }
            if (r0 == 0) goto L_0x0111
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r11.mPartETags     // Catch:{ all -> 0x00d4 }
            int r0 = r0.size()     // Catch:{ all -> 0x00d4 }
            int r1 = r11.mRunPartTaskCount     // Catch:{ all -> 0x00d4 }
            int r2 = r11.mPartExceptionCount     // Catch:{ all -> 0x00d4 }
            int r1 = r1 - r2
            if (r0 == r1) goto L_0x00fe
            goto L_0x012a
        L_0x00fe:
            com.alibaba.sdk.android.oss.TaskCancelException r0 = new com.alibaba.sdk.android.oss.TaskCancelException     // Catch:{ all -> 0x00d4 }
            java.lang.String r1 = "multipart cancel"
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x00d4 }
            com.alibaba.sdk.android.oss.ClientException r1 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x00d4 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d4 }
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x00d4 }
            throw r1     // Catch:{ all -> 0x00d4 }
        L_0x0111:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r11.mPartETags     // Catch:{ all -> 0x00d4 }
            int r0 = r0.size()     // Catch:{ all -> 0x00d4 }
            int r1 = r11.mPartExceptionCount     // Catch:{ all -> 0x00d4 }
            int r1 = r14 - r1
            if (r0 != r1) goto L_0x0120
            r11.notifyMultipartThread()     // Catch:{ all -> 0x00d4 }
        L_0x0120:
            Request r2 = r11.mRequest     // Catch:{ all -> 0x00d4 }
            long r3 = r11.mUploadedLength     // Catch:{ all -> 0x00d4 }
            long r5 = r11.mFileLength     // Catch:{ all -> 0x00d4 }
            r1 = r11
            r1.onProgressCallback(r2, r3, r5)     // Catch:{ all -> 0x00d4 }
        L_0x012a:
            monitor-exit(r10)     // Catch:{ all -> 0x00d4 }
            if (r7 == 0) goto L_0x0133
            r7.close()     // Catch:{ IOException -> 0x0131 }
            goto L_0x0133
        L_0x0131:
            r0 = move-exception
            goto L_0x013e
        L_0x0133:
            if (r9 == 0) goto L_0x0138
            r9.close()     // Catch:{ IOException -> 0x0131 }
        L_0x0138:
            if (r8 == 0) goto L_0x016b
            r8.close()     // Catch:{ IOException -> 0x0131 }
            goto L_0x016b
        L_0x013e:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)
            goto L_0x016b
        L_0x0142:
            monitor-exit(r10)     // Catch:{ all -> 0x00d4 }
            throw r0     // Catch:{ Exception -> 0x0148, all -> 0x0144 }
        L_0x0144:
            r0 = move-exception
            r1 = r0
            r2 = r7
            goto L_0x016e
        L_0x0148:
            r0 = move-exception
            r2 = r7
            goto L_0x0159
        L_0x014b:
            r0 = move-exception
            r1 = r0
            r8 = r2
            r9 = r8
            r2 = r6
            goto L_0x016e
        L_0x0151:
            r0 = move-exception
            r8 = r2
            r9 = r8
            r2 = r6
            goto L_0x0159
        L_0x0156:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0156 }
            throw r0     // Catch:{ Exception -> 0x001d, all -> 0x0017 }
        L_0x0159:
            r11.processException(r0)     // Catch:{ all -> 0x016c }
            if (r2 == 0) goto L_0x0161
            r2.close()     // Catch:{ IOException -> 0x0131 }
        L_0x0161:
            if (r9 == 0) goto L_0x0166
            r9.close()     // Catch:{ IOException -> 0x0131 }
        L_0x0166:
            if (r8 == 0) goto L_0x016b
            r8.close()     // Catch:{ IOException -> 0x0131 }
        L_0x016b:
            return
        L_0x016c:
            r0 = move-exception
            r1 = r0
        L_0x016e:
            if (r2 == 0) goto L_0x0176
            r2.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x0176
        L_0x0174:
            r0 = move-exception
            goto L_0x0181
        L_0x0176:
            if (r9 == 0) goto L_0x017b
            r9.close()     // Catch:{ IOException -> 0x0174 }
        L_0x017b:
            if (r8 == 0) goto L_0x0184
            r8.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x0184
        L_0x0181:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)
        L_0x0184:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    public void uploadPartFinish(PartETag partETag) throws Exception {
    }

    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, (ClientException) null, e);
            }
            throw e;
        } catch (Exception e2) {
            if (e2 instanceof ClientException) {
                clientException = (ClientException) e2;
            } else {
                clientException = new ClientException(e2.toString(), e2);
            }
            OSSCompletedCallback<Request, Result> oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, (ServiceException) null);
            }
            throw clientException;
        }
    }
}
