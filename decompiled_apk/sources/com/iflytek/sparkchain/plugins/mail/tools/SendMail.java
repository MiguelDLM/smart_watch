package com.iflytek.sparkchain.plugins.mail.tools;

import android.util.Log;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import com.iflytek.sparkchain.plugins.mail.Mail;
import com.iflytek.sparkchain.plugins.mail.MailImpl;
import com.iflytek.sparkchain.plugins.mail.ifla.b;
import com.iflytek.sparkchain.plugins.utils.Utils;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes10.dex */
public class SendMail extends BaseTool {
    private MailImpl mailImpl;

    public SendMail() {
        initParams();
    }

    private void initParams() {
        this.name = MailPlugin.SendEmail;
        this.description = "邮件发送。";
        this.isDirect = true;
        this.argsSchema = new b();
    }

    private String[] parseRecipient(JSONArray jSONArray) throws JSONException {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length() && jSONArray.get(i).getClass().equals(String.class); i++) {
            String string = jSONArray.getString(i);
            MailImpl mailImpl = this.mailImpl;
            String searchContact = mailImpl != null ? mailImpl.searchContact(string) : string;
            if (searchContact.equals(string)) {
                searchContact = Utils.getContactsEmail(string);
            }
            Log.d(Utils.TAG, "address: " + searchContact);
            strArr[i] = searchContact;
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed A[Catch: JSONException -> 0x0051, TryCatch #0 {JSONException -> 0x0051, blocks: (B:7:0x002e, B:10:0x0042, B:12:0x0048, B:16:0x0055, B:19:0x005d, B:21:0x006b, B:22:0x0075, B:24:0x007b, B:26:0x0089, B:27:0x0095, B:29:0x009b, B:31:0x00a9, B:32:0x00b5, B:35:0x00bd, B:37:0x00cb, B:38:0x00d1, B:40:0x00d7, B:42:0x00e5, B:44:0x00ed, B:46:0x00fc), top: B:6:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc A[Catch: JSONException -> 0x0051, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0051, blocks: (B:7:0x002e, B:10:0x0042, B:12:0x0048, B:16:0x0055, B:19:0x005d, B:21:0x006b, B:22:0x0075, B:24:0x007b, B:26:0x0089, B:27:0x0095, B:29:0x009b, B:31:0x00a9, B:32:0x00b5, B:35:0x00bd, B:37:0x00cb, B:38:0x00d1, B:40:0x00d7, B:42:0x00e5, B:44:0x00ed, B:46:0x00fc), top: B:6:0x002e }] */
    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object run(java.lang.Object r14, java.lang.String... r15) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.plugins.mail.tools.SendMail.run(java.lang.Object, java.lang.String[]):java.lang.Object");
    }

    public SendMail(Mail.Config config) {
        initParams();
        this.mailImpl = new MailImpl(config);
    }
}
