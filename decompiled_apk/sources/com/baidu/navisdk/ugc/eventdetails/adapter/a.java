package com.baidu.navisdk.ugc.eventdetails.adapter;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.imageloader.config.ImageConfig;
import com.baidu.navisdk.ugc.eventdetails.model.g;
import com.baidu.navisdk.ugc.eventdetails.view.VideoWidget;
import com.baidu.navisdk.ui.widget.BNCommonCornerView;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8042a;
    private final ArrayList<g> b;
    private d c;
    private b d;

    @OOXIXo
    private final Context e;

    @OOXIXo
    private final ArrayList<g> f;

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0372a {
        private C0372a() {
        }

        public /* synthetic */ C0372a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(@OOXIXo g gVar);
    }

    /* loaded from: classes8.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        @OOXIXo
        private BNCommonCornerView f8043a;

        @oOoXoXO
        private VideoWidget b;

        @oOoXoXO
        private ImageView c;

        @OOXIXo
        private final Context d;

        @OOXIXo
        private final ViewGroup e;
        private final int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@OOXIXo Context mContext, @OOXIXo ViewGroup itemView, int i) {
            super(itemView);
            IIX0o.x0xO0oo(mContext, "mContext");
            IIX0o.x0xO0oo(itemView, "itemView");
            this.d = mContext;
            this.e = itemView;
            this.f = i;
            View findViewById = this.itemView.findViewById(R.id.multimedia_container);
            IIX0o.oO(findViewById, "itemView.findViewById(R.id.multimedia_container)");
            this.f8043a = (BNCommonCornerView) findViewById;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (i != 1) {
                if (i == 2) {
                    VideoWidget videoWidget = new VideoWidget(mContext);
                    this.b = videoWidget;
                    this.f8043a.addView(videoWidget);
                    VideoWidget videoWidget2 = this.b;
                    if (videoWidget2 != null) {
                        videoWidget2.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                return;
            }
            ImageView imageView = new ImageView(mContext);
            this.c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.f8043a.addView(this.c);
            ImageView imageView2 = this.c;
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
        }

        @oOoXoXO
        public final ImageView a() {
            return this.c;
        }

        public final int b() {
            return this.f;
        }

        @oOoXoXO
        public final VideoWidget c() {
            return this.b;
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(@OOXIXo String str, int i);
    }

    /* loaded from: classes8.dex */
    public static final class e implements View.OnClickListener {
        final /* synthetic */ int b;

        public e(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b b = a.b(a.this);
            Object obj = a.this.b.get(this.b);
            IIX0o.oO(obj, "mData[position]");
            b.a((g) obj);
        }
    }

    /* loaded from: classes8.dex */
    public static final class f implements VideoWidget.a {
        final /* synthetic */ int b;

        public f(int i) {
            this.b = i;
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.view.VideoWidget.a
        public final void a(String str, int i) {
            a.c(a.this).a(((g) a.this.b.get(this.b)).a(), 1);
        }
    }

    static {
        new C0372a(null);
    }

    public a(@OOXIXo Context context, @OOXIXo ArrayList<g> data) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(data, "data");
        this.e = context;
        this.f = data;
        this.f8042a = context;
        this.b = data;
    }

    public static final /* synthetic */ b b(a aVar) {
        b bVar = aVar.d;
        if (bVar == null) {
            IIX0o.XOxIOxOx("mImageClickCallBack");
        }
        return bVar;
    }

    public static final /* synthetic */ d c(a aVar) {
        d dVar = aVar.c;
        if (dVar == null) {
            IIX0o.XOxIOxOx("mVideoClickCallback");
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.b.get(i).d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@OOXIXo RecyclerView.ViewHolder holder, int i) {
        IIX0o.x0xO0oo(holder, "holder");
        if (holder instanceof c) {
            c cVar = (c) holder;
            int b2 = cVar.b();
            if (b2 != 1) {
                if (b2 == 2) {
                    VideoWidget c2 = cVar.c();
                    if (c2 != null) {
                        c2.a(this.b.get(i).b(), this.b.get(i).a(), 0);
                    }
                    VideoWidget c3 = cVar.c();
                    if (c3 != null) {
                        c3.setFrom(1);
                    }
                    VideoWidget c4 = cVar.c();
                    if (c4 != null) {
                        c4.setClickPlayVideoListener(new f(i));
                        return;
                    }
                    return;
                }
                return;
            }
            g gVar = this.b.get(i);
            IIX0o.oO(gVar, "mData[position]");
            a(cVar, gVar);
            ImageView a2 = cVar.a();
            if (a2 != null) {
                a2.setOnClickListener(new e(i));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OOXIXo
    public RecyclerView.ViewHolder onCreateViewHolder(@OOXIXo ViewGroup parent, int i) {
        IIX0o.x0xO0oo(parent, "parent");
        View inflate = JarUtils.inflate(this.f8042a, R.layout.nsdk_layout_ugc_detail_image_and_video_item, null, false);
        IIX0o.oO(inflate, "JarUtils.inflate(mContex…_video_item, null, false)");
        Context context = this.f8042a;
        if (inflate != null) {
            return new c(context, (ViewGroup) inflate, i);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private final void a(c cVar, g gVar) {
        if (gVar.d() != 1) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcDetailImgAndVideoAdapter", "iamgeholder bind data fail,type is " + gVar.d());
                return;
            }
            return;
        }
        ImageView a2 = cVar.a();
        if (a2 != null) {
            a2.setClickable(false);
        }
        ImageConfig.ConfigBuilder load = ImageLoader.with(this.f8042a).load(gVar.b());
        int i = R.drawable.nsdk_rc_img_default_bg;
        load.placeHolder(i).error(i).into(cVar.a());
        ImageView a3 = cVar.a();
        if (a3 != null) {
            a3.setClickable(true);
        }
    }

    public final void a(@OOXIXo d mCallback) {
        IIX0o.x0xO0oo(mCallback, "mCallback");
        this.c = mCallback;
    }

    public final void a(@OOXIXo b mCallback) {
        IIX0o.x0xO0oo(mCallback, "mCallback");
        this.d = mCallback;
    }
}
