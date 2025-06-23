package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.IIX0;
import kotlin.Pair;
import kotlin.XI0oooXX;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.xxIO;
import xX0ox.Oxx0IOOO;

@kotlin.jvm.internal.XX({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,24423:1\n12524#1,2:24424\n12534#1,2:24426\n1282#1,2:24428\n1290#1,2:24430\n1298#1,2:24432\n1306#1,2:24434\n1314#1,2:24436\n1322#1,2:24438\n1330#1,2:24440\n1338#1,2:24442\n1346#1,2:24444\n2298#1,5:24446\n2311#1,5:24451\n2324#1,5:24456\n2337#1,5:24461\n2350#1,5:24466\n2363#1,5:24471\n2376#1,5:24476\n2389#1,5:24481\n2402#1,5:24486\n4307#1,2:24492\n4317#1,2:24494\n4327#1,2:24496\n4337#1,2:24498\n4347#1,2:24500\n4357#1,2:24502\n4367#1,2:24504\n4377#1,2:24506\n4387#1,2:24508\n3974#1:24510\n13374#1,2:24511\n3975#1,2:24513\n13376#1:24515\n3977#1:24516\n3988#1:24517\n13384#1,2:24518\n3989#1,2:24520\n13386#1:24522\n3991#1:24523\n4002#1:24524\n13394#1,2:24525\n4003#1,2:24527\n13396#1:24529\n4005#1:24530\n4016#1:24531\n13404#1,2:24532\n4017#1,2:24534\n13406#1:24536\n4019#1:24537\n4030#1:24538\n13414#1,2:24539\n4031#1,2:24541\n13416#1:24543\n4033#1:24544\n4044#1:24545\n13424#1,2:24546\n4045#1,2:24548\n13426#1:24550\n4047#1:24551\n4058#1:24552\n13434#1,2:24553\n4059#1,2:24555\n13436#1:24557\n4061#1:24558\n4072#1:24559\n13444#1,2:24560\n4073#1,2:24562\n13446#1:24564\n4075#1:24565\n4086#1:24566\n13454#1,2:24567\n4087#1,2:24569\n13456#1:24571\n4089#1:24572\n13374#1,3:24573\n13384#1,3:24576\n13394#1,3:24579\n13404#1,3:24582\n13414#1,3:24585\n13424#1,3:24588\n13434#1,3:24591\n13444#1,3:24594\n13454#1,3:24597\n4107#1,2:24600\n4217#1,2:24602\n4227#1,2:24604\n4237#1,2:24606\n4247#1,2:24608\n4257#1,2:24610\n4267#1,2:24612\n4277#1,2:24614\n4287#1,2:24616\n4297#1,2:24618\n9088#1,4:24620\n9103#1,4:24624\n9118#1,4:24628\n9133#1,4:24632\n9148#1,4:24636\n9163#1,4:24640\n9178#1,4:24644\n9193#1,4:24648\n9208#1,4:24652\n8801#1,4:24656\n8817#1,4:24660\n8833#1,4:24664\n8849#1,4:24668\n8865#1,4:24672\n8881#1,4:24676\n8897#1,4:24680\n8913#1,4:24684\n8929#1,4:24688\n8945#1,4:24692\n8961#1,4:24696\n8977#1,4:24700\n8993#1,4:24704\n9009#1,4:24708\n9025#1,4:24712\n9041#1,4:24716\n9057#1,4:24720\n9073#1,4:24724\n9376#1,4:24728\n10394#1,5:24732\n10405#1,5:24737\n10416#1,5:24742\n10427#1,5:24747\n10438#1,5:24752\n10449#1,5:24757\n10460#1,5:24762\n10471#1,5:24767\n10482#1,5:24772\n10497#1,5:24777\n10738#1,3:24782\n10741#1,3:24792\n10755#1,3:24795\n10758#1,3:24805\n10772#1,3:24808\n10775#1,3:24818\n10789#1,3:24821\n10792#1,3:24831\n10806#1,3:24834\n10809#1,3:24844\n10823#1,3:24847\n10826#1,3:24857\n10840#1,3:24860\n10843#1,3:24870\n10857#1,3:24873\n10860#1,3:24883\n10874#1,3:24886\n10877#1,3:24896\n10892#1,3:24899\n10895#1,3:24909\n10910#1,3:24912\n10913#1,3:24922\n10928#1,3:24925\n10931#1,3:24935\n10946#1,3:24938\n10949#1,3:24948\n10964#1,3:24951\n10967#1,3:24961\n10982#1,3:24964\n10985#1,3:24974\n11000#1,3:24977\n11003#1,3:24987\n11018#1,3:24990\n11021#1,3:25000\n11036#1,3:25003\n11039#1,3:25013\n11400#1,3:25142\n11410#1,3:25145\n11420#1,3:25148\n11430#1,3:25151\n11440#1,3:25154\n11450#1,3:25157\n11460#1,3:25160\n11470#1,3:25163\n11480#1,3:25166\n11266#1,4:25169\n11279#1,4:25173\n11292#1,4:25177\n11305#1,4:25181\n11318#1,4:25185\n11331#1,4:25189\n11344#1,4:25193\n11357#1,4:25197\n11370#1,4:25201\n11255#1:25205\n13374#1,2:25206\n13376#1:25209\n11256#1:25210\n13374#1,3:25211\n11391#1:25214\n13309#1:25215\n13310#1:25217\n11392#1:25218\n13309#1,2:25219\n13374#1,3:25221\n13384#1,3:25224\n13394#1,3:25227\n13404#1,3:25230\n13414#1,3:25233\n13424#1,3:25236\n13434#1,3:25239\n13444#1,3:25242\n13454#1,3:25245\n20623#1,2:25248\n20625#1,6:25251\n20839#1,2:25257\n20841#1,6:25260\n23035#1,6:25266\n23051#1,6:25272\n23067#1,6:25278\n23083#1,6:25284\n23099#1,6:25290\n23115#1,6:25296\n23131#1,6:25302\n23147#1,6:25308\n23163#1,6:25314\n23269#1,8:25320\n23287#1,8:25328\n23305#1,8:25336\n23323#1,8:25344\n23341#1,8:25352\n23359#1,8:25360\n23377#1,8:25368\n23395#1,8:25376\n23413#1,8:25384\n23511#1,6:25392\n23527#1,6:25398\n23543#1,6:25404\n23559#1,6:25410\n23575#1,6:25416\n23591#1,6:25422\n23607#1,6:25428\n23623#1,6:25434\n1#2:24491\n1#2:25208\n1#2:25216\n1#2:25250\n1#2:25259\n372#3,7:24785\n372#3,7:24798\n372#3,7:24811\n372#3,7:24824\n372#3,7:24837\n372#3,7:24850\n372#3,7:24863\n372#3,7:24876\n372#3,7:24889\n372#3,7:24902\n372#3,7:24915\n372#3,7:24928\n372#3,7:24941\n372#3,7:24954\n372#3,7:24967\n372#3,7:24980\n372#3,7:24993\n372#3,7:25006\n372#3,7:25016\n372#3,7:25023\n372#3,7:25030\n372#3,7:25037\n372#3,7:25044\n372#3,7:25051\n372#3,7:25058\n372#3,7:25065\n372#3,7:25072\n372#3,7:25079\n372#3,7:25086\n372#3,7:25093\n372#3,7:25100\n372#3,7:25107\n372#3,7:25114\n372#3,7:25121\n372#3,7:25128\n372#3,7:25135\n*S KotlinDebug\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n556#1:24424,2\n565#1:24426,2\n832#1:24428,2\n842#1:24430,2\n852#1:24432,2\n862#1:24434,2\n872#1:24436,2\n882#1:24438,2\n892#1:24440,2\n902#1:24442,2\n912#1:24444,2\n922#1:24446,5\n932#1:24451,5\n942#1:24456,5\n952#1:24461,5\n962#1:24466,5\n972#1:24471,5\n982#1:24476,5\n992#1:24481,5\n1002#1:24486,5\n3792#1:24492,2\n3801#1:24494,2\n3810#1:24496,2\n3819#1:24498,2\n3828#1:24500,2\n3837#1:24502,2\n3846#1:24504,2\n3855#1:24506,2\n3864#1:24508,2\n3875#1:24510\n3875#1:24511,2\n3875#1:24513,2\n3875#1:24515\n3875#1:24516\n3886#1:24517\n3886#1:24518,2\n3886#1:24520,2\n3886#1:24522\n3886#1:24523\n3897#1:24524\n3897#1:24525,2\n3897#1:24527,2\n3897#1:24529\n3897#1:24530\n3908#1:24531\n3908#1:24532,2\n3908#1:24534,2\n3908#1:24536\n3908#1:24537\n3919#1:24538\n3919#1:24539,2\n3919#1:24541,2\n3919#1:24543\n3919#1:24544\n3930#1:24545\n3930#1:24546,2\n3930#1:24548,2\n3930#1:24550\n3930#1:24551\n3941#1:24552\n3941#1:24553,2\n3941#1:24555,2\n3941#1:24557\n3941#1:24558\n3952#1:24559\n3952#1:24560,2\n3952#1:24562,2\n3952#1:24564\n3952#1:24565\n3963#1:24566\n3963#1:24567,2\n3963#1:24569,2\n3963#1:24571\n3963#1:24572\n3974#1:24573,3\n3988#1:24576,3\n4002#1:24579,3\n4016#1:24582,3\n4030#1:24585,3\n4044#1:24588,3\n4058#1:24591,3\n4072#1:24594,3\n4086#1:24597,3\n4098#1:24600,2\n4117#1:24602,2\n4126#1:24604,2\n4135#1:24606,2\n4144#1:24608,2\n4153#1:24610,2\n4162#1:24612,2\n4171#1:24614,2\n4180#1:24616,2\n4189#1:24618,2\n8407#1:24620,4\n8422#1:24624,4\n8437#1:24628,4\n8452#1:24632,4\n8467#1:24636,4\n8482#1:24640,4\n8497#1:24644,4\n8512#1:24648,4\n8527#1:24652,4\n8542#1:24656,4\n8557#1:24660,4\n8572#1:24664,4\n8587#1:24668,4\n8602#1:24672,4\n8617#1:24676,4\n8632#1:24680,4\n8647#1:24684,4\n8662#1:24688,4\n8676#1:24692,4\n8690#1:24696,4\n8704#1:24700,4\n8718#1:24704,4\n8732#1:24708,4\n8746#1:24712,4\n8760#1:24716,4\n8774#1:24720,4\n8788#1:24724,4\n9227#1:24728,4\n9972#1:24732,5\n9981#1:24737,5\n9990#1:24742,5\n9999#1:24747,5\n10008#1:24752,5\n10017#1:24757,5\n10026#1:24762,5\n10035#1:24767,5\n10044#1:24772,5\n10057#1:24777,5\n10513#1:24782,3\n10513#1:24792,3\n10525#1:24795,3\n10525#1:24805,3\n10537#1:24808,3\n10537#1:24818,3\n10549#1:24821,3\n10549#1:24831,3\n10561#1:24834,3\n10561#1:24844,3\n10573#1:24847,3\n10573#1:24857,3\n10585#1:24860,3\n10585#1:24870,3\n10597#1:24873,3\n10597#1:24883,3\n10609#1:24886,3\n10609#1:24896,3\n10622#1:24899,3\n10622#1:24909,3\n10635#1:24912,3\n10635#1:24922,3\n10648#1:24925,3\n10648#1:24935,3\n10661#1:24938,3\n10661#1:24948,3\n10674#1:24951,3\n10674#1:24961,3\n10687#1:24964,3\n10687#1:24974,3\n10700#1:24977,3\n10700#1:24987,3\n10713#1:24990,3\n10713#1:25000,3\n10726#1:25003,3\n10726#1:25013,3\n11065#1:25142,3\n11075#1:25145,3\n11085#1:25148,3\n11095#1:25151,3\n11105#1:25154,3\n11115#1:25157,3\n11125#1:25160,3\n11135#1:25163,3\n11145#1:25166,3\n11155#1:25169,4\n11165#1:25173,4\n11175#1:25177,4\n11185#1:25181,4\n11195#1:25185,4\n11205#1:25189,4\n11215#1:25193,4\n11225#1:25197,4\n11235#1:25201,4\n11245#1:25205\n11245#1:25206,2\n11245#1:25209\n11245#1:25210\n11255#1:25211,3\n11383#1:25214\n11383#1:25215\n11383#1:25217\n11383#1:25218\n11391#1:25219,2\n18891#1:25221,3\n18903#1:25224,3\n18915#1:25227,3\n18927#1:25230,3\n18939#1:25233,3\n18951#1:25236,3\n18963#1:25239,3\n18975#1:25242,3\n18987#1:25245,3\n21455#1:25248,2\n21455#1:25251,6\n21617#1:25257,2\n21617#1:25260,6\n22944#1:25266,6\n22954#1:25272,6\n22964#1:25278,6\n22974#1:25284,6\n22984#1:25290,6\n22994#1:25296,6\n23004#1:25302,6\n23014#1:25308,6\n23024#1:25314,6\n23178#1:25320,8\n23188#1:25328,8\n23198#1:25336,8\n23208#1:25344,8\n23218#1:25352,8\n23228#1:25360,8\n23238#1:25368,8\n23248#1:25376,8\n23258#1:25384,8\n23430#1:25392,6\n23440#1:25398,6\n23450#1:25404,6\n23460#1:25410,6\n23470#1:25416,6\n23480#1:25422,6\n23490#1:25428,6\n23500#1:25434,6\n11245#1:25208\n11383#1:25216\n21455#1:25250\n21617#1:25259\n10513#1:24785,7\n10525#1:24798,7\n10537#1:24811,7\n10549#1:24824,7\n10561#1:24837,7\n10573#1:24850,7\n10585#1:24863,7\n10597#1:24876,7\n10609#1:24889,7\n10622#1:24902,7\n10635#1:24915,7\n10648#1:24928,7\n10661#1:24941,7\n10674#1:24954,7\n10687#1:24967,7\n10700#1:24980,7\n10713#1:24993,7\n10726#1:25006,7\n10740#1:25016,7\n10757#1:25023,7\n10774#1:25030,7\n10791#1:25037,7\n10808#1:25044,7\n10825#1:25051,7\n10842#1:25058,7\n10859#1:25065,7\n10876#1:25072,7\n10894#1:25079,7\n10912#1:25086,7\n10930#1:25093,7\n10948#1:25100,7\n10966#1:25107,7\n10984#1:25114,7\n11002#1:25121,7\n11020#1:25128,7\n11038#1:25135,7\n*E\n"})
/* loaded from: classes6.dex */
public class ArraysKt___ArraysKt extends kotlin.collections.ooOOo0oXI {

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23982#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class I0Io implements Iterable<Short>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ short[] f29089XO;

        public I0Io(short[] sArr) {
            this.f29089XO = sArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.II0XooXoX(this.f29089XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24022#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0XooXoX implements Iterable<Boolean>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ boolean[] f29090XO;

        public II0XooXoX(boolean[] zArr) {
            this.f29090XO = zArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.oIX0oI(this.f29090XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23974#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0 implements Iterable<Byte>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ byte[] f29091XO;

        public II0xO0(byte[] bArr) {
            this.f29091XO = bArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.II0xO0(this.f29091XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24110#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class IXxxXO implements kotlin.sequences.ooOOo0oXI<Boolean> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ boolean[] f29092oIX0oI;

        public IXxxXO(boolean[] zArr) {
            this.f29092oIX0oI = zArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.oIX0oI(this.f29092oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24050#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class OOXIXo implements kotlin.sequences.ooOOo0oXI<Byte> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ byte[] f29093oIX0oI;

        public OOXIXo(byte[] bArr) {
            this.f29093oIX0oI = bArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.II0xO0(this.f29093oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24014#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Oxx0IOOO implements Iterable<Double>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ double[] f29094XO;

        public Oxx0IOOO(double[] dArr) {
            this.f29094XO = dArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.oxoX(this.f29094XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24120#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Oxx0xo implements kotlin.sequences.ooOOo0oXI<Character> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ char[] f29095oIX0oI;

        public Oxx0xo(char[] cArr) {
            this.f29095oIX0oI = cArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.I0Io(this.f29095oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23998#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class X0o0xo implements Iterable<Long>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ long[] f29096XO;

        public X0o0xo(long[] jArr) {
            this.f29096XO = jArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.Oxx0IOOO(this.f29096XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24006#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class XO implements Iterable<Float>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ float[] f29097XO;

        public XO(float[] fArr) {
            this.f29097XO = fArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.X0o0xo(this.f29097XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt$groupingBy$1\n*L\n1#1,24423:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oI0IIXIo<K, T> implements XxX0x0xxx<T, K> {

        /* renamed from: II0xO0 */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f29098II0xO0;

        /* renamed from: oIX0oI */
        public final /* synthetic */ T[] f29099oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oI0IIXIo(T[] tArr, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f29099oIX0oI = tArr;
            this.f29098II0xO0 = oooxoxo;
        }

        @Override // kotlin.collections.XxX0x0xxx
        @OXOo.OOXIXo
        public Iterator<T> II0xO0() {
            return kotlin.jvm.internal.II0XooXoX.oIX0oI(this.f29099oIX0oI);
        }

        @Override // kotlin.collections.XxX0x0xxx
        public K oIX0oI(T t) {
            return this.f29098II0xO0.invoke(t);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23966#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements Iterable<T>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ Object[] f29100XO;

        public oIX0oI(Object[] objArr) {
            this.f29100XO = objArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.II0XooXoX.oIX0oI(this.f29100XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24090#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oO implements kotlin.sequences.ooOOo0oXI<Float> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ float[] f29101oIX0oI;

        public oO(float[] fArr) {
            this.f29101oIX0oI = fArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.X0o0xo(this.f29101oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24060#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oOoXoXO implements kotlin.sequences.ooOOo0oXI<Short> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ short[] f29102oIX0oI;

        public oOoXoXO(short[] sArr) {
            this.f29102oIX0oI = sArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.II0XooXoX(this.f29102oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24070#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class ooOOo0oXI implements kotlin.sequences.ooOOo0oXI<Integer> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ int[] f29103oIX0oI;

        public ooOOo0oXI(int[] iArr) {
            this.f29103oIX0oI = iArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.XO(this.f29103oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23990#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oxoX implements Iterable<Integer>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ int[] f29104XO;

        public oxoX(int[] iArr) {
            this.f29104XO = iArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.XO(this.f29104XO);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24080#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class x0XOIxOo implements kotlin.sequences.ooOOo0oXI<Long> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ long[] f29105oIX0oI;

        public x0XOIxOo(long[] jArr) {
            this.f29105oIX0oI = jArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.Oxx0IOOO(this.f29105oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24100#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class x0xO0oo implements kotlin.sequences.ooOOo0oXI<Double> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ double[] f29106oIX0oI;

        public x0xO0oo(double[] dArr) {
            this.f29106oIX0oI = dArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.oxoX(this.f29106oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24040#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class xoIox<T> implements kotlin.sequences.ooOOo0oXI<T> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ Object[] f29107oIX0oI;

        public xoIox(Object[] objArr) {
            this.f29107oIX0oI = objArr;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.II0XooXoX.oIX0oI(this.f29107oIX0oI);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24030#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class xxIXOIIO implements Iterable<Character>, OI0IXox.oIX0oI {

        /* renamed from: XO */
        public final /* synthetic */ char[] f29108XO;

        public xxIXOIIO(char[] cArr) {
            this.f29108XO = cArr;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.xxIXOIIO.I0Io(this.f29108XO);
        }
    }

    @OXOo.OOXIXo
    public static final List<Float> I00(@OXOo.OOXIXo float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (i >= 0) {
            return xXoIo00O(fArr, X0.IIXOooo.OxxIIOOXO(fArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final List<Boolean> I000(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.IIXOooo(kotlin.collections.ooOOo0oXI.XOxxooXI(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float I0000OXo0(float[] fArr, Oox.oOoXoXO<? super Float, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Boolean I000OoII(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int XXoXOI = XXoXOI(zArr);
        if (XXoXOI == 0) {
            return Boolean.valueOf(z);
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            R invoke2 = selector.invoke(Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) > 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M I000X(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (double d : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final boolean I00I(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                boolean z = zArr[length];
                if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                    return z;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long I00XI0o(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.nextInt(jArr.length)]);
    }

    @xx0o0O.XO
    public static final boolean I00XxoO(char[] cArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final boolean I00oOXO0O(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @xx0o0O.XO
    public static final byte I00oX(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr[4];
    }

    @OXOo.OOXIXo
    public static final List<Double> I00x0xO(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.X00IxOx(copyOf);
        return o0oX0000(copyOf);
    }

    public static final float I0I(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length != 0) {
            float f = fArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                f = operation.invoke(Float.valueOf(f), Float.valueOf(fArr[it.nextInt()])).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @xx0o0O.XO
    public static final boolean I0I0IoIXO(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return true;
        }
        return false;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Character, V> I0IIXxxo(char[] cArr, Oox.oOoXoXO<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(X0.IIXOooo.XI0IXoo(cArr.length, 128)), 16));
        for (char c : cArr) {
            linkedHashMap.put(Character.valueOf(c), valueSelector.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    public static final boolean I0IXXXX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    public static int I0IoX00I(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final byte I0IxIoOoX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (bArr.length != 0) {
            byte b = bArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) < 0) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Long> I0O(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Comparator<? super Long> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Long[] xOI02 = kotlin.collections.ooOOo0oXI.xOI0(jArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(xOI02, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(xOI02);
    }

    public static final boolean I0O00OI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double I0OI0XxX(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final Set<Byte> I0OOxXXIx(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return (Set) xXxxOxI0I(bArr, new LinkedHashSet(OI0.xoIox(bArr.length)));
    }

    @OXOo.OOXIXo
    public static final List<Integer> I0OXXIoX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(xII0oI(iArr));
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double I0Oo0XXo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i : iArr) {
            d += selector.invoke(Integer.valueOf(i)).doubleValue();
        }
        return d;
    }

    public static final void I0X(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Float, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i]));
            i++;
            i2++;
        }
    }

    @xx0o0O.XO
    public static final char I0X0Ox(char[] cArr, int i, Oox.oOoXoXO<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= IoOIIOx(cArr)) {
            return cArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).charValue();
    }

    @OXOo.OOXIXo
    public static final List<Double> I0X0o0O(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Short> I0XIOxO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new oOoXoXO(sArr);
    }

    public static final char I0XIOxXXX(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @xx0o0O.XO
    public static final Integer I0XOIOO0I(int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return xOx0oO(iArr, i);
    }

    @xx0o0O.XO
    public static final Byte I0XOx(byte[] bArr, Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T> T[] I0XX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return (T[]) kotlin.collections.ooOOo0oXI.IO0XoXxO(tArr, 0, 0);
        }
        return (T[]) kotlin.collections.ooOOo0oXI.IO0XoXxO(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static int I0Xo(@OXOo.OOXIXo long[] jArr, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (j == jArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final List<Short> I0XoOIO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int xX0Ox = xX0Ox(sArr); -1 < xX0Ox; xX0Ox--) {
            if (!predicate.invoke(Short.valueOf(sArr[xX0Ox])).booleanValue()) {
                return o0oXooOxO(sArr, xX0Ox + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @xx0o0O.XO
    public static final int I0o(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr[2];
    }

    @OXOo.oOoXoXO
    public static final Boolean I0o0xoIIx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final int I0oIII0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (iArr.length != 0) {
            int i = iArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) < 0) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    public static final void I0oIXI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length > 1) {
            kotlin.collections.ooOOo0oXI.xOxOoo(iArr);
            XxxI(iArr);
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int I0oIXo(long[] jArr, Oox.oOoXoXO<? super Long, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (long j : jArr) {
            i += selector.invoke(Long.valueOf(j)).intValue();
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float I0oOI0O(float[] fArr, Oox.oOoXoXO<? super Float, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final List<Float> I0oo(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        Float[] Xxx0oXX2 = kotlin.collections.ooOOo0oXI.Xxx0oXX(fArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(Xxx0oXX2);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(Xxx0oXX2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R I0oo0X0Xo(char[] cArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> T[] I0oooO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(tArr2, xX0ox.Oxx0IOOO.o00());
        return tArr2;
    }

    @xx0o0O.XO
    public static final float I0ox0(float[] fArr, int i, Oox.oOoXoXO<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= oXIX(fArr)) {
            return fArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).floatValue();
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Boolean>> C I0x0IOXO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
        }
        return destination;
    }

    public static final double I0xI0oI(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final List<Byte> I0xO(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.X0x(copyOf);
        return ooXxX(copyOf);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double I0xX0I(int[] iArr, Oox.oOoXoXO<? super Integer, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (int i : iArr) {
            d += selector.invoke(Integer.valueOf(i)).doubleValue();
        }
        return d;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float I0xoO(short[] sArr, Oox.oOoXoXO<? super Short, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <K> List<Character> I0xoOOIx(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (hashSet.add(selector.invoke(Character.valueOf(c)))) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float I0xxIxxI(int[] iArr, Oox.oOoXoXO<? super Integer, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Byte>> C II(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final Iterable<Boolean> II0(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new II0XooXoX(zArr);
    }

    public static final void II00O0IoI(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length > 1) {
            kotlin.collections.ooOOo0oXI.xOoIIIoXI(fArr);
            IoI0O0(fArr);
        }
    }

    @OXOo.OOXIXo
    public static final List<Integer> II0IoxIxX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Integer[] XXoO0oX2 = kotlin.collections.ooOOo0oXI.XXoO0oX(iArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(XXoO0oX2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(XXoO0oX2);
    }

    @OXOo.OOXIXo
    public static final <V> List<V> II0OIo0X(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo char[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i]), Character.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Float II0XIox(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C II0XOIoOO(boolean[] zArr, C destination, Oox.x0xO0oo<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final float II0Xx(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (fArr.length != 0) {
            return fArr[random.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R III0I(T[] tArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            Object obj = (R) selector.invoke(tArr[0]);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(tArr[it.nextInt()]);
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> IIIOO0(float[] fArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r);
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Float.valueOf(fArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> IIIX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Float.valueOf(fArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final byte[] IIIXOoxX(@OXOo.OOXIXo Byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    @OXOo.oOoXoXO
    public static final Character IIIXXXII(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    public static final double IIIo0Xo(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (int i2 : iArr) {
            d += i2;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> IIIxxOO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final <T> T IIO(T[] tArr, int i, Oox.oOoXoXO<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= o0IXO(tArr)) {
            return tArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> IIO0OOo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i]), other[i]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M IIO0X0I(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static short[] IIOOI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            sArr2[i] = sArr[it.next().intValue()];
            i++;
        }
        return sArr2;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Byte>> C IIOXx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Byte.valueOf(b)).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double IIOx(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            d = Math.max(d, dArr[it.nextInt()]);
        }
        return Double.valueOf(d);
    }

    public static /* synthetic */ Appendable IIX(boolean[] zArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return xIxO0X0I(zArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    public static final boolean IIXOxIxOo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <T> X0.oOoXoXO IIXOxX(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return new X0.oOoXoXO(0, o0IXO(tArr));
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IIXo(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @xx0o0O.XO
    public static final int IIXxoXXox(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr[4];
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Byte, R>> IIo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            byte b = bArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Byte.valueOf(b), other[i]));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R, C extends Collection<? super R>> C IIo0I0X0(T[] tArr, C destination, Oox.x0xO0oo<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return destination;
    }

    public static final <T> int IIoIIxx(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float IIoO0x(float[] fArr, Oox.oOoXoXO<? super Float, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C IIoOIO0(Object[] objArr, C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(objArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (Object obj : objArr) {
            kotlin.jvm.internal.IIX0o.OxI(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> IIoX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i]), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Character> IIx(@OXOo.OOXIXo char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (i >= 0) {
            return Ix00x(cArr, X0.IIXOooo.OxxIIOOXO(cArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final Set<Character> IIx0x0I(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Iterable<Character> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Character> Xox = Xox(cArr);
        OxI.XIo0oOXIx(Xox, other);
        return Xox;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> IIxO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T IIxO0oXo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            T t = tArr[0];
            int o0IXO = o0IXO(tArr);
            if (o0IXO == 0) {
                return t;
            }
            R invoke = selector.invoke(t);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) > 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    @OXOo.oOoXoXO
    public static final Short IIxOxOx0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return Short.valueOf(s);
            }
        }
        return null;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int IIxoXo(float[] fArr, Oox.oOoXoXO<? super Float, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (float f : fArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Float.valueOf(f)).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static final List<Short> IIxxOXX(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.IOXOxOII(copyOf);
        return XxX0XOxoI(copyOf);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double IIxxXX(long[] jArr, Oox.oOoXoXO<? super Long, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C IO0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    public static /* synthetic */ String IO00(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return o0OXIoI(cArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    public static final <R> R IO0000X0X(@OXOo.OOXIXo char[] cArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Character.valueOf(cArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @xx0o0O.XO
    public static final short IO00xOx0(short[] sArr, int i, Oox.oOoXoXO<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= xX0Ox(sArr)) {
            return sArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).shortValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R IO0OIoI(float[] fArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Set<Long> IO0X(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return (Set) ooxIIII(jArr, new LinkedHashSet(OI0.xoIox(jArr.length)));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> IO0XIIxo(float[] fArr, R r, Oox.x0xO0oo<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r);
        for (float f : fArr) {
            r = operation.invoke(r, Float.valueOf(f));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Float IO0Xox(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return Float.valueOf(f);
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final List<Byte> IO0o(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (byte b : bArr) {
            if (z) {
                arrayList.add(Byte.valueOf(b));
            } else if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
                z = true;
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double IO0xO(float[] fArr, Oox.oOoXoXO<? super Float, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void IOI0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int xxXIIXIxx = xxXIIXIxx(bArr); xxXIIXIxx > 0; xxXIIXIxx--) {
            int nextInt = random.nextInt(xxXIIXIxx + 1);
            byte b = bArr[xxXIIXIxx];
            bArr[xxXIIXIxx] = bArr[nextInt];
            bArr[nextInt] = b;
        }
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> IOI0XII(short[] sArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r);
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Short.valueOf(sArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <R> R IOI0XxIo(@OXOo.OOXIXo boolean[] zArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int XXoXOI = XXoXOI(zArr); XXoXOI >= 0; XXoXOI--) {
            r = operation.invoke(Boolean.valueOf(zArr[XXoXOI]), r);
        }
        return r;
    }

    public static final <R> R IOIOO0(@OXOo.OOXIXo boolean[] zArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Boolean.valueOf(zArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    public static final <R> R IOIOooXOx(@OXOo.OOXIXo short[] sArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int xX0Ox = xX0Ox(sArr); xX0Ox >= 0; xX0Ox--) {
            r = operation.invoke(Short.valueOf(sArr[xX0Ox]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Character>> C IOIXIoo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (char c : cArr) {
            destination.add(Character.valueOf(c));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, R, V> List<V> IOIooX00(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(tArr[i], r));
            i++;
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IOIxx(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R IOO(boolean[] zArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static byte[] IOOI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr2[i] = bArr[it.next().intValue()];
            i++;
        }
        return bArr2;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final short IOOIo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (sArr.length != 0) {
            return sArr[random.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float IOOIx(int[] iArr, Oox.oOoXoXO<? super Integer, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final List<Integer> IOOOI(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int oOIoXOoI = oOIoXOoI(iArr); -1 < oOIoXOoI; oOIoXOoI--) {
            if (!predicate.invoke(Integer.valueOf(iArr[oOIoXOoI])).booleanValue()) {
                return xX0OOIO(iArr, oOIoXOoI + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @xx0o0O.XO
    public static final long IOOx(long[] jArr, int i, Oox.oOoXoXO<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= IOXI(jArr)) {
            return jArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).longValue();
    }

    @OXOo.OOXIXo
    public static final List<Long> IOOxII0o(@OXOo.OOXIXo long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= jArr.length) {
                return OoxIx(jArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Long.valueOf(jArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (long j : jArr) {
                arrayList.add(Long.valueOf(j));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final <R> R IOOxxIox(@OXOo.OOXIXo int[] iArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int oOIoXOoI = oOIoXOoI(iArr); oOIoXOoI >= 0; oOIoXOoI--) {
            r = operation.invoke(Integer.valueOf(oOIoXOoI), Integer.valueOf(iArr[oOIoXOoI]), r);
        }
        return r;
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final boolean IOX0Oox(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                boolean z2 = zArr[it.nextInt()];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                    z = z2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double IOX0Xo(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(dArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, dArr[it.nextInt()].doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final Set<Character> IOX0oOo(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) IOIXIoo(cArr, new LinkedHashSet(OI0.xoIox(X0.IIXOooo.XI0IXoo(cArr.length, 128))));
            }
            return oX.XO(Character.valueOf(cArr[0]));
        }
        return Xo0.OOXIXo();
    }

    public static int IOXI(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final void IOXII(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int IoOIIOx = IoOIIOx(cArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char c = cArr[nextInt];
            cArr[nextInt] = cArr[IoOIIOx];
            cArr[IoOIIOx] = c;
            IoOIIOx--;
        }
    }

    public static final int IOXX00X(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> IOXXO0o(@OXOo.OOXIXo T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = tArr.length;
            if (i >= length) {
                return IoXOX(tArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(tArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(tArr[i2]);
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IOXx00X(char[] cArr, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Float>> IOXxo0(@OXOo.OOXIXo final float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Float>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Float> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.X0o0xo(fArr);
            }
        });
    }

    @OXOo.oOoXoXO
    public static final Short IOo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                if (z) {
                    return null;
                }
                sh = Short.valueOf(s);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return sh;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int IOoI0x(char[] cArr, Oox.oOoXoXO<? super Character, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (char c : cArr) {
            i += selector.invoke(Character.valueOf(c)).intValue();
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double IOoII0(int[] iArr, Oox.oOoXoXO<? super Integer, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> boolean IOoIxXII(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            int XXoXOI = XXoXOI(zArr);
            if (XXoXOI == 0) {
                return z;
            }
            R invoke = selector.invoke(Boolean.valueOf(z));
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI).iterator();
            while (it.hasNext()) {
                boolean z2 = zArr[it.nextInt()];
                R invoke2 = selector.invoke(Boolean.valueOf(z2));
                if (invoke.compareTo(invoke2) > 0) {
                    z = z2;
                    invoke = invoke2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> void IOoIxx(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(tArr, xX0ox.Oxx0IOOO.o00());
    }

    @xx0o0O.XO
    public static final long IOoXX(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr[3];
    }

    @OXOo.OOXIXo
    public static final List<Float> IOoXxoI(@OXOo.OOXIXo float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = fArr.length;
            if (i >= length) {
                return X00OO00x(fArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Float.valueOf(fArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Float.valueOf(fArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> IOox(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Character.valueOf(cArr[i]), r));
            i++;
        }
        return arrayList;
    }

    public static int IOoxOXXx0(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float IOx(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Comparator<? super Float> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) < 0) {
                f = f2;
            }
        }
        return Float.valueOf(f);
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C IOx0XI0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    public static final long IOxI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length != 0) {
            long j = jArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                j = operation.invoke(Long.valueOf(j), Long.valueOf(jArr[it.nextInt()])).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float IOxIX00(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Comparator<? super Float> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (fArr.length != 0) {
            float f = fArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                float f2 = fArr[it.nextInt()];
                if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) < 0) {
                    f = f2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Set<Short> IOxIoX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Iterable<Short> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Short> oX0XXxO = oX0XXxO(sArr);
        OxI.oXIO0o0XI(oX0XXxO, other);
        return oX0XXxO;
    }

    @OXOo.OOXIXo
    public static final List<Float> IOxO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> long IOxOOIIO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            long j = jArr[0];
            int IOXI = IOXI(jArr);
            if (IOXI == 0) {
                return j;
            }
            R invoke = selector.invoke(Long.valueOf(j));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                R invoke2 = selector.invoke(Long.valueOf(j2));
                if (invoke.compareTo(invoke2) < 0) {
                    j = j2;
                    invoke = invoke2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final long IOxo0O(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (jArr.length != 0) {
            return jArr[random.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final String IOxoXoI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Long, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) oIo0(jArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @xx0o0O.XO
    public static final int IOxoo(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr.length;
    }

    @OXOo.OOXIXo
    public static final List<Byte> IOxooo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Integer>> C IOxxIx(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Integer.valueOf(i3)).booleanValue()) {
                destination.add(Integer.valueOf(i3));
            }
            i++;
            i2 = i4;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final short[] IOxxOo(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.IOXOxOII(copyOf);
        return copyOf;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double IOxxo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (double d2 : dArr) {
            d += selector.invoke(Double.valueOf(d2)).doubleValue();
        }
        return d;
    }

    public static final <R> R IX(@OXOo.OOXIXo double[] dArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int OIO = OIO(dArr); OIO >= 0; OIO--) {
            r = operation.invoke(Integer.valueOf(OIO), Double.valueOf(dArr[OIO]), r);
        }
        return r;
    }

    public static final <R> R IX0(@OXOo.OOXIXo byte[] bArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Byte.valueOf(bArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long IX00O(byte[] bArr, Oox.oOoXoXO<? super Byte, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (byte b : bArr) {
            j += selector.invoke(Byte.valueOf(b)).longValue();
        }
        return j;
    }

    public static boolean IX0IO(@OXOo.OOXIXo byte[] bArr, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (O00Ix(bArr, b) >= 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final HashSet<Long> IX0Iox(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return (HashSet) ooxIIII(jArr, new HashSet(OI0.xoIox(jArr.length)));
    }

    public static final double IX0OOX(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (double d2 : dArr) {
            d += d2;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static final double IX0ox0O0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int OIO = OIO(dArr);
        if (OIO >= 0) {
            double d = dArr[OIO];
            for (int i = OIO - 1; i >= 0; i--) {
                d = operation.invoke(Integer.valueOf(i), Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final short IX0oxIxXI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Comparator<? super Short> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (sArr.length != 0) {
            short s = sArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) > 0) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    public static final boolean IXI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T[] IXI0(T[] tArr, Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (T t : tArr) {
            action.invoke(t);
        }
        return tArr;
    }

    public static final boolean IXIIo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short IXIO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Comparator<? super Short> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) < 0) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double IXIO0xo0x(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (char c : cArr) {
            d += selector.invoke(Character.valueOf(c)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> IXIOOoxX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void IXIoXI(@OXOo.OOXIXo char[] cArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.collections.ooOOo0oXI.OI0IXox(cArr, i, i2);
        OxoI0I(cArr, i, i2);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int IXO0(long[] jArr, Oox.oOoXoXO<? super Long, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (long j : jArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Long.valueOf(j)).OO());
        }
        return oOoXoXO2;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer IXOIo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.nextInt(iArr.length)]);
    }

    @xx0o0O.XO
    public static final short IXOO0X0(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr[1];
    }

    @OXOo.OOXIXo
    public static final <R> List<R> IXOXoIo0x(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Double.valueOf(d)));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int IXOxIIO0o(int[] iArr, Oox.oOoXoXO<? super Integer, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (int i2 : iArr) {
            i += selector.invoke(Integer.valueOf(i2)).intValue();
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double IXOxX(int[] iArr, Oox.oOoXoXO<? super Integer, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long IXX0o(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IOXI = IOXI(jArr);
        if (IOXI < 0) {
            return null;
        }
        long j = jArr[IOXI];
        for (int i = IOXI - 1; i >= 0; i--) {
            j = operation.invoke(Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
        }
        return Long.valueOf(j);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short IXXIII0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = xX0Ox(sArr);
        if (xX0Ox < 0) {
            return null;
        }
        short s = sArr[xX0Ox];
        for (int i = xX0Ox - 1; i >= 0; i--) {
            s = operation.invoke(Integer.valueOf(i), Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
        }
        return Short.valueOf(s);
    }

    @OXOo.oOoXoXO
    public static final Byte IXXOI(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character IXXXOx0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IoOIIOx = IoOIIOx(cArr);
        if (IoOIIOx < 0) {
            return null;
        }
        char c = cArr[IoOIIOx];
        for (int i = IoOIIOx - 1; i >= 0; i--) {
            c = operation.invoke(Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
        }
        return Character.valueOf(c);
    }

    public static final boolean IXXXOxO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R IXXo0xoO(short[] sArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character IXXox(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            c = operation.invoke(Character.valueOf(c), Character.valueOf(cArr[it.nextInt()])).charValue();
        }
        return Character.valueOf(c);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Integer> IXXx0O(int[] iArr, Oox.x0xO0oo<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        int i = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(i));
        int length = iArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            i = operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i2])).intValue();
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Byte IXXxOX00X(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            byte b = bArr[length];
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return Byte.valueOf(b);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Byte, ? super V>> M IXXxo(byte[] bArr, M destination, Oox.oOoXoXO<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (byte b : bArr) {
            destination.put(Byte.valueOf(b), valueSelector.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long IXXxo0X(short[] sArr, Oox.oOoXoXO<? super Short, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (short s : sArr) {
            j += selector.invoke(Short.valueOf(s)).longValue();
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R IXXxxxIOo(boolean[] zArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static final boolean IXo(@OXOo.OOXIXo float[] fArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long IXo0(double[] dArr, Oox.oOoXoXO<? super Double, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (double d : dArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Double.valueOf(d)).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static final Pair<List<Short>, List<Short>> IXo0XX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            } else {
                arrayList2.add(Short.valueOf(s));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> IXo0ox(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i]), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Short> IXoIOXoo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Comparator<? super Short> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Short[] oIX0o2 = kotlin.collections.ooOOo0oXI.oIX0o(sArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(oIX0o2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(oIX0o2);
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Float, R>> IXoO0xxx(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Float.valueOf(fArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Short> IXoXxxO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            short s = sArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static /* synthetic */ Appendable IXooXOxI0(float[] fArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return OoIo(fArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int IXoxI0(char[] cArr, Oox.oOoXoXO<? super Character, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (char c : cArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Character.valueOf(c)).OO());
        }
        return oOoXoXO2;
    }

    @xx0o0O.XO
    public static final char IXoxO(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr[2];
    }

    @xx0o0O.XO
    public static final int IXx(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr.length;
    }

    @OXOo.OOXIXo
    public static final List<Float> IXx0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (float f : fArr) {
            if (z) {
                arrayList.add(Float.valueOf(f));
            } else if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
                z = true;
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final boolean IXx00O0Ox(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final Set<Long> IXx0oOO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Iterable<Long> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Long> IO0X = IO0X(jArr);
        OxI.oxIIX0o(IO0X, other);
        return IO0X;
    }

    public static final <R> R IXx0x(@OXOo.OOXIXo long[] jArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int IOXI = IOXI(jArr); IOXI >= 0; IOXI--) {
            r = operation.invoke(Integer.valueOf(IOXI), Long.valueOf(jArr[IOXI]), r);
        }
        return r;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IXxX(long[] jArr, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            R invoke = selector.invoke(Long.valueOf(jArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    public static final char IXxXo0I0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IoOIIOx = IoOIIOx(cArr);
        if (IoOIIOx >= 0) {
            char c = cArr[IoOIIOx];
            for (int i = IoOIIOx - 1; i >= 0; i--) {
                c = operation.invoke(Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean IXxXooxoI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            z = operation.invoke(Integer.valueOf(nextInt), Boolean.valueOf(z), Boolean.valueOf(zArr[nextInt])).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public static final <R> List<R> IXxoX0Ix(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(transform.invoke(Character.valueOf(c)));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void IXxx(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        oOOxoo0xx(zArr, Random.Default);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> double IXxxXooI(T[] tArr, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (T t : tArr) {
            d += selector.invoke(t).doubleValue();
        }
        return d;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void Io0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int xX0Ox = xX0Ox(sArr); xX0Ox > 0; xX0Ox--) {
            int nextInt = random.nextInt(xX0Ox + 1);
            short s = sArr[xX0Ox];
            sArr[xX0Ox] = sArr[nextInt];
            sArr[nextInt] = s;
        }
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Character, R>> Io00OI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Character.valueOf(cArr[i]), r));
            i++;
        }
        return arrayList;
    }

    public static /* synthetic */ String Io00oOXox(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return OIIOOoXx(dArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    @xx0o0O.XO
    public static final byte Io0OXxX(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr[1];
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R Io0xxxoO(double[] dArr, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            R invoke = selector.invoke(Double.valueOf(dArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Byte>> C IoI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                destination.add(Byte.valueOf(b));
            }
        }
        return destination;
    }

    public static final void IoI0O0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int oXIX = oXIX(fArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            float f = fArr[nextInt];
            fArr[nextInt] = fArr[oXIX];
            fArr[oXIX] = f;
            oXIX--;
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer IoI0x0oXX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            i = operation.invoke(Integer.valueOf(nextInt), Integer.valueOf(i), Integer.valueOf(iArr[nextInt])).intValue();
        }
        return Integer.valueOf(i);
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> IoI0xOIOO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (Set) IxOxxxIOI(tArr, new LinkedHashSet(OI0.xoIox(tArr.length)));
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C IoIOXX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int IoIXxoox(double[] dArr, Oox.oOoXoXO<? super Double, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (double d : dArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Double.valueOf(d)).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static final Pair<List<Character>, List<Character>> IoIx(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            } else {
                arrayList2.add(Character.valueOf(c));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IoIxIX(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte IoIxIooxx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            b = operation.invoke(Byte.valueOf(b), Byte.valueOf(bArr[it.nextInt()])).byteValue();
        }
        return Byte.valueOf(b);
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> IoIxoI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Iterable<? extends T> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<T> IoI0xOIOO = IoI0xOIOO(tArr);
        OxI.oxIIX0o(IoI0xOIOO, other);
        return IoI0xOIOO;
    }

    @xx0o0O.XO
    public static final double IoO(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr[3];
    }

    public static final int IoOIIOx(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr.length - 1;
    }

    @OXOo.OOXIXo
    public static final List<Short> IoOIxxI(@OXOo.OOXIXo short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = sArr.length;
            if (i >= length) {
                return xIIXIOo(sArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Short.valueOf(sArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Short.valueOf(sArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final long IoOIxxI0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length != 0) {
            long j = jArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (j > j2) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R IoOOx0IO0(double[] dArr, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    public static final float IoOXO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            if (length == 1) {
                return fArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void IoOXo(@OXOo.OOXIXo long[] jArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, jArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            long j = jArr[i];
            jArr[i] = jArr[i4];
            jArr[i4] = j;
            i4--;
            i++;
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C IoOoo0XXX(int[] iArr, C destination, Oox.x0xO0oo<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void IoOxOOX(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        OOo0(jArr, Random.Default);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte IoOxoIx(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (b < b2) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Byte> IoOxoX0X0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return oX0IX0o(bArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @OXOo.OOXIXo
    public static final <R> List<R> IoXI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(transform.invoke(Byte.valueOf(b)));
        }
        return arrayList;
    }

    public static final int IoXIOI0O(@OXOo.OOXIXo char[] cArr, char c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (c == cArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static final <R> R IoXIOXo(@OXOo.OOXIXo float[] fArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (float f : fArr) {
            r = operation.invoke(r, Float.valueOf(f));
        }
        return r;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Map<K, V> IoXIo(@OXOo.OOXIXo K[] kArr, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(kArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(kArr.length), 16));
        for (K k : kArr) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static <T> List<T> IoXOX(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return X0XOOO(tArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(tArr[0]);
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void IoXOoxxIX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        IOI0(bArr, Random.Default);
    }

    @xx0o0O.XO
    public static final double IoXOxx0o(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr[4];
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final byte IoXXxoxxo(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return oXOxXXX(bArr, Random.Default);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long IoXo0Xx(long[] jArr, Oox.oOoXoXO<? super Long, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (long j2 : jArr) {
            j += selector.invoke(Long.valueOf(j2)).longValue();
        }
        return j;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C IoXx(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static <T> HashSet<T> IoXx0XO0O(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (HashSet) IxOxxxIOI(tArr, new HashSet(OI0.xoIox(tArr.length)));
    }

    @xx0o0O.XO
    public static final char Ioo(char[] cArr, int i, Oox.oOoXoXO<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= IoOIIOx(cArr)) {
            return cArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).charValue();
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C Ioo0Ooox(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (short s : sArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R Ioo0OxIo(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            R invoke = selector.invoke(Integer.valueOf(iArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> void IooIo0I0X(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        OXXX(tArr, Random.Default);
    }

    @OXOo.oOoXoXO
    public static final Float IooIo0OOO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    public static final long IooOI0x(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Character IooOO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int IoOIIOx = IoOIIOx(cArr);
        if (IoOIIOx == 0) {
            return Character.valueOf(c);
        }
        R invoke = selector.invoke(Character.valueOf(c));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            R invoke2 = selector.invoke(Character.valueOf(c2));
            if (invoke.compareTo(invoke2) < 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(c);
    }

    @xx0o0O.XO
    public static final Short IooOox(short[] sArr, Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                short s = sArr[length];
                if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                    return Short.valueOf(s);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer IooXOO0Xx(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = oOIoXOoI(iArr);
        if (oOIoXOoI < 0) {
            return null;
        }
        int i = iArr[oOIoXOoI];
        for (int i2 = oOIoXOoI - 1; i2 >= 0; i2--) {
            i = operation.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
        }
        return Integer.valueOf(i);
    }

    @OXOo.oOoXoXO
    public static final <T> T IooXOxXXo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    public static final double IoooXox0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (float f : fArr) {
            d += f;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T extends Comparable<? super T>> T IooxIIo0(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length != 0) {
            T t = tArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    public static final short Iox(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                short s = sArr[length];
                if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                    return s;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Integer>> IoxOXXxXo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    public static final boolean IoxX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final List<Long> Ioxo0x0x0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            long j = jArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M IoxoI0IX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (int i : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Byte IoxoIIx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int xxXIIXIxx = xxXIIXIxx(bArr);
        if (xxXIIXIxx == 0) {
            return Byte.valueOf(b);
        }
        R invoke = selector.invoke(Byte.valueOf(b));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            R invoke2 = selector.invoke(Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) < 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return Byte.valueOf(b);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R IoxooOOx(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(tArr[0]);
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(tArr[it.nextInt()]);
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    public static final <R> R Ioxx(@OXOo.OOXIXo int[] iArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int oOIoXOoI = oOIoXOoI(iArr); oOIoXOoI >= 0; oOIoXOoI--) {
            r = operation.invoke(Integer.valueOf(iArr[oOIoXOoI]), r);
        }
        return r;
    }

    @xx0o0O.XO
    public static final Boolean IoxxXOO(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    @xx0o0O.XO
    public static final byte Ix(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr[3];
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M Ix00(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (boolean z : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Character> Ix00x(@OXOo.OOXIXo char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = cArr.length;
            if (i >= length) {
                return oxoIIXo(cArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Character.valueOf(cArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Character.valueOf(cArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.oOoXoXO
    public static final <T> T Ix00xIoO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            T t = tArr[length];
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R Ix0X0oxX(long[] jArr, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    public static final byte Ix0XII(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length != 0) {
            byte b = bArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                b = operation.invoke(Integer.valueOf(nextInt), Byte.valueOf(b), Byte.valueOf(bArr[nextInt])).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> Ix0XO(double[] dArr, Oox.x0xO0oo<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Short> Ix0Xx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Byte> Ix0xo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Double> IxII(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return Xxo0IxOOx(dArr, new Oxx0IOOO.I0Io(selector));
    }

    @OXOo.OOXIXo
    public static final <V> List<V> IxIIxX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo float[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super Float, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i]), Float.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static <T> T IxIOOxO(@OXOo.OOXIXo T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (i >= 0 && i <= o0IXO(tArr)) {
            return tArr[i];
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final List<Double> IxIXo(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(xII0X0OO(dArr));
    }

    @xx0o0O.XO
    public static final Float IxIXoo(float[] fArr, Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return Float.valueOf(f);
            }
        }
        return null;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T, R extends Comparable<? super R>> T IxIoXOO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int o0IXO = o0IXO(tArr);
        if (o0IXO == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            R invoke2 = selector.invoke(t2);
            if (invoke.compareTo(invoke2) < 0) {
                t = t2;
                invoke = invoke2;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> IxO0X0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = tArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), t).booleanValue()) {
                arrayList.add(t);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final boolean IxOIO(@OXOo.OOXIXo boolean[] zArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> IxOOI0Xo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            boolean z = zArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    public static final boolean IxOXOxO(@OXOo.OOXIXo double[] dArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double IxOoo(short[] sArr, Oox.oOoXoXO<? super Short, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static final float IxOoxxxx(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C IxOxxxIOI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (T t : tArr) {
            destination.add(t);
        }
        return destination;
    }

    public static final char IxX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IoOIIOx = IoOIIOx(cArr);
        if (IoOIIOx >= 0) {
            char c = cArr[IoOIIOx];
            for (int i = IoOIIOx - 1; i >= 0; i--) {
                c = operation.invoke(Integer.valueOf(i), Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @xx0o0O.XO
    public static final boolean IxX0(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final int IxXOO0o0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static final int IxXXI0Xo(@OXOo.OOXIXo boolean[] zArr, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Double>> C IxXXoxI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (double d : dArr) {
            destination.add(Double.valueOf(d));
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Boolean IxXxoIIO(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Integer Ixo(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return IXOIo(iArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static X0.oOoXoXO Ixo0(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return new X0.oOoXoXO(0, xxXIIXIxx(bArr));
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> IxoOxx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b)), valueTransform.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    public static final <S, T extends S> S IxoXI0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length != 0) {
            S s = (S) tArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                s = operation.invoke(Integer.valueOf(nextInt), s, (Object) tArr[nextInt]);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Boolean, ? super V>> M IxoXXoXo(boolean[] zArr, M destination, Oox.oOoXoXO<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (boolean z : zArr) {
            destination.put(Boolean.valueOf(z), valueSelector.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Double> IxoXXxOo(@OXOo.OOXIXo double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= dArr.length) {
                return OXIIooO0(dArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Double.valueOf(dArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (double d : dArr) {
                arrayList.add(Double.valueOf(d));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C IxoXx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (long j : jArr) {
            destination.add(transform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    public static final long IxoooIO0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                long j = jArr[length];
                if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                    return j;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final byte Ixox(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length != 0) {
            byte b = bArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (b > b2) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final <T, R> R Ixox0x(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> transform) {
        R r;
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = tArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                r = transform.invoke(tArr[i]);
                if (r != null) {
                    break;
                }
                i++;
            } else {
                r = null;
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    @OXOo.OOXIXo
    public static final List<Pair<Byte, Byte>> IxoxIo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo byte[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Byte.valueOf(bArr[i]), Byte.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <V> List<V> Ixx00XO0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo short[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super Short, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i]), Short.valueOf(other[i])));
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Byte> IxxI(byte[] bArr, Oox.x0xO0oo<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        byte b = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(b));
        int length = bArr.length;
        for (int i = 1; i < length; i++) {
            b = operation.invoke(Byte.valueOf(b), Byte.valueOf(bArr[i])).byteValue();
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final int IxxIoXox(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return O0Io0OO(iArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static final List<Long> IxxO0OOx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.Oxx0xo(kotlin.collections.ooOOo0oXI.X0xxXX0(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final int IxxOI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @xx0o0O.XO
    public static final boolean IxxOIX(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final List<Long> IxxXI0o(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    public static final void IxxxXx0I(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (long j : jArr) {
            action.invoke(Long.valueOf(j));
        }
    }

    public static final void O000IX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (double d : dArr) {
            action.invoke(Double.valueOf(d));
        }
    }

    public static int O00Ix(@OXOo.OOXIXo byte[] bArr, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final char[] O00OI(@OXOo.OOXIXo Character[] chArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    public static final void O00X(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (boolean z : zArr) {
            action.invoke(Boolean.valueOf(z));
        }
    }

    @OXOo.OOXIXo
    public static final <T> List<T> O00oxX0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Set<Float> O0I(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Iterable<Float> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Float> oxOxXO = oxOxXO(fArr);
        OxI.oxIIX0o(oxOxXO, other);
        return oxOxXO;
    }

    @OXOo.OOXIXo
    public static final boolean[] O0I0O0(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int XXoXOI = XXoXOI(zArr);
        oOXoIIIo it = new X0.oOoXoXO(0, XXoXOI).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            zArr2[XXoXOI - nextInt] = zArr[nextInt];
        }
        return zArr2;
    }

    public static final boolean O0I0OxOo(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> O0III(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, tArr[i]);
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <T> int O0IIO0(@OXOo.OOXIXo T[] tArr, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (t == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(t, tArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> O0IOXOo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Short.valueOf(sArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void O0IOxxxx(@OXOo.OOXIXo byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.collections.ooOOo0oXI.XO0OX(bArr, i, i2);
        XIxX0xXO(bArr, i, i2);
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Long>> C O0IX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                destination.add(Long.valueOf(j));
            }
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final int O0Io0OO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (iArr.length != 0) {
            return iArr[random.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean O0IoXXOx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int[] O0Ix0(int[] iArr, Oox.oOoXoXO<? super Integer, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (int i : iArr) {
            action.invoke(Integer.valueOf(i));
        }
        return iArr;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> O0Ix00(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R O0IxXO(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            R invoke = selector.invoke(Integer.valueOf(iArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> float O0OIII(T[] tArr, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            float floatValue = selector.invoke(tArr[0]).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(tArr[it.nextInt()]).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long O0OIo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Comparator<? super Long> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) > 0) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    @OXOo.oOoXoXO
    public static final Byte O0OO(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Boolean>> C O0OO0Ox(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            boolean z = zArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Boolean>> M O0OOoIox(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (boolean z : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final long O0OXx(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return IOxo0O(jArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static final <R> List<R> O0OoIOIxX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(transform.invoke(Short.valueOf(s)));
        }
        return arrayList;
    }

    public static final boolean O0OoXI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final int O0OxXXox(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final boolean O0X0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (zArr.length != 0) {
            return zArr[random.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R O0X0o(long[] jArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int O0X0oIxO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (short s : sArr) {
            i += selector.invoke(Short.valueOf(s)).intValue();
        }
        return i;
    }

    public static <T> T O0X0xoXo(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[o0IXO(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Double>> C O0XI0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Double O0XI00X0o(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Long>> C O0XOI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            long j = jArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Long.valueOf(j)).booleanValue()) {
                destination.add(Long.valueOf(j));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Integer O0XX0IX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    @kotlin.OOXIXo(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.XX(expression = "any { it == element }", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.6", hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ boolean O0Xo(float[] fArr, float f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        for (float f2 : fArr) {
            if (f2 == f) {
                return true;
            }
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Short O0Xo0O(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return oxX00Io(sArr, Random.Default);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R O0XoXI(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            R invoke = selector.invoke(Byte.valueOf(bArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> void O0Xx0oxXx(@OXOo.OOXIXo T[] tArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, tArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            T t = tArr[i];
            tArr[i] = tArr[i4];
            tArr[i4] = t;
            i4--;
            i++;
        }
    }

    @xx0o0O.XO
    public static final int O0o(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr.length;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Long> O0o000XOX(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new x0XOIxOo(jArr);
    }

    @OXOo.OOXIXo
    public static final List<Double> O0o0OI00(@OXOo.OOXIXo double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (i >= 0) {
            return IxoXXxOo(dArr, X0.IIXOooo.OxxIIOOXO(dArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M O0o0OO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final Set<Character> O0oO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Iterable<Character> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Character> Xox = Xox(cArr);
        OxI.oXIO0o0XI(Xox, other);
        return Xox;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer O0oXIX0oX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (i < i2) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R O0oXO0ooI(char[] cArr, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            R invoke = selector.invoke(Character.valueOf(cArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final int O0oXOX0XX(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr[3];
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C O0oo0o(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float O0oxX0(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static final <R> R O0x0XII(@OXOo.OOXIXo short[] sArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int xX0Ox = xX0Ox(sArr); xX0Ox >= 0; xX0Ox--) {
            r = operation.invoke(Integer.valueOf(xX0Ox), Short.valueOf(sArr[xX0Ox]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Boolean> O0x0XXxI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final Set<Double> O0xI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Iterable<Double> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Double> xII0X0OO = xII0X0OO(dArr);
        OxI.oXIO0o0XI(xII0X0OO, other);
        return xII0X0OO;
    }

    @kotlin.OOXIXo(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.XX(expression = "any { it == element }", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.6", hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ boolean O0xOXxxx(double[] dArr, double d) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static final <R> R O0xOx0(@OXOo.OOXIXo double[] dArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (double d : dArr) {
            r = operation.invoke(r, Double.valueOf(d));
        }
        return r;
    }

    public static final <R> R O0xoXo00O(@OXOo.OOXIXo boolean[] zArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (boolean z : zArr) {
            r = operation.invoke(r, Boolean.valueOf(z));
        }
        return r;
    }

    @XO0OX.xxIXOIIO(name = "averageOfDouble")
    public static final double OI(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (Double d2 : dArr) {
            d += d2.doubleValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.oOoXoXO
    public static final Float OI00(@OXOo.OOXIXo float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (i >= 0 && i <= oXIX(fArr)) {
            return Float.valueOf(fArr[i]);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> OI00Oo0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T> T OI0O(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (tArr.length != 0) {
            T t = tArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (comparator.compare(t, t2) > 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R OI0OI(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.oOoXoXO
    public static final <T> T OI0OIIo(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final boolean OI0o(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.oOoXoXO
    public static <T> T OI0oXX(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @xx0o0O.XO
    public static final <T> T OI0xX(T[] tArr, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                T t = tArr[length];
                if (!predicate.invoke(t).booleanValue()) {
                    if (i < 0) {
                        break;
                    }
                    length = i;
                } else {
                    return t;
                }
            }
        }
        return null;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float OII0(byte[] bArr, Oox.oOoXoXO<? super Byte, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final List<Long> OII0x(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float OIIIxxO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length != 0) {
            float f = fArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                f = Math.min(f, fArr[it.nextInt()]);
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <R> List<R> OIIO0oIoO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final String OIIOOoXx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Double, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) XXooo0(dArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final double OIIX0ooox(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (dArr.length != 0) {
            return dArr[random.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final X0.oOoXoXO OIIXIIO0(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return new X0.oOoXoXO(0, OIO(dArr));
    }

    @OXOo.OOXIXo
    public static final <T, K> List<T> OIIoIo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (hashSet.add(selector.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Boolean> OIIoO(boolean[] zArr, Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        boolean z = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z));
        int length = zArr.length;
        int i = 1;
        while (i < length) {
            Boolean invoke = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[i]));
            boolean booleanValue = invoke.booleanValue();
            arrayList.add(invoke);
            i++;
            z = booleanValue;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final long[] OIIoO0O(@OXOo.OOXIXo Long[] lArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    @OXOo.OOXIXo
    public static final List<Long> OIIxOxx(@OXOo.OOXIXo long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (i >= 0) {
            return IOOxII0o(jArr, X0.IIXOooo.OxxIIOOXO(jArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final int OIO(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr.length - 1;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OIO0O(@OXOo.OOXIXo boolean[] zArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, zArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            boolean z = zArr[i];
            zArr[i] = zArr[i4];
            zArr[i4] = z;
            i4--;
            i++;
        }
    }

    @OXOo.OOXIXo
    public static final <T> String OIO0XIo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) oIOoXooIO(tArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static <T> List<T> OIOIxOO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (List) OOXo0xOXx(tArr, new ArrayList());
    }

    public static final int OIOO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Double> OIOOOX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return Xxo0IxOOx(dArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @OXOo.OOXIXo
    public static X0.oOoXoXO OIOXo(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return new X0.oOoXoXO(0, oOIoXOoI(iArr));
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Float, V> OIOxOX(float[] fArr, Oox.oOoXoXO<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(Float.valueOf(f), valueSelector.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    public static final boolean OIX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static int OIX0oXO0o(@OXOo.OOXIXo byte[] bArr, byte b) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (b == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    public static short OIXI(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @xx0o0O.XO
    public static final short OIXO(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr[0];
    }

    @OXOo.OOXIXo
    public static final List<Byte> OIXXIXxX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final char OIXXXXxx(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length != 0) {
            char c = cArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (kotlin.jvm.internal.IIX0o.oI0IIXIo(c, c2) > 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Boolean> OIXXo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int XXoXOI = XXoXOI(zArr); -1 < XXoXOI; XXoXOI--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[XXoXOI])).booleanValue()) {
                return oIIXxXIox(zArr, XXoXOI + 1);
            }
        }
        return XIX0oOXXO(zArr);
    }

    public static byte OIXo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[xxXIIXIxx(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.oOoXoXO
    public static final Byte OIo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    @xx0o0O.XO
    public static final Long OIo0o(long[] jArr, Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                long j = jArr[length];
                if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                    return Long.valueOf(j);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final List<Long> OIoOI000O(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.X0(copyOf);
        return xoOxO(copyOf);
    }

    public static byte OIoOo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            if (length == 1) {
                return bArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Long OIox(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return I00XI0o(jArr, Random.Default);
    }

    @xx0o0O.XO
    public static final Float OIx(float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return OI00(fArr, i);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T OIx0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.nextInt(tArr.length)];
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long OIx00IX(char[] cArr, Oox.oOoXoXO<? super Character, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (char c : cArr) {
            j += selector.invoke(Character.valueOf(c)).longValue();
        }
        return j;
    }

    public static /* synthetic */ String OIx0IoOx0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return OIO0XIo(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character OIxIOOX0x(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.nextInt(cArr.length)]);
    }

    public static final int OIxOo0XI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Long.valueOf(jArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> OIxXxXO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Double.valueOf(dArr[i]), r));
            i++;
        }
        return arrayList;
    }

    public static final char OIxooI0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return c;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean OIxx(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return true;
        }
        return false;
    }

    @xx0o0O.XO
    public static final boolean OO00(byte[] bArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final <R> R OO00IOOo(@OXOo.OOXIXo boolean[] zArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int XXoXOI = XXoXOI(zArr); XXoXOI >= 0; XXoXOI--) {
            r = operation.invoke(Integer.valueOf(XXoXOI), Boolean.valueOf(zArr[XXoXOI]), r);
        }
        return r;
    }

    public static /* synthetic */ Appendable OO00XXI(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return XxOOX(bArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Character>>> M OO00xO0I(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c));
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double OO0I(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return XOIOIX(dArr, Random.Default);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short OO0X(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Comparator<? super Short> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) > 0) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    @OXOo.OOXIXo
    public static final HashSet<Character> OO0x(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return (HashSet) IOIXIoo(cArr, new HashSet(OI0.xoIox(X0.IIXOooo.XI0IXoo(cArr.length, 128))));
    }

    @xx0o0O.XO
    public static final int OOI(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr[0];
    }

    public static boolean OOI00oxoO(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (XoOoxI0X(iArr, i) >= 0) {
            return true;
        }
        return false;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double OOI0Xo(char[] cArr, Oox.oOoXoXO<? super Character, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Pair<Long, Long>> OOIIXxX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo long[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Long.valueOf(jArr[i]), Long.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Pair<List<Integer>, List<Integer>> OOIO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            } else {
                arrayList2.add(Integer.valueOf(i));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OOIOxI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int oXIX = oXIX(fArr); oXIX > 0; oXIX--) {
            int nextInt = random.nextInt(oXIX + 1);
            float f = fArr[oXIX];
            fArr[oXIX] = fArr[nextInt];
            fArr[nextInt] = f;
        }
    }

    public static final int OOIX(@OXOo.OOXIXo char[] cArr, char c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S, T extends S> List<S> OOIXXo0x(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        S s = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s);
        int length = tArr.length;
        for (int i = 1; i < length; i++) {
            s = operation.invoke(s, (Object) tArr[i]);
            arrayList.add(s);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Short>> C OOIXoIX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                destination.add(Short.valueOf(s));
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<Pair<T, R>> OOIo00Ooo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(tArr[i], r));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> OOO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Set<Double> OOOIxxXOI(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) IxXXoxI(dArr, new LinkedHashSet(OI0.xoIox(dArr.length)));
            }
            return oX.XO(Double.valueOf(dArr[0]));
        }
        return Xo0.OOXIXo();
    }

    public static final byte OOOO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return b;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> OOOOXx00x(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Long.valueOf(jArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, K, M extends Map<? super K, ? super T>> M OOOxXxoO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (T t : tArr) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Integer>> M OOX0x(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (int i : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i)), Integer.valueOf(i));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> OOXI0Ixxx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> OOXIxoX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long OOXOOIO(int[] iArr, Oox.oOoXoXO<? super Integer, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (int i : iArr) {
            j += selector.invoke(Integer.valueOf(i)).longValue();
        }
        return j;
    }

    @OXOo.OOXIXo
    public static <T> List<T> OOXOX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(kotlin.collections.ooOOo0oXI.IO0XoXxO(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @OXOo.OOXIXo
    public static final double[] OOXXo0ox(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        XI0xXOOxx(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super T>, T> C OOXo0xOXx(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (T t : tArr) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final long OOXoI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Comparator<? super Long> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (jArr.length != 0) {
            long j = jArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) < 0) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final boolean OOXx(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final double[] OOXxXox(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new double[0];
        }
        return kotlin.collections.ooOOo0oXI.x0OxxIOxX(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M OOo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (float f : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f)), valueTransform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OOo0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int IOXI = IOXI(jArr); IOXI > 0; IOXI--) {
            int nextInt = random.nextInt(IOXI + 1);
            long j = jArr[IOXI];
            jArr[IOXI] = jArr[nextInt];
            jArr[nextInt] = j;
        }
    }

    @OXOo.oOoXoXO
    public static final Long OOo0O(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final int[] OOoI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.xOxOoo(copyOf);
        return copyOf;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T> T OOoOIO0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (tArr.length != 0) {
            T t = tArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (comparator.compare(t, t2) < 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    public static final boolean OOoOoO0o(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R OOoXI0(double[] dArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final <T, R> R OOox(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @kotlin.OOXIXo(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.XX(expression = "indexOfLast { it == element }", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.6", hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int OOoxI(double[] dArr, double d) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (d == dArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final List<Pair<Integer, Integer>> OOoxIoIOX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo int[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Integer.valueOf(iArr[i]), Integer.valueOf(other[i])));
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final boolean OOxIO(int[] iArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @xx0o0O.XO
    public static final double OOxOXI0(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr[1];
    }

    @OXOo.OOXIXo
    public static final List<Byte> OOxX0oXXX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final byte OOxXX0OI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = xxXIIXIxx(bArr);
        if (xxXIIXIxx >= 0) {
            byte b = bArr[xxXIIXIxx];
            for (int i = xxXIIXIxx - 1; i >= 0; i--) {
                b = operation.invoke(Integer.valueOf(i), Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C OOxXXO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (int i : iArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Long> OOxXo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final int OOxxOOX(int[] iArr, int i, Oox.oOoXoXO<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= oOIoXOoI(iArr)) {
            return iArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).intValue();
    }

    public static final double OOxxOXII(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            if (length == 1) {
                return dArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OOxxo(@OXOo.OOXIXo double[] dArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, dArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            double d = dArr[i];
            dArr[i] = dArr[i4];
            dArr[i4] = d;
            i4--;
            i++;
        }
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Byte> OX0(byte[] bArr, Oox.IXxxXO<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        byte b = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(b));
        int length = bArr.length;
        for (int i = 1; i < length; i++) {
            b = operation.invoke(Integer.valueOf(i), Byte.valueOf(b), Byte.valueOf(bArr[i])).byteValue();
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Character> OX0I(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> OX0I00OO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Iterable<? extends T> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<T> IoI0xOIOO = IoI0xOIOO(tArr);
        OxI.oXIO0o0XI(IoI0xOIOO, other);
        return IoI0xOIOO;
    }

    public static final <S, T extends S> S OX0IXoX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int o0IXO = o0IXO(tArr);
        if (o0IXO >= 0) {
            S s = (S) tArr[o0IXO];
            for (int i = o0IXO - 1; i >= 0; i--) {
                s = operation.invoke((Object) tArr[i], s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final <T> T OX0OIOOI(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length == 1) {
                return tArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double OX0X(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(dArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, dArr[it.nextInt()].doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final List<Double> OX0X000(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.x0xO0oo(kotlin.collections.ooOOo0oXI.x0OxxIOxX(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @OXOo.OOXIXo
    public static final char[] OX0XI(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        OXXOI0(copyOf);
        return copyOf;
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final long OX0oIIIo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Comparator<? super Long> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (jArr.length != 0) {
            long j = jArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) > 0) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Pair<List<Long>, List<Long>> OX0oXXO0O(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            } else {
                arrayList2.add(Long.valueOf(j));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @OXOo.OOXIXo
    public static final List<Short> OX0xI0IO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, M extends Map<? super K, ? super V>> M OXI(@OXOo.OOXIXo K[] kArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(kArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (K k : kArr) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long OXI0O(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (j > j2) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    public static final <T, K> Map<K, List<T>> OXI0XXxIo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> OXIII(double[] dArr, R r, Oox.x0xO0oo<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r);
        for (double d : dArr) {
            r = operation.invoke(r, Double.valueOf(d));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Long> OXIIo0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (long j : jArr) {
            if (z) {
                arrayList.add(Long.valueOf(j));
            } else if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
                z = true;
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static List<Double> OXIIooO0(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            if (length != 1) {
                return ox0X(dArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Double.valueOf(dArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final List<Float> OXIIxO0x0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.Oo(kotlin.collections.ooOOo0oXI.x0(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Byte OXIO0OI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int xxXIIXIxx = xxXIIXIxx(bArr);
        if (xxXIIXIxx == 0) {
            return Byte.valueOf(b);
        }
        R invoke = selector.invoke(Byte.valueOf(b));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            R invoke2 = selector.invoke(Byte.valueOf(b2));
            if (invoke.compareTo(invoke2) > 0) {
                b = b2;
                invoke = invoke2;
            }
        }
        return Byte.valueOf(b);
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double OXIX00oXx(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length != 0) {
            double d = dArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                d = Math.min(d, dArr[it.nextInt()]);
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double OXIoXI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            d = operation.invoke(Double.valueOf(d), Double.valueOf(dArr[it.nextInt()])).doubleValue();
        }
        return Double.valueOf(d);
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C OXIxXO0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (float f : fArr) {
            destination.add(transform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Boolean OXO(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    @xx0o0O.XO
    public static final int OXO0(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr.length;
    }

    @OXOo.OOXIXo
    public static final long[] OXO0OoI(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        oIX0(copyOf);
        return copyOf;
    }

    public static <T> boolean OXO0oX(@OXOo.OOXIXo T[] tArr, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (XxOX(tArr, t) >= 0) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long OXOIIxO(char[] cArr, Oox.oOoXoXO<? super Character, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (char c : cArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Character.valueOf(c)).OO());
        }
        return oOoXoXO2;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T extends Comparable<? super T>> void OXOOOx(@OXOo.OOXIXo T[] tArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.collections.ooOOo0oXI.XXx0OXXXo(tArr, xX0ox.Oxx0IOOO.o00(), i, i2);
    }

    @OXOo.OOXIXo
    public static final Set<Float> OXOOox(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Iterable<Float> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Float> oxOxXO = oxOxXO(fArr);
        OxI.XIo0oOXIx(oxOxXO, other);
        return oxOxXO;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R OXOXOxoO(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            R invoke = selector.invoke(tArr[0]);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(tArr[it.nextInt()]);
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final Double OXOXxxOOO(double[] dArr, Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                double d = dArr[length];
                if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                    return Double.valueOf(d);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    public static final boolean OXOo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S OXOoOoXX0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s = (S) tArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            s = operation.invoke(Integer.valueOf(nextInt), s, (Object) tArr[nextInt]);
        }
        return s;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C OXOxXI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (char c : cArr) {
            destination.add(transform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Float> OXOxx(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Float> OoIIxX = OoIIxX(fArr);
        X0IIOO.oXX0IoI(OoIIxX);
        return OoIIxX;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> float OXX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            float f = fArr[0];
            int oXIX = oXIX(fArr);
            if (oXIX == 0) {
                return f;
            }
            R invoke = selector.invoke(Float.valueOf(f));
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX).iterator();
            while (it.hasNext()) {
                float f2 = fArr[it.nextInt()];
                R invoke2 = selector.invoke(Float.valueOf(f2));
                if (invoke.compareTo(invoke2) < 0) {
                    f = f2;
                    invoke = invoke2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Pair<List<Float>, List<Float>> OXX0Xox0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            } else {
                arrayList2.add(Float.valueOf(f));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @xx0o0O.XO
    public static final boolean OXX0xxo(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float OXXIooI(int[] iArr, Oox.oOoXoXO<? super Integer, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static byte[] OXXO(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int xxXIIXIxx = xxXIIXIxx(bArr);
        oOXoIIIo it = new X0.oOoXoXO(0, xxXIIXIxx).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            bArr2[xxXIIXIxx - nextInt] = bArr[nextInt];
        }
        return bArr2;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Float> OXXOI(float[] fArr, Oox.IXxxXO<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        float f = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(f));
        int length = fArr.length;
        for (int i = 1; i < length; i++) {
            f = operation.invoke(Integer.valueOf(i), Float.valueOf(f), Float.valueOf(fArr[i])).floatValue();
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static final void OXXOI0(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length > 1) {
            kotlin.collections.ooOOo0oXI.Oox(cArr);
            IOXII(cArr);
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> void OXXX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int o0IXO = o0IXO(tArr); o0IXO > 0; o0IXO--) {
            int nextInt = random.nextInt(o0IXO + 1);
            T t = tArr[o0IXO];
            tArr[o0IXO] = tArr[nextInt];
            tArr[nextInt] = t;
        }
    }

    @OXOo.OOXIXo
    public static final Set<Byte> OXXXIxoO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Iterable<Byte> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Byte> I0OOxXXIx = I0OOxXXIx(bArr);
        OxI.oXIO0o0XI(I0OOxXXIx, other);
        return I0OOxXXIx;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short[] OXXXo0(short[] sArr, Oox.oOoXoXO<? super Short, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (short s : sArr) {
            action.invoke(Short.valueOf(s));
        }
        return sArr;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Integer>> C OXXo0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                destination.add(Integer.valueOf(i));
            }
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final short OXXoX(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return IOOIo(sArr, Random.Default);
    }

    public static final void OXXx0(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int XXoXOI = XXoXOI(zArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            boolean z = zArr[nextInt];
            zArr[nextInt] = zArr[XXoXOI];
            zArr[XXoXOI] = z;
            XXoXOI--;
        }
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Short, V> OXXxXoO(short[] sArr, Oox.oOoXoXO<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(Short.valueOf(s), valueSelector.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Long> OXo(long[] jArr, Oox.IXxxXO<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        long j = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(j));
        int length = jArr.length;
        for (int i = 1; i < length; i++) {
            j = operation.invoke(Integer.valueOf(i), Long.valueOf(j), Long.valueOf(jArr[i])).longValue();
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double OXo0IXX0X(float[] fArr, Oox.oOoXoXO<? super Float, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte OXoIIXO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.nextInt(bArr.length)]);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Character, ? super V>> M OXoIOx(char[] cArr, M destination, Oox.oOoXoXO<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (char c : cArr) {
            destination.put(Character.valueOf(c), valueSelector.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Short>> M OXoIXx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (short s : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> OXoOo00O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i]), other[i]));
        }
        return arrayList;
    }

    public static final int OXoOoI0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = oOIoXOoI(iArr);
        if (oOIoXOoI >= 0) {
            int i = iArr[oOIoXOoI];
            for (int i2 = oOIoXOoI - 1; i2 >= 0; i2--) {
                i = operation.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> OXoOxOxX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float OXoo(long[] jArr, Oox.oOoXoXO<? super Long, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final <T> T OXooXOXx(T[] tArr, int i, Oox.oOoXoXO<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= o0IXO(tArr)) {
            return tArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R OXx(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            r = operation.invoke(Integer.valueOf(i2), r, tArr[i]);
            i++;
            i2++;
        }
        return r;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double OXx00IX(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (boolean z : zArr) {
            d += selector.invoke(Boolean.valueOf(z)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Boolean> OXx0OO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return o00oXxXII(zArr, new Oxx0IOOO.I0Io(selector));
    }

    @XO0OX.xxIXOIIO(name = "sumOfShort")
    public static final int OXxI(@OXOo.OOXIXo Short[] shArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(shArr, "<this>");
        int i = 0;
        for (Short sh : shArr) {
            i += sh.shortValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final List<Character> OXxI0IX0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Character[] XXooOOI2 = kotlin.collections.ooOOo0oXI.XXooOOI(cArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(XXooOOI2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(XXooOOI2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final char OXxIO(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return XOOxoxI(cArr, Random.Default);
    }

    @OXOo.oOoXoXO
    public static final Double OXxIOxox(@OXOo.OOXIXo double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (i >= 0 && i <= OIO(dArr)) {
            return Double.valueOf(dArr[i]);
        }
        return null;
    }

    public static final <R> R OXxIXOxO(@OXOo.OOXIXo int[] iArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Integer.valueOf(iArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @OXOo.oOoXoXO
    public static final Character OXxIXo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(c);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Double>>> M OXxO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static int[] OXxOX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int oOIoXOoI = oOIoXOoI(iArr);
        oOXoIIIo it = new X0.oOoXoXO(0, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            iArr2[oOIoXOoI - nextInt] = iArr[nextInt];
        }
        return iArr2;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float OXxXX(byte[] bArr, Oox.oOoXoXO<? super Byte, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <K> List<Short> OXxXoOx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (hashSet.add(selector.invoke(Short.valueOf(s)))) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> OXxo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R OXxx(boolean[] zArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T extends Comparable<? super T>> T Oo0(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length != 0) {
            T t = tArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                if (t.compareTo(t2) < 0) {
                    t = t2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ String Oo00XooIO(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return XIIxXO(iArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    public static final <R> R Oo0I0Io(@OXOo.OOXIXo float[] fArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int oXIX = oXIX(fArr); oXIX >= 0; oXIX--) {
            r = operation.invoke(Float.valueOf(fArr[oXIX]), r);
        }
        return r;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte[] Oo0IOI0x(byte[] bArr, Oox.oOoXoXO<? super Byte, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (byte b : bArr) {
            action.invoke(Byte.valueOf(b));
        }
        return bArr;
    }

    public static boolean Oo0IXI0(@OXOo.OOXIXo byte[] bArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static int Oo0OxoOx(@OXOo.OOXIXo short[] sArr, short s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int Oo0XIIOxO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (boolean z : zArr) {
            i += selector.invoke(Boolean.valueOf(z)).intValue();
        }
        return i;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void Oo0Xxx0OX(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        xXOIo(dArr, Random.Default);
    }

    public static final <R> R Oo0oOO(@OXOo.OOXIXo byte[] bArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int xxXIIXIxx = xxXIIXIxx(bArr); xxXIIXIxx >= 0; xxXIIXIxx--) {
            r = operation.invoke(Byte.valueOf(bArr[xxXIIXIxx]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final Iterable<Double> Oo0xX(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new Oxx0IOOO(dArr);
    }

    @OXOo.OOXIXo
    public static final Set<Byte> OoI(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) xXxxOxI0I(bArr, new LinkedHashSet(OI0.xoIox(bArr.length)));
            }
            return oX.XO(Byte.valueOf(bArr[0]));
        }
        return Xo0.OOXIXo();
    }

    @OXOo.OOXIXo
    public static final char[] OoIIOXxoO(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int IoOIIOx = IoOIIOx(cArr);
        oOXoIIIo it = new X0.oOoXoXO(0, IoOIIOx).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            cArr2[IoOIIOx - nextInt] = cArr[nextInt];
        }
        return cArr2;
    }

    @OXOo.OOXIXo
    public static final List<Float> OoIIxX(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Set<Short> OoIO0OIX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Iterable<Short> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Short> oX0XXxO = oX0XXxO(sArr);
        OxI.oxIIX0o(oX0XXxO, other);
        return oX0XXxO;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> OoIOOIxO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A OoIo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (float f : fArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Float.valueOf(f)));
            } else {
                buffer.append(String.valueOf(f));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @xx0o0O.XO
    public static final byte OoIoI0(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr[2];
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Character OoIx(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int IoOIIOx = IoOIIOx(cArr);
        if (IoOIIOx == 0) {
            return Character.valueOf(c);
        }
        R invoke = selector.invoke(Character.valueOf(c));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            R invoke2 = selector.invoke(Character.valueOf(c2));
            if (invoke.compareTo(invoke2) > 0) {
                c = c2;
                invoke = invoke2;
            }
        }
        return Character.valueOf(c);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> long OoO0X0O(T[] tArr, Oox.oOoXoXO<? super T, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (T t : tArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(t).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.oOoXoXO
    public static final Double OoOOIoXO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Double d = null;
        boolean z = false;
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                if (z) {
                    return null;
                }
                d = Double.valueOf(d2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return d;
    }

    public static final double OoOXoO0Io(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length != 0) {
            double d = dArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                d = operation.invoke(Integer.valueOf(nextInt), Double.valueOf(d), Double.valueOf(dArr[nextInt])).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean OoOoXO0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> OoOoxX0xo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(cArr.length), 16));
        for (char c : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c)), valueTransform.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R OoOx0(int[] iArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R OoX(double[] dArr, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int OoX0x0O(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (int i2 : iArr) {
            i += selector.invoke(Integer.valueOf(i2)).intValue();
        }
        return i;
    }

    public static final void OoXX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (int i : iArr) {
            action.invoke(Integer.valueOf(i));
        }
    }

    @OXOo.oOoXoXO
    public static final Byte OoXXoXI(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void OoXox(@OXOo.OOXIXo long[] jArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.collections.ooOOo0oXI.I0OO(jArr, i, i2);
        IoOXo(jArr, i, i2);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double OoXx(float[] fArr, Oox.oOoXoXO<? super Float, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Pair<Short, Short>> Ooo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo short[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Short.valueOf(sArr[i]), Short.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> OooI0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(transform.invoke(t));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Float OooIXXO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Float f = null;
        boolean z = false;
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                if (z) {
                    return null;
                }
                f = Float.valueOf(f2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return f;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean OooOO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int XXoXOI = XXoXOI(zArr);
        if (XXoXOI < 0) {
            return null;
        }
        boolean z = zArr[XXoXOI];
        for (int i = XXoXOI - 1; i >= 0; i--) {
            z = operation.invoke(Integer.valueOf(i), Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public static final List<Character> OooOXIoX(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.Oox(copyOf);
        return XoXOxI0XI(copyOf);
    }

    public static final boolean OooOoX(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final <V> List<V> OooXX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo int[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i]), Integer.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K> List<Long> OooXX0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (hashSet.add(selector.invoke(Long.valueOf(j)))) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double Oooo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (boolean z : zArr) {
            d += selector.invoke(Boolean.valueOf(z)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Character> OoooIXO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return OXxI0IX0(cArr, new Oxx0IOOO.I0Io(selector));
    }

    @xx0o0O.XO
    public static final float OoooxII(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr[3];
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Double>> C Oox0oOO0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            double d = dArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Double.valueOf(d)).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static List<Long> OoxIx(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            if (length != 1) {
                return OII0x(jArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Long.valueOf(jArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S, T extends S> List<S> OoxO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        S s = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s);
        int length = tArr.length;
        for (int i = 1; i < length; i++) {
            s = operation.invoke(Integer.valueOf(i), s, (Object) tArr[i]);
            arrayList.add(s);
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Boolean Ooxo0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (z) {
                    return null;
                }
                bool = Boolean.valueOf(z2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return bool;
    }

    @OXOo.OOXIXo
    public static final Iterable<Byte> OoxxX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new II0xO0(bArr);
    }

    @xx0o0O.XO
    public static final Byte Ooxxx(byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return xOO0X(bArr, i);
    }

    public static final boolean Ox(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Boolean, V> Ox0(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(Boolean.valueOf(z), valueSelector.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> Ox00Xx0O(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(XXIIoOI(tArr, comparator));
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C Ox0O0X(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (double d : dArr) {
            destination.add(transform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean Ox0OXI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                z = z2;
            }
        }
        return Boolean.valueOf(z);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long Ox0OXoOo(float[] fArr, Oox.oOoXoXO<? super Float, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (float f : fArr) {
            j += selector.invoke(Float.valueOf(f)).longValue();
        }
        return j;
    }

    public static final boolean Ox0XO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R Ox0XX(char[] cArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float Ox0o(short[] sArr, Oox.oOoXoXO<? super Short, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static short[] Ox0x0XxO0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new short[0];
        }
        return kotlin.collections.ooOOo0oXI.oXxOI0oIx(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M OxI0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (byte b : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> OxI0000XO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Float.valueOf(f)));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C OxII(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (long j : jArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    public static final short OxIIO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                if (!z) {
                    sh = Short.valueOf(s);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(sh, "null cannot be cast to non-null type kotlin.Short");
            return sh.shortValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> OxIIxx0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i]), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static <T, R> List<Pair<T, R>> OxIO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(tArr[i], other[i]));
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int OxIO0xI(short[] sArr, Oox.oOoXoXO<? super Short, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (short s : sArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Short.valueOf(s)).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.oOoXoXO
    public static final Long OxIOX(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C OxIX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Short> OxIX00xoO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return IXoIOXoo(sArr, new Oxx0IOOO.I0Io(selector));
    }

    @xx0o0O.XO
    public static final boolean OxIXxXXI0(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[0];
    }

    @OXOo.OOXIXo
    public static final <T, K, M extends Map<? super K, List<T>>> M OxIoXo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final Set<Float> OxO0IXxX0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) xO0II(fArr, new LinkedHashSet(OI0.xoIox(fArr.length)));
            }
            return oX.XO(Float.valueOf(fArr[0]));
        }
        return Xo0.OOXIXo();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float[] OxOIO(float[] fArr, Oox.x0xO0oo<? super Integer, ? super Float, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i]));
            i++;
            i2++;
        }
        return fArr;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Integer> OxOOxIxO(int[] iArr, Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        int i = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(i));
        int length = iArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            i = operation.invoke(Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(iArr[i2])).intValue();
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static byte OxX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.oOoXoXO
    public static final Character OxXIO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            char c = cArr[length];
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return Character.valueOf(c);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @xx0o0O.XO
    public static final char OxXIoIX(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr[3];
    }

    public static final int OxXIoIxIo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R OxXO0oo(char[] cArr, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> OxXOXII(char[] cArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r);
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Character.valueOf(cArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Double OxXOo(T[] tArr, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(tArr[it.nextInt()]).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @xx0o0O.XO
    public static final double OxXOoO(double[] dArr, int i, Oox.oOoXoXO<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= OIO(dArr)) {
            return dArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).doubleValue();
    }

    public static final boolean OxXXX0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (!z) {
                    bool = Boolean.valueOf(z2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(bool, "null cannot be cast to non-null type kotlin.Boolean");
            return bool.booleanValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean OxXXx0IX0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                z = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[it.nextInt()])).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Character>> M OxXXx0OX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (char c : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> OxXoOIo00(char[] cArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r);
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Character.valueOf(cArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R OxXooIXO(int[] iArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final float[] Oxo0I0O(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        II00O0IoI(copyOf);
        return copyOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void OxoI0I(@OXOo.OOXIXo char[] cArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, cArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            char c = cArr[i];
            cArr[i] = cArr[i4];
            cArr[i4] = c;
            i4--;
            i++;
        }
    }

    public static final void OxoIO00(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]));
            i++;
            i2++;
        }
    }

    public static final char OxoOX0X0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char c = cArr[length];
                if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                    return c;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T, R extends Comparable<? super R>> T Oxox(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int o0IXO = o0IXO(tArr);
        if (o0IXO == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            R invoke2 = selector.invoke(t2);
            if (invoke.compareTo(invoke2) > 0) {
                t = t2;
                invoke = invoke2;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> OxoxX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i]), other[i]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M Oxx0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapSequenceTo")
    @kotlin.X00IoxXI
    public static final <T, R, C extends Collection<? super R>> C Oxx0XxOI0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (T t : tArr) {
            OxI.Ioxxx(destination, transform.invoke(t));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Integer> Oxx0x(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        Integer[] XXoO0oX2 = kotlin.collections.ooOOo0oXI.XXoO0oX(iArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(XXoO0oX2);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(XXoO0oX2);
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Short> OxxIXIX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> int OxxO0XX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            int i = iArr[0];
            int oOIoXOoI = oOIoXOoI(iArr);
            if (oOIoXOoI == 0) {
                return i;
            }
            R invoke = selector.invoke(Integer.valueOf(i));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                R invoke2 = selector.invoke(Integer.valueOf(i2));
                if (invoke.compareTo(invoke2) > 0) {
                    i = i2;
                    invoke = invoke2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    public static final boolean OxxOI0x(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final Set<Byte> OxxXooXO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Iterable<Byte> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Byte> I0OOxXXIx = I0OOxXXIx(bArr);
        OxI.XIo0oOXIx(I0OOxXXIx, other);
        return I0OOxXXIx;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M Oxxx0X0oI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static <T> Iterable<xI<T>> X00(@OXOo.OOXIXo final T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends T>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<T> invoke() {
                return kotlin.jvm.internal.II0XooXoX.oIX0oI(tArr);
            }
        });
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Double>> C X000ooOxx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                destination.add(Double.valueOf(d));
            }
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S X000ox(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int o0IXO = o0IXO(tArr);
        if (o0IXO < 0) {
            return null;
        }
        S s = (S) tArr[o0IXO];
        for (int i = o0IXO - 1; i >= 0; i--) {
            s = operation.invoke((Object) tArr[i], s);
        }
        return s;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float X00IoX(int[] iArr, Oox.oOoXoXO<? super Integer, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C X00O(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (float f : fArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static List<Float> X00OO00x(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            if (length != 1) {
                return OoIIxX(fArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Float.valueOf(fArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> X00x0(boolean[] zArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r);
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Boolean.valueOf(zArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final boolean X0I(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C X0IXX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (T t : tArr) {
            destination.add(transform.invoke(t));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Short> X0IXXooOI(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Character> X0Ix(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int IoOIIOx = IoOIIOx(cArr); -1 < IoOIIOx; IoOIIOx--) {
            if (!predicate.invoke(Character.valueOf(cArr[IoOIIOx])).booleanValue()) {
                return IIx(cArr, IoOIIOx + 1);
            }
        }
        return oxoIIXo(cArr);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M X0Ix00XxO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (long j : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int X0IxXOO0(byte[] bArr, Oox.oOoXoXO<? super Byte, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (byte b : bArr) {
            i += selector.invoke(Byte.valueOf(b)).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final short[] X0IxoIO(@OXOo.OOXIXo Short[] shArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> X0OIo0XxO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(IoI0xOIOO(tArr));
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Double X0OOXI0(T[] tArr, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(tArr[it.nextInt()]).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double X0OOXXox(long[] jArr, Oox.oOoXoXO<? super Long, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (long j : jArr) {
            d += selector.invoke(Long.valueOf(j)).doubleValue();
        }
        return d;
    }

    public static char X0OOoXIOX(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M X0OXI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (char c : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c)), valueTransform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float X0OXIOxX(char[] cArr, Oox.oOoXoXO<? super Character, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int X0OXOOo0(byte[] bArr, Oox.oOoXoXO<? super Byte, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (byte b : bArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Byte.valueOf(b)).OO());
        }
        return oOoXoXO2;
    }

    @xx0o0O.XO
    public static final Short X0OXoo0(short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return xxIOx(sArr, i);
    }

    public static final <R> R X0OXxIII(@OXOo.OOXIXo double[] dArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int OIO = OIO(dArr); OIO >= 0; OIO--) {
            r = operation.invoke(Double.valueOf(dArr[OIO]), r);
        }
        return r;
    }

    public static final <R> R X0Ox(@OXOo.OOXIXo int[] iArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int i : iArr) {
            r = operation.invoke(r, Integer.valueOf(i));
        }
        return r;
    }

    public static final char X0OxoOx(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[IoOIIOx(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean[] X0OxxO(boolean[] zArr, Oox.oOoXoXO<? super Boolean, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (boolean z : zArr) {
            action.invoke(Boolean.valueOf(z));
        }
        return zArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer X0OxxX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (i > i2) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Float X0X(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int oXIX = oXIX(fArr);
        if (oXIX == 0) {
            return Float.valueOf(f);
        }
        R invoke = selector.invoke(Float.valueOf(f));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            R invoke2 = selector.invoke(Float.valueOf(f2));
            if (invoke.compareTo(invoke2) < 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return Float.valueOf(f);
    }

    public static final <R> R X0X0(@OXOo.OOXIXo char[] cArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int IoOIIOx = IoOIIOx(cArr); IoOIIOx >= 0; IoOIIOx--) {
            r = operation.invoke(Character.valueOf(cArr[IoOIIOx]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final List<Integer> X0X0X(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Double, R>> X0X0x00(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Double.valueOf(dArr[i]), r));
            i++;
        }
        return arrayList;
    }

    public static final int X0XI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long X0XO(long[] jArr, Oox.oOoXoXO<? super Long, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (long j : jArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Long.valueOf(j)).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static <T> List<T> X0XOOO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.oI0IIXIo(tArr));
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final int X0XXOX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (iArr.length != 0) {
            int i = iArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) > 0) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Boolean> X0XXxoOoX(@OXOo.OOXIXo boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (i >= 0) {
            return oIX0O0OX(zArr, X0.IIXOooo.OxxIIOOXO(zArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double X0XoO(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length != 0) {
            double d = dArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                d = Math.max(d, dArr[it.nextInt()]);
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void X0Xox(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        XI0x0I(iArr, Random.Default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R X0XxXXO0(T[] tArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(tArr[0]);
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(tArr[it.nextInt()]);
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer X0Xxxoo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) < 0) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> X0o(byte[] bArr, R r, Oox.x0xO0oo<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r);
        for (byte b : bArr) {
            r = operation.invoke(r, Byte.valueOf(b));
            arrayList.add(r);
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final char X0o0O0x(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length != 0) {
            char c = cArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (kotlin.jvm.internal.IIX0o.oI0IIXIo(c, c2) < 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte[] X0oI0OX0(byte[] bArr, Oox.x0xO0oo<? super Integer, ? super Byte, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i]));
            i++;
            i2++;
        }
        return bArr;
    }

    @xx0o0O.XO
    public static final boolean X0oO(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> X0oX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(fArr.length), 16));
        for (float f : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final double[] X0oo(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int OIO = OIO(dArr);
        oOXoIIIo it = new X0.oOoXoXO(0, OIO).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            dArr2[OIO - nextInt] = dArr[nextInt];
        }
        return dArr2;
    }

    @OXOo.OOXIXo
    public static <T> List<T> X0ooIIO(@OXOo.OOXIXo T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= tArr.length) {
                return IoXOX(tArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(tArr[0]);
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (T t : tArr) {
                arrayList.add(t);
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short X0ox(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = xX0Ox(sArr);
        if (xX0Ox < 0) {
            return null;
        }
        short s = sArr[xX0Ox];
        for (int i = xX0Ox - 1; i >= 0; i--) {
            s = operation.invoke(Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
        }
        return Short.valueOf(s);
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Long>>> M X0oxOX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Short>> X0oxX0(@OXOo.OOXIXo final short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Short>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Short> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.II0XooXoX(sArr);
            }
        });
    }

    @xx0o0O.XO
    public static final char X0xO(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr[1];
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final <T> int X0xOX0oO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (T t : tArr) {
            i += selector.invoke(t).intValue();
        }
        return i;
    }

    public static final int X0xOoIX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length != 0) {
            int i = iArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                i = operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[it.nextInt()])).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static boolean X0xX(@OXOo.OOXIXo short[] sArr, short s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (Oo0OxoOx(sArr, s) >= 0) {
            return true;
        }
        return false;
    }

    @xx0o0O.XO
    public static final char X0xXOX(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr[4];
    }

    @OXOo.OOXIXo
    public static final List<Integer> X0xo0oOx(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Integer> oXooI = oXooI(iArr);
        X0IIOO.oXX0IoI(oXooI);
        return oXooI;
    }

    @xx0o0O.XO
    public static final short XI0(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr[3];
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final float XI0IXO(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return II0Xx(fArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static final List<Character> XI0Ix0oX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.oO(kotlin.collections.ooOOo0oXI.xXoOI00O(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final int XI0O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> XI0Ox(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : tArr) {
            if (z) {
                arrayList.add(t);
            } else if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XI0oI(long[] jArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XI0oOxIXx(@OXOo.OOXIXo float[] fArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, fArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            float f = fArr[i];
            fArr[i] = fArr[i4];
            fArr[i4] = f;
            i4--;
            i++;
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void XI0x0I(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int oOIoXOoI = oOIoXOoI(iArr); oOIoXOoI > 0; oOIoXOoI--) {
            int nextInt = random.nextInt(oOIoXOoI + 1);
            int i = iArr[oOIoXOoI];
            iArr[oOIoXOoI] = iArr[nextInt];
            iArr[nextInt] = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XI0xIOoo(long[] jArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final List<Short> XI0xO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void XI0xXOOxx(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length > 1) {
            kotlin.collections.ooOOo0oXI.X00IxOx(dArr);
            oOxx00x(dArr);
        }
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Character>> XI0xXoI(@OXOo.OOXIXo final char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Character>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Character> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.I0Io(cArr);
            }
        });
    }

    public static final byte XII(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length != 0) {
            byte b = bArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                b = operation.invoke(Byte.valueOf(b), Byte.valueOf(bArr[it.nextInt()])).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double XII0XIXx(double[] dArr, Oox.oOoXoXO<? super Double, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M XIIOIXoI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C XIIo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final HashSet<Byte> XIIoIO(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return (HashSet) xXxxOxI0I(bArr, new HashSet(OI0.xoIox(bArr.length)));
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> XIIxIO(boolean[] zArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r);
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Boolean.valueOf(zArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Byte>> XIIxIX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XIIxIxOOo(long[] jArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final String XIIxXO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) ooxII(iArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.oOoXoXO
    public static final Integer XIO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                if (z) {
                    return null;
                }
                num = Integer.valueOf(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return num;
    }

    public static final boolean XIOIx0IxI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int XXoXOI = XXoXOI(zArr);
        if (XXoXOI >= 0) {
            boolean z = zArr[XXoXOI];
            for (int i = XXoXOI - 1; i >= 0; i--) {
                z = operation.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final <R> List<R> XIOOX0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i)));
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final int XIOX(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr.length;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> XIOX0(int[] iArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Integer.valueOf(iArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long XIOX0O(short[] sArr, Oox.oOoXoXO<? super Short, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (short s : sArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Short.valueOf(s)).OO());
        }
        return oOoXoXO2;
    }

    @xx0o0O.XO
    public static final float XIOoI(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr[1];
    }

    @OXOo.OOXIXo
    public static final Set<Boolean> XIOoXOoX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Iterable<Boolean> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Boolean> oxOXXXoX = oxOXXXoX(zArr);
        OxI.oXIO0o0XI(oxOXXXoX, other);
        return oxOXXXoX;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Float>> XIOxIIxxI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <K> List<Byte> XIX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (hashSet.add(selector.invoke(Byte.valueOf(b)))) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> XIX0Oo0(boolean[] zArr, Oox.x0xO0oo<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void XIX0XxoIo(@OXOo.OOXIXo int[] iArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, iArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            int i5 = iArr[i];
            iArr[i] = iArr[i4];
            iArr[i4] = i5;
            i4--;
            i++;
        }
    }

    @OXOo.OOXIXo
    public static List<Boolean> XIX0oOXXO(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            if (length != 1) {
                return xxX0I(zArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Boolean.valueOf(zArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C XIXI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <V> List<V> XIXIOO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo byte[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super Byte, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(other[i])));
        }
        return arrayList;
    }

    public static int XIXIo0OX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[oOIoXOoI(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float XIXIxIOoX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.nextInt(fArr.length)]);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T XIXOxI0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (comparator.compare(t, t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    public static final List<Integer> XIXo0OIOo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int oOIoXOoI = oOIoXOoI(iArr); -1 < oOIoXOoI; oOIoXOoI--) {
            if (!predicate.invoke(Integer.valueOf(iArr[oOIoXOoI])).booleanValue()) {
                return oIxIOoOx(iArr, oOIoXOoI + 1);
            }
        }
        return XXX0(iArr);
    }

    public static short XIXoo(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            if (length == 1) {
                return sArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, V> XIo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(tArr.length), 16));
        for (I00O.II0xO0 iI0xO0 : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(iI0xO0);
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <R> R XIo0IOI0(@OXOo.OOXIXo double[] dArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Double.valueOf(dArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R XIoI(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(tArr[0]);
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(tArr[it.nextInt()]);
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.OOXIXo
    public static final byte[] XIoIXXIXI(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        XoOI(copyOf);
        return copyOf;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> XIooOxX(short[] sArr, R r, Oox.x0xO0oo<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r);
        for (short s : sArr) {
            r = operation.invoke(r, Short.valueOf(s));
            arrayList.add(r);
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Double, V> XIoox00ox(double[] dArr, Oox.oOoXoXO<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(Double.valueOf(d), valueSelector.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double XIoxO00(byte[] bArr, Oox.oOoXoXO<? super Byte, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Byte, R>> XIoxoX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Byte.valueOf(bArr[i]), r));
            i++;
        }
        return arrayList;
    }

    public static final int XIx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Byte.valueOf(bArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> XIx0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    public static final void XIxI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Boolean, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i]));
            i++;
            i2++;
        }
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Double> XIxI0(double[] dArr, Oox.x0xO0oo<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        double d = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(d));
        int length = dArr.length;
        for (int i = 1; i < length; i++) {
            d = operation.invoke(Double.valueOf(d), Double.valueOf(dArr[i])).doubleValue();
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final X0.oOoXoXO XIxIO0XO(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return new X0.oOoXoXO(0, IoOIIOx(cArr));
    }

    public static /* synthetic */ Appendable XIxIOOOx(int[] iArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return ooxII(iArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @OXOo.OOXIXo
    public static final List<Byte> XIxOIII(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XIxOx(boolean[] zArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void XIxX0xXO(@OXOo.OOXIXo byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, bArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            byte b = bArr[i];
            bArr[i] = bArr[i4];
            bArr[i4] = b;
            i4--;
            i++;
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Integer XIxo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int oOIoXOoI = oOIoXOoI(iArr);
        if (oOIoXOoI == 0) {
            return Integer.valueOf(i);
        }
        R invoke = selector.invoke(Integer.valueOf(i));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            R invoke2 = selector.invoke(Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) > 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return Integer.valueOf(i);
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> XIxoOo0oI(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i)), valueTransform.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static long[] XIxooxXIX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr2[i] = jArr[it.next().intValue()];
            i++;
        }
        return jArr2;
    }

    public static final boolean XO0(@OXOo.OOXIXo char[] cArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Short>> C XO000(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            short s = sArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Short.valueOf(s)).booleanValue()) {
                destination.add(Short.valueOf(s));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Float> XO0O00OX(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.xOoIIIoXI(copyOf);
        return OXOxx(copyOf);
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Byte>> XO0OI00O(@OXOo.OOXIXo final byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Byte>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Byte> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.II0xO0(bArr);
            }
        });
    }

    @OXOo.OOXIXo
    public static final <T> Pair<List<T>, List<T>> XO0Ox0X(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final void XO0XIXOo0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (short s : sArr) {
            action.invoke(Short.valueOf(s));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XO0XoIxo(int[] iArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float XO0oIxoOX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Comparator<? super Float> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (fArr.length != 0) {
            float f = fArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                float f2 = fArr[it.nextInt()];
                if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) > 0) {
                    f = f2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> XO0ooX(long[] jArr, R r, Oox.x0xO0oo<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r);
        for (long j : jArr) {
            r = operation.invoke(r, Long.valueOf(j));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double XO0xXoO0X(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Comparator<? super Double> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) < 0) {
                d = d2;
            }
        }
        return Double.valueOf(d);
    }

    @OXOo.OOXIXo
    public static final <T> T[] XOI(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) kotlin.collections.OOXIXo.oIX0oI(tArr, tArr.length);
        int o0IXO = o0IXO(tArr);
        oOXoIIIo it = new X0.oOoXoXO(0, o0IXO).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            tArr2[o0IXO - nextInt] = tArr[nextInt];
        }
        return tArr2;
    }

    @OXOo.OOXIXo
    public static final List<Integer> XOI0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.IXxxXO(kotlin.collections.ooOOo0oXI.X0xII0I(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @OXOo.OOXIXo
    public static final List<Byte> XOI0XIII(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        Byte[] Oxxo2 = kotlin.collections.ooOOo0oXI.Oxxo(bArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(Oxxo2);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(Oxxo2);
    }

    @xx0o0O.XO
    public static final <T> T XOIIOIx(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[4];
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double XOIOIX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.nextInt(dArr.length)]);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> XOIX0OOIX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int o0IXO = o0IXO(tArr); -1 < o0IXO; o0IXO--) {
            if (!predicate.invoke(tArr[o0IXO]).booleanValue()) {
                return ox0xI00IX(tArr, o0IXO + 1);
            }
        }
        return IoXOX(tArr);
    }

    @xx0o0O.XO
    public static final Double XOIoXxI(double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return OXxIOxox(dArr, i);
    }

    public static final float XOIx0IOo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length != 0) {
            float f = fArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                f = operation.invoke(Integer.valueOf(nextInt), Float.valueOf(f), Float.valueOf(fArr[nextInt])).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long XOIxxO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IOXI = IOXI(jArr);
        if (IOXI >= 0) {
            long j = jArr[IOXI];
            for (int i = IOXI - 1; i >= 0; i--) {
                j = operation.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @xx0o0O.XO
    public static final float XOO(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr[2];
    }

    public static final float XOOI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return f;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Integer, V> XOOI0(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(Integer.valueOf(i), valueSelector.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short XOOIo0X(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            s = operation.invoke(Integer.valueOf(nextInt), Short.valueOf(s), Short.valueOf(sArr[nextInt])).shortValue();
        }
        return Short.valueOf(s);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float XOOXI0(long[] jArr, Oox.oOoXoXO<? super Long, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float XOOXIXxxI(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(fArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, fArr[it.nextInt()].floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final int XOOXX0II(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int XOOXoX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int i = 0;
        for (byte b : bArr) {
            i += b;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M XOOoX0xo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Long> XOOooo(@OXOo.OOXIXo long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (i >= 0) {
            return x0xxO0xox(jArr, X0.IIXOooo.OxxIIOOXO(jArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @xx0o0O.XO
    public static final boolean XOOxX(boolean[] zArr, int i, Oox.oOoXoXO<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= XXoXOI(zArr)) {
            return zArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).booleanValue();
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final char XOOxoxI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (cArr.length != 0) {
            return cArr[random.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.oOoXoXO
    public static final Character XOX(@OXOo.OOXIXo char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (i >= 0 && i <= IoOIIOx(cArr)) {
            return Character.valueOf(cArr[i]);
        }
        return null;
    }

    @xx0o0O.XO
    public static final double XOX0XxOxI(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr[2];
    }

    @OXOo.OOXIXo
    public static final Set<Long> XOX0oo0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Iterable<Long> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Long> IO0X = IO0X(jArr);
        OxI.XIo0oOXIx(IO0X, other);
        return IO0X;
    }

    public static final boolean XOX0x0XO(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[XXoXOI(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final List<Character> XOXIx(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        Character[] XXooOOI2 = kotlin.collections.ooOOo0oXI.XXooOOI(cArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(XXooOOI2);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(XXooOOI2);
    }

    @OXOo.OOXIXo
    public static final <V> List<V> XOXO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo double[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super Double, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i]), Double.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static <T> List<T> XOXXox0(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<T> X0XOOO = X0XOOO(tArr);
        X0IIOO.oXX0IoI(X0XOOO);
        return X0XOOO;
    }

    @OXOo.OOXIXo
    public static final List<Long> XOXo0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(IO0X(jArr));
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> XOXoO0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R XOXoxo(short[] sArr, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> double XOXx(T[] tArr, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            double doubleValue = selector.invoke(tArr[0]).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(tArr[it.nextInt()]).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Set<Boolean> XOXxOIxII(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Iterable<Boolean> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Boolean> oxOXXXoX = oxOXXXoX(zArr);
        OxI.XIo0oOXIx(oxOXXXoX, other);
        return oxOXXXoX;
    }

    @OXOo.OOXIXo
    public static final String XOXxX0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Byte, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) XxOOX(bArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C XOXxxXo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (char c : cArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Character.valueOf(c)));
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Double XOo(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @OXOo.OOXIXo
    public static final List<Character> XOoI(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(Xox(cArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XOoI0OX(byte[] bArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Long, R>> XOoOXXx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            long j = jArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Long.valueOf(j), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> T[] XOoX(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        for (T t : tArr) {
            if (t == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Short XOoooI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int xX0Ox = xX0Ox(sArr);
        if (xX0Ox == 0) {
            return Short.valueOf(s);
        }
        R invoke = selector.invoke(Short.valueOf(s));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            R invoke2 = selector.invoke(Short.valueOf(s2));
            if (invoke.compareTo(invoke2) > 0) {
                s = s2;
                invoke = invoke2;
            }
        }
        return Short.valueOf(s);
    }

    @OXOo.OOXIXo
    public static final List<Character> XOoooo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Integer> XOoxOOO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i)), Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T, R extends Comparable<? super R>> List<T> XOoxOXI0x(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return Ox00Xx0O(tArr, new Oxx0IOOO.oIX0oI(selector));
    }

    public static final int XOoxOo0oX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                int i2 = iArr[length];
                if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                    return i2;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean XOx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final <T, K> Map<K, T> XOx0xX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final long[] XOxOxoXo(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.X0(copyOf);
        return copyOf;
    }

    public static final int XOxoXO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Float.valueOf(fArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final float[] XOxxOO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr2[i] = fArr[it.next().intValue()];
            i++;
        }
        return fArr2;
    }

    public static final int XOxxxx00X(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @xx0o0O.XO
    public static final char XX00xxo(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return cArr[0];
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R XX0IOx(short[] sArr, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            R invoke = selector.invoke(Short.valueOf(sArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final char XX0Io(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (cArr.length != 0) {
            char c = cArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) < 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final char[] XX0OXX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new char[0];
        }
        return kotlin.collections.ooOOo0oXI.xXoOI00O(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final int XX0XXOO(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length != 0) {
            int i = iArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (i > i2) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XX0xxI(int[] iArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Character XXI(char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return OIxIOOX0x(cArr, Random.Default);
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> double XXI00xO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            double d = dArr[0];
            int OIO = OIO(dArr);
            if (OIO == 0) {
                return d;
            }
            R invoke = selector.invoke(Double.valueOf(d));
            oOXoIIIo it = new X0.oOoXoXO(1, OIO).iterator();
            while (it.hasNext()) {
                double d2 = dArr[it.nextInt()];
                R invoke2 = selector.invoke(Double.valueOf(d2));
                if (invoke.compareTo(invoke2) < 0) {
                    d = d2;
                    invoke = invoke2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    public static final /* synthetic */ <R> List<R> XXI0XXo(Object[] objArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            kotlin.jvm.internal.IIX0o.OxI(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> T[] XXIIoOI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.IIX0o.oO(tArr2, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(tArr2, comparator);
        return tArr2;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer XXIOoXOI(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i), Integer.valueOf(i2)) > 0) {
                i = i2;
            }
        }
        return Integer.valueOf(i);
    }

    public static final char XXIOxIoIo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length != 0) {
            char c = cArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                c = operation.invoke(Integer.valueOf(nextInt), Character.valueOf(c), Character.valueOf(cArr[nextInt])).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XXIX(byte[] bArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    public static long XXIX0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    @OXOo.OOXIXo
    public static int[] XXIXOOX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr2[i] = iArr[it.next().intValue()];
            i++;
        }
        return iArr2;
    }

    @OXOo.OOXIXo
    public static final List<Byte> XXIo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int xxXIIXIxx = xxXIIXIxx(bArr); -1 < xxXIIXIxx; xxXIIXIxx--) {
            if (!predicate.invoke(Byte.valueOf(bArr[xxXIIXIxx])).booleanValue()) {
                return o0XX0(bArr, xxXIIXIxx + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C XXIo0OO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (byte b : bArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final <T> T XXIx0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (tArr.length != 0) {
            return tArr[random.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final void XXO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Short, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i]));
            i++;
            i2++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> XXO0ox0(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, tArr[i]);
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Character, R>> XXOIooI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            char c = cArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Character.valueOf(c), other[i]));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Integer XXOO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            int i2 = iArr[length];
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return Integer.valueOf(i2);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @XO0OX.xxIXOIIO(name = "averageOfInt")
    public static final double XXOOoxx0x(@OXOo.OOXIXo Integer[] numArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(numArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (Integer num : numArr) {
            d += num.intValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    public static final List<Float> XXOXXOIxo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int oXIX = oXIX(fArr); -1 < oXIX; oXIX--) {
            if (!predicate.invoke(Float.valueOf(fArr[oXIX])).booleanValue()) {
                return oIoox0(fArr, oXIX + 1);
            }
        }
        return X00OO00x(fArr);
    }

    public static <T> T XXOXXx(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @xx0o0O.XO
    public static final <T> T XXOo(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[1];
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Boolean>> XXOoooXo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    public static final int XXOxx0o00(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int i = 0;
        for (short s : sArr) {
            i += s;
        }
        return i;
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> byte XXX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int xxXIIXIxx = xxXIIXIxx(bArr);
            if (xxXIIXIxx == 0) {
                return b;
            }
            R invoke = selector.invoke(Byte.valueOf(b));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                R invoke2 = selector.invoke(Byte.valueOf(b2));
                if (invoke.compareTo(invoke2) > 0) {
                    b = b2;
                    invoke = invoke2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static List<Integer> XXX0(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            if (length != 1) {
                return oXooI(iArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Integer.valueOf(iArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.oOoXoXO
    public static final Long XXXOoIXXx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            long j = jArr[length];
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return Long.valueOf(j);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    public static boolean XXXoOII(@OXOo.OOXIXo long[] jArr, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (XxxoIooX(jArr, j) >= 0) {
            return true;
        }
        return false;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final boolean XXXxIx(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return O0X0(zArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static final HashSet<Float> XXXxXoII0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return (HashSet) xO0II(fArr, new HashSet(OI0.xoIox(fArr.length)));
    }

    @XO0OX.xxIXOIIO(name = "sumOfByte")
    public static final int XXo0(@OXOo.OOXIXo Byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int i = 0;
        for (Byte b : bArr) {
            i += b.byteValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final String XXoIoXOO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Boolean, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) xIxO0X0I(zArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static final List<Short> XXoOOO0I(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(oX0XXxO(sArr));
    }

    public static final int XXoXOI(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr.length - 1;
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> List<T> XXoXoXo(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(o0oXoOoo(tArr));
    }

    public static short XXoo0(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[xX0Ox(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A XXooo0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Double, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (double d : dArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Double.valueOf(d)));
            } else {
                buffer.append(String.valueOf(d));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @OXOo.oOoXoXO
    public static final Long Xo000XO0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> Xo00XX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final boolean Xo0IXOO00(float[] fArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static /* synthetic */ String Xo0OOoo(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return XxOOO0(sArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float Xo0XO0ooI(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length != 0) {
            float floatValue = fArr[0].floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(fArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, fArr[it.nextInt()].floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Double> Xo0XX000(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K> XxX0x0xxx<T, K> Xo0oxx(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        return new oI0IIXIo(tArr, keySelector);
    }

    @OXOo.OOXIXo
    public static final List<Double> Xo0oxxX0(@OXOo.OOXIXo double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (i >= 0) {
            return Xx0Ox(dArr, X0.IIXOooo.OxxIIOOXO(dArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void Xo0x0I(@OXOo.OOXIXo short[] sArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, sArr.length);
        int i3 = (i + i2) / 2;
        if (i == i3) {
            return;
        }
        int i4 = i2 - 1;
        while (i < i3) {
            short s = sArr[i];
            sArr[i] = sArr[i4];
            sArr[i4] = s;
            i4--;
            i++;
        }
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double Xo0xX(byte[] bArr, Oox.oOoXoXO<? super Byte, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    public static <T> void Xo0xoOxI0(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int o0IXO = o0IXO(tArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t = tArr[nextInt];
            tArr[nextInt] = tArr[o0IXO];
            tArr[o0IXO] = t;
            o0IXO--;
        }
    }

    @OXOo.OOXIXo
    public static final List<Short> XoI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (short s : sArr) {
            if (z) {
                arrayList.add(Short.valueOf(s));
            } else if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
                z = true;
            }
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Double XoI0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            double d = dArr[length];
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return Double.valueOf(d);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @OXOo.OOXIXo
    public static final List<Short> XoI0Ixoo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Float, ? super V>> M XoI0OoX(float[] fArr, M destination, Oox.oOoXoXO<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (float f : fArr) {
            destination.put(Float.valueOf(f), valueSelector.invoke(Float.valueOf(f)));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final short XoIOoo00(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Comparator<? super Short> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (sArr.length != 0) {
            short s = sArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) < 0) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final boolean[] XoIOooOo(@OXOo.OOXIXo Boolean[] boolArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    @OXOo.OOXIXo
    public static final Iterable<Long> XoIoOXOIx(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new X0o0xo(jArr);
    }

    @OXOo.oOoXoXO
    public static final Integer XoIx(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final double XoIxo(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (short s : sArr) {
            d += s;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @xx0o0O.XO
    public static final boolean XoO(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[3];
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double XoO0Oo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (float f : fArr) {
            d += selector.invoke(Float.valueOf(f)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Integer>> XoO0xXIX(@OXOo.OOXIXo final int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Integer>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Integer> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.XO(iArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R XoO0xxI(T[] tArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            Object obj = (R) selector.invoke(tArr[0]);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(tArr[it.nextInt()]);
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    public static final void XoOI(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length > 1) {
            kotlin.collections.ooOOo0oXI.X0x(bArr);
            ooIxXoX(bArr);
        }
    }

    @OXOo.OOXIXo
    public static final List<Boolean> XoOIX(@OXOo.OOXIXo boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = zArr.length;
            if (i >= length) {
                return XIX0oOXXO(zArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Boolean.valueOf(zArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Boolean.valueOf(zArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> XoOO(short[] sArr, R r, Oox.x0xO0oo<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r);
        for (short s : sArr) {
            r = operation.invoke(r, Short.valueOf(s));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Character> XoOOOXox(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new Oxx0xo(cArr);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float XoOOoX0(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final long XoOOxOo0o(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr[0];
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Short>>> M XoOo0Ooo0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return destination;
    }

    public static int XoOoxI0X(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    @xx0o0O.XO
    public static final boolean XoOoxIIx(double[] dArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, List<V>> XoXIXxxI0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (I00O.II0xO0 iI0xO0 : tArr) {
            K invoke = keySelector.invoke(iI0xO0);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(iI0xO0));
        }
        return linkedHashMap;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R XoXO(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final boolean XoXOIx(long[] jArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.OOXIXo
    public static final List<Character> XoXOxI0XI(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Character> xxxo0II0O = xxxo0II0O(cArr);
        X0IIOO.oXX0IoI(xxxo0II0O);
        return xxxo0II0O;
    }

    @OXOo.OOXIXo
    public static final List<Float> XoXX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Float>> C XoXX0x00(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                destination.add(Float.valueOf(f));
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final Set<Float> XoXXXI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Iterable<Float> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Float> oxOxXO = oxOxXO(fArr);
        OxI.oXIO0o0XI(oxOxXO, other);
        return oxOxXO;
    }

    public static /* synthetic */ String XoXoOo(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return XOXxX0(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final List<Integer> XoXxXXX(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = iArr.length;
            if (i >= length) {
                return XXX0(iArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Integer.valueOf(iArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Integer.valueOf(iArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.oOoXoXO
    public static final Long Xoo0(@OXOo.OOXIXo long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (i >= 0 && i <= IOXI(jArr)) {
            return Long.valueOf(jArr[i]);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> XooOx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(transform.invoke(Long.valueOf(j)));
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Boolean XooX(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return xIoxxXxXo(zArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M Xooo0Xx(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (char c : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M Xoooo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> XooooIO0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            R invoke = transform.invoke(Integer.valueOf(i2), tArr[i]);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Set<Character> Xox(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return (Set) IOIXIoo(cArr, new LinkedHashSet(OI0.xoIox(X0.IIXOooo.XI0IXoo(cArr.length, 128))));
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> Xox0o(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f)), valueTransform.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double XoxIII(char[] cArr, Oox.oOoXoXO<? super Character, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (char c : cArr) {
            d += selector.invoke(Character.valueOf(c)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final boolean[] XoxIX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new boolean[0];
        }
        return kotlin.collections.ooOOo0oXI.XOxxooXI(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @OXOo.OOXIXo
    public static final float[] XoxIoI(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double XoxO0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Comparator<? super Double> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (dArr.length != 0) {
            double d = dArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                double d2 = dArr[it.nextInt()];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) < 0) {
                    d = d2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @OXOo.oOoXoXO
    public static final Character XoxX(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final <T> void XoxXOX0I(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (T t : tArr) {
            action.invoke(t);
        }
    }

    @OXOo.OOXIXo
    public static final List<Boolean> XoxXox(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (boolean z2 : zArr) {
            if (z) {
                arrayList.add(Boolean.valueOf(z2));
            } else if (!predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
                z = true;
            }
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Short XoxoOo(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double Xx00(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length != 0) {
            double doubleValue = dArr[0].doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(dArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, dArr[it.nextInt()].doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.oOoXoXO
    public static final Character Xx0I(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    public static /* synthetic */ String Xx0IoOX(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return XXoIoXOO(zArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    public static final int Xx0O0O(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Integer.valueOf(iArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double Xx0OX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int OIO = OIO(dArr);
        if (OIO < 0) {
            return null;
        }
        double d = dArr[OIO];
        for (int i = OIO - 1; i >= 0; i--) {
            d = operation.invoke(Integer.valueOf(i), Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
        }
        return Double.valueOf(d);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Double, ? super V>> M Xx0OXIoI(double[] dArr, M destination, Oox.oOoXoXO<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (double d : dArr) {
            destination.put(Double.valueOf(d), valueSelector.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double Xx0Oo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (long j : jArr) {
            d += selector.invoke(Long.valueOf(j)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final List<Double> Xx0Ox(@OXOo.OOXIXo double[] dArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = dArr.length;
            if (i >= length) {
                return OXIIooO0(dArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Double.valueOf(dArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Double.valueOf(dArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final List<Float> Xx0X(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Float.valueOf(f)).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int Xx0o(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (float f : fArr) {
            i += selector.invoke(Float.valueOf(f)).intValue();
        }
        return i;
    }

    public static final float Xx0oI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Float f = null;
        boolean z = false;
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                if (!z) {
                    f = Float.valueOf(f2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(f, "null cannot be cast to non-null type kotlin.Float");
            return f.floatValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double[] Xx0oIXI0(double[] dArr, Oox.x0xO0oo<? super Integer, ? super Double, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i]));
            i++;
            i2++;
        }
        return dArr;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Integer> Xx0oX(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new ooOOo0oXI(iArr);
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Character> Xx0x0IoIX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return OXxI0IX0(cArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @OXOo.OOXIXo
    public static long[] Xx0xOX0x(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int IOXI = IOXI(jArr);
        oOXoIIIo it = new X0.oOoXoXO(0, IOXI).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            jArr2[IOXI - nextInt] = jArr[nextInt];
        }
        return jArr2;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Double> XxI0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, ? super V>> M XxIO0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (T t : tArr) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Boolean XxIX(@OXOo.OOXIXo boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (i >= 0 && i <= XXoXOI(zArr)) {
            return Boolean.valueOf(zArr[i]);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R XxIXOoIX(byte[] bArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C XxO(short[] sArr, C destination, Oox.x0xO0oo<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final short[] XxOII0O(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        xX0Xo(copyOf);
        return copyOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Boolean XxOIoXI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int XXoXOI = XXoXOI(zArr);
        if (XXoXOI == 0) {
            return Boolean.valueOf(z);
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            R invoke2 = selector.invoke(Boolean.valueOf(z2));
            if (invoke.compareTo(invoke2) < 0) {
                z = z2;
                invoke = invoke2;
            }
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public static final String XxOOO0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Short, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) xxxoXXo0X(sArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A XxOOX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Byte, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Byte.valueOf(b)));
            } else {
                buffer.append(String.valueOf((int) b));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final long XxOOo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IOXI = IOXI(jArr);
        if (IOXI >= 0) {
            long j = jArr[IOXI];
            for (int i = IOXI - 1; i >= 0; i--) {
                j = operation.invoke(Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float XxOOo0O(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oXIX = oXIX(fArr);
        if (oXIX < 0) {
            return null;
        }
        float f = fArr[oXIX];
        for (int i = oXIX - 1; i >= 0; i--) {
            f = operation.invoke(Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
        }
        return Float.valueOf(f);
    }

    public static final <T> boolean XxOOooX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> XxOOoxOO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(iArr.length), 16));
        for (int i : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static <T> int XxOX(@OXOo.OOXIXo T[] tArr, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final List<Float> XxOXOI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (!predicate.invoke(Float.valueOf(f)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Character XxOXxXo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    @xx0o0O.XO
    public static final Boolean XxOx(boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return XxIX(zArr, i);
    }

    public static final float XxOxX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oXIX = oXIX(fArr);
        if (oXIX >= 0) {
            float f = fArr[oXIX];
            for (int i = oXIX - 1; i >= 0; i--) {
                f = operation.invoke(Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static long XxOxX00o(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            if (length == 1) {
                return jArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Double>> XxX(@OXOo.OOXIXo final double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Double>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Double> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.oxoX(dArr);
            }
        });
    }

    @OXOo.OOXIXo
    public static final List<Long> XxX0OXOO(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        Long[] xOI02 = kotlin.collections.ooOOo0oXI.xOI0(jArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(xOI02);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(xOI02);
    }

    @OXOo.OOXIXo
    public static final List<Short> XxX0XOxoI(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Short> X0IXXooOI = X0IXXooOI(sArr);
        X0IIOO.oXX0IoI(X0IXXooOI);
        return X0IXXooOI;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C XxX0xI(long[] jArr, C destination, Oox.x0xO0oo<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int XxXOXI0(double[] dArr, Oox.oOoXoXO<? super Double, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (double d : dArr) {
            i += selector.invoke(Double.valueOf(d)).intValue();
        }
        return i;
    }

    @xx0o0O.XO
    public static final Short XxXOXo0Xx(short[] sArr, Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return Short.valueOf(s);
            }
        }
        return null;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int XxXoxo00(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (byte b : bArr) {
            i += selector.invoke(Byte.valueOf(b)).intValue();
        }
        return i;
    }

    public static final <R> R XxXxIx(@OXOo.OOXIXo char[] cArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int IoOIIOx = IoOIIOx(cArr); IoOIIOx >= 0; IoOIIOx--) {
            r = operation.invoke(Integer.valueOf(IoOIIOx), Character.valueOf(cArr[IoOIIOx]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C Xxo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Double> Xxo0IxOOx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Comparator<? super Double> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Double[] OIII0O2 = kotlin.collections.ooOOo0oXI.OIII0O(dArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(OIII0O2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(OIII0O2);
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Short>> Xxo0x(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @XO0OX.xxIXOIIO(name = "sumOfInt")
    public static final int XxoIo(@OXOo.OOXIXo Integer[] numArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(numArr, "<this>");
        int i = 0;
        for (Integer num : numArr) {
            i += num.intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Long> XxoOI00IX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final Set<Boolean> XxoOX0I(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Iterable<Boolean> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Boolean> oxOXXXoX = oxOXXXoX(zArr);
        OxI.oxIIX0o(oxOXXXoX, other);
        return oxOXXXoX;
    }

    @OXOo.OOXIXo
    public static final boolean[] XxoXX0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr2[i] = zArr[it.next().intValue()];
            i++;
        }
        return zArr2;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float XxoXXxx(long[] jArr, Oox.oOoXoXO<? super Long, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Boolean> Xxoo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return o00oXxXII(zArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Byte XxooOoI(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return OXoIIXO(bArr, Random.Default);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Float XxoxOx0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int oXIX = oXIX(fArr);
        if (oXIX == 0) {
            return Float.valueOf(f);
        }
        R invoke = selector.invoke(Float.valueOf(f));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            R invoke2 = selector.invoke(Float.valueOf(f2));
            if (invoke.compareTo(invoke2) > 0) {
                f = f2;
                invoke = invoke2;
            }
        }
        return Float.valueOf(f);
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int Xxx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (long j : jArr) {
            i += selector.invoke(Long.valueOf(j)).intValue();
        }
        return i;
    }

    public static final <S, T extends S> S Xxx0Ox0I(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int o0IXO = o0IXO(tArr);
        if (o0IXO >= 0) {
            S s = (S) tArr[o0IXO];
            for (int i = o0IXO - 1; i >= 0; i--) {
                s = operation.invoke(Integer.valueOf(i), (Object) tArr[i], s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void Xxx0X0O(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        oIO0xOOxo(cArr, Random.Default);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R Xxx0o(float[] fArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> byte Xxx0o0XI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            byte b = bArr[0];
            int xxXIIXIxx = xxXIIXIxx(bArr);
            if (xxXIIXIxx == 0) {
                return b;
            }
            R invoke = selector.invoke(Byte.valueOf(b));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                R invoke2 = selector.invoke(Byte.valueOf(b2));
                if (invoke.compareTo(invoke2) < 0) {
                    b = b2;
                    invoke = invoke2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    public static void XxxI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int oOIoXOoI = oOIoXOoI(iArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int i = iArr[nextInt];
            iArr[nextInt] = iArr[oOIoXOoI];
            iArr[oOIoXOoI] = i;
            oOIoXOoI--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> XxxIIoOo(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        for (I00O.II0xO0 iI0xO0 : tArr) {
            r = operation.invoke(r, iI0xO0);
            arrayList.add(r);
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final <T> T XxxIX(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[3];
    }

    public static final <T, R extends Comparable<? super R>> void XxxO0XoI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.ooOOo0oXI.IOOXOOOOo(tArr, new Oxx0IOOO.oIX0oI(selector));
        }
    }

    public static final <R> R XxxXX0XO0(@OXOo.OOXIXo long[] jArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (long j : jArr) {
            r = operation.invoke(r, Long.valueOf(j));
        }
        return r;
    }

    public static int XxxoIooX(@OXOo.OOXIXo long[] jArr, long j) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static X0.oOoXoXO XxxoXoX(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return new X0.oOoXoXO(0, xX0Ox(sArr));
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R XxxooX(float[] fArr, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            R invoke = selector.invoke(Float.valueOf(fArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final HashSet<Boolean> XxxxOX(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return (HashSet) x00xO(zArr, new HashSet(OI0.xoIox(zArr.length)));
    }

    @xx0o0O.XO
    public static final <T> T o00OI00(T[] tArr, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Short> o00OIxXXx(short[] sArr, Oox.IXxxXO<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        short s = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(s));
        int length = sArr.length;
        for (int i = 1; i < length; i++) {
            s = operation.invoke(Integer.valueOf(i), Short.valueOf(s), Short.valueOf(sArr[i])).shortValue();
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K> List<Float> o00Ox0xOO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (hashSet.add(selector.invoke(Float.valueOf(f)))) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> o00oXxXII(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Boolean[] xXIX0Xo2 = kotlin.collections.ooOOo0oXI.xXIX0Xo(zArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(xXIX0Xo2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(xXIX0Xo2);
    }

    @xx0o0O.XO
    public static final <T> T o0I(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[2];
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M o0I0O0oXX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (byte b : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b)), valueTransform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Boolean> o0II(boolean[] zArr, Oox.IXxxXO<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        boolean z = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z));
        int length = zArr.length;
        int i = 1;
        while (i < length) {
            Boolean invoke = operation.invoke(Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(zArr[i]));
            boolean booleanValue = invoke.booleanValue();
            arrayList.add(invoke);
            i++;
            z = booleanValue;
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final char[] o0IIx(char[] cArr, Oox.x0xO0oo<? super Integer, ? super Character, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i]));
            i++;
            i2++;
        }
        return cArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R o0IXI(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int o0IXO = o0IXO(tArr); o0IXO >= 0; o0IXO--) {
            r = operation.invoke(Integer.valueOf(o0IXO), tArr[o0IXO], r);
        }
        return r;
    }

    public static <T> int o0IXO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr.length - 1;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Integer, ? super V>> M o0Ixx(int[] iArr, M destination, Oox.oOoXoXO<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (int i : iArr) {
            destination.put(Integer.valueOf(i), valueSelector.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> o0O(int[] iArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Integer.valueOf(iArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final long o0O0Xx(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length != 0) {
            long j = jArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                if (j < j2) {
                    j = j2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> char o0O0oo0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            char c = cArr[0];
            int IoOIIOx = IoOIIOx(cArr);
            if (IoOIIOx == 0) {
                return c;
            }
            R invoke = selector.invoke(Character.valueOf(c));
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                R invoke2 = selector.invoke(Character.valueOf(c2));
                if (invoke.compareTo(invoke2) < 0) {
                    c = c2;
                    invoke = invoke2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Long> o0OI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int IOXI = IOXI(jArr); -1 < IOXI; IOXI--) {
            if (!predicate.invoke(Long.valueOf(jArr[IOXI])).booleanValue()) {
                return IOOxII0o(jArr, IOXI + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final String o0OXIoI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Character, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) oXxXoox0(cArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static final double[] o0OXXox0(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.X00IxOx(copyOf);
        return copyOf;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double o0OoI(long[] jArr, Oox.oOoXoXO<? super Long, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @XO0OX.xxIXOIIO(name = "averageOfFloat")
    public static final double o0OoX(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (Float f : fArr) {
            d += f.floatValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> o0Oox0xox(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(sArr.length), 16));
        for (short s : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float o0X(double[] dArr, Oox.oOoXoXO<? super Double, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static List<Byte> o0X0(@OXOo.OOXIXo byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = bArr.length;
            if (i >= length) {
                return oIIxOxXOo(bArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Byte.valueOf(bArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Byte.valueOf(bArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character o0XIX(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (kotlin.jvm.internal.IIX0o.oI0IIXIo(c, c2) > 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Integer o0XO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int oOIoXOoI = oOIoXOoI(iArr);
        if (oOIoXOoI == 0) {
            return Integer.valueOf(i);
        }
        R invoke = selector.invoke(Integer.valueOf(i));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
        while (it.hasNext()) {
            int i2 = iArr[it.nextInt()];
            R invoke2 = selector.invoke(Integer.valueOf(i2));
            if (invoke.compareTo(invoke2) < 0) {
                i = i2;
                invoke = invoke2;
            }
        }
        return Integer.valueOf(i);
    }

    public static final short o0XO0o(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = xX0Ox(sArr);
        if (xX0Ox >= 0) {
            short s = sArr[xX0Ox];
            for (int i = xX0Ox - 1; i >= 0; i--) {
                s = operation.invoke(Integer.valueOf(i), Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean o0XOOXxIX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float o0XOXI0x(double[] dArr, Oox.oOoXoXO<? super Double, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final double o0XX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int OIO = OIO(dArr);
        if (OIO >= 0) {
            double d = dArr[OIO];
            for (int i = OIO - 1; i >= 0; i--) {
                d = operation.invoke(Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final List<Byte> o0XX0(@OXOo.OOXIXo byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= bArr.length) {
                return oIIxOxXOo(bArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Byte.valueOf(bArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (byte b : bArr) {
                arrayList.add(Byte.valueOf(b));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Character> o0Xo0XII(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(cArr.length), 16));
        for (char c : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final List<Byte> o0Xo0XX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(I0OOxXXIx(bArr));
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double o0XoxX0(long[] jArr, Oox.oOoXoXO<? super Long, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final float o0XxxOIx(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr[4];
    }

    @xx0o0O.XO
    public static final Character o0o(char[] cArr, Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Integer, R>> o0oI(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            int i2 = iArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Integer.valueOf(i2), other[i]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R o0oI0(char[] cArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> o0oOX(boolean[] zArr, R r, Oox.x0xO0oo<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r);
        for (boolean z : zArr) {
            r = operation.invoke(r, Boolean.valueOf(z));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Double> o0oX0000(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Double> ox0X = ox0X(dArr);
        X0IIOO.oXX0IoI(ox0X);
        return ox0X;
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> T[] o0oXoOoo(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(tArr2);
        return tArr2;
    }

    @OXOo.OOXIXo
    public static final List<Short> o0oXooOxO(@OXOo.OOXIXo short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= sArr.length) {
                return xIIXIOo(sArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Short.valueOf(sArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (short s : sArr) {
                arrayList.add(Short.valueOf(s));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @xx0o0O.XO
    public static final boolean o0oo(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R> List<R> o0ooO(T[] tArr, Oox.x0xO0oo<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double o0oxOOO0x(char[] cArr, Oox.oOoXoXO<? super Character, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final int o0oxo0o0(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length != 0) {
            int i = iArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                if (i < i2) {
                    i = i2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    public static final double o0x0O0o0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Double d = null;
        boolean z = false;
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                if (!z) {
                    d = Double.valueOf(d2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(d, "null cannot be cast to non-null type kotlin.Double");
            return d.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @xx0o0O.XO
    public static final byte o0x0XOXx(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr[0];
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> o0xIXX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(t));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final float[] o0xoIIX(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.xOoIIIoXI(copyOf);
        return copyOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T extends Comparable<? super T>> T o0xoIoI0o(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (t.compareTo(t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    public static final Set<Short> o0xooIIO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) oOX0oo0(sArr, new LinkedHashSet(OI0.xoIox(sArr.length)));
            }
            return oX.XO(Short.valueOf(sArr[0]));
        }
        return Xo0.OOXIXo();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Long oI0Iox(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int IOXI = IOXI(jArr);
        if (IOXI == 0) {
            return Long.valueOf(j);
        }
        R invoke = selector.invoke(Long.valueOf(j));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            R invoke2 = selector.invoke(Long.valueOf(j2));
            if (invoke.compareTo(invoke2) > 0) {
                j = j2;
                invoke = invoke2;
            }
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    public static final List<Double> oI0O(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int OIO = OIO(dArr); -1 < OIO; OIO--) {
            if (!predicate.invoke(Double.valueOf(dArr[OIO])).booleanValue()) {
                return Xo0oxxX0(dArr, OIO + 1);
            }
        }
        return OXIIooO0(dArr);
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Integer>>> M oI0XIox(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final float[] oI0XOxoI(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int oXIX = oXIX(fArr);
        oOXoIIIo it = new X0.oOoXoXO(0, oXIX).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            fArr2[oXIX - nextInt] = fArr[nextInt];
        }
        return fArr2;
    }

    @xx0o0O.XO
    public static final Character oI0XoXIXo(char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        return XOX(cArr, i);
    }

    @OXOo.OOXIXo
    public static final HashSet<Double> oI0oXOOOI(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return (HashSet) IxXXoxI(dArr, new HashSet(OI0.xoIox(dArr.length)));
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C oI0xOX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Character> oI0xOoox(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (char c : cArr) {
            if (z) {
                arrayList.add(Character.valueOf(c));
            } else if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
                z = true;
            }
        }
        return arrayList;
    }

    public static final float oI0xoXO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                float f = fArr[length];
                if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                    return f;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oII(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(dArr.length), 16));
        for (double d : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final X0.oOoXoXO oII00xox(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return new X0.oOoXoXO(0, oXIX(fArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R oIIO(float[] fArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> oIIOI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final double[] oIIOX0OO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            dArr2[i] = dArr[it.next().intValue()];
            i++;
        }
        return dArr2;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double oIIX(char[] cArr, Oox.oOoXoXO<? super Character, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final char[] oIIXI00(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            cArr2[i] = cArr[it.next().intValue()];
            i++;
        }
        return cArr2;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> oIIXxXIox(@OXOo.OOXIXo boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (i >= 0) {
            return XoOIX(zArr, X0.IIXOooo.OxxIIOOXO(zArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Character>> oIIo0xX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c));
        }
        return linkedHashMap;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final <T> T oIIoXX(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (T) XXIx0(tArr, Random.Default);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double oIIxO(char[] cArr, Oox.oOoXoXO<? super Character, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static List<Byte> oIIxOxXOo(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                return Ix0xo(bArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Byte.valueOf(bArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @XO0OX.xxIXOIIO(name = "sumOfFloat")
    public static final float oIIxXxOIx(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        float f = 0.0f;
        for (Float f2 : fArr) {
            f += f2.floatValue();
        }
        return f;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Character>> C oIO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Long oIO0X00(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return Long.valueOf(j);
            }
        }
        return null;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oIO0oIOO(double[] dArr, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            R invoke = selector.invoke(Double.valueOf(dArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oIO0xOOxo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int IoOIIOx = IoOIIOx(cArr); IoOIIOx > 0; IoOIIOx--) {
            int nextInt = random.nextInt(IoOIIOx + 1);
            char c = cArr[IoOIIOx];
            cArr[IoOIIOx] = cArr[nextInt];
            cArr[nextInt] = c;
        }
    }

    public static final boolean oIOI(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final double oIOIO(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[OIO(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.oOoXoXO
    public static final Short oIOXxOI(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    @OXOo.OOXIXo
    public static final <T, A extends Appendable> A oIOoXooIO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.IXxxXO.II0xO0(buffer, t, oooxoxo);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int oIOxx0OO(short[] sArr, Oox.oOoXoXO<? super Short, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (short s : sArr) {
            i += selector.invoke(Short.valueOf(s)).intValue();
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oIX(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            R invoke = selector.invoke(Byte.valueOf(bArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    public static final void oIX0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length > 1) {
            kotlin.collections.ooOOo0oXI.X0(jArr);
            x0IoI0x(jArr);
        }
    }

    @OXOo.OOXIXo
    public static final List<Boolean> oIX0O0OX(@OXOo.OOXIXo boolean[] zArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= zArr.length) {
                return XIX0oOXXO(zArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Boolean.valueOf(zArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (boolean z : zArr) {
                arrayList.add(Boolean.valueOf(z));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> oIXIXIxx0(char[] cArr, Oox.x0xO0oo<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final byte[] oIXO0X0(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.X0x(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final List<Character> oIXXo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int IoOIIOx = IoOIIOx(cArr); -1 < IoOIIOx; IoOIIOx--) {
            if (!predicate.invoke(Character.valueOf(cArr[IoOIIOx])).booleanValue()) {
                return oxO0xI(cArr, IoOIIOx + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float oIXXxO(short[] sArr, Oox.oOoXoXO<? super Short, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double oIXx(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R oIXx0o(T[] tArr, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            R invoke = selector.invoke(tArr[0]);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(tArr[it.nextInt()]);
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    public static final void oIo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Long, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i]));
            i++;
            i2++;
        }
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A oIo0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Long, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (long j : jArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Long.valueOf(j)));
            } else {
                buffer.append(String.valueOf(j));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int oIo0OoXIo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @xx0o0O.XO
    public static final Float oIo0x(float[] fArr, Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                float f = fArr[length];
                if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                    return Float.valueOf(f);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    public static final <T> boolean oIoII0OI(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final Iterable<Short> oIoIXxIO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new I0Io(sArr);
    }

    @OXOo.OOXIXo
    public static byte[] oIoIxO0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new byte[0];
        }
        return kotlin.collections.ooOOo0oXI.xxOXOOoIX(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Double>> M oIoIxo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (double d : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> boolean oIoXOooOO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            int XXoXOI = XXoXOI(zArr);
            if (XXoXOI == 0) {
                return z;
            }
            R invoke = selector.invoke(Boolean.valueOf(z));
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI).iterator();
            while (it.hasNext()) {
                boolean z2 = zArr[it.nextInt()];
                R invoke2 = selector.invoke(Boolean.valueOf(z2));
                if (invoke.compareTo(invoke2) < 0) {
                    z = z2;
                    invoke = invoke2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Float> oIoox0(@OXOo.OOXIXo float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (i >= 0) {
            return IOoXxoI(fArr, X0.IIXOooo.OxxIIOOXO(fArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final <T> boolean oIoxI0xx(@OXOo.OOXIXo T[] tArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final <T> int oIx0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(tArr[i]).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final double oIx0o(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length != 0) {
            double d = dArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                d = operation.invoke(Double.valueOf(d), Double.valueOf(dArr[it.nextInt()])).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int oIxIO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final List<Integer> oIxIOoOx(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (i >= 0) {
            return XoXxXXX(iArr, X0.IIXOooo.OxxIIOOXO(iArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final <T> boolean oIxOXo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.oOoXoXO
    public static final Double oIxOo0Iox(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    @kotlin.OOXIXo(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.XX(expression = "indexOfLast { it == element }", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.6", hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int oIxXOO(float[] fArr, float f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (f == fArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, V> oIxXX0Xo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oIxXXOI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(cArr.length), 16));
        for (char c : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double oIxXxXX0O(byte[] bArr, Oox.oOoXoXO<? super Byte, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    public static final boolean oIxxIo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean oO0(@OXOo.OOXIXo long[] jArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @xx0o0O.XO
    public static final boolean oO000oO(boolean[] zArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.oOoXoXO
    public static final Byte oO0I(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Byte b = null;
        boolean z = false;
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                if (z) {
                    return null;
                }
                b = Byte.valueOf(b2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R oO0IOOOx(double[] dArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oO0Io(float[] fArr, R r, Oox.x0xO0oo<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r);
        for (float f : fArr) {
            r = operation.invoke(r, Float.valueOf(f));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Boolean oO0XoIX(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float oO0XxoI(double[] dArr, Oox.oOoXoXO<? super Double, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final Integer oO0o(int[] iArr, Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                int i2 = iArr[length];
                if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                    return Integer.valueOf(i2);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int oO0x(boolean[] zArr, Oox.oOoXoXO<? super Boolean, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (boolean z : zArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Boolean.valueOf(z)).OO());
        }
        return oOoXoXO2;
    }

    public static final void oO0xxI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (byte b : bArr) {
            action.invoke(Byte.valueOf(b));
        }
    }

    @OXOo.OOXIXo
    public static final List<Boolean> oOI0IXOO(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(oxOXXXoX(zArr));
    }

    @OXOo.OOXIXo
    public static final List<Short> oOI0OXII(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int xX0Ox = xX0Ox(sArr); -1 < xX0Ox; xX0Ox--) {
            if (!predicate.invoke(Short.valueOf(sArr[xX0Ox])).booleanValue()) {
                return ooXXoOx(sArr, xX0Ox + 1);
            }
        }
        return xIIXIOo(sArr);
    }

    @OXOo.OOXIXo
    public static final List<Short> oOI0XOx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.OxxIIOOXO(kotlin.collections.ooOOo0oXI.oXxOI0oIx(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static /* synthetic */ Appendable oOI0ooOO(long[] jArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return oIo0(jArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oOII(float[] fArr, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character oOII0(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (kotlin.jvm.internal.IIX0o.oI0IIXIo(c, c2) < 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character oOIIOXoI(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IoOIIOx = IoOIIOx(cArr);
        if (IoOIIOx < 0) {
            return null;
        }
        char c = cArr[IoOIIOx];
        for (int i = IoOIIOx - 1; i >= 0; i--) {
            c = operation.invoke(Integer.valueOf(i), Character.valueOf(cArr[i]), Character.valueOf(c)).charValue();
        }
        return Character.valueOf(c);
    }

    @OXOo.OOXIXo
    public static <T> Set<T> oOIoOOO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) IxOxxxIOI(tArr, new LinkedHashSet(OI0.xoIox(tArr.length)));
            }
            return oX.XO(tArr[0]);
        }
        return Xo0.OOXIXo();
    }

    public static int oOIoXOoI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr.length - 1;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oOIoXo(boolean[] zArr, Oox.oOoXoXO<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.oOoXoXO
    public static final Double oOIxIIoI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C oOO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = tArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), t).booleanValue()) {
                destination.add(t);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Long> oOO0X(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> oOOIOOxI(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Boolean> xxX0I = xxX0I(zArr);
        X0IIOO.oXX0IoI(xxX0I);
        return xxX0I;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oOOxoo0xx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int XXoXOI = XXoXOI(zArr); XXoXOI > 0; XXoXOI--) {
            int nextInt = random.nextInt(XXoXOI + 1);
            boolean z = zArr[XXoXOI];
            zArr[XXoXOI] = zArr[nextInt];
            zArr[nextInt] = z;
        }
    }

    @OXOo.OOXIXo
    public static final List<Integer> oOX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i : iArr) {
            if (z) {
                arrayList.add(Integer.valueOf(i));
            } else if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
                z = true;
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Short> oOX0oOII(short[] sArr, Oox.x0xO0oo<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        short s = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(s));
        int length = sArr.length;
        for (int i = 1; i < length; i++) {
            s = operation.invoke(Short.valueOf(s), Short.valueOf(sArr[i])).shortValue();
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Short>> C oOX0oo0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (short s : sArr) {
            destination.add(Short.valueOf(s));
        }
        return destination;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int oOXIIOXOx(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (char c : cArr) {
            i += selector.invoke(Character.valueOf(c)).intValue();
        }
        return i;
    }

    @XO0OX.xxIXOIIO(name = "sumOfLong")
    public static final long oOXIx(@OXOo.OOXIXo Long[] lArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lArr, "<this>");
        long j = 0;
        for (Long l : lArr) {
            j += l.longValue();
        }
        return j;
    }

    public static final boolean oOXOX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final Set<Double> oOXOxxoxO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Iterable<Double> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Double> xII0X0OO = xII0X0OO(dArr);
        OxI.oxIIX0o(xII0X0OO, other);
        return xII0X0OO;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float oOXoXXoX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            f = operation.invoke(Float.valueOf(f), Float.valueOf(fArr[it.nextInt()])).floatValue();
        }
        return Float.valueOf(f);
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> oOXoxo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Iterable<? extends T> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<T> IoI0xOIOO = IoI0xOIOO(tArr);
        OxI.XIo0oOXIx(IoI0xOIOO, other);
        return IoI0xOIOO;
    }

    @OXOo.OOXIXo
    public static final Pair<List<Double>, List<Double>> oOXxx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            } else {
                arrayList2.add(Double.valueOf(d));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long oOXxxX0(double[] dArr, Oox.oOoXoXO<? super Double, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (double d : dArr) {
            j += selector.invoke(Double.valueOf(d)).longValue();
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R oOo0XOXO(double[] dArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oOo0o(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(zArr.length), 16));
        for (boolean z : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean oOoIIoxx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            z = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[it.nextInt()])).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short oOoIxI0x(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (s < s2) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedSequenceTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R, C extends Collection<? super R>> C oOx0IIo(T[] tArr, C destination, Oox.x0xO0oo<? super Integer, ? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.Ioxxx(destination, transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oOx0xoXI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s)), valueTransform.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Double oOxIIooO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int OIO = OIO(dArr);
        if (OIO == 0) {
            return Double.valueOf(d);
        }
        R invoke = selector.invoke(Double.valueOf(d));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            R invoke2 = selector.invoke(Double.valueOf(d2));
            if (invoke.compareTo(invoke2) > 0) {
                d = d2;
                invoke = invoke2;
            }
        }
        return Double.valueOf(d);
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> char oOxIxxoo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            char c = cArr[0];
            int IoOIIOx = IoOIIOx(cArr);
            if (IoOIIOx == 0) {
                return c;
            }
            R invoke = selector.invoke(Character.valueOf(c));
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                R invoke2 = selector.invoke(Character.valueOf(c2));
                if (invoke.compareTo(invoke2) > 0) {
                    c = c2;
                    invoke = invoke2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oOxoXxoX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j)), valueTransform.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean oOxx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            boolean z2 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                z = z2;
            }
        }
        return Boolean.valueOf(z);
    }

    public static final void oOxx00x(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int OIO = OIO(dArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            double d = dArr[nextInt];
            dArr[nextInt] = dArr[OIO];
            dArr[OIO] = d;
            OIO--;
        }
    }

    @OXOo.OOXIXo
    public static final int[] oOxxOXXxx(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        I0oIXI(copyOf);
        return copyOf;
    }

    @OXOo.OOXIXo
    public static final Iterable<Integer> oOxxXI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new oxoX(iArr);
    }

    @OXOo.OOXIXo
    public static final List<Byte> oX0IX0o(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Byte[] Oxxo2 = kotlin.collections.ooOOo0oXI.Oxxo(bArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(Oxxo2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(Oxxo2);
    }

    @OXOo.OOXIXo
    public static final Set<Integer> oX0IoO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Iterable<Integer> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Integer> xII0oI = xII0oI(iArr);
        OxI.oxIIX0o(xII0oI, other);
        return xII0oI;
    }

    @OXOo.OOXIXo
    public static final Iterable<Character> oX0O(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new xxIXOIIO(cArr);
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C oX0OXOXOo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (byte b : bArr) {
            destination.add(transform.invoke(Byte.valueOf(b)));
        }
        return destination;
    }

    @xx0o0O.XO
    public static final boolean oX0Ox(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[2];
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oX0XO(long[] jArr, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            R invoke = selector.invoke(Long.valueOf(jArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Set<Short> oX0XXxO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return (Set) oOX0oo0(sArr, new LinkedHashSet(OI0.xoIox(sArr.length)));
    }

    @OXOo.OOXIXo
    public static final List<Boolean> oX0oO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int XXoXOI = XXoXOI(zArr); -1 < XXoXOI; XXoXOI--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[XXoXOI])).booleanValue()) {
                return oIX0O0OX(zArr, XXoXOI + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long oX0oOx(float[] fArr, Oox.oOoXoXO<? super Float, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (float f : fArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Float.valueOf(f)).OO());
        }
        return oOoXoXO2;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oX0ooo(byte[] bArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Byte.valueOf(bArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Float> oX0x(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return xxo0OX0X0(fArr, new Oxx0IOOO.I0Io(selector));
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Long> oXI(long[] jArr, Oox.x0xO0oo<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        long j = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(j));
        int length = jArr.length;
        for (int i = 1; i < length; i++) {
            j = operation.invoke(Long.valueOf(j), Long.valueOf(jArr[i])).longValue();
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long[] oXI0OXIX(long[] jArr, Oox.x0xO0oo<? super Integer, ? super Long, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i]));
            i++;
            i2++;
        }
        return jArr;
    }

    public static final boolean oXI0XX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Character> oXIII(char[] cArr, Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        char c = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c));
        int length = cArr.length;
        int i = 1;
        while (i < length) {
            Character invoke = operation.invoke(Character.valueOf(c), Character.valueOf(cArr[i]));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i++;
            c = charValue;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Integer> oXIOOxX(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (i >= 0) {
            return xX0OOIO(iArr, X0.IIXOooo.OxxIIOOXO(iArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final long oXIOo0Oo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length != 0) {
            long j = jArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                j = operation.invoke(Integer.valueOf(nextInt), Long.valueOf(j), Long.valueOf(jArr[nextInt])).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @xx0o0O.XO
    public static final Integer oXIOxo(int[] iArr, Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    public static final int oXIX(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr.length - 1;
    }

    @xx0o0O.XO
    public static final long oXIo0X0x(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr[2];
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> oXIxoOo(long[] jArr, Oox.x0xO0oo<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R oXIxxoI0x(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int o0IXO = o0IXO(tArr); o0IXO >= 0; o0IXO--) {
            r = operation.invoke(tArr[o0IXO], r);
        }
        return r;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float oXO(double[] dArr, Oox.oOoXoXO<? super Double, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ Appendable oXO0x(short[] sArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return xxxoXXo0X(sArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double oXOIXIO00(int[] iArr, Oox.oOoXoXO<? super Integer, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.oOoXoXO
    public static final Short oXOIxX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            short s = sArr[length];
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return Short.valueOf(s);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @OXOo.OOXIXo
    public static final <T, R, V> List<V> oXOX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(tArr[i], other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Integer> oXOXIxOXo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return II0IoxIxX(iArr, new Oxx0IOOO.I0Io(selector));
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> oXOXXx0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i]), r));
            i++;
        }
        return arrayList;
    }

    public static final int oXOXo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C oXOxO0XXo(char[] cArr, C destination, Oox.x0xO0oo<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final byte oXOxXXX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (bArr.length != 0) {
            return bArr[random.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @xx0o0O.XO
    public static final Character oXOxox(char[] cArr, Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char c = cArr[length];
                if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                    return Character.valueOf(c);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    @xx0o0O.XO
    public static final <T> int oXX0(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr.length;
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> oXX0I0x0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i]), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Float> oXXI0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return CollectionsKt___CollectionsKt.oOo0o(oxOxXO(fArr));
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float oXXI0OO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length != 0) {
            float f = fArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                f = Math.max(f, fArr[it.nextInt()]);
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double oXXO(double[] dArr, Oox.oOoXoXO<? super Double, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <V> List<V> oXXOI00(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo long[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super Long, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i]), Long.valueOf(other[i])));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void oXXOIo(@OXOo.OOXIXo int[] iArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.collections.ooOOo0oXI.o0xOIoxo(iArr, i, i2);
        XIX0XxoIo(iArr, i, i2);
    }

    @OXOo.OOXIXo
    public static final <K> List<Integer> oXXX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (hashSet.add(selector.invoke(Integer.valueOf(i)))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oXXX0I(double[] dArr, R r, Oox.x0xO0oo<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r);
        for (double d : dArr) {
            r = operation.invoke(r, Double.valueOf(d));
            arrayList.add(r);
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long[] oXXX0o(long[] jArr, Oox.oOoXoXO<? super Long, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (long j : jArr) {
            action.invoke(Long.valueOf(j));
        }
        return jArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long oXXxI(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (j < j2) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    @kotlin.OOXIXo(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.XX(expression = "indexOfFirst { it == element }", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.6", hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int oXo(double[] dArr, double d) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (d == dArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> long oXo0I(T[] tArr, Oox.oOoXoXO<? super T, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (T t : tArr) {
            j += selector.invoke(t).longValue();
        }
        return j;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oXoIOX0(@OXOo.OOXIXo double[] dArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.collections.ooOOo0oXI.oXIoIo(dArr, i, i2);
        OOxxo(dArr, i, i2);
    }

    @OXOo.OOXIXo
    public static final Pair<List<Boolean>, List<Boolean>> oXoX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            } else {
                arrayList2.add(Boolean.valueOf(z));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean oXoo0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int XXoXOI = XXoXOI(zArr);
        if (XXoXOI >= 0) {
            boolean z = zArr[XXoXOI];
            for (int i = XXoXOI - 1; i >= 0; i--) {
                z = operation.invoke(Integer.valueOf(i), Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static List<Integer> oXooI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double oXoxo0x(short[] sArr, Oox.oOoXoXO<? super Short, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final List<Pair<Boolean, Boolean>> oXoxox(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo boolean[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Boolean.valueOf(zArr[i]), Boolean.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> oXx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    public static final double oXx00I(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return d;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final List<Short> oXx0XO(@OXOo.OOXIXo short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (i >= 0) {
            return o0oXooOxO(sArr, X0.IIXOooo.OxxIIOOXO(sArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final <T> void oXx0XOX0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), tArr[i]);
            i++;
            i2++;
        }
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Double, R>> oXx0XXOXO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            double d = dArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Double.valueOf(d), other[i]));
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final Boolean oXx0oXXo(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                boolean z = zArr[length];
                if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                    return Boolean.valueOf(z);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C oXx0xxxX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (int i : iArr) {
            destination.add(transform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C oXxOXxo0O(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (boolean z : zArr) {
            destination.add(transform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Long> oXxXOo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int IOXI = IOXI(jArr); -1 < IOXI; IOXI--) {
            if (!predicate.invoke(Long.valueOf(jArr[IOXI])).booleanValue()) {
                return XOOooo(jArr, IOXI + 1);
            }
        }
        return OoxIx(jArr);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double oXxXoO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            d = operation.invoke(Integer.valueOf(nextInt), Double.valueOf(d), Double.valueOf(dArr[nextInt])).doubleValue();
        }
        return Double.valueOf(d);
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A oXxXoox0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Character, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (char c : cArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Character.valueOf(c)));
            } else {
                buffer.append(c);
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean oXxo(@OXOo.OOXIXo boolean[] zArr, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (IxXXI0Xo(zArr, z) >= 0) {
            return true;
        }
        return false;
    }

    public static final int oo0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long oo000(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int IOXI = IOXI(jArr);
        if (IOXI < 0) {
            return null;
        }
        long j = jArr[IOXI];
        for (int i = IOXI - 1; i >= 0; i--) {
            j = operation.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]), Long.valueOf(j)).longValue();
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Byte> oo00Io(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float oo0I(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            f = Math.max(f, fArr[it.nextInt()]);
        }
        return Float.valueOf(f);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oo0I0oI(short[] sArr, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            R invoke = selector.invoke(Short.valueOf(sArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float oo0IoIIOo(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final <R> R oo0o(@OXOo.OOXIXo short[] sArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (short s : sArr) {
            r = operation.invoke(r, Short.valueOf(s));
        }
        return r;
    }

    @xx0o0O.XO
    public static final <T> boolean oo0oIoOIO(T[] tArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.OOXIXo
    public static final HashSet<Integer> oo0x(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return (HashSet) xIXXxOoo(iArr, new HashSet(OI0.xoIox(iArr.length)));
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double oo0xX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (byte b : bArr) {
            d += selector.invoke(Byte.valueOf(b)).doubleValue();
        }
        return d;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> ooI0Xo(long[] jArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r);
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Long.valueOf(jArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double ooIIx(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Long> ooIIxI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return I0O(jArr, new Oxx0IOOO.I0Io(selector));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> ooIXO(char[] cArr, R r, Oox.x0xO0oo<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r);
        for (char c : cArr) {
            r = operation.invoke(r, Character.valueOf(c));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final int ooIoIX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Double.valueOf(dArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> ooIoIx0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(transform.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Byte>>> M ooIx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (byte b : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Long>> ooIxOOoOo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return linkedHashMap;
    }

    public static void ooIxXoX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int xxXIIXIxx = xxXIIXIxx(bArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            byte b = bArr[nextInt];
            bArr[nextInt] = bArr[xxXIIXIxx];
            bArr[xxXIIXIxx] = b;
            xxXIIXIxx--;
        }
    }

    public static final int ooO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = oOIoXOoI(iArr);
        if (oOIoXOoI >= 0) {
            int i = iArr[oOIoXOoI];
            for (int i2 = oOIoXOoI - 1; i2 >= 0; i2--) {
                i = operation.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final Set<Character> ooO0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Iterable<Character> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Character> Xox = Xox(cArr);
        OxI.oxIIX0o(Xox, other);
        return Xox;
    }

    public static long ooO00o(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    public static final double ooO0X(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        for (Double d2 : dArr) {
            d += d2.doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> ooO0xXX(@OXOo.OOXIXo T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (i >= 0) {
            return X0ooIIO(tArr, X0.IIXOooo.OxxIIOOXO(tArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Long>> ooOI(@OXOo.OOXIXo final long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Long>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Long> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.Oxx0IOOO(jArr);
            }
        });
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final double ooOIOOX00(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (short s : sArr) {
            d += selector.invoke(Short.valueOf(s)).doubleValue();
        }
        return d;
    }

    @xx0o0O.XO
    public static final Byte ooOIo(byte[] bArr, Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                byte b = bArr[length];
                if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                    return Byte.valueOf(b);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final List<Double> ooOO0I0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double ooOX(int[] iArr, Oox.oOoXoXO<? super Integer, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final List<Pair<Character, Character>> ooOxOxO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo char[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Character.valueOf(cArr[i]), Character.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Character> ooOxox(@OXOo.OOXIXo char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (i >= 0) {
            return oxO0xI(cArr, X0.IIXOooo.OxxIIOOXO(cArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <R> List<R> ooOxox0O0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int ooOxxO(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (boolean z : zArr) {
            i += selector.invoke(Boolean.valueOf(z)).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> ooX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double ooX0IXxOo(float[] fArr, Oox.oOoXoXO<? super Float, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static /* synthetic */ Appendable ooX0XXOI(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return oIOoXooIO(objArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @OXOo.OOXIXo
    public static final List<Byte> ooX0xXIoI(@OXOo.OOXIXo byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (i >= 0) {
            return o0X0(bArr, X0.IIXOooo.OxxIIOOXO(bArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> ooXO(double[] dArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r);
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Double.valueOf(dArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final int ooXOOxo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Character.valueOf(cArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S ooXXO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int o0IXO = o0IXO(tArr);
        if (o0IXO < 0) {
            return null;
        }
        S s = (S) tArr[o0IXO];
        for (int i = o0IXO - 1; i >= 0; i--) {
            s = operation.invoke(Integer.valueOf(i), (Object) tArr[i], s);
        }
        return s;
    }

    @OXOo.OOXIXo
    public static final List<Short> ooXXoOx(@OXOo.OOXIXo short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (i >= 0) {
            return IoOIxxI(sArr, X0.IIXOooo.OxxIIOOXO(sArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R ooXoIoI(byte[] bArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static List<Byte> ooXxX(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Byte> Ix0xo = Ix0xo(bArr);
        X0IIOO.oXX0IoI(Ix0xo);
        return Ix0xo;
    }

    @xx0o0O.XO
    public static final short ooo(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr[4];
    }

    @xx0o0O.XO
    public static final <T> boolean oooIXI0o(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Float> oooIo0O(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return xxo0OX0X0(fArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Byte>> M oooO0oo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (byte b : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> oooO0ox(int[] iArr, Oox.x0xO0oo<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double oooOOIXX(short[] sArr, Oox.oOoXoXO<? super Short, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R oooOX(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    public static final boolean oooXox0X(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            if (length == 1) {
                return zArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float ooooxox0(char[] cArr, Oox.oOoXoXO<? super Character, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> int ooox(T[] tArr, Oox.oOoXoXO<? super T, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (T t : tArr) {
            i += selector.invoke(t).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M oox(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (float f : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static /* synthetic */ Appendable ooxI0(double[] dArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return XXooo0(dArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A ooxII(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (int i3 : iArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Integer.valueOf(i3)));
            } else {
                buffer.append(String.valueOf(i3));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Long>> C ooxIIII(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (long j : jArr) {
            destination.add(Long.valueOf(j));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Float> ooxIxOXIO(float[] fArr, Oox.x0xO0oo<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        float f = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(f));
        int length = fArr.length;
        for (int i = 1; i < length; i++) {
            f = operation.invoke(Float.valueOf(f), Float.valueOf(fArr[i])).floatValue();
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Double> ooxO0O(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        Double[] OIII0O2 = kotlin.collections.ooOOo0oXI.OIII0O(dArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(OIII0O2);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(OIII0O2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R ooxo0(T[] tArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(tArr[0]);
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(tArr[it.nextInt()]);
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double ooxoIO0I(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Comparator<? super Double> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (dArr.length != 0) {
            double d = dArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                double d2 = dArr[it.nextInt()];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) > 0) {
                    d = d2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Long ooxooo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int IOXI = IOXI(jArr);
        if (IOXI == 0) {
            return Long.valueOf(j);
        }
        R invoke = selector.invoke(Long.valueOf(j));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            R invoke2 = selector.invoke(Long.valueOf(j2));
            if (invoke.compareTo(invoke2) < 0) {
                j = j2;
                invoke = invoke2;
            }
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Boolean>>> M ox0OIxO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return destination;
    }

    public static final <T> T ox0OO0x(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                T t = tArr[length];
                if (predicate.invoke(t).booleanValue()) {
                    return t;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long ox0OOI(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            j = operation.invoke(Long.valueOf(j), Long.valueOf(jArr[it.nextInt()])).longValue();
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    public static final List<Integer> ox0OOx00X(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Double> ox0X(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> ox0o0o0(byte[] bArr, R r, Oox.x0xO0oo<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r);
        for (byte b : bArr) {
            r = operation.invoke(r, Byte.valueOf(b));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final boolean ox0x0Ix(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> ox0xI00IX(@OXOo.OOXIXo T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (i >= 0) {
            return IOXXO0o(tArr, X0.IIXOooo.OxxIIOOXO(tArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final int oxI0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Short.valueOf(sArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R oxI0IX(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (I00O.II0xO0 iI0xO0 : tArr) {
            r = operation.invoke(r, iI0xO0);
        }
        return r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R oxI0OXX(short[] sArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.oOoXoXO
    public static final Boolean oxI0OxXoO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            boolean z = zArr[length];
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Short>> C oxIIOOX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (!predicate.invoke(Short.valueOf(s)).booleanValue()) {
                destination.add(Short.valueOf(s));
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Integer> oxIIoX00o(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.xOxOoo(copyOf);
        return X0xo0oOx(copyOf);
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C oxIO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (boolean z : zArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float oxIX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oXIX = oXIX(fArr);
        if (oXIX < 0) {
            return null;
        }
        float f = fArr[oXIX];
        for (int i = oXIX - 1; i >= 0; i--) {
            f = operation.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
        }
        return Float.valueOf(f);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer oxIXI0oI(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oOIoXOoI = oOIoXOoI(iArr);
        if (oOIoXOoI < 0) {
            return null;
        }
        int i = iArr[oOIoXOoI];
        for (int i2 = oOIoXOoI - 1; i2 >= 0; i2--) {
            i = operation.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(i)).intValue();
        }
        return Integer.valueOf(i);
    }

    @OXOo.oOoXoXO
    public static final <T> T oxIXXxXx0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character oxIo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            c = operation.invoke(Integer.valueOf(nextInt), Character.valueOf(c), Character.valueOf(cArr[nextInt])).charValue();
        }
        return Character.valueOf(c);
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final char oxIox(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (cArr.length != 0) {
            char c = cArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                char c2 = cArr[it.nextInt()];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) > 0) {
                    c = c2;
                }
            }
            return c;
        }
        throw new NoSuchElementException();
    }

    public static final <T> boolean oxO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    public static final Set<Double> oxO00oXoO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Iterable<Double> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Double> xII0X0OO = xII0X0OO(dArr);
        OxI.XIo0oOXIx(xII0X0OO, other);
        return xII0X0OO;
    }

    @OXOo.OOXIXo
    public static final List<Character> oxO0xI(@OXOo.OOXIXo char[] cArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= cArr.length) {
                return oxoIIXo(cArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Character.valueOf(cArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (char c : cArr) {
                arrayList.add(Character.valueOf(c));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oxOII(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d)), valueTransform.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short oxOO0Ix(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            if (s > s2) {
                s = s2;
            }
        }
        return Short.valueOf(s);
    }

    public static final <R> R oxOX0OXx(@OXOo.OOXIXo long[] jArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Long.valueOf(jArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double oxOXX00(byte[] bArr, Oox.oOoXoXO<? super Byte, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final Set<Boolean> oxOXXXoX(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return (Set) x00xO(zArr, new LinkedHashSet(OI0.xoIox(zArr.length)));
    }

    @OXOo.OOXIXo
    public static final List<Float> oxOXxoO0I(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Set<Boolean> oxOo(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) x00xO(zArr, new LinkedHashSet(OI0.xoIox(zArr.length)));
            }
            return oX.XO(Boolean.valueOf(zArr[0]));
        }
        return Xo0.OOXIXo();
    }

    @OXOo.OOXIXo
    public static final <T, R extends Comparable<? super R>> List<T> oxOo0OxX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return Ox00Xx0O(tArr, new Oxx0IOOO.I0Io(selector));
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Float>> C oxOoIOX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                destination.add(Float.valueOf(f));
            }
        }
        return destination;
    }

    public static final void oxOoo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Byte, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i]));
            i++;
            i2++;
        }
    }

    @OXOo.OOXIXo
    public static final Set<Float> oxOxXO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return (Set) xO0II(fArr, new LinkedHashSet(OI0.xoIox(fArr.length)));
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void oxOxxIXX(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        Io0(sArr, Random.Default);
    }

    @OXOo.OOXIXo
    public static final List<Integer> oxX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short oxX00Io(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.nextInt(sArr.length)]);
    }

    @OXOo.OOXIXo
    public static final Set<Integer> oxX0IIoO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Iterable<Integer> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Integer> xII0oI = xII0oI(iArr);
        OxI.XIo0oOXIx(xII0oI, other);
        return xII0oI;
    }

    @xx0o0O.XO
    public static final <T> T oxX0o(T[] tArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (T) IxIOOxO(tArr, i);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int oxXI(int[] iArr, Oox.oOoXoXO<? super Integer, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (int i : iArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(Integer.valueOf(i)).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static <T> kotlin.sequences.ooOOo0oXI<T> oxXIOXO(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new xoIox(tArr);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short[] oxXXoo(short[] sArr, Oox.x0xO0oo<? super Integer, ? super Short, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i]));
            i++;
            i2++;
        }
        return sArr;
    }

    public static final int oxXoxO0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length != 0) {
            int i = iArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                i = operation.invoke(Integer.valueOf(nextInt), Integer.valueOf(i), Integer.valueOf(iArr[nextInt])).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte oxXxX000(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) > 0) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oxo(boolean[] zArr, R r, Oox.x0xO0oo<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r);
        for (boolean z : zArr) {
            r = operation.invoke(r, Boolean.valueOf(z));
            arrayList.add(r);
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> int oxo0O00(T[] tArr, Oox.oOoXoXO<? super T, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        for (T t : tArr) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(t).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static final List<Byte> oxo0x0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> oxo0xxOO(long[] jArr, R r, Oox.x0xO0oo<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r);
        for (long j : jArr) {
            r = operation.invoke(r, Long.valueOf(j));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Character> oxoIIXo(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length != 1) {
                return xxxo0II0O(cArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Character.valueOf(cArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @XO0OX.xxIXOIIO(name = "averageOfShort")
    public static final double oxoIOxO(@OXOo.OOXIXo Short[] shArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(shArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (Short sh : shArr) {
            d += sh.shortValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float oxoXoXxI(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return XIXIxIOoX(fArr, Random.Default);
    }

    public static final void oxoo(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (char c : cArr) {
            action.invoke(Character.valueOf(c));
        }
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S oxooX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S s = (S) tArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            s = operation.invoke(s, (Object) tArr[it.nextInt()]);
        }
        return s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, List<V>>> M oxox0OIx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    public static final void oxoxO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (float f : fArr) {
            action.invoke(Float.valueOf(f));
        }
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C oxoxX0Oxo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedSequence")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R> List<R> oxoxxo(T[] tArr, Oox.x0xO0oo<? super Integer, ? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.Ioxxx(arrayList, transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Short, R>> oxx0x0I0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            short s = sArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Short.valueOf(s), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Byte> oxxI0XIIX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int xxXIIXIxx = xxXIIXIxx(bArr); -1 < xxXIIXIxx; xxXIIXIxx--) {
            if (!predicate.invoke(Byte.valueOf(bArr[xxXIIXIxx])).booleanValue()) {
                return ooX0xXIoI(bArr, xxXIIXIxx + 1);
            }
        }
        return oIIxOxXOo(bArr);
    }

    public static final int oxxX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final X0.oOoXoXO x00(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return new X0.oOoXoXO(0, XXoXOI(zArr));
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float x000IXoX(char[] cArr, Oox.oOoXoXO<? super Character, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static void x000IxIoI(@OXOo.OOXIXo float[] fArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.collections.ooOOo0oXI.oOIx(fArr, i, i2);
        XI0oOxIXx(fArr, i, i2);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> x000OxX(short[] sArr, Oox.x0xO0oo<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final short x000xx(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length != 0) {
            short s = sArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (s > s2) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final Set<Integer> x00O(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) xIXXxOoo(iArr, new LinkedHashSet(OI0.xoIox(iArr.length)));
            }
            return oX.XO(Integer.valueOf(iArr[0]));
        }
        return Xo0.OOXIXo();
    }

    @OXOo.OOXIXo
    public static final List<Character> x00X(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = cArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Double> x00o(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Boolean>> C x00xO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (boolean z : zArr) {
            destination.add(Boolean.valueOf(z));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double x00xXx0o(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length != 0) {
            double doubleValue = dArr[0].doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(dArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, dArr[it.nextInt()].doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Character> x0I(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final float x0I0(float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        return fArr[0];
    }

    public static final <S, T extends S> S x0I00(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length != 0) {
            S s = (S) tArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                s = operation.invoke(s, (Object) tArr[it.nextInt()]);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float x0I0oOo0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            f = Math.min(f, fArr[it.nextInt()]);
        }
        return Float.valueOf(f);
    }

    @OXOo.OOXIXo
    public static final Set<Byte> x0IOX0o(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Iterable<Byte> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Byte> I0OOxXXIx = I0OOxXXIx(bArr);
        OxI.oxIIX0o(I0OOxXXIx, other);
        return I0OOxXXIx;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> float x0IX(T[] tArr, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            float floatValue = selector.invoke(tArr[0]).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(tArr[it.nextInt()]).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Byte> x0Io0(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new OOXIXo(bArr);
    }

    public static void x0IoI0x(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int IOXI = IOXI(jArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            long j = jArr[nextInt];
            jArr[nextInt] = jArr[IOXI];
            jArr[IOXI] = j;
            IOXI--;
        }
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Long>> M x0Ix0O(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (long j : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Long x0O(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                if (z) {
                    return null;
                }
                l = Long.valueOf(j);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return l;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R x0O0O(char[] cArr, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            R invoke = selector.invoke(Character.valueOf(cArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R x0O0X0Xx(short[] sArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @OXOo.OOXIXo
    public static final List<Double> x0O0xO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int OIO = OIO(dArr); -1 < OIO; OIO--) {
            if (!predicate.invoke(Double.valueOf(dArr[OIO])).booleanValue()) {
                return IxoXXxOo(dArr, OIO + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> x0OI(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(bArr.length), 16));
        for (byte b : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final byte x0OIOXo0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                byte b = bArr[length];
                if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                    return b;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C x0OOxoo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (T t : tArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(t));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T x0OX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            T t = tArr[0];
            int o0IXO = o0IXO(tArr);
            if (o0IXO == 0) {
                return t;
            }
            R invoke = selector.invoke(t);
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO).iterator();
            while (it.hasNext()) {
                T t2 = tArr[it.nextInt()];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) < 0) {
                    t = t2;
                    invoke = invoke2;
                }
            }
            return t;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final float[] x0OXo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new float[0];
        }
        return kotlin.collections.ooOOo0oXI.x0(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @OXOo.OOXIXo
    public static final <R> List<R> x0Oo0X(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(transform.invoke(Float.valueOf(f)));
        }
        return arrayList;
    }

    public static final <R> R x0Ox(@OXOo.OOXIXo float[] fArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int oXIX = oXIX(fArr); oXIX >= 0; oXIX--) {
            r = operation.invoke(Integer.valueOf(oXIX), Float.valueOf(fArr[oXIX]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final String x0X(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Float, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) OoIo(fArr, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> x0X0OIOx(float[] fArr, Oox.x0xO0oo<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static X0.oOoXoXO x0XIoX00(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return new X0.oOoXoXO(0, IOXI(jArr));
    }

    @xx0o0O.XO
    public static final byte x0XOOIXXO(byte[] bArr, int i, Oox.oOoXoXO<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= xxXIIXIxx(bArr)) {
            return bArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).byteValue();
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Float>> C x0XOxo(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Float.valueOf(f)).booleanValue()) {
                destination.add(Float.valueOf(f));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Double> x0Xox(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (double d : dArr) {
            if (z) {
                arrayList.add(Double.valueOf(d));
            } else if (!predicate.invoke(Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
                z = true;
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Pair<Float, Float>> x0Xx(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo float[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Float.valueOf(fArr[i]), Float.valueOf(other[i])));
        }
        return arrayList;
    }

    public static final float x0XxIXO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int oXIX = oXIX(fArr);
        if (oXIX >= 0) {
            float f = fArr[oXIX];
            for (int i = oXIX - 1; i >= 0; i--) {
                f = operation.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]), Float.valueOf(f)).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> x0o0(@OXOo.OOXIXo T[] tArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        for (I00O.II0xO0 iI0xO0 : tArr) {
            r = operation.invoke(r, iI0xO0);
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final <T> int x0o0O0Oo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (predicate.invoke(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R x0o0o0OX(short[] sArr, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> x0o0xxxIo(short[] sArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r);
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Short.valueOf(sArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final char x0oO0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length != 0) {
            char c = cArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                c = operation.invoke(Character.valueOf(c), Character.valueOf(cArr[it.nextInt()])).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R x0oOoo0Xo(long[] jArr, Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> short x0oXIXI(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            short s = sArr[0];
            int xX0Ox = xX0Ox(sArr);
            if (xX0Ox == 0) {
                return s;
            }
            R invoke = selector.invoke(Short.valueOf(s));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                R invoke2 = selector.invoke(Short.valueOf(s2));
                if (invoke.compareTo(invoke2) < 0) {
                    s = s2;
                    invoke = invoke2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final char[] x0oXXOO(char[] cArr, Oox.oOoXoXO<? super Character, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (char c : cArr) {
            action.invoke(Character.valueOf(c));
        }
        return cArr;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> x0oo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Long.valueOf(j)));
        }
        return arrayList;
    }

    public static int x0oo0I(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            if (length == 1) {
                return iArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @XO0OX.xxIXOIIO(name = "averageOfLong")
    public static final double x0ooOIxO(@OXOo.OOXIXo Long[] lArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(lArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (Long l : lArr) {
            d += l.longValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte x0ox(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (b > b2) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Long, ? super V>> M x0x(long[] jArr, M destination, Oox.oOoXoXO<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (long j : jArr) {
            destination.put(Long.valueOf(j), valueSelector.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    public static long x0x000(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[IOXI(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean x0xIxx(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> x0xo(long[] jArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r);
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Long.valueOf(jArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Integer>> C x0xoIx0(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int i : iArr) {
            if (!predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                destination.add(Integer.valueOf(i));
            }
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Float x0xoX0II(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Float x0xx(T[] tArr, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(tArr[it.nextInt()]).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final List<Long> x0xxO0xox(@OXOo.OOXIXo long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int length = jArr.length;
            if (i >= length) {
                return OoxIx(jArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Long.valueOf(jArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Long.valueOf(jArr[i2]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void xI0(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        OOIOxI(fArr, Random.Default);
    }

    public static final <R> R xI00o(@OXOo.OOXIXo short[] sArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Short.valueOf(sArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double xI0Io(float[] fArr, Oox.oOoXoXO<? super Float, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (float f : fArr) {
            d += selector.invoke(Float.valueOf(f)).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Float> xI0Ooxx0x(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new oO(fArr);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long xI0XO0Ix(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Comparator<? super Long> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            long j2 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) < 0) {
                j = j2;
            }
        }
        return Long.valueOf(j);
    }

    @OXOo.OOXIXo
    public static final Set<Integer> xI0oXX0Xo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Iterable<Integer> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Integer> xII0oI = xII0oI(iArr);
        OxI.oXIO0o0XI(xII0oI, other);
        return xII0oI;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R xI0xX0xI0(int[] iArr, Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.OOXIXo
    public static final Set<Double> xII0X0OO(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return (Set) IxXXoxI(dArr, new LinkedHashSet(OI0.xoIox(dArr.length)));
    }

    @OXOo.OOXIXo
    public static final Set<Integer> xII0oI(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return (Set) xIXXxOoo(iArr, new LinkedHashSet(OI0.xoIox(iArr.length)));
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapSequence")
    @kotlin.X00IoxXI
    public static final <T, R> List<R> xIIO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            OxI.Ioxxx(arrayList, transform.invoke(t));
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float[] xIIOo(float[] fArr, Oox.oOoXoXO<? super Float, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (float f : fArr) {
            action.invoke(Float.valueOf(f));
        }
        return fArr;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> int xIIOoXo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (iArr.length != 0) {
            int i = iArr[0];
            int oOIoXOoI = oOIoXOoI(iArr);
            if (oOIoXOoI == 0) {
                return i;
            }
            R invoke = selector.invoke(Integer.valueOf(i));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
            while (it.hasNext()) {
                int i2 = iArr[it.nextInt()];
                R invoke2 = selector.invoke(Integer.valueOf(i2));
                if (invoke.compareTo(invoke2) < 0) {
                    i = i2;
                    invoke = invoke2;
                }
            }
            return i;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Short> xIIXIOo(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            if (length != 1) {
                return X0IXXooOI(sArr);
            }
            return kotlin.collections.oI0IIXIo.OOXIXo(Short.valueOf(sArr[0]));
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T[] xIIoI(T[] tArr, Oox.x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), tArr[i]);
            i++;
            i2++;
        }
        return tArr;
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Boolean> xIIoO(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        if (zArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new IXxxXO(zArr);
    }

    public static final long xIIxxO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                if (!z) {
                    l = Long.valueOf(j);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(l, "null cannot be cast to non-null type kotlin.Long");
            return l.longValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @xx0o0O.XO
    public static final int xIO(byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr.length;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xIOI0xO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (int i : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i)), valueTransform.invoke(Integer.valueOf(i)));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Byte, V> xIOOIO(byte[] bArr, Oox.oOoXoXO<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(Byte.valueOf(b), valueSelector.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double xIOOXX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Comparator<? super Double> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) > 0) {
                d = d2;
            }
        }
        return Double.valueOf(d);
    }

    public static final void xIOOoxxxO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i]));
            i++;
            i2++;
        }
    }

    @OXOo.oOoXoXO
    public static final <T> T xIOXI(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long xIOXOx00O(int[] iArr, Oox.oOoXoXO<? super Integer, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (int i : iArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Integer.valueOf(i)).OO());
        }
        return oOoXoXO2;
    }

    public static final <R> R xIOXox(@OXOo.OOXIXo float[] fArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Float.valueOf(fArr[i]));
            i++;
            i2++;
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final HashSet<Short> xIOoIx0X(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return (HashSet) oOX0oo0(sArr, new HashSet(OI0.xoIox(sArr.length)));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T xIX(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return (T) OIx0(tArr, Random.Default);
    }

    public static final boolean xIX0XOOX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return z;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xIXOx(float[] fArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r);
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Float.valueOf(fArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, ? super V>> M xIXXIo(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (T t : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(t);
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final short xIXXooXo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xX0Ox = xX0Ox(sArr);
        if (xX0Ox >= 0) {
            short s = sArr[xX0Ox];
            for (int i = xX0Ox - 1; i >= 0; i--) {
                s = operation.invoke(Short.valueOf(sArr[i]), Short.valueOf(s)).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Integer>> C xIXXxOoo(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (int i : iArr) {
            destination.add(Integer.valueOf(i));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float xIXoXOXx(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length != 0) {
            float floatValue = fArr[0].floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(fArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, fArr[it.nextInt()].floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static void xIXx0(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int xX0Ox = xX0Ox(sArr);
        oOXoIIIo it = new X0.oOoXoXO(0, length).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            short s = sArr[nextInt];
            sArr[nextInt] = sArr[xX0Ox];
            sArr[xX0Ox] = s;
            xX0Ox--;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R xIo(char[] cArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xIo0xoOOx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (short s : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static /* synthetic */ String xIoIxoO(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return x0X(fArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    public static final short xIoXoXx0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length != 0) {
            short s = sArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                s = operation.invoke(Short.valueOf(s), Short.valueOf(sArr[it.nextInt()])).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final Iterable<xI<Boolean>> xIooI0x(@OXOo.OOXIXo final boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends Boolean>>() { // from class: kotlin.collections.ArraysKt___ArraysKt$withIndex$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<? extends Boolean> invoke() {
                return kotlin.jvm.internal.xxIXOIIO.oIX0oI(zArr);
            }
        });
    }

    @OXOo.OOXIXo
    public static final List<Boolean> xIoxOo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean xIoxxXxXo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.nextInt(zArr.length)]);
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final <T> double xIx0OIIo0(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (T t : tArr) {
            d += selector.invoke(t).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Boolean, R>> xIxIII(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Boolean.valueOf(zArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A xIxO0X0I(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Boolean, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (boolean z : zArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Boolean.valueOf(z)));
            } else {
                buffer.append(String.valueOf(z));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final boolean[] xIxXI(boolean[] zArr, Oox.x0xO0oo<? super Integer, ? super Boolean, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i]));
            i++;
            i2++;
        }
        return zArr;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xIxXx0oI0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(transform.invoke(Double.valueOf(d)));
        }
        return arrayList;
    }

    public static final double xIxxXXxx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                double d = dArr[length];
                if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                    return d;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xIxxxX0O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Short.valueOf(s)));
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final Long xO(long[] jArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return Xoo0(jArr, i);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double[] xO00xOOI(double[] dArr, Oox.oOoXoXO<? super Double, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        for (double d : dArr) {
            action.invoke(Double.valueOf(d));
        }
        return dArr;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Float>> C xO0II(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (float f : fArr) {
            destination.add(Float.valueOf(f));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long xO0O0IO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            j = operation.invoke(Integer.valueOf(nextInt), Long.valueOf(j), Long.valueOf(jArr[nextInt])).longValue();
        }
        return Long.valueOf(j);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float xO0OXI(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final short xO0OxX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length != 0) {
            short s = sArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                s = operation.invoke(Integer.valueOf(nextInt), Short.valueOf(s), Short.valueOf(sArr[nextInt])).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final Set<Short> xO0o0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Iterable<Short> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Short> oX0XXxO = oX0XXxO(sArr);
        OxI.XIo0oOXIx(oX0XXxO, other);
        return oX0XXxO;
    }

    public static final <R> R xO0x(@OXOo.OOXIXo char[] cArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (char c : cArr) {
            r = operation.invoke(r, Character.valueOf(c));
        }
        return r;
    }

    @xx0o0O.XO
    public static final short xO0x00ox(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr[2];
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C xO0xx0xxx(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            destination.add(transform.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double xO0xxOX(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (zArr.length != 0) {
            double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, List<V>>> M xOII(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Character> xOII0IIX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final float xOIIO0x(float[] fArr, int i, Oox.oOoXoXO<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= oXIX(fArr)) {
            return fArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).floatValue();
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xOIIOoO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Character.valueOf(c)));
        }
        return arrayList;
    }

    public static boolean xOIO(@OXOo.OOXIXo short[] sArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float xOIXO(byte[] bArr, Oox.oOoXoXO<? super Byte, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Long> xOIXOOx0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return I0O(jArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @OXOo.OOXIXo
    public static long[] xOIXoOX0X(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new long[0];
        }
        return kotlin.collections.ooOOo0oXI.X0xxXX0(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C xOIXxOo(float[] fArr, C destination, Oox.x0xO0oo<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R xOIo(float[] fArr, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            R invoke2 = selector.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.OOXIXo
    public static <T> Iterable<T> xOIx00(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new oIX0oI(tArr);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float xOIxOOI(short[] sArr, Oox.oOoXoXO<? super Short, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> xOO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i]), other[i]));
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Byte xOO0X(@OXOo.OOXIXo byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (i >= 0 && i <= xxXIIXIxx(bArr)) {
            return Byte.valueOf(bArr[i]);
        }
        return null;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double xOOo(short[] sArr, Oox.oOoXoXO<? super Short, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> List<T> xOOx00OI(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return Ox00Xx0O(tArr, xX0ox.Oxx0IOOO.o00());
    }

    @OXOo.OOXIXo
    public static final List<Integer> xOOxIoOoO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Integer.valueOf(i3)).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
            }
            i++;
            i2 = i4;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, ? super Float>> M xOOxX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (float f : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f)), Float.valueOf(f));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K> List<Boolean> xOXI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (hashSet.add(selector.invoke(Boolean.valueOf(z)))) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double xOXOxXoI(short[] sArr, Oox.oOoXoXO<? super Short, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (short s : sArr) {
            d += selector.invoke(Short.valueOf(s)).doubleValue();
        }
        return d;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xOXoOXO0(int[] iArr, R r, Oox.x0xO0oo<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r);
        for (int i : iArr) {
            r = operation.invoke(r, Integer.valueOf(i));
            arrayList.add(r);
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float xOXoooo(long[] jArr, Oox.oOoXoXO<? super Long, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> xOXoxI(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z)), valueTransform.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xOXx(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    public static final boolean xOXxx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                z = operation.invoke(Integer.valueOf(nextInt), Boolean.valueOf(z), Boolean.valueOf(zArr[nextInt])).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static int xOXxx0(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    @xx0o0O.XO
    public static final boolean xOo(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[1];
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final byte xOo0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (bArr.length != 0) {
            byte b = bArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) > 0) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double xOoIIXOxO(double[] dArr, Oox.oOoXoXO<? super Double, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (double d2 : dArr) {
            d += selector.invoke(Double.valueOf(d2)).doubleValue();
        }
        return d;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xOoIXoxO0(char[] cArr, R r, Oox.x0xO0oo<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r);
        for (char c : cArr) {
            r = operation.invoke(r, Character.valueOf(c));
            arrayList.add(r);
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xOoIoIXO0(byte[] bArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Byte.valueOf(bArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C xOoO0O0O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (short s : sArr) {
            destination.add(transform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double xOoOx0o(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            d = Math.min(d, dArr[it.nextInt()]);
        }
        return Double.valueOf(d);
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Integer, R>> xOoXIIooX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Integer.valueOf(iArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Character> xOx0I0X(char[] cArr, Oox.IXxxXO<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        char c = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c));
        int length = cArr.length;
        int i = 1;
        while (i < length) {
            Character invoke = operation.invoke(Integer.valueOf(i), Character.valueOf(c), Character.valueOf(cArr[i]));
            char charValue = invoke.charValue();
            arrayList.add(invoke);
            i++;
            c = charValue;
        }
        return arrayList;
    }

    @OXOo.oOoXoXO
    public static final Integer xOx0oO(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (i >= 0 && i <= oOIoXOoI(iArr)) {
            return Integer.valueOf(iArr[i]);
        }
        return null;
    }

    public static final byte xOxIIO(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Byte b = null;
        boolean z = false;
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                if (!z) {
                    b = Byte.valueOf(b2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(b, "null cannot be cast to non-null type kotlin.Byte");
            return b.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> short xOxIoIXXO(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length != 0) {
            short s = sArr[0];
            int xX0Ox = xX0Ox(sArr);
            if (xX0Ox == 0) {
                return s;
            }
            R invoke = selector.invoke(Short.valueOf(s));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                R invoke2 = selector.invoke(Short.valueOf(s2));
                if (invoke.compareTo(invoke2) > 0) {
                    s = s2;
                    invoke = invoke2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ String xOxIxO(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return IOxoXoI(jArr, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xOxXOOIx(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(transform.invoke(Integer.valueOf(i)));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte xOxXxx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            byte b2 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) < 0) {
                b = b2;
            }
        }
        return Byte.valueOf(b);
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Short, R>> xOxoXoX0O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Short.valueOf(sArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final int xOxxIxxI0(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr.length;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Long>> C xOxxO(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                destination.add(Long.valueOf(j));
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> xX0(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double xX0O(long[] jArr, Oox.oOoXoXO<? super Long, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI(jArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Integer> xX0OOIO(@OXOo.OOXIXo int[] iArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= iArr.length) {
                return XXX0(iArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Integer.valueOf(iArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (int i3 : iArr) {
                arrayList.add(Integer.valueOf(i3));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, List<Double>> xX0Oo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d));
        }
        return linkedHashMap;
    }

    public static int xX0Ox(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr.length - 1;
    }

    public static final char xX0XIooxO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(c);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(ch, "null cannot be cast to non-null type kotlin.Char");
            return ch.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final double xX0XOXI(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        for (double d2 : dArr) {
            d += d2;
        }
        return d;
    }

    public static final void xX0Xo(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length > 1) {
            kotlin.collections.ooOOo0oXI.IOXOxOII(sArr);
            xIXx0(sArr);
        }
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float xX0ooIII(char[] cArr, Oox.oOoXoXO<? super Character, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (cArr.length != 0) {
            float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static final int xX0x(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                if (!z) {
                    num = Integer.valueOf(i);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(num, "null cannot be cast to non-null type kotlin.Int");
            return num.intValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <R, V> List<V> xX0x0I(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xX0xI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int o0IXO = o0IXO(tArr); -1 < o0IXO; o0IXO--) {
            if (!predicate.invoke(tArr[o0IXO]).booleanValue()) {
                return X0ooIIO(tArr, o0IXO + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Double xX0xXooOO(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int OIO = OIO(dArr);
        if (OIO == 0) {
            return Double.valueOf(d);
        }
        R invoke = selector.invoke(Double.valueOf(d));
        oOXoIIIo it = new X0.oOoXoXO(1, OIO).iterator();
        while (it.hasNext()) {
            double d2 = dArr[it.nextInt()];
            R invoke2 = selector.invoke(Double.valueOf(d2));
            if (invoke.compareTo(invoke2) < 0) {
                d = d2;
                invoke = invoke2;
            }
        }
        return Double.valueOf(d);
    }

    @OXOo.OOXIXo
    public static final List<Byte> xXI0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return kotlin.collections.ooOOo0oXI.x0XOIxOo(kotlin.collections.ooOOo0oXI.xxOXOOoIX(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long xXI0oOx(boolean[] zArr, Oox.oOoXoXO<? super Boolean, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long j = 0;
        for (boolean z : zArr) {
            j += selector.invoke(Boolean.valueOf(z)).longValue();
        }
        return j;
    }

    @OXOo.OOXIXo
    public static final List<Byte> xXIO(@OXOo.OOXIXo byte[] bArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (i >= 0) {
            return o0XX0(bArr, X0.IIXOooo.OxxIIOOXO(bArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.oOoXoXO
    public static final Short xXIOOXOX(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final List<Short> xXIxIO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        Short[] oIX0o2 = kotlin.collections.ooOOo0oXI.oIX0o(sArr);
        kotlin.collections.ooOOo0oXI.XoOOx0IX(oIX0o2);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(oIX0o2);
    }

    @xx0o0O.XO
    public static final long xXIxxo0x(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr[1];
    }

    public static final float xXO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[oXIX(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> xXO0oXX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(jArr.length), 16));
        for (long j : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final char[] xXOIXxOx0(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.IIX0o.oO(copyOf, "copyOf(...)");
        kotlin.collections.ooOOo0oXI.Oox(copyOf);
        return copyOf;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void xXOIo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int OIO = OIO(dArr); OIO > 0; OIO--) {
            int nextInt = random.nextInt(OIO + 1);
            double d = dArr[OIO];
            dArr[OIO] = dArr[nextInt];
            dArr[nextInt] = d;
        }
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V, M extends Map<? super Short, ? super V>> M xXOO(short[] sArr, M destination, Oox.oOoXoXO<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (short s : sArr) {
            destination.put(Short.valueOf(s), valueSelector.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte xXOOI0O(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = xxXIIXIxx(bArr);
        if (xxXIIXIxx < 0) {
            return null;
        }
        byte b = bArr[xxXIIXIxx];
        for (int i = xxXIIXIxx - 1; i >= 0; i--) {
            b = operation.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
        }
        return Byte.valueOf(b);
    }

    public static final <T, R extends Comparable<? super R>> void xXOOII0XI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.ooOOo0oXI.IOOXOOOOo(tArr, new Oxx0IOOO.I0Io(selector));
        }
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R> List<R> xXOOx(byte[] bArr, Oox.x0xO0oo<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Pair<List<Byte>, List<Byte>> xXOXIII(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b : bArr) {
            if (predicate.invoke(Byte.valueOf(b)).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            } else {
                arrayList2.add(Byte.valueOf(b));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @OXOo.oOoXoXO
    public static final Float xXOXOOx(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i = length - 1;
            float f = fArr[length];
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return Float.valueOf(f);
            }
            if (i >= 0) {
                length = i;
            } else {
                return null;
            }
        }
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C xXOoI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            R invoke = transform.invoke(Integer.valueOf(i2), tArr[i]);
            if (invoke != null) {
                destination.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> xXOxII0xx(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), tArr[i]));
            i++;
            i2++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Float, R>> xXOxoX(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            float f = fArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Float.valueOf(f), other[i]));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Integer> xXX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return II0IoxIxX(iArr, new Oxx0IOOO.oIX0oI(selector));
    }

    public static final float xXXI0IX00(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long xXXIX(byte[] bArr, Oox.oOoXoXO<? super Byte, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (byte b : bArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Byte.valueOf(b)).OO());
        }
        return oOoXoXO2;
    }

    @xx0o0O.XO
    public static final double xXXXox(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return dArr[0];
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C xXXXxOOI0(double[] dArr, C destination, Oox.x0xO0oo<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R xXXo(double[] dArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    public static boolean xXXxoI(@OXOo.OOXIXo int[] iArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T extends Comparable<? super T>> T xXo0X0(@OXOo.OOXIXo T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (t.compareTo(t2) < 0) {
                t = t2;
            }
        }
        return t;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer xXoIXXXX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI(iArr)).iterator();
        while (it.hasNext()) {
            i = operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[it.nextInt()])).intValue();
        }
        return Integer.valueOf(i);
    }

    @OXOo.OOXIXo
    public static final List<Float> xXoIo00O(@OXOo.OOXIXo float[] fArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (i >= fArr.length) {
                return X00OO00x(fArr);
            }
            if (i == 1) {
                return kotlin.collections.oI0IIXIo.OOXIXo(Float.valueOf(fArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (float f : fArr) {
                arrayList.add(Float.valueOf(f));
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @xx0o0O.XO
    public static final double xXoIx00(double[] dArr, int i, Oox.oOoXoXO<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= OIO(dArr)) {
            return dArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).doubleValue();
    }

    public static final int xXoOoxXIX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (predicate.invoke(Boolean.valueOf(zArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ Appendable xXooxOx0O(char[] cArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return oXxXoox0(cArr, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int[] xXx(int[] iArr, Oox.x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]));
            i++;
            i2++;
        }
        return iArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float xXx0IX0(@OXOo.OOXIXo Float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(fArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, fArr[it.nextInt()].floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xXx0x0(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (long j : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j)), valueTransform.invoke(Long.valueOf(j)));
        }
        return destination;
    }

    @xx0o0O.XO
    public static final int xXxIoIXX0(int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        return iArr[1];
    }

    @xx0o0O.XO
    public static final byte xXxIxo(byte[] bArr, int i, Oox.oOoXoXO<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= xxXIIXIxx(bArr)) {
            return bArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).byteValue();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte xXxXXXo(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = xxXIIXIxx(bArr);
        if (xxXIIXIxx < 0) {
            return null;
        }
        byte b = bArr[xxXIIXIxx];
        for (int i = xxXIIXIxx - 1; i >= 0; i--) {
            b = operation.invoke(Integer.valueOf(i), Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
        }
        return Byte.valueOf(b);
    }

    @OXOo.OOXIXo
    public static final <T> T[] xXxo0xooI(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Collection<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        T[] tArr2 = (T[]) kotlin.collections.OOXIXo.oIX0oI(tArr, indices.size());
        Iterator<Integer> it = indices.iterator();
        int i = 0;
        while (it.hasNext()) {
            tArr2[i] = tArr[it.next().intValue()];
            i++;
        }
        return tArr2;
    }

    public static final boolean xXxoOIX(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (predicate.invoke(Character.valueOf(c)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final int xXxox(@OXOo.OOXIXo boolean[] zArr, boolean z) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (z == zArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @xx0o0O.XO
    public static final long xXxx(long[] jArr, int i, Oox.oOoXoXO<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= IOXI(jArr)) {
            return jArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).longValue();
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Byte>> C xXxxOxI0I(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (byte b : bArr) {
            destination.add(Byte.valueOf(b));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Byte xo0(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            b = operation.invoke(Integer.valueOf(nextInt), Byte.valueOf(b), Byte.valueOf(bArr[nextInt])).byteValue();
        }
        return Byte.valueOf(b);
    }

    public static final <R> R xo000(@OXOo.OOXIXo byte[] bArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (byte b : bArr) {
            r = operation.invoke(r, Byte.valueOf(b));
        }
        return r;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character xo00oox(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) < 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Byte> xo0I(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return oX0IX0o(bArr, new Oxx0IOOO.I0Io(selector));
    }

    @xx0o0O.XO
    public static final Double xo0Io0Ooo(double[] dArr, Oox.oOoXoXO<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (double d : dArr) {
            if (predicate.invoke(Double.valueOf(d)).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    public static final void xo0OI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Double, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            action.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i]));
            i++;
            i2++;
        }
    }

    @OXOo.OOXIXo
    public static final List<Float> xo0XO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (int oXIX = oXIX(fArr); -1 < oXIX; oXIX--) {
            if (!predicate.invoke(Float.valueOf(fArr[oXIX])).booleanValue()) {
                return xXoIo00O(fArr, oXIX + 1);
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @xx0o0O.XO
    public static final boolean xo0Xo0xo(short[] sArr) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Character>> C xo0oXIOO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = cArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Character.valueOf(c)).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
            i++;
            i2 = i3;
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final Integer xo0xII0II(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    @xx0o0O.XO
    public static final long xoI(long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        return jArr[4];
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xoIIIOI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (double d : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d)), valueTransform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final void xoIIoXXx(@OXOo.OOXIXo short[] sArr, int i, int i2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.collections.ooOOo0oXI.oXxOXOX(sArr, i, i2);
        Xo0x0I(sArr, i, i2);
    }

    @OXOo.OOXIXo
    public static final double[] xoIIxo0(@OXOo.OOXIXo Double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i = 0; i < length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Boolean xoIOoX(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int XXoXOI = XXoXOI(zArr);
        if (XXoXOI < 0) {
            return null;
        }
        boolean z = zArr[XXoXOI];
        for (int i = XXoXOI - 1; i >= 0; i--) {
            z = operation.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @OXOo.OOXIXo
    public static final Set<Long> xoIoo(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Iterable<Long> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<Long> IO0X = IO0X(jArr);
        OxI.oXIO0o0XI(IO0X, other);
        return IO0X;
    }

    public static final short xoIooI0(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (short s : sArr) {
            if (predicate.invoke(Short.valueOf(s)).booleanValue()) {
                return s;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final long xoIxI0X0(boolean[] zArr, Oox.oOoXoXO<? super Boolean, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        for (boolean z : zArr) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(Boolean.valueOf(z)).OO());
        }
        return oOoXoXO2;
    }

    public static final double xoO0(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (long j : jArr) {
            d += j;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static final <T> T xoO0X(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <V> Map<Long, V> xoOI00O0X(long[] jArr, Oox.oOoXoXO<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(Long.valueOf(j), valueSelector.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static short[] xoOIOOXxO(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int xX0Ox = xX0Ox(sArr);
        oOXoIIIo it = new X0.oOoXoXO(0, xX0Ox).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            sArr2[xX0Ox - nextInt] = sArr[nextInt];
        }
        return sArr2;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final byte xoOOIooI(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        if (bArr.length != 0) {
            byte b = bArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                byte b2 = bArr[it.nextInt()];
                if (b < b2) {
                    b = b2;
                }
            }
            return b;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T xoOX(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (comparator.compare(t, t2) > 0) {
                t = t2;
            }
        }
        return t;
    }

    @xx0o0O.XO
    public static final int xoOX00(short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        return sArr.length;
    }

    @xx0o0O.XO
    public static final boolean xoOXXoO0X(boolean[] zArr, int i, Oox.oOoXoXO<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= XXoXOI(zArr)) {
            return zArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).booleanValue();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float xoOo0O0x(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Comparator<? super Float> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            float f2 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) > 0) {
                f = f2;
            }
        }
        return Float.valueOf(f);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final float xoOoI(byte[] bArr, Oox.oOoXoXO<? super Byte, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (bArr.length != 0) {
            float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx(bArr)).iterator();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float xoOoOI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            f = operation.invoke(Integer.valueOf(nextInt), Float.valueOf(f), Float.valueOf(fArr[nextInt])).floatValue();
        }
        return Float.valueOf(f);
    }

    public static final double xoOx(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (byte b : bArr) {
            d += b;
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    public static final List<Long> xoOxO(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        List<Long> OII0x = OII0x(jArr);
        X0IIOO.oXX0IoI(OII0x);
        return OII0x;
    }

    public static int xoOxO0(@OXOo.OOXIXo short[] sArr, short s) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (s == sArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double xoX0XI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int OIO = OIO(dArr);
        if (OIO < 0) {
            return null;
        }
        double d = dArr[OIO];
        for (int i = OIO - 1; i >= 0; i--) {
            d = operation.invoke(Double.valueOf(dArr[i]), Double.valueOf(d)).doubleValue();
        }
        return Double.valueOf(d);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <R extends Comparable<? super R>> Short xoXI00O(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int xX0Ox = xX0Ox(sArr);
        if (xX0Ox == 0) {
            return Short.valueOf(s);
        }
        R invoke = selector.invoke(Short.valueOf(s));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
        while (it.hasNext()) {
            short s2 = sArr[it.nextInt()];
            R invoke2 = selector.invoke(Short.valueOf(s2));
            if (invoke.compareTo(invoke2) < 0) {
                s = s2;
                invoke = invoke2;
            }
        }
        return Short.valueOf(s);
    }

    @OXOo.OOXIXo
    public static int[] xoXI0X(@OXOo.OOXIXo Integer[] numArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    @OXOo.OOXIXo
    public static final <V> List<V> xoXXII0O(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo boolean[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super Boolean, ? super Boolean, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(other[i])));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final List<Integer> xoXXXIX(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (predicate.invoke(Integer.valueOf(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public static final <T> T xoXoIXox(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (predicate.invoke(t2).booleanValue()) {
                if (!z) {
                    t = t2;
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <R extends Comparable<? super R>> List<Short> xoXx(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return IXoIOXoo(sArr, new Oxx0IOOO.oIX0oI(selector));
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final short xooX(@OXOo.OOXIXo short[] sArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (sArr.length != 0) {
            short s = sArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
            while (it.hasNext()) {
                short s2 = sArr[it.nextInt()];
                if (s < s2) {
                    s = s2;
                }
            }
            return s;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xooXo(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (short s : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s)), valueTransform.invoke(Short.valueOf(s)));
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> double xooo0(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            double d = dArr[0];
            int OIO = OIO(dArr);
            if (OIO == 0) {
                return d;
            }
            R invoke = selector.invoke(Double.valueOf(d));
            oOXoIIIo it = new X0.oOoXoXO(1, OIO).iterator();
            while (it.hasNext()) {
                double d2 = dArr[it.nextInt()];
                R invoke2 = selector.invoke(Double.valueOf(d2));
                if (invoke.compareTo(invoke2) > 0) {
                    d = d2;
                    invoke = invoke2;
                }
            }
            return d;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> xoooOIO(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <R, C extends Collection<? super R>> C xooxxo(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        for (double d : dArr) {
            OxI.XIo0oOXIx(destination, transform.invoke(Double.valueOf(d)));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final List<Long> xoxIXox(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!predicate.invoke(Long.valueOf(j)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final Set<Long> xoxO(@OXOo.OOXIXo long[] jArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            if (length != 1) {
                return (Set) ooxIIII(jArr, new LinkedHashSet(OI0.xoIox(jArr.length)));
            }
            return oX.XO(Long.valueOf(jArr[0]));
        }
        return Xo0.OOXIXo();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final double xoxOOxI(double[] dArr, Oox.oOoXoXO<? super Double, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length != 0) {
            double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xoxX(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(Byte.valueOf(b)));
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final short xoxX0I(short[] sArr, int i, Oox.oOoXoXO<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= xX0Ox(sArr)) {
            return sArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).shortValue();
    }

    public static boolean xoxXoXO(@OXOo.OOXIXo char[] cArr, char c) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        if (OOIX(cArr, c) >= 0) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.XX(expression = "indexOfFirst { it == element }", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.6", hiddenSince = "1.7", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ int xoxoXoxIo(float[] fArr, float f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (f == fArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final byte xoxx(@OXOo.OOXIXo byte[] bArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xxXIIXIxx = xxXIIXIxx(bArr);
        if (xxXIIXIxx >= 0) {
            byte b = bArr[xxXIIXIxx];
            for (int i = xxXIIXIxx - 1; i >= 0; i--) {
                b = operation.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(b)).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> double xx00(T[] tArr, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length != 0) {
            double doubleValue = selector.invoke(tArr[0]).doubleValue();
            oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(tArr[it.nextInt()]).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final int xx00OX(int[] iArr, int i, Oox.oOoXoXO<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= oOIoXOoI(iArr)) {
            return iArr[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).intValue();
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xx0IXxxx0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i])));
            i++;
            i2++;
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final List<Double> xx0Io(double[] dArr, Oox.IXxxXO<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        double d = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(d));
        int length = dArr.length;
        for (int i = 1; i < length; i++) {
            d = operation.invoke(Integer.valueOf(i), Double.valueOf(d), Double.valueOf(dArr[i])).doubleValue();
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static final boolean xx0O(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <K> List<Double> xx0XoXxI(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (hashSet.add(selector.invoke(Double.valueOf(d)))) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Float xx0oII(T[] tArr, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, o0IXO(tArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(tArr[it.nextInt()]).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static int[] xxI(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return new int[0];
        }
        return kotlin.collections.ooOOo0oXI.X0xII0I(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Float xxI0O(float[] fArr, Oox.oOoXoXO<? super Float, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Double xxI0XIO(double[] dArr, Oox.oOoXoXO<? super Double, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        oOXoIIIo it = new X0.oOoXoXO(1, OIO(dArr)).iterator();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static final int xxI0x(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (float f : fArr) {
            if (predicate.invoke(Float.valueOf(f)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xxIIOXXX(int[] iArr, R r, Oox.x0xO0oo<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r);
        for (int i : iArr) {
            r = operation.invoke(r, Integer.valueOf(i));
            arrayList.add(r);
        }
        return arrayList;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final double xxIOIoOI0(double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        return OIIX0ooox(dArr, Random.Default);
    }

    @OXOo.oOoXoXO
    public static final Short xxIOx(@OXOo.OOXIXo short[] sArr, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        if (i >= 0 && i <= xX0Ox(sArr)) {
            return Short.valueOf(sArr[i]);
        }
        return null;
    }

    @xx0o0O.XO
    public static final <T> T xxIOxXI(T[] tArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        return tArr[0];
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, List<V>> xxIXxx0o(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Long, R>> xxIx0xX(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(other, 10), length));
        int i = 0;
        for (R r : other) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(Long.valueOf(jArr[i]), r));
            i++;
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final boolean xxO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (zArr.length != 0) {
            boolean z = zArr[0];
            oOXoIIIo it = new X0.oOoXoXO(1, XXoXOI(zArr)).iterator();
            while (it.hasNext()) {
                boolean z2 = zArr[it.nextInt()];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                    z = z2;
                }
            }
            return z;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> long xxO0xo00(@OXOo.OOXIXo long[] jArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (jArr.length != 0) {
            long j = jArr[0];
            int IOXI = IOXI(jArr);
            if (IOXI == 0) {
                return j;
            }
            R invoke = selector.invoke(Long.valueOf(j));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
            while (it.hasNext()) {
                long j2 = jArr[it.nextInt()];
                R invoke2 = selector.invoke(Long.valueOf(j2));
                if (invoke.compareTo(invoke2) > 0) {
                    j = j2;
                    invoke = invoke2;
                }
            }
            return j;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Boolean>> C xxOOXo(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <R extends Comparable<? super R>> float xxOXIO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            float f = fArr[0];
            int oXIX = oXIX(fArr);
            if (oXIX == 0) {
                return f;
            }
            R invoke = selector.invoke(Float.valueOf(f));
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX).iterator();
            while (it.hasNext()) {
                float f2 = fArr[it.nextInt()];
                R invoke2 = selector.invoke(Float.valueOf(f2));
                if (invoke.compareTo(invoke2) > 0) {
                    f = f2;
                    invoke = invoke2;
                }
            }
            return f;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final kotlin.sequences.ooOOo0oXI<Double> xxOoXO(@OXOo.OOXIXo double[] dArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        if (dArr.length == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new x0xO0oo(dArr);
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final int xxOx(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Double, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (double d : dArr) {
            i += selector.invoke(Double.valueOf(d)).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final List<Boolean> xxX0I(@OXOo.OOXIXo boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xxX0X(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (boolean z : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z)), valueTransform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final <R> R xxX0oIX0I(@OXOo.OOXIXo long[] jArr, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int IOXI = IOXI(jArr); IOXI >= 0; IOXI--) {
            r = operation.invoke(Long.valueOf(jArr[IOXI]), r);
        }
        return r;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <R, C extends Collection<? super R>> C xxXI(byte[] bArr, C destination, Oox.x0xO0oo<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i])));
            i++;
            i2++;
        }
        return destination;
    }

    public static int xxXIIXIxx(@OXOo.OOXIXo byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        return bArr.length - 1;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character xxXIO0OO(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo Comparator<? super Character> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, IoOIIOx(cArr)).iterator();
        while (it.hasNext()) {
            char c2 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) > 0) {
                c = c2;
            }
        }
        return Character.valueOf(c);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> List<R> xxXIXxxOx(double[] dArr, R r, Oox.IXxxXO<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r);
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            r = operation.invoke(Integer.valueOf(i), r, Double.valueOf(dArr[i]));
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super Character>> C xxXX0(@OXOo.OOXIXo char[] cArr, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (char c : cArr) {
            if (!predicate.invoke(Character.valueOf(c)).booleanValue()) {
                destination.add(Character.valueOf(c));
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xxXXO(@OXOo.OOXIXo T[] tArr, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(tArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <K> Map<K, Float> xxXooOI(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f)), Float.valueOf(f));
        }
        return linkedHashMap;
    }

    @xx0o0O.XO
    public static final boolean xxXxI(boolean[] zArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        return zArr[4];
    }

    @OXOo.OOXIXo
    public static final <R> List<Pair<Boolean, R>> xxXxOO(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            boolean z = zArr[i];
            arrayList.add(kotlin.Xo0.oIX0oI(Boolean.valueOf(z), other[i]));
        }
        return arrayList;
    }

    public static final int xxo00(@OXOo.OOXIXo int[] iArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final List<Float> xxo0OX0X0(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo Comparator<? super Float> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Float[] Xxx0oXX2 = kotlin.collections.ooOOo0oXI.Xxx0oXX(fArr);
        kotlin.collections.ooOOo0oXI.IOOXOOOOo(Xxx0oXX2, comparator);
        return kotlin.collections.ooOOo0oXI.oI0IIXIo(Xxx0oXX2);
    }

    @xx0o0O.XO
    public static final Long xxo0o(long[] jArr, Oox.oOoXoXO<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(jArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (long j : jArr) {
            if (predicate.invoke(Long.valueOf(j)).booleanValue()) {
                return Long.valueOf(j);
            }
        }
        return null;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final double xxo0x0(byte[] bArr, Oox.oOoXoXO<? super Byte, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        double d = XIXIX.OOXIXo.f3760XO;
        for (byte b : bArr) {
            d += selector.invoke(Byte.valueOf(b)).doubleValue();
        }
        return d;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Short xxoX(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            s = operation.invoke(Short.valueOf(s), Short.valueOf(sArr[it.nextInt()])).shortValue();
        }
        return Short.valueOf(s);
    }

    @OXOo.OOXIXo
    public static final Iterable<Float> xxoXO(@OXOo.OOXIXo float[] fArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return new XO(fArr);
    }

    @OXOo.OOXIXo
    public static final List<Pair<Double, Double>> xxoXoIX(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo double[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(kotlin.Xo0.oIX0oI(Double.valueOf(dArr[i]), Double.valueOf(other[i])));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final int xxoo0XO(float[] fArr, Oox.oOoXoXO<? super Float, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int i = 0;
        for (float f : fArr) {
            i += selector.invoke(Float.valueOf(f)).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <K, M extends Map<? super K, List<Float>>> M xxooOxoO(@OXOo.OOXIXo float[] fArr, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (float f : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R xxooXo(float[] fArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[it.nextInt()]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    public static final <R> R xxox(@OXOo.OOXIXo byte[] bArr, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        for (int xxXIIXIxx = xxXIIXIxx(bArr); xxXIIXIxx >= 0; xxXIIXIxx--) {
            r = operation.invoke(Integer.valueOf(xxXIIXIxx), Byte.valueOf(bArr[xxXIIXIxx]), r);
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final List<Double> xxoxO0O(@OXOo.OOXIXo double[] dArr, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(dArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            double d = dArr[i];
            int i3 = i2 + 1;
            if (predicate.invoke(Integer.valueOf(i2), Double.valueOf(d)).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R> R xxoxx0(short[] sArr, Comparator<? super R> comparator, Oox.oOoXoXO<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox(sArr)).iterator();
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    public static final boolean xxx(@OXOo.OOXIXo boolean[] zArr, @OXOo.OOXIXo Oox.oOoXoXO<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.oOoXoXO
    public static final Integer xxxIO(@OXOo.OOXIXo int[] iArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <R extends Comparable<? super R>> R xxxO(float[] fArr, Oox.oOoXoXO<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(fArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (fArr.length != 0) {
            R invoke = selector.invoke(Float.valueOf(fArr[0]));
            oOXoIIIo it = new X0.oOoXoXO(1, oXIX(fArr)).iterator();
            while (it.hasNext()) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[it.nextInt()]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final List<Character> xxxo0II0O(@OXOo.OOXIXo char[] cArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c : cArr) {
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <A extends Appendable> A xxxoXXo0X(@OXOo.OOXIXo short[] sArr, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super Short, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(sArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (short s : sArr) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (oooxoxo != null) {
                buffer.append(oooxoxo.invoke(Short.valueOf(s)));
            } else {
                buffer.append(String.valueOf((int) s));
            }
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @XO0OX.xxIXOIIO(name = "averageOfByte")
    public static final double xxxxxo(@OXOo.OOXIXo Byte[] bArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bArr, "<this>");
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        for (Byte b : bArr) {
            d += b.byteValue();
            i++;
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }
}
