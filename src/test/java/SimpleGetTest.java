import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleGetTest {
    @Test
    public void GetWeatherDetails() {
        RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "Bangalore");
        String responseBody = response.getBody().asString();
        String prettyprint = response.getBody().prettyPrint();
        System.out.println("Responsebody is=>" + responseBody);
        System.out.println(prettyprint);

        int code = response.statusCode();
        System.out.println(code);
        Assert.assertEquals(code /*actual value*/,200 /*Expected value*/,"Successful");
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
    }
}
