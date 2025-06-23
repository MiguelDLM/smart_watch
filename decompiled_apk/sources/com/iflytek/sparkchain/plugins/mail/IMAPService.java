package com.iflytek.sparkchain.plugins.mail;

import android.util.Log;
import com.iflytek.sparkchain.plugins.mail.Mail;
import com.sun.mail.imap.IMAPStore;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Folder;
import javax.mail.MessagingException;

/* loaded from: classes10.dex */
class IMAPService {
    private final String TAG = getClass().getName();
    private final Mail.Config config;

    public IMAPService(Mail.Config config) {
        this.config = config;
    }

    public List<String> getDefaultFolders() {
        ArrayList arrayList = new ArrayList();
        try {
            IMAPStore store = JMailTools.getStore(this.config);
            try {
                for (Folder folder : store.getDefaultFolder().list()) {
                    if (folder.list().length == 0) {
                        arrayList.add(folder.getFullName());
                    }
                }
                store.close();
            } finally {
            }
        } catch (MessagingException e) {
            Log.e(this.TAG, "getDefaultFolders failure: " + e.getMessage());
            Mail.AuthListener authListener = this.config.authListener;
            if (authListener != null) {
                authListener.onFailure(2, e.getMessage());
            }
        }
        return arrayList;
    }

    public Mail.IMAP.DraftBox getDraftBox() {
        return new Mail.IMAP.DraftBox(this.config, "Drafts");
    }

    public Mail.IMAP.Folder getFolder(String str) {
        return new Mail.IMAP.Folder(this.config, str);
    }

    public Mail.IMAP.Inbox getInbox() {
        return new Mail.IMAP.Inbox(this.config, "INBOX");
    }
}
