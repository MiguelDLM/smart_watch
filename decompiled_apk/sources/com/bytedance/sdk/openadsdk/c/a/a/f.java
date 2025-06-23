package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.FilterWord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public final class f implements Bridge, FilterWord {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10719a;
    private FilterWord b;

    public f(FilterWord filterWord) {
        this.b = filterWord;
        this.f10719a = xXxxox0I.f31021oxoX;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void addOption(FilterWord filterWord) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.Oxx0IOOO(0, new f(filterWord));
        this.f10719a.call(241101, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        FilterWord filterWord = this.b;
        if (filterWord == null) {
            return null;
        }
        switch (i) {
            case 241101:
                this.b.addOption(new f((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 241102:
                this.b.setIsSelected(valueSet.booleanValue(0));
                break;
            case 241103:
                return (T) filterWord.getId();
            case 241104:
                return (T) filterWord.getName();
            case 241105:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.getIsSelected()));
            case 241106:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.hasSecondOptions()));
            case 241107:
                return (T) Boolean.class.cast(Boolean.valueOf(filterWord.isValid()));
            case 241108:
                return (T) filterWord.getOptions();
        }
        a(i, valueSet, cls);
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getId() {
        return (String) this.f10719a.call(241103, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean getIsSelected() {
        return ((Boolean) this.f10719a.call(241105, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public String getName() {
        return (String) this.f10719a.call(241104, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public List<FilterWord> getOptions() {
        List list = (List) this.f10719a.call(241108, xXxxox0I.II0xO0(0).OOXIXo(), List.class);
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new f((Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean hasSecondOptions() {
        return ((Boolean) this.f10719a.call(241106, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public boolean isValid() {
        return ((Boolean) this.f10719a.call(241107, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.FilterWord
    public void setIsSelected(boolean z) {
        xXxxox0I II0xO02 = xXxxox0I.II0xO0(1);
        II0xO02.xxIXOIIO(0, z);
        this.f10719a.call(241102, II0xO02.OOXIXo(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.f31020I0Io;
    }

    public f(Bridge bridge) {
        this.f10719a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }
}
