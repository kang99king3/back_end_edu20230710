package com.hk.board.dtos;

import lombok.Data;

@Data
public class MessageDto {

	private String type;
	private String userId;
	private String roomNo;
	private String msg;
}
