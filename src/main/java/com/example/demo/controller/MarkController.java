package com.example.demo.controller;

import com.example.demo.dao.MarkJdbc;
import com.example.demo.model.Mark;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController
{
    private final MarkJdbc markjdbc;

    public MarkController(MarkJdbc markjdbc)
    {
        this.markjdbc = markjdbc;
    }

    @GetMapping("/mark/{id}")
    public Mark getMark(@PathVariable int id)
    {
        Mark mark = markjdbc.get(id);
        return mark;
    }
}
