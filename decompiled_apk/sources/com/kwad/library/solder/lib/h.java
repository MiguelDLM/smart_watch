package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes11.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        Objects.toString(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.ajN.yh());
        q.X(file3);
        Iterator<String> it = com.kwad.library.solder.lib.d.c.b(file, file3).iterator();
        while (it.hasNext()) {
            File a2 = com.kwad.library.solder.lib.d.c.a(file3, it.next(), file2);
            if (a2 != null) {
                hashSet.add(a2);
            }
        }
        q.R(file3);
        return hashSet;
    }

    private void c(Set<File> set) {
        com.kwad.library.solder.lib.c.b bVar = this.ako;
        if (bVar != null && bVar.alb.size() > 0 && set != null) {
            for (Map.Entry<String, String> entry : this.ako.alb.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    for (File file : set) {
                        String ab = ae.ab(file);
                        if (file.getName().equals(key)) {
                            if (!TextUtils.equals(ab, value)) {
                                d(set);
                                throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + ab + ",except " + value), 4008);
                            }
                        }
                    }
                    throw new PluginError.LoadError(new Exception(key + " not found"), 4001);
                }
            }
        }
    }

    private static void d(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            q.R(it.next());
        }
    }

    private File f(File file) {
        File file2 = new File(file.getParentFile(), this.ajN.yg());
        q.X(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void h(Context context, String str) {
        ClassLoader classLoader;
        super.h(context, str);
        getId();
        File file = new File(str);
        try {
            File f = f(file);
            this.aki = f;
            try {
                try {
                    c(a(context, file, f));
                    com.kwad.library.solder.lib.c.b bVar = this.ako;
                    if (bVar == null || (classLoader = bVar.ale) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            try {
                                com.kwad.library.solder.lib.ext.d.c(classLoader, this.aki);
                            } finally {
                                PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (PluginError.LoadError e) {
                    q.R(file);
                    throw e;
                }
            } catch (IOException th2) {
                throw new PluginError.LoadError(th2, r1);
            }
        } catch (IOException e2) {
            throw new PluginError.LoadError(e2, 4003);
        }
    }
}
