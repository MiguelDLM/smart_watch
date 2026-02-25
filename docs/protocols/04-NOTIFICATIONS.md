# 04 - Notification Forwarding Protocol

**Scope:** Binary encoding and delivery flow for push notifications forwarded
from the Android host to the smartwatch over BLE.

**Source package:** `com.szabh.smable3.entity`

---

## Table of Contents

1. [Overview](#1-overview)
2. [BleTime Encoding](#2-bletime-encoding)
3. [BleNotification (0x0401)](#3-blenotification-0x0401)
4. [BleNotification2 (0x0407)](#4-blenotification2-0x0407)
5. [Notification Categories](#5-notification-categories)
6. [App Package Constants](#6-app-package-constants)
7. [Notification Push Flow](#7-notification-push-flow)
8. [Field Encoding Rules](#8-field-encoding-rules)
9. [Implementation Notes](#9-implementation-notes)

---

## 1. Overview

Notifications originating on the Android phone are captured by a
`NotificationListenerService`, serialized into a fixed-layout binary structure,
and sent to the watch using `BleKeyFlag.UPDATE` on either `BleKey.NOTIFICATION`
(0x0401) or `BleKey.NOTIFICATION2` (0x0407).

Two entity variants exist:

| Entity            | BleKey       | Use case                                    |
|-------------------|--------------|---------------------------------------------|
| `BleNotification` | `0x0401`     | Standard notifications (message, app alert) |
| `BleNotification2`| `0x0407`     | Notifications that also carry a phone number (e.g., incoming calls) |

Both share the same base layout; `BleNotification2` appends an additional
32-byte phone number field.

---

## 2. BleTime Encoding

`BleTime` is a 7-byte timestamp structure embedded inside notification payloads.
It encodes wall-clock time using individual bytes for each component.

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleTime.java`
(referenced by both notification entities)

### Byte Layout

| Offset | Size | Type  | Field   | Description                                    |
|--------|------|-------|---------|------------------------------------------------|
| 0      | 1    | uint8 | year    | Year minus 2000 (e.g., `25` represents 2025)  |
| 1      | 1    | uint8 | month   | Month of year, 1-12                            |
| 2      | 1    | uint8 | day     | Day of month, 1-31                             |
| 3      | 1    | uint8 | hour    | Hour of day, 0-23                              |
| 4      | 1    | uint8 | minute  | Minute of hour, 0-59                           |
| 5      | 1    | uint8 | second  | Second of minute, 0-59                         |
| 6      | 1    | uint8 | weekday | Day of week: `0` = Sunday ... `6` = Saturday   |

### Encode Example

```
// 2025-07-04 14:30:00, Friday
bytes = [25, 7, 4, 14, 30, 0, 5]
//        ^year-2000  ^hour ^sec ^weekday(Fri=5)
```

### Decode Pseudocode

```
year    = buffer.get() & 0xFF  // add 2000 to get full year
month   = buffer.get() & 0xFF
day     = buffer.get() & 0xFF
hour    = buffer.get() & 0xFF
minute  = buffer.get() & 0xFF
second  = buffer.get() & 0xFF
weekday = buffer.get() & 0xFF  // 0=Sunday, 6=Saturday
```

---

## 3. BleNotification (0x0401)

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleNotification.java`

| Attribute  | Value                    |
|------------|--------------------------|
| BleKey     | `NOTIFICATION 0x0401`    |
| Direction  | Phone -> Watch           |
| Flag       | `BleKeyFlag.UPDATE`      |

### Byte Layout

| Offset | Size | Type    | Field     | Description                                                  |
|--------|------|---------|-----------|--------------------------------------------------------------|
| 0      | 1    | int8    | mCategory | Notification category code (see [Section 5](#5-notification-categories)) |
| 1      | 7    | BleTime | mTime     | Notification timestamp (see [Section 2](#2-bletime-encoding)) |
| 8      | 32   | bytes   | mPackage  | App package name, UTF-8, zero-padded to 32 bytes             |
| 40     | 32   | bytes   | mTitle    | Notification title, UTF-8, truncated and zero-padded to 32 bytes |
| 72     | 250  | bytes   | mContent  | Notification body text, UTF-8, truncated and zero-padded to 250 bytes |

**Total payload size: 322 bytes**

### Field Details

#### mCategory (offset 0, 1 byte)

Signed byte identifying the notification type. The watch uses this value to
select the appropriate icon and ringtone. See [Section 5](#5-notification-categories)
for all defined values.

#### mTime (offsets 1-7, 7 bytes)

Embedded `BleTime` structure representing the moment the notification was
generated. See [Section 2](#2-bletime-encoding) for field layout.

#### mPackage (offsets 8-39, 32 bytes)

The Android package name of the source application (e.g.,
`com.whatsapp`). Encoded as UTF-8, padded with null bytes (`0x00`) to fill the
32-byte field. If the package name exceeds 31 characters it is truncated at
byte 31 and the 32nd byte is set to `0x00` (null-terminated).

#### mTitle (offsets 40-71, 32 bytes)

Notification title string. UTF-8 encoded, null-padded to 32 bytes. Truncated at
31 characters if longer. The watch typically renders this as a header line.

#### mContent (offsets 72-321, 250 bytes)

Notification body / detail text. UTF-8 encoded, null-padded to 250 bytes.
Truncated at 249 characters if longer. The watch may scroll this text if it
exceeds display width.

### Encode Pseudocode

```
buf = new byte[322]
buf[0] = (byte) mCategory
encodeTime(buf, 1, mTime)                    // 7 bytes at offset 1
writeFixedUtf8(buf, 8,  mPackage, 32)        // truncate + null-pad to 32 bytes
writeFixedUtf8(buf, 40, mTitle,   32)        // truncate + null-pad to 32 bytes
writeFixedUtf8(buf, 72, mContent, 250)       // truncate + null-pad to 250 bytes

function writeFixedUtf8(buf, offset, str, maxLen):
    bytes = str.getBytes("UTF-8")
    n = min(bytes.length, maxLen - 1)        // reserve last byte for null terminator
    System.arraycopy(bytes, 0, buf, offset, n)
    buf[offset + n ... offset + maxLen - 1] = 0x00  // zero-fill remainder
```

---

## 4. BleNotification2 (0x0407)

**Source:** `decompiled_apk/sources/com/szabh/smable3/entity/BleNotification2.java`

| Attribute  | Value                     |
|------------|---------------------------|
| BleKey     | `NOTIFICATION2 0x0407`    |
| Direction  | Phone -> Watch            |
| Flag       | `BleKeyFlag.UPDATE`       |

`BleNotification2` extends `BleNotification` by appending a phone number field.
All fields from `BleNotification` are present at the same offsets.

### Byte Layout

All fields from `BleNotification` at offsets 0-321, followed by:

| Offset | Size | Type  | Field  | Description                                                   |
|--------|------|-------|--------|---------------------------------------------------------------|
| 322    | 32   | bytes | mPhone | Phone number string, UTF-8, zero-padded to 32 bytes           |

**Total payload size: 354 bytes**

### mPhone Field (offset 322, 32 bytes)

The phone number associated with the notification (primarily used for incoming
calls). UTF-8 encoded, null-padded to 32 bytes. International format is
recommended (e.g., `+15551234567`) but the field accepts any string up to 31
characters.

### Encode Pseudocode

```
buf = new byte[354]
// ... encode all BleNotification fields into buf[0..321] as above ...
writeFixedUtf8(buf, 322, mPhone, 32)         // truncate + null-pad to 32 bytes
```

### When to Use BleNotification2 vs BleNotification

| Condition                             | Entity to use      |
|---------------------------------------|--------------------|
| Notification has an associated phone number (e.g., incoming call) | `BleNotification2` (0x0407) |
| Standard app notification (message, social, etc.)                  | `BleNotification` (0x0401)  |

---

## 5. Notification Categories

The `mCategory` field (int8 at offset 0) tells the watch how to handle and
display the notification.

| Name          | Value | Description                                        |
|---------------|-------|----------------------------------------------------|
| INCOMING_CALL | 1     | Incoming phone call; watch may ring or vibrate     |
| MESSAGE       | 127   | Generic message / chat notification                |

### Category Assignment Logic

The host app inspects the source package name and maps it to a category:

- If the package matches a known messaging/social app (see [Section 6](#6-app-package-constants)),
  the corresponding category is set.
- `INCOMING_CALL` (1) is used when the phone is receiving a call and a phone
  number is available; `BleNotification2` should be used in this case.
- `MESSAGE` (127) is the fallback category for notifications from recognized
  messaging apps or apps with no specific category mapping.
- Numeric category values beyond the two defined above may exist in firmware
  but are undocumented in the decompiled sources.

---

## 6. App Package Constants

The following package name constants are defined in the source and used to
identify notification sources for category mapping and icon selection on the
watch.

| Constant           | Package Name                        |
|--------------------|-------------------------------------|
| PACKAGE_WHATSAPP   | `com.whatsapp`                      |
| PACKAGE_FACEBOOK   | `com.facebook.katana`               |
| PACKAGE_MESSENGER  | `com.facebook.orca`                 |
| PACKAGE_INSTAGRAM  | `com.instagram.android`             |
| PACKAGE_TELEGRAM   | `org.telegram.messenger`            |
| PACKAGE_LINE       | `jp.naver.line.android`             |
| PACKAGE_WECHAT     | `com.tencent.mm`                    |
| PACKAGE_QQ         | `com.tencent.mobileqq`              |
| PACKAGE_TWITTER    | `com.twitter.android`               |
| PACKAGE_SKYPE      | `com.skype.raider`                  |
| PACKAGE_VIBER      | `com.viber.voip`                    |
| PACKAGE_LINKEDIN   | `com.linkedin.android`              |
| PACKAGE_SNAPCHAT   | `com.snapchat.android`              |
| PACKAGE_DISCORD    | `com.discord`                       |
| PACKAGE_TIKTOK     | `com.zhiliaoapp.musically`          |
| PACKAGE_YOUTUBE    | `com.google.android.youtube`        |
| PACKAGE_NETFLIX    | `com.netflix.mediaclient`           |
| PACKAGE_KAKAOTALK  | `com.kakao.talk`                    |
| PACKAGE_GMAIL      | `com.google.android.gm`             |

These strings are written verbatim into `mPackage` (zero-padded to 32 bytes)
so the watch firmware can match them against its internal icon table.

---

## 7. Notification Push Flow

```
Android Phone                               Smartwatch
      |                                           |
      | [NotificationListenerService fires]       |
      |                                           |
      | 1. Capture notification:                  |
      |    - package name                         |
      |    - title / content                      |
      |    - post time                            |
      |                                           |
      | 2. Map package -> category                |
      |    - Look up PACKAGE_* constants          |
      |    - Assign mCategory value               |
      |                                           |
      | 3. Determine entity variant:              |
      |    - Has phone number? -> BleNotification2|
      |    - Otherwise         -> BleNotification |
      |                                           |
      | 4. Construct binary payload:              |
      |    - Fill all fixed-width fields          |
      |    - Truncate strings at field limits     |
      |    - Zero-pad remaining bytes             |
      |                                           |
      |--- BleKey(0x0401 or 0x0407, UPDATE) ----->|
      |    [322 or 354 bytes]                     |
      |                                           |
      |            [Watch receives payload]       |
      |            [Parses category, title,       |
      |             content, package]             |
      |            [Displays notification with    |
      |             appropriate icon / vibration] |
```

### Step-by-Step

1. **Capture:** `NotificationListenerService.onNotificationPosted()` fires with
   a `StatusBarNotification` object.
2. **Filter:** Optionally filter out notifications the user has muted or the
   app has blacklisted.
3. **Map:** Extract `packageName` from the notification; compare against
   `PACKAGE_*` constants to determine `mCategory`.
4. **Timestamp:** Populate `mTime` using the notification's post time converted
   to wall-clock components.
5. **Serialize:** Write the 322- or 354-byte payload as described in
   [Section 3](#3-blenotification-0x0401) or [Section 4](#4-blenotification2-0x0407).
6. **Send:** Transmit via the BLE characteristic associated with
   `BleKey.NOTIFICATION` or `BleKey.NOTIFICATION2` with flag `BleKeyFlag.UPDATE`.
7. **Display:** The watch firmware parses the payload and renders the
   notification, typically showing `mTitle` on one line and up to N characters
   of `mContent` on subsequent lines, with an icon derived from `mCategory`.

---

## 8. Field Encoding Rules

### String Fields (mPackage, mTitle, mContent, mPhone)

All string fields follow the same encoding contract:

1. Convert the Java `String` to a `byte[]` using UTF-8 encoding.
2. If the byte array is longer than `maxLen - 1`, truncate to `maxLen - 1` bytes.
   Take care not to split a multi-byte UTF-8 sequence in the middle.
3. Copy the bytes into the destination buffer at the correct offset.
4. Zero-fill all remaining bytes in the fixed-width field (null-termination +
   padding).

```
function writeFixedUtf8(destBuf, offset, string, maxLen):
    if string is null or empty:
        fill destBuf[offset .. offset+maxLen] with 0x00
        return
    raw = string.toByteArray(charset = UTF-8)
    n   = min(raw.length, maxLen - 1)
    // ensure we do not split a multi-byte sequence
    while n > 0 and (raw[n] & 0xC0) == 0x80:
        n -= 1
    copy raw[0..n] to destBuf[offset .. offset+n]
    fill destBuf[offset+n .. offset+maxLen] with 0x00
```

### mCategory (int8)

Write as a single signed byte. Values 1 and 127 are the only confirmed values;
other values are passed through as-is.

### mTime (BleTime, 7 bytes)

```
buf[offset + 0] = (year  - 2000) & 0xFF
buf[offset + 1] = month  & 0xFF       // 1-12
buf[offset + 2] = day    & 0xFF       // 1-31
buf[offset + 3] = hour   & 0xFF       // 0-23
buf[offset + 4] = minute & 0xFF       // 0-59
buf[offset + 5] = second & 0xFF       // 0-59
buf[offset + 6] = weekday & 0xFF      // 0=Sun, 6=Sat
```

---

## 9. Implementation Notes

### Re-implementing the NotificationListenerService

A reimplementation should:

1. Extend `android.service.notification.NotificationListenerService`.
2. Declare the service in `AndroidManifest.xml` with
   `android.permission.BIND_NOTIFICATION_LISTENER_SERVICE`.
3. In `onNotificationPosted`, extract:
   - `sbn.getPackageName()` -> `mPackage`
   - `notification.extras.getString(Notification.EXTRA_TITLE)` -> `mTitle`
   - `notification.extras.getString(Notification.EXTRA_TEXT)` -> `mContent`
   - `notification.`when`` or `System.currentTimeMillis()` -> `mTime`
4. Determine `mCategory` by comparing the package name against the constants in
   [Section 6](#6-app-package-constants).
5. If the category is `INCOMING_CALL` (1) and a phone number is available,
   construct `BleNotification2` (0x0407); otherwise use `BleNotification`
   (0x0401).

### Watch-Side Rendering

- The watch selects a notification icon based on `mCategory`.
- `mPackage` may be used by more capable firmware versions for finer-grained
  icon selection beyond the category code alone.
- `mTitle` and `mContent` display lengths depend on the watch's screen
  resolution and font size. The 32-byte and 250-byte maximums are the
  protocol limits, not the display limits.

### Byte Order

All fields in these notification structures are single bytes or byte arrays.
There are no multi-byte integer fields (unlike health data entities). Byte order
is therefore not a concern for this protocol.

### Null Termination

Fixed-width string fields are null-terminated within the field boundary.
Implementations must not rely on the final byte being `0x00` if the string
exactly fills `maxLen - 1` bytes — the encode step guarantees the terminator,
but defensive reads should scan up to `maxLen` bytes and stop at the first
`0x00`.

---

*End of document.*
