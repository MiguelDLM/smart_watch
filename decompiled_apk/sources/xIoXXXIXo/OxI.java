package xIoXXXIXo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import jxl.read.biff.BiffException;
import jxl.read.biff.IIX0;
import jxl.read.biff.PasswordException;
import jxl.read.biff.XIxXXX0x0;
import jxl.write.biff.IOoo;
import oIXoXx0.X0IIOO;

/* loaded from: classes6.dex */
public abstract class OxI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f34231oIX0oI = "2.6.12";

    public static X0IIOO IXxxXO(OutputStream outputStream, O0xOxO o0xOxO) throws IOException {
        return new IOoo(outputStream, false, o0xOxO);
    }

    public static X0IIOO OOXIXo(File file) throws IOException {
        return x0XOIxOo(file, new O0xOxO());
    }

    public static X0IIOO Oo(OutputStream outputStream, OxI oxI, O0xOxO o0xOxO) throws IOException {
        return new IOoo(outputStream, oxI, false, o0xOxO);
    }

    public static String XI0IXoo() {
        return "2.6.12";
    }

    public static OxI XIxXXX0x0(File file) throws IOException, BiffException {
        return xxX(file, new O0xOxO());
    }

    public static OxI XxX0x0xxx(InputStream inputStream) throws IOException, BiffException {
        return xXxxox0I(inputStream, new O0xOxO());
    }

    public static X0IIOO oO(OutputStream outputStream) throws IOException {
        return IXxxXO(outputStream, new O0xOxO());
    }

    public static X0IIOO oOoXoXO(File file, OxI oxI) throws IOException {
        return ooOOo0oXI(file, oxI, new O0xOxO());
    }

    public static X0IIOO ooOOo0oXI(File file, OxI oxI, O0xOxO o0xOxO) throws IOException {
        return new IOoo(new FileOutputStream(file), oxI, true, o0xOxO);
    }

    public static X0IIOO x0XOIxOo(File file, O0xOxO o0xOxO) throws IOException {
        return new IOoo(new FileOutputStream(file), true, o0xOxO);
    }

    public static X0IIOO x0xO0oo(OutputStream outputStream, OxI oxI) throws IOException {
        return Oo(outputStream, oxI, ((IIX0) oxI).XX());
    }

    public static OxI xXxxox0I(InputStream inputStream, O0xOxO o0xOxO) throws IOException, BiffException {
        IIX0 iix0 = new IIX0(new XIxXXX0x0(inputStream, o0xOxO), o0xOxO);
        iix0.ooXIXxIX();
        return iix0;
    }

    public static OxI xxX(File file, O0xOxO o0xOxO) throws IOException, BiffException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            XIxXXX0x0 xIxXXX0x0 = new XIxXXX0x0(fileInputStream, o0xOxO);
            fileInputStream.close();
            IIX0 iix0 = new IIX0(xIxXXX0x0, o0xOxO);
            iix0.ooXIXxIX();
            return iix0;
        } catch (IOException e) {
            fileInputStream.close();
            throw e;
        } catch (BiffException e2) {
            fileInputStream.close();
            throw e2;
        }
    }

    public abstract boolean IIX0o();

    public abstract int IIXOooo();

    public abstract String[] O0xOxO();

    public abstract IIXOooo OxI(String str);

    public abstract OxxIIOOXO[] Oxx0xo(String str);

    public abstract I0Io OxxIIOOXO(String str);

    public abstract IIXOooo[] X0IIOO();

    public abstract IIXOooo o00(int i) throws IndexOutOfBoundsException;

    public abstract I0Io oI0IIXIo(String str);

    public abstract void ooXIXxIX() throws BiffException, PasswordException;

    public abstract void xoIox();

    public abstract String[] xoXoI();
}
