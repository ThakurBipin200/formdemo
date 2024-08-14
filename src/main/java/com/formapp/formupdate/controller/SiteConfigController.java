package com.formapp.formupdate.controller;

import com.formapp.formupdate.entity.SiteConfig;
import com.formapp.formupdate.service.SiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/site-config")
//public class SiteConfigController {
//
//    @Autowired
//    private SiteConfigService siteConfigService;
//
//    @GetMapping
//    public List<SiteConfig> getAllSiteConfigs() {
//        return siteConfigService.getAllSiteConfigs();
//    }
//
//    @GetMapping("/{siteName}")
//    public ResponseEntity<SiteConfig> getSiteConfigById(@PathVariable String siteName) {
//        Optional<SiteConfig> siteConfig = siteConfigService.getSiteConfigById(siteName);
//        return siteConfig.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public SiteConfig createSiteConfig(@RequestBody SiteConfig siteConfig) {
//        return siteConfigService.saveSiteConfig(siteConfig);
//    }
//
//    @PutMapping("/{siteName}")
//    public ResponseEntity<SiteConfig> updateSiteConfig(@PathVariable String siteName, @RequestBody SiteConfig siteConfig) {
//        Optional<SiteConfig> existingConfig = siteConfigService.getSiteConfigById(siteName);
//        if (existingConfig.isPresent()) {
//            siteConfig.setSiteName(siteName);
//            return ResponseEntity.ok(siteConfigService.saveSiteConfig(siteConfig));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{siteName}")
//    public ResponseEntity<Void> deleteSiteConfig(@PathVariable String siteName) {
//        siteConfigService.deleteSiteConfig(siteName);
//        return ResponseEntity.noContent().build();
//    }
//}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/siteConfigs")
//public class SiteConfigController {
//
//    @Autowired
//    private SiteConfigService siteConfigService;
//
//    // Display the form with the dropdown for site selection
//    @GetMapping
//    public String showSiteConfigs(Model model) {
//        List<SiteConfig> siteConfigs = siteConfigService.findAll();
//        model.addAttribute("siteConfigs", siteConfigs);
//        return "siteConfigForm"; // Thymeleaf template name
//    }
//
//    // Handle the selection of a site from the dropdown
//    @GetMapping("/{siteName}")
//    public String getSiteConfig(@PathVariable String siteName, Model model) {
//        SiteConfig selectedSite = siteConfigService.findBySiteName(siteName);
//        List<SiteConfig> siteConfigs = siteConfigService.findAll();
//        model.addAttribute("siteConfigs", siteConfigs);
//        model.addAttribute("selectedSite", selectedSite);
//        return "siteConfigForm"; // Thymeleaf template name
//    }
//
//    // Handle the update of a site config
//    @PostMapping("/update")
//    public String updateSiteConfig(@ModelAttribute("selectedSite") SiteConfig siteConfig) {
//        siteConfigService.saveSiteConfig(siteConfig);
//        return "redirect:/siteConfigs"; // Redirect to the form after saving
//    }
//}
//


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@Controller
//public class SiteConfigController {
//
//    @Autowired
//    private SiteConfigService siteConfigService;
//
//    @GetMapping("/siteConfigs")
//    public String listSiteConfigs(Model model, @RequestParam(value = "siteName", required = false) String siteName) {
//        if (siteName != null) {
//            SiteConfig selectedSite = siteConfigService.findBySiteName(siteName);
//            model.addAttribute("selectedSite", selectedSite);
//        }
//        model.addAttribute("siteConfigs", siteConfigService.findAll());
//        return "siteConfigForm";
//    }
//
//    @PostMapping("/siteConfigs/update")
//    public String updateSiteConfig(@ModelAttribute SiteConfig siteConfig) {
//        siteConfigService.save(siteConfig);
//        return "redirect:/siteConfigs";
//    }
//}




import com.formapp.formupdate.entity.SiteConfig;
import com.formapp.formupdate.service.SiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class SiteConfigController {

    @Autowired
    private SiteConfigService siteConfigService;

    @GetMapping("/site-configs")
    public String showSiteConfigForm(Model model) {
        List<SiteConfig> siteConfigs = siteConfigService.findAll();
        model.addAttribute("siteConfigs", siteConfigs);
        model.addAttribute("selectedSiteConfig", new SiteConfig());
        return "siteConfigForm";
    }

    @GetMapping("/site-configs/{siteName}")
    public String getSiteConfigDetails(@RequestParam("siteName") String siteName, Model model) {
        List<SiteConfig> siteConfigs = siteConfigService.findAll();
        model.addAttribute("siteConfigs", siteConfigs);

        Optional<SiteConfig> siteConfig = siteConfigService.getSiteNameById(siteName);
        siteConfig.ifPresent(sc -> model.addAttribute("selectedSiteConfig", sc));
        return "siteConfigForm";
    }

    @PostMapping("/site-configs/update")
    public String updateSiteConfig(SiteConfig siteConfig) {
        siteConfigService.save(siteConfig);
        return "redirect:/site-configs";
    }
}

