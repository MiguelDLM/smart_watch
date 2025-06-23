package com.iflytek.sparkchain.plugins.mail.tools;

import android.util.Log;
import com.iflytek.sparkchain.plugins.base.BaseTool;
import com.iflytek.sparkchain.plugins.mail.Mail;
import com.iflytek.sparkchain.plugins.mail.MailImpl;
import com.iflytek.sparkchain.plugins.mail.ifla.a;
import com.iflytek.sparkchain.plugins.utils.Utils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class SearchMail extends BaseTool {
    private MailImpl mailImpl;

    public SearchMail() {
        initParams();
    }

    private void initParams() {
        this.name = MailPlugin.SearchEmail;
        this.description = "邮件检索。";
        this.isDirect = true;
        this.argsSchema = new a();
    }

    private String toJSON(List<Mail.Msg> list, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (list.size() != 0 && z) {
                    Iterator<Mail.Msg> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObject.put("mailList", jSONArray);
                    jSONObject.put("isSuccess", true);
                    return jSONObject.toString();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        Log.e(Utils.TAG, "Mail Not Found");
        jSONObject.put("mailList", jSONArray);
        jSONObject.put("isSuccess", z);
        return null;
    }

    @Override // com.iflytek.sparkchain.plugins.base.BaseTool
    public Object run(Object obj, String... strArr) {
        return obj == null ? "null" : toResult(obj.toString(), 0, "do search success!");
    }

    public SearchMail(Mail.Config config) {
        initParams();
        this.mailImpl = new MailImpl(config);
    }
}
