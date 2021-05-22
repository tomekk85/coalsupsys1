package pl.coalgroup.coalsupsys.bootstrap;

import com.github.javafaker.Faker;
import pl.coalgroup.coalsupsys.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * klasa do tworzenia fikcyjnych danych
 */
public class FakeData {
    static Faker faker = new Faker(new Locale("pl"));

    public static Customer createCustomerAsCompany() {
        Customer customer = new Customer();
        String companyName = faker.company().name();
        customer.setName(companyName);

        //adres
        customer.setCity(faker.address().city());
        customer.setStreet(faker.address().streetName());
        customer.setZipcode(faker.address().zipCode());
        customer.setBuildingNo(faker.number().numberBetween(1, 150));
        customer.setLocalNo(faker.number().numberBetween(1, 100));

        customer.setNIP(faker.number().numberBetween(1, 9) + faker.number().digits(9));
        customer.setBdo("0000" + faker.number().numberBetween(1, 9) + faker.number().digits(9));
        customer.setRegon(faker.number().numberBetween(1, 9) + faker.number().digits(13));
        //e-mail

        String pref = companyName.replaceAll("\\p{Punct}", "");//-znaki interpukcyjne
        pref = pref.contains(" ") ? pref.split(" ")[0] : pref;//-spacje
        customer.setEMail(withoutPolishSigns(pref.toLowerCase()) + "@gmail.com");

        customer.setPhoneNo(faker.phoneNumber().phoneNumber());
        return customer;
    }

    public static Customer createCustomerAsLegalPerson() {
        Customer customer = new Customer();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        //adres
        customer.setCity(faker.address().city());
        customer.setStreet(faker.address().streetName());
        customer.setZipcode(faker.address().zipCode());
        customer.setBuildingNo(faker.number().numberBetween(1, 150));
        customer.setLocalNo(faker.number().numberBetween(1, 100));

        customer.setPESEL(faker.number().digits(11));
        //e-mail
        customer.setEMail(withoutPolishSigns(firstName.toLowerCase()) + "_" + withoutPolishSigns(lastName.toLowerCase()) + "@gmail.com");

        customer.setPhoneNo(faker.phoneNumber().phoneNumber());
        return customer;
    }

    public static Supplier createSupplier() {
        Supplier supplier = new Supplier();
        String companyName = faker.company().name();
        supplier.setName(companyName);

        //adres
        supplier.setCity(faker.address().city());
        supplier.setStreet(faker.address().streetName());
        supplier.setZipcode(faker.address().zipCode());
        supplier.setBuildingNo(faker.number().numberBetween(1, 150));
        supplier.setLocalNo(faker.number().numberBetween(1, 100));

        supplier.setNIP(faker.number().numberBetween(1, 9) + faker.number().digits(9));
        supplier.setBdo("0000" + faker.number().numberBetween(1, 9) + faker.number().digits(9));
        supplier.setRegon(faker.number().numberBetween(1, 9) + faker.number().digits(13));
        //e-mail
        String pref = companyName.replaceAll("\\p{Punct}", "");//-znaki interpukcyjne
        pref = pref.contains(" ") ? pref.split(" ")[0] : pref;//-spacje
        supplier.setEMail(withoutPolishSigns(pref.toLowerCase()) + "@gmail.com");


        supplier.setPhoneNo(faker.phoneNumber().phoneNumber());

        return supplier;
    }

    public static Commodity createCommodity(int number) {
        Commodity commodity = new Commodity();
        commodity.setName("Węgiel kamienny - rodzaj " + number);
        commodity.setCode("CN" + faker.number().numberBetween(2700, 2800));

        //jednostka
        int pick = new Random().nextInt(Commodity.Unit.values().length);
        commodity.setUnit(Commodity.Unit.t);
        //commodity.setUnit(Commodity.Unit.values()[pick]);//losowo

        commodity.setPrice((double) faker.number().numberBetween(70000, 120000) / 100.0);
        return commodity;
    }

    public static GoodsReceipt createGoodsReceipt(List<Supplier> suppliers, List<Commodity> commodities){
        int startSupp = 0;
        int endSupp = suppliers.size();
        int startComm = 0;
        int endComm = commodities.size();

        GoodsReceipt goodsReceipt = new GoodsReceipt();
        goodsReceipt.setDateOfIssue(LocalDate.now());
        goodsReceipt.setIssuer("Marek Kowalski");
        goodsReceipt.setSupplier(suppliers.get(faker.number().numberBetween(startSupp, endSupp)));

        //set items
        for (int i = 0; i < faker.number().numberBetween(1, 20); i++){
            goodsReceipt.addItem(commodities.get(faker.number().numberBetween(startComm, endComm)),
                    (double)faker.number().numberBetween(1,50));
        }

        return goodsReceipt;
    }

    public static DeliveryNote createDeliveryNote(List<Customer> customers, List<Commodity> commodities){
        int startCust = 0;
        int endCust = customers.size();
        int startComm = 0;
        int endComm = commodities.size();

        DeliveryNote deliveryNote = new DeliveryNote();
        deliveryNote.setDateOfIssue(LocalDate.now());
        deliveryNote.setIssuer("Jadwiga Nowak");
        deliveryNote.setCustomer(customers.get(faker.number().numberBetween(startCust, endCust)));

        //set items
        for (int i = 0; i < faker.number().numberBetween(1, 20); i++){
            deliveryNote.addItem(commodities.get(faker.number().numberBetween(startComm, endComm)),
                    (double)faker.number().numberBetween(1,35));
        }

        return deliveryNote;
    }

    //funkcja pomocnicza
    private static String withoutPolishSigns(String word) {
        StringBuilder sb = new StringBuilder();
        int L = word.length();
        for (int I = 0; I < L; I++) {
            switch (word.charAt(I)) {
                case 'ą':
                    sb.append('a');
                    break;
                case 'ć':
                    sb.append('c');
                    break;
                case 'ę':
                    sb.append('e');
                    break;
                case 'ł':
                    sb.append('l');
                    break;
                case 'ń':
                    sb.append('n');
                    break;
                case 'ó':
                    sb.append('o');
                    break;
                case 'ś':
                    sb.append('s');
                    break;
                case 'ź':
                    sb.append('z');
                    break;
                case 'ż':
                    sb.append('z');
                    break;
//                case 'Ą': sb.append('A'); break;
//                case 'Ć': sb.append('C'); break;
//                case 'Ę': sb.append('E'); break;
//                case 'Ł': sb.append('L'); break;
//                case 'Ń': sb.append('N'); break;
//                case 'Ó': sb.append('O'); break;
//                case 'Ś': sb.append('S'); break;
//                case 'Ź': sb.append('Z'); break;
//                case 'Ż': sb.append('Z'); break;
                default:
                    sb.append(word.charAt(I));
                    break;
            }
        }
        return sb.toString();
    }
}
