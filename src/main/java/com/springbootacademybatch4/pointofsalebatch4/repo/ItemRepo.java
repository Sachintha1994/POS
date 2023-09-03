package com.springbootacademybatch4.pointofsalebatch4.repo;

import com.springbootacademybatch4.pointofsalebatch4.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b); // findAllByItemNameIs, findAllByItemNameEquals

}
