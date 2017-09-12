package xin.soren.micelle.domain.model.bookmark;

import lombok.Data;

/**
 * 
 * @ClassName: BookmarkEntity
 * @Description: TODO
 * @author Comsys-soren
 * @date 2017年9月12日 上午11:30:26
 * 
 *       不需要查询树结构, 所以直接使用邻接表实现. 更多方式: 邻接表, 递归查询(需要数据库支持 with 语句), 枚举路径, 嵌套集,
 *       闭包表. 资料: <SQL 反模式> 第三章-单纯的树
 */
@Data
public class BookmarkEntity {
	public Long id;
}
