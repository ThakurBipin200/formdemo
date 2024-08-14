package com.formapp.formupdate.repository;

import com.formapp.formupdate.entity.SiteConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteConfigRepository extends JpaRepository<SiteConfig, String> {
    // You can define custom query methods here if needed
}
