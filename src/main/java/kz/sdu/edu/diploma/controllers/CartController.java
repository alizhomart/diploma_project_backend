package kz.sdu.edu.diploma.controllers;


import kz.sdu.edu.diploma.entities.Carts;
import kz.sdu.edu.diploma.entities.Items;
import kz.sdu.edu.diploma.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
@Slf4j
@RequiredArgsConstructor
public class CartController {

    private final ItemService itemService;


//    @PostMapping(value = "/addtocart")
//    public List<Items> addtocart(HttpSession session,
//                                 @RequestParam(name = "itemId")Long itemId){
//        if(session.getAttribute("basket") == null){
//            List<Carts> carts = new ArrayList<>();
//            Items item = itemService.getItem(itemId);
//            Carts cart = new Carts();
//            cart.setCount(1);
//            cart.setPrice(item.getPrice());
//            cart.setItem(item);
//            carts.add(cart);
//            session.setAttribute("basket", carts);
//        }else{
//            List<Carts> carts = (List<Carts>) session.getAttribute("basket");
//            int index = this.exists(itemId, carts);
//            if (index == -1) {
//                Items item = itemService.getItem(itemId);
//                Carts cart = new Carts();
//                cart.setCount(1);
//                cart.setPrice(item.getPrice());
//                cart.setItem(item);
//                carts.add(cart);
//            } else {
//                int count = carts.get(index).getCount() + 1;
//                carts.get(index).setCount(count);
//            }
//            session.setAttribute("basket", carts);
//        }
//        return "redirect:/item-details/"+itemId+".html";
//    }

}
