package edu.bsuir.controller.notice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class NoticeDelete {
    @Value("${url.notice}")
    private String URL_NOTICE;

    @RequestMapping(value = {"/deleteNotice/{noticeId}"}, method = RequestMethod.GET)
    public String deleteNotice(@PathVariable("noticeId") String noticeId) {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(URL_NOTICE + "/" + noticeId);

        System.out.println("Авизация успешно удалёна!");

        return "redirect:/welcome";
    }

}
