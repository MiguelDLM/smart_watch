package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.collection.oIX0oI;
import com.bestmafen.baseble.data.BleWritable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.oxoX;

/* loaded from: classes13.dex */
public final class BleNotification extends BleWritable {

    @OOXIXo
    public static final String ALIBABA_RIMET = "com.alibaba.android.rimet";

    @OOXIXo
    public static final String ANDROID_EMAIL = "com.android.email";

    @OOXIXo
    public static final String ANDROID_INCALLUI = "com.android.incallui";

    @OOXIXo
    public static final String ANDROID_MMS = "com.android.mms";

    @OOXIXo
    public static final String ANDROID_MMS_SERVICE = "com.android.mms.service";

    @OOXIXo
    public static final String ANDROID_TELECOM = "com.android.server.telecom";

    @OOXIXo
    public static final String BAND = "com.nhn.android.band";

    @OOXIXo
    public static final String BETWEEN = "kr.co.vcnc.android.couple";

    @OOXIXo
    public static final String CAFE = "net.daum.android.cafe";
    public static final int CATEGORY_INCOMING_CALL = 1;
    public static final int CATEGORY_MESSAGE = 127;
    public static final int CONTENT_MAX_LENGTH = 250;

    @OOXIXo
    public static final String DISCORD = "com.discord";

    @OOXIXo
    public static final String FACEBOOK = "com.facebook.katana";

    @OOXIXo
    public static final String FACEBOOK_LITE = "com.facebook.lite";

    @OOXIXo
    public static final String FACEBOOK_MESSENGER = "com.facebook.orca";

    @OOXIXo
    public static final String FACEBOOK_MESSENGER_LITE = "com.facebook.mlite";

    @OOXIXo
    public static final String GIF_MAKER = "com.smile.gifmaker";

    @OOXIXo
    public static final String GOOGLE_CHROME = "com.android.chrome";

    @OOXIXo
    public static final String GOOGLE_DUO = "com.google.android.apps.tachyon";

    @OOXIXo
    public static final String GOOGLE_MMS = "com.google.android.apps.messaging";

    @OOXIXo
    public static final String GOOGLE_TELECOM = "com.google.android.dialer";

    @OOXIXo
    public static final String HEROMTS = "com.kiwoom.heromts";

    @OOXIXo
    public static final String HUAWEI_SYSTEM_MANAGER = "com.huawei.systemmanager";

    @OOXIXo
    public static final String INSTAGRAM = "com.instagram.android";

    @OOXIXo
    public static final String KAKAO_TALK = "com.kakao.talk";

    @OOXIXo
    public static final String LINE = "jp.naver.line.android";

    @OOXIXo
    public static final String LINKED_IN = "com.linkedin.android";

    @OOXIXo
    public static final String MEITUAN = "com.sankuai.meituan";

    @OOXIXo
    public static final String MEITUAN_TAKEOUTNEW = "com.sankuai.meituan.takeoutnew";

    @OOXIXo
    public static final String NAVERCAFE = "com.nhn.android.navercafe";

    @OOXIXo
    public static final String NETFLIX = "com.netflix.mediaclient";

    @OOXIXo
    public static final String ONE_PLUS_MMS = "com.oneplus.mms";

    @OOXIXo
    public static final String ONE_PLUS_TELECOM = "com.oneplus.dialer";
    public static final int PACKAGE_LENGTH = 32;

    @OOXIXo
    public static final String PACKAGE_MISSED_CALL = "com.android.mobilephone";

    @OOXIXo
    public static final String PACKAGE_SMS = "com.android.mms";
    public static final int PHONE_LENGTH = 32;

    @OOXIXo
    public static final String QQ = "com.tencent.mobileqq";

    @OOXIXo
    public static final String SAMSUNG_INCALLUI = "com.samsung.android.incallui";

    @OOXIXo
    public static final String SAMSUNG_MMS = "com.samsung.android.messaging";

    @OOXIXo
    public static final String SAMSUNG_TELECOM = "com.samsung.android.dialer";

    @OOXIXo
    public static final String SEARCH = "com.nhn.android.search";

    @OOXIXo
    public static final String SECURESMS = "org.thoughtcrime.securesms";

    @OOXIXo
    public static final String SINA_WEIBO = "com.sina.weibo";

    @OOXIXo
    public static final String SKYPE = "com.skype.raider";

    @OOXIXo
    public static final String SNAPCHAT = "com.snapchat.android";

    @OOXIXo
    public static final String TELEGRAM = "org.telegram.messenger";

    @OOXIXo
    public static final String TIKTOK = "com.zhiliaoapp.musically";
    public static final int TITLE_LENGTH = 32;

    @OOXIXo
    public static final String TOWNEERS = "com.towneers.www";

    @OOXIXo
    public static final String TRILL = "com.ss.android.ugc.trill";

    @OOXIXo
    public static final String TWITTER = "com.twitter.android";

    @OOXIXo
    public static final String UC = "Uxpp.UC";

    @OOXIXo
    public static final String VIBER = "com.viber.voip";

    @OOXIXo
    public static final String VK = "com.vkontakte.android";

    @OOXIXo
    public static final String WE_CHAT = "com.tencent.mm";

    @OOXIXo
    public static final String WHATS_APP = "com.whatsapp";

    @OOXIXo
    public static final String YAHOO_MAIL = "com.yahoo.mobile.client.android.mail";

