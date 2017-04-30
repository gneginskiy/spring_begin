package aop;

import misc.MiscUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by Greg on 30.04.2017.
 */
@Component
public class TransactionActiveCheck {

    public  void printTransactionStatus() {
        System.out.print("ASPECT BASED NOTIFICATION ABOUT TRANSACTION ACTIVITY: ");
        MiscUtils.printTransactionStatus();
    }
}
