package com.aliyun.sls.android.producer;

import XI0IXoo.II0xO0;
import XI0IXoo.oIX0oI;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LogProducerClient {
    private final long client;
    private final LogProducerConfig config;
    private boolean enable;
    private final long producer;

    public LogProducerClient(LogProducerConfig logProducerConfig) throws LogProducerException {
        this(logProducerConfig, null);
    }

    private static native long create_log_producer(long j, LogProducerCallback logProducerCallback);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroy_log_producer(long j);

    private static native long get_log_producer_client(long j);

    private static native int log_producer_client_add_log_with_len(long j, long j2, int i, String[] strArr, String[] strArr2, int i2);

    private static native int log_producer_client_add_log_with_len_time_int32(long j, long j2, int i, byte[][] bArr, byte[][] bArr2);

    public LogProducerResult addLog(Log log) {
        return addLog(log, 0);
    }

    public LogProducerResult addLogRaw(byte[][] bArr, byte[][] bArr2) {
        if (this.enable && this.client != 0 && bArr != null && bArr2 != null) {
            return LogProducerResult.fromInt(log_producer_client_add_log_with_len_time_int32(this.client, new Log().getLogTime(), bArr.length, bArr, bArr2));
        }
        return LogProducerResult.LOG_PRODUCER_INVALID;
    }

    public void destroyLogProducer() {
        if (!this.enable) {
            return;
        }
        this.enable = false;
        oIX0oI.II0xO0(new Runnable() { // from class: com.aliyun.sls.android.producer.LogProducerClient.1
            @Override // java.lang.Runnable
            public void run() {
                LogProducerClient.destroy_log_producer(LogProducerClient.this.producer);
            }
        });
    }

    public LogProducerClient(LogProducerConfig logProducerConfig, LogProducerCallback logProducerCallback) throws LogProducerException {
        this.config = logProducerConfig;
        long create_log_producer = create_log_producer(logProducerConfig.getConfig(), logProducerCallback);
        this.producer = create_log_producer;
        if (create_log_producer != 0) {
            long j = get_log_producer_client(create_log_producer);
            this.client = j;
            if (j != 0) {
                String endpoint = logProducerConfig.getEndpoint();
                String project = logProducerConfig.getProject();
                if (!TextUtils.isEmpty(endpoint) && !TextUtils.isEmpty(project)) {
                    II0xO0.oxoX(logProducerConfig.getContext(), endpoint, project);
                }
                this.enable = true;
                return;
            }
            throw new LogProducerException("Can not create log producer client");
        }
        throw new LogProducerException("Can not create log producer");
    }

    public LogProducerResult addLog(Log log, int i) {
        if (this.enable && this.client != 0 && log != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(log.getContent());
            int size = linkedHashMap.size();
            String[] strArr = new String[size];
            String[] strArr2 = new String[size];
            int i2 = 0;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                strArr[i2] = str;
                String str3 = (String) entry.getValue();
                if (str3 != null) {
                    str2 = str3;
                }
                strArr2[i2] = str2;
                i2++;
            }
            return LogProducerResult.fromInt(log_producer_client_add_log_with_len(this.client, log.getLogTime(), size, strArr, strArr2, i));
        }
        return LogProducerResult.LOG_PRODUCER_INVALID;
    }
}
