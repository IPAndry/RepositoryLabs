package by.bstu.unittesting.service;


import by.bstu.unittesting.model.LoginModel;

public class LoginField {

    public static final String TESTDATA_SEARCH_NAME = "testdata.item.search";

    public static LoginModel createViaSearch() {
        return new LoginModel(TestDataReader.getTestData(TESTDATA_SEARCH_NAME));
    }

}
