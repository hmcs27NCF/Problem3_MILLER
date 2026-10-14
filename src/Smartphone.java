/**
 * Smartphone product class.
 *
 * @author Hudson Miller
 */
public class Smartphone {
    // Price *will* be fixed at $800.00 for custom items in main
    private String name;
    private float price;
    private float screenSize;
    private String processor;
    private int cameraRes;
    private int battery;
    private int storage;

    public void setName(String input) {
        name = input;
    }
    public void setPrice(float input) {
        price = input;
    }
    public void setScreenSize(float input) {
        screenSize = input;
    }
    public void setProcessor(String input) {
        processor = input;
    }
    public void setCameraRes(int input) {
        cameraRes = input;
    }
    public void setBattery(int input) {
        battery = input;
    }
    public void setStorage(int input) {
        storage = input;
    }

    /**
     * Displays the smartphone's specifications.
     */
    public void displaySpecs() {
        System.out.println("Specifications: [ Price: $" + price + " | Screen Size: " + screenSize + " inches | Processor: " + processor + " | Camera Resolution: " + cameraRes + "p | Battery: " + battery + "mAh | Storage: " + storage + "GB ]");
    }
}
