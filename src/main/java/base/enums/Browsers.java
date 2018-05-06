package base.enums;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package base.
 */
public enum Browsers {

    FIREFOX("firefox"),
    CHROME("chrome");

    private String name;

    Browsers(String name) {
        this.name = name;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName() {
        return name;
    }
}
