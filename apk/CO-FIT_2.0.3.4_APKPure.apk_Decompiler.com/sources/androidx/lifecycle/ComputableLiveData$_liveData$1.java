package androidx.lifecycle;

public final class ComputableLiveData$_liveData$1 extends LiveData<T> {
    final /* synthetic */ ComputableLiveData<T> this$0;

    public ComputableLiveData$_liveData$1(ComputableLiveData<T> computableLiveData) {
        this.this$0 = computableLiveData;
    }

    public void onActive() {
        this.this$0.getExecutor$lifecycle_livedata_release().execute(this.this$0.refreshRunnable);
    }
}
