package com.formapp.formupdate.service;

import com.formapp.formupdate.entity.SiteConfig;
import com.formapp.formupdate.entity.User;
import com.formapp.formupdate.repository.SiteConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class SiteConfigService {
//
//    @Autowired
//    private SiteConfigRepository siteConfigRepository;
//
//    public List<SiteConfig> getAllSiteConfigs() {
//        return siteConfigRepository.findAll();
//    }
//
//    public Optional<SiteConfig> getSiteConfigById(String siteName) {
//        return siteConfigRepository.findById(siteName);
//    }
//
//    public SiteConfig saveSiteConfig(SiteConfig siteConfig) {
//        return siteConfigRepository.save(siteConfig);
//    }
//
//    public void deleteSiteConfig(String siteName) {
//        siteConfigRepository.deleteById(siteName);
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteConfigService {

    @Autowired
    private SiteConfigRepository siteConfigRepository;

    public List<SiteConfig> findAll() {
        return siteConfigRepository.findAll();
    }

    public SiteConfig findBySiteName(String siteName) {
        return siteConfigRepository.findById(siteName).orElse(null);
    }

    public Optional<SiteConfig> getSiteNameById(String id) {
        return siteConfigRepository.findById(id);
    }

    public void save(SiteConfig siteConfig) {
        siteConfigRepository.save(siteConfig);
    }

    public void deleteBySiteName(String siteName) {
        siteConfigRepository.deleteById(siteName);
    }

    public List<SiteConfig> getAllSiteConfigs() {
        return siteConfigRepository.findAll();
    }

    public SiteConfig saveSiteConfig(SiteConfig siteConfig) {
        return siteConfigRepository.save(siteConfig);
    }

    public void deleteSiteConfig(String siteName) {
        siteConfigRepository.deleteById(siteName);
    }
}
