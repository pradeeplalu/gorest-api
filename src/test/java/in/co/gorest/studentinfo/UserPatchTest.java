package in.co.gorest.studentinfo;

import in.co.gorest.model.PojoClass;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPatchTest extends TestBase {

    @Test
    public void createNewUser() {
        PojoClass studentPojo = new PojoClass();
        studentPojo.setName("Hary Potter");
        studentPojo.setEmail("HaryPot" + getRandomValue() + "@gmail.com");
        studentPojo.setGender("male");
        studentPojo.setStatus("active");
        Response response = given()
               .header("Content-Type", "application/json")
                .header("Authorization", "Bearer c426452f777927f6e49219f45652a5fd08178e3f873af217a5b982a6fdd15dac")
                .and()
                .body(studentPojo)
                .when()
                .patch("/users/3972")
                .then()
                .extract().response();
        //response.then().statusCode(200);
        response.prettyPrint();

    }
}
