import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GetLongRediractionRequest {
    @Test
    public void countRedirectionTest(){
        int responseCode = 0;
        int numberOfHope = 0;
        boolean followMark = false;

        while (responseCode != 200) {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(followMark)
                    .when()
                    .get("https://playground.learnqa.ru/api/long_redirect")
                    .andReturn();
            responseCode = response.getStatusCode();
            numberOfHope++;
            if (responseCode != 200) {
                followMark = true;}
        }
        System.out.println("Number of redirections: " + numberOfHope);
    }
}
