package com.tuya.heipa.domain.model.opus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpusEntity {
	private Long id;
	private String opusName;
	private Long creativeType;
}
