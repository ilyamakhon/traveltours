package by.epam.traveltours.scanner;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.dao.externaldao.ExternalTourDAO;
import by.epam.traveltours.exception.TourCriteriaNotFoundException;
import by.epam.traveltours.services.TourService;
import by.epam.traveltours.storage.TourStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TourScanner {

    private static TourService TOUR_SERVICE = TourService.getInstance();
    private Scanner in = new Scanner(System.in);
    private List<Tour> tours = new ArrayList<>();
    private ExternalTourDAO dao;

    public void baseMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("1: Create Tours ");
        System.out.println("2: Save Tours ");
        System.out.println("3: View Tours ");
        System.out.println("4: Use Local Internal Storage For Demo");
        System.out.println("5: Find Tours By Transport Type");
        System.out.println("6: Sort Tours ");
        System.out.println("7: Exit ");
        System.out.print("Please make your choice : ");
        String choice = in.next();

        switch (choice) {
            case "1":
                tours.addAll(readTours());
                baseMenu();
                break;
            case "2":
                saveTours();
                baseMenu();
                break;
            case "3":
                viewTours();
                baseMenu();
                break;
            case "4":
                tours = TourStorage.getInstance().getAllTours();
                baseMenu();
                break;
            case "5":
                findToursByTransportType();
                baseMenu();
                break;
            case "6":
                sortTours();
                baseMenu();
                break;
            case "7":
                return;
            default:
                throw new IllegalArgumentException("Wrong choice! Please view choices from menu once again!");
        }
    }

    private List<Tour> readTours() {
        List<Tour> tours = new ArrayList<>();
        System.out.println("------------------------------------------");
        System.out.print("Please enter amount of tours to be created: ");
        int amountOfTours = in.nextInt();
        Tour tour;

        for (int i = 0; i < amountOfTours; i++) {
            System.out.println("Creating of tour #" + (i + 1));
            tour = new Tour();

            System.out.print("Enter Tour ID : ");
            tour.setTourId(in.nextLong());

            System.out.print("Enter Amount Of Days : ");
            tour.setAmountOfDays(in.nextInt());

            System.out.print("Enter Price : ");
            tour.setPrice(in.nextFloat());

            System.out.print("[Available Tour Types: REST, THERAPEUTIC, EXCURSION, SHOPPING, CRUISE] Enter Tour Type : ");
            tour.setTourType(Tour.TourType.valueOf(in.next().toUpperCase()));

            System.out.print("[Available Tour Types: BREAKFAST, BREAKFAST_AND_DINNER, ALL_INCLUSIVE] Enter Type Of Food : ");
            tour.setTypeOfFood(Tour.TypeOfFood.valueOf(in.next().toUpperCase()));

            System.out.print("[Available Tour Types: BUS, TRAIN, PLANE] Enter Type Of Transport : ");
            tour.setTransportType(Tour.TransportType.valueOf(in.next().toUpperCase()));

            tours.add(tour);
        }

        return tours;
    }

    private void saveTours() {
        System.out.println("Save To: ");
        System.out.println("1: MySql");
        System.out.println("2: Json");
        System.out.println("3: File");
        System.out.print("Please make your choice : ");
        String choice = in.next();

        switch (choice) {
            case "1":
            case "2":
            case "3":
                dao = ExternalTourDAO.getDAO(choice);
                dao.saveTours(tours);
                break;
            default:
                throw new IllegalArgumentException("Wrong choice! Please view choices from menu once again!");
        }
    }

    private void viewTours() {
        System.out.println("View From: ");
        System.out.println("1: MySql");
        System.out.println("2: Json");
        System.out.println("3: File");
        System.out.println("4: Internal Storage");
        System.out.print("Pease make your choice : ");
        String choice = in.next();

        switch (choice) {
            case "1":
            case "2":
            case "3":
                dao = ExternalTourDAO.getDAO(choice);
                dao.readTours();
                break;
            case "4":
                tours.forEach(System.out::println);
                break;
            default:
                throw new IllegalArgumentException("Wrong choice! Please view choices from menu once again!");
        }
    }

    private void findToursByTransportType() {
        System.out.println("Transport Types: ");
        System.out.println("1: Plane");
        System.out.println("2: Train");
        System.out.println("3: Bus");
        System.out.print("Please make your choice : ");
        String choice = in.next();

        switch (choice) {
            case "1":
            case "2":
            case "3":
                TourCriteria tourCriteria = TourService.getInstance().getCriteriaByTransportType(choice);
                TOUR_SERVICE.findTours(tourCriteria, tours).forEach(System.out::println);
                break;
            default:
                throw new TourCriteriaNotFoundException("Wrong type for tour criteria : " + choice + "\nPlease review application.properties file to find correct criteria types!");
        }
    }

    private void sortTours() {
        System.out.println("Sort tours by: ");
        System.out.println("1: Amount of days");
        System.out.println("2: Price");
        System.out.print("Please make your choice : ");
        String choice = in.next();

        switch (choice) {
            case "1":
                TourCriteria tourCriteriaDays = TourCriteria.Builder.create().withSortField(TourCriteria.SortField.AMOUNT_OF_DAYS).build();
                TOUR_SERVICE.findTours(tourCriteriaDays, tours).forEach(System.out::println);
                break;
            case "2":
                TourCriteria tourCriteriaPrice = TourCriteria.Builder.create().withSortField(TourCriteria.SortField.PRICE).build();
                TOUR_SERVICE.findTours(tourCriteriaPrice, tours).forEach(System.out::println);
                break;
            default:
                throw new IllegalArgumentException("Wrong choice! Please view choices from menu once again!");
        }
    }
}
