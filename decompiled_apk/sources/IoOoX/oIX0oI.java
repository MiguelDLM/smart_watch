package IoOoX;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes8.dex */
public class oIX0oI {

    /* loaded from: classes8.dex */
    public interface II0xO0 {
        int oIX0oI(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i);
    }

    /* renamed from: IoOoX.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0022oIX0oI extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager.SpanSizeLookup f804I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f805II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ II0xO0 f806oIX0oI;

        public C0022oIX0oI(II0xO0 iI0xO0, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f806oIX0oI = iI0xO0;
            this.f805II0xO0 = gridLayoutManager;
            this.f804I0Io = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return this.f806oIX0oI.oIX0oI(this.f805II0xO0, this.f804I0Io, i);
        }
    }

    public static void II0xO0(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public static void oIX0oI(RecyclerView.Adapter adapter, RecyclerView recyclerView, II0xO0 iI0xO0) {
        adapter.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new C0022oIX0oI(iI0xO0, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }
}
