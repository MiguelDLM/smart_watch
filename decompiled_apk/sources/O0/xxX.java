package O0;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/* loaded from: classes10.dex */
public class xxX {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static Hashtable f1132X0o0xo = new Hashtable();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f1133oxoX = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f1134I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f1135II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Stack f1136oIX0oI;

    public xxX(boolean z, OxxIIOOXO[] oxxIIOOXOArr) {
        this.f1136oIX0oI = new Stack();
        for (OxxIIOOXO oxxIIOOXO : oxxIIOOXOArr) {
            this.f1136oIX0oI.addElement(oxxIIOOXO);
        }
        this.f1135II0xO0 = z;
        this.f1134I0Io = null;
    }

    public static xxX I0Io(boolean z, OxxIIOOXO[] oxxIIOOXOArr) {
        xxX xxx2 = new xxX(z, oxxIIOOXOArr);
        String xxx3 = xxx2.toString();
        synchronized (f1132X0o0xo) {
            try {
                xxX xxx4 = (xxX) f1132X0o0xo.get(xxx3);
                if (xxx4 == null) {
                    f1132X0o0xo.put(xxx3, xxx2);
                    return xxx2;
                }
                return xxx4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static xxX II0xO0(String str) throws XPathException {
        xxX xxx2;
        synchronized (f1132X0o0xo) {
            try {
                xxx2 = (xxX) f1132X0o0xo.get(str);
                if (xxx2 == null) {
                    xxx2 = new xxX(str);
                    f1132X0o0xo.put(str, xxx2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xxx2;
    }

    public static boolean xxIXOIIO(String str) throws XPathException, IOException {
        return II0xO0(str).II0XooXoX();
    }

    public boolean II0XooXoX() {
        return ((OxxIIOOXO) this.f1136oIX0oI.peek()).oxoX();
    }

    public boolean Oxx0IOOO() {
        return this.f1135II0xO0;
    }

    public String X0o0xo() throws XPathException {
        OOXIXo II0xO02 = ((OxxIIOOXO) this.f1136oIX0oI.peek()).II0xO0();
        if (II0xO02 instanceof I0Io) {
            return ((I0Io) II0xO02).II0xO0();
        }
        return null;
    }

    public Enumeration XO() {
        return this.f1136oIX0oI.elements();
    }

    public Object clone() {
        int size = this.f1136oIX0oI.size();
        OxxIIOOXO[] oxxIIOOXOArr = new OxxIIOOXO[size];
        Enumeration elements = this.f1136oIX0oI.elements();
        for (int i = 0; i < size; i++) {
            oxxIIOOXOArr[i] = (OxxIIOOXO) elements.nextElement();
        }
        return new xxX(this.f1135II0xO0, oxxIIOOXOArr);
    }

    public final String oIX0oI() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = this.f1136oIX0oI.elements();
        boolean z = true;
        while (elements.hasMoreElements()) {
            OxxIIOOXO oxxIIOOXO = (OxxIIOOXO) elements.nextElement();
            if (!z || this.f1135II0xO0) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
                if (oxxIIOOXO.I0Io()) {
                    stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
                }
            }
            stringBuffer.append(oxxIIOOXO.toString());
            z = false;
        }
        return stringBuffer.toString();
    }

    public String oxoX() throws XPathException {
        OOXIXo II0xO02 = ((OxxIIOOXO) this.f1136oIX0oI.peek()).II0xO0();
        if (II0xO02 instanceof oxoX) {
            return ((oxoX) II0xO02).II0xO0();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    public String toString() {
        if (this.f1134I0Io == null) {
            this.f1134I0Io = oIX0oI();
        }
        return this.f1134I0Io;
    }

    public xxX(String str) throws XPathException {
        this(str, new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f A[Catch: IOException -> 0x003a, TryCatch #0 {IOException -> 0x003a, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:8:0x0041, B:9:0x004b, B:11:0x004f, B:13:0x0055, B:15:0x005b, B:23:0x006a, B:24:0x0073, B:27:0x003e), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[EDGE_INSN: B:18:0x0066->B:19:0x0066 BREAK  A[LOOP:0: B:9:0x004b->B:15:0x005b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[Catch: IOException -> 0x003a, TryCatch #0 {IOException -> 0x003a, blocks: (B:3:0x000a, B:5:0x002d, B:7:0x0035, B:8:0x0041, B:9:0x004b, B:11:0x004f, B:13:0x0055, B:15:0x005b, B:23:0x006a, B:24:0x0073, B:27:0x003e), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xxX(java.lang.String r6, java.io.Reader r7) throws com.hp.hpl.sparta.xpath.XPathException {
        /*
            r5 = this;
            r5.<init>()
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r5.f1136oIX0oI = r0
            r5.f1134I0Io = r6     // Catch: java.io.IOException -> L3a
            O0.oI0IIXIo r6 = new O0.oI0IIXIo     // Catch: java.io.IOException -> L3a
            r6.<init>(r7)     // Catch: java.io.IOException -> L3a
            r7 = 47
            r6.II0xO0(r7)     // Catch: java.io.IOException -> L3a
            r0 = 46
            r6.II0xO0(r0)     // Catch: java.io.IOException -> L3a
            r0 = 58
            r6.oxoX(r0, r0)     // Catch: java.io.IOException -> L3a
            r0 = 95
            r6.oxoX(r0, r0)     // Catch: java.io.IOException -> L3a
            int r0 = r6.oIX0oI()     // Catch: java.io.IOException -> L3a
            r1 = 1
            r2 = 0
            if (r0 != r7) goto L3e
            r5.f1135II0xO0 = r1     // Catch: java.io.IOException -> L3a
            int r0 = r6.oIX0oI()     // Catch: java.io.IOException -> L3a
            if (r0 != r7) goto L3c
            r6.oIX0oI()     // Catch: java.io.IOException -> L3a
            r0 = 1
            goto L41
        L3a:
            r6 = move-exception
            goto L74
        L3c:
            r0 = 0
            goto L41
        L3e:
            r5.f1135II0xO0 = r2     // Catch: java.io.IOException -> L3a
            goto L3c
        L41:
            java.util.Stack r3 = r5.f1136oIX0oI     // Catch: java.io.IOException -> L3a
            O0.OxxIIOOXO r4 = new O0.OxxIIOOXO     // Catch: java.io.IOException -> L3a
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L3a
            r3.push(r4)     // Catch: java.io.IOException -> L3a
        L4b:
            int r0 = r6.f1125oIX0oI     // Catch: java.io.IOException -> L3a
            if (r0 != r7) goto L66
            int r0 = r6.oIX0oI()     // Catch: java.io.IOException -> L3a
            if (r0 != r7) goto L5a
            r6.oIX0oI()     // Catch: java.io.IOException -> L3a
            r0 = 1
            goto L5b
        L5a:
            r0 = 0
        L5b:
            java.util.Stack r3 = r5.f1136oIX0oI     // Catch: java.io.IOException -> L3a
            O0.OxxIIOOXO r4 = new O0.OxxIIOOXO     // Catch: java.io.IOException -> L3a
            r4.<init>(r5, r0, r6)     // Catch: java.io.IOException -> L3a
            r3.push(r4)     // Catch: java.io.IOException -> L3a
            goto L4b
        L66:
            r7 = -1
            if (r0 != r7) goto L6a
            return
        L6a:
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException     // Catch: java.io.IOException -> L3a
            java.lang.String r0 = "at end of XPATH expression"
            java.lang.String r1 = "end of expression"
            r7.<init>(r5, r0, r6, r1)     // Catch: java.io.IOException -> L3a
            throw r7     // Catch: java.io.IOException -> L3a
        L74:
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException
            r7.<init>(r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: O0.xxX.<init>(java.lang.String, java.io.Reader):void");
    }
}
