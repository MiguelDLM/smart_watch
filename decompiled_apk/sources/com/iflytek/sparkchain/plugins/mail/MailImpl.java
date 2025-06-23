package com.iflytek.sparkchain.plugins.mail;

import android.util.Log;
import com.iflytek.sparkchain.plugins.mail.Mail;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class MailImpl {
    private final String TAG = Utils.TAG;
    private boolean authSuccess;
    private Mail.Config config;

    public MailImpl(Mail.Config config) {
        this.authSuccess = false;
        this.config = config;
        this.authSuccess = initMail();
    }

    private boolean initMail() {
        if (verify()) {
            return Mail.auth(this.config);
        }
        return false;
    }

    private boolean verify() {
        String str;
        Mail.Config config = this.config;
        if (config.nickname == null || config.account == null || (str = config.password) == null || str.isEmpty() || this.config.nickname.isEmpty() || this.config.account.isEmpty()) {
            Mail.AuthListener authListener = this.config.authListener;
            if (authListener != null) {
                authListener.onAuth(10001, "mail user info error");
            }
            return false;
        }
        Mail.Config config2 = this.config;
        String str2 = config2.IMAPHost;
        if (str2 == null || config2.SMTPHost == null || str2.isEmpty() || this.config.SMTPHost.isEmpty()) {
            Mail.AuthListener authListener2 = this.config.authListener;
            if (authListener2 != null) {
                authListener2.onAuth(10002, "mail config info error");
            }
            return false;
        }
        if (this.config.IMAPPort.intValue() != -1 && this.config.SMTPPort.intValue() != -1) {
            return true;
        }
        Mail.AuthListener authListener3 = this.config.authListener;
        if (authListener3 != null) {
            authListener3.onAuth(10002, "mail config info error");
        }
        return false;
    }

    public Mail.Msg getDetail(long j) {
        return new Mail.IMAP(this.config).getInbox().getDetail(j);
    }

    public boolean isAuthSuccess() {
        return this.authSuccess;
    }

    public JSONObject parseSendMailContent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("payload")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
            if (!jSONObject2.has("plugins")) {
                return null;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("plugins");
            if (!jSONObject3.has("text")) {
                return null;
            }
            JSONArray jSONArray = jSONObject3.getJSONArray("text");
            if (jSONArray.length() > 0) {
                return (JSONObject) jSONArray.get(0);
            }
            return null;
        } catch (JSONException e) {
            Log.e(Utils.TAG, "parse sent_email json  failure: " + e.getMessage());
            return null;
        }
    }

    public String searchContact(String str) {
        return new Mail.IMAP(this.config).getInbox().searchContacts(str);
    }

    public List<Mail.Msg> searchMail(JSONObject jSONObject) {
        Log.d(Utils.TAG, "to" + jSONObject);
        return new Mail.IMAP(this.config).getInbox().search(jSONObject, 0, 0, false);
    }

    public boolean sendEmail(Mail.Draft draft) {
        Mail.SMTP smtp = new Mail.SMTP(this.config);
        Log.d(Utils.TAG, draft.toJSON().toString());
        return smtp.send(draft);
    }

    public List<Mail.Msg> searchMail(JSONObject jSONObject, int i, int i2, boolean z) {
        Log.d(Utils.TAG, "to" + jSONObject);
        return new Mail.IMAP(this.config).getInbox().search(jSONObject, i, i2, z);
    }
}
