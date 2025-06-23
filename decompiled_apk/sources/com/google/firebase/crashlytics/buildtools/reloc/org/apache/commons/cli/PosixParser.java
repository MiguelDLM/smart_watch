package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes10.dex */
public class PosixParser extends Parser {
    private Option currentOption;
    private boolean eatTheRest;
    private Options options;
    private final List<String> tokens = new ArrayList();

    private void gobble(Iterator<String> it) {
        if (this.eatTheRest) {
            while (it.hasNext()) {
                this.tokens.add(it.next());
            }
        }
    }

    private void init() {
        this.eatTheRest = false;
        this.tokens.clear();
    }

    private void processNonOptionToken(String str, boolean z) {
        Option option;
        if (z && ((option = this.currentOption) == null || !option.hasArg())) {
            this.eatTheRest = true;
            this.tokens.add(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        }
        this.tokens.add(str);
    }

    private void processOptionToken(String str, boolean z) {
        if (z && !this.options.hasOption(str)) {
            this.eatTheRest = true;
        }
        if (this.options.hasOption(str)) {
            this.currentOption = this.options.getOption(str);
        }
        this.tokens.add(str);
    }

    public void burstToken(String str, boolean z) {
        int i;
        for (int i2 = 1; i2 < str.length(); i2++) {
            String valueOf = String.valueOf(str.charAt(i2));
            if (this.options.hasOption(valueOf)) {
                this.tokens.add(HelpFormatter.DEFAULT_OPT_PREFIX + valueOf);
                Option option = this.options.getOption(valueOf);
                this.currentOption = option;
                if (option.hasArg() && str.length() != (i = i2 + 1)) {
                    this.tokens.add(str.substring(i));
                    return;
                }
            } else if (z) {
                processNonOptionToken(str.substring(i2), true);
                return;
            } else {
                this.tokens.add(str);
                return;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.Parser
    public String[] flatten(Options options, String[] strArr, boolean z) throws ParseException {
        String substring;
        init();
        this.options = options;
        Iterator<String> it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!HelpFormatter.DEFAULT_OPT_PREFIX.equals(next) && !HelpFormatter.DEFAULT_LONG_OPT_PREFIX.equals(next)) {
                if (next.startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
                    int indexOf = next.indexOf(61);
                    if (indexOf == -1) {
                        substring = next;
                    } else {
                        substring = next.substring(0, indexOf);
                    }
                    List<String> matchingOptions = options.getMatchingOptions(substring);
                    if (matchingOptions.isEmpty()) {
                        processNonOptionToken(next, z);
                    } else if (matchingOptions.size() <= 1) {
                        this.currentOption = options.getOption(matchingOptions.get(0));
                        this.tokens.add(HelpFormatter.DEFAULT_LONG_OPT_PREFIX + this.currentOption.getLongOpt());
                        if (indexOf != -1) {
                            this.tokens.add(next.substring(indexOf + 1));
                        }
                    } else {
                        throw new AmbiguousOptionException(substring, matchingOptions);
                    }
                } else if (next.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX)) {
                    if (next.length() != 2 && !options.hasOption(next)) {
                        if (!options.getMatchingOptions(next).isEmpty()) {
                            List<String> matchingOptions2 = options.getMatchingOptions(next);
                            if (matchingOptions2.size() <= 1) {
                                processOptionToken(HelpFormatter.DEFAULT_OPT_PREFIX + options.getOption(matchingOptions2.get(0)).getLongOpt(), z);
                            } else {
                                throw new AmbiguousOptionException(next, matchingOptions2);
                            }
                        } else {
                            burstToken(next, z);
                        }
                    } else {
                        processOptionToken(next, z);
                    }
                } else {
                    processNonOptionToken(next, z);
                }
            } else {
                this.tokens.add(next);
            }
            gobble(it);
        }
        List<String> list = this.tokens;
        return (String[]) list.toArray(new String[list.size()]);
    }
}
