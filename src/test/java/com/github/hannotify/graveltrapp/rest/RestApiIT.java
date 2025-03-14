package com.github.hannotify.graveltrapp.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RestApiIT {
    private String raceId;
    private String driverId;

    @Test
    void testGetDrivers() {
        var jsonPath = given()
                .when().get("http://localhost:9080/gravel-trapp/api/drivers")
                .then().contentType(ContentType.JSON)
                .statusCode(200)
                .body("size()", equalTo(20))
                .extract().jsonPath();

        jsonPath.<String>getList("id").stream().findAny().ifPresent(driverId -> this.driverId = driverId);
    }

    @Test
    void testGetRaces() {
        var jsonPath = given()
                .when().get("http://localhost:9080/gravel-trapp/api/races")
                .then().contentType(ContentType.JSON)
                .statusCode(200)
                .body("size()", equalTo(23))
                .extract().jsonPath();

        jsonPath.<String>getList("id").stream().findAny().ifPresent(raceId -> this.raceId = raceId);
    }

    @Test
    void testGetStandings() {
        given()
                .when().get("http://localhost:9080/gravel-trapp/api/standings")
                .then().contentType(ContentType.JSON)
                .statusCode(200)
                .body("size()", equalTo(20));
    }

    @Test
    void testPostRaceResult() {
        if (raceId == null) {
            testGetRaces();
        }

        if (driverId == null) {
            testGetDrivers();
        }

        assertThat(raceId).isNotNull();
        assertThat(driverId).isNotNull();

        var username = "joep";
        var password = "woof";

        createNewUser(username, password);
        var jwt = login(username, password);

        assertThat(jwt).isNotNull();

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + jwt)
                .body("""
                        {
                            "raceId": "%s",
                            "driverId": "%s",
                            "position": "1",
                            "fastestLap": true
                        }
                        """.formatted(raceId, driverId))
                .when().post("http://localhost:9080/gravel-trapp/api/race-results")
                .then()
                .statusCode(201);
    }

    private void createNewUser(String username, String password) {
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "username": "%s",
                            "password": "%s",
                            "roles": ["admin"]
                        }
                        """.formatted(username, password))
                .when().post("http://localhost:9080/gravel-trapp/api/user")
                .then()
                .statusCode(201);
    }

    private String login(String username, String password) {
        return given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                            "username": "%s",
                            "password": "%s"
                        }
                        """.formatted(username, password))
                .when().post("http://localhost:9080/gravel-trapp/api/user/login")
                .then()
                .statusCode(200)
                .extract().response().body().asString();
    }
}
