package in.reqres.tests;

import com.github.javafaker.Faker;
import in.reqres.models.CreateAndUpdateUserRequestModel;
import in.reqres.models.RegistrationAndLoginRequestModel;

import static in.reqres.tests.TestData.user4Email;


public class TestBase {

    Faker faker = new Faker();

    String newUserName = faker.name().firstName();
    String newUserJob = faker.job().position();
    CreateAndUpdateUserRequestModel createNewUserRequestBody =
            new CreateAndUpdateUserRequestModel(newUserName, newUserJob);
    CreateAndUpdateUserRequestModel updateUserRequestModel =
            new CreateAndUpdateUserRequestModel(newUserName, "QA Engineer");

    String newUsername = faker.name().username();
    String newEmail = faker.internet().emailAddress();
    String newPassword = faker.internet().password();

    RegistrationAndLoginRequestModel rightRegAndAuthData =
            new RegistrationAndLoginRequestModel(user4Email, newPassword);
    RegistrationAndLoginRequestModel missingPasswordRegAndAuthData =
            new RegistrationAndLoginRequestModel(user4Email);
    RegistrationAndLoginRequestModel wrongRegAndAuthData =
            new RegistrationAndLoginRequestModel(newUsername, newEmail, newPassword);
}

