package com.aliyun.sls.android.producer;

import X0IIOO.oIX0oI;
import XI0IXoo.I0Io;
import XI0IXoo.II0xO0;
import android.content.Context;
import android.text.TextUtils;
import com.aliyun.sls.android.producer.internal.LogProducerHttpHeaderInjector;

/* loaded from: classes.dex */
public class LogProducerConfig {
    private final long config;
    private final Context context;
    private boolean enablePersistent;
    private String endpoint;
    private String logstore;
    private String project;

    static {
        System.loadLibrary("sls_producer");
    }

    public LogProducerConfig() throws LogProducerException {
        this(I0Io.oIX0oI());
    }

    private static native long create_log_producer_config();

    private static native void log_producer_config_add_tag(long j, String str, String str2);

    private static native int log_producer_config_is_valid(long j);

    private static native void log_producer_config_reset_security_token(long j, String str, String str2, String str3);

    private static native void log_producer_config_set_access_id(long j, String str);

    private static native void log_producer_config_set_access_key(long j, String str);

    private static native void log_producer_config_set_callback_from_sender_thread(long j, int i);

    private static native void log_producer_config_set_compress_type(long j, int i);

    private static native void log_producer_config_set_connect_timeout_sec(long j, int i);

    private static native void log_producer_config_set_destroy_flusher_wait_sec(long j, int i);

    private static native void log_producer_config_set_destroy_sender_wait_sec(long j, int i);

    private static native void log_producer_config_set_drop_delay_log(long j, int i);

    private static native void log_producer_config_set_drop_unauthorized_log(long j, int i);

    private static native void log_producer_config_set_endpoint(long j, String str);

    private static native void log_producer_config_set_get_time_unix_func(LogProducerTimeUnixFunc logProducerTimeUnixFunc);

    private static native void log_producer_config_set_http_header_inject(long j, LogProducerHttpHeaderInjector logProducerHttpHeaderInjector);

    private static native void log_producer_config_set_logstore(long j, String str);

    private static native void log_producer_config_set_max_buffer_limit(long j, int i);

    private static native void log_producer_config_set_max_log_delay_time(long j, int i);

    private static native void log_producer_config_set_net_interface(long j, String str);

    private static native void log_producer_config_set_ntp_time_offset(long j, int i);

    private static native void log_producer_config_set_packet_log_bytes(long j, int i);

    private static native void log_producer_config_set_packet_log_count(long j, int i);

    private static native void log_producer_config_set_packet_timeout(long j, int i);

    private static native void log_producer_config_set_persistent(long j, int i);

    private static native void log_producer_config_set_persistent_file_path(long j, String str);

    private static native void log_producer_config_set_persistent_force_flush(long j, int i);

    private static native void log_producer_config_set_persistent_max_file_count(long j, int i);

    private static native void log_producer_config_set_persistent_max_file_size(long j, int i);

    private static native void log_producer_config_set_persistent_max_log_count(long j, int i);

    private static native void log_producer_config_set_project(long j, String str);

    private static native void log_producer_config_set_send_thread_count(long j, int i);

    private static native void log_producer_config_set_send_timeout_sec(long j, int i);

    private static native void log_producer_config_set_source(long j, String str);

    private static native void log_producer_config_set_topic(long j, String str);

    private static native void log_producer_config_set_use_webtracking(long j, int i);

    private static native void log_producer_config_set_using_http(long j, int i);

    private static native void log_producer_debug();

    private static native int log_producer_persistent_config_is_enabled(long j);

    public void addTag(String str, String str2) {
        log_producer_config_add_tag(this.config, str, str2);
    }

    public long getConfig() {
        return this.config;
    }

