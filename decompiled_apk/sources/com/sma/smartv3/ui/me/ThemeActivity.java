package com.sma.smartv3.ui.me;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.biz.ad.ADPAdError;
import com.sma.smartv3.biz.ad.ADPAdListener;
import com.sma.smartv3.biz.ad.ADPCAdError;
import com.sma.smartv3.biz.ad.ADPCAdListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.ad.ADPAdContainerView;
import com.sma.smartv3.view.ad.ADPCAdContainerView;
import java.util.List;

/* loaded from: classes11.dex */
public class ThemeActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    private final String TAG = "Theme";
    private final int nowTheme = com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24444oO, 0);

    /* loaded from: classes11.dex */
    public static final class II0xO0 extends ADPAdListener {
        public II0xO0() {
        }

        public void onAdFailed(@OXOo.OOXIXo ADPAdError error) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ThemeActivity.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
        }

        public void onAdLoaded() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ThemeActivity.this.TAG + " -> Ad State : Loaded");
        }

        public void onAdOpen() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ThemeActivity.this.TAG + " -> Ad State : Exposure");
        }
    }

    /* loaded from: classes11.dex */
    public static final class oIX0oI extends ADPCAdListener {
        public oIX0oI() {
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADError(@OXOo.OOXIXo ADPCAdError error) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ThemeActivity.this.TAG + " -> Ad State : Error, Info: " + error.getCode() + ", " + error.getMsg());
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADPresent() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ThemeActivity.this.TAG + " -> Ad State : Exposure");
        }

        @Override // com.sma.smartv3.biz.ad.ADPCAdListener
        public void onADReceive() {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(ThemeActivity.this.TAG + " -> Ad State : Loaded");
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ADPAdContainerView aDPAdContainerView;
        super.initView();
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.switch_theme);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.IIX0()) {
            ADPCAdContainerView aDPCAdContainerView = (ADPCAdContainerView) findViewById(R.id.adpcAdContainerView);
            if (aDPCAdContainerView != null) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> id:" + aDPCAdContainerView.getAdUnitId());
                aDPCAdContainerView.setAdListener(new oIX0oI());
                ADPCAdContainerView.loadAdView$default(aDPCAdContainerView, null, 0, false, null, 15, null);
                return;
            }
            return;
        }
        if (projectManager.oXIO0o0XI() && (aDPAdContainerView = (ADPAdContainerView) findViewById(R.id.adpAdContainerView)) != null) {
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " -> id:" + aDPAdContainerView.getAdUnitId());
            aDPAdContainerView.setAdListener(new II0xO0());
            ADPAdContainerView.loadAdView$default(aDPAdContainerView, null, 0, false, null, 15, null);
        }
    }

    public boolean isThemeSelect(int i) {
        if (i != com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24444oO, 0)) {
            return false;
        }
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_theme;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        onTitleLeftClick(getRecyclerView());
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public void onInitBaseLayoutAfter() {
        super.onInitBaseLayoutAfter();
        getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity$onInitBaseLayoutAfter$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.getItemSelectorHelper().IoOoX(1);
                DslViewHolder dslViewHolder = ThemeActivity.this.getDslViewHolder();
                final ThemeActivity themeActivity = ThemeActivity.this;
                dslViewHolder.post(new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity$onInitBaseLayoutAfter$1.1
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke() {
                        invoke2();
                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        final ThemeActivity themeActivity2 = ThemeActivity.this;
                        themeActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapter dslAdapter) {
                                invoke2(dslAdapter);
                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@OXOo.OOXIXo DslAdapter renderAdapter2) {
                                kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                final ThemeActivity themeActivity3 = ThemeActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_theme, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo final DslAdapterItem dslItem) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        dslItem.setItemIsSelected(ThemeActivity.this.isThemeSelect(0));
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.1.1
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                ImageView img = itemHolder.img(R.id.isSelectIv);
                                                if (img != null) {
                                                    img.setVisibility(DslAdapterItem.this.getItemIsSelected() ? 0 : 8);
                                                }
                                                TextView tv = itemHolder.tv(R.id.themeTv);
                                                if (tv != null) {
                                                    tv.setText(tv.getContext().getString(R.string.follow_theme));
                                                    tv.setTextColor(tv.getResources().getColor(R.color.line_color));
                                                }
                                                View view = itemHolder.view(R.id.themeRl);
                                                if (view != null) {
                                                    view.setBackgroundResource(R.drawable.pic_theme_system);
                                                }
                                            }
                                        });
                                        final ThemeActivity themeActivity4 = ThemeActivity.this;
                                        dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                                                invoke2(view);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo View it) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                if (DslAdapterItem.this.getItemIsSelected()) {
                                                    return;
                                                }
                                                DslAdapterItem.updateItemSelector$default(DslAdapterItem.this, !r5.getItemIsSelected(), false, 2, null);
                                                themeActivity4.updateTheme(0);
                                            }
                                        });
                                    }
                                });
                                final ThemeActivity themeActivity4 = ThemeActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_theme, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo final DslAdapterItem dslItem) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        dslItem.setItemIsSelected(ThemeActivity.this.isThemeSelect(1));
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.2.1
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                ImageView img = itemHolder.img(R.id.isSelectIv);
                                                if (img != null) {
                                                    img.setVisibility(DslAdapterItem.this.getItemIsSelected() ? 0 : 8);
                                                }
                                                TextView tv = itemHolder.tv(R.id.themeTv);
                                                if (tv != null) {
                                                    tv.setText(tv.getContext().getString(R.string.dark_theme));
                                                    tv.setTextColor(tv.getResources().getColor(R.color.line_color));
                                                }
                                                View view = itemHolder.view(R.id.themeRl);
                                                if (view != null) {
                                                    view.setBackgroundResource(R.drawable.pic_theme_dark);
                                                }
                                            }
                                        });
                                        final ThemeActivity themeActivity5 = ThemeActivity.this;
                                        dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                                                invoke2(view);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo View it) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                if (DslAdapterItem.this.getItemIsSelected()) {
                                                    return;
                                                }
                                                DslAdapterItem.updateItemSelector$default(DslAdapterItem.this, !r6.getItemIsSelected(), false, 2, null);
                                                themeActivity5.updateTheme(1);
                                            }
                                        });
                                    }
                                });
                                final ThemeActivity themeActivity5 = ThemeActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_theme, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo final DslAdapterItem dslItem) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        final ThemeActivity themeActivity6 = ThemeActivity.this;
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                DslAdapterItem.this.setItemIsSelected(themeActivity6.isThemeSelect(2));
                                                ImageView img = itemHolder.img(R.id.isSelectIv);
                                                if (img != null) {
                                                    img.setVisibility(DslAdapterItem.this.getItemIsSelected() ? 0 : 8);
                                                }
                                                TextView tv = itemHolder.tv(R.id.themeTv);
                                                if (tv != null) {
                                                    tv.setText(tv.getContext().getString(R.string.light_theme));
                                                    tv.setTextColor(tv.getResources().getColor(R.color.line_color));
                                                }
                                                View view = itemHolder.view(R.id.themeRl);
                                                if (view != null) {
                                                    view.setBackgroundResource(R.drawable.pic_theme_light);
                                                }
                                            }
                                        });
                                        final ThemeActivity themeActivity7 = ThemeActivity.this;
                                        dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                                                invoke2(view);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo View it) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                if (DslAdapterItem.this.getItemIsSelected()) {
                                                    return;
                                                }
                                                DslAdapterItem.updateItemSelector$default(DslAdapterItem.this, !r5.getItemIsSelected(), false, 2, null);
                                                themeActivity7.updateTheme(2);
                                            }
                                        });
                                    }
                                });
                                final ThemeActivity themeActivity6 = ThemeActivity.this;
                                DslAdapterExKt.oO(renderAdapter2, R.layout.item_theme, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return kotlin.oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo final DslAdapterItem dslItem) {
                                        kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        final ThemeActivity themeActivity7 = ThemeActivity.this;
                                        dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // Oox.Oxx0xo
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                                invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                                DslAdapterItem.this.setItemIsSelected(themeActivity7.isThemeSelect(3));
                                                ImageView img = itemHolder.img(R.id.isSelectIv);
                                                if (img != null) {
                                                    img.setVisibility(DslAdapterItem.this.getItemIsSelected() ? 0 : 8);
                                                }
                                                TextView tv = itemHolder.tv(R.id.themeTv);
                                                if (tv != null) {
                                                    tv.setText(tv.getContext().getString(R.string.brown_black_theme));
                                                    tv.setTextColor(tv.getResources().getColor(R.color.line_color));
                                                }
                                                View view = itemHolder.view(R.id.themeRl);
                                                if (view != null) {
                                                    view.setBackgroundResource(R.drawable.pic_theme_brown_black);
                                                }
                                            }
                                        });
                                        final ThemeActivity themeActivity8 = ThemeActivity.this;
                                        dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.me.ThemeActivity.onInitBaseLayoutAfter.1.1.1.4.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // Oox.oOoXoXO
                                            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(View view) {
                                                invoke2(view);
                                                return kotlin.oXIO0o0XI.f29392oIX0oI;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(@OXOo.OOXIXo View it) {
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                                                if (DslAdapterItem.this.getItemIsSelected()) {
                                                    return;
                                                }
                                                DslAdapterItem.updateItemSelector$default(DslAdapterItem.this, !r5.getItemIsSelected(), false, 2, null);
                                                themeActivity8.updateTheme(3);
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().getInt(com.sma.smartv3.util.XoI0Ixx0.f24444oO, 0) != this.nowTheme) {
            ToastUtils.showLong(R.string.reboot_app_show_new_view);
            com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24635oX, null, 2, null);
        }
        finish();
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
    public int refreshLayoutId() {
        return 0;
    }

    public final void updateTheme(int i) {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.oIX0oI().put(com.sma.smartv3.util.XoI0Ixx0.f24444oO, i);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        IIXOxIxOo.I0Io.IXxxXO().IIX0o("brown_black", null, 1);
                        return;
                    }
                    return;
                }
                IIXOxIxOo.I0Io.IXxxXO().IIX0o(ToastUtils.MODE.LIGHT, null, 1);
                return;
            }
            IIXOxIxOo.I0Io.IXxxXO().ooXIXxIX();
            return;
        }
        setTheme();
        if (Build.VERSION.SDK_INT < 29) {
            ToastUtils.showLong(R.string.system_no_support_switch);
        }
    }
}
