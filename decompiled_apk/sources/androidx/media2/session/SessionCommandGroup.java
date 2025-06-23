package androidx.media2.session;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class SessionCommandGroup implements VersionedParcelable {
    private static final String TAG = "SessionCommandGroup";
    Set<SessionCommand> mCommands;

    public SessionCommandGroup() {
        this.mCommands = new HashSet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionCommandGroup)) {
            return false;
        }
        SessionCommandGroup sessionCommandGroup = (SessionCommandGroup) obj;
        Set<SessionCommand> set = this.mCommands;
        if (set == null) {
            if (sessionCommandGroup.mCommands == null) {
                return true;
            }
            return false;
        }
        return set.equals(sessionCommandGroup.mCommands);
    }

    @NonNull
    public Set<SessionCommand> getCommands() {
        return new HashSet(this.mCommands);
    }

    public boolean hasCommand(@NonNull SessionCommand sessionCommand) {
        if (sessionCommand != null) {
            return this.mCommands.contains(sessionCommand);
        }
        throw new NullPointerException("command shouldn't be null");
    }

    public int hashCode() {
        return ObjectsCompat.hashCode(this.mCommands);
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private Set<SessionCommand> mCommands;

        public Builder() {
            this.mCommands = new HashSet();
        }

        private void addCommands(int i, SparseArray<List<Integer>> sparseArray) {
            for (int i2 = 0; i2 < sparseArray.size() && sparseArray.keyAt(i2) <= i; i2++) {
                Iterator<Integer> it = sparseArray.valueAt(i2).iterator();
                while (it.hasNext()) {
                    addCommand(new SessionCommand(it.next().intValue()));
                }
            }
        }

        @NonNull
        public Builder addAllLibraryCommands(int i) {
            addCommands(i, SessionCommand.VERSION_LIBRARY_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllPlayerBasicCommands(int i) {
            addCommands(i, SessionCommand.VERSION_PLAYER_BASIC_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllPlayerCommands(int i) {
            addAllPlayerBasicCommands(i);
            addAllPlayerPlaylistCommands(i);
            return this;
        }

        @NonNull
        public Builder addAllPlayerPlaylistCommands(int i) {
            addCommands(i, SessionCommand.VERSION_PLAYER_PLAYLIST_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllPredefinedCommands(int i) {
            if (i >= 1 && i <= 2) {
                addAllPlayerCommands(i);
                addAllVolumeCommands(i);
                addAllSessionCommands(i);
                addAllLibraryCommands(i);
                return this;
            }
            throw new IllegalArgumentException("Unknown command version " + i);
        }

        @NonNull
        public Builder addAllSessionCommands(int i) {
            addCommands(i, SessionCommand.VERSION_SESSION_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addAllVolumeCommands(int i) {
            addCommands(i, SessionCommand.VERSION_VOLUME_COMMANDS_MAP);
            return this;
        }

        @NonNull
        public Builder addCommand(@NonNull SessionCommand sessionCommand) {
            if (sessionCommand != null) {
                this.mCommands.add(sessionCommand);
                return this;
            }
            throw new NullPointerException("command shouldn't be null");
        }

        @NonNull
        public SessionCommandGroup build() {
            return new SessionCommandGroup(this.mCommands);
        }

        @NonNull
        public Builder removeCommand(@NonNull SessionCommand sessionCommand) {
            if (sessionCommand != null) {
                this.mCommands.remove(sessionCommand);
                return this;
            }
            throw new NullPointerException("command shouldn't be null");
        }

        public Builder(@NonNull SessionCommandGroup sessionCommandGroup) {
            if (sessionCommandGroup != null) {
                this.mCommands = sessionCommandGroup.getCommands();
                return;
            }
            throw new NullPointerException("commandGroup shouldn't be null");
        }
    }

    public SessionCommandGroup(@Nullable Collection<SessionCommand> collection) {
        HashSet hashSet = new HashSet();
        this.mCommands = hashSet;
        if (collection != null) {
            hashSet.addAll(collection);
        }
    }

    public boolean hasCommand(int i) {
        if (i != 0) {
            Iterator<SessionCommand> it = this.mCommands.iterator();
            while (it.hasNext()) {
                if (it.next().getCommandCode() == i) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalArgumentException("Use hasCommand(Command) for custom command");
    }
}
