package com.sjsu.cmpe.sstreet.simulatedstation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sensor")
public class Sensor {

    @org.springframework.data.annotation.Transient
    @JsonIgnore
    static final Long defaultCollectingInterval =  7000l; //default interval 1h 3600000l

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer internalId;

    private Integer idSensor;

    private String name;

    private String model;

    private String make;

    private Date installationDate;

    private SensorType type;

    private Long dataCollectingInterval = defaultCollectingInterval;

    private Date lastDataCollectingTimestamp;

    private Boolean registered = false;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="location_idlocation", unique= true, nullable=true, insertable=true, updatable=true)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "smart_node_idSmartNode")
    private SmartNode smartNode;

    public Sensor(
        String name,
        String model,
        String make,
        Date installationDate,
        SensorType type,
        Location location,
        SmartNode smartNode
    ) {

        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.type = type;
        this.location = location;
        this.smartNode = smartNode;
    }

    public Sensor(String name, String model, String make, Date installationDate, SensorType type, Location location) {

        this.name = name;
        this.model = model;
        this.make = make;
        this.installationDate = installationDate;
        this.type = type;
        this.location = location;
    }

    public Sensor() {

    }

    public Integer getIdSensor() {

        return idSensor;
    }

    public void setIdSensor(Integer idSensor) {

        this.idSensor = idSensor;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {

        this.model = model;
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {

        this.make = make;
    }

    public Date getInstallationDate() {

        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {

        this.installationDate = installationDate;
    }

    public SensorType getType() {

        return type;
    }

    public void setType(SensorType type) {

        this.type = type;
    }

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {

        this.location = location;
    }

    public SmartNode getSmartNode() {

        return smartNode;
    }

    public void setSmartNode(SmartNode smartNode) {

        this.smartNode = smartNode;
    }

    public Long getDataCollectingInterval() {

        return dataCollectingInterval;
    }

    public void setDataCollectingInterval(Long dataCollectingInterval) {

        this.dataCollectingInterval = dataCollectingInterval;
    }

    public Date getLastDataCollectingTimestamp() {

        return lastDataCollectingTimestamp;
    }

    public void setLastDataCollectingTimestamp(Date lastDataCollectingTimestamp) {

        this.lastDataCollectingTimestamp = lastDataCollectingTimestamp;
    }

    public Integer getInternalId() {

        return internalId;
    }

    public void setInternalId(Integer internalId) {

        this.internalId = internalId;
    }

    public Boolean getRegistered() {

        return registered;
    }

    public void setRegistered(Boolean registered) {

        this.registered = registered;
    }
}
