package com.gumtree.addressbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gumtree.addressbook.business.AddressService;

/**
 * The Class Launch.
 */
public class Launch 
{
    
    /**
     * The main method to launch the application.
     *
     * @param args the arguments
     */
    public static void main( String[] args)
    {
        System.setProperty("address.book.filename", "src/main/resources/address.txt");
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/beans.xml");
        
        AddressService addressService = context.getBean(AddressService.class);
        System.out.println("1.  How many males are in the address book?\nAnswer : "+addressService.getCountOfMales());
        System.out.println("2.  Who is the oldest person in the address book?\nAnswer : "+addressService.getOldestPersonName());
        System.out.println("3.  How many days older is Bill than Paul?\nAnswer : "+addressService.getDifferenceInDays("Bill McKnight", "Paul Robinson"));
    }
}
