package jxl.biff.formula;

import jxl.JXLException;

/* loaded from: classes6.dex */
public class FormulaException extends JXLException {
    static final oIX0oI UNRECOGNIZED_TOKEN = new oIX0oI("Unrecognized token");
    static final oIX0oI UNRECOGNIZED_FUNCTION = new oIX0oI("Unrecognized function");
    public static final oIX0oI BIFF8_SUPPORTED = new oIX0oI("Only biff8 formulas are supported");
    static final oIX0oI LEXICAL_ERROR = new oIX0oI("Lexical error:  ");
    static final oIX0oI INCORRECT_ARGUMENTS = new oIX0oI("Incorrect arguments supplied to function");
    static final oIX0oI SHEET_REF_NOT_FOUND = new oIX0oI("Could not find sheet");
    static final oIX0oI CELL_NAME_NOT_FOUND = new oIX0oI("Could not find named cell");

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f27644oIX0oI;

        public oIX0oI(String str) {
            this.f27644oIX0oI = str;
        }

        public String II0xO0() {
            return this.f27644oIX0oI;
        }
    }

    public FormulaException(oIX0oI oix0oi) {
        super(oix0oi.f27644oIX0oI);
    }

    public FormulaException(oIX0oI oix0oi, int i) {
        super(oix0oi.f27644oIX0oI + " " + i);
    }

    public FormulaException(oIX0oI oix0oi, String str) {
        super(oix0oi.f27644oIX0oI + " " + str);
    }
}
