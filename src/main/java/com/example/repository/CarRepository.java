package com.example.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Car;

@Repository
public class CarRepository {

    private JdbcTemplate jdbcTemplate;

    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Car car) {

        String sql =
                "insert into car(id,name,price,brand) values(?,?,?,?)";

        return jdbcTemplate.update(sql,
                car.getId(),
                car.getName(),
                car.getPrice(),
                car.getBrand());
        }

    public List<Car> findAll() {
        
        String sql="select * from car";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Car.class));
    }
    public Car findById(int id){

        String sql="select * from car where id=?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Car.class),
                id);
    }
    public int update(Car car){

        String sql=
                "update car set brand=?,name=?,price=? where id=?";

        return jdbcTemplate.update(sql,
                car.getBrand(),
                car.getName(),
                car.getPrice(),
                car.getId());
    }
    public int deleteById(int id){

        String sql=
                "delete from car where id=?";

        return jdbcTemplate.update(sql,id);
    }

}