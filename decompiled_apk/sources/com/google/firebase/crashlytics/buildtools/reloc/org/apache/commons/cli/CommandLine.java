package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/* loaded from: classes10.dex */
public class CommandLine implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<String> args = new LinkedList();
    private final List<Option> options = new ArrayList();

    /* loaded from: classes10.dex */
    public static final class Builder {
        private final CommandLine commandLine = new CommandLine();

        public Builder addArg(String str) {
            this.commandLine.addArg(str);
            return this;
        }

        public Builder addOption(Option option) {
            this.commandLine.addOption(option);
            return this;
        }

        public CommandLine build() {
            return this.commandLine;
        }
    }

    private Option resolveOption(String str) {
        String stripLeadingHyphens = Util.stripLeadingHyphens(str);
        for (Option option : this.options) {
            if (stripLeadingHyphens.equals(option.getOpt())) {
                return option;
            }
            if (stripLeadingHyphens.equals(option.getLongOpt())) {
                return option;
            }
        }
        return null;
    }

    public void addArg(String str) {
        this.args.add(str);
    }

    public void addOption(Option option) {
        this.options.add(option);
    }

    public List<String> getArgList() {
        return this.args;
    }

    public String[] getArgs() {
        String[] strArr = new String[this.args.size()];
        this.args.toArray(strArr);
        return strArr;
    }

    @Deprecated
    public Object getOptionObject(String str) {
        try {
            return getParsedOptionValue(str);
        } catch (ParseException e) {
            System.err.println("Exception found converting " + str + " to desired type: " + e.getMessage());
            return null;
        }
    }

    public Properties getOptionProperties(String str) {
        Properties properties = new Properties();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                List<String> valuesList = option.getValuesList();
                if (valuesList.size() >= 2) {
                    properties.put(valuesList.get(0), valuesList.get(1));
                } else if (valuesList.size() == 1) {
                    properties.put(valuesList.get(0), "true");
                }
            }
        }
        return properties;
    }

    public String getOptionValue(String str) {
        String[] optionValues = getOptionValues(str);
        if (optionValues == null) {
            return null;
        }
        return optionValues[0];
    }

    public String[] getOptionValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                arrayList.addAll(option.getValuesList());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Option[] getOptions() {
        List<Option> list = this.options;
        return (Option[]) list.toArray(new Option[list.size()]);
    }

    public Object getParsedOptionValue(String str) throws ParseException {
        String optionValue = getOptionValue(str);
        Option resolveOption = resolveOption(str);
        if (resolveOption != null && optionValue != null) {
            return TypeHandler.createValue(optionValue, resolveOption.getType());
        }
        return null;
    }

    public boolean hasOption(String str) {
        return this.options.contains(resolveOption(str));
    }

    public Iterator<Option> iterator() {
        return this.options.iterator();
    }

    public boolean hasOption(char c) {
        return hasOption(String.valueOf(c));
    }

    public Object getOptionObject(char c) {
        return getOptionObject(String.valueOf(c));
    }

    public String getOptionValue(char c) {
        return getOptionValue(String.valueOf(c));
    }

    public String getOptionValue(String str, String str2) {
        String optionValue = getOptionValue(str);
        return optionValue != null ? optionValue : str2;
    }

    public String getOptionValue(char c, String str) {
        return getOptionValue(String.valueOf(c), str);
    }

    public String[] getOptionValues(char c) {
        return getOptionValues(String.valueOf(c));
    }
}
