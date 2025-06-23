package io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
class QueueDrainSubscriberPad3 extends QueueDrainSubscriberPad2 {
    final AtomicLong requested = new AtomicLong();
}
