package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class Logger {

    @OXOo.OOXIXo
    public static final String LOG_TAG_BASE = "FacebookSDK.";

    @OXOo.OOXIXo
    private final LoggingBehavior behavior;

    @OXOo.OOXIXo
    private StringBuilder contents;
    private int priority;

    @OXOo.OOXIXo
    private final String tag;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final HashMap<String, String> stringsToReplace = new HashMap<>();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized String replaceStrings(String str) {
            String str2;
            str2 = str;
            for (Map.Entry entry : Logger.stringsToReplace.entrySet()) {
                str2 = kotlin.text.OxI.IIOIX(str2, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
            }
            return str2;
        }

        @XO0OX.x0XOIxOo
        public final void log(@OXOo.OOXIXo LoggingBehavior behavior, @OXOo.OOXIXo String tag, @OXOo.OOXIXo String string) {
            IIX0o.x0xO0oo(behavior, "behavior");
            IIX0o.x0xO0oo(tag, "tag");
            IIX0o.x0xO0oo(string, "string");
            log(behavior, 3, tag, string);
        }

        @XO0OX.x0XOIxOo
        public final synchronized void registerAccessToken(@OXOo.OOXIXo String accessToken) {
            IIX0o.x0xO0oo(accessToken, "accessToken");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(accessToken, "ACCESS_TOKEN_REMOVED");
            }
        }

        @XO0OX.x0XOIxOo
        public final synchronized void registerStringToReplace(@OXOo.OOXIXo String original, @OXOo.OOXIXo String replace) {
            IIX0o.x0xO0oo(original, "original");
            IIX0o.x0xO0oo(replace, "replace");
            Logger.stringsToReplace.put(original, replace);
        }

        private Companion() {
        }

        @XO0OX.x0XOIxOo
        public final void log(@OXOo.OOXIXo LoggingBehavior behavior, @OXOo.OOXIXo String tag, @OXOo.OOXIXo String format, @OXOo.OOXIXo Object... args) {
            IIX0o.x0xO0oo(behavior, "behavior");
            IIX0o.x0xO0oo(tag, "tag");
            IIX0o.x0xO0oo(format, "format");
            IIX0o.x0xO0oo(args, "args");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                Object[] copyOf = Arrays.copyOf(args, args.length);
                String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
                IIX0o.oO(format2, "java.lang.String.format(format, *args)");
                log(behavior, 3, tag, format2);
            }
        }

        @XO0OX.x0XOIxOo
        public final void log(@OXOo.OOXIXo LoggingBehavior behavior, int i, @OXOo.OOXIXo String tag, @OXOo.OOXIXo String format, @OXOo.OOXIXo Object... args) {
            IIX0o.x0xO0oo(behavior, "behavior");
            IIX0o.x0xO0oo(tag, "tag");
            IIX0o.x0xO0oo(format, "format");
            IIX0o.x0xO0oo(args, "args");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                Object[] copyOf = Arrays.copyOf(args, args.length);
                String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
                IIX0o.oO(format2, "java.lang.String.format(format, *args)");
                log(behavior, i, tag, format2);
            }
        }

        @XO0OX.x0XOIxOo
        public final void log(@OXOo.OOXIXo LoggingBehavior behavior, int i, @OXOo.OOXIXo String tag, @OXOo.OOXIXo String string) {
            IIX0o.x0xO0oo(behavior, "behavior");
            IIX0o.x0xO0oo(tag, "tag");
            IIX0o.x0xO0oo(string, "string");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(behavior)) {
                String replaceStrings = replaceStrings(string);
                if (!kotlin.text.OxI.IOOoXo0Ix(tag, Logger.LOG_TAG_BASE, false, 2, null)) {
                    tag = IIX0o.XIxXXX0x0(Logger.LOG_TAG_BASE, tag);
                }
                Log.println(i, tag, replaceStrings);
                if (behavior == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }
    }

    public Logger(@OXOo.OOXIXo LoggingBehavior behavior, @OXOo.OOXIXo String tag) {
        IIX0o.x0xO0oo(behavior, "behavior");
        IIX0o.x0xO0oo(tag, "tag");
        this.priority = 3;
        this.behavior = behavior;
        Validate validate = Validate.INSTANCE;
        this.tag = IIX0o.XIxXXX0x0(LOG_TAG_BASE, Validate.notNullOrEmpty(tag, "tag"));
        this.contents = new StringBuilder();
    }

    @XO0OX.x0XOIxOo
    public static final void log(@OXOo.OOXIXo LoggingBehavior loggingBehavior, int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
        Companion.log(loggingBehavior, i, str, str2);
    }

    @XO0OX.x0XOIxOo
    public static final synchronized void registerAccessToken(@OXOo.OOXIXo String str) {
        synchronized (Logger.class) {
            Companion.registerAccessToken(str);
        }
    }

    @XO0OX.x0XOIxOo
    public static final synchronized void registerStringToReplace(@OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
        synchronized (Logger.class) {
            Companion.registerStringToReplace(str, str2);
        }
    }

    private final boolean shouldLog() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }

    public final void append(@OXOo.OOXIXo StringBuilder stringBuilder) {
        IIX0o.x0xO0oo(stringBuilder, "stringBuilder");
        if (shouldLog()) {
            this.contents.append((CharSequence) stringBuilder);
        }
    }

    public final void appendKeyValue(@OXOo.OOXIXo String key, @OXOo.OOXIXo Object value) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(value, "value");
        append("  %s:\t%s\n", key, value);
    }

    @OXOo.OOXIXo
    public final String getContents() {
        Companion companion = Companion;
        String sb = this.contents.toString();
        IIX0o.oO(sb, "contents.toString()");
        return companion.replaceStrings(sb);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final void logString(@OXOo.OOXIXo String string) {
        IIX0o.x0xO0oo(string, "string");
        Companion.log(this.behavior, this.priority, this.tag, string);
    }

    public final void setPriority(int i) {
        Validate validate = Validate.INSTANCE;
        Validate.oneOf(Integer.valueOf(i), "value", 7, 3, 6, 4, 2, 5);
        setPriority(i);
    }

    @XO0OX.x0XOIxOo
    public static final void log(@OXOo.OOXIXo LoggingBehavior loggingBehavior, int i, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2, @OXOo.OOXIXo Object... objArr) {
        Companion.log(loggingBehavior, i, str, str2, objArr);
    }

    @XO0OX.x0XOIxOo
    public static final void log(@OXOo.OOXIXo LoggingBehavior loggingBehavior, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
        Companion.log(loggingBehavior, str, str2);
    }

    public final void append(@OXOo.OOXIXo String string) {
        IIX0o.x0xO0oo(string, "string");
        if (shouldLog()) {
            this.contents.append(string);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void log(@OXOo.OOXIXo LoggingBehavior loggingBehavior, @OXOo.OOXIXo String str, @OXOo.OOXIXo String str2, @OXOo.OOXIXo Object... objArr) {
        Companion.log(loggingBehavior, str, str2, objArr);
    }

    public final void append(@OXOo.OOXIXo String format, @OXOo.OOXIXo Object... args) {
        IIX0o.x0xO0oo(format, "format");
        IIX0o.x0xO0oo(args, "args");
        if (shouldLog()) {
            StringBuilder sb = this.contents;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format2 = String.format(format, Arrays.copyOf(copyOf, copyOf.length));
            IIX0o.oO(format2, "java.lang.String.format(format, *args)");
            sb.append(format2);
        }
    }

    public final void log() {
        String sb = this.contents.toString();
        IIX0o.oO(sb, "contents.toString()");
        logString(sb);
        this.contents = new StringBuilder();
    }
}
