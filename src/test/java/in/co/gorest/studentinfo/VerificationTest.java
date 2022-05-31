package in.co.gorest.studentinfo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class VerificationTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1.Total records are 20
    @Test
    public void test001() {
        int totalRecords = response.extract().path("records.size");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Total records = " + totalRecords);
        System.out.println("------------------End of Test---------------------------");
    }

    //2.id 2492 has name = "Fr. Gatik Ahluwalia"
    @Test
    public void test002() {
        String name = response.extract().path("[2].name");
        int idNo = response.extract().path("[2].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + idNo + " has name = " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    //3.id 2483 has email = "birjesh_acharya@brown.net"
    @Test
    public void test003() {
        String email = response.extract().path("[1].email");
        int idNo = response.extract().path("[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + idNo + "has email = " + email);
        System.out.println("------------------End of Test---------------------------");
    }

    //4.All ID has status = "active"
    @Test
    public void test004() {
        ArrayList<String> list = response.extract().path("findAll{it.status=='active'}.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All id whose status is active =" + list);
        System.out.println("------------------End of Test---------------------------");
    }

    //5.id 2472 has gender = "female"
    @Test
    public void test005() {
        String gender = response.extract().path("[1].gender");
        int id = response.extract().path("[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id " + id + " has gender =" + gender);
        System.out.println("------------------End of Test---------------------------");
    }

    //6.id 2471 has gender = "male"
    @Test
    public void test006() {
        ArrayList<String> arrayList = response.extract().path("findAll{it.gender=='male'}.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the ids whose gender is male = " + arrayList);
        System.out.println("------------------End of Test---------------------------");
    }

}


