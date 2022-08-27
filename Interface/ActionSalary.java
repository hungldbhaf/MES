package Interface;
import java.util.ArrayList;

public interface ActionSalary<T, T1> extends Action<T> {
    public Object add(ArrayList<T> list, ArrayList<T1> list2);

    public boolean edit(ArrayList<T> list, ArrayList<T1> list2);
}
