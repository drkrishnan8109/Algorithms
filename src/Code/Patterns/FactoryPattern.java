package Code.Patterns;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/*
* Goal: The Factory Pattern is used to create objects without specifying the exact class of the object that will be created. It defines an interface for creating an object but allows subclasses to alter the type of objects that will be created.
Use Case: Ideal for situations where you want to create different instances of classes that share a common interface or base class.
* */
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

        /* When the number of payment grows, using switch case violates Open/Closed principle of SOLID
        So use ConcurrentHashMap & Reflection for scalability & extensibility
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
        */

        protected ConcurrentHashMap<String, Class<? extends Payment>> paymentMap;
        private PaymentFactory() {
            paymentMap = new ConcurrentHashMap();
            paymentMap.put("credit", CreditCardPayment.class);
            paymentMap.put("paypal", PayPalPayment.class);
            paymentMap.put("bitcoin", BitCoinPayment.class);
        }

        public Payment createPayment(String type) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Class<? extends Payment> paymentClass = paymentMap.get(type);
            if(paymentClass == null) {
                System.err.println("Unknown Payment type");
                throw new IllegalArgumentException("Unknown Payment type");
            }
            return paymentClass.getDeclaredConstructor().newInstance();
        }
    }
}
