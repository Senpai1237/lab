package com.example.demo.dao;

import com.example.demo.model.Mark;
import com.example.demo.model.Study_Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class Study_GroupJdbc
{
    private final JdbcTemplate jdbcTemplate;

    public Study_GroupJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Study_Group mapStudy_Group (ResultSet rs, int i) throws SQLException
    {
        Study_Group study_group = new Study_Group(
                rs.getInt("id"),
                rs.getString("name")
        );
        return study_group;
    }

    //Создание и редактирование группы
    public Study_Group get(int id, String name)
    {
        return jdbcTemplate.queryForObject("MERGE INTO STUDY_GROUP (ID, NAME)" +
                "VALUES(?, ?)",
                this::mapStudy_Group, id, name);
    }

}