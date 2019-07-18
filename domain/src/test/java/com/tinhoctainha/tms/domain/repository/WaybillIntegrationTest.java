package com.tinhoctainha.tms.domain.repository;

import com.tinhoctainha.tms.domain.model.Booking;
import com.tinhoctainha.tms.domain.model.Contact;
import com.tinhoctainha.tms.domain.model.Customer;
import com.tinhoctainha.tms.domain.model.Province;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest(excludeAutoConfiguration = {FlywayAutoConfiguration.class})
public class WaybillIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RomoocRepository romoocRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private CommodityRepository commodityRepository;

    @Autowired
    private CostRepository costRepository;

    @Autowired
    private ShippingListRepository shippingListRepository;

    @Autowired
    private LedgerDetailRepository ledgerDetailRepository;

    @Autowired
    private LedgerRepository ledgerRepository;

    @Before
    public void before(){
        entityManager.clear();
        Province province = new Province();
        province.setName("Đồng Nai");
        provinceRepository.saveAndFlush(province);

        Customer customer = new Customer();
        customer.setCustomerCode("KH1");
        customer.setName("Việt Trade");
        customer.setCompany("Công ty TNHH Việt Trade");
        customer.setIdNumber("3603259123");
        customer.setAddress("Biên Hòa, Đồng Nai");
        customer.setPhone("02513 937 677");
        customer.setFax("02513 937 677");
        customer.setEmail("it@viet-trade.org");
        customer.setBankAccount("000012132");
        customer.setBankName("BIDV");
        customer.setBankBranch("CN Nam Đồng Nai");
        customer.setIsSupplier(1);
        customer.setProvince(province);
        customerRepository.saveAndFlush(customer);

        Date birthDate = new Date();
        String date = "17/07/2019";
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            birthDate = formatter.parse(date);
        }catch (java.text.ParseException e){
            e.printStackTrace();
        }

        Contact contact = new Contact();
        contact.setName("Nguyễn Văn Tèo");
        contact.setBirthDate(birthDate);
        contact.setGender(1);
        contact.setPhone("0902 085 911");
        contact.setEmail("it@viet-trade.org");
        contact.setPosition("Giám đốc");
        contact.setCustomer(customer);
        contactRepository.saveAndFlush(contact);

        Booking booking = new Booking();
        booking.setBookingNumber("A0023");
        booking.setBookingDate(birthDate);
        booking.setBookingType(1);
        booking.setNote("Ghi chú ở đây");
        booking.setCustomer(customer);
        bookingRepository.saveAndFlush(booking);
    }

    @Test
    public void test_customer(){
        Customer customer = new Customer();
        List<Customer> customers = customerRepository.findAll();
        assertThat(customers.size()).isEqualTo(1);
        customer = customers.get(0);
        List<Contact> contacts = contactRepository.findContactByCustomerId(customer.getId());
//        assertThat(contacts.size()).isEqualTo(1);
//        assertThat(contacts.get(0).getPhone()).isEqualTo("0902 085 911");
    }
}
