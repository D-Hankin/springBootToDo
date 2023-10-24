package com.toDo.toDo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ToDoController {

    private static final List<Todo> toDoItems = new ArrayList<>();
    static {
        toDoItems.add(new Todo("Print list", 1));
        toDoItems.add(new Todo("Add new item", 2));
        toDoItems.add(new Todo("Remove item", 3));
        toDoItems.add(new Todo("Done!", 4));
    }

    
    @GetMapping("/todo")
    String getToDo(Model model) {
        model.addAttribute("toDoItems", toDoItems);
        return "todo";
    }

}
