package com.poly.bangiaybe.dto.Resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RespAttributeDto {
    private Long attributeId;
    private Integer stock;
    private Integer cache;
}
