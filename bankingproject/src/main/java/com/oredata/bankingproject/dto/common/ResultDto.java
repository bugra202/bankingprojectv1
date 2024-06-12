package com.oredata.bankingproject.dto.common;

import lombok.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto<T> implements Serializable {
    private Long count;
    private List<T> resultList;
}