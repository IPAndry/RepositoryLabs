package framework.model;

public class LoginModel {

    private String name;

    private String search;

    public LoginModel(String testDataSearch){
        this.search = testDataSearch;
    }

    public String getSearch() {
        return search;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
