package com.bumptech.glide.util;

/* loaded from: classes8.dex */
public final class GlideSuppliers {

    /* loaded from: classes8.dex */
    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> GlideSupplier<T> memorize(final GlideSupplier<T> glideSupplier) {
        return new GlideSupplier<T>() { // from class: com.bumptech.glide.util.GlideSuppliers.1
            private volatile T instance;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public T get() {
                if (this.instance == null) {
                    synchronized (this) {
                        try {
                            if (this.instance == null) {
                                this.instance = (T) Preconditions.checkNotNull(GlideSupplier.this.get());
                            }
                        } finally {
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}
