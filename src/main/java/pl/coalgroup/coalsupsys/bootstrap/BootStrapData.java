package pl.coalgroup.coalsupsys.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coalgroup.coalsupsys.model.*;
import pl.coalgroup.coalsupsys.repositories.*;

import java.time.LocalDate;
import java.util.List;

/**
 * tu inicjalizujemy dane
 */

@Component
public class BootStrapData implements CommandLineRunner {
    private CustomerRepository customerRepo;
    private SupplierRepository supplierRepo;
    private CommodityRepository commodityRepo;
    private GoodsReceiptRepository goodsReceiptRepo;
    private DeliveryNoteRepository deliveryNoteRepo;

    public BootStrapData(CustomerRepository clientRepo, SupplierRepository supplierRepo, CommodityRepository commodityRepo,
                         GoodsReceiptRepository goodsReceiptRepo, DeliveryNoteRepository deliveryNoteRepo) {
        this.customerRepo = clientRepo;
        this.supplierRepo = supplierRepo;
        this.commodityRepo = commodityRepo;
        this.goodsReceiptRepo = goodsReceiptRepo;
        this.deliveryNoteRepo = deliveryNoteRepo;
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
        for (int i = 0; i < 3; i++) {
            GoodsReceipt goodsReceipt = FakeData.createGoodsReceipt(supplierRepo.findAll(), commodityRepo.findAll());
            goodsReceiptRepo.save(goodsReceipt);
        }

        //initialize Delivery Notes
        for (int i = 0; i < 3; i++) {
            DeliveryNote deliveryNote = FakeData.createDeliveryNote(customerRepo.findAll(), commodityRepo.findAll());
            deliveryNoteRepo.save(deliveryNote);
        }

        //wydruki
        List<Customer> customers = customerRepo.findAll();
        List<Supplier> suppliers = supplierRepo.findAll();
        List<Commodity> commodities = commodityRepo.findAll();
        List<GoodsReceipt> goodsReceiptList = goodsReceiptRepo.findAll();
        List<DeliveryNote> deliveryNoteList = deliveryNoteRepo.findAll();

        System.out.println(customers);
        System.out.println(suppliers);
        System.out.println(commodities);
        System.out.println(goodsReceiptList);
        System.out.println(deliveryNoteList);
    }

}
