package pl.coalgroup.coalsupsys.bootstrap;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import pl.coalgroup.coalsupsys.model.Commodity;
import pl.coalgroup.coalsupsys.model.Customer;
import pl.coalgroup.coalsupsys.model.Supplier;

import java.util.Locale;

/**
 * klasa do tworzenia fikcyjnych danych
 */
public class FakeData {
    static Faker faker = new Faker(new Locale("pl"));

    public static Customer createCustomerAsCompany(){
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
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        customer.setEMail(fakeValuesService.bothify("????##@gmail.com"));

        customer.setPhoneNo(faker.phoneNumber().phoneNumber());
        return customer;
    }

    public static Customer createCustomerAsLegalPerson(){
        Customer customer = new Customer();
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());

        //adres
        customer.setCity(faker.address().city());
        customer.setStreet(faker.address().streetName());
        customer.setZipcode(faker.address().zipCode());
        customer.setBuildingNo(faker.number().numberBetween(1, 150));
        customer.setLocalNo(faker.number().numberBetween(1, 100));

        customer.setPESEL(faker.number().digits(11));
        //e-mail
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        customer.setEMail(fakeValuesService.bothify("????##@gmail.com"));

        customer.setPhoneNo(faker.phoneNumber().phoneNumber());
        return customer;
    }

    public static Supplier createSupplier(){
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
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        supplier.setEMail(fakeValuesService.bothify("????##@gmail.com"));

        supplier.setPhoneNo(faker.phoneNumber().phoneNumber());

        return supplier;
    }

    public static Commodity createCommodity(){
        Commodity commodity = new Commodity();
        commodity.setName("Węgiel kamienny - rodzaj " + faker.number().numberBetween(0, 10));
        commodity.setCode("CN" + faker.number().numberBetween(2700, 2705));
        commodity.setUnit(Commodity.Unit.t);
        commodity.setPrice((double) faker.number().numberBetween(70000, 120000)/ 100.0);
        return commodity;
    }
}
