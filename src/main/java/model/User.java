package model;

public class User {
    private Integer id;
    private String name;
    private String accountID;
    private String token;
    private Long gmCreate;
    private Long gmModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmCreate() {
        return gmCreate;
    }

    public void setGmCreate(Long gmCreate) {
        this.gmCreate = gmCreate;
    }

    public Long getGmModified() {
        return gmModified;
    }

    public void setGmModified(Long gmModified) {
        this.gmModified = gmModified;
    }
}
