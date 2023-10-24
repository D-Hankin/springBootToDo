package com.toDo.toDo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ToDoController {

    private static final List<Todo> toDoItems = new ArrayList<>();
       
    @GetMapping("/todo")
    String getToDo(Model model) {
        model.addAttribute("toDoItems", toDoItems);
        model.addAttribute("newToDo", new Todo(null, 0));
        return "todo";
    }

    @PostMapping("/new-item")
    String newItem(@RequestParam("name") String name) {
        toDoItems.add(new Todo(name, toDoItems.size() + 1));
        return "redirect:/todo"; 
    }

    @GetMapping("/remove-item/{itemId}")
    String removeItem(@PathVariable int itemId) {
        toDoItems.removeIf(item -> item.getId() == itemId);
        return "redirect:/todo";
    }

}
