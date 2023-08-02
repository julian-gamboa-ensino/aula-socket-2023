package Models;
public  class Operacao_Planejamento  extends Operacao {
	
	
	public Operacao_Planejamento(int number, String holder) {
		this.number = number;
		this.atividade = holder;
	}
	
	@Override
	public String toString() {
		return "Operacao_Planejamento :"
				+ number
				+ ", atividade: "
				+ atividade;
				
	}
}
