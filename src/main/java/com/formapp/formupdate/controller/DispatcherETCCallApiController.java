package com.formapp.formupdate.controller;

import com.formapp.formupdate.entity.SiteConfig;
import com.formapp.formupdate.service.SiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diset-api")
public class DispatcherETCCallApiController {

    @Autowired
    private SiteConfigService siteConfigService;

    // Get all site configs for dispatcher etc.
    @GetMapping
    public List<SiteConfig> getAllDispatcherEtc() {
        return siteConfigService.getAllSiteConfigs();
    }

    @GetMapping("/{siteName}")
    @ResponseBody
    public ResponseEntity<SiteConfig> getSiteConfigById(@PathVariable String siteName) {
        Optional<SiteConfig> siteConfig = siteConfigService.getSiteNameById(siteName);
        return siteConfig.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new site config
    @PostMapping
    public ResponseEntity<SiteConfig> createSiteConfig(@RequestBody SiteConfig siteConfig) {
        SiteConfig createdSiteConfig = siteConfigService.saveSiteConfig(siteConfig);
        return ResponseEntity.ok(createdSiteConfig);
    }

    // Update an existing site config
    @PutMapping("/{siteName}")
    public ResponseEntity<SiteConfig> updateSiteConfig(@PathVariable String siteName, @RequestBody SiteConfig siteConfig) {
        Optional<SiteConfig> existingConfig = siteConfigService.getSiteNameById(siteName);
        if (existingConfig.isPresent()) {
            siteConfig.setSiteName(siteName);
            SiteConfig updatedSiteConfig = siteConfigService.saveSiteConfig(siteConfig);
            return ResponseEntity.ok(updatedSiteConfig);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a site config
    @DeleteMapping("/{siteName}")
    public ResponseEntity<Void> deleteSiteConfig(@PathVariable String siteName) {
        Optional<SiteConfig> existingConfig = siteConfigService.getSiteNameById(siteName);
        if (existingConfig.isPresent()) {
            siteConfigService.deleteSiteConfig(siteName);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

