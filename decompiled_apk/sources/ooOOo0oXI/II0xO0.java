package ooOOo0oXI;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public List<OxxIIOOXO> f32326oIX0oI = new ArrayList();

    public void II0xO0(Path path) {
        for (int size = this.f32326oIX0oI.size() - 1; size >= 0; size--) {
            IIXOooo.xoIox.II0xO0(path, this.f32326oIX0oI.get(size));
        }
    }

    public void oIX0oI(OxxIIOOXO oxxIIOOXO) {
        this.f32326oIX0oI.add(oxxIIOOXO);
    }
}
