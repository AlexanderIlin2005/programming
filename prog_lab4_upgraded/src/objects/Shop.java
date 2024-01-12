package objects;

import enums.Gender;
import enums.Money;
import enums.Product;
import exceptions.NoMoneyException;
import exceptions.UnableToMakePurchaseException;
import exceptions.cannotSetPriceException;

import java.util.ArrayList;

public class Shop extends Place {
    final Human salesman;
    private Stock stock = new Stock();

    public class Stock{
        private ArrayList<Product> productsList = new ArrayList<>();
        private ArrayList<Money> pricesList = new ArrayList<>();
        public void addProduct(Product newProduct, Money newPrice){
            int index = newProduct.ordinal();
            if (index >= productsList.size()) {
                for (int i = productsList.size(); i < index; i++) {
                    productsList.add(null);
                    pricesList.add(null);
                }
                productsList.add(newProduct);
                pricesList.add(newPrice);
            } else {
                productsList.set(index, newProduct);
                pricesList.set(index, newPrice);
            }
            //productsList.add(newProduct);
        }

        public void removeProduct(Product product){
            productsList.set(product.ordinal(), null);
            pricesList.set(product.ordinal(), null);
        }
        public void setPrice(Product product, Money newPrice) throws cannotSetPriceException {
            if (productsList.contains(product)){
                pricesList.set(product.ordinal(), newPrice);
            } else throw new cannotSetPriceException("Невозможно установить цену товару "+"["+product+"]"
                    +", так как его нет в списке товаров");

        }
        public Money getPrice(Product product){
            return pricesList.get(product.ordinal());
        }
        public ArrayList<Product> getProductsList(){
            return this.productsList;
        }

    }
    public Shop(String name, Gender gender, Human salesman) {
        super(name, gender);
        this.salesman=salesman;
        {
            System.out.println("Магазин");
        }

    }

    public void sell(Human human, Product product) throws UnableToMakePurchaseException {
        if (human.place == this) {
            try {
                human.giveMoney(this.stock.getPrice(product), this.salesman);
                human.receiveProduct(product);
            } catch (NoMoneyException e) {}
        } else throw new UnableToMakePurchaseException(human, this);

    }

    public Stock getAccessToStock(){
        //System.out.println(this.stock.getProductsList().size());
        return this.stock;
    }

    //public void addProduct(Product product, Money price){
    //    Stock.addProduct(product, price);
    //}

    //public void setPrice(Product product, Money price) throws cannotSetPriceException {
    //    Stock.setPrice(product, price);
    //}
}
