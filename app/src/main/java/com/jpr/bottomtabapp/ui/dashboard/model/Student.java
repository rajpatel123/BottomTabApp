package com.jpr.bottomtabapp.ui.dashboard.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Student {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("email")
@Expose
private String email;
@SerializedName("phone")
@Expose
private String phone;
@SerializedName("address")
@Expose
private String address;

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

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

}

