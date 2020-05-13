package com.springbootexample.springbootdemo.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Em  implements Serializable {

	private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Integer dId;
	
}
