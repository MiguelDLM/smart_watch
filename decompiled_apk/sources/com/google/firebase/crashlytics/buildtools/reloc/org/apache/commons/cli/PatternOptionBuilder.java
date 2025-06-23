package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Option;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;

/* loaded from: classes10.dex */
public class PatternOptionBuilder {
    public static final Class<String> STRING_VALUE = String.class;
    public static final Class<Object> OBJECT_VALUE = Object.class;
    public static final Class<Number> NUMBER_VALUE = Number.class;
    public static final Class<Date> DATE_VALUE = Date.class;
    public static final Class<?> CLASS_VALUE = Class.class;
    public static final Class<FileInputStream> EXISTING_FILE_VALUE = FileInputStream.class;
    public static final Class<File> FILE_VALUE = File.class;
    public static final Class<File[]> FILES_VALUE = File[].class;
    public static final Class<URL> URL_VALUE = URL.class;

    public static Object getValueClass(char c) {
        if (c != '#') {
            if (c != '%') {
                if (c != '/') {
                    if (c != ':') {
                        if (c != '<') {
                            if (c != '>') {
                                if (c != '@') {
                                    if (c != '*') {
                                        if (c != '+') {
                                            return null;
                                        }
                                        return CLASS_VALUE;
                                    }
                                    return FILES_VALUE;
                                }
                                return OBJECT_VALUE;
                            }
                            return FILE_VALUE;
                        }
                        return EXISTING_FILE_VALUE;
                    }
                    return STRING_VALUE;
                }
                return URL_VALUE;
            }
            return NUMBER_VALUE;
        }
        return DATE_VALUE;
    }

    public static boolean isValueCode(char c) {
        return c == '@' || c == ':' || c == '%' || c == '+' || c == '#' || c == '<' || c == '>' || c == '*' || c == '/' || c == '!';
    }

    public static Options parsePattern(String str) {
        Options options = new Options();
        boolean z = false;
        Class<?> cls = null;
        int i = 0;
        char c = TokenParser.SP;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            if (i >= str.length()) {
                break;
            }
            char charAt = str.charAt(i);
            if (!isValueCode(charAt)) {
                if (c != ' ') {
                    Option.Builder builder = Option.builder(String.valueOf(c));
                    if (cls == null) {
                        z3 = false;
                    }
                    options.addOption(builder.hasArg(z3).required(z2).type(cls).build());
                    cls = null;
                    z2 = false;
                }
                c = charAt;
            } else if (charAt == '!') {
                z2 = true;
            } else {
                cls = (Class) getValueClass(charAt);
            }
            i++;
        }
        if (c != ' ') {
            Option.Builder builder2 = Option.builder(String.valueOf(c));
            if (cls != null) {
                z = true;
            }
            options.addOption(builder2.hasArg(z).required(z2).type(cls).build());
        }
        return options;
    }
}
