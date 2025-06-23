package com.google.firebase.crashlytics.buildtools.ndk.internal.dwarf;

import java.util.List;

/* loaded from: classes10.dex */
public class DebugAbbrevEntry {
    public final List<Attribute> attributes;
    public final boolean hasChildren;
    public final int number;
    public final DWTag tag;

    /* loaded from: classes10.dex */
    public static class Attribute {
        public final DWForm form;
        public final DWAttribute name;

        public Attribute(int i, int i2) {
            this.name = DWAttribute.fromValue(i);
            this.form = DWForm.fromValue(i2);
        }

        public String toString() {
            return this.name + "\t" + this.form;
        }
    }

    public DebugAbbrevEntry(int i, int i2, boolean z, List<Attribute> list) {
        this.number = i;
        this.tag = DWTag.fromValue(i2);
        this.hasChildren = z;
        this.attributes = list;
    }

    public String toString() {
        String str;
        if (this.hasChildren) {
            str = "[has children]";
        } else {
            str = "[no children]";
        }
        StringBuilder sb = new StringBuilder(this.number + "\t" + this.tag + "\t" + str + "\n");
        for (Attribute attribute : this.attributes) {
            sb.append("  ");
            sb.append(attribute);
            sb.append("\n");
        }
        return sb.toString();
    }
}
