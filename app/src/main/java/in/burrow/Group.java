package in.burrow;

/**
 * Created by fasal on 26-07-2015.
 */
import java.util.ArrayList;

public class Group {


    private String Name;
    private String Number;
    private ArrayList<Child> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public ArrayList<Child> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
