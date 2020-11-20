import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface Environment extends Config {

    @DefaultValue("https://github.com/sergeynedaikhleb")
    @Key("url")
    String myUrl();

    @DefaultValue("sergey.nedaikhleb@i.ua")
    String login();

    @DefaultValue("testEnvironment")
    String password();

    @Key("name")
    @DefaultValue("sergeynedaikhleb")
    String accountOwner();

    Environment testEnvironment = ConfigFactory.create(Environment.class);
    // Environment BASE_CONFIG = ConfigFactory.create(Environment.class, System.getenv(), System.getProperties());
}
