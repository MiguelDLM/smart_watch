package com.alibaba.fastjson.asm;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes.dex */
public class MethodCollector {
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final StringBuilder result = new StringBuilder();
    private int currentParameter = 0;

    public MethodCollector(int i, int i2) {
        this.ignoreCount = i;
        this.paramCount = i2;
        this.debugInfoPresent = i2 == 0;
    }

    public String getResult() {
        if (this.result.length() != 0) {
            return this.result.substring(1);
        }
        return "";
    }

    public void visitLocalVariable(String str, int i) {
        int i2 = this.ignoreCount;
        if (i >= i2 && i < i2 + this.paramCount) {
            if (!str.equals(HelpFormatter.DEFAULT_ARG_NAME + this.currentParameter)) {
                this.debugInfoPresent = true;
            }
            this.result.append(',');
            this.result.append(str);
            this.currentParameter++;
        }
    }
}
