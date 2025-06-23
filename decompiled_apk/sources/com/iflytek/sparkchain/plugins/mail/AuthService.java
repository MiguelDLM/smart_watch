package com.iflytek.sparkchain.plugins.mail;

import com.iflytek.sparkchain.plugins.mail.Mail;
import com.iflytek.sparkchain.plugins.utils.Utils;
import com.sun.mail.imap.IMAPStore;
import javax.mail.MessagingException;
import javax.mail.Transport;

/* loaded from: classes10.dex */
final class AuthService {
    private final String TAG = Utils.TAG;
    private final Mail.Config config;

    public AuthService(Mail.Config config) {
        this.config = config;
    }

    public boolean auth() {
        int i;
        Mail.Config config = this.config;
        if (config.SMTPHost == null || config.SMTPPort == null) {
            Mail.AuthListener authListener = config.authListener;
            if (authListener != null) {
                authListener.onAuth(10002, "error msg: SMTPHost: " + this.config.SMTPHost + " config.SMTPPort: " + this.config.SMTPPort);
            }
            i = 0;
        } else {
            try {
                Transport transport = JMailTools.getTransport(config);
                if (transport != null) {
                    transport.close();
                }
                i = 1;
            } catch (MessagingException e) {
                Mail.AuthListener authListener2 = this.config.authListener;
                if (authListener2 != null) {
                    authListener2.onAuth(10003, e.getMessage() + " ");
                }
                return false;
            }
        }
        Mail.Config config2 = this.config;
        if (config2.IMAPHost == null || config2.IMAPPort == null) {
            Mail.AuthListener authListener3 = config2.authListener;
            if (authListener3 != null) {
                authListener3.onAuth(10002, "error msg: IMAPHost: " + this.config.IMAPHost + " config.IMAPPort: " + this.config.IMAPPort);
            }
        } else {
            try {
                IMAPStore store = JMailTools.getStore(config2);
                i++;
                if (store != null) {
                    store.close();
                }
            } catch (MessagingException e2) {
                Mail.AuthListener authListener4 = this.config.authListener;
                if (authListener4 != null) {
                    authListener4.onAuth(10003, e2.getMessage() + " ");
                }
                return false;
            }
        }
        if (i != 2) {
            return false;
        }
        Mail.AuthListener authListener5 = this.config.authListener;
        if (authListener5 != null) {
            authListener5.onAuth(0, "Mail Auth success!");
        }
        return true;
    }
}
