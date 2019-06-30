import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;


public class ProductsMain {
    public static void main(String[] args) {
        ArrayList<Products> products = new ArrayList<>();

        products.add(new Products("Telewizor LG",new BigDecimal(3000), new BigDecimal(23)));
        products.add(new Products("Telewizor LG",new BigDecimal(1000), new BigDecimal(19)));
        products.add(new Products("Telewizor LG",new BigDecimal(4000), new BigDecimal(21)));
        products.add(new Products("Telewizor LG",new BigDecimal(2500), new BigDecimal(20)));

        System.out.println("Netto suma " +netSum(products));
        System.out.println("Brutto suma "+grossSum(products));
        System.out.println("Suma vat "+ vatSum(products));


    }

    static BigDecimal netSum(ArrayList<Products>   products){
        BigDecimal sum= new BigDecimal(0);
        for (int i = 0; i <products.size() ; i++) {
            sum=sum.add(products.get(i).getNetPrice());
        }
        return sum;
    }

    static BigDecimal grossSum(ArrayList<Products> products){
        BigDecimal sumGross= new BigDecimal(0);
        BigDecimal sumVat = new BigDecimal(0);
        for (int i = 0; i <products.size() ; i++) {
            BigDecimal vat= products.get(i).getVatRate();
            BigDecimal nett = products.get(i).getNetPrice();
            BigDecimal tax = nett.multiply(vat.divide(new BigDecimal(100)));
            sumVat = sumGross.add(tax);
            BigDecimal brutto=nett.add(tax);
            sumGross=sumGross.add(brutto);
        }
        return sumGross;
    }

    static BigDecimal vatSum(ArrayList<Products> products){
        BigDecimal sumGross= new BigDecimal(0);
        BigDecimal sumVat = new BigDecimal(0);
        for (int i = 0; i <products.size() ; i++) {
            BigDecimal vat= products.get(i).getVatRate();
            BigDecimal nett = products.get(i).getNetPrice();
            BigDecimal tax = nett.multiply(vat.divide(new BigDecimal(100)));
            sumVat = sumVat.add(tax);

        }
        return sumVat;
    }

    static BigDecimal[] table(ArrayList<Products> products){//obliczanie vatu i brutto w jednej metodzie
        BigDecimal[] table = new BigDecimal[2];
        Arrays.fill(table, BigDecimal.ZERO);
        BigDecimal sumGross= new BigDecimal(0);
        BigDecimal sumVat = new BigDecimal(0);
        for (int i = 0; i <products.size() ; i++) {
            BigDecimal vat= products.get(i).getVatRate();
            BigDecimal nett = products.get(i).getNetPrice();
            BigDecimal tax = nett.multiply(vat.divide(new BigDecimal(100)));
            table[1] = table[1].add(tax);
            BigDecimal brutto=nett.add(tax);
            table[0]=table[0].add(brutto);
        }
        return table;
    }

}
