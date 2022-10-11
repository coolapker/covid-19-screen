package mojospy.covid19screen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 *
 *
 * @author libm
 * @date 2022/09/29
 */
@Mapper
public interface UtilMapper {

    /**
     * 判断表是否存在
     *
     * @param tableName 表名
     * @return 0 不存在  1  存在
     */
    @Select(" SELECT COUNT(*) as count FROM information_schema.TABLES WHERE table_name = #{tableName}")
    Integer existsTable(@Param("tableName") String tableName);
}
