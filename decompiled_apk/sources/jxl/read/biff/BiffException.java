package jxl.read.biff;

import jxl.JXLException;

/* loaded from: classes6.dex */
public class BiffException extends JXLException {
    static final oIX0oI unrecognizedBiffVersion = new oIX0oI("Unrecognized biff version");
    static final oIX0oI expectedGlobals = new oIX0oI("Expected globals");
    static final oIX0oI excelFileTooBig = new oIX0oI("Not all of the excel file could be read");
    static final oIX0oI excelFileNotFound = new oIX0oI("The input file was not found");
    static final oIX0oI unrecognizedOLEFile = new oIX0oI("Unable to recognize OLE stream");
    static final oIX0oI streamNotFound = new oIX0oI("Compound file does not contain the specified stream");
    static final oIX0oI passwordProtected = new oIX0oI("The workbook is password protected");
    static final oIX0oI corruptFileFormat = new oIX0oI("The file format is corrupt");

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f28096oIX0oI;

        public oIX0oI(String str) {
            this.f28096oIX0oI = str;
        }
    }

    public BiffException(oIX0oI oix0oi) {
        super(oix0oi.f28096oIX0oI);
    }
}
