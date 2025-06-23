package com.tenmeter.smlibrary.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.O0IxXx;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import com.huawei.openalliance.ad.constant.cu;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.activity.SMVipGameListActivity;
import com.tenmeter.smlibrary.adapter.BannerTopNewAdapter;
import com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter;
import com.tenmeter.smlibrary.adapter.GameListTypeNewAdapter;
import com.tenmeter.smlibrary.adapter.HotBottomListAdapter;
import com.tenmeter.smlibrary.adapter.HotListAdapter;
import com.tenmeter.smlibrary.adapter.IconListAdapter;
import com.tenmeter.smlibrary.banner.Banner;
import com.tenmeter.smlibrary.banner.adapter.BannerRoundImageAdapter;
import com.tenmeter.smlibrary.banner.holder.BannerImageHolder;
import com.tenmeter.smlibrary.banner.indicator.CircleIndicator;
import com.tenmeter.smlibrary.banner.listener.OnBannerListener;
import com.tenmeter.smlibrary.entity.SMADBean;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.entity.SMPOPResultBean;
import com.tenmeter.smlibrary.fragment.GameListFragment;
import com.tenmeter.smlibrary.listener.Consumer;
import com.tenmeter.smlibrary.listener.IADCallback;
import com.tenmeter.smlibrary.listener.IFragmentChangeCallback;
import com.tenmeter.smlibrary.listener.IGameListBannerCallback;
import com.tenmeter.smlibrary.listener.IGameListForTypeCallback;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.listener.IIconCallback;
import com.tenmeter.smlibrary.listener.IPopResultCallback;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import com.tenmeter.smlibrary.utils.KLog;
import com.tenmeter.smlibrary.utils.PreferencesUtils;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.SMPlayerManagerFactory;
import com.tenmeter.smlibrary.widget.AdDia;
import com.tenmeter.smlibrary.widget.LoadDia;
import com.tenmeter.smlibrary.widget.SMRoundPlayerView;
import com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator;
import com.tenmeter.smlibrary.widget.decoration.GridSpaceItemDecoration;
import com.tenmeter.smlibrary.widget.viewpagerlayout.CenterSnapHelper;
import com.tenmeter.smlibrary.widget.viewpagerlayout.ScaleLayoutManager;
import com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes13.dex */
public class GameListFragment extends Fragment implements IFragmentChangeCallback {
    private String from;
    private SMGameListParent leisureGameDatas;
    private HotListAdapter m3DAdapter;
    private LinearLayout m3DGameContainer;
    private TextView m3DName;
    private RecyclerView m3DRv;
    private Banner mAdBanner;
    private Runnable mAdRunnable;
    private TextView mAdTitle;
    private ScaleLayoutManager mBannerLayoutManager;
    private BannerTopNewAdapter mBannerNewAdapter;
    private RecyclerView mBannerRecyclerview;
    private CenterSnapHelper mCenterSnapHelper;
    private SMCircleIndicator mCircleIndicator;
    private RecyclerView mGameRv;
    private HotListAdapter mHotAdapter;
    private HotBottomListAdapter mHotBottomAdapter;
    private RecyclerView mHotBottomRv;
    private LinearLayout mHotGameContainer;
    private TextView mHotName;
    private RecyclerView mHotRv;
    private IconListAdapter mIconAdapter;
    private RecyclerView mIconRv;
    private Banner mLeisureBanner;
    private LinearLayout mLeisureGameContainer;
    private TextView mLeisureMore;
    private TextView mLeisureName;
    private LoadDia mLoadDia;
    private GameListTypeNewAdapter mTypeAdapter;
    private NestedScrollView scrollView;
    private List<String> bannerIds = new ArrayList();
    private List<String> bannerPauseIds = new ArrayList();
    private boolean isMute = true;
    private View view = null;
    private boolean isShow = false;
    private int curPosition = 0;
    private Handler hd = new Handler(Looper.getMainLooper());

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$10, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass10 implements Consumer<Boolean> {
        public AnonymousClass10() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$accept$0() {
            try {
                GameListFragment.this.hideLoading();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.Consumer
        public void accept(Boolean bool) {
            if (bool.booleanValue()) {
                GameListFragment.this.getGameTypeData();
            } else {
                GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.X0o0xo
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameListFragment.AnonymousClass10.this.lambda$accept$0();
                    }
                });
            }
        }
    }

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$12, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass12 implements IGameListBannerCallback {
        public AnonymousClass12() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1() {
            try {
                GameListFragment.this.hideLoading();
                GameListFragment.this.mBannerRecyclerview.setVisibility(8);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccessFul$0(List list) {
            try {
                GameListFragment.this.hideLoading();
                if (list.size() > 0) {
                    GameListFragment.this.mBannerNewAdapter.setData(list);
                    GameListFragment.this.view.findViewById(R.id.sm_flTopBanner).setVisibility(0);
                    GameListFragment.this.mBannerRecyclerview.smoothScrollToPosition(0);
                    GameListFragment.this.mCircleIndicator.createIndicators(list.size(), 0);
                    if (((SMGameListBannerParent) list.get(0)).getBannerType() == 99) {
                        GameListFragment.this.processLoadVideo(0);
                    }
                } else {
                    GameListFragment.this.view.findViewById(R.id.sm_flTopBanner).setVisibility(8);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListBannerCallback
        public void onError(String str) {
            Log.e("requestUrl:", "getGameBannerList--onError---message----" + str);
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.XO
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass12.this.lambda$onError$1();
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListBannerCallback
        public void onSuccessFul(final List<SMGameListBannerParent> list) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.Oxx0IOOO
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass12.this.lambda$onSuccessFul$0(list);
                }
            });
        }
    }

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$13, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass13 implements IIconCallback {
        public AnonymousClass13() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1() {
            try {
                GameListFragment.this.hideLoading();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccessFul$0(List list) {
            try {
                GameListFragment.this.hideLoading();
                GameListFragment.this.mIconAdapter.setData(list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.IIconCallback
        public void onError(String str) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.II0XooXoX
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass13.this.lambda$onError$1();
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IIconCallback
        public void onSuccessFul(final List<SMIconListParent> list) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.xxIXOIIO
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass13.this.lambda$onSuccessFul$0(list);
                }
            });
        }
    }

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$14, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass14 implements IGameListForTypeCallback {
        public AnonymousClass14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1() {
            try {
                GameListFragment.this.hideLoading();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccessFul$0(List list) {
            String str;
            try {
                GameListFragment.this.hideLoading();
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        SMGameListParent sMGameListParent = (SMGameListParent) it.next();
                        int i = 8;
                        if (sMGameListParent.getTagId() == 4) {
                            GameListFragment.this.mHotName.setText(sMGameListParent.getTagName());
                            LinearLayout linearLayout = GameListFragment.this.mHotGameContainer;
                            if (sMGameListParent.getGameList().size() > 0) {
                                i = 0;
                            }
                            linearLayout.setVisibility(i);
                            GameListFragment.this.mHotAdapter.setData(sMGameListParent.getGameList());
                        } else if (sMGameListParent.getTagId() == 2) {
                            GameListFragment.this.leisureGameDatas = sMGameListParent;
                            GameListFragment.this.mLeisureName.setText(sMGameListParent.getTagName());
                            TextView textView = GameListFragment.this.mLeisureMore;
                            if (SMGameClient.getInstance().isChina()) {
                                str = "更多";
                            } else {
                                str = "More";
                            }
                            textView.setText(str);
                            LinearLayout linearLayout2 = GameListFragment.this.mLeisureGameContainer;
                            if (sMGameListParent.getGameList().size() > 0) {
                                i = 0;
                            }
                            linearLayout2.setVisibility(i);
                            GameListFragment.this.processLeisureGame(sMGameListParent);
                        } else if (sMGameListParent.getTagId() == 5) {
                            GameListFragment.this.m3DName.setText(sMGameListParent.getTagName());
                            LinearLayout linearLayout3 = GameListFragment.this.m3DGameContainer;
                            if (sMGameListParent.getGameList().size() > 0) {
                                i = 0;
                            }
                            linearLayout3.setVisibility(i);
                            GameListFragment.this.m3DAdapter.setData(sMGameListParent.getGameList());
                        } else {
                            arrayList.add(sMGameListParent);
                        }
                    }
                    GameListFragment.this.mTypeAdapter.setData(arrayList);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListForTypeCallback
        public void onError(String str) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.OOXIXo
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass14.this.lambda$onError$1();
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListForTypeCallback
        public void onSuccessFul(final List<SMGameListParent> list) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.xoIox
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass14.this.lambda$onSuccessFul$0(list);
                }
            });
        }
    }

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$15, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass15 implements IIconCallback {
        public AnonymousClass15() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccessFul$0(List list) {
            try {
                GameListFragment.this.mHotBottomAdapter.setData(list);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.IIconCallback
        public void onError(String str) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.oOoXoXO
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass15.lambda$onError$1();
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IIconCallback
        public void onSuccessFul(final List<SMIconListParent> list) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.ooOOo0oXI
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass15.this.lambda$onSuccessFul$0(list);
                }
            });
        }
    }

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$16, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass16 implements IADCallback {
        public AnonymousClass16() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1() {
            try {
                GameListFragment.this.hideLoading();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccessFul$0(List list) {
            try {
                GameListFragment.this.hideLoading();
                if (list != null && list.size() > 0) {
                    GameListFragment.this.mAdTitle.setVisibility(0);
                    GameListFragment.this.mAdBanner.setVisibility(0);
                    GameListFragment.this.mAdTitle.setText(((SMADBean) list.get(0)).getAdName());
                    GameListFragment.this.mAdBanner.setAdapter(new BannerRoundImageAdapter<SMADBean>(list) { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.16.2
                        @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
                        public void onBindView(BannerImageHolder bannerImageHolder, SMADBean sMADBean, int i, int i2) {
                            try {
                                RequestBuilder<Drawable> load = Glide.with(GameListFragment.this.getContext()).load(sMADBean.getAdUrl());
                                Context context = GameListFragment.this.getContext();
                                int i3 = R.drawable.default_game;
                                RequestBuilder error = load.placeholder(ContextCompat.getDrawable(context, i3)).error(ContextCompat.getDrawable(GameListFragment.this.getContext(), i3));
                                ImageView imageView = bannerImageHolder.imageView;
                                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                                error.listener(new SGlideRequestListener(imageView, scaleType, scaleType)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(bannerImageHolder.imageView);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }).setOnBannerListener(new OnBannerListener<SMADBean>() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.16.1
                        @Override // com.tenmeter.smlibrary.banner.listener.OnBannerListener
                        public void OnBannerClick(SMADBean sMADBean, int i) {
                            try {
                                if (sMADBean.getRedirectType() == 1) {
                                    GameListFragment.this.gameClick(sMADBean.getGame());
                                } else if (sMADBean.getRedirectType() == 2) {
                                    SMGameClient.getInstance().startGameListSub(sMADBean.getTag(), GameListFragment.this.requireActivity());
                                } else if (sMADBean.getRedirectType() == 3) {
                                    if (sMADBean.getIcon() != null) {
                                        if (sMADBean.getIcon().getIconPage() == 2) {
                                            GameListFragment.this.jumpToVip(sMADBean.getIcon());
                                        } else {
                                            SMGameListParent sMGameListParent = new SMGameListParent();
                                            sMGameListParent.setGameList(sMADBean.getIcon().getGameList());
                                            sMGameListParent.setTagId(sMADBean.getIcon().getIconId());
                                            sMGameListParent.setTagName(sMADBean.getIcon().getIconName());
                                            SMGameClient.getInstance().startGameListSub(sMGameListParent, GameListFragment.this.requireActivity());
                                        }
                                    }
                                } else if (sMADBean.getRedirectType() == 4) {
                                    SMGameClient.getInstance().startWebActivity(sMADBean.getRedirectUrl(), GameListFragment.this.requireActivity());
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    if (list.size() > 1) {
                        GameListFragment.this.mAdBanner.setIndicator(new CircleIndicator(GameListFragment.this.requireActivity()));
                    }
                } else {
                    GameListFragment.this.mAdTitle.setVisibility(8);
                    GameListFragment.this.mAdBanner.setVisibility(8);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.IADCallback
        public void onError(String str) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.oO
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass16.this.lambda$onError$1();
                }
            });
            Log.e("requestUrl:", "getAD--onError---message----" + str);
        }

        @Override // com.tenmeter.smlibrary.listener.IADCallback
        public void onSuccessFul(final List<SMADBean> list) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.x0XOIxOo
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass16.this.lambda$onSuccessFul$0(list);
                }
            });
        }
    }

    /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$18, reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass18 implements IGameOpenListener {
        public AnonymousClass18() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$openResult$0() {
            try {
                GameListFragment.this.hideLoading();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
        public void openResult(boolean z) {
            GameListFragment.this.hd.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.x0xO0oo
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.AnonymousClass18.this.lambda$openResult$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gameClick(SMGameInfo sMGameInfo) {
        if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
            SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(requireActivity(), sMGameInfo);
        } else {
            showLoading();
            SMGameClient.getInstance().startGame(sMGameInfo, requireActivity(), new AnonymousClass18());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameTypeData() {
        if (this.mBannerNewAdapter.getData().size() == 0) {
            SMGameClient.getInstance().getGameBannerList(new AnonymousClass12());
        }
        SMGameClient.getInstance().getIconLists(new AnonymousClass13());
        SMGameClient.getInstance().getTypeGameList(new AnonymousClass14());
        SMGameClient.getInstance().getHotBottomLists(new AnonymousClass15());
        if (this.mAdBanner.getAdapter() == null || (this.mAdBanner.getAdapter() != null && this.mAdBanner.getAdapter().getItemCount() == 0)) {
            SMGameClient.getInstance().getAD(new AnonymousClass16());
        }
        SMGameClient.getInstance().getADPopDialog(new IPopResultCallback() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.17
            @Override // com.tenmeter.smlibrary.listener.IPopResultCallback
            public void onError(String str) {
            }

            @Override // com.tenmeter.smlibrary.listener.IPopResultCallback
            public void onSuccessFul(final SMPOPResultBean sMPOPResultBean) {
                if (sMPOPResultBean != null && sMPOPResultBean.getLinkType() != 0 && GameListFragment.this.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                    GameListFragment.this.mAdRunnable = new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!PreferencesUtils.getString(SMGameClient.getContext(), PreferencesUtils.SAVE_AD_POP_TIME, "").equals(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd")) && GameListFragment.this.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
                                    new AdDia(GameListFragment.this.requireActivity(), sMPOPResultBean).show();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    };
                    GameListFragment.this.hd.postDelayed(GameListFragment.this.mAdRunnable, 1000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        showLoading();
        if (!SMGameClient.baseUrl.isEmpty()) {
            getGameTypeData();
        } else {
            SMGameClient.getInstance().gamePrivate(new AnonymousClass10());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(View view) {
        String str;
        this.mAdBanner = (Banner) view.findViewById(R.id.ad_banner);
        this.mLeisureMore = (TextView) view.findViewById(R.id.tv_leisure_more);
        this.mLeisureName = (TextView) view.findViewById(R.id.tv_leisure_name);
        this.mHotName = (TextView) view.findViewById(R.id.tv_hot_title);
        this.m3DName = (TextView) view.findViewById(R.id.tv_3d_title);
        this.mBannerRecyclerview = (RecyclerView) view.findViewById(R.id.sm_bannerNew);
        this.m3DGameContainer = (LinearLayout) view.findViewById(R.id.ll_3d_container);
        this.mCircleIndicator = (SMCircleIndicator) view.findViewById(R.id.sm_circleIndicator);
        this.mHotGameContainer = (LinearLayout) view.findViewById(R.id.ll_hot_container);
        this.mLeisureGameContainer = (LinearLayout) view.findViewById(R.id.ll_leisure_container);
        this.mLeisureBanner = (Banner) view.findViewById(R.id.leisure_game_banner);
        this.mGameRv = (RecyclerView) view.findViewById(R.id.rv_game_list);
        this.mIconRv = (RecyclerView) view.findViewById(R.id.rv_icon_list);
        this.mHotBottomRv = (RecyclerView) view.findViewById(R.id.rv_hot_bottom_list);
        this.mHotRv = (RecyclerView) view.findViewById(R.id.rv_hot_list);
        this.m3DRv = (RecyclerView) view.findViewById(R.id.rv_3d_list);
        this.mAdTitle = (TextView) view.findViewById(R.id.tv_ad_title);
        TextView textView = (TextView) view.findViewById(R.id.rv_hot_sub_title);
        if (SMGameClient.getInstance().isChina()) {
            str = "向左滑动查看更多";
        } else {
            str = "Swipe left for more";
        }
        textView.setText(str);
        this.mIconRv.setLayoutManager(new GridLayoutManager(requireActivity(), 4));
        this.mIconRv.addItemDecoration(new GridSpaceItemDecoration(4));
        this.mHotRv.setLayoutManager(new LinearLayoutManager(requireActivity(), 0, false));
        this.m3DRv.setLayoutManager(new LinearLayoutManager(requireActivity(), 0, false));
        this.mHotBottomRv.setLayoutManager(new GridLayoutManager(requireActivity(), 5));
        this.mHotBottomRv.addItemDecoration(new GridSpaceItemDecoration(5));
        ScaleLayoutManager build = new ScaleLayoutManager.Builder(requireActivity(), 0).setMinScale(1.0f).build();
        this.mBannerLayoutManager = build;
        build.setInfinite(true);
        this.mBannerRecyclerview.setLayoutManager(this.mBannerLayoutManager);
        CenterSnapHelper centerSnapHelper = new CenterSnapHelper();
        this.mCenterSnapHelper = centerSnapHelper;
        centerSnapHelper.attachToRecyclerView(this.mBannerRecyclerview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToVip(SMIconListParent sMIconListParent) {
        Intent intent = new Intent(requireActivity(), (Class<?>) SMVipGameListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMIconListParent);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01c8 A[Catch: all -> 0x00ef, TryCatch #0 {all -> 0x00ef, blocks: (B:3:0x0002, B:5:0x0023, B:7:0x0053, B:9:0x007a, B:11:0x00ca, B:12:0x00f2, B:14:0x0114, B:15:0x0135, B:16:0x01c4, B:18:0x01c8, B:21:0x01e7, B:23:0x017d), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01e7 A[Catch: all -> 0x00ef, TRY_LEAVE, TryCatch #0 {all -> 0x00ef, blocks: (B:3:0x0002, B:5:0x0023, B:7:0x0053, B:9:0x007a, B:11:0x00ca, B:12:0x00f2, B:14:0x0114, B:15:0x0135, B:16:0x01c4, B:18:0x01c8, B:21:0x01e7, B:23:0x017d), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$processLoadVideo$1(final int r7) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.fragment.GameListFragment.lambda$processLoadVideo$1(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processLoadVideoForEnd$0(int i) {
        try {
            SMPlayerManagerFactory.factory(requireContext(), this.from).pauseAll();
            if (this.mBannerNewAdapter.getData().get(i).getBannerType() == 99) {
                this.curPosition = i;
                View findViewByPosition = this.mBannerLayoutManager.findViewByPosition(i);
                if (findViewByPosition != null) {
                    int i2 = R.id.ivPlayOrPause;
                    ((ImageView) findViewByPosition.findViewById(i2)).setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.sm_play_icon));
                    findViewByPosition.findViewById(i2).setTag("play");
                    ((SMRoundPlayerView) findViewByPosition.findViewById(R.id.videoView)).setPlayer(SMPlayerManagerFactory.factory(requireContext(), this.from).getPlayer(this.mBannerNewAdapter.getData().get(i).getVideo(), false));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$2() {
        try {
            if (this.mBannerNewAdapter.getData().size() > 0) {
                int currentPosition = this.mBannerLayoutManager.getCurrentPosition();
                if (this.mBannerNewAdapter.getData().get(currentPosition) != null && this.mBannerNewAdapter.getData().get(currentPosition).getBannerType() == 99) {
                    View findViewByPosition = this.mBannerLayoutManager.findViewByPosition(currentPosition);
                    int i = R.id.ivPlayOrPause;
                    ((ImageView) findViewByPosition.findViewById(i)).setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.sm_pause_icon));
                    findViewByPosition.findViewById(i).setTag("pause");
                    processLoadVideo(currentPosition);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mute(ExoPlayer exoPlayer, boolean z) {
        float f;
        if (this.isMute) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        exoPlayer.setVolume(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void process(SMIconListParent sMIconListParent) {
        if (sMIconListParent.getIconPage() == 2) {
            jumpToVip(sMIconListParent);
            return;
        }
        SMGameListParent sMGameListParent = new SMGameListParent();
        sMGameListParent.setGameList(sMIconListParent.getGameList());
        sMGameListParent.setTagId(sMIconListParent.getIconId());
        sMGameListParent.setTagName(sMIconListParent.getIconPageTitle());
        SMGameClient.getInstance().startGameListSub(sMGameListParent, requireActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLeisureGame(SMGameListParent sMGameListParent) {
        ArrayList arrayList = new ArrayList();
        if (sMGameListParent.getGameList().size() > 9) {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, 6));
            arrayList.add(sMGameListParent.getGameList().subList(6, 9));
        } else if (sMGameListParent.getGameList().size() > 3) {
            if (sMGameListParent.getGameList().size() > 6) {
                arrayList.add(sMGameListParent.getGameList().subList(0, 3));
                arrayList.add(sMGameListParent.getGameList().subList(3, 6));
                arrayList.add(sMGameListParent.getGameList().subList(6, sMGameListParent.getGameList().size() - 1));
            } else {
                arrayList.add(sMGameListParent.getGameList().subList(0, 3));
                arrayList.add(sMGameListParent.getGameList().subList(3, sMGameListParent.getGameList().size() - 1));
            }
        } else {
            arrayList.add(sMGameListParent.getGameList());
        }
        this.mLeisureBanner.setAdapter(new GameLeisureListBannerAdapter(requireActivity(), new GameLeisureListBannerAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.19
            @Override // com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
                    SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(GameListFragment.this.requireActivity(), sMGameInfo);
                } else {
                    GameListFragment.this.showLoading();
                    SMGameClient.getInstance().startGame(sMGameInfo, GameListFragment.this.requireActivity(), new IGameOpenListener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.19.1
                        @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                        public void openResult(boolean z) {
                            GameListFragment.this.hideLoading();
                        }
                    });
                }
            }
        }, arrayList)).setBannerGalleryEffect(4, 23, 0, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLoadVideo(final int i) {
        try {
            this.mBannerRecyclerview.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.this.lambda$processLoadVideo$1(i);
                }
            });
            this.mCircleIndicator.animatePageSelected(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLoadVideoForEnd(final int i) {
        try {
            this.mBannerRecyclerview.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.II0xO0
                @Override // java.lang.Runnable
                public final void run() {
                    GameListFragment.this.lambda$processLoadVideoForEnd$0(i);
                }
            });
            this.mCircleIndicator.animatePageSelected(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerListener() {
        this.mGameRv.setLayoutManager(new LinearLayoutManager(requireActivity()));
        IconListAdapter iconListAdapter = new IconListAdapter(requireActivity(), new ArrayList(), new IconListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.2
            @Override // com.tenmeter.smlibrary.adapter.IconListAdapter.IGameListItemClick
            public void itemClick(SMIconListParent sMIconListParent) {
                if (sMIconListParent.getIconPage() == 2) {
                    GameListFragment.this.jumpToVip(sMIconListParent);
                    return;
                }
                SMGameListParent sMGameListParent = new SMGameListParent();
                sMGameListParent.setGameList(sMIconListParent.getGameList());
                sMGameListParent.setTagId(sMIconListParent.getIconId());
                sMGameListParent.setTagName(sMIconListParent.getIconName());
                SMGameClient.getInstance().startGameListSub(sMGameListParent, GameListFragment.this.requireActivity());
            }
        });
        this.mIconAdapter = iconListAdapter;
        this.mIconRv.setAdapter(iconListAdapter);
        HotBottomListAdapter hotBottomListAdapter = new HotBottomListAdapter(requireActivity(), new ArrayList(), new HotBottomListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.3
            @Override // com.tenmeter.smlibrary.adapter.HotBottomListAdapter.IGameListItemClick
            public void itemClick(SMIconListParent sMIconListParent) {
                GameListFragment.this.process(sMIconListParent);
            }
        });
        this.mHotBottomAdapter = hotBottomListAdapter;
        this.mHotBottomRv.setAdapter(hotBottomListAdapter);
        HotListAdapter hotListAdapter = new HotListAdapter(requireActivity(), new ArrayList(), new HotListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.4
            @Override // com.tenmeter.smlibrary.adapter.HotListAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                GameListFragment.this.gameClick(sMGameInfo);
            }
        }, 0);
        this.mHotAdapter = hotListAdapter;
        this.mHotRv.setAdapter(hotListAdapter);
        HotListAdapter hotListAdapter2 = new HotListAdapter(requireActivity(), new ArrayList(), new HotListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.5
            @Override // com.tenmeter.smlibrary.adapter.HotListAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                GameListFragment.this.gameClick(sMGameInfo);
            }
        }, 1);
        this.m3DAdapter = hotListAdapter2;
        this.m3DRv.setAdapter(hotListAdapter2);
        GameListTypeNewAdapter gameListTypeNewAdapter = new GameListTypeNewAdapter(requireActivity(), new ArrayList(), new GameListTypeNewAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.6
            @Override // com.tenmeter.smlibrary.adapter.GameListTypeNewAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                GameListFragment.this.gameClick(sMGameInfo);
            }

            @Override // com.tenmeter.smlibrary.adapter.GameListTypeNewAdapter.IGameListItemClick
            public void itemMoreClick(SMGameListParent sMGameListParent) {
                SMGameClient.getInstance().startGameListSub(sMGameListParent, GameListFragment.this.requireActivity());
            }
        });
        this.mTypeAdapter = gameListTypeNewAdapter;
        this.mGameRv.setAdapter(gameListTypeNewAdapter);
        this.mLeisureMore.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListFragment.this.leisureGameDatas != null) {
                    SMGameClient.getInstance().startGameListSub(GameListFragment.this.leisureGameDatas, GameListFragment.this.requireActivity());
                }
            }
        });
        BannerTopNewAdapter bannerTopNewAdapter = new BannerTopNewAdapter(requireContext(), new ArrayList(), new BannerTopNewAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.8
            @Override // com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.IGameListItemClick
            public void itemClick(SMGameListBannerParent sMGameListBannerParent) {
                if (sMGameListBannerParent.getRedirectUrl().isEmpty() || sMGameListBannerParent.getRedirectUrl().equals("null")) {
                    GameListFragment.this.gameClick(sMGameListBannerParent.getGame());
                } else {
                    SMGameClient.getInstance().startWebActivity(sMGameListBannerParent.getRedirectUrl(), GameListFragment.this.requireActivity());
                }
            }

            @Override // com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.IGameListItemClick
            public void muteClick(ImageView imageView, ImageView imageView2, SMGameListBannerParent sMGameListBannerParent) {
                if (imageView2.getTag().toString().equals(cu.C)) {
                    GameListFragment.this.isMute = false;
                    GameListFragment.this.mute(SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).getPlayer(sMGameListBannerParent.getVideo()), !imageView.getTag().toString().equals("play"));
                    imageView2.setTag("noMute");
                    imageView2.setImageDrawable(ContextCompat.getDrawable(GameListFragment.this.requireActivity(), R.drawable.mute_close));
                    return;
                }
                GameListFragment.this.isMute = true;
                GameListFragment.this.mute(SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).getPlayer(sMGameListBannerParent.getVideo()), !imageView.getTag().toString().equals("play"));
                imageView2.setTag(cu.C);
                imageView2.setImageDrawable(ContextCompat.getDrawable(GameListFragment.this.requireActivity(), R.drawable.mute_open));
            }

            @Override // com.tenmeter.smlibrary.adapter.BannerTopNewAdapter.IGameListItemClick
            public void playOrPauseClick(ImageView imageView, final SMGameListBannerParent sMGameListBannerParent) {
                if (!imageView.getTag().toString().equals("play")) {
                    if (!GameListFragment.this.bannerPauseIds.contains(sMGameListBannerParent.getId() + "")) {
                        GameListFragment.this.bannerPauseIds.add(sMGameListBannerParent.getId() + "");
                    }
                    SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).getPlayer(sMGameListBannerParent.getVideo()).pause();
                    imageView.setTag("play");
                    imageView.setImageDrawable(ContextCompat.getDrawable(GameListFragment.this.requireActivity(), R.drawable.sm_play_icon));
                    return;
                }
                SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).getPlayer(sMGameListBannerParent.getVideo()).addListener(new Player.Listener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.8.1
                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                        O0IxXx.oIX0oI(this, audioAttributes);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onAudioSessionIdChanged(int i) {
                        O0IxXx.II0xO0(this, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                        O0IxXx.I0Io(this, commands);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onCues(CueGroup cueGroup) {
                        O0IxXx.oxoX(this, cueGroup);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                        O0IxXx.XO(this, deviceInfo);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                        O0IxXx.Oxx0IOOO(this, i, z);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onEvents(Player player, Player.Events events) {
                        O0IxXx.II0XooXoX(this, player, events);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onIsLoadingChanged(boolean z) {
                        O0IxXx.xxIXOIIO(this, z);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onIsPlayingChanged(boolean z) {
                        O0IxXx.xoIox(this, z);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onLoadingChanged(boolean z) {
                        O0IxXx.OOXIXo(this, z);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                        O0IxXx.oOoXoXO(this, j);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                        O0IxXx.ooOOo0oXI(this, mediaItem, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                        O0IxXx.x0XOIxOo(this, mediaMetadata);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onMetadata(Metadata metadata) {
                        O0IxXx.oO(this, metadata);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                        O0IxXx.x0xO0oo(this, z, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                        O0IxXx.Oo(this, playbackParameters);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public void onPlaybackStateChanged(int i) {
                        KLog.a("onPlayerStateChanged++++" + i);
                        if (i == 4) {
                            SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).release(GameListFragment.this.mBannerNewAdapter.getData().get(GameListFragment.this.mBannerNewAdapter.getData().indexOf(sMGameListBannerParent)).getVideo());
                            SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).removePlay(GameListFragment.this.mBannerNewAdapter.getData().get(GameListFragment.this.mBannerNewAdapter.getData().indexOf(sMGameListBannerParent)).getVideo());
                            GameListFragment gameListFragment = GameListFragment.this;
                            gameListFragment.processLoadVideoForEnd(gameListFragment.mBannerNewAdapter.getData().indexOf(sMGameListBannerParent));
                        }
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                        O0IxXx.Oxx0xo(this, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                        O0IxXx.oI0IIXIo(this, playbackException);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                        O0IxXx.OxxIIOOXO(this, playbackException);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                        O0IxXx.IIXOooo(this, z, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                        O0IxXx.xoXoI(this, mediaMetadata);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPositionDiscontinuity(int i) {
                        O0IxXx.o00(this, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onRenderedFirstFrame() {
                        O0IxXx.O0xOxO(this);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onRepeatModeChanged(int i) {
                        O0IxXx.X0IIOO(this, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                        O0IxXx.XI0IXoo(this, j);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                        O0IxXx.XIxXXX0x0(this, j);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onSeekProcessed() {
                        O0IxXx.xxX(this);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                        O0IxXx.XxX0x0xxx(this, z);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                        O0IxXx.xXxxox0I(this, z);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                        O0IxXx.IIX0o(this, i, i2);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                        O0IxXx.ooXIXxIX(this, timeline, i);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                        O0IxXx.xI(this, trackSelectionParameters);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onTracksChanged(Tracks tracks) {
                        O0IxXx.oo0xXOI0I(this, tracks);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                        O0IxXx.oo(this, videoSize);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onVolumeChanged(float f) {
                        O0IxXx.IoOoX(this, f);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onCues(List list) {
                        O0IxXx.X0o0xo(this, list);
                    }

                    @Override // com.google.android.exoplayer2.Player.Listener
                    public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
                        O0IxXx.OxI(this, positionInfo, positionInfo2, i);
                    }
                });
                if (GameListFragment.this.bannerPauseIds.contains(sMGameListBannerParent.getId() + "")) {
                    GameListFragment.this.bannerPauseIds.remove(sMGameListBannerParent.getId() + "");
                }
                GameListFragment.this.mute(SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).getPlayer(sMGameListBannerParent.getVideo()), false);
                SMPlayerManagerFactory.factory(SMGameClient.getContext(), GameListFragment.this.from).getPlayer(sMGameListBannerParent.getVideo()).play();
                imageView.setTag("pause");
                imageView.setImageDrawable(ContextCompat.getDrawable(GameListFragment.this.requireActivity(), R.drawable.sm_pause_icon));
            }
        });
        this.mBannerNewAdapter = bannerTopNewAdapter;
        this.mBannerRecyclerview.setAdapter(bannerTopNewAdapter);
        this.mBannerLayoutManager.setOnPageChangeListener(new ViewPagerLayoutManager.OnPageChangeListener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.9
            @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                KLog.a("onPageScrollStateChanged+++++" + i);
            }

            @Override // com.tenmeter.smlibrary.widget.viewpagerlayout.ViewPagerLayoutManager.OnPageChangeListener
            public void onPageSelected(int i) {
                GameListFragment.this.processLoadVideo(i);
            }
        });
    }

    public void hideLoading() {
        LoadDia loadDia;
        try {
            if (requireActivity() != null && (loadDia = this.mLoadDia) != null && loadDia.isShowing()) {
                this.mLoadDia.dismiss();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.view;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.view.getParent()).removeView(this.view);
            }
            return this.view;
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_sm_sdk_game_list, (ViewGroup) null, false);
        this.view = inflate;
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Log.e("requestUrl", "onDestroy");
        this.hd.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull final View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.1

            /* renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes13.dex */
            public class C10981 implements LifecycleEventObserver {
                public C10981() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onStateChanged$0() {
                    try {
                        if (GameListFragment.this.mBannerNewAdapter.getData().size() > 0) {
                            int currentPosition = GameListFragment.this.mBannerLayoutManager.getCurrentPosition();
                            if (GameListFragment.this.mBannerNewAdapter.getData().get(currentPosition).getBannerType() == 99) {
                                View findViewByPosition = GameListFragment.this.mBannerLayoutManager.findViewByPosition(currentPosition);
                                int i = R.id.ivPlayOrPause;
                                ((ImageView) findViewByPosition.findViewById(i)).setImageDrawable(ContextCompat.getDrawable(GameListFragment.this.requireContext(), R.drawable.sm_play_icon));
                                findViewByPosition.findViewById(i).setTag("play");
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_RESUME) {
                        GameListFragment.this.isShow = true;
                        GameListFragment.this.initData();
                        return;
                    }
                    if (event == Lifecycle.Event.ON_PAUSE) {
                        if (GameListFragment.this.mAdRunnable != null) {
                            GameListFragment.this.hd.removeCallbacks(GameListFragment.this.mAdRunnable);
                        }
                        GameListFragment.this.isShow = false;
                        try {
                            SMPlayerManagerFactory.factory(GameListFragment.this.requireContext(), GameListFragment.this.from).pauseAll();
                            GameListFragment.this.mBannerRecyclerview.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.oxoX
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GameListFragment.AnonymousClass1.C10981.this.lambda$onStateChanged$0();
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    if (event == Lifecycle.Event.ON_STOP) {
                        GameListFragment.this.isShow = false;
                        return;
                    }
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        GameListFragment.this.isShow = false;
                        try {
                            SMPlayerManagerFactory.factory(GameListFragment.this.requireContext(), GameListFragment.this.from).releaseAll();
                            SMPlayerManagerFactory.release(GameListFragment.this.from);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                SMGameClient.getInstance().setIFragmentChangeCallback(GameListFragment.this);
                GameListFragment.this.from = SMPlayerManagerFactory.FROM_FRAGMENT_BANNER + UUID.randomUUID().toString();
                KLog.a("from===========" + GameListFragment.this.from);
                GameListFragment.this.initView(view);
                GameListFragment.this.registerListener();
                GameListFragment.this.getLifecycle().addObserver(new C10981());
            }
        });
    }

    @Override // com.tenmeter.smlibrary.listener.IFragmentChangeCallback
    public void show(boolean z) {
        if (z) {
            this.bannerIds.clear();
            RecyclerView recyclerView = this.mBannerRecyclerview;
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.oIX0oI
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameListFragment.this.lambda$show$2();
                    }
                });
            }
        }
    }

    public void showLoading() {
        try {
            if (requireActivity() != null) {
                if (this.mLoadDia == null) {
                    this.mLoadDia = new LoadDia(getContext());
                }
                if (!this.mLoadDia.isShowing()) {
                    this.mLoadDia.show();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
