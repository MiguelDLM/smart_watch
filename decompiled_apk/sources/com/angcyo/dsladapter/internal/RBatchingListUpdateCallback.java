package com.angcyo.dsladapter.internal;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.L;
import com.angcyo.dsladapter.LibExKt;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes7.dex */
public final class RBatchingListUpdateCallback extends BatchingListUpdateCallback {
    private boolean log;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RBatchingListUpdateCallback(@OXOo.OOXIXo ListUpdateCallback callback) {
        super(callback);
        IIX0o.x0xO0oo(callback, "callback");
    }

    @Override // androidx.recyclerview.widget.BatchingListUpdateCallback
    public void dispatchLastEvent() {
        super.dispatchLastEvent();
    }

    public final boolean getLog() {
        return this.log;
    }

    @Override // androidx.recyclerview.widget.BatchingListUpdateCallback, androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, @OXOo.oOoXoXO Object obj) {
        super.onChanged(i, i2, obj);
        if (this.log) {
            L.f5267oIX0oI.ooXIXxIX(LibExKt.xXOx(this) + " 改变列表:" + i + TokenParser.SP + i2 + "个 payload:" + obj);
        }
    }

    @Override // androidx.recyclerview.widget.BatchingListUpdateCallback, androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        super.onInserted(i, i2);
        if (this.log) {
            L.f5267oIX0oI.ooXIXxIX(LibExKt.xXOx(this) + " 插入列表从:" + i + TokenParser.SP + i2 + (char) 20010);
        }
    }

    @Override // androidx.recyclerview.widget.BatchingListUpdateCallback, androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        super.onMoved(i, i2);
        if (this.log) {
            L.f5267oIX0oI.ooXIXxIX(LibExKt.xXOx(this) + " 移动列表从:" + i + " 到:" + i2);
        }
    }

    @Override // androidx.recyclerview.widget.BatchingListUpdateCallback, androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        super.onRemoved(i, i2);
        if (this.log) {
            L.f5267oIX0oI.ooXIXxIX(LibExKt.xXOx(this) + " 移除列表从:" + i + TokenParser.SP + i2 + (char) 20010);
        }
    }

    public final void setLog(boolean z) {
        this.log = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RBatchingListUpdateCallback(@OXOo.OOXIXo RecyclerView.Adapter<?> adapter) {
        super(new AdapterListUpdateCallback(adapter));
        IIX0o.x0xO0oo(adapter, "adapter");
    }
}
