package in.co.gorest.studentinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {
    @Test
    public void deleteUser() {

        Response response = given()
                .header("Authorization", "Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .header("Content-Type", "application/json")
                .pathParam("id", 5893)
                .when()
                .delete("/users" + "/{id}")
                .then()
                .extract().response();
        response.then().statusCode(204);
        response.prettyPrint();
    }
}



