package .domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_overall
 */
@Data
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
    private Integer curedRate;

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
    private Integer deadRate;

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
    private Integer noinfectCount;

    /**
     * 无症状感染者新增
     */
    private Integer noinfectIncr;

    /**
     * 
     */
    private Integer suspectIncr;

    /**
     * 
     */
    private Integer suspectCount;

    /**
     * 更新时间
     */
    private Integer updateTime;

    private static final long serialVersionUID = 1L;
}