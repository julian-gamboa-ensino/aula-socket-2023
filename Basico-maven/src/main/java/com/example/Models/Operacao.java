package com.example.Models;

public abstract class Operacao {
	
	public int number;
	public String atividade;
	
	public String toString() {
		return "---------------------------------"
				+ number
				+ ", atividade: "
				+ atividade;
				
	}
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
}
