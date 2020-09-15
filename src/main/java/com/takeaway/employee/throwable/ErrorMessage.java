package com.takeaway.employee.throwable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
	private Integer code;
	private String message;
	
	public static ErrorMessage NOT_ENOUGH_BALANCE = new ErrorMessage(100, "Not enough balance to transfer or withdraw");
	public static ErrorMessage PRIVATE_ACC_WITHDRAW = new ErrorMessage(101, "Private account cannot withdraw");
	public static ErrorMessage SAVING_ACC_WITHDRAW = new ErrorMessage(102, "Saving account is only allowed to transfer to the reference account");
	public static ErrorMessage SAVING_REF_ERROR = new ErrorMessage(103, "A SAVINGS_ACCOUNT can only reference to a CHECKING_ACCOUNT");
}
