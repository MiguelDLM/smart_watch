package com.alimm.tanx.ui.image.glide.load.model;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class GenericLoaderFactory {
    private static final ModelLoader NULL_MODEL_LOADER = new ModelLoader() { // from class: com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory.1
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
        public DataFetcher getResourceFetcher(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    };
    private final Context context;
    private final Map<Class, Map<Class, ModelLoaderFactory>> modelClassToResourceFactories = new HashMap();
    private final Map<Class, Map<Class, ModelLoader>> cachedModelLoaders = new HashMap();

    public GenericLoaderFactory(Context context) {
        this.context = context.getApplicationContext();
    }

    private <T, Y> void cacheModelLoader(Class<T> cls, Class<Y> cls2, ModelLoader<T, Y> modelLoader) {
        Map<Class, ModelLoader> map = this.cachedModelLoaders.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.cachedModelLoaders.put(cls, map);
        }
        map.put(cls2, modelLoader);
    }

    private <T, Y> void cacheNullLoader(Class<T> cls, Class<Y> cls2) {
        cacheModelLoader(cls, cls2, NULL_MODEL_LOADER);
    }

    private <T, Y> ModelLoader<T, Y> getCachedLoader(Class<T> cls, Class<Y> cls2) {
        Map<Class, ModelLoader> map = this.cachedModelLoaders.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> ModelLoaderFactory<T, Y> getFactory(Class<T> cls, Class<Y> cls2) {
        ModelLoaderFactory modelLoaderFactory;
        Map<Class, ModelLoaderFactory> map;
        Map<Class, ModelLoaderFactory> map2 = this.modelClassToResourceFactories.get(cls);
        if (map2 != null) {
            modelLoaderFactory = map2.get(cls2);
        } else {
            modelLoaderFactory = null;
        }
        if (modelLoaderFactory == null) {
            for (Class cls3 : this.modelClassToResourceFactories.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.modelClassToResourceFactories.get(cls3)) != null && (modelLoaderFactory = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return modelLoaderFactory;
    }

    @Deprecated
    public synchronized <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> cls, Class<Y> cls2, Context context) {
        return buildModelLoader(cls, cls2);
    }

    public synchronized <T, Y> ModelLoaderFactory<T, Y> register(Class<T> cls, Class<Y> cls2, ModelLoaderFactory<T, Y> modelLoaderFactory) {
        ModelLoaderFactory<T, Y> put;
        try {
            this.cachedModelLoaders.clear();
            Map<Class, ModelLoaderFactory> map = this.modelClassToResourceFactories.get(cls);
            if (map == null) {
                map = new HashMap<>();
                this.modelClassToResourceFactories.put(cls, map);
            }
            put = map.put(cls2, modelLoaderFactory);
            if (put != null) {
                Iterator<Map<Class, ModelLoaderFactory>> it = this.modelClassToResourceFactories.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().containsValue(put)) {
                        put = null;
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return put;
    }

    public synchronized <T, Y> ModelLoaderFactory<T, Y> unregister(Class<T> cls, Class<Y> cls2) {
        ModelLoaderFactory<T, Y> modelLoaderFactory;
        this.cachedModelLoaders.clear();
        Map<Class, ModelLoaderFactory> map = this.modelClassToResourceFactories.get(cls);
        if (map != null) {
            modelLoaderFactory = map.remove(cls2);
        } else {
            modelLoaderFactory = null;
        }
        return modelLoaderFactory;
    }

    public synchronized <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> cls, Class<Y> cls2) {
        ModelLoader<T, Y> cachedLoader = getCachedLoader(cls, cls2);
        if (cachedLoader != null) {
            if (NULL_MODEL_LOADER.equals(cachedLoader)) {
                return null;
            }
            return cachedLoader;
        }
        ModelLoaderFactory<T, Y> factory = getFactory(cls, cls2);
        if (factory != null) {
            cachedLoader = factory.build(this.context, this);
            cacheModelLoader(cls, cls2, cachedLoader);
        } else {
            cacheNullLoader(cls, cls2);
        }
        return cachedLoader;
    }
}
