package ro.ebs.internship.alzheimer.entity;

public class User {

    public enum Type {
        PACIENT,
        CARETAKER
    };

    private String username;
    private String password;
    private String name;
    private Type myType;
    private long age;
    private char sex;
    private String address;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public char getSex() {
        return sex;
    }

    public long getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Type getMyType() {
        return myType;
    }

    public void setMyType(Type myType) {
        this.myType = myType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


}
