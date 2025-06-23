package com.bestmafen.baseble.util;

import OXOo.OOXIXo;
import androidx.exifinterface.media.ExifInterface;
import com.vtrump.vtble.Oxx0IOOO;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class LogLevel {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ LogLevel[] $VALUES;
    public static final LogLevel V = new LogLevel(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, 0);
    public static final LogLevel D = new LogLevel("D", 1);
    public static final LogLevel I = new LogLevel(Oxx0IOOO.f27277xI, 2);
    public static final LogLevel W = new LogLevel("W", 3);
    public static final LogLevel E = new LogLevel(ExifInterface.LONGITUDE_EAST, 4);

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{V, D, I, W, E};
    }

    static {
        LogLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private LogLevel(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<LogLevel> getEntries() {
        return $ENTRIES;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }
}
