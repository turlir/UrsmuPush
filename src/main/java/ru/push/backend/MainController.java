package ru.push.backend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.push.backend.models.RegisteredDevice;
import ru.push.backend.services.ServicePattern;

import java.util.List;

@Controller
public class MainController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ServicePattern ursmuAndroidStorage;

    @RequestMapping("/devices")
    public String outputAll(ModelMap model) {
        List<RegisteredDevice> collect = ursmuAndroidStorage.getAll();

        model.addAttribute("message", "All items: " + collect.size());
        model.addAttribute("collection", collect);
        return "main";
    }

}