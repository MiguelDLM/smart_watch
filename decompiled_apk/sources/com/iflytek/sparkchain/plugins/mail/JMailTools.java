package com.iflytek.sparkchain.plugins.mail;

import com.iflytek.sparkchain.plugins.mail.Mail;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;
import com.sun.mail.imap.IMAPStore;
import com.sun.mail.imap.protocol.IMAPProtocol;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class JMailTools {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object a(IMAPProtocol iMAPProtocol) throws ProtocolException {
        iMAPProtocol.id("FUTONG");
        return null;
    }

    public static List<Mail.Msg.Cc> getCcList(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Address address : addressArr) {
            InternetAddress internetAddress = (InternetAddress) address;
            Mail.Msg.Cc cc = new Mail.Msg.Cc();
            cc.address = internetAddress.getAddress();
            cc.nickname = internetAddress.getPersonal();
            arrayList.add(cc);
        }
        return arrayList;
    }

    public static Mail.Msg.Flags getFlags(Flags flags) {
        Mail.Msg.Flags flags2 = new Mail.Msg.Flags();
        flags2.isSeen = flags.contains(Flags.Flag.SEEN);
        flags2.isStar = flags.contains(Flags.Flag.FLAGGED);
        return flags2;
    }

    public static IMAPFolder getFolder(IMAPStore iMAPStore, String str, Mail.Config config) throws MessagingException {
        IMAPFolder folder = iMAPStore.getFolder(str);
        boolean contains = config.account.contains("@163.com");
        boolean contains2 = config.account.contains("@126.com");
        boolean contains3 = config.account.contains("@yeah.net");
        if (contains || contains2 || contains3) {
            folder.doCommand(new IMAPFolder.ProtocolCommand() { // from class: com.iflytek.sparkchain.plugins.mail.oIX0oI
                public final Object oIX0oI(IMAPProtocol iMAPProtocol) {
                    Object a2;
                    a2 = JMailTools.a(iMAPProtocol);
                    return a2;
                }
            });
        }
        folder.open(2);
        return folder;
    }

    public static Mail.Msg.From getFrom(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        InternetAddress internetAddress = (InternetAddress) addressArr[0];
        Mail.Msg.From from = new Mail.Msg.From();
        from.address = internetAddress.getAddress();
        from.nickname = internetAddress.getPersonal();
        return from;
    }

    public static Mail.Msg.MainBody getMainBody(IMAPMessage iMAPMessage) throws IOException, MessagingException {
        HashMap<String, StringBuilder> mainBodyMap = getMainBodyMap(iMAPMessage, new HashMap());
        iMAPMessage.setFlag(Flags.Flag.SEEN, true);
        if (mainBodyMap.get("text/plain") != null) {
            return new Mail.Msg.MainBody("text/plain", String.valueOf(mainBodyMap.get("text/plain")));
        }
        if (mainBodyMap.get(NanoHTTPD.MIME_HTML) != null) {
            return new Mail.Msg.MainBody(NanoHTTPD.MIME_HTML, String.valueOf(mainBodyMap.get(NanoHTTPD.MIME_HTML)));
        }
        return null;
    }

    public static HashMap<String, StringBuilder> getMainBodyMap(Part part, HashMap<String, StringBuilder> hashMap) throws MessagingException, IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (part.isMimeType("text/plain")) {
            sb.append(part.getContent());
            hashMap.put("text/plain", sb);
        } else if (part.isMimeType(NanoHTTPD.MIME_HTML)) {
            sb2.append(part.getContent());
            hashMap.put(NanoHTTPD.MIME_HTML, sb2);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int count = multipart.getCount();
            for (int i = 0; i < count; i++) {
                getMainBodyMap(multipart.getBodyPart(i), hashMap);
            }
        }
        return hashMap;
    }

    public static Mail.Msg getMsgDetail(IMAPFolder iMAPFolder, Message message) {
        Mail.Msg msg = new Mail.Msg();
        try {
            IMAPMessage iMAPMessage = (IMAPMessage) message;
            long uid = iMAPFolder.getUID(iMAPMessage);
            long time = iMAPMessage.getSentDate().getTime();
            String subject = iMAPMessage.getSubject();
            Mail.Msg.Flags flags = getFlags(iMAPMessage.getFlags());
            Mail.Msg.From from = getFrom(iMAPMessage.getFrom());
            List<Mail.Msg.To> toList = getToList(iMAPMessage.getRecipients(MimeMessage.RecipientType.TO));
            List<Mail.Msg.Cc> ccList = getCcList(iMAPMessage.getRecipients(MimeMessage.RecipientType.CC));
            Mail.Msg.MainBody mainBody = getMainBody(iMAPMessage);
            msg.uid = uid;
            msg.sentDate = time;
            msg.subject = subject;
            msg.flags = flags;
            msg.from = from;
            msg.toList = toList;
            msg.ccList = ccList;
            msg.mainBody = mainBody;
        } catch (Exception unused) {
        }
        return msg;
    }

    public static Mail.Msg getMsgHead(long j, IMAPMessage iMAPMessage) {
        try {
            long time = iMAPMessage.getSentDate().getTime();
            String subject = iMAPMessage.getSubject();
            Mail.Msg.Flags flags = getFlags(iMAPMessage.getFlags());
            Mail.Msg.From from = getFrom(iMAPMessage.getFrom());
            List<Mail.Msg.To> toList = getToList(iMAPMessage.getRecipients(MimeMessage.RecipientType.TO));
            List<Mail.Msg.Cc> ccList = getCcList(iMAPMessage.getRecipients(MimeMessage.RecipientType.CC));
            Mail.Msg msg = new Mail.Msg();
            msg.uid = j;
            msg.sentDate = time;
            msg.subject = subject;
            msg.flags = flags;
            msg.from = from;
            msg.toList = toList;
            msg.ccList = ccList;
            return msg;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<Mail.Msg> getMsgHeads(IMAPFolder iMAPFolder, Message[] messageArr) {
        ArrayList arrayList = new ArrayList();
        for (Message message : messageArr) {
            try {
                IMAPMessage iMAPMessage = (IMAPMessage) message;
                long uid = iMAPFolder.getUID(iMAPMessage);
                long time = iMAPMessage.getSentDate().getTime();
                String subject = iMAPMessage.getSubject();
                Mail.Msg.Flags flags = getFlags(iMAPMessage.getFlags());
                Mail.Msg.From from = getFrom(iMAPMessage.getFrom());
                Mail.Msg msg = new Mail.Msg();
                msg.uid = uid;
                msg.sentDate = time;
                msg.subject = subject;
                msg.flags = flags;
                msg.from = from;
                arrayList.add(msg);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public static IMAPStore getStore(Mail.Config config) throws MessagingException {
        IMAPStore store = toSession(config).getStore("imap");
        store.connect(config.IMAPHost, config.account, config.password);
        return store;
    }

    public static List<Mail.Msg.To> getToList(Address[] addressArr) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Address address : addressArr) {
            InternetAddress internetAddress = (InternetAddress) address;
            Mail.Msg.To to = new Mail.Msg.To();
            to.address = internetAddress.getAddress();
            to.nickname = internetAddress.getPersonal();
            arrayList.add(to);
        }
        return arrayList;
    }

    public static Transport getTransport(Mail.Config config) throws MessagingException {
        Transport transport = toSession(config).getTransport("smtp");
        transport.connect(config.SMTPHost, config.account, config.password);
        return transport;
    }

    public static Address[] toAddresses(String[] strArr) throws AddressException {
        if (strArr == null || strArr.length == 0) {
            return new InternetAddress[0];
        }
        InternetAddress[] internetAddressArr = new InternetAddress[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            internetAddressArr[i] = new InternetAddress(strArr[i]);
        }
        return internetAddressArr;
    }

    public static MimeMessage toMimeMessage(Mail.Config config, Mail.Draft draft) throws MessagingException, MalformedURLException {
        String str;
        MimeMessage mimeMessage = new MimeMessage(toSession(config));
        mimeMessage.addRecipients(MimeMessage.RecipientType.TO, toAddresses(draft.to));
        String[] strArr = draft.cc;
        if (strArr != null) {
            mimeMessage.addRecipients(MimeMessage.RecipientType.CC, toAddresses(strArr));
        }
        String[] strArr2 = draft.bcc;
        if (strArr2 != null) {
            mimeMessage.addRecipients(MimeMessage.RecipientType.BCC, toAddresses(strArr2));
        }
        mimeMessage.setFrom(new InternetAddress(config.nickname + "<" + config.account + ">"));
        mimeMessage.setSubject(draft.subject, "UTF-8");
        mimeMessage.setSentDate(new Date());
        String str2 = draft.html;
        if (str2 != null && !str2.isEmpty()) {
            mimeMessage.setContent(draft.html, "text/html; charset=UTF-8");
        }
        String str3 = draft.html;
        if ((str3 == null || str3.isEmpty()) && (str = draft.text) != null) {
            mimeMessage.setText(str, "UTF-8");
        }
        mimeMessage.setFlag(Flags.Flag.RECENT, true);
        mimeMessage.saveChanges();
        return mimeMessage;
    }

    public static Mail.Msg toMsg(long j, IMAPMessage iMAPMessage) throws MessagingException, IOException {
        long time = iMAPMessage.getSentDate().getTime();
        String subject = iMAPMessage.getSubject();
        Mail.Msg.Flags flags = getFlags(iMAPMessage.getFlags());
        Mail.Msg.From from = getFrom(iMAPMessage.getFrom());
        List<Mail.Msg.To> toList = getToList(iMAPMessage.getRecipients(MimeMessage.RecipientType.TO));
        List<Mail.Msg.Cc> ccList = getCcList(iMAPMessage.getRecipients(MimeMessage.RecipientType.CC));
        Mail.Msg.MainBody mainBody = getMainBody(iMAPMessage);
        Mail.Msg msg = new Mail.Msg();
        msg.uid = j;
        msg.subject = subject;
        msg.sentDate = time;
        msg.flags = flags;
        msg.from = from;
        msg.toList = toList;
        msg.ccList = ccList;
        msg.mainBody = mainBody;
        return msg;
    }

    public static Session toSession(Mail.Config config) {
        String str;
        Properties properties = new Properties();
        if (config.SMTPHost != null && config.SMTPPort != null) {
            Boolean bool = Boolean.TRUE;
            properties.put("mail.smtp.auth", bool);
            properties.put("mail.smtp.host", config.SMTPHost);
            properties.put("mail.smtp.port", config.SMTPPort);
            if (config.account.contains("@outlook.com") || config.account.contains("@office365.com")) {
                properties.put("mail.smtp.starttls.enable", Boolean.valueOf(config.SMTPSSLEnable));
                str = "mail.smtp.starttls.required";
            } else {
                bool = Boolean.valueOf(config.SMTPSSLEnable);
                str = "mail.smtp.ssl.enable";
            }
            properties.put(str, bool);
        }
        if (config.IMAPHost != null && config.IMAPPort != null) {
            properties.put("mail.imap.auth", Boolean.TRUE);
            properties.put("mail.imap.host", config.IMAPHost);
            properties.put("mail.imap.port", config.IMAPPort);
            properties.put("mail.imap.ssl.enable", Boolean.valueOf(config.IMAPSSLEnable));
            properties.setProperty("mail.imap.partialfetch", "false");
            properties.setProperty("mail.imaps.partialfetch", "false");
        }
        return Session.getInstance(properties);
    }
}
