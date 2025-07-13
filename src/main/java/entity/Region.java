package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regionId;

    @Column(length = 50)
    private String regionName;

    public Region() {}
    public Region(String regionName) {
        this.regionName = regionName;
    }

    public int getRegionId() { return regionId; }
    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }

    @Override
    public String toString() {
        return regionId + ": " + regionName;
    }
}
