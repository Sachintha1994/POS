package com.springbootacademybatch4.pointofsalebatch4.service;

import com.springbootacademybatch4.pointofsalebatch4.dto.ItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.dto.request.RequestSaveItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    void addItem(RequestSaveItemDTO requestSaveItemDTO);

    List<ItemDTO> getItemByName(String itemName);
}
