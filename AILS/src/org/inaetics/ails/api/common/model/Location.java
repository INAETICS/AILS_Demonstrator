package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of a Location.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.2
 * @since 22-10-2015
 */
public class Location {
    
    private final String area;
    private final String building;
    private final String site;
    private final String organization;
   
    /**
     * Constructor of a Location.
     * 
     * @param area @NotNull The associated area of a Location.
     * @param building @NotNull The associated building of a Location.
     * @param site @NotNull The associated site of a Location.
     * @param organization @NotNull The associated organization of a Location.
     */
    public Location(String area, String building, String site, String organization) {
        super();
        this.area = Preconditions.checkNotNull(area, "area is not set");
        this.building = Preconditions.checkNotNull(building, "building is not set");
        this.site = Preconditions.checkNotNull(site, "site is not set");
        this.organization = Preconditions.checkNotNull(organization, "organization is not set");
    }

    /**
     * Retrieve the area of this Location.
     * 
     * @return This Location's area.
     */ 
    public String getArea() {
        return area;
    }

    /**
     * Retrieve the building of this Location.
     * 
     * @return This Location's building.
     */ 
    public String getBuilding() {
        return building;
    }

    /**
     * Retrieve the site of this Location.
     * 
     * @return This Location's site.
     */ 
    public String getSite() {
        return site;
    }

    /**
     * Retrieve the organization of this Location.
     * 
     * @return This Location's organization.
     */ 
    public String getOrganization() {
        return organization;
    }
    
}
