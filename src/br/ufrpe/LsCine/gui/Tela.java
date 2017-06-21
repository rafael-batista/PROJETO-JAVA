package br.ufrpe.LsCine.gui;

import java.util.Scanner;

import br.ufrpe.LsCine.negocio.Fachada;
import br.ufrpe.LsCine.negocio.beans.Filme;
import br.ufrpe.LsCine.negocio.beans.Salas;

public class Tela {
	
	Fachada fachada = new Fachada();
	int opcao;
	Scanner input = new Scanner(System.in);
		
	public void menu(){
		
		int resp;
		do{
		System.out.println("Bem-vindo!\n");
		System.out.println("1- Gerenciamento de filmes");
		System.out.println("2- Gerenciamento de sessões");
		System.out.println("3- Gerenciamento de salas");
		System.out.println("4- Relatorio de lucro");
		System.out.println("0- Sair");
		System.out.println("Escolha uma opção: ");
		resp = input.nextInt();
		switch(resp){
			case 1:{
				this.gerenciarFilmes();
				break;
			}
			case 2:{
				this.gerenciarSessoes();
				break;
			}
			case 3:{
				this.gerenciarSalas();
				break;
			}
			case 4:{
				this.relatorioLucro();
				break;
			}
			case 0:
				System.out.println("Finalizando o programa...");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}
		}while(resp !=0);
	}
	
	
	public void gerenciarFilmes(){
		System.out.println("Gerenciamento de filmes. Escolha a opcao desejada:");
		System.out.println("1-Cadastrar");
		System.out.println("2-Buscar");
		System.out.println("3-Remover");
		System.out.println("4-Alterar dados");
		//System.out.println("5-Comprar ticket");
		System.out.println("6-Voltar.");
		
		do{
			opcao = input.nextInt();
			
			switch(opcao){
				case 1: {
					System.out.println("Cadastrar filme.");
					System.out.println("Título: ");
					String nom = input.nextLine();
					input.nextLine();
					System.out.println("Duração(em minutos): ");
					int dur = input.nextInt();
					System.out.println("Classifição indicativa: ");
					System.out.println("1- Livre");
					System.out.println("2- +10");
					System.out.println("3- +12");
					System.out.println("4- +14");
					System.out.println("5- +16"); 
					System.out.println("6- +18");
					int cls = input.nextInt();
					fachada.cadastrarFilme(new Filme(nom,dur,cls));
					System.out.println("Cadastro realizado!\n");
					
					break;
				}
				case 2: {
					System.out.println("Buscar filme.");
					System.out.println("Título do filme que deseja buscar: ");
					String busca = input.nextLine();
					input.nextLine();
					Filme resultado = fachada.buscarFilme(busca);
					if(resultado==null){
						System.out.println("Filme não encontrado.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				}
				case 3: {
					System.out.println("Remover filme.");
					System.out.println("Título do filme que deseja remover:");
					String remove = input.nextLine();
					input.nextLine();
					fachada.removerFilme(remove);
					System.out.println("Filme removido.");
					break;
				}
				case 4: { //erro
					System.out.println("Modificar dados de filme.");
					System.out.println("Título do filme que deseja modificar: ");
					String busca = input.nextLine();
					input.nextLine();
					Filme filme = fachada.buscarFilme(busca);
					if(busca==null){
						System.out.println("Filme não encontrado.");
					}
					else{
						System.out.println(filme);
					}
					//System.out.println("Título: ");
					//String n = input.next();
					//n = input.nextLine();
					System.out.println("Duração: ");
					int d = input.nextInt();
					System.out.println("Classificação indicativa:");
					int c = input.nextInt();
					fachada.editarFilme(new Filme(filme.getNome(),d,c));
					System.out.println("Modificação realizada com sucesso!");
					
					break;				
				}
				case 5: {
					menu();
				}
				/*case 5: {
					System.out.println("Nome do filme:");
					String b = input.nextLine();
					b = input.nextLine();
					Filme filme = fachada.buscarFilme(b);
					System.out.println(filme);
					//int tipo, float valor, Sessão sessao, int id
					System.out.println("Tipo de ingresso:");
					System.out.println("1-Inteira");
					System.out.println("2-Meia");
					
					int t = input.nextInt();
					//fachada.cadastrarIngresso(new Ingresso(t));
					
					break;
				}*/
				default: {
					System.out.println("Opcao indisponível.");
					break;
				}		
			}	
		}while(opcao!=6);
	}
	
	
	public void gerenciarSessoes(){
		do{
		System.out.println("Gerenciamento de sessões. Escolha a opcao desejada:");
		System.out.println("1- Criar sessão");
		System.out.println("2- Buscar sessão por filme");
		System.out.println("3- Buscar sessão por sala");
		System.out.println("4- Buscar sessão por horário");
		System.out.println("5- Remover sessão");
		
		
			opcao = input.nextInt();
			
			switch(opcao){
				case 1: 
					System.out.println("Criar sessão.");
					Filme filmes = new Filme();
					Salas salan = new Salas();
					System.out.println("Filme: ");
					String nomes;
					do{
					nomes = input.nextLine();
					input.nextLine();					
					if(fachada.buscarFilme(nomes) != null){
						filmes = fachada.buscarFilme(nomes);
					}else if(fachada.buscarFilme(nomes) == null){
						System.out.println("Filme indisponível. Digite outro título.");
					}
					}while(fachada.buscarFilme(nomes) == null);					
					System.out.println("Sala: ");
					int num;
					do{
					num = input.nextInt();					
					if(fachada.procurarIdSala(num) != null){
						salan = fachada.procurarIdSala(num);
					}else{
						System.out.println("Sala indisponível. Escolha outra.");
					}
					}while(fachada.procurarIdSala(num) == null);					
					System.out.println("Horário: ");
					String horas = input.next();
					String minutos = input.next();					
					Date data = new Date();
					Date data2 = new Date();
					int final1;
					final1 = filmes.getDuracao();
					final1 = final1 / 2;
					int final2 = filmes.getDuracao();
					final2 = final2 % 2;
					data.setHours(Integer.parseInt(horas));
					data.setMinutes(Integer.parseInt(minutos));	
					data.setHours(Integer.parseInt(horas + final1));
					data.setMinutes(Integer.parseInt(minutos + final2));
					Sessao sessao = new Sessao(filmes, salan, data, data2);
					fachada.adicionarSessao(sessao);
					break;
				
				case 2:
					System.out.println("Digite o nome do filme:");
					String snome = input.nextLine();
					input.nextLine();
					Filme sfilme = fachada.buscarFilme(snome);						
					if(sfilme==null){
						System.out.println("Filme não encontrado.");
					}
					else{
						System.out.println(fachada.buscarSessaoPorFilme(sfilme));
					}
					break;
				case 3:
					System.out.println("Digite a sala do filme:");
					int sal = input.nextInt();					
					Salas sSala = fachada.procurarIdSala(sal);				
					if(sSala==null){
						System.out.println("Sala não encontrada.");
					}
					else{
						System.out.println(fachada.buscarSessaoPorSala(sSala));
					}
					break;
				case 4:
					System.out.println("Digite o horário da sessão:");
					System.out.println("Horário: ");
					String horasb = input.next();
					String minutosb = input.next();					
					Date datab = new Date();					
					datab.setHours(Integer.parseInt(horasb));
					datab.setMinutes(Integer.parseInt(minutosb));					
					if(fachada.buscarSessaoPorHorario(datab)==null){
						System.out.println("Horário indisponível.");
					}
					else{
						System.out.println(fachada.buscarSessaoPorHorario(datab));
					}
					break;
				case 5:
					System.out.println();
					default:
						System.out.println("Opção inválida.");
				
			}
		}while(opcao!=5);
	}
	
	public void gerenciarSalas(){
		do{
		System.out.println("\n\nGerenciamento de salas. Escolha a opcao desejada:");
		System.out.println("1- Criar sala");
		System.out.println("2- Buscar");
		System.out.println("3- Remover");
		System.out.println("4- Buscar tipo da Sala");
		System.out.println("5- Editar");
		System.out.println("6- Voltar");
	
		
			opcao = input.nextInt();
			
			switch(opcao){
				case 1:
					boolean s3d = false;
					boolean imax = false;
					int chs;
					System.out.println("Criar sala.");
					System.out.println("Numero da sala: ");
					int num = input.nextInt();
					System.out.println("Tipo de sessão:");
					System.out.println("1- 3D");
					System.out.println("2- IMAX 2D");
					System.out.println("3- IMAX 3D");
					do{
					chs = input.nextInt();					
					switch(chs){
					case 1:
						s3d = true;
						imax = false;
						break;
					case 2:
						imax = true;
						s3d = false;
						break;
					case 3:
						s3d = true;
						imax = true;
						break;
					default:
							System.out.println("Opção inválida.");
							break;
					}
					}while(chs > 3 || chs < 1);
					Salas nova = new Salas(num,s3d,imax);
					fachada.adicionarSala(nova);
					break;
				
				case 2:
					System.out.println("Buscar sala por numero.");
					System.out.println("Numero: ");
					int numero = input.nextInt();
					Salas resultado = fachada.procurarIdSala(numero);	
					if(resultado==null){
						System.out.println("Sala não encontrada.");
					}
					else{
						System.out.println(resultado);
					}
					break;
				
				case 3:
					int css;
					System.out.println("Salas cadastradas no momento.");
					fachada.listarSalas();
					System.out.println("Digite o número da sala que deseja remover.");
					css = input.nextInt();
					if(fachada.procurarIdSala(css) != null){
						fachada.removerSala(css);
					}else{
						System.out.println("Não foi possível remover a sala.");
					}
										
					break;
				case 4:
					int cho;
					System.out.println("Digite o número da sala que deseja buscar o tipo.");
					cho = input.nextInt();
					if(fachada.procurarIdSala(cho) != null){
						System.out.println(fachada.procurarTipoSala(cho));
						break;
					}else{
						System.out.println("Sala não encontrada.");
					}
										
				case 5:
					int cha, che;
					System.out.println("Digite o número da sala que deseja editar.");
					cha = input.nextInt();
					if(fachada.procurarIdSala(cha) != null){
						boolean v3d = false;
						boolean vimax = false;					
						System.out.println("Tipo de sessão:");
						System.out.println("1- 3D");
						System.out.println("2- IMAX 2D");
						System.out.println("3- IMAX 3D");
						do{
						che = input.nextInt();					
						switch(che){
						case 1:
							v3d = true;
							vimax = false;
							break;
						case 2:
							vimax = true;
							v3d = false;
							break;
						case 3:
							v3d = true;
							vimax = true;
							break;
						default:
								System.out.println("Opção inválida.");
								break;
						}
						}while(che > 3 || che < 1);
						Salas nova1 = new Salas(cha,v3d,vimax);
						fachada.editarSala(nova1);
						break;
					}
					break;
				case 6:
					System.out.println();
					break;
					default:
						System.out.println("Opção inválida.");
						break;
					
			}
		}while(opcao!=6);
	}

	public void relatorioLucro(){
		
	}
}
