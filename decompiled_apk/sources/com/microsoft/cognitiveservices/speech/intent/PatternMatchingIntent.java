package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.util.KeyedItem;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes11.dex */
public final class PatternMatchingIntent implements KeyedItem {
    public Collection<String> Phrases;
    private String id;

    public PatternMatchingIntent(String str) {
        this.id = str;
        this.Phrases = new ArrayList();
    }

    @Override // com.microsoft.cognitiveservices.speech.util.KeyedItem
    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public PatternMatchingIntent(String str, Collection<String> collection) {
        this.id = str;
        this.Phrases = collection;
    }

    public PatternMatchingIntent(String str, String... strArr) {
        this.id = str;
        this.Phrases = new ArrayList();
        for (String str2 : strArr) {
            this.Phrases.add(str2);
        }
    }
}
