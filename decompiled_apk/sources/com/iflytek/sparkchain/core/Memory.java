package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public class Memory {

    /* loaded from: classes10.dex */
    public static class TokenMemory extends Memory {
        int maxTokens;

        public TokenMemory(int i) {
            this.maxTokens = i;
        }

        @Override // com.iflytek.sparkchain.core.Memory
        public String getType() {
            return "TokenMemory";
        }
    }

    /* loaded from: classes10.dex */
    public static class WindowMemory extends Memory {
        int maxWindows;

        public WindowMemory(int i) {
            this.maxWindows = i;
        }

        @Override // com.iflytek.sparkchain.core.Memory
        public String getType() {
            return "WindowMemory";
        }
    }

    public static Memory tokenMemory(int i) {
        return new TokenMemory(i);
    }

    public static Memory windowMemory(int i) {
        return new WindowMemory(i);
    }

    public String getType() {
        return "Memory";
    }
}
