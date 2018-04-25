package edu.bsuir.controller.notice;

import edu.bsuir.model.Notices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class NoticeList {
    @Value("${url.notices}")
    private String URL_NOTICES;

    @RequestMapping(value = {"/noticesList"}, method = RequestMethod.GET)
    public String noticesList(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Notices[] list = restTemplate.getForObject(URL_NOTICES, Notices[].class);

        model.addAttribute("notices", list);

        return "noticesList";
    }
}
