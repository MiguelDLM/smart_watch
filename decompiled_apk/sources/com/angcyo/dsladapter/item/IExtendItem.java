package com.angcyo.dsladapter.item;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.IdRes;
import com.angcyo.dsladapter.DslAdapterExKt;
import com.angcyo.dsladapter.DslAdapterItem;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.item.IExtendItem;
import com.angcyo.dsladapter.item.oIX0oI;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes7.dex */
public interface IExtendItem extends oIX0oI {

    /* loaded from: classes7.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void I0Io(IExtendItem iExtendItem, DslViewHolder dslViewHolder, int i, DslAdapterItem dslAdapterItem, List list, int i2, int i3, float f, float f2, float f3, float f4, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initExtendItem");
            }
            iExtendItem.X0o0xo(dslViewHolder, i, dslAdapterItem, list, i2, (i4 & 32) != 0 ? -1 : i3, (i4 & 64) != 0 ? 0.0f : f, (i4 & 128) != 0 ? 180.0f : f2, (i4 & 256) != 0 ? 180.0f : f3, (i4 & 512) != 0 ? 180.0f : f4);
        }

        public static void II0xO0(@OOXIXo IExtendItem iExtendItem, @OOXIXo final DslViewHolder itemHolder, int i, @OOXIXo final DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads, @IdRes final int i2, @IdRes int i3, float f, float f2, final float f3, final float f4) {
            View view;
            IIX0o.x0xO0oo(itemHolder, "itemHolder");
            IIX0o.x0xO0oo(adapterItem, "adapterItem");
            IIX0o.x0xO0oo(payloads, "payloads");
            final boolean itemGroupExtend = adapterItem.getItemGroupExtend();
            if (!DslAdapterExKt.xoIox(payloads, 4) && (view = itemHolder.view(i2)) != null) {
                view.setRotation(itemGroupExtend ? f : f2);
            }
            if (i3 == -1) {
                itemHolder.clickItem(new oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.item.IExtendItem$initExtendItem$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view2) {
                        invoke2(view2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo View it) {
                        IIX0o.x0xO0oo(it, "it");
                        IExtendItem.DefaultImpls.oxoX(DslViewHolder.this, i2, adapterItem, itemGroupExtend, f4, f3);
                    }
                });
            } else {
                itemHolder.click(i3, new oOoXoXO<View, oXIO0o0XI>() { // from class: com.angcyo.dsladapter.item.IExtendItem$initExtendItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ oXIO0o0XI invoke(View view2) {
                        invoke2(view2);
                        return oXIO0o0XI.f29392oIX0oI;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@OOXIXo View it) {
                        IIX0o.x0xO0oo(it, "it");
                        IExtendItem.DefaultImpls.oxoX(DslViewHolder.this, i2, adapterItem, itemGroupExtend, f4, f3);
                    }
                });
            }
        }

        public static void X0o0xo(@OOXIXo IExtendItem iExtendItem, @OOXIXo DslViewHolder itemHolder, int i, @OOXIXo DslAdapterItem adapterItem, @OOXIXo List<? extends Object> payloads) {
            IIX0o.x0xO0oo(itemHolder, "itemHolder");
            IIX0o.x0xO0oo(adapterItem, "adapterItem");
            IIX0o.x0xO0oo(payloads, "payloads");
            oIX0oI.C0113oIX0oI.oIX0oI(iExtendItem, itemHolder, i, adapterItem, payloads);
        }

        public static boolean XO(@OOXIXo IExtendItem iExtendItem, @OOXIXo DslAdapterItem item) {
            IIX0o.x0xO0oo(item, "item");
            return oIX0oI.C0113oIX0oI.II0xO0(iExtendItem, item);
        }

        public static void oxoX(DslViewHolder dslViewHolder, int i, DslAdapterItem dslAdapterItem, boolean z, float f, float f2) {
            ViewPropertyAnimator animate;
            View view = dslViewHolder.view(i);
            if (view != null && (animate = view.animate()) != null) {
                if (z) {
                    animate.rotationBy(f);
                } else {
                    animate.rotationBy(f2);
                }
                animate.setDuration(300L);
                animate.start();
            }
            dslAdapterItem.setItemGroupExtend(!z);
        }
    }

    void X0o0xo(@OOXIXo DslViewHolder dslViewHolder, int i, @OOXIXo DslAdapterItem dslAdapterItem, @OOXIXo List<? extends Object> list, @IdRes int i2, @IdRes int i3, float f, float f2, float f3, float f4);
}
