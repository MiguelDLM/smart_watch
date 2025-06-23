package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: classes.dex */
public class UnitTransformation<T> implements Transformation<T> {
    private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation) TRANSFORMATION;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Transformation
    public Resource<T> transform(Resource<T> resource, int i, int i2) {
        return resource;
    }
}
