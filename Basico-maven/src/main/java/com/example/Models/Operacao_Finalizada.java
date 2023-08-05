package com.example.Models;


public  class Operacao_Finalizada  extends Operacao {
	
	
	public Operacao_Finalizada(int number, String holder) {
		this.number = number;
		this.atividade = holder;
	}
	
	@Override
	public String toString() {
		return "Operacao  Finalizada :"
				+ number
				+ ", Descrição: "
				+ atividade;
				
	}
}
