package Controller;
import Interface.*;


public class EmployeeRepository implements Sector {
    public String[] employees = { "Tuan", "My", "Huy", "Manh", "Kien" };

    @Override
    public Iterator getIterator() {
        return new EmployeeIterator();
    }

    private class EmployeeIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < employees.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return employees[index++];
            }
            return null;
        }
    }
}
