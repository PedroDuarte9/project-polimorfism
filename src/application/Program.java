package application;

/*
* Fazer um programa para ler os dados de N
produtos (N fornecido pelo usuário). Ao final,
mostrar a etiqueta de preço de cada produto na
mesma ordem em que foram digitados.
Todo produto possui nome e preço. Produtos
importados possuem uma taxa de alfândega, e
produtos usados possuem data de fabricação.
Estes dados específicos devem ser
acrescentados na etiqueta de preço conforme
exemplo (próxima página). Para produtos
importados, a taxa e alfândega deve ser
acrescentada ao preço final do produto.*/

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter the number of Products: ");
        int n = sc.nextInt();

        for (int i = 0; i<n; i++){
            System.out.println("Product #" + i +" data");
            System.out.println("Common, used or imported (c/u/i) ?");
            char opc = sc.next().charAt(0);
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println("Price: ");
            Double price = sc.nextDouble();

            if(opc == 'i'){
                System.out.println("Customs Fee");
                double fee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, fee));

            } else if (opc == 'c') {
                products.add(new Product(name, price));

            } else if (opc == 'u') {
                System.out.println("Enter the Date dd/MM/yyyy");
                Date date = sdf.parse(sc.next()); //Sempre usar sc.next() para datas
                products.add(new UsedProduct(name, price, date));
            }

        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product p: products) {
            System.out.println(p.priceTag());

        }

        sc.close();
    }
}
