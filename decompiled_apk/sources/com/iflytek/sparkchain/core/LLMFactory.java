package com.iflytek.sparkchain.core;

import com.facebook.appevents.internal.ViewHierarchyConstants;

/* loaded from: classes10.dex */
public class LLMFactory {
    public static LLM imageGeneration() {
        return imageGeneration(512, 512, null);
    }

    public static LLM imageUnderstanding() {
        return imageUnderstanding(null, null);
    }

    public static LLM textGeneration() {
        return textGeneration(null, null);
    }

    public static LLM imageGeneration(int i, int i2) {
        return imageGeneration(i, i2, null);
    }

    public static LLM imageUnderstanding(LLMConfig lLMConfig) {
        return imageUnderstanding(lLMConfig, null);
    }

    public static LLM textGeneration(LLMConfig lLMConfig) {
        return textGeneration(lLMConfig, null);
    }

    public static LLM imageGeneration(int i, int i2, LLMConfig lLMConfig) {
        if (lLMConfig == null) {
            lLMConfig = LLMConfig.builder();
        }
        lLMConfig.param(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
        lLMConfig.param("height", i2);
        return new LLM(d.IMAGE_GENERATION, lLMConfig, null);
    }

    public static LLM imageUnderstanding(LLMConfig lLMConfig, Memory memory) {
        return new LLM(d.IMAGE_UNDERSTANDING, lLMConfig, memory);
    }

    public static LLM textGeneration(LLMConfig lLMConfig, Memory memory) {
        return new LLM(d.TEXT_GENERATION, lLMConfig, memory);
    }

    public static LLM imageGeneration(LLMConfig lLMConfig) {
        return imageGeneration(512, 512, lLMConfig);
    }

    public static LLM imageUnderstanding(Memory memory) {
        return imageUnderstanding(null, memory);
    }

    public static LLM textGeneration(Memory memory) {
        return textGeneration(null, memory);
    }
}
