//package com.setuInterview.AccountOperations.Service.Util;
//
//import com.setuInterview.AccountOperations.Repository.Entities.TransactionHistoryDO;
//import org.springframework.stereotype.Component;
//
//import java.util.Comparator;
//
///**
// * @author saumitra chauhan
// * @since 27-07-2023 17:38
// */
//
//@Component
//public class TransactionHistoryComparator implements Comparator {
//    @Override
//    public int compare(Object o1, Object o2) {
//        TransactionHistoryDO transactionHistoryDO1 = (TransactionHistoryDO) o1;
//        TransactionHistoryDO transactionHistoryDO2 = (TransactionHistoryDO) o2;
//
//        return transactionHistoryDO1.getCreatedOn().compareTo(transactionHistoryDO2.getCreatedOn());
//
//    }
//}
