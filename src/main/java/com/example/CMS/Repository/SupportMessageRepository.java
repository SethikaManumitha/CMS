package com.example.CMS.Repository;

import com.example.CMS.Entity.SupportMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupportMessageRepository extends JpaRepository<SupportMessage, Integer> {
    List<SupportMessage> findBySenderIdAndSenderTypeAndReceiverTypeOrderByTimestampAsc(
            int senderId, String senderType, String receiverType);

    List<SupportMessage> findAll();

    @Query("SELECT DISTINCT sm.senderId FROM SupportMessage sm")
    List<Integer> findDistinctSenders();

}

