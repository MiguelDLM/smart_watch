package com.sma.smartv3.view.text;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class MyTypeface {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ MyTypeface[] $VALUES;

    @OOXIXo
    private final String fontName;

    @kotlin.OOXIXo(message = "字体库已删除")
    public static final MyTypeface DIN_COND_BOLD = new MyTypeface("DIN_COND_BOLD", 0, "DINCond-Bold.otf");

    @kotlin.OOXIXo(message = "字体库已删除")
    public static final MyTypeface PF_MEDIUM = new MyTypeface("PF_MEDIUM", 1, "PingFang Medium_0.ttf");

    @kotlin.OOXIXo(message = "字体库已删除")
    public static final MyTypeface PF_BOLD = new MyTypeface("PF_BOLD", 2, "PingFang Bold.ttf");

    @kotlin.OOXIXo(message = "字体库已删除")
    public static final MyTypeface PF_EXTRA_LIGHT = new MyTypeface("PF_EXTRA_LIGHT", 3, "PingFang ExtraLight.ttf");

    @kotlin.OOXIXo(message = "字体库已删除")
    public static final MyTypeface PF_REGULAR = new MyTypeface("PF_REGULAR", 4, "PingFang Regular_0.ttf");

    private static final /* synthetic */ MyTypeface[] $values() {
        return new MyTypeface[]{DIN_COND_BOLD, PF_MEDIUM, PF_BOLD, PF_EXTRA_LIGHT, PF_REGULAR};
    }

    static {
        MyTypeface[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private MyTypeface(String str, int i, String str2) {
        this.fontName = str2;
    }

    @OOXIXo
    public static oIX0oI<MyTypeface> getEntries() {
        return $ENTRIES;
    }

    public static MyTypeface valueOf(String str) {
        return (MyTypeface) Enum.valueOf(MyTypeface.class, str);
    }

    public static MyTypeface[] values() {
        return (MyTypeface[]) $VALUES.clone();
    }

    @OOXIXo
    public final String getFontName() {
        return this.fontName;
    }
}
