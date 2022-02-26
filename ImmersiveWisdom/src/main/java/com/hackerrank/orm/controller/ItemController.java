package com.hackerrank.orm.controller;

import com.hackerrank.orm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.enums.ItemStatus;

import java.util.*;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    //1. insert POST
    @PostMapping("/app/item")
    public Item insertItem(@RequestBody Item item){
        return itemService.addItem(item);
    }

    //2. update PUT
    @PutMapping("/app/item/{itemId}")
    public Item updateItem(@PathVariable("itemId") int itemID, @RequestBody Item item){
        return itemService.updateItem(itemID, item);
    }


    //3. delete by itemId DELETE
    @DeleteMapping("/app/item/{itemId}")
    public Item deleteItem(@PathVariable("itemId") int id){
        return itemService.deleteItem(id);
    }


    //4. delete all DELETE
    @DeleteMapping("/app/item")
    public List<Item> deleteAllItems(){
        return itemService.deleteAllItems();
    }


    //5. get by itemId GET
    @GetMapping("items/{itemId}")
    public Item getItem(@PathVariable("itemId") int id){
        return itemService.getItemByID(id);
    }

    //6. get all GET
    @GetMapping("/app/item")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }


    //7. filters by fields ?itemStatus={status}&itemEnteredByUser={modifiedBy} GET
    @GetMapping("/app/item?itemStatus={status}&itemEnteredByUser={modifiedBy}")
    public List<Item> filterItems(@PathVariable("status") ItemStatus status, @PathVariable("modifiedBy") String user){
        return itemService.filterItems(status, user);
    }


    //8. select all with sorting and pagination ?pageSize={pageSize}&page={page}&sortBy={sortBy} GET
    @GetMapping("/app/item?pageSize={pageSize}&page={page}&sortBy={sortBy}")
    public

}
