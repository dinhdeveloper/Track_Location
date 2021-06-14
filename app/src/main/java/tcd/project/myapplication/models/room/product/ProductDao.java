package tcd.project.myapplication.models.room.product;

import androidx.room.Dao;
import androidx.room.*;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM roomproductmodel")
    List<RoomProductModel> getAll();

    @Query("SELECT * FROM roomproductmodel WHERE uid IN (:productIds)")
    List<RoomProductModel> loadAllByIds(int[] productIds);

    @Insert
    void insertAll(RoomProductModel... users);

    @Delete
    void delete(RoomProductModel user);
}
