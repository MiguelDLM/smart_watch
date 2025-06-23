package org.apache.log4j.lf5;

import org.apache.log4j.spi.ThrowableInformation;

/* loaded from: classes6.dex */
public class Log4JLogRecord extends LogRecord {
    @Override // org.apache.log4j.lf5.LogRecord
    public boolean isSevereLevel() {
        if (!LogLevel.ERROR.equals(getLevel()) && !LogLevel.FATAL.equals(getLevel())) {
            return false;
        }
        return true;
    }

    public void setThrownStackTrace(ThrowableInformation throwableInformation) {
        String[] throwableStrRep = throwableInformation.getThrowableStrRep();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : throwableStrRep) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append("\n");
            stringBuffer.append(stringBuffer2.toString());
        }
        this._thrownStackTrace = stringBuffer.toString();
    }
}
