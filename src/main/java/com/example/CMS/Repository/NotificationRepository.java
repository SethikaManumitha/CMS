package com.example.CMS.Repository;

import com.example.CMS.Entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    List<Notification> findByUserType(String userType);

    List<Notification> findByUserTypeIn(List<String> userTypes);

    @Query(value = "SELECT * FROM notification WHERE user_type IN (?1, 'all') ORDER BY notification_id DESC LIMIT 10", nativeQuery = true)
    List<Notification> findLatest10ByUserType(String userType);

    @Query(value = "SELECT * FROM notification WHERE date = ?1 AND user_type IN (?2, 'all')", nativeQuery = true)
    List<Notification> findByDateAndUserType(String date, String userType);
}
