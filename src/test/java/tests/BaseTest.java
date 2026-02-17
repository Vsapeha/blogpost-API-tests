package tests;

import config.ConfigManager;
import customAssertions.HardAssertionEntryPoint;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected HardAssertionEntryPoint assertions = new HardAssertionEntryPoint();

    @BeforeClass
    void setUpEnvironmentsAndGetCredentials() {
        RestAssured.baseURI = ConfigManager.get("base.url");
    }
}
