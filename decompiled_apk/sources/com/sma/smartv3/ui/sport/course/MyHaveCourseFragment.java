package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.recycler.BaseDSLRecyclerFragment;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public class MyHaveCourseFragment extends BaseDSLRecyclerFragment {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
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

    public void showData(@OXOo.OOXIXo final List<String> list) {
        IIX0o.x0xO0oo(list, "list");
        renderAdapter(new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.MyHaveCourseFragment$showData$1
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
                DslViewHolder dslViewHolder = MyHaveCourseFragment.this.getDslViewHolder();
                final List<String> list2 = list;
                dslViewHolder.postDelay(100L, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.MyHaveCourseFragment$showData$1.1
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
                        List<String> list3 = list2;
                        DslAdapter dslAdapter = renderAdapter;
                        for (String str : list3) {
                            DslAdapterExKt.oO(dslAdapter, R.layout.item_special_course, new Oox.oOoXoXO<DslAdapterItem, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.MyHaveCourseFragment$showData$1$1$1$1
                                @Override // Oox.oOoXoXO
                                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapterItem dslAdapterItem) {
                                    invoke2(dslAdapterItem);
                                    return oXIO0o0XI.f29392oIX0oI;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@OXOo.OOXIXo DslAdapterItem dslItem) {
                                    IIX0o.x0xO0oo(dslItem, "$this$dslItem");
                                    dslItem.setItemBindOverride(new Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.MyHaveCourseFragment$showData$1$1$1$1.1
                                        public final void invoke(@OXOo.OOXIXo DslViewHolder viewHolder, int i, @OXOo.OOXIXo DslAdapterItem dslAdapterItem, @OXOo.OOXIXo List<? extends Object> list4) {
                                            IIX0o.x0xO0oo(viewHolder, "viewHolder");
                                            IIX0o.x0xO0oo(dslAdapterItem, "<anonymous parameter 2>");
                                            IIX0o.x0xO0oo(list4, "<anonymous parameter 3>");
                                        }

                                        @Override // Oox.Oxx0xo
                                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslViewHolder dslViewHolder2, Integer num, DslAdapterItem dslAdapterItem, List<? extends Object> list4) {
                                            invoke(dslViewHolder2, num.intValue(), dslAdapterItem, list4);
                                            return oXIO0o0XI.f29392oIX0oI;
                                        }
                                    });
                                }
                            });
                        }
                        DslAdapter.render$default(renderAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.course.MyHaveCourseFragment.showData.1.1.2
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
