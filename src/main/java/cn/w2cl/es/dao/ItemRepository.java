package cn.w2cl.es.dao;

import cn.w2cl.es.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Authror 卫骏
 * @Date 2020/1/31 14:39
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Integer> {
}
