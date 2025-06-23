package com.alibaba.sdk.android.oss.internal;

import android.os.ParcelFileDescriptor;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ResumableDownloadRequest;
import com.alibaba.sdk.android.oss.model.ResumableDownloadResult;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class ExtensionRequestOperation {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() { // from class: com.alibaba.sdk.android.oss.internal.ExtensionRequestOperation.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "oss-android-extensionapi-thread");
        }
    });
    private InternalRequestOperation apiOperation;

    public ExtensionRequestOperation(InternalRequestOperation internalRequestOperation) {
        this.apiOperation = internalRequestOperation;
    }

    private void setCRC64(OSSRequest oSSRequest) {
        Enum r0;
        if (oSSRequest.getCRC64() != OSSRequest.CRC64Config.NULL) {
            r0 = oSSRequest.getCRC64();
        } else if (this.apiOperation.getConf().isCheckCRC64()) {
            r0 = OSSRequest.CRC64Config.YES;
        } else {
            r0 = OSSRequest.CRC64Config.NO;
        }
        oSSRequest.setCRC64(r0);
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) throws IOException {
        String str;
        boolean z;
        String str2;
        setCRC64(resumableUploadRequest);
        if (!OSSUtils.isEmptyString(resumableUploadRequest.getRecordDirectory())) {
            String uploadFilePath = resumableUploadRequest.getUploadFilePath();
            if (uploadFilePath != null) {
                str = BinaryUtil.calculateMd5Str(uploadFilePath);
            } else {
                ParcelFileDescriptor openFileDescriptor = this.apiOperation.getApplicationContext().getContentResolver().openFileDescriptor(resumableUploadRequest.getUploadUri(), "r");
                try {
                    String calculateMd5Str = BinaryUtil.calculateMd5Str(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    str = calculateMd5Str;
                } catch (Throwable th) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    throw th;
                }
            }
            Enum crc64 = resumableUploadRequest.getCRC64();
            OSSRequest.CRC64Config cRC64Config = OSSRequest.CRC64Config.YES;
            if (crc64 == cRC64Config) {
                z = true;
            } else {
                z = false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(resumableUploadRequest.getBucketName());
            sb.append(resumableUploadRequest.getObjectKey());
            sb.append(String.valueOf(resumableUploadRequest.getPartSize()));
            if (z) {
                str2 = "-crc64";
            } else {
                str2 = "";
            }
            sb.append(str2);
            File file = new File(resumableUploadRequest.getRecordDirectory() + "/" + BinaryUtil.calculateMd5Str(sb.toString().getBytes()));
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                OSSLog.logDebug("[initUploadId] - Found record file, uploadid: " + readLine);
                if (resumableUploadRequest.getCRC64() == cRC64Config) {
                    File file2 = new File(resumableUploadRequest.getRecordDirectory() + File.separator + readLine);
                    if (file2.exists()) {
                        file2.delete();
                    }
                }
                this.apiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(resumableUploadRequest.getBucketName(), resumableUploadRequest.getObjectKey(), readLine), null);
            }
            file.delete();
        }
    }

    public boolean doesObjectExist(String str, String str2) throws ClientException, ServiceException {
        try {
            this.apiOperation.headObject(new HeadObjectRequest(str, str2), null).getResult();
            return true;
        } catch (ServiceException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public OSSAsyncTask<CompleteMultipartUploadResult> multipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback<MultipartUploadRequest, CompleteMultipartUploadResult> oSSCompletedCallback) {
        setCRC64(multipartUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), multipartUploadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new MultipartUploadTask(this.apiOperation, multipartUploadRequest, oSSCompletedCallback, executionContext)), executionContext);
    }

    public OSSAsyncTask<ResumableDownloadResult> resumableDownload(ResumableDownloadRequest resumableDownloadRequest, OSSCompletedCallback<ResumableDownloadRequest, ResumableDownloadResult> oSSCompletedCallback) {
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), resumableDownloadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new ResumableDownloadTask(this.apiOperation, resumableDownloadRequest, oSSCompletedCallback, executionContext)), executionContext);
    }

    public OSSAsyncTask<ResumableUploadResult> resumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        setCRC64(resumableUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new ResumableUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, this.apiOperation)), executionContext);
    }

    public OSSAsyncTask<ResumableUploadResult> sequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback) {
        setCRC64(resumableUploadRequest);
        ExecutionContext executionContext = new ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest, this.apiOperation.getApplicationContext());
        return OSSAsyncTask.wrapRequestTask(executorService.submit(new SequenceUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, this.apiOperation)), executionContext);
    }
}
