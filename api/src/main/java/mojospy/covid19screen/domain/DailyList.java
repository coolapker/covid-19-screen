package mojospy.covid19screen.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
/**
 * 日常列表
 *
 * @author libm
 * @date 2022/10/11
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DailyList {


    /** 累计确诊数列表 */
    Integer confirmedCountList;
    // 现存
    Integer currentConfirmedCountList;
    // 现存新增
    Integer currentConfirmedIncrList;
    // 境外输入
    Integer importedCountList;
    // 境外输入新增
    Integer importedIncrList;
    // 无症状感染
    Integer noInfectCountList;
    // 无症状感染新增
    Integer noInfectIncrList;

    /** 治愈数列表 */
    Integer curedCountList;
}
