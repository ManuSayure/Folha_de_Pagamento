//package main;
package principal;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Empregado[] listaDeEmpregados = new Empregado[500];
        Empregado[] copia = new Empregado[500];
        Empregado[] redo = new Empregado[500];
        int quantidadeEmpregados = 0, idLivre = 1;
        
        // MENU
        Scanner ler = new Scanner(System.in);
        Empregado novoFuncionario = new Empregado("","",0,0.0,0.0,0);
        Empregado CopiaNovoFuncionario = new Empregado("","",0,0.0,0.0,0);
        boolean sair,estado;
        int opcao, identificador, horaEntrada, minutosEntrada, horaSaida, key,idKey;
        int minutosSaida, horasTrabalhadas, lendoInt;
        double lendoDouble, valor, porcentagem, copiaComissao, copiaSalario, copiaTaxaSindicalExtra;
        String lendoString, horaString;
        Agenda = new int[10]String[10]
        String[] semana = new String("sabado","domingo","segunda", "ter�a","quarta","quinta","sexta");
        int data = 1;
		int dia = 0;
		int horas = 0;
		int sextas = 0;
		System.out.println( data + "\\05\\2017," + semana[dia] +"\n");
        
        
        do
        {
    		System.out.println(" ------------------------------------------    ");
        	System.out.println("Digite a op��o desejada\n                      ");
            System.out.println("01 - Adicionar empregado                       ");
            System.out.println("02 - Remover empregado                         ");
            System.out.println("03 - Lancar cartao de ponto                    ");
            System.out.println("04 - Lancar venda no sistema                   ");
            System.out.println("05 - Lancar uma taxa de servico                ");
            System.out.println("06 - Editar dados do empregado                 ");
            System.out.println("07 - Rodar a folha de pagamento para hoje      ");
            System.out.println("08 - Desfazer ou refazer o ultimo comando      ");
            System.out.println("09 - Vizualizar a agenda de pagamento          ");
            System.out.println("10 - Criar uma nova agenda de pagamento        ");
            System.out.println("00 - Sair do sistema\n                         ");
            System.out.println(" ------------------------------------------    ");
        	System.out.println("                                               ");
    		System.out.print(" >>  ");

            opcao = ler.nextInt();
            ler.nextLine();
            
            switch(opcao)
            {
                case 1: //CADASTRAR NOVO FUNCIONARIO
                	              	
                    System.out.println(" Digite o nome completo:");
            		novoFuncionario.nome = ler.nextLine();
            		
                    System.out.println("Digite o endere�o:");
            		novoFuncionario.endereco = ler.nextLine();
            		
                    System.out.println("Escolha o tipo do funcion�rio:\n"
                            + "1-Horista\n"
                            + "2-Assalariado\n"
                            + "3-Comissionado");
                    novoFuncionario.tipo = ler.nextInt();
                    if (novoFuncionario.tipo == 3 )
                    {
                    	System.out.println("Digite a comiss�o: ex 10%")	
                    	novoFuncionario.comissao = ler.nextInt();
                    	novoFuncionario.correto = 2;                    	
                    }
                    else if (novoFuncionario.tipo == 2 )
                    {
                    	novoFuncionario.correto = 4;
                    }
                    else
                    {
                    	novoFuncionario.correto = 1;
                    	
                    }
                    
                    System.out.println("Digite o sal�rio do funcion�rio:\n"
                            + "(Se horista, o valor da hora trabalhada\n"
                            + " Se assalariado ou comissionado, o valor mensal)");
                    System.out.print("R$:  ");
                    
                    novoFuncionario.salarioBruto = ler.nextDouble();
                   novoFuncionario.comissao = 0.0;
                    novoFuncionario.id = idLivre;
                    idKey= (id--);
                    listaDeEmpregados[idKey] = new Empregado
        (novoFuncionario.nome, novoFuncionario.endereco, novoFuncionario.tipo, 
                            novoFuncionario.salarioBruto, novoFuncionario.comissao, 
                            novoFuncionario.id);
                    CopiaNovoFuncionario = listaDeEmpregados[idKey];
                    idLivre++;
                    quantidadeEmpregados++;
                    key = opcao; 
                    System.out.println("O funcionario do ID " +(idLivre - 1)
                            + " foi cadastrado com sucesso!\n");
                break;
                case 2: //REMOVER FUNCIONARIO
                    if( quantidadeEmpregados > 0 )
                    {
                        do
                        {
                            sair = false;
                            System.out.println("Digite o ID do Funcionario:");
                            lendoInt = ler.nextInt();
                            sair = true;
                        }while(sair != true);
                        sair=false;
                        for(int i = 0; i<quantidadeEmpregados; i++)
                        {
                            if(listaDeEmpregados[i].id == lendoInt)
                            {	idKey=id;
                                listaDeEmpregados[i].id = -1;
                                sair=true;
                                key = opcao; 
                                quantidadeEmpregados--;
                                System.out.println(" O funcionario +"listaDeEmpredados.[i].nome"+ foi removido com sucesso!!");
                           
                            }
                        }
                        if(!sair)
                        {
                            System.out.println("O Funcionario n�o foi encontrado!");
                        }
                    }else
                    {
                        System.out.println("N�o foi possivel realizar esta op��o, pois n�o existe funcionarios!");
                    }
                break;
                case 3: // LAN�AR CARTAO DE PONTO
                    System.out.println("Informe o ID do funcionario horista:");
                    identificador = ler.nextInt();
                    ler.nextLine();
                    sair=false;
                    for(int i = 0; i<quantidadeEmpregados && !sair; i++)
                    {
                        if(listaDeEmpregados[i].id == identificador)
                        {
                            System.out.println("Informe o horario de entrada:");
                            horaString = ler.nextLine();
                            horaEntrada = (int) ( horaString.charAt(0) - '0') 
                                    * 10 + (int) ( horaString.charAt(1) - '0');
                            minutosEntrada = (int) ( horaString.charAt(3) - '0') 
                                    * 10 + (int) ( horaString.charAt(4) - '0');
                            System.out.println("Informe o horario de sa�da:");
                            horaString = ler.nextLine();
                            horaSaida = (int) ( horaString.charAt(0) - '0') 
                                    * 10 + (int) ( horaString.charAt(1) - '0');
                            minutosSaida = (int) ( horaString.charAt(3) - '0') 
                                    * 10 + (int) ( horaString.charAt(4) - '0');
                            horasTrabalhadas = horaSaida - horaEntrada;
                            if(minutosEntrada > minutosSaida)
                            {
                                horasTrabalhadas--;
                            }
                            if(horasTrabalhadas <= 8)
                            {
                            	idKey = i;
                            	copiaSalario = listaDeEmpregado[i].salarioLiquido;
                            	
                                listaDeEmpregados[i].salarioLiquido += (listaDeEmpregados[i].salarioBruto * horasTrabalhadas);
                            }else
                            {
                            	idKey = i;
                            	copiaSalario = listaDeEmpregado[i].salarioLiquido;
                                listaDeEmpregados[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido + (listaDeEmpregados[i].salarioBruto * 8);
                                listaDeEmpregados[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido + (horasTrabalhadas - 8.0) * listaDeEmpregados[i].salarioBruto * 1.5;
                            }
                            System.out.println("O Cart�o foi batido com sucesso!");
                            sair = true;
                            key = opcao; 
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado n�o foi encontrado!");
                    }
                break;
                case 4:// LAN�AR VENDA NO SISTEMA
                    System.out.println("Informe o ID do funcionario comissionado:\n");
                    identificador = ler.nextInt();
                    sair = false;
                    for(int i = 0; i < quantidadeEmpregados && !sair; i++)
                    {
                        if(listaDeEmpregados[i].id == identificador)
                        {
                            System.out.println("Informe o valor da venda R$:\n ");
                            valor = ler.nextDouble();
                            
                            System.out.println("Informe a porcentagem da comiss�o:\n ");
                            porcentagem = ler.nextDouble(); 
                            copiaComissao = listaDeEmpregados[i].comissao;
                            listaDeEmpregados[i].comissao += valor / 100 * porcentagem;
                            sair = true;
                            key = opcao; 
                            idKey=i;
                            System.out.println("A comiss�o de R$ "+(valor / 100 * porcentagem)+ " foi registrada!");
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado n�o foi encontrado!");
                    }
                break;
                case 5: //LAN�AR UMA NOVA TAXA DE SERVI�O
                    System.out.println("Informe o ID do funcionario:");
                    identificador = ler.nextInt();
                    sair = false;
                    for(int i = 0; i < quantidadeEmpregados && !sair; i++)
                    {
                        if(listaDeEmpregados[i].id == identificador)
                        {
                            System.out.println("Informe a taxa de servi�o R$:");
                            copiaTaxaSindicalExtra=  listaDeEmpregados[i].taxaSindicalExtra;
                            listaDeEmpregados[i].taxaSindicalExtra += ler.nextDouble();
                            sair = true;
                            key = opcao; 
                            idKey= i;
                            System.out.println("A taxa de servi�o de R$ "+lendoDouble+ " foi registrada!");
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado n�o foi encontrado!");
                    }
                break;
                case 6: // EDITAR DADOS DO FUNCIONARIO
                    System.out.println("Informe o ID do funcionario:");
                    identificador = ler.nextInt();
                    sair = false;
                    for(int i = 0; i < quantidadeEmpregados && !sair; i++)
                    {
                        if(listaDeEmpregados[i].id == identificador)
                        {	 idKey= i; 
                        	System.out.println("Qual informa��o voc� deseja modificar? 1- Nome\n 2- Endere�o \n 3- Tipo do funcion�rio\n 4 - Salario bruto\n 5- Comissao\n 6 Associa��o Sindical\n 7 Metodo de Pagamento \n 0- sair");
                        	lendoInt = ler.nextInt();
                        	while(lendoInt != 0){                      	
                        	                        	
                        	CopiaNovoFuncionario = listaDeEmpregados[idKey];
                        	
                        	if (lendoInt == 1){
                        		System.out.println("Substituir o nome completo do Funcion�rio: " + listaDeEmpregados[i].nome);
                                listaDeEmpregados[i].nome = ler.nextLine();
                                sair = true;
                                key = opcao;
                        	}
                        	else if(lendoInt == 2){
                        		System.out.println("Substituir o endere�o do funcion�rio: " + listaDeEmpregados[i].endereco);
                                listaDeEmpregados[i].endereco = ler.nextLine();
                                sair = true;
                                key = opcao;
                        	}
                        	else if(lendoInt == 3){
                        		 System.out.println("Substitua o tipo do funcion�rio: + \n1-Horista\n2-Assalariado \n3-Comissionado\nTipo Atual: " 
                                    + listaDeEmpregados[i].tipo );
                                 listaDeEmpregados[i].tipo = ler.nextInt();
                                 sair = true;
                                 key = opcao;
                        	}
                        	else if(lendoInt == 4){
                        		 System.out.println("Substitua o sal�rio do funcion�rio:\n" //4
                            + "(Se horista, o valor da hora trabalhada\n"
                            + " Se assalariado ou comissionado, o valor mensal)
                                    + "\nValor Atual: R$ " 
                                    + listaDeEmpregados[i].salarioBruto );
                            System.out.print("R$ ");
                            listaDeEmpredados[i].salarioBruto = ler.nextDouble();
                            sair = true;
                            key = opcao;
                        	}	
                        	else if(lendoInt == 5){
                        		System.out.println("Substitua o valor da comiss�o do funcion�rio:"); //5
                        		System.out.print("Valor Atual: R$ " + listaDeEmpregados[i].comissao + "\n");
                        		listaDeEmpregados[i].comissao = ler.nextDouble();
                        		sair = true;
                                key = opcao;
                        	}
                        	else if(lendoInt == 6){
                        		System.out.println("Substitua o estado de associa��o ao sindicato: (S/N)"); //6
                        		lendoString = ler.nextLine();
                        		estado = false;
                        		sair = true;
                                key = opcao;
                        	}
                            else if(lendoString.charAt(0) == 'S')
                            {
                                System.out.println("Informe o ID perante ao sindicato:\n");
                                listaDeEmpregados[i].idSindicato = ler.nextInt();
                                
                                System.out.println("Informe a taxa sindical:\n");
                                listaDeEmpregados[i].taxaSindical = ler.nextDouble();
                                estado = true;
                                listaDeEmpregados[i].pertencenteAoSindicato = estado;
                                sair = true;
                                key = opcao;
                            }
                            
                        	
                        	else if(lendoInt == 7){
                        		System.out.println("Substitua o m�todo de pagamento do funcion�rio:" //7
                            		+ "\n1-Cheque pelos correios"
                                    + "\n2-Cheque em m�os"
                                    + "\n3-Dep�sito em conta banc�ria"
                                    + "\nM�todo Atual:" + listaDeEmpregados[i].metodoDePagamento );
                           listaDeEmpregados[i].metodoDePagamento = ler.nextInt();
                           sair = true;
                           key = opcao;
                        	}  
                        	else {
                        		 System.out.println("Op�ao inv�lida!");
                        	}
                        	System.out.println("Qual informa��o voc� deseja modificar? 1- Nome\n 2- Endere�o \n 3- Tipo do funcion�rio\n 4 - Salario bruto\n 5- Comissao\n 6 Associa��o Sindical\n 7 Metodo de Pagamento \n 0- sair");
                        	lendoInt = ler.nextInt();
                        	sair = true;
                            key = opcao;
                        }
                            
                            
                            
                            System.out.println("O funcion�rio foi editado com sucesso!");
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado n�o foi encontrado!");
                    }
                break;
                case 7: // RODAR A FOLHA DE PAGAMENTO PRA HOJE
                	
        				
        				/for(int i =0; i < quantidadeEmpregados; i++)
        				{
        					copia[i] = new listaDeEmpregados();
        					copia[i].nome = listaDeEmpregados[i].nome; 
        					copia[i].endere�o = listaDeEmpregados[i].endere�o;
        					copia[i].tipo = listaDeEmpregados[i].tipo;
        					copia[i].metodoDePagamento = listaDeEmpregados[i].metodoDePagamento;
        					copia[i].salario = listaDeEmpregados[i].salario;
        					copia[i].comissao = listaDeEmpregados[i].comissao;
        				    copia[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido;
        					copia[i].taxaSindicalExtra = listaDeEmpregados[i].taxaSindicalExtra;
        					copia[i].taxaSindical = listaDeEmpregados[i].taxaSindical;
        					copia[i].recebe = listaDeEmpregados[i].recebe;
        				}
        				
        			for(int i=0; i < quantidadeEmpregados; i++){
        				if(listaDeEmpregados[i].nome != null){
        					
        					if(listaDeEmpregados[i].recebimento.equals(semana[dia])){
        						listaDeEmpregados[i].recebe++;
        					}
        					//System.out.println(funcion�rio[i].recebimento + "recebe:" + funcion�rio[i].recebe + "correto" + funcion�rio[i].correto);
        					if(listaDeEmpregados[i].tipo == 1) && (listaDeEmpregados[i].recebe == listaDeEmpregados[i].correto)){
        						if(listaDeEmpregados[i].salarioLiquido != 0){
        							System.out.println("PAGAMENTO\n\nID:	" + listaDeEmpregados[i].id + "\nNome:	" + listaDeEmpregados[i].nome + "\nSal�rio bruto:	" + listaDeEmpregados[i].salarioBruto + "\nValor descontado pelo sindicato:	" +  (listaDeEmpregados[i].taxaSindical +  listaDeEmpregados[i].taxaSindicalExtra) + "\nSal�rio recebido: " + (listaDeEmpregados[i].salarioLiquido -(listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical)));
        							listaDeEmpregados[i].salarioLiquido = 0.0;
        							listaDeEmpregados[i].recebe = 0;
        						}
        					}
        					else if((listaDeEmpregados[i].tipo == 2) && (listaDeEmpregados[i].recebe == listaDeEmpregados.correto)){
        						System.out.println("PAGAMENTO\n\nID:	" + listaDeEmpregados[i].id + "\nNome:	" + listaDeEmpregados[i].nome + "\nSal�rio bruto:	" + listaDeEmpregados[i].salarioBruto + "\nValor descontado pelo sindicato:	" +  (listaDeEmpregados[i].taxaSindical +  listaDeEmpregados[i].taxaSindicalExtra) + "\nSal�rio recebido: " + (listaDeEmpregados[i].salarioLiquido -(listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical)));
        							listaDeEmpregados[i].recebe = 0;
        							}
        					
        					else if((listaDeEmpregados[i].tipo == 3) && (listaDeEmpregados[i].recebe == listaDeEmpregados[i].correto)){
        						System.out.println("PAGAMENTO\n\nID:	" + listaDeEmpregados[i].id + "\nNome:	" + listaDeEmpregados[i].nome + "\n Sal�rio Bruto :	" + funcion�rio[i].salarioBruto + "+ Comiss�o : "+listaDeEmpregados[i].comissao +"\nValor descontado pelo sindicato:	" +  (listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical) + "\nSal�rio recebido: " + (listaDeEmpregados[i].liquido + listaDeEmpregados.comissao -(listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical)));
        							listaDeEmpregados[i].salarioLiquido = 0.0;
        					}
        				}
        			}
        			dia++;
        			if(dia == 7)
        			{
        				dia =0; 
        				
        			}
        			System.out.println( data + "\\05\\2017," + semana[dia] +"\n");
        			data++;
        		}
                break;
                case 8: // FAZER OU DESFAZER
                	System.out.println("Digite a op��o desejada\n         ");
                    System.out.println("01 - Redo                         ");
                    System.out.println("02 - Undo                         ");
                    opcao = ler.nextInt();
                    double ultimoValor;
                    
                switch(opcao)
                case 1: // Redo
                	
                	if(key = 1)
                	{
                		listaDeEmpregados[idKey] = copiaNovoFuncionario;
                	}
                	if(key = 2)
                	{
                		listaDeEmpregados[idKey].id = -1;
                	}
                	if(key = 3)
                	{
                		
                		listaDeEmpregados[idKey].salarioLiquido= ultimoValor;
                	}
                	if(key = 4)
                	{	
                		 listaDeEmpregados[idkey].comissao = ultimoValor;
                		 key = 4;
                	}
                	if(key = 5)
                	{
                		listaDeEmpregados[idKey].taxaSindicalExtra  = ultimoValor;
                	}
                	if(key = 6)
                	{ 
                		listaDeEmpregados[idKey] = novoFuncionrio;
                	}
                	if(key = 7)
                	{
                		for(int i =0; i < quantidadeEmpregados; i++)
        				{
                		 copia[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido;
                		 copia[i].recebe = listaDeEmpregados[i].recebe;
                		 
                		 listaDeEmpregados[i].salarioLiquido = redo[i].salarioLiquido ;    				
                		 listaDeEmpregados[i].recebe = redo[i].recebe;
                		
        				}
                	}
                	
                case 2:
                	break;
                	if(key = 1)
                	{   
                		listaDeEmpregados[idKey].remove;
                	}
                	if(key = 2)
                	{
                		listaDeEmpregados[idKey].id = idKey;
                	}
                	if(key = 3)
                	{
                		ultimoValor = listaDeEmpregados[idKey].salarioLiquido;
                		listaDeEmpregados[idKey].salarioLiquido= copiaSalario;
                	}
                	if(key = 4)
                	{
                		ultimoValor = listaDeEmpregados[idkey].comissao;
                		 listaDeEmpregados[idkey].comissao = copiaComissao;
                		 key = 4;
                	}
                	if(key = 5)
                	{
                		ultimoValor = listaDeEmpregados[idkey].taxaSindicalExtra;
                		listaDeEmpregados[idKey].taxaSindicalExtra  = copiaTaxaSindicalExtra;
                	}
                	if(key = 6)
                	{ 
                		novoFuncionrio = listaDeEmpregados[idKey];
                		
                		listaDeEmpregados[idKey] = copiaNovoFuncionario;
                		
                	}
                	if(key = 7)
                	{
                		for(int i =0; i < quantidadeEmpregados; i++)
        				{
                			for(int i =0; i < quantidadeEmpregados; i++)
            				{
                    		 redo[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido;    				
                    		 redo[i].recebe = listaDeEmpregados[i].recebe ;            				
                    		 listaDeEmpregados[i].salarioLiquido = copia[i].salarioLiquido ;    				
                    		 listaDeEmpregados[i].recebe = copia[i].recebe;
        				}
                	}
                	
                    
                break;
                case 9:// VIZUALIZAR A AGENDA DE PAGAMENTO
                	System.out.println("Forne�a o nome do funcion�rio a ser editado:");
    				//getchar = scanner.nextLine();
    				lendoString = scanner.nextLine();
    				System.out.println("1:	semanalmente\n2: mensalmente\n 3:bi-semanalmente");
    				lendoInt = scanner.nextInt();
    				for(int i=0; i < quantidadeEmpregados; i++)
    				{
    					if(listaDeEmpregados[i].nome != null)
    					{
    						if(listaDeEmpregados[i].nome.equals(lendoString)){
    							if(lendoInt == 1){
    								listaDeEmpregados[i].agenda = 1;
    							}
    							else if(lendoInt == 2){
    								listaDeEmpregados[i].agenda = 4;
    							}
    							else if(lendoInt == 3){
    								listaDeEmpregados[i].agenda = 2;
    							}
    						}
    					}
    				}
                    
                break;
                case 10://CRIAR UMA NOVA AGENDA DE PAGAMENTO
                	System.out.println("Forne�a o nome do funcion�rio a ser editado:\n");
    				//getchar = scanner.nextLine();
    				lendoString = scanner.nextLine();
    				sair= false;
    				
    				for(int i=0; i< quatidadeEmpregado; i++)
    				{
    					if(listaDeEmpregdos[i].nome.equal(lendoString) && listaDeEmpregdos[i].nome != null )
    					{
    						System.out.println("Digite\n1-Mensal\n2-semanal");
    						lendoInt= scanner.nextInt();
    						if (lendoInt == 2)
    						{
    							System.out.println("Digite o dia da semana e quantidade de vezes. EX: segunda 2");
    							listaDeEmpregados[i].recebimento = scanner.nextLine() ;
    							listaDeEmpregados[i].correto = scanner.nextInt();
    							System.out.println("Mudan�as realizadas com sucesso!\n");
    							sair= true;
    						}
    					}
    					
    				}
    				if(!sair){
    					System.out.println("Mudan�as realizadas com sucesso!\n");
    				}
    				                
                break;
                case 0:
                    System.out.println("O programa foi encerrado com sucesso!"
                            + "\nMuito obrigado pelo uso!!!");
                break;
                default:
                    System.out.println("Voc� digitou uma op��o incorreta,"
                            + " por favor, digite outra op��o!\n");
            }
        }while(opcao != 0);
    }
    
}