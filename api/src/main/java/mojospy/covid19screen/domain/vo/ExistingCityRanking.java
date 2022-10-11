package mojospy.covid19screen.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExistingCityRanking {
    private String name;
    private Integer value;
}
