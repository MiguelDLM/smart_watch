package com.iflytek.sparkchain.plugins.mail;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.internal.bn;
import com.iflytek.sparkchain.plugins.mail.Mail;
import com.iflytek.sparkchain.plugins.mail.UIDHandler;
import com.iflytek.sparkchain.plugins.utils.Utils;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;
import com.sun.mail.imap.IMAPStore;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.search.BodyTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SubjectTerm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class MailFolder {
    private final Mail.Config config;
    private final String folderName;
    private final String TAG = Utils.TAG;
    private final String SEEN = "seen";
    private final String UNSEEN = "unseen";
    private final String FLAGGED = "flagged";
    private final String ANSWERED = "answered";
    private final String DELETED = "deleted";
    private final String ON = "on_date";
    private final String SUBJECT = "subject";
    private final String TEXT = "text";
    private final String FROM = TypedValues.TransitionType.S_FROM;
    private final String TO = "TO";
    private final String CC = "CC";
    private final String BCC = "BCC";
    private final String Mail_Subject = "subject";
    private final String Mail_to = "to";
    private final String Mail_body = "body";
    private final String Mail_from = TypedValues.TransitionType.S_FROM;

    public MailFolder(Mail.Config config, String str) {
        this.config = config;
        this.folderName = str;
    }

    private JSONObject keyAdapter(JSONObject jSONObject) {
        try {
            return new JSONObject(jSONObject.toString().replace("contact", TypedValues.TransitionType.S_FROM).replace(bn.l, "flagged").replace("title_contain", "subject").replace("content_contain", "text"));
        } catch (JSONException e) {
            Log.e(Utils.TAG, "exception: " + e.getMessage());
            return null;
        }
    }

    private SearchTerm[] parseTerm(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("seen")) {
            arrayList.add(new FlagTerm(new Flags(Flags.Flag.SEEN), true));
        }
        if (jSONObject.has("unseen")) {
            arrayList.add(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        }
        if (jSONObject.has("flagged")) {
            arrayList.add(new FlagTerm(new Flags(Flags.Flag.FLAGGED), false));
        }
        if (jSONObject.has("answered")) {
            arrayList.add(new FlagTerm(new Flags(Flags.Flag.ANSWERED), true));
        }
        if (jSONObject.has("deleted")) {
            arrayList.add(new FlagTerm(new Flags(Flags.Flag.DELETED), true));
        }
        if (jSONObject.has("on_date")) {
            try {
                Date parse = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(jSONObject.getString("on_date"));
                Date date = new Date(parse.getTime());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(6, 1);
                Date time = calendar.getTime();
                SentDateTerm sentDateTerm = new SentDateTerm(6, parse);
                arrayList.add(new SentDateTerm(1, time));
                arrayList.add(sentDateTerm);
            } catch (ParseException | JSONException e) {
                Log.e(Utils.TAG, "exception: " + e.getMessage());
            }
        }
        if (jSONObject.has("subject")) {
            try {
                String string = jSONObject.getString("subject");
                if (string != null && !"null".equals(string) && !string.isEmpty()) {
                    arrayList.add(new SubjectTerm(string));
                }
            } catch (JSONException e2) {
                Log.e(Utils.TAG, "exception: " + e2.getMessage());
            }
        }
        if (jSONObject.has("text")) {
            try {
                arrayList.add(new BodyTerm(jSONObject.getString("text")));
            } catch (JSONException e3) {
                Log.e(Utils.TAG, "exception: " + e3.getMessage());
            }
        }
        if (jSONObject.has(TypedValues.TransitionType.S_FROM)) {
            try {
                if (jSONObject.get(TypedValues.TransitionType.S_FROM).getClass().equals(String.class)) {
                    arrayList.add(new FromStringTerm(jSONObject.getString(TypedValues.TransitionType.S_FROM)));
                } else if (jSONObject.get(TypedValues.TransitionType.S_FROM).getClass().equals(JSONArray.class)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(TypedValues.TransitionType.S_FROM);
                    if (jSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string2 = jSONArray.getString(i);
                            if (string2 != null && !"null".equals(string2) && !string2.isEmpty()) {
                                arrayList2.add(new FromStringTerm(string2));
                            }
                        }
                        if (arrayList2.size() != 0) {
                            arrayList.add(new OrTerm((SearchTerm[]) arrayList2.toArray(new SearchTerm[arrayList2.size()])));
                        }
                    }
                }
            } catch (JSONException e4) {
                Log.e(Utils.TAG, "exception: " + e4.getMessage());
            }
        }
        if (jSONObject.has("TO")) {
            try {
                arrayList.add(new RecipientStringTerm(Message.RecipientType.TO, jSONObject.getString("TO")));
            } catch (JSONException e5) {
                Log.e(Utils.TAG, "exception: " + e5.getMessage());
            }
        }
        if (jSONObject.has("CC")) {
            try {
                arrayList.add(new RecipientStringTerm(Message.RecipientType.CC, jSONObject.getString("CC")));
            } catch (JSONException e6) {
                Log.e(Utils.TAG, "exception: " + e6.getMessage());
            }
        }
        if (jSONObject.has("BCC")) {
            try {
                arrayList.add(new RecipientStringTerm(Message.RecipientType.BCC, jSONObject.getString("BCC")));
            } catch (JSONException e7) {
                Log.e(Utils.TAG, "exception: " + e7.getMessage());
            }
        }
        if (jSONObject.has("body")) {
            try {
                String string3 = jSONObject.getString("body");
                if (string3 != null && !"null".equals(string3) && !string3.isEmpty()) {
                    arrayList.add(new BodyTerm(string3));
                }
            } catch (JSONException e8) {
                Log.e(Utils.TAG, "exception: " + e8.getMessage());
            }
        }
        if (jSONObject.has("to")) {
            try {
                JSONArray jSONArray2 = jSONObject.getJSONArray("to");
                if (jSONArray2.length() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        String string4 = jSONArray2.getString(i2);
                        if (string4 != null && !"null".equals(string4) && !string4.isEmpty()) {
                            arrayList3.add(new FromStringTerm(string4));
                        }
                    }
                    if (arrayList3.size() != 0) {
                        arrayList.add(new OrTerm((SearchTerm[]) arrayList3.toArray(new SearchTerm[arrayList3.size()])));
                    }
                }
            } catch (JSONException e9) {
                Log.e(Utils.TAG, "exception: " + e9.getMessage());
            }
        }
        if (arrayList.size() <= 0) {
            return new SearchTerm[0];
        }
        Log.d("Trem", "Trem size is: " + arrayList.size());
        return (SearchTerm[]) arrayList.toArray(new SearchTerm[arrayList.size()]);
    }

    public boolean delete(long[] jArr) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    folder.setFlags(folder.getMessagesByUID(jArr), new Flags(Flags.Flag.DELETED), true);
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "delete failure: " + e.getMessage());
            return false;
        }
    }

    public Mail.Msg getDetail(long j) {
        new ArrayList();
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    Mail.Msg msgDetail = JMailTools.getMsgDetail(folder, folder.getMessageByUID(j));
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return msgDetail;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public Mail.Msg getMsg(long j) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    IMAPMessage messageByUID = folder.getMessageByUID(j);
                    if (messageByUID != null) {
                        Mail.Msg msg = JMailTools.toMsg(j, messageByUID);
                        folder.close();
                        if (store != null) {
                            store.close();
                        }
                        return msg;
                    }
                    folder.close();
                    if (store == null) {
                        return null;
                    }
                    store.close();
                    return null;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            Log.e(Utils.TAG, "getMsg failure: " + e.getMessage());
            return null;
        }
    }

    public List<Mail.Msg> load(long j) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                IMAPStore store = JMailTools.getStore(this.config);
                try {
                    IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                    try {
                        IMAPMessage[] messagesByUID = folder.getMessagesByUID(UIDHandler.nextUIDArray(folder, j));
                        FetchProfile fetchProfile = new FetchProfile();
                        fetchProfile.add(FetchProfile.Item.ENVELOPE);
                        fetchProfile.add(FetchProfile.Item.FLAGS);
                        folder.fetch(messagesByUID, fetchProfile);
                        for (IMAPMessage iMAPMessage : messagesByUID) {
                            Mail.Msg msgHead = JMailTools.getMsgHead(folder.getUID(iMAPMessage), iMAPMessage);
                            if (msgHead != null) {
                                arrayList.add(msgHead);
                            }
                        }
                        folder.close();
                        if (store != null) {
                            store.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (store != null) {
                        try {
                            store.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (MessagingException e) {
                Log.e(Utils.TAG, "load failure: " + e.getMessage());
            }
        }
        return arrayList;
    }

    public boolean move(String str, long[] jArr) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    IMAPFolder folder2 = JMailTools.getFolder(store, str, this.config);
                    try {
                        Message[] messagesByUID = folder.getMessagesByUID(jArr);
                        folder.copyMessages(messagesByUID, folder2);
                        folder.setFlags(messagesByUID, new Flags(Flags.Flag.DELETED), true);
                        if (folder2 != null) {
                            folder2.close();
                        }
                        folder.close();
                        if (store != null) {
                            store.close();
                        }
                        return true;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "move failure: " + e.getMessage());
            return false;
        }
    }

    public boolean readStatus(long[] jArr, boolean z) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    folder.setFlags(folder.getMessagesByUID(jArr), new Flags(Flags.Flag.SEEN), z);
                    folder.close();
                    if (store == null) {
                        return true;
                    }
                    store.close();
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "star failure: " + e.getMessage());
            return false;
        }
    }

    public boolean save(Mail.Draft draft) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    folder.appendMessages(new MimeMessage[]{JMailTools.toMimeMessage(this.config, draft)});
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return true;
                } finally {
                }
            } catch (Throwable th) {
                if (store != null) {
                    try {
                        store.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (MalformedURLException | MessagingException e) {
            Log.e(Utils.TAG, "save draft failure: " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059 A[Catch: all -> 0x001f, TryCatch #4 {all -> 0x001f, blocks: (B:7:0x0013, B:9:0x001a, B:10:0x002a, B:18:0x003e, B:20:0x0049, B:22:0x004c, B:24:0x0059, B:26:0x005d, B:29:0x0067, B:35:0x004e, B:37:0x0051, B:39:0x0054, B:41:0x0021), top: B:6:0x0013, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d A[Catch: MessagingException -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {MessagingException -> 0x003b, blocks: (B:3:0x0005, B:15:0x0037, B:32:0x007d, B:53:0x0096, B:58:0x0093, B:55:0x008e, B:5:0x000b, B:13:0x002f, B:30:0x0078, B:45:0x008b, B:50:0x0088), top: B:2:0x0005, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.iflytek.sparkchain.plugins.mail.Mail.Msg> search(org.json.JSONObject r6, int r7, int r8, final boolean r9) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.iflytek.sparkchain.plugins.mail.Mail$Config r1 = r5.config     // Catch: javax.mail.MessagingException -> L3b
            com.sun.mail.imap.IMAPStore r1 = com.iflytek.sparkchain.plugins.mail.JMailTools.getStore(r1)     // Catch: javax.mail.MessagingException -> L3b
            java.lang.String r2 = r5.folderName     // Catch: java.lang.Throwable -> L33
            com.iflytek.sparkchain.plugins.mail.Mail$Config r3 = r5.config     // Catch: java.lang.Throwable -> L33
            com.sun.mail.imap.IMAPFolder r2 = com.iflytek.sparkchain.plugins.mail.JMailTools.getFolder(r1, r2, r3)     // Catch: java.lang.Throwable -> L33
            javax.mail.search.SearchTerm[] r6 = r5.parseTerm(r6)     // Catch: java.lang.Throwable -> L1f
            int r3 = r6.length     // Catch: java.lang.Throwable -> L1f
            if (r3 != 0) goto L21
            javax.mail.Message[] r6 = r2.getMessages()     // Catch: java.lang.Throwable -> L1f
            goto L2a
        L1f:
            r6 = move-exception
            goto L81
        L21:
            javax.mail.search.AndTerm r3 = new javax.mail.search.AndTerm     // Catch: java.lang.Throwable -> L1f
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L1f
            javax.mail.Message[] r6 = r2.search(r3)     // Catch: java.lang.Throwable -> L1f
        L2a:
            int r3 = r6.length     // Catch: java.lang.Throwable -> L1f
            if (r3 != 0) goto L3e
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.lang.Throwable -> L33
            goto L35
        L33:
            r6 = move-exception
            goto L8c
        L35:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: javax.mail.MessagingException -> L3b
            goto L3d
        L3b:
            r6 = move-exception
            goto L97
        L3d:
            return r0
        L3e:
            com.iflytek.sparkchain.plugins.mail.MailFolder$1 r3 = new com.iflytek.sparkchain.plugins.mail.MailFolder$1     // Catch: java.lang.Throwable -> L1f
            r3.<init>()     // Catch: java.lang.Throwable -> L1f
            java.util.Arrays.sort(r6, r3)     // Catch: java.lang.Throwable -> L1f
            r9 = 0
            if (r7 >= r8) goto L4e
            int r3 = r6.length     // Catch: java.lang.Throwable -> L1f
            if (r8 > r3) goto L4e
        L4c:
            int r8 = r8 - r7
            goto L57
        L4e:
            int r3 = r6.length     // Catch: java.lang.Throwable -> L1f
            if (r8 <= r3) goto L56
            int r8 = r6.length     // Catch: java.lang.Throwable -> L1f
            if (r7 >= r8) goto L56
            int r8 = r6.length     // Catch: java.lang.Throwable -> L1f
            goto L4c
        L56:
            r8 = 0
        L57:
            if (r8 <= 0) goto L67
            javax.mail.Message[] r3 = new javax.mail.Message[r8]     // Catch: java.lang.Throwable -> L1f
        L5b:
            if (r9 >= r8) goto L66
            int r4 = r7 + r9
            r4 = r6[r4]     // Catch: java.lang.Throwable -> L1f
            r3[r9] = r4     // Catch: java.lang.Throwable -> L1f
            int r9 = r9 + 1
            goto L5b
        L66:
            r6 = r3
        L67:
            javax.mail.FetchProfile r7 = new javax.mail.FetchProfile     // Catch: java.lang.Throwable -> L1f
            r7.<init>()     // Catch: java.lang.Throwable -> L1f
            javax.mail.FetchProfile$Item r8 = javax.mail.FetchProfile.Item.ENVELOPE     // Catch: java.lang.Throwable -> L1f
            r7.add(r8)     // Catch: java.lang.Throwable -> L1f
            r2.fetch(r6, r7)     // Catch: java.lang.Throwable -> L1f
            java.util.List r0 = com.iflytek.sparkchain.plugins.mail.JMailTools.getMsgHeads(r2, r6)     // Catch: java.lang.Throwable -> L1f
            r2.close()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto Lbf
            r1.close()     // Catch: javax.mail.MessagingException -> L3b
            goto Lbf
        L81:
            if (r2 == 0) goto L8b
            r2.close()     // Catch: java.lang.Throwable -> L87
            goto L8b
        L87:
            r7 = move-exception
            r6.addSuppressed(r7)     // Catch: java.lang.Throwable -> L33
        L8b:
            throw r6     // Catch: java.lang.Throwable -> L33
        L8c:
            if (r1 == 0) goto L96
            r1.close()     // Catch: java.lang.Throwable -> L92
            goto L96
        L92:
            r7 = move-exception
            r6.addSuppressed(r7)     // Catch: javax.mail.MessagingException -> L3b
        L96:
            throw r6     // Catch: javax.mail.MessagingException -> L3b
        L97:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "search email failure: "
            r7.append(r8)
            java.lang.String r8 = r6.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "SparkChain"
            android.util.Log.e(r8, r7)
            com.iflytek.sparkchain.plugins.mail.Mail$Config r7 = r5.config
            com.iflytek.sparkchain.plugins.mail.Mail$AuthListener r7 = r7.authListener
            if (r7 == 0) goto Lbf
            java.lang.String r6 = r6.getMessage()
            r8 = 2
            r7.onFailure(r8, r6)
        Lbf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.plugins.mail.MailFolder.search(org.json.JSONObject, int, int, boolean):java.util.List");
    }

    public List<Mail.Msg> searchByFrom(String str) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    Message[] search = folder.search(new FromStringTerm(str));
                    FetchProfile fetchProfile = new FetchProfile();
                    fetchProfile.add(FetchProfile.Item.ENVELOPE);
                    folder.fetch(search, fetchProfile);
                    List<Mail.Msg> msgHeads = JMailTools.getMsgHeads(folder, search);
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return msgHeads;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "searchByFrom email failure: " + e.getMessage());
            return null;
        }
    }

    public List<Mail.Msg> searchBySubject(String str) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    Message[] search = folder.search(new SubjectTerm(str));
                    FetchProfile fetchProfile = new FetchProfile();
                    fetchProfile.add(FetchProfile.Item.ENVELOPE);
                    folder.fetch(search, fetchProfile);
                    List<Mail.Msg> msgHeads = JMailTools.getMsgHeads(folder, search);
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return msgHeads;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "star failure: " + e.getMessage());
            return null;
        }
    }

    public List<Mail.Msg> searchByTo(String str) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    Message[] search = folder.search(new RecipientStringTerm(MimeMessage.RecipientType.TO, str));
                    FetchProfile fetchProfile = new FetchProfile();
                    fetchProfile.add(FetchProfile.Item.ENVELOPE);
                    folder.fetch(search, fetchProfile);
                    List<Mail.Msg> msgHeads = JMailTools.getMsgHeads(folder, search);
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return msgHeads;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "searchByTo email failure: " + e.getMessage());
            return null;
        }
    }

    public String searchContacts(String str) {
        List searchByFrom = new Mail.IMAP(this.config).getInbox().searchByFrom(str);
        return searchByFrom.size() > 0 ? ((Mail.Msg) searchByFrom.get(0)).from.address : str;
    }

    public boolean star(long[] jArr, boolean z) {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    folder.setFlags(folder.getMessagesByUID(jArr), new Flags(Flags.Flag.FLAGGED), z);
                    folder.close();
                    if (store == null) {
                        return true;
                    }
                    store.close();
                    return true;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "star failure: " + e.getMessage());
            return false;
        }
    }

    public void sync(long[] jArr) {
        synchronized (this) {
            try {
                IMAPStore store = JMailTools.getStore(this.config);
                try {
                    IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                    try {
                        UIDHandler.Result syncUIDArray = UIDHandler.syncUIDArray(folder, jArr);
                        long[] jArr2 = syncUIDArray.newArray;
                        long[] jArr3 = syncUIDArray.delArray;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (jArr2.length > 0) {
                            IMAPMessage[] messagesByUID = folder.getMessagesByUID(jArr2);
                            FetchProfile fetchProfile = new FetchProfile();
                            fetchProfile.add(FetchProfile.Item.ENVELOPE);
                            fetchProfile.add(FetchProfile.Item.FLAGS);
                            folder.fetch(messagesByUID, fetchProfile);
                            for (IMAPMessage iMAPMessage : messagesByUID) {
                                Mail.Msg msgHead = JMailTools.getMsgHead(folder.getUID(iMAPMessage), iMAPMessage);
                                if (msgHead != null) {
                                    arrayList.add(msgHead);
                                }
                            }
                        }
                        for (long j : jArr3) {
                            arrayList2.add(Long.valueOf(j));
                        }
                        if (folder != null) {
                            folder.close();
                        }
                        if (store != null) {
                            store.close();
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (store != null) {
                        try {
                            store.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (MessagingException e) {
                Log.e(Utils.TAG, "failure: " + e.getMessage());
            }
        }
    }

    public int totalCount() {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    int messageCount = folder.getMessageCount();
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return messageCount;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "count failure: " + e.getMessage());
            return 0;
        }
    }

    public int unreadCount() {
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                IMAPFolder folder = JMailTools.getFolder(store, this.folderName, this.config);
                try {
                    int unreadMessageCount = folder.getUnreadMessageCount();
                    folder.close();
                    if (store != null) {
                        store.close();
                    }
                    return unreadMessageCount;
                } finally {
                }
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(Utils.TAG, "unreadCount failure: " + e.getMessage());
            return 0;
        }
    }
}
