package ooXIXxIX;

/* loaded from: classes8.dex */
public final /* synthetic */ class oIX0oI {
    public static /* synthetic */ int oIX0oI(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
