package org.apache.commons.lang3.exception;

import IO0xX.I0Io;
import IO0xX.II0xO0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.lang3.exception.DefaultExceptionContext;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.xXOx;

/* loaded from: classes6.dex */
public class DefaultExceptionContext implements II0xO0, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setContextValue$0(String str, Pair pair) {
        return xXOx.x0o(str, (CharSequence) pair.getKey());
    }

    @Override // IO0xX.II0xO0
    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    @Override // IO0xX.II0xO0
    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        Iterator<Pair<String, Object>> it = this.contextValues.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getKey());
        }
        return hashSet;
    }

    @Override // IO0xX.II0xO0
    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair<String, Object> pair : this.contextValues) {
            if (xXOx.x0o(str, pair.getKey())) {
                arrayList.add(pair.getValue());
            }
        }
        return arrayList;
    }

    @Override // IO0xX.II0xO0
    public Object getFirstContextValue(String str) {
        for (Pair<String, Object> pair : this.contextValues) {
            if (xXOx.x0o(str, pair.getKey())) {
                return pair.getValue();
            }
        }
        return null;
    }

    @Override // IO0xX.II0xO0
    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (!this.contextValues.isEmpty()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append("Exception Context:\n");
            int i = 0;
            for (Pair<String, Object> pair : this.contextValues) {
                sb.append("\t[");
                i++;
                sb.append(i);
                sb.append(':');
                sb.append(pair.getKey());
                sb.append("=");
                Object value = pair.getValue();
                if (value == null) {
                    sb.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e) {
                        str2 = "Exception thrown on toString(): " + I0Io.oOoXoXO(e);
                    }
                    sb.append(str2);
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }

    @Override // IO0xX.II0xO0
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    @Override // IO0xX.II0xO0
    public DefaultExceptionContext setContextValue(final String str, Object obj) {
        this.contextValues.removeIf(new Predicate() { // from class: IO0xX.oIX0oI
            @Override // java.util.function.Predicate
            public final boolean test(Object obj2) {
                boolean lambda$setContextValue$0;
                lambda$setContextValue$0 = DefaultExceptionContext.lambda$setContextValue$0(str, (Pair) obj2);
                return lambda$setContextValue$0;
            }
        });
        addContextValue(str, obj);
        return this;
    }
}
