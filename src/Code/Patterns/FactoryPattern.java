package Code.Patterns;

import java.util.concurrent.ConcurrentHashMap;

public class FactoryPattern {

    public interface Payment {
        void process(double amount);
    }

    public class CreditCardPayment implements Payment {
        public void process(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    }

    public class PayPalPayment implements Payment {
        public void process(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    public class BitCoinPayment implements Payment {
        public void process(double amount) {
            System.out.println("Processing BitCoin payment of $" + amount);
        }
    }

    public class PaymentFactory {
        public Payment createPayment(String type) {
            switch (type) {
                case "credit":
                    return new CreditCardPayment();
                case "paypal":
                    return new PayPalPayment();
                case "bitcoin":
                    return new BitCoinPayment();
                default:
                    throw new IllegalArgumentException("Unknown payment type");
            }
        }
    }
}
