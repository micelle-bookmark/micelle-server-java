package xin.soren.micelle.domain.model.bookmark;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @Description: 书签记录实体
 * @author Comsys-soren
 * @date 2017年9月12日 上午11:30:26
 * 
 *       不需要查询树结构, 所以直接使用邻接表实现. 更多方式: 邻接表, 递归查询(需要数据库支持 with 语句), 枚举路径, 嵌套集,
 *       闭包表. 资料: <SQL 反模式> 第三章-单纯的树
 */
@Data
public class BookmarkEntity {
	/**
	 * 书签记录 ID, primary key
	 */
	public Long id;

	/**
	 * 书签所属用户 ID
	 */
	public Long userId;

	/**
	 * 书签名称
	 */
	public String name;

	/**
	 * 书签所指 url
	 */
	public String url;

	/**
	 * 父书签目录 ID
	 */
	public Long parentId;

	/**
	 * 深度, 从0开始
	 */
	public Long depth;

	/**
	 * 是否被删除, 0=未删除, 1=删除
	 */
	public Long isDelete;

	/**
	 * 书签分类，dir=书签目录, bookmark=书签
	 */
	public String category;

	/**
	 * 创建时间
	 */
	public Date createTime;

	/**
	 * 上次修改时间
	 */
	public Date modifyTime;
}
