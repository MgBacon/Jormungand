package events;


public class JorgReadyEvent implements GenericEvent {
    private String name;
    private long responsenumber;

    public JorgReadyEvent(String name, long responseNumber){
        this.name = name;
        this.responsenumber = responseNumber;
    }

    public long getResponsenumber() {
        return responsenumber;
    }

    public String getName() {
        return name;
    }
}
