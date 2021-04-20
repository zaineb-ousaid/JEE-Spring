/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;

/**
 *
 * @author zenume
 */
@Entity
@Data @NoArgsConstructor@AllArgsConstructor@ToString
public class Patient {
  //Generer id Auto
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotNull
@Size(min = 5,max = 15)
private String nom;
	@Temporal(TemporalType.DATE) 
	@DateTimeFormat(pattern ="yyyy-MM-dd")
private Date dateNaiss;
	@DecimalMin("4")
private int score;
private boolean malade;

   


}
