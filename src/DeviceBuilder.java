/**
 * Class for making laptop and smartphone devices using the Builder pattern.
 * Associated with Laptop and Smartphone.
 *
 * @author Hudson Miller
 */
public class DeviceBuilder {
    Laptop laptop = new Laptop();
    Smartphone smartphone = new Smartphone();
    // laptop (memory, graphics, os)
    public DeviceBuilder buildMemory(int input) {
        laptop.setMemory(input);
        return this;
    }
    public DeviceBuilder buildGraphics(String input) {
        laptop.setGraphics(input);
        return this;
    }
    public DeviceBuilder buildOS(String input) {
        laptop.setOS(input);
        return this;
    }
    // smartphone (screen size, camera res, battery)
    public DeviceBuilder buildScreenSize(float input) {
        smartphone.setScreenSize(input);
        return this;
    }
    public DeviceBuilder buildCameraRes(int input) {
        smartphone.setCameraRes(input);
        return this;
    }
    public DeviceBuilder buildBattery(int input) {
        smartphone.setBattery(input);
        return this;
    }
    // shared (processor, storage)
    public DeviceBuilder buildLaptopProcessor(String input) {
        laptop.setProcessor(input);
        return this;
    }
    public DeviceBuilder buildSmartphoneProcessor(String input) {
        smartphone.setProcessor(input);
        return this;
    }
    public DeviceBuilder buildLaptopStorage(int input) {
        laptop.setStorage(input);
        return this;
    }
    public DeviceBuilder buildSmartphoneStorage(int input) {
        smartphone.setStorage(input);
        return this;
    }
    public DeviceBuilder buildLaptopPrice(float input) {
        laptop.setPrice(input);
        return this;
    }
    public DeviceBuilder buildSmartphonePrice(float input) {
        smartphone.setPrice(input);
        return this;
    }
    // return completed object
    public Laptop completeLaptop() {
        return laptop;
    }
    public Smartphone completeSmartphone() {
        return smartphone;
    }
}
