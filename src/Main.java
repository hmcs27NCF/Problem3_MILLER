import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Part 1: the adapter / search
        CSVAdapter adapter = new CSVAdapter(Path.of("src", "sample.csv"));
        Scanner scnr = new Scanner(System.in);

        try {
            System.out.println("=== CSV Contents ===");
            adapter.displayRawContents();

            System.out.print("\nSearch Device Name: ");
            String input = scnr.nextLine();

            System.out.println("\n=== Search Result ===");
            Laptop laptop = adapter.buildDevice(input);
            laptop.displaySpecs();

        } catch (IOException e) {
            System.out.println(
                    "Error reading CSV: " + e.getMessage()
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Part 2: the custom object (I think this is how it goes)
        System.out.println("\n=== Custom Device Order ===");
        System.out.println("What device would you like to make? (Smartphone / Laptop)");
        String choice = scnr.nextLine();
        DeviceBuilder mainBuilder = new DeviceBuilder();
        if(choice.equalsIgnoreCase("smartphone")) {
            System.out.println("Processor: ");
            String processor = scnr.nextLine();
            System.out.println("Screen Size (inches): ");
            float screenSize = scnr.nextFloat();
            scnr.nextLine();
            System.out.println("Camera Resolution (pixels): ");
            int cameraRes = scnr.nextInt();
            scnr.nextLine();
            System.out.println("Storage: ");
            int storage = scnr.nextInt();
            scnr.nextLine();
            System.out.println("Battery (mAh): ");
            int battery = scnr.nextInt();
            scnr.nextLine();
            Smartphone smartphone = mainBuilder
                    .buildSmartphoneProcessor(processor)
                    .buildCameraRes(cameraRes)
                    .buildSmartphoneStorage(storage)
                    .buildBattery(battery)
                    .buildScreenSize(screenSize)
                    .buildSmartphonePrice(800)
                    .completeSmartphone();
            System.out.println("Name? : ");
            String name = scnr.nextLine();
            System.out.println("\n=== Custom Device Created ===");
            System.out.println("Device Name: " + name + " (Smartphone)");
            smartphone.displaySpecs();
        }
        else if(choice.equalsIgnoreCase("laptop")) {
            System.out.println("Processor: ");
            String processor = scnr.nextLine();
            System.out.println("Memory: ");
            int memory = scnr.nextInt();
            scnr.nextLine();
            System.out.println("Storage: ");
            int storage = scnr.nextInt();
            scnr.nextLine();
            System.out.println("Graphics: ");
            String graphics = scnr.nextLine();
            System.out.println("Operating System: ");
            String os = scnr.nextLine();
            Laptop laptop = mainBuilder
                    .buildLaptopProcessor(processor)
                    .buildMemory(memory)
                    .buildLaptopStorage(storage)
                    .buildGraphics(graphics)
                    .buildOS(os)
                    .buildLaptopPrice(800)
                    .completeLaptop();
            System.out.println("Name? : ");
            String name = scnr.nextLine();
            System.out.println("\n=== Custom Device Created ===");
            System.out.println("Device Name: " + name + " (Laptop)");
            laptop.displaySpecs();
        }
        else {
            System.out.println("Invalid input.");
        }
    }
}