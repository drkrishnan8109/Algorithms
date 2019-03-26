package Code.Patterns;

/**
 * Points:
 * 1. Instance object is static
 * 2. getInstance returns static
 * 3. class is not static
 * 4. No public constructor
 *
 */
public class Singleton {

        private static Singleton theOneInstance = null;

        private Singleton() {
            // do stuff to make the object
        }

        public static Singleton getInstance() {
            if (theOneInstance == null) {
                theOneInstance = new Singleton();
            }
            return theOneInstance;
        }
    }
