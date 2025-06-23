package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class ResumableUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private ResumableUploadRequest.ExceptionTerminationMode exceptionTerminationMode;
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.exceptionTerminationMode = resumableUploadRequest.getExceptionTerminationMode();
    }

    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), (OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult>) null).waitUntilFinished();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkException() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException {
        /*
            r6 = this;
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r6.mContext
            com.alibaba.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()
            boolean r0 = r0.isCancelled()
            if (r0 == 0) goto L_0x00c6
            Request r0 = r6.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.Boolean r0 = r0.deleteUploadOnCancelling()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0026
            r6.abortThisUpload()
            java.io.File r0 = r6.mRecordFile
            if (r0 == 0) goto L_0x00c6
            r0.delete()
            goto L_0x00c6
        L_0x0026:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r0 = r6.mPartETags
            if (r0 == 0) goto L_0x00c6
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00c6
            boolean r0 = r6.mCheckCRC64
            if (r0 == 0) goto L_0x00c6
            Request r0 = r6.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            if (r0 == 0) goto L_0x00c6
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r1 = r6.mPartETags
            java.util.Iterator r1 = r1.iterator()
        L_0x0049:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r1.next()
            com.alibaba.sdk.android.oss.model.PartETag r2 = (com.alibaba.sdk.android.oss.model.PartETag) r2
            int r3 = r2.getPartNumber()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            long r4 = r2.getCRC64()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r0.put(r3, r2)
            goto L_0x0049
        L_0x0069:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009d }
            r2.<init>()     // Catch:{ IOException -> 0x009d }
            Request r3 = r6.mRequest     // Catch:{ IOException -> 0x009d }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3     // Catch:{ IOException -> 0x009d }
            java.lang.String r3 = r3.getRecordDirectory()     // Catch:{ IOException -> 0x009d }
            r2.append(r3)     // Catch:{ IOException -> 0x009d }
            java.lang.String r3 = java.io.File.separator     // Catch:{ IOException -> 0x009d }
            r2.append(r3)     // Catch:{ IOException -> 0x009d }
            java.lang.String r3 = r6.mUploadId     // Catch:{ IOException -> 0x009d }
            r2.append(r3)     // Catch:{ IOException -> 0x009d }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x009d }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x009d }
            r3.<init>(r2)     // Catch:{ IOException -> 0x009d }
            r6.mCRC64RecordFile = r3     // Catch:{ IOException -> 0x009d }
            boolean r2 = r3.exists()     // Catch:{ IOException -> 0x009d }
            if (r2 != 0) goto L_0x009f
            java.io.File r2 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x009d }
            r2.createNewFile()     // Catch:{ IOException -> 0x009d }
            goto L_0x009f
        L_0x009b:
            r0 = move-exception
            goto L_0x00c0
        L_0x009d:
            r0 = move-exception
            goto L_0x00b7
        L_0x009f:
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x009d }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009d }
            java.io.File r4 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x009d }
            r3.<init>(r4)     // Catch:{ IOException -> 0x009d }
            r2.<init>(r3)     // Catch:{ IOException -> 0x009d }
            r2.writeObject(r0)     // Catch:{ IOException -> 0x00b5, all -> 0x00b2 }
            r2.close()
            goto L_0x00c6
        L_0x00b2:
            r0 = move-exception
            r1 = r2
            goto L_0x00c0
        L_0x00b5:
            r0 = move-exception
            r1 = r2
        L_0x00b7:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x00c6
            r1.close()
            goto L_0x00c6
        L_0x00c0:
            if (r1 == 0) goto L_0x00c5
            r1.close()
        L_0x00c5:
            throw r0
        L_0x00c6:
            super.checkException()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableUploadTask.checkException():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.util.Map} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0325, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x032e, code lost:
        r1.mUploadId = null;
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0340, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0213, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0216, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0217, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02a2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02a3, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02a5, code lost:
        r5 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02a9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02aa, code lost:
        r20 = r5;
        r19 = r6;
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02eb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0338 A[LOOP:0: B:42:0x0187->B:107:0x0338, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0340 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0341 A[EDGE_INSN: B:123:0x0341->B:109:0x0341 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01cd A[Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0213 A[ExcHandler: ClientException (r0v47 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:46:0x01ad] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "[initUploadId] -  "
            Request r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            r3 = 0
            if (r0 != 0) goto L_0x0374
            android.net.Uri r0 = r1.mUploadUri
            java.lang.String r4 = "[initUploadId] - mUploadFilePath : "
            if (r0 == 0) goto L_0x0056
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            android.net.Uri r4 = r1.mUploadUri
            java.lang.String r4 = r4.getPath()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r0)
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r1.mContext
            android.content.Context r0 = r0.getApplicationContext()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r4 = r1.mUploadUri
            java.lang.String r5 = "r"
            android.os.ParcelFileDescriptor r4 = r0.openFileDescriptor(r4, r5)
            java.io.FileDescriptor r0 = r4.getFileDescriptor()     // Catch:{ all -> 0x004f }
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((java.io.FileDescriptor) r0)     // Catch:{ all -> 0x004f }
            r4.close()
            goto L_0x0070
        L_0x004f:
            r0 = move-exception
            if (r4 == 0) goto L_0x0055
            r4.close()
        L_0x0055:
            throw r0
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r4 = r1.mUploadFilePath
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r0)
            java.lang.String r0 = r1.mUploadFilePath
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((java.lang.String) r0)
        L_0x0070:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[initUploadId] - mRequest.getPartSize() : "
            r4.append(r5)
            Request r5 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r5 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r5
            long r5 = r5.getPartSize()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            Request r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getBucketName()
            r4.append(r0)
            Request r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getObjectKey()
            r4.append(r0)
            Request r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            long r5 = r0.getPartSize()
            java.lang.String r0 = java.lang.String.valueOf(r5)
            r4.append(r0)
            boolean r0 = r1.mCheckCRC64
            if (r0 == 0) goto L_0x00c0
            java.lang.String r0 = "-crc64"
            goto L_0x00c2
        L_0x00c0:
            java.lang.String r0 = ""
        L_0x00c2:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            byte[] r0 = r0.getBytes()
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((byte[]) r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            Request r5 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r5 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r5
            java.lang.String r5 = r5.getRecordDirectory()
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            r1.mRecordFile = r4
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x010f
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.FileReader r4 = new java.io.FileReader
            java.io.File r6 = r1.mRecordFile
            r4.<init>(r6)
            r0.<init>(r4)
            java.lang.String r4 = r0.readLine()
            r1.mUploadId = r4
            r0.close()
        L_0x010f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "[initUploadId] - mUploadId : "
            r0.append(r4)
            java.lang.String r4 = r1.mUploadId
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r0)
            java.lang.String r0 = r1.mUploadId
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 != 0) goto L_0x0341
            boolean r0 = r1.mCheckCRC64
            if (r0 == 0) goto L_0x0184
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            Request r4 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r4 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r4
            java.lang.String r4 = r4.getRecordDirectory()
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = r1.mUploadId
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0184
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r4)
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream
            r5.<init>(r0)
            java.lang.Object r0 = r5.readObject()     // Catch:{ ClassNotFoundException -> 0x0177 }
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ ClassNotFoundException -> 0x0177 }
            r4.delete()     // Catch:{ ClassNotFoundException -> 0x0175 }
        L_0x016c:
            r5.close()
            r4.delete()
            goto L_0x0185
        L_0x0173:
            r0 = move-exception
            goto L_0x017d
        L_0x0175:
            r0 = move-exception
            goto L_0x0179
        L_0x0177:
            r0 = move-exception
            r6 = r3
        L_0x0179:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)     // Catch:{ all -> 0x0173 }
            goto L_0x016c
        L_0x017d:
            r5.close()
            r4.delete()
            throw r0
        L_0x0184:
            r6 = r3
        L_0x0185:
            r4 = 0
            r5 = 0
        L_0x0187:
            com.alibaba.sdk.android.oss.model.ListPartsRequest r0 = new com.alibaba.sdk.android.oss.model.ListPartsRequest
            Request r7 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r7 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r7
            java.lang.String r7 = r7.getBucketName()
            Request r8 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r8 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r8
            java.lang.String r8 = r8.getObjectKey()
            java.lang.String r9 = r1.mUploadId
            r0.<init>(r7, r8, r9)
            if (r5 <= 0) goto L_0x01a7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r0.setPartNumberMarker(r7)
        L_0x01a7:
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r7 = r1.mApiOperation
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r7 = r7.listParts(r0, r3)
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r7.getResult()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            com.alibaba.sdk.android.oss.model.ListPartsResult r0 = (com.alibaba.sdk.android.oss.model.ListPartsResult) r0     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            boolean r8 = r0.isTruncated()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            int r5 = r0.getNextPartNumberMarker()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            java.util.List r0 = r0.getParts()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            int[] r9 = r1.mPartAttr     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r10 = r9[r4]     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r11 = 1
            r9 = r9[r11]     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r12 = 0
        L_0x01c7:
            int r13 = r0.size()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            if (r12 >= r13) goto L_0x031e
            java.lang.Object r13 = r0.get(r12)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            com.alibaba.sdk.android.oss.model.PartSummary r13 = (com.alibaba.sdk.android.oss.model.PartSummary) r13     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            com.alibaba.sdk.android.oss.model.PartETag r14 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            int r15 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            java.lang.String r4 = r13.getETag()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r14.<init>(r15, r4)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            long r3 = r13.getSize()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r14.setPartSize(r3)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            if (r6 == 0) goto L_0x021d
            int r3 = r6.size()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            if (r3 <= 0) goto L_0x021d
            int r3 = r14.getPartNumber()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            boolean r3 = r6.containsKey(r3)     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            if (r3 == 0) goto L_0x021d
            int r3 = r14.getPartNumber()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            long r3 = r3.longValue()     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            r14.setCRC64(r3)     // Catch:{ ServiceException -> 0x0216, ClientException -> 0x0213 }
            goto L_0x021d
        L_0x0213:
            r0 = move-exception
            goto L_0x0325
        L_0x0216:
            r0 = move-exception
            r17 = r2
        L_0x0219:
            r19 = r6
            goto L_0x0326
        L_0x021d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.<init>()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.append(r2)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.append(r12)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            java.lang.String r4 = " part.getPartNumber() : "
            r3.append(r4)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            int r4 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.append(r4)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            java.lang.String r3 = r3.toString()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r3)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.<init>()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.append(r2)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.append(r12)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            java.lang.String r4 = " part.getSize() : "
            r3.append(r4)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r16 = r12
            long r11 = r13.getSize()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            r3.append(r11)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            java.lang.String r3 = r3.toString()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r3)     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            int r3 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x0317, ClientException -> 0x0213 }
            if (r3 != r9) goto L_0x0263
            r3 = 1
            goto L_0x0264
        L_0x0263:
            r3 = 0
        L_0x0264:
            java.lang.String r11 = " or lastPartSize : "
            java.lang.String r12 = " setting is inconsistent with PartSize : "
            java.lang.String r4 = "current part size "
            if (r3 == 0) goto L_0x02b2
            long r17 = r13.getSize()     // Catch:{ ServiceException -> 0x02a9, ClientException -> 0x0213 }
            r20 = r5
            r19 = r6
            long r5 = r1.mLastPartSize     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            int r21 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r21 != 0) goto L_0x027b
            goto L_0x02b6
        L_0x027b:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.<init>()     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.append(r4)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            long r4 = r13.getSize()     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.append(r4)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.append(r12)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.append(r10)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.append(r11)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            long r4 = r1.mLastPartSize     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r3.append(r4)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            java.lang.String r3 = r3.toString()     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r0.<init>((java.lang.String) r3)     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            throw r0     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
        L_0x02a2:
            r0 = move-exception
            r17 = r2
        L_0x02a5:
            r5 = r20
            goto L_0x0326
        L_0x02a9:
            r0 = move-exception
            r20 = r5
            r19 = r6
            r17 = r2
            goto L_0x0326
        L_0x02b2:
            r20 = r5
            r19 = r6
        L_0x02b6:
            if (r3 != 0) goto L_0x02ed
            long r5 = r13.getSize()     // Catch:{ ServiceException -> 0x02a2, ClientException -> 0x0213 }
            r17 = r2
            long r2 = (long) r10
            int r18 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r18 != 0) goto L_0x02c4
            goto L_0x02ef
        L_0x02c4:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.<init>()     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.append(r4)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            long r3 = r13.getSize()     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.append(r3)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.append(r12)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.append(r10)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.append(r11)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            long r3 = r1.mLastPartSize     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.append(r3)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            java.lang.String r2 = r2.toString()     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r0.<init>((java.lang.String) r2)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            throw r0     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
        L_0x02eb:
            r0 = move-exception
            goto L_0x02a5
        L_0x02ed:
            r17 = r2
        L_0x02ef:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r2 = r1.mPartETags     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.add(r14)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            long r2 = r1.mUploadedLength     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            long r4 = r13.getSize()     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            long r2 = r2 + r4
            r1.mUploadedLength = r2     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            java.util.List<java.lang.Integer> r2 = r1.mAlreadyUploadIndex     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            int r3 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            r2.add(r3)     // Catch:{ ServiceException -> 0x02eb, ClientException -> 0x0213 }
            int r12 = r16 + 1
            r2 = r17
            r6 = r19
            r5 = r20
            r3 = 0
            r4 = 0
            r11 = 1
            goto L_0x01c7
        L_0x0317:
            r0 = move-exception
            r17 = r2
            r20 = r5
            goto L_0x0219
        L_0x031e:
            r17 = r2
            r20 = r5
            r19 = r6
            goto L_0x0332
        L_0x0325:
            throw r0
        L_0x0326:
            int r2 = r0.getStatusCode()
            r3 = 404(0x194, float:5.66E-43)
            if (r2 != r3) goto L_0x0340
            r2 = 0
            r1.mUploadId = r2
            r8 = 0
        L_0x0332:
            r7.waitUntilFinished()
            if (r8 != 0) goto L_0x0338
            goto L_0x0341
        L_0x0338:
            r2 = r17
            r6 = r19
            r3 = 0
            r4 = 0
            goto L_0x0187
        L_0x0340:
            throw r0
        L_0x0341:
            java.io.File r0 = r1.mRecordFile
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0374
            java.io.File r0 = r1.mRecordFile
            boolean r0 = r0.createNewFile()
            if (r0 == 0) goto L_0x0352
            goto L_0x0374
        L_0x0352:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't create file at path: "
            r2.append(r3)
            java.io.File r3 = r1.mRecordFile
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = "\nPlease make sure the directory exist!"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x0374:
            java.lang.String r0 = r1.mUploadId
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 == 0) goto L_0x03c4
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest r0 = new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest
            Request r2 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getBucketName()
            Request r3 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3
            java.lang.String r3 = r3.getObjectKey()
            Request r4 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r4 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r4
            com.alibaba.sdk.android.oss.model.ObjectMetadata r4 = r4.getMetadata()
            r0.<init>(r2, r3, r4)
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r2 = r1.mApiOperation
            r3 = 0
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r0 = r2.initMultipartUpload(r0, r3)
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r0.getResult()
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult r0 = (com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult) r0
            java.lang.String r0 = r0.getUploadId()
            r1.mUploadId = r0
            java.io.File r0 = r1.mRecordFile
            if (r0 == 0) goto L_0x03c4
            java.io.BufferedWriter r0 = new java.io.BufferedWriter
            java.io.FileWriter r2 = new java.io.FileWriter
            java.io.File r3 = r1.mRecordFile
            r2.<init>(r3)
            r0.<init>(r2)
            java.lang.String r2 = r1.mUploadId
            r0.write(r2)
            r0.close()
        L_0x03c4:
            Request r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r2 = r1.mUploadId
            r0.setUploadId(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableUploadTask.initMultipartUploadId():void");
    }

    public void processException(Exception exc) {
        synchronized (this.mLock) {
            try {
                this.mPartExceptionCount++;
                this.mUploadException = exc;
                OSSLog.logThrowable2Local(exc);
                if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                    this.mIsCancel = true;
                    this.mLock.notify();
                }
                if (this.exceptionTerminationMode == ResumableUploadRequest.ExceptionTerminationMode.EXCEPTION || this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                    notifyMultipartThread();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mSp.contains(this.mUploadId)) {
            this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
        }
    }

    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor;
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        final int i = iArr[0];
        final int i2 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long j2 = this.mUploadedLength;
            if (j2 <= this.mFileLength) {
                if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                    j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
                }
                long j3 = j2;
                OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
                if (oSSProgressCallback != null) {
                    oSSProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
                }
                this.mSp.removeKey(this.mUploadId);
            } else {
                throw new ClientException("The uploading file is inconsistent with before");
            }
        }
        this.mRunPartTaskCount = this.mPartETags.size();
        for (final int i3 = 0; i3 < i2; i3++) {
            if (this.exceptionTerminationMode == ResumableUploadRequest.ExceptionTerminationMode.EXCEPTION) {
                checkException();
            }
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) && (threadPoolExecutor = this.mPoolExecutor) != null) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                j += (long) i;
                threadPoolExecutor.execute(new Runnable() {
                    public void run() {
                        ResumableUploadTask.this.uploadPart(i3, i, i2);
                    }
                });
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new ResumableUploadResult(completeMultipartUploadResult) : null;
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        releasePool();
        return resumableUploadResult;
    }
}
