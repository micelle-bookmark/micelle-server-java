package xin.soren.micelle.domain.mapper.id;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xin.soren.micelle.domain.model.id.BizIdEntity;

/**
 * 
 * @Description: ID记录实体操作类
 * @author soren
 * @date 2017年12月17日 上午10:19:52
 */
@Mapper
public interface BizIdMapper {

	@Select("select id, biz_tag, max_id, step, desc, create_time, modify_time from biz_id " + "where biz_tag=#{tag}")
	@Results(id = "default", value = { @Result(property = "bizTag", column = "biz_tag"),
			@Result(property = "maxId", column = "max_id"), @Result(property = "createTime", column = "create_time"),
			@Result(property = "modifyTime", column = "modify_time") })
	public BizIdEntity getByBizTag(@Param("tag") String tag);

	@Update("update biz_id set max_id = max_id + step where biz_tag = #{tag} and max_id = #{maxId} ")
	public Long nextId(@Param("tag") String bizTag, @Param("maxId") Long maxId);

	@Update("update biz_id set max_id = max_id + #{step} where biz_tag = #{tag} and max_id = #{maxId} ")
	public Long nextIdWithStep(@Param("tag") String bizTag, @Param("maxId") Long maxId, @Param("step") Long step);
}
