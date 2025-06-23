package com.goodix.ble.libcomx.logger;

import com.goodix.ble.libcomx.ILogger;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.HashMap;
import oOo.OxxIIOOXO;

/* loaded from: classes9.dex */
public class PrefixedLogger implements ILogger {
    private ILogger output;
    private HashMap<String, String> tagCache;
    private String tagDelimiter;
    private String tagPrefix;

    public PrefixedLogger(ILogger iLogger) {
        this.tagPrefix = null;
        this.tagDelimiter = HelpFormatter.DEFAULT_OPT_PREFIX;
        this.tagCache = new HashMap<>(32);
        this.output = iLogger;
    }

    private synchronized String getTag(String str) {
        String str2 = this.tagPrefix;
        if (str == null) {
            if (str2 == null) {
                str2 = "null";
            }
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        String str3 = this.tagCache.get(str);
        if (str3 == null) {
            str3 = str2 + this.tagDelimiter + str;
            this.tagCache.put(str, str3);
        }
        return str3;
    }

    public synchronized void clearTagCache() {
        this.tagCache.clear();
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void d(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            iLogger.d(getTag(str), str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void e(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            iLogger.e(getTag(str), str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void i(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            iLogger.i(getTag(str), str2);
        }
    }

    public void setTagDelimiter(String str) {
        this.tagDelimiter = str;
    }

    public void setTagPrefix(String str) {
        this.tagPrefix = str;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public /* synthetic */ ILogger subLogger() {
        return OxxIIOOXO.oIX0oI(this);
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void v(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            iLogger.v(getTag(str), str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void w(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            iLogger.w(getTag(str), str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void e(String str, String str2, Throwable th) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            iLogger.e(getTag(str), str2, th);
        }
    }

    public PrefixedLogger(ILogger iLogger, String str) {
        this.tagPrefix = null;
        this.tagDelimiter = HelpFormatter.DEFAULT_OPT_PREFIX;
        this.tagCache = new HashMap<>(32);
        this.output = iLogger;
        this.tagPrefix = str;
    }
}
