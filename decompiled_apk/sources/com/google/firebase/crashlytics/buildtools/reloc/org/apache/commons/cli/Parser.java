package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

@Deprecated
/* loaded from: classes10.dex */
public abstract class Parser implements CommandLineParser {
    protected CommandLine cmd;
    private Options options;
    private List requiredOptions;

    private void updateRequiredOptions(Option option) throws ParseException {
        if (option.isRequired()) {
            getRequiredOptions().remove(option.getKey());
        }
        if (getOptions().getOptionGroup(option) != null) {
            OptionGroup optionGroup = getOptions().getOptionGroup(option);
            if (optionGroup.isRequired()) {
                getRequiredOptions().remove(optionGroup);
            }
            optionGroup.setSelected(option);
        }
    }

    public void checkRequiredOptions() throws MissingOptionException {
        if (getRequiredOptions().isEmpty()) {
        } else {
            throw new MissingOptionException(getRequiredOptions());
        }
    }

    public abstract String[] flatten(Options options, String[] strArr, boolean z) throws ParseException;

    public Options getOptions() {
        return this.options;
    }

    public List getRequiredOptions() {
        return this.requiredOptions;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLineParser
    public CommandLine parse(Options options, String[] strArr) throws ParseException {
        return parse(options, strArr, null, false);
    }

    public void processArgs(Option option, ListIterator<String> listIterator) throws ParseException {
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            String next = listIterator.next();
            if (getOptions().hasOption(next) && next.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.addValueForProcessing(Util.stripLeadingAndTrailingQuotes(next));
                } catch (RuntimeException unused) {
                    listIterator.previous();
                }
            }
        }
        if (option.getValues() == null && !option.hasOptionalArg()) {
            throw new MissingArgumentException(option);
        }
    }

    public void processOption(String str, ListIterator<String> listIterator) throws ParseException {
        if (getOptions().hasOption(str)) {
            Option option = (Option) getOptions().getOption(str).clone();
            updateRequiredOptions(option);
            if (option.hasArg()) {
                processArgs(option, listIterator);
            }
            this.cmd.addOption(option);
            return;
        }
        throw new UnrecognizedOptionException("Unrecognized option: " + str, str);
    }

    public void processProperties(Properties properties) throws ParseException {
        boolean z;
        if (properties == null) {
            return;
        }
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String obj = propertyNames.nextElement().toString();
            Option option = this.options.getOption(obj);
            if (option != null) {
                OptionGroup optionGroup = this.options.getOptionGroup(option);
                if (optionGroup != null && optionGroup.getSelected() != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!this.cmd.hasOption(obj) && !z) {
                    String property = properties.getProperty(obj);
                    if (option.hasArg()) {
                        if (option.getValues() == null || option.getValues().length == 0) {
                            try {
                                option.addValueForProcessing(property);
                            } catch (RuntimeException unused) {
                            }
                        }
                    } else if (!"yes".equalsIgnoreCase(property) && !"true".equalsIgnoreCase(property) && !"1".equalsIgnoreCase(property)) {
                    }
                    this.cmd.addOption(option);
                    updateRequiredOptions(option);
                }
            } else {
                throw new UnrecognizedOptionException("Default option wasn't defined", obj);
            }
        }
    }

    public void setOptions(Options options) {
        this.options = options;
        this.requiredOptions = new ArrayList(options.getRequiredOptions());
    }

    public CommandLine parse(Options options, String[] strArr, Properties properties) throws ParseException {
        return parse(options, strArr, properties, false);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLineParser
    public CommandLine parse(Options options, String[] strArr, boolean z) throws ParseException {
        return parse(options, strArr, null, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r9 != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0050 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine parse(com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Options r6, java.lang.String[] r7, java.util.Properties r8, boolean r9) throws com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.ParseException {
        /*
            r5 = this;
            java.util.List r0 = r6.helpOptions()
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L18
            java.lang.Object r1 = r0.next()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Option r1 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Option) r1
            r1.clearValues()
            goto L8
        L18:
            java.util.Collection r0 = r6.getOptionGroups()
            java.util.Iterator r0 = r0.iterator()
        L20:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L31
            java.lang.Object r1 = r0.next()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.OptionGroup r1 = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.OptionGroup) r1
            r2 = 0
            r1.setSelected(r2)
            goto L20
        L31:
            r5.setOptions(r6)
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine r6 = new com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine
            r6.<init>()
            r5.cmd = r6
            r6 = 0
            if (r7 != 0) goto L40
            java.lang.String[] r7 = new java.lang.String[r6]
        L40:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Options r0 = r5.getOptions()
            java.lang.String[] r7 = r5.flatten(r0, r7, r9)
            java.util.List r7 = java.util.Arrays.asList(r7)
            java.util.ListIterator r7 = r7.listIterator()
        L50:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Lb6
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "--"
            boolean r2 = r1.equals(r0)
            r3 = 1
            if (r2 == 0) goto L67
        L65:
            r6 = 1
            goto L9c
        L67:
            java.lang.String r2 = "-"
            boolean r4 = r2.equals(r0)
            if (r4 == 0) goto L78
            if (r9 == 0) goto L72
            goto L65
        L72:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine r2 = r5.cmd
            r2.addArg(r0)
            goto L9c
        L78:
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L94
            if (r9 == 0) goto L90
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Options r2 = r5.getOptions()
            boolean r2 = r2.hasOption(r0)
            if (r2 != 0) goto L90
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine r6 = r5.cmd
            r6.addArg(r0)
            goto L65
        L90:
            r5.processOption(r0, r7)
            goto L9c
        L94:
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine r2 = r5.cmd
            r2.addArg(r0)
            if (r9 == 0) goto L9c
            goto L65
        L9c:
            if (r6 == 0) goto L50
        L9e:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L50
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = r1.equals(r0)
            if (r2 != 0) goto L9e
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine r2 = r5.cmd
            r2.addArg(r0)
            goto L9e
        Lb6:
            r5.processProperties(r8)
            r5.checkRequiredOptions()
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine r6 = r5.cmd
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Parser.parse(com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Options, java.lang.String[], java.util.Properties, boolean):com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.CommandLine");
    }
}
