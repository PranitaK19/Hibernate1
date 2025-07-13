package app;

import dao.CountryDAO;
import dao.RegionDAO;
import entity.Region;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegionDAO regionDAO = new RegionDAO();
        CountryDAO countryDAO = new CountryDAO();

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Add Region");
            System.out.println("2. View All Regions");
            System.out.println("3. Delete Region");
            System.out.println("4. Add Country");
            System.out.println("5. View All Countries");
            System.out.println("6. Delete Country");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
            case 1 : {
                System.out.print("Enter Region Name: ");
                regionDAO.addRegion(sc.nextLine());
                break;
            }
            case 2 : {
                regionDAO.getAllRegions().forEach(System.out::println);
                break;
            }
            case 3 : {
                System.out.print("Enter Region ID: ");
                regionDAO.deleteRegion(sc.nextInt()); sc.nextLine();
                break;
            }
            case 4 : {
                System.out.print("Enter Country ID (2 letters): ");
                String id = sc.nextLine();
                System.out.print("Enter Country Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Region ID: ");
                Region region = regionDAO.getById(sc.nextInt());
                sc.nextLine();
                if (region != null) {
                    countryDAO.addCountry(id, name, region);
                } else {
                    System.out.println("Invalid Region ID.");
                }
                break;
            }
            case 5 : {
                countryDAO.getAllCountries().forEach(System.out::println);
                break;
            }
            case 6 : {
                System.out.print("Enter Country ID to delete: ");
                countryDAO.deleteCountry(sc.nextLine());
                break;
            }
            case 0 : {
                System.out.println("Exiting...");
                sc.close();
                return;
            }
            default : {
                System.out.println("Invalid Choice");
                break;
            }
        }

    }
    }
}