    @OOXIXo
    public static final String YOUTUBE = "com.google.android.youtube";

    @OOXIXo
    public static final String ZALO = "com.zing.zalo";
    private int mCategory;

    @OOXIXo
    private String mContent;

    @OOXIXo
    private String mPackage;
    private long mTime;

    @OOXIXo
    private String mTitle;

    @OOXIXo
    public static final Companion Companion = new Companion(null);

    @OOXIXo
    public static final String GMAIL = "com.google.android.gm";

    @OOXIXo
    public static final String OUT_LOOK = "com.microsoft.office.outlook";

    @OOXIXo
    public static final String OUT_LOOK2 = "park.outlook.sign.in.client";

    @OOXIXo
    private static final List<String> sEmailPackages = CollectionsKt__CollectionsKt.X00IoxXI(GMAIL, OUT_LOOK, OUT_LOOK2);

    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        public final boolean isEmail(@OOXIXo String packageName) {
            IIX0o.x0xO0oo(packageName, "packageName");
            if (!StringsKt__StringsKt.o00xOoIO(packageName, "mail", false, 2, null) && !BleNotification.sEmailPackages.contains(packageName)) {
                return false;
            }
            return true;
        }

        private Companion() {
        }
    }

    public BleNotification() {
        this(0, 0L, null, null, null, 31, null);
    }

    public static /* synthetic */ BleNotification copy$default(BleNotification bleNotification, int i, long j, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bleNotification.mCategory;
        }
        if ((i2 & 2) != 0) {
            j = bleNotification.mTime;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str = bleNotification.mPackage;
        }
        String str4 = str;
        if ((i2 & 8) != 0) {
            str2 = bleNotification.mTitle;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = bleNotification.mContent;
        }
        return bleNotification.copy(i, j2, str4, str5, str3);
    }

    public final int component1() {
        return this.mCategory;
    }

    public final long component2() {
        return this.mTime;
    }

    @OOXIXo
    public final String component3() {
        return this.mPackage;
    }

    @OOXIXo
    public final String component4() {
        return this.mTitle;
    }

    @OOXIXo
    public final String component5() {
        return this.mContent;
    }

    @OOXIXo
    public final BleNotification copy(int i, long j, @OOXIXo String mPackage, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        return new BleNotification(i, j, mPackage, mTitle, mContent);
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public void encode() {
        super.encode();
        writeInt8(this.mCategory);
        writeObject(BleTime.Companion.ofLocal(this.mTime));
        BleWritable.writeStringWithFix$default(this, this.mPackage, 32, null, 4, null);
        BleWritable.writeStringWithMax$default(this, this.mTitle, 32, null, 4, null);
        BleWritable.writeStringWithLimit$default(this, this.mContent, 250, null, true, 4, null);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleNotification)) {
            return false;
        }
        BleNotification bleNotification = (BleNotification) obj;
        return this.mCategory == bleNotification.mCategory && this.mTime == bleNotification.mTime && IIX0o.Oxx0IOOO(this.mPackage, bleNotification.mPackage) && IIX0o.Oxx0IOOO(this.mTitle, bleNotification.mTitle) && IIX0o.Oxx0IOOO(this.mContent, bleNotification.mContent);
    }

    public final int getMCategory() {
        return this.mCategory;
    }

    @OOXIXo
    public final String getMContent() {
        return this.mContent;
    }

    @Override // com.bestmafen.baseble.data.BleWritable
    public int getMLengthToWrite() {
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        return Math.min(bytes.length, 250) + 71;
    }

    @OOXIXo
    public final String getMPackage() {
        return this.mPackage;
    }

    public final long getMTime() {
        return this.mTime;
    }

    @OOXIXo
    public final String getMTitle() {
        return this.mTitle;
    }

    public int hashCode() {
        return (((((((this.mCategory * 31) + oIX0oI.oIX0oI(this.mTime)) * 31) + this.mPackage.hashCode()) * 31) + this.mTitle.hashCode()) * 31) + this.mContent.hashCode();
    }

    public final void setMCategory(int i) {
        this.mCategory = i;
    }

    public final void setMContent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mContent = str;
    }

    public final void setMPackage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPackage = str;
    }

    public final void setMTime(long j) {
        this.mTime = j;
    }

    public final void setMTitle(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mTitle = str;
    }

    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BleNotification(mCategory=");
        sb.append(this.mCategory);
        sb.append(", mTime=");
        sb.append(this.mTime);
        sb.append(", mPackage='");
        sb.append(this.mPackage);
        sb.append("', mTitle='");
        sb.append(this.mTitle);
        sb.append("', mLength=");
        byte[] bytes = this.mContent.getBytes(oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        sb.append(Math.min(bytes.length, 250));
        sb.append(", mContent='");
        sb.append(this.mContent);
        sb.append("')");
        return sb.toString();
    }

    public /* synthetic */ BleNotification(int i, long j, String str, String str2, String str3, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3);
    }

    public BleNotification(int i, long j, @OOXIXo String mPackage, @OOXIXo String mTitle, @OOXIXo String mContent) {
        IIX0o.x0xO0oo(mPackage, "mPackage");
        IIX0o.x0xO0oo(mTitle, "mTitle");
        IIX0o.x0xO0oo(mContent, "mContent");
        this.mCategory = i;
        this.mTime = j;
        this.mPackage = mPackage;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }
}
