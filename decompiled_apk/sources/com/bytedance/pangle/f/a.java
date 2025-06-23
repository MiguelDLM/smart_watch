package com.bytedance.pangle.f;

import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.i;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends c.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f10545a;

    public static a b() {
        if (f10545a == null) {
            synchronized (a.class) {
                try {
                    if (f10545a == null) {
                        f10545a = new a();
                    }
                } finally {
                }
            }
        }
        return f10545a;
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i, d dVar) {
        Zeus.registerPluginStateListener(new c(dVar, i));
    }

    @Override // com.bytedance.pangle.c
    public final void a(int i) {
        ZeusPluginStateListener zeusPluginStateListener;
        List<ZeusPluginStateListener> list = i.a().b;
        Iterator<ZeusPluginStateListener> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                zeusPluginStateListener = null;
                break;
            }
            zeusPluginStateListener = it.next();
            if ((zeusPluginStateListener instanceof c) && ((c) zeusPluginStateListener).f10552a == i) {
                break;
            }
        }
        if (zeusPluginStateListener != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    @Override // com.bytedance.pangle.c
    public final int b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
