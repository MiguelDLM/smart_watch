package XXooOOI;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.lang3.XX0;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f4108I0Io = "mru_file_manager";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f4109oxoX = 3;

    /* renamed from: II0xO0, reason: collision with root package name */
    public LinkedList f4110II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f4111oIX0oI = 0;

    public II0xO0() {
        II0XooXoX();
        x0XOIxOo(3);
    }

    public static void oIX0oI() {
        String property = System.getProperty(XX0.f32529II0xO0);
        String property2 = System.getProperty("file.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(property);
        stringBuffer.append(property2);
        stringBuffer.append("lf5");
        File file = new File(stringBuffer.toString());
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    public String I0Io() {
        String property = System.getProperty(XX0.f32529II0xO0);
        String property2 = System.getProperty("file.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(property);
        stringBuffer.append(property2);
        stringBuffer.append("lf5");
        stringBuffer.append(property2);
        stringBuffer.append(f4108I0Io);
        return stringBuffer.toString();
    }

    public void II0XooXoX() {
        oIX0oI();
        File file = new File(I0Io());
        if (file.exists()) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                this.f4110II0xO0 = (LinkedList) objectInputStream.readObject();
                objectInputStream.close();
                Iterator it = this.f4110II0xO0.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof File) && !(next instanceof URL)) {
                        it.remove();
                    }
                }
                return;
            } catch (Exception unused) {
                this.f4110II0xO0 = new LinkedList();
                return;
            }
        }
        this.f4110II0xO0 = new LinkedList();
    }

    public Object II0xO0(int i) {
        if (i < oO()) {
            return this.f4110II0xO0.get(i);
        }
        return null;
    }

    public void OOXIXo(File file) {
        ooOOo0oXI(file);
    }

    public String[] Oxx0IOOO() {
        if (oO() == 0) {
            return null;
        }
        String[] strArr = new String[oO()];
        for (int i = 0; i < oO(); i++) {
            Object II0xO02 = II0xO0(i);
            if (II0xO02 instanceof File) {
                strArr[i] = ((File) II0xO02).getAbsolutePath();
            } else {
                strArr[i] = II0xO02.toString();
            }
        }
        return strArr;
    }

    public InputStream X0o0xo(File file) throws IOException, FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(file));
    }

    public InputStream XO(URL url) throws IOException {
        return url.openStream();
    }

    public int oO() {
        return this.f4110II0xO0.size();
    }

    public void oOoXoXO(URL url) {
        ooOOo0oXI(url);
    }

    public void ooOOo0oXI(Object obj) {
        int indexOf = this.f4110II0xO0.indexOf(obj);
        if (indexOf == -1) {
            this.f4110II0xO0.add(0, obj);
            x0XOIxOo(this.f4111oIX0oI);
        } else {
            xxIXOIIO(indexOf);
        }
    }

    public InputStream oxoX(int i) throws IOException, FileNotFoundException {
        if (i < oO()) {
            Object II0xO02 = II0xO0(i);
            if (II0xO02 instanceof File) {
                return X0o0xo((File) II0xO02);
            }
            return XO((URL) II0xO02);
        }
        return null;
    }

    public void x0XOIxOo(int i) {
        if (i < this.f4110II0xO0.size()) {
            for (int i2 = 0; i2 < this.f4110II0xO0.size() - i; i2++) {
                this.f4110II0xO0.removeLast();
            }
        }
        this.f4111oIX0oI = i;
    }

    public void xoIox() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(I0Io())));
            objectOutputStream.writeObject(this.f4110II0xO0);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xxIXOIIO(int i) {
        LinkedList linkedList = this.f4110II0xO0;
        linkedList.add(0, linkedList.remove(i));
    }

    public II0xO0(int i) {
        II0XooXoX();
        x0XOIxOo(i);
    }
}
