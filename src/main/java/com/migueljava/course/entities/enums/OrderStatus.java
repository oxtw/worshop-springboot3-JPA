//Classe ENUMERADA de STATUS do pedido.
package com.migueljava.course.entities.enums;

import com.migueljava.course.entities.Order;

public enum OrderStatus {
	
	//códigos numerados por ordem para não confundir no banco de dados e ser mais simples de fazer manutenção.
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	
	private int code;
	
	//construtor privado recebendo um codigo do tipo inteiro inteiro.
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//método get que retorna meu code.
	public int getCode() {
		return code;
	}
	
	//esse método irá me retornar o OrderStatus correspondente ao código dele.
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) 
				return value;
			}
		//exceção caso o código seja inválido.
			throw new IllegalArgumentException("Invalid OrderStatus code");
		}
	}