package Code.Patterns;

import java.util.ArrayList;
import java.util.List;

/*
* Subject and Observer where Subject is the object that changes.
* Subject keeps a list of observers and notifies the observers whenever there is a achnge*/
public class ObserverPattern {
    // Observer interface
    interface Observer {
        void update(String message);
    }

    // Subject interface
    interface Subject {
        void attach(Observer observer);
        void detach(Observer observer);
        void notifyObservers();
    }

    // Concrete Subject
    class NewsPublisher implements Subject {
        private final List<Observer> observers = new ArrayList<>();
        private String news;

        @Override
        public void attach(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(news);
            }
        }

        public void setNews(String news) {
            this.news = news;
            notifyObservers(); // Notify all observers of the change
        }
    }

    // Concrete Observer
    class NewsChannel implements Observer {
        private final String name;

        public NewsChannel(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " received news: " + message);
        }
    }

    // Usage
    public class ObserverDemo {
        public void main(String[] args) {
            NewsPublisher publisher = new NewsPublisher();

            NewsChannel channel1 = new NewsChannel("Channel 1");
            NewsChannel channel2 = new NewsChannel("Channel 2");

            publisher.attach(channel1);
            publisher.attach(channel2);

            // Publisher updates news
            publisher.setNews("New Observer Pattern Implemented!");
        }
    }
}