    public Context getContext() {
        return this.context;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getLogstore() {
        return this.logstore;
    }

    public String getProject() {
        return this.project;
    }

    public int isEnabled() {
        return log_producer_persistent_config_is_enabled(this.config);
    }

    public int isValid() {
        return log_producer_config_is_valid(this.config);
    }

    public void logProducerDebug() {
        log_producer_debug();
    }

    public void resetSecurityToken(String str, String str2, String str3) {
        log_producer_config_reset_security_token(this.config, str, str2, str3);
    }

    public void setAccessKeyId(String str) {
        log_producer_config_set_access_id(this.config, str);
    }

    public void setAccessKeySecret(String str) {
        log_producer_config_set_access_key(this.config, str);
    }

    public void setCallbackFromSenderThread(boolean z) {
        log_producer_config_set_callback_from_sender_thread(this.config, z ? 1 : 0);
    }

    public void setCompressType(int i) {
        log_producer_config_set_compress_type(this.config, i);
    }

    public void setConnectTimeoutSec(int i) {
        log_producer_config_set_connect_timeout_sec(this.config, i);
    }

    public void setDestroyFlusherWaitSec(int i) {
        log_producer_config_set_destroy_flusher_wait_sec(this.config, i);
    }

    public void setDestroySenderWaitSec(int i) {
        log_producer_config_set_destroy_sender_wait_sec(this.config, i);
    }

    public void setDropDelayLog(int i) {
        log_producer_config_set_drop_delay_log(this.config, i);
    }

    public void setDropUnauthorizedLog(int i) {
        log_producer_config_set_drop_unauthorized_log(this.config, i);
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
        log_producer_config_set_endpoint(this.config, str);
    }

    public void setGetTimeUnixFunc(LogProducerTimeUnixFunc logProducerTimeUnixFunc) {
        log_producer_config_set_get_time_unix_func(logProducerTimeUnixFunc);
    }

    public void setHttpHeaderInjector(LogProducerHttpHeaderInjector logProducerHttpHeaderInjector) {
        log_producer_config_set_http_header_inject(this.config, logProducerHttpHeaderInjector);
    }

    public void setLogstore(String str) {
        this.logstore = str;
        log_producer_config_set_logstore(this.config, str);
    }

    public void setMaxBufferLimit(int i) {
        log_producer_config_set_max_buffer_limit(this.config, i);
    }

    public void setMaxLogDelayTime(int i) {
        log_producer_config_set_max_log_delay_time(this.config, i);
    }

    public void setNetInterface(String str) {
        log_producer_config_set_net_interface(this.config, str);
    }

    public void setNtpTimeOffset(int i) {
        log_producer_config_set_ntp_time_offset(this.config, i);
    }

    public void setPacketLogBytes(int i) {
        log_producer_config_set_packet_log_bytes(this.config, i);
    }

    public void setPacketLogCount(int i) {
        log_producer_config_set_packet_log_count(this.config, i);
    }

    public void setPacketTimeout(int i) {
        log_producer_config_set_packet_timeout(this.config, i);
    }

    public void setPersistent(int i) {
        boolean z;
        if (1 == i) {
            z = true;
        } else {
            z = false;
        }
        this.enablePersistent = z;
        log_producer_config_set_persistent(this.config, i);
        if (this.enablePersistent) {
            setSendThreadCount(1);
        }
    }

    public void setPersistentFilePath(String str) {
        log_producer_config_set_persistent_file_path(this.config, str);
    }

    public void setPersistentForceFlush(int i) {
        log_producer_config_set_persistent_force_flush(this.config, i);
    }

    public void setPersistentMaxFileCount(int i) {
        log_producer_config_set_persistent_max_file_count(this.config, i);
    }

    public void setPersistentMaxFileSize(int i) {
        log_producer_config_set_persistent_max_file_size(this.config, i);
    }

    public void setPersistentMaxLogCount(int i) {
        log_producer_config_set_persistent_max_log_count(this.config, i);
    }

    public void setProject(String str) {
        this.project = str;
        log_producer_config_set_project(this.config, str);
    }

    public void setSendThreadCount(int i) {
        if (this.enablePersistent && 1 != i) {
            i = 1;
        }
        log_producer_config_set_send_thread_count(this.config, i);
    }

    public void setSendTimeoutSec(int i) {
        log_producer_config_set_send_timeout_sec(this.config, i);
    }

    public void setSource(String str) {
        log_producer_config_set_source(this.config, str);
    }

    public void setTopic(String str) {
        log_producer_config_set_topic(this.config, str);
    }

    public void setUseWebtracking(boolean z) {
        log_producer_config_set_use_webtracking(this.config, z ? 1 : 0);
    }

    public void setUsingHttp(int i) {
        log_producer_config_set_using_http(this.config, i);
    }

    public LogProducerConfig(String str, String str2, String str3) throws LogProducerException {
        this(I0Io.oIX0oI(), str, str2, str3);
    }

    public LogProducerConfig(String str, String str2, String str3, String str4, String str5) throws LogProducerException {
        this(str, str2, str3, str4, str5, (String) null);
    }

    public LogProducerConfig(String str, String str2, String str3, String str4, String str5, String str6) throws LogProducerException {
        this(I0Io.oIX0oI(), str, str2, str3, str4, str5, str6);
    }

    public LogProducerConfig(Context context) throws LogProducerException {
        this(context, null, null, null);
    }

    public LogProducerConfig(Context context, String str, String str2, String str3) throws LogProducerException {
        this(context, str, str2, str3, (String) null, (String) null);
    }

    public LogProducerConfig(Context context, String str, String str2, String str3, String str4, String str5) throws LogProducerException {
        this(context, str, str2, str3, str4, str5, null);
    }

    public LogProducerConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6) throws LogProducerException {
        this.enablePersistent = false;
        this.context = context;
        long create_log_producer_config = create_log_producer_config();
        this.config = create_log_producer_config;
        if (create_log_producer_config != 0) {
            setSource("Android");
            setPacketTimeout(3000);
            setPacketLogCount(1024);
            setPacketLogBytes(1048576);
            setSendThreadCount(1);
            setDropUnauthorizedLog(0);
            setDropDelayLog(0);
            setGetTimeUnixFunc(new LogProducerTimeUnixFunc() { // from class: com.aliyun.sls.android.producer.LogProducerConfig.1
                @Override // com.aliyun.sls.android.producer.LogProducerTimeUnixFunc
                public long getTimeUnix() {
                    return II0xO0.II0xO0();
                }
            });
            setHttpHeaderInjector(new LogProducerHttpHeaderInjector() { // from class: com.aliyun.sls.android.producer.LogProducerConfig.2
                @Override // com.aliyun.sls.android.producer.internal.LogProducerHttpHeaderInjector
                public String[] injectHeaders(String[] strArr, int i) {
                    return oIX0oI.oIX0oI(strArr, new String[0]);
                }
            });
            setEndpoint(str);
            setProject(str2);
            setLogstore(str3);
            setAccessKeyId(str4);
            setAccessKeySecret(str5);
            if (TextUtils.isEmpty(str6)) {
                return;
            }
            resetSecurityToken(str4, str5, str6);
            return;
        }
        throw new LogProducerException("Can not create log producer config");
    }
}
