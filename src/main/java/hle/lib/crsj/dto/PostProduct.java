package hle.lib.crsj.dto;

import lombok.Data;

@Data
public class PostProduct {
    String name;
    String category;
    String imageUrl;
    Integer price;
    Integer stock;
    String description;
}
