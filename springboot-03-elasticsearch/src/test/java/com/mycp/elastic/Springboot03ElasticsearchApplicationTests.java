package com.mycp.elastic;

import com.mycp.elastic.bean.Article;
import com.mycp.elastic.bean.Book;
import com.mycp.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * 测试Jest 操作ES
 *
 */
@SpringBootTest
class Springboot03ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02() {
        Book book = new Book();
        book.setId(11);
        book.setBookName("三国2");
        book.setAuthor("罗贯中2");

        bookRepository.index(book);
    }

    @Test
    public void testFind() {
        List<Book> books = bookRepository.findByBookNameLike("三");

        for (Book book : books) {
            System.out.println(book);
        }
    }


    @Test
    void contextLoads() {
        // 1. 给ES中索引，即保存一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("张三");
        article.setContent("hello");

        // 构建一个索引功能
        Index index = new Index.Builder(article)
                .index("mycp")
                .type("news")
                .build();

        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 访问 http://39.105.96.93:9200/mycp/news/_search

    }

    /**
     * 测试搜索
     */
    @Test
    public void search() {
        // 查询表达式
        String json = "{\"query\": {\"match\": {\"content\": \"hello\"}}}";

        // 构建搜索功能
        Search search = new Search.Builder(json)
                .addIndex("mycp")
                .addType("news")
                .build();

        // 执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
