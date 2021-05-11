package pl.coalgroup.coalsupsys.bootstrap;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coalgroup.coalsupsys.model.*;
import pl.coalgroup.coalsupsys.repositories.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Component
public class BootStrapData implements CommandLineRunner {
    private CustomerRepository clientRepo;
    private SupplierRepository supplierRepo;
    private CommodityRepository commodityRepo;
    private GoodReceiptRepository goodReceiptRepo;
    private GoodReceiptItemRepository goodReceiptItemRepo;

    public BootStrapData(CustomerRepository clientRepo, SupplierRepository supplierRepo, CommodityRepository commodityRepo,
                         GoodReceiptRepository goodReceiptRepo, GoodReceiptItemRepository goodReceiptItemRepo) {
        this.clientRepo = clientRepo;
        this.supplierRepo = supplierRepo;
        this.commodityRepo = commodityRepo;
        this.goodReceiptRepo = goodReceiptRepo;
        this.goodReceiptItemRepo = goodReceiptItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("pl"));


        //initialize Customers - companies
        for(int i =0; i < 30; i++){
            Customer customer = FakeData.createCustomerAsCompany();
            clientRepo.save(customer);
        }
        //initialize Customers - legal persons
        for(int i =0; i < 30; i++){
            Customer customer = FakeData.createCustomerAsLegalPerson();
            clientRepo.save(customer);
        }

        //initialize Suppliers - companies
        for(int i =0; i < 20; i++){
            Supplier supplier = FakeData.createSupplier();
            supplierRepo.save(supplier);
        }

        //initialize Commodities
        for(int i = 0; i < 20; i++){
            Commodity commodity = FakeData.createCommodity();
            commodityRepo.save(commodity);
        }




        //initialize Good Receipts
        GoodReceipt goodReceipt1 = new GoodReceipt();
        goodReceipt1.setSuffix("WZ");
        goodReceipt1.setDocumentNumber(1);
        goodReceipt1.setDateOfIssue(LocalDate.now());
        goodReceipt1.setContractor(clientRepo.findById(1L).get());
        goodReceipt1.setIssuer("Marek Kowalski");

        //initialize Good Receipt Items
        Commodity[] commArray = commodityRepo.findAll().toArray(new Commodity[0]);

        int counter = 1;
        for(Commodity comm: commArray){
            GoodReceiptItem item = new GoodReceiptItem();
            item.setCommodity(commArray[0]);
            item.setAmount(40);
            item.setPosition(counter++);
            goodReceiptItemRepo.save(item);
        }

        List<GoodReceiptItem> itemList = goodReceiptItemRepo.findAll();
        for(GoodReceiptItem item: itemList){
            goodReceipt1.addItem(item);
        }
        goodReceiptRepo.save(goodReceipt1);


        //wydruki
        List<Customer> customers = clientRepo.findAll();
        List<Supplier> suppliers = supplierRepo.findAll();
        List<Commodity> commodities = commodityRepo.findAll();
        List<GoodReceipt> goodReceiptList = goodReceiptRepo.findAll();

        System.out.println(customers);
        System.out.println(suppliers);
        System.out.println(commodities);
        System.out.println(itemList);
        System.out.println(goodReceiptList);
        System.out.println(goodReceiptList.get(0).getNumberOfItems());

    }

}
