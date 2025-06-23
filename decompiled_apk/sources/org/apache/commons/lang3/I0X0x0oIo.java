package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class I0X0x0oIo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final II0xO0 f32479oIX0oI = new II0xO0();

    /* loaded from: classes6.dex */
    public static class I0Io implements XO, oxoX {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final String f32480oIX0oI;

        public I0Io(String str) {
            xoIxX.xo0x(str, "The name must not be null", new Object[0]);
            this.f32480oIX0oI = str;
        }

        @Override // org.apache.commons.lang3.I0X0x0oIo.XO
        public boolean II0xO0(Thread thread) {
            if (thread != null && thread.getName().equals(this.f32480oIX0oI)) {
                return true;
            }
            return false;
        }

        @Override // org.apache.commons.lang3.I0X0x0oIo.oxoX
        public boolean oIX0oI(ThreadGroup threadGroup) {
            if (threadGroup != null && threadGroup.getName().equals(this.f32480oIX0oI)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements XO, oxoX {
        @Override // org.apache.commons.lang3.I0X0x0oIo.XO
        public boolean II0xO0(Thread thread) {
            return true;
        }

        @Override // org.apache.commons.lang3.I0X0x0oIo.oxoX
        public boolean oIX0oI(ThreadGroup threadGroup) {
            return true;
        }

        public II0xO0() {
        }
    }

    /* loaded from: classes6.dex */
    public static class X0o0xo implements XO {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final long f32481oIX0oI;

        public X0o0xo(long j) {
            if (j > 0) {
                this.f32481oIX0oI = j;
                return;
            }
            throw new IllegalArgumentException("The thread id must be greater than zero");
        }

        @Override // org.apache.commons.lang3.I0X0x0oIo.XO
        public boolean II0xO0(Thread thread) {
            if (thread != null && thread.getId() == this.f32481oIX0oI) {
                return true;
            }
            return false;
        }
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface XO {
        boolean II0xO0(Thread thread);
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface oxoX {
        boolean oIX0oI(ThreadGroup threadGroup);
    }

    public static Thread I0Io(long j, ThreadGroup threadGroup) {
        xoIxX.xo0x(threadGroup, "The thread group must not be null", new Object[0]);
        Thread oIX0oI2 = oIX0oI(j);
        if (oIX0oI2 != null && threadGroup.equals(oIX0oI2.getThreadGroup())) {
            return oIX0oI2;
        }
        return null;
    }

    public static Collection<Thread> II0XooXoX(XO xo2) {
        return Oxx0IOOO(x0XOIxOo(), true, xo2);
    }

    public static Thread II0xO0(long j, String str) {
        xoIxX.xo0x(str, "The thread group name must not be null", new Object[0]);
        Thread oIX0oI2 = oIX0oI(j);
        if (oIX0oI2 != null && oIX0oI2.getThreadGroup() != null && oIX0oI2.getThreadGroup().getName().equals(str)) {
            return oIX0oI2;
        }
        return null;
    }

    public static Collection<Thread> OOXIXo(String str, ThreadGroup threadGroup) {
        return Oxx0IOOO(threadGroup, false, new I0Io(str));
    }

    public static Collection<Thread> Oxx0IOOO(ThreadGroup threadGroup, boolean z, XO xo2) {
        Thread[] threadArr;
        int enumerate;
        xoIxX.xo0x(threadGroup, "The group must not be null", new Object[0]);
        xoIxX.xo0x(xo2, "The predicate must not be null", new Object[0]);
        int activeCount = threadGroup.activeCount();
        while (true) {
            int i = activeCount + (activeCount / 2) + 1;
            threadArr = new Thread[i];
            enumerate = threadGroup.enumerate(threadArr, z);
            if (enumerate < i) {
                break;
            }
            activeCount = enumerate;
        }
        ArrayList arrayList = new ArrayList(enumerate);
        for (int i2 = 0; i2 < enumerate; i2++) {
            if (xo2.II0xO0(threadArr[i2])) {
                arrayList.add(threadArr[i2]);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<ThreadGroup> X0o0xo(oxoX oxox) {
        return oxoX(x0XOIxOo(), true, oxox);
    }

    public static Collection<ThreadGroup> XO(String str) {
        return X0o0xo(new I0Io(str));
    }

    public static Thread oIX0oI(long j) {
        Collection<Thread> II0XooXoX2 = II0XooXoX(new X0o0xo(j));
        if (II0XooXoX2.isEmpty()) {
            return null;
        }
        return II0XooXoX2.iterator().next();
    }

    public static Collection<ThreadGroup> oOoXoXO() {
        return X0o0xo(f32479oIX0oI);
    }

    public static Collection<Thread> ooOOo0oXI() {
        return II0XooXoX(f32479oIX0oI);
    }

    public static Collection<ThreadGroup> oxoX(ThreadGroup threadGroup, boolean z, oxoX oxox) {
        ThreadGroup[] threadGroupArr;
        int enumerate;
        xoIxX.xo0x(threadGroup, "The group must not be null", new Object[0]);
        xoIxX.xo0x(oxox, "The predicate must not be null", new Object[0]);
        int activeGroupCount = threadGroup.activeGroupCount();
        while (true) {
            int i = activeGroupCount + (activeGroupCount / 2) + 1;
            threadGroupArr = new ThreadGroup[i];
            enumerate = threadGroup.enumerate(threadGroupArr, z);
            if (enumerate < i) {
                break;
            }
            activeGroupCount = enumerate;
        }
        ArrayList arrayList = new ArrayList(enumerate);
        for (int i2 = 0; i2 < enumerate; i2++) {
            if (oxox.oIX0oI(threadGroupArr[i2])) {
                arrayList.add(threadGroupArr[i2]);
            }
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static ThreadGroup x0XOIxOo() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }

    public static Collection<Thread> xoIox(String str, String str2) {
        xoIxX.xo0x(str, "The thread name must not be null", new Object[0]);
        xoIxX.xo0x(str2, "The thread group name must not be null", new Object[0]);
        Collection<ThreadGroup> X0o0xo2 = X0o0xo(new I0Io(str2));
        if (X0o0xo2.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        I0Io i0Io = new I0Io(str);
        Iterator<ThreadGroup> it = X0o0xo2.iterator();
        while (it.hasNext()) {
            arrayList.addAll(Oxx0IOOO(it.next(), false, i0Io));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public static Collection<Thread> xxIXOIIO(String str) {
        return II0XooXoX(new I0Io(str));
    }
}
