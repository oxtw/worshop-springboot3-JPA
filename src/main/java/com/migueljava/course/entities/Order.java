//Classe de Entidades.

package com.migueljava.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.migueljava.course.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//classe de pedidos, com nome e horario do pedido.
//Implementação do Serializable.
@Entity //annotation para identificar como uma entidade.
@Table(name ="tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T' HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	//neste casso assoceiei order status como int, para eu dizer explicitamente que estou gravando no banco de dados um numero inteiro.
	private Integer orderStatus;
	

	//classe associada a USER.
	@ManyToOne // "muitos para um", definido no modelo de dominio, associação.
	@JoinColumn(name = "client_id") // Aqui eu defino a chave estrangeira pelo nome lá no banco de dados.
	private User client;

	//construtores
	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	//Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	//implementando o método valueOf no get do orderStatus.
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}
	//implementando getcode no set
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
	}
		
	}	
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	//hashcode e equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
