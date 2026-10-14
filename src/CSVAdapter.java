import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

/**
 * There are (at time of writing) no interfaces in this program, so I'm not sure if I'll be
 * able to *correctly* implement Adapter, other than implementing a class that simply "adapts"
 * the data from the CSV to a format usable in my product classes.
 *
 * CSVAdapter works based off of the sample CSV file given in the homework, so it will have to
 * 1. Display the raw contents of the CSV line by line
 * 2. Search for a product in the CSV by name
 * 3. Build the desired product -> Use the Builder here too
 *
 * I remember a little bit about file reading from OOP, but since Hugo did that part of the
 * final project, I didn't have a ton of time to learn it. I'll have to peak / copy some stuff
 * from the final project and do some research.
 * - - - - - - - - - - - - - - - - - - - - - - - - -
 * Do NOT use scanner -> Find the Java parsing method
 *
 * @author Hudson Miller
 */

public class CSVAdapter {

    // How I Learned to Stop Scanning and Love the CSV File
    private final Path csvPath;

    public CSVAdapter(Path csvPath) {
        this.csvPath = csvPath;
    }

    // Goal 1: display raw contents (self explanatory)
    /**
     * Displays raw contents o algo
     * @throws IOException
     */
    public void displayRawContents() throws IOException {
        List<String> lines = Files.readAllLines(csvPath);

        for (String line : lines) {
            System.out.println(line);
        }
    }

    // Goal 2: product search
    /**
     * Will find a product based on user / scanner input in main
     *
     * @param productName
     * @return
     * @throws IOException
     */
    public String[] findProduct(String productName)
            throws IOException {

        List<String> lines = Files.readAllLines(csvPath);

        // skip header
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).isBlank()) {
                continue;
            }

            // -1 to preserve empty columns
            String[] data = lines.get(i).split(",", -1);

            // "data" is a list of strings composed of one row of the CSV file
            if (data.length >= 7 && data[0].trim().equalsIgnoreCase(productName)) {
                return data;
            }
        }

        return null;
    }

    // Goal 3: adapt CSV data into a laptop / smartphone

    /**
     * This is a big method, but it uses DeviceBuilder to build a laptop. I'll do the same for smartphone.
     * -> Me from the future. The sample output doesn't do anything special for smartphones so I'll keep this
     * the way it is and change the name to buildDevice(productName).
     *
     * @param productName
     * @return
     * @throws IOException
     */
    public Laptop buildDevice(String productName)
            throws IOException {

        String[] data = findProduct(productName);

        if (data == null) {
            throw new IllegalArgumentException(
                    "Product not found: " + productName
            );
        }

        /** CSV columns to help me keep track
        // 0 = ProductName
        // 1 = Processor
        // 2 = RAM
        // 3 = Storage
        // 4 = Integrated graphics
        // 5 = Operating system
        // 6 = Price
         */

        if ((!data[0].trim().startsWith("Laptop")) && (!data[0].trim().startsWith("Smartphone"))) {
            throw new IllegalArgumentException(
                    "This product is not a valid device: " + data[0]
            );
        }

        // "trim()" is sort of like "nextLine()"
        String name = data[0].trim();
        if (name.isEmpty()) {
            name = "N/A";
        }
        String processor = data[1].trim();
        if (processor.isEmpty()) {
            processor = "N/A";
        }

        // I don't think I need those lines for these two because they're int?
        int memory = Integer.parseInt(data[2].trim());
        int storage = Integer.parseInt(data[3].trim());

        String graphics = data[4].trim();
        if (graphics.isEmpty()) {
            graphics = "N/A";
        }

        String os = data[5].trim();
        float price = Float.parseFloat(data[6].trim());

        // use the Builder to construct a laptop
        DeviceBuilder builder = new DeviceBuilder();

        Laptop laptop = builder
                .buildLaptopProcessor(processor)
                .buildMemory(memory)
                .buildLaptopStorage(storage)
                .buildGraphics(graphics)
                .buildOS(os)
                .buildLaptopPrice(price)
                .completeLaptop();

        System.out.println("Created product: " + name);

        return laptop;
    }
}



