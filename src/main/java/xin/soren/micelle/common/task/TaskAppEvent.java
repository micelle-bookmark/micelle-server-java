package xin.soren.micelle.common.task;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: task发布事件
 * @author yangsonglin
 * @date 2017年8月23日 下午3:34:35
 * @version V2.0
 */
public class TaskAppEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

	@Setter
	@Getter
	private Object msg;

	public TaskAppEvent(Object source, Object msg) {
		super(source);
		this.setMsg(msg);
	}
}
