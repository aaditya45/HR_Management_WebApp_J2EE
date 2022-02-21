package com.thinking.machines.hr.beans;

public class AdministratorBean {
    private String username;
    private String password;
    public AdministratorBean(){
        this.username = "";
        this.password = "";
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int compareTo(AdministratorBean other) {
        return this.username.compareTo(other.getUsername());
    }
    public boolean equals(Object other) {
        if(!(other instanceof AdministratorBean)) return false;
        AdministratorBean obj = (AdministratorBean) other;
        return this.username.equalsIgnoreCase(obj.getUsername());
    }
    public int hashCode(){
        return this.username.hashCode();
    }
}
