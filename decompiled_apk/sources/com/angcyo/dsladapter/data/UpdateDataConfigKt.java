package com.angcyo.dsladapter.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.IXxxXO;
import Oox.x0xO0oo;
import XO0OX.II0xO0;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.LibExKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.reflect.oxoX;

/* loaded from: classes7.dex */
public final class UpdateDataConfigKt {
    public static final <Item extends DslAdapterItem, Bean> void I0Io(@OOXIXo DslAdapter dslAdapter, @OOXIXo final Class<Item> itemClass, @oOoXoXO final List<? extends Bean> list, @oOoXoXO Throwable th, @OOXIXo final Page page, @OOXIXo final IXxxXO<? super Item, ? super Bean, ? super Integer, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(itemClass, "itemClass");
        IIX0o.x0xO0oo(page, "page");
        IIX0o.x0xO0oo(initItem, "initItem");
        xxIXOIIO(dslAdapter, th);
        if (th != null) {
            return;
        }
        page.pageLoadEnd();
        ooOOo0oXI(dslAdapter, new Oox.oOoXoXO<UpdateDataConfig, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$loadDataEndIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(UpdateDataConfig updateDataConfig) {
                invoke2(updateDataConfig);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo UpdateDataConfig updateData) {
                IIX0o.x0xO0oo(updateData, "$this$updateData");
                updateData.x0xO0oo(Page.this.getFirstPageIndex());
                updateData.Oxx0xo(Page.this.getRequestPageIndex());
                updateData.oO(Page.this.getRequestPageSize());
                updateData.Oo(list);
                final Class<Item> cls = itemClass;
                final IXxxXO<Item, Bean, Integer, oXIO0o0XI> iXxxXO = initItem;
                updateData.IXxxXO(new IXxxXO<DslAdapterItem, Object, Integer, DslAdapterItem>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$loadDataEndIndex$3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // Oox.IXxxXO
                    public /* bridge */ /* synthetic */ DslAdapterItem invoke(DslAdapterItem dslAdapterItem, Object obj, Integer num) {
                        return invoke(dslAdapterItem, obj, num.intValue());
                    }

                    @oOoXoXO
                    public final DslAdapterItem invoke(@oOoXoXO DslAdapterItem dslAdapterItem, @oOoXoXO final Object obj, final int i) {
                        Class<Item> cls2 = cls;
                        final IXxxXO<Item, Bean, Integer, oXIO0o0XI> iXxxXO2 = iXxxXO;
                        return UpdateDataConfigKt.x0xO0oo(cls2, dslAdapterItem, new Oox.oOoXoXO<Item, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt.loadDataEndIndex.3.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                                invoke((DslAdapterItem) obj2);
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            /* JADX WARN: Incorrect types in method signature: (TItem;)V */
                            public final void invoke(@OOXIXo DslAdapterItem updateOrCreateItemByClass) {
                                IIX0o.x0xO0oo(updateOrCreateItemByClass, "$this$updateOrCreateItemByClass");
                                iXxxXO2.invoke(updateOrCreateItemByClass, obj, Integer.valueOf(i));
                            }
                        });
                    }
                });
            }
        });
    }

    public static final void II0XooXoX(@OOXIXo DslAdapter dslAdapter, @oOoXoXO Throwable th) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        xxIXOIIO(dslAdapter, th);
    }

    public static /* synthetic */ void II0xO0(DslAdapter dslAdapter, Class cls, List list, Throwable th, Page page, x0xO0oo x0xo0oo, int i, Object obj) {
        if ((i & 16) != 0) {
            x0xo0oo = new x0xO0oo<Object, Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$loadDataEnd$1
                public final void invoke(@OOXIXo Object obj2, Object obj3) {
                    IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2, Object obj3) {
                    invoke(obj2, obj3);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        oIX0oI(dslAdapter, cls, list, th, page, x0xo0oo);
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> void IXxxXO(DslAdapter dslAdapter, List<? extends Object> list, int i, int i2, Oox.oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> action, x0xO0oo<? super Item, Object, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        IIX0o.x0xO0oo(initItem, "initItem");
        IIX0o.xoXoI();
        ooOOo0oXI(dslAdapter, new UpdateDataConfigKt$updateSingleData$3(i, i2, list, action, initItem));
    }

    public static /* synthetic */ void OOXIXo(DslAdapter dslAdapter, List list, Throwable th, Page page, int i, Object obj) {
        if ((i & 4) != 0) {
            page = oIX0oI.oIX0oI();
        }
        xoIox(dslAdapter, list, th, page);
    }

    public static /* synthetic */ DslAdapterItem Oo(Class cls, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateOrCreateItemByClass$1
                public final void invoke(@OOXIXo Object obj2) {
                    IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        return x0xO0oo(cls, dslAdapterItem, oooxoxo);
    }

    public static final <T> void Oxx0IOOO(@OOXIXo final DslAdapter dslAdapter, @oOoXoXO final T t, @oOoXoXO final Throwable th, @OOXIXo Page page, @OOXIXo final x0xO0oo<? super DslAdapter, ? super T, oXIO0o0XI> render) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(page, "page");
        IIX0o.x0xO0oo(render, "render");
        if (th != null) {
            DslAdapter.render$default(dslAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$resetRender$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                    invoke2(dslAdapter2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo DslAdapter render2) {
                    IIX0o.x0xO0oo(render2, "$this$render");
                    UpdateDataConfigKt.xxIXOIIO(render2, th);
                }
            }, 3, null);
        } else if (t == null) {
            DslAdapter.render$default(dslAdapter, false, null, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$resetRender$2
                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(DslAdapter dslAdapter2) {
                    invoke2(dslAdapter2);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo DslAdapter render2) {
                    IIX0o.x0xO0oo(render2, "$this$render");
                    DslAdapter.setAdapterStatus$default(render2, 1, null, 2, null);
                }
            }, 3, null);
        } else {
            page.pageLoadEnd();
            DslAdapter.changeDataItems$default(dslAdapter, false, null, new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$resetRender$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                    invoke2(list);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo List<DslAdapterItem> it) {
                    IIX0o.x0xO0oo(it, "it");
                    it.clear();
                    render.invoke(dslAdapter, t);
                    if (it.isEmpty() && dslAdapter.getHeaderItems().isEmpty() && dslAdapter.getFooterItems().isEmpty()) {
                        DslAdapter.setAdapterStatus$default(dslAdapter, 1, null, 2, null);
                    } else {
                        DslAdapter.setAdapterStatus$default(dslAdapter, 0, null, 2, null);
                    }
                }
            }, 3, null);
        }
    }

    public static /* synthetic */ void Oxx0xo(DslAdapter dslAdapter, List list, int i, int i2, Oox.oOoXoXO oooxoxo, x0xO0oo x0xo0oo, int i3, Object obj) {
        int i4;
        if ((i3 & 2) != 0) {
            i = Page.Companion.oIX0oI();
        }
        int i5 = i;
        if ((i3 & 4) != 0) {
            i4 = Integer.MAX_VALUE;
        } else {
            i4 = i2;
        }
        if ((i3 & 8) != 0) {
            oooxoxo = new Oox.oOoXoXO<UpdateDataConfig, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateSingleData$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo UpdateDataConfig updateDataConfig) {
                    IIX0o.x0xO0oo(updateDataConfig, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(UpdateDataConfig updateDataConfig) {
                    invoke2(updateDataConfig);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        Oox.oOoXoXO action = oooxoxo;
        if ((i3 & 16) != 0) {
            IIX0o.xoXoI();
            x0xo0oo = UpdateDataConfigKt$updateSingleData$2.INSTANCE;
        }
        x0xO0oo initItem = x0xo0oo;
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        IIX0o.x0xO0oo(initItem, "initItem");
        IIX0o.xoXoI();
        ooOOo0oXI(dslAdapter, new UpdateDataConfigKt$updateSingleData$3(i5, i4, list, action, initItem));
    }

    public static /* synthetic */ void OxxIIOOXO(DslAdapter dslAdapter, List list, int i, int i2, Oox.oOoXoXO oooxoxo, IXxxXO iXxxXO, int i3, Object obj) {
        int i4;
        if ((i3 & 2) != 0) {
            i = Page.Companion.oIX0oI();
        }
        int i5 = i;
        if ((i3 & 4) != 0) {
            i4 = Integer.MAX_VALUE;
        } else {
            i4 = i2;
        }
        if ((i3 & 8) != 0) {
            oooxoxo = new Oox.oOoXoXO<UpdateDataConfig, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateSingleDataIndex$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OOXIXo UpdateDataConfig updateDataConfig) {
                    IIX0o.x0xO0oo(updateDataConfig, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(UpdateDataConfig updateDataConfig) {
                    invoke2(updateDataConfig);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        Oox.oOoXoXO action = oooxoxo;
        if ((i3 & 16) != 0) {
            IIX0o.xoXoI();
            iXxxXO = UpdateDataConfigKt$updateSingleDataIndex$2.INSTANCE;
        }
        IXxxXO initItem = iXxxXO;
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        IIX0o.x0xO0oo(initItem, "initItem");
        IIX0o.xoXoI();
        ooOOo0oXI(dslAdapter, new UpdateDataConfigKt$updateSingleDataIndex$3(i5, i4, list, action, initItem));
    }

    public static /* synthetic */ void X0o0xo(DslAdapter dslAdapter, Class cls, List list, Throwable th, Page page, IXxxXO iXxxXO, int i, Object obj) {
        if ((i & 16) != 0) {
            iXxxXO = new IXxxXO<Object, Object, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$loadDataEndIndex$2
                public final void invoke(@OOXIXo Object obj2, Object obj3, int i2) {
                    IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2, Object obj3, Integer num) {
                    invoke((DslAdapterItem) obj2, obj3, num.intValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        I0Io(dslAdapter, cls, list, th, page, iXxxXO);
    }

    public static /* synthetic */ void XO(DslAdapter dslAdapter, oxoX oxox, List list, Throwable th, Page page, IXxxXO iXxxXO, int i, Object obj) {
        if ((i & 16) != 0) {
            iXxxXO = new IXxxXO<Object, Object, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$loadDataEndIndex$1
                public final void invoke(@OOXIXo Object obj2, Object obj3, int i2) {
                    IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.IXxxXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2, Object obj3, Integer num) {
                    invoke((DslAdapterItem) obj2, obj3, num.intValue());
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        oxoX(dslAdapter, oxox, list, th, page, iXxxXO);
    }

    public static final /* synthetic */ <Item extends DslAdapterItem> void oI0IIXIo(DslAdapter dslAdapter, List<? extends Object> list, int i, int i2, Oox.oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> action, IXxxXO<? super Item, Object, ? super Integer, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        IIX0o.x0xO0oo(initItem, "initItem");
        IIX0o.xoXoI();
        ooOOo0oXI(dslAdapter, new UpdateDataConfigKt$updateSingleDataIndex$3(i, i2, list, action, initItem));
    }

    public static final <Item extends DslAdapterItem, Bean> void oIX0oI(@OOXIXo DslAdapter dslAdapter, @OOXIXo Class<Item> itemClass, @oOoXoXO List<? extends Bean> list, @oOoXoXO Throwable th, @OOXIXo Page page, @OOXIXo final x0xO0oo<? super Item, ? super Bean, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(itemClass, "itemClass");
        IIX0o.x0xO0oo(page, "page");
        IIX0o.x0xO0oo(initItem, "initItem");
        I0Io(dslAdapter, itemClass, list, th, page, new IXxxXO<Item, Bean, Integer, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$loadDataEnd$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // Oox.IXxxXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj, Object obj2, Integer num) {
                invoke((DslAdapterItem) obj, obj2, num.intValue());
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* JADX WARN: Incorrect types in method signature: (TItem;TBean;I)V */
            public final void invoke(@OOXIXo DslAdapterItem loadDataEndIndex, Object obj, int i) {
                IIX0o.x0xO0oo(loadDataEndIndex, "$this$loadDataEndIndex");
                initItem.invoke(loadDataEndIndex, obj);
            }
        });
    }

    public static final void oO(@OOXIXo DslAdapter dslAdapter, @OOXIXo Oox.oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        final UpdateDataConfig updateDataConfig = new UpdateDataConfig();
        updateDataConfig.Oxx0xo(Page.Companion.oIX0oI());
        updateDataConfig.oO(Integer.MAX_VALUE);
        action.invoke(updateDataConfig);
        dslAdapter.changeHeaderItems(true, updateDataConfig.oxoX(), new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateHeaderData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                invoke2(list);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo List<DslAdapterItem> it) {
                IIX0o.x0xO0oo(it, "it");
                List<DslAdapterItem> oOoXoXO2 = UpdateDataConfigKt.oOoXoXO(UpdateDataConfig.this, it);
                it.clear();
                it.addAll(oOoXoXO2);
            }
        });
    }

    @OOXIXo
    public static final List<DslAdapterItem> oOoXoXO(@OOXIXo UpdateDataConfig updateDataConfig, @OOXIXo List<? extends DslAdapterItem> originList) {
        IIX0o.x0xO0oo(updateDataConfig, "<this>");
        IIX0o.x0xO0oo(originList, "originList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(originList);
        List<Object> Oxx0IOOO2 = updateDataConfig.Oxx0IOOO();
        if (Oxx0IOOO2 == null) {
            Oxx0IOOO2 = CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int max = Math.max(0, updateDataConfig.xxIXOIIO() - updateDataConfig.XO()) * updateDataConfig.X0o0xo();
        int intValue = updateDataConfig.xoIox().invoke().intValue() + max;
        for (int i = max; i < intValue; i++) {
            int i2 = i - max;
            Object OIoxIx2 = CollectionsKt___CollectionsKt.OIoxIx(Oxx0IOOO2, i2);
            DslAdapterItem dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(arrayList2, i);
            DslAdapterItem invoke = updateDataConfig.II0XooXoX().invoke(dslAdapterItem, OIoxIx2, Integer.valueOf(i2));
            if (invoke != null) {
                invoke.setItemUpdateFlag(true);
                invoke.setItemData(OIoxIx2);
            }
            if (invoke == null) {
                if (dslAdapterItem != null) {
                    arrayList3.add(dslAdapterItem);
                }
            } else if (dslAdapterItem != null && !IIX0o.Oxx0IOOO(dslAdapterItem, invoke)) {
                arrayList2.set(i, invoke);
            } else if (dslAdapterItem == null) {
                arrayList4.add(invoke);
            }
        }
        int size = arrayList2.size();
        while (intValue < size) {
            Object obj = arrayList2.get(intValue);
            IIX0o.oO(obj, "oldList[i]");
            arrayList3.add(obj);
            intValue++;
        }
        arrayList2.removeAll(arrayList3);
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList4);
        return arrayList;
    }

    public static final void ooOOo0oXI(@OOXIXo final DslAdapter dslAdapter, @OOXIXo Oox.oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        final UpdateDataConfig updateDataConfig = new UpdateDataConfig();
        action.invoke(updateDataConfig);
        dslAdapter.changeDataItems(false, updateDataConfig.oxoX(), new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                invoke2(list);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo List<DslAdapterItem> it) {
                IIX0o.x0xO0oo(it, "it");
                List<DslAdapterItem> oOoXoXO2 = UpdateDataConfigKt.oOoXoXO(UpdateDataConfig.this, it);
                it.clear();
                it.addAll(oOoXoXO2);
                UpdateDataConfig.this.II0xO0().invoke(dslAdapter);
            }
        });
    }

    public static final <Item extends DslAdapterItem, Bean> void oxoX(@OOXIXo DslAdapter dslAdapter, @OOXIXo oxoX<Item> itemClass, @oOoXoXO List<? extends Bean> list, @oOoXoXO Throwable th, @OOXIXo Page page, @OOXIXo IXxxXO<? super Item, ? super Bean, ? super Integer, oXIO0o0XI> initItem) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(itemClass, "itemClass");
        IIX0o.x0xO0oo(page, "page");
        IIX0o.x0xO0oo(initItem, "initItem");
        I0Io(dslAdapter, II0xO0.X0o0xo(itemClass), list, th, page, initItem);
    }

    public static final void x0XOIxOo(@OOXIXo DslAdapter dslAdapter, @OOXIXo Oox.oOoXoXO<? super UpdateDataConfig, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(action, "action");
        final UpdateDataConfig updateDataConfig = new UpdateDataConfig();
        updateDataConfig.Oxx0xo(Page.Companion.oIX0oI());
        updateDataConfig.oO(Integer.MAX_VALUE);
        action.invoke(updateDataConfig);
        dslAdapter.changeFooterItems(true, updateDataConfig.oxoX(), new Oox.oOoXoXO<List<DslAdapterItem>, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.data.UpdateDataConfigKt$updateFooterData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(List<DslAdapterItem> list) {
                invoke2(list);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OOXIXo List<DslAdapterItem> it) {
                IIX0o.x0xO0oo(it, "it");
                List<DslAdapterItem> oOoXoXO2 = UpdateDataConfigKt.oOoXoXO(UpdateDataConfig.this, it);
                it.clear();
                it.addAll(oOoXoXO2);
            }
        });
    }

    @oOoXoXO
    public static final <Item extends DslAdapterItem> DslAdapterItem x0xO0oo(@OOXIXo Class<Item> itemClass, @oOoXoXO DslAdapterItem dslAdapterItem, @OOXIXo Oox.oOoXoXO<? super Item, oXIO0o0XI> initItem) {
        DslAdapterItem dslAdapterItem2;
        IIX0o.x0xO0oo(itemClass, "itemClass");
        IIX0o.x0xO0oo(initItem, "initItem");
        if (dslAdapterItem == null || !IIX0o.Oxx0IOOO(LibExKt.x0xO0oo(dslAdapterItem), LibExKt.x0xO0oo(itemClass))) {
            dslAdapterItem = itemClass.newInstance();
        }
        if (dslAdapterItem instanceof DslAdapterItem) {
            dslAdapterItem2 = dslAdapterItem;
        } else {
            dslAdapterItem2 = null;
        }
        if (dslAdapterItem2 != null) {
            initItem.invoke(dslAdapterItem2);
        }
        return dslAdapterItem;
    }

    public static final void xoIox(@OOXIXo DslAdapter dslAdapter, @oOoXoXO List<?> list, @oOoXoXO Throwable th, @OOXIXo Page page) {
        boolean isEmpty;
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        IIX0o.x0xO0oo(page, "page");
        xxIXOIIO(dslAdapter, th);
        if (th == null) {
            if (page.isFirstPage()) {
                List<?> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    isEmpty = false;
                } else {
                    isEmpty = true;
                }
            } else {
                isEmpty = dslAdapter.getDataItems().isEmpty();
            }
            if (isEmpty && dslAdapter.getHeaderItems().isEmpty() && dslAdapter.getFooterItems().isEmpty()) {
                dslAdapter.updateAdapterStatus(1);
            } else {
                dslAdapter.updateAdapterStatus(0);
            }
            LoadDataExKt.X0o0xo(dslAdapter, page.getRequestPageIndex(), LibExKt.Ox0O(list), page.getRequestPageSize(), false);
        }
    }

    public static final void xxIXOIIO(@OOXIXo DslAdapter dslAdapter, @oOoXoXO Throwable th) {
        IIX0o.x0xO0oo(dslAdapter, "<this>");
        if (th != null) {
            if (dslAdapter.getAdapterItems().isEmpty()) {
                dslAdapter.getDslAdapterStatusItem().setItemErrorThrowable(th);
                DslAdapterExKt.IoIOOxIIo(dslAdapter, null, 1, null);
            } else if (DslAdapterExKt.IoOoo(dslAdapter)) {
                DslAdapterExKt.IxIX0I(dslAdapter);
            } else {
                DslAdapterExKt.OoO(dslAdapter, null, null, false, 7, null);
            }
        }
    }
}
