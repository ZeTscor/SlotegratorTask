package ui.config;


import org.aeonbits.owner.Config;


@org.aeonbits.owner.Config.Sources({
        "classpath:ui.properties"
})

public interface UiConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("clearCookies")
    @DefaultValue("true")
    Boolean clearCookies();


    @Key("implicitWait")
    @DefaultValue("10")
    Integer implicitWait();

    @Key("explicitWait")
    @DefaultValue("15")
    int explicitWait();

}
