package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.exoplayer2.C;
import java.util.Map;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleNotificationSettings2 extends BleWritable {

    @OOXIXo
    public static final String AMAZON = "com.amazon.mobile.shopping";

    @OOXIXo
    public static final String BAND = "bandapp";

    @OOXIXo
    public static final String BETWEEN = "between";

    @OOXIXo
    public static final String CALL = "tel";

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String Daangn_Market = "Daangn_Market";

    @OOXIXo
    public static final String Daum_Cafe = "Daum_Cafe";

    @OOXIXo
    public static final String Discord = "discord";

    @OOXIXo
    public static final String EMAIL = "mailto";

    @OOXIXo
    public static final String FACEBOOK_MESSENGER = "fbauth2";

    @OOXIXo
    public static final String GMAIL = "googlegmail";

    @OOXIXo
    public static final String GOOGLE_MAPS = "GOOGLE_MAPS";

    @OOXIXo
    public static final String IMO = "IMO";

    @OOXIXo
    public static final String INSTAGRAM = "instagram";
    public static final int ITEM_LENGTH = 8;

    @OOXIXo
    public static final String KAKAO_TALK = "kakaolink";

    @OOXIXo
    public static final String Kiwoom_Securities = "Kiwoom_Securities";

    @OOXIXo
    public static final String LINE = "line";

    @OOXIXo
    public static final String LINKED_IN = "linkedin";

    @OOXIXo
    public static final String LYFT = "co.uk.weinstant.instant";

    @OOXIXo
    public static final String MIRROR_PHONE = "mirror_phone";

    @OOXIXo
    public static final String NAVERCAFE = "navercafe";

    @OOXIXo
    public static final String NAVER_APP = "NAVER_APP";

    @OOXIXo
    public static final String NETFLIX = "nflx";

    @OOXIXo
    public static final String Nate_On = "Nate_On";

    @OOXIXo
    public static final String Naver_Band = "Naver_Band";

    @OOXIXo
    public static final String Naver_Cafe = "Naver_Cafe";

    @OOXIXo
    public static final String Pinterest = "Pinterest";

    @OOXIXo
    public static final String QQ = "mqq";

    @OOXIXo
    public static final String SINA_WEIBO = "sinaweibo";

    @OOXIXo
    public static final String SKYPE = "skype";

    @OOXIXo
    public static final String SLACK = "SLACK";

    @OOXIXo
    public static final String SMS = "sms";

    @OOXIXo
    public static final String SNAPCHAT = "snapchat";

    @OOXIXo
    public static final String Signal = "Signal";

    @OOXIXo
    public static final String TELEGRAM = "telegram";

    @OOXIXo
    public static final String TWITTER = "twitter";

    @OOXIXo
    public static final String TikTok_KOR = "TikTok_KOR";

    @OOXIXo
    public static final String Tik_Tok = "awemesso";

    @OOXIXo
    public static final String TumBlr = "TumBlr";

    @OOXIXo
    public static final String UBER = "uberx";

    @OOXIXo
    public static final String VKontakte = "VKontakte";

    @OOXIXo
    public static final String WE_CHAT = "wechat";

    @OOXIXo
    public static final String WHATS_APP = "whatsapp";

    @OOXIXo
    public static final String YOUTUBE = "youtube";

    @OOXIXo
    public static final String Zalo = "Zalo";

    @OOXIXo
    private final Map<String, Integer> BIT_MASKS;
    private long mNotificationBits;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleNotificationSettings2() {
        Object obj = "tel";
        Map<String, Integer> XX2 = o0.XX(Xo0.oIX0oI("mirror_phone", 1), Xo0.oIX0oI("tel", 2), Xo0.oIX0oI("sms", 4), Xo0.oIX0oI("mailto", 8), Xo0.oIX0oI("skype", 16), Xo0.oIX0oI("fbauth2", 32), Xo0.oIX0oI("whatsapp", 64), Xo0.oIX0oI("line", 128), Xo0.oIX0oI("instagram", 256), Xo0.oIX0oI("kakaolink", 512), Xo0.oIX0oI("googlegmail", 1024), Xo0.oIX0oI("twitter", 2048), Xo0.oIX0oI("linkedin", 4096), Xo0.oIX0oI("sinaweibo", 8192), Xo0.oIX0oI("mqq", 16384), Xo0.oIX0oI("wechat", 32768), Xo0.oIX0oI("bandapp", 65536), Xo0.oIX0oI("telegram", 131072), Xo0.oIX0oI("between", 262144), Xo0.oIX0oI("navercafe", 524288), Xo0.oIX0oI("youtube", 1048576), Xo0.oIX0oI("nflx", 2097152), Xo0.oIX0oI(Tik_Tok, 4194304), Xo0.oIX0oI(SNAPCHAT, 8388608), Xo0.oIX0oI(AMAZON, 16777216), Xo0.oIX0oI(UBER, 33554432), Xo0.oIX0oI(LYFT, 67108864), Xo0.oIX0oI(GOOGLE_MAPS, Integer.valueOf(C.BUFFER_FLAG_FIRST_SAMPLE)), Xo0.oIX0oI(SLACK, 268435456), Xo0.oIX0oI(Discord, 536870912), Xo0.oIX0oI(TumBlr, 1073741824), Xo0.oIX0oI(Pinterest, Integer.MIN_VALUE), Xo0.oIX0oI(Zalo, 1), Xo0.oIX0oI(IMO, 2), Xo0.oIX0oI(VKontakte, 4), Xo0.oIX0oI(TikTok_KOR, 8), Xo0.oIX0oI(Naver_Band, 16), Xo0.oIX0oI(NAVER_APP, 32), Xo0.oIX0oI(Naver_Cafe, 64), Xo0.oIX0oI(Signal, 128), Xo0.oIX0oI(Nate_On, 256), Xo0.oIX0oI(Daangn_Market, 512), Xo0.oIX0oI(Kiwoom_Securities, 1024), Xo0.oIX0oI(Daum_Cafe, 2048));
        this.BIT_MASKS = XX2;
        for (String str : XX2.keySet()) {
            Object obj2 = obj;
            if (!IIX0o.Oxx0IOOO(str, obj2)) {
                enable(str);
            }
            obj = obj2;
        }
    }

    @Override // com.bestmafen.baseble.data.BleReadable
    public void decode() {
        super.decode();
        this.mNotificationBits = BleReadable.readInt64$default(this, null, 1, null);
    }

    public final void disable(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        if (this.BIT_MASKS.get(id) != null) {
            this.mNotificationBits &= ~r5.intValue();
        }
    }

    public final void enable(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        if (this.BIT_MASKS.get(id) != null) {
            this.mNotificationBits |= r5.intValue();
        }
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeLong$default(this, this.mNotificationBits, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 8;
    }

    public final long getMNotificationBits() {
        return this.mNotificationBits;
    }

    public final boolean isEnabled(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        if (this.BIT_MASKS.get(id) == null) {
            return false;
        }
        if ((this.mNotificationBits & r6.intValue()) <= 0) {
            return false;
        }
        return true;
    }

    public final void setMNotificationBits(long j) {
        this.mNotificationBits = j;
    }

    @OOXIXo
    public String toString() {
        return "BleNotificationSettings2(mNotificationBits=" + Long.toBinaryString(this.mNotificationBits) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void toggle(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        if (this.BIT_MASKS.get(id) != null) {
            this.mNotificationBits ^= r5.intValue();
        }
    }
}
