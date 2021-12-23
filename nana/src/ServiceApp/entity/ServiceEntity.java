package ServiceApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ServiceEntity {
    public int id;
    public String title;
    public double cost;
    public int duration;
    public double discount;
    public String imagePath;

    public ServiceEntity(String title, double cost, int duration, double discount, String imagePath) {
        this(-1,title,cost,duration,discount,imagePath);
    }
}

