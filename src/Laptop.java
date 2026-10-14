/**
 * Laptop product class.
 *
 * @author Hudson Miller
 */
public class Laptop {
    // Price *will* be fixed at $800.00 for custom items in main
    private String name;
    private float price;
    private String processor;
    private int memory;
    private int storage;
    private String graphics;
    private String os;

    public void setName(String input) {
        name = input;
    }
    public void setPrice(float input) {
        price = input;
    }
    public void setProcessor(String input) {
        processor = input;
    }
    public void setMemory(int input) {
        memory = input;
    }
    public void setStorage(int input) {
        storage = input;
    }
    public void setGraphics(String input) {
        graphics = input;
    }
    public void setOS(String input) {
        os = input;
    }

    /**
     * Displays the laptop's specifications.
     * Should I use toString() instead?
     * Nah I should be good. Maybe if I wanted to look fancy I could.
     */
    public void displaySpecs() {
        System.out.println("Specifications: [ Price: $" + price + " | Processor: " + processor + " | RAM: " + memory + "GB | Storage: " + storage + "GB | GPU : " + graphics + " | Operating System: " + os + " ]");
    }
}
