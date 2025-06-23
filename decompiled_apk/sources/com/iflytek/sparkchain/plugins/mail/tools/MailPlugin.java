package com.iflytek.sparkchain.plugins.mail.tools;

import com.iflytek.sparkchain.plugins.base.BasePlugin;
import com.iflytek.sparkchain.plugins.mail.Mail;

/* loaded from: classes10.dex */
public class MailPlugin extends BasePlugin {
    public static final String SearchEmail = "find_email";
    public static final String SendEmail = "send_email";

    public MailPlugin() {
        this.tools.append(new SearchMail()).append(new SendMail());
    }

    public MailPlugin(Mail.Config config) {
        this.tools.append(new SearchMail(config)).append(new SendMail(config));
    }
}
