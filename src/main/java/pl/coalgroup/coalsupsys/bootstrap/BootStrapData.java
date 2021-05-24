package pl.coalgroup.coalsupsys.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coalgroup.coalsupsys.model.*;
import pl.coalgroup.coalsupsys.repositories.*;

import java.util.List;

/**
 * tu inicjalizujemy dane
 */

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepo;
    private final SupplierRepository supplierRepo;
    private final CommodityRepository commodityRepo;
    private final GoodsReceiptRepository goodsReceiptRepo;
    private final GRRegisterRepository grRegisterRepo;
    private final DeliveryNoteRepository deliveryNoteRepo;
    private final DNRegisterRepository dnRegisterRepo;
    private final StockRepository stockRepo;

    public BootStrapData(CustomerRepository clientRepo, SupplierRepository supplierRepo, CommodityRepository commodityRepo,
                         GoodsReceiptRepository goodsReceiptRepo, GRRegisterRepository grRegisterRepo, DeliveryNoteRepository deliveryNoteRepo, DNRegisterRepository dnRegisterRepo, StockRepository stockRepo) {
        this.customerRepo = clientRepo;
        this.supplierRepo = supplierRepo;
        this.commodityRepo = commodityRepo;
        this.goodsReceiptRepo = goodsReceiptRepo;
        this.grRegisterRepo = grRegisterRepo;
        this.deliveryNoteRepo = deliveryNoteRepo;
        this.dnRegisterRepo = dnRegisterRepo;
        this.stockRepo = stockRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //initialize Customers - companies
        for (int i = 0; i < 30; i++) {
            Customer customer = FakeData.createCustomerAsCompany();
            customerRepo.save(customer);
        }
        //initialize Customers - legal persons
        for (int i = 0; i < 30; i++) {
            Customer customer = FakeData.createCustomerAsLegalPerson();
            customerRepo.save(customer);
        }

        //initialize Suppliers - companies
        for (int i = 0; i < 20; i++) {
            Supplier supplier = FakeData.createSupplier();
            supplierRepo.save(supplier);
        }

        //initialize Commodities
        for (int i = 0; i < 7; i++) {
            Commodity commodity = FakeData.createCommodity(i + 1);
            commodityRepo.save(commodity);
        }

        //initialize Good Receipts
        for (int i = 0; i < 225; i++) {
            GoodsReceipt goodsReceipt = FakeData.createGoodsReceipt(supplierRepo.findAll(), commodityRepo.findAll());

            //Stock
            for (GoodsReceipt.Item item: goodsReceipt.getItems()){
                Stock stock = new Stock();
                stock.setCommodity(item.getCommodity());
                stock.setAmount(item.getAmount());

                List<Stock> list = stockRepo.findAll();

                for(Stock element : list){
                    if(stock.getCommodity().equals(element.getCommodity())){
                        stock.setId(element.getId());
                        stock.setAmount(stock.getAmount()+ element.getAmount());
                        break;
                    }
                }
                stockRepo.save(stock);
            }

            //Goods Receipt Register
            GoodsReceiptRegister register = new GoodsReceiptRegister();
            register.setGoodsReceipt(goodsReceipt);

            goodsReceiptRepo.save(goodsReceipt);

            grRegisterRepo.save(register);

        }

        //initialize Delivery Notes
        for (int i = 0; i < 3; i++) {
            DeliveryNote deliveryNote = FakeData.createDeliveryNote(customerRepo.findAll(), commodityRepo.findAll());
            deliveryNoteRepo.save(deliveryNote);
            DeliveryNoteRegister register = new DeliveryNoteRegister();
            register.setDeliveryNote(deliveryNote);

            dnRegisterRepo.save(register);
        }

        //Lists
        List<Customer> customers = customerRepo.findAll();
        List<Supplier> suppliers = supplierRepo.findAll();
        List<Commodity> commodities = commodityRepo.findAll();
        List<GoodsReceipt> goodsReceiptList = goodsReceiptRepo.findAll();
        List<DeliveryNote> deliveryNoteList = deliveryNoteRepo.findAll();

        List<Stock> stockList = stockRepo.findAll();

        //print outs
//        System.out.println(customers);
//        System.out.println(suppliers);
//        System.out.println(commodities);
//        System.out.println(goodsReceiptList);
//        System.out.println(deliveryNoteList);
//        System.out.println(stockList);
    }

}
