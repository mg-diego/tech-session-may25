package data.models;

import data.enums.Browsers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ScenarioConfiguration {
    public Browsers browser;
    public String version;
    public String resolution;
    public String name;
}
