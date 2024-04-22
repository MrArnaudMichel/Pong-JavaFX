package pong.javafxpong.model;

/**
 * The Resizable interface represents an object that can be resized.
 */
public interface Resizable {
    /**
     * Resizes the object's width by the specified factor.
     *
     * @param factor The factor by which to resize the width.
     */
    void resizeWidth(double factor);

    /**
     * Resizes the object's height by the specified factor.
     *
     * @param factor The factor by which to resize the height.
     */
    void resizeHeight(double factor);
}
