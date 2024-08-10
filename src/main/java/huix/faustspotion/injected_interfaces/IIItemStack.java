package huix.faustspotion.injected_interfaces;

public interface IIItemStack {

    default void decreaseSize(int value) {
        return;
    }
}
