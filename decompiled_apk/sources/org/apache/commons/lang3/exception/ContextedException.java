package org.apache.commons.lang3.exception;

import IO0xX.II0xO0;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes6.dex */
public class ContextedException extends Exception implements II0xO0 {
    private static final long serialVersionUID = 20110706;
    private final II0xO0 exceptionContext;

    public ContextedException() {
        this.exceptionContext = new DefaultExceptionContext();
    }

    @Override // IO0xX.II0xO0
    public List<Pair<String, Object>> getContextEntries() {
        return this.exceptionContext.getContextEntries();
    }

    @Override // IO0xX.II0xO0
    public Set<String> getContextLabels() {
        return this.exceptionContext.getContextLabels();
    }

    @Override // IO0xX.II0xO0
    public List<Object> getContextValues(String str) {
        return this.exceptionContext.getContextValues(str);
    }

    @Override // IO0xX.II0xO0
    public Object getFirstContextValue(String str) {
        return this.exceptionContext.getFirstContextValue(str);
    }

    @Override // IO0xX.II0xO0
    public String getFormattedExceptionMessage(String str) {
        return this.exceptionContext.getFormattedExceptionMessage(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getFormattedExceptionMessage(super.getMessage());
    }

    public String getRawMessage() {
        return super.getMessage();
    }

    @Override // IO0xX.II0xO0
    public ContextedException addContextValue(String str, Object obj) {
        this.exceptionContext.addContextValue(str, obj);
        return this;
    }

    @Override // IO0xX.II0xO0
    public ContextedException setContextValue(String str, Object obj) {
        this.exceptionContext.setContextValue(str, obj);
        return this;
    }

    public ContextedException(String str) {
        super(str);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(Throwable th) {
        super(th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(String str, Throwable th) {
        super(str, th);
        this.exceptionContext = new DefaultExceptionContext();
    }

    public ContextedException(String str, Throwable th, II0xO0 iI0xO0) {
        super(str, th);
        this.exceptionContext = iI0xO0 == null ? new DefaultExceptionContext() : iI0xO0;
    }
}
