package Code.Patterns;

import java.util.ArrayList;
import java.util.List;

public class NotificationObserverPattern {


    private interface NotificationObserver{
        void update(String message);
    }

    class SMSNotificationObserver implements NotificationObserver {
        @Override
        public void update(String message) {
            //Send SMS
        }
    }

    class EMailNotificationObserver implements NotificationObserver {
        @Override
        public void update(String message) {
            //Send Email
        }
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
