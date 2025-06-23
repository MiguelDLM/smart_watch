package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.vk.openvk.api.proto.EventListener;
import o0.XxX0x0xxx;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class DislikeListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private AdapterView.OnItemClickListener f10646a;
    private EventListener b;
    private AdapterView.OnItemClickListener c;

    public DislikeListView(Context context) {
        super(context);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DislikeListView.this.getAdapter() != null && DislikeListView.this.getAdapter().getItem(i) != null && (DislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i);
                    if (!filterWord.hasSecondOptions()) {
                        if (DislikeListView.this.f10646a != null) {
                            DislikeListView.this.f10646a.onItemClick(adapterView, view, i, j);
                        }
                        if (DislikeListView.this.b != null) {
                            DislikeListView.this.b.onEvent(0, XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().II0XooXoX(0, filterWord.getId()).II0XooXoX(1, filterWord.getName()).OOXIXo()).XO());
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener instanceof EventListener) {
            this.b = (EventListener) onItemClickListener;
        } else {
            this.f10646a = onItemClickListener;
        }
    }

    private void a() {
        super.setOnItemClickListener(this.c);
    }

    public DislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DislikeListView.this.getAdapter() != null && DislikeListView.this.getAdapter().getItem(i) != null && (DislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i);
                    if (!filterWord.hasSecondOptions()) {
                        if (DislikeListView.this.f10646a != null) {
                            DislikeListView.this.f10646a.onItemClick(adapterView, view, i, j);
                        }
                        if (DislikeListView.this.b != null) {
                            DislikeListView.this.b.onEvent(0, XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().II0XooXoX(0, filterWord.getId()).II0XooXoX(1, filterWord.getName()).OOXIXo()).XO());
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public DislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.DislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (DislikeListView.this.getAdapter() != null && DislikeListView.this.getAdapter().getItem(i2) != null && (DislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) DislikeListView.this.getAdapter().getItem(i2);
                    if (!filterWord.hasSecondOptions()) {
                        if (DislikeListView.this.f10646a != null) {
                            DislikeListView.this.f10646a.onItemClick(adapterView, view, i2, j);
                        }
                        if (DislikeListView.this.b != null) {
                            DislikeListView.this.b.onEvent(0, XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().II0XooXoX(0, filterWord.getId()).II0XooXoX(1, filterWord.getName()).OOXIXo()).XO());
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }
}
