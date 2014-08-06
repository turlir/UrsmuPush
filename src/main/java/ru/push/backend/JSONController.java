package ru.push.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JSONController {


    @Autowired
    private DeviceDAO service;

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*")
    public
    @ResponseBody
    RegisteredDevice getShopInJSON() {
        RegisteredDevice expected = new RegisteredDevice();
        expected.setPushId("fhth456484t89h4");
        expected.setFaculty("FGZV");
        expected.setGroupName("TTPV-11");

        return expected;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=*")
    public
    @ResponseBody
    java.util.List<RegisteredDevice> getAll() {
        return service.getAll();
    }
}
