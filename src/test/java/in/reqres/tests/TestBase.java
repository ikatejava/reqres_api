package in.reqres.tests;

import com.github.javafaker.Faker;
import in.reqres.models.CorrectRegistrationAndLoginRequestModel;
import in.reqres.models.CreateAndUpdateUserRequestModel;
import in.reqres.models.IncorrectRegistrationRequestModel;
import in.reqres.models.MissingPasswordRegistrationAndLoginRequestModel;

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

    CorrectRegistrationAndLoginRequestModel rightRegAndAuthData =
            new CorrectRegistrationAndLoginRequestModel(user4Email, newPassword);
    MissingPasswordRegistrationAndLoginRequestModel missingPasswordRegAndAuthData =
            new MissingPasswordRegistrationAndLoginRequestModel(user4Email);
    IncorrectRegistrationRequestModel wrongRegAndAuthData =
            new IncorrectRegistrationRequestModel(newUsername, newEmail, newPassword);
}
