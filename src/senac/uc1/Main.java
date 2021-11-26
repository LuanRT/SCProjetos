package senac.uc1;

import java.util.*;
import senac.uc1.cliente.*;

public class Main {
	private static List lista_de_clientes;

	public static void main(String... args) {
		lista_de_clientes = new ArrayList<Cliente>();

		// temporario! somente para testes:
		PessoaFisica pf = new PessoaFisica();
		pf.setEmail("luanrt4@gmail.com");
		pf.setEndereco("Test123");
		pf.setNome("LuanRT");
		pf.setTelefone("557799486848");
		pf.setCpf("123-456-768-22");

		System.out.println(pf.toString());
	}
}
