package model.descriptors;

import org.jetbrains.annotations.NotNull;

public class HeadDescriptor extends Descriptor {

    public HeadDescriptor() {
    }

    public HeadDescriptor(int[] headIndex) {
        super(headIndex);
    }

    public HeadDescriptor(@NotNull HeadDescriptor other) {
        this(other.indexs);
    }

    @Override
    public String toString() {
        return "Head: " + getId();
    }
}
