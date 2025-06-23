package com.sma.smartv3.ui.device.dialpay.item;

import IXo.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.OnlineWatchFaceV2;
import com.sma.smartv3.model.WatchFaceBanner;
import com.sma.smartv3.model.WatchFaceCategoryV2;
import com.sma.smartv3.ui.device.dialpay.DialMoveActivity;
import com.sma.smartv3.ui.device.dialpay.WatchFaceDialPayDetailActivity;
import com.sma.smartv3.ui.me.GoogleWebViewActivity;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nBannerItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BannerItem.kt\ncom/sma/smartv3/ui/device/dialpay/item/BannerItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,123:1\n50#2,3:124\n53#2:130\n55#2,2:132\n86#2,2:140\n1549#3:127\n1620#3,2:128\n1622#3:131\n1549#3:134\n1620#3,3:135\n37#4,2:138\n*S KotlinDebug\n*F\n+ 1 BannerItem.kt\ncom/sma/smartv3/ui/device/dialpay/item/BannerItem\n*L\n62#1:124,3\n62#1:130\n62#1:132,2\n71#1:140,2\n62#1:127\n62#1:128,2\n62#1:131\n64#1:134\n64#1:135,3\n71#1:138,2\n*E\n"})
/* loaded from: classes12.dex */
public final class BannerItem extends BaseDslItem {
    public Banner<WatchFaceBanner, ImageAdapter> mBanner;

    @OOXIXo
    private final List<WatchFaceBanner> mBannerList;
    public Context mContext;

    /* loaded from: classes12.dex */
    public static final class ImageAdapter extends BannerAdapter<WatchFaceBanner, BannerViewHolder> {

        /* loaded from: classes12.dex */
        public final class BannerViewHolder extends RecyclerView.ViewHolder {

            @OOXIXo
            private ImageView imageView;
            final /* synthetic */ ImageAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BannerViewHolder(@XO @OOXIXo ImageAdapter imageAdapter, ImageView imageView) {
                super(imageView);
                IIX0o.x0xO0oo(imageView, "imageView");
                this.this$0 = imageAdapter;
                this.imageView = imageView;
            }

            @OOXIXo
            public final ImageView getImageView() {
                return this.imageView;
            }

            public final void setImageView(@OOXIXo ImageView imageView) {
                IIX0o.x0xO0oo(imageView, "<set-?>");
                this.imageView = imageView;
            }
        }

        public ImageAdapter(@oOoXoXO List<WatchFaceBanner> list) {
            super(list);
        }

        @Override // com.youth.banner.holder.IViewHolder
        public void onBindView(@oOoXoXO BannerViewHolder bannerViewHolder, @oOoXoXO WatchFaceBanner watchFaceBanner, int i, int i2) {
            if ((bannerViewHolder != null ? bannerViewHolder.getImageView() : null) != null) {
                Glide.with(bannerViewHolder.getImageView().getContext()).load(watchFaceBanner != null ? watchFaceBanner.getSlidePath() : null).into(bannerViewHolder.getImageView());
            }
        }

        @Override // com.youth.banner.holder.IViewHolder
        @OOXIXo
        public BannerViewHolder onCreateHolder(@OOXIXo ViewGroup parent, int i) {
            IIX0o.x0xO0oo(parent, "parent");
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return new BannerViewHolder(this, imageView);
        }
    }

