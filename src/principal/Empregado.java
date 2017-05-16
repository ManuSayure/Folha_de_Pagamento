package principal;

public class Empregado
{
    public boolean pertencenteAoSindicato;
    public int id, tipo, metodoDePagamento, idSindicato;
    public String nome, endereco;
    public double salarioBruto, comissao, taxaSindical, taxaSindicalExtra;
    public double salarioLiquido;
    public int agenda;
    public String recebimento = "sexta";
	public int recebe = 0;
	public int correto = 0;
    
    public Empregado( String novoNome, String novoEndereco, int novoTipo, 
            double novoSalario, double novaComissao, int novoId, int agenda)
    {
        nome = novoNome;
        endereco = novoEndereco;
        tipo = novoTipo;
        salarioBruto = novoSalario;
        comissao = novaComissao;
        id = novoId;
        pertencenteAoSindicato = false;
        metodoDePagamento = 1;//Por padrão todos recebem um cheque pelo correio
        taxaSindical = 0.0;
        taxaSindicalExtra = 0.0;
        salarioLiquido = 0.0;
        this.agenda = agenda;
        
    }
}