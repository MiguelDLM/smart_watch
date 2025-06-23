package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {
    private LiveDataUtils() {
    }

    @SuppressLint({"LambdaLast"})
    @NonNull
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull final Function<In, Out> function, @NonNull final TaskExecutor taskExecutor) {
        final Object obj = new Object();
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<In>() {
            Out mCurrentOutput = null;

            public void onChanged(@Nullable final In in) {
                TaskExecutor.this.executeOnTaskThread(new Runnable() {
                    public void run() {
                        synchronized (obj) {
                            try {
                                Out apply = function.apply(in);
                                AnonymousClass1 r2 = AnonymousClass1.this;
                                Out out = r2.mCurrentOutput;
                                if (out == null && apply != null) {
                                    r2.mCurrentOutput = apply;
                                    mediatorLiveData.postValue(apply);
                                } else if (out != null && !out.equals(apply)) {
                                    AnonymousClass1 r22 = AnonymousClass1.this;
                                    r22.mCurrentOutput = apply;
                                    mediatorLiveData.postValue(apply);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            }
        });
        return mediatorLiveData;
    }
}
