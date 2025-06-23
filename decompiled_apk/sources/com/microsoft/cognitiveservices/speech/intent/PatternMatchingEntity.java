package com.microsoft.cognitiveservices.speech.intent;

import com.microsoft.cognitiveservices.speech.util.KeyedItem;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes11.dex */
public class PatternMatchingEntity implements KeyedItem {
    public Collection<String> Phrases;
    private String entityId;
    private EntityMatchMode mode;
    private EntityType type;

    /* loaded from: classes11.dex */
    public enum EntityMatchMode {
        Basic(0),
        Strict(1),
        Fuzzy(2);

        private final int id;

        EntityMatchMode(int i) {
            this.id = i;
        }

        public int getValue() {
            return this.id;
        }
    }

    /* loaded from: classes11.dex */
    public enum EntityType {
        Any(0),
        List(1),
        PrebuiltInteger(2);

        private final int id;

        EntityType(int i) {
            this.id = i;
        }

        public int getValue() {
            return this.id;
        }
    }

    public PatternMatchingEntity(String str, EntityType entityType, EntityMatchMode entityMatchMode, Collection<String> collection) {
        this.entityId = str;
        this.type = entityType;
        this.mode = entityMatchMode;
        if (collection == null) {
            this.Phrases = new ArrayList();
        } else {
            this.Phrases = collection;
        }
    }

    public static PatternMatchingEntity CreateAnyEntity(String str) {
        return new PatternMatchingEntity(str, EntityType.Any, EntityMatchMode.Basic, null);
    }

    public static PatternMatchingEntity CreateIntegerEntity(String str) {
        return new PatternMatchingEntity(str, EntityType.PrebuiltInteger, EntityMatchMode.Basic, null);
    }

    public static PatternMatchingEntity CreateListEntity(String str, EntityMatchMode entityMatchMode, Collection<String> collection) {
        return new PatternMatchingEntity(str, EntityType.List, entityMatchMode, collection);
    }

    @Override // com.microsoft.cognitiveservices.speech.util.KeyedItem
    public String getId() {
        return this.entityId;
    }

    public EntityMatchMode getMatchMode() {
        return this.mode;
    }

    public EntityType getType() {
        return this.type;
    }

    public void setId(String str) {
        this.entityId = str;
    }

    public void setMatchMode(EntityMatchMode entityMatchMode) {
        this.mode = entityMatchMode;
    }

    public void setType(EntityType entityType) {
        this.type = entityType;
    }

    public static PatternMatchingEntity CreateListEntity(String str, EntityMatchMode entityMatchMode, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            arrayList.add(str2);
        }
        return new PatternMatchingEntity(str, EntityType.List, entityMatchMode, arrayList);
    }
}
