package org.apache.log4j;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class I0Io extends org.apache.log4j.II0xO0 implements org.apache.log4j.spi.oIX0oI {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f33126x0xO0oo = 128;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final List f33127II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public org.apache.log4j.helpers.oIX0oI f33128OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public boolean f33129oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final org.apache.log4j.helpers.oIX0oI f33130oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final Thread f33131ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f33132x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f33133xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final Map f33134xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class II0xO0 implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final Map f33135IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final List f33136Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final org.apache.log4j.helpers.oIX0oI f33137Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final I0Io f33138XO;

        public II0xO0(I0Io i0Io, List list, Map map, org.apache.log4j.helpers.oIX0oI oix0oi) {
            this.f33138XO = i0Io;
            this.f33136Oo = list;
            this.f33137Oxx0xo = oix0oi;
            this.f33135IXxxXO = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            LoggingEvent[] loggingEventArr;
            boolean z2 = true;
            while (z2) {
                try {
                    synchronized (this.f33136Oo) {
                        try {
                            int size = this.f33136Oo.size();
                            boolean z3 = this.f33138XO.f33158Oxx0IOOO;
                            while (true) {
                                z = !z3;
                                if (size != 0 || !z) {
                                    break;
                                }
                                this.f33136Oo.wait();
                                size = this.f33136Oo.size();
                                z3 = this.f33138XO.f33158Oxx0IOOO;
                            }
                            if (size > 0) {
                                loggingEventArr = new LoggingEvent[this.f33135IXxxXO.size() + size];
                                this.f33136Oo.toArray(loggingEventArr);
                                Iterator it = this.f33135IXxxXO.values().iterator();
                                while (it.hasNext()) {
                                    loggingEventArr[size] = ((oIX0oI) it.next()).II0xO0();
                                    size++;
                                }
                                this.f33136Oo.clear();
                                this.f33135IXxxXO.clear();
                                this.f33136Oo.notifyAll();
                            } else {
                                loggingEventArr = null;
                            }
                        } finally {
                        }
                    }
                    if (loggingEventArr != null) {
                        for (LoggingEvent loggingEvent : loggingEventArr) {
                            synchronized (this.f33137Oxx0xo) {
                                this.f33137Oxx0xo.II0xO0(loggingEvent);
                            }
                        }
                    }
                    z2 = z;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f33139II0xO0 = 1;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public LoggingEvent f33140oIX0oI;

        public oIX0oI(LoggingEvent loggingEvent) {
            this.f33140oIX0oI = loggingEvent;
        }

        public LoggingEvent II0xO0() {
            return new LoggingEvent(null, x0xO0oo.xXOx(this.f33140oIX0oI.getLoggerName()), this.f33140oIX0oI.getLevel(), MessageFormat.format("Discarded {0} messages due to full event buffer including: {1}", new Integer(this.f33139II0xO0), this.f33140oIX0oI.getMessage()), null);
        }

        public void oIX0oI(LoggingEvent loggingEvent) {
            if (loggingEvent.getLevel().toInt() > this.f33140oIX0oI.getLevel().toInt()) {
                this.f33140oIX0oI = loggingEvent;
            }
            this.f33139II0xO0++;
        }
    }

    public I0Io() {
        ArrayList arrayList = new ArrayList();
        this.f33127II0XooXoX = arrayList;
        HashMap hashMap = new HashMap();
        this.f33134xxIXOIIO = hashMap;
        this.f33133xoIox = 128;
        this.f33132x0XOIxOo = false;
        this.f33129oO = true;
        org.apache.log4j.helpers.oIX0oI oix0oi = new org.apache.log4j.helpers.oIX0oI();
        this.f33130oOoXoXO = oix0oi;
        this.f33128OOXIXo = oix0oi;
        Thread thread = new Thread(new II0xO0(this, arrayList, hashMap, oix0oi));
        this.f33131ooOOo0oXI = thread;
        thread.setDaemon(true);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Dispatcher-");
        stringBuffer.append(thread.getName());
        thread.setName(stringBuffer.toString());
        thread.start();
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public org.apache.log4j.oIX0oI II0XooXoX(String str) {
        org.apache.log4j.oIX0oI II0XooXoX2;
        synchronized (this.f33130oOoXoXO) {
            II0XooXoX2 = this.f33130oOoXoXO.II0XooXoX(str);
        }
        return II0XooXoX2;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        Thread thread = this.f33131ooOOo0oXI;
        if (thread != null && thread.isAlive() && this.f33133xoIox > 0) {
            loggingEvent.getNDC();
            loggingEvent.getThreadName();
            loggingEvent.getMDCCopy();
            if (this.f33132x0XOIxOo) {
                loggingEvent.getLocationInformation();
            }
            synchronized (this.f33127II0XooXoX) {
                while (true) {
                    try {
                        int size = this.f33127II0XooXoX.size();
                        if (size < this.f33133xoIox) {
                            this.f33127II0XooXoX.add(loggingEvent);
                            if (size == 0) {
                                this.f33127II0XooXoX.notifyAll();
                            }
                        } else {
                            if (!this.f33129oO || Thread.interrupted() || Thread.currentThread() == this.f33131ooOOo0oXI) {
                                break;
                            }
                            try {
                                this.f33127II0XooXoX.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                String loggerName = loggingEvent.getLoggerName();
                oIX0oI oix0oi = (oIX0oI) this.f33134xxIXOIIO.get(loggerName);
                if (oix0oi == null) {
                    this.f33134xxIXOIIO.put(loggerName, new oIX0oI(loggingEvent));
                } else {
                    oix0oi.oIX0oI(loggingEvent);
                }
            }
            return;
        }
        synchronized (this.f33130oOoXoXO) {
            this.f33130oOoXoXO.II0xO0(loggingEvent);
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public Enumeration OOXIXo() {
        Enumeration OOXIXo2;
        synchronized (this.f33130oOoXoXO) {
            OOXIXo2 = this.f33130oOoXoXO.OOXIXo();
        }
        return OOXIXo2;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void Oxx0IOOO(org.apache.log4j.oIX0oI oix0oi) {
        synchronized (this.f33130oOoXoXO) {
            this.f33130oOoXoXO.Oxx0IOOO(oix0oi);
        }
    }

    public boolean X0IIOO() {
        return this.f33129oO;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void X0o0xo(String str) {
        synchronized (this.f33130oOoXoXO) {
            this.f33130oOoXoXO.X0o0xo(str);
        }
    }

    public int XI0IXoo() {
        return this.f33133xoIox;
    }

    public boolean XIxXXX0x0() {
        return this.f33132x0XOIxOo;
    }

    public void XxX0x0xxx(int i) {
        if (i >= 0) {
            synchronized (this.f33127II0XooXoX) {
                if (i < 1) {
                    i = 1;
                }
                this.f33133xoIox = i;
                this.f33127II0XooXoX.notifyAll();
            }
            return;
        }
        throw new NegativeArraySizeException(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE);
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public void close() {
        synchronized (this.f33127II0XooXoX) {
            this.f33158Oxx0IOOO = true;
            this.f33127II0XooXoX.notifyAll();
        }
        try {
            this.f33131ooOOo0oXI.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            org.apache.log4j.helpers.xxIXOIIO.oxoX("Got an InterruptedException while waiting for the dispatcher to finish.", e);
        }
        synchronized (this.f33130oOoXoXO) {
            try {
                Enumeration OOXIXo2 = this.f33130oOoXoXO.OOXIXo();
                if (OOXIXo2 != null) {
                    while (OOXIXo2.hasMoreElements()) {
                        Object nextElement = OOXIXo2.nextElement();
                        if (nextElement instanceof org.apache.log4j.oIX0oI) {
                            ((org.apache.log4j.oIX0oI) nextElement).close();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void oIX0oI(org.apache.log4j.oIX0oI oix0oi) {
        synchronized (this.f33130oOoXoXO) {
            this.f33130oOoXoXO.oIX0oI(oix0oi);
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void oO() {
        synchronized (this.f33130oOoXoXO) {
            this.f33130oOoXoXO.oO();
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public boolean oOoXoXO(org.apache.log4j.oIX0oI oix0oi) {
        boolean oOoXoXO2;
        synchronized (this.f33130oOoXoXO) {
            oOoXoXO2 = this.f33130oOoXoXO.oOoXoXO(oix0oi);
        }
        return oOoXoXO2;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return false;
    }

    public void xXxxox0I(boolean z) {
        this.f33132x0XOIxOo = z;
    }

    public void xxX(boolean z) {
        synchronized (this.f33127II0XooXoX) {
            this.f33129oO = z;
            this.f33127II0XooXoX.notifyAll();
        }
    }
}
