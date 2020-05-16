package visual;

import java.util.LinkedList;
import java.util.List;

import controle.*;
import dados.Cliente;

public class Inicio {
	
	public static void main(String[] args) {
		
		AsciiArt.printAsciiArt("WB");
		Menu menu = new Menu();
		Cliente cl = null;
		
		int id = 0;
		int op = 1000;
		
		List<Cliente> clientes = new LinkedList<Cliente>();
		
		while(op != 0) {
			menu.imprimirMenu();
			Controle ctl = new Controle();
			op = ctl.opcao();
			
			switch(op) {
			case 1:	
				cl = new Cliente(0, 0, 0, 0, 0, null, null, null, null);
				
				System.out.println("\nNome: ");
				cl.setNome(ctl.composto()); 
				
				System.out.println("Nascimento: ");
				System.out.println("Dia:");
				cl.setDia(ctl.opcao());
				System.out.println("M�s: ");
				cl.setMes(ctl.opcao()); 
				System.out.println("Ano: ");
				cl.setAno(ctl.opcao());
				
				System.out.println("Idade: ");
				cl.setIdade(ctl.opcao());
				
				System.out.println("G�nero: ");
				cl.setGenero(ctl.composto());
				
				System.out.println("Telefone: ");
				cl.setTelefone(ctl.composto());
				
				System.out.println("Produto ou servi�o: ");
				cl.setServico(ctl.composto());
				
				cl.setUserId(id += 1);
				
				clientes.add(cl);
				
				break;
			
			case 2:
				if(clientes.isEmpty() ) {
					System.out.println("\nN�o h� cadastros!");
					System.out.println("Aperte qualquer tecla...");
					ctl.texto();
				}else {
					System.out.println("\nC�digo do cliente: ");
					int x = ctl.opcao();
					
					for(int i = 0; i < clientes.size(); i++) {
						if(cl.getUserId() == x) {
							
							System.out.println("Nome: ");
							String Nome = ctl.composto();
							
							System.out.println("Nascimento: ");
							System.out.println("Dia: ");
							int dia = ctl.opcao();
							System.out.println("M�s:");
							int mes = ctl.opcao();
							System.out.println("Ano:");
							int ano = ctl.opcao();
							
							System.out.println("Idade: ");
							int idade = ctl.opcao();
							
							System.out.println("G�nero: (M/F)");
							String genero = ctl.texto();
							
							System.out.println("Telefone:");
							String telefone = ctl.texto();
							
							System.out.println("Servi�o ou produto:");
							String servico = ctl.composto();
							
							cl.setNome(Nome);
							cl.setDia(dia);
							cl.setMes(mes);
							cl.setAno(ano);
							cl.setIdade(idade);
							cl.setGenero(genero);
							cl.setTelefone(telefone);
							cl.setServico(servico);
							
							System.out.println("Dados Atualizados!\n");
							System.out.println(clientes.toString());
							}
						}
					}
				break;
			
			case 3:
				if(clientes.isEmpty()) {
					System.out.println("\nN�o h� cadastros!");
					System.out.println("Aperte qualquer tecla...");
					ctl.texto();
				}else {
					System.out.println("C�digo do cliente: ");
					int x = ctl.opcao();
					
					for(int i = 0; i < clientes.size(); i++) {
						if(cl.getUserId() == x) {
							clientes.remove(x);
						}
					}
				}
				
				break;
			
			case 4:				
				if(clientes.isEmpty()) {
					System.out.println("N�o h� cadastros!");
					System.out.println("Aperte qualquer tecla...");
					ctl.texto();
				}else {
					System.out.println("\n##### CLIENTES CADASTRADOS #####\n");
					System.out.println(clientes.toString());
					}
				break;
			
			case 5:
				if(clientes.isEmpty()) {
					System.out.println("N�o h� cadastros!");
					System.out.println("Aperte qualquer tecla...");
					ctl.texto();
				}else {
					System.out.println("\n##### Lista por g�nero #####\n");
					System.out.println("Informe o g�nero: (M/F)");
					String gen = ctl.texto();
					
					for(int i = 0; i < clientes.size(); i++) {
						if(cl.getGenero().equals(gen)) {
						System.out.println(clientes.get(i));
						}
					}
				}
				break;
				
			case 6:
				if(clientes.isEmpty()) {
					System.out.println("N�o h� cadastros!");
					System.out.println("Aperte qualquer tecla...");
					ctl.texto();
				}else {
					for(int i = 0; i < clientes.size(); i++) {
						System.out.println("\n+++++ Lista de compras +++++");
						System.out.println("\nCliente: " + clientes.get(i).getNome());
						System.out.println("Servi�o/Produto: " + clientes.get(i).getServico());
						System.out.println("\n++++++++++++++++++++++++++++++");
					}
				}
				break;
				
			case 7:
				System.out.println("Idade m�dia de p�blico por unidade");
				System.out.println("Informe a unidade: ");
				System.out.println(cl.getIdade()/2);
				
				System.out.println("Idade m�dia de p�blico por g�nero");
				System.out.println("Informe o g�nero: ");
				String gen = ctl.texto();
				
				for(int i =0; i < clientes.size(); i++) {
					if(cl.getGenero().equals(gen)) {
						System.out.println(cl.getIdade());
					}
				}
				
				System.out.println("Servi�o/Produto mais procurado");
				System.out.println(cl.getServico());
				
				System.out.println("Servi�o/Produto mais procurado por g�nero");
				System.out.println("Informe o g�nero: ");
				String gen1 = ctl.texto();
				
				for(int i =0; i < clientes.size(); i++) {
					if(cl.getGenero().equals(gen1)) {
						System.out.println(cl.getServico());
					}
				}
				break;
			}
		}
	}
}
