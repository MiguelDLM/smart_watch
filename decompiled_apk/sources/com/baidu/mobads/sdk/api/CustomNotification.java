package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.bn;
import com.octopus.ad.widget.ScrollClickView;

/* loaded from: classes7.dex */
public class CustomNotification {
    private static String mChannel = "down";

    @DrawableRes
    private static int mSmallIcon = 17301634;
    private NotificationCompat.Style mStyle = new NotificationCompat.DecoratedCustomViewStyle();

    public static void initNotification(@DrawableRes int i, String str) {
        mSmallIcon = i;
        if (!TextUtils.isEmpty(str)) {
            mChannel = str;
        }
    }

    public static void setNotificationChannel(String str) {
        if (!TextUtils.isEmpty(str)) {
            mChannel = str;
        }
    }

    public static void setNotificationIcon(@DrawableRes int i) {
        mSmallIcon = i;
    }

    private void setRemoteViewText(RemoteViews remoteViews, int i, String str) {
        if (remoteViews != null) {
            if (!TextUtils.isEmpty(str)) {
                remoteViews.setTextViewText(i, str);
                remoteViews.setViewVisibility(i, 0);
            } else {
                remoteViews.setViewVisibility(i, 8);
            }
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i, int i2, String str6, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder;
        if (bn.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = ScrollClickView.f19358IIX0o;
            }
            try {
                builder = new NotificationCompat.Builder(context, str);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.left_icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(R.id.content_layout, 0);
            setRemoteViewText(remoteViews, R.id.content_text, str4);
            setRemoteViewText(remoteViews, R.id.content_status, str5);
        }
        if (i >= 0 && i <= 100) {
            int i3 = R.id.progress_bar;
            remoteViews.setProgressBar(i3, 100, i, false);
            remoteViews.setViewVisibility(i3, 0);
        } else {
            remoteViews.setViewVisibility(R.id.progress_bar, 8);
        }
        int i4 = R.id.btn_action;
        remoteViews.setTextViewText(i4, str6);
        remoteViews.setOnClickPendingIntent(i4, pendingIntent);
        return builder.setSmallIcon(i2).setOngoing(false).setTicker(str2).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }

    @TargetApi(16)
    public Notification getNewNotification(Context context, String str, boolean z, Bitmap bitmap, String str2, String str3, int i, boolean z2, String str4, PendingIntent pendingIntent, String str5, PendingIntent pendingIntent2) {
        NotificationCompat.Builder builder;
        if (bn.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            try {
                builder = new NotificationCompat.Builder(context, mChannel);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.baidu_mobads_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.title, str2);
        setRemoteViewText(remoteViews, R.id.desc, str3);
        if (i >= 0 && i <= 100) {
            int i2 = R.id.progress;
            remoteViews.setProgressBar(i2, 100, i, z2);
            remoteViews.setViewVisibility(i2, 0);
        } else {
            remoteViews.setViewVisibility(R.id.progress, 8);
        }
        int i3 = R.id.button1;
        remoteViews.setTextViewText(i3, str4);
        remoteViews.setOnClickPendingIntent(i3, pendingIntent);
        if (TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.button2, 8);
        } else {
            int i4 = R.id.button2;
            remoteViews.setViewVisibility(i4, 0);
            remoteViews.setTextViewText(i4, str5);
            remoteViews.setOnClickPendingIntent(i4, pendingIntent2);
        }
        return builder.setStyle(this.mStyle).setSmallIcon(mSmallIcon).setOngoing(false).setTicker(str).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}
