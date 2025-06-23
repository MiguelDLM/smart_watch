package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;

/* loaded from: classes8.dex */
public class GameRequestValidation {
    public static void validate(GameRequestContent content) {
        boolean z;
        boolean z2;
        Validate.notNull(content.getMessage(), "message");
        int i = 0;
        if (content.getObjectId() != null) {
            z = true;
        } else {
            z = false;
        }
        if (content.getActionType() != GameRequestContent.ActionType.ASKFOR && content.getActionType() != GameRequestContent.ActionType.SEND) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!(z ^ z2)) {
            if (content.getRecipients() != null) {
                i = 1;
            }
            if (content.getSuggestions() != null) {
                i++;
            }
            if (content.getFilters() != null) {
                i++;
            }
            if (i <= 1) {
                return;
            } else {
                throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
            }
        }
        throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
    }
}
