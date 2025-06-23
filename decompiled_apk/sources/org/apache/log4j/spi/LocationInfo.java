package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/* loaded from: classes6.dex */
public class LocationInfo implements Serializable {
    public static final String NA = "?";
    static boolean inVisualAge = false;
    static final long serialVersionUID = -1325822038990805636L;
    transient String className;
    transient String fileName;
    public String fullInfo;
    transient String lineNumber;
    transient String methodName;
    private static StringWriter sw = new StringWriter();
    private static PrintWriter pw = new PrintWriter(sw);

    static {
        inVisualAge = false;
        try {
            Class.forName("com.ibm.uvm.tools.DebugSupport");
            inVisualAge = true;
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Detected IBM VisualAge environment.");
        } catch (Throwable unused) {
        }
    }

    public LocationInfo(Throwable th, String str) {
        String stringWriter;
        String str2;
        int indexOf;
        int i;
        int indexOf2;
        if (th == null) {
            return;
        }
        synchronized (sw) {
            th.printStackTrace(pw);
            stringWriter = sw.toString();
            sw.getBuffer().setLength(0);
        }
        int lastIndexOf = stringWriter.lastIndexOf(str);
        if (lastIndexOf == -1 || (indexOf = stringWriter.indexOf((str2 = org.apache.log4j.x0XOIxOo.f33503oIX0oI), lastIndexOf)) == -1 || (indexOf2 = stringWriter.indexOf(str2, (i = indexOf + org.apache.log4j.x0XOIxOo.f33502II0xO0))) == -1) {
            return;
        }
        if (!inVisualAge) {
            int lastIndexOf2 = stringWriter.lastIndexOf("at ", indexOf2);
            if (lastIndexOf2 == -1) {
                return;
            } else {
                i = lastIndexOf2 + 3;
            }
        }
        this.fullInfo = stringWriter.substring(i, indexOf2);
    }

    public String getClassName() {
        int i;
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.className == null) {
            int lastIndexOf = str.lastIndexOf(40);
            if (lastIndexOf == -1) {
                this.className = NA;
            } else {
                int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
                if (inVisualAge) {
                    i = this.fullInfo.lastIndexOf(32, lastIndexOf2) + 1;
                } else {
                    i = 0;
                }
                if (lastIndexOf2 == -1) {
                    this.className = NA;
                } else {
                    this.className = this.fullInfo.substring(i, lastIndexOf2);
                }
            }
        }
        return this.className;
    }

    public String getFileName() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.fileName == null) {
            int lastIndexOf = str.lastIndexOf(58);
            if (lastIndexOf == -1) {
                this.fileName = NA;
            } else {
                this.fileName = this.fullInfo.substring(this.fullInfo.lastIndexOf(40, lastIndexOf - 1) + 1, lastIndexOf);
            }
        }
        return this.fileName;
    }

    public String getLineNumber() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.lineNumber == null) {
            int lastIndexOf = str.lastIndexOf(41);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(58, lastIndexOf - 1);
            if (lastIndexOf2 == -1) {
                this.lineNumber = NA;
            } else {
                this.lineNumber = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.lineNumber;
    }

    public String getMethodName() {
        String str = this.fullInfo;
        if (str == null) {
            return NA;
        }
        if (this.methodName == null) {
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = this.fullInfo.lastIndexOf(46, lastIndexOf);
            if (lastIndexOf2 == -1) {
                this.methodName = NA;
            } else {
                this.methodName = this.fullInfo.substring(lastIndexOf2 + 1, lastIndexOf);
            }
        }
        return this.methodName;
    }
}
