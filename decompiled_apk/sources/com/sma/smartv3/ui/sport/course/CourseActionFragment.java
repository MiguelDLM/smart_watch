package com.sma.smartv3.ui.sport.course;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CourseDetails;
import com.sma.smartv3.model.ProgressMarkers;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class CourseActionFragment extends BaseDSLRecyclerFragment {
    private CourseDetails mCourseDetails;

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        Serializable mArg3 = getMArg3();
        IIX0o.x0XOIxOo(mArg3, "null cannot be cast to non-null type com.sma.smartv3.model.CourseDetails");
        this.mCourseDetails = (CourseDetails) mArg3;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        CourseDetails courseDetails = this.mCourseDetails;
        if (courseDetails == null) {
            IIX0o.XOxIOxOx("mCourseDetails");
            courseDetails = null;
        }
        showData(courseDetails.getProgressMarkers());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.course_fragment_rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int recyclerViewId() {
        return R.id.rv;
    }

    @Override // com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment
    public int refreshLayoutId() {
        return 0;
    }

    public final void showData(@OXOo.OOXIXo final List<ProgressMarkers> list) {
        IIX0o.x0xO0oo(list, "list");
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseActionFragment$showData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter) {
                invoke2(dslAdapter);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo final DslAdapter renderAdapter) {
                IIX0o.x0xO0oo(renderAdapter, "$this$renderAdapter");
                renderAdapter.clearAllItems();
                DslAdapter.setAdapterStatus$default(renderAdapter, 2, null, 2, null);
                DslViewHolder dslViewHolder = CourseActionFragment.this.getDslViewHolder();
                final List<ProgressMarkers> list2 = list;
                final CourseActionFragment courseActionFragment = CourseActionFragment.this;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseActionFragment$showData$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // Oox.oIX0oI
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                        invoke2();
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        List<ProgressMarkers> list3 = list2;
                        DslAdapter dslAdapter = renderAdapter;
                        final CourseActionFragment courseActionFragment2 = courseActionFragment;
                        for (final ProgressMarkers progressMarkers : list3) {
                            DslAdapterExKt.oO(dslAdapter, R.layout.item_action_course, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseActionFragment$showData$1$1$1$1

                                /* renamed from: com.sma.smartv3.ui.sport.course.CourseActionFragment$showData$1$1$1$1$1, reason: invalid class name */
                                /* loaded from: classes12.dex */
                                public static final class AnonymousClass1 extends Lambda implements Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI> {
                                    final /* synthetic */ ProgressMarkers $item;
                                    final /* synthetic */ CourseActionFragment this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(CourseActionFragment courseActionFragment, ProgressMarkers progressMarkers) {
                                        super(4);
                                        this.this$0 = courseActionFragment;
                                        this.$item = progressMarkers;
                                    }

                                    /* JADX INFO: Access modifiers changed from: private */
                                    public static final void invoke$lambda$0(CourseActionFragment this$0, int i, View view) {
                                        CourseDetails courseDetails;
                                        IIX0o.x0xO0oo(this$0, "this$0");
                                        Intent intent = new Intent(this$0.requireActivity(), (Class<?>) CourseIntroduceActivity.class);
                                        intent.putExtra("mArg1", i);
                                        courseDetails = this$0.mCourseDetails;
                                        if (courseDetails == null) {
                                            IIX0o.XOxIOxOx("mCourseDetails");
                                            courseDetails = null;
                                        }
                                        intent.putExtra("mArg3", courseDetails);
                                        this$0.requireActivity().startActivity(intent);
                                    }

                                    @Override // Oox.Oxx0xo
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list) {
                                        invoke(dslViewHolder, num.intValue(), dslAdapterItem, list);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    public final void invoke(@OXOo.OOXIXo DslViewHolder viewHolder, final int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list) {
                                        View view;
                                        IIX0o.x0xO0oo(viewHolder, "viewHolder");
                                        IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                        IIX0o.x0xO0oo(list, "<anonymous parameter 3>");
                                        if (i == 0 && (view = viewHolder.view(R.id.item_special_course_view)) != null) {
                                            view.setVisibility(8);
                                        }
                                        RequestBuilder<Drawable> load = Glide.with(this.this$0.requireActivity()).load(this.$item.getCoverUrl());
                                        ImageView img = viewHolder.img(R.id.item_special_course_pic);
                                        IIX0o.ooOOo0oXI(img);
                                        load.into(img);
                                        TextView textView = (TextView) viewHolder.v(R.id.item_special_course_name);
                                        if (textView != null) {
                                            textView.setText(this.$item.getTitle());
                                        }
                                        TextView textView2 = (TextView) viewHolder.v(R.id.item_special_course_intro);
                                        if (textView2 != null) {
                                            textView2.setText(com.sma.smartv3.util.xoIox.IoOoo(this.$item.getTime()));
                                        }
                                        View v = viewHolder.v(R.id.item_special_course_layout);
                                        if (v != null) {
                                            final CourseActionFragment courseActionFragment = this.this$0;
                                            v.setOnClickListener(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0080: INVOKE 
                                                  (r2v1 'v' android.view.View)
                                                  (wrap:android.view.View$OnClickListener:0x007d: CONSTRUCTOR 
                                                  (r4v13 'courseActionFragment' com.sma.smartv3.ui.sport.course.CourseActionFragment A[DONT_INLINE])
                                                  (r3v0 'i' int A[DONT_INLINE])
                                                 A[MD:(com.sma.smartv3.ui.sport.course.CourseActionFragment, int):void (m), WRAPPED] call: com.sma.smartv3.ui.sport.course.Oxx0xo.<init>(com.sma.smartv3.ui.sport.course.CourseActionFragment, int):void type: CONSTRUCTOR)
                                                 VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] in method: com.sma.smartv3.ui.sport.course.CourseActionFragment$showData$1$1$1$1.1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List<? extends java.lang.Object>):void, file: classes12.dex
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
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.sma.smartv3.ui.sport.course.Oxx0xo, state: NOT_LOADED
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
                                                	... 23 more
                                                */
                                            /*
                                                this = this;
                                                java.lang.String r0 = "viewHolder"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
                                                java.lang.String r0 = "<anonymous parameter 2>"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                                                java.lang.String r4 = "<anonymous parameter 3>"
                                                kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r4)
                                                if (r3 != 0) goto L21
                                                r4 = 2131364920(0x7f0a0c38, float:1.834969E38)
                                                android.view.View r4 = r2.view(r4)
                                                if (r4 != 0) goto L1c
                                                goto L21
                                            L1c:
                                                r5 = 8
                                                r4.setVisibility(r5)
                                            L21:
                                                com.sma.smartv3.ui.sport.course.CourseActionFragment r4 = r1.this$0
                                                androidx.fragment.app.FragmentActivity r4 = r4.requireActivity()
                                                com.bumptech.glide.RequestManager r4 = com.bumptech.glide.Glide.with(r4)
                                                com.sma.smartv3.model.ProgressMarkers r5 = r1.$item
                                                java.lang.String r5 = r5.getCoverUrl()
                                                com.bumptech.glide.RequestBuilder r4 = r4.load(r5)
                                                r5 = 2131364918(0x7f0a0c36, float:1.8349687E38)
                                                android.widget.ImageView r5 = r2.img(r5)
                                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r5)
                                                r4.into(r5)
                                                r4 = 2131364917(0x7f0a0c35, float:1.8349685E38)
                                                android.view.View r4 = r2.v(r4)
                                                android.widget.TextView r4 = (android.widget.TextView) r4
                                                if (r4 != 0) goto L4e
                                                goto L57
                                            L4e:
                                                com.sma.smartv3.model.ProgressMarkers r5 = r1.$item
                                                java.lang.String r5 = r5.getTitle()
                                                r4.setText(r5)
                                            L57:
                                                r4 = 2131364914(0x7f0a0c32, float:1.8349679E38)
                                                android.view.View r4 = r2.v(r4)
                                                android.widget.TextView r4 = (android.widget.TextView) r4
                                                if (r4 != 0) goto L63
                                                goto L70
                                            L63:
                                                com.sma.smartv3.model.ProgressMarkers r5 = r1.$item
                                                int r5 = r5.getTime()
                                                java.lang.String r5 = com.sma.smartv3.util.xoIox.IoOoo(r5)
                                                r4.setText(r5)
                                            L70:
                                                r4 = 2131364916(0x7f0a0c34, float:1.8349683E38)
                                                android.view.View r2 = r2.v(r4)
                                                if (r2 == 0) goto L83
                                                com.sma.smartv3.ui.sport.course.CourseActionFragment r4 = r1.this$0
                                                com.sma.smartv3.ui.sport.course.Oxx0xo r5 = new com.sma.smartv3.ui.sport.course.Oxx0xo
                                                r5.<init>(r4, r3)
                                                r2.setOnClickListener(r5)
                                            L83:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.sport.course.CourseActionFragment$showData$1$1$1$1.AnonymousClass1.invoke(com.angcyo.dsladapter.DslViewHolder, int, com.angcyo.dsladapter.DslAdapterItem, java.util.List):void");
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // Oox.oOoXoXO
                                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                        invoke2(dslAdapterItem);
                                        return oXIO0o0XI.f29392oIX0oI;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                        IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                        dslItem.setItemBindOverride(new AnonymousClass1(CourseActionFragment.this, progressMarkers));
                                    }
                                });
                            }
                            DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.CourseActionFragment.showData.1.1.2
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                                    invoke2(dslAdapter2);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                                    IIX0o.x0xO0oo(render, "$this$render");
                                    DslAdapter.setAdapterStatus$default(render, 0, null, 2, null);
                                }
                            }, 3, null);
                        }
                    });
                }
            });
        }
    }
