package O0Xx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public BufferedWriter f1397I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ByteArrayOutputStream f1398II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final OutputStream f1401oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final ArrayList<String> f1402oxoX = new ArrayList<>();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final ArrayList<String> f1399X0o0xo = new ArrayList<>();

    /* renamed from: XO, reason: collision with root package name */
    public int f1400XO = 0;

    public II0XooXoX(ByteArrayOutputStream byteArrayOutputStream) {
        this.f1401oIX0oI = byteArrayOutputStream;
    }

    public ArrayList<String> I0Io() {
        return this.f1402oxoX;
    }

    public void II0xO0() {
        try {
            BufferedWriter bufferedWriter = this.f1397I0Io;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                this.f1397I0Io = null;
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(this.f1401oIX0oI, StandardCharsets.UTF_8));
                Iterator<String> it = this.f1402oxoX.iterator();
                while (it.hasNext()) {
                    bufferedWriter2.write(it.next() + ",");
                }
                bufferedWriter2.write("\n");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(this.f1398II0xO0.toByteArray()), StandardCharsets.UTF_8));
                while (bufferedReader.ready()) {
                    bufferedWriter2.write(bufferedReader.readLine() + "\n");
                }
                bufferedReader.close();
                bufferedWriter2.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void X0o0xo(int i) {
        this.f1400XO = i;
    }

    public void XO() {
        try {
            if (this.f1397I0Io == null) {
                this.f1398II0xO0 = new ByteArrayOutputStream();
                this.f1397I0Io = new BufferedWriter(new OutputStreamWriter(this.f1398II0xO0, StandardCharsets.UTF_8));
            }
            Iterator<String> it = this.f1399X0o0xo.iterator();
            while (it.hasNext()) {
                String next = it.next();
                this.f1397I0Io.write(next + ",");
            }
            if (this.f1399X0o0xo.size() < this.f1400XO) {
                for (int i = 0; i < this.f1400XO - this.f1399X0o0xo.size(); i++) {
                    this.f1397I0Io.write(",");
                }
            }
            this.f1397I0Io.write("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void oIX0oI() {
        Collections.fill(this.f1399X0o0xo, "");
    }

    public void oxoX(String str, Object obj) {
        if (str == null) {
            str = "null";
        }
        if (obj == null) {
            obj = "null";
        }
        for (int i = 0; i < this.f1402oxoX.size(); i++) {
            if (this.f1402oxoX.get(i).compareTo(str) == 0) {
                this.f1399X0o0xo.set(i, obj.toString());
                return;
            }
        }
        this.f1402oxoX.add(str);
        this.f1399X0o0xo.add(obj.toString());
    }
}
