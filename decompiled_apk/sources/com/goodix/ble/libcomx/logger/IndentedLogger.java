package com.goodix.ble.libcomx.logger;

import com.goodix.ble.libcomx.ILogger;

/* loaded from: classes9.dex */
public class IndentedLogger implements ILogger {
    private String defaultTag;
    private String msgIndent;
    private ILogger output;

    public IndentedLogger(ILogger iLogger) {
        this.msgIndent = null;
        this.defaultTag = "null";
        this.output = iLogger;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void d(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            if (str == null) {
                str = this.defaultTag;
            }
            if (this.msgIndent != null) {
                str2 = this.msgIndent + str2;
            }
            iLogger.d(str, str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void e(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            if (str == null) {
                str = this.defaultTag;
            }
            if (this.msgIndent != null) {
                str2 = this.msgIndent + str2;
            }
            iLogger.e(str, str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void i(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            if (str == null) {
                str = this.defaultTag;
            }
            if (this.msgIndent != null) {
                str2 = this.msgIndent + str2;
            }
            iLogger.i(str, str2);
        }
    }

    public void setDefaultTag(String str) {
        if (str == null) {
            return;
        }
        this.defaultTag = str;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public ILogger subLogger() {
        IndentedLogger indentedLogger = new IndentedLogger(this.output);
        String str = this.msgIndent;
        if (str != null) {
            indentedLogger.msgIndent = str + str;
        } else {
            indentedLogger.msgIndent = "  ";
        }
        indentedLogger.defaultTag = this.defaultTag;
        return indentedLogger;
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void v(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            if (str == null) {
                str = this.defaultTag;
            }
            if (this.msgIndent != null) {
                str2 = this.msgIndent + str2;
            }
            iLogger.v(str, str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void w(String str, String str2) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            if (str == null) {
                str = this.defaultTag;
            }
            if (this.msgIndent != null) {
                str2 = this.msgIndent + str2;
            }
            iLogger.w(str, str2);
        }
    }

    @Override // com.goodix.ble.libcomx.ILogger
    public void e(String str, String str2, Throwable th) {
        ILogger iLogger = this.output;
        if (iLogger != null) {
            if (str == null) {
                str = this.defaultTag;
            }
            if (this.msgIndent != null) {
                str2 = this.msgIndent + str2;
            }
            iLogger.e(str, str2, th);
        }
    }

    public IndentedLogger(ILogger iLogger, String str) {
        this.defaultTag = "null";
        this.output = iLogger;
        this.msgIndent = str;
    }
}
