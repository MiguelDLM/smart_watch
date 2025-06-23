package com.baidu.tts.client.model;

import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class AvailableConditions {

    /* renamed from: a, reason: collision with root package name */
    public Set<String> f10054a;
    public Set<String> b;

    public void appendGender(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f10054a == null) {
            this.f10054a = new HashSet();
        }
        this.f10054a.add(str);
    }

    public void appendSpeaker(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.b == null) {
            this.b = new HashSet();
        }
        this.b.add(str);
    }

    public Set<String> getGenders() {
        return this.f10054a;
    }

    public Set<String> getSpeakers() {
        return this.b;
    }

    public void setGenders(Set<String> set) {
        this.f10054a = set;
    }

    public void setSpeakers(Set<String> set) {
        this.b = set;
    }
}
