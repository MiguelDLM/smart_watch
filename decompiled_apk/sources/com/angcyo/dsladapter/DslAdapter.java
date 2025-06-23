package com.angcyo.dsladapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nDslAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DslAdapter.kt\ncom/angcyo/dsladapter/DslAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1209:1\n1855#2,2:1210\n1855#2,2:1212\n1855#2,2:1214\n1855#2,2:1216\n1855#2,2:1218\n1855#2,2:1220\n857#2,2:1222\n1855#2,2:1224\n857#2,2:1226\n1855#2,2:1228\n857#2,2:1230\n1855#2,2:1232\n766#2:1234\n857#2,2:1235\n766#2:1237\n857#2,2:1238\n766#2:1240\n857#2,2:1241\n1747#2,3:1243\n1864#2,3:1246\n1855#2,2:1249\n1855#2,2:1251\n1855#2,2:1253\n1855#2,2:1255\n1855#2,2:1257\n1855#2,2:1259\n1855#2,2:1261\n766#2:1264\n857#2,2:1265\n766#2:1267\n857#2,2:1268\n766#2:1270\n857#2,2:1271\n800#2,11:1273\n1855#2,2:1284\n1#3:1263\n*S KotlinDebug\n*F\n+ 1 DslAdapter.kt\ncom/angcyo/dsladapter/DslAdapter\n*L\n154#1:1210,2\n221#1:1212,2\n234#1:1214,2\n240#1:1216,2\n311#1:1218,2\n321#1:1220,2\n539#1:1222,2\n544#1:1224,2\n553#1:1226,2\n558#1:1228,2\n567#1:1230,2\n572#1:1232,2\n594#1:1234\n594#1:1235,2\n595#1:1237\n595#1:1238,2\n596#1:1240\n596#1:1241,2\n601#1:1243,3\n857#1:1246,3\n894#1:1249,2\n937#1:1251,2\n976#1:1253,2\n985#1:1255,2\n994#1:1257,2\n1004#1:1259,2\n1013#1:1261,2\n1168#1:1264\n1168#1:1265,2\n1180#1:1267\n1180#1:1268,2\n1194#1:1270\n1194#1:1271,2\n1205#1:1273,11\n890#1:1284,2\n*E\n"})
/* loaded from: classes7.dex */
public class DslAdapter extends RecyclerView.Adapter<DslViewHolder> implements oOXoIIIo {

    @OXOo.OOXIXo
    private final HashMap<Integer, Integer> _itemLayoutHold;

    @OXOo.oOoXoXO
    private RecyclerView _recyclerView;

    @OXOo.OOXIXo
    private com.angcyo.dsladapter.internal.II0xO0 adapterItemAnimateDelayHandler;

    @OXOo.OOXIXo
    private final List<DslAdapterItem> adapterItems;

    @OXOo.OOXIXo
    private com.angcyo.dsladapter.filter.xxIXOIIO adapterStatusIFilterInterceptor;

    @OXOo.OOXIXo
    private final List<DslAdapterItem> dataItems;

    @NonNull
    @OXOo.oOoXoXO
    @SuppressLint({"KotlinNullnessAnnotation"})
    private XxX0x0xxx defaultFilterParams;

    @OXOo.OOXIXo
    private final List<Oox.oOoXoXO<DslAdapter, oXIO0o0XI>> dispatchUpdatesAfterList;

    @OXOo.OOXIXo
    private final List<Oox.oOoXoXO<DslAdapter, oXIO0o0XI>> dispatchUpdatesAfterOnceList;

    @OXOo.OOXIXo
    private final List<Oox.oOoXoXO<DslAdapter, oXIO0o0XI>> dispatchUpdatesBeforeList;

    @OXOo.OOXIXo
    private DslAdapterStatusItem dslAdapterStatusItem;

    @OXOo.oOoXoXO
    private DslDataFilter dslDataFilter;

    @OXOo.OOXIXo
    private DslLoadMoreItem dslLoadMoreItem;

    @OXOo.OOXIXo
    private final List<DslAdapterItem> footerItems;

    @OXOo.OOXIXo
    private final List<DslAdapterItem> headerItems;

    @OXOo.OOXIXo
    private final Set<Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>> itemBindObserver;

    @OXOo.OOXIXo
    private final ItemSelectorHelper itemSelectorHelper;

    @OXOo.OOXIXo
    private final Set<Oox.oOoXoXO<XxX0x0xxx, oXIO0o0XI>> itemUpdateDependObserver;

    @OXOo.OOXIXo
    private com.angcyo.dsladapter.filter.xxIXOIIO loadMoreIFilterInterceptor;

    @OXOo.oOoXoXO
    private Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> onDispatchUpdatesAfterOnce;

    @OXOo.oOoXoXO
    private XxX0x0xxx onceFilterParams;

    public DslAdapter() {
        this(null, 1, null);
    }

    public static /* synthetic */ void addLastItem$default(DslAdapter dslAdapter, List list, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$addLastItem$1
                    public final void invoke(@OXOo.OOXIXo Object obj2) {
                        kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                        invoke(obj2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }
                };
            }
            dslAdapter.addLastItem(list, dslAdapterItem, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLastItem");
    }

    public static /* synthetic */ void autoAdapterStatus$default(DslAdapter dslAdapter, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                th = null;
            }
            dslAdapter.autoAdapterStatus(th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoAdapterStatus");
    }

