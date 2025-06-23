package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class MaybeEqualSingle<T> extends Single<Boolean> {
    final BiPredicate<? super T, ? super T> isEqual;
    final MaybeSource<? extends T> source1;
    final MaybeSource<? extends T> source2;

    /* loaded from: classes6.dex */
    public static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final SingleObserver<? super Boolean> actual;
        final BiPredicate<? super T, ? super T> isEqual;
        final EqualObserver<T> observer1;
        final EqualObserver<T> observer2;

        public EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.actual = singleObserver;
            this.isEqual = biPredicate;
            this.observer1 = new EqualObserver<>(this);
            this.observer2 = new EqualObserver<>(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        public void done() {
            boolean z;
            if (decrementAndGet() == 0) {
                Object obj = this.observer1.value;
                Object obj2 = this.observer2.value;
                if (obj != null && obj2 != null) {
                    try {
                        this.actual.onSuccess(Boolean.valueOf(this.isEqual.test(obj, obj2)));
                        return;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                SingleObserver<? super Boolean> singleObserver = this.actual;
                if (obj == null && obj2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                singleObserver.onSuccess(Boolean.valueOf(z));
            }
        }

        public void error(EqualObserver<T> equalObserver, Throwable th) {
            if (getAndSet(0) > 0) {
                EqualObserver<T> equalObserver2 = this.observer1;
                if (equalObserver == equalObserver2) {
                    this.observer2.dispose();
                } else {
                    equalObserver2.dispose();
                }
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.observer1.get());
        }

        public void subscribe(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
            maybeSource.subscribe(this.observer1);
            maybeSource2.subscribe(this.observer2);
        }
    }

    /* loaded from: classes6.dex */
    public static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final EqualCoordinator<T> parent;
        Object value;

        public EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.parent = equalCoordinator;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.done();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.parent.error(this, th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.value = t;
            this.parent.done();
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.source1 = maybeSource;
        this.source2 = maybeSource2;
        this.isEqual = biPredicate;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.isEqual);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe(this.source1, this.source2);
    }
}
