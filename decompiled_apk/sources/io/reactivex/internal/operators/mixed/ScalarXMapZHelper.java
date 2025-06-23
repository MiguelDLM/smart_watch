package io.reactivex.internal.operators.mixed;

import I00O.II0xO0;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean tryAsCompletable(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        CompletableSource completableSource;
        if (obj instanceof Callable) {
            try {
                II0xO0 iI0xO0 = (Object) ((Callable) obj).call();
                if (iI0xO0 != null) {
                    completableSource = (CompletableSource) ObjectHelper.requireNonNull(function.apply(iI0xO0), "The mapper returned a null CompletableSource");
                } else {
                    completableSource = null;
                }
                if (completableSource == null) {
                    EmptyDisposable.complete(completableObserver);
                } else {
                    completableSource.subscribe(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, completableObserver);
                return true;
            }
        }
        return false;
    }

    public static <T, R> boolean tryAsMaybe(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        MaybeSource maybeSource;
        if (obj instanceof Callable) {
            try {
                II0xO0 iI0xO0 = (Object) ((Callable) obj).call();
                if (iI0xO0 != null) {
                    maybeSource = (MaybeSource) ObjectHelper.requireNonNull(function.apply(iI0xO0), "The mapper returned a null MaybeSource");
                } else {
                    maybeSource = null;
                }
                if (maybeSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    maybeSource.subscribe(MaybeToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }
        return false;
    }

    public static <T, R> boolean tryAsSingle(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        SingleSource singleSource;
        if (obj instanceof Callable) {
            try {
                II0xO0 iI0xO0 = (Object) ((Callable) obj).call();
                if (iI0xO0 != null) {
                    singleSource = (SingleSource) ObjectHelper.requireNonNull(function.apply(iI0xO0), "The mapper returned a null SingleSource");
                } else {
                    singleSource = null;
                }
                if (singleSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    singleSource.subscribe(SingleToObservable.create(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }
        return false;
    }
}
