package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

/* loaded from: classes9.dex */
public class DefaultTrackNameProvider implements TrackNameProvider {
    private final Resources resources;

    public DefaultTrackNameProvider(Resources resources) {
        this.resources = (Resources) Assertions.checkNotNull(resources);
    }

    private String buildAudioChannelString(Format format) {
        int i = format.channelCount;
        if (i != -1 && i >= 1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 6 && i != 7) {
                        if (i != 8) {
                            return this.resources.getString(R.string.exo_track_surround);
                        }
                        return this.resources.getString(R.string.exo_track_surround_7_point_1);
                    }
                    return this.resources.getString(R.string.exo_track_surround_5_point_1);
                }
                return this.resources.getString(R.string.exo_track_stereo);
            }
            return this.resources.getString(R.string.exo_track_mono);
        }
        return "";
    }

    private String buildBitrateString(Format format) {
        int i = format.bitrate;
        if (i == -1) {
            return "";
        }
        return this.resources.getString(R.string.exo_track_bitrate, Float.valueOf(i / 1000000.0f));
    }

    private String buildLabelString(Format format) {
        if (TextUtils.isEmpty(format.label)) {
            return "";
        }
        return format.label;
    }

    private String buildLanguageOrLabelString(Format format) {
        String joinWithSeparator = joinWithSeparator(buildLanguageString(format), buildRoleString(format));
        if (TextUtils.isEmpty(joinWithSeparator)) {
            return buildLabelString(format);
        }
        return joinWithSeparator;
    }

    private String buildLanguageString(Format format) {
        Locale locale;
        String str = format.language;
        if (TextUtils.isEmpty(str) || C.LANGUAGE_UNDETERMINED.equals(str)) {
            return "";
        }
        if (Util.SDK_INT >= 21) {
            locale = Locale.forLanguageTag(str);
        } else {
            locale = new Locale(str);
        }
        Locale defaultDisplayLocale = Util.getDefaultDisplayLocale();
        String displayName = locale.getDisplayName(defaultDisplayLocale);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(defaultDisplayLocale) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String buildResolutionString(Format format) {
        int i = format.width;
        int i2 = format.height;
        if (i != -1 && i2 != -1) {
            return this.resources.getString(R.string.exo_track_resolution, Integer.valueOf(i), Integer.valueOf(i2));
        }
        return "";
    }

    private String buildRoleString(Format format) {
        String str;
        if ((format.roleFlags & 2) != 0) {
            str = this.resources.getString(R.string.exo_track_role_alternate);
        } else {
            str = "";
        }
        if ((format.roleFlags & 4) != 0) {
            str = joinWithSeparator(str, this.resources.getString(R.string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            str = joinWithSeparator(str, this.resources.getString(R.string.exo_track_role_commentary));
        }
        if ((format.roleFlags & 1088) != 0) {
            return joinWithSeparator(str, this.resources.getString(R.string.exo_track_role_closed_captions));
        }
        return str;
    }

    private static int inferPrimaryTrackType(Format format) {
        int trackType = MimeTypes.getTrackType(format.sampleMimeType);
        if (trackType != -1) {
            return trackType;
        }
        if (MimeTypes.getVideoMediaMimeType(format.codecs) != null) {
            return 2;
        }
        if (MimeTypes.getAudioMediaMimeType(format.codecs) != null) {
            return 1;
        }
        if (format.width != -1 || format.height != -1) {
            return 2;
        }
        if (format.channelCount == -1 && format.sampleRate == -1) {
            return -1;
        }
        return 1;
    }

    private String joinWithSeparator(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.resources.getString(R.string.exo_item_list, str, str2);
                }
            }
        }
        return str;
    }

    @Override // com.google.android.exoplayer2.ui.TrackNameProvider
    public String getTrackName(Format format) {
        String buildLanguageOrLabelString;
        int inferPrimaryTrackType = inferPrimaryTrackType(format);
        if (inferPrimaryTrackType == 2) {
            buildLanguageOrLabelString = joinWithSeparator(buildRoleString(format), buildResolutionString(format), buildBitrateString(format));
        } else if (inferPrimaryTrackType == 1) {
            buildLanguageOrLabelString = joinWithSeparator(buildLanguageOrLabelString(format), buildAudioChannelString(format), buildBitrateString(format));
        } else {
            buildLanguageOrLabelString = buildLanguageOrLabelString(format);
        }
        if (buildLanguageOrLabelString.length() == 0) {
            return this.resources.getString(R.string.exo_track_unknown);
        }
        return buildLanguageOrLabelString;
    }
}
