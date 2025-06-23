package jxl.write.biff;

import jxl.write.WriteException;

/* loaded from: classes6.dex */
public class JxlWriteException extends WriteException {
    static oIX0oI formatInitialized = new oIX0oI("Attempt to modify a referenced format");
    static oIX0oI cellReferenced = new oIX0oI("Cell has already been added to a worksheet");
    static oIX0oI maxRowsExceeded = new oIX0oI("The maximum number of rows permitted on a worksheet been exceeded");
    static oIX0oI maxColumnsExceeded = new oIX0oI("The maximum number of columns permitted on a worksheet has been exceeded");
    static oIX0oI copyPropertySets = new oIX0oI("Error encounted when copying additional property sets");

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f28648oIX0oI;

        public oIX0oI(String str) {
            this.f28648oIX0oI = str;
        }
    }

    public JxlWriteException(oIX0oI oix0oi) {
        super(oix0oi.f28648oIX0oI);
    }
}
