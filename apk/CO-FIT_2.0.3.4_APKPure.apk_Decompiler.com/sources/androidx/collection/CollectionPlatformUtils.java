package androidx.collection;

import OXOo.OOXIXo;

public final class CollectionPlatformUtils {
    @OOXIXo
    public static final CollectionPlatformUtils INSTANCE = new CollectionPlatformUtils();

    private CollectionPlatformUtils() {
    }

    @OOXIXo
    public final IndexOutOfBoundsException createIndexOutOfBoundsException$collection() {
        return new ArrayIndexOutOfBoundsException();
    }
}
