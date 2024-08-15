package com.formapp.formupdate.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "site_config") // Custom table name
public class SiteConfig {

    @Id
    @Column(name = "site_name") // Custom column name
    private String siteName;

    @Column(name = "header_vhost")
    private String headerVhost;

    @Column(name = "site_prod_domain")
    private String siteProdDomain;

    @Column(name = "site_non_prod_domain")
    private String siteNonProdDomain;

    @Column(name = "aem_site_path_en")
    private String aemSitePathEN;

    @Column(name = "stat_files_level")
    private String statFilesLevel;

    @ElementCollection
    @CollectionTable(name = "dam_transform_path", joinColumns = @JoinColumn(name = "site_name"))
    @Column(name = "path")
    private List<String> damTransformPath;

    @Column(name = "state_specific_page")
    private String stateSpecificPage;

    @Column(name = "site_map_feed_selector")
    private String siteMapFeedSelector;

    @ElementCollection
    @CollectionTable(name = "languages", joinColumns = @JoinColumn(name = "site_name"))
    @Column(name = "language")
    private List<String> languages;

    @Column(name = "common_cache_check")
    private String commonCacheCheck;

    @ElementCollection
    @CollectionTable(name = "common_cache_path", joinColumns = @JoinColumn(name = "site_name"))
    @Column(name = "path")
    private List<String> commonCachePath;

    @ElementCollection
    @CollectionTable(name = "common_dropdown", joinColumns = @JoinColumn(name = "site_name"))
    @Column(name = "dropdown")
    private List<String> commonDropdown;

    @Column(name = "site_sp_cache_check")
    private String siteSpCacheCheck;

    @ElementCollection
    @CollectionTable(name = "site_sp_cache_path", joinColumns = @JoinColumn(name = "site_name"))
    @Column(name = "path")
    private List<String> siteSpCachePath;

    @ElementCollection
    @CollectionTable(name = "site_sp_dropdown", joinColumns = @JoinColumn(name = "site_name"))
    @Column(name = "dropdown")
    private List<String> siteSpDropdown;

    // Getters and Setters

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getHeaderVhost() {
        return headerVhost;
    }

    public void setHeaderVhost(String headerVhost) {
        this.headerVhost = headerVhost;
    }

    public String getSiteProdDomain() {
        return siteProdDomain;
    }

    public void setSiteProdDomain(String siteProdDomain) {
        this.siteProdDomain = siteProdDomain;
    }

    public String getSiteNonProdDomain() {
        return siteNonProdDomain;
    }

    public void setSiteNonProdDomain(String siteNonProdDomain) {
        this.siteNonProdDomain = siteNonProdDomain;
    }

    public String getAemSitePathEN() {
        return aemSitePathEN;
    }

    public void setAemSitePathEN(String aemSitePathEN) {
        this.aemSitePathEN = aemSitePathEN;
    }

    public String getStatFilesLevel() {
        return statFilesLevel;
    }

    public void setStatFilesLevel(String statFilesLevel) {
        this.statFilesLevel = statFilesLevel;
    }

    public List<String> getDamTransformPath() {
        return damTransformPath;
    }

    public void setDamTransformPath(List<String> damTransformPath) {
        this.damTransformPath = damTransformPath;
    }

    public String getStateSpecificPage() {
        return stateSpecificPage;
    }

    public void setStateSpecificPage(String stateSpecificPage) {
        this.stateSpecificPage = stateSpecificPage;
    }

    public String getSiteMapFeedSelector() {
        return siteMapFeedSelector;
    }

    public void setSiteMapFeedSelector(String siteMapFeedSelector) {
        this.siteMapFeedSelector = siteMapFeedSelector;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getCommonCacheCheck() {
        return commonCacheCheck;
    }

    public void setCommonCacheCheck(String commonCacheCheck) {
        this.commonCacheCheck = commonCacheCheck;
    }

    public List<String> getCommonCachePath() {
        return commonCachePath;
    }

    public void setCommonCachePath(List<String> commonCachePath) {
        this.commonCachePath = commonCachePath;
    }

    public List<String> getCommonDropdown() {
        return commonDropdown;
    }

    public void setCommonDropdown(List<String> commonDropdown) {
        this.commonDropdown = commonDropdown;
    }

    public String getSiteSpCacheCheck() {
        return siteSpCacheCheck;
    }

    public void setSiteSpCacheCheck(String siteSpCacheCheck) {
        this.siteSpCacheCheck = siteSpCacheCheck;
    }

    public List<String> getSiteSpCachePath() {
        return siteSpCachePath;
    }

    public void setSiteSpCachePath(List<String> siteSpCachePath) {
        this.siteSpCachePath = siteSpCachePath;
    }

    public List<String> getSiteSpDropdown() {
        return siteSpDropdown;
    }

    public void setSiteSpDropdown(List<String> siteSpDropdown) {
        this.siteSpDropdown = siteSpDropdown;
    }
}
