package com.hackerrank.orm.service;

import com.hackerrank.orm.enums.ItemStatus;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

@Transactional
@Service
public class ItemService {
    @Autowired
    public ItemRepository itemRepository;

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach((items::add));
        return items;
    }

    public Item getItemByID(int id){
        Item item = itemRepository.findById(id).orElse(null);
        return item;
    }

    public Item addItem(Item item){
        itemRepository.save(item);
        return item;
    }

    public Item updateItem(int id, Item item){
        itemRepository.save(item);
        return item;
    }

    public Item deleteItem(int id){
        Item item = itemRepository.findById(id).orElse(null);
        itemRepository.deleteById(id);
        return item;
    }

    public List<Item> deleteAllItems(){
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::delete);
        return items;
    }

    public List<Item> filterItems(ItemStatus status, String user){
        List<Item> items = session.createQuery("SELECT * FROM Item WHERE itemStatus = :status AND itemEnteredByUser = :user");
        return items;
    }

    public

}
