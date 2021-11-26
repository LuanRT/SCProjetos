package senac.uc1.cliente;

public class Cliente {
	// Dados 
	private String nome, endereco, telefone, email;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		String client_info = 
			"Nome: " + nome + "\n" +
			"Endereço: " + endereco + "\n" + 
			"Telefone: " + telefone + "\n" +
			"Email: " + email;
		return client_info;
	}
}
