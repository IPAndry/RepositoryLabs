package framework.service;

import framework.model.LoginModel;

public class LoginField {

    public static final String TESTDATA_SEARCH_NAME = "testdata.item.search";

    public static LoginModel createViaSearch() {
        return new LoginModel(TestDataReader.getTestData(TESTDATA_SEARCH_NAME));
    }

}
