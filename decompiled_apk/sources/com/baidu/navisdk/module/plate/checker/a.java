package com.baidu.navisdk.module.plate.checker;

import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public abstract class a implements c {
    public static final boolean a(String str) {
        return Pattern.compile(".*\\d+.*").matcher(str).matches();
    }
}
