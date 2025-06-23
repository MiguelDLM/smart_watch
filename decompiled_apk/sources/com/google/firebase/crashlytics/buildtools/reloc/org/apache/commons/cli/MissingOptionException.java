package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class MissingOptionException extends ParseException {
    private static final long serialVersionUID = 8161889051578563249L;
    private List missingOptions;

    public MissingOptionException(String str) {
        super(str);
    }

    private static String createMessage(List<?> list) {
        String str;
        StringBuilder sb = new StringBuilder("Missing required option");
        if (list.size() == 1) {
            str = "";
        } else {
            str = "s";
        }
        sb.append(str);
        sb.append(": ");
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public List getMissingOptions() {
        return this.missingOptions;
    }

    public MissingOptionException(List list) {
        this(createMessage(list));
        this.missingOptions = list;
    }
}
