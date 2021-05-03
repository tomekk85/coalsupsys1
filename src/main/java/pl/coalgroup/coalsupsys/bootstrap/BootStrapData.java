package pl.coalgroup.coalsupsys.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.coalgroup.coalsupsys.model.*;
import pl.coalgroup.coalsupsys.repositories.*;

import java.time.LocalDate;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    private AddressRepository addressRepo;
    private CompanyRepository companyRepo;
    private LegalPersonRepository legalPersonRepo;
    private CommodityRepository commodityRepo;
    private GoodReceiptRepository goodReceiptRepo;
    private GoodReceiptItemRepository goodReceiptItemRepo;

    public BootStrapData(AddressRepository addressRepo, CompanyRepository companyRepo,
                         LegalPersonRepository legalPersonRepo, CommodityRepository commodityRepo,
                         GoodReceiptRepository goodReceiptRepo, GoodReceiptItemRepository goodReceiptItemRepo) {
        this.addressRepo = addressRepo;
        this.companyRepo = companyRepo;
        this.legalPersonRepo = legalPersonRepo;
        this.commodityRepo = commodityRepo;
        this.goodReceiptRepo = goodReceiptRepo;
        this.goodReceiptItemRepo = goodReceiptItemRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        //initialize Addresses
        Address address1 = new Address();
        address1.setCity("Koszalin");
        address1.setStreet("Monte Cassino");
        address1.setZipcode("75-000");
        address1.setBuildingNo(55);
        address1.setLocalNo(5);
        Address address2 = new Address();
        address2.setCity("Słupsk");
        address2.setStreet("Wojska Polskiego");
        address2.setZipcode("76-200");
        address2.setBuildingNo(1);
        address2.setLocalNo(2);
        Address address3 = new Address();
        address3.setCity("Warszawa");
        address3.setStreet("Nowy Świat");
        address3.setZipcode("00-504");
        address3.setBuildingNo(34);
        address3.setLocalNo(18);

        addressRepo.save(address1);
        addressRepo.save(address2);
        addressRepo.save(address3);


        //initialize Companies
        Company pomorzanka = new Company();
        pomorzanka.setName("Pomorzanka");
        pomorzanka.setAddress(address2);
        pomorzanka.setCustomer(true);
        pomorzanka.setSupplier(false);
        pomorzanka.setNIP("7772555842");
        pomorzanka.setBdo("000030979");
        pomorzanka.setRegon("639852493");
        pomorzanka.setEMail("biuro@pomorzanka.pl");
        pomorzanka.setPhoneNo("501011812");

        companyRepo.save(pomorzanka);

        //initialize LegalPersons
        LegalPerson legalPerson = new LegalPerson();
        legalPerson.setCustomer(true);
        legalPerson.setSupplier(false);
        legalPerson.setFirstName("Marek");
        legalPerson.setLastName("Kowalski");
        legalPerson.setPESEL("83041511326");
        legalPerson.setAddress(address1);
        legalPerson.setEMail("jankowalski@gmail.com");
        legalPerson.setPhoneNo("666777999");
        legalPersonRepo.save(legalPerson);

        //initialize Commodities
        Commodity commodity1 = new Commodity();
        commodity1.setName("Węgiel kamienny - Orzech I");
        commodity1.setCode("CN2701");
        commodity1.setUnit(Commodity.Unit.t);
        commodity1.setPrice(830.08);

        Commodity commodity2 = new Commodity();
        commodity2.setName("Węgiel kamienny - Orzech II");
        commodity2.setCode("CN2701");
        commodity2.setUnit(Commodity.Unit.t);
        commodity2.setPrice(756.10);

        Commodity commodity3 = new Commodity();
        commodity3.setName("Węgiel kamienny - Groszek");
        commodity3.setCode("CN2701");
        commodity3.setUnit(Commodity.Unit.t);
        commodity3.setPrice(860.98);

        Commodity commodity4 = new Commodity();
        commodity4.setName("Koks-Orzech");
        commodity4.setCode("CN2704 00");
        commodity4.setUnit(Commodity.Unit.t);
        commodity4.setPrice(986.18);

        Commodity commodity5 = new Commodity();
        commodity5.setName("Węgiel brunatny");
        commodity5.setCode("2702");
        commodity5.setUnit(Commodity.Unit.t);
        commodity5.setPrice(779.67);

        commodityRepo.save(commodity1);
        commodityRepo.save(commodity2);
        commodityRepo.save(commodity3);
        commodityRepo.save(commodity4);
        commodityRepo.save(commodity5);

        //initialize Good Receipts
        GoodReceipt goodReceipt1 = new GoodReceipt();
        goodReceipt1.setSuffix("WZ");
        goodReceipt1.setDocumentNumber(1);
        goodReceipt1.setDateOfIssue(LocalDate.now());
        goodReceipt1.setContractor(pomorzanka);
        goodReceipt1.setIssuer("Marek Kowalski");

        //initialize Good Receipt Items
        Commodity[] commArray = {commodity1, commodity2, commodity3, commodity4, commodity5};

        int counter = 1;
        for(Commodity comm: commArray){
            GoodReceiptItem item = new GoodReceiptItem();
            item.setCommodity(commodity1);
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
        List<Address> addresses = addressRepo.findAll();
        List<Company> companies = companyRepo.findAll();
        List<LegalPerson> legalPersonList = legalPersonRepo.findAll();
        List<Commodity> commodities = commodityRepo.findAll();
        List<GoodReceipt> goodReceiptList = goodReceiptRepo.findAll();

        System.out.println(addresses);
        System.out.println(companies);
        System.out.println(legalPersonList);
        System.out.println(commodities);
        System.out.println(itemList);
        System.out.println(goodReceiptList);
        System.out.println(goodReceiptList.get(0).getNumberOfItems());
    }

}
