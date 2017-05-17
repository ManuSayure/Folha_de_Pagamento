//package main;
package principal;

import principal.Empregado;
import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
    	//ArrayList<Empregados> listaDeEmpregdos  = new ArrayList<Empregados>(500);
        Empregado[] listaDeEmpregados = new Empregado[500];
    	
        Empregado[] copia = new Empregado[500];
        Empregado[] redo = new Empregado[500];
        int quantidadeEmpregados = 0, idLivre = 1;
        
        // MENU
        Scanner ler = new Scanner(System.in);
        Empregado novoFuncionario = new Empregado("", "" , 0, 0.0, 0.0, 0);
        Empregado copiaNovoFuncionario = new Empregado("", "", 0, 0.0, 0.0, 0);
        boolean sair,estado;
        int opcao, identificador, horaEntrada, minutosEntrada, horaSaida, key=0;
        int  idKey=0;
        int minutosSaida, horasTrabalhadas, lendoInt;
        double lendoDouble, valor, porcentagem, copiaComissao= 0.0, copiaSalario = 0.0, copiaTaxaSindicalExtra = 0.0;
        String lendoString = "", horaString;
        //Agenda = 
        String semana[] = {"sabado","domingo","segunda", "terça","quarta","quinta","sexta"};
        int data = 1;
		int dia = 0;
		int horas = 0;
		int sextas = 0;
		System.out.println( data + "\\05\\2017," + semana[dia] +"\n");
        
        
        do
        {
    		System.out.println(" ------------------------------------------    ");
        	System.out.println("Digite a opção desejada\n                      ");
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
            		
                    System.out.println("Digite o endereço:");
            		novoFuncionario.endereco = ler.nextLine();
            		
                    System.out.println("Escolha o tipo do funcionário:\n"
                            + "1-Horista\n"
                            + "2-Assalariado\n"
                            + "3-Comissionado");
                    novoFuncionario.tipo = ler.nextInt();
                    if (novoFuncionario.tipo == 3 )
                    {
                    	System.out.println("Digite a comissão: ex 10%")	;
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
                    
                    System.out.println("Digite o salário do funcionário:\n"
                            + "(Se horista, o valor da hora trabalhada\n"
                            + " Se assalariado ou comissionado, o valor mensal)");
                    System.out.print("R$:  ");
                    
                    novoFuncionario.salarioBruto = ler.nextDouble();
                   novoFuncionario.comissao = 0.0;
                    novoFuncionario.id = idLivre;
                    idKey= (idLivre-1);
                    listaDeEmpregados[idKey] = new Empregado
        (novoFuncionario.nome, novoFuncionario.endereco, novoFuncionario.tipo, 
                            novoFuncionario.salarioBruto, novoFuncionario.comissao, 
                            novoFuncionario.id);
                    copiaNovoFuncionario = listaDeEmpregados[idKey];
                    idLivre++;
                    quantidadeEmpregados++;
                    key = opcao; 
                    System.out.println("O funcionario do ID " +(idLivre)
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
                            {	idKey = lendoInt;
                                listaDeEmpregados[i].id = -1;
                                sair = true;
                                key = opcao; 
                                quantidadeEmpregados--;
                                System.out.println(" O funcionario " + (listaDeEmpregados[i].nome) + " foi removido com sucesso!!");
                           
                            }
                        }
                        if(!sair)
                        {
                            System.out.println("O Funcionario não foi encontrado!");
                        }
                    }else
                    {
                        System.out.println("Não foi possivel realizar esta opção, pois não existe funcionarios!");
                    }
                break;
                case 3: // LANÇAR CARTAO DE PONTO
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
                            System.out.println("Informe o horario de saída:");
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
                            	copiaSalario = listaDeEmpregados[i].salarioLiquido;
                            	
                                listaDeEmpregados[i].salarioLiquido += (listaDeEmpregados[i].salarioBruto * horasTrabalhadas);
                            }else
                            {
                            	idKey = i;
                            	copiaSalario = listaDeEmpregados[i].salarioLiquido;
                                listaDeEmpregados[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido + (listaDeEmpregados[i].salarioBruto * 8);
                                listaDeEmpregados[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido + (horasTrabalhadas - 8.0) * listaDeEmpregados[i].salarioBruto * 1.5;
                            }
                            System.out.println("O Cartão foi batido com sucesso!");
                            sair = true;
                            key = opcao; 
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado não foi encontrado!");
                    }
                break;
                case 4:// LANÇAR VENDA NO SISTEMA
                    System.out.println("Informe o ID do funcionario comissionado:\n");
                    identificador = ler.nextInt();
                    sair = false;
                    for(int i = 0; i < quantidadeEmpregados && !sair; i++)
                    {
                        if(listaDeEmpregados[i].id == identificador)
                        {
                            System.out.println("Informe o valor da venda R$:\n ");
                            valor = ler.nextDouble();
                            
                            System.out.println("Informe a porcentagem da comissão:\n ");
                            porcentagem = ler.nextDouble(); 
                            copiaComissao = listaDeEmpregados[i].comissao;
                            listaDeEmpregados[i].comissao += valor / 100 * porcentagem;
                            sair = true;
                            key = opcao; 
                            idKey=i;
                            System.out.println("A comissão de R$ "+(valor / 100 * porcentagem)+ " foi registrada!");
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado não foi encontrado!");
                    }
                break;
                case 5: //LANÇAR UMA NOVA TAXA DE SERVIÇO
                    System.out.println("Informe o ID do funcionario:");
                    identificador = ler.nextInt();
                    sair = false;
                    for(int i = 0; i < quantidadeEmpregados && !sair; i++)
                    {
                        if(listaDeEmpregados[i].id == identificador)
                        {
                            System.out.println("Informe a taxa de serviço R$:");
                            copiaTaxaSindicalExtra=  listaDeEmpregados[i].taxaSindicalExtra;
                            listaDeEmpregados[i].taxaSindicalExtra += ler.nextDouble();
                            sair = true;
                            key = opcao; 
                            idKey= i;
                            System.out.println("A taxa de serviço de R$ "+ listaDeEmpregados[i].taxaSindicalExtra + " foi registrada!");
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado não foi encontrado!");
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
                        	System.out.println("Qual informação você deseja modificar? 1- Nome\n 2- Endereço \n 3- Tipo do funcionário\n 4 - Salario bruto\n 5- Comissao\n 6 Associação Sindical\n 7 Metodo de Pagamento \n 0- sair");
                        	lendoInt = ler.nextInt();
                        	while(lendoInt != 0){                      	
                        	                        	
                        	copiaNovoFuncionario = listaDeEmpregados[idKey];
                        	
                        	if (lendoInt == 1){
                        		System.out.println("Substituir o nome completo do Funcionário: " + listaDeEmpregados[i].nome);
                                listaDeEmpregados[i].nome = ler.nextLine();
                                sair = true;
                                key = opcao;
                        	}
                        	else if(lendoInt == 2){
                        		System.out.println("Substituir o endereço do funcionário: " + listaDeEmpregados[i].endereco);
                                listaDeEmpregados[i].endereco = ler.nextLine();
                                sair = true;
                                key = opcao;
                        	}
                        	else if(lendoInt == 3){
                        		 System.out.println("Substitua o tipo do funcionário: + \n1-Horista\n2-Assalariado \n3-Comissionado\nTipo Atual: " 
                                    + listaDeEmpregados[i].tipo );
                                 listaDeEmpregados[i].tipo = ler.nextInt();
                                 sair = true;
                                 key = opcao;
                        	}
                        	else if(lendoInt == 4){
                        		 System.out.println("Substitua o salário do funcionário:\n" //4
                            + "Se horista, o valor da hora trabalhada\n"
                            + "Se assalariado ou comissionado, o valor mensal"
                                    + "\nValor Atual: R$ " 
                                    + listaDeEmpregados[i].salarioBruto );
                            System.out.print("R$ ");
                            listaDeEmpregados[i].salarioBruto = ler.nextDouble();
                            sair = true;
                            key = opcao;
                        	}	
                        	else if(lendoInt == 5){
                        		System.out.println("Substitua o valor da comissão do funcionário:"); //5
                        		System.out.print("Valor Atual: R$ " + listaDeEmpregados[i].comissao + "\n");
                        		listaDeEmpregados[i].comissao = ler.nextDouble();
                        		sair = true;
                                key = opcao;
                        	}
                        	else if(lendoInt == 6){
                        		System.out.println("Substitua o estado de associação ao sindicato: (S/N)"); //6
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
                        		System.out.println("Substitua o método de pagamento do funcionário:" //7
                            		+ "\n1-Cheque pelos correios"
                                    + "\n2-Cheque em mãos"
                                    + "\n3-Depósito em conta bancária"
                                    + "\nMétodo Atual:" + listaDeEmpregados[i].metodoDePagamento );
                           listaDeEmpregados[i].metodoDePagamento = ler.nextInt();
                           sair = true;
                           key = opcao;
                        	}  
                        	else {
                        		 System.out.println("Opçao inválida!");
                        	}
                        	System.out.println("Qual informação você deseja modificar? 1- Nome\n 2- Endereço \n 3- Tipo do funcionário\n 4 - Salario bruto\n 5- Comissao\n 6 Associação Sindical\n 7 Metodo de Pagamento \n 0- sair");
                        	lendoInt = ler.nextInt();
                        	sair = true;
                            key = opcao;
                        }
                            
                            
                            
                            System.out.println("O funcionário foi editado com sucesso!");
                        }
                    }
                    if( !sair )
                    {
                        System.out.println("O Empregado não foi encontrado!");
                    }
                break;
                case 7: // RODAR A FOLHA DE PAGAMENTO PRA HOJE
                	
        				
        				for(int i =0; i < quantidadeEmpregados; i++)
        				{
        					copia[i] =  new Empregado("", "", 0, 0.0, 0.0, 0);
        					copia[i].nome = listaDeEmpregados[i].nome; 
        					copia[i].endereco = listaDeEmpregados[i].endereco;
        					copia[i].tipo = listaDeEmpregados[i].tipo;
        					copia[i].metodoDePagamento = listaDeEmpregados[i].metodoDePagamento;
        					copia[i].salarioBruto = listaDeEmpregados[i].salarioBruto;
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
        					//System.out.println(funcionário[i].recebimento + "recebe:" + funcionário[i].recebe + "correto" + funcionário[i].correto);
        					if((listaDeEmpregados[i].tipo == 1) && (listaDeEmpregados[i].recebe == listaDeEmpregados[i].correto)){
        						if(listaDeEmpregados[i].salarioLiquido != 0){
        							System.out.println("PAGAMENTO\n\nID:	" + listaDeEmpregados[i].id + "\nNome:	" + listaDeEmpregados[i].nome + "\nSalário bruto:	" + listaDeEmpregados[i].salarioBruto + "\nValor descontado pelo sindicato:	" +  (listaDeEmpregados[i].taxaSindical +  listaDeEmpregados[i].taxaSindicalExtra) + "\nSalário recebido: " + (listaDeEmpregados[i].salarioLiquido -(listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical)));
        							listaDeEmpregados[i].salarioLiquido = 0.0;
        							listaDeEmpregados[i].recebe = 0;
        						}
        					}
        					else if((listaDeEmpregados[i].tipo == 2) && (listaDeEmpregados[i].recebe == listaDeEmpregados[i].correto)){
        						System.out.println("PAGAMENTO\n\nID:	" + listaDeEmpregados[i].id + "\nNome:	" + listaDeEmpregados[i].nome + "\nSalário bruto:	" + listaDeEmpregados[i].salarioBruto + "\nValor descontado pelo sindicato:	" +  (listaDeEmpregados[i].taxaSindical +  listaDeEmpregados[i].taxaSindicalExtra) + "\nSalário recebido: " + (listaDeEmpregados[i].salarioLiquido -(listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical)));
        							listaDeEmpregados[i].recebe = 0;
        							}
        					
        					else if((listaDeEmpregados[i].tipo == 3) && (listaDeEmpregados[i].recebe == listaDeEmpregados[i].correto)){
        						System.out.println("PAGAMENTO\n\nID:	" + listaDeEmpregados[i].id + "\nNome:	" + listaDeEmpregados[i].nome + "\n Salário Bruto :	" + listaDeEmpregados[i].salarioBruto + "+ Comissão : "+listaDeEmpregados[i].comissao +"\nValor descontado pelo sindicato:	" +  (listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical) + "\nSalário recebido: " + (listaDeEmpregados[i].salarioLiquido + listaDeEmpregados[i].comissao -(listaDeEmpregados[i].taxaSindicalExtra +  listaDeEmpregados[i].taxaSindical)));
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
        		
                break;        
                case 8 :	// FAZER OU DESFAZER
                	System.out.println("Digite a opção desejada\n         ");
                    System.out.println("01 - Redo                         ");
                    System.out.println("02 - Undo                         ");
                    opcao = ler.nextInt();
                    double ultimoValor = 0.0;
                    
                    switch (opcao)
                    {
	                case 1: // Redo
	                	
	                	if(key == 1)
	                	{
	                		listaDeEmpregados[idKey] = copiaNovoFuncionario;
	                	}
	                	if(key == 2)
	                	{
	                		listaDeEmpregados[idKey].id = -1;
	                	}
	                	if(key == 3)
	                	{
	                		
	                		listaDeEmpregados[idKey].salarioLiquido= ultimoValor;
	                	}
	                	if(key == 4)
	                	{	
	                		 listaDeEmpregados[idKey].comissao = ultimoValor;
	                		 key = 4;
	                	}
	                	if(key == 5)
	                	{
	                		listaDeEmpregados[idKey].taxaSindicalExtra  = ultimoValor;
	                	}
	                	if(key == 6)
	                	{ 
	                		listaDeEmpregados[idKey] = novoFuncionario;
	                	}
	                	if(key == 7)
	                	{
	                		for(int i =0; i < quantidadeEmpregados; i++)
	        				{
	                		 copia[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido;
	                		 copia[i].recebe = listaDeEmpregados[i].recebe;
	                		 
	                		 listaDeEmpregados[i].salarioLiquido = redo[i].salarioLiquido ;    				
	                		 listaDeEmpregados[i].recebe = redo[i].recebe;
	                		
	        				}
	                	}
	                break;	                	
	                case 2: // UNDO
	                	if(key == 1)
	                	{   
	                		listaDeEmpregados[idKey] = null;
	                	}
	                	if(key == 2)
	                	{
	                		listaDeEmpregados[idKey].id = idKey;
	                	}
	                	if(key == 3)
	                	{
	                		ultimoValor = listaDeEmpregados[idKey].salarioLiquido;
	                		listaDeEmpregados[idKey].salarioLiquido= copiaSalario;
	                	}
	                	if(key == 4)
	                	{
	                		ultimoValor = listaDeEmpregados[idKey].comissao;
	                		 listaDeEmpregados[idKey].comissao = copiaComissao;
	                		 key = 4;
	                	}
	                	if(key == 5)
	                	{
	                		ultimoValor = listaDeEmpregados[idKey].taxaSindicalExtra;
	                		listaDeEmpregados[idKey].taxaSindicalExtra  = copiaTaxaSindicalExtra;
	                	}
	                	if(key == 6)
	                	{ 
	                		novoFuncionario = listaDeEmpregados[idKey];
	                		
	                		listaDeEmpregados[idKey] = copiaNovoFuncionario;
	                		
	                	}
	                	if(key == 7)
	                	{
	                		for(int i =0; i < quantidadeEmpregados; i++) 
	                		{
	                			redo[i].salarioLiquido = listaDeEmpregados[i].salarioLiquido;    				
			                    redo[i].recebe = listaDeEmpregados[i].recebe ;            				
			                    listaDeEmpregados[i].salarioLiquido = copia[i].salarioLiquido ;    				
			                    listaDeEmpregados[i].recebe = copia[i].recebe;
	            			}
	        		   	}
                }
                break;
                case 9:// VIZUALIZAR A AGENDA DE PAGAMENTO
                	System.out.println("Forneça o nome do funcionário a ser editado:");
    				//getchar = scanner.nextLine();
    				lendoString = ler.nextLine();
    				System.out.println("1:	semanalmente\n2: mensalmente\n 3:bi-semanalmente");
    				lendoInt = ler.nextInt();
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
                	System.out.println("Forneça o nome do funcionário a ser editado:\n");
    				//getchar = scanner.nextLine();
    				lendoString = ler.nextLine();
    				sair= false;
    				
    				for(int i=0; i< quantidadeEmpregados; i++)
    				{
    					if(listaDeEmpregados[i].nome.equals(lendoString) && listaDeEmpregados[i].nome != null )
    					{
    						System.out.println("Digite\n1-Mensal\n2-semanal");
    						lendoInt= ler.nextInt();
    						if (lendoInt == 2)
    						{
    							System.out.println("Digite o dia da semana e quantidade de vezes. EX: segunda 2");
    							listaDeEmpregados[i].recebimento = ler.nextLine() ;
    							listaDeEmpregados[i].correto = ler.nextInt();
    							System.out.println("Mudanças realizadas com sucesso!\n");
    							sair= true;
    						}
    					}
    					
    				}
    				if(!sair){
    					System.out.println("Mudanças realizadas com sucesso!\n");
    				}
    				                
                break;
                case 0:
                    System.out.println("O programa foi encerrado com sucesso!"
                            + "\nMuito obrigado pelo uso!!!");
                break;
                default:
                    System.out.println("Você digitou uma opção incorreta,"
                            + " por favor, digite outra opção!\n");
            }   
            break;
                   
        
        }while(opcao != 0);
    }
 }
    
