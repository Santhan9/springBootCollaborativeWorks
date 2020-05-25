package com.start.springboot.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;


@RestController
public class cusControler {

    @Autowired
    private cusRepository cr;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/details")
    public List<cusInfo> getDetails() throws ClassNotFoundException {
        //dataStorage db= new dataStorage();

       //System.out.println( db.validateUserDetails("san","san"));

        return cr.getcustomers();

    }


    @GetMapping("/detail")
    public String getDetail() throws ClassNotFoundException {

       // return Arrays.asList(new cusInfo(123,"santhan",986));

        dataStorage db= new dataStorage();

        System.out.println( db.validateUserDetails("san","san"));

        cusInfo cs = new cusInfo();

        return cs.getFirstName();

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/postAddUser", consumes = "application/json", produces = "application/json")
    public void addMember(@RequestBody cusInfo cus) throws ClassNotFoundException {

        System.out.println(cus.lastName);

        System.out.println(cus.firstName);


        cr.saveCustomer(cus);

        //return "OK";

        //System.out.println(cus.cusId);
      // cusInfo cs = new cusInfo(cus.cusId,cus.cusName,cus.phone);



    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/postValidateUser", consumes = "application/json", produces = "application/json")
    public cusInfo validateUser(@RequestBody loginInfo cus) throws ClassNotFoundException {

        System.out.println(cus.email);

        System.out.println(cus.password);


       return cr.validateUser(cus);



        //return "OK";

        //System.out.println(cus.cusId);
        // cusInfo cs = new cusInfo(cus.cusId,cus.cusName,cus.phone);



    }


}
