package ru.push.backend;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DeviceDAO service;

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public String outputAll(ModelMap model) {

        List<RegisteredDevice> list = service.getAll();

        model.addAttribute("message", "All items: " + list.size());
        model.addAttribute("collection", list);

        return "main";
    }

    @RequestMapping(value = "/device/{pushId}", method = RequestMethod.GET)
    public String outputOne(ModelMap model, @PathVariable String pushId) {
        RegisteredDevice[] list = new RegisteredDevice[]{
                service.getDeviceByPushId(pushId)
        };

        model.addAttribute("message", "All items: " + list.length);
        model.addAttribute("collection", list);
        return "main";
    }

    @RequestMapping(value = "/device/page={page}", method = RequestMethod.GET)
    public String outputPage(ModelMap model, @PathVariable int page) {
        List<RegisteredDevice> list = service.getPage(page);

        model.addAttribute("message", "All items: " + DeviceDAO.COUNT_ITEM_PAGE);
        model.addAttribute("collection", list);
        return "main";
    }


    /*
    Auto parse request parameters and SET name-by-name fields to new RegisteredDevice object
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@ModelAttribute @Valid RegisteredDevice devices, BindingResult result) {
        if (!result.hasErrors()) {
            service.addItem(devices);

            logger.info(devices.toString());
            return "registered_success";
        } else
            return "registered_failed";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String reRegister(@ModelAttribute @Valid RegisteredDevice devices, BindingResult result) {
        if (!result.hasErrors()) {
            service.updateItem(devices);
            return "re_registered_success";
        } else
            return "re_registered_failed";
    }

    @RequestMapping(value = "/delete/{pushId}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteItem(@PathVariable String pushId) {
        service.delete(pushId);
        return "";
    }


}