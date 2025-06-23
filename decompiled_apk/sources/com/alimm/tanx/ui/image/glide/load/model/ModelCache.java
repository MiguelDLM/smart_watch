package com.alimm.tanx.ui.image.glide.load.model;

import com.alimm.tanx.ui.image.glide.util.LruCache;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    /* loaded from: classes.dex */
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a2, int i, int i2) {
            ModelKey<A> modelKey = (ModelKey) KEY_QUEUE.poll();
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            ((ModelKey) modelKey).model = a2;
            ((ModelKey) modelKey).width = i;
            ((ModelKey) modelKey).height = i2;
            return modelKey;
        }

        private void init(A a2, int i, int i2) {
            this.model = a2;
            this.width = i;
            this.height = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.width != modelKey.width || this.height != modelKey.height || !this.model.equals(modelKey.model)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.model.hashCode() + (((this.height * 31) + this.width) * 31);
        }

        public void release() {
            KEY_QUEUE.offer(this);
        }
    }

    public ModelCache() {
        this(250);
    }

    public B get(A a2, int i, int i2) {
        ModelKey<A> modelKey = ModelKey.get(a2, i, i2);
        B b = this.cache.get(modelKey);
        modelKey.release();
        return b;
    }

    public void put(A a2, int i, int i2, B b) {
        this.cache.put(ModelKey.get(a2, i, i2), b);
    }

    public ModelCache(int i) {
        this.cache = new LruCache<ModelKey<A>, B>(i) { // from class: com.alimm.tanx.ui.image.glide.load.model.ModelCache.1
            @Override // com.alimm.tanx.ui.image.glide.util.LruCache
            public /* bridge */ /* synthetic */ void onItemEvicted(Object obj, Object obj2) {
                onItemEvicted((ModelKey) obj, (ModelKey<A>) obj2);
            }

            public void onItemEvicted(ModelKey<A> modelKey, B b) {
                modelKey.release();
            }
        };
    }
}
