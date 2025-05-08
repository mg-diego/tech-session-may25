package data;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Catalog {

    public String id;
    public String name;
    public String description;
}
