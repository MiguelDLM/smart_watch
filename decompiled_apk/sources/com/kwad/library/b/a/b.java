package com.kwad.library.b.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tenmeter.smlibrary.utils.FileUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> aju;
    private final List<String> ajv;
    private final ClassLoader ajw;

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.ajw = classLoader;
        this.aju = list;
        this.ajv = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        Log.i("PluginClassLoader", "mParent is " + classLoader.getClass().getName());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        if (TextUtils.isEmpty(findLibrary) && (this.ajw instanceof BaseDexClassLoader)) {
            return ((BaseDexClassLoader) this.ajw).findLibrary(str);
        }
        return findLibrary;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) {
        List<String> list = this.aju;
        if (list != null && list.contains(str)) {
            Log.i("PluginClassLoader", "loadClass " + str + " from host by interface");
            return super.loadClass(str, z);
        }
        List<String> list2 = this.ajv;
        if (list2 != null) {
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + FileUtils.FILE_EXTENSION_SEPARATOR)) {
                    return super.loadClass(str, z);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e2) {
                e2.addSuppressed(e);
                throw e2;
            }
        }
    }
}
