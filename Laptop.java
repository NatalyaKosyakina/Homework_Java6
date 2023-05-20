package org.Homework_S6;

public class Laptop {
    private String model = "Нет данных";
    private int ram = 0;
    private String memoryType = "Нет данных";
    private int memory = 0;
    private String operatingSystem = "Нет данных";


    public Laptop(String model, int ram, String memoryType, int memory, String operatingSystem) {
        this.model = model;
        this.ram = ram;
        this.memoryType = memoryType;
        this.memory = memory;
        this.operatingSystem = operatingSystem;
    }

    Laptop() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String diskType) {
        this.memoryType = diskType;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return '\n' + "Model: " + model +
                ", ram: " + ram +
                ", memoryType: " + memoryType +
                ", memory: " + memory +
                ", operatingSystem: " + operatingSystem;
    }

}
