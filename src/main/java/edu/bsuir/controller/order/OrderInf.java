package edu.bsuir.controller.order;


import edu.bsuir.model.Orders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderInf {
  @Value("${message.error}")
  private String messageError;

  @Value("${url.order}")
  private String URL_ORDER;

  @Value("${url.order.last}")
  private String URL_ORDER_LAST;

  @Value("${url.users.forwarder}")
  private String URL_USERS_FORWARDERS;

  @Value("${url.stocks}")
  private String URL_STOCKS;

  @RequestMapping(value = {"/orderInf/{orderId}"}, method = RequestMethod.GET)
  public String getUser(Model model, @PathVariable("orderId") String orderId) {

    RestTemplate restTemplate = new RestTemplate();

    Orders order = restTemplate.getForObject(URL_ORDER + "/" + orderId, Orders.class);

    model.addAttribute("order", order);

    return "orderInf";
  }
}
