package mojospy.covid19screen.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_city
 */
@TableName(value ="t_city")
@Data
public class City implements Serializable {
    /**
     * 城市id
     */
    @TableId
    private String cid;

    /**
     * 城市名称
     */
    private String city;

    /**
     * 现有确诊
     */
    private Integer existing;

    /**
     * 累计确诊
     */
    private Integer confirmed;

    /**
     * 较昨日新增
     */
    private Integer confirmedIncr;

    /**
     * 死亡
     */
    private Integer dead;

    /**
     * 治愈
     */
    private Integer cured;

    /**
     * 城市表外键
     */
    private String pid;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}