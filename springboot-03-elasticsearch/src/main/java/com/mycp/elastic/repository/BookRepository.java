package com.mycp.elastic.repository;

import com.mycp.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * <数据类型，bean主键类型> 和JPA类似操作
 *
 * @author lq
 * create 2020-01-02 20:03
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

}
