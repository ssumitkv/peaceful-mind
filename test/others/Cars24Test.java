package test.others;
/*
Create a Singleton class called "PaymentProcessor" that manages concurrent transactions. The Payment Processor should use 
ConcurrentHashMap to store payment records.
Ensure thread-safety of the ConcurrentHashMap. Implement the following functionalities:
Add a payment record to the concurrent hashmap.
Get a payment record by transactionId from the concurrent hashmap.
Remove a payment record by transactionId from the concurrent hashmap.

 */

import java.util.concurrent.ConcurrentHashMap;

public class Cars24Test {
    
    static private ConcurrentHashMap<String, Payments> payments;
    static private Cars24Test test;
 

    private Cars24Test(){
        payments = new ConcurrentHashMap();
    }
    
 
  
    synchronized static Cars24Test getInstance() {
        if (test == null) {
            test =  new Cars24Test();;
        }
        return test;
    }


    // @Transactional
    Boolean addRecord(Payments record) {    
        if(payments.contains(record.txnId)) {
            // txn already present
            return false;
        }
        else {
            payments.put(record.txnId, record);
        }
        return true;
    }

    Payments getPayment(String txnId ) {
        if(payments.containsKey(txnId)) {
            return payments.get(txnId);
        }
        return null;
    }

// @Transactional
    Boolean remove(String txnId) {
        payments.remove(txnId);
        return true;
    }

    public class Payments {
        String txnId;
        Double amount;
    }


}
