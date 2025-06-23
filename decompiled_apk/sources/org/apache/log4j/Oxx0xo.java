package org.apache.log4j;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

/* loaded from: classes6.dex */
public class Oxx0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f33196I0Io = 5;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static Hashtable f33198oIX0oI = new Hashtable();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f33197II0xO0 = 0;

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public String f33199II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f33200oIX0oI;

        public oIX0oI(String str, oIX0oI oix0oi) {
            this.f33199II0xO0 = str;
            if (oix0oi != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(oix0oi.f33200oIX0oI);
                stringBuffer.append(TokenParser.SP);
                stringBuffer.append(str);
                this.f33200oIX0oI = stringBuffer.toString();
                return;
            }
            this.f33200oIX0oI = str;
        }
    }

    public static String I0Io() {
        Stack oxoX2 = oxoX();
        if (oxoX2 != null && !oxoX2.isEmpty()) {
            return ((oIX0oI) oxoX2.peek()).f33200oIX0oI;
        }
        return null;
    }

    public static String II0XooXoX() {
        Stack oxoX2 = oxoX();
        if (oxoX2 != null && !oxoX2.isEmpty()) {
            return ((oIX0oI) oxoX2.peek()).f33199II0xO0;
        }
        return "";
    }

    public static Stack II0xO0() {
        Stack oxoX2 = oxoX();
        if (oxoX2 == null) {
            return null;
        }
        return (Stack) oxoX2.clone();
    }

    public static void OOXIXo() {
        f33198oIX0oI.remove(Thread.currentThread());
        Oxx0IOOO();
    }

    public static void Oxx0IOOO() {
        Thread thread;
        Hashtable hashtable = f33198oIX0oI;
        if (hashtable == null) {
            return;
        }
        synchronized (hashtable) {
            try {
                int i = f33197II0xO0 + 1;
                f33197II0xO0 = i;
                if (i <= 5) {
                    return;
                }
                f33197II0xO0 = 0;
                Vector vector = new Vector();
                Enumeration keys = f33198oIX0oI.keys();
                loop0: while (true) {
                    for (int i2 = 0; keys.hasMoreElements() && i2 <= 4; i2++) {
                        thread = (Thread) keys.nextElement();
                        if (thread.isAlive()) {
                        }
                    }
                    vector.addElement(thread);
                }
                int size = vector.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Thread thread2 = (Thread) vector.elementAt(i3);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Lazy NDC removal for thread [");
                    stringBuffer.append(thread2.getName());
                    stringBuffer.append("] (");
                    stringBuffer.append(f33198oIX0oI.size());
                    stringBuffer.append(").");
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
                    f33198oIX0oI.remove(thread2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int X0o0xo() {
        Stack oxoX2 = oxoX();
        if (oxoX2 == null) {
            return 0;
        }
        return oxoX2.size();
    }

    public static void XO(Stack stack) {
        if (stack != null) {
            f33198oIX0oI.put(Thread.currentThread(), stack);
        }
    }

    public static void oIX0oI() {
        Stack oxoX2 = oxoX();
        if (oxoX2 != null) {
            oxoX2.setSize(0);
        }
    }

    public static void oOoXoXO(int i) {
        Stack oxoX2 = oxoX();
        if (oxoX2 != null && i < oxoX2.size()) {
            oxoX2.setSize(i);
        }
    }

    public static Stack oxoX() {
        Hashtable hashtable = f33198oIX0oI;
        if (hashtable != null) {
            return (Stack) hashtable.get(Thread.currentThread());
        }
        return null;
    }

    public static void xoIox(String str) {
        Stack oxoX2 = oxoX();
        if (oxoX2 == null) {
            oIX0oI oix0oi = new oIX0oI(str, null);
            Stack stack = new Stack();
            f33198oIX0oI.put(Thread.currentThread(), stack);
            stack.push(oix0oi);
            return;
        }
        if (oxoX2.isEmpty()) {
            oxoX2.push(new oIX0oI(str, null));
        } else {
            oxoX2.push(new oIX0oI(str, (oIX0oI) oxoX2.peek()));
        }
    }

    public static String xxIXOIIO() {
        Stack oxoX2 = oxoX();
        if (oxoX2 != null && !oxoX2.isEmpty()) {
            return ((oIX0oI) oxoX2.pop()).f33199II0xO0;
        }
        return "";
    }
}
