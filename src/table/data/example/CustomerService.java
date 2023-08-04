/*
 * The MIT License
 *
 * Copyright (c) 2009-2023 PrimeTek Informatics
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package table.data.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;


public class CustomerService {

    private Random random = new SecureRandom();
    private Country[] countries;    
    private String[] firstNames;
    private String[] lastNames;
    private String[] companies;

    
    public CustomerService() {
        countries = new Country[]{
            new Country(0, "Argentina", "ar"),
            new Country(1, "Australia", "au"),
            new Country(2, "Brazil", "br"),
            new Country(3, "Canada", "ca"),
            new Country(4, "Germany", "de"),
            new Country(5, "France", "fr"),
            new Country(6, "India", "in"),
            new Country(7, "Italy", "it"),
            new Country(8, "Japan", "jp"),
            new Country(9, "Russia", "ru"),
            new Country(10, "Spain", "es"),
            new Country(11, "United Kingdom", "gb")};

        companies = new String[]{"Benton, John B Jr", "Chanay, Jeffrey A Esq", "Chemel, James L Cpa", "Feltz Printing Service",
            "Printing Dimensions", "Chapman, Ross E Esq", "Morlong Associates", "Commercial Press", "Truhlar And Truhlar Attys",
            "King, Christopher A Esq", "Dorl, James J Esq", "Rangoni Of Florence", "Feiner Bros", "Buckley Miller Wright",
            "Rousseaux, Michael Esq"};
     
        firstNames = new String[]{"James", "David", "Jeanfrancois", "Ivar", "Tony",
            "Adams", "Claire", "Costa", "Juan", "Maria", "Jennifer",
            "Stacey", "Leja", "Morrow", "Arvin", "Darci", "Izzy",
            "Ricardo", "Clifford", "Emily", "Kadeem", "Mujtaba", "Aika",
            "Mayumi", "Misaki", "Silvio", "Nicolas", "Antonio",
            "Deepesh", "Aditya", "Aruna", "Jones", "Julie", "Smith",
            "Johnson", "Francesco", "Salvatore", "Kaitlin", "Faith",
            "Maisha", "Jefferson", "Leon", "Rodrigues", "Alejandro",
            "Munro", "Cody", "Chavez", "Sinclair", "Isabel", "Octavia",
            "Murillo", "Greenwood", "Wickens", "Ashley"};
        lastNames = new String[]{"Butt", "Darakjy", "Venere", "Paprocki", "Foller",
            "Morasca", "Tollner", "Dilliard", "Wieser", "Marrier", "Amigon",
            "Maclead", "Caldarera", "Ruta", "Albares", "Poquette", "Garufi",
            "Gaucho", "Rim", "Whobrey", "Flosi", "Nicka", "Inouye",
            "Kolmetz", "Royster", "Slusarski", "Iturbide", "Caudy",
            "Chui", "Kusko", "Figeroa", "Vocelka", "Stenseth", "Glick",
            "Sergi", "Shinko", "Stockham", "Ostrosky", "Gillian",
            "Rulapaugh", "Schemmer", "Oldroyd", "Campain", "Perin",
            "Ferencz", "Saylors", "Briddick", "Waycott", "Bowley", "Malet",
            "Malet", "Bolognia", "Nestle", "Doe"};
    }

    public List<Customer> getCustomers(int number) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
        	Customer customer = new Customer();
        	customer.setId(i +1000);
        	customer.setFirstName(getFirstName());
        	customer.setLastName(getLastName());
        	customer.setPhone("+84 " + RandomStringUtils.randomNumeric(9));
        	customer.setCompany(getCompany());
        	customer.setAddress(RandomStringUtils.randomAlphanumeric(50));
        	customer.setCountry(getCountry());
        	
            customers.add(customer);
        }
        return customers;
    }

    private String getFirstName() {
        return firstNames[random.nextInt(firstNames.length)];
    }
    
    private String getLastName() {
        return lastNames[random.nextInt(firstNames.length)];
    }
    
    private Country getCountry() {
        return countries[random.nextInt(countries.length)];
    }

    private String getCompany() {
        return companies[random.nextInt(companies.length)];
    }
}
