package service;

import model.Affiliate;
import model.Transaction;

import java.util.ArrayList;
import java.util.UUID;

public class TransactionService {

    public void createTransaction(Affiliate affiliate, double transactionAmount) {
        Transaction transaction;
        synchronized (TransactionService.class) {
            transaction = new Transaction(affiliate.getOrderCommissions(), UUID.randomUUID(), transactionAmount);
        }
        affiliate.getTransactions().add(transaction);
        affiliate.setOrderCommissions(new ArrayList<>());

    }
}
