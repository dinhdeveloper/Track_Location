package tcd.project.myapplication.models.room.product;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomProductModel {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "id_forkey")
    public String id_forkey;

    @ColumnInfo(name = "productName")
    public String productName;

    @ColumnInfo(name = "price")
    public String price;


}
