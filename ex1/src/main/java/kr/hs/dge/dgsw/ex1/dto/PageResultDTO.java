package kr.hs.dge.dgsw.ex1.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
public class PageResultDTO<DTO, EN> {
    private List<DTO> dtoList;
    private int totalPage;
    private int page;
    private int size;

    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) {
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        Pageable pageable = result.getPageable();
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();
    }
}
