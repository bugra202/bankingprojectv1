package com.oredata.bankingproject.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class
PageInfo {
    private int pageSize;
    private int pageNumber;
    private int totalCount;
    //private List<OrderBy> orderByColumnNames;
}
