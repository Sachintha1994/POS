package com.springbootacademybatch4.pointofsalebatch4.controller;


import com.springbootacademybatch4.pointofsalebatch4.dto.CustomerDTO;
import com.springbootacademybatch4.pointofsalebatch4.dto.ItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.dto.request.RequestSaveItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody RequestSaveItemDTO requestSaveItemDTO){
        itemService.addItem(requestSaveItemDTO);
        return "saved";
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )                                                 // with giving parameters
    public List<ItemDTO> getItemByName(@RequestParam(value = "name") String itemName){
        List<ItemDTO> itemDTO = itemService.getItemByName(itemName);
        return itemDTO;
    }
}
