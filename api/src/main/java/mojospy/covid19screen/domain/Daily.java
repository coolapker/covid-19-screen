package mojospy.covid19screen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 疫情记录(Daily)表实体类
 *
 * @author libm
 * @since 2022-11-15 14:10:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_daily")
public class Daily {


    /**
     * 记录日期
     */
    @TableId(type = IdType.AUTO)
    @JsonFormat(timezone = "Asia/Shanghai", pattern = "yyyy-MM-dd")
    private LocalDate dateOf;
    /**
     * 累计确诊
     */
    private Integer confirmedCount;
    /**
     * 累计治愈
     */
    private Integer curedCount;
    /**
     * 较昨日新增确诊
     */
    private Integer confirmedIncr;
    /**
     * 境外输入新增
     */
    private Integer inputIncr;
    /**
     * 较昨日治愈新增
     */
    private Integer curedIncr;


}

