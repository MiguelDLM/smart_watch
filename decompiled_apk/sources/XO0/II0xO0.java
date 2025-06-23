package XO0;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.simple.eventbus.ThreadMode;

/* loaded from: classes6.dex */
public final class II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static II0xO0 f3838II0XooXoX = null;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final String f3839Oxx0IOOO = "II0xO0";

    /* renamed from: I0Io, reason: collision with root package name */
    public List<I0Io> f3840I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Map<I0Io, CopyOnWriteArrayList<Oxx0IOOO>> f3841II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public C0060II0xO0 f3842X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public X0o0xo f3843XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f3844oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ThreadLocal<Queue<I0Io>> f3845oxoX;

    /* loaded from: classes6.dex */
    public class oIX0oI extends ThreadLocal<Queue<I0Io>> {
        public oIX0oI() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Queue<I0Io> initialValue() {
            return new ConcurrentLinkedQueue();
        }
    }

    public II0xO0() {
        this(f3839Oxx0IOOO);
    }

    public static II0xO0 oxoX() {
        if (f3838II0XooXoX == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f3838II0XooXoX == null) {
                        f3838II0XooXoX = new II0xO0();
                    }
                } finally {
                }
            }
        }
        return f3838II0XooXoX;
    }

    public synchronized void I0Io() {
        this.f3845oxoX.get().clear();
        this.f3841II0xO0.clear();
    }

    public List<I0Io> II0XooXoX() {
        return this.f3840I0Io;
    }

    public void IIXOooo(Object obj) {
        if (obj == null) {
            return;
        }
        synchronized (this) {
            this.f3843XO.X0o0xo(obj);
        }
    }

    public void IXxxXO(I0O00OI.I0Io i0Io) {
        this.f3842X0o0xo.f3846I0Io = i0Io;
    }

    public void OOXIXo(Object obj, String str) {
        this.f3845oxoX.get().offer(new I0Io(obj.getClass(), str));
        this.f3842X0o0xo.II0xO0(obj);
    }

    public void Oo(Class<?> cls, String str) {
        Iterator<I0Io> it = this.f3840I0Io.iterator();
        while (it.hasNext()) {
            I0Io next = it.next();
            if (next.f3834oIX0oI.equals(cls) && next.f3833II0xO0.equals(str)) {
                it.remove();
            }
        }
    }

    public Queue<I0Io> Oxx0IOOO() {
        return this.f3845oxoX.get();
    }

    public void Oxx0xo(IxOXOxO.II0xO0 iI0xO0) {
        this.f3842X0o0xo.f3848X0o0xo = iI0xO0;
    }

    public void OxxIIOOXO(I0O00OI.I0Io i0Io) {
        this.f3842X0o0xo.f3850oIX0oI = i0Io;
    }

    public String X0o0xo() {
        return this.f3844oIX0oI;
    }

    public C0060II0xO0 XO() {
        return this.f3842X0o0xo;
    }

    public void oI0IIXIo(I0O00OI.I0Io i0Io) {
        this.f3842X0o0xo.f3847II0xO0 = i0Io;
    }

    public void oO(Object obj) {
        x0XOIxOo(obj);
        this.f3842X0o0xo.I0Io(obj);
    }

    public void oOoXoXO(Object obj) {
        ooOOo0oXI(obj, I0Io.f3831oxoX);
    }

    public void ooOOo0oXI(Object obj, String str) {
        I0Io i0Io = new I0Io(obj.getClass(), str);
        i0Io.f3832I0Io = obj;
        this.f3840I0Io.add(i0Io);
    }

    public void x0XOIxOo(Object obj) {
        if (obj == null) {
            return;
        }
        synchronized (this) {
            this.f3843XO.II0xO0(obj);
        }
    }

    public void x0xO0oo(Class<?> cls) {
        Oo(cls, I0Io.f3831oxoX);
    }

    public void xoIox(Object obj) {
        OOXIXo(obj, I0Io.f3831oxoX);
    }

    public Map<I0Io, CopyOnWriteArrayList<Oxx0IOOO>> xxIXOIIO() {
        return this.f3841II0xO0;
    }

    public II0xO0(String str) {
        this.f3844oIX0oI = f3839Oxx0IOOO;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f3841II0xO0 = concurrentHashMap;
        this.f3840I0Io = Collections.synchronizedList(new LinkedList());
        this.f3845oxoX = new oIX0oI();
        this.f3842X0o0xo = new C0060II0xO0(this, null);
        this.f3843XO = new X0o0xo(concurrentHashMap);
        this.f3844oIX0oI = str;
    }

    /* renamed from: XO0.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0060II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public I0O00OI.I0Io f3846I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public I0O00OI.I0Io f3847II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public IxOXOxO.II0xO0 f3848X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public I0O00OI.I0Io f3850oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public Map<I0Io, List<I0Io>> f3851oxoX;

        public C0060II0xO0() {
            this.f3850oIX0oI = new I0O00OI.oxoX();
            this.f3847II0xO0 = new I0O00OI.II0xO0();
            this.f3846I0Io = new I0O00OI.oIX0oI();
            this.f3851oxoX = new ConcurrentHashMap();
            this.f3848X0o0xo = new IxOXOxO.oIX0oI();
        }

        public void I0Io(Object obj) {
            Iterator it = II0xO0.this.f3840I0Io.iterator();
            while (it.hasNext()) {
                Oxx0IOOO((I0Io) it.next(), obj);
            }
        }

        public final boolean II0XooXoX(Oxx0IOOO oxx0IOOO, Object obj) {
            Object obj2;
            Reference<Object> reference = oxx0IOOO.f3855oIX0oI;
            if (reference != null) {
                obj2 = reference.get();
            } else {
                obj2 = null;
            }
            if (obj != null && (obj2 == null || !obj2.equals(obj))) {
                return false;
            }
            return true;
        }

        public void II0xO0(Object obj) {
            Queue<I0Io> queue = II0xO0.this.f3845oxoX.get();
            while (queue.size() > 0) {
                oIX0oI(queue.poll(), obj);
            }
        }

        public final void Oxx0IOOO(I0Io i0Io, Object obj) {
            List<I0Io> X0o0xo2 = X0o0xo(i0Io, i0Io.f3832I0Io);
            Object obj2 = i0Io.f3832I0Io;
            for (I0Io i0Io2 : X0o0xo2) {
                List<Oxx0IOOO> list = (List) II0xO0.this.f3841II0xO0.get(i0Io2);
                if (list != null) {
                    for (Oxx0IOOO oxx0IOOO : list) {
                        I0O00OI.I0Io oxoX2 = oxoX(oxx0IOOO.f3853I0Io);
                        if (II0XooXoX(oxx0IOOO, obj) && (oxx0IOOO.f3856oxoX.equals(i0Io2) || oxx0IOOO.f3856oxoX.f3834oIX0oI.isAssignableFrom(i0Io2.f3834oIX0oI))) {
                            oxoX2.oIX0oI(oxx0IOOO, obj2);
                        }
                    }
                }
            }
        }

        public final List<I0Io> X0o0xo(I0Io i0Io, Object obj) {
            List<I0Io> list;
            if (this.f3851oxoX.containsKey(i0Io)) {
                list = this.f3851oxoX.get(i0Io);
            } else {
                List<I0Io> oIX0oI2 = this.f3848X0o0xo.oIX0oI(i0Io, obj);
                this.f3851oxoX.put(i0Io, oIX0oI2);
                list = oIX0oI2;
            }
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }

        public final void XO(I0Io i0Io, Object obj) {
            List<Oxx0IOOO> list = (List) II0xO0.this.f3841II0xO0.get(i0Io);
            if (list == null) {
                return;
            }
            for (Oxx0IOOO oxx0IOOO : list) {
                oxoX(oxx0IOOO.f3853I0Io).oIX0oI(oxx0IOOO, obj);
            }
        }

        public final void oIX0oI(I0Io i0Io, Object obj) {
            Iterator<I0Io> it = X0o0xo(i0Io, obj).iterator();
            while (it.hasNext()) {
                XO(it.next(), obj);
            }
        }

        public final I0O00OI.I0Io oxoX(ThreadMode threadMode) {
            if (threadMode == ThreadMode.ASYNC) {
                return this.f3846I0Io;
            }
            if (threadMode == ThreadMode.POST) {
                return this.f3847II0xO0;
            }
            return this.f3850oIX0oI;
        }

        public /* synthetic */ C0060II0xO0(II0xO0 iI0xO0, oIX0oI oix0oi) {
            this();
        }
    }
}
