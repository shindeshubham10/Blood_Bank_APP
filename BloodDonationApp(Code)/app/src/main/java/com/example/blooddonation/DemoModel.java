package com.example.blooddonation;

public class DemoModel {


     /*String City, Name ;*/

     String Blood_Grp, City, Full_Name, Locality, Phone, Reason ;

    public DemoModel() {
    }

    public DemoModel(String blood_Grp, String city, String full_Name, String locality, String phone, String reason) {
        Blood_Grp = blood_Grp;
        City = city;
        Full_Name = full_Name;
        Locality = locality;
        Phone = phone;
        Reason = reason;
    }

    public String getBlood_Grp() {
        return Blood_Grp;
    }

    public void setBlood_Grp(String blood_Grp) {
        Blood_Grp = blood_Grp;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

/*public DemoModel() {
    }

    public DemoModel(String city, String name) {
        City = city;
        Name = name;
    }


    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }*/
}
