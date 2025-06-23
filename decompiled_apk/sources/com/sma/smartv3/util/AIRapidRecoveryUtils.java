package com.sma.smartv3.util;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.util.AIRapidRecoveryUtils;
import com.szabh.smable3.component.BleCache;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public final class AIRapidRecoveryUtils {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final boolean f24193I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AIRapidRecoveryUtils f24195oIX0oI = new AIRapidRecoveryUtils();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final kotlin.X0IIOO f24194II0xO0 = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<List<oIX0oI>>() { // from class: com.sma.smartv3.util.AIRapidRecoveryUtils$mAIRapidRecoveryList$2
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final List<AIRapidRecoveryUtils.oIX0oI> invoke() {
            return new ArrayList();
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f24196I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f24197II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public int f24198X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public boolean f24199XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f24200oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f24201oxoX;

        public oIX0oI() {
            this(null, null, null, null, 0, false, 63, null);
        }

        public static /* synthetic */ oIX0oI II0XooXoX(oIX0oI oix0oi, String str, String str2, String str3, String str4, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = oix0oi.f24200oIX0oI;
            }
            if ((i2 & 2) != 0) {
                str2 = oix0oi.f24197II0xO0;
            }
            String str5 = str2;
            if ((i2 & 4) != 0) {
                str3 = oix0oi.f24196I0Io;
            }
            String str6 = str3;
            if ((i2 & 8) != 0) {
                str4 = oix0oi.f24201oxoX;
            }
            String str7 = str4;
            if ((i2 & 16) != 0) {
                i = oix0oi.f24198X0o0xo;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                z = oix0oi.f24199XO;
            }
            return oix0oi.Oxx0IOOO(str, str5, str6, str7, i3, z);
        }

        @OXOo.OOXIXo
        public final String I0Io() {
            return this.f24196I0Io;
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f24197II0xO0;
        }

        public final void IXxxXO(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f24200oIX0oI = str;
        }

        @OXOo.OOXIXo
        public final String OOXIXo() {
            return this.f24201oxoX;
        }

        public final void Oo(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f24201oxoX = str;
        }

        @OXOo.OOXIXo
        public final oIX0oI Oxx0IOOO(@OXOo.OOXIXo String mQuestion, @OXOo.OOXIXo String mAnswer, @OXOo.OOXIXo String mKeyWords1, @OXOo.OOXIXo String mKeyWords2, int i, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(mQuestion, "mQuestion");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mAnswer, "mAnswer");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mKeyWords1, "mKeyWords1");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mKeyWords2, "mKeyWords2");
            return new oIX0oI(mQuestion, mAnswer, mKeyWords1, mKeyWords2, i, z);
        }

        public final void Oxx0xo(boolean z) {
            this.f24199XO = z;
        }

        public final int X0o0xo() {
            return this.f24198X0o0xo;
        }

        public final boolean XO() {
            return this.f24199XO;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24200oIX0oI, oix0oi.f24200oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24197II0xO0, oix0oi.f24197II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24196I0Io, oix0oi.f24196I0Io) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f24201oxoX, oix0oi.f24201oxoX) && this.f24198X0o0xo == oix0oi.f24198X0o0xo && this.f24199XO == oix0oi.f24199XO;
        }

        public int hashCode() {
            return (((((((((this.f24200oIX0oI.hashCode() * 31) + this.f24197II0xO0.hashCode()) * 31) + this.f24196I0Io.hashCode()) * 31) + this.f24201oxoX.hashCode()) * 31) + this.f24198X0o0xo) * 31) + androidx.work.oIX0oI.oIX0oI(this.f24199XO);
        }

        public final void oI0IIXIo(int i) {
            this.f24198X0o0xo = i;
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            return this.f24200oIX0oI;
        }

        public final void oO(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f24197II0xO0 = str;
        }

        @OXOo.OOXIXo
        public final String oOoXoXO() {
            return this.f24200oIX0oI;
        }

        public final int ooOOo0oXI() {
            return this.f24198X0o0xo;
        }

        @OXOo.OOXIXo
        public final String oxoX() {
            return this.f24201oxoX;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "RapidRecoveryBean(mQuestion=" + this.f24200oIX0oI + ", mAnswer=" + this.f24197II0xO0 + ", mKeyWords1=" + this.f24196I0Io + ", mKeyWords2=" + this.f24201oxoX + ", type=" + this.f24198X0o0xo + ", isPlayResult=" + this.f24199XO + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final boolean x0XOIxOo() {
            return this.f24199XO;
        }

        public final void x0xO0oo(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f24196I0Io = str;
        }

        @OXOo.OOXIXo
        public final String xoIox() {
            return this.f24196I0Io;
        }

        @OXOo.OOXIXo
        public final String xxIXOIIO() {
            return this.f24197II0xO0;
        }

        public oIX0oI(@OXOo.OOXIXo String mQuestion, @OXOo.OOXIXo String mAnswer, @OXOo.OOXIXo String mKeyWords1, @OXOo.OOXIXo String mKeyWords2, int i, boolean z) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(mQuestion, "mQuestion");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mAnswer, "mAnswer");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mKeyWords1, "mKeyWords1");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mKeyWords2, "mKeyWords2");
            this.f24200oIX0oI = mQuestion;
            this.f24197II0xO0 = mAnswer;
            this.f24196I0Io = mKeyWords1;
            this.f24201oxoX = mKeyWords2;
            this.f24198X0o0xo = i;
            this.f24199XO = z;
        }

        public /* synthetic */ oIX0oI(String str, String str2, String str3, String str4, int i, boolean z, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) == 0 ? str4 : "", (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? true : z);
        }
    }

    static {
        BleCache bleCache = BleCache.INSTANCE;
        String mBleName = bleCache.getMBleName();
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(mBleName, "S23")) {
            kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AC05W_C032_S09");
        } else if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(mBleName, "P13")) {
            kotlin.jvm.internal.IIX0o.Oxx0IOOO(bleCache.getMFirmwareFlag(), "AC05W_C034_P13");
        }
        f24193I0Io = false;
    }

    @OXOo.OOXIXo
    public final List<oIX0oI> I0Io() {
        kotlin.jvm.internal.IIXOooo iIXOooo = null;
        boolean z = false;
        oIX0oI().add(new oIX0oI("全网粉丝量最多的女主播是谁？", "全网粉丝最多的女主播是杨润心（网名：蛋蛋）。截止2024年9月19日8时21分，杨润心于快手平台的粉丝数量超过1.0亿个，经世界纪录认证(WRCA)官方审核，她成功创造“粉丝数量最多的电商女主播(单一平台)”世界纪录，成为全网粉丝数量最多的女主播。", "粉丝量", "女主播", 0, z, 48, iIXOooo));
        int i = 32;
        int i2 = 1;
        oIX0oI().add(new oIX0oI("快手平台带货一姐是谁？", "快手平台带货一姐是蛋蛋。蛋蛋，原名杨润心（也有说法为杨润欣），1997年出生于吉林长春，是快手平台上极具影响力的头部主播，也是辛巴辛有志的徒弟。2024年9月19日，蛋蛋的粉丝数正式突破1亿，成为全网首位粉丝破亿的女主播，其带货实力在快手平台上得到了广泛认可。", "快手", "一姐", i2, z, i, iIXOooo));
        oIX0oI().add(new oIX0oI("评价一下辛有志辛总？", "辛有志（辛巴）是一位极具影响力和实力的直播带货领域商业巨匠，辛巴在直播带货领域取得了显著的成绩。他创立的辛选集团年销售额高达数百亿，个人单场直播销售额也屡创新高，如单场直播销售额高达60亿，众多单品销售额破10亿1。这充分展示了他在销售领域的非凡才华和出色的商业头脑。他的直播带货风格独特，能够吸引大量观众，为消费者带来品质好、价格优惠的产品，赢得了众多粉丝的喜爱和支持。", "评价", "辛有志", i2, z, i, iIXOooo));
        String str = null;
        int i3 = 0;
        oIX0oI().add(new oIX0oI("咖啡不加糖用英语怎么说？", "“咖啡不加糖”用英语可以表达为：\"Coffee without sugar\" 或者 \"Black coffee\"（如果指的是不加糖也不加奶的纯黑咖啡）。", "咖啡不加糖", str, i3, z, 56, iIXOooo));
        oIX0oI().add(new oIX0oI("例如帮我写一篇关于春天的英语作文？", "The Arrival of Spring\nSpring, the season of renewal and rebirth, has always held a special place in my heart. After the long, cold winter months, the arrival of spring brings with it a sense of warmth and hope that seems to permeate the air.\nThe first signs of spring are subtle but unmistakable. The snow begins to melt, revealing patches of green grass that have been hidden beneath a blanket of white. The trees start to bud, their branches adorned with tiny, delicate leaves that are a fresh, vibrant green. And then, of course, there are the flowers. They bloom in a riot of colors, filling the gardens and parks with their sweet, intoxicating fragrance.\nOne of my favorite things about spring is the weather. The days become longer and the sun shines more brightly, filling me with a sense of energy and optimism. It's the perfect time to get outside and enjoy the beauty of nature. I love to go for walks in the park, feeling the soft breeze on my face and listening to the birds singing their cheerful songs.\nSpring is also a time for new beginnings. It's a chance to start fresh, to set new goals and make new plans. The energy of the season seems to inspire me to be more productive and creative. I find myself wanting to learn new things, to try new activities, and to explore the world ar", "英语作文", str, i3, z, 24, iIXOooo));
        int i4 = 56;
        oIX0oI().add(new oIX0oI("把他翻译成中文", "春天：万物复苏的季节\n春天，是一个赋予世界生机的季节，它用缤纷色彩描绘大地，让世间洋溢着万象更新之感。\n随着冬日的寒意渐渐消散，大地从沉睡中苏醒。曾经枯黄、蛰伏的草地，重焕生机，如茵的绿草为大地铺上了一层葱郁的地毯。那些曾光秃秃、仿若枯骨的树木，如今萌生出娇柔的新芽，不久后便舒展开来，长成嫩叶，在微风中沙沙作响。五彩斑斓的花朵竞相绽放，争奇斗艳。雏菊如散落的繁星点缀着草地，郁金香则整齐排列，昂首挺立，花瓣呈现出红、黄、紫等绚烂色彩。\n春天的天气令人愉悦。严寒与狂风已然远去，温暖的阳光倾洒大地，人们纷纷褪去厚重的冬衣，欣然投身户外。轻柔的微风拂过脸庞，携带着花朵的芬芳。此时，白昼似乎无尽延长，处处洋溢着冒险的希望。\n春天不仅自然风光迷人，也是充满活力的时节。人们走出家门，渴望沐浴阳光、享受清新空气。公园里野餐的场景随处可见，家人和朋友聚在方格毛毯上，欢声笑语，共享美食。孩子们放飞风筝，眼睛紧盯着在空中舞动的彩色风筝，清脆的笑声在空气中回荡。园丁们忙碌起来，播下种子，悉心照料幼苗，期待着未来几个月的丰收。\n春天，大自然的交响乐奏响。候鸟从越冬之地归来，婉转的鸣叫声充斥着天空。它们筑巢、产卵、抚育幼雏，忙碌的身影彰显着这个季节的生机盎然。蜜蜂和蝴蝶在花丛中穿梭飞舞，嗡嗡声为热闹的氛围增添一份活力。积雪融化，溪水潺潺流下，为新生的喧嚣营造出舒缓的背景音。\n春天，是充满希望与蜕变的季节。它提醒我们，无论日子多么黑暗寒冷，光明与温暖总会在不远处等候。它激励我们如同大地一般，摆脱旧貌，迎接新机遇。它让我们心中充满喜悦，脑海中满是梦想，无疑是一年中最为神奇美妙的时光。", "翻译成中文", str, i3, z, i4, iIXOooo));
        oIX0oI().add(new oIX0oI("小炒黄牛肉怎么做？", "小炒黄牛肉的制作步骤如下：\n\u3000·\u3000准备食材：需要500g黄牛肉（薄片）、青尖椒、红尖椒、小米椒、姜、蒜、葱、香菜等蔬菜，以及料酒、生抽、老抽、蚝油、淀粉、小苏打、盐、鸡精、食用油等调料。\n\u3000·\u3000腌制牛肉：将切好的牛肉片放入碗中，加入适量的料酒、生抽、淀粉、小苏打等调料，抓匀后腌制15-30分钟，以便让牛肉更加入味且嫩滑。\n\u3000·\u3000炒制牛肉：热锅放油，待油热后，放入腌制好的黄牛肉，快速翻炒至变色后盛出备用。这一步是为了锁住牛肉的鲜嫩和汁水。\n\u3000·\u3000炒制配料：再次热锅倒油，放入切好的姜、蒜、辣椒等配料爆香，炒出浓郁的香辣味。\n\u3000·\u3000合炒调味：将炒好的牛肉重新倒回锅中，加入适量的生抽、老抽调色调味，同时放入剩余的蔬菜翻炒均匀。根据个人口味加入适量的盐和鸡精进行调味。\n\u3000·\u3000出锅装盘：待所有食材翻炒均匀且入味后，即可关火出锅装盘享用。", "小炒黄牛肉", str, i3, z, i4, iIXOooo));
        int i5 = 32;
        int i6 = 1;
        oIX0oI().add(new oIX0oI("杭州有哪些美食", "杭州拥有众多美食，包括但不限于西湖醋鱼、龙井虾仁、东坡肉、知味观的小笼包、叫化童鸡皮、片儿川面、葱包桧等。这些美食各具特色，是杭州饮食文化的重要组成部分。", "杭州", "美食", i6, z, i5, iIXOooo));
        oIX0oI().add(new oIX0oI("杭州有哪些好玩的地方", "杭州拥有许多值得游玩的地方，如西湖风景名胜区、灵隐寺、宋城景区、西溪国家湿地公园、千岛湖风景区等。这些地方不仅风景优美，还蕴含着丰富的历史文化底蕴，是游客们不可错过的旅游胜地。", "杭州", "好玩", i6, z, i5, iIXOooo));
        return oIX0oI();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[LOOP:0: B:7:0x0021->B:22:?, LOOP_END, SYNTHETIC] */
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.sma.smartv3.util.AIRapidRecoveryUtils.oIX0oI II0xO0(@OXOo.OOXIXo java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "question"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            boolean r0 = com.sma.smartv3.util.AIRapidRecoveryUtils.f24193I0Io
            r1 = 0
            if (r0 == 0) goto L7a
            java.util.List r0 = r8.oIX0oI()
            int r0 = r0.size()
            if (r0 != 0) goto L17
            r8.I0Io()
        L17:
            java.util.List r0 = r8.oIX0oI()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L78
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.sma.smartv3.util.AIRapidRecoveryUtils$oIX0oI r3 = (com.sma.smartv3.util.AIRapidRecoveryUtils.oIX0oI) r3
            int r4 = r3.ooOOo0oXI()
            r5 = 1
            r6 = 2
            r7 = 0
            if (r4 != r5) goto L4e
            java.lang.String r4 = r3.xoIox()
            boolean r4 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r9, r4, r7, r6, r1)
            if (r4 == 0) goto L4c
            java.lang.String r3 = r3.OOXIXo()
            boolean r3 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r9, r3, r7, r6, r1)
            if (r3 == 0) goto L4c
            goto L75
        L4c:
            r5 = 0
            goto L75
        L4e:
            java.lang.String r4 = r3.OOXIXo()
            int r4 = r4.length()
            if (r4 <= 0) goto L6d
            java.lang.String r4 = r3.xoIox()
            boolean r4 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r9, r4, r7, r6, r1)
            if (r4 != 0) goto L75
            java.lang.String r3 = r3.OOXIXo()
            boolean r3 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r9, r3, r7, r6, r1)
            if (r3 == 0) goto L4c
            goto L75
        L6d:
            java.lang.String r3 = r3.xoIox()
            boolean r5 = kotlin.text.StringsKt__StringsKt.o00xOoIO(r9, r3, r7, r6, r1)
        L75:
            if (r5 == 0) goto L21
            r1 = r2
        L78:
            com.sma.smartv3.util.AIRapidRecoveryUtils$oIX0oI r1 = (com.sma.smartv3.util.AIRapidRecoveryUtils.oIX0oI) r1
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.util.AIRapidRecoveryUtils.II0xO0(java.lang.String):com.sma.smartv3.util.AIRapidRecoveryUtils$oIX0oI");
    }

    @OXOo.OOXIXo
    public final List<oIX0oI> oIX0oI() {
        return (List) f24194II0xO0.getValue();
    }

    public final boolean oxoX() {
        return f24193I0Io;
    }
}
