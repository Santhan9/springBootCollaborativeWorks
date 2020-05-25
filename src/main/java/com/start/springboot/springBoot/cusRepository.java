package com.start.springboot.springBoot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class cusRepository {

    public List<cusInfo> cusList = new ArrayList<cusInfo>();


    public void saveCustomer(cusInfo cs) throws ClassNotFoundException {

        dataStorage db= new dataStorage();

        db.storeUserDetails(cs.firstName,cs.lastName,cs.phone,cs.email,cs.password);

        cusList.add(cs);

    }

    public cusInfo validateUser(loginInfo cs) throws ClassNotFoundException {

        dataStorage db= new dataStorage();

       // db.storeUserDetails(cs.firstName,cs.lastName,cs.phone,cs.email,cs.password);

       return db.validateUserDetails(cs.email,cs.password);

       // cusList.add(cs);

    }

    public List<cusInfo> getcustomers(){
        return this.cusList;
    }
}
