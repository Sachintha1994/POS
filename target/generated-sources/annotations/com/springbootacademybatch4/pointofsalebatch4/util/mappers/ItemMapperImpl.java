package com.springbootacademybatch4.pointofsalebatch4.util.mappers;

import com.springbootacademybatch4.pointofsalebatch4.dto.ItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.dto.request.RequestSaveItemDTO;
import com.springbootacademybatch4.pointofsalebatch4.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-15T14:51:40+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item requestDTOToEntity(RequestSaveItemDTO requestSaveItemDTO) {
        if ( requestSaveItemDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setItemName( requestSaveItemDTO.getItemName() );
        item.setMeasuringUnitType( requestSaveItemDTO.getMeasuringUnitType() );
        item.setBalanceQty( requestSaveItemDTO.getBalanceQty() );
        item.setSupplierPrice( requestSaveItemDTO.getSupplierPrice() );
        item.setSellingPrice( requestSaveItemDTO.getSellingPrice() );

        return item;
    }

    @Override
    public List<ItemDTO> entityListToDTOList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>( items.size() );
        for ( Item item : items ) {
            list.add( itemToItemDTO( item ) );
        }

        return list;
    }

    protected ItemDTO itemToItemDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemId( item.getItemId() );
        itemDTO.setItemName( item.getItemName() );
        itemDTO.setMeasuringUnitType( item.getMeasuringUnitType() );
        itemDTO.setBalanceQty( item.getBalanceQty() );
        itemDTO.setSupplierPrice( item.getSupplierPrice() );
        itemDTO.setSellingPrice( item.getSellingPrice() );
        itemDTO.setActiveState( item.isActiveState() );

        return itemDTO;
    }
}
