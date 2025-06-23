package x0XOIxOo;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final List<Mask> f33964I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<oIX0oI<Integer, Integer>> f33965II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<oIX0oI<IXxxXO.Oxx0IOOO, Path>> f33966oIX0oI;

    public Oxx0IOOO(List<Mask> list) {
        this.f33964I0Io = list;
        this.f33966oIX0oI = new ArrayList(list.size());
        this.f33965II0xO0 = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f33966oIX0oI.add(list.get(i).II0xO0().oIX0oI());
            this.f33965II0xO0.add(list.get(i).I0Io().oIX0oI());
        }
    }

    public List<oIX0oI<Integer, Integer>> I0Io() {
        return this.f33965II0xO0;
    }

    public List<Mask> II0xO0() {
        return this.f33964I0Io;
    }

    public List<oIX0oI<IXxxXO.Oxx0IOOO, Path>> oIX0oI() {
        return this.f33966oIX0oI;
    }
}
