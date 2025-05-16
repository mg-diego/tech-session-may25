package data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Builder
@AllArgsConstructor
public class Catalog {

    @BsonProperty("_id")
    public String id;
    public String name;
    public String description;
}
