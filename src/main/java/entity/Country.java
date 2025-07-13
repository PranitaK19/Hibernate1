package entity;

import jakarta.persistence.*;



@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "countryid")
    private String countryId;  // <- हे @Id पाहिजे

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    // Constructors, Getters, Setters


    public Country() {}

    public Country(String countryId, String countryName, Region region) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.region = region;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return countryId + " - " + countryName + " (" + region.getRegionName() + ")";
    }
}
