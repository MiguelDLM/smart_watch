package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.tsccm;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.AbstractPoolEntry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.AbstractPooledConnAdapter;

@Deprecated
/* loaded from: classes10.dex */
public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    public BasicPooledConnAdapter(ThreadSafeClientConnManager threadSafeClientConnManager, AbstractPoolEntry abstractPoolEntry) {
        super(threadSafeClientConnManager, abstractPoolEntry);
        markReusable();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.AbstractPooledConnAdapter, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.AbstractClientConnAdapter
    public void detach() {
        super.detach();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.AbstractClientConnAdapter
    public ClientConnectionManager getManager() {
        return super.getManager();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.AbstractPooledConnAdapter
    public AbstractPoolEntry getPoolEntry() {
        return super.getPoolEntry();
    }
}
