package com.start.springboot.springBoot;

import org.springframework.stereotype.Component;

@Component
public class cusInfo {

   String firstName;
   String lastName;
   long phone;
    String email;
    String password;

    public cusInfo(String firstName, String lastName, long phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println(this.lastName);
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    public cusInfo(){

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
