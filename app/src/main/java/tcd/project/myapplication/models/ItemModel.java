package tcd.project.myapplication.models;

import java.io.Serializable;
import java.util.List;

public class ItemModel implements Serializable {

    private String id;
    private String shipment;
    private String images;
    private String destination;
    private String departure;
    private String totalTime;
    private String timeStart;
    private String timeEnd;
    private List<ProductModel> product;

    public ItemModel() {
    }

    public ItemModel(String id,String shipment, String images, String destination, String departure, String totalTime, List<ProductModel> product) {
        this.id = id;
        this.shipment = shipment;
        this.images = images;
        this.destination = destination;
        this.departure = departure;
        this.totalTime = totalTime;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public List<ProductModel> getProduct() {
        return product;
    }

    public void setProduct(List<ProductModel> product) {
        this.product = product;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