    public static /* synthetic */ void changeDataItems$default(DslAdapter dslAdapter, boolean z, XxX0x0xxx xxX0x0xxx, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.changeDataItems(z, xxX0x0xxx, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeDataItems");
    }

    public static /* synthetic */ void changeFooterItems$default(DslAdapter dslAdapter, boolean z, XxX0x0xxx xxX0x0xxx, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.changeFooterItems(z, xxX0x0xxx, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeFooterItems");
    }

    public static /* synthetic */ void changeHeaderItems$default(DslAdapter dslAdapter, boolean z, XxX0x0xxx xxX0x0xxx, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.changeHeaderItems(z, xxX0x0xxx, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeHeaderItems");
    }

    public static /* synthetic */ void changeItems$default(DslAdapter dslAdapter, boolean z, XxX0x0xxx xxX0x0xxx, Oox.oIX0oI oix0oi, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.changeItems(z, xxX0x0xxx, oix0oi);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeItems");
    }

    public static /* synthetic */ DslAdapterItem get$default(DslAdapter dslAdapter, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        return dslAdapter.get(i, z, z2);
    }

    private static final void getDataAndSubList$addSubList(List<DslAdapterItem> list, DslAdapterItem dslAdapterItem) {
        list.add(dslAdapterItem);
        Iterator<T> it = dslAdapterItem.getItemSubList().iterator();
        while (it.hasNext()) {
            getDataAndSubList$addSubList(list, (DslAdapterItem) it.next());
        }
    }

    public static /* synthetic */ List getDataAndSubList$default(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            return dslAdapter.getDataAndSubList(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDataAndSubList");
    }

    public static /* synthetic */ List getDataList$default(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return dslAdapter.getDataList(z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDataList");
    }

    public static /* synthetic */ DslAdapterItem getItemData$default(DslAdapter dslAdapter, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            return dslAdapter.getItemData(i, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItemData");
    }

    public static /* synthetic */ boolean haveItemBy$default(DslAdapter dslAdapter, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            return dslAdapter.haveItemBy(z, oooxoxo);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: haveItemBy");
    }

    public static /* synthetic */ void insertFooterItem$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            dslAdapter.insertFooterItem(dslAdapterItem, i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertFooterItem");
    }

    public static /* synthetic */ void insertHeaderItem$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            dslAdapter.insertHeaderItem(dslAdapterItem, i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertHeaderItem");
    }

    public static /* synthetic */ void insertItem$default(DslAdapter dslAdapter, int i, DslAdapterItem dslAdapterItem, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItem");
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        dslAdapter.insertItem(i, dslAdapterItem, z);
    }

    public static /* synthetic */ boolean insertItemAfter$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItemAfter");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return dslAdapter.insertItemAfter(dslAdapterItem, dslAdapterItem2, z);
    }

    public static /* synthetic */ boolean insertItemBefore$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItemBefore");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return dslAdapter.insertItemBefore(dslAdapterItem, dslAdapterItem2, z);
    }

    public static /* synthetic */ void invoke$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((i & 1) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$invoke$1
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        dslAdapter.invoke(dslAdapterItem, oooxoxo);
    }

    public static /* synthetic */ void notifyItemChanged$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, Object obj, boolean z, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            dslAdapter.notifyItemChanged(dslAdapterItem, obj, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyItemChanged");
    }

    public static /* synthetic */ void notifyItemChangedPayload$default(DslAdapter dslAdapter, int i, Object obj, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                obj = null;
            }
            dslAdapter.notifyItemChangedPayload(i, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyItemChangedPayload");
    }

    public static /* synthetic */ void removeFooterItem$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            dslAdapter.removeFooterItem(dslAdapterItem, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeFooterItem");
    }

    public static /* synthetic */ void removeHeaderItem$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            dslAdapter.removeHeaderItem(dslAdapterItem, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeHeaderItem");
    }

    public static /* synthetic */ void removeItem$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            dslAdapter.removeItem(dslAdapterItem, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeItem");
    }

    public static /* synthetic */ void removeItemFromAll$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = true;
            }
            dslAdapter.removeItemFromAll(dslAdapterItem, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeItemFromAll");
    }

    public static /* synthetic */ void render$default(DslAdapter dslAdapter, boolean z, XxX0x0xxx xxX0x0xxx, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            if ((i & 2) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.render(z, xxX0x0xxx, oooxoxo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: render");
    }

    public static /* synthetic */ void renderData$default(DslAdapter dslAdapter, boolean z, boolean z2, XxX0x0xxx xxX0x0xxx, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            if ((i & 4) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.renderData(z, z2, xxX0x0xxx, x0xo0oo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderData");
    }

    public static /* synthetic */ void renderFooter$default(DslAdapter dslAdapter, boolean z, boolean z2, XxX0x0xxx xxX0x0xxx, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            if ((i & 4) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.renderFooter(z, z2, xxX0x0xxx, x0xo0oo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderFooter");
    }

    public static /* synthetic */ void renderHeader$default(DslAdapter dslAdapter, boolean z, boolean z2, XxX0x0xxx xxX0x0xxx, Oox.x0xO0oo x0xo0oo, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            if ((i & 4) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.renderHeader(z, z2, xxX0x0xxx, x0xo0oo);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderHeader");
    }

    public static /* synthetic */ void setAdapterStatus$default(DslAdapter dslAdapter, int i, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                th = null;
            }
            dslAdapter.setAdapterStatus(i, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAdapterStatus");
    }

    public static /* synthetic */ void setAdapterStatusEnable$default(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            dslAdapter.setAdapterStatusEnable(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAdapterStatusEnable");
    }

    public static /* synthetic */ void setLoadMore$default(DslAdapter dslAdapter, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 2) != 0) {
                obj = null;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            dslAdapter.setLoadMore(i, obj, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadMore");
    }

    public static /* synthetic */ void setLoadMoreEnable$default(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            dslAdapter.setLoadMoreEnable(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoadMoreEnable");
    }

    public static /* synthetic */ void updateAllDataItem$default(DslAdapter dslAdapter, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = 1;
            }
            dslAdapter.updateAllDataItem(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAllDataItem");
    }

    public static /* synthetic */ void updateAllFooterItem$default(DslAdapter dslAdapter, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = 1;
            }
            dslAdapter.updateAllFooterItem(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAllFooterItem");
    }

    public static /* synthetic */ void updateAllHeaderItem$default(DslAdapter dslAdapter, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = 1;
            }
            dslAdapter.updateAllHeaderItem(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAllHeaderItem");
    }

    public static /* synthetic */ void updateAllItem$default(DslAdapter dslAdapter, Object obj, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 1) != 0) {
                obj = 1;
            }
            dslAdapter.updateAllItem(obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateAllItem");
    }

    public static /* synthetic */ void updateItemDepend$default(DslAdapter dslAdapter, XxX0x0xxx xxX0x0xxx, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                xxX0x0xxx = dslAdapter.getDefaultFilterParams();
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(xxX0x0xxx);
            }
            dslAdapter.updateItemDepend(xxX0x0xxx);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItemDepend");
    }

    public static /* synthetic */ void updateItems$default(DslAdapter dslAdapter, Iterable iterable, Object obj, boolean z, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                z = true;
            }
            dslAdapter.updateItems(iterable, obj, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateItems");
    }

    @OXOo.OOXIXo
    public final XxX0x0xxx _defaultFilterParams() {
        return new XxX0x0xxx(null, false, false, false, false, false, null, null, 0L, 0L, null, 2047, null);
    }

    public final void _updateAdapterItems() {
        this.adapterItems.clear();
        this.adapterItems.addAll(this.headerItems);
        this.adapterItems.addAll(this.dataItems);
        this.adapterItems.addAll(this.footerItems);
        for (DslAdapterItem dslAdapterItem : this.adapterItems) {
            dslAdapterItem.setItemDslAdapter(this);
            dslAdapterItem.clearItemGroupParamsCache();
        }
    }

    public final int _validIndex(@OXOo.OOXIXo List<?> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        if (i < 0) {
            return list.size();
        }
        return Math.min(i, list.size());
    }

    public final void addLastItem(@OXOo.OOXIXo DslAdapterItem item) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        insertItem$default(this, -1, item, false, 4, (Object) null);
    }

    public final void autoAdapterStatus(@OXOo.oOoXoXO Throwable th) {
        if (isAdapterStatus()) {
            if (th == null) {
                if (this.adapterItems.size() <= 0) {
                    setAdapterStatus$default(this, 1, null, 2, null);
                    return;
                } else {
                    setAdapterStatus$default(this, 0, null, 2, null);
                    return;
                }
            }
            this.dslAdapterStatusItem.setItemErrorThrowable(th);
            setAdapterStatus$default(this, 3, null, 2, null);
            return;
        }
        if (th != null) {
            this.dslAdapterStatusItem.setItemErrorThrowable(th);
            setAdapterStatus$default(this, 3, null, 2, null);
        }
    }

    public final void changeDataItems(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo final Oox.oOoXoXO<? super List<DslAdapterItem>, oXIO0o0XI> change) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(change, "change");
        changeItems(z, filterParams, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$changeDataItems$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                change.invoke(this.getDataItems());
            }
        });
    }

    public final void changeFooterItems(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo final Oox.oOoXoXO<? super List<DslAdapterItem>, oXIO0o0XI> change) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(change, "change");
        changeItems(z, filterParams, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$changeFooterItems$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                change.invoke(this.getFooterItems());
            }
        });
    }

    public final void changeHeaderItems(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo final Oox.oOoXoXO<? super List<DslAdapterItem>, oXIO0o0XI> change) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(change, "change");
        changeItems(z, filterParams, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$changeHeaderItems$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                change.invoke(this.getHeaderItems());
            }
        });
    }

