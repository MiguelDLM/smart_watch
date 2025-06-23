package com.iflytek.sparkchain.plugins.mail;

import com.iflytek.sparkchain.plugins.mail.Mail;
import java.net.MalformedURLException;
import java.util.function.Consumer;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class SMTPService {
    private final Mail.Config config;

    public SMTPService(Mail.Config config) {
        this.config = config;
    }

    private boolean forward(Mail.Draft draft, String str, long j, Runnable runnable, Consumer<Exception> consumer) {
        Mail.Msg msg = new Mail.IMAP(this.config).getFolder(str).getMsg(j);
        if (msg == null) {
            return false;
        }
        draft.text += msg.mainBody.content;
        return send(draft);
    }

    private boolean reply(Mail.Draft draft, String str, long j, Runnable runnable, Consumer<Exception> consumer) {
        Mail.Msg msg = new Mail.IMAP(this.config).getFolder(str).getMsg(j);
        if (msg == null) {
            return false;
        }
        draft.text += msg.mainBody.content;
        return send(draft);
    }

    public boolean send(Mail.Draft draft) {
        try {
            Transport transport = JMailTools.getTransport(this.config);
            try {
                MimeMessage mimeMessage = JMailTools.toMimeMessage(this.config, draft);
                transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
                String[] strArr = draft.cc;
                if (strArr != null && strArr.length != 0) {
                    transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.CC));
                }
                String[] strArr2 = draft.bcc;
                if (strArr2 != null && strArr2.length != 0) {
                    transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.BCC));
                }
                transport.close();
                return true;
            } catch (Throwable th) {
                if (transport != null) {
                    try {
                        transport.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (MessagingException | MalformedURLException e) {
            Mail.AuthListener authListener = this.config.authListener;
            if (authListener == null) {
                return false;
            }
            authListener.onFailure(1, e.getMessage());
            return false;
        }
    }
}
