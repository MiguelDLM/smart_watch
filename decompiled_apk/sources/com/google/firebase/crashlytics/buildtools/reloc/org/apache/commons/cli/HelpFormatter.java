package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class HelpFormatter {
    public static final String DEFAULT_ARG_NAME = "arg";
    public static final int DEFAULT_DESC_PAD = 3;
    public static final int DEFAULT_LEFT_PAD = 1;
    public static final String DEFAULT_LONG_OPT_PREFIX = "--";
    public static final String DEFAULT_LONG_OPT_SEPARATOR = " ";
    public static final String DEFAULT_OPT_PREFIX = "-";
    public static final String DEFAULT_SYNTAX_PREFIX = "usage: ";
    public static final int DEFAULT_WIDTH = 74;

    @Deprecated
    public int defaultWidth = 74;

    @Deprecated
    public int defaultLeftPad = 1;

    @Deprecated
    public int defaultDescPad = 3;

    @Deprecated
    public String defaultSyntaxPrefix = DEFAULT_SYNTAX_PREFIX;

    @Deprecated
    public String defaultNewLine = System.getProperty("line.separator");

    @Deprecated
    public String defaultOptPrefix = DEFAULT_OPT_PREFIX;

    @Deprecated
    public String defaultLongOptPrefix = DEFAULT_LONG_OPT_PREFIX;

    @Deprecated
    public String defaultArgName = DEFAULT_ARG_NAME;
    protected Comparator<Option> optionComparator = new OptionComparator();
    private String longOptSeparator = " ";

    /* loaded from: classes10.dex */
    public static class OptionComparator implements Comparator<Option>, Serializable {
        private static final long serialVersionUID = 5305467873966684014L;

        private OptionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Option option, Option option2) {
            return option.getKey().compareToIgnoreCase(option2.getKey());
        }
    }

    private void appendOption(StringBuffer stringBuffer, Option option, boolean z) {
        String str;
        String argName;
        if (!z) {
            stringBuffer.append("[");
        }
        if (option.getOpt() != null) {
            stringBuffer.append(DEFAULT_OPT_PREFIX);
            stringBuffer.append(option.getOpt());
        } else {
            stringBuffer.append(DEFAULT_LONG_OPT_PREFIX);
            stringBuffer.append(option.getLongOpt());
        }
        if (option.hasArg() && (option.getArgName() == null || option.getArgName().length() != 0)) {
            if (option.getOpt() == null) {
                str = this.longOptSeparator;
            } else {
                str = " ";
            }
            stringBuffer.append(str);
            stringBuffer.append("<");
            if (option.getArgName() != null) {
                argName = option.getArgName();
            } else {
                argName = getArgName();
            }
            stringBuffer.append(argName);
            stringBuffer.append(">");
        }
        if (!z) {
            stringBuffer.append("]");
        }
    }

    private void appendOptionGroup(StringBuffer stringBuffer, OptionGroup optionGroup) {
        if (!optionGroup.isRequired()) {
            stringBuffer.append("[");
        }
        ArrayList arrayList = new ArrayList(optionGroup.getOptions());
        if (getOptionComparator() != null) {
            Collections.sort(arrayList, getOptionComparator());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            appendOption(stringBuffer, (Option) it.next(), true);
            if (it.hasNext()) {
                stringBuffer.append(" | ");
            }
        }
        if (!optionGroup.isRequired()) {
            stringBuffer.append("]");
        }
    }

    private Appendable renderWrappedTextBlock(StringBuffer stringBuffer, int i, int i2, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
            boolean z = true;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!z) {
                    stringBuffer.append(getNewLine());
                } else {
                    z = false;
                }
                renderWrappedText(stringBuffer, i, i2, readLine);
            }
        } catch (IOException unused) {
        }
        return stringBuffer;
    }

    public String createPadding(int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, TokenParser.SP);
        return new String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findWrapPos(java.lang.String r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 10
            int r1 = r6.indexOf(r0, r8)
            r2 = -1
            if (r1 == r2) goto Le
            if (r1 > r7) goto Le
            int r1 = r1 + 1
            return r1
        Le:
            r1 = 9
            int r1 = r6.indexOf(r1, r8)
            if (r1 == r2) goto L1b
            if (r1 > r7) goto L1b
            int r1 = r1 + 1
            return r1
        L1b:
            int r7 = r7 + r8
            int r1 = r6.length()
            if (r7 < r1) goto L23
            return r2
        L23:
            r1 = r7
        L24:
            if (r1 < r8) goto L38
            char r3 = r6.charAt(r1)
            r4 = 32
            if (r3 == r4) goto L38
            if (r3 == r0) goto L38
            r4 = 13
            if (r3 != r4) goto L35
            goto L38
        L35:
            int r1 = r1 + (-1)
            goto L24
        L38:
            if (r1 <= r8) goto L3b
            return r1
        L3b:
            int r6 = r6.length()
            if (r7 != r6) goto L42
            goto L43
        L42:
            r2 = r7
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter.findWrapPos(java.lang.String, int, int):int");
    }

    public String getArgName() {
        return this.defaultArgName;
    }

    public int getDescPadding() {
        return this.defaultDescPad;
    }

    public int getLeftPadding() {
        return this.defaultLeftPad;
    }

    public String getLongOptPrefix() {
        return this.defaultLongOptPrefix;
    }

    public String getLongOptSeparator() {
        return this.longOptSeparator;
    }

    public String getNewLine() {
        return this.defaultNewLine;
    }

    public String getOptPrefix() {
        return this.defaultOptPrefix;
    }

    public Comparator<Option> getOptionComparator() {
        return this.optionComparator;
    }

    public String getSyntaxPrefix() {
        return this.defaultSyntaxPrefix;
    }

    public int getWidth() {
        return this.defaultWidth;
    }

    public void printHelp(String str, Options options) {
        printHelp(getWidth(), str, null, options, null, false);
    }

    public void printOptions(PrintWriter printWriter, int i, Options options, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        renderOptions(stringBuffer, i, options, i2, i3);
        printWriter.println(stringBuffer.toString());
    }

    public void printUsage(PrintWriter printWriter, int i, String str, Options options) {
        StringBuffer stringBuffer = new StringBuffer(getSyntaxPrefix());
        stringBuffer.append(str);
        stringBuffer.append(" ");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(options.getOptions());
        if (getOptionComparator() != null) {
            Collections.sort(arrayList2, getOptionComparator());
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Option option = (Option) it.next();
            OptionGroup optionGroup = options.getOptionGroup(option);
            if (optionGroup != null) {
                if (!arrayList.contains(optionGroup)) {
                    arrayList.add(optionGroup);
                    appendOptionGroup(stringBuffer, optionGroup);
                }
            } else {
                appendOption(stringBuffer, option, option.isRequired());
            }
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        printWrapped(printWriter, i, stringBuffer.toString().indexOf(32) + 1, stringBuffer.toString());
    }

    public void printWrapped(PrintWriter printWriter, int i, String str) {
        printWrapped(printWriter, i, 0, str);
    }

    public StringBuffer renderOptions(StringBuffer stringBuffer, int i, Options options, int i2, int i3) {
        String str;
        String argName;
        String createPadding = createPadding(i2);
        String createPadding2 = createPadding(i3);
        ArrayList arrayList = new ArrayList();
        List<Option> helpOptions = options.helpOptions();
        if (getOptionComparator() != null) {
            Collections.sort(helpOptions, getOptionComparator());
        }
        int i4 = 0;
        int i5 = 0;
        for (Option option : helpOptions) {
            StringBuffer stringBuffer2 = new StringBuffer();
            if (option.getOpt() == null) {
                stringBuffer2.append(createPadding);
                stringBuffer2.append("   ");
                stringBuffer2.append(getLongOptPrefix());
                stringBuffer2.append(option.getLongOpt());
            } else {
                stringBuffer2.append(createPadding);
                stringBuffer2.append(getOptPrefix());
                stringBuffer2.append(option.getOpt());
                if (option.hasLongOpt()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(getLongOptPrefix());
                    stringBuffer2.append(option.getLongOpt());
                }
            }
            if (option.hasArg()) {
                String argName2 = option.getArgName();
                if (argName2 != null && argName2.length() == 0) {
                    stringBuffer2.append(TokenParser.SP);
                } else {
                    if (option.hasLongOpt()) {
                        str = this.longOptSeparator;
                    } else {
                        str = " ";
                    }
                    stringBuffer2.append(str);
                    stringBuffer2.append("<");
                    if (argName2 != null) {
                        argName = option.getArgName();
                    } else {
                        argName = getArgName();
                    }
                    stringBuffer2.append(argName);
                    stringBuffer2.append(">");
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i5) {
                i5 = stringBuffer2.length();
            }
        }
        Iterator<Option> it = helpOptions.iterator();
        while (it.hasNext()) {
            Option next = it.next();
            int i6 = i4 + 1;
            StringBuilder sb = new StringBuilder(((StringBuffer) arrayList.get(i4)).toString());
            if (sb.length() < i5) {
                sb.append(createPadding(i5 - sb.length()));
            }
            sb.append(createPadding2);
            int i7 = i5 + i3;
            if (next.getDescription() != null) {
                sb.append(next.getDescription());
            }
            renderWrappedText(stringBuffer, i, i7, sb.toString());
            if (it.hasNext()) {
                stringBuffer.append(getNewLine());
            }
            i4 = i6;
        }
        return stringBuffer;
    }

    public StringBuffer renderWrappedText(StringBuffer stringBuffer, int i, int i2, String str) {
        int findWrapPos = findWrapPos(str, i, 0);
        if (findWrapPos == -1) {
            stringBuffer.append(rtrim(str));
            return stringBuffer;
        }
        stringBuffer.append(rtrim(str.substring(0, findWrapPos)));
        stringBuffer.append(getNewLine());
        if (i2 >= i) {
            i2 = 1;
        }
        String createPadding = createPadding(i2);
        while (true) {
            str = createPadding + str.substring(findWrapPos).trim();
            findWrapPos = findWrapPos(str, i, 0);
            if (findWrapPos == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i && findWrapPos == i2 - 1) {
                findWrapPos = i;
            }
            stringBuffer.append(rtrim(str.substring(0, findWrapPos)));
            stringBuffer.append(getNewLine());
        }
    }

    public String rtrim(String str) {
        if (str != null && str.length() != 0) {
            int length = str.length();
            while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
            return str.substring(0, length);
        }
        return str;
    }

    public void setArgName(String str) {
        this.defaultArgName = str;
    }

    public void setDescPadding(int i) {
        this.defaultDescPad = i;
    }

    public void setLeftPadding(int i) {
        this.defaultLeftPad = i;
    }

    public void setLongOptPrefix(String str) {
        this.defaultLongOptPrefix = str;
    }

    public void setLongOptSeparator(String str) {
        this.longOptSeparator = str;
    }

    public void setNewLine(String str) {
        this.defaultNewLine = str;
    }

    public void setOptPrefix(String str) {
        this.defaultOptPrefix = str;
    }

    public void setOptionComparator(Comparator<Option> comparator) {
        this.optionComparator = comparator;
    }

    public void setSyntaxPrefix(String str) {
        this.defaultSyntaxPrefix = str;
    }

    public void setWidth(int i) {
        this.defaultWidth = i;
    }

    public void printHelp(String str, Options options, boolean z) {
        printHelp(getWidth(), str, null, options, null, z);
    }

    public void printWrapped(PrintWriter printWriter, int i, int i2, String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        renderWrappedTextBlock(stringBuffer, i, i2, str);
        printWriter.println(stringBuffer.toString());
    }

    public void printHelp(String str, String str2, Options options, String str3) {
        printHelp(str, str2, options, str3, false);
    }

    public void printHelp(String str, String str2, Options options, String str3, boolean z) {
        printHelp(getWidth(), str, str2, options, str3, z);
    }

    public void printHelp(int i, String str, String str2, Options options, String str3) {
        printHelp(i, str, str2, options, str3, false);
    }

    public void printHelp(int i, String str, String str2, Options options, String str3, boolean z) {
        PrintWriter printWriter = new PrintWriter(System.out);
        printHelp(printWriter, i, str, str2, options, getLeftPadding(), getDescPadding(), str3, z);
        printWriter.flush();
    }

    public void printHelp(PrintWriter printWriter, int i, String str, String str2, Options options, int i2, int i3, String str3) {
        printHelp(printWriter, i, str, str2, options, i2, i3, str3, false);
    }

    public void printHelp(PrintWriter printWriter, int i, String str, String str2, Options options, int i2, int i3, String str3, boolean z) {
        if (str != null && str.length() != 0) {
            if (z) {
                printUsage(printWriter, i, str, options);
            } else {
                printUsage(printWriter, i, str);
            }
            if (str2 != null && str2.trim().length() > 0) {
                printWrapped(printWriter, i, str2);
            }
            printOptions(printWriter, i, options, i2, i3);
            if (str3 == null || str3.trim().length() <= 0) {
                return;
            }
            printWrapped(printWriter, i, str3);
            return;
        }
        throw new IllegalArgumentException("cmdLineSyntax not provided");
    }

    public void printUsage(PrintWriter printWriter, int i, String str) {
        printWrapped(printWriter, i, getSyntaxPrefix().length() + str.indexOf(32) + 1, getSyntaxPrefix() + str);
    }
}
