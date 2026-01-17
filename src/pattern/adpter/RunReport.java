package pattern.adpter;

public class RunReport {

	public static void main(String[] args) {
		
		GeradorRelatorioVendas report = new GeradorRelatorioVendas(new GeradorExcel());
		report.gerar();

	}

}
