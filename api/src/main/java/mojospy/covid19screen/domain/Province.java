package mojospy.covid19screen.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.NoArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_province")
public class Province implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 省份id
     */
    private String pid;
    /**
     * 省份名称
     */
    private String provinceLabel;
    /**
     * 现存确诊
     */
    private Integer currentConfirmedCount;
    /**
     * 累计确诊
     */
    private Integer confirmedCount;
    /**
     * 较昨日新增
     */
    private Integer todayConfirmedCount;
    /**
     * 累计死亡
     */
    private Integer deadCount;
    /**
     * 死亡率
     */
    private String deadRate;
    /**
     * 累计治愈
     */
    private Integer curedCount;
    /**
     * 治愈率
     */
    private String curedRate;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}

