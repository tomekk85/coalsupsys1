package pl.coalgroup.coalsupsys.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Stan magazynowy
 */
@Entity
@Data
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    Integer currentGRNumber;
    Integer currentDNNumber;

    public Warehouse() {
        currentGRNumber = 1;
        currentDNNumber = 1;
    }
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //Map<Commodity, Double> stock;// stan magazynowy

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    Map<Integer, GoodsReceipt> goodsReceiptRegister = new HashMap<>();//rejestr PZ

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    Map<Integer, DeliveryNote> deliveryNoteRegister = new HashMap<>();//rejestr WZ

    public void addToStock(GoodsReceipt goodsReceipt){
        Map <Integer, GoodsReceipt.Item> commodities = goodsReceipt.getItems();

        //dodanie danych z PZ do stanu magazynowego
        for(int key : commodities.keySet()){
            Commodity commodity = commodities.get(key).getCommodity();
            Double amount = commodities.get(key).getAmount();

            //stock.put(commodity, stock.get(commodity) + amount);
        }
        //dodanie PZ do rejestru PZ
        goodsReceiptRegister.put(currentGRNumber++, goodsReceipt);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "goodsReceiptRegister=" + goodsReceiptRegister +
                ", deliveryNoteRegister=" + deliveryNoteRegister +
                '}';
    }

    public void releaseFromStock(DeliveryNote deliveryNote){
        Map <Integer, DeliveryNote.Item> commodities = deliveryNote.getItems();

        for(int key : commodities.keySet()){
            Commodity commodity = commodities.get(key).getCommodity();
            Double amount = commodities.get(key).getAmount();

//            Double amountOnStock = stock.get(commodity);
//            if (amount < amountOnStock) {
//                stock.put(commodity, stock.get(commodity) - amount);
//            } else if(amount == amountOnStock){
//                stock.remove(commodity);
//            } else {
//                System.out.println("There is not enough amount of commodity on the stock!");
//            }
        }



    }
}
