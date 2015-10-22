package org.inaetics.ails.api.common.model;

/**
 * Representation of a Location.
 * 
 * @author Jessy Naus
 * @version 0.1.0
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
     * @param area The associated area of a Location.
     * @param building The associated building of a Location.
     * @param site The associated site of a Location.
     * @param organization The associated organization of a Location.
     */
    public Location(String area, String building, String site, String organization) {
        super();
        
        this.area = area;
        this.building = building;
        this.site = site;
        this.organization = organization;
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
