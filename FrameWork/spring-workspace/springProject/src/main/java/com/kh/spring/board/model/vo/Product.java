package com.kh.spring.board.model.vo;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter @Getter
@ToString
public class Product {

	private int proNo;
	private String proName;
	private String proDesc;
	
	private ArrayList<Option> optionList;
	
}
