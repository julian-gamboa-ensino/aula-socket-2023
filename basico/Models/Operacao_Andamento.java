package Models;
public class Operacao_Andamento extends Operacao{

	public Operacao_Andamento()
	{
		
	}
	
	public Operacao_Andamento(int number, String holder) {
		this.number = number;
		this.atividade = holder;
	}
	
	@Override
	public String toString() {
		

        String aux_atividade = (atividade != null) ? atividade : "NAO DEF";
        
		return " Andamento  --->  --->   --->  :"
				+  number
				+ ", atividade: "
				+ aux_atividade;
				
	}

}


/*
 	
 	
 	
 	
 */