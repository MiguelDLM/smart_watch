package IXI;

import OoOoXO0.oI0IIXIo;
import OoOoXO0.oO;
import Ox0XO.IXxxXO;
import Ox0XO.ooOOo0oXI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import org.apache.commons.lang3.XX0;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public class oxoX implements oO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final FilenameFilter f652Oxx0IOOO = new II0xO0();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f653X0o0xo = ".bup";

    /* renamed from: XO, reason: collision with root package name */
    public static final String f654XO = ".lck";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f655oxoX = ".msg";

    /* renamed from: I0Io, reason: collision with root package name */
    public ooOOo0oXI f656I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public File f657II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public File f658oIX0oI;

    public oxoX() {
        this(System.getProperty(XX0.f32604oxoX));
    }

    @Override // OoOoXO0.oO
    public boolean I0Io(String str) throws MqttPersistenceException {
        oxoX();
        File file = this.f657II0xO0;
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
        stringBuffer.append(f655oxoX);
        return new File(file, stringBuffer.toString()).exists();
    }

    @Override // OoOoXO0.oO
    public void II0xO0(String str, oI0IIXIo oi0iixio) throws MqttPersistenceException {
        oxoX();
        File file = this.f657II0xO0;
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
        stringBuffer.append(f655oxoX);
        File file2 = new File(file, stringBuffer.toString());
        File file3 = this.f657II0xO0;
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str));
        stringBuffer2.append(f655oxoX);
        stringBuffer2.append(f653X0o0xo);
        File file4 = new File(file3, stringBuffer2.toString());
        if (file2.exists() && !file2.renameTo(file4)) {
            file4.delete();
            file2.renameTo(file4);
        }
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(oi0iixio.II0xO0(), oi0iixio.oxoX(), oi0iixio.I0Io());
                if (oi0iixio.XO() != null) {
                    fileOutputStream.write(oi0iixio.XO(), oi0iixio.X0o0xo(), oi0iixio.oIX0oI());
                }
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                if (file4.exists()) {
                    file4.delete();
                }
                if (file4.exists() && !file4.renameTo(file2)) {
                    file2.delete();
                    file4.renameTo(file2);
                }
            } catch (IOException e) {
                throw new MqttPersistenceException(e);
            }
        } catch (Throwable th) {
            if (file4.exists() && !file4.renameTo(file2)) {
                file2.delete();
                file4.renameTo(file2);
            }
            throw th;
        }
    }

    public final void Oxx0IOOO(File file) throws MqttPersistenceException {
        File[] listFiles = file.listFiles(new I0Io(this));
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                File file2 = new File(file, listFiles[i].getName().substring(0, listFiles[i].getName().length() - 4));
                if (!listFiles[i].renameTo(file2)) {
                    file2.delete();
                    listFiles[i].renameTo(file2);
                }
            }
            return;
        }
        throw new MqttPersistenceException();
    }

    public final File[] X0o0xo() throws MqttPersistenceException {
        oxoX();
        File[] listFiles = this.f657II0xO0.listFiles(f652Oxx0IOOO);
        if (listFiles != null) {
            return listFiles;
        }
        throw new MqttPersistenceException();
    }

    public final boolean XO(char c) {
        if (!Character.isJavaIdentifierPart(c) && c != '-') {
            return false;
        }
        return true;
    }

    @Override // OoOoXO0.oO
    public void clear() throws MqttPersistenceException {
        oxoX();
        for (File file : X0o0xo()) {
            file.delete();
        }
    }

    @Override // OoOoXO0.oO
    public void close() throws MqttPersistenceException {
        synchronized (this) {
            try {
                ooOOo0oXI ooooo0oxi = this.f656I0Io;
                if (ooooo0oxi != null) {
                    ooooo0oxi.oIX0oI();
                }
                if (X0o0xo().length == 0) {
                    this.f657II0xO0.delete();
                }
                this.f657II0xO0 = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // OoOoXO0.oO
    public oI0IIXIo get(String str) throws MqttPersistenceException {
        oxoX();
        try {
            File file = this.f657II0xO0;
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
            stringBuffer.append(f655oxoX);
            FileInputStream fileInputStream = new FileInputStream(new File(file, stringBuffer.toString()));
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            for (int i = 0; i < available; i += fileInputStream.read(bArr, i, available - i)) {
            }
            fileInputStream.close();
            return new IXxxXO(str, bArr, 0, available, null, 0, 0);
        } catch (IOException e) {
            throw new MqttPersistenceException(e);
        }
    }

    @Override // OoOoXO0.oO
    public Enumeration keys() throws MqttPersistenceException {
        oxoX();
        File[] X0o0xo2 = X0o0xo();
        Vector vector = new Vector(X0o0xo2.length);
        for (File file : X0o0xo2) {
            vector.addElement(file.getName().substring(0, r4.length() - 4));
        }
        return vector.elements();
    }

    @Override // OoOoXO0.oO
    public void oIX0oI(String str, String str2) throws MqttPersistenceException {
        if (this.f658oIX0oI.exists() && !this.f658oIX0oI.isDirectory()) {
            throw new MqttPersistenceException();
        }
        if (!this.f658oIX0oI.exists() && !this.f658oIX0oI.mkdirs()) {
            throw new MqttPersistenceException();
        }
        if (this.f658oIX0oI.canWrite()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (XO(charAt)) {
                    stringBuffer.append(charAt);
                }
            }
            stringBuffer.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            for (int i2 = 0; i2 < str2.length(); i2++) {
                char charAt2 = str2.charAt(i2);
                if (XO(charAt2)) {
                    stringBuffer.append(charAt2);
                }
            }
            synchronized (this) {
                if (this.f657II0xO0 == null) {
                    File file = new File(this.f658oIX0oI, stringBuffer.toString());
                    this.f657II0xO0 = file;
                    if (!file.exists()) {
                        this.f657II0xO0.mkdir();
                    }
                }
                try {
                    this.f656I0Io = new ooOOo0oXI(this.f657II0xO0, f654XO);
                } catch (Exception unused) {
                }
                Oxx0IOOO(this.f657II0xO0);
            }
            return;
        }
        throw new MqttPersistenceException();
    }

    public final void oxoX() throws MqttPersistenceException {
        if (this.f657II0xO0 != null) {
        } else {
            throw new MqttPersistenceException();
        }
    }

    @Override // OoOoXO0.oO
    public void remove(String str) throws MqttPersistenceException {
        oxoX();
        File file = this.f657II0xO0;
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
        stringBuffer.append(f655oxoX);
        File file2 = new File(file, stringBuffer.toString());
        if (file2.exists()) {
            file2.delete();
        }
    }

    public oxoX(String str) {
        this.f657II0xO0 = null;
        this.f656I0Io = null;
        this.f658oIX0oI = new File(str);
    }
}
