package kotlinx.coroutines;

/* loaded from: classes6.dex */
public interface oO<T> extends kotlin.coroutines.I0Io<T> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static /* synthetic */ Object II0xO0(oO oOVar, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return oOVar.xxX(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }

        public static /* synthetic */ boolean oIX0oI(oO oOVar, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return oOVar.oIX0oI(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    @XI0oooXX
    void II0XooXoX(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, @OXOo.OOXIXo Throwable th);

    @OX00O0xII
    void IO();

    @OX00O0xII
    @OXOo.oOoXoXO
    Object OI0(T t, @OXOo.oOoXoXO Object obj, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo);

    @XI0oooXX
    void OxxIIOOXO(T t, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo);

    @XI0oooXX
    void X00IoxXI(@OXOo.OOXIXo CoroutineDispatcher coroutineDispatcher, T t);

    @OX00O0xII
    void XIxXXX0x0(@OXOo.OOXIXo Object obj);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    boolean oIX0oI(@OXOo.oOoXoXO Throwable th);

    @OX00O0xII
    @OXOo.oOoXoXO
    Object oo0xXOI0I(@OXOo.OOXIXo Throwable th);

    void ooXIXxIX(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo);

    @OX00O0xII
    @OXOo.oOoXoXO
    Object xxX(T t, @OXOo.oOoXoXO Object obj);
}
