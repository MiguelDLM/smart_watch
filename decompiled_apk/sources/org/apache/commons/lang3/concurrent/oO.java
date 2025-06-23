package org.apache.commons.lang3.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class oO extends I0Io<II0xO0> {

    /* renamed from: oxoX, reason: collision with root package name */
    public final Map<String, I0Io<?>> f32708oxoX;

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public final Map<String, ConcurrentException> f32709I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final Map<String, Object> f32710II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Map<String, I0Io<?>> f32711oIX0oI;

        public I0Io<?> I0Io(String str) {
            return oIX0oI(str);
        }

        public ConcurrentException II0xO0(String str) {
            oIX0oI(str);
            return this.f32709I0Io.get(str);
        }

        public boolean Oxx0IOOO() {
            return this.f32709I0Io.isEmpty();
        }

        public Set<String> X0o0xo() {
            return Collections.unmodifiableSet(this.f32711oIX0oI.keySet());
        }

        public boolean XO(String str) {
            oIX0oI(str);
            return this.f32709I0Io.containsKey(str);
        }

        public final I0Io<?> oIX0oI(String str) {
            I0Io<?> i0Io = this.f32711oIX0oI.get(str);
            if (i0Io != null) {
                return i0Io;
            }
            throw new NoSuchElementException("No child initializer with name " + str);
        }

        public Object oxoX(String str) {
            oIX0oI(str);
            return this.f32710II0xO0.get(str);
        }

        public II0xO0(Map<String, I0Io<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            this.f32711oIX0oI = map;
            this.f32710II0xO0 = map2;
            this.f32709I0Io = map3;
        }
    }

    public oO() {
        this.f32708oxoX = new HashMap();
    }

    public void OOXIXo(String str, I0Io<?> i0Io) {
        xoIxX.xo0x(str, "Name of child initializer must not be null!", new Object[0]);
        xoIxX.xo0x(i0Io, "Child initializer must not be null!", new Object[0]);
        synchronized (this) {
            try {
                if (!II0XooXoX()) {
                    this.f32708oxoX.put(str, i0Io);
                } else {
                    throw new IllegalStateException("addInitializer() must not be called after start()!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.commons.lang3.concurrent.I0Io
    public int XO() {
        Iterator<I0Io<?>> it = this.f32708oxoX.values().iterator();
        int i = 1;
        while (it.hasNext()) {
            i += it.next().XO();
        }
        return i;
    }

    @Override // org.apache.commons.lang3.concurrent.I0Io
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public II0xO0 Oxx0IOOO() throws Exception {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.f32708oxoX);
        }
        ExecutorService I0Io2 = I0Io();
        for (I0Io i0Io : hashMap.values()) {
            if (i0Io.oxoX() == null) {
                i0Io.xxIXOIIO(I0Io2);
            }
            i0Io.xoIox();
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                hashMap2.put(entry.getKey(), ((I0Io) entry.getValue()).get());
            } catch (ConcurrentException e) {
                hashMap3.put(entry.getKey(), e);
            }
        }
        return new II0xO0(hashMap, hashMap2, hashMap3);
    }

    public oO(ExecutorService executorService) {
        super(executorService);
        this.f32708oxoX = new HashMap();
    }
}
