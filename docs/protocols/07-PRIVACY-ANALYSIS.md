# 07 — Privacy and Tracking Analysis of the CO-FIT / SMA App

**Status:** Reference document — findings from static analysis of decompiled APK  
**Severity:** Critical  
**Purpose:** Primary motivation for building an open-source alternative

---

## Overview

Static analysis of the decompiled CO-FIT / SMA companion app (Android APK) reveals an
extensive network of embedded tracking SDKs, hardcoded credentials, and data exfiltration
endpoints that collectively constitute a severe privacy violation for any user who installs
the application.

The app transmits voice recordings, GPS movement history, and complete health data to
servers operated by multiple Chinese technology companies, advertising networks, and
third-party AI providers — all without meaningful disclosure or granular user consent.

This document catalogs every finding in full detail. It is the definitive record of why
an open-source, self-hostable alternative is necessary.

---

## Table of Contents

1. [Embedded Tracking and Analytics SDKs](#1-embedded-tracking-and-analytics-sdks)
2. [Hardcoded Credentials and API Keys](#2-hardcoded-credentials-and-api-keys)
3. [Sensitive Data Uploads](#3-sensitive-data-uploads)
4. [Network Endpoints (50+)](#4-network-endpoints-50)
5. [Android Manifest Permissions](#5-android-manifest-permissions)
6. [Privacy Risk Summary](#6-privacy-risk-summary)

---

## 1. Embedded Tracking and Analytics SDKs

Twelve or more distinct third-party SDKs are bundled into the app. Each SDK operates
independently, reporting to its own backend with its own data collection scope. The user
has no ability to opt out of individual SDKs.

---

### 1.1 Tencent Bugly — Crash Reporting and Analytics

**Severity:** High  
**Package:** `com.tencent.bugly`  
**Source:** `decompiled_apk/sources/com/tencent/bugly/`

Bugly is Tencent's crash reporting and application performance monitoring service.
Beyond crash dumps it collects device fingerprint data, OS version, app usage patterns,
and foreground/background state.

**Endpoints contacted:**
- `android.bugly.qq.com`
- `apm.bugly.qq.com`
- `h.trace.qq.com`

**Data collected:**
- Full crash stack traces including memory state
- Device hardware info (model, CPU, RAM)
- App session data and usage patterns

---

### 1.2 Baidu LBS / Yingyan — Location Tracking Service

**Severity:** Critical  
**Package:** `com.baidu.location`, `com.baidu.trace`  
**Source:** `decompiled_apk/sources/com/sma/smartv3/network/BaiDu.java`

The Baidu Yingyan ("Eagle Eye") SDK is a continuous location tracking service designed
to record and replay movement history. The app actively uploads GPS coordinates in
batches to Baidu's servers, creating a persistent movement record tied to a user entity.

**Hardcoded API Key (exposed in source):**
```
qcXtk4qlqB31PI8KK74Sw8k6jQhBlBqH
```

**Endpoints contacted:**
- `yingyan.baidu.com/api/v3/track/addpoints` — batch GPS upload
- `yingyan.baidu.com/api/v3/entity/add` — creates persistent tracking entity
- `api.map.baidu.com` — Baidu Maps API

**Data collected:**
- Precise GPS coordinates with timestamps
- Full movement history and routes
- Location is uploaded even while the watch is worn passively

This is not incidental location access. The `addpoints` API is explicitly designed for
fleet tracking and persistent movement logging. Its presence in a consumer health app is
not a side-effect of a map feature — it is deliberate continuous location surveillance.

---

### 1.3 Alibaba Tanx — Advertising SDK

**Severity:** High  
**Package:** `com.alibaba.sdk.android.oss` and associated ad SDK packages  
**Source:** `decompiled_apk/sources/com/alibaba/`

Tanx is Alibaba's programmatic advertising exchange. The SDK collects device identifiers
to build advertising profiles and transmit them to Alibaba's ad network infrastructure.

**Endpoint contacted:**
- `sdk-config.tanx.com`

**Data collected:**
- Android_ID
- OAID (Open Advertising ID)
- Device model and OS version for audience segmentation

---

### 1.4 ByteDance / Pangolin — Ad Network

**Severity:** High  
**Package:** `com.bytedance.sdk.openadsdk`  
**Source:** `decompiled_apk/sources/com/bytedance/`

ByteDance is the parent company of TikTok. The Pangolin ad SDK is their monetization
platform for third-party Android apps. Embedding this SDK means all health app users
are profiled by ByteDance's advertising systems.

**Endpoints contacted:**
- `i.snssdk.com`
- `is.snssdk.com`

**Data collected:**
- IMEI (device hardware identifier)
- Android_ID
- Device model and configuration for ad profiling

---

### 1.5 Kuaishou / Kwad — Ad Network

**Severity:** High  
**Package:** `com.kwad.sdk`  
**Source:** `decompiled_apk/sources/com/kwad/`

Kuaishou is a major Chinese short-video platform (competitor to TikTok). Their Kwad
advertising SDK collects device identifiers and app usage data for ad targeting.

**Data collected:**
- Device identifiers
- App usage statistics

---

### 1.6 iFlyTek SparkChain — Voice AI and Speech Recognition

**Severity:** Critical  
**Package:** `com.iflytek.sparkchain`  
**Source:** `decompiled_apk/sources/com/iflytek/sparkchain/plugins/search/tools/SearchTool.java`  
**Source:** `decompiled_apk/sources/com/iflytek/sparkchain/plugins/bot/BotUtil.java`

iFlyTek is a Chinese AI company. Their SparkChain SDK handles voice input from the watch
microphone. Voice recordings are transmitted to iFlyTek servers for transcription and
AI processing.

**Hardcoded credentials exposed in source:**
```
appID:     cf714658
apiKey:    d1961748909c404621b9f6dd6b1b18ce
apiSecret: NTE0ZGI3ZDI3ZjYwOWM4OTNlOWY2OWUz
```

**Endpoint contacted:**
- `sparkbot.xf-yun.com`

**Data uploaded:**
- Raw voice recordings from watch microphone
- Transcription requests and results

These credentials are embedded in plaintext in the decompiled source. Anyone who
decompiles the APK can use these keys, impersonating the app or exhausting its quota.

---

### 1.7 Microsoft Cognitive Services — Speech Recognition

**Severity:** High  
**Source:** Voice management code

The app also integrates Microsoft's speech recognition service as a secondary or fallback
transcription provider. Voice audio captured from the watch is uploaded to Microsoft's
cloud infrastructure.

**Data uploaded:**
- Voice audio recordings for speech-to-text processing

---

### 1.8 OpenAI API — Transcription, TTS, and Chat

**Severity:** Critical  
**Source:** `decompiled_apk/sources/com/sma/smartv3/biz/voice/VoiceManager.java`  
**Source:** `decompiled_apk/sources/com/sma/smartv3/biz/voice/DcsTtsPlayer.java`

The app integrates OpenAI's API for three distinct functions: voice transcription, text-
to-speech playback, and chat completions. Voice recordings from the watch microphone are
sent directly to OpenAI's servers.

**Endpoints contacted:**
- `api.openai.com/v1/audio/transcriptions` — voice-to-text
- `api.openai.com/v1/audio/speech` — text-to-speech
- `api.openai.com/v1/chat/completions` — AI chat

**Data uploaded:**
- Voice audio recordings
- Chat prompts and conversation context

---

### 1.9 Facebook SDK

**Severity:** High  
**Package:** `com.facebook.sdk`  
**Source:** `decompiled_apk/sources/com/facebook/`

The Facebook SDK is embedded for event tracking and analytics. It reports app usage
events and device information to Meta's servers regardless of whether the user has a
Facebook account.

**Data collected:**
- App events (screens viewed, features used)
- Device identifiers and OS information

---

### 1.10 WeChat SDK

**Severity:** Medium  
**Package:** `com.tencent.mm.opensdk`  
**Source:** Manifest and SDK integration files

The WeChat SDK (by Tencent) is integrated for social sharing and login functionality.
It establishes a data channel to Tencent's infrastructure.

---

### 1.11 QQ SDK

**Severity:** Medium  
**Package:** `com.tencent.open`, `com.tencent.connect`  
**Source:** Manifest and SDK integration files

Tencent's QQ social platform SDK is embedded alongside WeChat, duplicating the Tencent
data collection surface.

---

### 1.12 Alibaba Cloud / Aliyun Log Service

**Severity:** High  
**Source:** `decompiled_apk/sources/com/aliyun/`

Alibaba Cloud's log service SDK ships telemetry and application logs to Alibaba's
cloud infrastructure in Guangzhou, China.

**Endpoint contacted:**
- `cn-guangzhou.log.aliyuncs.com`

**Data collected:**
- Application logs and diagnostic telemetry
- Potentially includes user action logs

---

## 2. Hardcoded Credentials and API Keys

The following credentials were found embedded in plaintext in the decompiled application
source. Hardcoding credentials in application binaries is a critical security failure:
any user who decompiles the APK obtains full access to these accounts and services.

| Credential | Value | Source File |
|---|---|---|
| Baidu AK | `qcXtk4qlqB31PI8KK74Sw8k6jQhBlBqH` | `BaiDu.java` |
| iFlyTek appID | `cf714658` | `SearchTool.java` |
| iFlyTek apiKey | `d1961748909c404621b9f6dd6b1b18ce` | `SearchTool.java` |
| iFlyTek apiSecret | `NTE0ZGI3ZDI3ZjYwOWM4OTNlOWY2OWUz` | `SearchTool.java` |
| Fitbit client secret | (embedded in resources) | `strings.xml` / resources |
| Strava client secret | (embedded in resources) | `strings.xml` / resources |
| WeChat app secret | (embedded in resources) | `strings.xml` / resources |

**Impact of exposed credentials:**

- The Baidu AK controls access to the Yingyan location tracking service. Anyone holding
  this key can query location history for all users tracked under this account.
- The iFlyTek credentials allow any holder to submit voice requests billed to the app
  developer's account, and potentially access transcription logs.
- The Fitbit and Strava client secrets allow any holder to forge OAuth flows impersonating
  this app, gaining access to users' fitness platform accounts if users have linked them.
- The WeChat app secret allows impersonation of the app in WeChat's OAuth system.

---

## 3. Sensitive Data Uploads

### 3.1 Voice and Audio Recordings

**Severity:** Critical

Voice input captured from the watch microphone is uploaded to three separate cloud
providers in parallel or as fallbacks:

1. **iFlyTek** (`sparkbot.xf-yun.com`) — Chinese AI company
2. **Microsoft Cognitive Services** — Microsoft cloud
3. **OpenAI** (`api.openai.com/v1/audio/transcriptions`) — US AI company

No explicit per-session consent is presented. The user grants microphone permission once
during app setup; after that, all voice interactions are silently transmitted to all three
providers. There is no disclosure that voice data leaves the device at all, let alone
that it is sent to three different international cloud providers.

**Source:** `decompiled_apk/sources/com/sma/smartv3/biz/voice/VoiceManager.java`

---

### 3.2 GPS and Location History

**Severity:** Critical

The Baidu Yingyan integration does not merely request location access — it actively
constructs a persistent movement history. The `entity/add` API creates a named tracking
entity (tied to the device), and `track/addpoints` uploads batches of GPS coordinates
with timestamps to Baidu's servers.

This means Baidu accumulates a complete record of everywhere the user goes, across all
app sessions, stored indefinitely on Baidu's infrastructure.

**Source:** `decompiled_apk/sources/com/sma/smartv3/network/BaiDu.java`

---

### 3.3 Health and Biometric Data

**Severity:** Critical

All health metrics collected by the watch are uploaded to vendor backend servers:

- Heart rate (continuous and spot measurements)
- Blood pressure readings
- Blood oxygen (SpO2)
- Sleep patterns and stages
- Step count and activity data
- Workout sessions

**Endpoints:**
- `api.iot-solution.net/kotlinweb` — primary health data backend
- `api.smawatch.cn` — SMA Watch API
- `ceshi.smawatch.cn` — **test/staging server left active in production builds**

The presence of `ceshi.smawatch.cn` (ceshi = "test" in Chinese) in production code means
health data may be routed to an unsecured development environment with weaker security
controls and data retention policies than a production system.

---

### 3.4 Fitness Platform Data

**Severity:** High

Workout and fitness data is synced to Fitbit and Strava using client secrets hardcoded
in the application. Users who have linked these accounts have their fitness data
transmitted using credentials that are publicly extractable from the APK.

---

### 3.5 Hardware Device Identifiers

**Severity:** High

Multiple SDKs independently collect hardware-level device identifiers. These identifiers
persist across app reinstalls and factory resets (IMEI) or are difficult to rotate:

- **IMEI** — permanent hardware identifier for the device
- **DeviceId** — telephony device identifier
- **SubscriberId** — tied to the SIM card
- **SimSerialNumber** — SIM hardware identifier
- **Android_ID** — software identifier, reset only on factory reset
- **OAID** — Open Advertising ID, Chinese ad ecosystem identifier

Collecting this combination of identifiers creates a persistent cross-app, cross-service
fingerprint that cannot be cleared by the user without replacing hardware.

---

## 4. Network Endpoints (50+)

### Vendor Backends

| Domain | Purpose |
|---|---|
| `api.iot-solution.net` | Primary health data API server |
| `ceshi.smawatch.cn` | Test/staging server — left active in production |
| `api.smawatch.cn` | SMA Watch vendor API |

### AGPS and Satellite Data

| Domain | Purpose |
|---|---|
| `wepodownload.mediatek.com` | MediaTek EPO satellite prediction data |
| `alp.u-blox.com` | u-blox AGNSS data |
| `sma-product.oss-accelerate.aliyuncs.com` | SMA AGPS files via Alibaba Cloud |

### Voice and AI Services

| Domain | Purpose |
|---|---|
| `api.openai.com` | OpenAI transcription, TTS, chat |
| `sparkbot.xf-yun.com` | iFlyTek SparkBot voice AI |
| Microsoft speech endpoints | Microsoft Cognitive Services speech |

### Location Tracking

| Domain | Purpose |
|---|---|
| `yingyan.baidu.com` | Baidu Yingyan continuous location tracking |
| `api.map.baidu.com` | Baidu Maps API |

### Analytics and Advertising

| Domain | Purpose |
|---|---|
| `android.bugly.qq.com` | Tencent Bugly crash reporting |
| `apm.bugly.qq.com` | Tencent APM (app performance monitoring) |
| `h.trace.qq.com` | Tencent analytics trace |
| `i.snssdk.com` | ByteDance / Pangolin ad network |
| `is.snssdk.com` | ByteDance / Pangolin ad network |
| `sdk-config.tanx.com` | Alibaba Tanx advertising SDK config |

### Cloud Logging

| Domain | Purpose |
|---|---|
| `cn-guangzhou.log.aliyuncs.com` | Alibaba Cloud log service (Guangzhou, China) |

### Third-Party Fitness Platforms

| Domain | Purpose |
|---|---|
| `api.fitbit.com` | Fitbit fitness data sync |
| `www.strava.com` | Strava workout sync |

---

## 5. Android Manifest Permissions

**Source:** `decompiled_apk/resources/AndroidManifest.xml`

### High-Risk Permissions

These permissions expose sensitive user data and have no legitimate justification for
a watch companion app beyond the specific features that nominally require them. Many
of these permissions are requested as a bundle, giving the app — and all embedded SDKs —
broad access to device data.

```
ACCESS_FINE_LOCATION          Precise GPS coordinates
ACCESS_COARSE_LOCATION        Approximate location via cell/WiFi
ACCESS_BACKGROUND_LOCATION    Location access when app is closed or in background
READ_CONTACTS                 Full contact list including names, numbers, emails
READ_CALL_LOG                 Complete call history
READ_SMS                      All SMS messages on the device
READ_PHONE_STATE              IMEI, phone number, SIM state, carrier
RECORD_AUDIO                  Microphone — continuous access possible
CAMERA                        Camera access
QUERY_ALL_PACKAGES            Complete list of every app installed on the device
```

The combination of `READ_CONTACTS`, `READ_CALL_LOG`, and `READ_SMS` goes far beyond what
is needed to display notifications on a watch. These permissions grant the app — and by
extension, every embedded SDK — access to the user's complete social graph and
communication history.

`ACCESS_BACKGROUND_LOCATION` ensures location tracking continues when the user is not
actively using the app.

`QUERY_ALL_PACKAGES` allows the app to enumerate every application installed on the
device, which is commonly used for fingerprinting and behavioral profiling.

### Bluetooth Permissions

```
BLUETOOTH
BLUETOOTH_ADMIN
BLUETOOTH_SCAN
BLUETOOTH_CONNECT
BLUETOOTH_ADVERTISE
```

Necessary for watch communication. Bluetooth scanning can also be used as a location
proxy in environments where GPS is unavailable.

### Other Permissions

```
INTERNET
ACCESS_NETWORK_STATE
ACCESS_WIFI_STATE
CHANGE_WIFI_STATE
WRITE_EXTERNAL_STORAGE
READ_EXTERNAL_STORAGE
MANAGE_EXTERNAL_STORAGE
RECEIVE_BOOT_COMPLETED       Starts automatically on device boot
FOREGROUND_SERVICE           Runs persistent background service
SYSTEM_ALERT_WINDOW          Can draw overlays over other apps
REQUEST_INSTALL_PACKAGES     Can install additional APKs
VIBRATE
WAKE_LOCK                    Prevents device from sleeping
```

`RECEIVE_BOOT_COMPLETED` means the app starts automatically every time the device
boots, ensuring background data collection begins without any user action.

`REQUEST_INSTALL_PACKAGES` is particularly dangerous: combined with the network access
permissions, this permission allows the app to silently download and install additional
software.

`SYSTEM_ALERT_WINDOW` allows the app to display UI elements that overlay other apps,
which can be used for phishing overlays on top of banking or authentication screens.

---

## 6. Privacy Risk Summary

The following is a consolidated list of all confirmed privacy violations found in
the decompiled application.

### Finding 1 — 12+ Tracking SDKs Embedded

The app bundles tracking and advertising SDKs from Tencent, Alibaba, ByteDance,
Kuaishou, Baidu, iFlyTek, Facebook, and Microsoft. Each SDK independently collects
device and usage data. The user has no mechanism to disable individual SDKs, and no
disclosure of this SDK inventory is made in the app's privacy policy or store listing.

### Finding 2 — Voice Recordings Sent to 3 Cloud Providers

Voice captured from the watch microphone is transmitted to iFlyTek (China), Microsoft,
and OpenAI. These transmissions occur for every voice interaction. There is no user
notification that audio leaves the device, nor is there any choice of provider.

**Source:** `decompiled_apk/sources/com/sma/smartv3/biz/voice/VoiceManager.java`

### Finding 3 — Continuous Location Tracking via Baidu Yingyan

The Baidu Yingyan SDK maintains a persistent server-side movement record. GPS coordinates
are uploaded in batches. This is not a map or navigation feature — it is a surveillance
infrastructure designed for fleet and asset tracking, repurposed here to track individual
users.

**Source:** `decompiled_apk/sources/com/sma/smartv3/network/BaiDu.java`

### Finding 4 — Complete Health Data Uploaded to Vendor Servers

All biometric data collected by the watch is uploaded to vendor-operated backends. This
includes heart rate, blood pressure, blood oxygen, sleep records, and workout data. Users
have no self-hosting option and no visibility into data retention or deletion policies.

### Finding 5 — Hardcoded API Keys and Secrets in Binary

Seven or more credentials are embedded as plaintext strings in the APK. This includes
a Baidu location tracking API key, iFlyTek voice AI credentials, and OAuth client
secrets for Fitbit, Strava, and WeChat. Any person who decompiles the APK — a
straightforward process — obtains full access to these accounts.

### Finding 6 — Test Server Left Active in Production

The endpoint `ceshi.smawatch.cn` (ceshi = test) is present in production builds
alongside the production API. User health data may be routed to this server, which
is unlikely to have production-grade security, encryption, or data governance controls.

**Source:** `decompiled_apk/sources/com/sma/smartv3/ble/ProductManager.java`

### Finding 7 — Excessive Permission Scope

The app requests READ_CONTACTS, READ_CALL_LOG, READ_SMS, CAMERA, QUERY_ALL_PACKAGES,
and ACCESS_BACKGROUND_LOCATION. This permission set exceeds what any watch companion app
requires. These permissions are available to all embedded SDKs, meaning advertising and
analytics networks gain access to the user's call history, messages, and contact list.

**Source:** `decompiled_apk/resources/AndroidManifest.xml`

### Finding 8 — Hardware Fingerprinting

Five distinct hardware identifiers are collected (IMEI, DeviceId, SubscriberId,
SimSerialNumber, Android_ID). This combination creates a permanent device fingerprint
that persists across app reinstalls and most reset operations.

### Finding 9 — Third-Party Fitness Platforms with Exposed Secrets

Fitbit and Strava integration uses OAuth client secrets that are extractable from the
APK. Any actor who extracts these secrets can impersonate the app in OAuth flows,
potentially gaining unauthorized access to users' fitness platform accounts.

### Finding 10 — ByteDance (TikTok Parent) Receives User Data

The Pangolin ad SDK by ByteDance — the company that operates TikTok — is embedded in a
health app. Device identifiers including IMEI and Android_ID are transmitted to
ByteDance's ad infrastructure. Users of the health app become part of ByteDance's
advertising audience without any disclosure.

---

## Conclusion

The CO-FIT / SMA companion app is not primarily a health and fitness tool. It is an
application that happens to provide watch functionality while simultaneously operating as
a data collection platform for a dozen different commercial and advertising entities.

The data collected — location history, voice recordings, biometrics, hardware identifiers,
contact lists, call logs — is among the most sensitive personal information a device can
hold. It is transmitted to servers in multiple jurisdictions under data governance regimes
that offer users no practical recourse.

An open-source alternative that communicates only with user-controlled infrastructure,
embeds no third-party SDKs, and stores all health data locally is the only solution that
gives users genuine control over their own biometric information.

---

*Source files referenced in this analysis:*

- `decompiled_apk/resources/AndroidManifest.xml`
- `decompiled_apk/sources/com/sma/smartv3/ble/ProductManager.java`
- `decompiled_apk/sources/com/sma/smartv3/network/BaiDu.java`
- `decompiled_apk/sources/com/iflytek/sparkchain/plugins/search/tools/SearchTool.java`
- `decompiled_apk/sources/com/iflytek/sparkchain/plugins/bot/BotUtil.java`
- `decompiled_apk/sources/com/sma/smartv3/biz/voice/VoiceManager.java`
- `decompiled_apk/sources/com/sma/smartv3/biz/voice/DcsTtsPlayer.java`
