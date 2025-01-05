package com.prapp.examplesecurityjwt.business;


import com.prapp.examplesecurityjwt.expose.dto.CompanyDto;
import com.prapp.examplesecurityjwt.expose.dto.PagedResult;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    List<CompanyDto.Response> list();
    PagedResult<CompanyDto.Response> listPage(int page, int size);
    CompanyDto.Response findById(UUID id);
    CompanyDto.Response save(CompanyDto.Request request);
    CompanyDto.Response update(UUID id, CompanyDto.Request request);
    void delete(UUID id);
}
