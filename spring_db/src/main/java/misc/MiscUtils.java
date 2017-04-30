package misc;

import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by Greg on 30.04.2017.
 */
public class MiscUtils {

    public static void printTransactionStatus() {
        String s = TransactionSynchronizationManager.isActualTransactionActive() ? "" : "not";
        System.out.println("transaction is "+ s +" active now");
    }
}
