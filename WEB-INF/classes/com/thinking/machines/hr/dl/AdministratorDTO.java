package com.thinking.machines.hr.dl;

public class AdministratorDTO implements java.io.Serializable, Comparable<AdministratorDTO>{
    private String username;
    private String password;
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
    public int compareTo(AdministratorDTO other) {
        return this.username.compareTo(other.getUsername());
    }
    public boolean equals(Object other) {
        if(!(other instanceof AdministratorDTO)) return false;
        AdministratorDTO obj = (AdministratorDTO) other;
        return this.username.equalsIgnoreCase(obj.getUsername());
    }
    public int hashCode(){
        return this.username.hashCode();
    }
}
