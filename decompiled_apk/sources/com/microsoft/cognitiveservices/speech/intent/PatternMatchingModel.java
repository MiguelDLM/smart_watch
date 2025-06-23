package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.util.KeyedItemHashMap;

/* loaded from: classes11.dex */
public final class PatternMatchingModel extends LanguageUnderstandingModel {
    private KeyedItemHashMap<PatternMatchingEntity> entities;
    private KeyedItemHashMap<PatternMatchingIntent> intents;

    public PatternMatchingModel(String str) {
        this.modelId = str;
        this.intents = new KeyedItemHashMap<>();
        this.entities = new KeyedItemHashMap<>();
    }

    public KeyedItemHashMap<PatternMatchingEntity> getEntities() {
        return this.entities;
    }

    public KeyedItemHashMap<PatternMatchingIntent> getIntents() {
        return this.intents;
    }
}
