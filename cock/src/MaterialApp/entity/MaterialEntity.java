package MaterialApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaterialEntity {
    int id;
    String title;
    int countInPack;
    String unit;
    int countInStock;
    int minCount;
    String description;
    int cost;
    String image;
    String materialType;

    public MaterialEntity(String title, int countInPack, String unit, int countInStock, int minCount, String description, int cost, String image, String materialType) {
        this(-1,title,countInPack,unit,countInStock,minCount,description,cost,image,materialType);
    }
}
