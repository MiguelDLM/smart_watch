package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import com.bestmafen.baseble.data.BleReadable;
import com.bestmafen.baseble.data.BleWritable;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Map;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes13.dex */
public final class BleNotificationSettings extends BleWritable {

    @OOXIXo
    public static final String BAND = "bandapp";

    @OOXIXo
    public static final String BETWEEN = "between";

    @OOXIXo
    public static final String CALL = "tel";

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String EMAIL = "mailto";

    @OOXIXo
    public static final String FACEBOOK_MESSENGER = "fbauth2";

    @OOXIXo
    public static final String GMAIL = "googlegmail";

    @OOXIXo
    public static final String INSTAGRAM = "instagram";
    public static final int ITEM_LENGTH = 4;

    @OOXIXo
    public static final String KAKAO_TALK = "kakaolink";

    @OOXIXo
    public static final String LINE = "line";

    @OOXIXo
    public static final String LINKED_IN = "linkedin";

    @OOXIXo
    public static final String MIRROR_PHONE = "mirror_phone";

    @OOXIXo
    public static final String NAVERCAFE = "navercafe";

    @OOXIXo
    public static final String NETFLIX = "nflx";

    @OOXIXo
    public static final String QQ = "mqq";

    @OOXIXo
    public static final String SINA_WEIBO = "sinaweibo";

    @OOXIXo
    public static final String SKYPE = "skype";

    @OOXIXo
    public static final String SMS = "sms";

    @OOXIXo
    public static final String TELEGRAM = "telegram";

    @OOXIXo
    public static final String TWITTER = "twitter";

    @OOXIXo
    public static final String WE_CHAT = "wechat";

    @OOXIXo
    public static final String WHATS_APP = "whatsapp";

    @OOXIXo
    public static final String YOUTUBE = "youtube";

    @OOXIXo
    private final Map<String, Integer> BIT_MASKS;
    private int mNotificationBits;

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    public BleNotificationSettings() {
        Object obj = "tel";
        Map<String, Integer> XX2 = o0.XX(Xo0.oIX0oI("mirror_phone", 1), Xo0.oIX0oI("tel", 2), Xo0.oIX0oI("sms", 4), Xo0.oIX0oI("mailto", 8), Xo0.oIX0oI("skype", 16), Xo0.oIX0oI("fbauth2", 32), Xo0.oIX0oI("whatsapp", 64), Xo0.oIX0oI("line", 128), Xo0.oIX0oI("instagram", 256), Xo0.oIX0oI("kakaolink", 512), Xo0.oIX0oI("googlegmail", 1024), Xo0.oIX0oI("twitter", 2048), Xo0.oIX0oI("linkedin", 4096), Xo0.oIX0oI("sinaweibo", 8192), Xo0.oIX0oI("mqq", 16384), Xo0.oIX0oI("wechat", 32768), Xo0.oIX0oI("bandapp", 65536), Xo0.oIX0oI("telegram", 131072), Xo0.oIX0oI("between", 262144), Xo0.oIX0oI("navercafe", 524288), Xo0.oIX0oI("youtube", 1048576), Xo0.oIX0oI("nflx", 2097152));
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
        this.mNotificationBits = BleReadable.readInt32$default(this, null, 1, null);
    }

    public final void disable(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        Integer num = this.BIT_MASKS.get(id);
        if (num != null) {
            int intValue = num.intValue();
            this.mNotificationBits = (~intValue) & this.mNotificationBits;
        }
    }

    public final void enable(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        Integer num = this.BIT_MASKS.get(id);
        if (num != null) {
            this.mNotificationBits = num.intValue() | this.mNotificationBits;
        }
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        BleWritable.writeInt32$default(this, this.mNotificationBits, null, 2, null);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        return 4;
    }

    public final int getMNotificationBits() {
        return this.mNotificationBits;
    }

    public final boolean isEnabled(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        Integer num = this.BIT_MASKS.get(id);
        if (num == null || (num.intValue() & this.mNotificationBits) <= 0) {
            return false;
        }
        return true;
    }

    public final void setMNotificationBits(int i) {
        this.mNotificationBits = i;
    }

    @OOXIXo
    public String toString() {
        return "BleNotificationSettings(mNotificationBits=" + Integer.toBinaryString(this.mNotificationBits) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void toggle(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        Integer num = this.BIT_MASKS.get(id);
        if (num != null) {
            this.mNotificationBits = num.intValue() ^ this.mNotificationBits;
        }
    }
}
