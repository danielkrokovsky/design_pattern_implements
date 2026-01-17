package pattern.adpter;

public class GeradorPdf implements RelatorioAdapter{

	@Override
	public void generate(String nome, String conteudo) {
		
		System.out.println("Gerando relatório em pdf");
	}
}
