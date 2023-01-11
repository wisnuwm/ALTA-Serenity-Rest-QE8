package starter.reqres.StepDef;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
//    @Given("Get list user with page {int}")
//    public void getListUserWithPage(int page) {
//        reqresAPI.getListUsers(page);
//    }
//
//    @When("Send request get list user")
//    public void sendRequestGetListUser() {
//        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
//    }
//
//    @Then("Should return status code {int}")
//    public void shouldReturnStatusCode(int ok) {
//        SerenityRest.then().statusCode(ok);
//    }
//
//    @And("Response body page should be {int}")
//    public void responseBodyPageShouldBe(int page) {
//        SerenityRest.then().body("page",equalTo(page));
//    }

    //scenario 2
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(ReqresAPI.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                    .body("name",equalTo(name))
                    .body("job",equalTo(job));
    }

    //scenario 3
    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJsonWithId(int id) {
        File json = new File(ReqresAPI.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    //scenario 4
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
}
