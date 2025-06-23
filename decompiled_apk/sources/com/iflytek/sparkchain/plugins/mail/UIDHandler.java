package com.iflytek.sparkchain.plugins.mail;

import com.sun.mail.imap.IMAPFolder;
import java.util.Arrays;
import javax.mail.Message;
import javax.mail.MessagingException;

/* loaded from: classes10.dex */
class UIDHandler {

    /* loaded from: classes10.dex */
    public static class Basis {
        private Basis() {
        }

        public static int binarySearch(IMAPFolder iMAPFolder, Message[] messageArr, long j) throws MessagingException {
            int length = messageArr.length - 1;
            int i = 0;
            while (i <= length) {
                int i2 = (i + length) / 2;
                if (iMAPFolder.getUID(messageArr[i2]) > j) {
                    length = i2 - 1;
                } else {
                    if (iMAPFolder.getUID(messageArr[i2]) >= j) {
                        return i2;
                    }
                    i = i2 + 1;
                }
            }
            return -1;
        }

        public static long[] deleteUID(long[] jArr, long j) {
            int binarySearch = Arrays.binarySearch(jArr, j);
            int length = jArr.length;
            int i = length - 1;
            long[] jArr2 = new long[i];
            if (binarySearch > 0) {
                System.arraycopy(jArr, 0, jArr2, 0, binarySearch);
                System.arraycopy(jArr, binarySearch + 1, jArr2, binarySearch, (length - binarySearch) - 1);
                return jArr2;
            }
            if (binarySearch != 0) {
                return jArr;
            }
            System.arraycopy(jArr, 1, jArr2, 0, i);
            return jArr2;
        }

        public static long[] insertUID(long[] jArr, long j) {
            int length = jArr.length;
            long[] jArr2 = new long[length + 1];
            System.arraycopy(jArr, 0, jArr2, 0, length);
            jArr2[length] = j;
            return jArr2;
        }

        public static int searchIndex(IMAPFolder iMAPFolder, Message[] messageArr, long j) throws MessagingException {
            int length = messageArr.length - 1;
            int i = 0;
            int i2 = length;
            while (i <= i2) {
                int i3 = (i + i2) / 2;
                if (iMAPFolder.getUID(messageArr[i3]) > j) {
                    i2 = i3 - 1;
                    if (i2 >= 0 && iMAPFolder.getUID(messageArr[i2]) < j) {
                        return i2;
                    }
                } else {
                    if (iMAPFolder.getUID(messageArr[i3]) >= j) {
                        return i3 - 1;
                    }
                    i = i3 + 1;
                    if (i == length && iMAPFolder.getUID(messageArr[i]) < j) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }

    /* loaded from: classes10.dex */
    public static class Result {
        long[] delArray;
        long[] newArray;

        public Result(long[] jArr, long[] jArr2) {
            this.newArray = jArr;
            this.delArray = jArr2;
        }
    }

    public static long[] nextUIDArray(IMAPFolder iMAPFolder, long j) throws MessagingException {
        Message[] messages = iMAPFolder.getMessages();
        long[] jArr = new long[0];
        if (messages.length == 0) {
            return jArr;
        }
        int i = 1;
        if (j < 0) {
            int length = messages.length - 1;
            while (length >= 0 && i <= 20) {
                jArr = Basis.insertUID(jArr, iMAPFolder.getUID(messages[length]));
                length--;
                i++;
            }
            return jArr;
        }
        int searchIndex = Basis.searchIndex(iMAPFolder, messages, j);
        while (searchIndex >= 0 && i <= 20) {
            jArr = Basis.insertUID(jArr, iMAPFolder.getUID(messages[searchIndex]));
            searchIndex--;
            i++;
        }
        return jArr;
    }

    public static Result syncUIDArray(IMAPFolder iMAPFolder, long[] jArr) throws MessagingException {
        Message[] messages = iMAPFolder.getMessages();
        int length = jArr.length;
        int length2 = messages.length;
        long[] jArr2 = new long[0];
        long[] jArr3 = new long[0];
        if (length == 0) {
            return new Result(jArr2, jArr3);
        }
        if (length2 == 0) {
            return new Result(jArr2, jArr);
        }
        Arrays.sort(jArr);
        if (length != length2 || jArr[length - 1] != iMAPFolder.getUID(messages[length2 - 1])) {
            long j = jArr[length - 1];
            while (true) {
                length2--;
                long uid = iMAPFolder.getUID(messages[length2]);
                if (uid <= j) {
                    break;
                }
                jArr2 = Basis.insertUID(jArr2, uid);
            }
            for (long j2 : jArr) {
                if (Basis.binarySearch(iMAPFolder, messages, j2) < 0) {
                    jArr3 = Basis.insertUID(jArr3, j2);
                }
            }
        }
        return new Result(jArr2, jArr3);
    }
}
