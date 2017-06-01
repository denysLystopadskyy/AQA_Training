package pages;

/**
 * Created by denys.lystopadskyy on 6/1/2017.
 */
public interface LoadableComponentGLVersion {

    default <T extends BasePage> T get() {
        try {
            isLoaded();
            return (T) this;
        } catch (Error e) {
            load();
        }

        isLoaded();

        return (T) this;
    }

    void load();

    void isLoaded() throws Error;

}
