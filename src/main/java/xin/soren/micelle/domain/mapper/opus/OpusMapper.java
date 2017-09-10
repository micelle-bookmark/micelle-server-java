package xin.soren.micelle.domain.mapper.opus;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xin.soren.micelle.domain.model.opus.OpusEntity;

@Mapper
public interface OpusMapper {
	@Select("select id, opus_name, creative_type from opus where id=#{arg0}")
	@Results(id = "default", value = { @Result(property = "opusName", column = "opus_name"),
			@Result(property = "creativeType", column = "creative_type") })
	public OpusEntity selectById(Long opusId);

	@Insert("insert into opus(id, opus_name, creative_type) values(#{opus.id}, #{opus.opusName}, #{opus.creativeType})")
	public Long insert(@Param("opus") OpusEntity opus);

	@Update("update opus set opus_name=#{opus.opusName} where id=#{opus.id}")
	public Long update(@Param("opus") OpusEntity opus);
}
