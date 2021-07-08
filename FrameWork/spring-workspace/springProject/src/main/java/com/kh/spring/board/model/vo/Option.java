package com.kh.spring.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter @Getter
@ToString
public class Option {

	private int optNo;
	private String optName;
	private int optPrice;
	private int refProNo;
	
}
