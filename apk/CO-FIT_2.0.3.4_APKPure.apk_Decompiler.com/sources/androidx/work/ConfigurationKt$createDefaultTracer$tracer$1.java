package androidx.work;

import androidx.tracing.Trace;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.IIX0o;

public final class ConfigurationKt$createDefaultTracer$tracer$1 implements Tracer {
    public void beginAsyncSection(String str, int i) {
        IIX0o.x0xO0oo(str, "methodName");
        Trace.beginAsyncSection(str, i);
    }

    public void beginSection(String str) {
        IIX0o.x0xO0oo(str, TTDownloadField.TT_LABEL);
        Trace.beginSection(str);
    }

    public void endAsyncSection(String str, int i) {
        IIX0o.x0xO0oo(str, "methodName");
        Trace.endAsyncSection(str, i);
    }

    public void endSection() {
        Trace.endSection();
    }

    public boolean isEnabled() {
        return Trace.isEnabled();
    }
}
