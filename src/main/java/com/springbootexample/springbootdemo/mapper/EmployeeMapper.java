package com.springbootexample.springbootdemo.mapper;

import com.springbootexample.springbootdemo.entities.Em;
import com.springbootexample.springbootdemo.entities.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("Select * from em where id = #{id}")
    public Em getEmployeeById(Integer id);

    @Update("Update em set lastName = #{lastName},email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    public void updateEmployee(Em employee);

    @Delete("delete from em where id = #{id}")
    public void deleteEmp(Integer id);

    @Insert("insert into em(lastName,email,gender) values(#{lastName},#{email},#{gender})")
    public void insertUser(Em employee);

    @Select("select * from em where lastName = #{lastName}")
    public Em getEmByLastName(String lastName);
}