    public final void changeItems(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo final Oox.oIX0oI<oXIO0o0XI> change) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(change, "change");
        render(z, filterParams, new Oox.oOoXoXO<DslAdapter, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$changeItems$1
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
            public final void invoke2(@OXOo.OOXIXo DslAdapter render) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(render, "$this$render");
                change.invoke();
                render._updateAdapterItems();
            }
        });
    }

    public final void changingAllItem() {
        Iterator<T> it = this.adapterItems.iterator();
        while (it.hasNext()) {
            ((DslAdapterItem) it.next()).setItemChanging(true);
        }
    }

    public final void clearAllItems() {
        this.headerItems.clear();
        this.dataItems.clear();
        this.footerItems.clear();
        _updateAdapterItems();
    }

    public final void clearFooterItems() {
        this.footerItems.clear();
        _updateAdapterItems();
    }

    public final void clearHeaderItems() {
        this.headerItems.clear();
        _updateAdapterItems();
    }

    public final void clearItems() {
        this.dataItems.clear();
        _updateAdapterItems();
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem get(int i, boolean z, boolean z2) {
        List<DslAdapterItem> dataList = getDataList(z);
        if (i < 0 && z2) {
            return (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(dataList, dataList.size() + i);
        }
        return (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(dataList, i);
    }

    @OXOo.OOXIXo
    public final com.angcyo.dsladapter.internal.II0xO0 getAdapterItemAnimateDelayHandler() {
        return this.adapterItemAnimateDelayHandler;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getAdapterItems() {
        return this.adapterItems;
    }

    @OXOo.OOXIXo
    public final com.angcyo.dsladapter.filter.xxIXOIIO getAdapterStatusIFilterInterceptor() {
        return this.adapterStatusIFilterInterceptor;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getDataAndSubList(boolean z) {
        List<DslAdapterItem> list;
        if (z) {
            list = getValidFilterDataList();
        } else {
            list = this.adapterItems;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            getDataAndSubList$addSubList(arrayList, (DslAdapterItem) it.next());
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getDataItems() {
        return this.dataItems;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getDataList(boolean z) {
        if (z) {
            return getValidFilterDataList();
        }
        return this.adapterItems;
    }

    @NonNull
    @OXOo.oOoXoXO
    @SuppressLint({"KotlinNullnessAnnotation"})
    public final XxX0x0xxx getDefaultFilterParams() {
        XxX0x0xxx xxX0x0xxx = this.onceFilterParams;
        if (xxX0x0xxx == null) {
            XxX0x0xxx xxX0x0xxx2 = this.defaultFilterParams;
            if (xxX0x0xxx2 == null) {
                return _defaultFilterParams();
            }
            return xxX0x0xxx2;
        }
        return xxX0x0xxx;
    }

    @OXOo.OOXIXo
    public final List<Oox.oOoXoXO<DslAdapter, oXIO0o0XI>> getDispatchUpdatesAfterList() {
        return this.dispatchUpdatesAfterList;
    }

    @OXOo.OOXIXo
    public final List<Oox.oOoXoXO<DslAdapter, oXIO0o0XI>> getDispatchUpdatesAfterOnceList() {
        return this.dispatchUpdatesAfterOnceList;
    }

    @OXOo.OOXIXo
    public final List<Oox.oOoXoXO<DslAdapter, oXIO0o0XI>> getDispatchUpdatesBeforeList() {
        return this.dispatchUpdatesBeforeList;
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem getDslAdapterItem(@OXOo.OOXIXo DslViewHolder dslViewHolder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslViewHolder, "<this>");
        int adapterPosition = dslViewHolder.getAdapterPosition();
        if (adapterPosition < 0 || adapterPosition >= getValidFilterDataList().size()) {
            return null;
        }
        return getItemData$default(this, dslViewHolder.getAdapterPosition(), false, 2, null);
    }

    @OXOo.OOXIXo
    public final DslAdapterStatusItem getDslAdapterStatusItem() {
        return this.dslAdapterStatusItem;
    }

    @OXOo.oOoXoXO
    public final DslDataFilter getDslDataFilter() {
        return this.dslDataFilter;
    }

    @OXOo.OOXIXo
    public final DslLoadMoreItem getDslLoadMoreItem() {
        return this.dslLoadMoreItem;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getFooterItems() {
        return this.footerItems;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getHeaderItems() {
        return this.headerItems;
    }

    @OXOo.OOXIXo
    public final Set<Oox.Oxx0xo<DslViewHolder, Integer, DslAdapterItem, List<? extends Object>, oXIO0o0XI>> getItemBindObserver() {
        return this.itemBindObserver;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getValidFilterDataList().size();
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem getItemData(int i, boolean z) {
        List<DslAdapterItem> dataList = getDataList(z);
        if (i >= 0 && i < dataList.size()) {
            return dataList.get(i);
        }
        return null;
    }

    @OXOo.OOXIXo
    public final ItemSelectorHelper getItemSelectorHelper() {
        return this.itemSelectorHelper;
    }

    @OXOo.OOXIXo
    public final Set<Oox.oOoXoXO<XxX0x0xxx, oXIO0o0XI>> getItemUpdateDependObserver() {
        return this.itemUpdateDependObserver;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int itemLayoutId;
        int i2 = 0;
        DslAdapterItem itemData$default = getItemData$default(this, i, false, 2, null);
        if (itemData$default != null) {
            Integer itemViewType = itemData$default.getItemViewType();
            if (itemViewType != null) {
                itemLayoutId = itemViewType.intValue();
            } else {
                itemLayoutId = itemData$default.getItemLayoutId();
            }
            i2 = itemLayoutId;
            this._itemLayoutHold.put(Integer.valueOf(i2), Integer.valueOf(itemData$default.getItemLayoutId()));
        }
        return i2;
    }

    @OXOo.OOXIXo
    public final com.angcyo.dsladapter.filter.xxIXOIIO getLoadMoreIFilterInterceptor() {
        return this.loadMoreIFilterInterceptor;
    }

    @OXOo.oOoXoXO
    public final Oox.oOoXoXO<DslAdapter, oXIO0o0XI> getOnDispatchUpdatesAfterOnce() {
        return this.onDispatchUpdatesAfterOnce;
    }

    @OXOo.oOoXoXO
    public final XxX0x0xxx getOnceFilterParams() {
        return this.onceFilterParams;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getUpdateDependItemListFrom(@OXOo.OOXIXo DslAdapterItem fromItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fromItem, "fromItem");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : getValidFilterDataList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            DslAdapterItem dslAdapterItem = (DslAdapterItem) obj;
            if (fromItem.isItemInUpdateList().invoke(dslAdapterItem, Integer.valueOf(i)).booleanValue()) {
                arrayList.add(dslAdapterItem);
            }
            i = i2;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public final List<DslAdapterItem> getValidFilterDataList() {
        List<DslAdapterItem> Oxx0xo2;
        DslDataFilter dslDataFilter = this.dslDataFilter;
        if (dslDataFilter == null || (Oxx0xo2 = dslDataFilter.Oxx0xo()) == null) {
            return this.adapterItems;
        }
        return Oxx0xo2;
    }

    @OXOo.OOXIXo
    public final HashMap<Integer, Integer> get_itemLayoutHold() {
        return this._itemLayoutHold;
    }

    @OXOo.oOoXoXO
    public final RecyclerView get_recyclerView() {
        return this._recyclerView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean haveItemBy(boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = getDataList(z);
        if ((dataList instanceof Collection) && dataList.isEmpty()) {
            return false;
        }
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void insertFooterItem(@OXOo.OOXIXo DslAdapterItem item, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        if (z && this.footerItems.contains(item)) {
            return;
        }
        List<DslAdapterItem> list = this.footerItems;
        list.add(_validIndex(list, i), item);
        _updateAdapterItems();
    }

    public final void insertHeaderItem(@OXOo.OOXIXo DslAdapterItem item, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        if (z && this.headerItems.contains(item)) {
            return;
        }
        List<DslAdapterItem> list = this.headerItems;
        list.add(_validIndex(list, i), item);
        _updateAdapterItems();
    }

    public final void insertItem(int i, @OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        if (list.isEmpty()) {
            return;
        }
        List<DslAdapterItem> list2 = this.dataItems;
        list2.addAll(_validIndex(list2, i), list);
        _updateAdapterItems();
    }

    public final boolean insertItemAfter(@OXOo.OOXIXo DslAdapterItem with, @OXOo.OOXIXo DslAdapterItem newItem, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(with, "with");
        kotlin.jvm.internal.IIX0o.x0xO0oo(newItem, "newItem");
        return (insertItemAfter(this.dataItems, with, newItem, z) == -1 && insertItemAfter(this.headerItems, with, newItem, z) == -1 && insertItemAfter(this.footerItems, with, newItem, z) == -1) ? false : true;
    }

    public final boolean insertItemBefore(@OXOo.OOXIXo DslAdapterItem with, @OXOo.OOXIXo DslAdapterItem newItem, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(with, "with");
        kotlin.jvm.internal.IIX0o.x0xO0oo(newItem, "newItem");
        return (insertItemBefore(this.dataItems, with, newItem, z) == -1 && insertItemBefore(this.headerItems, with, newItem, z) == -1 && insertItemBefore(this.footerItems, with, newItem, z) == -1) ? false : true;
    }

    public final <T extends DslAdapterItem> void invoke(@OXOo.OOXIXo T t, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(t, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        addLastItem(t, config);
    }

    public final boolean isAdapterStatus() {
        return this.dslAdapterStatusItem.isInStateLayout();
    }

    public final boolean isEmpty() {
        return this.adapterItems.isEmpty();
    }

    @OXOo.OOXIXo
    public final <T extends DslAdapterItem> DslAdapter minus(@OXOo.OOXIXo T item) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        removeItemFromAll$default(this, item, false, 2, null);
        return this;
    }

    public final void notifyDataChanged() {
        List<DslAdapterItem> Oxx0xo2;
        List<DslAdapterItem> Oxx0xo3;
        _updateAdapterItems();
        DslDataFilter dslDataFilter = this.dslDataFilter;
        if (dslDataFilter != null) {
            dslDataFilter.xoIox();
        }
        DslDataFilter dslDataFilter2 = this.dslDataFilter;
        if (dslDataFilter2 != null && (Oxx0xo3 = dslDataFilter2.Oxx0xo()) != null) {
            Oxx0xo3.clear();
        }
        DslDataFilter dslDataFilter3 = this.dslDataFilter;
        if (dslDataFilter3 != null && (Oxx0xo2 = dslDataFilter3.Oxx0xo()) != null) {
            Oxx0xo2.addAll(this.adapterItems);
        }
        Iterator<T> it = this.adapterItems.iterator();
        while (it.hasNext()) {
            ((DslAdapterItem) it.next()).diffResult(null, null);
        }
        notifyDataSetChanged();
    }

    public final void notifyItemChanged(@OXOo.oOoXoXO DslAdapterItem dslAdapterItem, @OXOo.oOoXoXO Object obj, boolean z) {
        List<DslAdapterItem> dataList;
        int indexOf;
        if (dslAdapterItem != null && (indexOf = (dataList = getDataList(z)).indexOf(dslAdapterItem)) >= 0 && indexOf < dataList.size()) {
            dslAdapterItem.diffResult(null, null);
            notifyItemChangedPayload(indexOf, obj);
        }
    }

    public final void notifyItemChangedPayload(int i, @OXOo.oOoXoXO Object obj) {
        notifyItemChanged(i, obj);
    }

    public final void observeItemBind(@OXOo.OOXIXo Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> itemBindAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemBindAction, "itemBindAction");
        this.itemBindObserver.add(itemBindAction);
    }

    public final void observeItemUpdateDepend(@OXOo.OOXIXo Oox.oOoXoXO<? super XxX0x0xxx, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.itemUpdateDependObserver.add(action);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@OXOo.OOXIXo RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this._recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@OXOo.OOXIXo DslViewHolder holder, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@OXOo.OOXIXo RecyclerView recyclerView) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this._recyclerView = null;
    }

    public final void onDispatchUpdates(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.dispatchUpdatesAfterList.add(action);
    }

    @Override // com.angcyo.dsladapter.oOXoIIIo
    public void onDispatchUpdatesAfter(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> oooxoxo = this.onDispatchUpdatesAfterOnce;
        if (oooxoxo != null) {
            oooxoxo.invoke(dslAdapter);
        }
        this.onDispatchUpdatesAfterOnce = null;
        Iterator<T> it = this.dispatchUpdatesAfterOnceList.iterator();
        while (it.hasNext()) {
            ((Oox.oOoXoXO) it.next()).invoke(dslAdapter);
        }
        this.dispatchUpdatesAfterOnceList.clear();
        Iterator<T> it2 = this.dispatchUpdatesAfterList.iterator();
        while (it2.hasNext()) {
            ((Oox.oOoXoXO) it2.next()).invoke(dslAdapter);
        }
    }

    @Override // com.angcyo.dsladapter.oOXoIIIo
    public void onDispatchUpdatesBefore(@OXOo.OOXIXo DslAdapter dslAdapter) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapter, "dslAdapter");
        Iterator<T> it = this.dispatchUpdatesBeforeList.iterator();
        while (it.hasNext()) {
            ((Oox.oOoXoXO) it.next()).invoke(dslAdapter);
        }
    }

    public final void onDispatchUpdatesOnce(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.dispatchUpdatesAfterOnceList.add(action);
    }

    @OXOo.OOXIXo
    public final <T extends DslAdapterItem> DslAdapter plus(@OXOo.OOXIXo T item) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        addLastItem(item);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeAllItemBy(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> list = this.dataItems;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        removeItem(arrayList);
        List<DslAdapterItem> list2 = this.headerItems;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (predicate.invoke(obj2).booleanValue()) {
                arrayList2.add(obj2);
            }
        }
        removeHeaderItem(arrayList2);
        List<DslAdapterItem> list3 = this.footerItems;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list3) {
            if (predicate.invoke(obj3).booleanValue()) {
                arrayList3.add(obj3);
            }
        }
        removeFooterItem(arrayList3);
    }

    public final void removeFooterItem(@OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (this.footerItems.contains((DslAdapterItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (this.footerItems.removeAll(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((DslAdapterItem) it.next()).setItemRemoveFlag(true);
            }
            _updateAdapterItems();
        }
    }

    public final void removeHeaderItem(@OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (this.headerItems.contains((DslAdapterItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (this.headerItems.removeAll(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((DslAdapterItem) it.next()).setItemRemoveFlag(true);
            }
            _updateAdapterItems();
        }
    }

    public final void removeItem(@OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (this.dataItems.contains((DslAdapterItem) obj)) {
                arrayList.add(obj);
            }
        }
        if (this.dataItems.removeAll(arrayList)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((DslAdapterItem) it.next()).setItemRemoveFlag(true);
            }
            _updateAdapterItems();
        }
    }

    public final void removeItemBind(@OXOo.OOXIXo Oox.Oxx0xo<? super DslViewHolder, ? super Integer, ? super DslAdapterItem, ? super List<? extends Object>, oXIO0o0XI> itemBindAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemBindAction, "itemBindAction");
        this.itemBindObserver.remove(itemBindAction);
    }

    public final void removeItemFrom(@OXOo.OOXIXo List<DslAdapterItem> fromList, @OXOo.OOXIXo DslAdapterItem item, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fromList, "fromList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        int indexOf = this.adapterItems.indexOf(item);
        if (indexOf != -1 && fromList.remove(item)) {
            item.setItemRemoveFlag(true);
            if (z) {
                int size = this.adapterItems.size();
                for (int i = indexOf + 1; i < size; i++) {
                    DslAdapterItem dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(this.adapterItems, i);
                    if (dslAdapterItem != null) {
                        dslAdapterItem.setItemUpdateFlag(true);
                    }
                }
            }
            _updateAdapterItems();
        }
    }

    public final void removeItemFromAll(@OXOo.OOXIXo DslAdapterItem item, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        removeItemFrom(this.dataItems, item, z);
        removeItemFrom(this.headerItems, item, z);
        removeItemFrom(this.footerItems, item, z);
    }

    public final void removeItemUpdateDepend(@OXOo.OOXIXo Oox.oOoXoXO<? super XxX0x0xxx, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.itemUpdateDependObserver.remove(action);
    }

    public final void render(boolean z, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Integer II0xO02 = DslAdapterExKt.II0xO0(this);
        action.invoke(this);
        _updateAdapterItems();
        if (z) {
            Integer II0xO03 = DslAdapterExKt.II0xO0(this);
            if (this.adapterItems.isEmpty()) {
                if ((II0xO02 != null && II0xO02.intValue() > 0) || ((II0xO03 == null || II0xO03.intValue() != 2) && (II0xO03 == null || II0xO03.intValue() != 3))) {
                    DslAdapterExKt.OxxIIOOXO(this);
                }
            } else {
                DslAdapterExKt.xxIO(this);
            }
        }
        updateItemDepend(filterParams);
    }

    public final void renderData(final boolean z, boolean z2, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapter, ? super List<DslAdapterItem>, oXIO0o0XI> render) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(render, "render");
        final DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        dslAdapter.dslDataFilter = null;
        render.invoke(dslAdapter, this.dataItems);
        changeItems(z2, filterParams, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$renderData$1
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
                if (z) {
                    this.getDataItems().clear();
                }
                this.getDataItems().addAll(dslAdapter.getAdapterItems());
            }
        });
    }

    public final void renderFooter(final boolean z, boolean z2, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapter, ? super List<DslAdapterItem>, oXIO0o0XI> render) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(render, "render");
        final DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        dslAdapter.dslDataFilter = null;
        render.invoke(dslAdapter, this.footerItems);
        changeItems(z2, filterParams, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$renderFooter$1
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
                if (z) {
                    this.getFooterItems().clear();
                }
                this.getFooterItems().addAll(dslAdapter.getAdapterItems());
            }
        });
    }

    public final void renderHeader(final boolean z, boolean z2, @OXOo.OOXIXo XxX0x0xxx filterParams, @OXOo.OOXIXo Oox.x0xO0oo<? super DslAdapter, ? super List<DslAdapterItem>, oXIO0o0XI> render) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        kotlin.jvm.internal.IIX0o.x0xO0oo(render, "render");
        final DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        dslAdapter.dslDataFilter = null;
        render.invoke(dslAdapter, this.headerItems);
        changeItems(z2, filterParams, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$renderHeader$1
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
                if (z) {
                    this.getHeaderItems().clear();
                }
                this.getHeaderItems().addAll(dslAdapter.getAdapterItems());
            }
        });
    }

    public final void resetItem(@OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        this.dataItems.clear();
        this.dataItems.addAll(list);
        _updateAdapterItems();
    }

    public final void setAdapterItemAnimateDelayHandler(@OXOo.OOXIXo com.angcyo.dsladapter.internal.II0xO0 iI0xO0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iI0xO0, "<set-?>");
        this.adapterItemAnimateDelayHandler = iI0xO0;
    }

    public final void setAdapterStatus(int i, @OXOo.oOoXoXO Throwable th) {
        if (this.dslAdapterStatusItem.getItemState() == i) {
            return;
        }
        if (i == 3) {
            this.dslAdapterStatusItem.setItemErrorThrowable(th);
        }
        this.dslAdapterStatusItem.setItemState(i);
        this.dslAdapterStatusItem.setItemUpdateFlag(true);
    }

    public final void setAdapterStatusEnable(boolean z) {
        if (this.dslAdapterStatusItem.getItemStateEnable() == z) {
            return;
        }
        this.dslAdapterStatusItem.setItemStateEnable(z);
    }

    public final void setAdapterStatusIFilterInterceptor(@OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxixoiio, "<set-?>");
        this.adapterStatusIFilterInterceptor = xxixoiio;
    }

    public final void setDefaultFilterParams(@OXOo.oOoXoXO XxX0x0xxx xxX0x0xxx) {
        this.defaultFilterParams = xxX0x0xxx;
    }

    public final void setDslAdapterStatusItem(@OXOo.OOXIXo DslAdapterStatusItem dslAdapterStatusItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslAdapterStatusItem, "<set-?>");
        this.dslAdapterStatusItem = dslAdapterStatusItem;
    }

    public final void setDslDataFilter(@OXOo.oOoXoXO DslDataFilter dslDataFilter) {
        this.dslDataFilter = dslDataFilter;
    }

    public final void setDslLoadMoreItem(@OXOo.OOXIXo DslLoadMoreItem dslLoadMoreItem) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dslLoadMoreItem, "<set-?>");
        this.dslLoadMoreItem = dslLoadMoreItem;
    }

    public final void setLoadMore(int i, @OXOo.oOoXoXO Object obj, boolean z) {
        if (this.dslLoadMoreItem.getItemStateEnable() && this.dslLoadMoreItem.getItemState() == i) {
            return;
        }
        this.dslLoadMoreItem.setItemDslAdapter(this);
        this.dslLoadMoreItem.setItemState(i);
        if (z) {
            notifyItemChanged$default(this, this.dslLoadMoreItem, obj, false, 4, null);
        }
    }

    public final void setLoadMoreEnable(boolean z) {
        if (this.dslLoadMoreItem.getItemStateEnable() == z) {
            return;
        }
        this.dslLoadMoreItem.setItemStateEnable(z);
    }

    public final void setLoadMoreIFilterInterceptor(@OXOo.OOXIXo com.angcyo.dsladapter.filter.xxIXOIIO xxixoiio) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxixoiio, "<set-?>");
        this.loadMoreIFilterInterceptor = xxixoiio;
    }

    public final void setOnDispatchUpdatesAfterOnce(@OXOo.oOoXoXO Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> oooxoxo) {
        this.onDispatchUpdatesAfterOnce = oooxoxo;
    }

    public final void setOnceFilterParams(@OXOo.oOoXoXO XxX0x0xxx xxX0x0xxx) {
        this.onceFilterParams = xxX0x0xxx;
    }

    public final void set_recyclerView(@OXOo.oOoXoXO RecyclerView recyclerView) {
        this._recyclerView = recyclerView;
    }

    public final void updateAdapterStatus(int i) {
        if (this.dslAdapterStatusItem.getItemState() == i) {
            return;
        }
        this.dslAdapterStatusItem.setItemDslAdapter(this);
        this.dslAdapterStatusItem.setItemState(i);
        if (!this.dslAdapterStatusItem.getItemChanging() || !this.dslAdapterStatusItem.getItemChanged()) {
            this.dslAdapterStatusItem.setItemChanging(true);
        }
    }

    public final void updateAllDataItem(@OXOo.oOoXoXO Object obj) {
        Iterator<T> it = this.dataItems.iterator();
        while (it.hasNext()) {
            ((DslAdapterItem) it.next()).diffResult(null, null);
        }
        notifyItemRangeChanged(0, this.dataItems.size(), obj);
    }

    public final void updateAllFooterItem(@OXOo.oOoXoXO Object obj) {
        Iterator<T> it = this.footerItems.iterator();
        while (it.hasNext()) {
            ((DslAdapterItem) it.next()).diffResult(null, null);
        }
        notifyItemRangeChanged(this.dataItems.size() + this.headerItems.size(), this.footerItems.size(), obj);
    }

    public final void updateAllHeaderItem(@OXOo.oOoXoXO Object obj) {
        Iterator<T> it = this.headerItems.iterator();
        while (it.hasNext()) {
            ((DslAdapterItem) it.next()).diffResult(null, null);
        }
        notifyItemRangeChanged(this.dataItems.size(), this.headerItems.size(), obj);
    }

    public final void updateAllItem(@OXOo.oOoXoXO Object obj) {
        Iterator<T> it = this.adapterItems.iterator();
        while (it.hasNext()) {
            ((DslAdapterItem) it.next()).diffResult(null, null);
        }
        notifyItemRangeChanged(0, getItemCount(), obj);
    }

    public final void updateDataFilter(@OXOo.oOoXoXO DslDataFilter dslDataFilter) {
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.dslDataFilter, dslDataFilter)) {
            return;
        }
        DslDataFilter dslDataFilter2 = this.dslDataFilter;
        if (dslDataFilter2 != null) {
            dslDataFilter2.o00(this);
            dslDataFilter2.x0xO0oo().remove(this.adapterStatusIFilterInterceptor);
            dslDataFilter2.oO().remove(this.loadMoreIFilterInterceptor);
        }
        this.dslDataFilter = dslDataFilter;
        if (dslDataFilter != null) {
            dslDataFilter.II0XooXoX(this);
            dslDataFilter.x0xO0oo().add(0, this.adapterStatusIFilterInterceptor);
            dslDataFilter.oO().add(this.loadMoreIFilterInterceptor);
        }
    }

    public final void updateItemDepend(@OXOo.OOXIXo XxX0x0xxx filterParams) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(filterParams, "filterParams");
        Iterator<T> it = this.itemUpdateDependObserver.iterator();
        while (it.hasNext()) {
            ((Oox.oOoXoXO) it.next()).invoke(filterParams);
        }
        DslDataFilter dslDataFilter = this.dslDataFilter;
        if (dslDataFilter != null) {
            dslDataFilter.O0xOxO(filterParams);
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(filterParams, this.onceFilterParams)) {
                this.onceFilterParams = null;
            }
        }
    }

    public final void updateItems(@OXOo.OOXIXo Iterable<? extends DslAdapterItem> list, @OXOo.oOoXoXO Object obj, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        List<DslAdapterItem> dataList = getDataList(z);
        for (DslAdapterItem dslAdapterItem : list) {
            int indexOf = dataList.indexOf(dslAdapterItem);
            if (indexOf >= 0 && indexOf < dataList.size()) {
                dslAdapterItem.diffResult(null, null);
                notifyItemChangedPayload(indexOf, obj);
            }
        }
    }

    public /* synthetic */ DslAdapter(List list, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? null : list);
    }

    public static /* synthetic */ DslAdapterItem get$default(DslAdapter dslAdapter, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return dslAdapter.get(str, z);
    }

    public static /* synthetic */ void insertItem$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItem");
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        dslAdapter.insertItem(dslAdapterItem, i, z);
    }

    public static /* synthetic */ int insertItemAfter$default(DslAdapter dslAdapter, List list, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItemAfter");
        }
        if ((i & 8) != 0) {
            z = true;
        }
        return dslAdapter.insertItemAfter(list, dslAdapterItem, dslAdapterItem2, z);
    }

    public static /* synthetic */ int insertItemBefore$default(DslAdapter dslAdapter, List list, DslAdapterItem dslAdapterItem, DslAdapterItem dslAdapterItem2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItemBefore");
        }
        if ((i & 8) != 0) {
            z = true;
        }
        return dslAdapter.insertItemBefore(list, dslAdapterItem, dslAdapterItem2, z);
    }

    public static /* synthetic */ void invoke$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, int i, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((i2 & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$invoke$2
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        dslAdapter.invoke((DslAdapter) dslAdapterItem, i, (Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI>) oooxoxo);
    }

    public final <T extends DslAdapterItem> void addLastItem(@OXOo.OOXIXo T item, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        insertItem(-1, (int) item, (Oox.oOoXoXO<? super int, oXIO0o0XI>) init);
    }

    public final <T extends DslAdapterItem> void invoke(@OXOo.OOXIXo T t, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(t, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        insertItem(i, (int) t, (Oox.oOoXoXO<? super int, oXIO0o0XI>) config);
    }

    @OXOo.OOXIXo
    public final <T extends DslAdapterItem> DslAdapter minus(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        removeItemFromAll(list);
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @OXOo.OOXIXo
    public DslViewHolder onCreateViewHolder(@OXOo.OOXIXo ViewGroup parent, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(parent, "parent");
        Integer num = this._itemLayoutHold.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        int intValue = num.intValue();
        if (intValue > 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(intValue, parent, false);
            kotlin.jvm.internal.IIX0o.oO(inflate, "from(parent.context).inf…(layoutId, parent, false)");
            return new DslViewHolder(inflate, 0, 2, null);
        }
        throw new IllegalStateException("请检查是否未指定[itemLayoutId]");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@OXOo.OOXIXo DslViewHolder holder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        boolean onFailedToRecycleView = super.onFailedToRecycleView((DslAdapter) holder);
        L.f5267oIX0oI.oo0xXOI0I("是否回收失败:" + holder + TokenParser.SP + onFailedToRecycleView);
        return onFailedToRecycleView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@OXOo.OOXIXo DslViewHolder holder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        super.onViewAttachedToWindow((DslAdapter) holder);
        DslAdapterItem dslAdapterItem = getDslAdapterItem(holder);
        if (dslAdapterItem != null) {
            View view = holder.itemView;
            kotlin.jvm.internal.IIX0o.oO(view, "holder.itemView");
            LibExKt.xI(view, dslAdapterItem.getItemSpanCount() == -1);
            dslAdapterItem.getItemViewAttachedToWindow().invoke(holder, Integer.valueOf(holder.getAdapterPosition()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@OXOo.OOXIXo DslViewHolder holder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        super.onViewDetachedFromWindow((DslAdapter) holder);
        DslAdapterItem dslAdapterItem = getDslAdapterItem(holder);
        if (dslAdapterItem != null) {
            dslAdapterItem.getItemViewDetachedToWindow().invoke(holder, Integer.valueOf(holder.getAdapterPosition()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@OXOo.OOXIXo DslViewHolder holder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        super.onViewRecycled((DslAdapter) holder);
        DslAdapterItem dslAdapterItem = getDslAdapterItem(holder);
        if (dslAdapterItem != null) {
            dslAdapterItem.getItemViewRecycled().invoke(holder, Integer.valueOf(holder.getAdapterPosition()));
        }
    }

    @OXOo.OOXIXo
    public final <T extends DslAdapterItem> DslAdapter plus(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        addLastItem(list);
        return this;
    }

    public DslAdapter(@OXOo.oOoXoXO List<? extends DslAdapterItem> list) {
        this.dslAdapterStatusItem = new DslAdapterStatusItem();
        this.dslLoadMoreItem = new DslLoadMoreItem();
        this.adapterStatusIFilterInterceptor = new com.angcyo.dsladapter.internal.oIX0oI();
        this.loadMoreIFilterInterceptor = new com.angcyo.dsladapter.internal.xoIox();
        this.adapterItemAnimateDelayHandler = new com.angcyo.dsladapter.internal.II0xO0();
        this.adapterItems = new ArrayList();
        this.footerItems = new ArrayList();
        this.headerItems = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.dataItems = arrayList;
        this.itemSelectorHelper = new ItemSelectorHelper(this);
        this.dispatchUpdatesBeforeList = new ArrayList();
        this.dispatchUpdatesAfterList = new ArrayList();
        this.dispatchUpdatesAfterOnceList = new ArrayList();
        this.itemBindObserver = new LinkedHashSet();
        this.itemUpdateDependObserver = new LinkedHashSet();
        this._itemLayoutHold = new HashMap<>();
        updateDataFilter(new DslDataFilter(this));
        if (list != null) {
            arrayList.clear();
            arrayList.addAll(list);
            _updateAdapterItems();
            updateItemDepend(new XxX0x0xxx(null, false, false, true, false, false, null, null, 0L, 0L, null, 2035, null));
        }
    }

    public static /* synthetic */ List get$default(DslAdapter dslAdapter, Oox.oOoXoXO oooxoxo, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return dslAdapter.get((Oox.oOoXoXO<? super DslAdapterItem, Boolean>) oooxoxo, z);
    }

    public static /* synthetic */ void insertItem$default(DslAdapter dslAdapter, int i, DslAdapterItem dslAdapterItem, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertItem");
        }
        if ((i2 & 4) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$insertItem$1
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        dslAdapter.insertItem(i, (int) dslAdapterItem, (Oox.oOoXoXO<? super int, oXIO0o0XI>) oooxoxo);
    }

    public static /* synthetic */ void invoke$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, List list, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((i & 2) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$invoke$3
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        dslAdapter.invoke((DslAdapter) dslAdapterItem, (List<DslAdapterItem>) list, (Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI>) oooxoxo);
    }

    public final <T extends DslAdapterItem> void addLastItem(@OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo T item, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        insertItem(list, -1, item, init);
    }

    public final <T extends DslAdapterItem> void invoke(@OXOo.OOXIXo T t, @OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(t, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        addLastItem(list, t, config);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(DslViewHolder dslViewHolder, int i, List list) {
        onBindViewHolder2(dslViewHolder, i, (List<? extends Object>) list);
    }

    public static /* synthetic */ List get$default(DslAdapter dslAdapter, Class cls, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return dslAdapter.get(cls, z);
    }

    public final void addLastItem(@OXOo.OOXIXo List<? extends DslAdapterItem> item) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        insertItem(-1, item);
    }

    @OXOo.oOoXoXO
    public final DslAdapterItem get(@OXOo.oOoXoXO String str, boolean z) {
        if (str != null) {
            return DslAdapterExKt.x0o(this, str, z);
        }
        return null;
    }

    public final void insertItem(int i, @OXOo.OOXIXo DslAdapterItem item, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        if (z && this.dataItems.contains(item)) {
            return;
        }
        List<DslAdapterItem> list = this.dataItems;
        list.add(_validIndex(list, i), item);
        _updateAdapterItems();
    }

    public final int insertItemAfter(@OXOo.OOXIXo List<DslAdapterItem> fromList, @OXOo.OOXIXo DslAdapterItem with, @OXOo.OOXIXo DslAdapterItem newItem, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fromList, "fromList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(with, "with");
        kotlin.jvm.internal.IIX0o.x0xO0oo(newItem, "newItem");
        int oIX0oI2 = LibExKt.oIX0oI(fromList, with, newItem);
        if (oIX0oI2 != -1) {
            if (z) {
                int size = fromList.size();
                for (int i = oIX0oI2 + 1; i < size; i++) {
                    DslAdapterItem dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(this.adapterItems, i);
                    if (dslAdapterItem != null) {
                        dslAdapterItem.setItemUpdateFlag(true);
                    }
                }
            }
            _updateAdapterItems();
        }
        return oIX0oI2;
    }

    public final int insertItemBefore(@OXOo.OOXIXo List<DslAdapterItem> fromList, @OXOo.OOXIXo DslAdapterItem with, @OXOo.OOXIXo DslAdapterItem newItem, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fromList, "fromList");
        kotlin.jvm.internal.IIX0o.x0xO0oo(with, "with");
        kotlin.jvm.internal.IIX0o.x0xO0oo(newItem, "newItem");
        int II0xO02 = LibExKt.II0xO0(fromList, with, newItem);
        if (II0xO02 != -1) {
            if (z) {
                for (int i = 0; i < II0xO02; i++) {
                    DslAdapterItem dslAdapterItem = (DslAdapterItem) CollectionsKt___CollectionsKt.OIoxIx(this.adapterItems, i);
                    if (dslAdapterItem != null) {
                        dslAdapterItem.setItemUpdateFlag(true);
                    }
                }
            }
            _updateAdapterItems();
        }
        return II0xO02;
    }

    public final <T extends DslAdapterItem> void invoke(@OXOo.OOXIXo T t, int i, @OXOo.OOXIXo List<DslAdapterItem> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> config) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(t, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(config, "config");
        insertItem(list, i, t, config);
    }

    /* renamed from: onBindViewHolder */
    public void onBindViewHolder2(@OXOo.OOXIXo DslViewHolder holder, int i, @OXOo.OOXIXo List<? extends Object> payloads) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(holder, "holder");
        kotlin.jvm.internal.IIX0o.x0xO0oo(payloads, "payloads");
        super.onBindViewHolder((DslAdapter) holder, i, (List<Object>) payloads);
        DslAdapterItem itemData$default = getItemData$default(this, i, false, 2, null);
        if (itemData$default != null) {
            itemData$default.setItemDslAdapter(this);
            itemData$default.getItemBind().invoke(holder, Integer.valueOf(i), itemData$default, payloads);
            holder.setBindView(true);
            Iterator<T> it = this.itemBindObserver.iterator();
            while (it.hasNext()) {
                ((Oox.Oxx0xo) it.next()).invoke(holder, Integer.valueOf(i), itemData$default, payloads);
            }
        }
    }

    public final void onDispatchUpdatesBefore(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.dispatchUpdatesBeforeList.add(action);
    }

    public final void removeItemFromAll(@OXOo.OOXIXo List<? extends DslAdapterItem> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        removeItem(list);
        removeHeaderItem(list);
        removeFooterItem(list);
    }

    public static /* synthetic */ List get$default(DslAdapter dslAdapter, kotlin.reflect.oxoX oxox, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return dslAdapter.get(oxox, z);
    }

    public static /* synthetic */ void invoke$default(DslAdapter dslAdapter, DslAdapterItem dslAdapterItem, int i, List list, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        }
        if ((i2 & 4) != 0) {
            oooxoxo = new Oox.oOoXoXO<Object, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.DslAdapter$invoke$4
                public final void invoke(@OXOo.OOXIXo Object obj2) {
                    kotlin.jvm.internal.IIX0o.x0xO0oo(obj2, "$this$null");
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Object obj2) {
                    invoke(obj2);
                    return oXIO0o0XI.f29392oIX0oI;
                }
            };
        }
        dslAdapter.invoke(dslAdapterItem, i, list, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final List<DslAdapterItem> get(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapterItem, Boolean> predicate, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        List<DslAdapterItem> dataList = getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List get$default(DslAdapter dslAdapter, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            List<DslAdapterItem> dataList = dslAdapter.getDataList(z);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : dataList) {
                kotlin.jvm.internal.IIX0o.OxI(3, "Item");
                if (obj2 instanceof Object) {
                    arrayList.add(obj2);
                }
            }
            return arrayList;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
    }

    public final void insertItem(@OXOo.OOXIXo DslAdapterItem item, int i, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        insertItem(i, item, z);
    }

    @OXOo.OOXIXo
    public final <Item extends DslAdapterItem> List<Item> get(@OXOo.OOXIXo Class<Item> itemClass, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemClass, "itemClass");
        List<DslAdapterItem> dataList = getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo((DslAdapterItem) obj), LibExKt.x0xO0oo(itemClass))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends DslAdapterItem> void insertItem(int i, @OXOo.OOXIXo T item, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        List<DslAdapterItem> list = this.dataItems;
        list.add(_validIndex(list, i), item);
        _updateAdapterItems();
        init.invoke(item);
    }

    public final void onDispatchUpdatesAfter(@OXOo.OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        this.dispatchUpdatesAfterList.add(action);
    }

    public final void removeFooterItem(@OXOo.OOXIXo DslAdapterItem item, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        removeItemFrom(this.footerItems, item, z);
    }

    public final void removeHeaderItem(@OXOo.OOXIXo DslAdapterItem item, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        removeItemFrom(this.headerItems, item, z);
    }

    public final void removeItem(@OXOo.OOXIXo DslAdapterItem item, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        removeItemFrom(this.dataItems, item, z);
    }

    public final <T extends DslAdapterItem> void insertItem(@OXOo.OOXIXo List<DslAdapterItem> list, int i, @OXOo.OOXIXo T item, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> init) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
        kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
        kotlin.jvm.internal.IIX0o.x0xO0oo(init, "init");
        list.add(_validIndex(list, i), item);
        _updateAdapterItems();
        init.invoke(item);
    }

    @OXOo.OOXIXo
    public final <Item extends DslAdapterItem> List<Item> get(@OXOo.OOXIXo kotlin.reflect.oxoX<Item> itemClass, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(itemClass, "itemClass");
        List<DslAdapterItem> dataList = getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(LibExKt.x0xO0oo((DslAdapterItem) obj), LibExKt.x0xO0oo(XO0OX.II0xO0.X0o0xo(itemClass)))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final /* synthetic */ <Item extends DslAdapterItem> List<Item> get(boolean z) {
        List<DslAdapterItem> dataList = getDataList(z);
        ArrayList arrayList = new ArrayList();
        for (Object obj : dataList) {
            kotlin.jvm.internal.IIX0o.OxI(3, "Item");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
