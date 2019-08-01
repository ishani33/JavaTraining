
public class AccountClient {

	public static void main(String[] args) {
		Account account = new Account(5000);
		TransactionThread t1 =
                new TransactionThread(account, TransactionType.CREDIT, "Roger", 2000);
        TransactionThread t2 =
                new TransactionThread(account, TransactionType.CREDIT, "\tAmy", 3500);
        TransactionThread t3 =
                new TransactionThread(account, TransactionType.DEBIT, "\t\tCalvin", 2000);
        
        t3.start();
        t1.start();
        t2.start();
        
        
        try {
        	t1.join(); //this specifies that the caller thread(here main thread) has to wait for the current thread to finish
        	t2.join();
        	t3.join();
        } catch(InterruptedException e) {
        	e.printStackTrace();
        }
        System.out.println("Final balance : "+ account.getBalance());

	}

}
