package o0xxxXXxX;

import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.DataSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class II0XooXoX extends oxoX<BubbleEntry> implements IIxOXoOo0.I0Io {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f31232O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public float f31233OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f31234X0IIOO;

    public II0XooXoX(List<BubbleEntry> list, String str) {
        super(list, str);
        this.f31232O0xOxO = true;
        this.f31234X0IIOO = 2.5f;
    }

    @Override // IIxOXoOo0.I0Io
    public void IxIX0I(float f) {
        this.f31234X0IIOO = XIXIX.OOXIXo.X0o0xo(f);
    }

    public void OxO(boolean z) {
        this.f31232O0xOxO = z;
    }

    public void X0O0I0(II0XooXoX iI0XooXoX) {
        iI0XooXoX.f31234X0IIOO = this.f31234X0IIOO;
        iI0XooXoX.f31232O0xOxO = this.f31232O0xOxO;
    }

    @Override // IIxOXoOo0.I0Io
    public boolean XIxXXX0x0() {
        return this.f31232O0xOxO;
    }

    @Override // IIxOXoOo0.I0Io
    public float getMaxSize() {
        return this.f31233OxI;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    /* renamed from: o0oxo0oI, reason: merged with bridge method [inline-methods] */
    public void oxOXxoXII(BubbleEntry bubbleEntry) {
        super.oxOXxoXII(bubbleEntry);
        float oOoXoXO2 = bubbleEntry.oOoXoXO();
        if (oOoXoXO2 > this.f31233OxI) {
            this.f31233OxI = oOoXoXO2;
        }
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<BubbleEntry> oX0I0O() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16010Oxx0xo.size(); i++) {
            arrayList.add(((BubbleEntry) this.f16010Oxx0xo.get(i)).Oxx0IOOO());
        }
        II0XooXoX iI0XooXoX = new II0XooXoX(arrayList, getLabel());
        X0O0I0(iI0XooXoX);
        return iI0XooXoX;
    }

    @Override // IIxOXoOo0.I0Io
    public float ooOx() {
        return this.f31234X0IIOO;
    }
}