    public BannerItem(@OOXIXo List<WatchFaceBanner> mBannerList) {
        IIX0o.x0xO0oo(mBannerList, "mBannerList");
        this.mBannerList = mBannerList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindView$lambda$1(BannerItem this$0, WatchFaceBanner watchFaceBanner, int i) {
        Collection ooXIXxIX2;
        IIX0o.x0xO0oo(this$0, "this$0");
        String slideType = watchFaceBanner.getSlideType();
        int hashCode = slideType.hashCode();
        OnlineWatchFaceV2 onlineWatchFaceV2 = null;
        if (hashCode != -1898886909) {
            if (hashCode != 1176599814) {
                if (hashCode == 1722888108 && slideType.equals("WatchFace")) {
                    Intent intent = new Intent(this$0.getMBanner().getContext(), (Class<?>) WatchFaceDialPayDetailActivity.class);
                    intent.putExtra("mArg1", watchFaceBanner.getSlideEleId());
                    this$0.getMBanner().getContext().startActivity(intent);
                    return;
                }
                return;
            }
            if (slideType.equals("WatchFaceType")) {
                try {
                    JsonArray asJsonArray = JsonParser.parseString(Xo0.f24349oIX0oI.XO().getString(XoI0Ixx0.f24362IIxOXoOo0)).getAsJsonArray();
                    IIX0o.ooOOo0oXI(asJsonArray);
                    ooXIXxIX2 = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    while (it.hasNext()) {
                        ooXIXxIX2.add(new Gson().fromJson(it.next(), OnlineWatchFaceV2.class));
                    }
                } catch (Exception unused) {
                    ooXIXxIX2 = CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                List o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(ooXIXxIX2);
                if (o0Xo0XII == null) {
                    return;
                }
                List<OnlineWatchFaceV2> list = o0Xo0XII;
                ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list, 10));
                for (OnlineWatchFaceV2 onlineWatchFaceV22 : list) {
                    if (Integer.parseInt(onlineWatchFaceV22.getTypeId()) == watchFaceBanner.getSlideEleId()) {
                        onlineWatchFaceV2 = onlineWatchFaceV22;
                    }
                    arrayList.add(oXIO0o0XI.f29392oIX0oI);
                }
                if (onlineWatchFaceV2 != null) {
                    SPUtils I0Io2 = Xo0.f24349oIX0oI.I0Io();
                    WatchFaceCategoryV2[] watchFaceList = onlineWatchFaceV2.getWatchFaceList();
                    IIX0o.ooOOo0oXI(watchFaceList);
                    I0Io2.put(XoI0Ixx0.f24485xXOx + '_' + WatchFaceCategoryV2[].class.getName(), new Gson().toJson(ArraysKt___ArraysKt.XOXXox0(watchFaceList).toArray(new WatchFaceCategoryV2[0])));
                    Intent intent2 = new Intent(this$0.getMBanner().getContext(), (Class<?>) DialMoveActivity.class);
                    intent2.putExtra("mArg0", onlineWatchFaceV2.getTypeName());
                    intent2.putExtra("mArg1", watchFaceBanner.getSlideEleId());
                    this$0.getMBanner().getContext().startActivity(intent2);
                    return;
                }
                return;
            }
            return;
        }
        if (slideType.equals("Points")) {
            Intent intent3 = new Intent(this$0.getMBanner().getContext(), (Class<?>) GoogleWebViewActivity.class);
            intent3.putExtra("mArg0", OrderManager.IIX0o(OrderManager.f20130oIX0oI, null, null, 3, null));
            intent3.putExtra("mArg1", 2);
            this$0.getMBanner().getContext().startActivity(intent3);
        }
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.banner);
        IIX0o.ooOOo0oXI(v);
        setMBanner((Banner) v);
        Context context = getMBanner().getContext();
        IIX0o.oO(context, "getContext(...)");
        setMContext(context);
        List<WatchFaceBanner> list = this.mBannerList;
        if (list != null && list.size() > 0) {
            getMBanner().setAdapter(new ImageAdapter(this.mBannerList)).setIndicator(new CircleIndicator(getMContext()));
            getMBanner().setOnBannerListener(new OnBannerListener() { // from class: com.sma.smartv3.ui.device.dialpay.item.oIX0oI
                @Override // com.youth.banner.listener.OnBannerListener
                public final void OnBannerClick(Object obj, int i) {
                    BannerItem.bindView$lambda$1(BannerItem.this, (WatchFaceBanner) obj, i);
                }
            });
            getMBanner().start();
        }
    }

    @OOXIXo
    public final Banner<WatchFaceBanner, ImageAdapter> getMBanner() {
        Banner<WatchFaceBanner, ImageAdapter> banner = this.mBanner;
        if (banner != null) {
            return banner;
        }
        IIX0o.XOxIOxOx("mBanner");
        return null;
    }

    @OOXIXo
    public final List<WatchFaceBanner> getMBannerList() {
        return this.mBannerList;
    }

    @OOXIXo
    public final Context getMContext() {
        Context context = this.mContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("mContext");
        return null;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.layout_online_watchface_banner_head;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void onDetach(@OOXIXo DslViewHolder itemHolder, int i) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        super.onDetach(itemHolder, i);
        List<WatchFaceBanner> list = this.mBannerList;
        if (list != null && list.size() > 0) {
            getMBanner().stop();
        }
    }

    public final void setMBanner(@OOXIXo Banner<WatchFaceBanner, ImageAdapter> banner) {
        IIX0o.x0xO0oo(banner, "<set-?>");
        this.mBanner = banner;
    }

    public final void setMContext(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "<set-?>");
        this.mContext = context;
    }
}
