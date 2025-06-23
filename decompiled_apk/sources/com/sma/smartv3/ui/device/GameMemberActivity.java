package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.UserMember;
import com.sma.smartv3.network.Api;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

@kotlin.jvm.internal.XX({"SMAP\nGameMemberActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameMemberActivity.kt\ncom/sma/smartv3/ui/device/GameMemberActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,221:1\n19#2:222\n15#2:223\n93#2,2:224\n90#2:226\n93#2,2:227\n90#2:229\n1855#3:230\n1855#3,2:231\n1856#3:233\n*S KotlinDebug\n*F\n+ 1 GameMemberActivity.kt\ncom/sma/smartv3/ui/device/GameMemberActivity\n*L\n45#1:222\n45#1:223\n98#1:224,2\n98#1:226\n110#1:227,2\n110#1:229\n159#1:230\n174#1:231,2\n159#1:233\n*E\n"})
/* loaded from: classes12.dex */
public final class GameMemberActivity extends BaseDSLRecyclerActivity {

    @OXOo.OOXIXo
    private final String TAG = "GameMemberActivity";

    @OXOo.OOXIXo
    private final AppUser appUser;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mMemberBtn$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mUserAvatar$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mUserMemberTime$delegate;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mUserName$delegate;

    public GameMemberActivity() {
        SPUtils XO2 = com.sma.smartv3.util.Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        this.appUser = (AppUser) (fromJson != null ? fromJson : appUser);
        this.mUserAvatar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$mUserAvatar$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final ImageView invoke() {
                return (ImageView) GameMemberActivity.this.findViewById(R.id.game_member_iv_avatar);
            }
        });
        this.mUserName$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$mUserName$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) GameMemberActivity.this.findViewById(R.id.game_member_user_name);
            }
        });
        this.mUserMemberTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$mUserMemberTime$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final TextView invoke() {
                return (TextView) GameMemberActivity.this.findViewById(R.id.game_member_user_member_time);
            }
        });
        this.mMemberBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$mMemberBtn$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            public final Button invoke() {
                return (Button) GameMemberActivity.this.findViewById(R.id.btn_bottom);
            }
        });
    }

    private final Button getMMemberBtn() {
        return (Button) this.mMemberBtn$delegate.getValue();
    }

    private final ImageView getMUserAvatar() {
        return (ImageView) this.mUserAvatar$delegate.getValue();
    }

    private final TextView getMUserMemberTime() {
        return (TextView) this.mUserMemberTime$delegate.getValue();
    }

    private final TextView getMUserName() {
        return (TextView) this.mUserName$delegate.getValue();
    }

    private final void getServerData() {
        OrderManager.f20130oIX0oI.xxX(new Oox.oOoXoXO<Boolean, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$getServerData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Boolean bool) {
                invoke2(bool);
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.oOoXoXO Boolean bool) {
                GameMemberActivity.this.initView();
            }
        });
    }

    public final void findData(@OXOo.OOXIXo List<? extends SMIconListParent> result) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
        for (final SMIconListParent sMIconListParent : result) {
            DslAdapterExKt.oO(getDslAdapter(), R.layout.layout_online_watchface_category_head, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                    invoke2(dslAdapterItem);
                    return kotlin.oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                    dslItem.setItemIsGroupHead(true);
                    dslItem.setItemIsHover(false);
                    dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(SMIconListParent.this.getIconName()));
                    final SMIconListParent sMIconListParent2 = SMIconListParent.this;
                    dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$1.1
                        {
                            super(4);
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                            kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                            TextView tv = itemHolder.tv(R.id.tv_name);
                            if (tv == null) {
                                return;
                            }
                            tv.setText(SMIconListParent.this.getIconName());
                        }
                    });
                    dslItem.setItemTag(SMIconListParent.this.getIconName());
                    final SMIconListParent sMIconListParent3 = SMIconListParent.this;
                    final GameMemberActivity gameMemberActivity = this;
                    dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$1.2
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
                            com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.Oxx0xo(SMIconListParent.this, gameMemberActivity);
                        }
                    });
                }
            });
            List<SMGameInfo> gameList = sMIconListParent.getGameList();
            kotlin.jvm.internal.IIX0o.oO(gameList, "getGameList(...)");
            for (final SMGameInfo sMGameInfo : CollectionsKt___CollectionsKt.O0o000XOX(gameList, 4)) {
                DslAdapterExKt.oO(getDslAdapter(), R.layout.item_game_member, new Oox.oOoXoXO<DslAdapterItem, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$2$1

                    /* renamed from: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$2$1$1, reason: invalid class name */
                    /* loaded from: classes12.dex */
                    public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, kotlin.oXIO0o0XI> {
                        final /* synthetic */ SMGameInfo $gameInfo;
                        final /* synthetic */ GameMemberActivity this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(GameMemberActivity gameMemberActivity, SMGameInfo sMGameInfo) {
                            super(4);
                            this.this$0 = gameMemberActivity;
                            this.$gameInfo = sMGameInfo;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final void invoke$lambda$0(GameMemberActivity this$0, SMGameInfo sMGameInfo, View view) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
                            com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(sMGameInfo);
                            oOXIXo.IXxxXO(this$0, sMGameInfo);
                        }

                        @Override // Oox.Oxx0xo
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                            invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(@OXOo.OOXIXo DslViewHolder itemHolder, int i, @OXOo.OOXIXo DslAdapterItem adapterItem, @OXOo.OOXIXo List<? extends Object> payloads) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(itemHolder, "itemHolder");
                            kotlin.jvm.internal.IIX0o.x0xO0oo(adapterItem, "adapterItem");
                            kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
                            ImageView imageView = (ImageView) itemHolder.v(R.id.item_game_icon);
                            if (imageView != null) {
                                RequestOptions transform = new RequestOptions().transform(new RoundedCorners(20));
                                kotlin.jvm.internal.IIX0o.oO(transform, "transform(...)");
                                Glide.with((FragmentActivity) this.this$0).load(this.$gameInfo.getBackground()).apply((BaseRequestOptions<?>) transform).into(imageView);
                                final GameMemberActivity gameMemberActivity = this.this$0;
                                final SMGameInfo sMGameInfo = this.$gameInfo;
                                imageView.setOnClickListener(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: INVOKE 
                                      (r3v6 'imageView' android.widget.ImageView)
                                      (wrap:android.view.View$OnClickListener:0x004e: CONSTRUCTOR 
                                      (r4v13 'gameMemberActivity' com.sma.smartv3.ui.device.GameMemberActivity A[DONT_INLINE])
                                      (r5v8 'sMGameInfo' com.tenmeter.smlibrary.entity.SMGameInfo A[DONT_INLINE])
                                     A[MD:(com.sma.smartv3.ui.device.GameMemberActivity, com.tenmeter.smlibrary.entity.SMGameInfo):void (m), WRAPPED] call: com.sma.smartv3.ui.device.oXX0IoI.<init>(com.sma.smartv3.ui.device.GameMemberActivity, com.tenmeter.smlibrary.entity.SMGameInfo):void type: CONSTRUCTOR)
                                     VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$2$1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.device.oXX0IoI, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 21 more
                                    */
                                /*
                                    this = this;
                                    java.lang.String r3 = "itemHolder"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r3)
                                    java.lang.String r3 = "adapterItem"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r3)
                                    java.lang.String r3 = "payloads"
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r3)
                                    r3 = 2131364840(0x7f0a0be8, float:1.8349528E38)
                                    android.view.View r3 = r2.v(r3)
                                    android.widget.ImageView r3 = (android.widget.ImageView) r3
                                    if (r3 == 0) goto L54
                                    com.bumptech.glide.request.RequestOptions r4 = new com.bumptech.glide.request.RequestOptions
                                    r4.<init>()
                                    com.bumptech.glide.load.resource.bitmap.RoundedCorners r5 = new com.bumptech.glide.load.resource.bitmap.RoundedCorners
                                    r0 = 20
                                    r5.<init>(r0)
                                    com.bumptech.glide.request.BaseRequestOptions r4 = r4.transform(r5)
                                    java.lang.String r5 = "transform(...)"
                                    kotlin.jvm.internal.IIX0o.oO(r4, r5)
                                    com.bumptech.glide.request.RequestOptions r4 = (com.bumptech.glide.request.RequestOptions) r4
                                    com.sma.smartv3.ui.device.GameMemberActivity r5 = r1.this$0
                                    com.bumptech.glide.RequestManager r5 = com.bumptech.glide.Glide.with(r5)
                                    com.tenmeter.smlibrary.entity.SMGameInfo r0 = r1.$gameInfo
                                    java.lang.String r0 = r0.getBackground()
                                    com.bumptech.glide.RequestBuilder r5 = r5.load(r0)
                                    com.bumptech.glide.RequestBuilder r4 = r5.apply(r4)
                                    r4.into(r3)
                                    com.sma.smartv3.ui.device.GameMemberActivity r4 = r1.this$0
                                    com.tenmeter.smlibrary.entity.SMGameInfo r5 = r1.$gameInfo
                                    com.sma.smartv3.ui.device.oXX0IoI r0 = new com.sma.smartv3.ui.device.oXX0IoI
                                    r0.<init>(r4, r5)
                                    r3.setOnClickListener(r0)
                                L54:
                                    r3 = 2131364842(0x7f0a0bea, float:1.8349532E38)
                                    android.widget.TextView r3 = r2.tv(r3)
                                    if (r3 != 0) goto L5e
                                    goto L67
                                L5e:
                                    com.tenmeter.smlibrary.entity.SMGameInfo r4 = r1.$gameInfo
                                    java.lang.String r4 = r4.getGname()
                                    r3.setText(r4)
                                L67:
                                    r3 = 2131364839(0x7f0a0be7, float:1.8349526E38)
                                    android.widget.TextView r3 = r2.tv(r3)
                                    if (r3 != 0) goto L71
                                    goto L7a
                                L71:
                                    com.tenmeter.smlibrary.entity.SMGameInfo r4 = r1.$gameInfo
                                    java.lang.String r4 = r4.getDetails()
                                    r3.setText(r4)
                                L7a:
                                    r3 = 2131364841(0x7f0a0be9, float:1.834953E38)
                                    android.widget.TextView r2 = r2.tv(r3)
                                    if (r2 != 0) goto L84
                                    goto La0
                                L84:
                                    com.sma.smartv3.ui.device.GameMemberActivity r3 = r1.this$0
                                    com.tenmeter.smlibrary.entity.SMGameInfo r4 = r1.$gameInfo
                                    long r4 = r4.getPlayNum()
                                    java.lang.Long r4 = java.lang.Long.valueOf(r4)
                                    r5 = 1
                                    java.lang.Object[] r5 = new java.lang.Object[r5]
                                    r0 = 0
                                    r5[r0] = r4
                                    r4 = 2132018695(0x7f140607, float:1.9675704E38)
                                    java.lang.String r3 = r3.getString(r4, r5)
                                    r2.setText(r3)
                                La0:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$2$1.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                            invoke2(dslAdapterItem);
                            return kotlin.oXIO0o0XI.f29392oIX0oI;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                            kotlin.jvm.internal.IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                            dslItem.setItemGroups(CollectionsKt__CollectionsKt.XOxIOxOx(SMIconListParent.this.getIconName()));
                            dslItem.setItemBindOverride(new AnonymousClass1(this, sMGameInfo));
                            final GameMemberActivity gameMemberActivity = this;
                            final SMGameInfo sMGameInfo2 = sMGameInfo;
                            dslItem.setItemClick(new Oox.oOoXoXO<View, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$findData$1$2$1.2
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
                                    com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
                                    GameMemberActivity gameMemberActivity2 = GameMemberActivity.this;
                                    SMGameInfo gameInfo = sMGameInfo2;
                                    kotlin.jvm.internal.IIX0o.oO(gameInfo, "$gameInfo");
                                    oOXIXo.IXxxXO(gameMemberActivity2, gameInfo);
                                }
                            });
                        }
                    });
                }
            }
            getDslAdapter().notifyDataSetChanged();
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public void init(@OXOo.oOoXoXO Bundle bundle) {
        }

        @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
        public boolean initEvent() {
            return true;
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity, com.bestmafen.androidbase.base.oIX0oI
        public void initView() {
            String string;
            String string2;
            super.initView();
            setStatusBarColor(this, oIxOXo.oxoX.I0Io(getMContext(), R.color.game_member_status_color));
            if (this.appUser.getAvatarUrl().length() > 0) {
                Glide.with((FragmentActivity) this).load(this.appUser.getAvatarUrl()).error(R.drawable.pic_avatar_default).into(getMUserAvatar());
            }
            getMUserName().setText(this.appUser.getNickname());
            com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
            SPUtils XO2 = xo0.XO();
            Object fromJson = new Gson().fromJson(XO2.getString(com.sma.smartv3.util.x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
            if (fromJson == null) {
                fromJson = UserMember.class.newInstance();
            }
            UserMember userMember = (UserMember) fromJson;
            TextView mUserMemberTime = getMUserMemberTime();
            com.sma.smartv3.biz.OOXIXo oOXIXo = com.sma.smartv3.biz.OOXIXo.f20119oIX0oI;
            if (oOXIXo.o00(userMember)) {
                string = getString(R.string.valid_until) + com.sma.smartv3.util.xoIox.Oxx0IOOO().format(new Date(userMember.getLatestGameMemberDateTime()));
            } else if (userMember.getLatestGameMemberDateTime() > 0) {
                string = getString(R.string.game_member_expired_tip);
            } else {
                string = getString(R.string.game_member_no_have);
            }
            mUserMemberTime.setText(string);
            ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.game_member_title);
            SPUtils XO3 = xo0.XO();
            Object fromJson2 = new Gson().fromJson(XO3.getString(com.sma.smartv3.util.x0xO0oo.f24656xOoOIoI + '_' + UserMember.class.getName()), (Class<Object>) UserMember.class);
            if (fromJson2 == null) {
                fromJson2 = UserMember.class.newInstance();
            }
            UserMember userMember2 = (UserMember) fromJson2;
            Button mMemberBtn = getMMemberBtn();
            if (userMember2.getLatestGameMemberDateTime() > 0) {
                if (oOXIXo.o00(userMember2)) {
                    string2 = getString(R.string.game_member_renewal_btn);
                } else {
                    string2 = getString(R.string.renew_now);
                }
            } else {
                string2 = getString(R.string.game_member_open_btn);
            }
            mMemberBtn.setText(string2);
            if (getRecyclerView().getItemDecorationCount() == 0) {
                getRecyclerView().addItemDecoration(new DividerItemDecoration(getMContext(), 0));
            }
        }

        @Override // com.bestmafen.androidbase.base.oIX0oI
        public int layoutId() {
            return R.layout.activity_game_member;
        }

        public final void onBottomClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oI0IIXIo(this);
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public void onInitBaseLayoutAfter() {
            super.onInitBaseLayoutAfter();
            com.sma.smartv3.biz.OOXIXo.f20119oIX0oI.oOoXoXO(new xxxI.II0xO0<List<SMIconListParent>>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$onInitBaseLayoutAfter$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                    ToastUtils.showLong(error, new Object[0]);
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO List<SMIconListParent> list) {
                    ArrayList arrayList;
                    String str;
                    Integer num = null;
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(Api.INSTANCE.getBASE_URL(), com.sma.smartv3.ui.me.O0X.f23389oIX0oI)) {
                        if (list != null) {
                            arrayList = new ArrayList();
                            for (Object obj : list) {
                                SMIconListParent sMIconListParent = (SMIconListParent) obj;
                                if (sMIconListParent.getIconId() == 84 || sMIconListParent.getIconId() == 85) {
                                    arrayList.add(obj);
                                }
                            }
                        }
                        arrayList = null;
                    } else {
                        if (list != null) {
                            arrayList = new ArrayList();
                            for (Object obj2 : list) {
                                SMIconListParent sMIconListParent2 = (SMIconListParent) obj2;
                                if (sMIconListParent2.getIconId() == 50 || sMIconListParent2.getIconId() == 52) {
                                    arrayList.add(obj2);
                                }
                            }
                        }
                        arrayList = null;
                    }
                    OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                    StringBuilder sb = new StringBuilder();
                    str = GameMemberActivity.this.TAG;
                    sb.append(str);
                    sb.append(" getIconLists = ");
                    if (arrayList != null) {
                        num = Integer.valueOf(arrayList.size());
                    }
                    sb.append(num);
                    oix0oi.oIX0oI(sb.toString());
                    GameMemberActivity.this.showList(arrayList);
                }
            });
        }

        @XO0.XO(tag = com.sma.smartv3.util.x0xO0oo.f24583O0)
        public final void onOrderPayStatusChange(@OXOo.OOXIXo Object data) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
            OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " onOrderPayStatusChange");
            getServerData();
        }

        public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
            finish();
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public int recyclerViewId() {
            return R.id.game_member_rv;
        }

        @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity
        public int refreshLayoutId() {
            return 0;
        }

        public final void showList(@OXOo.oOoXoXO final List<? extends SMIconListParent> list) {
            renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$showList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    DslViewHolder dslViewHolder = GameMemberActivity.this.getDslViewHolder();
                    final GameMemberActivity gameMemberActivity = GameMemberActivity.this;
                    final List<SMIconListParent> list2 = list;
                    dslViewHolder.postDelay(300L, new Oox.oIX0oI<kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity$showList$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            final GameMemberActivity gameMemberActivity2 = GameMemberActivity.this;
                            final List<SMIconListParent> list3 = list2;
                            gameMemberActivity2.renderAdapter(new Oox.oOoXoXO<DslAdapter, kotlin.oXIO0o0XI>() { // from class: com.sma.smartv3.ui.device.GameMemberActivity.showList.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
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
                                    String str;
                                    kotlin.jvm.internal.IIX0o.x0xO0oo(renderAdapter2, "$this$renderAdapter");
                                    DslAdapter.setAdapterStatus$default(renderAdapter2, 0, null, 2, null);
                                    List<SMIconListParent> list4 = list3;
                                    if (list4 != null && !list4.isEmpty()) {
                                        List<SMIconListParent> list5 = list3;
                                        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list5, 10));
                                        Iterator<T> it = list5.iterator();
                                        boolean z = true;
                                        while (it.hasNext()) {
                                            List<SMGameInfo> gameList = ((SMIconListParent) it.next()).getGameList();
                                            Integer valueOf = gameList != null ? Integer.valueOf(gameList.size()) : null;
                                            kotlin.jvm.internal.IIX0o.ooOOo0oXI(valueOf);
                                            if (valueOf.intValue() > 0) {
                                                z = false;
                                            }
                                            arrayList.add(kotlin.oXIO0o0XI.f29392oIX0oI);
                                        }
                                        if (z) {
                                            gameMemberActivity2.getRecyclerView().setVisibility(8);
                                        } else {
                                            gameMemberActivity2.getRecyclerView().setVisibility(0);
                                            gameMemberActivity2.findData(list3);
                                        }
                                        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
                                        StringBuilder sb = new StringBuilder();
                                        str = gameMemberActivity2.TAG;
                                        sb.append(str);
                                        sb.append(" isEmptyData = ");
                                        sb.append(z);
                                        oix0oi.oIX0oI(sb.toString());
                                        return;
                                    }
                                    gameMemberActivity2.getRecyclerView().setVisibility(8);
                                }
                            });
                        }
                    });
                }
            });
        }
    }
