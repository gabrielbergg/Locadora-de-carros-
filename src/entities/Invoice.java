package entities;

public class Invoice {
    private Double pagamentoBasico;
    private Double taxa;

    
    public Invoice(Double pagamentoBasico, Double taxa) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxa = taxa;
    }


    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }


    public Double getTaxa() {
        return taxa;
    }

    public Double totalPagamento() {
        return getPagamentoBasico() + getTaxa();
    }
    
}
