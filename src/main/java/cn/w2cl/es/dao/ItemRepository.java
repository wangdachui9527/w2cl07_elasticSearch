package cn.w2cl.es.dao;

import cn.w2cl.es.pojo.Item;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Authror 卫骏
 * @Date 2020/1/31 14:39
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Integer> {
    List<Item> findByTitleAndContent(String title, String content);

    List<Item> findByTitleOrContent(String title, String content, Pageable pageable);

    List<Item> findByTitleAndContentAndIdBetween(String title, String content, int min, int max, Pageable pageable);
}
