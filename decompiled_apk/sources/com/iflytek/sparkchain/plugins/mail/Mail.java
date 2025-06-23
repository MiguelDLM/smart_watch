package com.iflytek.sparkchain.plugins.mail;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.internal.a;
import com.huawei.openalliance.ad.constant.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public final class Mail {

    /* loaded from: classes10.dex */
    public interface AuthListener {
        void onAuth(int i, String str);

        void onFailure(int i, String str);

        void onSuccess(int i, String str);
    }

    /* loaded from: classes10.dex */
    public static class Config {
        public String IMAPHost;
        public Integer IMAPPort;
        public boolean IMAPSSLEnable;
        public String SMTPHost;
        public Integer SMTPPort;
        public boolean SMTPSSLEnable;
        public String account;
        public AuthListener authListener;
        public String nickname;
        public String password;
    }

    /* loaded from: classes10.dex */
    public static class Draft implements Parcelable {
        public static final Parcelable.Creator<Draft> CREATOR = new Parcelable.Creator<Draft>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Draft.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Draft createFromParcel(Parcel parcel) {
                return new Draft(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Draft[] newArray(int i) {
                return new Draft[i];
            }
        };
        public String[] bcc;
        public String[] cc;
        public String html;
        public String subject;
        public String text;
        public String[] to;

        public Draft() {
            this.subject = "";
            this.text = "";
            this.html = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.to = parcel.createStringArray();
            this.cc = parcel.createStringArray();
            this.bcc = parcel.createStringArray();
            this.subject = parcel.readString();
            this.text = parcel.readString();
            this.html = parcel.readString();
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("subject", this.subject);
                jSONObject.put("text", this.text);
                jSONObject.put(a.f, this.html);
                JSONArray jSONArray = new JSONArray();
                String[] strArr = this.to;
                if (strArr != null && strArr.length > 0) {
                    for (String str : strArr) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("to", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                String[] strArr2 = this.cc;
                if (strArr2 != null && strArr2.length > 0) {
                    for (String str2 : strArr2) {
                        jSONArray2.put(str2);
                    }
                }
                jSONObject.put("cc", jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                String[] strArr3 = this.bcc;
                if (strArr3 != null && strArr3.length > 0) {
                    for (String str3 : strArr3) {
                        jSONArray2.put(str3);
                    }
                }
                jSONObject.put("bcc", jSONArray3);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(this.to);
            parcel.writeStringArray(this.cc);
            parcel.writeStringArray(this.bcc);
            parcel.writeString(this.subject);
            parcel.writeString(this.text);
            parcel.writeString(this.html);
        }

        public Draft(Parcel parcel) {
            this.subject = "";
            this.text = "";
            this.html = "";
            this.to = parcel.createStringArray();
            this.cc = parcel.createStringArray();
            this.bcc = parcel.createStringArray();
            this.subject = parcel.readString();
            this.text = parcel.readString();
            this.html = parcel.readString();
        }
    }

    /* loaded from: classes10.dex */
    public static class IMAP extends IMAPService {

        /* loaded from: classes10.dex */
        public static class DraftBox extends MailFolder {
            public DraftBox(Config config, String str) {
                super(config, str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean delete(long[] jArr) {
                return super.delete(jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ Msg getDetail(long j) {
                return super.getDetail(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ Msg getMsg(long j) {
                return super.getMsg(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List load(long j) {
                return super.load(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean move(String str, long[] jArr) {
                return super.move(str, jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean readStatus(long[] jArr, boolean z) {
                return super.readStatus(jArr, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public boolean save(Draft draft) {
                return super.save(draft);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List search(JSONObject jSONObject, int i, int i2, boolean z) {
                return super.search(jSONObject, i, i2, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchByFrom(String str) {
                return super.searchByFrom(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchBySubject(String str) {
                return super.searchBySubject(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchByTo(String str) {
                return super.searchByTo(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ String searchContacts(String str) {
                return super.searchContacts(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean star(long[] jArr, boolean z) {
                return super.star(jArr, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ void sync(long[] jArr) {
                super.sync(jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ int totalCount() {
                return super.totalCount();
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ int unreadCount() {
                return super.unreadCount();
            }
        }

        /* loaded from: classes10.dex */
        public static class Folder extends MailFolder {
            public Folder(Config config, String str) {
                super(config, str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean delete(long[] jArr) {
                return super.delete(jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ Msg getDetail(long j) {
                return super.getDetail(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ Msg getMsg(long j) {
                return super.getMsg(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List load(long j) {
                return super.load(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean move(String str, long[] jArr) {
                return super.move(str, jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean readStatus(long[] jArr, boolean z) {
                return super.readStatus(jArr, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean save(Draft draft) {
                return super.save(draft);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List search(JSONObject jSONObject, int i, int i2, boolean z) {
                return super.search(jSONObject, i, i2, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchByFrom(String str) {
                return super.searchByFrom(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchBySubject(String str) {
                return super.searchBySubject(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchByTo(String str) {
                return super.searchByTo(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ String searchContacts(String str) {
                return super.searchContacts(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean star(long[] jArr, boolean z) {
                return super.star(jArr, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ void sync(long[] jArr) {
                super.sync(jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ int totalCount() {
                return super.totalCount();
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ int unreadCount() {
                return super.unreadCount();
            }
        }

        /* loaded from: classes10.dex */
        public static class Inbox extends MailFolder {
            public Inbox(Config config, String str) {
                super(config, str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean delete(long[] jArr) {
                return super.delete(jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ Msg getDetail(long j) {
                return super.getDetail(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ Msg getMsg(long j) {
                return super.getMsg(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List load(long j) {
                return super.load(j);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean move(String str, long[] jArr) {
                return super.move(str, jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean readStatus(long[] jArr, boolean z) {
                return super.readStatus(jArr, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean save(Draft draft) {
                return super.save(draft);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List search(JSONObject jSONObject, int i, int i2, boolean z) {
                return super.search(jSONObject, i, i2, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchByFrom(String str) {
                return super.searchByFrom(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchBySubject(String str) {
                return super.searchBySubject(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ List searchByTo(String str) {
                return super.searchByTo(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ String searchContacts(String str) {
                return super.searchContacts(str);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ boolean star(long[] jArr, boolean z) {
                return super.star(jArr, z);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ void sync(long[] jArr) {
                super.sync(jArr);
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ int totalCount() {
                return super.totalCount();
            }

            @Override // com.iflytek.sparkchain.plugins.mail.MailFolder
            public /* bridge */ /* synthetic */ int unreadCount() {
                return super.unreadCount();
            }
        }

        public IMAP(Config config) {
            super(config);
        }

        @Override // com.iflytek.sparkchain.plugins.mail.IMAPService
        public /* bridge */ /* synthetic */ List getDefaultFolders() {
            return super.getDefaultFolders();
        }

        @Override // com.iflytek.sparkchain.plugins.mail.IMAPService
        public /* bridge */ /* synthetic */ DraftBox getDraftBox() {
            return super.getDraftBox();
        }

        @Override // com.iflytek.sparkchain.plugins.mail.IMAPService
        public /* bridge */ /* synthetic */ Folder getFolder(String str) {
            return super.getFolder(str);
        }

        @Override // com.iflytek.sparkchain.plugins.mail.IMAPService
        public /* bridge */ /* synthetic */ Inbox getInbox() {
            return super.getInbox();
        }
    }

    /* loaded from: classes10.dex */
    public static class Msg implements Parcelable {
        public static final Parcelable.Creator<Msg> CREATOR = new Parcelable.Creator<Msg>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Msg.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Msg createFromParcel(Parcel parcel) {
                return new Msg(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Msg[] newArray(int i) {
                return new Msg[i];
            }
        };
        public List<Cc> ccList;
        public Flags flags;
        public From from;
        public MainBody mainBody;
        public long sentDate;
        public String subject;
        public List<To> toList;
        public long uid;

        /* loaded from: classes10.dex */
        public static class Cc implements Parcelable {
            public static final Parcelable.Creator<Cc> CREATOR = new Parcelable.Creator<Cc>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Msg.Cc.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Cc createFromParcel(Parcel parcel) {
                    return new Cc(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Cc[] newArray(int i) {
                    return new Cc[i];
                }
            };
            public String address;
            public String nickname;

            public Cc() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public void readFromParcel(Parcel parcel) {
                this.address = parcel.readString();
                this.nickname = parcel.readString();
            }

            public JSONObject toJSON() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("nickname", this.nickname);
                    jSONObject.put("address", this.address);
                    return jSONObject;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.address);
                parcel.writeString(this.nickname);
            }

            public Cc(Parcel parcel) {
                this.address = parcel.readString();
                this.nickname = parcel.readString();
            }
        }

        /* loaded from: classes10.dex */
        public static class Flags implements Parcelable {
            public static final Parcelable.Creator<Flags> CREATOR = new Parcelable.Creator<Flags>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Msg.Flags.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Flags createFromParcel(Parcel parcel) {
                    return new Flags(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public Flags[] newArray(int i) {
                    return new Flags[i];
                }
            };
            public boolean isSeen;
            public boolean isStar;

            public Flags() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public void readFromParcel(Parcel parcel) {
                this.isSeen = parcel.readByte() != 0;
                this.isStar = parcel.readByte() != 0;
            }

            public JSONObject toJSON() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isSeen", this.isSeen);
                    jSONObject.put("isStar", this.isStar);
                    return jSONObject;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeByte(this.isSeen ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.isStar ? (byte) 1 : (byte) 0);
            }

            public Flags(Parcel parcel) {
                this.isSeen = parcel.readByte() != 0;
                this.isStar = parcel.readByte() != 0;
            }
        }

        /* loaded from: classes10.dex */
        public static class From implements Parcelable {
            public static final Parcelable.Creator<From> CREATOR = new Parcelable.Creator<From>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Msg.From.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public From createFromParcel(Parcel parcel) {
                    return new From(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public From[] newArray(int i) {
                    return new From[i];
                }
            };
            public String address;
            public String nickname;

            public From() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public void readFromParcel(Parcel parcel) {
                this.address = parcel.readString();
                this.nickname = parcel.readString();
            }

            public JSONObject toJSON() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("nickname", this.nickname);
                    jSONObject.put("address", this.address);
                    return jSONObject;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.address);
                parcel.writeString(this.nickname);
            }

            public From(Parcel parcel) {
                this.address = parcel.readString();
                this.nickname = parcel.readString();
            }
        }

        /* loaded from: classes10.dex */
        public static class MainBody implements Parcelable {
            public static final Parcelable.Creator<MainBody> CREATOR = new Parcelable.Creator<MainBody>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Msg.MainBody.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public MainBody createFromParcel(Parcel parcel) {
                    return new MainBody(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public MainBody[] newArray(int i) {
                    return new MainBody[i];
                }
            };
            public String content;
            public String type;

            public MainBody(Parcel parcel) {
                this.type = parcel.readString();
                this.content = parcel.readString();
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public void readFromParcel(Parcel parcel) {
                this.type = parcel.readString();
                this.content = parcel.readString();
            }

            public JSONObject toJSON() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("content", this.content);
                    jSONObject.put("type", this.type);
                    return jSONObject;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.type);
                parcel.writeString(this.content);
            }

            public MainBody(String str, String str2) {
                this.type = str;
                this.content = str2;
            }
        }

        /* loaded from: classes10.dex */
        public static class To implements Parcelable {
            public static final Parcelable.Creator<To> CREATOR = new Parcelable.Creator<To>() { // from class: com.iflytek.sparkchain.plugins.mail.Mail.Msg.To.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public To createFromParcel(Parcel parcel) {
                    return new To(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public To[] newArray(int i) {
                    return new To[i];
                }
            };
            public String address;
            public String nickname;

            public To() {
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public void readFromParcel(Parcel parcel) {
                this.address = parcel.readString();
                this.nickname = parcel.readString();
            }

            public JSONObject toJSON() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("nickname", this.nickname);
                    jSONObject.put("address", this.address);
                    return jSONObject;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(this.address);
                parcel.writeString(this.nickname);
            }

            public To(Parcel parcel) {
                this.address = parcel.readString();
                this.nickname = parcel.readString();
            }
        }

        public Msg() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.uid = parcel.readLong();
            this.sentDate = parcel.readLong();
            this.subject = parcel.readString();
            this.flags = (Flags) parcel.readParcelable(Flags.class.getClassLoader());
            this.from = (From) parcel.readParcelable(From.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            this.toList = arrayList;
            parcel.readList(arrayList, To.class.getClassLoader());
            ArrayList arrayList2 = new ArrayList();
            this.ccList = arrayList2;
            parcel.readList(arrayList2, Cc.class.getClassLoader());
            this.mainBody = (MainBody) parcel.readParcelable(MainBody.class.getClassLoader());
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uid", this.uid);
                jSONObject.put("sentDate", this.sentDate);
                jSONObject.put("subject", this.subject);
                jSONObject.put(bn.f.y, this.flags.toJSON());
                jSONObject.put(TypedValues.TransitionType.S_FROM, this.from.toJSON());
                jSONObject.put("mainBody", this.mainBody.toJSON());
                JSONArray jSONArray = new JSONArray();
                Iterator<To> it = this.toList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
                jSONObject.put("toList", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                Iterator<Cc> it2 = this.ccList.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next().toJSON());
                }
                jSONObject.put("ccList", jSONArray2);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uid);
            parcel.writeLong(this.sentDate);
            parcel.writeString(this.subject);
            parcel.writeParcelable(this.flags, i);
            parcel.writeParcelable(this.from, i);
            parcel.writeList(this.toList);
            parcel.writeList(this.ccList);
            parcel.writeParcelable(this.mainBody, i);
        }

        public Msg(long j, long j2, String str, Flags flags, From from, List<To> list, List<Cc> list2, MainBody mainBody) {
            this.uid = j;
            this.sentDate = j2;
            this.subject = str;
            this.flags = flags;
            this.from = from;
            this.toList = list;
            this.ccList = list2;
            this.mainBody = mainBody;
        }

        public Msg(Parcel parcel) {
            this.uid = parcel.readLong();
            this.sentDate = parcel.readLong();
            this.subject = parcel.readString();
            this.flags = (Flags) parcel.readParcelable(Flags.class.getClassLoader());
            this.from = (From) parcel.readParcelable(From.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            this.toList = arrayList;
            parcel.readList(arrayList, To.class.getClassLoader());
            ArrayList arrayList2 = new ArrayList();
            this.ccList = arrayList2;
            parcel.readList(arrayList2, Cc.class.getClassLoader());
            this.mainBody = (MainBody) parcel.readParcelable(MainBody.class.getClassLoader());
        }
    }

    /* loaded from: classes10.dex */
    public static class SMTP extends SMTPService {
        public SMTP(Config config) {
            super(config);
        }

        @Override // com.iflytek.sparkchain.plugins.mail.SMTPService
        public /* bridge */ /* synthetic */ boolean send(Draft draft) {
            return super.send(draft);
        }
    }

    public static boolean auth(Config config) {
        return new AuthService(config).auth();
    }
}
