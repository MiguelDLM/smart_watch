package com.sma.smartv3.ui.contactpicker;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.AnimRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;
import com.sma.smartv3.co_fit.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class ContactPicker {
    public static final int CHOICE_MODE_MULTIPLE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;
    public static final int LOAD_ASYNC = 0;
    public static final int LOAD_SYNC = 1;

    public static ArrayList<ContactResult> buildResult(List<Contact> selectedContacts) {
        ArrayList<ContactResult> arrayList = new ArrayList<>();
        Iterator<Contact> it = selectedContacts.iterator();
        while (it.hasNext()) {
            arrayList.add(new ContactResult(it.next()));
        }
        return arrayList;
    }

    public static ArrayList<ContactResult> obtainResult(Intent data) {
        return data.getParcelableArrayListExtra("extra_result_selection");
    }

    /* loaded from: classes12.dex */
    public static class Builder implements Serializable {
        protected transient Activity acc;
        protected Integer animationCloseEnter;
        protected Integer animationCloseExit;
        protected Integer animationOpenEnter;
        protected Integer animationOpenExit;
        protected int bubbleColor;
        protected int bubbleTextColor;
        protected transient Fragment frag;
        protected int handleColor;
        protected boolean hideScrollbar;
        protected Integer searchIconColor;
        protected String titleText;
        protected int trackColor;

        @StyleRes
        protected int theme = R.style.ContactPickerTheme;
        protected LimitColumn columnLimit = LimitColumn.NONE;
        protected boolean showTrack = true;
        protected int selectionMode = 0;
        protected int loadingMode = 0;
        protected ArrayList<Long> selectedItems = new ArrayList<>();
        protected int maxSelectCount = 0;

        public Builder(@NonNull Activity act) {
            this.acc = act;
        }

        public Builder bubbleColor(@ColorInt int bubbleColor) {
            this.bubbleColor = bubbleColor;
            return this;
        }

        public Builder bubbleTextColor(@ColorInt int textColor) {
            this.bubbleTextColor = textColor;
            return this;
        }

        public Builder handleColor(@ColorInt int handleColor) {
            this.handleColor = handleColor;
            return this;
        }

        public Builder hideScrollbar(boolean hideScrollbar) {
            this.hideScrollbar = hideScrollbar;
            return this;
        }

        public Builder limitToColumn(LimitColumn limitedColumn) {
            this.columnLimit = limitedColumn;
            return this;
        }

        public Builder searchIconColor(@ColorInt Integer searchIconColor) {
            this.searchIconColor = searchIconColor;
            return this;
        }

        public Builder setActivityAnimations(@AnimRes Integer animationOpenEnter, @AnimRes Integer animationOpenExit, @AnimRes Integer animationCloseEnter, @AnimRes Integer animationCloseExit) {
            this.animationOpenEnter = animationOpenEnter;
            this.animationOpenExit = animationOpenExit;
            this.animationCloseEnter = animationCloseEnter;
            this.animationCloseExit = animationCloseExit;
            return this;
        }

        public Builder setChoiceMode(int selectionMode) {
            this.selectionMode = selectionMode;
            return this;
        }

        public Builder setLoadingType(int loadingMode) {
            this.loadingMode = loadingMode;
            return this;
        }

        public Builder setMaxSelectCount(int maxSelectCount) {
            this.maxSelectCount = maxSelectCount;
            return this;
        }

        public Builder setSelectedContacts(String... selectedContactIDs) {
            this.selectedItems.clear();
            for (String str : selectedContactIDs) {
                this.selectedItems.add(Long.valueOf(Long.parseLong(str)));
            }
            return this;
        }

        public Builder setTitleText(String titleText) {
            this.titleText = titleText;
            return this;
        }

        public void showPickerForResult(int requestCode) {
            if (this.acc != null) {
                Intent intent = new Intent(this.acc, (Class<?>) ContactPickerActivity.class);
                intent.putExtra("builder", this);
                this.acc.startActivityForResult(intent, requestCode);
                Integer num = this.animationOpenEnter;
                if (num != null && this.animationOpenExit != null) {
                    this.acc.overridePendingTransition(num.intValue(), this.animationOpenExit.intValue());
                    return;
                }
                return;
            }
            Fragment fragment = this.frag;
            if (fragment != null) {
                if (fragment.getActivity() != null) {
                    Intent intent2 = new Intent(this.frag.getActivity(), (Class<?>) ContactPickerActivity.class);
                    intent2.putExtra("builder", this);
                    this.frag.startActivityForResult(intent2, requestCode);
                    if (this.animationOpenEnter != null && this.animationOpenExit != null) {
                        this.frag.getActivity().overridePendingTransition(this.animationOpenEnter.intValue(), this.animationOpenExit.intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            throw new RuntimeException("Unable to find a context for intent. Is there a valid activity or fragment passed in the builder?");
        }

        public Builder showTrack(boolean showTrack) {
            this.showTrack = showTrack;
            return this;
        }

        public Builder theme(@StyleRes int theme) {
            this.theme = theme;
            return this;
        }

        public Builder trackColor(@ColorInt int trackColor) {
            this.trackColor = trackColor;
            return this;
        }

        public Builder setSelectedContacts(ArrayList<ContactResult> selectedContacts) {
            this.selectedItems.clear();
            Iterator<ContactResult> it = selectedContacts.iterator();
            while (it.hasNext()) {
                this.selectedItems.add(Long.valueOf(Long.parseLong(it.next().getContactID())));
            }
            return this;
        }

        public Builder(@NonNull Fragment frag) {
            this.frag = frag;
        }
    }
}
