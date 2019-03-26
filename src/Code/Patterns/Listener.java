package Code.Patterns;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 10/12/17.
 *
 * 3 main points:
 * 1. implements PropertyChangeListener
 * 2. @Override propertyChange(property, oldValue, newValue)
 * 3. notifyListeners()
 *
 */
public class Listener implements PropertyChangeListener{

    List<Integer> Person = new ArrayList<Integer>();
    List<PropertyChangeListener> listeners = new ArrayList<>();

    public class Person{

        private String firstname;
        public Person(String firstname){
            this.firstname= firstname;
        }

        public void setFirstName(String firstname){
            notifyListeners(this, "FIRSTNAME", this.firstname, this.firstname=firstname);
        }

        public void notifyListeners(Object obj, String property, String oldValue, String newValue){
            for(PropertyChangeListener listenerName: listeners){
                listenerName.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.println("Changed property: " + event.getPropertyName() + " [old -> "
                + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
    }
}
