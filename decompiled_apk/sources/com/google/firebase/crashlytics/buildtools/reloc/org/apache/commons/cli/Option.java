package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class Option implements Cloneable, Serializable {
    public static final int UNINITIALIZED = -1;
    public static final int UNLIMITED_VALUES = -2;
    private static final long serialVersionUID = 1;
    private String argName;
    private String description;
    private String longOpt;
    private int numberOfArgs;
    private final String opt;
    private boolean optionalArg;
    private boolean required;
    private Class<?> type;
    private List<String> values;
    private char valuesep;

    /* loaded from: classes10.dex */
    public static final class Builder {
        private String argName;
        private String description;
        private String longOpt;
        private int numberOfArgs;
        private final String opt;
        private boolean optionalArg;
        private boolean required;
        private Class<?> type;
        private char valuesep;

        public Builder argName(String str) {
            this.argName = str;
            return this;
        }

        public Option build() {
            if (this.opt == null && this.longOpt == null) {
                throw new IllegalArgumentException("Either opt or longOpt must be specified");
            }
            return new Option(this);
        }

        public Builder desc(String str) {
            this.description = str;
            return this;
        }

        public Builder hasArg() {
            return hasArg(true);
        }

        public Builder hasArgs() {
            this.numberOfArgs = -2;
            return this;
        }

        public Builder longOpt(String str) {
            this.longOpt = str;
            return this;
        }

        public Builder numberOfArgs(int i) {
            this.numberOfArgs = i;
            return this;
        }

        public Builder optionalArg(boolean z) {
            this.optionalArg = z;
            return this;
        }

        public Builder required() {
            return required(true);
        }

        public Builder type(Class<?> cls) {
            this.type = cls;
            return this;
        }

        public Builder valueSeparator() {
            return valueSeparator('=');
        }

        private Builder(String str) throws IllegalArgumentException {
            this.numberOfArgs = -1;
            this.type = String.class;
            OptionValidator.validateOption(str);
            this.opt = str;
        }

        public Builder hasArg(boolean z) {
            this.numberOfArgs = z ? 1 : -1;
            return this;
        }

        public Builder required(boolean z) {
            this.required = z;
            return this;
        }

        public Builder valueSeparator(char c) {
            this.valuesep = c;
            return this;
        }
    }

    private void add(String str) {
        if (acceptsArg()) {
            this.values.add(str);
            return;
        }
        throw new RuntimeException("Cannot add value, list full.");
    }

    public static Builder builder() {
        return builder(null);
    }

    private boolean hasNoValues() {
        return this.values.isEmpty();
    }

    private void processValue(String str) {
        if (hasValueSeparator()) {
            char valueSeparator = getValueSeparator();
            int indexOf = str.indexOf(valueSeparator);
            while (indexOf != -1 && this.values.size() != this.numberOfArgs - 1) {
                add(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(valueSeparator);
            }
        }
        add(str);
    }

    public boolean acceptsArg() {
        if ((!hasArg() && !hasArgs() && !hasOptionalArg()) || (this.numberOfArgs > 0 && this.values.size() >= this.numberOfArgs)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean addValue(String str) {
        throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
    }

    public void addValueForProcessing(String str) {
        if (this.numberOfArgs != -1) {
            processValue(str);
            return;
        }
        throw new RuntimeException("NO_ARGS_ALLOWED");
    }

    public void clearValues() {
        this.values.clear();
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.values = new ArrayList(this.values);
            return option;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("A CloneNotSupportedException was thrown: " + e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Option option = (Option) obj;
        String str = this.opt;
        if (str == null ? option.opt != null : !str.equals(option.opt)) {
            return false;
        }
        String str2 = this.longOpt;
        String str3 = option.longOpt;
        if (str2 == null ? str3 == null : str2.equals(str3)) {
            return true;
        }
        return false;
    }

    public String getArgName() {
        return this.argName;
    }

    public int getArgs() {
        return this.numberOfArgs;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return getKey().charAt(0);
    }

    public String getKey() {
        String str = this.opt;
        if (str == null) {
            return this.longOpt;
        }
        return str;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public String getOpt() {
        return this.opt;
    }

    public Object getType() {
        return this.type;
    }

    public String getValue() {
        if (hasNoValues()) {
            return null;
        }
        return this.values.get(0);
    }

    public char getValueSeparator() {
        return this.valuesep;
    }

    public String[] getValues() {
        if (hasNoValues()) {
            return null;
        }
        List<String> list = this.values;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public List<String> getValuesList() {
        return this.values;
    }

    public boolean hasArg() {
        int i = this.numberOfArgs;
        if (i <= 0 && i != -2) {
            return false;
        }
        return true;
    }

    public boolean hasArgName() {
        String str = this.argName;
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    public boolean hasArgs() {
        int i = this.numberOfArgs;
        if (i > 1 || i == -2) {
            return true;
        }
        return false;
    }

    public boolean hasLongOpt() {
        if (this.longOpt != null) {
            return true;
        }
        return false;
    }

    public boolean hasOptionalArg() {
        return this.optionalArg;
    }

    public boolean hasValueSeparator() {
        if (this.valuesep > 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        String str = this.opt;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = i * 31;
        String str2 = this.longOpt;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public boolean isRequired() {
        return this.required;
    }

    public boolean requiresArg() {
        if (this.optionalArg) {
            return false;
        }
        if (this.numberOfArgs == -2) {
            return this.values.isEmpty();
        }
        return acceptsArg();
    }

    public void setArgName(String str) {
        this.argName = str;
    }

    public void setArgs(int i) {
        this.numberOfArgs = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLongOpt(String str) {
        this.longOpt = str;
    }

    public void setOptionalArg(boolean z) {
        this.optionalArg = z;
    }

    public void setRequired(boolean z) {
        this.required = z;
    }

    @Deprecated
    public void setType(Object obj) {
        setType((Class<?>) obj);
    }

    public void setValueSeparator(char c) {
        this.valuesep = c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ option: ");
        sb.append(this.opt);
        if (this.longOpt != null) {
            sb.append(" ");
            sb.append(this.longOpt);
        }
        sb.append(" ");
        if (hasArgs()) {
            sb.append("[ARG...]");
        } else if (hasArg()) {
            sb.append(" [ARG]");
        }
        sb.append(" :: ");
        sb.append(this.description);
        if (this.type != null) {
            sb.append(" :: ");
            sb.append(this.type);
        }
        sb.append(" ]");
        return sb.toString();
    }

    private Option(Builder builder) {
        this.numberOfArgs = -1;
        this.type = String.class;
        this.values = new ArrayList();
        this.argName = builder.argName;
        this.description = builder.description;
        this.longOpt = builder.longOpt;
        this.numberOfArgs = builder.numberOfArgs;
        this.opt = builder.opt;
        this.optionalArg = builder.optionalArg;
        this.required = builder.required;
        this.type = builder.type;
        this.valuesep = builder.valuesep;
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public String getValue(int i) throws IndexOutOfBoundsException {
        if (hasNoValues()) {
            return null;
        }
        return this.values.get(i);
    }

    public void setType(Class<?> cls) {
        this.type = cls;
    }

    public String getValue(String str) {
        String value = getValue();
        return value != null ? value : str;
    }

    public Option(String str, String str2) throws IllegalArgumentException {
        this(str, null, false, str2);
    }

    public Option(String str, boolean z, String str2) throws IllegalArgumentException {
        this(str, null, z, str2);
    }

    public Option(String str, String str2, boolean z, String str3) throws IllegalArgumentException {
        this.numberOfArgs = -1;
        this.type = String.class;
        this.values = new ArrayList();
        OptionValidator.validateOption(str);
        this.opt = str;
        this.longOpt = str2;
        if (z) {
            this.numberOfArgs = 1;
        }
        this.description = str3;
    }
}
