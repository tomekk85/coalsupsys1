package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

/**
 * Stan magazynowy
 */
@Data
public class Warehouse {
    Integer currentGRNumber;

    Map<Commodity, Double> stock;// stan magazynowy


    Map<Integer, Document> goodsReceiptRegister;//rejestr PZ

    public void addToStock(Document goodsReceipt){
        Map <Integer, Document.Item> commodities = goodsReceipt.getItems();

        //dodanie danych z PZ do stanu magazynowego
        for(int key : commodities.keySet()){
            Commodity commodity = commodities.get(key).getCommodity();
            Double amount = commodities.get(key).getAmount();

            stock.put(commodity, stock.get(commodity) + amount);
        }
        //dodanie PZ do rejestru PZ
        goodsReceiptRegister.put(currentGRNumber++, goodsReceipt);
    }

    public void releaseFromStock(Document goodsReceipt){
        Map <Integer, Document.Item> commodities = goodsReceipt.getItems();

        for(int key : commodities.keySet()){
            Commodity commodity = commodities.get(key).getCommodity();
            Double amount = commodities.get(key).getAmount();

            Double amountOnStock = stock.get(commodity);
            if (amount < amountOnStock) {
                stock.put(commodity, stock.get(commodity) - amount);
            } else if(amount == amountOnStock){
                stock.remove(commodity);
            } else {
                System.out.println("There is not enough amount of commodity on the stock!");
            }
        }

    }
}
