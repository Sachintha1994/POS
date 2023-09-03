package com.springbootacademybatch4.pointofsalebatch4.service.impl;

import com.springbootacademybatch4.pointofsalebatch4.dto.ItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.dto.request.RequestSaveItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.entity.Item;
import com.springbootacademybatch4.pointofsalebatch4.repo.ItemRepo;
import com.springbootacademybatch4.pointofsalebatch4.service.ItemService;
import com.springbootacademybatch4.pointofsalebatch4.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void addItem(RequestSaveItemDTO requestSaveItemDTO) {
        Item item = itemMapper.requestDTOToEntity(requestSaveItemDTO);
        item.setActiveState(false);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
        }
    }

    @Override
    public List<ItemDTO> getItemByName(String  itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,false);
        List<ItemDTO> itemDTOS = itemMapper.entityListToDTOList(items);
        return itemDTOS;
    }
}
