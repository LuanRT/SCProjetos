package senac.uc1.cliente;

public class PessoaFisica extends Cliente {
	private String cpf;

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}
}