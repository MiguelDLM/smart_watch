package kotlin.collections.unsigned;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import X0.IIXOooo;
import XO0OX.xxIXOIIO;
import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.IIX0;
import kotlin.IXxxXO;
import kotlin.OO0x0xX;
import kotlin.OOXIxO0;
import kotlin.OX00O0xII;
import kotlin.Pair;
import kotlin.X00IoxXI;
import kotlin.XI0oooXX;
import kotlin.XX0xXo;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OI0;
import kotlin.collections.OxI;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.X0IIOO;
import kotlin.collections.oOXoIIIo;
import kotlin.collections.oo0xXOI0I;
import kotlin.collections.ooOOo0oXI;
import kotlin.collections.xI;
import kotlin.collections.xoxXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oI0IIXIo;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;
import kotlin.random.Random;
import kotlin.x0xO;
import kotlin.xX0IIXIx0;
import kotlin.xxIO;
import xx0o0O.XO;

@XX({"SMAP\n_UArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,10733:1\n3775#1:10734\n3783#1:10735\n3791#1:10736\n3799#1:10737\n3775#1:10738\n3783#1:10739\n3791#1:10740\n3799#1:10741\n3775#1:10742\n3783#1:10743\n3791#1:10744\n3799#1:10745\n3775#1:10795\n3783#1:10796\n3791#1:10797\n3799#1:10798\n3775#1:10799\n3783#1:10800\n3791#1:10801\n3799#1:10802\n3775#1:10803\n3783#1:10804\n3791#1:10805\n3799#1:10806\n3775#1:10863\n3783#1:10864\n3791#1:10865\n3799#1:10866\n3775#1:10867\n3783#1:10868\n3791#1:10869\n3799#1:10870\n3775#1:10871\n3783#1:10872\n3791#1:10873\n3799#1:10874\n3775#1:10875\n3783#1:10876\n3791#1:10877\n3799#1:10878\n3775#1:10879\n3783#1:10880\n3791#1:10881\n3799#1:10882\n3775#1:10883\n3783#1:10884\n3791#1:10885\n3799#1:10886\n3775#1:10887\n3783#1:10888\n3791#1:10889\n3799#1:10890\n3775#1:10891\n3783#1:10892\n3791#1:10893\n3799#1:10894\n3775#1:10895\n3783#1:10896\n3791#1:10897\n3799#1:10898\n3775#1:10899\n3783#1:10900\n3791#1:10901\n3799#1:10902\n3775#1:10903\n3783#1:10904\n3791#1:10905\n3799#1:10906\n3775#1:10907\n3783#1:10908\n3791#1:10909\n3799#1:10910\n3775#1:10911\n3783#1:10912\n3791#1:10913\n3799#1:10914\n3775#1:10915\n3783#1:10916\n3791#1:10917\n3799#1:10918\n3775#1:10919\n3783#1:10920\n3791#1:10921\n3799#1:10922\n3775#1:10923\n3783#1:10924\n3791#1:10925\n3799#1:10926\n3775#1:10927\n3783#1:10928\n3791#1:10929\n3799#1:10930\n3775#1:10931\n3783#1:10932\n3791#1:10933\n3799#1:10934\n3775#1:10935\n3783#1:10936\n3791#1:10937\n3799#1:10938\n3775#1:10939\n3783#1:10940\n3791#1:10941\n3799#1:10942\n3775#1:10943\n3783#1:10944\n3791#1:10945\n3799#1:10946\n3775#1:10947\n3783#1:10948\n3791#1:10949\n3799#1:10950\n3775#1:10951\n3783#1:10952\n3791#1:10953\n3799#1:10954\n3775#1:10955\n3783#1:10956\n3791#1:10957\n3799#1:10958\n3775#1:10959\n3783#1:10960\n3791#1:10961\n3799#1:10962\n3775#1:10963\n3783#1:10964\n3791#1:10965\n3799#1:10966\n3775#1:10967\n3783#1:10968\n3791#1:10969\n3799#1:10970\n3775#1:10971\n3783#1:10972\n3791#1:10973\n3799#1:10974\n3775#1:10975\n3783#1:10976\n3791#1:10977\n3799#1:10978\n3775#1:10979\n3783#1:10980\n3791#1:10981\n3799#1:10982\n3775#1:10983\n3783#1:10984\n3791#1:10985\n3799#1:10986\n3775#1:10987\n3783#1:10988\n3791#1:10989\n3799#1:10990\n3775#1:10991\n3783#1:10992\n3791#1:10993\n3799#1:10994\n3775#1:10995\n3783#1:10996\n3791#1:10997\n3799#1:10998\n3775#1:10999\n3783#1:11000\n3791#1:11001\n3799#1:11002\n3775#1:11003\n3783#1:11004\n3791#1:11005\n3799#1:11006\n3775#1:11007\n3783#1:11008\n3791#1:11009\n3799#1:11010\n3775#1:11011\n3783#1:11012\n3791#1:11013\n3799#1:11014\n1663#2,6:10746\n1675#2,6:10752\n1639#2,6:10758\n1651#2,6:10764\n1771#2,6:10770\n1783#2,6:10776\n1747#2,6:10782\n1759#2,6:10788\n1#3:10794\n372#4,7:10807\n372#4,7:10814\n372#4,7:10821\n372#4,7:10828\n372#4,7:10835\n372#4,7:10842\n372#4,7:10849\n372#4,7:10856\n*S KotlinDebug\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n*L\n326#1:10734\n338#1:10735\n350#1:10736\n362#1:10737\n692#1:10738\n702#1:10739\n712#1:10740\n722#1:10741\n733#1:10742\n744#1:10743\n755#1:10744\n766#1:10745\n1718#1:10795\n1735#1:10796\n1752#1:10797\n1769#1:10798\n2546#1:10799\n2563#1:10800\n2580#1:10801\n2597#1:10802\n2913#1:10803\n2929#1:10804\n2945#1:10805\n2961#1:10806\n5573#1:10863\n5593#1:10864\n5613#1:10865\n5633#1:10866\n5654#1:10867\n5676#1:10868\n5698#1:10869\n5720#1:10870\n5833#1:10871\n5852#1:10872\n5871#1:10873\n5890#1:10874\n5912#1:10875\n5941#1:10876\n5970#1:10877\n5999#1:10878\n6024#1:10879\n6049#1:10880\n6074#1:10881\n6099#1:10882\n6129#1:10883\n6152#1:10884\n6175#1:10885\n6198#1:10886\n6221#1:10887\n6244#1:10888\n6267#1:10889\n6290#1:10890\n6311#1:10891\n6334#1:10892\n6357#1:10893\n6380#1:10894\n6403#1:10895\n6424#1:10896\n6445#1:10897\n6466#1:10898\n6487#1:10899\n6508#1:10900\n6529#1:10901\n6550#1:10902\n6569#1:10903\n6590#1:10904\n6611#1:10905\n6632#1:10906\n6655#1:10907\n6678#1:10908\n6701#1:10909\n6724#1:10910\n6745#1:10911\n6766#1:10912\n6787#1:10913\n6808#1:10914\n6825#1:10915\n6840#1:10916\n6855#1:10917\n6870#1:10918\n6889#1:10919\n6908#1:10920\n6927#1:10921\n6946#1:10922\n6961#1:10923\n6976#1:10924\n6991#1:10925\n7006#1:10926\n7025#1:10927\n7044#1:10928\n7063#1:10929\n7082#1:10930\n7104#1:10931\n7133#1:10932\n7162#1:10933\n7191#1:10934\n7216#1:10935\n7241#1:10936\n7266#1:10937\n7291#1:10938\n7321#1:10939\n7344#1:10940\n7367#1:10941\n7390#1:10942\n7413#1:10943\n7436#1:10944\n7459#1:10945\n7482#1:10946\n7503#1:10947\n7526#1:10948\n7549#1:10949\n7572#1:10950\n7595#1:10951\n7616#1:10952\n7637#1:10953\n7658#1:10954\n7679#1:10955\n7700#1:10956\n7721#1:10957\n7742#1:10958\n7761#1:10959\n7782#1:10960\n7803#1:10961\n7824#1:10962\n7847#1:10963\n7870#1:10964\n7893#1:10965\n7916#1:10966\n7937#1:10967\n7958#1:10968\n7979#1:10969\n8000#1:10970\n8017#1:10971\n8032#1:10972\n8047#1:10973\n8062#1:10974\n8081#1:10975\n8100#1:10976\n8119#1:10977\n8138#1:10978\n8153#1:10979\n8168#1:10980\n8183#1:10981\n8198#1:10982\n8416#1:10983\n8441#1:10984\n8466#1:10985\n8491#1:10986\n8516#1:10987\n8541#1:10988\n8566#1:10989\n8591#1:10990\n8615#1:10991\n8639#1:10992\n8663#1:10993\n8687#1:10994\n8712#1:10995\n8737#1:10996\n8762#1:10997\n8787#1:10998\n8809#1:10999\n8834#1:11000\n8859#1:11001\n8884#1:11002\n8909#1:11003\n8935#1:11004\n8961#1:11005\n8987#1:11006\n9012#1:11007\n9037#1:11008\n9062#1:11009\n9087#1:11010\n9113#1:11011\n9138#1:11012\n9163#1:11013\n9188#1:11014\n816#1:10746,6\n826#1:10752,6\n836#1:10758,6\n846#1:10764,6\n856#1:10770,6\n866#1:10776,6\n876#1:10782,6\n886#1:10788,6\n4791#1:10807,7\n4811#1:10814,7\n4831#1:10821,7\n4851#1:10828,7\n4872#1:10835,7\n4893#1:10842,7\n4914#1:10849,7\n4935#1:10856,7\n*E\n"})
/* loaded from: classes6.dex */
public class UArraysKt___UArraysKt extends II0xO0 {
    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long I0(long[] component1) {
        IIX0o.x0xO0oo(component1, "$this$component1");
        return OOXIxO0.OOXIXo(component1, 0);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> I00(@OOXIXo byte[] reversed) {
        IIX0o.x0xO0oo(reversed, "$this$reversed");
        if (OO0x0xX.x0xO0oo(reversed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<x0xO> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(OO0x0xX.II0xO0(reversed));
        X0IIOO.oXX0IoI(o0Xo0XII);
        return o0Xo0XII;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> xxIO I000X(int[] minByOrNull, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minByOrNull, "$this$minByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(minByOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(minByOrNull, 0);
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(minByOrNull);
        if (oOIoXOoI == 0) {
            return xxIO.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(xxIO.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int OOXIXo3 = XX0xXo.OOXIXo(minByOrNull, it.nextInt());
            R invoke2 = selector.invoke(xxIO.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) > 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int I00O(int[] first) {
        IIX0o.x0xO0oo(first, "$this$first");
        return xxIO.oOoXoXO(ArraysKt___ArraysKt.IOoxOXXx0(first));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] I00oX(int[] plus, int[] elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        return XX0xXo.X0o0xo(ooOOo0oXI.oIXoXx0(plus, elements));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R I0IIXxxo(byte[] minOf, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(minOf)) {
            R invoke = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOf, it.nextInt())));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final x0xO I0O00OI(byte[] lastOrNull, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(lastOrNull) - 1;
        if (ooOOo0oXI2 < 0) {
            return null;
        }
        while (true) {
            int i = ooOOo0oXI2 - 1;
            byte OOXIXo2 = OO0x0xX.OOXIXo(lastOrNull, ooOOo0oXI2);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                return x0xO.oxoX(OOXIXo2);
            }
            if (i >= 0) {
                ooOOo0oXI2 = i;
            } else {
                return null;
            }
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void I0OO(short[] forEachIndexed, x0xO0oo<? super Integer, ? super OX00O0xII, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEachIndexed, "$this$forEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final OX00O0xII I0OXXIoX(short[] reduceOrNull, x0xO0oo<? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceOrNull, "$this$reduceOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(reduceOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(reduceOrNull)).iterator();
        while (it.hasNext()) {
            OOXIXo2 = operation.invoke(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceOrNull, it.nextInt()))).I0oOIX();
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean I0X0x0oIo(long[] any) {
        IIX0o.x0xO0oo(any, "$this$any");
        return ArraysKt___ArraysKt.oO0(any);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float I0XIOxO(byte[] maxOf, oOoXoXO<? super x0xO, Float> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(maxOf)) {
            float floatValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfDouble")
    @X00IoxXI
    @XO
    public static final double I0XIOxXXX(int[] sumOf, oOoXoXO<? super xxIO, Double> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void I0XOIOO0I(@OOXIXo short[] shuffle, @OOXIXo Random random) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        IIX0o.x0xO0oo(random, "random");
        for (int xX0Ox = ArraysKt___ArraysKt.xX0Ox(shuffle); xX0Ox > 0; xX0Ox--) {
            int nextInt = random.nextInt(xX0Ox + 1);
            short OOXIXo2 = xX0IIXIx0.OOXIXo(shuffle, xX0Ox);
            xX0IIXIx0.IXxxXO(shuffle, xX0Ox, xX0IIXIx0.OOXIXo(shuffle, nextInt));
            xX0IIXIx0.IXxxXO(shuffle, nextInt, OOXIXo2);
        }
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long[] I0XOx(@OOXIXo long[] sortedArrayDescending) {
        IIX0o.x0xO0oo(sortedArrayDescending, "$this$sortedArrayDescending");
        if (OOXIxO0.x0xO0oo(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        long[] X0o0xo2 = OOXIxO0.X0o0xo(copyOf);
        Xxo(X0o0xo2);
        return X0o0xo2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> I0XoOIO(long[] runningFoldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super XI0oooXX, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFoldIndexed, "$this$runningFoldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(runningFoldIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(runningFoldIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(runningFoldIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, XI0oooXX.oxoX(OOXIxO0.OOXIXo(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean I0o(int[] none, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(none, "$this$none");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(none);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(xxIO.oxoX(XX0xXo.OOXIXo(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfULong")
    @X00IoxXI
    @XO
    public static final long I0o0xoIIx(long[] sumOf, oOoXoXO<? super XI0oooXX, XI0oooXX> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] I0oOIX(int[] asIntArray) {
        IIX0o.x0xO0oo(asIntArray, "$this$asIntArray");
        return asIntArray;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean I0oOoX(long[] all, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(all, "$this$all");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(all);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (!predicate.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> I0ox0(byte[] scanIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super x0xO, ? extends R> operation) {
        IIX0o.x0xO0oo(scanIndexed, "$this$scanIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(scanIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(scanIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(scanIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, x0xO.oxoX(OO0x0xX.OOXIXo(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int[] I0x0IOXO(@OOXIXo int[] sortedArrayDescending) {
        IIX0o.x0xO0oo(sortedArrayDescending, "$this$sortedArrayDescending");
        if (XX0xXo.x0xO0oo(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        int[] X0o0xo2 = XX0xXo.X0o0xo(copyOf);
        xxXX0(X0o0xo2);
        return X0o0xo2;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfDouble")
    @X00IoxXI
    @XO
    public static final double I0xI0oI(short[] sumOf, oOoXoXO<? super OX00O0xII, Double> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] I0xX0(short[] copyOf) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        short[] copyOf2 = Arrays.copyOf(copyOf, copyOf.length);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return xX0IIXIx0.X0o0xo(copyOf2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte I0xoOOIx(byte[] reduceRightIndexed, Oox.IXxxXO<? super Integer, ? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceRightIndexed, "$this$reduceRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(reduceRightIndexed);
        if (xxXIIXIxx >= 0) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(reduceRightIndexed, xxXIIXIxx);
            for (int i = xxXIIXIxx - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(Integer.valueOf(i), x0xO.oxoX(OO0x0xX.OOXIXo(reduceRightIndexed, i)), x0xO.oxoX(OOXIXo2)).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void II(@OOXIXo short[] sort) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        if (xX0IIXIx0.ooOOo0oXI(sort) > 1) {
            xoxXI.OOXIXo(sort, 0, xX0IIXIx0.ooOOo0oXI(sort));
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> XI0oooXX II0(long[] maxByOrNull, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxByOrNull, "$this$maxByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(maxByOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(maxByOrNull, 0);
        int IOXI = ArraysKt___ArraysKt.IOXI(maxByOrNull);
        if (IOXI == 0) {
            return XI0oooXX.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(XI0oooXX.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
        while (it.hasNext()) {
            long OOXIXo3 = OOXIxO0.OOXIXo(maxByOrNull, it.nextInt());
            R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) < 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K> Map<K, List<OX00O0xII>> II0OOXOx(short[] groupBy, oOoXoXO<? super OX00O0xII, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(OX00O0xII.oxoX(OOXIXo2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(OX00O0xII.oxoX(OOXIXo2));
        }
        return linkedHashMap;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> II0XIox(@OOXIXo long[] take, int i) {
        IIX0o.x0xO0oo(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= OOXIxO0.ooOOo0oXI(take)) {
                return CollectionsKt___CollectionsKt.oOo0o(OOXIxO0.II0xO0(take));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(XI0oooXX.oxoX(OOXIxO0.OOXIXo(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(take);
            int i2 = 0;
            for (int i3 = 0; i3 < ooOOo0oXI2; i3++) {
                arrayList.add(XI0oooXX.oxoX(OOXIxO0.OOXIXo(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<XI0oooXX, R>> II0XOIoOO(@OOXIXo long[] zip, @OOXIXo Iterable<? extends R> other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(Xo0.oIX0oI(XI0oooXX.oxoX(OOXIxO0.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xxIXOIIO(name = "sumOfUShort")
    @oxxXoxO(version = "1.5")
    public static final int IIIXXXII(@OOXIXo OX00O0xII[] oX00O0xIIArr) {
        IIX0o.x0xO0oo(oX00O0xIIArr, "<this>");
        int i = 0;
        for (OX00O0xII oX00O0xII : oX00O0xIIArr) {
            i = xxIO.oOoXoXO(i + xxIO.oOoXoXO(oX00O0xII.I0oOIX() & OX00O0xII.f29066Oxx0xo));
        }
        return i;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double IIIo0Xo(short[] minOfOrNull, oOoXoXO<? super OX00O0xII, Double> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(minOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R IIIxO(int[] foldRight, R r, x0xO0oo<? super xxIO, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRight, "$this$foldRight");
        IIX0o.x0xO0oo(operation, "operation");
        for (int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(foldRight); oOIoXOoI >= 0; oOIoXOoI--) {
            r = operation.invoke(xxIO.oxoX(XX0xXo.OOXIXo(foldRight, oOIoXOoI)), r);
        }
        return r;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> IIO(int[] scanIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super xxIO, ? extends R> operation) {
        IIX0o.x0xO0oo(scanIndexed, "$this$scanIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(scanIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(scanIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(scanIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, xxIO.oxoX(XX0xXo.OOXIXo(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> IIOIX(byte[] filter, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(filter, "$this$filter");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(filter);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(filter, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(x0xO.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> IIOXx(@OOXIXo long[] slice, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return II0xO0.I0Io(OOXIxO0.X0o0xo(ooOOo0oXI.X0xxXX0(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int IIX0(int[] component4) {
        IIX0o.x0xO0oo(component4, "$this$component4");
        return XX0xXo.OOXIXo(component4, 3);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final XI0oooXX IIXOxIxOo(@OOXIXo long[] lastOrNull) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        if (OOXIxO0.x0xO0oo(lastOrNull)) {
            return null;
        }
        return XI0oooXX.oxoX(OOXIxO0.OOXIXo(lastOrNull, OOXIxO0.ooOOo0oXI(lastOrNull) - 1));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] IIXxoXXox(short[] plus, short[] elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        return xX0IIXIx0.X0o0xo(ooOOo0oXI.xx0o0O(plus, elements));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> IIo0I0X0(long[] zip, R[] other, x0xO0oo<? super XI0oooXX, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(OOXIxO0.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(zip, i)), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short IIoIIxx(short[] reduceIndexed, Oox.IXxxXO<? super Integer, ? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceIndexed, "$this$reduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (!xX0IIXIx0.x0xO0oo(reduceIndexed)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceIndexed, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(reduceIndexed)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceIndexed, nextInt))).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] IIoOIO0(@OOXIXo byte[] sliceArray, @OOXIXo Collection<Integer> indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return OO0x0xX.X0o0xo(ArraysKt___ArraysKt.IOOI(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long IIoX0OoI(long[] getOrElse, int i, oOoXoXO<? super Integer, XI0oooXX> defaultValue) {
        IIX0o.x0xO0oo(getOrElse, "$this$getOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.IOXI(getOrElse)) {
            return OOXIxO0.OOXIXo(getOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).OO();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final XI0oooXX IIx(long[] reduceRightOrNull, x0xO0oo<? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceRightOrNull, "$this$reduceRightOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int IOXI = ArraysKt___ArraysKt.IOXI(reduceRightOrNull);
        if (IOXI < 0) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(reduceRightOrNull, IOXI);
        for (int i = IOXI - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceRightOrNull, i)), XI0oooXX.oxoX(OOXIXo2)).OO();
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte IIxOXoOo0(byte[] component1) {
        IIX0o.x0xO0oo(component1, "$this$component1");
        return OO0x0xX.OOXIXo(component1, 0);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> IIxOxOx0(byte[] takeWhile, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(takeWhile, "$this$takeWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(takeWhile);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(takeWhile, i);
            if (!predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                break;
            }
            arrayList.add(x0xO.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    public static /* synthetic */ int[] IO0XoXxO(int[] copyInto, int[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = XX0xXo.ooOOo0oXI(copyInto);
        }
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.IIxOXoOo0(copyInto, destination, i, i2, i3);
        return destination;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> IO0Xox(@OOXIXo byte[] takeLast, int i) {
        IIX0o.x0xO0oo(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(takeLast);
            if (i >= ooOOo0oXI2) {
                return CollectionsKt___CollectionsKt.oOo0o(OO0x0xX.II0xO0(takeLast));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(x0xO.oxoX(OO0x0xX.OOXIXo(takeLast, ooOOo0oXI2 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = ooOOo0oXI2 - i; i2 < ooOOo0oXI2; i2++) {
                arrayList.add(x0xO.oxoX(OO0x0xX.OOXIXo(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<x0xO> IO0o(byte[] runningReduce, x0xO0oo<? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(runningReduce, "$this$runningReduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(runningReduce)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(runningReduce, 0);
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(runningReduce));
        arrayList.add(x0xO.oxoX(OOXIXo2));
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(runningReduce);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OO0x0xX.OOXIXo(runningReduce, i))).I0oOIX();
            arrayList.add(x0xO.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K> Map<K, List<xxIO>> IO0xX(int[] groupBy, oOoXoXO<? super xxIO, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(xxIO.oxoX(OOXIXo2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(xxIO.oxoX(OOXIXo2));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void IOI(int[] iArr) {
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> IOOOI(short[] runningFold, R r, x0xO0oo<? super R, ? super OX00O0xII, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFold, "$this$runningFold");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(runningFold)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(runningFold) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(runningFold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void IOOXOOOOo(short[] sArr) {
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super x0xO>> C IOOoXo0Ix(byte[] filterIndexedTo, C destination, x0xO0oo<? super Integer, ? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexedTo, "$this$filterIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(filterIndexedTo, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), x0xO.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(x0xO.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OOXIXo
    public static final X0.oOoXoXO IOXOxOII(@OOXIXo long[] indices) {
        IIX0o.x0xO0oo(indices, "$this$indices");
        return ArraysKt___ArraysKt.x0XIoX00(indices);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, M extends Map<? super K, List<xxIO>>> M IOo0(int[] groupByTo, M destination, oOoXoXO<? super xxIO, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(xxIO.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(xxIO.oxoX(OOXIXo2));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short[] IOoXX(short[] onEachIndexed, x0xO0oo<? super Integer, ? super OX00O0xII, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEachIndexed, "$this$onEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] IOoo(long[] copyOf) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        long[] copyOf2 = Arrays.copyOf(copyOf, copyOf.length);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return OOXIxO0.X0o0xo(copyOf2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int IOooo0o(byte[] indexOf, byte b) {
        IIX0o.x0xO0oo(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.O00Ix(indexOf, b);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfInt")
    @X00IoxXI
    @XO
    public static final int IOoxOXXx0(short[] sumOf, oOoXoXO<? super OX00O0xII, Integer> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i += selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i2))).intValue();
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short IOxO(short[] single) {
        IIX0o.x0xO0oo(single, "$this$single");
        return OX00O0xII.oOoXoXO(ArraysKt___ArraysKt.XIXoo(single));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final OX00O0xII IOxoo(@OOXIXo short[] randomOrNull, @OOXIXo Random random) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        IIX0o.x0xO0oo(random, "random");
        if (xX0IIXIx0.x0xO0oo(randomOrNull)) {
            return null;
        }
        return OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(randomOrNull, random.nextInt(xX0IIXIx0.ooOOo0oXI(randomOrNull))));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short[] IOxxIx(@OOXIXo short[] sliceArray, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return xX0IIXIx0.X0o0xo(ArraysKt___ArraysKt.Ox0x0XxO0(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int IX0IO(int[] random) {
        IIX0o.x0xO0oo(random, "$this$random");
        return xoxXoXO(random, Random.Default);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float IX0OOX(int[] minOfOrNull, oOoXoXO<? super xxIO, Float> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(minOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int IXI(short[] lastIndexOf, short s) {
        IIX0o.x0xO0oo(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.xoOxO0(lastIndexOf, s);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short IXIIo(short[] last, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(last, "$this$last");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(last) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                short OOXIXo2 = xX0IIXIx0.OOXIXo(last, ooOOo0oXI2);
                if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                    return OOXIXo2;
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R IXIxx0(short[] foldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super OX00O0xII, ? extends R> operation) {
        IIX0o.x0xO0oo(foldIndexed, "$this$foldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String IXO(@OXOo.oOoXoXO byte[] bArr) {
        String OoIXo2;
        if (bArr == null || (OoIXo2 = CollectionsKt___CollectionsKt.OoIXo(OO0x0xX.II0xO0(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return OoIXo2;
    }

    @xxIXOIIO(name = "minWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final short IXOO0X0(@OOXIXo short[] minWith, @OOXIXo Comparator<? super OX00O0xII> comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!xX0IIXIx0.x0xO0oo(minWith)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(minWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minWith)).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(minWith, it.nextInt());
                if (comparator.compare(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(OOXIXo3)) > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> IXOXoIo0x(short[] takeWhile, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(takeWhile, "$this$takeWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(takeWhile);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(takeWhile, i);
            if (!predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                break;
            }
            arrayList.add(OX00O0xII.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> IXX(int[] flatMap, oOoXoXO<? super xxIO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMap, "$this$flatMap");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(flatMap);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(flatMap, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R IXXIXx00I(long[] foldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super XI0oooXX, ? extends R> operation) {
        IIX0o.x0xO0oo(foldIndexed, "$this$foldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, XI0oooXX.oxoX(OOXIxO0.OOXIXo(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float IXXxo(short[] minOf, oOoXoXO<? super OX00O0xII, Float> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(minOf)) {
            float floatValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final xxIO IXo(int[] lastOrNull, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(lastOrNull) - 1;
        if (ooOOo0oXI2 < 0) {
            return null;
        }
        while (true) {
            int i = ooOOo0oXI2 - 1;
            int OOXIXo2 = XX0xXo.OOXIXo(lastOrNull, ooOOo0oXI2);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                return xxIO.oxoX(OOXIXo2);
            }
            if (i >= 0) {
                ooOOo0oXI2 = i;
            } else {
                return null;
            }
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX IXoIo(long[] findLast, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(findLast, "$this$findLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(findLast) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                long OOXIXo2 = OOXIxO0.OOXIXo(findLast, ooOOo0oXI2);
                if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                    return XI0oooXX.oxoX(OOXIXo2);
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        return null;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> IXoXxxO(@OOXIXo byte[] slice, @OOXIXo Iterable<Integer> indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(x0xO.oxoX(OO0x0xX.OOXIXo(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean IXoxO(byte[] none, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(none, "$this$none");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(none);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short IXx(short[] reduce, x0xO0oo<? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduce, "$this$reduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (!xX0IIXIx0.x0xO0oo(reduce)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(reduce, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(reduce)).iterator();
            while (it.hasNext()) {
                OOXIXo2 = operation.invoke(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduce, it.nextInt()))).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<OX00O0xII> IXx0(short[] runningReduce, x0xO0oo<? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(runningReduce, "$this$runningReduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(runningReduce)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(runningReduce, 0);
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(runningReduce));
        arrayList.add(OX00O0xII.oxoX(OOXIXo2));
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(runningReduce);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(runningReduce, i))).I0oOIX();
            arrayList.add(OX00O0xII.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R IXxOIOO(long[] fold, R r, x0xO0oo<? super R, ? super XI0oooXX, ? extends R> operation) {
        IIX0o.x0xO0oo(fold, "$this$fold");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(fold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, XI0oooXX.oxoX(OOXIxO0.OOXIXo(fold, i)));
        }
        return r;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final x0xO Io0OXxX(@OOXIXo byte[] minWithOrNull, @OOXIXo Comparator<? super x0xO> comparator) {
        IIX0o.x0xO0oo(minWithOrNull, "$this$minWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (OO0x0xX.x0xO0oo(minWithOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(minWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minWithOrNull)).iterator();
        while (it.hasNext()) {
            byte OOXIXo3 = OO0x0xX.OOXIXo(minWithOrNull, it.nextInt());
            if (comparator.compare(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OOXIXo3)) > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> IoI(@OOXIXo int[] sorted) {
        IIX0o.x0xO0oo(sorted, "$this$sorted");
        int[] copyOf = Arrays.copyOf(sorted, sorted.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        int[] X0o0xo2 = XX0xXo.X0o0xo(copyOf);
        oxo0x0(X0o0xo2);
        return II0xO0.oIX0oI(X0o0xo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long IoIOOxIIo(long[] component5) {
        IIX0o.x0xO0oo(component5, "$this$component5");
        return OOXIxO0.OOXIXo(component5, 4);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte[] IoO(byte[] onEachIndexed, x0xO0oo<? super Integer, ? super x0xO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEachIndexed, "$this$onEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), x0xO.oxoX(OO0x0xX.OOXIXo(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] IoOoo(byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<this>");
        return OO0x0xX.X0o0xo(bArr);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final Iterable<xI<OX00O0xII>> IoOoo0XXX(@OOXIXo final short[] withIndex) {
        IIX0o.x0xO0oo(withIndex, "$this$withIndex");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends OX00O0xII>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final Iterator<? extends OX00O0xII> invoke() {
                return xX0IIXIx0.Oo(withIndex);
            }
        });
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> List<R> IoX(int[] flatMapIndexed, x0xO0oo<? super Integer, ? super xxIO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexed, "$this$flatMapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), xxIO.oxoX(XX0xXo.OOXIXo(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<Pair<OX00O0xII, OX00O0xII>> IoXIOXo(@OOXIXo short[] zip, @OOXIXo short[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(xX0IIXIx0.ooOOo0oXI(zip), xX0IIXIx0.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(Xo0.oIX0oI(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(zip, i)), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(other, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] IoXIXo(long[] copyInto, long[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.I0(copyInto, destination, i, i2, i3);
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float IoXIo(int[] minOf, oOoXoXO<? super xxIO, Float> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(minOf)) {
            float floatValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void IoXO0XoX(byte[] bArr) {
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] IoXOxx0o(byte[] plus, byte[] elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        return OO0x0xX.X0o0xo(ooOOo0oXI.IXX(plus, elements));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> Ioo(int[] scan, R r, x0xO0oo<? super R, ? super xxIO, ? extends R> operation) {
        IIX0o.x0xO0oo(scan, "$this$scan");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(scan)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(scan) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(scan);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, xxIO.oxoX(XX0xXo.OOXIXo(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> Ioo0Ooox(short[] zip, R[] other, x0xO0oo<? super OX00O0xII, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(xX0IIXIx0.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(zip, i)), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfLong")
    @X00IoxXI
    @XO
    public static final long IooOI0x(long[] sumOf, oOoXoXO<? super XI0oooXX, Long> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        long j = 0;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            j += selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i))).longValue();
        }
        return j;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double IooOox(int[] sumByDouble, oOoXoXO<? super xxIO, Double> selector) {
        IIX0o.x0xO0oo(sumByDouble, "$this$sumByDouble");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumByDouble);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumByDouble, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R IoooXox0(short[] minOfOrNull, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(minOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int IoxOx(int[] getOrElse, int i, oOoXoXO<? super Integer, xxIO> defaultValue) {
        IIX0o.x0xO0oo(getOrElse, "$this$getOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.oOIoXOoI(getOrElse)) {
            return XX0xXo.OOXIXo(getOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).OO();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short IoxX(short[] last) {
        IIX0o.x0xO0oo(last, "$this$last");
        return OX00O0xII.oOoXoXO(ArraysKt___ArraysKt.XXoo0(last));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> Ioxo0x0x0(@OOXIXo int[] slice, @OOXIXo Iterable<Integer> indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(xxIO.oxoX(XX0xXo.OOXIXo(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "minByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> byte IoxoI0IX(byte[] minBy, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(minBy)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(minBy, 0);
            int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(minBy);
            if (xxXIIXIxx == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(x0xO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(x0xO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] IoxxXOO(@OOXIXo byte[] sortedArrayDescending) {
        IIX0o.x0xO0oo(sortedArrayDescending, "$this$sortedArrayDescending");
        if (OO0x0xX.x0xO0oo(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        byte[] X0o0xo2 = OO0x0xX.X0o0xo(copyOf);
        O0IX(X0o0xo2);
        return X0o0xo2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<XI0oooXX, V> Ioxxx(long[] associateWith, oOoXoXO<? super XI0oooXX, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWith, "$this$associateWith");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(IIXOooo.OxxIIOOXO(OI0.xoIox(OOXIxO0.ooOOo0oXI(associateWith)), 16));
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(associateWith);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(associateWith, i);
            linkedHashMap.put(XI0oooXX.oxoX(OOXIXo2), valueSelector.invoke(XI0oooXX.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int[] Ix(int[] onEach, oOoXoXO<? super xxIO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEach, "$this$onEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(onEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(xxIO.oxoX(XX0xXo.OOXIXo(onEach, i)));
        }
        return onEach;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> Ix0(long[] filterNot, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNot, "$this$filterNot");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(filterNot);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(filterNot, i);
            if (!predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(XI0oooXX.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double Ix00(byte[] minOf, oOoXoXO<? super x0xO, Double> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(minOf)) {
            double doubleValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String Ix00oIoI(@OXOo.oOoXoXO short[] sArr) {
        String OoIXo2;
        if (sArr == null || (OoIXo2 = CollectionsKt___CollectionsKt.OoIXo(xX0IIXIx0.II0xO0(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return OoIXo2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] Ix0XO(byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return OO0x0xX.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final x0xO Ix0Xx(byte[] singleOrNull, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(singleOrNull);
        x0xO x0xo = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(singleOrNull, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                if (z) {
                    return null;
                }
                x0xo = x0xO.oxoX(OOXIXo2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return x0xo;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX Ix0x(long[] firstOrNull, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(firstOrNull);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(firstOrNull, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                return XI0oooXX.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short IxI(short[] first) {
        IIX0o.x0xO0oo(first, "$this$first");
        return OX00O0xII.oOoXoXO(ArraysKt___ArraysKt.OIXI(first));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int IxIX0I(@OXOo.oOoXoXO short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final xxIO IxIXo(int[] reduceOrNull, x0xO0oo<? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceOrNull, "$this$reduceOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(reduceOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(reduceOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(reduceOrNull)).iterator();
        while (it.hasNext()) {
            OOXIXo2 = operation.invoke(xxIO.oxoX(OOXIXo2), xxIO.oxoX(XX0xXo.OOXIXo(reduceOrNull, it.nextInt()))).OO();
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> IxIXoo(@OOXIXo byte[] sortedDescending) {
        IIX0o.x0xO0oo(sortedDescending, "$this$sortedDescending");
        byte[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        byte[] X0o0xo2 = OO0x0xX.X0o0xo(copyOf);
        OX0xI0IO(X0o0xo2);
        return I00(X0o0xo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> IxIo(int[] filterIndexed, x0xO0oo<? super Integer, ? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexed, "$this$filterIndexed");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            int OOXIXo2 = XX0xXo.OOXIXo(filterIndexed, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), xxIO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(xxIO.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void IxO0Oxo(int[] iArr) {
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> IxO0X0(@OOXIXo short[] slice, @OOXIXo Iterable<Integer> indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> IxOIO(short[] mapIndexed, x0xO0oo<? super Integer, ? super OX00O0xII, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexed, "$this$mapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(mapIndexed));
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> IxOOI0Xo(@OOXIXo short[] slice, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return II0xO0.oxoX(xX0IIXIx0.X0o0xo(ooOOo0oXI.oXxOI0oIx(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX IxOXOxO(long[] lastOrNull, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(lastOrNull) - 1;
        if (ooOOo0oXI2 < 0) {
            return null;
        }
        while (true) {
            int i = ooOOo0oXI2 - 1;
            long OOXIXo2 = OOXIxO0.OOXIXo(lastOrNull, ooOOo0oXI2);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                return XI0oooXX.oxoX(OOXIXo2);
            }
            if (i >= 0) {
                ooOOo0oXI2 = i;
            } else {
                return null;
            }
        }
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> IxX00(@OOXIXo int[] dropLast, int i) {
        IIX0o.x0xO0oo(dropLast, "$this$dropLast");
        if (i >= 0) {
            return oOIxIIoI(dropLast, IIXOooo.OxxIIOOXO(XX0xXo.ooOOo0oXI(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double IxoOxx(byte[] maxOfOrNull, oOoXoXO<? super x0xO, Double> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R IxoXXoXo(int[] minOfOrNull, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(minOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfUInt")
    @X00IoxXI
    @XO
    public static final int Ixox0x(short[] sumOf, oOoXoXO<? super OX00O0xII, xxIO> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final xxIO IxxOI(int[] reduceIndexedOrNull, Oox.IXxxXO<? super Integer, ? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(reduceIndexedOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(reduceIndexedOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), xxIO.oxoX(OOXIXo2), xxIO.oxoX(XX0xXo.OOXIXo(reduceIndexedOrNull, nextInt))).OO();
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void IxxXI0o(@OOXIXo short[] sort, int i, int i2) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, xX0IIXIx0.ooOOo0oXI(sort));
        xoxXI.OOXIXo(sort, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short O0(short[] component4) {
        IIX0o.x0xO0oo(component4, "$this$component4");
        return xX0IIXIx0.OOXIXo(component4, 3);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> O00(@OOXIXo int[] drop, int i) {
        IIX0o.x0xO0oo(drop, "$this$drop");
        if (i >= 0) {
            return O0XX0IX(drop, IIXOooo.OxxIIOOXO(XX0xXo.ooOOo0oXI(drop) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super x0xO, ? super V>> M O00XxXI(byte[] associateWithTo, M destination, oOoXoXO<? super x0xO, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWithTo, "$this$associateWithTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(associateWithTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(associateWithTo, i);
            destination.put(x0xO.oxoX(OOXIXo2), valueSelector.invoke(x0xO.oxoX(OOXIXo2)));
        }
        return destination;
    }

    public static /* synthetic */ void O00oxX0(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = xX0IIXIx0.ooOOo0oXI(sArr);
        }
        IxxXI0o(sArr, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void O0IX(@OOXIXo byte[] sortDescending) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        if (OO0x0xX.ooOOo0oXI(sortDescending) > 1) {
            OX0xI0IO(sortDescending);
            ArraysKt___ArraysKt.ooIxXoX(sortDescending);
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte O0IoXXOx(byte[] last, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(last, "$this$last");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(last) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                byte OOXIXo2 = OO0x0xX.OOXIXo(last, ooOOo0oXI2);
                if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                    return OOXIXo2;
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String O0IxXx(@OXOo.oOoXoXO long[] jArr) {
        String OoIXo2;
        if (jArr == null || (OoIXo2 = CollectionsKt___CollectionsKt.OoIXo(OOXIxO0.II0xO0(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return OoIXo2;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R, C extends Collection<? super R>> C O0O0Io00X(long[] flatMapIndexedTo, C destination, x0xO0oo<? super Integer, ? super XI0oooXX, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexedTo, "$this$flatMapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xxIXOIIO(name = "sumOfULong")
    @oxxXoxO(version = "1.5")
    public static final long O0OO(@OOXIXo XI0oooXX[] xI0oooXXArr) {
        IIX0o.x0xO0oo(xI0oooXXArr, "<this>");
        long j = 0;
        for (XI0oooXX xI0oooXX : xI0oooXXArr) {
            j = XI0oooXX.oOoXoXO(j + xI0oooXX.OO());
        }
        return j;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short[] O0OO0Ox(@OOXIXo short[] sliceArray, @OOXIXo Collection<Integer> indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return xX0IIXIx0.X0o0xo(ArraysKt___ArraysKt.IIOOI(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super x0xO>> C O0OOX0IIx(byte[] filterNotTo, C destination, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNotTo, "$this$filterNotTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(filterNotTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(filterNotTo, i);
            if (!predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(x0xO.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @xxIXOIIO(name = "maxWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final long O0OOoIox(@OOXIXo long[] maxWith, @OOXIXo Comparator<? super XI0oooXX> comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!OOXIxO0.x0xO0oo(maxWith)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(maxWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxWith)).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(maxWith, it.nextInt());
                if (comparator.compare(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIXo3)) < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> O0OoXI(int[] map, oOoXoXO<? super xxIO, ? extends R> transform) {
        IIX0o.x0xO0oo(map, "$this$map");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(map));
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(map);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            arrayList.add(transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(map, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short O0X(short[] component3) {
        IIX0o.x0xO0oo(component3, "$this$component3");
        return xX0IIXIx0.OOXIXo(component3, 2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> O0XI0(@OOXIXo long[] sorted) {
        IIX0o.x0xO0oo(sorted, "$this$sorted");
        long[] copyOf = Arrays.copyOf(sorted, sorted.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        long[] X0o0xo2 = OOXIxO0.X0o0xo(copyOf);
        xX0(X0o0xo2);
        return II0xO0.I0Io(X0o0xo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> O0XI00X0o(@OOXIXo short[] take, int i) {
        IIX0o.x0xO0oo(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= xX0IIXIx0.ooOOo0oXI(take)) {
                return CollectionsKt___CollectionsKt.oOo0o(xX0IIXIx0.II0xO0(take));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(take);
            int i2 = 0;
            for (int i3 = 0; i3 < ooOOo0oXI2; i3++) {
                arrayList.add(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long[] O0XOI(@OOXIXo long[] sliceArray, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return OOXIxO0.X0o0xo(ArraysKt___ArraysKt.xOIXoOX0X(sliceArray, indices));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> O0XX0IX(@OOXIXo int[] takeLast, int i) {
        IIX0o.x0xO0oo(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(takeLast);
            if (i >= ooOOo0oXI2) {
                return CollectionsKt___CollectionsKt.oOo0o(XX0xXo.II0xO0(takeLast));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(xxIO.oxoX(XX0xXo.OOXIXo(takeLast, ooOOo0oXI2 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = ooOOo0oXI2 - i; i2 < ooOOo0oXI2; i2++) {
                arrayList.add(xxIO.oxoX(XX0xXo.OOXIXo(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long O0Xo(@OOXIXo long[] random, @OOXIXo Random random2) {
        IIX0o.x0xO0oo(random, "$this$random");
        IIX0o.x0xO0oo(random2, "random");
        if (!OOXIxO0.x0xO0oo(random)) {
            return OOXIxO0.OOXIXo(random, random2.nextInt(OOXIxO0.ooOOo0oXI(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] O0Xx(byte[] asByteArray) {
        IIX0o.x0xO0oo(asByteArray, "$this$asByteArray");
        return asByteArray;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int O0o(int[] reduce, x0xO0oo<? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduce, "$this$reduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (!XX0xXo.x0xO0oo(reduce)) {
            int OOXIXo2 = XX0xXo.OOXIXo(reduce, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(reduce)).iterator();
            while (it.hasNext()) {
                OOXIXo2 = operation.invoke(xxIO.oxoX(OOXIXo2), xxIO.oxoX(XX0xXo.OOXIXo(reduce, it.nextInt()))).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> O0o0(byte[] flatMap, oOoXoXO<? super x0xO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMap, "$this$flatMap");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(flatMap);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(flatMap, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "maxByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> short O0o000XOX(short[] maxBy, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(maxBy)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(maxBy, 0);
            int xX0Ox = ArraysKt___ArraysKt.xX0Ox(maxBy);
            if (xX0Ox == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(OX00O0xII.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(OX00O0xII.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> O0o0OI00(@OOXIXo int[] reversed) {
        IIX0o.x0xO0oo(reversed, "$this$reversed");
        if (XX0xXo.x0xO0oo(reversed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<xxIO> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(XX0xXo.II0xO0(reversed));
        X0IIOO.oXX0IoI(o0Xo0XII);
        return o0Xo0XII;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long[] O0oXOX0XX(long[] onEachIndexed, x0xO0oo<? super Integer, ? super XI0oooXX, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEachIndexed, "$this$onEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX O0x(long[] find, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(find, "$this$find");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(find);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(find, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                return XI0oooXX.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R O0x0XXxI(long[] maxOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWithOrNull, "$this$maxOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(maxOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R O0xO0(byte[] foldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super x0xO, ? extends R> operation) {
        IIX0o.x0xO0oo(foldIndexed, "$this$foldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, x0xO.oxoX(OO0x0xX.OOXIXo(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte O0xOXxxx(byte[] random) {
        IIX0o.x0xO0oo(random, "$this$random");
        return XXXoOII(random, Random.Default);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<Pair<x0xO, x0xO>> O0xOx0(@OOXIXo byte[] zip, @OOXIXo byte[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(OO0x0xX.ooOOo0oXI(zip), OO0x0xX.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(Xo0.oIX0oI(x0xO.oxoX(OO0x0xX.OOXIXo(zip, i)), x0xO.oxoX(OO0x0xX.OOXIXo(other, i))));
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> O0xxXxI(@OOXIXo byte[] dropLast, int i) {
        IIX0o.x0xO0oo(dropLast, "$this$dropLast");
        if (i >= 0) {
            return XxOXxXo(dropLast, IIXOooo.OxxIIOOXO(OO0x0xX.ooOOo0oXI(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R OI(short[] minOfWith, Comparator<? super R> comparator, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWith, "$this$minOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(minOfWith)) {
            Object obj = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R OI0IXox(int[] foldRightIndexed, R r, Oox.IXxxXO<? super Integer, ? super xxIO, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRightIndexed, "$this$foldRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        for (int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(foldRightIndexed); oOIoXOoI >= 0; oOIoXOoI--) {
            r = operation.invoke(Integer.valueOf(oOIoXOoI), xxIO.oxoX(XX0xXo.OOXIXo(foldRightIndexed, oOIoXOoI)), r);
        }
        return r;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> OI0OIIo(long[] takeLastWhile, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(takeLastWhile, "$this$takeLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int IOXI = ArraysKt___ArraysKt.IOXI(takeLastWhile); -1 < IOXI; IOXI--) {
            if (!predicate.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(takeLastWhile, IOXI))).booleanValue()) {
                return xOOxIO(takeLastWhile, IOXI + 1);
            }
        }
        return CollectionsKt___CollectionsKt.oOo0o(OOXIxO0.II0xO0(takeLastWhile));
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double OI0xX(long[] sumByDouble, oOoXoXO<? super XI0oooXX, Double> selector) {
        IIX0o.x0xO0oo(sumByDouble, "$this$sumByDouble");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumByDouble);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumByDouble, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OIII0O(long[] indexOfLast, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfLast, "$this$indexOfLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (predicate.invoke(XI0oooXX.oxoX(XI0oooXX.oOoXoXO(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C OIIXOxo(long[] flatMapTo, C destination, oOoXoXO<? super XI0oooXX, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapTo, "$this$flatMapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(flatMapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(destination, transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(flatMapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final OX00O0xII OIIoIo(short[] reduceRightIndexedOrNull, Oox.IXxxXO<? super Integer, ? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(reduceRightIndexedOrNull);
        if (xX0Ox < 0) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceRightIndexedOrNull, xX0Ox);
        for (int i = xX0Ox - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceRightIndexedOrNull, i)), OX00O0xII.oxoX(OOXIXo2)).I0oOIX();
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> OIIxOxx(@OOXIXo short[] reversed) {
        IIX0o.x0xO0oo(reversed, "$this$reversed");
        if (xX0IIXIx0.x0xO0oo(reversed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<OX00O0xII> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(xX0IIXIx0.II0xO0(reversed));
        X0IIOO.oXX0IoI(o0Xo0XII);
        return o0Xo0XII;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OIOIxOO(@OOXIXo int[] sort, int i, int i2) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, XX0xXo.ooOOo0oXI(sort));
        xoxXI.oOoXoXO(sort, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static boolean OIOoIIOIx(@OXOo.oOoXoXO long[] jArr, @OXOo.oOoXoXO long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float OIOxOX(long[] minOf, oOoXoXO<? super XI0oooXX, Float> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(minOf)) {
            float floatValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfUInt")
    @X00IoxXI
    @XO
    public static final int OIXI(byte[] sumOf, oOoXoXO<? super x0xO, xxIO> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @xxIXOIIO(name = "minOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final long OIXO(@OOXIXo long[] min) {
        int compare;
        IIX0o.x0xO0oo(min, "$this$min");
        if (!OOXIxO0.x0xO0oo(min)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(min, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(min)).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(min, it.nextInt());
                compare = Long.compare(OOXIXo2 ^ Long.MIN_VALUE, OOXIXo3 ^ Long.MIN_VALUE);
                if (compare > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long OIXXIXxX(long[] single, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(single, "$this$single");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(single);
        XI0oooXX xI0oooXX = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(single, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                if (!z) {
                    xI0oooXX = XI0oooXX.oxoX(OOXIXo2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return xI0oooXX.OO();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfULong")
    @X00IoxXI
    @XO
    public static final long OIo(short[] sumOf, oOoXoXO<? super OX00O0xII, XI0oooXX> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double OIo0o(byte[] sumByDouble, oOoXoXO<? super x0xO, Double> selector) {
        IIX0o.x0xO0oo(sumByDouble, "$this$sumByDouble");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumByDouble);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumByDouble, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final xxIO OIoxIx(@OOXIXo int[] firstOrNull) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        if (XX0xXo.x0xO0oo(firstOrNull)) {
            return null;
        }
        return xxIO.oxoX(XX0xXo.OOXIXo(firstOrNull, 0));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OIx(@OOXIXo short[] shuffle) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        I0XOIOO0I(shuffle, Random.Default);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OIx00oxx(short[] count, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(count, "$this$count");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(count);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            if (predicate.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final xxIO OIx0xoOo(@OOXIXo int[] getOrNull, int i) {
        IIX0o.x0xO0oo(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.oOIoXOoI(getOrNull)) {
            return xxIO.oxoX(XX0xXo.OOXIXo(getOrNull, i));
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> OIxI0O(long[] flatMap, oOoXoXO<? super XI0oooXX, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMap, "$this$flatMap");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(flatMap);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(flatMap, i))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M OIxOIX0II(short[] groupByTo, M destination, oOoXoXO<? super OX00O0xII, ? extends K> keySelector, oOoXoXO<? super OX00O0xII, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(OX00O0xII.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(OX00O0xII.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII OIxOX(short[] find, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(find, "$this$find");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(find);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(find, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                return OX00O0xII.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfDouble")
    @X00IoxXI
    @XO
    public static final double OIxooI0(long[] sumOf, oOoXoXO<? super XI0oooXX, Double> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super OX00O0xII>> C OIxx0I0(short[] filterTo, C destination, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(filterTo, "$this$filterTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(filterTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(filterTo, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(OX00O0xII.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] OO(short[] asShortArray) {
        IIX0o.x0xO0oo(asShortArray, "$this$asShortArray");
        return asShortArray;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OO0(long[] count, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(count, "$this$count");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(count);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            if (predicate.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] OO0x0xX(short[] sArr) {
        IIX0o.x0xO0oo(sArr, "<this>");
        return xX0IIXIx0.X0o0xo(sArr);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final OX00O0xII OOI(@OOXIXo short[] minOrNull) {
        IIX0o.x0xO0oo(minOrNull, "$this$minOrNull");
        if (xX0IIXIx0.x0xO0oo(minOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(minOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOrNull)).iterator();
        while (it.hasNext()) {
            short OOXIXo3 = xX0IIXIx0.OOXIXo(minOrNull, it.nextInt());
            if (IIX0o.oI0IIXIo(OOXIXo2 & OX00O0xII.f29066Oxx0xo, 65535 & OOXIXo3) > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long OOI00oxoO(long[] random) {
        IIX0o.x0xO0oo(random, "$this$random");
        return O0Xo(random, Random.Default);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short[] OOIXoIX(@OOXIXo short[] sortedArray) {
        IIX0o.x0xO0oo(sortedArray, "$this$sortedArray");
        if (xX0IIXIx0.x0xO0oo(sortedArray)) {
            return sortedArray;
        }
        short[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        short[] X0o0xo2 = xX0IIXIx0.X0o0xo(copyOf);
        II(X0o0xo2);
        return X0o0xo2;
    }

    public static /* synthetic */ void OOIXx0x(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = XX0xXo.ooOOo0oXI(iArr);
        }
        XooIO0oo0(iArr, i, i2, i3);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> OOOI(int[] dropWhile, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(dropWhile, "$this$dropWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(dropWhile);
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(dropWhile, i);
            if (z) {
                arrayList.add(xxIO.oxoX(OOXIXo2));
            } else if (!predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(xxIO.oxoX(OOXIXo2));
                z = true;
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfDouble")
    @X00IoxXI
    @XO
    public static final double OOOO(byte[] sumOf, oOoXoXO<? super x0xO, Double> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i))).doubleValue();
        }
        return d;
    }

    public static final int OOOox(@OOXIXo byte[] lastIndex) {
        IIX0o.x0xO0oo(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.xxXIIXIxx(lastIndex);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final OX00O0xII OOOxXxoO(@OOXIXo short[] maxWithOrNull, @OOXIXo Comparator<? super OX00O0xII> comparator) {
        IIX0o.x0xO0oo(maxWithOrNull, "$this$maxWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (xX0IIXIx0.x0xO0oo(maxWithOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(maxWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            short OOXIXo3 = xX0IIXIx0.OOXIXo(maxWithOrNull, it.nextInt());
            if (comparator.compare(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(OOXIXo3)) < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @xxIXOIIO(name = "maxOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final long OOX0x(@OOXIXo long[] max) {
        int compare;
        IIX0o.x0xO0oo(max, "$this$max");
        if (!OOXIxO0.x0xO0oo(max)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(max, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(max)).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(max, it.nextInt());
                compare = Long.compare(OOXIXo2 ^ Long.MIN_VALUE, OOXIXo3 ^ Long.MIN_VALUE);
                if (compare < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OOXIxO0(int[] component1) {
        IIX0o.x0xO0oo(component1, "$this$component1");
        return XX0xXo.OOXIXo(component1, 0);
    }

    public static /* synthetic */ void OOXo0xOXx(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = XX0xXo.ooOOo0oXI(iArr);
        }
        OIOIxOO(iArr, i, i2);
    }

    @xxIXOIIO(name = "maxOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final int OOo(@OOXIXo int[] max) {
        int compare;
        IIX0o.x0xO0oo(max, "$this$max");
        if (!XX0xXo.x0xO0oo(max)) {
            int OOXIXo2 = XX0xXo.OOXIXo(max, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(max)).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(max, it.nextInt());
                compare = Integer.compare(OOXIXo2 ^ Integer.MIN_VALUE, OOXIXo3 ^ Integer.MIN_VALUE);
                if (compare < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OOoOoO0o(int[] last, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(last, "$this$last");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(last) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                int OOXIXo2 = XX0xXo.OOXIXo(last, ooOOo0oXI2);
                if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                    return OOXIXo2;
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfULong")
    @X00IoxXI
    @XO
    public static final long OOox(byte[] sumOf, oOoXoXO<? super x0xO, XI0oooXX> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII OOxOI(short[] elementAtOrNull, int i) {
        IIX0o.x0xO0oo(elementAtOrNull, "$this$elementAtOrNull");
        return oxOIoIx(elementAtOrNull, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final XI0oooXX OOxOOxIO(@OOXIXo long[] firstOrNull) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        if (OOXIxO0.x0xO0oo(firstOrNull)) {
            return null;
        }
        return XI0oooXX.oxoX(OOXIxO0.OOXIXo(firstOrNull, 0));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final OX00O0xII OOxOXI0(@OOXIXo short[] minWithOrNull, @OOXIXo Comparator<? super OX00O0xII> comparator) {
        IIX0o.x0xO0oo(minWithOrNull, "$this$minWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (xX0IIXIx0.x0xO0oo(minWithOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(minWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minWithOrNull)).iterator();
        while (it.hasNext()) {
            short OOXIXo3 = xX0IIXIx0.OOXIXo(minWithOrNull, it.nextInt());
            if (comparator.compare(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(OOXIXo3)) > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> OOxXXO(byte[] zip, Iterable<? extends R> other, x0xO0oo<? super x0xO, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final xxIO OOxXo(@OOXIXo int[] singleOrNull) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        if (XX0xXo.ooOOo0oXI(singleOrNull) == 1) {
            return xxIO.oxoX(XX0xXo.OOXIXo(singleOrNull, 0));
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] OX(byte[] copyOfRange, int i, int i2) {
        byte[] copyOfRange2;
        IIX0o.x0xO0oo(copyOfRange, "$this$copyOfRange");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            copyOfRange2 = ooOOo0oXI.xxOXOOoIX(copyOfRange, i, i2);
        } else if (i2 <= copyOfRange.length) {
            copyOfRange2 = Arrays.copyOfRange(copyOfRange, i, i2);
            IIX0o.ooOOo0oXI(copyOfRange2);
        } else {
            throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + copyOfRange.length);
        }
        return OO0x0xX.X0o0xo(copyOfRange2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte OX00O0xII(byte[] component2) {
        IIX0o.x0xO0oo(component2, "$this$component2");
        return OO0x0xX.OOXIXo(component2, 1);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OX00o0X(int[] indexOf, int i) {
        IIX0o.x0xO0oo(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.XoOoxI0X(indexOf, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void OX0xI0IO(@OOXIXo byte[] sort) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        if (OO0x0xX.ooOOo0oXI(sort) > 1) {
            xoxXI.xoIox(sort, 0, OO0x0xX.ooOOo0oXI(sort));
        }
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double OXI(long[] minOfOrNull, oOoXoXO<? super XI0oooXX, Double> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(minOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<x0xO> OXIIo0(byte[] runningReduceIndexed, Oox.IXxxXO<? super Integer, ? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(runningReduceIndexed, "$this$runningReduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(runningReduceIndexed));
        arrayList.add(x0xO.oxoX(OOXIXo2));
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(runningReduceIndexed);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), x0xO.oxoX(OOXIXo2), x0xO.oxoX(OO0x0xX.OOXIXo(runningReduceIndexed, i))).I0oOIX();
            arrayList.add(x0xO.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final xxIO OXIOoo0X0(int[] findLast, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(findLast, "$this$findLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(findLast) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                int OOXIXo2 = XX0xXo.OOXIXo(findLast, ooOOo0oXI2);
                if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                    return xxIO.oxoX(OOXIXo2);
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        return null;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final XI0oooXX OXO0(@OOXIXo long[] randomOrNull, @OOXIXo Random random) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        IIX0o.x0xO0oo(random, "random");
        if (OOXIxO0.x0xO0oo(randomOrNull)) {
            return null;
        }
        return XI0oooXX.oxoX(OOXIxO0.OOXIXo(randomOrNull, random.nextInt(OOXIxO0.ooOOo0oXI(randomOrNull))));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short OXO0oX(short[] random) {
        IIX0o.x0xO0oo(random, "$this$random");
        return X0xX(random, Random.Default);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int OXOXxxOOO(long[] sumBy, oOoXoXO<? super XI0oooXX, xxIO> selector) {
        IIX0o.x0xO0oo(sumBy, "$this$sumBy");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumBy);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i = xxIO.oOoXoXO(i + selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumBy, i2))).OO());
        }
        return i;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final xxIO OXOo(@OOXIXo int[] lastOrNull) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        if (XX0xXo.x0xO0oo(lastOrNull)) {
            return null;
        }
        return xxIO.oxoX(XX0xXo.OOXIXo(lastOrNull, XX0xXo.ooOOo0oXI(lastOrNull) - 1));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int[] OXXo0(@OOXIXo int[] sortedArray) {
        IIX0o.x0xO0oo(sortedArray, "$this$sortedArray");
        if (XX0xXo.x0xO0oo(sortedArray)) {
            return sortedArray;
        }
        int[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        int[] X0o0xo2 = XX0xXo.X0o0xo(copyOf);
        oxo0x0(X0o0xo2);
        return X0o0xo2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX OXXoIoXI(long[] elementAtOrNull, int i) {
        IIX0o.x0xO0oo(elementAtOrNull, "$this$elementAtOrNull");
        return XXO0(elementAtOrNull, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R OXXxXoO(int[] minOf, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(minOf)) {
            R invoke = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOf, it.nextInt())));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R OXoIOx(short[] minOf, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(minOf)) {
            R invoke = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOf, it.nextInt())));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @xxIXOIIO(name = "maxWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final byte OXoIXx(@OOXIXo byte[] maxWith, @OOXIXo Comparator<? super x0xO> comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!OO0x0xX.x0xO0oo(maxWith)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(maxWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxWith)).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(maxWith, it.nextInt());
                if (comparator.compare(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OOXIXo3)) < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final x0xO OXooXo(byte[] firstOrNull, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(firstOrNull);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(firstOrNull, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                return x0xO.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final XI0oooXX OXxXoOx(long[] reduceRightIndexedOrNull, Oox.IXxxXO<? super Integer, ? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int IOXI = ArraysKt___ArraysKt.IOXI(reduceRightIndexedOrNull);
        if (IOXI < 0) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(reduceRightIndexedOrNull, IOXI);
        for (int i = IOXI - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceRightIndexedOrNull, i)), XI0oooXX.oxoX(OOXIXo2)).OO();
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K> Map<K, List<x0xO>> OXxx0OO(byte[] groupBy, oOoXoXO<? super x0xO, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(x0xO.oxoX(OOXIXo2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(x0xO.oxoX(OOXIXo2));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int Oo0IXI0(int[] lastIndexOf, int i) {
        IIX0o.x0xO0oo(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.I0IoX00I(lastIndexOf, i);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C Oo0xX(long[] mapIndexedTo, C destination, x0xO0oo<? super Integer, ? super XI0oooXX, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexedTo, "$this$mapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            destination.add(transform.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    public static final int OoI0OO(@OOXIXo int[] lastIndex) {
        IIX0o.x0xO0oo(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.oOIoXOoI(lastIndex);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R, C extends Collection<? super R>> C OoIXo(int[] flatMapIndexedTo, C destination, x0xO0oo<? super Integer, ? super xxIO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexedTo, "$this$flatMapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), xxIO.oxoX(XX0xXo.OOXIXo(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean OoIoI0(byte[] none) {
        IIX0o.x0xO0oo(none, "$this$none");
        return OO0x0xX.x0xO0oo(none);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static boolean OoO(@OXOo.oOoXoXO byte[] bArr, @OXOo.oOoXoXO byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long OoOoXO0(long[] last, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(last, "$this$last");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(last) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                long OOXIXo2 = OOXIxO0.OOXIXo(last, ooOOo0oXI2);
                if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                    return OOXIXo2;
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R OoOoxX0xo(long[] maxOfOrNull, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OooI(int[] count, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(count, "$this$count");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(count);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            if (predicate.invoke(xxIO.oxoX(XX0xXo.OOXIXo(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super x0xO>> C OooO0XOx(byte[] filterTo, C destination, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterTo, "$this$filterTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(filterTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(filterTo, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(x0xO.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfUInt")
    @X00IoxXI
    @XO
    public static final int OooOoX(long[] sumOf, oOoXoXO<? super XI0oooXX, xxIO> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final x0xO OooXX0(byte[] reduceRightIndexedOrNull, Oox.IXxxXO<? super Integer, ? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(reduceRightIndexedOrNull);
        if (xxXIIXIxx < 0) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(reduceRightIndexedOrNull, xxXIIXIxx);
        for (int i = xxXIIXIxx - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), x0xO.oxoX(OO0x0xX.OOXIXo(reduceRightIndexedOrNull, i)), x0xO.oxoX(OOXIXo2)).I0oOIX();
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int[] OoooxII(int[] onEachIndexed, x0xO0oo<? super Integer, ? super xxIO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEachIndexed, "$this$onEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(onEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), xxIO.oxoX(XX0xXo.OOXIXo(onEachIndexed, i)));
            i++;
            i2++;
        }
        return onEachIndexed;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R Oox(long[] foldRightIndexed, R r, Oox.IXxxXO<? super Integer, ? super XI0oooXX, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRightIndexed, "$this$foldRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        for (int IOXI = ArraysKt___ArraysKt.IOXI(foldRightIndexed); IOXI >= 0; IOXI--) {
            r = operation.invoke(Integer.valueOf(IOXI), XI0oooXX.oxoX(OOXIxO0.OOXIXo(foldRightIndexed, IOXI)), r);
        }
        return r;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> Oox0oOO0(@OOXIXo int[] slice, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return II0xO0.oIX0oI(XX0xXo.X0o0xo(ooOOo0oXI.X0xII0I(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OoxOxII(long[] indexOfFirst, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfFirst, "$this$indexOfFirst");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(XI0oooXX.oxoX(XI0oooXX.oOoXoXO(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C OoxxX(short[] mapIndexedTo, C destination, x0xO0oo<? super Integer, ? super OX00O0xII, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexedTo, "$this$mapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            destination.add(transform.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void Ooxxx(@OOXIXo long[] shuffle, @OOXIXo Random random) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        IIX0o.x0xO0oo(random, "random");
        for (int IOXI = ArraysKt___ArraysKt.IOXI(shuffle); IOXI > 0; IOXI--) {
            int nextInt = random.nextInt(IOXI + 1);
            long OOXIXo2 = OOXIxO0.OOXIXo(shuffle, IOXI);
            OOXIxO0.IXxxXO(shuffle, IOXI, OOXIxO0.OOXIXo(shuffle, nextInt));
            OOXIxO0.IXxxXO(shuffle, nextInt, OOXIXo2);
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> Ox(byte[] map, oOoXoXO<? super x0xO, ? extends R> transform) {
        IIX0o.x0xO0oo(map, "$this$map");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(map));
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(map);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            arrayList.add(transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(map, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double Ox0(short[] minOf, oOoXoXO<? super OX00O0xII, Double> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(minOf)) {
            double doubleValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M Ox00XOXoo(int[] groupByTo, M destination, oOoXoXO<? super xxIO, ? extends K> keySelector, oOoXoXO<? super xxIO, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(xxIO.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(xxIO.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long Ox0O(long[] component4) {
        IIX0o.x0xO0oo(component4, "$this$component4");
        return OOXIxO0.OOXIXo(component4, 3);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long Ox0XO(long[] last) {
        IIX0o.x0xO0oo(last, "$this$last");
        return XI0oooXX.oOoXoXO(ArraysKt___ArraysKt.x0x000(last));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> x0xO OxI0(byte[] minByOrNull, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minByOrNull, "$this$minByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(minByOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(minByOrNull, 0);
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(minByOrNull);
        if (xxXIIXIxx == 0) {
            return x0xO.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(x0xO.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            byte OOXIXo3 = OO0x0xX.OOXIXo(minByOrNull, it.nextInt());
            R invoke2 = selector.invoke(x0xO.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) > 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] OxI0000XO(byte[] toByteArray) {
        IIX0o.x0xO0oo(toByteArray, "$this$toByteArray");
        byte[] copyOf = Arrays.copyOf(toByteArray, toByteArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> OxII(int[] zip, R[] other, x0xO0oo<? super xxIO, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(XX0xXo.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(zip, i)), other[i]));
        }
        return arrayList;
    }

    @xxIXOIIO(name = "minOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final short OxIXxXXI0(@OOXIXo short[] min) {
        IIX0o.x0xO0oo(min, "$this$min");
        if (!xX0IIXIx0.x0xO0oo(min)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(min, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(min)).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(min, it.nextInt());
                if (IIX0o.oI0IIXIo(OOXIXo2 & OX00O0xII.f29066Oxx0xo, 65535 & OOXIXo3) > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    public static final int OxIxx0(@OOXIXo short[] lastIndex) {
        IIX0o.x0xO0oo(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.xX0Ox(lastIndex);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OxO(int[] elementAtOrElse, int i, oOoXoXO<? super Integer, xxIO> defaultValue) {
        IIX0o.x0xO0oo(elementAtOrElse, "$this$elementAtOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.oOIoXOoI(elementAtOrElse)) {
            return XX0xXo.OOXIXo(elementAtOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).OO();
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double OxX(short[] sumByDouble, oOoXoXO<? super OX00O0xII, Double> selector) {
        IIX0o.x0xO0oo(sumByDouble, "$this$sumByDouble");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumByDouble);
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            d += selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumByDouble, i))).doubleValue();
        }
        return d;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short[] OxXIoIX(short[] onEach, oOoXoXO<? super OX00O0xII, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEach, "$this$onEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(onEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(onEach, i)));
        }
        return onEach;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int OxXIoIxIo(int[] reduceIndexed, Oox.IXxxXO<? super Integer, ? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceIndexed, "$this$reduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (!XX0xXo.x0xO0oo(reduceIndexed)) {
            int OOXIXo2 = XX0xXo.OOXIXo(reduceIndexed, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(reduceIndexed)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), xxIO.oxoX(OOXIXo2), xxIO.oxoX(XX0xXo.OOXIXo(reduceIndexed, nextInt))).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final xxIO OxXXx0OX(@OOXIXo int[] maxOrNull) {
        int compare;
        IIX0o.x0xO0oo(maxOrNull, "$this$maxOrNull");
        if (XX0xXo.x0xO0oo(maxOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(maxOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOrNull)).iterator();
        while (it.hasNext()) {
            int OOXIXo3 = XX0xXo.OOXIXo(maxOrNull, it.nextInt());
            compare = Integer.compare(OOXIXo2 ^ Integer.MIN_VALUE, OOXIXo3 ^ Integer.MIN_VALUE);
            if (compare < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> OxXXx0X(long[] dropWhile, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(dropWhile, "$this$dropWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(dropWhile);
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(dropWhile, i);
            if (z) {
                arrayList.add(XI0oooXX.oxoX(OOXIXo2));
            } else if (!predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(XI0oooXX.oxoX(OOXIXo2));
                z = true;
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> Oxo00O(byte[] filterNot, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNot, "$this$filterNot");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(filterNot);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(filterNot, i);
            if (!predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(x0xO.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] Oxx(long[] copyOfRange, int i, int i2) {
        long[] copyOfRange2;
        IIX0o.x0xO0oo(copyOfRange, "$this$copyOfRange");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            copyOfRange2 = ooOOo0oXI.X0xxXX0(copyOfRange, i, i2);
        } else if (i2 <= copyOfRange.length) {
            copyOfRange2 = Arrays.copyOfRange(copyOfRange, i, i2);
            IIX0o.ooOOo0oXI(copyOfRange2);
        } else {
            throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + copyOfRange.length);
        }
        return OOXIxO0.X0o0xo(copyOfRange2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<x0xO, R>> Oxx0XxOI0(@OOXIXo byte[] zip, @OOXIXo Iterable<? extends R> other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(Xo0.oIX0oI(x0xO.oxoX(OO0x0xX.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R OxxIXIX(short[] maxOfWith, Comparator<? super R> comparator, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWith, "$this$maxOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(maxOfWith)) {
            Object obj = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int Oxxo(short[] indexOfFirst, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfFirst, "$this$indexOfFirst");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(OX00O0xII.oxoX(OX00O0xII.oOoXoXO(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void X0(long[] forEachIndexed, x0xO0oo<? super Integer, ? super XI0oooXX, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEachIndexed, "$this$forEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void X000ooOxx(@OOXIXo long[] sortDescending, int i, int i2) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        xOII0IIX(sortDescending, i, i2);
        ArraysKt___ArraysKt.IoOXo(sortDescending, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void X00IxOx(byte[] forEach, oOoXoXO<? super x0xO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEach, "$this$forEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(forEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(forEach, i)));
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> X00O(long[] zip, Iterable<? extends R> other, x0xO0oo<? super XI0oooXX, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final x0xO X00xOoXI(byte[] elementAtOrNull, int i) {
        IIX0o.x0xO0oo(elementAtOrNull, "$this$elementAtOrNull");
        return oI00o(elementAtOrNull, i);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super XI0oooXX>> C X0IOOI(long[] filterIndexedTo, C destination, x0xO0oo<? super Integer, ? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexedTo, "$this$filterIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            long OOXIXo2 = OOXIxO0.OOXIXo(filterIndexedTo, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(XI0oooXX.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "minByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> int X0Ix00XxO(int[] minBy, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(minBy)) {
            int OOXIXo2 = XX0xXo.OOXIXo(minBy, 0);
            int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(minBy);
            if (oOIoXOoI == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(xxIO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(xxIO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short X0O0I0(short[] elementAtOrElse, int i, oOoXoXO<? super Integer, OX00O0xII> defaultValue) {
        IIX0o.x0xO0oo(elementAtOrElse, "$this$elementAtOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.xX0Ox(elementAtOrElse)) {
            return xX0IIXIx0.OOXIXo(elementAtOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).I0oOIX();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int X0OIo0XxO(int[] reduceRight, x0xO0oo<? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceRight, "$this$reduceRight");
        IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(reduceRight);
        if (oOIoXOoI >= 0) {
            int OOXIXo2 = XX0xXo.OOXIXo(reduceRight, oOIoXOoI);
            for (int i = oOIoXOoI - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(xxIO.oxoX(XX0xXo.OOXIXo(reduceRight, i)), xxIO.oxoX(OOXIXo2)).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final x0xO X0OXI(@OOXIXo byte[] maxOrNull) {
        IIX0o.x0xO0oo(maxOrNull, "$this$maxOrNull");
        if (OO0x0xX.x0xO0oo(maxOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(maxOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOrNull)).iterator();
        while (it.hasNext()) {
            byte OOXIXo3 = OO0x0xX.OOXIXo(maxOrNull, it.nextInt());
            if (IIX0o.oI0IIXIo(OOXIXo2 & 255, OOXIXo3 & 255) < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K> Map<K, List<XI0oooXX>> X0OXX(long[] groupBy, oOoXoXO<? super XI0oooXX, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(XI0oooXX.oxoX(OOXIXo2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(XI0oooXX.oxoX(OOXIXo2));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte X0OXoo0(byte[] single, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(single, "$this$single");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(single);
        x0xO x0xo = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(single, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                if (!z) {
                    x0xo = x0xO.oxoX(OOXIXo2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return x0xo.I0oOIX();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<x0xO, R>> X0Ox(@OOXIXo byte[] zip, @OOXIXo R[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(OO0x0xX.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(zip, i);
            arrayList.add(Xo0.oIX0oI(x0xO.oxoX(OOXIXo2), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] X0XXxoOoX(long[] reversedArray) {
        IIX0o.x0xO0oo(reversedArray, "$this$reversedArray");
        return OOXIxO0.X0o0xo(ArraysKt___ArraysKt.Xx0xOX0x(reversedArray));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double X0oX(int[] maxOf, oOoXoXO<? super xxIO, Double> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(maxOf)) {
            double doubleValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> X0ooXIooI(int[] filter, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(filter, "$this$filter");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(filter);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(filter, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(xxIO.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R X0x(byte[] foldRightIndexed, R r, Oox.IXxxXO<? super Integer, ? super x0xO, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRightIndexed, "$this$foldRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        for (int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(foldRightIndexed); xxXIIXIxx >= 0; xxXIIXIxx--) {
            r = operation.invoke(Integer.valueOf(xxXIIXIxx), x0xO.oxoX(OO0x0xX.OOXIXo(foldRightIndexed, xxXIIXIxx)), r);
        }
        return r;
    }

    public static /* synthetic */ byte[] X0xII0I(byte[] copyInto, byte[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = OO0x0xX.ooOOo0oXI(copyInto);
        }
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.O00XxXI(copyInto, destination, i, i2, i3);
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final xxIO X0xO(@OOXIXo int[] minWithOrNull, @OOXIXo Comparator<? super xxIO> comparator) {
        IIX0o.x0xO0oo(minWithOrNull, "$this$minWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (XX0xXo.x0xO0oo(minWithOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(minWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minWithOrNull)).iterator();
        while (it.hasNext()) {
            int OOXIXo3 = XX0xXo.OOXIXo(minWithOrNull, it.nextInt());
            if (comparator.compare(xxIO.oxoX(OOXIXo2), xxIO.oxoX(OOXIXo3)) > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R, C extends Collection<? super R>> C X0xOO(short[] flatMapIndexedTo, C destination, x0xO0oo<? super Integer, ? super OX00O0xII, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexedTo, "$this$flatMapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short X0xX(@OOXIXo short[] random, @OOXIXo Random random2) {
        IIX0o.x0xO0oo(random, "$this$random");
        IIX0o.x0xO0oo(random2, "random");
        if (!xX0IIXIx0.x0xO0oo(random)) {
            return xX0IIXIx0.OOXIXo(random, random2.nextInt(xX0IIXIx0.ooOOo0oXI(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] X0xXOX(byte[] plus, byte b) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        return OO0x0xX.X0o0xo(ooOOo0oXI.O0o0(plus, b));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] X0xxXX0(int[] copyInto, int[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.IIxOXoOo0(copyInto, destination, i, i2, i3);
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] XI(byte[] copyOf, int i) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        byte[] copyOf2 = Arrays.copyOf(copyOf, i);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return OO0x0xX.X0o0xo(copyOf2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int[] XI0(@OOXIXo int[] plus, @OOXIXo Collection<xxIO> elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(plus);
        int[] copyOf = Arrays.copyOf(plus, XX0xXo.ooOOo0oXI(plus) + elements.size());
        IIX0o.oO(copyOf, "copyOf(...)");
        Iterator<xxIO> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[ooOOo0oXI2] = it.next().OO();
            ooOOo0oXI2++;
        }
        return XX0xXo.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<OX00O0xII> XI0Ox(short[] runningReduceIndexed, Oox.IXxxXO<? super Integer, ? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(runningReduceIndexed, "$this$runningReduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(runningReduceIndexed));
        arrayList.add(OX00O0xII.oxoX(OOXIXo2));
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(runningReduceIndexed);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(runningReduceIndexed, i))).I0oOIX();
            arrayList.add(OX00O0xII.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super OX00O0xII, ? super V>> M XI0oooXX(short[] associateWithTo, M destination, oOoXoXO<? super OX00O0xII, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWithTo, "$this$associateWithTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(associateWithTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(associateWithTo, i);
            destination.put(OX00O0xII.oxoX(OOXIXo2), valueSelector.invoke(OX00O0xII.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final xxIO XIOOI(int[] firstOrNull, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(firstOrNull);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(firstOrNull, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                return xxIO.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] XIOOX0(int[] toIntArray) {
        IIX0o.x0xO0oo(toIntArray, "$this$toIntArray");
        int[] copyOf = Arrays.copyOf(toIntArray, toIntArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final x0xO XIOX(@OOXIXo byte[] randomOrNull, @OOXIXo Random random) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        IIX0o.x0xO0oo(random, "random");
        if (OO0x0xX.x0xO0oo(randomOrNull)) {
            return null;
        }
        return x0xO.oxoX(OO0x0xX.OOXIXo(randomOrNull, random.nextInt(OO0x0xX.ooOOo0oXI(randomOrNull))));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final XI0oooXX XIOoI(@OOXIXo long[] minWithOrNull, @OOXIXo Comparator<? super XI0oooXX> comparator) {
        IIX0o.x0xO0oo(minWithOrNull, "$this$minWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (OOXIxO0.x0xO0oo(minWithOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(minWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minWithOrNull)).iterator();
        while (it.hasNext()) {
            long OOXIXo3 = OOXIxO0.OOXIXo(minWithOrNull, it.nextInt());
            if (comparator.compare(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIXo3)) > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XIX(int[] reduceRightIndexed, Oox.IXxxXO<? super Integer, ? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceRightIndexed, "$this$reduceRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(reduceRightIndexed);
        if (oOIoXOoI >= 0) {
            int OOXIXo2 = XX0xXo.OOXIXo(reduceRightIndexed, oOIoXOoI);
            for (int i = oOIoXOoI - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(Integer.valueOf(i), xxIO.oxoX(XX0xXo.OOXIXo(reduceRightIndexed, i)), xxIO.oxoX(OOXIXo2)).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short[] XIX0Oo0(@OOXIXo OX00O0xII[] oX00O0xIIArr) {
        IIX0o.x0xO0oo(oX00O0xIIArr, "<this>");
        int length = oX00O0xIIArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = oX00O0xIIArr[i].I0oOIX();
        }
        return xX0IIXIx0.X0o0xo(sArr);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long[] XIXI(@OOXIXo long[] sortedArray) {
        IIX0o.x0xO0oo(sortedArray, "$this$sortedArray");
        if (OOXIxO0.x0xO0oo(sortedArray)) {
            return sortedArray;
        }
        long[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        long[] X0o0xo2 = OOXIxO0.X0o0xo(copyOf);
        xX0(X0o0xo2);
        return X0o0xo2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XIXIX(int[] component3) {
        IIX0o.x0xO0oo(component3, "$this$component3");
        return XX0xXo.OOXIXo(component3, 2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static boolean XIXIxO(@OXOo.oOoXoXO int[] iArr, @OXOo.oOoXoXO int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double XIo(short[] maxOf, oOoXoXO<? super OX00O0xII, Double> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(maxOf)) {
            double doubleValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<x0xO, V> XIo0oOXIx(byte[] associateWith, oOoXoXO<? super x0xO, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWith, "$this$associateWith");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(IIXOooo.OxxIIOOXO(OI0.xoIox(OO0x0xX.ooOOo0oXI(associateWith)), 16));
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(associateWith);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(associateWith, i);
            linkedHashMap.put(x0xO.oxoX(OOXIXo2), valueSelector.invoke(x0xO.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double XIoox00ox(long[] minOf, oOoXoXO<? super XI0oooXX, Double> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(minOf)) {
            double doubleValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final x0xO[] XIx0(@OOXIXo byte[] toTypedArray) {
        IIX0o.x0xO0oo(toTypedArray, "$this$toTypedArray");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(toTypedArray);
        x0xO[] x0xoArr = new x0xO[ooOOo0oXI2];
        for (int i = 0; i < ooOOo0oXI2; i++) {
            x0xoArr[i] = x0xO.oxoX(OO0x0xX.OOXIXo(toTypedArray, i));
        }
        return x0xoArr;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R XIxO(long[] foldRight, R r, x0xO0oo<? super XI0oooXX, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRight, "$this$foldRight");
        IIX0o.x0xO0oo(operation, "operation");
        for (int IOXI = ArraysKt___ArraysKt.IOXI(foldRight); IOXI >= 0; IOXI--) {
            r = operation.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(foldRight, IOXI)), r);
        }
        return r;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final XI0oooXX XIxOIII(@OOXIXo long[] singleOrNull) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        if (OOXIxO0.ooOOo0oXI(singleOrNull) == 1) {
            return XI0oooXX.oxoX(OOXIxO0.OOXIXo(singleOrNull, 0));
        }
        return null;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R XIxoOo0oI(short[] maxOfOrNull, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final x0xO XO0(@OOXIXo byte[] lastOrNull) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        if (OO0x0xX.x0xO0oo(lastOrNull)) {
            return null;
        }
        return x0xO.oxoX(OO0x0xX.OOXIXo(lastOrNull, OO0x0xX.ooOOo0oXI(lastOrNull) - 1));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long[] XO000(@OOXIXo long[] sliceArray, @OOXIXo Collection<Integer> indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return OOXIxO0.X0o0xo(ArraysKt___ArraysKt.XIxooxXIX(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final xxIO XO00XOO(int[] elementAtOrNull, int i) {
        IIX0o.x0xO0oo(elementAtOrNull, "$this$elementAtOrNull");
        return OIx0xoOo(elementAtOrNull, i);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R XO0OX(short[] foldRightIndexed, R r, Oox.IXxxXO<? super Integer, ? super OX00O0xII, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRightIndexed, "$this$foldRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        for (int xX0Ox = ArraysKt___ArraysKt.xX0Ox(foldRightIndexed); xX0Ox >= 0; xX0Ox--) {
            r = operation.invoke(Integer.valueOf(xX0Ox), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(foldRightIndexed, xX0Ox)), r);
        }
        return r;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> XO0o(@OOXIXo long[] dropLast, int i) {
        IIX0o.x0xO0oo(dropLast, "$this$dropLast");
        if (i >= 0) {
            return II0XIox(dropLast, IIXOooo.OxxIIOOXO(OOXIxO0.ooOOo0oXI(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] XOIIOIx(int[] plus, int i) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        return XX0xXo.X0o0xo(ooOOo0oXI.OIIXOxo(plus, i));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XOIoXxI(@OOXIXo byte[] shuffle, @OOXIXo Random random) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        IIX0o.x0xO0oo(random, "random");
        for (int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(shuffle); xxXIIXIxx > 0; xxXIIXIxx--) {
            int nextInt = random.nextInt(xxXIIXIxx + 1);
            byte OOXIXo2 = OO0x0xX.OOXIXo(shuffle, xxXIIXIxx);
            OO0x0xX.IXxxXO(shuffle, xxXIIXIxx, OO0x0xX.OOXIXo(shuffle, nextInt));
            OO0x0xX.IXxxXO(shuffle, nextInt, OOXIXo2);
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean XOO(long[] none) {
        IIX0o.x0xO0oo(none, "$this$none");
        return OOXIxO0.x0xO0oo(none);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfInt")
    @X00IoxXI
    @XO
    public static final int XOOI(long[] sumOf, oOoXoXO<? super XI0oooXX, Integer> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i += selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i2))).intValue();
        }
        return i;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R XOOI0(long[] minOf, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(minOf)) {
            R invoke = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOf, it.nextInt())));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M XOOO0O(long[] groupByTo, M destination, oOoXoXO<? super XI0oooXX, ? extends K> keySelector, oOoXoXO<? super XI0oooXX, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(XI0oooXX.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(XI0oooXX.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfLong")
    @X00IoxXI
    @XO
    public static final long XOOXX0II(byte[] sumOf, oOoXoXO<? super x0xO, Long> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        long j = 0;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            j += selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i))).longValue();
        }
        return j;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XOOooo(byte[] reverse, int i, int i2) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.XIxX0xXO(reverse, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XOOxX(@OOXIXo int[] shuffle, @OOXIXo Random random) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        IIX0o.x0xO0oo(random, "random");
        for (int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(shuffle); oOIoXOoI > 0; oOIoXOoI--) {
            int nextInt = random.nextInt(oOIoXOoI + 1);
            int OOXIXo2 = XX0xXo.OOXIXo(shuffle, oOIoXOoI);
            XX0xXo.IXxxXO(shuffle, oOIoXOoI, XX0xXo.OOXIXo(shuffle, nextInt));
            XX0xXo.IXxxXO(shuffle, nextInt, OOXIXo2);
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean XOX0XxOxI(long[] none, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(none, "$this$none");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(none);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte XOXo0(byte[] reduceRight, x0xO0oo<? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceRight, "$this$reduceRight");
        IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(reduceRight);
        if (xxXIIXIxx >= 0) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(reduceRight, xxXIIXIxx);
            for (int i = xxXIIXIxx - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(reduceRight, i)), x0xO.oxoX(OOXIXo2)).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> XOXxxXo(byte[] zip, R[] other, x0xO0oo<? super x0xO, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(OO0x0xX.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(zip, i)), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> List<R> XOo0(byte[] flatMapIndexed, x0xO0oo<? super Integer, ? super x0xO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexed, "$this$flatMapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), x0xO.oxoX(OO0x0xX.OOXIXo(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final x0xO XOoI(byte[] reduceOrNull, x0xO0oo<? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceOrNull, "$this$reduceOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(reduceOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(reduceOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(reduceOrNull)).iterator();
        while (it.hasNext()) {
            OOXIXo2 = operation.invoke(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OO0x0xX.OOXIXo(reduceOrNull, it.nextInt()))).I0oOIX();
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float XOoxOOO(int[] maxOfOrNull, oOoXoXO<? super xxIO, Float> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XOx(byte[] lastIndexOf, byte b) {
        IIX0o.x0xO0oo(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.OIX0oXO0o(lastIndexOf, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R XOx0xX(long[] maxOfWith, Comparator<? super R> comparator, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWith, "$this$maxOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(maxOfWith)) {
            Object obj = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> XOxoX(short[] filterIndexed, x0xO0oo<? super Integer, ? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexed, "$this$filterIndexed");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(filterIndexed, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(OX00O0xII.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] XOxxooXI(byte[] copyOf) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        byte[] copyOf2 = Arrays.copyOf(copyOf, copyOf.length);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return OO0x0xX.X0o0xo(copyOf2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean XX(byte[] all, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(all, "$this$all");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(all);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (!predicate.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean XX0(long[] any, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(any, "$this$any");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(any);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final xxIO XX00xxo(@OOXIXo int[] minOrNull) {
        int compare;
        IIX0o.x0xO0oo(minOrNull, "$this$minOrNull");
        if (XX0xXo.x0xO0oo(minOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(minOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOrNull)).iterator();
        while (it.hasNext()) {
            int OOXIXo3 = XX0xXo.OOXIXo(minOrNull, it.nextInt());
            compare = Integer.compare(OOXIXo2 ^ Integer.MIN_VALUE, OOXIXo3 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<OX00O0xII, V> XX0xXo(short[] associateWith, oOoXoXO<? super OX00O0xII, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWith, "$this$associateWith");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(IIXOooo.OxxIIOOXO(OI0.xoIox(xX0IIXIx0.ooOOo0oXI(associateWith)), 16));
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(associateWith);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(associateWith, i);
            linkedHashMap.put(OX00O0xII.oxoX(OOXIXo2), valueSelector.invoke(OX00O0xII.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int[] XXI0XXo(@OOXIXo int[] sliceArray, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return XX0xXo.X0o0xo(ArraysKt___ArraysKt.xxI(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] XXIo(short[] reversedArray) {
        IIX0o.x0xO0oo(reversedArray, "$this$reversedArray");
        return xX0IIXIx0.X0o0xo(ArraysKt___ArraysKt.xoOIOOXxO(reversedArray));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <V> List<V> XXIo0OO(int[] zip, int[] other, x0xO0oo<? super xxIO, ? super xxIO, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(XX0xXo.ooOOo0oXI(zip), XX0xXo.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(zip, i)), xxIO.oxoX(XX0xXo.OOXIXo(other, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void XXIoX0(short[] sArr) {
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final XI0oooXX XXO0(@OOXIXo long[] getOrNull, int i) {
        IIX0o.x0xO0oo(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.IOXI(getOrNull)) {
            return XI0oooXX.oxoX(OOXIxO0.OOXIXo(getOrNull, i));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R XXOOoxx0x(long[] minOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWithOrNull, "$this$minOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(minOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfLong")
    @X00IoxXI
    @XO
    public static final long XXOXXx(short[] sumOf, oOoXoXO<? super OX00O0xII, Long> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        long j = 0;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            j += selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i))).longValue();
        }
        return j;
    }

    @xxIXOIIO(name = "minWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final long XXOo(@OOXIXo long[] minWith, @OOXIXo Comparator<? super XI0oooXX> comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!OOXIxO0.x0xO0oo(minWith)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(minWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minWith)).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(minWith, it.nextInt());
                if (comparator.compare(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIXo3)) > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] XXXI(long[] copyOf, int i) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        long[] copyOf2 = Arrays.copyOf(copyOf, i);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return OOXIxO0.X0o0xo(copyOf2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte XXXoOII(@OOXIXo byte[] random, @OOXIXo Random random2) {
        IIX0o.x0xO0oo(random, "$this$random");
        IIX0o.x0xO0oo(random2, "random");
        if (!OO0x0xX.x0xO0oo(random)) {
            return OO0x0xX.OOXIXo(random, random2.nextInt(OO0x0xX.ooOOo0oXI(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XXoO0oX(short[] indexOfLast, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfLast, "$this$indexOfLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (predicate.invoke(OX00O0xII.oxoX(OX00O0xII.oOoXoXO(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long XXoOOO0I(long[] reduceRight, x0xO0oo<? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceRight, "$this$reduceRight");
        IIX0o.x0xO0oo(operation, "operation");
        int IOXI = ArraysKt___ArraysKt.IOXI(reduceRight);
        if (IOXI >= 0) {
            long OOXIXo2 = OOXIxO0.OOXIXo(reduceRight, IOXI);
            for (int i = IOXI - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceRight, i)), XI0oooXX.oxoX(OOXIXo2)).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int XXoOx0(@OXOo.oOoXoXO int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XXooOOI(byte[] indexOfLast, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfLast, "$this$indexOfLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (predicate.invoke(x0xO.oxoX(x0xO.oOoXoXO(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short XXx0OXXXo(short[] getOrElse, int i, oOoXoXO<? super Integer, OX00O0xII> defaultValue) {
        IIX0o.x0xO0oo(getOrElse, "$this$getOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.xX0Ox(getOrElse)) {
            return xX0IIXIx0.OOXIXo(getOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).I0oOIX();
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void Xo(@OOXIXo byte[] fill, byte b, int i, int i2) {
        IIX0o.x0xO0oo(fill, "$this$fill");
        ooOOo0oXI.O0xxXxI(fill, b, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean Xo0(short[] any) {
        IIX0o.x0xO0oo(any, "$this$any");
        return ArraysKt___ArraysKt.xOIO(any);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> Xo000XO0(@OOXIXo long[] takeLast, int i) {
        IIX0o.x0xO0oo(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(takeLast);
            if (i >= ooOOo0oXI2) {
                return CollectionsKt___CollectionsKt.oOo0o(OOXIxO0.II0xO0(takeLast));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(XI0oooXX.oxoX(OOXIxO0.OOXIXo(takeLast, ooOOo0oXI2 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = ooOOo0oXI2 - i; i2 < ooOOo0oXI2; i2++) {
                arrayList.add(XI0oooXX.oxoX(OOXIxO0.OOXIXo(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final x0xO Xo00XX(@OOXIXo byte[] singleOrNull) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        if (OO0x0xX.ooOOo0oXI(singleOrNull) == 1) {
            return x0xO.oxoX(OO0x0xX.OOXIXo(singleOrNull, 0));
        }
        return null;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final OX00O0xII Xo0oxxX0(short[] reduceRightOrNull, x0xO0oo<? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceRightOrNull, "$this$reduceRightOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(reduceRightOrNull);
        if (xX0Ox < 0) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceRightOrNull, xX0Ox);
        for (int i = xX0Ox - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceRightOrNull, i)), OX00O0xII.oxoX(OOXIXo2)).I0oOIX();
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<XI0oooXX> XoI(long[] runningReduceIndexed, Oox.IXxxXO<? super Integer, ? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(runningReduceIndexed, "$this$runningReduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(runningReduceIndexed));
        arrayList.add(XI0oooXX.oxoX(OOXIXo2));
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(runningReduceIndexed);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(runningReduceIndexed, i))).OO();
            arrayList.add(XI0oooXX.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean XoI0Ixx0(short[] any, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(any, "$this$any");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(any);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double XoI0OoX(byte[] minOfOrNull, oOoXoXO<? super x0xO, Double> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(minOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C XoIoOXOIx(int[] mapTo, C destination, oOoXoXO<? super xxIO, ? extends R> transform) {
        IIX0o.x0xO0oo(mapTo, "$this$mapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(mapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            destination.add(transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(mapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XoIxOXIXo(byte[] count, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(count, "$this$count");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(count);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            if (predicate.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(count, i2))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R XoIxo(long[] minOfWith, Comparator<? super R> comparator, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWith, "$this$minOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(minOfWith)) {
            Object obj = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] XoO(short[] plus, short s) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        return xX0IIXIx0.X0o0xo(ooOOo0oXI.IXXIXx00I(plus, s));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> OX00O0xII XoOOOXox(short[] maxByOrNull, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxByOrNull, "$this$maxByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(maxByOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(maxByOrNull, 0);
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(maxByOrNull);
        if (xX0Ox == 0) {
            return OX00O0xII.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(OX00O0xII.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
        while (it.hasNext()) {
            short OOXIXo3 = xX0IIXIx0.OOXIXo(maxByOrNull, it.nextInt());
            R invoke2 = selector.invoke(OX00O0xII.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) < 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @OOXIXo
    public static final X0.oOoXoXO XoOOx0IX(@OOXIXo byte[] indices) {
        IIX0o.x0xO0oo(indices, "$this$indices");
        return ArraysKt___ArraysKt.Ixo0(indices);
    }

    @xxIXOIIO(name = "minOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final byte XoOOxOo0o(@OOXIXo byte[] min) {
        IIX0o.x0xO0oo(min, "$this$min");
        if (!OO0x0xX.x0xO0oo(min)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(min, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(min)).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(min, it.nextInt());
                if (IIX0o.oI0IIXIo(OOXIXo2 & 255, OOXIXo3 & 255) > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> XoOxI0ox(long[] filter, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(filter, "$this$filter");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(filter);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(filter, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(XI0oooXX.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean XoX(short[] all, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(all, "$this$all");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(all);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (!predicate.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XoXX(@OOXIXo byte[] sort, int i, int i2) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, OO0x0xX.ooOOo0oXI(sort));
        xoxXI.xoIox(sort, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XoXX0x00(@OOXIXo byte[] sortDescending, int i, int i2) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        XoXX(sortDescending, i, i2);
        ArraysKt___ArraysKt.XIxX0xXO(sortDescending, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void XooIO0oo0(@OOXIXo int[] fill, int i, int i2, int i3) {
        IIX0o.x0xO0oo(fill, "$this$fill");
        ooOOo0oXI.oX0I0O(fill, i, i2, i3);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> XI0oooXX Xooo0Xx(long[] minByOrNull, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minByOrNull, "$this$minByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(minByOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(minByOrNull, 0);
        int IOXI = ArraysKt___ArraysKt.IOXI(minByOrNull);
        if (IOXI == 0) {
            return XI0oooXX.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(XI0oooXX.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
        while (it.hasNext()) {
            long OOXIXo3 = OOXIxO0.OOXIXo(minByOrNull, it.nextInt());
            R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) > 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double Xox0o(int[] maxOfOrNull, oOoXoXO<? super xxIO, Double> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> XoxXox(long[] scan, R r, x0xO0oo<? super R, ? super XI0oooXX, ? extends R> operation) {
        IIX0o.x0xO0oo(scan, "$this$scan");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(scan)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(scan) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(scan);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, XI0oooXX.oxoX(OOXIxO0.OOXIXo(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, List<V>> Xx(int[] groupBy, oOoXoXO<? super xxIO, ? extends K> keySelector, oOoXoXO<? super xxIO, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(xxIO.oxoX(OOXIXo2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(xxIO.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, List<V>> Xx0(byte[] groupBy, oOoXoXO<? super x0xO, ? extends K> keySelector, oOoXoXO<? super x0xO, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(x0xO.oxoX(OOXIXo2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(x0xO.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R Xx0OXIoI(byte[] minOfOrNull, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(minOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII Xx0X(short[] singleOrNull, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(singleOrNull);
        OX00O0xII oX00O0xII = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(singleOrNull, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                if (z) {
                    return null;
                }
                oX00O0xII = OX00O0xII.oxoX(OOXIXo2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return oX00O0xII;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "maxByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> long Xx0oX(long[] maxBy, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(maxBy)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(maxBy, 0);
            int IOXI = ArraysKt___ArraysKt.IOXI(maxBy);
            if (IOXI == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(XI0oooXX.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C XxI(byte[] flatMapTo, C destination, oOoXoXO<? super x0xO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapTo, "$this$flatMapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(flatMapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(destination, transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(flatMapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double XxI0(long[] maxOfOrNull, oOoXoXO<? super XI0oooXX, Double> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R, C extends Collection<? super R>> C XxIIOXIXx(byte[] flatMapIndexedTo, C destination, x0xO0oo<? super Integer, ? super x0xO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexedTo, "$this$flatMapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(flatMapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), x0xO.oxoX(OO0x0xX.OOXIXo(flatMapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final XI0oooXX XxIO0(@OOXIXo long[] maxWithOrNull, @OOXIXo Comparator<? super XI0oooXX> comparator) {
        IIX0o.x0xO0oo(maxWithOrNull, "$this$maxWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (OOXIxO0.x0xO0oo(maxWithOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(maxWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            long OOXIXo3 = OOXIxO0.OOXIXo(maxWithOrNull, it.nextInt());
            if (comparator.compare(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIXo3)) < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, M extends Map<? super K, List<x0xO>>> M XxIOX(byte[] groupByTo, M destination, oOoXoXO<? super x0xO, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(x0xO.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(x0xO.oxoX(OOXIXo2));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super XI0oooXX>> C XxIo(long[] filterNotTo, C destination, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNotTo, "$this$filterNotTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(filterNotTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(filterNotTo, i);
            if (!predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(XI0oooXX.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<xxIO, R>> XxO(@OOXIXo int[] zip, @OOXIXo R[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(XX0xXo.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(zip, i);
            arrayList.add(Xo0.oIX0oI(xxIO.oxoX(OOXIXo2), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float XxOOoxOO(int[] maxOf, oOoXoXO<? super xxIO, Float> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(maxOf)) {
            float floatValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> XxOXxXo(@OOXIXo byte[] take, int i) {
        IIX0o.x0xO0oo(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= OO0x0xX.ooOOo0oXI(take)) {
                return CollectionsKt___CollectionsKt.oOo0o(OO0x0xX.II0xO0(take));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(x0xO.oxoX(OO0x0xX.OOXIXo(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(take);
            int i2 = 0;
            for (int i3 = 0; i3 < ooOOo0oXI2; i3++) {
                arrayList.add(x0xO.oxoX(OO0x0xX.OOXIXo(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XxOx(@OOXIXo byte[] shuffle) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        XOIoXxI(shuffle, Random.Default);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> XxX0xI(int[] zip, Iterable<? extends R> other, x0xO0oo<? super xxIO, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int XxXOXo0Xx(byte[] sum) {
        IIX0o.x0xO0oo(sum, "$this$sum");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sum);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + xxIO.oOoXoXO(OO0x0xX.OOXIXo(sum, i) & 255));
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final x0xO XxXX(byte[] find, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(find, "$this$find");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(find);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(find, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                return x0xO.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void Xxo(@OOXIXo long[] sortDescending) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        if (OOXIxO0.ooOOo0oXI(sortDescending) > 1) {
            xX0(sortDescending);
            ArraysKt___ArraysKt.x0IoI0x(sortDescending);
        }
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double XxoOI00IX(short[] maxOfOrNull, oOoXoXO<? super OX00O0xII, Double> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int Xxx0oXX(int[] indexOfLast, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfLast, "$this$indexOfLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (predicate.invoke(xxIO.oxoX(xxIO.oOoXoXO(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] XxxIX(long[] plus, long j) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        return OOXIxO0.X0o0xo(ooOOo0oXI.XxI(plus, j));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<OX00O0xII, R>> XxxXX0XO0(@OOXIXo short[] zip, @OOXIXo R[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(xX0IIXIx0.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(zip, i);
            arrayList.add(Xo0.oIX0oI(OX00O0xII.oxoX(OOXIXo2), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int o00OI00(int[] sum) {
        IIX0o.x0xO0oo(sum, "$this$sum");
        return xxIO.oOoXoXO(ArraysKt___ArraysKt.xOXxx0(sum));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long o00Ox0xOO(long[] reduceRightIndexed, Oox.IXxxXO<? super Integer, ? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceRightIndexed, "$this$reduceRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int IOXI = ArraysKt___ArraysKt.IOXI(reduceRightIndexed);
        if (IOXI >= 0) {
            long OOXIXo2 = OOXIxO0.OOXIXo(reduceRightIndexed, IOXI);
            for (int i = IOXI - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(Integer.valueOf(i), XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceRightIndexed, i)), XI0oooXX.oxoX(OOXIXo2)).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int o00xOoIO(int[] first, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(first, "$this$first");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(first);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(first, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                return OOXIXo2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean o0I(short[] none, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(none, "$this$none");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(none);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(none, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R o0I0O0oXX(int[] maxOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWithOrNull, "$this$maxOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(maxOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] o0IXXIx(int[] copyOfRange, int i, int i2) {
        int[] copyOfRange2;
        IIX0o.x0xO0oo(copyOfRange, "$this$copyOfRange");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            copyOfRange2 = ooOOo0oXI.X0xII0I(copyOfRange, i, i2);
        } else if (i2 <= copyOfRange.length) {
            copyOfRange2 = Arrays.copyOfRange(copyOfRange, i, i2);
            IIX0o.ooOOo0oXI(copyOfRange2);
        } else {
            throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + copyOfRange.length);
        }
        return XX0xXo.X0o0xo(copyOfRange2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float o0Ixx(byte[] minOfOrNull, oOoXoXO<? super x0xO, Float> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(minOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> o0OI(byte[] runningFoldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super x0xO, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFoldIndexed, "$this$runningFoldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(runningFoldIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(runningFoldIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(runningFoldIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, x0xO.oxoX(OO0x0xX.OOXIXo(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long o0OO0(long[] first, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(first, "$this$first");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(first);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(first, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                return OOXIXo2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final xxIO o0Oo(int[] find, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(find, "$this$find");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(find);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(find, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                return xxIO.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R o0OoX(int[] minOfWith, Comparator<? super R> comparator, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWith, "$this$minOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(minOfWith)) {
            Object obj = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float o0Oox0xox(short[] maxOf, oOoXoXO<? super OX00O0xII, Float> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(maxOf)) {
            float floatValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte o0Xo(byte[] elementAtOrElse, int i, oOoXoXO<? super Integer, x0xO> defaultValue) {
        IIX0o.x0xO0oo(elementAtOrElse, "$this$elementAtOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.xxXIIXIxx(elementAtOrElse)) {
            return OO0x0xX.OOXIXo(elementAtOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).I0oOIX();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float o0Xo0XII(byte[] maxOfOrNull, oOoXoXO<? super x0xO, Float> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final XI0oooXX o0Xo0XX(long[] reduceIndexedOrNull, Oox.IXxxXO<? super Integer, ? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(reduceIndexedOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(reduceIndexedOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceIndexedOrNull, nextInt))).OO();
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long[] o0XxxOIx(@OOXIXo long[] plus, @OOXIXo Collection<XI0oooXX> elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(plus);
        long[] copyOf = Arrays.copyOf(plus, OOXIxO0.ooOOo0oXI(plus) + elements.size());
        IIX0o.oO(copyOf, "copyOf(...)");
        Iterator<XI0oooXX> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[ooOOo0oXI2] = it.next().OO();
            ooOOo0oXI2++;
        }
        return OOXIxO0.X0o0xo(copyOf);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short[] o0o(@OOXIXo short[] sortedArrayDescending) {
        IIX0o.x0xO0oo(sortedArrayDescending, "$this$sortedArrayDescending");
        if (xX0IIXIx0.x0xO0oo(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] copyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        short[] X0o0xo2 = xX0IIXIx0.X0o0xo(copyOf);
        xxOOXo(X0o0xo2);
        return X0o0xo2;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static boolean o0oIxOo(@OXOo.oOoXoXO short[] sArr, @OXOo.oOoXoXO short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V, M extends Map<? super K, List<V>>> M o0oIxXOx(byte[] groupByTo, M destination, oOoXoXO<? super x0xO, ? extends K> keySelector, oOoXoXO<? super x0xO, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(x0xO.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(x0xO.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] o0ooO(long[] jArr) {
        IIX0o.x0xO0oo(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return OOXIxO0.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> o0oxo0oI(short[] dropWhile, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(dropWhile, "$this$dropWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(dropWhile);
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(dropWhile, i);
            if (z) {
                arrayList.add(OX00O0xII.oxoX(OOXIXo2));
            } else if (!predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(OX00O0xII.oxoX(OOXIXo2));
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R o0x0XOXx(int[] minOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWithOrNull, "$this$minOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(minOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, M extends Map<? super K, List<OX00O0xII>>> M o0xIIX0(short[] groupByTo, M destination, oOoXoXO<? super OX00O0xII, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(OX00O0xII.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(OX00O0xII.oxoX(OOXIXo2));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] o0xIXX(short[] toShortArray) {
        IIX0o.x0xO0oo(toShortArray, "$this$toShortArray");
        short[] copyOf = Arrays.copyOf(toShortArray, toShortArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    @OOXIXo
    public static final X0.oOoXoXO o0xIoII(@OOXIXo short[] indices) {
        IIX0o.x0xO0oo(indices, "$this$indices");
        return ArraysKt___ArraysKt.XxxoXoX(indices);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void o0xOIoxo(int[] forEachIndexed, x0xO0oo<? super Integer, ? super xxIO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEachIndexed, "$this$forEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), xxIO.oxoX(XX0xXo.OOXIXo(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super xxIO, ? super V>> M o0xxxXXxX(int[] associateWithTo, M destination, oOoXoXO<? super xxIO, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWithTo, "$this$associateWithTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(associateWithTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(associateWithTo, i);
            destination.put(xxIO.oxoX(OOXIXo2), valueSelector.invoke(xxIO.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static String oI(@OXOo.oOoXoXO int[] iArr) {
        String OoIXo2;
        if (iArr == null || (OoIXo2 = CollectionsKt___CollectionsKt.OoIXo(XX0xXo.II0xO0(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return OoIXo2;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> List<R> oI0(long[] flatMapIndexed, x0xO0oo<? super Integer, ? super XI0oooXX, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexed, "$this$flatMapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final x0xO oI00o(@OOXIXo byte[] getOrNull, int i) {
        IIX0o.x0xO0oo(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.xxXIIXIxx(getOrNull)) {
            return x0xO.oxoX(OO0x0xX.OOXIXo(getOrNull, i));
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C oI0X0(short[] flatMapTo, C destination, oOoXoXO<? super OX00O0xII, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapTo, "$this$flatMapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(flatMapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(destination, transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(flatMapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oI0XoXIXo(@OOXIXo long[] shuffle) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        Ooxxx(shuffle, Random.Default);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<xxIO> oI0xOoox(int[] runningReduce, x0xO0oo<? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(runningReduce, "$this$runningReduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(runningReduce)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        int OOXIXo2 = XX0xXo.OOXIXo(runningReduce, 0);
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(runningReduce));
        arrayList.add(xxIO.oxoX(OOXIXo2));
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(runningReduce);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(xxIO.oxoX(OOXIXo2), xxIO.oxoX(XX0xXo.OOXIXo(runningReduce, i))).OO();
            arrayList.add(xxIO.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R oII(long[] maxOf, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(maxOf)) {
            R invoke = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOf, it.nextInt())));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX oIIOI(long[] singleOrNull, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(singleOrNull);
        XI0oooXX xI0oooXX = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(singleOrNull, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                if (z) {
                    return null;
                }
                xI0oooXX = XI0oooXX.oxoX(OOXIXo2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return xI0oooXX;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void oIIXxXIox(long[] reverse) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.x0IoI0x(reverse);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] oIIxXoo(short[] copyOf, int i) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        short[] copyOf2 = Arrays.copyOf(copyOf, i);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return xX0IIXIx0.X0o0xo(copyOf2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> oIO(@OOXIXo byte[] sorted) {
        IIX0o.x0xO0oo(sorted, "$this$sorted");
        byte[] copyOf = Arrays.copyOf(sorted, sorted.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        byte[] X0o0xo2 = OO0x0xX.X0o0xo(copyOf);
        OX0xI0IO(X0o0xo2);
        return II0xO0.II0xO0(X0o0xo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> oIO0X00(byte[] takeLastWhile, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(takeLastWhile, "$this$takeLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(takeLastWhile); -1 < xxXIIXIxx; xxXIIXIxx--) {
            if (!predicate.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(takeLastWhile, xxXIIXIxx))).booleanValue()) {
                return xIXX(takeLastWhile, xxXIIXIxx + 1);
            }
        }
        return CollectionsKt___CollectionsKt.oOo0o(OO0x0xX.II0xO0(takeLastWhile));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> oIOXxOI(short[] takeLastWhile, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(takeLastWhile, "$this$takeLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int xX0Ox = ArraysKt___ArraysKt.xX0Ox(takeLastWhile); -1 < xX0Ox; xX0Ox--) {
            if (!predicate.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(takeLastWhile, xX0Ox))).booleanValue()) {
                return xxxI(takeLastWhile, xX0Ox + 1);
            }
        }
        return CollectionsKt___CollectionsKt.oOo0o(xX0IIXIx0.II0xO0(takeLastWhile));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte oIX0o(byte[] last) {
        IIX0o.x0xO0oo(last, "$this$last");
        return x0xO.oOoXoXO(ArraysKt___ArraysKt.OIXo(last));
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII[] oIXIXIxx0(@OOXIXo short[] toTypedArray) {
        IIX0o.x0xO0oo(toTypedArray, "$this$toTypedArray");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(toTypedArray);
        OX00O0xII[] oX00O0xIIArr = new OX00O0xII[ooOOo0oXI2];
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oX00O0xIIArr[i] = OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(toTypedArray, i));
        }
        return oX00O0xIIArr;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oIXXo(long[] runningFold, R r, x0xO0oo<? super R, ? super XI0oooXX, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFold, "$this$runningFold");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(runningFold)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(runningFold) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(runningFold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, XI0oooXX.oxoX(OOXIxO0.OOXIXo(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C oIXoXx0(int[] flatMapTo, C destination, oOoXoXO<? super xxIO, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapTo, "$this$flatMapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(flatMapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(destination, transform.invoke(xxIO.oxoX(XX0xXo.OOXIXo(flatMapTo, i))));
        }
        return destination;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final XI0oooXX oIo0OoXIo(long[] randomOrNull) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        return OXO0(randomOrNull, Random.Default);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int oIo0x(int[] sumBy, oOoXoXO<? super xxIO, xxIO> selector) {
        IIX0o.x0xO0oo(sumBy, "$this$sumBy");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumBy);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i = xxIO.oOoXoXO(i + selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumBy, i2))).OO());
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> x0xO oIoIXxIO(byte[] maxByOrNull, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxByOrNull, "$this$maxByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(maxByOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(maxByOrNull, 0);
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(maxByOrNull);
        if (xxXIIXIxx == 0) {
            return x0xO.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(x0xO.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            byte OOXIXo3 = OO0x0xX.OOXIXo(maxByOrNull, it.nextInt());
            R invoke2 = selector.invoke(x0xO.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) < 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final XI0oooXX oIoIxo(@OOXIXo long[] maxOrNull) {
        int compare;
        IIX0o.x0xO0oo(maxOrNull, "$this$maxOrNull");
        if (OOXIxO0.x0xO0oo(maxOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(maxOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOrNull)).iterator();
        while (it.hasNext()) {
            long OOXIXo3 = OOXIxO0.OOXIXo(maxOrNull, it.nextInt());
            compare = Long.compare(OOXIXo2 ^ Long.MIN_VALUE, OOXIXo3 ^ Long.MIN_VALUE);
            if (compare < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void oIoox0(int[] reverse) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.XxxI(reverse);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> oIoxI0xx(short[] map, oOoXoXO<? super OX00O0xII, ? extends R> transform) {
        IIX0o.x0xO0oo(map, "$this$map");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(map));
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(map);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            arrayList.add(transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(map, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final OX00O0xII oIxIO(short[] reduceIndexedOrNull, Oox.IXxxXO<? super Integer, ? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(reduceIndexedOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceIndexedOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceIndexedOrNull, nextInt))).I0oOIX();
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oIxIOoOx(long[] reverse, int i, int i2) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.IoOXo(reverse, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> oIxOXo(byte[] mapIndexed, x0xO0oo<? super Integer, ? super x0xO, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexed, "$this$mapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(mapIndexed));
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), x0xO.oxoX(OO0x0xX.OOXIXo(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R oIxXX0Xo(byte[] maxOfWith, Comparator<? super R> comparator, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWith, "$this$maxOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(maxOfWith)) {
            Object obj = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float oIxXXOI(long[] maxOf, oOoXoXO<? super XI0oooXX, Float> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(maxOf)) {
            float floatValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> oIxxIo(long[] mapIndexed, x0xO0oo<? super Integer, ? super XI0oooXX, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexed, "$this$mapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(mapIndexed));
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> oO0(long[] map, oOoXoXO<? super XI0oooXX, ? extends R> transform) {
        IIX0o.x0xO0oo(map, "$this$map");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(map));
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(map);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            arrayList.add(transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(map, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte oO0IXx(byte[] first) {
        IIX0o.x0xO0oo(first, "$this$first");
        return x0xO.oOoXoXO(ArraysKt___ArraysKt.OxX(first));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, M extends Map<? super K, List<XI0oooXX>>> M oO0OX0(long[] groupByTo, M destination, oOoXoXO<? super XI0oooXX, ? extends K> keySelector) {
        IIX0o.x0xO0oo(groupByTo, "$this$groupByTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(groupByTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(groupByTo, i);
            K invoke = keySelector.invoke(XI0oooXX.oxoX(OOXIXo2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(XI0oooXX.oxoX(OOXIXo2));
        }
        return destination;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfULong")
    @X00IoxXI
    @XO
    public static final long oO0XoIX(int[] sumOf, oOoXoXO<? super xxIO, XI0oooXX> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int oO0o(short[] sumBy, oOoXoXO<? super OX00O0xII, xxIO> selector) {
        IIX0o.x0xO0oo(sumBy, "$this$sumBy");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumBy);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i = xxIO.oOoXoXO(i + selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumBy, i2))).OO());
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short oOI0IXOO(short[] reduceRight, x0xO0oo<? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceRight, "$this$reduceRight");
        IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(reduceRight);
        if (xX0Ox >= 0) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceRight, xX0Ox);
            for (int i = xX0Ox - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceRight, i)), OX00O0xII.oxoX(OOXIXo2)).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte oOIXoIXXI(byte[] getOrElse, int i, oOoXoXO<? super Integer, x0xO> defaultValue) {
        IIX0o.x0xO0oo(getOrElse, "$this$getOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.xxXIIXIxx(getOrElse)) {
            return OO0x0xX.OOXIXo(getOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).I0oOIX();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void oOIx(short[] forEach, oOoXoXO<? super OX00O0xII, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEach, "$this$forEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(forEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(forEach, i)));
        }
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> oOIxIIoI(@OOXIXo int[] take, int i) {
        IIX0o.x0xO0oo(take, "$this$take");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= XX0xXo.ooOOo0oXI(take)) {
                return CollectionsKt___CollectionsKt.oOo0o(XX0xXo.II0xO0(take));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(xxIO.oxoX(XX0xXo.OOXIXo(take, 0)));
            }
            ArrayList arrayList = new ArrayList(i);
            int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(take);
            int i2 = 0;
            for (int i3 = 0; i3 < ooOOo0oXI2; i3++) {
                arrayList.add(xxIO.oxoX(XX0xXo.OOXIXo(take, i3)));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] oOO(@OOXIXo byte[] sliceArray, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return OO0x0xX.X0o0xo(ArraysKt___ArraysKt.oIoIxO0(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<xxIO> oOX(int[] runningReduceIndexed, Oox.IXxxXO<? super Integer, ? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(runningReduceIndexed, "$this$runningReduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(runningReduceIndexed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        int OOXIXo2 = XX0xXo.OOXIXo(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(runningReduceIndexed));
        arrayList.add(xxIO.oxoX(OOXIXo2));
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(runningReduceIndexed);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), xxIO.oxoX(OOXIXo2), xxIO.oxoX(XX0xXo.OOXIXo(runningReduceIndexed, i))).OO();
            arrayList.add(xxIO.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long oOo(long[] component3) {
        IIX0o.x0xO0oo(component3, "$this$component3");
        return OOXIxO0.OOXIXo(component3, 2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R oOo0o(short[] maxOf, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(maxOf)) {
            R invoke = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOf, it.nextInt())));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int oOoIIO0(@OXOo.oOoXoXO long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <V> List<V> oOx0IIo(byte[] zip, byte[] other, x0xO0oo<? super x0xO, ? super x0xO, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(OO0x0xX.ooOOo0oXI(zip), OO0x0xX.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(zip, i)), x0xO.oxoX(OO0x0xX.OOXIXo(other, i))));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R oOx0xoXI(int[] maxOfWith, Comparator<? super R> comparator, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWith, "$this$maxOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(maxOfWith)) {
            Object obj = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float oOxoXxoX(short[] maxOfOrNull, oOoXoXO<? super OX00O0xII, Float> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C oOxxXI(short[] mapTo, C destination, oOoXoXO<? super OX00O0xII, ? extends R> transform) {
        IIX0o.x0xO0oo(mapTo, "$this$mapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(mapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            destination.add(transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(mapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean oX(int[] any, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(any, "$this$any");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(any);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(xxIO.oxoX(XX0xXo.OOXIXo(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> oX000x(short[] filter, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(filter, "$this$filter");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(filter);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(filter, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(OX00O0xII.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> oX0I0O(byte[] dropLastWhile, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(dropLastWhile, "$this$dropLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(dropLastWhile); -1 < xxXIIXIxx; xxXIIXIxx--) {
            if (!predicate.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(dropLastWhile, xxXIIXIxx))).booleanValue()) {
                return XxOXxXo(dropLastWhile, xxXIIXIxx + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C oX0O(byte[] mapIndexedTo, C destination, x0xO0oo<? super Integer, ? super x0xO, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexedTo, "$this$mapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            destination.add(transform.invoke(Integer.valueOf(i2), x0xO.oxoX(OO0x0xX.OOXIXo(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long[] oX0Ox(long[] onEach, oOoXoXO<? super XI0oooXX, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEach, "$this$onEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(onEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(onEach, i)));
        }
        return onEach;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oX0oO(int[] runningFoldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super xxIO, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFoldIndexed, "$this$runningFoldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(runningFoldIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(runningFoldIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(runningFoldIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, xxIO.oxoX(XX0xXo.OOXIXo(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> oX0ooo0I0(short[] dropLastWhile, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(dropLastWhile, "$this$dropLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int xX0Ox = ArraysKt___ArraysKt.xX0Ox(dropLastWhile); -1 < xX0Ox; xX0Ox--) {
            if (!predicate.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(dropLastWhile, xX0Ox))).booleanValue()) {
                return O0XI00X0o(dropLastWhile, xX0Ox + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte oXIO0o0XI(byte[] component3) {
        IIX0o.x0xO0oo(component3, "$this$component3");
        return OO0x0xX.OOXIXo(component3, 2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> oXIOOxX(@OOXIXo long[] reversed) {
        IIX0o.x0xO0oo(reversed, "$this$reversed");
        if (OOXIxO0.x0xO0oo(reversed)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<XI0oooXX> o0Xo0XII = CollectionsKt___CollectionsKt.o0Xo0XII(OOXIxO0.II0xO0(reversed));
        X0IIOO.oXX0IoI(o0Xo0XII);
        return o0Xo0XII;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> oXIOxo(@OOXIXo long[] sortedDescending) {
        IIX0o.x0xO0oo(sortedDescending, "$this$sortedDescending");
        long[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        long[] X0o0xo2 = OOXIxO0.X0o0xo(copyOf);
        xX0(X0o0xo2);
        return oXIOOxX(X0o0xo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean oXIo0X0x(short[] none) {
        IIX0o.x0xO0oo(none, "$this$none");
        return xX0IIXIx0.x0xO0oo(none);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void oXIoIo(long[] forEach, oOoXoXO<? super XI0oooXX, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEach, "$this$forEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(forEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(forEach, i)));
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] oXIoO(short[] copyOfRange, int i, int i2) {
        short[] copyOfRange2;
        IIX0o.x0xO0oo(copyOfRange, "$this$copyOfRange");
        if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
            copyOfRange2 = ooOOo0oXI.oXxOI0oIx(copyOfRange, i, i2);
        } else if (i2 <= copyOfRange.length) {
            copyOfRange2 = Arrays.copyOfRange(copyOfRange, i, i2);
            IIX0o.ooOOo0oXI(copyOfRange2);
        } else {
            throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + copyOfRange.length);
        }
        return xX0IIXIx0.X0o0xo(copyOfRange2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int[] oXIxoOo(@OOXIXo xxIO[] xxioArr) {
        IIX0o.x0xO0oo(xxioArr, "<this>");
        int length = xxioArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = xxioArr[i].OO();
        }
        return XX0xXo.X0o0xo(iArr);
    }

    public static /* synthetic */ void oXO0oOx0(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = OO0x0xX.ooOOo0oXI(bArr);
        }
        Xo(bArr, b, i, i2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final Iterable<xI<xxIO>> oXOxO0XXo(@OOXIXo final int[] withIndex) {
        IIX0o.x0xO0oo(withIndex, "$this$withIndex");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends xxIO>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final Iterator<? extends xxIO> invoke() {
                return XX0xXo.Oo(withIndex);
            }
        });
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @XO
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int oXOxox(byte[] sumBy, oOoXoXO<? super x0xO, xxIO> selector) {
        IIX0o.x0xO0oo(sumBy, "$this$sumBy");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumBy);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i = xxIO.oOoXoXO(i + selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumBy, i2))).OO());
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte oXX0(byte[] reduceIndexed, Oox.IXxxXO<? super Integer, ? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceIndexed, "$this$reduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (!OO0x0xX.x0xO0oo(reduceIndexed)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(reduceIndexed, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(reduceIndexed)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), x0xO.oxoX(OOXIXo2), x0xO.oxoX(OO0x0xX.OOXIXo(reduceIndexed, nextInt))).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] oXX0IoI(int[] copyOf, int i) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        int[] copyOf2 = Arrays.copyOf(copyOf, i);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return XX0xXo.X0o0xo(copyOf2);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final XI0oooXX oXXI0(long[] reduceOrNull, x0xO0oo<? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceOrNull, "$this$reduceOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(reduceOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(reduceOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(reduceOrNull)).iterator();
        while (it.hasNext()) {
            OOXIXo2 = operation.invoke(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceOrNull, it.nextInt()))).OO();
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final xxIO oXXX(int[] reduceRightIndexedOrNull, Oox.IXxxXO<? super Integer, ? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(reduceRightIndexedOrNull);
        if (oOIoXOoI < 0) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(reduceRightIndexedOrNull, oOIoXOoI);
        for (int i = oOIoXOoI - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(Integer.valueOf(i), xxIO.oxoX(XX0xXo.OOXIXo(reduceRightIndexedOrNull, i)), xxIO.oxoX(OOXIXo2)).OO();
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final x0xO oXoXxOo(@OOXIXo byte[] firstOrNull) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        if (OO0x0xX.x0xO0oo(firstOrNull)) {
            return null;
        }
        return x0xO.oxoX(OO0x0xX.OOXIXo(firstOrNull, 0));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfInt")
    @X00IoxXI
    @XO
    public static final int oXx00I(byte[] sumOf, oOoXoXO<? super x0xO, Integer> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i += selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i2))).intValue();
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] oXx0XO(byte[] reversedArray) {
        IIX0o.x0xO0oo(reversedArray, "$this$reversedArray");
        return OO0x0xX.X0o0xo(ArraysKt___ArraysKt.OXXO(reversedArray));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long oXx0oXXo(long[] sum) {
        IIX0o.x0xO0oo(sum, "$this$sum");
        return XI0oooXX.oOoXoXO(ArraysKt___ArraysKt.XXIX0(sum));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] oXxOI0oIx(int[] copyOf) {
        IIX0o.x0xO0oo(copyOf, "$this$copyOf");
        int[] copyOf2 = Arrays.copyOf(copyOf, copyOf.length);
        IIX0o.oO(copyOf2, "copyOf(...)");
        return XX0xXo.X0o0xo(copyOf2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void oXxOXOX(long[] jArr) {
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final xxIO oXxo(int[] randomOrNull) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        return xIO(randomOrNull, Random.Default);
    }

    public static /* synthetic */ void oXxx000(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = xX0IIXIx0.ooOOo0oXI(sArr);
        }
        xIx0XO(sArr, s, i, i2);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final x0xO oo0(byte[] randomOrNull) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        return XIOX(randomOrNull, Random.Default);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> oo00(byte[] dropWhile, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(dropWhile, "$this$dropWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(dropWhile);
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(dropWhile, i);
            if (z) {
                arrayList.add(x0xO.oxoX(OOXIXo2));
            } else if (!predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(x0xO.oxoX(OOXIXo2));
                z = true;
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R oo00Io(byte[] maxOfOrNull, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super xxIO>> C oo0oIXo(int[] filterNotTo, C destination, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNotTo, "$this$filterNotTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(filterNotTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(filterNotTo, i);
            if (!predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(xxIO.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfLong")
    @X00IoxXI
    @XO
    public static final long ooO00o(int[] sumOf, oOoXoXO<? super xxIO, Long> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        long j = 0;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            j += selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i))).longValue();
        }
        return j;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte ooO0oXxI(byte[] first, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(first, "$this$first");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(first);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(first, i);
            if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                return OOXIXo2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] ooO0xXX(int[] reversedArray) {
        IIX0o.x0xO0oo(reversedArray, "$this$reversedArray");
        return XX0xXo.X0o0xo(ArraysKt___ArraysKt.OXxOX(reversedArray));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int ooOIo(short[] sum) {
        IIX0o.x0xO0oo(sum, "$this$sum");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sum);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + xxIO.oOoXoXO(xX0IIXIx0.OOXIXo(sum, i) & OX00O0xII.f29066Oxx0xo));
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int ooOO0I0(int[] single, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(single, "$this$single");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(single);
        xxIO xxio = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(single, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                if (!z) {
                    xxio = xxIO.oxoX(OOXIXo2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return xxio.OO();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short ooOx(short[] component1) {
        IIX0o.x0xO0oo(component1, "$this$component1");
        return xX0IIXIx0.OOXIXo(component1, 0);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void ooOxox(short[] reverse) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.xIXx0(reverse);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final xxIO ooX0xXIoI(int[] reduceRightOrNull, x0xO0oo<? super xxIO, ? super xxIO, xxIO> operation) {
        IIX0o.x0xO0oo(reduceRightOrNull, "$this$reduceRightOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(reduceRightOrNull);
        if (oOIoXOoI < 0) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(reduceRightOrNull, oOIoXOoI);
        for (int i = oOIoXOoI - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(xxIO.oxoX(XX0xXo.OOXIXo(reduceRightOrNull, i)), xxIO.oxoX(OOXIXo2)).OO();
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void ooXXoOx(byte[] reverse) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.ooIxXoX(reverse);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] ooo(long[] plus, long[] elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        return OOXIxO0.X0o0xo(ooOOo0oXI.xX0ox(plus, elements));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R oooO0oo(short[] maxOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWithOrNull, "$this$maxOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(maxOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(maxOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] oooO0ox(int[] iArr) {
        IIX0o.x0xO0oo(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return XX0xXo.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> OX00O0xII oox(short[] minByOrNull, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minByOrNull, "$this$minByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(minByOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(minByOrNull, 0);
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(minByOrNull);
        if (xX0Ox == 0) {
            return OX00O0xII.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(OX00O0xII.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
        while (it.hasNext()) {
            short OOXIXo3 = xX0IIXIx0.OOXIXo(minByOrNull, it.nextInt());
            R invoke2 = selector.invoke(OX00O0xII.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) > 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final OX00O0xII oox000IX(@OOXIXo short[] firstOrNull) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        if (xX0IIXIx0.x0xO0oo(firstOrNull)) {
            return null;
        }
        return OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(firstOrNull, 0));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super XI0oooXX, ? super V>> M ox(long[] associateWithTo, M destination, oOoXoXO<? super XI0oooXX, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWithTo, "$this$associateWithTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(associateWithTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(associateWithTo, i);
            destination.put(XI0oooXX.oxoX(OOXIXo2), valueSelector.invoke(XI0oooXX.oxoX(OOXIXo2)));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int ox0(byte[] indexOfFirst, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfFirst, "$this$indexOfFirst");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(x0xO.oxoX(x0xO.oOoXoXO(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII ox0I(short[] firstOrNull, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(firstOrNull, "$this$firstOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(firstOrNull);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(firstOrNull, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                return OX00O0xII.oxoX(OOXIXo2);
            }
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void ox0xI00IX(short[] reverse, int i, int i2) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.Xo0x0I(reverse, i, i2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<Pair<XI0oooXX, XI0oooXX>> oxI0IX(@OOXIXo long[] zip, @OOXIXo long[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(OOXIxO0.ooOOo0oXI(zip), OOXIxO0.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(Xo0.oIX0oI(XI0oooXX.oxoX(OOXIxO0.OOXIXo(zip, i)), XI0oooXX.oxoX(OOXIxO0.OOXIXo(other, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oxIIOOX(@OOXIXo int[] sortDescending, int i, int i2) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        OIOIxOO(sortDescending, i, i2);
        ArraysKt___ArraysKt.XIX0XxoIo(sortDescending, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short oxIIX0o(short[] component5) {
        IIX0o.x0xO0oo(component5, "$this$component5");
        return xX0IIXIx0.OOXIXo(component5, 4);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<XI0oooXX, R>> oxIO(@OOXIXo long[] zip, @OOXIXo R[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(OOXIxO0.ooOOo0oXI(zip), other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(zip, i);
            arrayList.add(Xo0.oIX0oI(XI0oooXX.oxoX(OOXIXo2), other[i]));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super OX00O0xII>> C oxIO0IIo(short[] filterNotTo, C destination, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNotTo, "$this$filterNotTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(filterNotTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(filterNotTo, i);
            if (!predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(OX00O0xII.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> oxIXXxXx0(int[] takeLastWhile, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(takeLastWhile, "$this$takeLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(takeLastWhile); -1 < oOIoXOoI; oOIoXOoI--) {
            if (!predicate.invoke(xxIO.oxoX(XX0xXo.OOXIXo(takeLastWhile, oOIoXOoI))).booleanValue()) {
                return O00(takeLastWhile, oOIoXOoI + 1);
            }
        }
        return CollectionsKt___CollectionsKt.oOo0o(XX0xXo.II0xO0(takeLastWhile));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int oxO(long[] lastIndexOf, long j) {
        IIX0o.x0xO0oo(lastIndexOf, "$this$lastIndexOf");
        return ArraysKt___ArraysKt.I0Xo(lastIndexOf, j);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float oxOII(long[] maxOfOrNull, oOoXoXO<? super XI0oooXX, Float> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final OX00O0xII oxOIoIx(@OOXIXo short[] getOrNull, int i) {
        IIX0o.x0xO0oo(getOrNull, "$this$getOrNull");
        if (i >= 0 && i <= ArraysKt___ArraysKt.xX0Ox(getOrNull)) {
            return OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(getOrNull, i));
        }
        return null;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> oxOXxoXII(@OOXIXo short[] dropLast, int i) {
        IIX0o.x0xO0oo(dropLast, "$this$dropLast");
        if (i >= 0) {
            return O0XI00X0o(dropLast, IIXOooo.OxxIIOOXO(xX0IIXIx0.ooOOo0oXI(dropLast) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> oxOoIOX(@OOXIXo short[] sorted) {
        IIX0o.x0xO0oo(sorted, "$this$sorted");
        short[] copyOf = Arrays.copyOf(sorted, sorted.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        short[] X0o0xo2 = xX0IIXIx0.X0o0xo(copyOf);
        II(X0o0xo2);
        return II0xO0.oxoX(X0o0xo2);
    }

    public static /* synthetic */ void oxX(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = OO0x0xX.ooOOo0oXI(bArr);
        }
        XoXX(bArr, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte oxX0o(byte[] single) {
        IIX0o.x0xO0oo(single, "$this$single");
        return x0xO.oOoXoXO(ArraysKt___ArraysKt.OIoOo(single));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double oxXIOXO(byte[] maxOf, oOoXoXO<? super x0xO, Double> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(maxOf)) {
            double doubleValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean oxXx0IX(int[] any) {
        IIX0o.x0xO0oo(any, "$this$any");
        return ArraysKt___ArraysKt.xXXxoI(any);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void oxo0x0(@OOXIXo int[] sort) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        if (XX0xXo.ooOOo0oXI(sort) > 1) {
            xoxXI.oOoXoXO(sort, 0, XX0xXo.ooOOo0oXI(sort));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R oxoIOxO(short[] minOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWithOrNull, "$this$minOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(minOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<xxIO, R>> oxoxxo(@OOXIXo int[] zip, @OOXIXo Iterable<? extends R> other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(Xo0.oIX0oI(xxIO.oxoX(XX0xXo.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final OX00O0xII oxxX(short[] randomOrNull) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        return IOxoo(randomOrNull, Random.Default);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean oxxXoxO(int[] all, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(all, "$this$all");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(all);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (!predicate.invoke(xxIO.oxoX(XX0xXo.OOXIXo(all, i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte[] x0(byte[] copyInto, byte[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.O00XxXI(copyInto, destination, i, i2, i3);
        return destination;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final long[] x000OxX(@OOXIXo XI0oooXX[] xI0oooXXArr) {
        IIX0o.x0xO0oo(xI0oooXXArr, "<this>");
        int length = xI0oooXXArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = xI0oooXXArr[i].OO();
        }
        return OOXIxO0.X0o0xo(jArr);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> x00IOx(long[] dropLastWhile, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(dropLastWhile, "$this$dropLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int IOXI = ArraysKt___ArraysKt.IOXI(dropLastWhile); -1 < IOXI; IOXI--) {
            if (!predicate.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(dropLastWhile, IOXI))).booleanValue()) {
                return II0XIox(dropLastWhile, IOXI + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final xxIO x00X(int[] singleOrNull, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(singleOrNull);
        xxIO xxio = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(singleOrNull, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                if (z) {
                    return null;
                }
                xxio = xxIO.oxoX(OOXIXo2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return xxio;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> x00X0xoXO(short[] flatMap, oOoXoXO<? super OX00O0xII, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMap, "$this$flatMap");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(flatMap);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(flatMap, i))));
        }
        return arrayList;
    }

    public static /* synthetic */ void x00o(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = OOXIxO0.ooOOo0oXI(jArr);
        }
        xOII0IIX(jArr, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long x0I(long[] single) {
        IIX0o.x0xO0oo(single, "$this$single");
        return XI0oooXX.oOoXoXO(ArraysKt___ArraysKt.XxOxX00o(single));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final XI0oooXX x0I0(@OOXIXo long[] minOrNull) {
        int compare;
        IIX0o.x0xO0oo(minOrNull, "$this$minOrNull");
        if (OOXIxO0.x0xO0oo(minOrNull)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(minOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOrNull)).iterator();
        while (it.hasNext()) {
            long OOXIXo3 = OOXIxO0.OOXIXo(minOrNull, it.nextInt());
            compare = Long.compare(OOXIXo2 ^ Long.MIN_VALUE, OOXIXo3 ^ Long.MIN_VALUE);
            if (compare > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> xxIO x0Io0(int[] maxByOrNull, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxByOrNull, "$this$maxByOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(maxByOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(maxByOrNull, 0);
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(maxByOrNull);
        if (oOIoXOoI == 0) {
            return xxIO.oxoX(OOXIXo2);
        }
        R invoke = selector.invoke(xxIO.oxoX(OOXIXo2));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int OOXIXo3 = XX0xXo.OOXIXo(maxByOrNull, it.nextInt());
            R invoke2 = selector.invoke(xxIO.oxoX(OOXIXo3));
            if (invoke.compareTo(invoke2) < 0) {
                OOXIXo2 = OOXIXo3;
                invoke = invoke2;
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final x0xO x0Ix0O(@OOXIXo byte[] maxWithOrNull, @OOXIXo Comparator<? super x0xO> comparator) {
        IIX0o.x0xO0oo(maxWithOrNull, "$this$maxWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (OO0x0xX.x0xO0oo(maxWithOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(maxWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            byte OOXIXo3 = OO0x0xX.OOXIXo(maxWithOrNull, it.nextInt());
            if (comparator.compare(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OOXIXo3)) < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> x0O0xO(byte[] runningFold, R r, x0xO0oo<? super R, ? super x0xO, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFold, "$this$runningFold");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(runningFold)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(runningFold) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(runningFold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, x0xO.oxoX(OO0x0xX.OOXIXo(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double x0OI(long[] maxOf, oOoXoXO<? super XI0oooXX, Double> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(maxOf)) {
            double doubleValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(maxOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(maxOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int x0OIX00oO(@OXOo.oOoXoXO byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final x0xO x0OOI(byte[] findLast, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(findLast, "$this$findLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(findLast) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                byte OOXIXo2 = OO0x0xX.OOXIXo(findLast, ooOOo0oXI2);
                if (predicate.invoke(x0xO.oxoX(OOXIXo2)).booleanValue()) {
                    return x0xO.oxoX(OOXIXo2);
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        return null;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<Pair<xxIO, xxIO>> x0OOxoo(@OOXIXo int[] zip, @OOXIXo int[] other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int min = Math.min(XX0xXo.ooOOo0oXI(zip), XX0xXo.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(Xo0.oIX0oI(xxIO.oxoX(XX0xXo.OOXIXo(zip, i)), xxIO.oxoX(XX0xXo.OOXIXo(other, i))));
        }
        return arrayList;
    }

    public static /* synthetic */ short[] x0OxxIOxX(short[] copyInto, short[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = xX0IIXIx0.ooOOo0oXI(copyInto);
        }
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.xoO0xx0(copyInto, destination, i, i2, i3);
        return destination;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] x0X0OIOx(@OOXIXo x0xO[] x0xoArr) {
        IIX0o.x0xO0oo(x0xoArr, "<this>");
        int length = x0xoArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = x0xoArr[i].I0oOIX();
        }
        return OO0x0xX.X0o0xo(bArr);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int[] x0XOxo(@OOXIXo int[] sliceArray, @OOXIXo Collection<Integer> indices) {
        IIX0o.x0xO0oo(sliceArray, "$this$sliceArray");
        IIX0o.x0xO0oo(indices, "indices");
        return XX0xXo.X0o0xo(ArraysKt___ArraysKt.XXIXOOX(sliceArray, indices));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<XI0oooXX> x0Xox(long[] runningReduce, x0xO0oo<? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(runningReduce, "$this$runningReduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(runningReduce)) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(runningReduce, 0);
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(runningReduce));
        arrayList.add(XI0oooXX.oxoX(OOXIXo2));
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(runningReduce);
        for (int i = 1; i < ooOOo0oXI2; i++) {
            OOXIXo2 = operation.invoke(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(runningReduce, i))).OO();
            arrayList.add(XI0oooXX.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] x0oo(long[] toLongArray) {
        IIX0o.x0xO0oo(toLongArray, "$this$toLongArray");
        long[] copyOf = Arrays.copyOf(toLongArray, toLongArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return copyOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R x0ooOIxO(byte[] minOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWithOrNull, "$this$minOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(minOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII x0oox0(short[] findLast, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(findLast, "$this$findLast");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(findLast) - 1;
        if (ooOOo0oXI2 >= 0) {
            while (true) {
                int i = ooOOo0oXI2 - 1;
                short OOXIXo2 = xX0IIXIx0.OOXIXo(findLast, ooOOo0oXI2);
                if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                    return OX00O0xII.oxoX(OOXIXo2);
                }
                if (i < 0) {
                    break;
                }
                ooOOo0oXI2 = i;
            }
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> x0oxIIIX(long[] filterIndexed, x0xO0oo<? super Integer, ? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexed, "$this$filterIndexed");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            long OOXIXo2 = OOXIxO0.OOXIXo(filterIndexed, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(XI0oooXX.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R x0x(long[] minOfOrNull, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(minOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] x0xO(long[] jArr) {
        IIX0o.x0xO0oo(jArr, "<this>");
        return OOXIxO0.X0o0xo(jArr);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, List<V>> x0xOIoO(long[] groupBy, oOoXoXO<? super XI0oooXX, ? extends K> keySelector, oOoXoXO<? super XI0oooXX, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(XI0oooXX.oxoX(OOXIXo2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(XI0oooXX.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void x0xoIx0(@OOXIXo short[] sortDescending, int i, int i2) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        IxxXI0o(sortDescending, i, i2);
        ArraysKt___ArraysKt.Xo0x0I(sortDescending, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xI0OXooO(short[] indexOf, short s) {
        IIX0o.x0xO0oo(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.Oo0OxoOx(indexOf, s);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "maxByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> int xI0Ooxx0x(int[] maxBy, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(maxBy)) {
            int OOXIXo2 = XX0xXo.OOXIXo(maxBy, 0);
            int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(maxBy);
            if (oOIoXOoI == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(xxIO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(xxIO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte xI0oxI00(byte[] component5) {
        IIX0o.x0xO0oo(component5, "$this$component5");
        return OO0x0xX.OOXIXo(component5, 4);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final <R> List<Pair<OX00O0xII, R>> xIIO(@OOXIXo short[] zip, @OOXIXo Iterable<? extends R> other) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(Xo0.oIX0oI(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R xIIoO(byte[] maxOf, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(maxOf)) {
            R invoke = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOf, it.nextInt())));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final xxIO xIO(@OOXIXo int[] randomOrNull, @OOXIXo Random random) {
        IIX0o.x0xO0oo(randomOrNull, "$this$randomOrNull");
        IIX0o.x0xO0oo(random, "random");
        if (XX0xXo.x0xO0oo(randomOrNull)) {
            return null;
        }
        return xxIO.oxoX(XX0xXo.OOXIXo(randomOrNull, random.nextInt(XX0xXo.ooOOo0oXI(randomOrNull))));
    }

    @xxIXOIIO(name = "maxOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final short xIOI0xO(@OOXIXo short[] max) {
        IIX0o.x0xO0oo(max, "$this$max");
        if (!xX0IIXIx0.x0xO0oo(max)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(max, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(max)).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(max, it.nextInt());
                if (IIX0o.oI0IIXIo(OOXIXo2 & OX00O0xII.f29066Oxx0xo, 65535 & OOXIXo3) < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final float xIOOIO(byte[] minOf, oOoXoXO<? super x0xO, Float> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(minOf)) {
            float floatValue = selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOf, 0))).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOf)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOf, it.nextInt()))).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> xIOXX(byte[] filterIndexed, x0xO0oo<? super Integer, ? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexed, "$this$filterIndexed");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(filterIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(filterIndexed, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), x0xO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(x0xO.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xxIXOIIO(name = "sumOfUInt")
    @oxxXoxO(version = "1.5")
    public static final int xIX0XOOX(@OOXIXo xxIO[] xxioArr) {
        IIX0o.x0xO0oo(xxioArr, "<this>");
        int i = 0;
        for (xxIO xxio : xxioArr) {
            i = xxIO.oOoXoXO(i + xxio.OO());
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super xxIO>> C xIXIOX(int[] filterIndexedTo, C destination, x0xO0oo<? super Integer, ? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexedTo, "$this$filterIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            int OOXIXo2 = XX0xXo.OOXIXo(filterIndexedTo, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), xxIO.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(xxIO.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short xIXOoI(short[] first, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(first, "$this$first");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(first);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(first, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                return OOXIXo2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> xIXX(@OOXIXo byte[] drop, int i) {
        IIX0o.x0xO0oo(drop, "$this$drop");
        if (i >= 0) {
            return IO0Xox(drop, IIXOooo.OxxIIOOXO(OO0x0xX.ooOOo0oXI(drop) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "minByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> long xIXXIo(long[] minBy, oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OOXIxO0.x0xO0oo(minBy)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(minBy, 0);
            int IOXI = ArraysKt___ArraysKt.IOXI(minBy);
            if (IOXI == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(XI0oooXX.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void xIXoO0Xx(long[] jArr) {
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "minByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> short xIo0xoOOx(short[] minBy, oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!xX0IIXIx0.x0xO0oo(minBy)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(minBy, 0);
            int xX0Ox = ArraysKt___ArraysKt.xX0Ox(minBy);
            if (xX0Ox == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(OX00O0xII.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(OX00O0xII.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> List<R> xIoXXXIXo(short[] flatMapIndexed, x0xO0oo<? super Integer, ? super OX00O0xII, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(flatMapIndexed, "$this$flatMapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(flatMapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(flatMapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    public static /* synthetic */ void xIx(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = OOXIxO0.ooOOo0oXI(jArr);
        }
        xOOxI(jArr, j, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void xIx0XO(@OOXIXo short[] fill, short s, int i, int i2) {
        IIX0o.x0xO0oo(fill, "$this$fill");
        ooOOo0oXI.oX0ooo0I0(fill, s, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> xIxooxXX(short[] filterNot, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNot, "$this$filterNot");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(filterNot);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(filterNot, i);
            if (!predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(OX00O0xII.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final xxIO[] xIxxxX0O(@OOXIXo int[] toTypedArray) {
        IIX0o.x0xO0oo(toTypedArray, "$this$toTypedArray");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(toTypedArray);
        xxIO[] xxioArr = new xxIO[ooOOo0oXI2];
        for (int i = 0; i < ooOOo0oXI2; i++) {
            xxioArr[i] = xxIO.oxoX(XX0xXo.OOXIXo(toTypedArray, i));
        }
        return xxioArr;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xO(int[] single) {
        IIX0o.x0xO0oo(single, "$this$single");
        return xxIO.oOoXoXO(ArraysKt___ArraysKt.x0oo0I(single));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, V> List<V> xO0x(short[] zip, Iterable<? extends R> other, x0xO0oo<? super OX00O0xII, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(zip);
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), ooOOo0oXI2));
        int i = 0;
        for (R r : other) {
            if (i >= ooOOo0oXI2) {
                break;
            }
            arrayList.add(transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(zip, i)), r));
            i++;
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte[] xO0x00ox(byte[] onEach, oOoXoXO<? super x0xO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(onEach, "$this$onEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(onEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(onEach, i)));
        }
        return onEach;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xOI0(int[] last) {
        IIX0o.x0xO0oo(last, "$this$last");
        return xxIO.oOoXoXO(ArraysKt___ArraysKt.XIXIo0OX(last));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void xOII0IIX(@OOXIXo long[] sort, int i, int i2) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, OOXIxO0.ooOOo0oXI(sort));
        xoxXI.xxIXOIIO(sort, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> xOIIOoO(int[] takeWhile, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(takeWhile, "$this$takeWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(takeWhile);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(takeWhile, i);
            if (!predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                break;
            }
            arrayList.add(xxIO.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> List<R> xOIO(int[] mapIndexed, x0xO0oo<? super Integer, ? super xxIO, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexed, "$this$mapIndexed");
        IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(mapIndexed));
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(mapIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), xxIO.oxoX(XX0xXo.OOXIXo(mapIndexed, i))));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final Iterable<xI<XI0oooXX>> xOIXxOo(@OOXIXo final long[] withIndex) {
        IIX0o.x0xO0oo(withIndex, "$this$withIndex");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends XI0oooXX>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final Iterator<? extends XI0oooXX> invoke() {
                return OOXIxO0.Oo(withIndex);
            }
        });
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C xOIx00(byte[] mapTo, C destination, oOoXoXO<? super x0xO, ? extends R> transform) {
        IIX0o.x0xO0oo(mapTo, "$this$mapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(mapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            destination.add(transform.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(mapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short xOOOX(short[] component2) {
        IIX0o.x0xO0oo(component2, "$this$component2");
        return xX0IIXIx0.OOXIXo(component2, 1);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void xOOxI(@OOXIXo long[] fill, long j, int i, int i2) {
        IIX0o.x0xO0oo(fill, "$this$fill");
        ooOOo0oXI.x00IOx(fill, j, i, i2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> xOOxIO(@OOXIXo long[] drop, int i) {
        IIX0o.x0xO0oo(drop, "$this$drop");
        if (i >= 0) {
            return Xo000XO0(drop, IIXOooo.OxxIIOOXO(OOXIxO0.ooOOo0oXI(drop) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> xOOxIoOoO(@OOXIXo long[] slice, @OOXIXo Iterable<Integer> indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(XI0oooXX.oxoX(OOXIxO0.OOXIXo(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @xxIXOIIO(name = "maxOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final byte xOOxX(@OOXIXo byte[] max) {
        IIX0o.x0xO0oo(max, "$this$max");
        if (!OO0x0xX.x0xO0oo(max)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(max, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(max)).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(max, it.nextInt());
                if (IIX0o.oI0IIXIo(OOXIXo2 & 255, OOXIXo3 & 255) < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final x0xO xOXI(byte[] reduceRightOrNull, x0xO0oo<? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceRightOrNull, "$this$reduceRightOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(reduceRightOrNull);
        if (xxXIIXIxx < 0) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(reduceRightOrNull, xxXIIXIxx);
        for (int i = xxXIIXIxx - 1; i >= 0; i--) {
            OOXIXo2 = operation.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(reduceRightOrNull, i)), x0xO.oxoX(OOXIXo2)).I0oOIX();
        }
        return x0xO.oxoX(OOXIXo2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R xOXoxI(byte[] maxOfWithOrNull, Comparator<? super R> comparator, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfWithOrNull, "$this$maxOfWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(maxOfWithOrNull)) {
            return null;
        }
        Object obj = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfWithOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(maxOfWithOrNull, it.nextInt())));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean xOo(int[] none) {
        IIX0o.x0xO0oo(none, "$this$none");
        return XX0xXo.x0xO0oo(none);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void xOoIIIoXI(int[] forEach, oOoXoXO<? super xxIO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEach, "$this$forEach");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(forEach);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            action.invoke(xxIO.oxoX(XX0xXo.OOXIXo(forEach, i)));
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte xOoOIoI(byte[] component4) {
        IIX0o.x0xO0oo(component4, "$this$component4");
        return OO0x0xX.OOXIXo(component4, 3);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xOx(long[] indexOf, long j) {
        IIX0o.x0xO0oo(indexOf, "$this$indexOf");
        return ArraysKt___ArraysKt.XxxoIooX(indexOf, j);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final void xOxOoo(byte[] forEachIndexed, x0xO0oo<? super Integer, ? super x0xO, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(forEachIndexed, "$this$forEachIndexed");
        IIX0o.x0xO0oo(action, "action");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(forEachIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            action.invoke(Integer.valueOf(i2), x0xO.oxoX(OO0x0xX.OOXIXo(forEachIndexed, i)));
            i++;
            i2++;
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final x0xO xOxxIxxI0(byte[] reduceIndexedOrNull, Oox.IXxxXO<? super Integer, ? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(reduceIndexedOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(reduceIndexedOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), x0xO.oxoX(OOXIXo2), x0xO.oxoX(OO0x0xX.OOXIXo(reduceIndexedOrNull, nextInt))).I0oOIX();
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] xOxxO(@OOXIXo byte[] sortedArray) {
        IIX0o.x0xO0oo(sortedArray, "$this$sortedArray");
        if (OO0x0xX.x0xO0oo(sortedArray)) {
            return sortedArray;
        }
        byte[] copyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        byte[] X0o0xo2 = OO0x0xX.X0o0xo(copyOf);
        OX0xI0IO(X0o0xo2);
        return X0o0xo2;
    }

    @OOXIXo
    public static final X0.oOoXoXO xOxxXO(@OOXIXo int[] indices) {
        IIX0o.x0xO0oo(indices, "$this$indices");
        return ArraysKt___ArraysKt.OIOXo(indices);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> xX(int[] dropLastWhile, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(dropLastWhile, "$this$dropLastWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(dropLastWhile); -1 < oOIoXOoI; oOIoXOoI--) {
            if (!predicate.invoke(xxIO.oxoX(XX0xXo.OOXIXo(dropLastWhile, oOIoXOoI))).booleanValue()) {
                return oOIxIIoI(dropLastWhile, oOIoXOoI + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void xX0(@OOXIXo long[] sort) {
        IIX0o.x0xO0oo(sort, "$this$sort");
        if (OOXIxO0.ooOOo0oXI(sort) > 1) {
            xoxXI.xxIXOIIO(sort, 0, OOXIxO0.ooOOo0oXI(sort));
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long xX0IIXIx0(long[] component2) {
        IIX0o.x0xO0oo(component2, "$this$component2");
        return OOXIxO0.OOXIXo(component2, 1);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R xX0ox(byte[] fold, R r, x0xO0oo<? super R, ? super x0xO, ? extends R> operation) {
        IIX0o.x0xO0oo(fold, "$this$fold");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(fold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, x0xO.oxoX(OO0x0xX.OOXIXo(fold, i)));
        }
        return r;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xX0xI(short[] runningFoldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super OX00O0xII, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFoldIndexed, "$this$runningFoldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(runningFoldIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(runningFoldIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(runningFoldIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(runningFoldIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void xXIO(int[] reverse, int i, int i2) {
        IIX0o.x0xO0oo(reverse, "$this$reverse");
        ArraysKt___ArraysKt.XIX0XxoIo(reverse, i, i2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xXIX0Xo(int[] indexOfFirst, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(indexOfFirst, "$this$indexOfFirst");
        IIX0o.x0xO0oo(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(xxIO.oxoX(xxIO.oOoXoXO(indexOfFirst[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @xxIXOIIO(name = "minWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final int xXIxxo0x(@OOXIXo int[] minWith, @OOXIXo Comparator<? super xxIO> comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!XX0xXo.x0xO0oo(minWith)) {
            int OOXIXo2 = XX0xXo.OOXIXo(minWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minWith)).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(minWith, it.nextInt());
                if (comparator.compare(xxIO.oxoX(OOXIXo2), xxIO.oxoX(OOXIXo3)) > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R xXO0oXX(int[] maxOf, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOf, "$this$maxOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(maxOf)) {
            R invoke = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOf, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOf)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOf, it.nextInt())));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float xXOO(long[] minOfOrNull, oOoXoXO<? super XI0oooXX, Float> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(minOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(minOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(minOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final XI0oooXX[] xXOOx(@OOXIXo long[] toTypedArray) {
        IIX0o.x0xO0oo(toTypedArray, "$this$toTypedArray");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(toTypedArray);
        XI0oooXX[] xI0oooXXArr = new XI0oooXX[ooOOo0oXI2];
        for (int i = 0; i < ooOOo0oXI2; i++) {
            xI0oooXXArr[i] = XI0oooXX.oxoX(OOXIxO0.OOXIXo(toTypedArray, i));
        }
        return xI0oooXXArr;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean xXOx(byte[] any, oOoXoXO<? super x0xO, Boolean> predicate) {
        IIX0o.x0xO0oo(any, "$this$any");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(any);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            if (predicate.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(any, i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfInt")
    @X00IoxXI
    @XO
    public static final int xXXI0IX00(int[] sumOf, oOoXoXO<? super xxIO, Integer> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        int i = 0;
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i += selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i2))).intValue();
        }
        return i;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final x0xO xXXXox(@OOXIXo byte[] minOrNull) {
        IIX0o.x0xO0oo(minOrNull, "$this$minOrNull");
        if (OO0x0xX.x0xO0oo(minOrNull)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(minOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOrNull)).iterator();
        while (it.hasNext()) {
            byte OOXIXo3 = OO0x0xX.OOXIXo(minOrNull, it.nextInt());
            if (IIX0o.oI0IIXIo(OOXIXo2 & 255, OOXIXo3 & 255) > 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final Iterable<xI<x0xO>> xXXXxOOI0(@OOXIXo final byte[] withIndex) {
        IIX0o.x0xO0oo(withIndex, "$this$withIndex");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends x0xO>>() { // from class: kotlin.collections.unsigned.UArraysKt___UArraysKt$withIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OOXIXo
            public final Iterator<? extends x0xO> invoke() {
                return OO0x0xX.Oo(withIndex);
            }
        });
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final OX00O0xII xXXxoI(short[] lastOrNull, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(lastOrNull) - 1;
        if (ooOOo0oXI2 < 0) {
            return null;
        }
        while (true) {
            int i = ooOOo0oXI2 - 1;
            short OOXIXo2 = xX0IIXIx0.OOXIXo(lastOrNull, ooOOo0oXI2);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                return OX00O0xII.oxoX(OOXIXo2);
            }
            if (i >= 0) {
                ooOOo0oXI2 = i;
            } else {
                return null;
            }
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long xXo(long[] first) {
        IIX0o.x0xO0oo(first, "$this$first");
        return XI0oooXX.oOoXoXO(ArraysKt___ArraysKt.ooO00o(first));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> xXoIx00(short[] scan, R r, x0xO0oo<? super R, ? super OX00O0xII, ? extends R> operation) {
        IIX0o.x0xO0oo(scan, "$this$scan");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(scan)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(scan) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(scan);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] xXoOI00O(short[] copyInto, short[] destination, int i, int i2, int i3) {
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.xoO0xx0(copyInto, destination, i, i2, i3);
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final xxIO xXx0x0(@OOXIXo int[] maxWithOrNull, @OOXIXo Comparator<? super xxIO> comparator) {
        IIX0o.x0xO0oo(maxWithOrNull, "$this$maxWithOrNull");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (XX0xXo.x0xO0oo(maxWithOrNull)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(maxWithOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            int OOXIXo3 = XX0xXo.OOXIXo(maxWithOrNull, it.nextInt());
            if (comparator.compare(xxIO.oxoX(OOXIXo2), xxIO.oxoX(OOXIXo3)) < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @xxIXOIIO(name = "minWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final byte xXxIoIXX0(@OOXIXo byte[] minWith, @OOXIXo Comparator<? super x0xO> comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!OO0x0xX.x0xO0oo(minWith)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(minWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minWith)).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(minWith, it.nextInt());
                if (comparator.compare(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OOXIXo3)) > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> xXxIxo(byte[] scan, R r, x0xO0oo<? super R, ? super x0xO, ? extends R> operation) {
        IIX0o.x0xO0oo(scan, "$this$scan");
        IIX0o.x0xO0oo(operation, "operation");
        if (OO0x0xX.x0xO0oo(scan)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OO0x0xX.ooOOo0oXI(scan) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(scan);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, x0xO.oxoX(OO0x0xX.OOXIXo(scan, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> xXxx(long[] scanIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super XI0oooXX, ? extends R> operation) {
        IIX0o.x0xO0oo(scanIndexed, "$this$scanIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (OOXIxO0.x0xO0oo(scanIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(OOXIxO0.ooOOo0oXI(scanIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(scanIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, XI0oooXX.oxoX(OOXIxO0.OOXIXo(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super OX00O0xII>> C xo(short[] filterIndexedTo, C destination, x0xO0oo<? super Integer, ? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(filterIndexedTo, "$this$filterIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(filterIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(filterIndexedTo, i);
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(OX00O0xII.oxoX(OOXIXo2));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <V> List<V> xo000(short[] zip, short[] other, x0xO0oo<? super OX00O0xII, ? super OX00O0xII, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(xX0IIXIx0.ooOOo0oXI(zip), xX0IIXIx0.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(zip, i)), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(other, i))));
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> xo0Io0Ooo(@OOXIXo int[] sortedDescending) {
        IIX0o.x0xO0oo(sortedDescending, "$this$sortedDescending");
        int[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        int[] X0o0xo2 = XX0xXo.X0o0xo(copyOf);
        oxo0x0(X0o0xo2);
        return O0o0OI00(X0o0xo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xo0XO(int[] runningFold, R r, x0xO0oo<? super R, ? super xxIO, ? extends R> operation) {
        IIX0o.x0xO0oo(runningFold, "$this$runningFold");
        IIX0o.x0xO0oo(operation, "operation");
        if (XX0xXo.x0xO0oo(runningFold)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(XX0xXo.ooOOo0oXI(runningFold) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(runningFold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, xxIO.oxoX(XX0xXo.OOXIXo(runningFold, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> xo0oXIOO(@OOXIXo byte[] slice, @OOXIXo X0.oOoXoXO indices) {
        IIX0o.x0xO0oo(slice, "$this$slice");
        IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return II0xO0.II0xO0(OO0x0xX.X0o0xo(ooOOo0oXI.xxOXOOoIX(slice, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1)));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final boolean xo0x(byte[] any) {
        IIX0o.x0xO0oo(any, "$this$any");
        return ArraysKt___ArraysKt.Oo0IXI0(any);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> xo0xII0II(@OOXIXo short[] takeLast, int i) {
        IIX0o.x0xO0oo(takeLast, "$this$takeLast");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(takeLast);
            if (i >= ooOOo0oXI2) {
                return CollectionsKt___CollectionsKt.oOo0o(xX0IIXIx0.II0xO0(takeLast));
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(takeLast, ooOOo0oXI2 - 1)));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = ooOOo0oXI2 - i; i2 < ooOOo0oXI2; i2++) {
                arrayList.add(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(takeLast, i2)));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final short[] xoI(@OOXIXo short[] plus, @OOXIXo Collection<OX00O0xII> elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(plus);
        short[] copyOf = Arrays.copyOf(plus, xX0IIXIx0.ooOOo0oXI(plus) + elements.size());
        IIX0o.oO(copyOf, "copyOf(...)");
        Iterator<OX00O0xII> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[ooOOo0oXI2] = it.next().I0oOIX();
            ooOOo0oXI2++;
        }
        return xX0IIXIx0.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final OX00O0xII xoIIIOI(@OOXIXo short[] maxOrNull) {
        IIX0o.x0xO0oo(maxOrNull, "$this$maxOrNull");
        if (xX0IIXIx0.x0xO0oo(maxOrNull)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(maxOrNull, 0);
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxOrNull)).iterator();
        while (it.hasNext()) {
            short OOXIXo3 = xX0IIXIx0.OOXIXo(maxOrNull, it.nextInt());
            if (IIX0o.oI0IIXIo(OOXIXo2 & OX00O0xII.f29066Oxx0xo, 65535 & OOXIXo3) < 0) {
                OOXIXo2 = OOXIXo3;
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R xoIXOxX(int[] fold, R r, x0xO0oo<? super R, ? super xxIO, ? extends R> operation) {
        IIX0o.x0xO0oo(fold, "$this$fold");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(fold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, xxIO.oxoX(XX0xXo.OOXIXo(fold, i)));
        }
        return r;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oI0IIXIo
    @oxxXoxO(version = "1.5")
    @xxIXOIIO(name = "sumOfUInt")
    @X00IoxXI
    @XO
    public static final int xoIooI0(int[] sumOf, oOoXoXO<? super xxIO, xxIO> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i))).OO());
        }
        return oOoXoXO2;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int[] xoIxX(int[] iArr) {
        IIX0o.x0xO0oo(iArr, "<this>");
        return XX0xXo.X0o0xo(iArr);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Float xoO0(short[] minOfOrNull, oOoXoXO<? super OX00O0xII, Float> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(minOfOrNull)) {
            return null;
        }
        float floatValue = selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfOrNull, 0))).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(minOfOrNull)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(minOfOrNull, it.nextInt()))).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xxIXOIIO(name = "sumOfUByte")
    @oxxXoxO(version = "1.5")
    public static final int xoO0X(@OOXIXo x0xO[] x0xoArr) {
        IIX0o.x0xO0oo(x0xoArr, "<this>");
        int i = 0;
        for (x0xO x0xo : x0xoArr) {
            i = xxIO.oOoXoXO(i + xxIO.oOoXoXO(x0xo.I0oOIX() & 255));
        }
        return i;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xoO0xx0(int[] component2) {
        IIX0o.x0xO0oo(component2, "$this$component2");
        return XX0xXo.OOXIXo(component2, 1);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final double xoOI00O0X(int[] minOf, oOoXoXO<? super xxIO, Double> selector) {
        IIX0o.x0xO0oo(minOf, "$this$minOf");
        IIX0o.x0xO0oo(selector, "selector");
        if (!XX0xXo.x0xO0oo(minOf)) {
            double doubleValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOf, 0))).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOf)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOf, it.nextInt()))).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long xoOX00(long[] reduceIndexed, Oox.IXxxXO<? super Integer, ? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduceIndexed, "$this$reduceIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (!OOXIxO0.x0xO0oo(reduceIndexed)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(reduceIndexed, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(reduceIndexed)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                OOXIXo2 = operation.invoke(Integer.valueOf(nextInt), XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduceIndexed, nextInt))).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final Double xoOx(int[] minOfOrNull, oOoXoXO<? super xxIO, Double> selector) {
        IIX0o.x0xO0oo(minOfOrNull, "$this$minOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(minOfOrNull)) {
            return null;
        }
        double doubleValue = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfOrNull, 0))).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(minOfOrNull)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(minOfOrNull, it.nextInt()))).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super XI0oooXX>> C xoX(long[] filterTo, C destination, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(filterTo, "$this$filterTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(filterTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(filterTo, i);
            if (predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(XI0oooXX.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short xoXXXIX(short[] single, oOoXoXO<? super OX00O0xII, Boolean> predicate) {
        IIX0o.x0xO0oo(single, "$this$single");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(single);
        OX00O0xII oX00O0xII = null;
        boolean z = false;
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(single, i);
            if (predicate.invoke(OX00O0xII.oxoX(OOXIXo2)).booleanValue()) {
                if (!z) {
                    oX00O0xII = OX00O0xII.oxoX(OOXIXo2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return oX00O0xII.I0oOIX();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @xxIXOIIO(name = "maxWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final int xooXo(@OOXIXo int[] maxWith, @OOXIXo Comparator<? super xxIO> comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!XX0xXo.x0xO0oo(maxWith)) {
            int OOXIXo2 = XX0xXo.OOXIXo(maxWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxWith)).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(maxWith, it.nextInt());
                if (comparator.compare(xxIO.oxoX(OOXIXo2), xxIO.oxoX(OOXIXo3)) < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R xooxxX(short[] fold, R r, x0xO0oo<? super R, ? super OX00O0xII, ? extends R> operation) {
        IIX0o.x0xO0oo(fold, "$this$fold");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(fold);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(r, OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(fold, i)));
        }
        return r;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <V> List<V> xooxxo(long[] zip, long[] other, x0xO0oo<? super XI0oooXX, ? super XI0oooXX, ? extends V> transform) {
        IIX0o.x0xO0oo(zip, "$this$zip");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(OOXIxO0.ooOOo0oXI(zip), OOXIxO0.ooOOo0oXI(other));
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(zip, i)), XI0oooXX.oxoX(OOXIxO0.OOXIXo(other, i))));
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> xox(int[] filterNot, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterNot, "$this$filterNot");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(filterNot);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(filterNot, i);
            if (!predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                arrayList.add(xxIO.oxoX(OOXIXo2));
            }
        }
        return arrayList;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> xoxX(long[] takeWhile, oOoXoXO<? super XI0oooXX, Boolean> predicate) {
        IIX0o.x0xO0oo(takeWhile, "$this$takeWhile");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(takeWhile);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            long OOXIXo2 = OOXIxO0.OOXIXo(takeWhile, i);
            if (!predicate.invoke(XI0oooXX.oxoX(OOXIXo2)).booleanValue()) {
                break;
            }
            arrayList.add(XI0oooXX.oxoX(OOXIXo2));
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void xoxX0I(@OOXIXo int[] shuffle) {
        IIX0o.x0xO0oo(shuffle, "$this$shuffle");
        XOOxX(shuffle, Random.Default);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long[] xoxXI(long[] asLongArray) {
        IIX0o.x0xO0oo(asLongArray, "$this$asLongArray");
        return asLongArray;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int xoxXoXO(@OOXIXo int[] random, @OOXIXo Random random2) {
        IIX0o.x0xO0oo(random, "$this$random");
        IIX0o.x0xO0oo(random2, "random");
        if (!XX0xXo.x0xO0oo(random)) {
            return XX0xXo.OOXIXo(random, random2.nextInt(XX0xXo.ooOOo0oXI(random)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, List<V>> xoxo(short[] groupBy, oOoXoXO<? super OX00O0xII, ? extends K> keySelector, oOoXoXO<? super OX00O0xII, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(groupBy, "$this$groupBy");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(groupBy);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(groupBy, i);
            K invoke = keySelector.invoke(OX00O0xII.oxoX(OOXIXo2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(OX00O0xII.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    public static final int xx(@OOXIXo long[] lastIndex) {
        IIX0o.x0xO0oo(lastIndex, "$this$lastIndex");
        return ArraysKt___ArraysKt.IOXI(lastIndex);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <C extends Collection<? super xxIO>> C xx0(int[] filterTo, C destination, oOoXoXO<? super xxIO, Boolean> predicate) {
        IIX0o.x0xO0oo(filterTo, "$this$filterTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(filterTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(filterTo, i);
            if (predicate.invoke(xxIO.oxoX(OOXIXo2)).booleanValue()) {
                destination.add(xxIO.oxoX(OOXIXo2));
            }
        }
        return destination;
    }

    @IIX0(markerClass = {IXxxXO.class})
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO
    public static final <R> List<R> xx00OX(short[] scanIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super OX00O0xII, ? extends R> operation) {
        IIX0o.x0xO0oo(scanIndexed, "$this$scanIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        if (xX0IIXIx0.x0xO0oo(scanIndexed)) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xX0IIXIx0.ooOOo0oXI(scanIndexed) + 1);
        arrayList.add(r);
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(scanIndexed);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            r = operation.invoke(Integer.valueOf(i), r, OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(scanIndexed, i)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static /* synthetic */ void xx00oOoI(byte[] bArr) {
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final OX00O0xII xx0O(@OOXIXo short[] lastOrNull) {
        IIX0o.x0xO0oo(lastOrNull, "$this$lastOrNull");
        if (xX0IIXIx0.x0xO0oo(lastOrNull)) {
            return null;
        }
        return OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(lastOrNull, xX0IIXIx0.ooOOo0oXI(lastOrNull) - 1));
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int xx0X0(int[] component5) {
        IIX0o.x0xO0oo(component5, "$this$component5");
        return XX0xXo.OOXIXo(component5, 4);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short xx0XoXxI(short[] reduceRightIndexed, Oox.IXxxXO<? super Integer, ? super OX00O0xII, ? super OX00O0xII, OX00O0xII> operation) {
        IIX0o.x0xO0oo(reduceRightIndexed, "$this$reduceRightIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(reduceRightIndexed);
        if (xX0Ox >= 0) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(reduceRightIndexed, xX0Ox);
            for (int i = xX0Ox - 1; i >= 0; i--) {
                OOXIXo2 = operation.invoke(Integer.valueOf(i), OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(reduceRightIndexed, i)), OX00O0xII.oxoX(OOXIXo2)).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R xx0o0O(int[] foldIndexed, R r, Oox.IXxxXO<? super Integer, ? super R, ? super xxIO, ? extends R> operation) {
        IIX0o.x0xO0oo(foldIndexed, "$this$foldIndexed");
        IIX0o.x0xO0oo(operation, "operation");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(foldIndexed);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, xxIO.oxoX(XX0xXo.OOXIXo(foldIndexed, i)));
            i++;
            i2++;
        }
        return r;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte xxI0x(byte[] reduce, x0xO0oo<? super x0xO, ? super x0xO, x0xO> operation) {
        IIX0o.x0xO0oo(reduce, "$this$reduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (!OO0x0xX.x0xO0oo(reduce)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(reduce, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(reduce)).iterator();
            while (it.hasNext()) {
                OOXIXo2 = operation.invoke(x0xO.oxoX(OOXIXo2), x0xO.oxoX(OO0x0xX.OOXIXo(reduce, it.nextInt()))).I0oOIX();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<xxIO, V> xxIO(int[] associateWith, oOoXoXO<? super xxIO, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(associateWith, "$this$associateWith");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(IIXOooo.OxxIIOOXO(OI0.xoIox(XX0xXo.ooOOo0oXI(associateWith)), 16));
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(associateWith);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            int OOXIXo2 = XX0xXo.OOXIXo(associateWith, i);
            linkedHashMap.put(xxIO.oxoX(OOXIXo2), valueSelector.invoke(xxIO.oxoX(OOXIXo2)));
        }
        return linkedHashMap;
    }

    @xxIXOIIO(name = "minOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final int xxIOxXI(@OOXIXo int[] min) {
        int compare;
        IIX0o.x0xO0oo(min, "$this$min");
        if (!XX0xXo.x0xO0oo(min)) {
            int OOXIXo2 = XX0xXo.OOXIXo(min, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(min)).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(min, it.nextInt());
                compare = Integer.compare(OOXIXo2 ^ Integer.MIN_VALUE, OOXIXo3 ^ Integer.MIN_VALUE);
                if (compare > 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void xxOOXo(@OOXIXo short[] sortDescending) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        if (xX0IIXIx0.ooOOo0oXI(sortDescending) > 1) {
            II(sortDescending);
            ArraysKt___ArraysKt.xIXx0(sortDescending);
        }
    }

    public static /* synthetic */ long[] xxOXOOoIX(long[] copyInto, long[] destination, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = OOXIxO0.ooOOo0oXI(copyInto);
        }
        IIX0o.x0xO0oo(copyInto, "$this$copyInto");
        IIX0o.x0xO0oo(destination, "destination");
        ooOOo0oXI.I0(copyInto, destination, i, i2, i3);
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    @xxIXOIIO(name = "maxByOrThrow-U")
    @XO
    public static final <R extends Comparable<? super R>> byte xxOoXO(byte[] maxBy, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(maxBy)) {
            byte OOXIXo2 = OO0x0xX.OOXIXo(maxBy, 0);
            int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(maxBy);
            if (xxXIIXIxx == 0) {
                return OOXIXo2;
            }
            R invoke = selector.invoke(x0xO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(x0xO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @xxIXOIIO(name = "maxWithOrThrow-U")
    @oI0IIXIo
    @oxxXoxO(version = "1.7")
    public static final short xxX0X(@OOXIXo short[] maxWith, @OOXIXo Comparator<? super OX00O0xII> comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        if (!xX0IIXIx0.x0xO0oo(maxWith)) {
            short OOXIXo2 = xX0IIXIx0.OOXIXo(maxWith, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xX0Ox(maxWith)).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(maxWith, it.nextInt());
                if (comparator.compare(OX00O0xII.oxoX(OOXIXo2), OX00O0xII.oxoX(OOXIXo3)) < 0) {
                    OOXIXo2 = OOXIXo3;
                }
            }
            return OOXIXo2;
        }
        throw new NoSuchElementException();
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short[] xxXI(short[] sArr) {
        IIX0o.x0xO0oo(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        return xX0IIXIx0.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final void xxXX0(@OOXIXo int[] sortDescending) {
        IIX0o.x0xO0oo(sortDescending, "$this$sortDescending");
        if (XX0xXo.ooOOo0oXI(sortDescending) > 1) {
            oxo0x0(sortDescending);
            ArraysKt___ArraysKt.XxxI(sortDescending);
        }
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R xxXXXxIxo(short[] foldRight, R r, x0xO0oo<? super OX00O0xII, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRight, "$this$foldRight");
        IIX0o.x0xO0oo(operation, "operation");
        for (int xX0Ox = ArraysKt___ArraysKt.xX0Ox(foldRight); xX0Ox >= 0; xX0Ox--) {
            r = operation.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(foldRight, xX0Ox)), r);
        }
        return r;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R extends Comparable<? super R>> R xxXooOI(int[] maxOfOrNull, oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxOfOrNull, "$this$maxOfOrNull");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(maxOfOrNull)) {
            return null;
        }
        R invoke = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfOrNull, 0)));
        oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.oOIoXOoI(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(maxOfOrNull, it.nextInt())));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final byte[] xxXxI(@OOXIXo byte[] plus, @OOXIXo Collection<x0xO> elements) {
        IIX0o.x0xO0oo(plus, "$this$plus");
        IIX0o.x0xO0oo(elements, "elements");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(plus);
        byte[] copyOf = Arrays.copyOf(plus, OO0x0xX.ooOOo0oXI(plus) + elements.size());
        IIX0o.oO(copyOf, "copyOf(...)");
        Iterator<x0xO> it = elements.iterator();
        while (it.hasNext()) {
            copyOf[ooOOo0oXI2] = it.next().I0oOIX();
            ooOOo0oXI2++;
        }
        return OO0x0xX.X0o0xo(copyOf);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long xxo00(long[] reduce, x0xO0oo<? super XI0oooXX, ? super XI0oooXX, XI0oooXX> operation) {
        IIX0o.x0xO0oo(reduce, "$this$reduce");
        IIX0o.x0xO0oo(operation, "operation");
        if (!OOXIxO0.x0xO0oo(reduce)) {
            long OOXIXo2 = OOXIxO0.OOXIXo(reduce, 0);
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.IOXI(reduce)).iterator();
            while (it.hasNext()) {
                OOXIXo2 = operation.invoke(XI0oooXX.oxoX(OOXIXo2), XI0oooXX.oxoX(OOXIxO0.OOXIXo(reduce, it.nextInt()))).OO();
            }
            return OOXIXo2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> xxo0o(@OOXIXo short[] sortedDescending) {
        IIX0o.x0xO0oo(sortedDescending, "$this$sortedDescending");
        short[] copyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        IIX0o.oO(copyOf, "copyOf(...)");
        short[] X0o0xo2 = xX0IIXIx0.X0o0xo(copyOf);
        II(X0o0xo2);
        return OIIxOxx(X0o0xo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C xxoXO(long[] mapTo, C destination, oOoXoXO<? super XI0oooXX, ? extends R> transform) {
        IIX0o.x0xO0oo(mapTo, "$this$mapTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(mapTo);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            destination.add(transform.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(mapTo, i))));
        }
        return destination;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @OXOo.oOoXoXO
    public static final OX00O0xII xxoxO0O(@OOXIXo short[] singleOrNull) {
        IIX0o.x0xO0oo(singleOrNull, "$this$singleOrNull");
        if (xX0IIXIx0.ooOOo0oXI(singleOrNull) == 1) {
            return OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(singleOrNull, 0));
        }
        return null;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R, C extends Collection<? super R>> C xxx(int[] mapIndexedTo, C destination, x0xO0oo<? super Integer, ? super xxIO, ? extends R> transform) {
        IIX0o.x0xO0oo(mapIndexedTo, "$this$mapIndexedTo");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(mapIndexedTo);
        int i = 0;
        int i2 = 0;
        while (i < ooOOo0oXI2) {
            destination.add(transform.invoke(Integer.valueOf(i2), xxIO.oxoX(XX0xXo.OOXIXo(mapIndexedTo, i))));
            i++;
            i2++;
        }
        return destination;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long xxx00(long[] elementAtOrElse, int i, oOoXoXO<? super Integer, XI0oooXX> defaultValue) {
        IIX0o.x0xO0oo(elementAtOrElse, "$this$elementAtOrElse");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= ArraysKt___ArraysKt.IOXI(elementAtOrElse)) {
            return OOXIxO0.OOXIXo(elementAtOrElse, i);
        }
        return defaultValue.invoke(Integer.valueOf(i)).OO();
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> xxxI(@OOXIXo short[] drop, int i) {
        IIX0o.x0xO0oo(drop, "$this$drop");
        if (i >= 0) {
            return xo0xII0II(drop, IIXOooo.OxxIIOOXO(xX0IIXIx0.ooOOo0oXI(drop) - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final <R> R xxxoo0XI(byte[] foldRight, R r, x0xO0oo<? super x0xO, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(foldRight, "$this$foldRight");
        IIX0o.x0xO0oo(operation, "operation");
        for (int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(foldRight); xxXIIXIxx >= 0; xxXIIXIxx--) {
            r = operation.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(foldRight, xxXIIXIxx)), r);
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @X00IoxXI
    @XO
    public static final <R> R xxxxxo(byte[] minOfWith, Comparator<? super R> comparator, oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minOfWith, "$this$minOfWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        if (!OO0x0xX.x0xO0oo(minOfWith)) {
            Object obj = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfWith, 0)));
            oOXoIIIo it = new X0.oOoXoXO(1, ArraysKt___ArraysKt.xxXIIXIxx(minOfWith)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(minOfWith, it.nextInt())));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }
}
