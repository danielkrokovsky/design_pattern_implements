package pattern.adpter;

public class GeradorRelatorioVendas {
	
	private RelatorioAdapter adapter;

	public GeradorRelatorioVendas(RelatorioAdapter adapter) {

		this.adapter = adapter;
	}
	
	public void gerar() {
		this.adapter.generate("Teste 12345", "Teste 12345");
	}

}
