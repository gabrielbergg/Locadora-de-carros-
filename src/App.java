import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.CarRental;
import entities.Veiculo;
import serviços.RentalService;
import serviços.TaxaBrasil;






public class App {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in, "CP850");
        String modelo, retirada, retorno;
        Double preçoHora, preçoDia;
        
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
       

        System.out.print("Modelo do carro: ");
        modelo = leia.nextLine();
        System.out.print("Retirada (dd/mm/aaaa hh:mm): ");
        retirada = leia.nextLine();
        System.out.print("Retorno (dd/mm/aaaa hh:mm): ");
        retorno = leia.nextLine();

        LocalDateTime ld = LocalDateTime.parse(retirada, dt);
        LocalDateTime ld2 = LocalDateTime.parse(retorno, dt);

        Veiculo veiculo = new Veiculo(modelo);
        CarRental carRental = new CarRental(ld, ld2, veiculo);
       
        System.out.print("Informe o preço por hora: ");
        preçoHora = leia.nextDouble();
        System.out.print("Informe o preço por dia: ");
        preçoDia = leia.nextDouble();
        
        RentalService rentalService = new RentalService(preçoHora, preçoDia, new TaxaBrasil());

        rentalService.processInvoice(carRental);

        System.out.println("\nFATURA: ");
        System.out.println("Pagamento básico: "+carRental.getFatura().getPagamentoBasico());
        System.out.println("Imposto: " +carRental.getFatura().getTaxa());
        System.out.println("Pagamento total: " +carRental.getFatura().totalPagamento());

        leia.close();
    }
  

}
