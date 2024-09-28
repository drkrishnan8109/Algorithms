package Code.Patterns;

import java.util.ArrayList;
import java.util.List;

public class NotificationObserver {


    public interface NotificationObserverInterface {
        void update(String message);
    }

    public class NotificationService {
        private List<NotificationObserver> observers = new ArrayList<>();

        public void registerObserver(NotificationObserver observer) {
            observers.add(observer);
        }

        public void sendNotification(String message) {
            for (NotificationObserver observer : observers) {
                observer.update(message);
            }
        }
    }

}
