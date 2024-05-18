package candidatura;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessoSeletivo {

	static final double SALARIO_BASE = 2000.0;
	static ArrayList<String> listaSelecionados = new ArrayList<String>();
	static String[] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge"};
	@SuppressWarnings("rawtypes")
	static Map map = new HashMap<>();
	static int tentativasRealizadas;

	public static void main(String[] args) {
		ArrayList<String> listaExcluidos = new ArrayList<String>();
		selecaoCandidatos();
		for(int i = 0; i < listaSelecionados.size(); i++) {
			boolean aceite = entrandoEmContato(listaSelecionados.get(i));
			if(aceite) {
				System.out.println("\nO contato com o candidato(a) "+listaSelecionados.get(i)+" foi realizado com sucesso na "+tentativasRealizadas+"ª tentativa .");
			}
			else {
				System.out.println("Não conseguimos entrar em contato com o candidato(a) "+listaSelecionados.get(i)+", número máximo de tentativas excedido.\n");
				listaExcluidos.add(listaSelecionados.get(i));
				listaSelecionados.remove(i);
			}
		}
		System.out.println("\nCANDIDATOS PARA A VAGA E SALÁRIOS PRETENDIDOS:");
		for(int i = 0; i < candidatos.length; i++){
			System.out.printf(candidatos[i]+" : %.2f",map.get(candidatos[i]));
			System.out.printf("\n");
		}
		System.out.println("\nCANDIDATOS QUE FORAM EXCLUIDOS NA CHAMADA:");
		if(listaExcluidos.size() == 0){
			System.out.println("Nenhum candidato foi excluído!");
		} else{
			for(String excluido : listaExcluidos) {
				System.out.println(excluido);
			}
		}	
		System.out.println("\nCANDIDATOS QUE FORAM CONTRATADOS:");
		if(listaSelecionados.size() == 0){
			System.out.println("Nenhum candidato foi contratado!");
		} else{
			for(String contratado : listaSelecionados) {
				System.out.println(contratado);
			}
		}
	}
	static boolean entrandoEmContato(String candidato) {
		tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;
			}
			else {
				atendeu = true;
			}
		} while(continuarTentando && tentativasRealizadas < 4);
		return atendeu;
	}
	@SuppressWarnings("unchecked")
	static void selecaoCandidatos() {
		int candidatoAtual = 0;
		while( candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			map.put(candidatos[candidatoAtual], salarioPretendido);
			if(SALARIO_BASE >= salarioPretendido) {
				listaSelecionados.add(candidato);
			}
			candidatoAtual++;
		}
	}
	static double valorPretendido() {
		double pretensaoSalarial = java.util.concurrent.ThreadLocalRandom.current().nextDouble(1800, 2200);
		return pretensaoSalarial;
	}
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
}
