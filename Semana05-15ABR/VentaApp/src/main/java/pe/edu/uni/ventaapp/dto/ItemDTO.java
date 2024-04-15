package pe.edu.uni.ventaapp.dto;

public class ItemDTO {

	private String concepto;
	private double valor;

	public ItemDTO() {
	}

	public ItemDTO(String concepto, double valor) {
		this.concepto = concepto;
		this.valor = valor;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		String texto = "Concepto: " + concepto;
		texto += "\tValor: " + valor;
		return texto;
	}

	
}
