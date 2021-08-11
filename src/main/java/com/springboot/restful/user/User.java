package com.springboot.restful.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class User {
	private Integer id;
	private String name;
	private Date joinDate;
}
