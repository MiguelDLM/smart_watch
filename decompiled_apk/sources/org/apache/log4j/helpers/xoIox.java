package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public class xoIox implements Enumeration {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final xoIox f33330oIX0oI = new xoIox();

    public static xoIox oIX0oI() {
        return f33330oIX0oI;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return false;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        throw new NoSuchElementException();
    }
}
