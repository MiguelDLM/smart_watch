package androidx.lifecycle;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import com.huawei.openalliance.ad.constant.bn;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    @OOXIXo
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OOXIXo
    public LifecycleOwner create(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        AppInitializer instance = AppInitializer.getInstance(context);
        IIX0o.oO(instance, "getInstance(context)");
        if (instance.isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            LifecycleDispatcher.init(context);
            ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.Companion;
            companion.init$lifecycle_process_release(context);
            return companion.get();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
    }
}
