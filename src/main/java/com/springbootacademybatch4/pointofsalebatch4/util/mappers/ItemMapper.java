package com.springbootacademybatch4.pointofsalebatch4.util.mappers;

import com.springbootacademybatch4.pointofsalebatch4.dto.ItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.dto.request.RequestSaveItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDTOToEntity(RequestSaveItemDTO requestSaveItemDTO);
    List<ItemDTO> entityListToDTOList(List<Item> items);
}