package mojospy.covid19screen.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_overall
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_overall")
public class Overall implements Serializable {
    /**
     * 累计确诊
     */
    private Integer confirmedCount;

    /**
     * 累计确诊增长
     */
    private Integer confirmedIncr;

    /**
     * 累计治愈
     */
    private Integer curedCount;

    /**
     * 累计治愈增长
     */
    private Integer curedIncr;

    /**
     * 治愈率
     */
    private String curedRate;

    /**
     * 现有确诊
     */
    private Integer currentConfirmedCount;

    /**
     * 现有确诊增长
     */
    private Integer currentConfirmedIncr;

    /**
     * 累计死亡
     */
    private Integer deadCount;

    /**
     * 累计死亡增长
     */
    private Integer deadIncr;

    /**
     * 死亡率
     */
    private String deadRate;

    /**
     * 境外输入
     */
    private Integer importedCount;

    /**
     * 境外输入增长
     */
    private Integer importedIncr;

    /**
     * 无症状感染者
     */
    private Integer noInfectCount;

    /**
     * 无症状感染者新增
     */
    private Integer noInfectIncr;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}