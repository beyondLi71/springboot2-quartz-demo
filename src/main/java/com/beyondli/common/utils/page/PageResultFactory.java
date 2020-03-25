package com.beyondli.common.utils.page;



import com.beyondli.common.utils.mapper.MapperUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author beyondLi
 * @desc  PageResul工厂.
 */
@Component
public class PageResultFactory {

    public  <T> PageResult createPageResult(int page, int count, List<T> data) {
        return new PageResult<T>(page, count, data);
    }

    public  <E> PageResult<E> convert(PageResult pageResult, Class<E> dtoClass) {
        List<E> dtoList = MapperUtils.mapperList(pageResult.getList(), dtoClass);
        //+1是因为hibernate分页从0开始
        return new PageResult<E>(pageResult.getPage() + 1, pageResult.getCount(), dtoList);
    }

    public <T, E> PageResult<E> convert(PageResult<T> pageResult, Function<T, E> function) {
        return new PageResult<E>(pageResult.getPage(), pageResult.getCount(),
                pageResult.getList().stream().map(function).collect(Collectors.toList()));
    }

}
